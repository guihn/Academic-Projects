"""Portabilidade e limites do fluxo de conexão; não fazem login em contas de teste."""

from pathlib import Path
import json
import sys
from types import SimpleNamespace

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import pytest
import google_login as google
from app import app


@pytest.fixture
def client(tmp_path):
    app.config.update(TESTING=True, DB=str(tmp_path / "local.sqlite3"))
    return app.test_client()


def test_windows_official_install_path(monkeypatch, tmp_path):
    file = tmp_path / "agy" / "bin" / "agy.exe"
    file.parent.mkdir(parents=True)
    file.write_bytes(b"")
    file.chmod(0o700)
    monkeypatch.delenv("ANTIGRAVITY_BIN", raising=False)
    monkeypatch.setenv("LOCALAPPDATA", str(tmp_path))
    monkeypatch.setattr(google.platform, "system", lambda: "Windows")
    monkeypatch.setattr(google.shutil, "which", lambda name: None)
    assert google.executable() == str(file)


def test_windows_rejects_command_scripts(monkeypatch, tmp_path):
    file = tmp_path / "agy.cmd"
    file.write_text("", encoding="utf-8")
    file.chmod(0o700)
    monkeypatch.setenv("ANTIGRAVITY_BIN", str(file))
    monkeypatch.setattr(google.platform, "system", lambda: "Windows")
    assert google.executable() is None


def test_windows_opens_own_console(monkeypatch, tmp_path):
    calls = []
    monkeypatch.setattr(google, "__file__", str(tmp_path / "google_login.py"))
    monkeypatch.setattr(
        google, "executable", lambda: "C:/Users/Aluno/AppData/Local/agy/bin/agy.exe"
    )
    monkeypatch.setattr(google.platform, "system", lambda: "Windows")
    monkeypatch.setattr(
        google.subprocess, "Popen", lambda *a, **k: calls.append((a, k))
    )
    assert "Cliente oficial aberto" in google.open_login()
    args, options = calls[0]
    assert args[0] == ["C:/Users/Aluno/AppData/Local/agy/bin/agy.exe"]
    assert options["creationflags"] == 0x00000010 and options["shell"] is False


def test_linux_uses_available_terminal(monkeypatch, tmp_path):
    calls = []
    monkeypatch.setattr(google, "__file__", str(tmp_path / "google_login.py"))
    monkeypatch.setattr(google, "executable", lambda: "/usr/local/bin/agy")
    monkeypatch.setattr(google.platform, "system", lambda: "Linux")
    monkeypatch.setattr(
        google.shutil, "which", lambda name: "/usr/bin/foot" if name == "foot" else None
    )
    monkeypatch.setattr(
        google.subprocess, "Popen", lambda *a, **k: calls.append((a, k))
    )
    google.open_login()
    assert calls[0][0][0] == ["/usr/bin/foot", "-e", "/usr/local/bin/agy"]
    assert calls[0][1]["shell"] is False


def test_no_terminal_gives_manual_instruction(monkeypatch, tmp_path):
    monkeypatch.setattr(google, "__file__", str(tmp_path / "google_login.py"))
    monkeypatch.setattr(google, "executable", lambda: "/usr/local/bin/agy")
    monkeypatch.setattr(google.platform, "system", lambda: "Linux")
    monkeypatch.setattr(google.shutil, "which", lambda name: None)
    with pytest.raises(google.GoogleLoginError, match="agy"):
        google.open_login()


def test_account_environment_strips_other_auth(monkeypatch):
    keys = [
        "AGY_ADC_AUTH",
        "GEMINI_API_KEY",
        "GOOGLE_APPLICATION_CREDENTIALS",
        "GOOGLE_GEMINI_BASE_URL",
    ]
    for key in keys:
        monkeypatch.setenv(key, "test-value")
    assert all(key not in google.account_environment() for key in keys)


def test_login_does_not_accept_remote_origin(client, monkeypatch):
    def forbidden():
        raise AssertionError("Não deve abrir terminal")

    monkeypatch.setattr("app.open_login", forbidden)
    r = client.post(
        "/api/conexao/entrar", json={}, headers={"Origin": "https://outro-site.example"}
    )
    assert r.status_code == 403


def test_login_requires_json(client):
    assert client.post("/api/conexao/entrar", data={}).status_code == 415


def test_login_starts_official_flow(client, monkeypatch):
    monkeypatch.setattr("app.open_login", lambda: "Cliente oficial aberto no terminal.")
    assert (
        client.post("/api/conexao/entrar", json={}).json["mensagem"]
        == "Cliente oficial aberto no terminal."
    )


def test_connection_success_does_not_return_tokens(client, monkeypatch):
    monkeypatch.setattr(
        "app.generate",
        lambda *a: ({"mensagem": "ok"}, {"status": "SUCCESS"}, "gemini-teste"),
    )
    r = client.post("/api/conexao/verificar", json={})
    assert r.status_code == 200 and r.json["conexao"]["estado"] == "conectada"
    assert set(r.json) == {"mensagem", "modelo", "conexao"}


def test_connection_failure_not_marked_connected(client, monkeypatch):
    def failed(*args):
        raise google.GoogleLoginError("Login necessário.")

    monkeypatch.setattr("app.generate", failed)
    r = client.post("/api/conexao/verificar", json={})
    assert r.status_code == 502 and r.json["conexao"]["estado"] == "falha"


def test_untrusted_host_blocked(client):
    assert (
        client.get("/api/status", headers={"Host": "externo.example"}).status_code
        == 400
    )
