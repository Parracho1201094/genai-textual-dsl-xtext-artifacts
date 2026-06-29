# Evidence to include in the ENORM LTS report

Use these concise evidence items for the Xtext/textual part of the report.

## Parsing

Show the three example models under `examples/` opening in the Xtext editor without syntax errors:

- `salary.lts`
- `invoicing.lts`
- `grading.lts`

## Validation

Include screenshots or test output for:

- duplicate table names;
- duplicate column names;
- invalid `.csv` path extension;
- join columns with incompatible types;
- aggregation over a non-numeric column;
- dropping an unknown column;
- using a table before it is declared.

## Generation

Show generated Java equivalent to the files under:

- `runtime-java/src/main/java/generated/salary/SalaryProcess.java`
- `runtime-java/src/main/java/generated/invoicing/InvoicingProcess.java`
- `runtime-java/src/main/java/generated/grading/GradingProcess.java`

## Execution

Run the runtime demo and include the generated files under `runtime-java/out/` as execution evidence.
