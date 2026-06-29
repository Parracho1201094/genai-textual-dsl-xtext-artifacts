# LTS DSL Syntax Guide

## Table of Contents

1. [Introduction](#introduction)
2. [Basic Structure](#basic-structure)
3. [Data Sources](#data-sources)
4. [Table Definitions](#table-definitions)
5. [Operations](#operations)
6. [Expressions](#expressions)
7. [Output](#output)
8. [Complete Examples](#complete-examples)

---

## Introduction

The LTS (Load, Transform, Save) DSL is designed for Excel-like data processing. Files have the `.lts` extension and contain one or more process definitions.

### Key Principles

- **Declarative**: Specify WHAT to do, not HOW
- **Intuitive**: Use Excel-like concepts
- **Typed**: Strong typing for safety
- **Executable**: Generates Java code

---

## Basic Structure

### File Format

```lts
process ProcessName {
    // 1. Data sources (CSV files)
    csv source ...
    
    // 2. Table definitions
    table ...
    
    // 3. Operations
    operations {
        ...
    }
    
    // 4. Output
    output {
        ...
    }
}
```

### Identifiers and Keywords

**Identifiers**: Variable and function names
- Start with letter or underscore
- Contain letters, numbers, underscores
- Case-sensitive
- Examples: `employees`, `employee_data`, `_temp`, `Salary2024`

**Keywords**: Reserved words (cannot be used as identifiers)
- `process`, `csv`, `source`, `table`, `operations`, `output`, `load`, `save`
- `filter`, `sort`, `join`, `group`, `aggregate`, `append`, `lookup`
- `insert`, `remove`, `delete`, `calculate`, `copy`, `all`, `by`
- `from`, `to`, `where`, `on`, `preserving`, `with`, `of`, `type`, `as`

**Comments**:
```lts
// Single-line comment

/* Multi-line
   comment */
```

---

## Data Sources

### CSV Data Source

Define external CSV files to load:

```lts
csv source source_name from "path/to/file.csv" {
    column1: String,
    column2: Integer,
    column3: Decimal
}
```

**Attributes**:
- `source_name`: Unique identifier for this source
- `"path/to/file.csv"`: Relative or absolute file path
- Columns: Comma-separated list with name and type

**Example**:
```lts
csv source employees from "data/employees.csv" {
    emp_id: Integer,
    name: String,
    salary: Decimal,
    hire_date: Date
}

csv source departments from "data/depts.csv" {
    dept_id: Integer,
    dept_name: String,
    location: String
}
```

---

## Table Definitions

### Basic Table

Create in-memory tables to hold intermediate results:

```lts
table table_name {
    col1: DataType,
    col2: DataType,
    col3: DataType
}
```

**Data Types**:
- `String`: Text values
- `Integer`: Whole numbers
- `Decimal`: Floating-point numbers
- `Boolean`: True/false
- `Date`: YYYY-MM-DD format
- `Time`: HH:MM:SS format
- `DateTime`: YYYY-MM-DD HH:MM:SS format

**Example**:
```lts
table employee_payments {
    emp_id: Integer,
    emp_name: String,
    base_salary: Decimal,
    department: String,
    multiplier: Decimal,
    final_payment: Decimal
}

table department_summary {
    dept_name: String,
    total_paid: Decimal,
    employee_count: Integer,
    last_updated: DateTime
}
```

---

## Operations

The `operations` block contains transformation steps executed sequentially.

### Load Operation

```lts
load target_table from source_name [copy all columns];
```

Loads data from a CSV source into a table.

**Examples**:
```lts
// Copy all columns from source
load employees from employees_source copy all columns;

// Load without copying all (requires manual column mapping)
load departments from departments_source;
```

### Save Operation

```lts
save table_name to "output/file.csv";
```

Saves table to a CSV file.

**Examples**:
```lts
save employee_payments to "output/payments.csv";
save department_summary to "reports/summary.csv";
```

### Filter Operation

```lts
filter table_name where condition;
```

Filters rows based on Boolean condition.

**Comparison Operators**:
- `=` Equal
- `!=` Not equal
- `<` Less than
- `>` Greater than
- `<=` Less than or equal
- `>=` Greater than or equal

**Logical Operators**:
- `and` OR `&&` (both conditions true)
- `or` OR `||` (either condition true)
- `not` OR `!` (negate condition)

**Pattern Matching**:
- `like "pattern"` String pattern matching
- `in (val1, val2, ...)` Value in list
- `not in (val1, val2, ...)` Value not in list
- `between min and max` Range check

**Examples**:
```lts
// Simple comparison
filter employees where salary > 50000;

// String matching
filter employees where department = "IT";

// Compound condition
filter employees where department = "IT" and salary > 50000;

// Pattern matching
filter employees where name like "John%";

// Range
filter employees where salary between 40000 and 60000;

// List membership
filter employees where department in ("IT", "HR", "Finance");
```

### Sort Operation

```lts
sort table_name by column1 [order1], column2 [order2], ...;
```

Sorts rows by one or more columns.

**Sort Orders**:
- `ascending` OR `asc` (default)
- `descending` OR `desc`

**Examples**:
```lts
// Single column
sort employees by salary descending;

// Multiple columns
sort employees by department ascending, name ascending;

// Abbreviations
sort payments by amount desc;
```

### Join Operation

```lts
join left_table right_table on left_col = right_col
    [preserving type]
    [with aggregations];
```

Combines rows from two tables based on matching condition.

**Preserve Types**:
- `left` Keep all rows from left table (left outer join)
- `right` Keep all rows from right table (right outer join)
- `all` Keep all rows from both tables (full outer join)
- `inner` Keep only matching rows (default)

**Examples**:
```lts
// Basic join
join employees departments on employees.dept_id = departments.dept_id;

// With preserve type
join employees worked_hours on employees.emp_id = worked_hours.emp_id
    preserving left;

// With aggregation
join payments categories on payments.dept_id = categories.dept_id
    with total_paid: sum(payments.amount);
```

### Group and Aggregate

```lts
group table_name by col1, col2 {
    new_col1: aggregation_func(col),
    new_col2: aggregation_func(col),
    ...
}
```

Groups rows by columns and applies aggregations.

**Aggregation Functions**:
- `sum(column)` Sum of values
- `count(column)` Count of rows
- `avg(column)` OR `average(column)` Average
- `min(column)` Minimum value
- `max(column)` Maximum value
- `first(column)` First value in group
- `last(column)` Last value in group
- `concat(column [, separator])` String concatenation

**Examples**:
```lts
// Simple grouping
group employees by department {
    employee_count: count(emp_id),
    avg_salary: avg(salary)
};

// Multiple grouping columns
group sales by customer_id, product_id {
    total_quantity: sum(quantity),
    total_amount: sum(amount),
    first_date: first(sale_date),
    last_date: max(sale_date)
};

// With concatenation
group employees by department {
    emp_list: concat(name, ", "),
    emp_count: count(emp_id)
};
```

### Aggregate (No Grouping)

```lts
aggregate table_name {
    total: sum(column),
    count: count(column),
    ...
}
```

Applies aggregations to entire table without grouping.

**Examples**:
```lts
aggregate employees {
    total_employees: count(emp_id),
    total_payroll: sum(salary),
    avg_salary: avg(salary)
};
```

### Remove Duplicates

```lts
remove duplicates from table_name [based on col1, col2, ...];
```

Removes duplicate rows, optionally based on specific columns.

**Examples**:
```lts
// Remove full row duplicates
remove duplicates from employees;

// Remove duplicates based on ID only
remove duplicates from employees based on emp_id;

// Multi-column basis
remove duplicates from orders based on customer_id, product_id;
```

### Create Empty Table

```lts
create empty table table_name {
    col1: Type,
    col2: Type,
    ...
}
```

Creates an empty table with specified schema.

**Example**:
```lts
create empty table results {
    emp_id: Integer,
    status: String,
    message: String
}
```

### Insert Column

```lts
insert column col_name into table_name of type DataType
    [with default value literal];
```

Adds a new column to a table.

**Examples**:
```lts
// Without default
insert column status into employees of type String;

// With default
insert column processed into results of type Boolean
    with default value false;
```

### Remove Column

```lts
remove column table.column_name from table_name;
```

Removes a column from a table.

**Examples**:
```lts
remove column employees.salary from employees;
remove column orders.internal_id from orders;
```

### Calculate Column

```lts
calculate column new_col in table_name of type DataType
    as expression;
```

Creates a calculated column based on expression.

**Examples**:
```lts
// Simple calculation
calculate column total in orders of type Decimal
    as quantity * unit_price;

// Using multiple columns
calculate column gross_salary in employees of type Decimal
    as base_salary * (1.0 + bonus_percentage / 100.0);

// With function calls
calculate column full_name in employees of type String
    as upper(first_name) + " " + last_name;
```

### String Operations

#### Concatenation

```lts
concatenate column result in table_name from col1, col2, ...
    [with separator] of type String;
```

**Examples**:
```lts
concatenate column full_name in employees from first_name, last_name
    with " " of type String;

concatenate column address in customers from street, city, state, zip
    with ", " of type String;
```

#### String Splitting

```lts
split column source_col in table_name by delimiter
    into col1, col2, ... of type String;
```

**Examples**:
```lts
split column name in employees by " " into first_name, last_name of type String;

split column address in locations by ", " into street, city, state, zip of type String;
```

#### String Extraction

```lts
extract from source_col in table_name pattern "regex_pattern"
    to target_col;
```

**Examples**:
```lts
extract from email in users pattern "(.+)@" to username;
extract from phone in contacts pattern "\\d{3}-\\d{4}$" to extension;
```

#### Case Conversion

```lts
to upper column table.col_name;
to lower column table.col_name;
trim column table.col_name;
```

**Examples**:
```lts
to upper column employees.last_name;
to lower column users.email;
trim column products.description;
```

### Lookup (VLOOKUP)

```lts
lookup table_name column col_to_match from lookup_table on lookup_key
    returning return_col to result_col;
```

Performs lookup similar to Excel VLOOKUP.

**Examples**:
```lts
lookup orders column product_id from products on products.product_id
    returning products.unit_price to unit_price;

lookup employees column dept_id from departments on departments.dept_id
    returning departments.dept_name to department_name;
```

### Append Rows

```lts
append source_table to target_table;
```

Appends all rows from source to target table.

**Example**:
```lts
append previous_data to current_data;
```

### Remove/Delete Rows

```lts
remove rows from table_name where condition;
delete rows from table_name where condition;
```

Removes rows matching condition.

**Examples**:
```lts
remove rows from employees where salary < 0;
delete rows from orders where order_status = "cancelled";
```

### Custom Function Calls

```lts
call function function_name(param1=value1, param2=value2, ...)
    returning result_col in table_name;
```

Calls custom Java functions.

**Examples**:
```lts
call function calculateTax(salary=base_salary, rate=tax_rate)
    returning tax_amount in employees;
```

---

## Expressions

### Expression Syntax

Expressions are used in filters and calculations.

### Literals

```lts
// String literals
"text"
'text'

// Numbers
123
45.67
0.5

// Boolean
true
false

// Null
null
```

### Column References

```lts
table_name.column_name

// Examples
employees.salary
orders.order_date
customers.total_purchases
```

### Arithmetic Operations

```lts
col1 + col2           // Addition
col1 - col2           // Subtraction
col1 * col2           // Multiplication
col1 / col2           // Division
col1 % col2           // Modulo
col1 ^ col2           // Power
```

**Example**:
```lts
calculate column commission in sales of type Decimal
    as (total_amount * commission_rate) / 100.0;
```

### Built-in Functions

**String Functions**:
- `upper(string)` Convert to uppercase
- `lower(string)` Convert to lowercase
- `trim(string)` Remove whitespace
- `length(string)` String length
- `substring(string, start, length)` Extract substring

**Numeric Functions**:
- `abs(number)` Absolute value
- `round(number)` Round to nearest integer
- `floor(number)` Round down
- `ceiling(number)` Round up
- `sqrt(number)` Square root
- `power(base, exponent)` Power

**Date Functions**:
- `today()` Current date
- `now()` Current date and time

**Examples**:
```lts
calculate column name_upper in employees of type String
    as upper(name);

calculate column salary_rounded in employees of type Integer
    as round(salary);

filter orders where order_date >= today();
```

### Complex Expressions

```lts
// Nested operations
calculate column final_price in products of type Decimal
    as (base_price + tax) * (1.0 - discount_rate);

// Using functions in expressions
calculate column status_code in users of type String
    as upper(substring(username, 1, 3)) + "-" + lower(status);

// Conditional-like logic (using boolean operations)
filter orders where (status = "completed" or status = "pending")
    and amount > 100.0;
```

---

## Output

The `output` block defines what to save and where.

### Output Structure

```lts
output {
    save table_name to "file.csv";
    save table_name to "file.csv";
    save log to "log.txt" with warnings, errors;
}
```

### Save Table Action

```lts
save table_name to "path/filename.csv";
```

Saves a table to CSV format.

**Examples**:
```lts
save employee_payments to "output/payments.csv";
save department_summary to "reports/dept_summary.csv";
```

### Save Log Action

```lts
save log to "path/logfile.txt" [with types];
```

Saves process warnings and errors to a log file.

**Log Types**:
- `warnings` Include warning messages
- `errors` Include error messages
- `info` Include informational messages
- `debug` Include debug messages
- `all` Include all message types

**Examples**:
```lts
// Save all logs
save log to "process.log" with warnings, errors;

// Save only errors
save log to "errors.log" with errors;

// Save all types
save log to "debug.log" with all;
```

---

## Complete Examples

### Example 1: Simple Data Load and Transform

```lts
process SimpleTransform {
    csv source products from "data/products.csv" {
        id: Integer,
        name: String,
        price: Decimal
    }
    
    table product_catalog {
        id: Integer,
        name: String,
        price: Decimal,
        price_with_tax: Decimal
    }
    
    operations {
        load product_catalog from products copy all columns;
        
        calculate column price_with_tax in product_catalog of type Decimal
            as price * 1.15;
        
        sort product_catalog by price descending;
    }
    
    output {
        save product_catalog to "output/catalog.csv";
        save log to "process.log" with warnings, errors;
    }
}
```

### Example 2: Complex Join and Aggregation

```lts
process SalesAnalysis {
    csv source sales from "data/sales.csv" {
        id: Integer,
        customer_id: Integer,
        amount: Decimal,
        date: Date
    }
    
    csv source customers from "data/customers.csv" {
        customer_id: Integer,
        name: String,
        city: String
    }
    
    table enriched_sales {
        id: Integer,
        customer_id: Integer,
        customer_name: String,
        city: String,
        amount: Decimal,
        date: Date
    }
    
    table summary {
        city: String,
        total_sales: Decimal,
        num_transactions: Integer,
        avg_transaction: Decimal
    }
    
    operations {
        load enriched_sales from sales copy all columns;
        
        join enriched_sales customers 
            on enriched_sales.customer_id = customers.customer_id
            preserving left;
        
        group enriched_sales by city {
            total_sales: sum(amount),
            num_transactions: count(id),
            avg_transaction: avg(amount)
        };
    }
    
    output {
        save enriched_sales to "output/enriched_sales.csv";
        save summary to "output/city_summary.csv";
        save log to "output/analysis.log" with all;
    }
}
```

### Example 3: Multi-Step String Processing

```lts
process NameProcessing {
    csv source people from "data/people.csv" {
        id: Integer,
        full_name: String,
        email: String
    }
    
    table processed {
        id: Integer,
        full_name: String,
        first_name: String,
        last_name: String,
        email: String,
        username: String
    }
    
    operations {
        load processed from people copy all columns;
        
        split column full_name in processed by " "
            into first_name, last_name of type String;
        
        extract from email in processed pattern "(.+)@" to username;
        
        to upper column processed.first_name;
    }
    
    output {
        save processed to "output/processed_people.csv";
    }
}
```

---

## Quick Reference

### Data Types
```
String | Integer | Decimal | Boolean | Date | Time | DateTime
```

### Comparison Operators
```
= | != | < | > | <= | >=
```

### Logical Operators
```
and | && | or | || | not | !
```

### Pattern Operators
```
like | in | not in | between
```

### Sort Orders
```
ascending | asc | descending | desc
```

### Aggregation Functions
```
sum | count | avg | average | min | max | first | last | concat
```

### String Functions
```
upper | lower | trim | length | substring
```

### Numeric Functions
```
abs | round | floor | ceiling | sqrt | power
```

### Join Types
```
preserving: all | left | right | inner
```

---

**Version**: 1.0  
**Last Updated**: 2026-06-25
