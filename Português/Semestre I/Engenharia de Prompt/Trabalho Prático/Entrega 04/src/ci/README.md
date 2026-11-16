<table width="100%">
<tr>
<td align="left" width="5000"><strong>Português</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src/ci">English</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs">Índice</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src">Pasta&nbsp;anterior</a></td>
</tr>
</table>

# Verificação automatizada

As verificações cobrem inicialização limpa, localização do cliente Google, edição dos dados e execução do ZIP extraído no Windows. O script de publicação disponibiliza o pacote validado.


Arquivo fonte: [publicar_release.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/ci/publicar_release.py)

Arquivo fonte: [verificar_cliente_windows.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/ci/verificar_cliente_windows.py)

Arquivo fonte: [verificar_consistencia_interface.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/ci/verificar_consistencia_interface.py)

Arquivo fonte: [verificar_inicio.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/ci/verificar_inicio.py)

Arquivo fonte: [verificar_portatil_windows.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/ci/verificar_portatil_windows.py)

A publicação depende da opção manual explícita `publish` do workflow. Uma versão preexistente interrompe o script de release; nenhuma release, tag ou branch é excluída.
