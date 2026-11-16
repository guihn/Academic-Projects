"""Testes determinísticos; não constituem evidência de execução de LLM."""

import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import pytest
from app import app, reference, validate_lot, InputError


def lot(valid="2026-11-18", storage="refrigerado"):
    return dict(
        produto="Iogurte",
        categoria="laticínios",
        lote="IG1",
        data_validade=valid,
        quantidade=36,
        setor="refrigerados",
        armazenamento=storage,
    )


@pytest.mark.parametrize(
    "valid,storage,status,days",
    [
        ("2026-11-14", "refrigerado", "VENCIDO", -1),
        ("2026-11-15", "refrigerado", "CRÍTICO", 0),
        ("2026-11-18", "refrigerado", "CRÍTICO", 3),
        ("2026-11-19", "refrigerado", "ATENÇÃO", 4),
        ("2026-11-22", "refrigerado", "ATENÇÃO", 7),
        ("2026-11-23", "refrigerado", "OK", 8),
        ("2026-11-30", "ambiente", "CRÍTICO", 15),
        ("2026-12-01", "ambiente", "ATENÇÃO", 16),
        ("2026-12-30", "ambiente", "ATENÇÃO", 45),
        ("2026-12-31", "ambiente", "OK", 46),
        ("2028-03-01", "congelado", "OK", 472),
    ],
)
def test_boundaries(valid, storage, status, days):
    assert reference(lot(valid, storage), "2026-11-15") == dict(
        classificacao=status, dias_restantes=days
    )


@pytest.mark.parametrize(
    "field,value",
    [
        ("data_validade", "2026-02-30"),
        ("data_validade", None),
        ("data_validade", "03/2027"),
        ("quantidade", True),
        ("quantidade", 0),
        ("quantidade", -2),
        ("quantidade", 1.5),
        ("setor", None),
        ("armazenamento", "ignorado"),
    ],
)
def test_invalid_lots(field, value):
    data = lot()
    data[field] = value
    with pytest.raises(InputError):
        validate_lot(data)


@pytest.fixture
def client(tmp_path):
    app.config.update(TESTING=True, DB=str(tmp_path / "test.sqlite3"))
    return app.test_client()


def test_missing_client_blocks_analysis(client, monkeypatch):
    monkeypatch.setattr("google_login.executable", lambda: None)
    r = client.post(
        "/api/analisar",
        json={"texto": "Iogurte lote 1", "data_referencia": "2026-11-15"},
    )
    assert r.status_code == 502
    assert "Cliente Google não encontrado" in r.json["erro"]
    assert r.json["trace"][0]["status"] == "erro"
    assert client.get("/api/historico").json == []


def test_confirmation_requires_extraction(client):
    r = client.post(
        "/api/analisar",
        json={
            "texto": "Iogurte lote 1",
            "data_referencia": "2026-11-15",
            "lote_confirmado": lot(),
        },
    )
    assert r.status_code == 422
    assert "extração válida" in r.json["erro"]


@pytest.mark.parametrize(
    "payload",
    [
        None,
        [],
        {},
        {"texto": "abc", "data_referencia": "2026-02-30"},
        {"texto": "x", "data_referencia": "2026-11-15"},
    ],
)
def test_bad_requests(client, payload):
    assert client.post("/api/analisar", json=payload).status_code in (400, 422)


def test_unknown_approval(client):
    assert client.post("/api/aprovar/nao-existe").status_code == 404


def test_home(client):
    assert client.get("/").status_code == 200
    assert b"ValidaMarket" in client.get("/").data
