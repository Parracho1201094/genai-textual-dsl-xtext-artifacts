package org.enorm.lts.validation

import com.google.inject.Inject
import java.util.HashSet
import org.eclipse.xtext.validation.Check
import org.enorm.lts.lts.AggregateStatement
import org.enorm.lts.lts.ColumnDef
import org.enorm.lts.lts.CreateStatement
import org.enorm.lts.lts.CsvSource
import org.enorm.lts.lts.DropColumnsStatement
import org.enorm.lts.lts.JoinStatement
import org.enorm.lts.lts.LoadStatement
import org.enorm.lts.lts.LtsPackage
import org.enorm.lts.lts.Process
import org.enorm.lts.lts.SetColumnStatement
import org.enorm.lts.lts.TableProducingStatement
import org.enorm.lts.schema.TableEnvironmentBuilder
import org.enorm.lts.types.TypeComputer

class LtsValidator extends AbstractLtsValidator {

    public static val DUPLICATE_TABLE = "duplicate.table"
    public static val DUPLICATE_COLUMN = "duplicate.column"
    public static val UNKNOWN_COLUMN = "unknown.column"
    public static val TYPE_ERROR = "type.error"
    public static val INVALID_CSV = "invalid.csv"

    @Inject TableEnvironmentBuilder envBuilder
    @Inject TypeComputer typeComputer

    @Check
    def checkDuplicateTableNames(Process process) {
        val seen = newHashSet
        for (stmt : process.statements.filter(TableProducingStatement)) {
            if (!seen.add(stmt.name)) {
                error(
                    "Table '" + stmt.name + "' is already defined in process '" + process.name + "'.",
                    stmt,
                    LtsPackage.Literals.TABLE_PRODUCING_STATEMENT__NAME,
                    DUPLICATE_TABLE,
                    stmt.name
                )
            }
        }
    }

    @Check
    def checkLoadColumns(LoadStatement stmt) {
        checkDuplicateColumns(stmt.name, stmt.columns)
    }

    @Check
    def checkCreateColumns(CreateStatement stmt) {
        checkDuplicateColumns(stmt.name, stmt.columns)
    }

    private def checkDuplicateColumns(String tableName, Iterable<ColumnDef> columns) {
        val seen = new HashSet<String>()
        for (col : columns) {
            if (!seen.add(col.name)) {
                error(
                    "Column '" + col.name + "' is duplicated in table '" + tableName + "'.",
                    col,
                    LtsPackage.Literals.COLUMN_DEF__NAME,
                    DUPLICATE_COLUMN,
                    col.name
                )
            }
        }
    }

    @Check
    def checkCsvExtension(CsvSource source) {
        val p = source.path.replace('"', '')
        if (!p.endsWith(".csv")) {
            error(
                "CSV source path must end with .csv: " + p,
                source,
                LtsPackage.Literals.CSV_SOURCE__PATH,
                INVALID_CSV
            )
        }
    }

    @Check
    def checkJoinColumnsAndTypes(JoinStatement stmt) {
        val env = envBuilder.environmentBefore(stmt)
        val left = env.schemaOf(stmt.target.name)
        val right = env.schemaOf(stmt.source.name)

        if (left === null || right === null) return

        for (cond : stmt.conditions) {
            val leftCol = left.column(cond.leftColumn)
            val rightCol = right.column(cond.rightColumn)

            if (leftCol === null) {
                error("Column '" + cond.leftColumn + "' does not exist in table '" + stmt.target.name + "'.",
                    cond, LtsPackage.Literals.JOIN_CONDITION__LEFT_COLUMN, UNKNOWN_COLUMN)
            }

            if (rightCol === null) {
                error("Column '" + cond.rightColumn + "' does not exist in table '" + stmt.source.name + "'.",
                    cond, LtsPackage.Literals.JOIN_CONDITION__RIGHT_COLUMN, UNKNOWN_COLUMN)
            }

            if (leftCol !== null && rightCol !== null && leftCol.type != rightCol.type) {
                error("Cannot join " + stmt.target.name + "." + leftCol.name + ":" + leftCol.type +
                    " with " + stmt.source.name + "." + rightCol.name + ":" + rightCol.type + ".",
                    cond, null, TYPE_ERROR)
            }
        }

        val addedNames = newHashSet
        for (added : stmt.addedColumns) {
            val sourceCol = right.column(added.sourceColumn)
            val outName = if (added.targetColumn !== null) added.targetColumn else added.sourceColumn
            if (sourceCol === null) {
                error("Column '" + added.sourceColumn + "' does not exist in table '" + stmt.source.name + "'.",
                    added, LtsPackage.Literals.ADDED_COLUMN__SOURCE_COLUMN, UNKNOWN_COLUMN)
            }
            if (!addedNames.add(outName) || left.column(outName) !== null) {
                error("Join would create duplicate output column '" + outName + "'. Use an alias.",
                    added, null, DUPLICATE_COLUMN, outName)
            }
        }
    }

    @Check
    def checkAggregation(AggregateStatement stmt) {
        val env = envBuilder.environmentBefore(stmt)
        val source = env.schemaOf(stmt.source.name)
        if (source === null) return

        for (g : stmt.groupColumns) {
            if (source.column(g) === null) {
                error("Group column '" + g + "' does not exist in table '" + stmt.source.name + "'.",
                    stmt, LtsPackage.Literals.AGGREGATE_STATEMENT__GROUP_COLUMNS, UNKNOWN_COLUMN)
            }
        }

        val out = newHashSet
        for (a : stmt.aggregations) {
            val c = source.column(a.sourceColumn)
            if (c === null) {
                error("Aggregation column '" + a.sourceColumn + "' does not exist in table '" + stmt.source.name + "'.",
                    a, LtsPackage.Literals.AGGREGATION__SOURCE_COLUMN, UNKNOWN_COLUMN)
            } else if (a.function.literal != "count" && !typeComputer.isNumeric(c.type)) {
                error(a.function.literal + "(" + c.name + ") is invalid because '" + c.name + "' is " + c.type + ".",
                    a, LtsPackage.Literals.AGGREGATION__SOURCE_COLUMN, TYPE_ERROR)
            }
            if (!out.add(a.targetColumn)) {
                error("Aggregation output column '" + a.targetColumn + "' is duplicated.",
                    a, LtsPackage.Literals.AGGREGATION__TARGET_COLUMN, DUPLICATE_COLUMN)
            }
        }
    }

    @Check
    def checkSetExpressionType(SetColumnStatement stmt) {
        val env = envBuilder.environmentBefore(stmt)
        val tableSchema = env.schemaOf(stmt.table.name)
        if (tableSchema === null) return

        val actual = typeComputer.typeOf(stmt.expression, tableSchema)
        if (actual !== null && !typeComputer.isAssignable(actual, stmt.type)) {
            error("Cannot assign expression of type " + actual + " to column '" + stmt.column + "' of type " + stmt.type + ".",
                stmt, LtsPackage.Literals.SET_COLUMN_STATEMENT__EXPRESSION, TYPE_ERROR)
        }
    }

    @Check
    def checkDropColumns(DropColumnsStatement stmt) {
        val env = envBuilder.environmentBefore(stmt)
        val schema = env.schemaOf(stmt.table.name)
        if (schema === null) return
        for (col : stmt.columns) {
            if (schema.column(col) === null) {
                warning("Column '" + col + "' cannot be dropped because it does not exist in table '" + stmt.table.name + "'.",
                    stmt, LtsPackage.Literals.DROP_COLUMNS_STATEMENT__COLUMNS, UNKNOWN_COLUMN)
            }
        }
    }
}
