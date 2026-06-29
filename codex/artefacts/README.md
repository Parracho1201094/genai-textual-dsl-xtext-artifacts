# LTS — Load, Transform, Save

This repository is a concrete Eclipse Xtext design for an Excel-oriented ETL
language. It contains:

- the complete Xtext grammar;
- valid Salary, Invoicing, Grading, string, and extension examples;
- intentionally invalid models;
- semantic validation and quick fixes;
- an Xtend-to-Java generator;
- a Java runtime that executes generated processes without Excel;
- an implementation report and proposed project structure.

Start with [docs/LTS-Xtext-Implementation.md](docs/LTS-Xtext-Implementation.md).

## Main files

- `org.example.lts/src/org/example/lts/Lts.xtext`
- `org.example.lts/src/org/example/lts/validation/LtsValidator.java`
- `org.example.lts.ui/src/org/example/lts/ui/quickfix/LtsQuickfixProvider.java`
- `org.example.lts/src/org/example/lts/generator/LtsGenerator.xtend`
- `org.example.lts.runtime/src/main/java/org/example/lts/runtime/`
- `examples/`
- `invalid/`

The language was generated and executed with the locally installed Xtext 2.42
toolchain. Run `GenerateLts.mwe2` after grammar changes.

## Verified execution

The Xtext workflow, standalone validator, Xtend generator, generated Java, and
ETL runtime were executed end to end. Generated Java is under `generated-src/`.
Fixture inputs and resulting CSV/log files are under `demo/`.

Observed outputs:

- Salary: Ana `1300.000`, Bruno `1400.000`
- Invoicing: Acme `40.00`, Globex `50.00`
- Grading: `17.2`, `15`, and `13`

The standalone entry point used for validation and generation is
`org.example.lts.cli.LtsCli`.
