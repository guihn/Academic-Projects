<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/scripts">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src">Parent&nbsp;folder</a></td>
</tr>
</table>

# Integration and distribution tools

These scripts record model integration tests, verify the browser workflow, select application files and construct the Windows portable ZIP with pinned official components.


Source file: [construir_windows.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src/scripts/construir_windows.py)

Source file: [empacotar.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src/scripts/empacotar.py)

Source file: [testar_llm_real.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src/scripts/testar_llm_real.py)

Source file: [verificar_interface.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src/scripts/verificar_interface.py)

Source file: [testar_gestao_real.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src/scripts/testar_gestao_real.py)

Additional real-model cases cover reports without writeoffs, partially reported amounts, an expired product at home, a product near expiration, a shelf report with missing details and an attempted prompt override. Each execution uses an isolated database and preserves original responses.

## Browser checks

Browser verification additionally requires Playwright 1.65.2 and its Chromium build. The same virtual-environment interpreter runs `-m pip install playwright==1.65.2` and `-m playwright install chromium`. The real-model scripts require an authorized Google account with access/quota. The code tests use isolated replacements; their outputs are not recorded as real inference.
