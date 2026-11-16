"""Ten-lot integration batch with recorded model responses."""

import argparse, json, sys, tempfile
from pathlib import Path
from datetime import datetime, timezone

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
from app import app

ROOT = Path(__file__).resolve().parents[1]
CASES = [
    (
        "T01",
        "Iogurte natural 170g, lote IG-5521, validade 18/11/2026, 36 unidades, gôndola refrigerados, refrigerado",
        "CRÍTICO",
        3,
    ),
    (
        "T02",
        "Leite integral 1L, lote LT-10, validade 14/11/2026, 12 unidades, corredor 3, ambiente",
        "VENCIDO",
        -1,
    ),
    (
        "T03",
        "Arroz 5kg lote AR1, validade 31/12/2026, 20 pacotes, estoque seco, ambiente",
        "OK",
        46,
    ),
    (
        "T04",
        "Iogurte lote IG4, validade 19/11/2026, 8 unidades, refrigerados, refrigerado",
        "ATENÇÃO",
        4,
    ),
    (
        "T05",
        "Queijo lote Q5, validade 15/11/2026, 6 unidades, frios, refrigerado",
        "CRÍTICO",
        0,
    ),
    (
        "T06",
        "Ervilha em lata lote E6, validade 30/11/2026, 16 latas, corredor 4, ambiente",
        "CRÍTICO",
        15,
    ),
    (
        "T07",
        "Milho enlatado lote M7, validade 01/12/2026, 24 latas, corredor 4, ambiente",
        "ATENÇÃO",
        16,
    ),
    (
        "T08",
        "Feijão 1kg lote F8, validade 30/12/2026, 15 pacotes, estoque, ambiente",
        "ATENÇÃO",
        45,
    ),
    (
        "T09",
        "Iogurte lote IG9, validade 22/11/2026, 10 unidades, refrigerados, refrigerado",
        "ATENÇÃO",
        7,
    ),
    (
        "T10",
        "Manteiga lote MT10, validade 23/11/2026, 9 unidades, frios, refrigerado",
        "OK",
        8,
    ),
]


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument(
        "--casos",
        nargs="*",
        help="Specific case identifiers for reruns with other logs retained. The incomplete-date case is always included.",
    )
    selected = parser.parse_args().casos
    reports = []
    # An isolated database keeps integration tests separate from application history.
    with tempfile.TemporaryDirectory() as temp:
        app.config["DB"] = str(Path(temp) / "execucoes.sqlite3")
        client = app.test_client()
        for tid, text, status, days in CASES:
            if selected and tid not in selected:
                continue
            report = {
                "id": tid,
                "inicio_utc": datetime.now(timezone.utc).isoformat(),
                "entrada": text,
                "data_referencia": "2026-11-15",
                "esperado": {"classificacao": status, "dias_restantes": days},
                "etapas": [],
            }
            data = {"texto": text, "data_referencia": "2026-11-15"}
            r = client.post("/api/analisar", json=data)
            report["etapas"].append({"http_status": r.status_code, "resposta": r.json})
            if r.status_code == 200:
                lot = r.json["lote"]
                data.update(lote_confirmado=lot, extracao_id=r.json["extracao_id"])
                r = client.post("/api/analisar", json=data)
                report["etapas"].append(
                    {"http_status": r.status_code, "resposta": r.json}
                )
                if r.status_code == 200 and r.json.get("acao"):
                    r = client.post("/api/aprovar/" + r.json["id"], json={})
                    report["etapas"].append(
                        {"http_status": r.status_code, "resposta": r.json}
                    )
            report["passou"] = (
                r.status_code == 200
                and r.json.get("risco", {}).get("classificacao") == status
                and r.json.get("risco", {}).get("dias_restantes") == days
            )
            reports.append(report)
            (ROOT / "evidencias" / f"{tid}.json").write_text(
                json.dumps(report, ensure_ascii=False, indent=2), encoding="utf-8"
            )
            print(tid, "PASSED" if report["passou"] else "FAILED", flush=True)
            # Missing authorization interrupts the batch before repeated requests.
            if r.status_code == 502 and "Google client not found" in r.json.get(
                "erro", ""
            ):
                break
        # An incomplete date remains null and blocks further processing.
        data = {
            "texto": "Arroz 5kg lote AR11, validade 03/2027, 20 pacotes, estoque seco, ambiente",
            "data_referencia": "2026-11-15",
        }
        r = client.post("/api/analisar", json=data)
        incomplete = {
            "id": "T11",
            "entrada": data,
            "http_status": r.status_code,
            "resposta": r.json,
            "passou": r.status_code == 422
            and "data_validade" in r.json.get("erro", ""),
        }
        (ROOT / "evidencias" / "T11.json").write_text(
            json.dumps(incomplete, ensure_ascii=False, indent=2), encoding="utf-8"
        )
    if selected:
        reports = [
            json.loads(
                (ROOT / "evidencias" / f"{tid}.json").read_text(encoding="utf-8")
            )
            for tid, *_ in CASES
            if (ROOT / "evidencias" / f"{tid}.json").exists()
        ]
    traces = [
        e
        for r in reports
        for stage in r["etapas"]
        for e in stage["resposta"].get("trace", [])
    ]
    traces.extend(incomplete["resposta"].get("trace", []))
    unique = {e["inicio_utc"]: e for e in traces}
    summary = {
        "respostas_reais_recebidas": sum(
            e.get("status") == "ok" for e in unique.values()
        ),
        "observacao": "Observed results; inference failures remain recorded as failures.",
        "tipo": "Real Gemini with Google account through Antigravity CLI (without mocks)",
        "total_lotes_executados": len(reports),
        "passaram": sum(r["passou"] for r in reports),
        "falharam": sum(not r["passou"] for r in reports),
        "data_incompleta_passou": incomplete["passou"],
    }
    (ROOT / "evidencias" / "resumo_llm.json").write_text(
        json.dumps(summary, ensure_ascii=False, indent=2), encoding="utf-8"
    )
    print(json.dumps(summary, ensure_ascii=False, indent=2))
    return (
        0
        if len(reports) == 10
        and all(r["passou"] for r in reports)
        and incomplete["passou"]
        else 1
    )


if __name__ == "__main__":
    raise SystemExit(main())
