"""Confere o cliente oficial no Windows sem introduzir credenciais de ninguém."""

from pathlib import Path
import json
import os
import subprocess
import sys

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
from google_login import executable, account_environment, generate, GoogleLoginError

binary = executable()
assert (
    binary and Path(binary).suffix.lower() == ".exe"
), "Cliente oficial não encontrado."
help_result = subprocess.run(
    [binary, "--help"], capture_output=True, text=True, encoding="utf-8", timeout=30
)
assert help_result.returncode == 0 and "--print" in (
    help_result.stdout + help_result.stderr
)
try:
    generate(
        "P04",
        "Retorne apenas JSON com mensagem: verificação de conexão. Não use ferramentas.",
    )
except GoogleLoginError:
    # Em runner sem login, inferência deve falhar de forma explícita; não há fallback.
    print(
        "Cliente oficial Windows inicia e a aplicação trata a ausência de login sem gerar resposta simulada."
    )
else:
    raise AssertionError("Runner não deveria possuir uma conta Google conectada.")
