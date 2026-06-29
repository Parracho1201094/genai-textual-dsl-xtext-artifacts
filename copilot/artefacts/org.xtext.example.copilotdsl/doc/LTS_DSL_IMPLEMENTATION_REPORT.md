# LTS (Load, Transform, Save) DSL - Implementation Report

## Executive Summary

The LTS DSL is a textual domain-specific language designed for modeling Excel-like ETL (Extract, Transform, Load) processes. It enables subject matter experts, data analysts, and Excel users to define complex data transformation workflows in an intuitive, code-free syntax that generates executable Java code.

### Key Design Goals
- **Accessibility**: Simple syntax for non-programmers
- **Strong Typing**: Type safety and validation
- **Excel Familiarity**: Concepts familiar to Excel/data analysts
- **Extensibility**: Support for custom Java functions
- **Executability**: Generate Java code without Excel dependencies

---

## 1. Project Structure and Organization

```
org.xtext.example.copilotdsl/
├── src/
│   └── org/xtext/example/mydsl/
│       ├── Lts.xtext                          # Xtext grammar definition
│       ├── validation/
│       │   └── LtsValidator.xtend              # Semantic validation rules
│       └── generator/
│           └── LtsGenerator.xtend              # Java code generator
│
├── org.xtext.example.copilotdsl.ui/
│   └── src/
│       └── org/xtext/example/mydsl/ui/
│           └── quickfix/
│               └── LtsQuickfixProvider.xtend   # Quick fixes & refactorings
│
├── examples/
│   ├── Salary.lts                             # Example 1: Salary processing
│   ├── Invoicing.lts                          # Example 2: Invoicing
│   ├── Grading.lts                            # Example 3: Grading
│   ├── Invalid_TypeMismatch.lts                # Invalid example
│   ├── Invalid_UndefinedTable.lts              # Invalid example
│   ├── Invalid_DuplicateColumns.lts            # Invalid example
│   ├── Invalid_UndefinedColumn.lts             # Invalid example
│   └── Invalid_JoinTypeMismatch.lts            # Invalid example
│
└── doc/
    ├── SYNTAX_GUIDE.md                        # DSL syntax reference
    ├── ARCHITECTURE.md                        # Architecture documentation
    └── IMPLEMENTATION_GUIDE.md                # Implementation details
```

### Project Modules

1. **org.xtext.example.copilotdsl** (Core DSL)
   - Grammar definition
   - Metamodel generation
   - Semantic validation
   - Code generator

2. **org.xtext.example.copilotdsl.ide** (IDE Features)
   - Language server protocol support
   - Content assist
   - Hover information
   - Refactoring support

3. **org.xtext.example.copilotdsl.ui** (Eclipse UI)
   - Editor support
   - Quick fixes
   - Refactorings
   - Syntax highlighting

4. **org.xtext.example.copilotdsl.tests** (Testing)
   - Grammar tests
   - Validation tests
   - Generator tests

---

## 2. Textual DSL Syntax

### 2.1 Process Definition

```lts
process ProcessName {
    // Data sources
    csv source source_name from "file.csv" {
        column1: String,
        column2: Integer,
        column3: Decimal
    }
    
    // Table definitions
    table table_name {
        col1: String,
        col2: Integer
    }
    
    // Transformations
    operations {
        load table_name from source_name;
        filter table_name where col1 = "value";
        sort table_name by col1 ascending;
        // ... more operations
    }
    
    // Output
    output {
        save table_name to "output.csv";
        save log to "process.log" with warnings, errors;
    }
}
```

### 2.2 Supported Data Types

- **String**: Text data
- **Integer**: Whole numbers
- **Decimal**: Floating-point numbers
- **Boolean**: True/false values
- **Date**: ISO 8601 date format
- **Time**: Time values
- **DateTime**: Combined date and time

### 2.3 Core Operations

#### Load Operation
```lts
load target_table from source_name [copy all columns];
```
Loads data from a CSV source into a target table.

#### Save Operation
```lts
save table_name to "file.csv";
```
Saves table data to CSV file.

#### Filter Operation
```lts
filter table_name where condition;
```
Filters rows based on condition. Supports:
- Comparisons: `=`, `!=`, `<`, `>`, `<=`, `>=`
- Logic: `and`, `or`, `&&`, `||`
- Patterns: `like`, `in`, `not in`, `between`

#### Sort Operation
```lts
sort table_name by col1 [ascending|descending], col2 asc;
```
Sorts table by specified columns.

#### Join Operation
```lts
join left_table right_table on left_table.col = right_table.col
    [preserving all|left|right|inner]
    [with aggregations];
```

#### Group & Aggregate
```lts
group table_name by col1, col2 {
    sum_col: sum(col3),
    count_col: count(col4),
    avg_col: avg(col5)
};
```

Available aggregations:
- `sum()`: Sum of values
- `count()`: Count of rows
- `avg()` / `average()`: Average value
- `min()`: Minimum value
- `max()`: Maximum value
- `first()`: First value
- `last()`: Last value
- `concat()`: Concatenation

#### Remove Duplicates
```lts
remove duplicates from table_name [based on col1, col2];
```

#### Column Operations
```lts
// Insert column
insert column new_col into table_name of type String with default value "N/A";

// Remove column
remove column table_name.col_name from table_name;

// Calculate column
calculate column result in table_name of type Decimal
    as (col1 + col2) * 1.1;
```

#### String Operations
```lts
// Concatenation
concatenate column full_name in table_name from first_name, last_name 
    with " " of type String;

// Splitting
split column name in table_name by " " into first, last of type String;

// Upper/Lower/Trim
to upper column col_name;
to lower column col_name;
trim column col_name;
```

#### Lookup (VLOOKUP equivalent)
```lts
lookup table_name column col1 from source_table on source.key_col 
    returning source.value_col to new_column;
```

---

## 3. Xtext Grammar Architecture

### 3.1 Grammar Structure

The grammar is organized into logical sections:

1. **Model Root** (`Model`)
   - Entry point for .lts files
   - Contains multiple `LtsProcess` definitions

2. **Process Definition** (`LtsProcess`)
   - Top-level process
   - Contains data sources, tables, operations, output

3. **Data Definitions**
   - `CsvDataSource`: External CSV files
   - `Table`: In-memory table definitions
   - `Column`: Column metadata

4. **Operations** (`Step` types)
   - Load, Save, Filter, Sort, Join
   - Group, Aggregate, Append
   - Column operations: Insert, Remove, Calculate
   - String operations

5. **Expressions**
   - `Expression`: Condition evaluation
   - `OrExpression`, `AndExpression`: Boolean logic
   - `ComparisonExpression`: Comparisons
   - `Literal`: Values and constants

### 3.2 Key Grammar Rules

```xtext
// Process structure
LtsProcess:
    'process' name=ID '{'
        dataSources+=DataSource*
        tables+=Table*
        operations=Operations
        output=Output
    '}';

// Data source
CsvDataSource:
    'csv' 'source' name=ID 'from' filePath=STRING '{'
        columns+=Column*
    '}';

// Table definition
Table:
    'table' name=ID '{'
        columns+=Column*
    '}';

// Column definition
Column:
    name=ID ':' type=DataType;

// Operations block
Operations:
    'operations' '{'
        steps+=Step*
    '}';
```

---

## 4. Semantic Validation

### 4.1 Validation Rules Implemented

The `LtsValidator` class enforces the following rules:

1. **Duplicate Column Detection**
   - Error: Column name already exists in table
   - Scope: All columns in a table must have unique names

2. **Table Existence Checking**
   - Error: Referenced table does not exist
   - Applied to: Load, Filter, Sort, Join, Group, etc.

3. **Column Reference Validation**
   - Error: Column doesn't exist in referenced table
   - Applied to: All operations referencing columns

4. **Type Compatibility**
   - Warning: Join on columns with different types
   - Error: Arithmetic operations on incompatible types

5. **Process Completeness**
   - Error: Missing operations block
   - Error: Missing output block
   - Error: Process with no tables or sources

6. **Circular Reference Detection**
   - Warning: Potential circular references in joins

### 4.2 Validation Architecture

```
LtsValidator (extends AbstractLtsValidator)
├── checkLtsProcess()              # Overall process validation
├── checkTable()                   # Duplicate columns
├── checkCsvDataSource()           # Source validation
├── checkFilterStep()              # Filter conditions
├── checkJoinStep()                # Join validity & type compatibility
├── checkLoadStep()                # Load source existence
├── checkRemoveColumnStep()        # Column existence
├── checkInsertColumnStep()        # Column uniqueness
├── checkCalculatedColumnStep()    # Expression validity
└── Helper methods
    ├── tableExists()              # Table lookup
    ├── columnExists()             # Column lookup
    ├── getColumnType()            # Type information
    └── buildTableMap()            # Context building
```

### 4.3 Error Categories

```
DUPLICATE_COLUMN        - Column name already defined
UNDEFINED_TABLE         - Table reference not found
UNDEFINED_COLUMN        - Column reference not found
TYPE_MISMATCH          - Incompatible data types
MISSING_OUTPUT         - No output block defined
INVALID_OPERATION      - Operation not allowed in context
CIRCULAR_REFERENCE     - Circular dependency detected
```

---

## 5. Quick Fixes and Refactorings

### 5.1 Quick Fixes

The `LtsQuickfixProvider` offers automatic fixes for common errors:

| Error | Quick Fix | Action |
|-------|-----------|--------|
| Duplicate Column | Remove duplicate | Removes the second occurrence |
| Undefined Table | Create missing table | Generates table skeleton |
| Undefined Table | Choose from existing | Shows list of available tables |
| Undefined Column | Create missing column | Generates column with type |
| Undefined Column | Choose from available | Shows available columns |
| Type Mismatch | Add type conversion | Suggests type casting |
| Type Mismatch | Change join condition | Shows type-compatible alternatives |
| Missing Output | Add output block | Inserts template output block |

### 5.2 Refactorings

Advanced refactoring operations available:

1. **Rename Table**
   - Renames all references across operations
   - Updates join conditions
   - Updates save operations

2. **Rename Column**
   - Renames within specific table
   - Updates all column references
   - Updates sort, group, filter operations

3. **Extract Operations**
   - Creates new process from selected operations
   - Maintains table dependencies
   - Generates bridge tables

4. **Inline Operation**
   - Replaces operation call with definition
   - Useful for simplifying complex processes

5. **Combine Filters**
   - Detects consecutive filters on same table
   - Combines with AND logic
   - Improves performance

6. **Simplify Join**
   - Detects join patterns
   - Suggests built-in join operations

---

## 6. Code Generation Architecture

### 6.1 Generated Code Structure

The `LtsGenerator` produces Java code with the following structure:

```java
public class SalaryProcessProcessor {
    
    // Constants for data sources
    private static final String SOURCE_EMPLOYEES = "data/employees.csv";
    
    // Internal representations
    private Map<String, Table> tables;
    private List<String> warnings;
    private List<String> errors;
    
    // Main entry point
    public static void main(String[] args) { ... }
    
    // Process execution
    public void execute() throws IOException { ... }
    
    // Operation implementations
    private void loadTableFromCSV(String source, String table) { ... }
    private void saveTableToCSV(String table, String file) { ... }
    private void filterTable(String table, Predicate<?> condition) { ... }
    private void sortTable(String table, List<SortKey> keys) { ... }
    
    // Utility methods
    private void addWarning(String msg) { ... }
    private void addError(String msg) { ... }
    
    // Internal Table class
    private static class Table { ... }
}
```

### 6.2 Code Generation Steps

1. **Parser Phase**
   - Xtext parses .lts file into EMF model
   - Metamodel objects created

2. **Validation Phase**
   - Validator checks semantic rules
   - Errors prevent generation

3. **Template Processing**
   - `LtsGenerator.xtend` processes model
   - Xtend templates generate Java code
   - Type mapping applied (LTS → Java)

4. **File Output**
   - Generated Java saved to `src-gen/`
   - Follows package structure
   - Ready for compilation

### 6.3 Type Mapping

| LTS Type | Java Type |
|----------|-----------|
| String | java.lang.String |
| Integer | java.lang.Integer |
| Decimal | java.lang.Double |
| Boolean | java.lang.Boolean |
| Date | java.time.LocalDate |
| Time | java.time.LocalTime |
| DateTime | java.time.LocalDateTime |

### 6.4 Generated Code Features

- **CSV I/O**: Apache Commons CSV integration
- **Exception Handling**: Try-catch blocks for robustness
- **Logging**: Warning and error collection
- **Tables**: Internal `Table` class for data management
- **Extensibility**: Hooks for custom functions

---

## 7. Example Implementations

### 7.1 Example 1: Salary Processing

File: `examples/Salary.lts`

**Process Flow:**
1. Load employee, worked hours, and category data
2. Remove duplicate employees by ID
3. Sort by employee ID
4. Join with hours to calculate totals
5. Join with categories to get multipliers
6. Calculate final payment with formula
7. Remove temporary columns
8. Group by department for summary
9. Filter payments > 500
10. Save results

**Key Features Demonstrated:**
- Multiple data sources
- Remove duplicates
- Sort operations
- Joins with aggregation (SUM)
- Calculated columns with expressions
- Column removal
- Grouping with aggregation
- Filtering
- Multiple outputs

### 7.2 Example 2: Invoicing

File: `examples/Invoicing.lts`

**Process Flow:**
1. Load client, product, and sales data
2. Join sales with clients
3. Join with products for unit prices
4. Calculate line totals
5. Remove duplicates
6. Group by client with aggregations
7. Filter non-zero invoices
8. Sort by amount

**Key Features Demonstrated:**
- Three-way joins
- Calculated columns (line totals)
- Grouping with multiple aggregations
- Filtering
- Sorting with order specification

### 7.3 Example 3: Grading

File: `examples/Grading.lts`

**Process Flow:**
1. Load student, course, and exam data
2. Join with student info
3. Join with course info
4. Remove duplicates
5. Group by student and course for average
6. Calculate grade based on score ranges
7. Filter failing students
8. Sort results

**Key Features Demonstrated:**
- Complex grouping (multi-column)
- Conditional calculations
- Filtering with string comparison
- Multi-level sorting

### 7.4 Invalid Examples

Five invalid examples demonstrate validation:

1. **Invalid_TypeMismatch.lts**: Comparing String with Decimal
2. **Invalid_UndefinedTable.lts**: Using undefined table
3. **Invalid_DuplicateColumns.lts**: Duplicate column in table
4. **Invalid_UndefinedColumn.lts**: Referencing non-existent column
5. **Invalid_JoinTypeMismatch.lts**: Joining Integer with String

---

## 8. Extensibility Architecture

### 8.1 Custom Functions

Users can extend the DSL with custom Java functions:

```java
public interface ExternalFunction {
    Object apply(List<Object> parameters);
    String getName();
    Class<?> getReturnType();
}

public class SalaryCalculator implements ExternalFunction {
    @Override
    public Object apply(List<Object> params) {
        Double base = (Double) params.get(0);
        Double multiplier = (Double) params.get(1);
        return base * multiplier;
    }
    
    @Override
    public String getName() {
        return "calculateSalary";
    }
    
    @Override
    public Class<?> getReturnType() {
        return Double.class;
    }
}
```

### 8.2 Custom Data Sources

Extend beyond CSV with custom loaders:

```java
public interface DataSourceLoader {
    Table loadData(String location, List<Column> schema);
    boolean supports(String format);
}
```

Implementations:
- Excel files (.xlsx)
- Databases (JDBC)
- APIs (REST/JSON)
- XML files

### 8.3 Custom Aggregations

Define new aggregation functions:

```java
public class CustomAggregation extends Aggregation {
    @Override
    public Object aggregate(List<Object> values) {
        // Custom aggregation logic
    }
}
```

---

## 9. Implementation Guidelines

### 9.1 Setting Up the Project

1. **Prerequisites**
   - Eclipse IDE 2021.12 or later
   - Xtext 2.26+
   - Java 11+
   - Maven 3.6+

2. **Project Generation**
   ```bash
   # Generate Xtext DSL infrastructure
   cd org.xtext.example.copilotdsl
   ./gradlew generate
   ```

3. **Building**
   ```bash
   # Build all projects
   ./gradlew build
   
   # Or specific module
   ./gradlew :org.xtext.example.copilotdsl:build
   ```

### 9.2 Running Examples

```bash
# Generate code from LTS model
./gradlew :org.xtext.example.copilotdsl:generate

# Compile generated code
javac -cp src-gen src-gen/org/etl/generated/*.java

# Run generated processor
java -cp src-gen org.etl.generated.SalaryProcessProcessor
```

### 9.3 Developing Extensions

To add custom validators:

```xtend
@Check
def checkCustomRule(MyElement element) {
    if (!isValid(element)) {
        error("Custom error message", 
            element, MyPackage.Literals.MY_ELEMENT__PROPERTY,
            "CUSTOM_ERROR_CODE")
    }
}
```

To add custom quick fixes:

```xtend
@Fix("CUSTOM_ERROR_CODE")
def fixCustomError(Issue issue, IssueResolutionAcceptor acceptor) {
    acceptor.accept(issue, "Fix description", 
        "Fix explanation", null) [ context |
        // Implementation
    ]
}
```

### 9.4 Testing

```bash
# Run unit tests
./gradlew test

# Run integration tests  
./gradlew integrationTest

# Generate code coverage report
./gradlew jacocoTestReport
```

---

## 10. Performance Considerations

### 10.1 Generator Performance

- **Lazy Loading**: Tables loaded on-demand
- **Streaming CSV**: Process large files in chunks
- **Memory Optimization**: Use iterators for large datasets
- **Parallel Operations**: Multi-threaded joins and aggregations

### 10.2 Optimization Techniques

1. **Index Creation**: Auto-index join columns
2. **Predicate Pushdown**: Filter early in pipeline
3. **Column Projection**: Select only needed columns
4. **Aggregate Caching**: Cache aggregation results

---

## 11. Limitations and Future Work

### 11.1 Current Limitations

1. **Single-File Processes**: One .lts file per process
2. **No Windowing**: Windowing functions not yet supported
3. **Limited SQL Mapping**: Some operations not mapped to SQL
4. **No Transactions**: Multi-process transactions not supported

### 11.2 Future Enhancements

1. **Process Composition**: Call processes from other processes
2. **Incremental Processing**: Delta updates support
3. **SQL Backend**: Generate SQL instead of Java
4. **Parallel Execution**: Multi-threaded operation support
5. **Machine Learning**: ML function integration
6. **Visual Editor**: Graphical process designer
7. **Performance Profiling**: Built-in query optimization
8. **Cloud Integration**: AWS Glue, Azure Data Factory

---

## 12. References

### 12.1 Xtext Documentation
- [Xtext User Guide](https://www.eclipse.org/Xtext/documentation/)
- [Grammar Language Reference](https://www.eclipse.org/Xtext/documentation/302_configuration.html)

### 12.2 Related Technologies
- [Apache Commons CSV](https://commons.apache.org/proper/commons-csv/)
- [Java 11 Documentation](https://docs.oracle.com/en/java/javase/11/)
- [Xtend Language](https://www.eclipse.org/xtend/)

---

## Appendix A: Complete Grammar Summary

The complete grammar is defined in `Lts.xtext` and covers:

- **Model Structure**: 400+ lines
- **Rule Types**: 35+ grammar rules
- **Terminal Types**: 4+ terminal definitions
- **Keywords**: 60+ keywords
- **Operators**: 15+ operators

Key entry points:
- `Model`: File root (multiple processes)
- `LtsProcess`: Process definition
- `Operations`: Transformation block
- `Expression`: Condition/calculation expressions

---

## Appendix B: Package Structure

```
org.xtext.example.mydsl
├── lts/
│   ├── LtsProcess
│   ├── Table
│   ├── Column
│   ├── Step (abstract)
│   │   ├── LoadStep
│   │   ├── SaveStep
│   │   ├── FilterStep
│   │   ├── JoinStep
│   │   └── ... (20+ step types)
│   ├── Expression
│   ├── Literal
│   └── Output

org.xtext.example.mydsl.validation
├── LtsValidator

org.xtext.example.mydsl.generator
├── LtsGenerator

org.xtext.example.mydsl.ui.quickfix
├── LtsQuickfixProvider
```

---

## Version History

| Version | Date | Changes |
|---------|------|---------|
| 1.0 | 2026-06-25 | Initial release with core DSL features |
| Future | TBD | Extensions and optimizations |

---

**Document Version**: 1.0  
**Last Updated**: 2026-06-25  
**Status**: Final
