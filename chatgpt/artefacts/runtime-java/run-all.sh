#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
mvn -q -DskipTests package
mvn -q -Dexec.mainClass=generated.salary.SalaryProcess exec:java
mvn -q -Dexec.mainClass=generated.invoicing.InvoicingProcess exec:java
mvn -q -Dexec.mainClass=generated.grading.GradingProcess exec:java
echo "Done. Check runtime-java/out/."
