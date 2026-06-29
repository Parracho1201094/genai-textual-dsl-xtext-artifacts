You are an expert Eclipse Xtext language engineer. Using only the textual DSL requirements, produce an Xtext grammar that covers the required concepts and example scenarios. 

Project context:
The DSL is called LTS, which means Load, Transform, Save. It is a DSL for modeling Excel-like ETL processes. The target users are subject matter experts, especially Excel users and data analysts, not necessarily programmers.
The DSL should allow users to model processes that:
- load input tables from CSV files
- define table columns and column data types
- transform tables using Excel-like operations
- save output tables
- save logs with warnings and errors
- generate executable code, preferably Java, that runs the modeled process without requiring Excel
The DSL should be:
- simple and easy to learn
- intuitive for data analysts
- strongly typed
- flexible enough to support new data sources in the future
- extensible through custom functions/operators written in Java or another base language
Produce the project artifacts needed for an Xtext implementation, including:
1. A proposed textual syntax for the LTS DSL.
2. The complete Xtext grammar file.
```markdown
You are an expert Eclipse Xtext language engineer. Using only the textual DSL requirements, produce an Xtext grammar that covers the required concepts and example scenarios.

Project context:

The DSL is called LTS, which means Load, Transform, Save. It is a DSL for modeling Excel-like ETL processes. The target users are subject matter experts, especially Excel users and data analysts, not necessarily programmers.

The DSL should allow users to model processes that:
- load input tables from CSV files
- define table columns and table column data types
- transform tables using Excel-like operations
- save output tables
- save logs with warnings and errors
- generate executable code, preferably Java, that runs the modeled process without requiring Excel

The DSL should be:
- simple and easy to learn
- intuitive for data analysts
- strongly typed
- flexible enough to support new data sources in the future
- extensible through custom functions/operators written in Java or another base language

Produce the project artifacts needed for an Xtext implementation, including:
1. A proposed textual syntax for the LTS DSL.
2. The complete Xtext grammar file.
3. Example `.lts` model files for:
   - Salary
   - Invoicing
   - Grading
4. Invalid `.lts` examples that demonstrate validation errors.
5. Xtext validation rules, preferably in Java or Xtend.
6. Xtext quick fixes/refactorings.
7. An Xtend code generator.
8. Generated-code architecture.
9. A suggested folder/package structure for the Xtext project.
10. A report section explaining the Xtext implementation.

The DSL must support at least these concepts:
- LTS process
- CSV data source
- input table
- output table
- log file
- column
- data type
- load operation
- save operation
- filter
- sort
- group
- aggregation
- join
- append rows
- create empty table
- insert column
- remove column
- lookup
- remove duplicates
- string manipulation, including concatenation, splitting, and extraction
- calculated columns or expressions
- custom/external functions

The required scenarios are:

Salary:
- load employee, worked hours, and employee category CSV files
- remove duplicate employees
- sort employees by id
- create a payments table
- copy employee data into payments
- join payments with employee categories
- join payments with worked hours using SUM
- calculate payment
- remove temporary columns
- save payments to CSV
- save warnings and errors to a log file

Invoicing:
- load clients, products, and sales CSV files
- calculate the total value to invoice each client
- save invoice results to CSV
- save warnings and errors to a log file

Grading:
- load students, courses, and exams CSV files
- calculate final grade for each course and student
- save grade results to CSV
- save warnings and errors to a log file

Important implementation expectations:
- The syntax should be readable and intuitive for data analysts.
- The grammar should map cleanly to the metamodel.
- The DSL should be strongly typed.
- The validator should detect semantic errors, not only syntax errors.
- Quick fixes should correct common model mistakes.
- The generator should produce executable Java code that performs the modeled LTS process without requiring Excel.
- The generated code should support manual extensions through custom Java functions.
- The answer should include actual code/files where possible, not only descriptions.

## Response: 
https://claude.ai/share/52924294-45a2-472e-8aff-976dd3c54ecc

