# Generation architecture

The Xtext generator should emit small Java process classes and delegate all reusable behavior to `org.enorm.lts.runtime`.

Common generated code:

- creates a `ProcessLogger`;
- loads CSV inputs with explicit schemas;
- calls `Operators` for sort, filter, join, aggregate, copy, duplicate removal, calculated columns, and dropping columns;
- saves CSV output and log output.

Reusable runtime code:

- `Table`, `Row`, `Schema`, `Column`, `Type`;
- `CsvLoader`, `CsvSaver`, `CsvOptions`;
- `Operators`, `JoinSpec`, `GroupBy`, `Aggregations`, `Mapping`, `Sort`;
- `ProcessLogger`;
- `CustomFunctions` as the manual extension point.
