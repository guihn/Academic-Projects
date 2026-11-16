"""Publication of the validated ValidaMarket package and removal of superseded downloads."""

from pathlib import Path
from urllib.parse import quote
import json
import hashlib
import os
import urllib.request
import urllib.error

ROOT = Path(__file__).resolve().parents[1]
API = "https://api.github.com/repos/guihn/Academic-Projects"
TAG = "validamarket-e4-v1.0"


def api(method, url, payload=None, binary=None, content_type="application/json"):
    headers = {
        "Accept": "application/vnd.github+json",
        "Authorization": "Bearer " + os.environ["GH_TOKEN"],
        "X-GitHub-Api-Version": "2026-03-10",
        "Content-Type": content_type,
    }
    data = (
        binary
        if binary is not None
        else json.dumps(payload).encode() if payload is not None else None
    )
    request = urllib.request.Request(url, data=data, headers=headers, method=method)
    with urllib.request.urlopen(request, timeout=180) as response:
        return None if response.status == 204 else json.load(response)


def require_unused_version():
    """Stops if the release or tag exists; no previous publication is deleted."""
    for suffix in ["/releases/tags/" + TAG, "/git/ref/tags/" + TAG]:
        try:
            api("GET", API + suffix)
        except urllib.error.HTTPError as error:
            if error.code == 404:
                continue
            raise
        raise SystemExit("Version 1.0 already exists. Publication interrupted.")


def main():
    archive = ROOT / "dist/ValidaMarket_Windows_Portatil.zip"
    validation = ROOT / "dist/validacao_portatil_windows.json"
    report = json.loads(validation.read_text(encoding="utf-8"))
    if report["resultado"] != "aprovado" or report["interface_windows"] != "aprovada":
        raise SystemExit("Publication requires a validated Windows package.")
    if report.get("zip_sha256") != hashlib.sha256(archive.read_bytes()).hexdigest():
        raise SystemExit('The archive does not match the validated SHA-256.')
    require_unused_version()
    notes = """ValidaMarket — Entrega 04 do Trabalho Prático de Engenharia de Prompt, Semestre I.

Pacote vigente: versão 1.0, com Python, bibliotecas e cliente oficial Google incluídos. A execução começa em Iniciar.bat após a extração completa do ZIP. A autorização utiliza a conta Google do executor; internet e acesso/cota ao Gemini são necessários.

Código, explicação e evidências: https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004

Current package: version 1.0, with a Portuguese interface. The English source and documentation are available at https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004

Windows startup, interface, calendar and input-editing regression are verified automatically. Account authorization remains with the executor. The academic DOCX is a separate submission and is excluded from this package.
"""
    release = api(
        "POST",
        API + "/releases",
        {
            "tag_name": TAG,
            "target_commitish": os.environ["GITHUB_SHA"],
            "name": "ValidaMarket — Entrega 04 — 1.0",
            "body": notes,
            "draft": True,
            "prerelease": False,
        },
    )
    upload = release["upload_url"].split("{", 1)[0]
    for asset in [
        archive,
        ROOT / "dist/Entrega4_ValidaMarket.zip",
        ROOT / "dist/ValidaMarket_Windows_Portatil.zip.sha256",
        validation,
    ]:
        mime = (
            "application/zip"
            if asset.suffix == ".zip"
            else "application/json" if asset.suffix == ".json" else "text/plain"
        )
        api(
            "POST",
            upload + "?name=" + quote(asset.name),
            binary=asset.read_bytes(),
            content_type=mime,
        )
    published = api("PATCH", release["url"], {"draft": False, "make_latest": "true"})
    print(published["html_url"])


if __name__ == "__main__":
    main()
