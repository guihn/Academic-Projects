"Browser workflow verification with an authorized Google account."

from pathlib import Path
from datetime import datetime, timezone
import json
import sys
from playwright.sync_api import sync_playwright

ROOT = Path(__file__).resolve().parents[1]
URL = sys.argv[1] if len(sys.argv) > 1 else "http://127.0.0.1:5000"
with sync_playwright() as p:
    browser = p.chromium.launch()
    page = browser.new_page(
        viewport={"width": 1366, "height": 1000}, device_scale_factor=1, locale="pt-BR"
    )
    page.set_default_timeout(240000)
    errors = []
    page.on("pageerror", lambda e: errors.append(str(e)))
    page.goto(URL)
    page.locator("#google-title").wait_for()
    page.screenshot(
        path=str(ROOT / "evidencias" / "interface_desktop.png"), full_page=True
    )
    page.locator("#text").fill(
        "Iogurte natural 170g, lote IG-5521, validade 18/11/2026, 36 unidades, gôndola refrigerados, refrigerado"
    )
    page.locator("#date").fill("15/11/2026")
    page.get_by_role("button", name="AI extraction").click()
    page.locator("#review").wait_for(state="visible")
    assert page.locator("#f_data_validade").input_value() == "2026-11-18"
    assert page.locator("#f_quantidade").input_value() == "36"
    page.screenshot(
        path=str(ROOT / "evidencias" / "conferencia_real.png"), full_page=True
    )
    page.get_by_role("button", name="AI confirmation and classification").click()
    page.locator("#result").wait_for(state="visible")
    assert "CRÍTICO" in page.locator("#risk").inner_text()
    page.screenshot(
        path=str(ROOT / "evidencias" / "recomendacao_real.png"), full_page=True
    )
    page.get_by_role("button", name="Approval and alert generation").click()
    page.locator("#alert").wait_for(state="visible")
    log = json.loads(page.locator("#log").text_content())
    assert log["aprovado"] is True
    assert [e["id"] for e in log["trace"]] == ["P01", "P02", "P03", "P04"]
    assert all(e["status"] == "ok" for e in log["trace"])
    assert log["risco"]["dias_restantes"] == 3
    (ROOT / "evidencias" / "fluxo_navegador_real.json").write_text(
        json.dumps(log, ensure_ascii=False, indent=2), encoding="utf-8"
    )
    page.screenshot(path=str(ROOT / "evidencias" / "alerta_real.png"), full_page=True)
    # The writeoff below is a synthetic test event, explicitly confirmed.
    page.locator("#writeoff-record").select_option(log["id"])
    page.locator("#writeoff-quantity").fill("2")
    page.locator("#writeoff-reason").select_option("avaria")
    page.locator("#writeoff-value").fill("12,90")
    page.locator("#writeoff-done").check()
    page.get_by_role("button", name="Writeoff registration", exact=True).click()
    page.wait_for_function(
        "document.getElementById('writeoff-history').textContent.includes('12,90')"
    )
    page.locator("#report-generate").click()
    page.locator("#report-download").wait_for(state="visible")
    weekly = page.evaluate("weeklyReport")
    assert weekly["dados"]["totais"]["unidades_baixadas"] == 2
    assert weekly["dados"]["totais"]["valor_centavos_informado"] == 1290
    assert [e["id"] for e in weekly["trace"]] == ["P05"]
    page.locator("#report-title").scroll_into_view_if_needed()
    page.screenshot(
        path=str(ROOT / "evidencias/relatorio_semanal_real.png"), full_page=True
    )
    services = []
    for text, expected in [
        ("What is the difference between expiration and storage conditions?", False),
        (
            "I found milk lot LT-10, expired yesterday, 14/11/2026, displayed for sale on the shelf in aisle 3. What should I do?",
            True,
        ),
    ]:
        page.locator("#service-text").fill(text)
        with page.expect_response("**/api/atendimento", timeout=240000) as response:
            page.get_by_role(
                "button", name="Customer service with AI", exact=True
            ).click()
        value = response.value.json()
        assert response.value.status == 200, value
        assert value["resposta"]["produto_vencido_na_gondola"] is expected
        assert bool(value["alerta"]) is expected
        assert [e["id"] for e in value["trace"]] == (
            ["P06", "P04"] if expected else ["P06"]
        )
        services.append(value)
        page.wait_for_function("!document.getElementById('service-text').disabled")
    page.locator("#service-title").scroll_into_view_if_needed()
    page.screenshot(path=str(ROOT / "evidencias/atendimento_real.png"), full_page=True)
    (ROOT / "evidencias/gestao_real.json").write_text(
        json.dumps(
            {
                "origem_dos_dados": "Synthetic test entries and writeoff; real Gemini responses.",
                "relatorio": weekly,
                "atendimentos": services,
                "baixas": page.request.get(URL + "/api/gestao").json()["baixas"],
                "prompts_executados": ["P01", "P02", "P03", "P04", "P05", "P06"],
            },
            ensure_ascii=False,
            indent=2,
        ),
        encoding="utf-8",
    )
    assert (
        page.evaluate("getComputedStyle(document.documentElement).colorScheme")
        == "dark"
    )
    # Native calendar synchronization and letter rejection in the reference date.
    page.locator("#date-picker").evaluate(
        "el => {el.value='2026-11-16';el.dispatchEvent(new Event('change',{bubbles:true}));}"
    )
    assert page.locator("#date").input_value() == "16/11/2026"
    page.locator("#date").press("End")
    page.locator("#date").press_sequentially("abc")
    assert page.locator("#date").input_value() == "16/11/2026"
    assert page.locator("#result").is_hidden()
    page.set_viewport_size({"width": 390, "height": 844})
    page.screenshot(
        path=str(ROOT / "evidencias" / "interface_mobile.png"), full_page=True
    )
    assert page.evaluate("document.documentElement.scrollWidth <= window.innerWidth")
    (ROOT / "evidencias" / "interface.json").write_text(
        json.dumps(
            {
                "data_utc": datetime.now(timezone.utc).isoformat(),
                "url": URL,
                "desktop": "1366x1000",
                "mobile": "390x844",
                "erros_javascript": errors,
                "mensagem_observada": page.locator("#message").inner_text(),
                "fluxo_completo_llm_real": True,
                "prompts_executados": ["P01", "P02", "P03", "P04", "P05", "P06"],
                "gestao_e_atendimento_llm_real": True,
                "tema_escuro": True,
                "calendario_e_bloqueio_de_letras": True,
                "aprovacao_registrada": log["aprovado"],
                "sem_rolagem_horizontal_mobile": True,
            },
            ensure_ascii=False,
            indent=2,
        ),
        encoding="utf-8",
    )
    assert not errors
    browser.close()
print(
    "P01–P06 verified in the browser with a Google account; desktop and mobile passed."
)
