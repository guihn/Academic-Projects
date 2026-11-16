"""Smoke test do inicializador real; não precisa de conta Google ou interface gráfica."""

from pathlib import Path
import json
import os
import shutil
import socket
import subprocess
import sys
import tempfile
import time
import urllib.request

ROOT = Path(__file__).resolve().parents[1]
with tempfile.TemporaryDirectory(prefix="validamarket-inicio-") as temp:
    target = Path(temp) / "ValidaMarket com espacos"
    target.mkdir()
    for name in [
        "app.py",
        "gestao.py",
        "google_login.py",
        "iniciar.py",
        "requirements.txt",
    ]:
        shutil.copy2(ROOT / name, target / name)
    for name in ["static", "templates", "prompts"]:
        shutil.copytree(ROOT / name, target / name)
    with socket.socket() as sock:
        sock.bind(("127.0.0.1", 0))
        port = sock.getsockname()[1]
    environment = os.environ.copy()
    environment.update(
        VALIDAMARKET_NO_BROWSER="1", VALIDAMARKET_PORT=str(port), PYTHONUNBUFFERED="1"
    )
    log = Path(temp) / "inicio.log"
    with log.open("w", encoding="utf-8") as output:
        process = subprocess.Popen(
            [sys.executable, str(target / "iniciar.py")],
            cwd=target,
            env=environment,
            stdout=output,
            stderr=subprocess.STDOUT,
        )
    try:
        for _ in range(180):
            if process.poll() is not None:
                raise RuntimeError(log.read_text(encoding="utf-8"))
            try:
                with urllib.request.urlopen(
                    f"http://127.0.0.1:{port}/api/status", timeout=1
                ) as response:
                    state = json.load(response)
                if state.get("aplicativo") == "validamarket":
                    break
            except (OSError, ValueError):
                pass
            time.sleep(1)
        else:
            raise RuntimeError(
                "Inicialização excedeu prazo. " + log.read_text(encoding="utf-8")
            )
        assert (
            target
            / ".venv"
            / ("Scripts/python.exe" if os.name == "nt" else "bin/python")
        ).is_file()
        assert not (target / ".env").exists()
        print(
            "Inicialização limpa em pasta com espaços: OK; servidor local pronto; sem credencial embutida."
        )
    finally:
        if os.name == "nt":
            subprocess.run(
                ["taskkill", "/PID", str(process.pid), "/T", "/F"], capture_output=True
            )
        else:
            # O pai espera o servidor; terminar ambos sem afetar outros processos.
            if shutil.which("pkill"):
                subprocess.run(
                    ["pkill", "-TERM", "-P", str(process.pid)], capture_output=True
                )
            process.terminate()
        process.wait(timeout=15)
