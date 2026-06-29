# LTS DSL - Generated Code Architecture and Implementation Guide

## 1. Generated Code Overview

### 1.1 Code Generation Strategy

The LTS code generator produces standalone Java applications that execute ETL processes without requiring Excel or the DSL runtime. Each process generates:

- **Main Processor Class**: Contains execution logic
- **Table Class**: In-memory data structure
- **Helper Classes**: For specific operations
- **Main Method**: Entry point for standalone execution

### 1.2 Generated Code Features

| Feature | Implementation | Benefits |
|---------|-----------------|----------|
| Type Safety | Java strong typing | Compile-time error detection |
| Exception Handling | Try-catch blocks | Graceful error handling |
| Logging | Separate warnings/errors | Audit trail |
| Memory Management | Java GC | Automatic cleanup |
| Extensibility | Protected methods | Custom implementations |
| Performance | Direct Java code | No interpretation overhead |

---

## 2. Generated Processor Structure

### 2.1 Basic Template

```java
package org.etl.generated;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import org.apache.commons.csv.*;

/**
 * Generated ETL Process: [ProcessName]
 * Auto-generated from LTS DSL model
 * Date: 2026-06-25
 * 
 * Usage:
 *   java org.etl.generated.[ClassName] [input-data-dir]
 */
public class [ClassName]Processor {
    
    // === Configuration Constants ===
    private static final String BASE_DIR = "./data";
    private static final String OUTPUT_DIR = "./output";
    private static final String LOG_DIR = "./logs";
    
    // === Instance Variables ===
    private Map<String, Table> tables;
    private List<String> warnings;
    private List<String> errors;
    private boolean debugMode;
    
    // === Constructor ===
    public [ClassName]Processor() {
        this.tables = new LinkedHashMap<>();
        this.warnings = new ArrayList<>();
        this.errors = new ArrayList<>();
        this.debugMode = Boolean.getBoolean("lts.debug");
    }
    
    // === Main Entry Point ===
    public static void main(String[] args) {
        try {
            [ClassName]Processor processor = new [ClassName]Processor();
            int exitCode = processor.execute();
            System.exit(exitCode);
        } catch (Exception e) {
            System.err.println("Fatal error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    // === Execution Method ===
    public int execute() throws IOException {
        System.out.println("Starting ETL Process: [ProcessName]");
        long startTime = System.currentTimeMillis();
        
        try {
            // 1. Initialize tables
            initializeTables();
            
            // 2. Load data
            loadData();
            
            // 3. Execute transformations
            transform();
            
            // 4. Save results
            saveResults();
            
            // 5. Save logs
            saveLogs();
            
            long duration = System.currentTimeMillis() - startTime;
            System.out.println("Process completed successfully in " + duration + "ms");
            
            if (errors.isEmpty()) {
                System.out.println("No errors. Status: SUCCESS");
                return 0;
            } else {
                System.out.println("Errors encountered. Status: PARTIAL");
                return 1;
            }
        } catch (Exception e) {
            addError("Process execution failed: " + e.getMessage());
            saveLogs();
            System.out.println("Process failed. Status: FAILURE");
            return 1;
        }
    }
    
    // === Phase Methods ===
    
    private void initializeTables() {
        // Create table schema definitions
        // Example:
        tables.put("employees", new Table("employees", 
            Arrays.asList("emp_id", "name", "salary")));
        
        if (debugMode) {
            System.out.println("Tables initialized: " + tables.size());
        }
    }
    
    private void loadData() throws IOException {
        // Load data from CSV sources
    }
    
    private void transform() throws IOException {
        // Execute transformation steps
    }
    
    private void saveResults() throws IOException {
        // Save output tables
    }
    
    private void saveLogs() throws IOException {
        // Write log file
    }
    
    // === Utility Methods ===
    
    public void addWarning(String message) {
        warnings.add(message);
        if (debugMode) {
            System.out.println("WARNING: " + message);
        }
    }
    
    public void addError(String message) {
        errors.add(message);
        System.err.println("ERROR: " + message);
    }
    
    public List<String> getWarnings() {
        return Collections.unmodifiableList(warnings);
    }
    
    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }
    
    // === Internal Table Class ===
    
    private static class Table {
        private String name;
        private List<String> columns;
        private List<Map<String, Object>> rows;
        
        public Table(String name, List<String> columns) {
            this.name = name;
            this.columns = new ArrayList<>(columns);
            this.rows = new ArrayList<>();
        }
        
        public void addRow(Map<String, Object> row) {
            rows.add(new LinkedHashMap<>(row));
        }
        
        public void addColumn(String columnName) {
            if (!columns.contains(columnName)) {
                columns.add(columnName);
                // Initialize column for all existing rows
                for (Map<String, Object> row : rows) {
                    row.put(columnName, null);
                }
            }
        }
        
        public void removeColumn(String columnName) {
            columns.remove(columnName);
            for (Map<String, Object> row : rows) {
                row.remove(columnName);
            }
        }
        
        public int getRowCount() {
            return rows.size();
        }
        
        public List<String> getColumns() {
            return new ArrayList<>(columns);
        }
        
        public List<Map<String, Object>> getRows() {
            return new ArrayList<>(rows);
        }
        
        public void clear() {
            rows.clear();
        }
    }
}
```

---

## 3. Operation Implementation Patterns

### 3.1 Load Operation

```java
private void loadTableFromCSV(String sourceName, String tableName) 
        throws IOException {
    
    String filePath = BASE_DIR + "/" + sourceName + ".csv";
    System.out.println("Loading " + sourceName + " into " + tableName);
    
    File file = new File(filePath);
    if (!file.exists()) {
        addError("Source file not found: " + filePath);
        return;
    }
    
    Table table = tables.get(tableName);
    if (table == null) {
        addError("Table not found: " + tableName);
        return;
    }
    
    try (Reader in = new FileReader(file)) {
        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();
        CSVParser parser = new CSVParser(in, format);
        
        int rowCount = 0;
        for (CSVRecord record : parser) {
            Map<String, Object> row = new LinkedHashMap<>();
            for (String columnName : table.getColumns()) {
                String value = record.get(columnName);
                row.put(columnName, parseValue(value, columnName, tableName));
            }
            table.addRow(row);
            rowCount++;
        }
        
        System.out.println("Loaded " + rowCount + " rows into " + tableName);
    } catch (IOException e) {
        addError("Failed to load " + sourceName + ": " + e.getMessage());
    }
}

private Object parseValue(String value, String columnName, String tableName) {
    // Determine column type and parse accordingly
    // This would be customized based on the table schema
    if (value == null || value.trim().isEmpty()) {
        return null;
    }
    
    try {
        // Try numeric first
        if (value.matches("-?\\d+")) {
            return Integer.parseInt(value);
        }
        if (value.matches("-?\\d*\\.\\d+")) {
            return Double.parseDouble(value);
        }
        
        // Try date
        if (value.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return LocalDate.parse(value);
        }
        
        // Default to string
        return value;
    } catch (Exception e) {
        addWarning("Failed to parse value '" + value + "' for " + 
                   tableName + "." + columnName);
        return value;
    }
}
```

### 3.2 Filter Operation

```java
private void filterTable(String tableName, FilterPredicate predicate) {
    Table table = tables.get(tableName);
    if (table == null) {
        addError("Table not found: " + tableName);
        return;
    }
    
    System.out.println("Filtering " + tableName);
    
    List<Map<String, Object>> filtered = new ArrayList<>();
    int originalCount = table.getRowCount();
    
    for (Map<String, Object> row : table.getRows()) {
        try {
            if (predicate.test(row)) {
                filtered.add(row);
            }
        } catch (Exception e) {
            addWarning("Error evaluating filter on row: " + e.getMessage());
        }
    }
    
    table.clear();
    for (Map<String, Object> row : filtered) {
        table.addRow(row);
    }
    
    System.out.println("Filter result: " + originalCount + " → " + 
                       table.getRowCount() + " rows");
}

// Predicate interface
private interface FilterPredicate {
    boolean test(Map<String, Object> row);
}
```

### 3.3 Sort Operation

```java
private void sortTable(String tableName, List<SortKey> sortKeys) {
    Table table = tables.get(tableName);
    if (table == null) {
        addError("Table not found: " + tableName);
        return;
    }
    
    System.out.println("Sorting " + tableName);
    
    List<Map<String, Object>> rows = new ArrayList<>(table.getRows());
    
    rows.sort((row1, row2) -> {
        for (SortKey key : sortKeys) {
            Object val1 = row1.get(key.column);
            Object val2 = row2.get(key.column);
            
            int cmp = compareValues(val1, val2);
            if (cmp != 0) {
                return key.descending ? -cmp : cmp;
            }
        }
        return 0;
    });
    
    table.clear();
    for (Map<String, Object> row : rows) {
        table.addRow(row);
    }
}

private int compareValues(Object o1, Object o2) {
    if (o1 == null && o2 == null) return 0;
    if (o1 == null) return -1;
    if (o2 == null) return 1;
    
    if (o1 instanceof Comparable && o2 instanceof Comparable) {
        return ((Comparable) o1).compareTo(o2);
    }
    
    return o1.toString().compareTo(o2.toString());
}

private static class SortKey {
    String column;
    boolean descending;
    
    SortKey(String column, boolean descending) {
        this.column = column;
        this.descending = descending;
    }
}
```

### 3.4 Join Operation

```java
private void joinTables(String leftTableName, String rightTableName,
        String leftColumn, String rightColumn,
        boolean leftOuter, Aggregator aggregator) {
    
    Table leftTable = tables.get(leftTableName);
    Table rightTable = tables.get(rightTableName);
    
    if (leftTable == null || rightTable == null) {
        addError("One or both tables not found");
        return;
    }
    
    System.out.println("Joining " + leftTableName + " with " + 
                       rightTableName);
    
    // Build index on right table
    Map<Object, List<Map<String, Object>>> rightIndex = new HashMap<>();
    for (Map<String, Object> row : rightTable.getRows()) {
        Object key = row.get(rightColumn);
        rightIndex.computeIfAbsent(key, k -> new ArrayList<>())
                  .add(row);
    }
    
    // Perform join
    List<Map<String, Object>> result = new ArrayList<>();
    Set<Object> matchedKeys = new HashSet<>();
    
    for (Map<String, Object> leftRow : leftTable.getRows()) {
        Object key = leftRow.get(leftColumn);
        List<Map<String, Object>> rightRows = rightIndex.get(key);
        
        if (rightRows != null && !rightRows.isEmpty()) {
            matchedKeys.add(key);
            for (Map<String, Object> rightRow : rightRows) {
                Map<String, Object> joined = new LinkedHashMap<>(leftRow);
                joined.putAll(rightRow);
                result.add(joined);
            }
        } else if (leftOuter) {
            result.add(new LinkedHashMap<>(leftRow));
        }
    }
    
    // Update left table with results
    leftTable.clear();
    for (Map<String, Object> row : result) {
        leftTable.addRow(row);
    }
    
    System.out.println("Join produced " + result.size() + " rows");
}
```

### 3.5 Group and Aggregate

```java
private void groupAndAggregate(String tableName,
        List<String> groupColumns,
        Map<String, AggregationFunc> aggregations) {
    
    Table table = tables.get(tableName);
    if (table == null) {
        addError("Table not found: " + tableName);
        return;
    }
    
    System.out.println("Grouping " + tableName + " by " + groupColumns);
    
    // Build groups
    Map<String, List<Map<String, Object>>> groups = new LinkedHashMap<>();
    
    for (Map<String, Object> row : table.getRows()) {
        StringBuilder keyBuilder = new StringBuilder();
        for (String col : groupColumns) {
            keyBuilder.append(row.get(col)).append("|");
        }
        String key = keyBuilder.toString();
        
        groups.computeIfAbsent(key, k -> new ArrayList<>())
              .add(row);
    }
    
    // Apply aggregations
    List<Map<String, Object>> result = new ArrayList<>();
    
    for (List<Map<String, Object>> group : groups.values()) {
        Map<String, Object> aggregatedRow = new LinkedHashMap<>();
        
        // Add group columns
        Map<String, Object> firstRow = group.get(0);
        for (String col : groupColumns) {
            aggregatedRow.put(col, firstRow.get(col));
        }
        
        // Apply aggregations
        for (Map.Entry<String, AggregationFunc> agg : aggregations.entrySet()) {
            Object result_val = agg.getValue().aggregate(group);
            aggregatedRow.put(agg.getKey(), result_val);
        }
        
        result.add(aggregatedRow);
    }
    
    // Update table
    table.clear();
    for (Map<String, Object> row : result) {
        table.addRow(row);
    }
    
    System.out.println("Aggregation produced " + result.size() + " groups");
}

private interface AggregationFunc {
    Object aggregate(List<Map<String, Object>> rows);
}
```

### 3.6 Save Operation

```java
private void saveTableToCSV(String tableName, String filePath)
        throws IOException {
    
    Table table = tables.get(tableName);
    if (table == null) {
        addError("Table not found: " + tableName);
        return;
    }
    
    System.out.println("Saving " + tableName + " to " + filePath);
    
    // Create directory if needed
    File file = new File(filePath);
    file.getParentFile().mkdirs();
    
    try (Writer out = new FileWriter(file)) {
        CSVFormat format = CSVFormat.DEFAULT
            .withHeader(table.getColumns().toArray(new String[0]));
        CSVPrinter printer = new CSVPrinter(out, format);
        
        // Write header
        printer.printRecord(table.getColumns());
        
        // Write rows
        for (Map<String, Object> row : table.getRows()) {
            List<Object> values = new ArrayList<>();
            for (String column : table.getColumns()) {
                values.add(formatValue(row.get(column)));
            }
            printer.printRecord(values);
        }
        
        printer.flush();
        System.out.println("Saved " + table.getRowCount() + " rows");
    } catch (IOException e) {
        addError("Failed to save " + tableName + ": " + e.getMessage());
        throw e;
    }
}

private String formatValue(Object value) {
    if (value == null) {
        return "";
    }
    if (value instanceof LocalDate || value instanceof LocalTime || 
        value instanceof LocalDateTime) {
        return value.toString();
    }
    return value.toString();
}
```

---

## 4. Running Generated Code

### 4.1 Compilation

```bash
# Assuming generated code is in src-gen/
cd src-gen

# Compile with Apache Commons CSV on classpath
javac -cp ".:commons-csv-1.9.0.jar" \
  org/etl/generated/SalaryProcessProcessor.java

# Or using Maven
mvn compile
```

### 4.2 Execution

```bash
# Set data directory and run
java -Dlts.debug=true \
  -cp ".:commons-csv-1.9.0.jar" \
  org.etl.generated.SalaryProcessProcessor

# With custom data directory
java -Dlts.data.dir=/custom/data/path \
  org.etl.generated.SalaryProcessProcessor

# With output to specific directory
java -Dlts.output.dir=/custom/output/path \
  org.etl.generated.SalaryProcessProcessor
```

### 4.3 Configuration via System Properties

| Property | Default | Purpose |
|----------|---------|---------|
| `lts.debug` | false | Enable debug output |
| `lts.data.dir` | ./data | Input data directory |
| `lts.output.dir` | ./output | Output directory |
| `lts.log.dir` | ./logs | Log directory |
| `lts.log.level` | INFO | Logging level |

---

## 5. Extending Generated Code

### 5.1 Custom Operations

Add custom processing methods:

```java
// In generated processor class
private void myCustomOperation(String tableName) {
    Table table = tables.get(tableName);
    if (table == null) return;
    
    // Custom logic here
    for (Map<String, Object> row : table.getRows()) {
        // Process row
    }
}

// Call from transform() method
private void transform() throws IOException {
    // ... other operations ...
    myCustomOperation("my_table");
}
```

### 5.2 Custom Aggregations

```java
private Object customAggregate(List<Map<String, Object>> rows, 
                               String columnName,
                               String operation) {
    switch (operation) {
        case "PERCENTILE":
            return calculatePercentile(rows, columnName, 90);
        case "MEDIAN":
            return calculateMedian(rows, columnName);
        default:
            return null;
    }
}

private Double calculateMedian(List<Map<String, Object>> rows,
                               String columnName) {
    List<Double> values = new ArrayList<>();
    for (Map<String, Object> row : rows) {
        Object val = row.get(columnName);
        if (val instanceof Number) {
            values.add(((Number) val).doubleValue());
        }
    }
    
    Collections.sort(values);
    int size = values.size();
    return values.get(size / 2);
}
```

### 5.3 Custom Data Loaders

```java
private void loadFromDatabase(String tableName, String query) throws Exception {
    // Example: Load from JDBC data source
    Table table = tables.get(tableName);
    
    try (Connection conn = createDatabaseConnection()) {
        try (Statement stmt = conn.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    Map<String, Object> row = new LinkedHashMap<>();
                    for (String col : table.getColumns()) {
                        row.put(col, rs.getObject(col));
                    }
                    table.addRow(row);
                }
            }
        }
    }
}

private Connection createDatabaseConnection() throws Exception {
    return DriverManager.getConnection(
        "jdbc:mysql://localhost/mydb",
        "user",
        "password"
    );
}
```

---

## 6. Testing Generated Code

### 6.1 Unit Test Template

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SalaryProcessProcessorTest {
    
    private SalaryProcessProcessor processor;
    
    @BeforeEach
    void setUp() {
        processor = new SalaryProcessProcessor();
    }
    
    @Test
    void testExecutionSucceeds() throws IOException {
        int exitCode = processor.execute();
        assertEquals(0, exitCode);
    }
    
    @Test
    void testNoErrors() throws IOException {
        processor.execute();
        assertTrue(processor.getErrors().isEmpty());
    }
    
    @Test
    void testOutputGenerated() throws IOException {
        processor.execute();
        File output = new File("output/payments.csv");
        assertTrue(output.exists());
    }
}
```

### 6.2 Integration Test

```java
@Test
void testEndToEndProcess() throws Exception {
    // Setup test data
    setupTestData();
    
    // Run processor
    SalaryProcessProcessor processor = new SalaryProcessProcessor();
    int result = processor.execute();
    
    // Verify results
    assertEquals(0, result);
    verifyOutputFile("output/payments.csv");
    verifyLogFile("logs/salary_process.log");
    
    // Cleanup
    cleanupTestFiles();
}
```

---

## 7. Performance Optimization

### 7.1 Memory Efficiency

```java
// Stream large files instead of loading all into memory
private void streamProcessing(String tableName) throws IOException {
    File input = new File(BASE_DIR + "/" + tableName + ".csv");
    
    try (Reader in = new FileReader(input)) {
        CSVParser parser = CSVFormat.DEFAULT
            .withFirstRecordAsHeader()
            .parse(in);
        
        // Process row by row
        for (CSVRecord record : parser) {
            processRow(record);  // Don't accumulate in memory
        }
    }
}
```

### 7.2 Parallel Processing

```java
private void parallelSort(String tableName, List<SortKey> keys) {
    Table table = tables.get(tableName);
    
    List<Map<String, Object>> rows = table.getRows();
    
    // Use parallel stream for sorting
    rows.parallelStream()
        .sorted((r1, r2) -> compareRows(r1, r2, keys))
        .forEach(row -> {});  // Materialize
}
```

### 7.3 Index-Based Lookups

```java
// Build index for frequent lookups
private Map<Object, Map<String, Object>> buildIndex(String tableName,
                                                      String keyColumn) {
    Table table = tables.get(tableName);
    Map<Object, Map<String, Object>> index = new HashMap<>();
    
    for (Map<String, Object> row : table.getRows()) {
        Object key = row.get(keyColumn);
        index.put(key, new HashMap<>(row));
    }
    
    return index;
}
```

---

## 8. Error Handling and Logging

### 8.1 Log File Format

```
[2026-06-25T10:30:45] Start: SalaryProcess
[2026-06-25T10:30:45] Loading employees from employees.csv
[2026-06-25T10:30:46] Loaded 1000 rows
[2026-06-25T10:30:46] WARNING: Null salary for emp_id=5
[2026-06-25T10:30:47] Sorting by emp_id
[2026-06-25T10:31:00] Saving output to payments.csv
[2026-06-25T10:31:01] Saved 998 rows
[2026-06-25T10:31:01] ERROR: Failed to join with categories
[2026-06-25T10:31:01] End: SalaryProcess (Duration: 16s)
[2026-06-25T10:31:01] Status: PARTIAL (2 errors, 1 warning)
```

### 8.2 Exception Handling Pattern

```java
try {
    loadTableFromCSV("employees", "employees");
} catch (FileNotFoundException e) {
    addError("Input file not found: " + e.getMessage());
} catch (IOException e) {
    addError("I/O error while loading: " + e.getMessage());
} catch (Exception e) {
    addError("Unexpected error: " + e.getMessage());
    if (debugMode) {
        e.printStackTrace();
    }
}
```

---

## 9. Documentation in Generated Code

Every generated class includes:

```java
/**
 * Generated ETL Process: [ProcessName]
 * 
 * Source: [path/to/file.lts]
 * Generated: [date]
 * 
 * Process Description:
 * [Description from comments in LTS file]
 * 
 * Input Files:
 * - data/employees.csv
 * - data/departments.csv
 * 
 * Output Files:
 * - output/payments.csv
 * - logs/salary_process.log
 * 
 * Usage:
 *   java org.etl.generated.SalaryProcessProcessor [args]
 * 
 * Configuration:
 *   Set JVM properties:
 *   -Dlts.data.dir=/path/to/data
 *   -Dlts.output.dir=/path/to/output
 *   -Dlts.debug=true
 * 
 * Error Handling:
 *   - Returns 0 if successful
 *   - Returns 1 if any errors occurred
 *   - Writes detailed log to logs/[process].log
 * 
 * Author: [Generated by LTS DSL v1.0]
 */
```

---

## 10. Deployment

### 10.1 Package as JAR

```bash
# Compile
javac -d bin src-gen/org/etl/generated/*.java

# Create MANIFEST.MF
echo "Manifest-Version: 1.0" > MANIFEST.MF
echo "Main-Class: org.etl.generated.SalaryProcessProcessor" >> MANIFEST.MF

# Package JAR
jar cfm salary-processor.jar MANIFEST.MF -C bin .

# Add dependencies
jar uf salary-processor.jar commons-csv-1.9.0.jar
```

### 10.2 Package as Docker Image

```dockerfile
FROM openjdk:11-jre-slim

WORKDIR /app

COPY salary-processor.jar .
COPY data/ ./data/

ENTRYPOINT ["java", "-jar", "salary-processor.jar"]
```

### 10.3 Cloud Deployment

```bash
# AWS Lambda
aws lambda create-function \
  --function-name SalaryProcessor \
  --runtime java11 \
  --handler org.etl.generated.SalaryProcessProcessor::handleRequest \
  --zip-file fileb://salary-processor.jar

# Azure Functions
func azure functionapp create --resource-group myRG \
  --consumption-plan-location westus \
  --runtime java --runtime-version 11 \
  --functions-version 3 \
  --name salary-processor
```

---

**Version**: 1.0  
**Last Updated**: 2026-06-25  
**Status**: Complete
