"""Regressão da edição de datas/descrição. Fixtures HTTP não são evidências de LLM."""

from playwright.sync_api import sync_playwright
import json
import sys

url = sys.argv[1] if len(sys.argv) > 1 else "http://127.0.0.1:5000"
lot = {
    "produto": "Iogurte",
    "categoria": "laticínios",
    "lote": "IG1",
    "data_validade": "2026-11-18",
    "quantidade": 36,
    "setor": "frios",
    "armazenamento": "refrigerado",
}
with sync_playwright() as p:
    browser = p.chromium.launch()
    page = browser.new_page()
    page.goto(url)

    def analyze(route):
        data = route.request.post_data_json
        if "lote_confirmado" in data:
            response = {
                "etapa": "analisado",
                "id": "fixture",
                "lote": lot,
                "risco": {"classificacao": "CRÍTICO", "dias_restantes": 3},
                "acao": {
                    "acao": "Revisar lote",
                    "prazo": "2026-11-17",
                    "responsavel": "líder",
                },
                "alerta": None,
                "trace": [],
            }
        else:
            response = {
                "etapa": "conferir",
                "lote": lot,
                "extracao_id": "fixture",
                "trace": [],
            }
        route.fulfill(
            status=200, content_type="application/json", body=json.dumps(response)
        )

    page.route("**/api/analisar", analyze)
    page.locator("#text").fill(
        "Iogurte lote IG1, validade 18/11/2026, 36 unidades, frios, refrigerado"
    )
    page.locator("#date").fill("15/11/2026")
    page.get_by_role("button", name="Extração com IA", exact=True).click()
    page.locator("#review").wait_for(state="visible")
    page.get_by_role(
        "button", name="Confirmação e classificação com IA", exact=True
    ).click()
    page.locator("#result").wait_for(state="visible")
    page.locator("#f_quantidade").fill("20")
    assert page.locator("#result").is_hidden()
    page.get_by_role(
        "button", name="Confirmação e classificação com IA", exact=True
    ).click()
    page.locator("#result").wait_for(state="visible")
    page.locator("#date").fill("16/11/2026")
    assert page.locator("#review").is_hidden() and page.locator("#result").is_hidden()
    assert "nova extração" in page.locator("#message").inner_text()
    browser.close()
print(
    "Regressão aprovada: alteração dos dados exige recálculo; alteração da referência exige nova extração. Fixtures identificadas como testes de interface."
)
