#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
rm -rf target/classes
mkdir -p target/classes
find src/main/java -name '*.java' > target/sources.txt
javac -d target/classes @target/sources.txt
java -cp target/classes generated.salary.SalaryProcess
java -cp target/classes generated.invoicing.InvoicingProcess
java -cp target/classes generated.grading.GradingProcess
echo "Done. Check runtime-java/out/."
