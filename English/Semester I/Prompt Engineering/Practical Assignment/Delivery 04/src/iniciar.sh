#!/bin/sh
cd "$(dirname "$0")" || exit 1
if command -v python3 >/dev/null 2>&1; then
    exec python3 iniciar.py
elif command -v python >/dev/null 2>&1; then
    exec python iniciar.py
else
    echo 'Execution requires Python 3.11 or later.' >&2
    exit 1
fi
