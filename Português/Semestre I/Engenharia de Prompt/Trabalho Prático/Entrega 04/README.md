<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Entrega 04 · ValidaMarket

## Descrição

O ValidaMarket auxilia o controle de validade em supermercados. A descrição de um lote informa produto, identificador, validade completa, quantidade, setor e conservação. Seis prompts do Gemini extraem os dados, classificam a proximidade do vencimento, propõem uma ação e geram um alerta local. A conferência dos campos e a aprovação da ação estabelecem o controle humano entre as chamadas ao modelo.

## Resumo do enunciado

A quarta entrega do trabalho prático exige um protótipo funcional com chamada a LLM em tempo de execução, código no GitHub e testes registrados. O escopo implementado corresponde ao controle de validade da entrega prática anterior. F01–F08 abrangem cadastro e conferência, extração, classificação, recomendação, aprovação e alerta, histórico, relatório semanal de perdas e atendimento ao cliente. Importação CSV e envio externo permanecem fora do escopo implementado.

## Solução

P01 extrai dados estruturados para conferência. P02 recebe o lote e a classificação calculada por Python, devolve os campos e explica a faixa aplicada. O programa valida novamente os campos retornados. P03 propõe uma ação para lotes que exigem atenção. P04 gera o alerta após aprovação explícita. Lotes OK permanecem em monitoramento, sem P03/P04. O SQLite registra análises, aprovações, baixas declaradas, relatórios e atendimentos; a exportação JSON disponibiliza os logs. P05 resume os sete dias encerrados na referência. P06 responde dúvidas sobre validade e aciona P04 para solicitar conferência de relatos de vencidos na gôndola.

A aplicação funciona localmente com a conta Google do executor autorizada no Antigravity CLI oficial. Senhas e tokens de autenticação são gerenciados pelo cliente oficial. O programa não aplica descontos, não descarta produtos e não envia mensagens externas.

## Prompts e técnicas utilizadas

O elemento central do trabalho é o conjunto de instruções que transforma a descrição de um lote em dados estruturados, avaliação por validade, recomendação e alerta. Cada prompt possui um contrato de entrada, um formato de saída esperado e restrições à invenção de informações ou à execução de ações sem aprovação.

| Prompt | Técnica | Finalidade e controle |
| --- | --- | --- |
| P01 | Exemplos few-shot e JSON estruturado | Extração dos campos do lote; valores ausentes ou ambíguos permanecem null para validação. |
| P02 | Regras explícitas, exemplos de limites e saída restrita | Classificação e justificativa apoiadas no cálculo Python, com exemplos de limites e validação da saída. |
| P03 | Role prompting e regras condicionais | Recomendação conforme o risco, com tratamento obrigatório dos vencidos e aprovação humana. |
| P04 | Template de comunicação | Alerta após aprovação ou solicitação de conferência de relato na gôndola. |
| P05 | Role prompting com dados agregados | Baixas semanais por produto/setor, hipóteses e medidas preventivas. |
| P06 | Role prompting e guardrails | Orientação sobre validade sem inventar dados; P04 para relato de vencido na gôndola. |

O encadeamento fornece a extração conferida a P02, o risco calculado a P03 e a ação aprovada a P04. A conferência humana separa extração e análise; a aprovação precede o alerta. Os [arquivos de prompts](https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/prompts) contêm as instruções completas. Os registros de execução documentam respostas do modelo, falhas de extração e repetições corrigidas.

## Execução

O pacote portátil requer Windows 10/11 de 64 bits, navegador, internet e conta Google com acesso/cota para o modelo. Python, bibliotecas e cliente oficial estão incluídos. A interface do portátil está em português.

### Inicialização portátil

Após a extração do ZIP inteiro, `ValidaMarket_Windows/Iniciar.bat` inicia `iniciar.py` com o Python incluído e abre `http://127.0.0.1:5000`. A janela mantém o servidor ativo; `Ctrl+C` encerra o programa.

O botão `Login Google` abre o cliente oficial em um terminal local. A autorização ocorre no navegador com a conta Google selecionada. Após o login, o cliente pode ser fechado e o botão `Verificação da conexão` confirma o acesso ao Gemini pela aplicação. O comando `/logout` encerra uma sessão existente no cliente oficial. As credenciais permanecem na conta do sistema operacional, fora do pacote.

### Execução pelo código-fonte

A alternativa de código-fonte requer Python 3.11+ e Antigravity CLI oficial. Na pasta `src`, `python iniciar.py` cria o ambiente virtual local, instala `requirements.txt` e abre o navegador. Sistemas com o comando `python3` utilizam o equivalente `python3 iniciar.py`. As chaves JSON, classificações e opções de armazenamento permanecem fixas entre as versões dos idiomas.

### Análise de lotes

A descrição completa informa produto, lote, validade, quantidade, setor e armazenamento. A referência aceita entrada numérica em dd/mm/aaaa ou seleção pelo calendário. A extração apresenta campos editáveis; a confirmação inicia classificação e recomendação. A aprovação gera o alerta local. Alterações na entrada invalidam os resultados anteriores. Histórico e download JSON permanecem disponíveis na página.

Referência do exemplo: **15/11/2026**.

```text
Iogurte natural 170g, lote IG-5521, validade 18/11/2026, 36 unidades, gôndola refrigerados, refrigerado.
```

### Baixas, relatório semanal e atendimento

Uma análise aprovada com saldo disponível pode receber um registro de baixa. Quantidade, motivo e confirmação da movimentação física já realizada são obrigatórios; o valor total é opcional. O programa limita a quantidade ao saldo daquela análise. Análises repetidas do mesmo lote são registros separados e não devem ser tratadas como estoque adicional.

O relatório semanal considera os sete dias encerrados na referência, incluindo os dois extremos. Os totais são calculados por Python a partir dos eventos registrados; P05 apresenta síntese, hipóteses de causas e medidas preventivas. Baixas sem valor informado aparecem separadamente; ausência de valor não significa perda zero. A geração ocorre sob demanda, com histórico e exportação JSON.

O atendimento utiliza a mesma referência. P06 responde à pergunta sem solicitar dados pessoais. O relato de produto vencido exposto à venda aciona P04 para solicitar conferência em alerta local; dúvidas gerais não geram esse alerta. O relato não comprova o vencimento nem executa retirada física.

O ZIP de fontes inclui testes, scripts de integração e evidências, além dos arquivos de execução. O ZIP portátil Windows contém somente os arquivos de execução e os componentes oficiais incluídos. Ambos excluem o documento acadêmico e os dados pessoais.

### Configuração e diagnóstico

`GEMINI_MODEL` seleciona o modelo; `ANTIGRAVITY_BIN` identifica o executável do cliente; `VALIDAMARKET_PORT` seleciona a porta local. Um `.env` local pode conter essas opções, sem credenciais. O modelo padrão é `gemini-3.8-flash-low`.

Uma porta ocupada exige outra porta disponível ou encerramento da instância anterior. A ausência de acesso ao modelo, cota ou autorização produz uma mensagem de erro. O cliente portátil fica em `cliente_google/agy.exe`; a execução pelo código-fonte localiza `agy` na configuração ou no sistema.

## Conteúdo do projeto

| Seção | Conteúdo |
| --- | --- |
| [Arquivos fonte](https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src) | Aplicação, interface, prompts e testes. |
| [Execução](https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004#execu%C3%A7%C3%A3o) | Requisitos, inicialização e autorização Google, descritos nesta página. |
| [Explicação do código](https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004#c%C3%B3digo-da-aplica%C3%A7%C3%A3o) | Funções, rotas, dados e cadeia de prompts, documentados nesta página. |
| [Evidências](https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/evidencias) | Logs de inferência, relatórios e capturas de tela. |

ZIP portátil: `ValidaMarket_Windows_Portatil.zip`, distribuído separadamente do relatório acadêmico.

## Integrantes

- Guilherme Henrique Moura dos Santos
- Davi Gomes Junqueira Silva
- Gustavo Rafael Atanásio dos Santos
- Gabriel Gonçalves Fialho


## Código da aplicação

A implementação utiliza quatro módulos Python para coordenar a inicialização, a análise dos lotes e a comunicação com o Gemini:

- `iniciar.py` prepara o ambiente Python, inicia o servidor local e abre o navegador.
- `app.py` encadeia os prompts, valida os dados e o cálculo de datas, recebe a aprovação e grava o histórico.
- `gestao.py` valida baixas declaradas, períodos de sete dias e contratos de relatório/atendimento; valores monetários usam centavos inteiros.
- `google_login.py` localiza o cliente oficial Google, abre a autorização da conta e solicita respostas estruturadas ao modelo.

Os módulos fornecem o suporte de software para a cadeia de prompts. Suas responsabilidades e interações estão descritas a seguir; os arquivos de implementação permanecem disponíveis em src. As instruções dos prompts, as restrições das respostas e sua avaliação constituem o foco do trabalho.

### Estrutura do programa

O navegador envia JSON ao Flask. O servidor chama o Gemini pelo cliente oficial, confere os dados e grava registros no SQLite local. Os arquivos em src constituem a aplicação; o Python incluído e agy.exe são componentes de terceiros.

### Inicialização: iniciar.py

main() carrega as opções permitidas do .env antes de verificar Python e a porta local; variáveis existentes no ambiente têm prioridade. O portátil utiliza _python/python.exe; o código-fonte cria .venv e instala requirements.txt quando o hash do arquivo muda. O inicializador abre app.py, aguarda /api/status e abre o navegador. Ctrl+C encerra o servidor filho.

### Fluxo: app.py

pipeline() primeiro chama P01 e registra um identificador de extração. A confirmação humana devolve o lote conferido e o identificador. Mudanças na descrição ou referência exigem outra extração. reference() calcula os dias restantes e a classificação da política. P02 recebe esses valores em calculo_conferido e os devolve com uma justificativa; divergências continuam bloqueadas. P03 fornece a ação quando o status não é OK. approve() gera P04 somente após aprovação explícita.


A confirmação exige um identificador válido de extração. P02 deve coincidir com o cálculo Python, e P03 deve retornar uma data completa dentro do intervalo permitido. As conexões SQLite são fechadas após as transações. Entradas acima do limite recebem erro HTTP 413 em JSON.

### Campos e datas

validate_lot() exige quantidade inteira positiva, datas completas, armazenamento conhecido e os campos esperados. Categoria pode ser null. As datas usam aaaa-mm-dd internamente. Os valores ambiente, refrigerado e congelado são literais do contrato. Dias negativos significam VENCIDO. Refrigerados/congelados são CRÍTICO até 3 dias e ATENÇÃO até 7; ambiente utiliza 15 e 45 dias. Valores superiores são OK.

### Cliente Google: google_login.py

executable() localiza o cliente na configuração, no portátil, no PATH ou nos diretórios usuais. open_login() abre um terminal local. generate() fornece prompt e JSON Schema por subprocess.run(shell=False), com limite de 100 segundos para o processo e 90 segundos para o cliente. O uso de ferramentas é bloqueado e um diretório temporário isola a inferência. Somente campos de resposta e uso são exportados; tokens da conta permanecem no cliente oficial.

### Comportamento da página: static/app.js

api() centraliza fetch e erros HTTP. busy() bloqueia controles durante solicitações. extractLot(), buildFields(), confirmLot() e approveAction() correspondem ao fluxo principal. referenceDateISO() valida a data numérica e sincroniza o calendário nativo. Edições invalidam resultados antigos. render(), history(), renderReport() e renderService() apresentam os dados com textContent. downloadJSON() exporta análises, relatórios e atendimentos. managementHistory() carrega os eventos anteriores.

### Regras de baixa: gestao.py

writeoff() exige declaração explícita de movimentação física realizada, quantidade inteira positiva dentro do saldo do registro, motivo e data válida. O valor opcional é lido como decimal e armazenado em centavos inteiros; a ausência permanece desconhecida. Uma transação SQLite impede baixas simultâneas superiores ao saldo de um mesmo registro.

aggregate() seleciona a janela inclusiva de sete dias e agrupa baixas efetivas por produto e setor. Análises, aprovações e relatos possuem contagens separadas. validate_report() e validate_service() rejeitam saídas P05/P06 malformadas antes da gravação. report() envia os totais calculados a P05; service() chama P06 e, condicionalmente, P04, preservando os rastros originais.

### Armazenamento e logs

database() cria extracoes, registros, baixas, relatorios e atendimentos em dados.sqlite3. Valores chegam ao SQL por parâmetros ?. O JSON da extração registra entrada, referência e trace; o JSON da análise inclui lote, risco, ação, alerta e aprovação. llm() registra prompt, horários, resposta do modelo e erros. normalize_alert() remove um invólucro JSON duplicado sem alterar a resposta bruta do trace.

### Verificação e distribuição

tests cobre contratos locais sem inferência. scripts/testar_llm_real.py registra lotes com o modelo real; scripts/verificar_interface.py verifica o fluxo no navegador; scripts/testar_gestao_real.py registra relatórios e atendimentos adicionais com Gemini real. ci verifica inicialização limpa e o pacote Windows extraído. scripts/empacotar.py seleciona o projeto completo e detecta padrões de credenciais; source_files() fornece a seleção menor utilizada pelo portátil. scripts/construir_windows.py confere hashes do Python e do cliente Google oficiais e instala bibliotecas dentro do ZIP. ci/publicar_release.py publica somente após solicitação manual explícita no workflow, com credencial temporária do Actions. Releases e tags existentes não são excluídas nem substituídas. Essas ferramentas não participam da análise comum de um lote.

### Rotas HTTP

| Rota | Finalidade |
| --- | --- |
| `/` | Página |
| `/api/status` | Estado do cliente e da conexão |
| `/api/conexao/entrar` | Login no cliente oficial |
| `/api/conexao/verificar` | Verificação de acesso ao modelo |
| `/api/analisar` | Extração ou análise confirmada |
| `/api/aprovar/<id>` | Aprovação e alerta |
| `/api/historico` | Últimas 100 análises e saldos dos registros |
| `/api/baixas/<id>` | Registro de baixa física já realizada |
| `/api/relatorios` | Agregação semanal e relatório P05 |
| `/api/atendimento` | Orientação P06 e eventual alerta P04 |
| `/api/gestao` | Histórico de baixas, relatórios e atendimentos |

## Auxílio de IA

O desenvolvimento do protótipo e a elaboração dos prompts e da documentação desta entrega contaram com auxílio de ferramentas de inteligência artificial.
