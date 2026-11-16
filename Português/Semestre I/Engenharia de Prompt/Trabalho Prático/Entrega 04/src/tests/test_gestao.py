"""Regras de baixa e agregação; contratos de P05/P06 com saídas controladas."""

import json
import pytest
import app as backend
from gestao import GestaoError, aggregate, period, writeoff


@pytest.fixture
def client(tmp_path):
    backend.app.config.update(TESTING=True, DB=str(tmp_path / "gestao.sqlite3"))
    return backend.app.test_client()


def seed(approved=True):
    data = {
        "data_referencia": "2026-11-15",
        "lote": {
            "produto": "Leite",
            "lote": "L1",
            "setor": "Corredor 3",
            "quantidade": 12,
        },
        "risco": {"classificacao": "VENCIDO"},
        "acao": {"acao": "Retirar"},
        "aprovado": approved,
    }
    with backend.database() as db:
        db.execute(
            "INSERT INTO registros VALUES(?,?,?,?)",
            ("r1", "2026-11-15", json.dumps(data), int(approved)),
        )
    return data


def event(**changes):
    return dict(
        realizada=True,
        quantidade=3,
        motivo="vencimento",
        data="2026-11-15",
        valor="12,90",
        **changes
    )


@pytest.mark.parametrize("date", ["2026-02-30", "15/11/2026", "0001-01-01", None, 12])
def test_period_rejects_invalid_dates(date):
    with pytest.raises(GestaoError):
        period(date)


@pytest.mark.parametrize(
    "field,value",
    [
        ("realizada", False),
        ("quantidade", True),
        ("quantidade", 13),
        ("quantidade", 0),
        ("quantidade", 1.5),
        ("motivo", "desconto"),
        ("valor", "-1"),
        ("valor", "1.234"),
        ("valor", True),
    ],
)
def test_invalid_writeoff(field, value):
    data = event()
    data[field] = value
    with pytest.raises(GestaoError):
        writeoff(data, 12)


def test_amounts_are_exact_or_unknown():
    data = event()
    assert writeoff(data, 12)["valor_centavos"] == 1290
    data["valor"] = "0,00"
    assert writeoff(data, 12)["valor_centavos"] == 0
    data["valor"] = ""
    assert writeoff(data, 12)["valor_centavos"] is None


def test_writeoff_requires_approval_and_confirmation(client):
    seed(False)
    assert client.post("/api/baixas/r1", json=event()).status_code == 422
    assert client.get("/api/gestao").json["baixas"] == []
    with backend.database() as db:
        db.execute("UPDATE registros SET aprovado=1")
    data = event()
    data["realizada"] = False
    assert client.post("/api/baixas/r1", json=data).status_code == 422
    assert client.get("/api/gestao").json["baixas"] == []


def test_partial_writeoffs_cannot_exceed_record_balance(client):
    seed()
    assert client.post("/api/baixas/r1", json=event()).status_code == 201
    data = event()
    data["quantidade"] = 10
    assert client.post("/api/baixas/r1", json=data).status_code == 422
    data["quantidade"] = 9
    assert client.post("/api/baixas/r1", json=data).status_code == 201
    assert client.post("/api/baixas/r1", json=event()).status_code == 422
    history = client.get("/api/historico").json[0]
    assert (history["saldo_registro"], history["quantidade_baixada"]) == (0, 12)
    assert len(client.get("/api/gestao").json["baixas"]) == 2


def test_week_groups_only_actual_losses_in_inclusive_period():
    lot = {"produto": "Leite", "setor": "Corredor 3"}
    record = {
        "id": "r1",
        "aprovado": 1,
        "dados": {
            "data_referencia": "2026-11-15",
            "lote": lot,
            "risco": {"classificacao": "VENCIDO"},
        },
    }
    losses = [
        dict(
            registro_id="r1",
            data=d,
            quantidade=q,
            valor_centavos=v,
            motivo="vencimento",
        )
        for d, q, v in [
            ("2026-11-09", 2, 1290),
            ("2026-11-15", 3, None),
            ("2026-11-08", 50, 99999),
            ("2026-11-16", 60, 99999),
        ]
    ]
    output = aggregate([record], losses, [], "2026-11-15")
    assert output["periodo"] == {"inicio": "2026-11-09", "fim": "2026-11-15"}
    assert output["totais"]["unidades_baixadas"] == 5
    assert output["totais"]["valor_centavos_informado"] == 1290
    assert output["totais"]["baixas_sem_valor"] == 1
    assert output["por_produto_setor"][0]["unidades"] == 5
    assert (
        aggregate([record], [], [], "2026-11-15")["totais"]["valor_centavos_informado"]
        is None
    )
    assert aggregate([record], [], [], "2026-11-15")["totais"]["unidades_baixadas"] == 0

    unknown = aggregate(
        [record],
        [
            dict(
                registro_id="r1",
                data="2026-11-15",
                quantidade=1,
                valor_centavos=None,
                motivo="avaria",
            )
        ],
        [],
        "2026-11-15",
    )
    assert unknown["por_produto_setor"][0]["valor_centavos_informado"] is None


def test_empty_report_does_not_call_model(client, monkeypatch):
    monkeypatch.setattr(
        backend, "llm", lambda *args: pytest.fail("Sem dados não deve chamar IA")
    )
    assert (
        client.post(
            "/api/relatorios", json={"data_referencia": "2026-11-15"}
        ).status_code
        == 422
    )


def test_report_passes_calculated_data_and_persists(client, monkeypatch):
    seed()
    client.post("/api/baixas/r1", json=event())

    def model(pid, data, trace):
        assert pid == "P05"
        assert data["totais"]["unidades_baixadas"] == 3
        assert data["totais"]["valor_centavos_informado"] == 1290
        return {
            "resumo": "Resumo de teste controlado",
            "causas_possiveis": ["Hipótese"],
            "medidas_preventivas": ["Conferência"],
        }

    monkeypatch.setattr(backend, "llm", model)
    response = client.post("/api/relatorios", json={"data_referencia": "2026-11-15"})
    assert response.status_code == 200
    assert client.get("/api/gestao").json["relatorios"][0]["id"] == response.json["id"]


def test_invalid_report_model_output_is_not_saved(client, monkeypatch):
    seed()
    monkeypatch.setattr(backend, "llm", lambda *args: {"resumo": "incompleto"})
    assert (
        client.post(
            "/api/relatorios", json={"data_referencia": "2026-11-15"}
        ).status_code
        == 502
    )
    assert client.get("/api/gestao").json["relatorios"] == []


@pytest.mark.parametrize("shelf", [True, False])
def test_service_alert_only_for_shelf_report(client, monkeypatch, shelf):
    calls = []

    def model(pid, data, trace):
        calls.append(pid)
        if pid == "P06":
            return {
                "mensagem": "Resposta de teste controlado",
                "produto": None,
                "lote": None,
                "setor": None,
                "produto_vencido_na_gondola": shelf,
            }
        assert data["origem"] == "atendimento"
        assert data["risco"]["confirmado"] is False
        assert data["lote"]["lote"] == "Não informado"
        return {"mensagem": "Conferir relato na gôndola."}

    monkeypatch.setattr(backend, "llm", model)
    response = client.post(
        "/api/atendimento",
        json={"texto": "Pergunta de teste", "data_referencia": "2026-11-15"},
    )
    assert response.status_code == 200
    assert calls == (["P06", "P04"] if shelf else ["P06"])
    assert bool(response.json["alerta"]) == shelf
    assert client.get("/api/gestao").json["baixas"] == []
    assert len(client.get("/api/gestao").json["atendimentos"]) == 1


def test_invalid_service_model_output_is_not_saved(client, monkeypatch):
    monkeypatch.setattr(backend, "llm", lambda *args: {"mensagem": "incompleto"})
    assert (
        client.post(
            "/api/atendimento",
            json={"texto": "Pergunta", "data_referencia": "2026-11-15"},
        ).status_code
        == 502
    )
    assert client.get("/api/gestao").json["atendimentos"] == []


@pytest.mark.parametrize(
    "path", ["/api/baixas/r1", "/api/relatorios", "/api/atendimento"]
)
def test_management_rejects_non_object_json(client, path):
    assert client.post(path, json=[]).status_code == 400
