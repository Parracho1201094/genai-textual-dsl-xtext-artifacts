"""
invoicing_main.py
-----------------
Python translation of the Java code LTSGenerator.xtend would produce
for invoicing.lts.

Expected output (invoices.csv):
  clientId | clientName | totalInvoice
  1        | Acme Corp  | 24.50 + 29.97  = 54.47   (sales 1,2 only; sale 5 qty<0 filtered)
  2        | Beta Ltd   | 49.95           = 49.95   (sale 3 only; sale 4 qty=0 filtered)

  sale 1: qty=3, unitPrice=9.99  → 29.97
  sale 2: qty=1, unitPrice=24.50 → 24.50
  sale 3: qty=5, unitPrice=9.99  → 49.95
  sale 4: qty=0  → filtered
  sale 5: qty=-1 → filtered
"""

import sys, os
sys.path.insert(0, os.path.dirname(__file__))

import lts_runtime as rt

DATA   = os.path.join(os.path.dirname(__file__), "data")
OUTPUT = os.path.join(os.path.dirname(__file__), "output")

def main():
    log = rt.LogCollector(os.path.join(OUTPUT, "invoicing_log.txt"))

    clientsConfig  = rt.CsvConfig(f"{DATA}/clients.csv")
    productsConfig = rt.CsvConfig(f"{DATA}/products.csv")
    salesConfig    = rt.CsvConfig(f"{DATA}/sales.csv")
    invoicesConfig = rt.CsvConfig(f"{OUTPUT}/invoices.csv")

    # load
    clients  = rt.load(clientsConfig)
    products = rt.load(productsConfig)
    sales    = rt.load(salesConfig)
    log.info(f"Loaded clients ({clients.row_count()}), products ({products.row_count()}), sales ({sales.row_count()})")

    # filter sales where quantity > 0
    before = sales.row_count()
    sales = rt.filter_table(sales, lambda row: rt.compare(row.get("quantity"), ">", 0))
    log.warning(f"Filtered {before - sales.row_count()} sale(s) with quantity <= 0.")

    # lookup unitPrice from products on productId into sales
    sales = rt.lookup(sales, "productId", products, "productId", "unitPrice")

    # add column lineTotal = quantity * unitPrice
    sales = rt.add_computed_column(
        sales, "lineTotal",
        lambda row: rt.arithmetic(row.get("quantity"), "*", row.get("unitPrice"))
    )

    # group sales by clientId aggregating lineTotal using SUM → invoiceSummary
    invoiceSummary = rt.group(sales, ["clientId"], "lineTotal", rt.AggFunction.SUM)

    # lookup clientName from clients
    invoiceSummary = rt.lookup(invoiceSummary, "clientId",
                               clients, "clientId", "clientName")

    # rename lineTotal → totalInvoice
    invoiceSummary = rt.add_computed_column(
        invoiceSummary, "totalInvoice",
        lambda row: row.get("lineTotal")
    )
    invoiceSummary = rt.drop_columns(invoiceSummary, ["lineTotal"])

    # output table
    invoices = rt.Table(["clientId", "clientName", "totalInvoice"])
    invoices = rt.append_rows(invoices, invoiceSummary)

    rt.save(invoices, invoicesConfig)
    log.info(f"Saved invoices ({invoices.row_count()} rows)")
    log.flush()

    return invoices

if __name__ == "__main__":
    result = main()
    print("\n=== invoices table ===")
    print(",".join(result.columns))
    for row in result.rows:
        print(",".join(str(row.get(c, "")) for c in result.columns))
