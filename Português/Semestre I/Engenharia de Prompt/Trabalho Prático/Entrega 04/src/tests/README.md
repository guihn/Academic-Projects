<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src/tests">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Testes determinísticos

A suíte verifica datas, validação dos campos, rotas HTTP, localização do cliente, limites da autorização, seleção dos pacotes e bloqueio da substituição de versões na publicação. Substituições isoladas permitem execução sem login Google.


Arquivo fonte: [test_app.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/tests/test_app.py)

Arquivo fonte: [test_connection.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/tests/test_connection.py)

Arquivo fonte: [test_delivery.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/tests/test_delivery.py)

Arquivo fonte: [test_google_login.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/tests/test_google_login.py)

`test_gestao.py` cobre confirmação e saldo de baixas, período inclusivo, valores desconhecidos, contrato P05 e acionamento condicional P06 → P04. Saídas controladas nesses testes não constituem evidência de IA real.

`test_revisao.py` cobre a seleção de porta pelo .env e a prioridade do ambiente, identificadores de extração, saídas P02/P03 inválidas, prazos permitidos, data mínima do calendário, fechamento de conexões, JSON excessivo e baixas simultâneas.

## Ambiente de verificação

Os testes de código requerem Python 3.11+ e pytest 9.2.0 em ambiente virtual. Na pasta `src`, `python -m venv .venv` cria o ambiente. No Windows, `.venv\Scripts\python.exe -m pip install -r requirements.txt pytest==9.2.0` instala as dependências de teste e `.venv\Scripts\python.exe -m pytest -q tests` executa a suíte. Nos demais sistemas, o caminho do interpretador é `.venv/bin/python`. Essas ferramentas são separadas da inicialização comum do portátil.
