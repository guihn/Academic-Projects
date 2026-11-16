"""Inferência Gemini pelo cliente oficial autenticado com a conta Google.

Não lê, copia ou exporta tokens. O próprio Antigravity CLI gerencia o login.
"""

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
    """Carrega apenas opções locais de execução, preservando o ambiente existente."""
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
    """Localiza o cliente Google no pacote, na configuração ou no sistema."""
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
    """Usa o ambiente local sem encaminhar configurações de chave de API."""
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
    """Abre o cliente oficial no terminal local; ele gerencia OAuth e o cofre do SO."""
    binary = executable()
    if not binary:
        raise GoogleLoginError(
            "O login requer o Antigravity CLI oficial do Google, disponível pelo link de instalação da página."
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
            # Terminal.app recebe só o caminho fixo do executável; nenhum texto da página vira comando.
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
                    "Terminal gráfico não encontrado. O comando agy permite o login manual; a conexão pode ser verificada na página após a autorização."
                )
    except OSError:
        raise GoogleLoginError(
            "A abertura do terminal falhou. O comando agy permite o login manual no cliente Google."
        ) from None
    return "Cliente oficial aberto no terminal. A autorização ocorre no navegador com a conta Google selecionada. Após o login, a verificação de conexão fica disponível no ValidaMarket."


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
        raise GoogleLoginError("Prompt não reconhecido.")
    return {
        "type": "object",
        "properties": props,
        "required": list(props),
        "additionalProperties": False,
    }


def generate(pid, prompt):
    """Executa o cliente oficial, valida o JSON e retorna resposta, log e modelo."""
    binary = executable()
    if not binary:
        raise GoogleLoginError(
            "Cliente Google não encontrado. O login requer o Antigravity CLI e uma conta Google autorizada no cliente oficial."
        )
    model = os.getenv("GEMINI_MODEL") or DEFAULT_MODEL
    # A inferência usa a conta já autenticada no cliente oficial.
    args = [
        binary,
        "-p",
        prompt
        + "\nNão use ferramentas, arquivos, comandos, skills ou subagentes. Retorne apenas os dados solicitados.",
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
        raise GoogleLoginError("O Gemini excedeu o tempo de resposta.") from None
    except (OSError, UnicodeError):
        raise GoogleLoginError(
            "A inicialização do cliente Google falhou. A instalação do Antigravity CLI deve estar disponível."
        ) from None
    try:
        envelope = json.loads(result.stdout)
    except (ValueError, TypeError):
        raise GoogleLoginError(
            "O cliente Google não retornou um log JSON válido. A autorização da conta pode estar indisponível."
        ) from None
    if (
        not isinstance(envelope, dict)
        or result.returncode != 0
        or envelope.get("status") != "SUCCESS"
    ):
        raise GoogleLoginError(
            "O cliente Google não concluiu a geração. A conta ativa precisa de autorização, acesso ao modelo e cota disponível."
        )
    parsed = envelope.get("structured_output")
    try:
        if parsed is None:
            parsed = json.loads(envelope.get("response", ""))
        if not isinstance(parsed, dict):
            raise ValueError()
    except (ValueError, TypeError):
        raise GoogleLoginError(
            "O Gemini retornou dados fora do formato JSON esperado."
        ) from None
    # O envelope contém resposta e uso, não contém os tokens de autenticação.
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
