"Writeoff validation, weekly date range and report aggregates."

from collections import Counter
from datetime import date, timedelta
from decimal import Decimal
import re


class GestaoError(ValueError):
    pass


def period(reference):
    if not isinstance(reference, str) or not re.fullmatch(
        r"\d{4}-\d{2}-\d{2}", reference
    ):
        raise GestaoError("Invalid reference date.")
    try:
        end = date.fromisoformat(reference)
        start = end - timedelta(days=6)
    except (ValueError, OverflowError):
        raise GestaoError("Invalid reference date.") from None
    return {"inicio": start.isoformat(), "fim": end.isoformat()}


def writeoff(data, available):
    "A writeoff requires operator confirmation; AI approval does not record a loss."
    if data.get("realizada") is not True:
        raise GestaoError(
            "The writeoff requires confirmation of the completed physical movement."
        )
    quantity = data.get("quantidade")
    if type(quantity) is not int or not 1 <= quantity <= min(available, 2147483647):
        raise GestaoError(
            "Invalid writeoff quantity or quantity above the record balance."
        )
    reason = data.get("motivo")
    if reason not in ("vencimento", "avaria", "outro"):
        raise GestaoError("Invalid writeoff reason.")
    reference = data.get("data")
    period(reference)
    value = data.get("valor")
    cents = None
    if value not in (None, ""):
        if not isinstance(value, str) or not re.fullmatch(
            r"\d{1,10}(?:[.,]\d{1,2})?", value
        ):
            raise GestaoError("Invalid amount. Expected format: 12,90 or 12.90.")
        cents = int(Decimal(value.replace(",", ".")) * 100)
    return {
        "quantidade": quantity,
        "motivo": reason,
        "data": reference,
        "valor_centavos": cents,
    }


def aggregate(records, writeoffs, services, reference):
    "Code calculates totals; the model receives data without inventing losses."
    window = period(reference)
    within = (
        lambda value: isinstance(value, str)
        and window["inicio"] <= value <= window["fim"]
    )
    analyses = [r for r in records if within(r["dados"].get("data_referencia"))]
    events = [e for e in writeoffs if within(e["data"])]
    cases = [c for c in services if within(c["data_referencia"])]
    if not analyses and not events and not cases:
        raise GestaoError("No records in the selected report period.")
    lookup = {r["id"]: r["dados"]["lote"] for r in records}
    groups = {}
    for event in events:
        lot = lookup[event["registro_id"]]
        key = (lot["produto"], lot["setor"])
        item = groups.setdefault(
            key,
            {
                "produto": key[0],
                "setor": key[1],
                "baixas": 0,
                "unidades": 0,
                "valor_centavos_informado": 0,
                "baixas_sem_valor": 0,
            },
        )
        item["baixas"] += 1
        item["unidades"] += event["quantidade"]
        if event["valor_centavos"] is None:
            item["baixas_sem_valor"] += 1
        else:
            item["valor_centavos_informado"] += event["valor_centavos"]
    for group in groups.values():
        if group["baixas"] == group["baixas_sem_valor"]:
            group["valor_centavos_informado"] = None
    known_values = [
        e["valor_centavos"] for e in events if e["valor_centavos"] is not None
    ]
    return {
        "periodo": window,
        "totais": {
            "analises": len(analyses),
            "classificacoes": dict(
                Counter(r["dados"]["risco"]["classificacao"] for r in analyses)
            ),
            "acoes_aprovadas": sum(bool(r["aprovado"]) for r in analyses),
            "baixas_registradas": len(events),
            "unidades_baixadas": sum(e["quantidade"] for e in events),
            "valor_centavos_informado": sum(known_values) if known_values else None,
            "baixas_sem_valor": sum(e["valor_centavos"] is None for e in events),
            "atendimentos": len(cases),
            "relatos_na_gondola": sum(
                c["dados"]["resposta"]["produto_vencido_na_gondola"] for c in cases
            ),
        },
        "por_produto_setor": sorted(
            groups.values(), key=lambda g: (-g["unidades"], g["produto"], g["setor"])
        ),
        "motivos_de_baixa": dict(Counter(e["motivo"] for e in events)),
        "observacao": "Analyses and approvals are not physical writeoffs. Amounts include only values supplied by the operator. Repeated analyses do not represent additional stock.",
    }


def validate_report(value):
    fields = {"resumo", "causas_possiveis", "medidas_preventivas"}
    if not isinstance(value, dict) or set(value) != fields:
        raise GestaoError("P05 returned an invalid report structure.")
    if (
        not isinstance(value["resumo"], str)
        or not 1 <= len(value["resumo"].strip()) <= 1800
    ):
        raise GestaoError("P05 returned an invalid summary.")
    for field in ["causas_possiveis", "medidas_preventivas"]:
        items = value[field]
        if (
            not isinstance(items, list)
            or not 1 <= len(items) <= 5
            or any(
                not isinstance(v, str) or not 1 <= len(v.strip()) <= 400 for v in items
            )
        ):
            raise GestaoError("P05 returned an invalid observation list.")
    return value


def validate_service(value):
    fields = {"mensagem", "produto", "lote", "setor", "produto_vencido_na_gondola"}
    if not isinstance(value, dict) or set(value) != fields:
        raise GestaoError("P06 returned an invalid customer-service structure.")
    if (
        not isinstance(value["mensagem"], str)
        or not 1 <= len(value["mensagem"].strip()) <= 1800
    ):
        raise GestaoError("P06 returned an invalid response.")
    if type(value["produto_vencido_na_gondola"]) is not bool:
        raise GestaoError("P06 returned an invalid shelf-report flag.")
    for field in ["produto", "lote", "setor"]:
        if value[field] is not None and (
            not isinstance(value[field], str)
            or not 1 <= len(value[field].strip()) <= 200
        ):
            raise GestaoError("P06 returned invalid product data.")
    return value
