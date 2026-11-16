"""Constrói a distribuição Windows x64 portátil em um runner Windows.

Baixa componentes oficiais, valida o hash do cliente Google e instala bibliotecas
somente dentro do pacote. Não copia HOME, cofre, .env, banco ou perfis.
"""

from pathlib import Path
from zipfile import ZipFile, ZIP_DEFLATED
import hashlib
import json
import os
import platform
import shutil
import subprocess
import sys
import urllib.request
from urllib.parse import urlsplit
from empacotar import ROOT, source_files, audit


def main():
    if sys.platform != "win32" or platform.machine().lower() not in ("amd64", "x86_64"):
        raise SystemExit("A distribuição deve ser construída no Windows x64.")
    pinned = json.loads((ROOT / "COMPONENTES_FIXADOS.json").read_text(encoding="utf-8"))
    version = pinned["python"]
    if sys.version_info[:2] != (3, 13):
        raise SystemExit("A construção requer Python 3.13 x64.")
    build = ROOT / ".runtime" / "distribuicao_windows"
    if build.exists():
        shutil.rmtree(build)
    stage = build / "ValidaMarket_Windows"
    stage.mkdir(parents=True)
    files = source_files()
    issues = audit(files)
    if issues:
        raise SystemExit("Possível credencial nas fontes: " + str(issues))
    for source in files:
        relative = source.relative_to(ROOT)
        target = stage / relative
        target.parent.mkdir(parents=True, exist_ok=True)
        shutil.copy2(source, target)
    shutil.copy2(ROOT.parent / "README.md", stage / "README.md")
    python_dir = stage / "_python"
    python_dir.mkdir()
    python_url = pinned["python_origem"]
    python_zip = build / "python-embed.zip"
    urllib.request.urlretrieve(python_url, python_zip)
    if (
        hashlib.sha256(python_zip.read_bytes()).hexdigest()
        != pinned["python_zip_sha256"]
    ):
        raise SystemExit("Hash do Python portátil divergiu da versão fixada.")
    with ZipFile(python_zip) as archive:
        archive.extractall(python_dir)
    pth = next(python_dir.glob("python*._pth"))
    pth.write_text(
        "python313.zip\n.\nLib/site-packages\n..\nimport site\n", encoding="utf-8"
    )
    subprocess.run(
        [
            sys.executable,
            "-m",
            "pip",
            "install",
            "--only-binary=:all:",
            "--no-compile",
            "--target",
            str(python_dir / "Lib/site-packages"),
            "-r",
            str(ROOT / "requirements.txt"),
        ],
        check=True,
    )
    manifest = {
        "url": pinned["cliente_google_origem"],
        "sha512": pinned["cliente_google_sha512"],
        "version": pinned["cliente_google_versao"],
    }
    url = manifest["url"]
    if (
        urlsplit(url).scheme != "https"
        or urlsplit(url).hostname != "storage.googleapis.com"
    ):
        raise SystemExit("Origem inesperada para o cliente Google.")
    client_dir = stage / "cliente_google"
    client_dir.mkdir()
    binary = client_dir / "agy.exe"
    urllib.request.urlretrieve(url, binary)
    digest = hashlib.sha512(binary.read_bytes()).hexdigest()
    if digest.lower() != manifest["sha512"].lower():
        raise SystemExit("Hash do cliente Google divergiu do manifesto oficial.")
    sqlite_version = subprocess.check_output(
        [
            str(python_dir / "python.exe"),
            "-c",
            "import sqlite3; print(sqlite3.sqlite_version)",
        ],
        cwd=stage,
        text=True,
        encoding="utf-8",
    ).strip()
    metadata = {
        "sqlite": sqlite_version,
        "python": version,
        "python_origem": python_url,
        "python_zip_sha256": hashlib.sha256(python_zip.read_bytes()).hexdigest(),
        "cliente_google_versao": manifest["version"],
        "cliente_google_origem": url,
        "cliente_google_sha512": digest,
        "bibliotecas": "requirements.txt",
        "inclui_credenciais": False,
        "modo": "Portátil Windows x64; não instala Python/cliente no sistema nem altera PATH.",
    }
    (stage / "COMPONENTES.json").write_text(
        json.dumps(metadata, ensure_ascii=False, indent=2), encoding="utf-8"
    )
    (stage / "LEIA_PRIMEIRO.txt").write_text(
        "ValidaMarket — Windows portátil\n\nA execução começa em Iniciar.bat, após a extração completa do ZIP. Python, bibliotecas e cliente oficial Google estão incluídos. O servidor abre a página local no navegador; a janela mantém o programa ativo. Ctrl+C encerra a execução.\n\nO botão Login Google abre o cliente oficial para autorização da conta. Após o login, o botão Verificação da conexão confirma acesso ao Gemini. A sessão fica no cofre do sistema operacional. Internet e acesso/cota para o modelo são necessários. As instruções completas estão em README.md.\n",
        encoding="utf-8",
    )
    destination = ROOT / "dist"
    destination.mkdir(exist_ok=True)
    archive_path = destination / "ValidaMarket_Windows_Portatil.zip"
    with ZipFile(archive_path, "w", ZIP_DEFLATED) as archive:
        for file in stage.rglob("*"):
            if file.is_file():
                if file.suffix.lower() in (".docx", ".pdf"):
                    raise SystemExit("O relatório acadêmico deve ficar fora do ZIP.")
                archive.write(file, file.relative_to(build))
    digest = hashlib.sha256(archive_path.read_bytes()).hexdigest()
    (destination / "ValidaMarket_Windows_Portatil.zip.sha256").write_text(
        digest + "  " + archive_path.name + "\n", encoding="utf-8"
    )
    print(archive_path)
    return archive_path


if __name__ == "__main__":
    main()
