"""Regressões da revisão: configuração, contratos e limites de datas/estoque."""

import json
import sqlite3
from concurrent.futures import ThreadPoolExecutor
from contextlib import contextmanager
import pytest
import app as backend
import google_login
import iniciar


@pytest.fixture
def client(tmp_path):
    backend.app.config.update(TESTING=True, DB=str(tmp_path / "review.sqlite3"))
    return backend.app.test_client()


def lot():
    return dict(
        produto="Leite",
        categoria=None,
        lote="L1",
        data_validade="2026-11-18",
        quantidade=12,
        setor="C3",
        armazenamento="refrigerado",
    )


def confirmation(client, data=None, reference="2026-11-15"):
    draft = "a" * 32
    with backend.database() as db:
        db.execute(
            "INSERT INTO extracoes VALUES(?,?)",
            (
                draft,
                json.dumps(
                    dict(texto="Lote de teste", data_referencia=reference, trace=[])
                ),
            ),
        )
    return dict(
        texto="Lote de teste",
        data_referencia=reference,
        extracao_id=draft,
        lote_confirmado=data or lot(),
    )


def test_settings_only_accept_runtime_options(tmp_path, monkeypatch):
    monkeypatch.setattr(google_login, "__file__", str(tmp_path / "google_login.py"))
    (tmp_path / ".env").write_text(
        'VALIDAMARKET_PORT=5009\nGOOGLE_API_KEY=must-not-load\nGEMINI_MODEL="test-model"\n',
        encoding="utf-8",
    )
    for key in ["VALIDAMARKET_PORT", "GOOGLE_API_KEY", "GEMINI_MODEL"]:
        monkeypatch.delenv(key, raising=False)
    google_login.load_settings()
    assert google_login.os.getenv("VALIDAMARKET_PORT") == "5009"
    assert google_login.os.getenv("GEMINI_MODEL") == "test-model"
    assert google_login.os.getenv("GOOGLE_API_KEY") is None


def test_startup_respects_dotenv_port_and_environment_priority(tmp_path, monkeypatch):
    monkeypatch.setattr(google_login, "__file__", str(tmp_path / "google_login.py"))
    (tmp_path / ".env").write_text("VALIDAMARKET_PORT=5009", encoding="utf-8")
    monkeypatch.delenv("VALIDAMARKET_PORT", raising=False)
    monkeypatch.setenv("VALIDAMARKET_NO_BROWSER", "1")
    urls = []

    @contextmanager
    def existing_server(url, **kwargs):
        from io import StringIO

        urls.append(url)
        yield StringIO('{"aplicativo":"validamarket"}')

    monkeypatch.setattr(iniciar.urllib.request, "urlopen", existing_server)
    assert iniciar.main() == 0
    assert urls[-1] == "http://127.0.0.1:5009/api/status"
    monkeypatch.setenv("VALIDAMARKET_PORT", "5010")
    assert iniciar.main() == 0
    assert urls[-1] == "http://127.0.0.1:5010/api/status"


@pytest.mark.parametrize(
    "identifier", [["draft"], {"id": "draft"}, 123, "not-a-valid-id"]
)
def test_malformed_extraction_is_422_not_internal_error(client, identifier):
    data = dict(
        texto="Lote de teste",
        data_referencia="2026-11-15",
        lote_confirmado=lot(),
        extracao_id=identifier,
    )
    assert client.post("/api/analisar", json=data).status_code == 422


def test_sqlite_connection_closes_after_transaction(client):
    with backend.database() as db:
        db.execute("SELECT 1")
    with pytest.raises(sqlite3.ProgrammingError):
        db.execute("SELECT 1")


@pytest.mark.parametrize(
    "risk",
    [
        {},
        [],
        {"classificacao": "CRÍTICO", "dias_restantes": 3, "justificativa": " "},
        {"classificacao": "CRÍTICO", "dias_restantes": True, "justificativa": "x"},
    ],
)
def test_malformed_risk_is_blocked_before_storage(client, monkeypatch, risk):
    data = confirmation(client)
    monkeypatch.setattr(backend, "llm", lambda *args: risk)
    assert client.post("/api/analisar", json=data).status_code == 502
    assert client.get("/api/historico").json == []


@pytest.mark.parametrize(
    "deadline", ["2026-11-14", "2026-11-18", "17/11/2026", "invalid"]
)
def test_deadline_outside_policy_is_blocked(client, monkeypatch, deadline):
    data = confirmation(client)

    def model(pid, payload, trace):
        if pid == "P02":
            assert payload["calculo_conferido"] == {
                "classificacao": "CRÍTICO",
                "dias_restantes": 3,
            }
            return {
                "classificacao": "CRÍTICO",
                "dias_restantes": 3,
                "justificativa": "3 dias",
            }
        return dict(acao="Revisar", prazo=deadline, responsavel="Líder")

    monkeypatch.setattr(backend, "llm", model)
    assert client.post("/api/analisar", json=data).status_code == 502
    assert client.get("/api/historico").json == []


def test_minimum_date_does_not_underflow(client, monkeypatch):
    data = lot()
    data["data_validade"] = "0001-01-01"
    payload = confirmation(client, data, "0001-01-01")

    def model(pid, data, trace):
        if pid == "P02":
            return dict(
                classificacao="CRÍTICO",
                dias_restantes=0,
                justificativa="Dia de referência",
            )
        assert data["limite_reavaliacao"] == "0001-01-01"
        return dict(
            acao="Retirar preventivamente", prazo="0001-01-01", responsavel="Líder"
        )

    monkeypatch.setattr(backend, "llm", model)
    assert client.post("/api/analisar", json=payload).status_code == 200


def test_excessive_quantity_is_blocked():
    data = lot()
    data["quantidade"] = 2147483648
    with pytest.raises(backend.InputError):
        backend.validate_lot(data)


def test_whitespace_alert_is_rejected():
    with pytest.raises(backend.ModelError):
        backend.normalize_alert({"mensagem": "  "})


def test_large_request_returns_json(client):
    response = client.post("/api/analisar", json={"texto": "x" * 17000})
    assert response.status_code == 413 and response.is_json


def test_simultaneous_writeoffs_do_not_exceed_balance(client):
    data = {
        "lote": lot(),
        "acao": {"acao": "Retirar"},
        "data_referencia": "2026-11-15",
        "risco": {"classificacao": "CRÍTICO"},
    }
    with backend.database() as db:
        db.execute(
            "INSERT INTO registros VALUES(?,?,?,1)",
            ("record", "2026-11-15", json.dumps(data)),
        )

    def submit(_):
        with backend.app.test_client() as other:
            return other.post(
                "/api/baixas/record",
                json=dict(
                    quantidade=8, motivo="avaria", realizada=True, data="2026-11-15"
                ),
            ).status_code

    with ThreadPoolExecutor(max_workers=2) as executor:
        statuses = list(executor.map(submit, range(2)))
    assert sorted(statuses) == [201, 422]
    assert client.get("/api/historico").json[0]["saldo_registro"] == 4
