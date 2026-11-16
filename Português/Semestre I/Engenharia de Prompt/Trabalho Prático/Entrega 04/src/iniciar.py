"""Inicialização portátil: Python 3.11+, Windows/Linux, sem ativar venv manualmente."""

from pathlib import Path
import hashlib
import json
import os
import subprocess
import sys
import time
import urllib.error
import urllib.request
import webbrowser
from google_login import load_settings

ROOT = Path(__file__).resolve().parent


def main():
    """Prepara o Python, inicia o servidor e abre o navegador."""
    load_settings()
    if sys.version_info < (3, 11):
        print("A execução requer Python 3.11 ou superior.")
        return 1
    port = os.getenv("VALIDAMARKET_PORT", "5000")
    if not port.isdigit() or not 1024 <= int(port) <= 65535:
        print("VALIDAMARKET_PORT deve ser um número entre 1024 e 65535.")
        return 1
    url = f"http://127.0.0.1:{port}"
    try:
        with urllib.request.urlopen(url + "/api/status", timeout=2) as response:
            status = json.load(response)
        if status.get("aplicativo") == "validamarket":
            print("ValidaMarket já está em execução: " + url)
            if os.getenv("VALIDAMARKET_NO_BROWSER") != "1":
                webbrowser.open(url)
            return 0
        raise ValueError("A porta está ocupada por outro programa.")
    except (urllib.error.HTTPError, ValueError):
        print(
            "A porta escolhida está ocupada por outro programa. VALIDAMARKET_PORT permite selecionar outra porta."
        )
        return 1
    except (urllib.error.URLError, TimeoutError):
        pass
    bundled = ROOT / "_python" / "python.exe"
    if os.name == "nt" and bundled.is_file():
        python = bundled
        # O pacote Windows já contém Python e bibliotecas; não cria venv nem usa pip.
        check = subprocess.run([str(python), "-c", "import flask,sqlite3"], cwd=ROOT)
        if check.returncode:
            print(
                "Pacote portátil incompleto. A execução requer a extração do ZIP inteiro."
            )
            return 1
    else:
        import venv

        env_dir = ROOT / ".venv"
        python = env_dir / ("Scripts/python.exe" if os.name == "nt" else "bin/python")
        if not python.exists():
            print("Criando ambiente Python local…", flush=True)
            try:
                venv.EnvBuilder(with_pip=True).create(env_dir)
            except (OSError, subprocess.SubprocessError):
                print(
                    "A criação do ambiente virtual falhou. A execução pelo código-fonte requer Python, venv e pip."
                )
                return 1
        runtime = ROOT / ".runtime"
        runtime.mkdir(exist_ok=True)
        required = ROOT / "requirements.txt"
        checksum = hashlib.sha256(required.read_bytes()).hexdigest()
        installed = runtime / "dependencias.sha256"
        if not installed.exists() or installed.read_text(encoding="utf-8") != checksum:
            print("Instalando dependências do projeto…", flush=True)
            if subprocess.run(
                [str(python), "-m", "pip", "install", "-r", str(required)], cwd=ROOT
            ).returncode:
                print(
                    "A instalação de dependências falhou. São necessários Python funcional e acesso à internet."
                )
                return 1
            installed.write_text(checksum, encoding="utf-8")
    print("Iniciando ValidaMarket: " + url, flush=True)
    server = subprocess.Popen([str(python), str(ROOT / "app.py")], cwd=ROOT)
    try:
        for _ in range(100):
            if server.poll() is not None:
                return server.returncode or 1
            try:
                with urllib.request.urlopen(url + "/api/status", timeout=1) as response:
                    state = json.load(response)
                if state.get("aplicativo") == "validamarket":
                    if os.getenv("VALIDAMARKET_NO_BROWSER") != "1":
                        webbrowser.open(url)
                    break
            except (urllib.error.URLError, ValueError, TimeoutError):
                pass
            time.sleep(0.2)
        else:
            print("O servidor não ficou disponível no prazo de inicialização.")
            server.terminate()
            return 1
        print(
            "Página disponível no navegador. A janela mantém o servidor ativo.\nO login Google precede a verificação da conexão. Ctrl+C encerra o programa.",
            flush=True,
        )
        return server.wait()
    except KeyboardInterrupt:
        server.terminate()
        server.wait()
        return 0


if __name__ == "__main__":
    raise SystemExit(main())
