"Gemini inference through the official Google account client.\n\nAntigravity CLI manages sign-in; application code does not read or export tokens."

import json
import os
from pathlib import Path
import shutil
import platform
import subprocess
import tempfile

DEFAULT_MODEL = "gemini-3.8-flash-low"
SETTINGS = {
    "toolPermission": "strict",
    "allowNonWorkspaceAccess": False,
    "permissions": {
        "allow": [],
        "deny": [
            "command(*)",
            "read_file(*)",
            "write_file(*)",
            "read_url(*)",
            "execute_url(*)",
            "mcp(*)",
        ],
    },
}


class GoogleLoginError(RuntimeError):
    pass


def load_settings():
    """Loads only local runtime options, preserving environment overrides."""
    config = Path(__file__).resolve().parent / ".env"
    if not config.is_file():
        return
    allowed = {
        "GEMINI_MODEL",
        "ANTIGRAVITY_BIN",
        "VALIDAMARKET_PORT",
        "VALIDAMARKET_DB",
    }
    for line in config.read_text(encoding="utf-8").splitlines():
        key, separator, value = line.partition("=")
        if separator and key.strip() in allowed:
            os.environ.setdefault(key.strip(), value.strip().strip('"').strip("'"))


def executable():
    "Finds the Google client in the package, configuration or system."
    configured = os.getenv("ANTIGRAVITY_BIN")
    if configured:
        p = Path(configured).expanduser()
        return (
            str(p)
            if p.is_file()
            and os.access(p, os.X_OK)
            and (platform.system() != "Windows" or p.suffix.lower() == ".exe")
            else None
        )
    portable = Path(__file__).resolve().parent / "cliente_google" / "agy.exe"
    if platform.system() == "Windows" and portable.is_file():
        return str(portable)
    found = shutil.which("agy")
    if found and (
        platform.system() != "Windows" or Path(found).suffix.lower() == ".exe"
    ):
        return found
    if platform.system() == "Windows":
        base = Path(
            os.environ.get("LOCALAPPDATA", str(Path.home() / "AppData" / "Local"))
        )
        candidates = [
            base / "agy" / "bin" / "agy.exe",
            Path.home() / ".local/bin/agy.exe",
        ]
    else:
        candidates = [Path.home() / ".local/bin/agy"]
    for candidate in candidates:
        if candidate.is_file() and os.access(candidate, os.X_OK):
            return str(candidate)
    return None


def account_environment():
    "Uses the local environment without forwarding API key configuration."
    environment = os.environ.copy()
    for key in [
        "GEMINI_API_KEY",
        "GOOGLE_API_KEY",
        "GOOGLE_GENAI_USE_VERTEXAI",
        "GOOGLE_APPLICATION_CREDENTIALS",
        "AGY_ADC_AUTH",
        "GOOGLE_GEMINI_BASE_URL",
    ]:
        environment.pop(key, None)
    return environment


def open_login():
    "Opens the official client in a local terminal; the client manages OAuth and system credentials."
    binary = executable()
    if not binary:
        raise GoogleLoginError(
            "Sign-in requires the official Google Antigravity CLI, available through the installation link on the page."
        )
    workspace = Path(__file__).resolve().parent / ".runtime" / "login"
    workspace.mkdir(parents=True, exist_ok=True)
    system = platform.system()
    options = dict(cwd=workspace, env=account_environment(), shell=False)
    try:
        if system == "Windows":
            subprocess.Popen(
                [binary],
                creationflags=getattr(subprocess, "CREATE_NEW_CONSOLE", 0x00000010),
                **options
            )
        elif system == "Darwin":
            # Terminal.app receives only the fixed executable path; page text never becomes a command.
            quoted = "'" + binary.replace("'", "'\"'\"'") + "'"
            script = 'tell application "Terminal" to do script ' + json.dumps(quoted)
            subprocess.Popen(["/usr/bin/osascript", "-e", script], **options)
        else:
            terminals = [
                ("foot", ["-e"]),
                ("kitty", []),
                ("alacritty", ["-e"]),
                ("gnome-terminal", ["--"]),
                ("konsole", ["-e"]),
                ("x-terminal-emulator", ["-e"]),
                ("xterm", ["-e"]),
            ]
            for name, flags in terminals:
                terminal = shutil.which(name)
                if terminal:
                    subprocess.Popen([terminal, *flags, binary], **options)
                    break
            else:
                raise GoogleLoginError(
                    "Graphical terminal not found. The agy command provides manual sign-in; the page can verify the connection after authorization."
                )
    except OSError:
        raise GoogleLoginError(
            "Terminal launch failed. The agy command provides manual Google client sign-in."
        ) from None
    return "Official client opened in a terminal. Browser authorization uses the selected Google account. Connection verification is available in ValidaMarket after sign-in."


def schema(pid):
    """Define os campos JSON esperados para cada um dos seis prompts."""
    if pid == "P01":
        props = {
            k: {"type": ["string", "null"]}
            for k in [
                "produto",
                "categoria",
                "lote",
                "data_validade",
                "setor",
                "armazenamento",
            ]
        }
        props["quantidade"] = {"type": ["integer", "null"]}
    elif pid == "P02":
        props = {
            "classificacao": {
                "type": "string",
                "enum": ["OK", "ATENÇÃO", "CRÍTICO", "VENCIDO"],
            },
            "dias_restantes": {"type": "integer"},
            "justificativa": {"type": "string"},
        }
    elif pid == "P03":
        props = {k: {"type": "string"} for k in ["acao", "prazo", "responsavel"]}
    elif pid == "P04":
        props = {"mensagem": {"type": "string"}}
    elif pid == "P05":
        props = {
            "resumo": {"type": "string"},
            "causas_possiveis": {
                "type": "array",
                "items": {"type": "string"},
                "minItems": 1,
                "maxItems": 5,
            },
            "medidas_preventivas": {
                "type": "array",
                "items": {"type": "string"},
                "minItems": 1,
                "maxItems": 5,
            },
        }
    elif pid == "P06":
        props = {
            "mensagem": {"type": "string"},
            "produto": {"type": ["string", "null"]},
            "lote": {"type": ["string", "null"]},
            "setor": {"type": ["string", "null"]},
            "produto_vencido_na_gondola": {"type": "boolean"},
        }
    else:
        raise GoogleLoginError("Unrecognized prompt.")
    return {
        "type": "object",
        "properties": props,
        "required": list(props),
        "additionalProperties": False,
    }


def generate(pid, prompt):
    "Runs the official client, validates JSON and returns response, log and model."
    binary = executable()
    if not binary:
        raise GoogleLoginError(
            "Google client not found. Sign-in requires Antigravity CLI and a Google account authorized in the official client."
        )
    model = os.getenv("GEMINI_MODEL") or DEFAULT_MODEL
    # Inference uses the account already authenticated in the official client.
    args = [
        binary,
        "-p",
        prompt
        + "\nTool, file, command, skill and subagent use is prohibited. Only the requested data may be returned.",
        "--model",
        model,
        "--output-format",
        "json",
        "--json-schema",
        json.dumps(schema(pid), ensure_ascii=False),
        "--disable-slash-commands",
        "--print-timeout",
        "90s",
        "--settings",
        json.dumps(SETTINGS),
    ]
    environment = account_environment()
    try:
        with tempfile.TemporaryDirectory(prefix="validamarket-inferencia-") as cwd:
            result = subprocess.run(
                args,
                cwd=cwd,
                env=environment,
                capture_output=True,
                text=True,
                encoding="utf-8",
                timeout=100,
                shell=False,
            )
    except subprocess.TimeoutExpired:
        raise GoogleLoginError("Gemini exceeded the response time limit.") from None
    except (OSError, UnicodeError):
        raise GoogleLoginError(
            "Google client startup failed. An available Antigravity CLI installation is required."
        ) from None
    try:
        envelope = json.loads(result.stdout)
    except (ValueError, TypeError):
        raise GoogleLoginError(
            "The Google client did not return a valid JSON log. Account authorization may be unavailable."
        ) from None
    if (
        not isinstance(envelope, dict)
        or result.returncode != 0
        or envelope.get("status") != "SUCCESS"
    ):
        raise GoogleLoginError(
            "The Google client did not complete generation. The active account requires authorization, model access and available quota."
        )
    parsed = envelope.get("structured_output")
    try:
        if parsed is None:
            parsed = json.loads(envelope.get("response", ""))
        if not isinstance(parsed, dict):
            raise ValueError()
    except (ValueError, TypeError):
        raise GoogleLoginError(
            "Gemini returned data outside the expected JSON format."
        ) from None
    # The envelope contains response and usage data, without authentication tokens.
    public_fields = [
        "conversation_id",
        "status",
        "response",
        "duration_seconds",
        "num_turns",
        "usage",
        "structured_output",
        "json_schema",
    ]
    public_envelope = {key: envelope[key] for key in public_fields if key in envelope}
    return parsed, public_envelope, model
