package org.example.lts.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.example.lts.lts.AggregateOperation
import org.example.lts.lts.AppendRowsOperation
import org.example.lts.lts.BinaryExpression
import org.example.lts.lts.BooleanValue
import org.example.lts.lts.CalculateColumnOperation
import org.example.lts.lts.ColumnAssignment
import org.example.lts.lts.ColumnReference
import org.example.lts.lts.CreateTableOperation
import org.example.lts.lts.CsvSink
import org.example.lts.lts.DecimalLiteral
import org.example.lts.lts.Expression
import org.example.lts.lts.ExternalFunction
import org.example.lts.lts.FilterOperation
import org.example.lts.lts.FunctionCall
import org.example.lts.lts.GroupOperation
import org.example.lts.lts.InsertColumnOperation
import org.example.lts.lts.IntegerLiteral
import org.example.lts.lts.JoinKind
import org.example.lts.lts.JoinOperation
import org.example.lts.lts.LoadOperation
import org.example.lts.lts.LookupOperation
import org.example.lts.lts.Model
import org.example.lts.lts.NullLiteral
import org.example.lts.lts.Operation
import org.example.lts.lts.Process
import org.example.lts.lts.RemoveColumnOperation
import org.example.lts.lts.RemoveDuplicatesOperation
import org.example.lts.lts.SaveLogOperation
import org.example.lts.lts.SaveTableOperation
import org.example.lts.lts.SortDirection
import org.example.lts.lts.SortOperation
import org.example.lts.lts.StringLiteral
import org.example.lts.lts.TableDeclaration
import org.example.lts.lts.UnaryExpression

class LtsGenerator extends AbstractGenerator {
    override void doGenerate(Resource resource, IFileSystemAccess2 fsa,
        IGeneratorContext context) {
        val process = (resource.contents.head as Model).process
        fsa.generateFile(
            "lts/generated/" + process.javaClassName + ".java",
            process.compile
        )
    }

    private def CharSequence compile(Process process) '''
        package lts.generated;

        import java.math.BigDecimal;
        import java.nio.file.Path;
        import java.util.LinkedHashMap;
        import java.util.Map;

        import org.example.lts.runtime.*;

        /**
         * Generated from the LTS process «process.name».
         * Regenerate this file instead of editing it manually.
         */
        public final class «process.javaClassName» {
            private final Path baseDirectory;
            private final Map<String, DataTable> tables = new LinkedHashMap<>();
            private final FunctionRegistry functions = new FunctionRegistry();
            private final LtsLog log = new LtsLog();

            public «process.javaClassName»(Path baseDirectory) {
                this.baseDirectory = baseDirectory;
                «FOR function : process.declarations.filter(ExternalFunction)»
                functions.register("«escape(function.name)»",
                        "«escape(function.implementation)»");
                «ENDFOR»
            }

            public static void main(String[] args) throws Exception {
                Path base = args.length == 0 ? Path.of(".") : Path.of(args[0]);
                new «process.javaClassName»(base).run();
            }

            public void run() throws Exception {
                «FOR operation : process.steps»
                «operation.compileOperation»
                «ENDFOR»
            }

            private Path path(String relativeOrAbsolute) {
                Path path = Path.of(relativeOrAbsolute);
                return path.isAbsolute() ? path : baseDirectory.resolve(path).normalize();
            }

            «FOR table : process.declarations.filter(TableDeclaration)»
            private static Schema «table.schemaMethod»() {
                return Schema.builder()
                    «FOR column : table.columns»
                    .column("«escape(column.name)»", ValueType.«column.type.literal.toUpperCase»,
                            «column.required», «nullableString(column.format)»)
                    «ENDFOR»
                    .build();
            }

            «ENDFOR»
        }
    '''

    private def CharSequence compileOperation(Operation operation) {
        switch operation {
            LoadOperation: {
                val table = operation.table
                val source = table.source
                '''
                tables.put("«escape(table.name)»",
                        CsvIO.read("«escape(table.name)»", path("«escape(source.path)»"),
                                '«separator(source.separator)»', «source.header»,
                                «table.schemaMethod»(), log));
                '''
            }
            CreateTableOperation:
                '''
                tables.put("«escape(operation.table.name)»",
                        new DataTable("«escape(operation.table.name)»",
                                «operation.table.schemaMethod»()));
                '''
            AppendRowsOperation:
                '''
                LtsOps.append("«escape(operation.source.name)»",
                        tables.get("«escape(operation.source.name)»"),
                        "«escape(operation.target.name)»",
                        tables.get("«escape(operation.target.name)»"),
                        «operation.mappings.compileAssignments», functions);
                '''
            FilterOperation:
                '''
                LtsOps.filter("«escape(operation.table.name)»",
                        tables.get("«escape(operation.table.name)»"),
                        «operation.condition.compileExpression», functions);
                '''
            SortOperation:
                '''
                LtsOps.sort(tables.get("«escape(operation.table.name)»")
                        «FOR key : operation.keys BEFORE ", " SEPARATOR ", "»
                        new SortSpec("«escape((key.column as ColumnReference).column)»",
                                «key.direction !== SortDirection.DESC»)
                        «ENDFOR»);
                '''
            RemoveDuplicatesOperation:
                '''
                LtsOps.removeDuplicates(tables.get("«escape(operation.table.name)»")
                        «FOR key : operation.keys BEFORE ", " SEPARATOR ", "»
                        "«escape((key as ColumnReference).column)»"
                        «ENDFOR»);
                '''
            CalculateColumnOperation:
                '''
                LtsOps.calculate("«escape(operation.table.name)»",
                        tables.get("«escape(operation.table.name)»"),
                        "«escape(operation.column)»",
                        «operation.value.compileExpression», functions);
                '''
            InsertColumnOperation:
                '''
                LtsOps.insertColumn("«escape(operation.table.name)»",
                        tables.get("«escape(operation.table.name)»"),
                        "«escape(operation.column)»",
                        ValueType.«operation.type.literal.toUpperCase»,
                        «IF operation.value === null»null«ELSE»«operation.value.compileExpression»«ENDIF»,
                        functions);
                '''
            RemoveColumnOperation:
                '''
                LtsOps.removeColumns(tables.get(
                        "«escape((operation.columns.head as ColumnReference).table.name)»")
                        «FOR ref : operation.columns BEFORE ", " SEPARATOR ", "»
                        "«escape((ref as ColumnReference).column)»"
                        «ENDFOR»);
                '''
            JoinOperation:
                '''
                LtsOps.join("«escape(operation.target.name)»",
                        tables.get("«escape(operation.target.name)»"),
                        "«escape(operation.source.name)»",
                        tables.get("«escape(operation.source.name)»"),
                        «operation.kind === JoinKind.LEFT»,
                        «operation.condition.compileExpression»,
                        «operation.selections.compileAssignments»,
                        «operation.aggregations.compileAssignments»,
                        functions, log);
                '''
            GroupOperation:
                '''
                LtsOps.group("«escape(operation.source.name)»",
                        tables.get("«escape(operation.source.name)»"),
                        tables.get("«escape(operation.target.name)»"),
                        LtsOps.expressions(
                                «FOR key : operation.keys SEPARATOR ", "»
                                «key.compileExpression»
                                «ENDFOR»),
                        «operation.aggregations.compileAssignments», functions);
                '''
            AggregateOperation:
                '''
                LtsOps.group("«escape(operation.source.name)»",
                        tables.get("«escape(operation.source.name)»"),
                        tables.get("«escape(operation.target.name)»"),
                        LtsOps.expressions(
                                «FOR key : operation.keys SEPARATOR ", "»
                                «key.compileExpression»
                                «ENDFOR»),
                        «operation.aggregations.compileAssignments», functions);
                '''
            LookupOperation: {
                val target = operation.target as ColumnReference
                '''
                LtsOps.lookup("«escape(target.table.name)»",
                        tables.get("«escape(target.table.name)»"),
                        "«escape(target.column)»",
                        "«escape(operation.source.name)»",
                        tables.get("«escape(operation.source.name)»"),
                        «operation.left.compileExpression»,
                        «operation.right.compileExpression»,
                        «operation.result.compileExpression»,
                        «IF operation.defaultValue === null»null«ELSE»«operation.defaultValue.compileExpression»«ENDIF»,
                        functions, log);
                '''
            }
            SaveTableOperation: {
                val CsvSink sink = operation.sink
                '''
                CsvIO.write(tables.get("«escape(operation.table.name)»"),
                        path("«escape(sink.path)»"), '«separator(sink.separator)»',
                        «sink.header»);
                '''
            }
            SaveLogOperation:
                '''
                log.save(path("«escape(operation.log.path)»"));
                '''
            default:
                '''// Unsupported operation: «operation.eClass.name»'''
        }
    }

    private def CharSequence compileAssignments(Iterable<ColumnAssignment> assignments) '''
        LtsOps.assignments(
                «FOR assignment : assignments SEPARATOR ",\n                "»
                "«escape(assignment.column)»", «assignment.value.compileExpression»
                «ENDFOR»)
    '''

    private def CharSequence compileExpression(Expression expression) {
        switch expression {
            ColumnReference:
                '''Expressions.column("«escape(expression.table.name)»",
                        "«escape(expression.column)»")'''
            StringLiteral:
                '''Expressions.literal("«escape(expression.value)»")'''
            IntegerLiteral:
                '''Expressions.literal(«expression.value»L)'''
            DecimalLiteral:
                '''Expressions.literal(new BigDecimal("«expression.value»"))'''
            BooleanValue:
                '''Expressions.literal(«expression.value»)'''
            NullLiteral:
                '''Expressions.literal(null)'''
            UnaryExpression:
                '''Expressions.unary("«escape(expression.operator)»",
                        «expression.operand.compileExpression»)'''
            BinaryExpression:
                '''Expressions.binary(«expression.left.compileExpression»,
                        "«escape(expression.operator)»",
                        «expression.right.compileExpression»)'''
            FunctionCall:
                '''Expressions.call("«escape(expression.name)»"
                        «FOR argument : expression.arguments BEFORE ", " SEPARATOR ", "»
                        «argument.compileExpression»
                        «ENDFOR»)'''
            default:
                '''Expressions.literal(null)'''
        }
    }

    private def String javaClassName(Process process) {
        val clean = process.name.replaceAll("[^A-Za-z0-9_$]", "_")
        (if (Character.isJavaIdentifierStart(clean.charAt(0))) clean else "_" + clean)
            + "Process"
    }

    private def String schemaMethod(TableDeclaration table) {
        "schema_" + table.name.replaceAll("[^A-Za-z0-9_$]", "_")
    }

    private def String separator(String separator) {
        val value = if (separator === null || separator.empty) "," else separator
        switch value.charAt(0) {
            case '\t': "\\t"
            case '\n': "\\n"
            case '\r': "\\r"
            case '\'': "\\'"
            case '\\': "\\\\"
            default: value.charAt(0).toString
        }
    }

    private def String nullableString(String value) {
        if (value === null) "null" else "\"" + escape(value) + "\""
    }

    private def String escape(String value) {
        if (value === null) return ""
        value.replace("\\", "\\\\")
            .replace("\"", "\\\"")
            .replace("\r", "\\r")
            .replace("\n", "\\n")
            .replace("\t", "\\t")
    }
}
