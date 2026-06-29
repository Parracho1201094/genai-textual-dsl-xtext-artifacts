"""
salary_main.py
--------------
Python translation of the Java code that LTSGenerator.xtend would produce
for salary.lts.  Follows the step sequence in the model exactly.

Expected output (payments.csv):
  employeeId | employeeName | categoryId | categoryName | payment
  1          | Alice        | 10         | Junior       | 232.5   (15.5h * 15.0)
  2          | Bob          | 20         | Senior       | 375.0   (15.0h * 25.0)
  4          | Carol        | 10         | Junior       | 240.0   (16.0h * 15.0)

  (employee id=3 "Alice" is a duplicate of id=1 → removed)
  (employee id=2 "Bob" duplicate → removed, single entry with SUM of hours)
"""

import sys, os
sys.path.insert(0, os.path.dirname(__file__))

import lts_runtime as rt

DATA   = os.path.join(os.path.dirname(__file__), "data")
OUTPUT = os.path.join(os.path.dirname(__file__), "output")

def main():
    log = rt.LogCollector(os.path.join(OUTPUT, "salary_log.txt"))

    # ── Data source configs ──────────────────────────────────────────────────
    employeeSourceConfig    = rt.CsvConfig(f"{DATA}/employee.csv")
    workedHoursSourceConfig = rt.CsvConfig(f"{DATA}/workedHours.csv")
    categorySourceConfig    = rt.CsvConfig(f"{DATA}/category.csv")
    paymentsOutputConfig    = rt.CsvConfig(f"{OUTPUT}/payments.csv")

    # ── Step 1: load ─────────────────────────────────────────────────────────
    employee    = rt.load(employeeSourceConfig)
    workedHours = rt.load(workedHoursSourceConfig)
    category    = rt.load(categorySourceConfig)
    log.info(f"Loaded employee ({employee.row_count()} rows)")
    log.info(f"Loaded workedHours ({workedHours.row_count()} rows)")
    log.info(f"Loaded category ({category.row_count()} rows)")

    # ── Step 2: sort employee by id ASC ──────────────────────────────────────
    employee = rt.sort_table(employee, ["id"], ["ASC"])

    # ── Step 3: remove duplicates employee by id ──────────────────────────────
    before = employee.row_count()
    employee = rt.remove_duplicates(employee, ["id"])
    dupes = before - employee.row_count()
    if dupes:
        log.warning(f"Removed {dupes} duplicate employee row(s).")

    # ── Step 4: create paymentsDraft (start empty, same schema as payments) ──
    # In Python we create it as an empty Table; columns match the output schema.
    paymentsDraft = rt.Table(
        ["employeeId", "employeeName", "categoryId",
         "categoryName", "hourValue", "totalHours", "payment"]
    )

    # ── Step 5: copy employee into paymentsDraft ──────────────────────────────
    # Rename columns to match draft schema: id→employeeId, name→employeeName
    renamed_rows = []
    for row in employee.rows:
        renamed_rows.append({
            "employeeId":   row["id"],
            "employeeName": row["name"],
            "categoryId":   row["categoryId"],
            "categoryName": None,
            "hourValue":    None,
            "totalHours":   None,
            "payment":      None,
        })
    paymentsDraft = rt.Table(paymentsDraft.columns, renamed_rows)

    # ── Step 6a: lookup categoryName from category on id into paymentsDraft ──
    paymentsDraft = rt.lookup(paymentsDraft, "categoryId",
                              category, "id", "categoryName")

    # ── Step 6b: lookup hourValue from category on id into paymentsDraft ──────
    paymentsDraft = rt.lookup(paymentsDraft, "categoryId",
                              category, "id", "hourValue")

    # ── Step 7: join paymentsDraft with workedHours, aggregating hours SUM ───
    paymentsDraft = rt.join(
        paymentsDraft, "employeeId",
        workedHours,   "employeeId",
        agg_col="hours", agg_fn=rt.AggFunction.SUM
    )
    # After join the aggregated column is called "hours"; rename to totalHours
    paymentsDraft = rt.add_computed_column(
        paymentsDraft, "totalHours", lambda row: row.get("hours"))
    paymentsDraft = rt.drop_columns(paymentsDraft, ["hours"])

    # ── Step 8: calculate payment = totalHours * hourValue ───────────────────
    paymentsDraft = rt.update_column(
        paymentsDraft, "payment",
        lambda row: rt.arithmetic(row.get("totalHours"), "*", row.get("hourValue"))
    )

    # Warn about employees with no worked hours (payment will be 0.0)
    for row in paymentsDraft.rows:
        if not row.get("totalHours"):
            log.warning(f"Employee {row.get('employeeId')} ({row.get('employeeName')}) "
                        f"has no worked hours; payment set to 0.0.")

    # ── Step 9: drop helper columns ──────────────────────────────────────────
    paymentsDraft = rt.drop_columns(paymentsDraft, ["hourValue", "totalHours"])

    # ── Step 10: define output table and append draft into it ─────────────────
    payments = rt.Table(["employeeId", "employeeName", "categoryId",
                          "categoryName", "payment"])
    payments = rt.append_rows(payments, paymentsDraft)

    # ── Step 11: save ─────────────────────────────────────────────────────────
    rt.save(payments, paymentsOutputConfig)
    log.info(f"Saved payments ({payments.row_count()} rows) → {paymentsOutputConfig.path}")
    log.flush()

    return payments

if __name__ == "__main__":
    result = main()
    print("\n=== payments table ===")
    print(",".join(result.columns))
    for row in result.rows:
        print(",".join(str(row.get(c, "")) for c in result.columns))
