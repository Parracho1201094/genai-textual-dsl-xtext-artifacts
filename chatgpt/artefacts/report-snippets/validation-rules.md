# Validation rules

The recommended validator separates parser errors, Xtext linking errors, and semantic errors.

Parser errors cover malformed syntax. Linking errors cover unresolved table references. Semantic errors are implemented in `LtsValidator.xtend` and include duplicate process/table/column names, invalid column references, join type mismatches, invalid expressions, invalid aggregation types, duplicate output columns, invalid file extensions, and operations whose input tables are not yet available.

Quick fixes should be implemented first for small deterministic transformations: rename duplicate table, rename duplicate column, and change an invalid source path extension to `.csv`.
