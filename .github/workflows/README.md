<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects">Repository</a></td>
</tr>
</table>

# Validation and distribution workflow

The ValidaMarket workflow checks Python 3.11 and 3.13 on Windows and Ubuntu for both source languages. The Windows job constructs the portable distribution from pinned official components and verifies the extracted BAT and browser interface. Automatic pushes run validation; publication requires a manual workflow execution with `publish` enabled or the explicit commit selector `Release: validamarket-e4-v1.0`. Both package formats are published only after successful verification. Existing releases and tags are not replaced.

Source file: [validamarket.yml](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/.github/workflows/validamarket.yml)

<details>
<summary>Workflow configuration</summary>

```yaml
name: ValidaMarket validation and distribution
on:
  push:
    branches: [main]
    paths:
      - 'English/Semester I/Prompt Engineering/**'
      - 'Português/Semestre I/Engenharia de Prompt/**'
      - '.github/workflows/validamarket.yml'
  workflow_dispatch:
    inputs:
      publish:
        description: Publish the validated first release (1.0)
        type: boolean
        default: false
permissions:
  contents: read
jobs:
  verify:
    strategy:
      fail-fast: false
      matrix:
        os: [windows-latest, ubuntu-latest]
        python: ['3.11', '3.13']
        source:
          - 'English/Semester I/Prompt Engineering/Practical Assignment/Delivery 04/src'
          - 'Português/Semestre I/Engenharia de Prompt/Trabalho Prático/Entrega 04/src'
    runs-on: ${{ matrix.os }}
    defaults:
      run:
        working-directory: ${{ matrix.source }}
    steps:
      - uses: actions/checkout@v7
      - uses: actions/setup-python@v7
        with:
          python-version: ${{ matrix.python }}
      - name: Test dependencies
        run: python -m pip install -r requirements.txt pytest==9.2.0
      - name: Application contracts
        run: python -m pytest -q tests
      - name: Clean startup
        run: python ci/verificar_inicio.py
  windows:
    needs: verify
    runs-on: windows-latest
    permissions:
      contents: write
    defaults:
      run:
        working-directory: Português/Semestre I/Engenharia de Prompt/Trabalho Prático/Entrega 04/src
    steps:
      - uses: actions/checkout@v7
      - uses: actions/setup-python@v7
        with:
          python-version: '3.13.17'
      - name: Portable package construction
        run: python scripts/construir_windows.py
      - name: Browser verification dependencies
        run: |
          python -m pip install playwright==1.65.2
          python -m playwright install chromium
      - name: Extracted package and browser verification
        env:
          VALIDAMARKET_UI_TEST: '1'
        run: python ci/verificar_portatil_windows.py
      - name: Complete source archive
        run: |
          python scripts/empacotar.py
          Copy-Item ../Entrega4_ValidaMarket.zip dist/Entrega4_ValidaMarket.zip
      - uses: actions/upload-artifact@v4
        with:
          name: ValidaMarket-current-package
          path: |
            Português/Semestre I/Engenharia de Prompt/Trabalho Prático/Entrega 04/src/dist/ValidaMarket_Windows_Portatil.zip
            Português/Semestre I/Engenharia de Prompt/Trabalho Prático/Entrega 04/src/dist/Entrega4_ValidaMarket.zip
            Português/Semestre I/Engenharia de Prompt/Trabalho Prático/Entrega 04/src/dist/ValidaMarket_Windows_Portatil.zip.sha256
            Português/Semestre I/Engenharia de Prompt/Trabalho Prático/Entrega 04/src/dist/validacao_portatil_windows.json
            Português/Semestre I/Engenharia de Prompt/Trabalho Prático/Entrega 04/src/dist/interface_portatil_windows.png
      - name: Current assignment publication
        if: (github.event_name == 'workflow_dispatch' && inputs.publish) || (github.event_name == 'push' && github.ref == 'refs/heads/main' && contains(github.event.head_commit.message, 'Release: validamarket-e4-v1.0'))
        env:
          GH_TOKEN: ${{ github.token }}
        run: python ci/publicar_release.py
```

</details>
