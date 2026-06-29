Act as an experienced Xtext engineer and DSL consultant.

I am working on the ENORM LTS project: a Load, Transform, Save DSL for Excel/CSV-like data processing. I only want to focus on the useful Xtext/textual DSL part of the project. Do not spend effort on graphical syntax, Sirius, MPS, or general project-management discussion unless it directly affects the Xtext implementation.

Analyze, improve, or help document the solution with emphasis on the following deliverables:

1. Xtext grammar and textual concrete syntax
   - Explain the intended textual notation.
   - Review or propose the Xtext grammar.
   - Check whether the syntax is readable for domain users such as data analysts.
   - Identify grammar problems, ambiguities, missing rules, or unnecessary complexity.
   - Prefer a simple LTS syntax based on operations such as load, create, sort, filter, join, remove duplicates, calculate/set columns, drop columns, save, and save log.

2. Abstract syntax / metamodel implied by the grammar
   - Derive the main concepts from the grammar.
   - Describe the implied metamodel in terms of entities, attributes, containment relations, and references.
   - Identify concepts such as Process, Table, Column, Type, DataSource, Statement, Load, Save, Transformation, Join, Filter, Sort, Aggregation, Expression, and FunctionCall.
   - Explain how the grammar maps to the Ecore model generated or used by Xtext.
   - Point out where custom scoping is needed, especially for table and column references.

3. Validation rules and diagnostics
   - Propose or review semantic validation rules for the DSL.
   - Include diagnostics for:
     - duplicate process, table, or column names;
     - undefined table references;
     - undefined column references;
     - incompatible column types in joins;
     - invalid arithmetic or string expressions;
     - saving a table that was never created or loaded;
     - duplicate output columns;
     - aggregations over non-numeric columns;
     - operations used before their input table exists;
     - invalid file extensions or unsupported data sources.
   - For each validation rule, describe the error/warning message and, where useful, a quick fix.
   - Distinguish syntax errors, linking errors, and semantic validation errors.

4. Code generation templates or generated code
   - Explain how the Xtext generator should transform a `.lts` model into executable code.
   - Prefer Java code generation using a reusable runtime library.
   - Separate common code from variable generated code.
   - Describe reusable runtime classes such as Table, Column, CsvLoader, CsvSaver, Operators, Logger, and CustomFunctions.
   - Show generator templates or representative generated Java code.
   - Explain how each DSL construct maps to generated Java statements.
   - Include support for manual extensions through custom Java functions/operators.

5. Example DSL programs/models
   - Provide or review complete `.lts` examples for:
     - Salary;
     - Invoicing;
     - Grading.
   - Each example should demonstrate loading CSV files with typed schemas, transformations, joins/lookups, calculated columns, filtering/sorting where applicable, duplicate removal, output saving, and log saving.
   - Keep examples realistic but not unnecessarily large.
   - Use the examples to demonstrate the main language features.

6. Build, parsing, validation, and generation evidence
   - Explain what evidence should be included in the report or repository.
   - Include examples of:
     - successful Xtext project build;
     - generated language artifacts;
     - parsed `.lts` models;
     - editor syntax highlighting/content assist if available;
     - validation diagnostics;
     - quick fixes if implemented;
     - generated Java files;
     - execution output or generated CSV/log files if available;
     - unit tests for parsing, validation, and generation.
   - Suggest concise test cases and screenshots/logs that prove the solution works.

When answering, structure the response as a practical engineering review or implementation plan. Focus on concrete artifacts, code, grammar, validation, generation, and examples. Avoid generic DSL theory unless it directly helps improve the Xtext solution.

# ChatGPT Response

https://chatgpt.com/share/6a40051a-d1c0-83eb-9a21-3a3f3fa4292d