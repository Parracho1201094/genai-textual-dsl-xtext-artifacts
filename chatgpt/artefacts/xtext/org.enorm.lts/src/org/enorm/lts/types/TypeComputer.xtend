package org.enorm.lts.types

import org.enorm.lts.lts.BinaryExpression
import org.enorm.lts.lts.BooleanLiteral
import org.enorm.lts.lts.ColumnRef
import org.enorm.lts.lts.DecimalLiteral
import org.enorm.lts.lts.Expression
import org.enorm.lts.lts.FunctionCall
import org.enorm.lts.lts.IntLiteral
import org.enorm.lts.lts.StringLiteral
import org.enorm.lts.lts.Type
import org.enorm.lts.schema.TableSchema

class TypeComputer {

    def Type typeOf(Expression e, TableSchema currentSchema) {
        switch e {
            StringLiteral: Type.STRING
            IntLiteral: Type.INT
            DecimalLiteral: Type.DECIMAL
            BooleanLiteral: Type.BOOLEAN
            ColumnRef: {
                if (e.table === null) currentSchema.column(e.name)?.type else null
            }
            FunctionCall: typeOfFunction(e)
            BinaryExpression: typeOfBinary(e, currentSchema)
            default: null
        }
    }

    private def Type typeOfFunction(FunctionCall f) {
        switch f.name {
            case "concat": Type.STRING
            case "substring": Type.STRING
            case "split": Type.STRING
            case "extract": Type.STRING
            case "toDecimal": Type.DECIMAL
            case "toInt": Type.INT
            case "toString": Type.STRING
            case "passFail": Type.STRING
            default: Type.STRING // user-defined CustomFunctions are allowed; validate strictly only when registered
        }
    }

    private def Type typeOfBinary(BinaryExpression b, TableSchema currentSchema) {
        val left = typeOf(b.left, currentSchema)
        val right = typeOf(b.right, currentSchema)
        switch b.op {
            case "and", case "or", case "==", case "!=", case "<", case "<=", case ">", case ">=": Type.BOOLEAN
            case "+": {
                if (left == Type.STRING || right == Type.STRING) Type.STRING
                else numericResult(left, right)
            }
            case "-", case "*", case "/": numericResult(left, right)
            default: null
        }
    }

    def boolean isNumeric(Type t) { t == Type.INT || t == Type.DECIMAL }

    def boolean isAssignable(Type actual, Type expected) {
        actual == expected || (actual == Type.INT && expected == Type.DECIMAL)
    }

    private def Type numericResult(Type left, Type right) {
        if (!isNumeric(left) || !isNumeric(right)) return null
        if (left == Type.DECIMAL || right == Type.DECIMAL) Type.DECIMAL else Type.INT
    }
}
