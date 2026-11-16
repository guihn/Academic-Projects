"""Portable ZIP test without Python, pip or agy on the application PATH."""

from pathlib import Path
from zipfile import ZipFile
import json
import hashlib
import os
import socket
import sys
import subprocess
import tempfile
import time
import urllib.request

ROOT = Path(__file__).resolve().parents[1]
archive = ROOT / "dist/ValidaMarket_Windows_Portatil.zip"
with tempfile.TemporaryDirectory(prefix="validamarket-teste-") as folder:
    base = Path(folder) / "Execution without Python"
    base.mkdir()
    with ZipFile(archive) as bundle:
        names = bundle.namelist()
        assert not any(
            name.lower().endswith((".docx", ".pdf")) for name in names
        ), "The academic DOCX is a separate submission."
        assert not any(
            "/.env" == n[-5:]
            or "/.venv/" in n
            or "/.runtime/" in n
            or n.endswith(".sqlite3")
            for n in names
        )
        assert not any(
            Path(n).name in ("auth.json", "oauth_creds.json", "credentials.json")
            for n in names
        )
        bundle.extractall(base)
    app_root = base / "ValidaMarket_Windows"
    runtime = app_root / "_python/python.exe"
    assert runtime.is_file() and (app_root / "cliente_google/agy.exe").is_file()
    with socket.socket() as sock:
        sock.bind(("127.0.0.1", 0))
        port = sock.getsockname()[1]
    env = os.environ.copy()
    env.update(
        PATH=str(Path(os.environ["SystemRoot"]) / "System32"),
        VALIDAMARKET_PORT=str(port),
        VALIDAMARKET_NO_BROWSER="1",
        PYTHONUTF8="1",
    )
    for name in [
        "PYTHONHOME",
        "PYTHONPATH",
        "ANTIGRAVITY_BIN",
        "GEMINI_API_KEY",
        "GOOGLE_API_KEY",
    ]:
        env.pop(name, None)
    log = Path(folder) / "execucao.log"
    with log.open("w", encoding="utf-8") as output:
        proc = subprocess.Popen(
            [os.environ["COMSPEC"], "/d", "/c", str(app_root / "Iniciar.bat")],
            cwd=app_root,
            env=env,
            stdout=output,
            stderr=subprocess.STDOUT,
        )
    try:
        for _ in range(60):
            if proc.poll() is not None:
                raise RuntimeError(log.read_text(encoding="utf-8"))
            try:
                with urllib.request.urlopen(
                    f"http://127.0.0.1:{port}/api/status", timeout=1
                ) as response:
                    status = json.load(response)
                if status.get("aplicativo") == "validamarket":
                    break
            except (OSError, ValueError):
                pass
            time.sleep(0.5)
        else:
            raise RuntimeError(log.read_text(encoding="utf-8"))
        assert status["cliente_disponivel"] is True
        assert not (
            app_root / ".venv"
        ).exists(), (
            "The portable package must not create a virtual environment at runtime."
        )
        result = subprocess.run(
            [
                str(runtime),
                "-c",
                "from google_login import executable; print(executable())",
            ],
            cwd=app_root,
            env=env,
            capture_output=True,
            text=True,
            encoding="utf-8",
            timeout=15,
        )
        assert result.returncode == 0, result.stderr
        assert (
            Path(result.stdout.strip()).resolve()
            == (app_root / "cliente_google/agy.exe").resolve()
        ), result.stdout
        report = {
            "versao": "1.0",
            "commit": os.environ.get("GITHUB_SHA"),
            "zip_sha256": hashlib.sha256(archive.read_bytes()).hexdigest(),
            "resultado": "aprovado",
            "ambiente": "Windows x64; PATH do processo limitado a System32",
            "entrada": "Iniciar.bat, extracted in a folder with spaces",
            "python_incluido": True,
            "cliente_google_incluido": True,
            "criacao_de_venv": False,
            "credenciais_no_pacote": False,
            "status_http": status,
            "limite": "Startup and official-client discovery without global installations. Personal Google authorization belongs to the executor in the official client.",
        }
        if os.environ.get("VALIDAMARKET_UI_TEST") == "1":
            from playwright.sync_api import sync_playwright

            with sync_playwright() as playwright:
                browser = playwright.chromium.launch()
                page = browser.new_page(
                    viewport={"width": 1366, "height": 1000}, locale="pt-BR"
                )
                page.set_default_timeout(120000)
                errors = []
                page.on("pageerror", lambda error: errors.append(str(error)))
                page.goto(f"http://127.0.0.1:{port}")
                page.get_by_role("button", name="Google sign-in", exact=True).wait_for()
                assert page.get_by_role(
                    "button", name="Google sign-in", exact=True
                ).is_enabled()
                page.locator("#date").fill("")
                page.locator("#date").press_sequentially("abc15112026")
                assert page.locator("#date").input_value() == "15/11/2026"
                page.get_by_role("button", name="Reference date calendar").click()
                page.keyboard.press("Escape")
                with page.expect_response("**/api/conexao/verificar") as response:
                    page.get_by_role(
                        "button", name="Connection verification", exact=True
                    ).click()
                assert (
                    response.value.status == 502
                ), "No Google account may be embedded in the package or runner."
                page.get_by_text(response.value.json()["erro"], exact=True).wait_for()
                page.screenshot(
                    path=str(ROOT / "dist/interface_portatil_windows.png"),
                    full_page=True,
                )
                assert not errors, errors
                report.update(
                    interface_windows="aprovada",
                    erros_javascript=errors,
                    conta_google_embutida=False,
                    sem_sessao_bloqueado_com_http=502,
                )
                browser.close()
            subprocess.run(
                [
                    sys.executable,
                    str(ROOT / "ci/verificar_consistencia_interface.py"),
                    f"http://127.0.0.1:{port}",
                ],
                check=True,
            )
            report["regressao_edicao_de_entrada"] = (
                "aprovada; fixtures de interface, sem atribuir esses outputs ao LLM"
            )
        (ROOT / "dist/validacao_portatil_windows.json").write_text(
            json.dumps(report, ensure_ascii=False, indent=2), encoding="utf-8"
        )
        print(json.dumps(report, ensure_ascii=False, indent=2))
    finally:
        subprocess.run(
            ["taskkill", "/PID", str(proc.pid), "/T", "/F"], capture_output=True
        )
        proc.wait(timeout=15)
