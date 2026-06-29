package org.example.lts.types;

import java.util.List;
import java.util.Locale;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.example.lts.lts.BinaryExpression;
import org.example.lts.lts.BooleanValue;
import org.example.lts.lts.Column;
import org.example.lts.lts.ColumnReference;
import org.example.lts.lts.DataType;
import org.example.lts.lts.DecimalLiteral;
import org.example.lts.lts.Expression;
import org.example.lts.lts.ExternalFunction;
import org.example.lts.lts.FunctionCall;
import org.example.lts.lts.IntegerLiteral;
import org.example.lts.lts.InsertColumnOperation;
import org.example.lts.lts.NullLiteral;
import org.example.lts.lts.Operation;
import org.example.lts.lts.Process;
import org.example.lts.lts.RemoveColumnOperation;
import org.example.lts.lts.StringLiteral;
import org.example.lts.lts.UnaryExpression;

public class LtsTypeComputer {
    public DataType typeOf(Expression expression) {
        if (expression == null || expression instanceof NullLiteral) {
            return null;
        }
        if (expression instanceof StringLiteral) {
            return DataType.STRING;
        }
        if (expression instanceof IntegerLiteral) {
            return DataType.INTEGER;
        }
        if (expression instanceof DecimalLiteral) {
            return DataType.DECIMAL;
        }
        if (expression instanceof BooleanValue) {
            return DataType.BOOLEAN;
        }
        if (expression instanceof ColumnReference) {
            ColumnReference ref = (ColumnReference) expression;
            return columnType(ref, ref.getTable(), ref.getColumn());
        }
        if (expression instanceof UnaryExpression) {
            UnaryExpression unary = (UnaryExpression) expression;
            return "not".equals(unary.getOperator())
                    ? DataType.BOOLEAN
                    : typeOf(unary.getOperand());
        }
        if (expression instanceof BinaryExpression) {
            return typeOfBinary((BinaryExpression) expression);
        }
        if (expression instanceof FunctionCall) {
            return typeOfCall((FunctionCall) expression);
        }
        return null;
    }

    public Column findColumn(ColumnReference reference) {
        if (reference.getTable() == null) {
            return null;
        }
        return reference.getTable().getColumns().stream()
                .filter(c -> c.getName().equals(reference.getColumn()))
                .findFirst()
                .orElse(null);
    }

    public Column findColumn(EObject context, org.example.lts.lts.TableDeclaration table, String name) {
        if (table == null || name == null) {
            return null;
        }
        return table.getColumns().stream()
                .filter(c -> name.equals(c.getName()))
                .findFirst()
                .orElse(null);
    }

    public DataType columnType(EObject context,
            org.example.lts.lts.TableDeclaration table, String name) {
        Column declared = findColumn(context, table, name);
        DataType result = declared == null ? null : declared.getType();
        Process process = EcoreUtil2.getContainerOfType(context, Process.class);
        Operation current = context instanceof Operation
                ? (Operation) context
                : EcoreUtil2.getContainerOfType(context, Operation.class);
        if (process == null || current == null) {
            return result;
        }
        int limit = process.getSteps().indexOf(current);
        for (int i = 0; i < limit; i++) {
            Operation operation = process.getSteps().get(i);
            if (operation instanceof InsertColumnOperation) {
                InsertColumnOperation insert = (InsertColumnOperation) operation;
                if (insert.getTable() == table && name.equals(insert.getColumn())) {
                    result = insert.getType();
                }
            } else if (operation instanceof RemoveColumnOperation) {
                RemoveColumnOperation remove = (RemoveColumnOperation) operation;
                boolean removed = remove.getColumns().stream()
                        .filter(ColumnReference.class::isInstance)
                        .map(ColumnReference.class::cast)
                        .anyMatch(ref -> ref.getTable() == table
                                && name.equals(ref.getColumn()));
                if (removed) {
                    result = null;
                }
            }
        }
        return result;
    }

    public boolean isAssignable(DataType target, DataType source) {
        return source == null || target == source
                || (target == DataType.DECIMAL && source == DataType.INTEGER);
    }

    public boolean isNumeric(DataType type) {
        return type == DataType.INTEGER || type == DataType.DECIMAL;
    }

    private DataType typeOfBinary(BinaryExpression binary) {
        String operator = binary.getOperator();
        if ("and".equals(operator) || "or".equals(operator)
                || "=".equals(operator) || "!=".equals(operator)
                || "<".equals(operator) || "<=".equals(operator)
                || ">".equals(operator) || ">=".equals(operator)) {
            return DataType.BOOLEAN;
        }
        if ("&".equals(operator)) {
            return DataType.STRING;
        }
        DataType left = typeOf(binary.getLeft());
        DataType right = typeOf(binary.getRight());
        if (left == DataType.DECIMAL || right == DataType.DECIMAL || "/".equals(operator)) {
            return DataType.DECIMAL;
        }
        return left == DataType.INTEGER && right == DataType.INTEGER
                ? DataType.INTEGER
                : null;
    }

    private DataType typeOfCall(FunctionCall call) {
        String name = call.getName().toLowerCase(Locale.ROOT);
        List<Expression> args = call.getArguments();
        switch (name) {
        case "concat":
        case "split":
        case "extract":
        case "upper":
        case "lower":
        case "trim":
            return DataType.STRING;
        case "sum":
        case "avg":
        case "todecimal":
            return DataType.DECIMAL;
        case "count":
        case "tointeger":
            return DataType.INTEGER;
        case "min":
        case "max":
        case "first":
        case "coalesce":
            return args.isEmpty() ? null : typeOf(args.get(0));
        case "tostring":
            return DataType.STRING;
        case "toboolean":
            return DataType.BOOLEAN;
        default:
            Process process = EcoreUtil2.getContainerOfType(call, Process.class);
            if (process == null) {
                return null;
            }
            return process.getDeclarations().stream()
                    .filter(ExternalFunction.class::isInstance)
                    .map(ExternalFunction.class::cast)
                    .filter(f -> f.getName().equals(call.getName()))
                    .map(ExternalFunction::getReturnType)
                    .findFirst()
                    .orElse(null);
        }
    }
}
