Set-StrictMode -Version Latest
$ErrorActionPreference = "Stop"
Set-Location $PSScriptRoot
mvn -q -DskipTests package
mvn -q -Dexec.mainClass=generated.salary.SalaryProcess exec:java
mvn -q -Dexec.mainClass=generated.invoicing.InvoicingProcess exec:java
mvn -q -Dexec.mainClass=generated.grading.GradingProcess exec:java
Write-Host "Done. Check runtime-java/out/."
