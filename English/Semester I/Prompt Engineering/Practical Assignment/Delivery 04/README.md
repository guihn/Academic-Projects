<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment">Parent&nbsp;folder</a></td>
</tr>
</table>

# Delivery 04 · ValidaMarket

## Description

ValidaMarket supports expiration monitoring in supermarkets. A lot description provides product, batch identifier, complete expiration date, quantity, section and storage conditions. Six Gemini prompts extract data, classify expiration risk, propose an action and generate a local alert. Field review and action approval provide human control between the model calls.

## Assignment summary

The fourth practical delivery requires a functional prototype with an LLM call at runtime, source code on GitHub and recorded tests. The implemented scope follows expiration control from the preceding practical delivery. F01–F08 cover lot review, extraction, classification, recommendation, approval and alerts, history, weekly loss reporting and customer service. CSV import and external message delivery remain outside the implemented scope.

## Solution

P01 extracts structured data for review. P02 receives the lot and a Python-calculated assessment, returns the classification and explains the applied range. Python validates the returned fields again. P03 proposes an action for lots requiring attention. P04 generates the alert after explicit approval. OK lots remain under monitoring without P03/P04. SQLite records analyses, approvals, explicitly declared writeoffs, reports and customer interactions. JSON export provides the execution traces. P05 summarizes a seven-day period ending on the reference date; P06 answers expiration questions and triggers P04 for a report of expired goods on a shelf. Such reports require verification.

The application runs locally with the executor's Google account authorized in the official Antigravity CLI. Passwords and authentication tokens are managed by the official client. The program does not apply discounts, dispose of products or send messages externally.

## Prompts and techniques

The central artifact is the set of instructions that transforms a lot description into structured data, an expiration assessment, a recommendation and an alert. Each prompt has an input contract, an expected output format and restrictions on invented information or unauthorized actions.

| Prompt | Technique | Purpose and control |
| --- | --- | --- |
| P01 | Few-shot examples and structured JSON | Extraction of lot fields; missing or ambiguous values remain null for validation. |
| P02 | Explicit rules, boundary examples and constrained output | Classification and justification grounded in the Python-calculated assessment, with boundary examples and output validation. |
| P03 | Role prompting and conditional rules | Action recommendation by risk, with mandatory treatment of expired lots and human approval. |
| P04 | Communication template | Local alert after approval, or a verification request for a customer shelf report. |
| P05 | Role prompting with calculated aggregates | Weekly writeoffs by product and section, hypotheses and preventive measures. |
| P06 | Role prompting and guardrails | Expiration guidance, without invented details; P04 for an expired-on-shelf report. |

Prompt chaining passes the reviewed extraction to P02, the assessed risk to P03 and the approved action to P04. Human review separates extraction from analysis, and approval precedes the alert. The [prompt files](https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src/prompts) contain the complete instructions. Execution records document model responses, extraction failures and corrected repetitions.

## Execution

The portable package requires 64-bit Windows 10/11, a browser, internet and a Google account with model access/quota. Python, libraries and the official client are included. The portable interface is in Portuguese.

### Portable startup

After extraction of the entire ZIP, `ValidaMarket_Windows/Iniciar.bat` starts `iniciar.py` with the included Python and opens `http://127.0.0.1:5000`. The terminal keeps the server active; `Ctrl+C` stops it.

`Login Google` opens the official client in a local terminal. Authorization takes place with the selected Google account in the browser. After sign-in, the client can be closed and `Verificação da conexão` checks Gemini access from the application. The `/logout` command ends an existing official-client session. Credentials remain in the operating system account, outside the package.

### Source execution

The source alternative requires Python 3.11+ and the official Antigravity CLI. From `src`, `python iniciar.py` creates a local virtual environment, installs `requirements.txt` and opens the browser. Systems using `python3` use the equivalent `python3 iniciar.py` command. The English source presents English messages; operational JSON keys, classification tokens and storage options remain fixed.

### Lot analysis

A complete description includes product, lot, expiration date, quantity, section and storage. The reference date accepts numeric dd/mm/yyyy input or the calendar. Extraction provides editable fields; confirmation starts classification and recommendation. Approval generates the local alert. Input changes invalidate previous results. History and JSON download remain available on the page.

Example reference: **15/11/2026**.

```text
Natural yogurt 170g, lot IG-5521, expiration 18/11/2026, 36 units, refrigerated aisle, refrigerated.
```

The Portuguese portable accepts the equivalent description:

```text
Iogurte natural 170g, lote IG-5521, validade 18/11/2026, 36 unidades, gôndola refrigerados, refrigerado.
```

### Writeoffs, weekly report and customer service

An approved analysis with a remaining balance can receive a writeoff declaration. Quantity, reason and confirmation of the completed physical movement are required; the total monetary amount is optional. The program caps the quantity at the remaining balance of that analysis. Duplicate analyses of the same lot are separate records and must not be treated as additional stock.

The weekly report uses the seven days ending on the reference date, inclusive. Numeric totals are calculated by Python from recorded events; P05 summarizes them with possible causes and preventive measures. Missing monetary values are shown separately, so their absence does not mean zero loss. The report is generated on demand and remains available in history and JSON.

Customer service uses the same reference date. P06 answers a question without requesting personal data. A reported expired product on a store shelf triggers P04 to request verification in a local alert; a general question does not trigger that alert. The report does not prove that a product is expired and does not execute a physical withdrawal.

The source ZIP includes tests, integration scripts and evidence in addition to runtime files. The portable Windows ZIP contains only runtime files and the bundled official components. Both exclude the academic document and personal data.

### Configuration and diagnosis

`GEMINI_MODEL` selects the model; `ANTIGRAVITY_BIN` identifies the client executable; `VALIDAMARKET_PORT` selects the local port. A local `.env` may hold these options without credentials. The default model is `gemini-3.8-flash-low`.

An occupied port requires another available port or termination of the other instance. Missing model access, quota or authorization produces an error. The portable client is `cliente_google/agy.exe`; source execution locates `agy` in the configuration or system.

## Project resources

| Section | Content |
| --- | --- |
| [Source files](https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src) | Application, interface, prompts and tests. |
| [Execution](https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004#execution) | Requirements, startup and Google authorization, described on this page. |
| [Code explanation](https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004#application-code) | Functions, routes, data and prompt chain, documented below. |
| [Test records](https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src/evidencias) | Model traces, test reports and screenshots. |

Version 1.0: [Windows portable package](https://github.com/guihn/Academic-Projects/releases/download/validamarket-e4-v1.0/ValidaMarket_Windows_Portatil.zip) and [complete source project](https://github.com/guihn/Academic-Projects/releases/download/validamarket-e4-v1.0/Entrega4_ValidaMarket.zip). The academic report is submitted separately.

## Group members

- Guilherme Henrique Moura dos Santos
- Davi Gomes Junqueira Silva
- Gustavo Rafael Atanásio dos Santos
- Gabriel Gonçalves Fialho


## Application code

The implementation uses four Python modules to coordinate startup, lot analysis and communication with Gemini:

- `iniciar.py` prepares the Python environment, starts the local server and opens the browser.
- `app.py` connects the prompts, validates lot data and date calculations, handles approval and stores the history.
- `gestao.py` validates physical writeoff declarations, seven-day periods and report/customer-response contracts; monetary amounts use integer cents.
- `google_login.py` locates the official Google client, opens account authorization and requests structured model responses.

These modules provide the software support for the prompt chain. Their responsibilities and interactions are described below; the implementation files remain available in src. Prompt instructions, response constraints and evaluation form the focus of the assignment.

### Program structure

The browser sends JSON to Flask. The server calls Gemini through the official client, checks the data and stores records in local SQLite. Source files in src are the maintained application; bundled Python and agy.exe are third-party components.

### Startup: iniciar.py

main() loads the permitted .env options before checking Python and the local port; existing environment variables take precedence. The portable uses _python/python.exe; source execution creates .venv and installs requirements.txt when its hash changes. The launcher starts app.py, waits for /api/status and opens the browser. Ctrl+C terminates the child server.

### Workflow: app.py

pipeline() first calls P01 and records an extraction identifier. Human confirmation sends the reviewed lot and identifier back. A changed description or reference requires another extraction. P02 returns classification and remaining days; reference() independently calculates both and blocks disagreement. P03 supplies an action when the status is not OK. approve() generates P04 only after explicit approval.


The confirmation requires a valid extraction identifier. P02 must match the Python calculation, and P03 must return a complete date within the permitted interval. SQLite connections close after their transactions. HTTP 413 returns JSON when an input exceeds the permitted size.

### Fields and dates

validate_lot() requires positive integer quantity, complete dates, known storage and the expected fields. Category may be null. Dates use ISO yyyy-mm-dd internally. Storage tokens ambiente, refrigerado and congelado are literal contract values. Negative days mean VENCIDO. Refrigerated/frozen lots are CRÍTICO through 3 days and ATENÇÃO through 7; ambient lots use 15 and 45 days. Higher values are OK.

### Google client: google_login.py

executable() locates the client in configuration, the portable folder, PATH or standard installation directories. open_login() opens a local terminal. generate() supplies the prompt and JSON Schema through subprocess.run(shell=False), with a 100-second process limit and a 90-second client limit. Tool access is denied and a temporary working directory isolates inference. Only response and usage fields are exported; account tokens remain with the official client.

### Page behavior: static/app.js

api() wraps fetch calls and HTTP errors. busy() disables controls while requests run. extractLot(), buildFields(), confirmLot() and approveAction() correspond to the main workflow. referenceDateISO() validates the numeric date and synchronizes the native calendar. Input changes invalidate stale results. render(), history(), renderReport() and renderService() present data through textContent. downloadJSON() exports analyses, reports and customer interactions. managementHistory() loads earlier events.

### Writeoff rules: gestao.py

writeoff() requires an explicit declaration of a completed physical movement, a positive integer quantity within the record balance, a reason and a valid date. Optional monetary amounts are parsed as decimals and stored as integer cents; an omitted amount remains unknown. A SQLite transaction prevents simultaneous writeoffs from exceeding one record's balance.

aggregate() selects the inclusive seven-day window and groups actual writeoffs by product and section. Analyses, approvals and customer reports have separate counts. validate_report() and validate_service() reject malformed P05/P06 outputs before storage. report() sends calculated aggregates to P05; service() calls P06 and conditionally P04, preserving original model traces.

### Storage and logs

database() creates extracoes, registros, baixas, relatorios and atendimentos in dados.sqlite3. Values reach SQL through ? parameters. Extraction JSON records input, reference and trace; analysis JSON includes lot, risk, action, alert and approval. llm() records prompt, timestamps, model response and errors. normalize_alert() removes a duplicate JSON wrapper without changing the raw response trace.

### Verification and distribution

tests covers local contracts without inference. scripts/testar_llm_real.py records real-model batches; scripts/verificar_interface.py verifies the browser workflow; scripts/testar_gestao_real.py records additional real-model report and customer-service cases. ci checks clean startup and the extracted Windows package. scripts/empacotar.py selects the complete project and scans credential patterns; source_files() supplies the smaller runtime selection used by the portable builder. scripts/construir_windows.py verifies pinned official Python and Google client hashes and installs libraries inside the ZIP. ci/publicar_release.py publishes only after an explicit manual workflow request, using an ephemeral Actions credential. Existing releases and tags are never deleted or replaced. None of these support scripts runs during ordinary lot analysis.

### HTTP routes

| Route | Purpose |
| --- | --- |
| `/` | Page |
| `/api/status` | Client and connection state |
| `/api/conexao/entrar` | Official-client sign-in |
| `/api/conexao/verificar` | Model access verification |
| `/api/analisar` | Extraction or confirmed analysis |
| `/api/aprovar/<id>` | Approval and alert |
| `/api/historico` | Last 100 analyses and their record balances |
| `/api/baixas/<id>` | Completed physical writeoff declaration |
| `/api/relatorios` | Weekly aggregates and P05 report |
| `/api/atendimento` | P06 response and optional P04 alert |
| `/api/gestao` | Writeoff, report and customer-service history |

## AI assistance

Prototype development and the preparation of prompts and documentation for this delivery used artificial intelligence tools as support.
