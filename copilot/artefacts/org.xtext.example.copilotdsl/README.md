# LTS (Load, Transform, Save) DSL - Project README

## Overview

**LTS** is a textual Domain-Specific Language (DSL) designed for modeling Excel-like ETL (Extract, Transform, Load) processes in an intuitive, code-free syntax. The DSL targets subject matter experts, data analysts, and Excel users, enabling them to define complex data transformation workflows that compile to executable Java code.

### Key Characteristics

- **Declarative Syntax**: Define WHAT to transform, not HOW
- **Excel-Familiar**: Uses concepts like columns, filters, joins, aggregations
- **Strongly Typed**: Type safety with DataTypes (String, Integer, Decimal, Date, etc.)
- **Code Generation**: Produces standalone Java applications
- **No Excel Required**: Generated code runs independently
- **Extensible**: Support for custom Java functions and operations
- **IDE Support**: Eclipse editor integration with syntax highlighting, content assist, quick fixes

---

## Project Structure

```
org.xtext.example.copilotdsl/
├── src/
│   └── org/xtext/example/mydsl/
│       ├── Lts.xtext                  # Grammar definition
│       ├── validation/
│       │   └── LtsValidator.xtend      # Semantic validation
│       └── generator/
│           └── LtsGenerator.xtend      # Java code generator
│
├── org.xtext.example.copilotdsl.ui/
│   └── src/org/xtext/example/mydsl/ui/
│       └── quickfix/
│           └── LtsQuickfixProvider.xtend   # Quick fixes & refactorings
│
├── examples/
│   ├── Salary.lts                     # Salary processing example
│   ├── Invoicing.lts                  # Invoicing example
│   ├── Grading.lts                    # Grading example
│   ├── Invalid_TypeMismatch.lts       # Invalid examples (for testing)
│   ├── Invalid_UndefinedTable.lts
│   ├── Invalid_DuplicateColumns.lts
│   ├── Invalid_UndefinedColumn.lts
│   └── Invalid_JoinTypeMismatch.lts
│
├── doc/
│   ├── LTS_DSL_IMPLEMENTATION_REPORT.md     # Main documentation
│   ├── SYNTAX_GUIDE.md                       # DSL syntax reference
│   ├── ARCHITECTURE.md                       # System architecture
│   └── GENERATED_CODE_ARCHITECTURE.md        # Code generation details
│
└── GenerateMyDsl.mwe2                   # Xtext generator configuration
```

---

## Getting Started

### Prerequisites

- Eclipse IDE 2021.12+ with Xtext
- Java 11+
- Maven 3.6+
- Apache Commons CSV (for generated code)

### Installation

1. Clone the repository
2. Import all four projects into Eclipse:
   - org.xtext.example.copilotdsl
   - org.xtext.example.copilotdsl.ui
   - org.xtext.example.copilotdsl.tests
   - org.xtext.example.copilotdsl.ide

3. Generate Xtext infrastructure:
   ```bash
   cd org.xtext.example.copilotdsl
   ./gradlew generate
   ```

4. Build:
   ```bash
   ./gradlew build
   ```

### Your First LTS Process

Create a file `process.lts`:

```lts
process SimpleExample {
    csv source employees from "employees.csv" {
        id: Integer,
        name: String,
        salary: Decimal
    }
    
    table results {
        id: Integer,
        name: String,
        salary: Decimal
    }
    
    operations {
        load results from employees copy all columns;
        filter results where salary > 50000;
        sort results by salary descending;
    }
    
    output {
        save results to "high_salary.csv";
        save log to "process.log" with warnings, errors;
    }
}
```

---

## Features

### DSL Features

✓ **Data Sources**
  - Load from CSV files
  - Multiple concurrent sources
  - Type-safe columns

✓ **Table Management**
  - Define table schemas
  - Create empty tables
  - Insert/remove columns
  - Remove duplicates

✓ **Transformations**
  - Filter rows with conditions
  - Sort by multiple columns
  - Join tables (inner, left, right, full)
  - Group and aggregate (sum, count, avg, min, max, concat)
  - Calculate computed columns
  - String operations (concatenate, split, trim, case conversion)
  - Lookup (VLOOKUP equivalent)
  - Append rows

✓ **Output**
  - Save to CSV
  - Write logs with warnings/errors
  - Multiple output targets

✓ **Strong Typing**
  - 7 data types: String, Integer, Decimal, Boolean, Date, Time, DateTime
  - Type validation
  - Type-aware operations

### IDE Features

✓ **Syntax Highlighting**
  - Keywords
  - Comments
  - Strings and numbers

✓ **Content Assist** (Ctrl+Space)
  - Context-aware suggestions
  - Table and column name completion
  - Function suggestions

✓ **Quick Fixes** (Ctrl+1)
  - Create missing tables/columns
  - Remove duplicates
  - Suggest type conversions
  - Add missing output blocks

✓ **Navigation** (F3)
  - Go to definition
  - Find references

✓ **Validation**
  - Real-time syntax checking
  - Semantic error detection
  - Type checking

### Code Generation

✓ **Java Code Generation**
  - Standalone executable applications
  - CSV I/O using Apache Commons CSV
  - Exception handling
  - Logging and error tracking
  - No runtime dependencies

✓ **Extensibility**
  - Custom Java functions
  - Custom aggregations
  - Custom data sources
  - Override generated methods

---

## Documentation

### Quick References

1. **[SYNTAX_GUIDE.md](doc/SYNTAX_GUIDE.md)**
   - Complete DSL syntax reference
   - Operation specifications
   - Expression grammar
   - Examples for each feature

2. **[ARCHITECTURE.md](doc/ARCHITECTURE.md)**
   - System architecture
   - Grammar hierarchy
   - Validation architecture
   - Code generation pipeline
   - Extension points

3. **[GENERATED_CODE_ARCHITECTURE.md](doc/GENERATED_CODE_ARCHITECTURE.md)**
   - Generated code structure
   - Operation implementation patterns
   - Runtime execution
   - Testing and deployment
   - Performance optimization

4. **[LTS_DSL_IMPLEMENTATION_REPORT.md](doc/LTS_DSL_IMPLEMENTATION_REPORT.md)**
   - Complete implementation report
   - All features documented
   - Project structure
   - Package organization
   - Implementation guidelines

---

## Examples

### Example 1: Salary Processing

**File**: `examples/Salary.lts`

Process employee salary data through multiple transformations:
- Load employee, worked hours, and category data
- Remove duplicates
- Join with hours and categories
- Calculate payments
- Group by department

**Demonstrates**: Multiple data sources, joins with aggregation, calculated columns, grouping, filtering

### Example 2: Invoicing

**File**: `examples/Invoicing.lts`

Process sales data to generate invoices:
- Load clients, products, and sales
- Join tables to enrich data
- Calculate line totals
- Group by customer

**Demonstrates**: Complex joins, calculated columns, grouping with aggregations

### Example 3: Grading

**File**: `examples/Grading.lts`

Process student grades:
- Load student, course, and exam data
- Join with metadata
- Calculate average scores
- Assign letter grades
- Filter and sort results

**Demonstrates**: Complex grouping, conditional calculations, filtering, sorting

### Invalid Examples

Five invalid examples demonstrate validation:
- Type mismatch in conditions
- Undefined table references
- Duplicate column definitions
- Undefined column references
- Type mismatch in joins

---

## Supported Operations

| Operation | Description | Example |
|-----------|-------------|---------|
| **load** | Import data from CSV | `load employees from employees_source;` |
| **save** | Export table to CSV | `save results to "output.csv";` |
| **filter** | Filter rows by condition | `filter employees where salary > 50000;` |
| **sort** | Sort by columns | `sort employees by name ascending;` |
| **join** | Combine tables | `join orders customers on orders.cust_id = customers.id;` |
| **group** | Group and aggregate | `group sales by customer { total: sum(amount) };` |
| **aggregate** | Aggregate entire table | `aggregate orders { total: sum(amount) };` |
| **calculate** | Computed column | `calculate column bonus in employees as salary * 0.1;` |
| **insert** | Add column | `insert column status into results of type String;` |
| **remove** | Delete column/rows | `remove column temp from results;` |
| **remove duplicates** | Deduplicate rows | `remove duplicates from employees based on id;` |
| **string ops** | String transformations | `concatenate column full_name in users from first, last;` |

---

## Data Types

| Type | Description | Range/Format |
|------|-------------|--------------|
| **String** | Text | Unlimited length |
| **Integer** | Whole numbers | -2,147,483,648 to 2,147,483,647 |
| **Decimal** | Floating point | IEEE 754 double precision |
| **Boolean** | True/false | true \| false |
| **Date** | ISO 8601 date | YYYY-MM-DD |
| **Time** | Time of day | HH:MM:SS |
| **DateTime** | Date and time | YYYY-MM-DD HH:MM:SS |

---

## Validation Rules

The validator enforces:

✓ **Syntax Errors**
  - Grammar violations

✓ **Semantic Errors**
  - Undefined tables
  - Undefined columns
  - Duplicate column names
  - Incomplete process definitions

✓ **Type Errors**
  - Type mismatches in expressions
  - Incompatible join columns
  - Wrong aggregation types

✓ **Logical Errors**
  - Missing output block
  - Missing operations
  - Circular references (warning)

---

## Running Generated Code

### Compilation

```bash
cd org.xtext.example.copilotdsl/src-gen

javac -cp ".:commons-csv-1.9.0.jar" \
  org/etl/generated/SalaryProcessProcessor.java
```

### Execution

```bash
java -cp ".:commons-csv-1.9.0.jar" \
  org.etl.generated.SalaryProcessProcessor
```

### With Options

```bash
java -Dlts.debug=true \
     -Dlts.data.dir=/path/to/data \
     -Dlts.output.dir=/path/to/output \
     -cp ".:commons-csv-1.9.0.jar" \
     org.etl.generated.SalaryProcessProcessor
```

---

## Extension Points

### Adding Custom Validators

```xtend
@Check
def myCustomCheck(MyElement element) {
    if (!isValid(element)) {
        error("Error message", element, MyPackage.Literals.PROPERTY)
    }
}
```

### Adding Custom Functions

```java
public class MyCustomFunction implements ExternalFunction {
    @Override
    public Object apply(List<Object> params) {
        // Custom logic
    }
    
    @Override
    public String getName() { return "myFunction"; }
    
    @Override
    public Class<?> getReturnType() { return Double.class; }
}
```

### Extending Generated Code

Generated processor classes can be extended:

```java
public class CustomSalaryProcessor extends SalaryProcessProcessor {
    @Override
    protected void transform() throws IOException {
        super.transform();
        myCustomLogic();
    }
}
```

---

## Quick Fixes

Available quick fixes for common errors:

| Issue | Quick Fix | Result |
|-------|-----------|--------|
| Duplicate column | Remove duplicate | Column removed |
| Undefined table | Create table | Table skeleton created |
| Undefined column | Create column | Column added |
| Type mismatch | Add conversion | Cast added |
| Missing output | Add output block | Template added |

---

## Performance Characteristics

- **Parsing**: O(n) where n = file size
- **Validation**: O(n·m) where m = operations count
- **Generation**: O(n·m) producing Java code
- **Runtime**: Depends on data size and operation complexity
- **Memory**: Proportional to table sizes in memory

---

## Limitations and Future Work

### Current Limitations

- Single-file processes (no modular processes)
- No windowing functions
- Limited SQL mapping
- No distributed processing

### Planned Enhancements

- ✓ Process composition/modularization
- ✓ SQL backend support
- ✓ Windowing functions
- ✓ Machine learning integration
- ✓ Visual editor
- ✓ Cloud deployment templates

---

## Troubleshooting

### Common Issues

**Q: Parser error on valid syntax**
- A: Check SYNTAX_GUIDE.md for correct syntax

**Q: "Table not found" error**
- A: Ensure table is defined before use; use Ctrl+1 quick fix

**Q: Type mismatch in join**
- A: Verify join columns have compatible types

**Q: Generated code won't compile**
- A: Ensure Apache Commons CSV is on classpath

### Debug Mode

Enable debug output:
```bash
java -Dlts.debug=true -jar processor.jar
```

---

## Support and Resources

- **Grammar Reference**: `src/org/xtext/example/mydsl/Lts.xtext`
- **Examples**: `examples/` directory
- **Documentation**: `doc/` directory
- **Validation Rules**: `src/.../LtsValidator.xtend`
- **Code Generator**: `src/.../LtsGenerator.xtend`

---

## Version History

| Version | Date | Features |
|---------|------|----------|
| 1.0 | 2026-06-25 | Initial release with core DSL features |

---

## License

[License information to be added]

---

## Contributors

- Generated by Xtext 2.26+
- Implemented using Eclipse IDE platform

---

## Contact

For issues, suggestions, or contributions:
- Review documentation in `doc/` folder
- Check examples in `examples/` folder
- Consult SYNTAX_GUIDE.md for language reference

---

**Created**: 2026-06-25  
**Status**: Stable Release  
**Compatibility**: Eclipse IDE 2021.12+, Java 11+
