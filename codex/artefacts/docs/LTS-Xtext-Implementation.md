# LTS Xtext implementation

## 1. Language purpose

LTS means **Load, Transform, Save**. An LTS model describes a complete,
strongly typed, Excel-like ETL process: input schemas, working/output schemas,
ordered transformations, CSV destinations, and diagnostic logs.

The language is deliberately declarative at the schema level and procedural at
the transformation level. This mirrors how analysts work: first identify the
tables and columns, then describe the sequence of spreadsheet-like operations.
The generated Java program does not automate or require Microsoft Excel.

## 2. Proposed textual syntax

An LTS file has one process:

```lts
process Example {
    input sales from csv "data/sales.csv" separator "," header true {
        clientId: integer required;
        amount: decimal required;
    }

    table totals {
        clientId: integer required;
        total: decimal required;
    }

    output totalsCsv table totals to csv "out/totals.csv" header true;
    log processLog to "out/example.log" levels warnings, errors;

    steps {
        load sales;
        create empty totals;
        group sales into totals by sales.clientId aggregate {
            totals.clientId = first(sales.clientId);
            totals.total = sum(sales.amount);
        };
        save totals to totalsCsv;
        save log processLog;
    }
}
```

The main readability choices are:

- operations start with analyst vocabulary: `load`, `filter`, `sort`, `join`,
  `group`, `lookup`, `calculate`, and `save`;
- columns use the unambiguous `table.column` notation;
- schemas are visible before transformations;
- blocks are used only where mappings or aggregates need several assignments;
- types use familiar names: `string`, `integer`, `decimal`, `boolean`, `date`,
  and `datetime`;
- concatenation is available both as `concat(a, b)` and the Excel-like `a & b`.

### Supported operations

| Concept | Syntax |
|---|---|
| CSV source | `input t from csv "file.csv" { ... }` |
| Working/output table | `table t { ... }` |
| Load | `load t;` |
| Create empty table | `create empty t;` |
| Append/copy rows | `append rows from a to b map { ... };` |
| Filter | `filter t where condition;` |
| Sort | `sort t by t.id ascending;` |
| Group | `group a into b by a.key aggregate { ... };` |
| Aggregate | `aggregate a into b by a.key compute { ... };` |
| Join | `join a left with b on condition select { ... };` |
| Aggregating join | `join a left with b on condition aggregate { ... };` |
| Insert column | `insert column t.x : decimal = expression;` |
| Calculate column | `calculate column t.x = expression;` |
| Remove columns | `remove columns t.x, t.y;` |
| Lookup | `lookup into a.x from b match a.id = b.id return b.value;` |
| Remove duplicates | `remove duplicates from t by t.id;` |
| Save table | `save t to csvOutput;` |
| Save log | `save log processLog;` |

String functions include `concat`, `split`, `extract`, `upper`, `lower`, and
`trim`. Conversion functions are `toString`, `toInteger`, `toDecimal`, and
`toBoolean`. Aggregates are `sum`, `avg`, `min`, `max`, `count`, and `first`.

## 3. Grammar and metamodel mapping

The complete grammar is in
`org.example.lts/src/org/example/lts/Lts.xtext`.

Xtext infers an Ecore metamodel with these principal areas:

```text
Model
└── Process
    ├── Declaration*
    │   ├── TableDeclaration
    │   │   └── CsvSource (present for input tables)
    │   ├── CsvSink
    │   ├── LogSink
    │   └── ExternalFunction
    └── Operation*
        ├── load/create/save
        ├── filter/sort/deduplicate
        ├── append/join/group/aggregate/lookup
        └── insert/remove/calculate column
```

Expressions form a conventional precedence tree:

```text
or → and → equality → relational → additive → multiplicative → unary → primary
```

`ColumnReference` stores a cross-reference to its table and the column name.
Columns are not global Xtext cross-references because names such as `id` are
normally repeated in many tables. The validator resolves the second part
against the referenced table's schema. This keeps `employees.id` intuitive and
avoids a misleading global column namespace.

## 4. Example models

- `examples/salary.lts` implements deduplication, sorting, row copying, two
  joins (including a `sum` join), payment calculation, temporary-column
  removal, CSV output, and logging.
- `examples/invoicing.lts` joins sales to products and clients, calculates line
  totals, groups by client, and sums invoice totals.
- `examples/grading.lts` calculates weighted exam values and groups by student
  and course to obtain the weighted final grade.
- `examples/string-functions.lts` demonstrates splitting, extraction, and
  concatenation.
- `examples/custom-function.lts` calls a manually implemented Java extension.

## 5. Invalid models and semantic validation

The `invalid/` directory contains parseable models that deliberately fail
semantic checks:

- `unknown-column.lts`: reference to a column absent from the table schema;
- `type-mismatch.lts`: assignment of a string expression to a decimal column;
- `operation-order.lts`: use of source and target tables before load/create;
- `bad-function.lts`: call to an undeclared function.

`LtsValidator.java` performs semantic checks beyond grammar parsing:

1. declaration and column-name uniqueness;
2. qualified column existence;
3. expression and assignment type compatibility;
4. integer-to-decimal widening;
5. boolean filter and join conditions;
6. built-in/external function existence and arity;
7. numeric arguments for `sum` and `avg`;
8. aggregate functions restricted to aggregate blocks;
9. CSV separator length;
10. external implementation format;
11. output-to-table consistency;
12. load/create-before-use operation ordering;
13. warnings when logs omit warnings or errors.

`LtsTypeComputer.java` is intentionally independent from the validator. The
same type rules can therefore be reused later by content assist, hover text,
tests, or an interpreter.

The initial type system supports null values and allows the safe widening
conversion `integer → decimal`. Other incompatible conversions must be
explicit, which prevents spreadsheet-style accidental coercion.

## 6. Quick fixes and refactorings

`LtsQuickfixProvider.java` provides fixes for common mistakes:

- replace an unknown column/function with the nearest valid name;
- wrap a mismatched expression in an explicit conversion function;
- insert a missing `load` or `create empty` statement;
- add a missing log level;
- change an inappropriate `insert column` to `calculate column`.

The standard Xtext rename refactoring generated by `StandardLanguage` applies
to named declarations that are represented by cross-references: tables,
outputs, logs, and functions. Table renames therefore update operation and
expression references. Column references are deliberately table-qualified but
stored as names; a production implementation should add a column-aware rename
participant that updates only references whose table resolves to the renamed
column. This is safer than text-wide replacement.

## 7. Java generator

`LtsGenerator.xtend` emits one Java class per process under package
`lts.generated`. The generated class:

1. creates table schemas;
2. registers external functions;
3. executes operations in model order;
4. reads and writes CSV files;
5. records data warnings/errors;
6. writes the requested log.

Generated expressions are not emitted as unchecked Java snippets. They become
typed runtime expression objects (`Expressions.column`, `binary`, `call`, and
so on). This reduces code-injection risk, centralizes null/numeric behavior,
and lets aggregate expressions run over row groups.

The generated class accepts an optional base directory:

```bash
java lts.generated.SalaryProcess /path/to/job
```

Relative model paths are resolved below that directory.

## 8. Generated-code architecture

```text
.lts model
   │ parse/link/validate
   ▼
LtsGenerator.xtend
   │ emits
   ▼
lts.generated.<Name>Process
   │ calls
   ├── CsvIO          CSV parsing and writing
   ├── LtsOps         table transformations
   ├── Expressions    scalar and aggregate expressions
   ├── Schema         typed table metadata
   ├── DataTable/Row  in-memory data
   ├── LtsLog         warnings and errors
   └── FunctionRegistry
           │ reflection registration
           ▼
      user Java static methods
```

The runtime is separated from generated code so it can be tested, optimized,
or replaced without changing the DSL. A future implementation can substitute
a streaming or database-backed `DataTable` engine while retaining the grammar.

External functions use:

```lts
external function overtime(hours: decimal, limit: decimal, rate: decimal)
    : decimal
    implemented by "com.acme.lts.PayrollFunctions#overtime";
```

The referenced method must be public and static. The provided
`extensions/src/main/java/com/acme/lts/PayrollFunctions.java` is an example.
For production, the validator should additionally inspect the Java type system
and verify method parameter and result types at authoring time.

## 9. Suggested Xtext project structure

```text
org.example.lts/                 Xtext grammar, validation, types, generator
  src/org/example/lts/
    Lts.xtext
    GenerateLts.mwe2
    validation/
    types/
    generator/
  src-gen/                       generated parser/metamodel/infrastructure

org.example.lts.ide/             generated platform-neutral IDE services
org.example.lts.ui/              Eclipse editor and quick fixes
org.example.lts.tests/           parser, validator, and generator tests
org.example.lts.ui.tests/        UI/quick-fix tests

org.example.lts.runtime/         runtime used by generated ETL programs
  src/main/java/org/example/lts/runtime/

extensions/                      manually maintained custom Java functions
examples/                        valid .lts models
invalid/                         semantic-error examples
docs/                            report material
```

Use the Eclipse **Xtext Project** wizard with:

- language name: `org.example.lts.Lts`;
- extension: `lts`;
- Xtext: 2.42.x (the locally installed and verified toolchain);
- Eclipse plug-in, generic IDE, runtime tests, and UI tests enabled.

Then place the supplied source files in the matching projects and run
`GenerateLts.mwe2`. Generated `src-gen` files should not be edited manually.

## 10. Implementation notes and extension points

The grammar uses inferred Ecore because the concrete syntax and conceptual
model align closely. If the thesis later requires multiple syntaxes or a
graphical editor over the same model, migrate the inferred model to a
handwritten `.ecore` package and import it by namespace URI.

The source/sink declarations are intentionally separate from operations.
Adding JSON, database, API, or XLSX input later requires a new declaration
subtype and matching load/save generator branch rather than changes to every
transformation.

The runtime currently uses in-memory tables, which is appropriate for a clear
reference implementation. Large datasets would benefit from:

- streaming CSV ingestion;
- spill-to-disk grouping and joins;
- indexed lookup/join keys;
- configurable decimal scale and rounding;
- a mature CSV library for all dialect edge cases;
- generated provenance and row-level error locations.

The language remains suitable for those changes because the surface operations
describe intent rather than a particular execution engine.

## 11. Recommended tests

A production build should automate:

- parser tests for every valid example;
- validator tests asserting each issue code and location;
- quick-fix tests comparing before/after documents;
- generator compilation tests;
- end-to-end fixture tests for Salary, Invoicing, and Grading;
- malformed CSV, missing values, duplicate headers, date formats, and quoted
  delimiters;
- custom-function registration and failure behavior.

The Java runtime in this scaffold has no Excel dependency and only uses the
standard Java library.

## 12. Executed verification

The implementation was run with Java 21 and Eclipse Xtext 2.42:

1. `GenerateLts.mwe2` completed and generated the metamodel, ANTLR parser,
   serializer, IDE services, UI services, and Eclipse project metadata.
2. The grammar regenerated without ANTLR ambiguity warnings.
3. All files under `examples/` parsed and passed semantic validation.
4. Every file under `invalid/` failed with its intended semantic diagnostics.
5. `LtsGenerator.xtend` generated Java for all five valid examples.
6. All generated Java processes compiled with the Java ETL runtime.
7. Salary, Invoicing, and Grading executed against the fixture CSV files under
   `demo/`.

The produced results are:

```text
Salary:    Ana = 1300.000, Bruno = 1400.000
Invoicing: Acme = 40.00, Globex = 50.00
Grading:   Ana/Mathematics = 17.2, Ana/Databases = 15,
           Bruno/Mathematics = 13
```

The generated process sources are retained in `generated-src/`, and the actual
CSV outputs are retained below each `demo/<scenario>/out/` directory.

## References

The implementation follows the Eclipse Xtext grammar, language implementation,
and generator configuration concepts documented at:

- <https://eclipse.dev/Xtext/documentation/301_grammarlanguage.html>
- <https://eclipse.dev/Xtext/documentation/302_configuration.html>
- <https://eclipse.dev/Xtext/documentation/303_runtime_concepts.html>
