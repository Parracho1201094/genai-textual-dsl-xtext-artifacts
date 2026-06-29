package org.example.lts.validation;

import static org.example.lts.validation.LtsIssueCodes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.example.lts.lts.AggregateOperation;
import org.example.lts.lts.AppendRowsOperation;
import org.example.lts.lts.BinaryExpression;
import org.example.lts.lts.CalculateColumnOperation;
import org.example.lts.lts.Column;
import org.example.lts.lts.ColumnAssignment;
import org.example.lts.lts.ColumnReference;
import org.example.lts.lts.CreateTableOperation;
import org.example.lts.lts.CsvSink;
import org.example.lts.lts.CsvSource;
import org.example.lts.lts.DataType;
import org.example.lts.lts.Declaration;
import org.example.lts.lts.Expression;
import org.example.lts.lts.ExternalFunction;
import org.example.lts.lts.FilterOperation;
import org.example.lts.lts.FunctionCall;
import org.example.lts.lts.GroupOperation;
import org.example.lts.lts.InsertColumnOperation;
import org.example.lts.lts.JoinOperation;
import org.example.lts.lts.LoadOperation;
import org.example.lts.lts.LogLevel;
import org.example.lts.lts.LogSink;
import org.example.lts.lts.LookupOperation;
import org.example.lts.lts.Operation;
import org.example.lts.lts.Process;
import org.example.lts.lts.RemoveColumnOperation;
import org.example.lts.lts.RemoveDuplicatesOperation;
import org.example.lts.lts.SaveTableOperation;
import org.example.lts.lts.SortOperation;
import org.example.lts.lts.TableDeclaration;
import org.example.lts.lts.UnaryExpression;
import org.example.lts.types.LtsTypeComputer;

import com.google.inject.Inject;

public class LtsValidator extends AbstractLtsValidator {
    private static final Pattern JAVA_METHOD =
            Pattern.compile("[A-Za-z_$][\\w$]*(\\.[A-Za-z_$][\\w$]*)+#[A-Za-z_$][\\w$]*");

    private static final Set<String> BUILT_INS = new HashSet<>(Arrays.asList(
            "concat", "split", "extract", "upper", "lower", "trim",
            "sum", "avg", "min", "max", "count", "first", "coalesce",
            "tostring", "tointeger", "todecimal", "toboolean"));

    private static final Set<String> AGGREGATES =
            new HashSet<>(Arrays.asList("sum", "avg", "min", "max", "count", "first"));

    @Inject
    private LtsTypeComputer types;

    @Check
    public void checkUniqueDeclarationNames(Process process) {
        Map<String, Declaration> seen = new HashMap<>();
        for (Declaration declaration : process.getDeclarations()) {
            String name = declarationName(declaration);
            if (name == null) {
                continue;
            }
            if (seen.putIfAbsent(name, declaration) != null) {
                error("Declaration '" + name + "' is already defined.",
                        declaration, feature(declaration, "name"), DUPLICATE_NAME, name);
            }
        }
    }

    @Check
    public void checkUniqueColumns(TableDeclaration table) {
        if (table.getSource() != null && table.getColumns().isEmpty()) {
            error("An input table must declare at least one column.",
                    table, feature(table, "columns"), UNKNOWN_COLUMN);
        }
        Set<String> seen = new HashSet<>();
        for (Column column : table.getColumns()) {
            if (!seen.add(column.getName())) {
                error("Column '" + column.getName() + "' is already defined in table '"
                        + table.getName() + "'.",
                        column, feature(column, "name"), DUPLICATE_COLUMN, column.getName());
            }
        }
    }

    @Check
    public void checkCsvSeparator(CsvSource source) {
        checkSeparator(source, source.getSeparator());
    }

    @Check
    public void checkCsvSeparator(CsvSink sink) {
        checkSeparator(sink, sink.getSeparator());
    }

    @Check
    public void checkExternalImplementation(ExternalFunction function) {
        if (function.getImplementation() == null
                || !JAVA_METHOD.matcher(function.getImplementation()).matches()) {
            error("Implementation must use 'fully.qualified.Class#staticMethod'.",
                    function, feature(function, "implementation"), INVALID_IMPLEMENTATION);
        }
    }

    @Check
    public void checkLogLevels(LogSink log) {
        for (LogLevel expected : Arrays.asList(LogLevel.WARNING, LogLevel.ERROR)) {
            if (!log.getLevels().contains(expected)) {
                warning("The log does not include " + expected.getLiteral() + ".",
                        log, feature(log, "levels"), MISSING_LOG_LEVEL, expected.getLiteral());
            }
        }
    }

    @Check
    public void checkColumnReference(ColumnReference reference) {
        if (reference.getTable() != null
                && types.columnType(reference, reference.getTable(),
                        reference.getColumn()) == null) {
            String suggestion = closestColumn(reference.getTable(), reference.getColumn());
            error("Unknown column '" + reference.getColumn() + "' in table '"
                    + reference.getTable().getName() + "'.",
                    reference, feature(reference, "column"), UNKNOWN_COLUMN,
                    suggestion == null ? "" : suggestion);
        }
    }

    @Check
    public void checkColumnAssignment(ColumnAssignment assignment) {
        DataType targetType = types.columnType(
                assignment, assignment.getTable(), assignment.getColumn());
        if (targetType == null) {
            String suggestion = closestColumn(assignment.getTable(), assignment.getColumn());
            error("Unknown target column '" + assignment.getColumn() + "' in table '"
                    + assignment.getTable().getName() + "'.",
                    assignment, feature(assignment, "column"), UNKNOWN_COLUMN,
                    suggestion == null ? "" : suggestion);
            return;
        }
        checkAssignable(targetType, assignment.getValue(), assignment,
                feature(assignment, "value"));
    }

    @Check
    public void checkCalculateColumn(CalculateColumnOperation operation) {
        DataType targetType = types.columnType(
                operation, operation.getTable(), operation.getColumn());
        if (targetType == null) {
            error("Calculated column '" + operation.getColumn()
                    + "' is not declared in table '" + operation.getTable().getName() + "'.",
                    operation, feature(operation, "column"), UNKNOWN_COLUMN,
                    closestColumn(operation.getTable(), operation.getColumn()));
            return;
        }
        checkAssignable(targetType, operation.getValue(), operation,
                feature(operation, "value"));
    }

    @Check
    public void checkInsertColumn(InsertColumnOperation operation) {
        DataType existing = types.columnType(
                operation, operation.getTable(), operation.getColumn());
        if (existing != null) {
            warning("Column '" + operation.getColumn()
                    + "' is already part of the declared schema; use 'calculate column'.",
                    operation, feature(operation, "column"), COLUMN_ALREADY_DECLARED,
                    operation.getTable().getName(), operation.getColumn());
        }
        if (operation.getValue() != null) {
            checkAssignable(operation.getType(), operation.getValue(), operation,
                    feature(operation, "value"));
        }
    }

    @Check
    public void checkFilterCondition(FilterOperation operation) {
        requireBoolean(operation.getCondition(), operation, feature(operation, "condition"));
    }

    @Check
    public void checkJoinCondition(JoinOperation operation) {
        requireBoolean(operation.getCondition(), operation, feature(operation, "condition"));
        if (operation.getSource() == operation.getTarget()) {
            warning("This is a self-join. Confirm that it is intentional.",
                    operation, feature(operation, "source"), DUPLICATE_NAME);
        }
    }

    @Check
    public void checkBinaryExpression(BinaryExpression expression) {
        DataType left = types.typeOf(expression.getLeft());
        DataType right = types.typeOf(expression.getRight());
        String operator = expression.getOperator();
        if ("and".equals(operator) || "or".equals(operator)) {
            if (left != null && left != DataType.BOOLEAN) {
                error("Left operand of '" + operator + "' must be boolean.",
                        expression, feature(expression, "left"), BOOLEAN_EXPECTED);
            }
            if (right != null && right != DataType.BOOLEAN) {
                error("Right operand of '" + operator + "' must be boolean.",
                        expression, feature(expression, "right"), BOOLEAN_EXPECTED);
            }
        } else if (Arrays.asList("+", "-", "*", "/").contains(operator)) {
            if (left != null && !types.isNumeric(left)) {
                error("Left operand of '" + operator + "' must be numeric.",
                        expression, feature(expression, "left"), NUMERIC_EXPECTED);
            }
            if (right != null && !types.isNumeric(right)) {
                error("Right operand of '" + operator + "' must be numeric.",
                        expression, feature(expression, "right"), NUMERIC_EXPECTED);
            }
        } else if (!"&".equals(operator) && left != null && right != null
                && !types.isAssignable(left, right) && !types.isAssignable(right, left)) {
            error("Operands of '" + operator + "' have incompatible types: "
                    + left.getLiteral() + " and " + right.getLiteral() + ".",
                    expression, feature(expression, "right"), INCOMPATIBLE_TYPES,
                    left.getLiteral(), right.getLiteral());
        }
    }

    @Check
    public void checkUnaryExpression(UnaryExpression expression) {
        DataType operand = types.typeOf(expression.getOperand());
        if ("not".equals(expression.getOperator())
                && operand != null && operand != DataType.BOOLEAN) {
            error("Operand of 'not' must be boolean.",
                    expression, feature(expression, "operand"), BOOLEAN_EXPECTED);
        } else if ("-".equals(expression.getOperator())
                && operand != null && !types.isNumeric(operand)) {
            error("Operand of unary '-' must be numeric.",
                    expression, feature(expression, "operand"), NUMERIC_EXPECTED);
        }
    }

    @Check
    public void checkFunction(FunctionCall call) {
        String name = call.getName().toLowerCase(Locale.ROOT);
        ExternalFunction external = externalFunction(call);
        if (!BUILT_INS.contains(name) && external == null) {
            error("Unknown function '" + call.getName() + "'.",
                    call, feature(call, "name"), UNKNOWN_FUNCTION,
                    closestFunction(call.getName()));
            return;
        }

        int expected = expectedArity(name, external);
        if (expected >= 0 && call.getArguments().size() != expected) {
            error("Function '" + call.getName() + "' expects " + expected
                    + " argument(s), but received " + call.getArguments().size() + ".",
                    call, feature(call, "arguments"), WRONG_ARGUMENT_COUNT,
                    Integer.toString(expected));
        }
        if ("concat".equals(name) && call.getArguments().size() < 2) {
            error("concat requires at least two arguments.",
                    call, feature(call, "arguments"), WRONG_ARGUMENT_COUNT, "2");
        }
        if ("coalesce".equals(name) && call.getArguments().size() < 2) {
            error("coalesce requires at least two arguments.",
                    call, feature(call, "arguments"), WRONG_ARGUMENT_COUNT, "2");
        }
        if (AGGREGATES.contains(name) && !isInsideAggregateBlock(call)) {
            error("Aggregate function '" + call.getName()
                    + "' may only be used in aggregate or group assignments.",
                    call, feature(call, "name"), AGGREGATE_CONTEXT);
        }
        if (Arrays.asList("sum", "avg").contains(name) && !call.getArguments().isEmpty()
                && !types.isNumeric(types.typeOf(call.getArguments().get(0)))) {
            error("Function '" + call.getName() + "' requires a numeric argument.",
                    call, feature(call, "arguments"), NUMERIC_EXPECTED);
        }
        if (external != null) {
            for (int i = 0; i < Math.min(external.getParameters().size(),
                    call.getArguments().size()); i++) {
                DataType expectedType = external.getParameters().get(i).getType();
                DataType actualType = types.typeOf(call.getArguments().get(i));
                if (!types.isAssignable(expectedType, actualType)) {
                    error("Argument " + (i + 1) + " of '" + call.getName()
                            + "' must be " + expectedType.getLiteral() + ", not "
                            + literal(actualType) + ".",
                            call, feature(call, "arguments"), i,
                            INCOMPATIBLE_TYPES, expectedType.getLiteral(),
                            literal(actualType));
                }
            }
        }
    }

    @Check
    public void checkSaveTarget(SaveTableOperation operation) {
        if (operation.getSink() != null && operation.getTable() != operation.getSink().getTable()) {
            error("Output '" + operation.getSink().getName() + "' is declared for table '"
                    + operation.getSink().getTable().getName() + "', not '"
                    + operation.getTable().getName() + "'.",
                    operation, feature(operation, "sink"), WRONG_OUTPUT_TABLE,
                    operation.getSink().getTable().getName());
        }
    }

    @Check(CheckType.NORMAL)
    public void checkOperationOrder(Process process) {
        Set<TableDeclaration> ready = new LinkedHashSet<>();
        for (Operation operation : process.getSteps()) {
            for (TableUse use : requiredTables(operation)) {
                if (use.table != null && !ready.contains(use.table)) {
                    String action = use.table.getSource() != null ? "load" : "create empty";
                    error("Table '" + use.table.getName() + "' is not ready. Add '"
                            + action + " " + use.table.getName() + ";' before this operation.",
                            operation, feature(operation, use.feature), TABLE_NOT_READY,
                            use.table.getName(), action);
                }
            }
            if (operation instanceof LoadOperation) {
                ready.add(((LoadOperation) operation).getTable());
            } else if (operation instanceof CreateTableOperation) {
                ready.add(((CreateTableOperation) operation).getTable());
            }
        }
    }

    @Check
    public void checkLoadKind(LoadOperation operation) {
        if (operation.getTable() != null && operation.getTable().getSource() == null) {
            error("Only an input table can be loaded. Use 'create empty "
                    + operation.getTable().getName() + ";'.",
                    operation, feature(operation, "table"), TABLE_NOT_READY,
                    operation.getTable().getName(), "create empty");
        }
    }

    @Check
    public void checkCreateKind(CreateTableOperation operation) {
        if (operation.getTable() != null && operation.getTable().getSource() != null) {
            error("An input table must be loaded from its source. Use 'load "
                    + operation.getTable().getName() + ";'.",
                    operation, feature(operation, "table"), TABLE_NOT_READY,
                    operation.getTable().getName(), "load");
        }
    }

    private void checkSeparator(EObject object, String separator) {
        if (separator != null && separator.length() != 1) {
            error("CSV separator must contain exactly one character.",
                    object, feature(object, "separator"), INVALID_SEPARATOR, ",");
        }
    }

    private void checkAssignable(DataType target, Expression value, EObject source,
            EStructuralFeature feature) {
        DataType actual = types.typeOf(value);
        if (!types.isAssignable(target, actual)) {
            error("Cannot assign " + literal(actual) + " to " + literal(target) + ".",
                    source, feature, INCOMPATIBLE_TYPES,
                    target.getLiteral(), literal(actual));
        }
    }

    private void requireBoolean(Expression expression, EObject source, EStructuralFeature feature) {
        DataType actual = types.typeOf(expression);
        if (actual != null && actual != DataType.BOOLEAN) {
            error("This expression must be boolean, but is " + actual.getLiteral() + ".",
                    source, feature, BOOLEAN_EXPECTED);
        }
    }

    private ExternalFunction externalFunction(FunctionCall call) {
        Process process = EcoreUtil2.getContainerOfType(call, Process.class);
        if (process == null) {
            return null;
        }
        return process.getDeclarations().stream()
                .filter(ExternalFunction.class::isInstance)
                .map(ExternalFunction.class::cast)
                .filter(f -> f.getName().equals(call.getName()))
                .findFirst()
                .orElse(null);
    }

    private int expectedArity(String name, ExternalFunction external) {
        if (external != null) {
            return external.getParameters().size();
        }
        switch (name) {
        case "split":
        case "extract":
            return 3;
        case "upper":
        case "lower":
        case "trim":
        case "sum":
        case "avg":
        case "min":
        case "max":
        case "count":
        case "first":
        case "tostring":
        case "tointeger":
        case "todecimal":
        case "toboolean":
            return 1;
        default:
            return -1;
        }
    }

    private boolean isInsideAggregateBlock(FunctionCall call) {
        ColumnAssignment assignment = EcoreUtil2.getContainerOfType(call, ColumnAssignment.class);
        if (assignment == null || !(assignment.eContainer() instanceof Operation)) {
            return false;
        }
        EObject container = assignment.eContainer();
        if (container instanceof GroupOperation) {
            return ((GroupOperation) container).getAggregations().contains(assignment);
        }
        if (container instanceof AggregateOperation) {
            return ((AggregateOperation) container).getAggregations().contains(assignment);
        }
        if (container instanceof JoinOperation) {
            return ((JoinOperation) container).getAggregations().contains(assignment);
        }
        return false;
    }

    private List<TableUse> requiredTables(Operation operation) {
        List<TableUse> uses = new ArrayList<>();
        if (operation instanceof AppendRowsOperation) {
            uses.add(new TableUse(((AppendRowsOperation) operation).getSource(), "source"));
            uses.add(new TableUse(((AppendRowsOperation) operation).getTarget(), "target"));
        } else if (operation instanceof FilterOperation) {
            uses.add(new TableUse(((FilterOperation) operation).getTable(), "table"));
        } else if (operation instanceof SortOperation) {
            uses.add(new TableUse(((SortOperation) operation).getTable(), "table"));
        } else if (operation instanceof GroupOperation) {
            uses.add(new TableUse(((GroupOperation) operation).getSource(), "source"));
            uses.add(new TableUse(((GroupOperation) operation).getTarget(), "target"));
        } else if (operation instanceof AggregateOperation) {
            uses.add(new TableUse(((AggregateOperation) operation).getSource(), "source"));
            uses.add(new TableUse(((AggregateOperation) operation).getTarget(), "target"));
        } else if (operation instanceof JoinOperation) {
            uses.add(new TableUse(((JoinOperation) operation).getTarget(), "target"));
            uses.add(new TableUse(((JoinOperation) operation).getSource(), "source"));
        } else if (operation instanceof InsertColumnOperation) {
            uses.add(new TableUse(((InsertColumnOperation) operation).getTable(), "table"));
        } else if (operation instanceof RemoveColumnOperation) {
            for (Expression ref : ((RemoveColumnOperation) operation).getColumns()) {
                if (ref instanceof ColumnReference) {
                    uses.add(new TableUse(((ColumnReference) ref).getTable(), "columns"));
                }
            }
        } else if (operation instanceof CalculateColumnOperation) {
            uses.add(new TableUse(((CalculateColumnOperation) operation).getTable(), "table"));
        } else if (operation instanceof LookupOperation) {
            uses.add(new TableUse(((LookupOperation) operation).getSource(), "source"));
            Expression target = ((LookupOperation) operation).getTarget();
            if (target instanceof ColumnReference) {
                uses.add(new TableUse(((ColumnReference) target).getTable(), "target"));
            }
        } else if (operation instanceof RemoveDuplicatesOperation) {
            uses.add(new TableUse(((RemoveDuplicatesOperation) operation).getTable(), "table"));
        } else if (operation instanceof SaveTableOperation) {
            uses.add(new TableUse(((SaveTableOperation) operation).getTable(), "table"));
        }
        return uses;
    }

    private String declarationName(Declaration declaration) {
        EStructuralFeature name = feature(declaration, "name");
        return name == null ? null : (String) declaration.eGet(name);
    }

    private EStructuralFeature feature(EObject object, String name) {
        return object.eClass().getEStructuralFeature(name);
    }

    private String closestColumn(TableDeclaration table, String value) {
        if (table == null) {
            return "";
        }
        return closest(value, table.getColumns().stream()
                .map(Column::getName).collect(Collectors.toList()));
    }

    private String closestFunction(String value) {
        return closest(value, BUILT_INS);
    }

    private String closest(String value, Iterable<String> candidates) {
        String best = "";
        int bestDistance = Integer.MAX_VALUE;
        for (String candidate : candidates) {
            int distance = levenshtein(value.toLowerCase(Locale.ROOT),
                    candidate.toLowerCase(Locale.ROOT));
            if (distance < bestDistance) {
                best = candidate;
                bestDistance = distance;
            }
        }
        return bestDistance <= 3 ? best : "";
    }

    private int levenshtein(String left, String right) {
        int[] costs = new int[right.length() + 1];
        for (int j = 0; j <= right.length(); j++) {
            costs[j] = j;
        }
        for (int i = 1; i <= left.length(); i++) {
            costs[0] = i;
            int northwest = i - 1;
            for (int j = 1; j <= right.length(); j++) {
                int current = costs[j];
                costs[j] = Math.min(Math.min(costs[j] + 1, costs[j - 1] + 1),
                        northwest + (left.charAt(i - 1) == right.charAt(j - 1) ? 0 : 1));
                northwest = current;
            }
        }
        return costs[right.length()];
    }

    private String literal(DataType type) {
        return type == null ? "unknown/null" : type.getLiteral();
    }

    private static final class TableUse {
        private final TableDeclaration table;
        private final String feature;

        private TableUse(TableDeclaration table, String feature) {
            this.table = table;
            this.feature = feature;
        }
    }
}
