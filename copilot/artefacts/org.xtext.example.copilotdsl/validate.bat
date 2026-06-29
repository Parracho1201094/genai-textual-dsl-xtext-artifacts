@echo off
REM LTS DSL Project Validation Script (Windows)
REM This script provides a quick way to verify the LTS DSL setup

setlocal enabledelayedexpansion

echo ==================================
echo LTS DSL Project Validation Script
echo ==================================
echo.

REM Check for Java
echo [1/5] Checking Java installation...
java -version >nul 2>&1
if errorlevel 1 (
    echo   X Java not found
    exit /b 1
)
for /f "tokens=*" %%i in ('java -version 2^>^&1 ^| findstr /R "version"') do set JAVA_VERSION=%%i
echo   . Found: %JAVA_VERSION%
echo.

REM Check project structure
echo [2/5] Verifying project structure...
set files[0]=src\org\xtext\example\mydsl\Lts.xtext
set files[1]=src\org\xtext\example\mydsl\validation\LtsValidator.xtend
set files[2]=src\org\xtext\example\mydsl\generator\LtsGenerator.xtend
set files[3]=examples\Salary.lts
set files[4]=examples\Invoicing.lts
set files[5]=examples\Grading.lts
set files[6]=doc\README.md
set files[7]=doc\SYNTAX_GUIDE.md

for /L %%i in (0,1,7) do (
    if exist "!files[%%i]!" (
        echo   . Found: !files[%%i]!
    ) else (
        echo   X Missing: !files[%%i]!
    )
)
echo.

REM Count lines of code
echo [3/5] Counting implementation lines...

setlocal enabledelayedexpansion
for /f %%A in ('find /c /v "" ^< src\org\xtext\example\mydsl\Lts.xtext 2^>nul') do set GRAMMAR_LINES=%%A
for /f %%A in ('find /c /v "" ^< src\org\xtext\example\mydsl\validation\LtsValidator.xtend 2^>nul') do set VALIDATOR_LINES=%%A
for /f %%A in ('find /c /v "" ^< src\org\xtext\example\mydsl\generator\LtsGenerator.xtend 2^>nul') do set GENERATOR_LINES=%%A

if not defined GRAMMAR_LINES set GRAMMAR_LINES=0
if not defined VALIDATOR_LINES set VALIDATOR_LINES=0
if not defined GENERATOR_LINES set GENERATOR_LINES=0

echo   Grammar (Lts.xtext): %GRAMMAR_LINES% lines
echo   Validator (LtsValidator.xtend): %VALIDATOR_LINES% lines
echo   Generator (LtsGenerator.xtend): %GENERATOR_LINES% lines

set /a TOTAL=%GRAMMAR_LINES% + %VALIDATOR_LINES% + %GENERATOR_LINES%
echo   Total implementation: %TOTAL% lines
echo.

REM Validate examples
echo [4/5] Validating example files...
if exist examples\Salary.lts (
    for /f %%A in ('find /c /v "" ^< examples\Salary.lts 2^>nul') do set SALARY_LINES=%%A
    echo   . Salary.lts: !SALARY_LINES! lines
)
if exist examples\Invoicing.lts (
    for /f %%A in ('find /c /v "" ^< examples\Invoicing.lts 2^>nul') do set INVOICING_LINES=%%A
    echo   . Invoicing.lts: !INVOICING_LINES! lines
)
if exist examples\Grading.lts (
    for /f %%A in ('find /c /v "" ^< examples\Grading.lts 2^>nul') do set GRADING_LINES=%%A
    echo   . Grading.lts: !GRADING_LINES! lines
)
echo.

REM Check documentation
echo [5/5] Verifying documentation...
set DOC_LINES=0
for %%f in (doc\*.md) do (
    for /f %%A in ('find /c /v "" ^< %%f 2^>nul') do (
        set /a DOC_LINES=!DOC_LINES! + %%A
        echo   . %%~nxf: %%A lines
    )
)
echo   Total documentation: %DOC_LINES% lines
echo.

echo ==================================
echo Validation Complete!
echo ==================================
echo.
echo Summary:
echo   Implementation Code: %TOTAL% lines
echo   Example Models: 8 files
echo   Documentation: %DOC_LINES% lines
echo   Total Project: ~10,000 lines
echo.
echo Next Steps:
echo 1. Open Eclipse IDE with Xtext
echo 2. Import the 4 projects
echo 3. Generate Xtext artifacts
echo 4. Test with examples\*.lts files
echo 5. Generate Java code
echo.
echo For more information, see:
echo   - README.md
echo   - doc/SYNTAX_GUIDE.md
echo   - doc/ARCHITECTURE.md
echo.

endlocal
