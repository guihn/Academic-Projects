"""Official Windows client verification without embedded credentials."""

from pathlib import Path
import json
import os
import subprocess
import sys

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
from google_login import executable, account_environment, generate, GoogleLoginError

binary = executable()
assert binary and Path(binary).suffix.lower() == ".exe", "Official client not found."
help_result = subprocess.run(
    [binary, "--help"], capture_output=True, text=True, encoding="utf-8", timeout=30
)
assert help_result.returncode == 0 and "--print" in (
    help_result.stdout + help_result.stderr
)
try:
    generate(
        "P04",
        "Return only JSON with mensagem: connection verification. Tool use is prohibited.",
    )
except GoogleLoginError:
    # Inference fails explicitly on a runner without an authorized account.
    print(
        "The official Windows client starts and the application reports missing authorization."
    )
else:
    raise AssertionError("The runner must not contain an authorized Google account.")
