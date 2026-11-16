"""Regras de distribuição e erro de porta ocupada; não simulam saída de IA real."""

from pathlib import Path
import sys
import urllib.error

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import iniciar
from scripts.empacotar import source_files


def test_source_package_excludes_report_and_private_environment(tmp_path):
    (tmp_path / "app.py").write_text("# programa", encoding="utf-8")
    (tmp_path / "Entrega4.docx").write_bytes(b"")
    (tmp_path / ".env").write_text("local", encoding="utf-8")
    scripts = tmp_path / "scripts"
    scripts.mkdir()
    (scripts / "gerar_documento.py").write_text(
        "# relatório separado", encoding="utf-8"
    )
    selected = {str(file.relative_to(tmp_path)) for file in source_files(tmp_path)}
    assert selected == {"app.py"}


def test_other_server_http_error_is_reported_as_port_conflict(monkeypatch, capsys):
    def occupied(*args, **kwargs):
        raise urllib.error.HTTPError(
            "http://127.0.0.1:5000/api/status", 404, "Not Found", {}, None
        )

    monkeypatch.setattr(iniciar.urllib.request, "urlopen", occupied)
    monkeypatch.delenv("VALIDAMARKET_PORT", raising=False)
    assert iniciar.main() == 1
    assert "ocupada por outro programa" in capsys.readouterr().out


def test_alert_wrapper_is_removed_without_changing_llm_trace():
    import json
    from app import normalize_alert

    original = {
        "mensagem": json.dumps(
            {"mensagem": "ALTA | Iogurte | Conferir lote"}, ensure_ascii=False
        )
    }
    assert normalize_alert(original) == {"mensagem": "ALTA | Iogurte | Conferir lote"}
    assert original["mensagem"].startswith("{")


def test_alert_rejects_unexpected_embedded_json():
    import pytest
    from app import normalize_alert, ModelError

    with pytest.raises(ModelError):
        normalize_alert({"mensagem": '{"outro":"texto"}'})


def test_publication_checks_both_unused_references(monkeypatch):
    import ci.publicar_release as publication

    calls = []

    def missing(method, url):
        calls.append((method, url))
        raise urllib.error.HTTPError(url, 404, "Not Found", {}, None)

    monkeypatch.setattr(publication, "api", missing)
    publication.require_unused_version()
    assert len(calls) == 2 and all(method == "GET" for method, url in calls)


def test_publication_does_not_replace_existing_version(monkeypatch):
    import pytest
    import ci.publicar_release as publication

    calls = []
    monkeypatch.setattr(publication, "api", lambda method, url: calls.append(method))
    with pytest.raises(SystemExit):
        publication.require_unused_version()
    assert calls == ["GET"]


def test_publication_does_not_hide_permission_error(monkeypatch):
    import pytest
    import ci.publicar_release as publication

    def forbidden(method, url):
        raise urllib.error.HTTPError(url, 403, "Forbidden", {}, None)

    monkeypatch.setattr(publication, "api", forbidden)
    with pytest.raises(urllib.error.HTTPError) as error:
        publication.require_unused_version()
    assert error.value.code == 403
