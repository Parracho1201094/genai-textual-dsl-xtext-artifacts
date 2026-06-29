Set-StrictMode -Version Latest
$ErrorActionPreference = "Stop"
Set-Location $PSScriptRoot
Remove-Item -Recurse -Force target/classes -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Force target/classes | Out-Null
Get-ChildItem -Recurse src/main/java -Filter *.java | ForEach-Object { $_.FullName } | Set-Content target/sources.txt
javac -d target/classes '@target/sources.txt'
java -cp target/classes generated.salary.SalaryProcess
java -cp target/classes generated.invoicing.InvoicingProcess
java -cp target/classes generated.grading.GradingProcess
Write-Host "Done. Check runtime-java/out/."
