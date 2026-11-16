"Clean launcher smoke test without Google authorization or a graphical interface."

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
                "Startup exceeded the time limit. " + log.read_text(encoding="utf-8")
            )
        assert (
            target
            / ".venv"
            / ("Scripts/python.exe" if os.name == "nt" else "bin/python")
        ).is_file()
        assert not (target / ".env").exists()
        print(
            "Clean startup in a folder with spaces: OK; local server ready; no embedded credentials."
        )
    finally:
        if os.name == "nt":
            subprocess.run(
                ["taskkill", "/PID", str(process.pid), "/T", "/F"], capture_output=True
            )
        else:
            # Both parent and server are stopped without affecting other processes.
            if shutil.which("pkill"):
                subprocess.run(
                    ["pkill", "-TERM", "-P", str(process.pid)], capture_output=True
                )
            process.terminate()
        process.wait(timeout=15)
