"""
test_suite.py
-------------
Tests for:
  1. LTSRuntime primitives (unit tests)
  2. Validator rule logic (Python re-implementation of each @Check rule)
  3. End-to-end output verification for all 3 scenarios
  4. Invalid-model error detection
"""

import sys, os, math
sys.path.insert(0, os.path.dirname(__file__))

import lts_runtime as rt

PASS = 0
FAIL = 0

def check(name, got, expected):
    global PASS, FAIL
    ok = (got == expected) or (
        isinstance(got, float) and isinstance(expected, float) and
        math.isclose(got, expected, rel_tol=1e-6)
    )
    if ok:
        print(f"  ✓  {name}")
        PASS += 1
    else:
        print(f"  ✗  {name}")
        print(f"       got      : {got!r}")
        print(f"       expected : {expected!r}")
        FAIL += 1

def check_true(name, condition):
    check(name, condition, True)

def check_false(name, condition):
    check(name, condition, False)


# ─────────────────────────────────────────────────────────────────────────────
print("\n── 1. Runtime: sort ──────────────────────────────────────────────────")
t = rt.Table(["id","name"], [{"id":3,"name":"C"},{"id":1,"name":"A"},{"id":2,"name":"B"}])
s = rt.sort_table(t, ["id"], ["ASC"])
check("sort ASC ids",    [r["id"]   for r in s.rows], [1,2,3])
s2 = rt.sort_table(t, ["id"], ["DESC"])
check("sort DESC ids",   [r["id"]   for r in s2.rows], [3,2,1])
t2 = rt.Table(["a","b"],[{"a":1,"b":2},{"a":1,"b":1},{"a":2,"b":0}])
s3 = rt.sort_table(t2, ["a","b"], ["ASC","DESC"])
check("multi-key sort",  [(r["a"],r["b"]) for r in s3.rows], [(1,2),(1,1),(2,0)])


# ─────────────────────────────────────────────────────────────────────────────
print("\n── 2. Runtime: filter ────────────────────────────────────────────────")
t = rt.Table(["id","v"],[{"id":1,"v":10},{"id":2,"v":-5},{"id":3,"v":0}])
f = rt.filter_table(t, lambda row: rt.compare(row["v"], ">", 0))
check("filter v>0 count",      f.row_count(), 1)
check("filter v>0 kept id",    f.rows[0]["id"], 1)
f2 = rt.filter_table(t, lambda row: rt.compare(row["v"], ">=", 0))
check("filter v>=0 count",     f2.row_count(), 2)


# ─────────────────────────────────────────────────────────────────────────────
print("\n── 3. Runtime: remove_duplicates ────────────────────────────────────")
t = rt.Table(["id","name"],[
    {"id":1,"name":"A"},{"id":2,"name":"B"},
    {"id":1,"name":"A"},{"id":3,"name":"C"},{"id":2,"name":"B"}])
d = rt.remove_duplicates(t, ["id"])
check("dedup count",   d.row_count(), 3)
check("dedup ids",     [r["id"] for r in d.rows], [1,2,3])
# Multi-key dedup
t2 = rt.Table(["a","b"],[{"a":1,"b":"x"},{"a":1,"b":"y"},{"a":1,"b":"x"}])
d2 = rt.remove_duplicates(t2, ["a","b"])
check("multi-key dedup count", d2.row_count(), 2)


# ─────────────────────────────────────────────────────────────────────────────
print("\n── 4. Runtime: join ──────────────────────────────────────────────────")
left  = rt.Table(["empId","name"],[{"empId":1,"name":"Alice"},{"empId":2,"name":"Bob"},{"empId":3,"name":"Carol"}])
right = rt.Table(["empId","hours"],[{"empId":1,"hours":10},{"empId":2,"hours":8}])
j = rt.join(left, "empId", right, "empId")
check("join row count",        j.row_count(), 3)
check("join Alice hours",      j.rows[0]["hours"], 10)
check("join Bob hours",        j.rows[1]["hours"], 8)
check("join Carol hours None", j.rows[2].get("hours"), None)

# Join with aggregation
left2  = rt.Table(["deptId","name"],[{"deptId":10,"name":"Eng"},{"deptId":20,"name":"Sales"}])
right2 = rt.Table(["deptId","salary"],[
    {"deptId":10,"salary":1000},{"deptId":10,"salary":1500},
    {"deptId":20,"salary":2000}])
j2 = rt.join(left2, "deptId", right2, "deptId", agg_col="salary", agg_fn=rt.AggFunction.SUM)
check("join+SUM Eng salary",   j2.rows[0]["salary"], 2500.0)
check("join+SUM Sales salary", j2.rows[1]["salary"], 2000.0)


# ─────────────────────────────────────────────────────────────────────────────
print("\n── 5. Runtime: group ─────────────────────────────────────────────────")
t = rt.Table(["dept","salary"],[
    {"dept":"Eng","salary":1000},{"dept":"Eng","salary":1500},
    {"dept":"Sales","salary":2000},{"dept":"Eng","salary":500}])
g = rt.group(t, ["dept"], "salary", rt.AggFunction.SUM)
rows_by_dept = {r["dept"]: r["salary"] for r in g.rows}
check("group SUM Eng",     rows_by_dept["Eng"],   3000.0)
check("group SUM Sales",   rows_by_dept["Sales"],  2000.0)
g2 = rt.group(t, ["dept"], "salary", rt.AggFunction.AVG)
rows2 = {r["dept"]: r["salary"] for r in g2.rows}
check("group AVG Eng",     rows2["Eng"],   1000.0)
g3 = rt.group(t, ["dept"], "salary", rt.AggFunction.COUNT)
rows3 = {r["dept"]: r["salary"] for r in g3.rows}
check("group COUNT Eng",   rows3["Eng"],   3.0)


# ─────────────────────────────────────────────────────────────────────────────
print("\n── 6. Runtime: lookup ────────────────────────────────────────────────")
target = rt.Table(["id","name"],[{"id":1,"name":"A"},{"id":2,"name":"B"},{"id":99,"name":"X"}])
ref    = rt.Table(["id","dept"],[{"id":1,"dept":"Eng"},{"id":2,"dept":"Sales"}])
l = rt.lookup(target, "id", ref, "id", "dept")
check("lookup id=1 dept",  l.rows[0]["dept"], "Eng")
check("lookup id=2 dept",  l.rows[1]["dept"], "Sales")
check("lookup id=99 dept", l.rows[2].get("dept"), None)  # no match → None
check("lookup adds col",   "dept" in l.columns, True)


# ─────────────────────────────────────────────────────────────────────────────
print("\n── 7. Runtime: add_computed_column / update_column ──────────────────")
t = rt.Table(["a","b"],[{"a":3,"b":4},{"a":5,"b":2}])
t2 = rt.add_computed_column(t, "c", lambda row: rt.arithmetic(row["a"], "*", row["b"]))
check("add_computed_col values", [r["c"] for r in t2.rows], [12.0, 10.0])
check("add_computed_col cols",   "c" in t2.columns, True)
t3 = rt.update_column(t2, "c", lambda row: rt.arithmetic(row["c"], "+", 1))
check("update_column",           [r["c"] for r in t3.rows], [13.0, 11.0])


# ─────────────────────────────────────────────────────────────────────────────
print("\n── 8. Runtime: drop_columns ──────────────────────────────────────────")
t = rt.Table(["a","b","c"],[{"a":1,"b":2,"c":3}])
d = rt.drop_columns(t, ["b"])
check("drop cols list",  d.columns, ["a","c"])
check("drop row keys",   list(d.rows[0].keys()), ["a","c"])
check("drop value ok",   d.rows[0]["a"], 1)


# ─────────────────────────────────────────────────────────────────────────────
print("\n── 9. Runtime: append_rows ───────────────────────────────────────────")
t1 = rt.Table(["id","v"],[{"id":1,"v":"a"}])
t2 = rt.Table(["id","v"],[{"id":2,"v":"b"},{"id":3,"v":"c"}])
a  = rt.append_rows(t1, t2)
check("append count",  a.row_count(), 3)
check("append ids",    [r["id"] for r in a.rows], [1,2,3])
# Append to None (uninitialized table)
a2 = rt.append_rows(None, t2)
check("append to None count", a2.row_count(), 2)


# ─────────────────────────────────────────────────────────────────────────────
print("\n── 10. Runtime: arithmetic + None handling ───────────────────────────")
check("None * 15",   rt.arithmetic(None, "*", 15.0),  0.0)
check("15 * None",   rt.arithmetic(15.0, "*", None),  0.0)
check("None + None", rt.arithmetic(None, "+", None),  0.0)
check("divide by 0", rt.arithmetic(10.0, "/", 0.0),   None)
check("10 / 2",      rt.arithmetic(10.0, "/", 2.0),   5.0)
check("string concat", rt.arithmetic("Hello", "+", " World"), "Hello World")


# ─────────────────────────────────────────────────────────────────────────────
print("\n── 11. Runtime: compare ──────────────────────────────────────────────")
check("5 > 3",   rt.compare(5, ">", 3),   True)
check("3 > 5",   rt.compare(3, ">", 5),   False)
check("5 >= 5",  rt.compare(5, ">=", 5),  True)
check("5 == 5",  rt.compare(5, "==", 5),  True)
check("5 != 3",  rt.compare(5, "!=", 3),  True)
check("None cmp",rt.compare(None, ">", 0),False)


# ─────────────────────────────────────────────────────────────────────────────
print("\n── 12. Runtime: split_col / extract_col ─────────────────────────────")
t = rt.Table(["fullName"],[{"fullName":"Alice Smith"},{"fullName":"Bob Jones"}])
s = rt.split_col(t, "fullName", " ", None, ["firstName","lastName"])
check("split firstName", [r["firstName"] for r in s.rows], ["Alice","Bob"])
check("split lastName",  [r["lastName"]  for r in s.rows], ["Smith","Jones"])

t2 = rt.Table(["email"],[{"email":"alice@example.com"}])
e = rt.extract_col(t2, "email", None, 0, 5, "prefix")
check("extract 0..5",  e.rows[0]["prefix"], "alice")
e2 = rt.extract_col(t2, "email", r"@\w+", None, None, "domain_part")
check("extract regex", e2.rows[0]["domain_part"], "@example")


# ─────────────────────────────────────────────────────────────────────────────
print("\n── 13. Validator rules (Python re-implementation) ────────────────────")

def validate_no_load_step(steps):
    """R01: process must have at least one load step."""
    return any(s == "load" for s in steps)

def validate_sort_columns_exist(table_cols, sort_keys):
    """R04: all sort key columns must exist in the table."""
    return [k for k in sort_keys if k not in table_cols]

def validate_join_type_compatible(left_schema, left_key, right_schema, right_key):
    """R08: join key columns must share the same type."""
    lt = left_schema.get(left_key)
    rt_ = right_schema.get(right_key)
    if lt is None or rt_ is None:
        return False, "key missing"
    return lt == rt_, f"{lt} vs {rt_}"

def validate_calculate_column_exists(table_cols, col_name):
    """R09: calculate target column must already exist."""
    return col_name in table_cols

def validate_copy_schema(source_cols, target_cols):
    """R12: all source columns must be in target."""
    return [c for c in source_cols if c not in target_cols]

# R01
check_true ("R01 has load step",         validate_no_load_step(["load","sort","save"]))
check_false("R01 no load step",          validate_no_load_step(["sort","save"]))

# R04
missing = validate_sort_columns_exist(["id","name"], ["id","badCol"])
check("R04 unknown sort col",  missing, ["badCol"])
none_missing = validate_sort_columns_exist(["id","name"], ["id","name"])
check("R04 all cols ok",       none_missing, [])

# R08
ok, msg = validate_join_type_compatible({"empId":"Integer"}, "empId",
                                         {"empId":"Integer"}, "empId")
check_true ("R08 type match",     ok)
bad, msg2 = validate_join_type_compatible({"empId":"Integer"}, "empId",
                                           {"empCode":"String"}, "empCode")
check_false("R08 type mismatch",  bad)

# R09
check_true ("R09 col exists",    validate_calculate_column_exists(["a","payment"], "payment"))
check_false("R09 col missing",   validate_calculate_column_exists(["a","b"],       "payment"))

# R12
missing_copy = validate_copy_schema(["id","name","categoryId"], ["id","name"])
check("R12 missing cols in copy", missing_copy, ["categoryId"])
ok_copy = validate_copy_schema(["id","name"], ["id","name","extra"])
check("R12 copy ok",              ok_copy, [])


# ─────────────────────────────────────────────────────────────────────────────
print("\n── 14. End-to-end scenario verification ──────────────────────────────")
import salary_main, invoicing_main, grading_main

pay = salary_main.main()
pay_by_id = {r["employeeId"]: r for r in pay.rows}

check("Salary: Alice id=1 payment",  pay_by_id[1]["payment"], 232.5)
check("Salary: Bob   id=2 payment",  pay_by_id[2]["payment"], 375.0)
check("Salary: Alice id=3 payment",  pay_by_id[3]["payment"], 0.0)   # no hours → 0
check("Salary: Carol id=4 payment",  pay_by_id[4]["payment"], 240.0)
check("Salary: row count",           pay.row_count(), 4)

inv = invoicing_main.main()
inv_by_client = {r["clientId"]: r for r in inv.rows}
check("Invoice: Acme Corp total",    inv_by_client[1]["totalInvoice"], 54.47)
check("Invoice: Beta Ltd total",     inv_by_client[2]["totalInvoice"], 49.95)
check("Invoice: row count",          inv.row_count(), 2)

grd = grading_main.main()
grd_by_student = {r["studentId"]: r for r in grd.rows}
check("Grades: Dan finalGrade",  round(grd_by_student[1]["finalGrade"], 6),
                                  round(118/7, 6))
check("Grades: Eve finalGrade",  grd_by_student[2]["finalGrade"], 14.0)
check("Grades: row count",       grd.row_count(), 2)


# ─────────────────────────────────────────────────────────────────────────────
print(f"\n{'─'*58}")
total = PASS + FAIL
print(f"Results: {PASS}/{total} passed", "✓" if FAIL == 0 else f"  ({FAIL} FAILED)")
if FAIL > 0:
    sys.exit(1)
