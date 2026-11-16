@echo off
setlocal
cd /d "%~dp0"
if exist "%~dp0_python\python.exe" (
    "%~dp0_python\python.exe" "%~dp0iniciar.py"
    if errorlevel 1 pause
    exit /b
)
where py >nul 2>nul
if %errorlevel% equ 0 (
    py -3 iniciar.py
) else (
    where python >nul 2>nul
    if errorlevel 1 (
        echo Execution requires Python 3.11 or later: https://www.python.org/downloads/windows/
        echo Python must be available on PATH.
        pause
        exit /b 1
    )
    python iniciar.py
)
if errorlevel 1 pause
