# LTS DSL – Xtext Implementation
## ENORM Project · Master in Informatics Engineering 2023/2024

---

## Quick-start

```bash
# 1. Install Eclipse for Java and DSL Developers (2023-09+)
# 2. Install Xtext via Eclipse Marketplace

# 3. Create new Xtext project in Eclipse:
#      File → New → Xtext Project
#      Grammar name : org.lts.LTS
#      Extension    : lts

# 4. Copy grammar/LTS.xtext → org.lts/src/org/lts/LTS.xtext
# 5. Right-click LTS.xtext → Run As → Generate Xtext Artifacts

# 6. Copy src/* into the generated project's source folders:
#      src/validation/ → org.lts plugin
#      src/generator/  → org.lts plugin
#      src/quickfix/   → org.lts.ui plugin

# 7. Launch nested Eclipse → open any .lts file
```

---

## Repository layout

```
lts-xtext/
│
├── README.md                          ← this file
│
├── grammar/
│   └── LTS.xtext                      ← FULL Xtext grammar
│
├── models/
│   ├── valid/
│   │   ├── salary.lts                 ← Case 1 – Salary
│   │   ├── invoicing.lts              ← Case 2 – Invoicing
│   │   └── grading.lts                ← Case 3 – Grading
│   └── invalid/
│       └── invalid_examples.lts       ← 10 documented validation errors
│
├── src/
│   ├── validation/
│   │   └── LTSValidator.xtend         ← 14 semantic @Check rules
│   ├── quickfix/
│   │   └── LTSQuickfixProvider.xtend  ← 8 @Fix quick-fix refactorings
│   └── generator/
│       └── LTSGenerator.xtend         ← Xtend code generator → Java
│
└── report/
    └── REPORT.md                      ← Full implementation report
```

---

## Grammar summary

```
process <Name> {
    datasource <name> type CSV { path: "…" delimiter: "," hasHeader: true }

    table <name> from <datasource> { <col> : <Type> … }
    output table <name> to <datasource> { <col> : <Type> … }
    create table <name> { <col> : <Type> … }

    log <name> to "<path>" level: WARNING

    load   <table>
    save   <table>
    sort   <table> by <col> [ASC|DESC], …
    filter <table> where <expression>
    remove duplicates <table> by <col>, …
    drop   columns <col>, … from <table>
    add    column <name> : <Type> = <expr> to <table>
    copy   <src> into <dst>
    join   <left> with <right> on <leftKey> = <rightKey> [aggregating <col> using SUM|AVG|…]
    append <src> to <dst>
    group  <table> by <col>,… aggregating <col> using <FN> into <result>
    lookup <col> from <ref> on <refKey> into <table> using <tableKey>
    concat <expr> + <expr> … into <col> in <table>
    split  <col> by "<delim>" into <c1>, <c2> in <table>
    extract <col> from <start> to <end> into <result> in <table>
    calculate <col> = <expr> in <table>
    call "<FQN>" with <col>, … into <col> in <table>
}
```

Types: `Integer  Decimal  String  Boolean  Date  Timestamp`

---

## Generated code layout (per process)

```
<processname>/
  Main.java            ← orchestrator          (always regenerated)
  TableSchema.java     ← column name constants  (always regenerated)
  LTSRuntime.java      ← runtime library        (always regenerated)
  CustomFunctions.java ← user extension stub    (generated ONCE, then preserved)
```

---

## Validation rules (LTSValidator.xtend)

| Code | Rule |
|---|---|
| `noLoadStep` | Process must have ≥ 1 load step |
| `missingLogDeclaration` | Process should declare a log |
| `duplicateColumnName` | No duplicate column names in a table |
| `unknownSortColumn` | Sort key column must exist in table |
| `filterUnknownColumn` | Filter expression columns must exist |
| `removeUnknownColumn` | Drop/dedup key columns must exist |
| `joinTypeMismatch` | Join key columns must be type-compatible |
| `calculateUnknownColumn` | Calculate target column must already exist |
| `groupMissingResultColumn` | Group result table must have aggregation column |
| `lookupUnknownColumn` | Lookup fetch/key columns must exist in ref |
| `copySchemaIncompatible` | Source columns must exist in copy target |
| `saveWithoutLoad` (warning) | Process should have ≥ 1 save step |

---

## Authors

- ENORM Project, Master in Informatics Engineering, ISEP Porto, 2023/2024
- Alexandre Bragança (ATB), Rafael Gonçalves (RCC) – Project supervisors
