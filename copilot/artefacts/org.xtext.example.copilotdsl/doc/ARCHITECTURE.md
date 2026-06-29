# LTS DSL Architecture Documentation

## 1. System Architecture Overview

### 1.1 High-Level Components

```
┌─────────────────────────────────────────────────────────────┐
│                     LTS DSL System                          │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│  ┌──────────────────────────────────────────────────────┐   │
│  │  Eclipse IDE / Editor                                │   │
│  │  ├─ Syntax Highlighting                             │   │
│  │  ├─ Content Assist (Ctrl+Space)                    │   │
│  │  ├─ Quick Fixes (Ctrl+1)                           │   │
│  │  └─ Navigation (F3)                                │   │
│  └──────────────────────────────────────────────────────┘   │
│                           │                                  │
│                           ▼                                  │
│  ┌──────────────────────────────────────────────────────┐   │
│  │  Xtext Runtime                                        │   │
│  │  ├─ Parser (ANTLR)                                  │   │
│  │  ├─ Lexer                                           │   │
│  │  ├─ Linker                                          │   │
│  │  └─ Resource Manager                               │   │
│  └──────────────────────────────────────────────────────┘   │
│                           │                                  │
│          ┌────────────────┼────────────────┐                │
│          ▼                ▼                ▼                │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐      │
│  │ Validator    │  │ Generator    │  │ Linker       │      │
│  │              │  │              │  │              │      │
│  │- Semantic    │  │- Xtend Code  │  │- References  │      │
│  │  checks      │  │  gen         │  │- Resolution  │      │
│  │- Type safety │  │- Java output │  │              │      │
│  │- Reference   │  │              │  │              │      │
│  │  validation  │  │              │  │              │      │
│  └──────────────┘  └──────────────┘  └──────────────┘      │
│          │                ▼                                  │
│          │          ┌──────────────┐                        │
│          │          │Generated Java│                        │
│          │          │   Code       │                        │
│          │          │              │                        │
│          │          │ *.java files │                        │
│          │          └──────────────┘                        │
│          │                ▼                                  │
│          │          ┌──────────────┐                        │
│          │          │  Compilation │                        │
│          │          │   & Linking  │                        │
│          │          └──────────────┘                        │
│          │                ▼                                  │
│          └──────────────→ Runtime Execution                │
│                                                              │
└─────────────────────────────────────────────────────────────┘
```

### 1.2 Processing Pipeline

```
Input File (.lts)
       │
       ▼
┌──────────────┐
│  Lexer/Parser│
├──────────────┤
│ Tokenize and │
│  build AST   │
└──────────────┘
       │
       ▼
┌──────────────┐
│  Linker      │
├──────────────┤
│ Resolve      │
│ references   │
└──────────────┘
       │
       ▼
┌──────────────┐
│ Validator    │
├──────────────┤
│ Check semantic│
│ constraints  │
└──────────────┘
       │
       ├─── [Errors Found] ──→ Report Errors
       │
       └─── [OK] ──→ ┌──────────────┐
                     │  Generator   │
                     ├──────────────┤
                     │ Transform    │
                     │ to Java      │
                     └──────────────┘
                             │
                             ▼
                     Generated Java Code
                             │
                             ▼
                     Java Compiler (javac)
                             │
                             ▼
                     Executable JAR/Binary
```

---

## 2. Grammar Architecture

### 2.1 Grammar Hierarchy

```
Model
  └─ LtsProcess*
      ├─ name: ID
      ├─ dataSources: DataSource*
      │   └─ CsvDataSource
      │       ├─ name: ID
      │       ├─ filePath: STRING
      │       └─ columns: Column*
      │
      ├─ tables: Table*
      │   ├─ name: ID
      │   └─ columns: Column*
      │
      ├─ operations: Operations
      │   └─ steps: Step*
      │       ├─ LoadStep
      │       ├─ SaveStep
      │       ├─ FilterStep
      │       ├─ SortStep
      │       ├─ JoinStep
      │       ├─ GroupStep
      │       ├─ CalculatedColumnStep
      │       ├─ RemoveColumnStep
      │       ├─ InsertColumnStep
      │       ├─ RemoveDuplicatesStep
      │       ├─ StringConcatenationStep
      │       ├─ StringSplitStep
      │       ├─ StringExtractionStep
      │       ├─ StringToUpperStep
      │       ├─ StringToLowerStep
      │       ├─ StringTrimStep
      │       ├─ CustomFunctionStep
      │       └─ ... (more step types)
      │
      └─ output: Output
          └─ actions: OutputAction*
              ├─ SaveTableAction
              └─ SaveLogAction

Column
  ├─ name: ID
  └─ type: DataType

Expression
  ├─ OrExpression
  ├─ AndExpression
  ├─ ComparisonExpression
  ├─ AdditiveExpression
  ├─ MultiplicativeExpression
  ├─ UnaryExpression
  ├─ PrimaryExpression
  └─ Literal
```

### 2.2 Expression Grammar (Precedence)

```
Lowest Precedence
    │
    ▼ or (||)
    │
    ▼ and (&&)
    │
    ▼ Comparisons (=, !=, <, >, <=, >=)
    │
    ▼ Addition/Subtraction (+, -)
    │
    ▼ Multiplication/Division (*, /, %)
    │
    ▼ Unary (!,  not)
    │
    ▼ Power (^)
    │
    ▼ Function calls
    │
    ▼ Primary (literals, columns, parens)
    │
Highest Precedence
```

### 2.3 Lexical Structure

**Terminals**:
```
ID         : [a-zA-Z_][a-zA-Z0-9_]*
NUMBER     : [0-9]+(\.[0-9]+)?
STRING     : "[^"]*" | '[^']*'
WS         : [ \t\r\n]+
SL_COMMENT : //[^\r\n]* (\r? \n)?
ML_COMMENT : /* ... */
```

**Keywords** (60+):
```
process, csv, source, table, column, operation, load, save, filter,
sort, join, group, aggregate, append, lookup, remove, delete, create,
insert, calculate, by, from, to, where, on, of, type, preserving,
with, all, and, or, not, true, false, null, String, Integer, Decimal,
Boolean, Date, Time, DateTime, ...
```

---

## 3. Metamodel Architecture

### 3.1 Generated Metamodel

The Xtext generator creates an Ecore metamodel with:

**Packages**:
- `org.xtext.example.mydsl.lts`: Core metamodel classes
- `org.xtext.example.mydsl.lts.util`: Utility classes
- `org.xtext.example.mydsl.lts.impl`: Implementation classes

**Key Classes**:
```java
// Core classes (auto-generated from grammar)
LtsProcess {
    String name
    List<DataSource> dataSources
    List<Table> tables
    Operations operations
    Output output
}

Table {
    String name
    List<Column> columns
}

Column {
    String name
    DataType type
}

Operations {
    List<Step> steps
}

Step (abstract)
├─ LoadStep
├─ SaveStep
├─ FilterStep
├─ SortStep
├─ JoinStep
├─ GroupStep
└─ ... (more)

Expression (abstract)
├─ OrExpression
├─ AndExpression
├─ ComparisonExpression
└─ ... (more)
```

### 3.2 Metamodel Generation

```
Lts.xtext
    │
    └──→ [Xtext Generator]
        ├──→ LtsFactory.java
        ├──→ LtsPackage.java
        ├──→ Lts*.java (all model classes)
        ├──→ Lts*Impl.java (implementations)
        ├──→ Serializer.java
        ├──→ Scoping.xtend
        └──→ Formatting.xtend
```

---

## 4. Validation Architecture

### 4.1 Validator Structure

```
AbstractValidator (Xtext base)
    │
    └─ LtsValidator (Custom)
        ├─ @Check checkLtsProcess()
        ├─ @Check checkTable()
        ├─ @Check checkCsvDataSource()
        ├─ @Check checkFilterStep()
        ├─ @Check checkJoinStep()
        ├─ @Check checkLoadStep()
        ├─ @Check checkRemoveColumnStep()
        ├─ @Check checkInsertColumnStep()
        ├─ @Check checkCalculatedColumnStep()
        ├─ @Check checkRemoveDuplicatesStep()
        ├─ @Check checkSortStep()
        ├─ @Check checkGroupStep()
        │
        └─ Helper Methods
            ├─ buildTableMap()
            ├─ tableExists()
            ├─ columnExists()
            ├─ getColumnType()
            └─ checkExpressionColumns()
```

### 4.2 Validation Flow

```
Parse Model
    │
    ▼
Build Table Map
    │ (Collects all tables and columns)
    │
    ▼
Check Each Rule
    ├─ Duplicate columns?
    ├─ Table exists?
    ├─ Column exists?
    ├─ Type compatibility?
    └─ All required blocks present?
    │
    ▼
Report Issues
    ├─ Errors (prevent generation)
    └─ Warnings (suggestions)
```

### 4.3 Error Categories

| Category | Severity | Impact | Examples |
|----------|----------|--------|----------|
| Syntax | Error | Parse fails | Missing semicolon |
| Semantic | Error | Won't generate | Undefined table |
| Type | Error/Warning | May fail at runtime | Type mismatch |
| Constraint | Error | Violates rule | Duplicate column |
| Logical | Warning | May cause issues | Unused column |

---

## 5. Code Generation Architecture

### 5.1 Generator Pipeline

```
LtsProcess Model (EMF)
    │
    ├─ Extract metadata
    │   ├─ Table schemas
    │   ├─ Column types
    │   ├─ Operation sequence
    │   └─ Output targets
    │
    ▼
┌──────────────────────────┐
│  Xtend Template System   │
├──────────────────────────┤
│ generateProcessCode()    │
│ ├─ Package header       │
│ ├─ Imports              │
│ ├─ Class definition     │
│ ├─ Constants            │
│ ├─ execute() method     │
│ ├─ Helper methods       │
│ └─ Inner classes        │
└──────────────────────────┘
    │
    ▼
Generated Java Source Code
    │
    ├─ Class files
    ├─ Inner classes
    ├─ Static initializers
    └─ Main method
    │
    ▼
Java Compilation
    │
    ▼
Bytecode (.class)
```

### 5.2 Generated Code Structure

```java
public class SalaryProcessProcessor {
    
    // Constants
    private static final String SOURCE_EMPLOYEES = "data/employees.csv";
    private static final String SOURCE_WORKED_HOURS = "data/worked_hours.csv";
    
    // Instance state
    private Map<String, Table> tables;
    private List<String> warnings;
    private List<String> errors;
    
    // Entry point
    public static void main(String[] args) {
        new SalaryProcessProcessor().execute();
    }
    
    // Main execution method
    public void execute() throws IOException {
        // 1. Initialize tables
        // 2. Load data
        // 3. Execute transformations
        // 4. Save results
        // 5. Save logs
    }
    
    // Operation methods
    private void loadTableFromCSV(...) { }
    private void saveTableToCSV(...) { }
    private void filterTable(...) { }
    
    // Utility methods
    private void addWarning(String msg) { }
    private void addError(String msg) { }
    
    // Inner Table class
    private static class Table {
        private Map<String, Object>[] rows;
        public void addRow(...) { }
        public void removeColumn(...) { }
    }
}
```

### 5.3 Type Mapping

```
LTS Type           Java Type              Description
─────────────────────────────────────────────────────
String         →   java.lang.String       Text data
Integer        →   java.lang.Integer      Whole numbers
Decimal        →   java.lang.Double       Floating point
Boolean        →   java.lang.Boolean      True/false
Date           →   java.time.LocalDate    YYYY-MM-DD
Time           →   java.time.LocalTime    HH:MM:SS
DateTime       →   java.time.LocalDateTime YYYY-MM-DD HH:MM:SS
```

### 5.4 CSV I/O Implementation

Uses **Apache Commons CSV**:

```java
// Reading
CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();
CSVParser parser = new CSVParser(reader, format);
for (CSVRecord record : parser) {
    table.addRow(convertRecord(record));
}

// Writing
CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
printer.printRecord(headers);
for (Row row : table.getRows()) {
    printer.printRecord(row.getValues());
}
```

---

## 6. Scoping and Cross-References

### 6.1 Scope Provider

```
LtsScopeProvider extends AbstractDeclarativeScopeProvider
    │
    ├─ scope_LoadStep_sourceName()
    │   └─ Returns: CsvDataSource names
    │
    ├─ scope_LoadStep_sourceTable()
    │   └─ Returns: Table names
    │
    ├─ scope_FilterStep_tableName()
    │   └─ Returns: Table names
    │
    ├─ scope_JoinStep_leftTable/rightTable()
    │   └─ Returns: Table names
    │
    ├─ scope_ColumnRef_column()
    │   └─ Returns: Columns in specified table
    │
    └─ scope_Expression_column()
        └─ Returns: Columns based on context
```

### 6.2 Reference Resolution

```
Column Reference (table.column)
    │
    ├─ Resolve 'table' name
    │   └─ Lookup in tableMap
    │
    └─ Resolve 'column' name
        ├─ If table exists
        │   └─ Lookup column in table schema
        │
        └─ If not found
            └─ Report error
```

---

## 7. IDE Features Architecture

### 7.1 Content Assist (Ctrl+Space)

```
ContentAssistProvider
    │
    ├─ Local suggestions
    │   ├─ Keywords based on context
    │   ├─ Table names (after 'from')
    │   ├─ Column names (after 'where')
    │   └─ Function names (after 'call')
    │
    ├─ Cross-file suggestions
    │   ├─ Defined tables
    │   ├─ Defined sources
    │   └─ Available functions
    │
    └─ Proposals
        ├─ Keywords matching prefix
        ├─ Symbols matching prefix
        └─ Auto-completion text
```

### 7.2 Hover Information (F2)

```
HoverProvider
    │
    ├─ Hover on keyword
    │   └─ Show keyword documentation
    │
    ├─ Hover on table
    │   └─ Show table schema
    │
    ├─ Hover on column
    │   └─ Show column type and table
    │
    └─ Hover on function
        └─ Show function signature
```

### 7.3 Quick Fixes (Ctrl+1)

```
QuickfixProvider
    │
    ├─ Duplicate column
    │   └─ Remove duplicate
    │
    ├─ Undefined table
    │   ├─ Create table
    │   └─ Choose from existing
    │
    ├─ Undefined column
    │   ├─ Create column
    │   └─ Choose from existing
    │
    ├─ Type mismatch
    │   ├─ Add type conversion
    │   └─ Change join condition
    │
    └─ Missing output
        └─ Add output block
```

### 7.4 Refactoring

```
RefactoringProvider
    │
    ├─ Rename table
    ├─ Rename column
    ├─ Extract operations
    ├─ Inline operation
    ├─ Combine filters
    └─ Simplify joins
```

---

## 8. Build and Deployment Architecture

### 8.1 Build Structure

```
org.xtext.example.copilotdsl (Core Plugin)
    ├─ Manifest.mf
    ├─ build.properties
    ├─ pom.xml (Maven config)
    ├─ GenerateMyDsl.mwe2 (Xtext generator config)
    │
    ├─ src/
    │   └─ Lts.xtext
    │
    └─ src-gen/ (Generated by Xtext)
        ├─ Lts*.java (Metamodel)
        ├─ LtsGrammarAccess.java
        ├─ LtsValueConverter.java
        └─ ... (more generated)

org.xtext.example.copilotdsl.ui (UI Plugin)
    ├─ src/
    │   ├─ quickfix/LtsQuickfixProvider.xtend
    │   ├─ labeling/LtsLabelProvider.xtend
    │   ├─ outline/LtsOutlineTreeProvider.xtend
    │   └─ ... (more UI components)
    │
    └─ plugin.xml (Eclipse extension registration)

org.xtext.example.copilotdsl.tests (Test Plugin)
    └─ src/
        └─ *Test.xtend
```

### 8.2 Compilation Process

```
Xtext MWE2 Workflow
    │
    ├─ Parse Lts.xtext grammar
    ├─ Validate grammar rules
    ├─ Generate Ecore metamodel
    ├─ Generate ANTLR parser
    ├─ Generate Xtext infrastructure
    └─ Generate builder/validator stubs
        │
        ▼
    Xtend Compilation
        │
        ├─ Compile LtsValidator.xtend
        ├─ Compile LtsGenerator.xtend
        ├─ Compile LtsQuickfixProvider.xtend
        └─ Compile other .xtend files
            │
            ▼
        Java Compilation
            │
            └─ Compile all .java files
                │
                ▼
            Package as OSGi Plugins
                │
                └─ Create .jar bundles
```

---

## 9. Runtime Architecture

### 9.1 Runtime Components

```
Eclipse Runtime
    │
    ├─ Equinox OSGi Container
    │   │
    │   ├─ Core Plugins
    │   │   ├─ org.eclipse.emf.ecore
    │   │   ├─ org.eclipse.xtext
    │   │   └─ org.eclipse.xtext.xbase
    │   │
    │   ├─ LTS DSL Plugins
    │   │   ├─ org.xtext.example.copilotdsl
    │   │   ├─ org.xtext.example.copilotdsl.ui
    │   │   └─ org.xtext.example.copilotdsl.ide
    │   │
    │   └─ UI/Editor Plugin
    │       ├─ org.eclipse.ui
    │       ├─ org.eclipse.jface
    │       └─ org.eclipse.swt
    │
    └─ Services
        ├─ Parser Service
        ├─ Validator Service
        ├─ Generator Service
        ├─ Scoping Service
        └─ Linking Service
```

### 9.2 Document Lifecycle

```
User opens .lts file
    │
    ▼
Editor instantiated
    │
    ├─ Set editor input
    ├─ Load resource (EMF)
    │   └─ Parse model
    │
    ▼
Lexing & Parsing
    │
    ├─ Tokenize input
    ├─ Build parse tree
    └─ Create EMF model
        │
        ▼
Linking
    │
    └─ Resolve cross-references
        │
        ▼
Validation
    │
    ├─ Run validators
    ├─ Collect issues
    └─ Publish diagnostics
        │
        ▼
Display in Editor
    │
    ├─ Syntax highlighting
    ├─ Error/warning markers
    ├─ Outline view
    └─ Content assist ready
```

### 9.3 Incremental Build

```
File modified
    │
    ▼
Change notification
    │
    ├─ Minimal reparse (changed region only)
    ├─ Incremental validation
    └─ Selective regeneration
        │
        ▼
Update markers
    │
    └─ Minimal UI refresh
```

---

## 10. Extension Points

### 10.1 Adding Custom Validators

```xtend
@Check
def checkMyCustomRule(MyElement element) {
    if (!isValid(element)) {
        error("Error message",
            element, 
            MyPackage.Literals.MY_PROPERTY,
            "CUSTOM_CODE")
    }
}
```

### 10.2 Adding Custom Operations

1. Add grammar rule:
```xtext
MyCustomStep:
    'my_operation' ...;
```

2. Add validation:
```xtend
@Check
def checkMyCustomStep(MyCustomStep step) { ... }
```

3. Add code generation:
```xtend
def String generateMyCustomStep(MyCustomStep step) { ... }
```

4. Add quick fixes:
```xtend
@Fix("MY_CUSTOM_ERROR")
def fixMyCustomError(Issue issue, IssueResolutionAcceptor acceptor) { ... }
```

### 10.3 Adding Custom Functions

1. Implement interface:
```java
public class MyCustomFunction implements ExternalFunction { ... }
```

2. Register in generator:
```xtend
def registerFunction(ExternalFunction func) { ... }
```

3. Reference in LTS:
```lts
call function myFunction(...) returning result in table;
```

---

## 11. Performance Optimization

### 11.1 Parser Optimization
- Incremental parsing for large files
- Lazy linking for cross-references
- Caching of parsed models

### 11.2 Validation Optimization
- Selective validation (only changed parts)
- Parallel validation of independent rules
- Early termination on critical errors

### 11.3 Generation Optimization
- Template caching
- Incremental code generation
- Minimal file rewrites

---

## 12. Troubleshooting Architecture

### 12.1 Common Issues and Resolution

| Issue | Cause | Resolution |
|-------|-------|-----------|
| Parser error | Syntax mistake | Check SYNTAX_GUIDE.md |
| Undefined table | Table not defined | Use Ctrl+1 quick fix |
| Type mismatch | Wrong column type | Verify column schema |
| Generation fails | Validation error | Check error markers |
| Runtime error | Logic error in process | Add logging steps |

### 12.2 Debug Output

```
Enable logging:
├─ Set DEBUG environment variable
├─ Check error log view
├─ Review generated .java files
└─ Check console output
```

---

**Version**: 1.0  
**Last Updated**: 2026-06-25  
**Status**: Complete
