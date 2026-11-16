<table width="100%">
<tr>
<td align="left" width="5000"><strong>English</strong> | <a href="https://github.com/guihn/Academic-Projects/tree/main/Portugu%C3%AAs/Semestre%20I/Engenharia%20de%20Prompt/Trabalho%20Pr%C3%A1tico/Entrega%2004/src/tests">Português</a></td>
<td align="right" width="5000"><a href="https://github.com/guihn/Academic-Projects/tree/main/English">Index</a> | <a href="https://github.com/guihn/Academic-Projects/tree/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src">Parent&nbsp;folder</a></td>
</tr>
</table>

# Deterministic tests

The test suite checks dates, input validation, HTTP routes, client discovery, account boundaries, package selection and prevention of replacement of existing releases. Isolated substitutes make these tests independent of Google sign-in.


Source file: [test_app.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src/tests/test_app.py)

Source file: [test_connection.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src/tests/test_connection.py)

Source file: [test_delivery.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src/tests/test_delivery.py)

Source file: [test_google_login.py](https://github.com/guihn/Academic-Projects/raw/refs/heads/main/English/Semester%20I/Prompt%20Engineering/Practical%20Assignment/Delivery%2004/src/tests/test_google_login.py)

`test_gestao.py` covers writeoff confirmation and balances, inclusive date periods, unknown monetary values, P05 contracts and conditional P06 → P04 routing. Controlled model outputs in these tests are not real-model evidence.

`test_revisao.py` covers .env port selection and environment precedence, extraction identifiers, malformed P02/P03 outputs, permitted deadlines, the minimum calendar date, connection closure, oversized JSON requests and simultaneous writeoffs.

## Verification environment

Code checks require Python 3.11+ and pytest 9.2.0 in a virtual environment. From `src`, `python -m venv .venv` creates the environment. On Windows, `.venv\Scripts\python.exe -m pip install -r requirements.txt pytest==9.2.0` installs the test dependencies and `.venv\Scripts\python.exe -m pytest -q tests` runs the suite. On other systems, the interpreter path is `.venv/bin/python`. These tools are separate from ordinary portable startup.
