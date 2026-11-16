"""Contrato do transporte CLI. Stubs aqui não são evidências de LLM real."""

import json, subprocess, sys
from pathlib import Path
from types import SimpleNamespace
import pytest

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import google_login as transport


def ready(monkeypatch):
    monkeypatch.setattr(transport, "executable", lambda: "/usr/bin/agy")


def test_missing_client(monkeypatch):
    monkeypatch.setattr(transport, "executable", lambda: None)
    with pytest.raises(
        transport.GoogleLoginError, match="Cliente Google não encontrado"
    ):
        transport.generate("P01", "texto")


def test_timeout(monkeypatch):
    ready(monkeypatch)

    def timeout(*a, **k):
        raise subprocess.TimeoutExpired("agy", 100)

    monkeypatch.setattr(transport.subprocess, "run", timeout)
    with pytest.raises(transport.GoogleLoginError, match="tempo de resposta"):
        transport.generate("P01", "texto")


@pytest.mark.parametrize(
    "code,payload",
    [
        (1, {"status": "ERROR"}),
        (0, {"status": "ERROR"}),
        (0, []),
        (0, {"status": "SUCCESS", "response": "texto inválido"}),
    ],
)
def test_invalid_output(monkeypatch, code, payload):
    ready(monkeypatch)
    monkeypatch.setattr(
        transport.subprocess,
        "run",
        lambda *a, **k: SimpleNamespace(returncode=code, stdout=json.dumps(payload)),
    )
    with pytest.raises(transport.GoogleLoginError):
        transport.generate("P01", "texto")


def test_google_account_only_and_deny_tools(monkeypatch):
    ready(monkeypatch)
    monkeypatch.setenv("GEMINI_API_KEY", "key-must-not-be-forwarded")
    monkeypatch.setenv("GOOGLE_API_KEY", "key-must-not-be-forwarded")
    monkeypatch.setenv("GOOGLE_GENAI_USE_VERTEXAI", "true")

    def run(args, **kwargs):
        assert kwargs["shell"] is False
        assert "GEMINI_API_KEY" not in kwargs["env"]
        assert "GOOGLE_API_KEY" not in kwargs["env"]
        assert "GOOGLE_GENAI_USE_VERTEXAI" not in kwargs["env"]
        settings = json.loads(args[args.index("--settings") + 1])
        assert settings["toolPermission"] == "strict"
        assert "command(*)" in settings["permissions"]["deny"]
        return SimpleNamespace(
            returncode=0,
            stdout=json.dumps(
                {
                    "status": "SUCCESS",
                    "structured_output": {"mensagem": "teste"},
                    "response": '{"mensagem":"teste"}',
                }
            ),
        )

    monkeypatch.setattr(transport.subprocess, "run", run)
    parsed, envelope, model = transport.generate("P04", "texto")
    assert parsed == {"mensagem": "teste"}
    assert envelope["status"] == "SUCCESS"


def test_only_response_fields_are_exported(monkeypatch):
    ready(monkeypatch)
    payload = {
        "status": "SUCCESS",
        "structured_output": {"mensagem": "ok"},
        "response": '{"mensagem":"ok"}',
        "internal_auth_profile": {"private": "must-stay-in-client"},
    }
    monkeypatch.setattr(
        transport.subprocess,
        "run",
        lambda *a, **k: SimpleNamespace(returncode=0, stdout=json.dumps(payload)),
    )
    parsed, envelope, _ = transport.generate("P04", "texto")
    assert parsed["mensagem"] == "ok"
    assert "internal_auth_profile" not in envelope
