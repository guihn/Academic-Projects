"ValidaMarket E4: prompt chain, validation and human approval."

from datetime import date, datetime, timedelta, timezone
from contextlib import contextmanager
from pathlib import Path
import json
import os
import re
import sqlite3
import uuid
import platform
from urllib.parse import urlsplit
from google_login import (
    generate,
    executable,
    DEFAULT_MODEL,
    GoogleLoginError,
    open_login,
    load_settings,
)
from flask import Flask, jsonify, render_template, request
from gestao import (
    GestaoError,
    aggregate,
    period,
    writeoff,
    validate_report,
    validate_service,
)

ROOT = Path(__file__).resolve().parent
load_settings()

app = Flask(__name__)
app.config.update(
    MAX_CONTENT_LENGTH=16000,
    DB=os.getenv("VALIDAMARKET_DB") or str(ROOT / "dados.sqlite3"),
    TRUSTED_HOSTS=["localhost", "127.0.0.1", "[::1]"],
)
connection_state = {"estado": "nao_verificada", "verificada_em": None}
FIELDS = [
    "produto",
    "categoria",
    "lote",
    "data_validade",
    "quantidade",
    "setor",
    "armazenamento",
]


class InputError(ValueError):
    pass


class ModelError(RuntimeError):
    pass


@contextmanager
def database():
    "Opens local SQLite storage and creates extraction and analysis tables when needed."
    db = sqlite3.connect(app.config["DB"])
    db.row_factory = sqlite3.Row
    db.execute(
        "CREATE TABLE IF NOT EXISTS registros (id TEXT PRIMARY KEY, criado TEXT NOT NULL, dados TEXT NOT NULL, aprovado INTEGER NOT NULL DEFAULT 0)"
    )
    db.execute(
        "CREATE TABLE IF NOT EXISTS extracoes (id TEXT PRIMARY KEY, dados TEXT NOT NULL)"
    )
    db.execute(
        "CREATE TABLE IF NOT EXISTS baixas (id TEXT PRIMARY KEY, registro_id TEXT NOT NULL, criado TEXT NOT NULL, data TEXT NOT NULL, quantidade INTEGER NOT NULL, motivo TEXT NOT NULL, valor_centavos INTEGER)"
    )
    db.execute(
        "CREATE TABLE IF NOT EXISTS relatorios (id TEXT PRIMARY KEY, data_referencia TEXT NOT NULL, dados TEXT NOT NULL)"
    )
    db.execute(
        "CREATE TABLE IF NOT EXISTS atendimentos (id TEXT PRIMARY KEY, data_referencia TEXT NOT NULL, dados TEXT NOT NULL)"
    )
    try:
        with db:
            yield db
    finally:
        db.close()


def reference(lot, today):
    "Calculates remaining days and classification to check the P02 response."
    days = (date.fromisoformat(lot["data_validade"]) - date.fromisoformat(today)).days
    cold = lot["armazenamento"] in ("refrigerado", "congelado")
    critical, attention = (3, 7) if cold else (15, 45)
    if days < 0:
        status = "VENCIDO"
    elif days <= critical:
        status = "CRÍTICO"
    elif days <= attention:
        status = "ATENÇÃO"
    else:
        status = "OK"
    return {"classificacao": status, "dias_restantes": days}


def validate_lot(lot):
    "Checks fields, quantity, storage and date before analysis."
    if not isinstance(lot, dict) or set(lot) != set(FIELDS):
        raise ModelError("P01 returned a structure incompatible with the lot fields.")
    missing = [k for k in FIELDS if k != "categoria" and lot[k] is None]
    if missing:
        raise InputError("Missing or ambiguous fields: " + ", ".join(missing))
    if any(
        not isinstance(lot[k], str) or not lot[k].strip() or len(lot[k]) > 200
        for k in ["produto", "lote", "data_validade", "setor", "armazenamento"]
    ):
        raise InputError(
            "Product, lot, expiration date, section and storage must contain valid text."
        )
    if lot["categoria"] is not None and (
        not isinstance(lot["categoria"], str) or len(lot["categoria"]) > 200
    ):
        raise ModelError("Category returned in an invalid format.")
    if type(lot["quantidade"]) is not int or not 1 <= lot["quantidade"] <= 2147483647:
        raise InputError("Quantity must be a positive integer number of units.")
    if lot["armazenamento"] not in ("ambiente", "refrigerado", "congelado"):
        raise InputError("Valid storage tokens: ambiente, refrigerado or congelado.")
    try:
        if not re.fullmatch(r"\d{4}-\d{2}-\d{2}", lot["data_validade"]):
            raise ValueError()
        date.fromisoformat(lot["data_validade"])
    except (ValueError, TypeError):
        raise InputError(
            "Invalid expiration date: a complete day, month and year are required."
        )
    return lot


def llm(pid, data, trace):
    "Combines the prompt and input, calls Gemini and logs the response."
    prompt = (ROOT / "prompts" / (pid + ".txt")).read_text(
        encoding="utf-8"
    ) + json.dumps(data, ensure_ascii=False)
    entry = {
        "id": pid,
        "inicio_utc": datetime.now(timezone.utc).isoformat(),
        "prompt": prompt,
        "provedor": "Gemini via Antigravity CLI",
        "autenticacao": "Google account (sign-in managed by the official client)",
        "status": "iniciado",
    }
    trace.append(entry)
    try:
        parsed, envelope, model = generate(pid, prompt)
        entry.update(
            modelo_solicitado=model,
            resposta_cliente=envelope,
            saida_bruta=envelope.get("response", ""),
            status="ok",
            fim_utc=datetime.now(timezone.utc).isoformat(),
        )
        return parsed
    except GoogleLoginError as exc:
        entry.update(
            status="erro", erro=str(exc), fim_utc=datetime.now(timezone.utc).isoformat()
        )
        raise ModelError(str(exc)) from None


def normalize_alert(value):
    "Removes a possible duplicate JSON wrapper from the P04 message."
    if not isinstance(value, dict) or not isinstance(value.get("mensagem"), str):
        raise ModelError("P04 returned an invalid message.")
    message = value["mensagem"]
    # Alguns outputs encapsulam o objeto JSON novamente dentro da string.
    # Only the wrapper is removed; the original text remains in the LLM trace.
    if message.lstrip().startswith("{"):
        try:
            wrapped = json.loads(message)
        except ValueError:
            raise ModelError("P04 returned an invalid message.") from None
        if (
            not isinstance(wrapped, dict)
            or set(wrapped) != {"mensagem"}
            or not isinstance(wrapped["mensagem"], str)
        ):
            raise ModelError("P04 returned an invalid message.")
        message = wrapped["mensagem"]
    if not 1 <= len(message.strip()) <= 600:
        raise ModelError("P04 returned an invalid message.")
    return {"mensagem": message}


def pipeline(text, today, approved_lot=None, extraction_id=None):
    "Runs P01 or confirms an extraction before running P02 and P03."
    trace = []
    try:
        if not isinstance(text, str) or not 3 <= len(text.strip()) <= 4000:
            raise InputError("The lot description must contain 3 to 4000 characters.")
        if not isinstance(today, str) or not re.fullmatch(r"\d{4}-\d{2}-\d{2}", today):
            raise InputError("Invalid reference date.")
        try:
            date.fromisoformat(today)
        except ValueError:
            raise InputError("Invalid reference date.")
        if approved_lot is not None:
            if not isinstance(extraction_id, str) or not re.fullmatch(
                r"[0-9a-f]{32}", extraction_id
            ):
                raise InputError("The confirmation requires a valid lot extraction.")
            with database() as db:
                draft = db.execute(
                    "SELECT dados FROM extracoes WHERE id=?", (extraction_id or "",)
                ).fetchone()
            if not draft:
                raise InputError("Confirmation requires a valid lot extraction.")
            draft = json.loads(draft["dados"])
            if draft["texto"] != text or draft["data_referencia"] != today:
                raise InputError("The input changed. A new lot extraction is required.")
            trace = draft["trace"]
        lot = validate_lot(
            approved_lot
            if approved_lot is not None
            else llm("P01", {"texto": text}, trace)
        )
        if approved_lot is None:
            extraction_id = uuid.uuid4().hex
            with database() as db:
                db.execute(
                    "INSERT INTO extracoes VALUES(?,?)",
                    (
                        extraction_id,
                        json.dumps(
                            {"texto": text, "data_referencia": today, "trace": trace},
                            ensure_ascii=False,
                        ),
                    ),
                )
            return {
                "etapa": "conferir",
                "lote": lot,
                "trace": trace,
                "data_referencia": today,
                "extracao_id": extraction_id,
            }
        expected = reference(lot, today)
        risk = llm(
            "P02",
            {"lote": lot, "data_referencia": today, "calculo_conferido": expected},
            trace,
        )
        if not isinstance(risk, dict) or set(risk) != {
            "classificacao",
            "dias_restantes",
            "justificativa",
        }:
            raise ModelError("P02 returned invalid fields.")
        if type(risk.get("dias_restantes")) is not int or any(
            risk.get(k) != v for k, v in expected.items()
        ):
            raise ModelError(
                "P02 disagreed with the date calculation or policy limits. Analysis blocked."
            )
        if (
            not isinstance(risk.get("justificativa"), str)
            or not 1 <= len(risk["justificativa"].strip()) <= 600
        ):
            raise ModelError("P02 returned an invalid justification.")
        result = {
            "etapa": "analisado",
            "lote": lot,
            "data_referencia": today,
            "risco": risk,
            "trace": trace,
            "acao": None,
            "alerta": None,
        }
        if expected["classificacao"] != "OK":
            deadline = (
                date.fromisoformat(lot["data_validade"]) - timedelta(days=1)
                if lot["data_validade"] > today
                else date.fromisoformat(today)
            ).isoformat()
            action = llm(
                "P03",
                {
                    "lote": lot,
                    "data_referencia": today,
                    "risco": risk,
                    "limite_reavaliacao": deadline,
                },
                trace,
            )
            if not isinstance(action, dict) or set(action) != {
                "acao",
                "prazo",
                "responsavel",
            }:
                raise ModelError("P03 returned invalid fields.")
            if any(
                not isinstance(action.get(k), str)
                or not 1 <= len(action[k].strip()) <= 1200
                for k in ["acao", "prazo", "responsavel"]
            ):
                raise ModelError("P03 returned an incomplete action.")
            if (
                not re.fullmatch(r"\d{4}-\d{2}-\d{2}", action["prazo"])
                or not today <= action["prazo"] <= deadline
            ):
                raise ModelError("P03 returned a deadline outside the permitted range.")
            try:
                date.fromisoformat(action["prazo"])
            except ValueError:
                raise ModelError(
                    "P03 returned a deadline outside the permitted range."
                ) from None
            if (
                expected["classificacao"] == "VENCIDO"
                and action["acao"]
                != "Removal from sale, segregation, incident recording and referral to the responsible person for disposal."
            ):
                raise ModelError(
                    "P03 disagreed with the mandatory action for expired products. Workflow blocked."
                )
            result["acao"] = action
            # The alert is displayed only after manager approval through another route.
        result["id"] = uuid.uuid4().hex
        with database() as db:
            db.execute(
                "INSERT INTO registros(id,criado,dados) VALUES(?,?,?)",
                (
                    result["id"],
                    datetime.now(timezone.utc).isoformat(),
                    json.dumps(result, ensure_ascii=False),
                ),
            )
        return result
    except (InputError, ModelError) as exc:
        exc.trace = trace
        raise


@app.errorhandler(413)
def too_large(error):
    return jsonify(erro="The request exceeds the permitted size."), 413


@app.get("/")
def home():
    return render_template("index.html", today=date.today().isoformat())


@app.get("/api/status")
def status():
    return jsonify(
        aplicativo="validamarket",
        cliente_disponivel=bool(executable()),
        autenticacao="Local Google account",
        modelo=os.getenv("GEMINI_MODEL") or DEFAULT_MODEL,
        sistema=platform.system(),
        conexao=connection_state,
    )


@app.before_request
def protect_local_connection():
    "Restricts sign-in launch requests to the local browser."
    if request.path.startswith("/api/conexao/") and request.method == "POST":
        if request.remote_addr not in ("127.0.0.1", "::1"):
            return (
                jsonify(erro="Google sign-in must originate on this computer."),
                403,
            )
        if not request.is_json:
            return jsonify(erro="The request body must be a JSON object."), 415
        origin = request.headers.get("Origin")
        if origin and urlsplit(origin).netloc != request.host:
            return jsonify(erro="Origin not allowed."), 403


@app.post("/api/conexao/entrar")
def connect_google():
    try:
        return jsonify(mensagem=open_login())
    except GoogleLoginError as exc:
        return jsonify(erro=str(exc)), 503


@app.post("/api/conexao/verificar")
def verify_google():
    try:
        # A real response checks model access, beyond executable availability.
        data, envelope, model = generate(
            "P04",
            "Return only JSON with mensagem: Gemini connection verified. Tool use is prohibited.",
        )
        connection_state.update(
            estado="conectada", verificada_em=datetime.now(timezone.utc).isoformat()
        )
        return jsonify(
            mensagem="Gemini connection verified with the Google account active in the local client.",
            conexao=connection_state,
            modelo=model,
        )
    except GoogleLoginError as exc:
        connection_state.update(estado="falha", verificada_em=None)
        return jsonify(erro=str(exc), conexao=connection_state), 502


@app.post("/api/analisar")
def analyze():
    data = request.get_json(silent=True)
    if not isinstance(data, dict):
        return jsonify(erro="The request body must be a JSON object."), 400
    try:
        return jsonify(
            pipeline(
                data.get("texto"),
                data.get("data_referencia"),
                data.get("lote_confirmado"),
                data.get("extracao_id"),
            )
        )
    except (InputError, ModelError) as exc:
        return jsonify(erro=str(exc), trace=getattr(exc, "trace", [])), (
            422 if isinstance(exc, InputError) else 502
        )


@app.post("/api/aprovar/<record_id>")
def approve(record_id):
    "Records approval and calls P04 to generate the local alert."
    with database() as db:
        row = db.execute("SELECT * FROM registros WHERE id=?", (record_id,)).fetchone()
        if not row:
            return jsonify(erro="Record not found."), 404
        result = json.loads(row["dados"])
        if row["aprovado"]:
            return jsonify(result)
        try:
            if result["acao"] is not None:
                raw_alert = llm(
                    "P04",
                    {
                        "lote": result["lote"],
                        "risco": result["risco"],
                        "acao": result["acao"],
                    },
                    result["trace"],
                )
                result["alerta"] = normalize_alert(raw_alert)
                result["normalizacao_alerta"] = result["alerta"] != raw_alert
        except ModelError as exc:
            return jsonify(erro=str(exc), trace=result["trace"]), 502
        result["aprovado"] = True
        db.execute(
            "UPDATE registros SET dados=?,aprovado=1 WHERE id=?",
            (json.dumps(result, ensure_ascii=False), record_id),
        )
        return jsonify(result)


def records(db):
    return [
        dict(
            id=r["id"],
            criado=r["criado"],
            aprovado=bool(r["aprovado"]),
            dados=json.loads(r["dados"]),
        )
        for r in db.execute("SELECT * FROM registros ORDER BY criado DESC")
    ]


@app.get("/api/historico")
def history():
    with database() as db:
        data = records(db)[:100]
        for record in data:
            record["quantidade_baixada"] = db.execute(
                "SELECT COALESCE(SUM(quantidade),0) FROM baixas WHERE registro_id=?",
                (record["id"],),
            ).fetchone()[0]
            record["saldo_registro"] = (
                record["dados"]["lote"]["quantidade"] - record["quantidade_baixada"]
            )
        return jsonify(data)


@app.post("/api/baixas/<record_id>")
def register_writeoff(record_id):
    data = request.get_json(silent=True)
    if not isinstance(data, dict):
        return jsonify(erro="The request body must be a JSON object."), 400
    try:
        with database() as db:
            db.execute("BEGIN IMMEDIATE")
            row = db.execute(
                "SELECT * FROM registros WHERE id=?", (record_id,)
            ).fetchone()
            if not row:
                return jsonify(erro="Record not found."), 404
            result = json.loads(row["dados"])
            if not row["aprovado"] or result["acao"] is None:
                raise GestaoError(
                    "The writeoff requires a reviewed and approved action for the record."
                )
            used = db.execute(
                "SELECT COALESCE(SUM(quantidade),0) FROM baixas WHERE registro_id=?",
                (record_id,),
            ).fetchone()[0]
            event = writeoff(data, result["lote"]["quantidade"] - used)
            event.update(
                id=uuid.uuid4().hex,
                registro_id=record_id,
                criado=datetime.now(timezone.utc).isoformat(),
            )
            db.execute(
                "INSERT INTO baixas VALUES(?,?,?,?,?,?,?)",
                (
                    event["id"],
                    record_id,
                    event["criado"],
                    event["data"],
                    event["quantidade"],
                    event["motivo"],
                    event["valor_centavos"],
                ),
            )
        return jsonify(event), 201
    except GestaoError as exc:
        return jsonify(erro=str(exc)), 422


@app.post("/api/relatorios")
def report():
    data = request.get_json(silent=True)
    if not isinstance(data, dict):
        return jsonify(erro="The request body must be a JSON object."), 400
    trace = []
    try:
        with database() as db:
            payload = aggregate(
                records(db),
                [dict(r) for r in db.execute("SELECT * FROM baixas")],
                [
                    dict(
                        data_referencia=r["data_referencia"],
                        dados=json.loads(r["dados"]),
                    )
                    for r in db.execute("SELECT * FROM atendimentos")
                ],
                data.get("data_referencia"),
            )
        response = llm("P05", payload, trace)
        try:
            validate_report(response)
        except GestaoError as exc:
            raise ModelError(str(exc)) from None
        result = {
            "id": uuid.uuid4().hex,
            "criado": datetime.now(timezone.utc).isoformat(),
            "dados": payload,
            "relatorio": response,
            "trace": trace,
        }
        with database() as db:
            db.execute(
                "INSERT INTO relatorios VALUES(?,?,?)",
                (
                    result["id"],
                    data["data_referencia"],
                    json.dumps(result, ensure_ascii=False),
                ),
            )
        return jsonify(result)
    except (GestaoError, ModelError) as exc:
        return jsonify(erro=str(exc), trace=trace), (
            502 if isinstance(exc, ModelError) else 422
        )


@app.post("/api/atendimento")
def service():
    data = request.get_json(silent=True)
    if not isinstance(data, dict):
        return jsonify(erro="The request body must be a JSON object."), 400
    trace = []
    try:
        text = data.get("texto")
        if not isinstance(text, str) or not 3 <= len(text.strip()) <= 2000:
            raise GestaoError("The question must contain 3 to 2000 characters.")
        reference_date = data.get("data_referencia")
        period(reference_date)
        response = llm(
            "P06", {"pergunta": text, "data_referencia": reference_date}, trace
        )
        try:
            validate_service(response)
        except GestaoError as exc:
            raise ModelError(str(exc)) from None
        result = {
            "id": uuid.uuid4().hex,
            "criado": datetime.now(timezone.utc).isoformat(),
            "data_referencia": reference_date,
            "pergunta": text,
            "resposta": response,
            "alerta": None,
            "trace": trace,
        }
        if response["produto_vencido_na_gondola"]:
            lot = {
                field: response[field] or "Not provided"
                for field in ["produto", "lote", "setor"]
            }
            action = {
                "acao": "Verify the shelf report and, if expiration is confirmed, remove the product from sale and segregate it.",
                "prazo": reference_date,
                "responsavel": "Section leader",
            }
            alert = normalize_alert(
                llm(
                    "P04",
                    {
                        "origem": "atendimento",
                        "lote": lot,
                        "risco": {"classificacao": "VENCIDO", "confirmado": False},
                        "acao": action,
                    },
                    trace,
                )
            )
            result["alerta"] = {"mensagem": "REPORT TO VERIFY | " + alert["mensagem"]}
        with database() as db:
            db.execute(
                "INSERT INTO atendimentos VALUES(?,?,?)",
                (result["id"], reference_date, json.dumps(result, ensure_ascii=False)),
            )
        return jsonify(result)
    except (GestaoError, ModelError) as exc:
        return jsonify(erro=str(exc), trace=trace), (
            502 if isinstance(exc, ModelError) else 422
        )


@app.get("/api/gestao")
def management():
    with database() as db:
        return jsonify(
            baixas=[
                dict(r)
                for r in db.execute(
                    "SELECT * FROM baixas ORDER BY criado DESC LIMIT 100"
                )
            ],
            relatorios=[
                json.loads(r["dados"])
                for r in db.execute(
                    "SELECT dados FROM relatorios ORDER BY rowid DESC LIMIT 10"
                )
            ],
            atendimentos=[
                json.loads(r["dados"])
                for r in db.execute(
                    "SELECT dados FROM atendimentos ORDER BY rowid DESC LIMIT 10"
                )
            ],
        )


if __name__ == "__main__":
    app.run(
        host="127.0.0.1", port=int(os.getenv("VALIDAMARKET_PORT", "5000")), debug=False
    )
