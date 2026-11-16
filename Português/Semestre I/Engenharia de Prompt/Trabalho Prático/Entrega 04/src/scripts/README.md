<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src/scripts">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Ferramentas de integração e distribuição

Os scripts registram testes de integração, verificam o fluxo no navegador, selecionam arquivos da aplicação e constroem o ZIP Windows com componentes oficiais fixados.


Arquivo fonte: [construir_windows.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/scripts/construir_windows.py)

Arquivo fonte: [empacotar.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/scripts/empacotar.py)

Arquivo fonte: [testar_llm_real.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/scripts/testar_llm_real.py)

Arquivo fonte: [verificar_interface.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/scripts/verificar_interface.py)

Arquivo fonte: [testar_gestao_real.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/scripts/testar_gestao_real.py)

Os casos adicionais com Gemini real abrangem relatório sem baixas, valores parcialmente informados, produto vencido em casa, produto próximo da validade, relato sem detalhes e tentativa de desvio das instruções. Cada execução utiliza banco isolado e preserva as respostas originais.

## Verificação pelo navegador

A verificação da interface requer também Playwright 1.65.2 e a versão Chromium correspondente. O mesmo interpretador do ambiente virtual utiliza os comandos `-m pip install playwright==1.65.2` e `-m playwright install chromium`. Os scripts com modelo real exigem conta Google autorizada e acesso/cota. Os testes de código utilizam substituições isoladas; suas saídas não são registradas como inferências reais.
