/*
 * LTSValidator.xtend
 *
 * Semantic validation rules for the LTS DSL.
 * Xtext calls these automatically when the file is saved or on-demand.
 *
 * Convention: every rule method is annotated with @Check.
 * Error codes are declared as public static final String constants so that
 * quick-fix handlers can reference them without magic strings.
 *
 * Package: org.lts.validation
 */
package org.lts.validation

import org.eclipse.xtext.validation.Check
import org.lts.lTS.*
import java.util.HashSet
import java.util.HashMap
import java.util.Set
import java.util.Map

class LTSValidator extends AbstractLTSValidator {

    // ── Error code constants ──────────────────────────────────────────────────
    public static val DUPLICATE_PROCESS_NAME       = "duplicateProcessName"
    public static val UNKNOWN_SORT_COLUMN          = "unknownSortColumn"
    public static val SAVE_WITHOUT_LOAD            = "saveWithoutLoad"
    public static val JOIN_TYPE_MISMATCH           = "joinTypeMismatch"
    public static val CALCULATE_UNKNOWN_COLUMN     = "calculateUnknownColumn"
    public static val NO_LOAD_STEP                 = "noLoadStep"
    public static val GROUP_MISSING_RESULT_COLUMN  = "groupMissingResultColumn"
    public static val COPY_SCHEMA_INCOMPATIBLE     = "copySchemaIncompatible"
    public static val DROP_BEFORE_USE              = "dropBeforeUse"
    public static val LOOKUP_UNKNOWN_COLUMN        = "lookupUnknownColumn"
    public static val INSERT_COLUMN_TYPE_MISMATCH  = "insertColumnTypeMismatch"
    public static val MISSING_LOG_DECLARATION      = "missingLogDeclaration"
    public static val DUPLICATE_COLUMN_NAME        = "duplicateColumnName"
    public static val FILTER_UNKNOWN_COLUMN        = "filterUnknownColumn"
    public static val REMOVE_UNKNOWN_COLUMN        = "removeUnknownColumn"

    // ─────────────────────────────────────────────────────────────────────────
    // Helper: collect all column names declared for a TableDeclaration
    // ─────────────────────────────────────────────────────────────────────────
    def private Map<String, DataType> columnsOf(TableDeclaration tbl) {
        val map = new HashMap<String, DataType>
        val cols = switch tbl {
            InputTableDeclaration  : tbl.columns
            OutputTableDeclaration : tbl.columns
            EmptyTableDeclaration  : tbl.columns
            default                : #[]
        }
        for (c : cols) map.put(c.name, c.type)
        map
    }

    // ─────────────────────────────────────────────────────────────────────────
    // R01 – Each process must contain at least one LoadStep
    // ─────────────────────────────────────────────────────────────────────────
    @Check
    def checkAtLeastOneLoadStep(Process process) {
        val hasLoad = process.steps.exists[it instanceof LoadStep]
        if (!hasLoad) {
            error(
                "Process '" + process.name + "' has no load steps. " +
                "At least one table must be loaded.",
                process,
                LTSPackage.Literals.PROCESS__NAME,
                NO_LOAD_STEP
            )
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // R02 – Each process should declare a log
    // ─────────────────────────────────────────────────────────────────────────
    @Check
    def checkLogDeclared(Process process) {
        if (process.log === null) {
            warning(
                "Process '" + process.name + "' has no log declaration. " +
                "Warnings and errors will not be persisted.",
                process,
                LTSPackage.Literals.PROCESS__NAME,
                MISSING_LOG_DECLARATION
            )
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // R03 – No duplicate column names within a table declaration
    // ─────────────────────────────────────────────────────────────────────────
    @Check
    def checkNoDuplicateColumns(InputTableDeclaration tbl) {
        checkColumnUniqueness(tbl.columns, tbl, LTSPackage.Literals.INPUT_TABLE_DECLARATION__COLUMNS)
    }

    @Check
    def checkNoDuplicateColumnsOut(OutputTableDeclaration tbl) {
        checkColumnUniqueness(tbl.columns, tbl, LTSPackage.Literals.OUTPUT_TABLE_DECLARATION__COLUMNS)
    }

    @Check
    def checkNoDuplicateColumnsEmpty(EmptyTableDeclaration tbl) {
        checkColumnUniqueness(tbl.columns, tbl, LTSPackage.Literals.EMPTY_TABLE_DECLARATION__COLUMNS)
    }

    def private checkColumnUniqueness(Iterable<ColumnDeclaration> cols, EObject owner, EStructuralFeature feature) {
        val seen = new HashSet<String>
        for (col : cols) {
            if (!seen.add(col.name)) {
                error(
                    "Duplicate column name '" + col.name + "'.",
                    col,
                    LTSPackage.Literals.COLUMN_DECLARATION__NAME,
                    DUPLICATE_COLUMN_NAME
                )
            }
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // R04 – SortStep: all sort key columns must exist in the target table
    // ─────────────────────────────────────────────────────────────────────────
    @Check
    def checkSortColumnsExist(SortStep step) {
        if (step.table === null) return
        val cols = columnsOf(step.table)
        for (key : step.sortKeys) {
            if (!cols.containsKey(key.column)) {
                error(
                    "Column '" + key.column + "' does not exist in table '" +
                    step.table.name + "'.",
                    key,
                    LTSPackage.Literals.SORT_KEY__COLUMN,
                    UNKNOWN_SORT_COLUMN,
                    key.column   // pass as issue data for quick-fix
                )
            }
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // R05 – FilterStep: column references in the condition must exist
    // ─────────────────────────────────────────────────────────────────────────
    @Check
    def checkFilterColumns(FilterStep step) {
        if (step.table === null || step.condition === null) return
        val cols = columnsOf(step.table)
        collectColumnRefs(step.condition).forEach [ ref |
            if (!cols.containsKey(ref)) {
                error(
                    "Column '" + ref + "' referenced in filter does not exist in table '" +
                    step.table.name + "'.",
                    step,
                    LTSPackage.Literals.FILTER_STEP__CONDITION,
                    FILTER_UNKNOWN_COLUMN
                )
            }
        ]
    }

    def private Set<String> collectColumnRefs(Expression expr) {
        val refs = new HashSet<String>
        collectRefsInto(expr, refs)
        refs
    }

    def private dispatch void collectRefsInto(ColumnRef ref, Set<String> acc) {
        acc.add(ref.column)
    }
    def private dispatch void collectRefsInto(OrExpression  e, Set<String> acc) {
        collectRefsInto(e.left, acc); collectRefsInto(e.right, acc)
    }
    def private dispatch void collectRefsInto(AndExpression e, Set<String> acc) {
        collectRefsInto(e.left, acc); collectRefsInto(e.right, acc)
    }
    def private dispatch void collectRefsInto(ComparisonExpression e, Set<String> acc) {
        collectRefsInto(e.left, acc); collectRefsInto(e.right, acc)
    }
    def private dispatch void collectRefsInto(AddExpression e, Set<String> acc) {
        collectRefsInto(e.left, acc); collectRefsInto(e.right, acc)
    }
    def private dispatch void collectRefsInto(MulExpression e, Set<String> acc) {
        collectRefsInto(e.left, acc); collectRefsInto(e.right, acc)
    }
    def private dispatch void collectRefsInto(NotExpression e, Set<String> acc) {
        collectRefsInto(e.operand, acc)
    }
    def private dispatch void collectRefsInto(ParenExpression e, Set<String> acc) {
        collectRefsInto(e.inner, acc)
    }
    def private dispatch void collectRefsInto(Expression e, Set<String> acc) {
        // Literals: nothing to collect
    }

    // ─────────────────────────────────────────────────────────────────────────
    // R06 – RemoveDuplicatesStep: key columns must exist in the table
    // ─────────────────────────────────────────────────────────────────────────
    @Check
    def checkRemoveDuplicatesColumns(RemoveDuplicatesStep step) {
        if (step.table === null) return
        val cols = columnsOf(step.table)
        for (key : step.keys) {
            if (!cols.containsKey(key)) {
                error(
                    "Column '" + key + "' does not exist in table '" + step.table.name + "'.",
                    step,
                    LTSPackage.Literals.REMOVE_DUPLICATES_STEP__KEYS,
                    REMOVE_UNKNOWN_COLUMN
                )
            }
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // R07 – RemoveColumnsStep: columns to drop must exist in the table
    // ─────────────────────────────────────────────────────────────────────────
    @Check
    def checkDropColumnsExist(RemoveColumnsStep step) {
        if (step.table === null) return
        val cols = columnsOf(step.table)
        for (col : step.columns) {
            if (!cols.containsKey(col)) {
                error(
                    "Column '" + col + "' does not exist in table '" + step.table.name +
                    "' and cannot be dropped.",
                    step,
                    LTSPackage.Literals.REMOVE_COLUMNS_STEP__COLUMNS,
                    REMOVE_UNKNOWN_COLUMN
                )
            }
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // R08 – JoinStep: key columns must exist in both tables AND be type-compatible
    // ─────────────────────────────────────────────────────────────────────────
    @Check
    def checkJoinKeyTypes(JoinStep step) {
        if (step.left === null || step.right === null) return

        val leftCols  = columnsOf(step.left)
        val rightCols = columnsOf(step.right)

        val leftType  = leftCols.get(step.leftKey)
        val rightType = rightCols.get(step.rightKey)

        if (leftType === null) {
            error(
                "Join key '" + step.leftKey + "' does not exist in table '" +
                step.left.name + "'.",
                step, LTSPackage.Literals.JOIN_STEP__LEFT_KEY,
                JOIN_TYPE_MISMATCH
            )
            return
        }
        if (rightType === null) {
            error(
                "Join key '" + step.rightKey + "' does not exist in table '" +
                step.right.name + "'.",
                step, LTSPackage.Literals.JOIN_STEP__RIGHT_KEY,
                JOIN_TYPE_MISMATCH
            )
            return
        }
        if (leftType !== rightType) {
            error(
                "Join key columns '" + step.leftKey + "' (" + leftType.literal +
                ") and '" + step.rightKey + "' (" + rightType.literal +
                ") are not type-compatible.",
                step, LTSPackage.Literals.JOIN_STEP__RIGHT_KEY,
                JOIN_TYPE_MISMATCH
            )
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // R09 – CalculateColumnStep: the target column must exist in the table
    // ─────────────────────────────────────────────────────────────────────────
    @Check
    def checkCalculateColumnExists(CalculateColumnStep step) {
        if (step.table === null) return
        val cols = columnsOf(step.table)
        if (!cols.containsKey(step.column)) {
            error(
                "Column '" + step.column + "' does not exist in table '" +
                step.table.name + "'. Use 'add column' to insert a new column.",
                step, LTSPackage.Literals.CALCULATE_COLUMN_STEP__COLUMN,
                CALCULATE_UNKNOWN_COLUMN,
                step.column
            )
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // R10 – GroupStep: the result table must contain a column for the aggregated value
    // ─────────────────────────────────────────────────────────────────────────
    @Check
    def checkGroupResultTableHasAggColumn(GroupStep step) {
        if (step.result === null) return
        val resultCols = columnsOf(step.result)
        if (!resultCols.containsKey(step.aggColumn)) {
            error(
                "Result table '" + step.result.name + "' must contain a column " +
                "for the aggregated value '" + step.aggColumn + "'.",
                step, LTSPackage.Literals.GROUP_STEP__AGG_COLUMN,
                GROUP_MISSING_RESULT_COLUMN
            )
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // R11 – LookupStep: the fetched column must exist in the reference table
    // ─────────────────────────────────────────────────────────────────────────
    @Check
    def checkLookupColumnExists(LookupStep step) {
        if (step.reference === null) return
        val refCols = columnsOf(step.reference)
        if (!refCols.containsKey(step.fetchColumn)) {
            error(
                "Column '" + step.fetchColumn + "' does not exist in reference table '" +
                step.reference.name + "'.",
                step, LTSPackage.Literals.LOOKUP_STEP__FETCH_COLUMN,
                LOOKUP_UNKNOWN_COLUMN
            )
        }
        if (!refCols.containsKey(step.referenceKey)) {
            error(
                "Lookup key '" + step.referenceKey + "' does not exist in reference table '" +
                step.reference.name + "'.",
                step, LTSPackage.Literals.LOOKUP_STEP__REFERENCE_KEY,
                LOOKUP_UNKNOWN_COLUMN
            )
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // R12 – CopyStep: all columns of the source must exist in the target
    //       (the target may have MORE columns – those will remain null/default)
    // ─────────────────────────────────────────────────────────────────────────
    @Check
    def checkCopySchemaCompatibility(CopyStep step) {
        if (step.source === null || step.target === null) return
        val sourceCols = columnsOf(step.source)
        val targetCols = columnsOf(step.target)

        for (entry : sourceCols.entrySet) {
            if (!targetCols.containsKey(entry.key)) {
                error(
                    "Source table '" + step.source.name + "' has column '" + entry.key +
                    "' (" + entry.value.literal + ") which is not present in target table '" +
                    step.target.name + "'.",
                    step, LTSPackage.Literals.COPY_STEP__TARGET,
                    COPY_SCHEMA_INCOMPATIBLE
                )
            }
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // R13 – Process must have at least one save step (output or log)
    // ─────────────────────────────────────────────────────────────────────────
    @Check
    def checkAtLeastOneSaveStep(Process process) {
        val hasSave = process.steps.exists[it instanceof SaveStep]
        if (!hasSave) {
            warning(
                "Process '" + process.name + "' has no save steps. " +
                "No output will be produced.",
                process, LTSPackage.Literals.PROCESS__NAME,
                SAVE_WITHOUT_LOAD
            )
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // R14 – InsertColumnStep: a column with the same name must not already exist
    // ─────────────────────────────────────────────────────────────────────────
    @Check
    def checkInsertColumnNotDuplicate(InsertColumnStep step) {
        if (step.table === null) return
        val cols = columnsOf(step.table)
        if (cols.containsKey(step.name)) {
            error(
                "Column '" + step.name + "' already exists in table '" +
                step.table.name + "'. Use 'calculate' to update an existing column.",
                step, LTSPackage.Literals.INSERT_COLUMN_STEP__NAME,
                DUPLICATE_COLUMN_NAME
            )
        }
    }
}
