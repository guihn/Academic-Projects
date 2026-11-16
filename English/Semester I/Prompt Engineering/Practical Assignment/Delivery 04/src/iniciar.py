"""Portable startup: Python 3.11+, without manual virtual environment activation."""

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
    """Prepares Python, starts the server and opens the browser."""
    load_settings()
    if sys.version_info < (3, 11):
        print("Execution requires Python 3.11 or later.")
        return 1
    port = os.getenv("VALIDAMARKET_PORT", "5000")
    if not port.isdigit() or not 1024 <= int(port) <= 65535:
        print("VALIDAMARKET_PORT must be a number between 1024 and 65535.")
        return 1
    url = f"http://127.0.0.1:{port}"
    try:
        with urllib.request.urlopen(url + "/api/status", timeout=2) as response:
            status = json.load(response)
        if status.get("aplicativo") == "validamarket":
            print("ValidaMarket is already running: " + url)
            if os.getenv("VALIDAMARKET_NO_BROWSER") != "1":
                webbrowser.open(url)
            return 0
        raise ValueError("The port is occupied by another program.")
    except (urllib.error.HTTPError, ValueError):
        print(
            "The selected port is occupied by another program. VALIDAMARKET_PORT selects a different port."
        )
        return 1
    except (urllib.error.URLError, TimeoutError):
        pass
    bundled = ROOT / "_python" / "python.exe"
    if os.name == "nt" and bundled.is_file():
        python = bundled
        # The Windows package already includes Python and libraries; no venv or pip is needed.
        check = subprocess.run([str(python), "-c", "import flask,sqlite3"], cwd=ROOT)
        if check.returncode:
            print(
                "Incomplete portable package. Execution requires extraction of the entire ZIP."
            )
            return 1
    else:
        import venv

        env_dir = ROOT / ".venv"
        python = env_dir / ("Scripts/python.exe" if os.name == "nt" else "bin/python")
        if not python.exists():
            print("Creating the local Python environment…", flush=True)
            try:
                venv.EnvBuilder(with_pip=True).create(env_dir)
            except (OSError, subprocess.SubprocessError):
                print(
                    "Virtual environment creation failed. Source execution requires Python, venv and pip."
                )
                return 1
        runtime = ROOT / ".runtime"
        runtime.mkdir(exist_ok=True)
        required = ROOT / "requirements.txt"
        checksum = hashlib.sha256(required.read_bytes()).hexdigest()
        installed = runtime / "dependencias.sha256"
        if not installed.exists() or installed.read_text(encoding="utf-8") != checksum:
            print("Installing project dependencies…", flush=True)
            if subprocess.run(
                [str(python), "-m", "pip", "install", "-r", str(required)], cwd=ROOT
            ).returncode:
                print(
                    "Dependency installation failed. Working Python and internet access are required."
                )
                return 1
            installed.write_text(checksum, encoding="utf-8")
    print("Starting ValidaMarket: " + url, flush=True)
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
            print("The server did not become available within the startup time limit.")
            server.terminate()
            return 1
        print(
            "Page available in the browser. This window keeps the server active.\nGoogle sign-in precedes connection verification. Ctrl+C stops the program.",
            flush=True,
        )
        return server.wait()
    except KeyboardInterrupt:
        server.terminate()
        server.wait()
        return 0


if __name__ == "__main__":
    raise SystemExit(main())
