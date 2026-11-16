"""Windows x64 portable distribution with verified official components."""

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
        raise SystemExit("The distribution requires Windows x64 for construction.")
    pinned = json.loads((ROOT / "COMPONENTES_FIXADOS.json").read_text(encoding="utf-8"))
    version = pinned["python"]
    if sys.version_info[:2] != (3, 13):
        raise SystemExit("Construction requires Python 3.13 x64.")
    build = ROOT / ".runtime" / "distribuicao_windows"
    if build.exists():
        shutil.rmtree(build)
    stage = build / "ValidaMarket_Windows"
    stage.mkdir(parents=True)
    files = source_files()
    issues = audit(files)
    if issues:
        raise SystemExit("Possible credential in source files: " + str(issues))
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
        raise SystemExit("Portable Python hash differs from the pinned value.")
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
        raise SystemExit("Unexpected Google client origin.")
    client_dir = stage / "cliente_google"
    client_dir.mkdir()
    binary = client_dir / "agy.exe"
    urllib.request.urlretrieve(url, binary)
    digest = hashlib.sha512(binary.read_bytes()).hexdigest()
    if digest.lower() != manifest["sha512"].lower():
        raise SystemExit("Google client hash differs from the pinned value.")
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
        "modo": "Portable Windows x64; no system-wide Python or client installation and no PATH changes.",
    }
    (stage / "COMPONENTES.json").write_text(
        json.dumps(metadata, ensure_ascii=False, indent=2), encoding="utf-8"
    )
    (stage / "LEIA_PRIMEIRO.txt").write_text(
        "ValidaMarket — portable Windows\n\nExecution starts with Iniciar.bat after extraction of the entire ZIP. Python, libraries and the official Google client are included. The server opens the local page in the browser; the terminal keeps the program active. Ctrl+C stops execution.\n\nGoogle sign-in opens the official client for account authorization. Connection verification confirms Gemini access after sign-in. Session storage belongs to the operating system credential store. Internet and model access/quota are required. README.md contains the complete instructions.\n",
        encoding="utf-8",
    )
    destination = ROOT / "dist"
    destination.mkdir(exist_ok=True)
    archive_path = destination / "ValidaMarket_Windows_Portatil.zip"
    with ZipFile(archive_path, "w", ZIP_DEFLATED) as archive:
        for file in stage.rglob("*"):
            if file.is_file():
                if file.suffix.lower() in (".docx", ".pdf"):
                    raise SystemExit("The academic report must remain outside the ZIP.")
                archive.write(file, file.relative_to(build))
    digest = hashlib.sha256(archive_path.read_bytes()).hexdigest()
    (destination / "ValidaMarket_Windows_Portatil.zip.sha256").write_text(
        digest + "  " + archive_path.name + "\n", encoding="utf-8"
    )
    print(archive_path)
    return archive_path


if __name__ == "__main__":
    main()
