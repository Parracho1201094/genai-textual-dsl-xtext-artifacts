# ENORM/LTS Xtext Requirements

This document defines the normalized requirements used for the ENORM/LTS textual DSL artefact construction and evaluation. The requirements are intended to be used as a reference for the implementation and evaluation of the DSL, including grammar, validation, quick fixes, code generation, and execution.

## 1. Project Context

The DSL is called **LTS**, meaning **Load, Transform, Save**. It is a textual domain-specific language for modelling Excel-like ETL processes, where users load tabular data, apply transformation operations, and save the resulting outputs.

The intended users are subject matter experts, especially Excel users and data analysts, who may not necessarily be programmers. The language should therefore favour readable and intuitive syntax while still providing enough structure to support validation, type checking, code generation, and execution.

The DSL should allow users to model processes that:

- load input tables from CSV files;
- define table columns and column data types;
- transform tables using Excel-like operations;
- save output tables;
- save logs containing warnings and errors;
- generate executable code, preferably Java, that runs the modelled process without requiring Excel.

## 2. Language Quality Requirements

The LTS DSL should be:

- simple and easy to learn;
- intuitive for data analysts and Excel-oriented users;
- strongly typed;
- flexible enough to support new data sources in the future;
- extensible through custom functions or operators written in Java or another base language;
- suitable for implementation as a textual DSL in Eclipse Xtext.

## 3. Required Xtext Artefacts

The implementation package should include the artefacts required for an Xtext-based textual DSL workflow:

1. A proposed textual syntax for the LTS DSL.
2. A complete Xtext grammar file.
3. Example `.lts` model files for the required scenarios:
   - Salary;
   - Invoicing;
   - Grading.
4. Invalid `.lts` model files that demonstrate validation errors.
5. Xtext validation rules, preferably implemented in Java or Xtend.
6. Xtext quick fixes or refactorings for common modelling mistakes.
7. An Xtend code generator.
8. A generated-code architecture explaining how DSL constructs map to executable code.
9. A suggested folder and package structure for the Xtext project.
10. A report section explaining the Xtext implementation, design decisions, limitations, and expected execution workflow.

The generated artefact package should include actual implementation files where possible, not only high-level descriptions.

## 4. Required DSL Concepts

The DSL must support at least the following concepts:

- LTS process;
- CSV data source;
- input table;
- output table;
- log file;
- column;
- data type;
- load operation;
- save operation;
- filter operation;
- sort operation;
- group operation;
- aggregation;
- join operation;
- append rows operation;
- create empty table operation;
- insert column operation;
- remove column operation;
- lookup operation;
- remove duplicates operation;
- string manipulation operations, including:
  - concatenation;
  - splitting;
  - extraction;
- calculated columns or expressions;
- custom or external functions.

## 5. Required Scenarios

The implementation must support the three representative LTS scenarios described below. These scenarios should be covered by valid `.lts` model files and should be used as practical evidence for grammar coverage, validation behaviour, generation support, and execution where possible.

### 5.1 Salary Scenario

The Salary scenario should model a process that:

- loads employee, worked-hours, and employee-category CSV files;
- removes duplicate employees;
- sorts employees by identifier;
- creates a payments table;
- copies employee data into the payments table;
- joins payments with employee categories;
- joins payments with worked hours using a `SUM` aggregation;
- calculates the payment value;
- removes temporary columns;
- saves the payments table to CSV;
- saves warnings and errors to a log file.

### 5.2 Invoicing Scenario

The Invoicing scenario should model a process that:

- loads clients, products, and sales CSV files;
- calculates the total value to invoice each client;
- saves invoice results to CSV;
- saves warnings and errors to a log file.

### 5.3 Grading Scenario

The Grading scenario should model a process that:

- loads students, courses, and exams CSV files;
- calculates the final grade for each course and student;
- saves grade results to CSV;
- saves warnings and errors to a log file.

## 6. Validation Requirements

The implementation should include semantic validation beyond grammar-level syntax checking. The validator should detect common modelling errors such as:

- duplicate table declarations;
- duplicate column declarations within the same table;
- references to unknown tables;
- references to unknown columns;
- invalid column references in filters, joins, lookups, groups, or calculations;
- type mismatches between joined columns;
- type mismatches in calculated expressions;
- aggregation over non-numeric columns where inappropriate;
- attempts to save tables that were not created, loaded, or populated;
- missing log declarations when log saving is required;
- invalid CSV file declarations or unsupported file formats;
- misuse of custom or external functions.

Validation errors should produce meaningful diagnostic messages. Where possible, invalid `.lts` examples should be provided to demonstrate the expected errors.

## 7. Quick-Fix and Refactoring Requirements

The implementation should include quick fixes or refactorings for common and deterministic modelling mistakes. Possible quick fixes include:

- renaming duplicate tables or columns;
- adding a missing table declaration;
- adding a missing column declaration;
- correcting an invalid CSV file extension;
- removing references to unknown columns;
- inserting a missing load operation before a table is used;
- adding a default log declaration;
- replacing an invalid operation with a more appropriate one where the correction is deterministic.

Quick fixes should perform actual model edits where possible. Placeholder quick fixes or documentation-only suggestions should be clearly identified as incomplete.

## 8. Code Generation Requirements

The generator should produce executable Java code, or an equivalent executable target, capable of performing the modelled LTS process without requiring Excel.

The generated-code architecture should:

- separate generated process code from reusable runtime support;
- include reusable abstractions for tables, rows, columns, schemas, CSV input/output, logging, and table operations;
- map DSL operations to generated Java calls or runtime services;
- support the required Salary, Invoicing, and Grading scenarios;
- allow manual extensions through custom Java functions or operators;
- make common generated code and model-dependent generated code distinguishable.

The generator should not only produce documentation or placeholder code. Where execution is claimed, retained evidence should show that the generated code compiles and produces outputs for the relevant scenarios.

## 9. Implementation Expectations

The implementation should satisfy the following expectations:

* The syntax should be readable and intuitive for data analysts.
* The grammar should map cleanly to the abstract syntax or metamodel.
* The DSL should be strongly typed.
* The validator should detect semantic errors, not only syntax errors.
* Quick fixes should correct common model mistakes where deterministic correction is possible.
* The generator should produce executable Java code that performs the modelled LTS process without requiring Excel.
* The generated code should support manual extensions through custom Java functions.
* Example models should cover the required scenarios.
* Invalid examples should demonstrate the validation layer.
* Documentation should describe what was actually implemented and verified, not only what was intended.
* Any unsupported, placeholder, or partially implemented behaviour should be explicitly documented.