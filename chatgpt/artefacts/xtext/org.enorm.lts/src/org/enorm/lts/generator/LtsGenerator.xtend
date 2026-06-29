package org.enorm.lts.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.enorm.lts.lts.AggregateStatement
import org.enorm.lts.lts.CreateStatement
import org.enorm.lts.lts.DropColumnsStatement
import org.enorm.lts.lts.FilterStatement
import org.enorm.lts.lts.JoinStatement
import org.enorm.lts.lts.LoadStatement
import org.enorm.lts.lts.Process
import org.enorm.lts.lts.RemoveDuplicatesStatement
import org.enorm.lts.lts.SaveLogStatement
import org.enorm.lts.lts.SaveStatement
import org.enorm.lts.lts.SetColumnStatement
import org.enorm.lts.lts.SortDirection
import org.enorm.lts.lts.SortStatement

class LtsGenerator extends AbstractGenerator {

    override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
        val process = resource.allContents.filter(Process).head
        if (process === null) return
        fsa.generateFile("generated/" + process.name + "Process.java", process.compileProcess)
    }

    def compileProcess(Process process) '''
        package generated.«process.name.toLowerCase»;

        import java.nio.file.Path;
        import org.enorm.lts.runtime.*;
        import org.enorm.lts.custom.CustomFunctions;

        public final class «process.name»Process {
            public static void main(String[] args) throws Exception {
                ProcessLogger log = new ProcessLogger();

                «FOR stmt : process.statements»
                    «stmt.compileStatement»
                «ENDFOR»
            }
        }
    '''

    def dispatch compileStatement(LoadStatement stmt) '''
        Table «stmt.name» = CsvLoader.load(
            Path.of(«stmt.source.path»),
            Schema.of(
                «FOR c : stmt.columns SEPARATOR ","»
                    Column.of("«c.name»", Type.«c.type.literal.toUpperCase»)
                «ENDFOR»
            ),
            CsvOptions.header(«stmt.header»).delimiter(«IF stmt.delimiter !== null»«stmt.delimiter»«ELSE»","«ENDIF»),
            log
        );
    '''

    def dispatch compileStatement(CreateStatement stmt) '''
        Table «stmt.name» = Table.empty("«stmt.name»", Schema.of(
            «FOR c : stmt.columns SEPARATOR ","»
                Column.of("«c.name»", Type.«c.type.literal.toUpperCase»)
            «ENDFOR»
        ));
    '''

    def dispatch compileStatement(SortStatement stmt) '''
        «stmt.table.name» = Operators.sort(«stmt.table.name», Sort.by(
            «FOR k : stmt.keys SEPARATOR ","»
                "«k.column»", Sort.Direction.«IF k.direction == SortDirection.DESC»DESC«ELSE»ASC«ENDIF»
            «ENDFOR»
        ));
    '''

    def dispatch compileStatement(RemoveDuplicatesStatement stmt) '''
        «stmt.table.name» = Operators.removeDuplicates(«stmt.table.name», «FOR c : stmt.columns SEPARATOR ", "»"«c»"«ENDFOR»);
    '''

    def dispatch compileStatement(FilterStatement stmt) '''
        «stmt.table.name» = Operators.filter(«stmt.table.name», row -> /* compile expression */ true);
    '''

    def dispatch compileStatement(AggregateStatement stmt) '''
        Table «stmt.name» = Operators.aggregate(
            «stmt.source.name»,
            GroupBy.columns(«FOR c : stmt.groupColumns SEPARATOR ", "»"«c»"«ENDFOR»),
            «FOR a : stmt.aggregations SEPARATOR ","»
                Aggregations.«a.function.literal»("«a.sourceColumn»", "«a.targetColumn»", Type.«a.type.literal.toUpperCase»)
            «ENDFOR»
        );
    '''

    def dispatch compileStatement(JoinStatement stmt) '''
        «stmt.target.name» = Operators.leftJoin(
            «stmt.target.name»,
            «stmt.source.name»,
            JoinSpec.on(«FOR c : stmt.conditions SEPARATOR ", "»"«c.leftColumn»", "«c.rightColumn»"«ENDFOR»)
                «FOR a : stmt.addedColumns»
                    .add("«a.sourceColumn»", "«IF a.targetColumn !== null»«a.targetColumn»«ELSE»«a.sourceColumn»«ENDIF»")
                «ENDFOR»,
            log
        );
    '''

    def dispatch compileStatement(SetColumnStatement stmt) '''
        «stmt.table.name» = Operators.setColumn(«stmt.table.name», "«stmt.column»", Type.«stmt.type.literal.toUpperCase», row -> /* compile expression */ null);
    '''

    def dispatch compileStatement(DropColumnsStatement stmt) '''
        «stmt.table.name» = Operators.dropColumns(«stmt.table.name», «FOR c : stmt.columns SEPARATOR ", "»"«c»"«ENDFOR»);
    '''

    def dispatch compileStatement(SaveStatement stmt) '''
        CsvSaver.save(«stmt.table.name», Path.of(«stmt.source.path»), CsvOptions.header(«stmt.header»), log);
    '''

    def dispatch compileStatement(SaveLogStatement stmt) '''
        log.save(Path.of(«stmt.path»));
    '''
}
