"Application source packaging without environments, databases or sessions."

from pathlib import Path
from zipfile import ZipFile, ZIP_DEFLATED
import json
import re

ROOT = Path(__file__).resolve().parents[1]
SOURCES = [
    "app.py",
    "gestao.py",
    "google_login.py",
    "iniciar.py",
    "Iniciar.bat",
    "iniciar.sh",
    "requirements.txt",
    ".env.example",
    "README.md",
    "COMPONENTES_FIXADOS.json",
]
DIRECTORIES = ["static", "templates", "prompts"]
EXTENSIONS = {".py", ".md", ".txt", ".json", ".png", ".css", ".js", ".html", ".yml"}
FORBIDDEN = {".env", "auth.json", "oauth_creds.json", "credentials.json", "token.json"}
PATTERNS = {
    "google_access_token": rb"ya29\.[A-Za-z0-9_-]{20,}",
    "google_api_key": rb"AIza[0-9A-Za-z_-]{30,}",
    "private_key": rb"-----BEGIN (?:RSA |EC |OPENSSH )?PRIVATE KEY-----",
    "token_value": rb'(?i)["\'](?:refresh_token|access_token|id_token|client_secret)["\']\s*:\s*["\'][^"\']{15,}',
}


def source_files(root=ROOT):
    files = [root / name for name in SOURCES if (root / name).is_file()]
    for folder in DIRECTORIES:
        for file in sorted((root / folder).rglob("*")):
            if file.relative_to(root).as_posix() == "scripts/gerar_documento.py":
                continue
            if (
                not file.is_file()
                or file.name in FORBIDDEN
                or file.suffix not in EXTENSIONS
            ):
                continue
            if any(
                part.startswith(".") or part == "__pycache__"
                for part in file.relative_to(root).parts
            ):
                continue
            files.append(file)
    return files


def project_files(root=ROOT):
    """Selects the complete project, including tests and evidence, without private data."""
    files = set(source_files(root))
    for folder in ["tests", "scripts", "ci", "evidencias"]:
        for file in (root / folder).rglob("*"):
            relative = file.relative_to(root)
            if (
                file.is_file()
                and file.suffix in EXTENSIONS
                and file.name not in FORBIDDEN
                and not any(
                    part.startswith(".") or part == "__pycache__"
                    for part in relative.parts
                )
            ):
                files.add(file)
    return sorted(files)


def audit(files):
    issues = []
    for file in files:
        if file.suffix == ".png":
            continue
        data = file.read_bytes()
        for name, pattern in PATTERNS.items():
            if re.search(pattern, data):
                issues.append({"arquivo": file.name, "tipo": name})
    return issues


def main():
    files = project_files()
    issues = audit(files + [ROOT.parent / "README.md"])
    if issues:
        raise SystemExit(
            "Packaging blocked: possible credential in "
            + json.dumps(issues, ensure_ascii=False)
        )
    destination = ROOT.parent / "Entrega4_ValidaMarket.zip"
    with ZipFile(destination, "w", ZIP_DEFLATED) as archive:
        for file in files:
            archive.write(file, Path(ROOT.name) / file.relative_to(ROOT))
        archive.write(ROOT.parent / "README.md", "README.md")
        assert not any(
            name.lower().endswith((".docx", ".pdf")) for name in archive.namelist()
        )
    print(destination)
    print(
        "Selected source files only. No environment, database or Google profile. Credential pattern scan: no matches."
    )


if __name__ == "__main__":
    main()
