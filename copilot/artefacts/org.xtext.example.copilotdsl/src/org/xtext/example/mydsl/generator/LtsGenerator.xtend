/*
 * Code Generator for LTS DSL
 * Generates executable Java code from LTS models
 */
package org.xtext.example.mydsl.generator

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.xtext.example.mydsl.lts.LtsProcess
import org.xtext.example.mydsl.lts.Table
import org.xtext.example.mydsl.lts.Column
import org.xtext.example.mydsl.lts.Operations
import org.xtext.example.mydsl.lts.Step
import org.xtext.example.mydsl.lts.LoadStep
import org.xtext.example.mydsl.lts.SaveStep
import org.xtext.example.mydsl.lts.FilterStep
import org.xtext.example.mydsl.lts.SortStep
import org.xtext.example.mydsl.lts.JoinStep
import org.xtext.example.mydsl.lts.GroupStep
import org.xtext.example.mydsl.lts.CalculatedColumnStep
import org.xtext.example.mydsl.lts.RemoveColumnStep
import org.xtext.example.mydsl.lts.InsertColumnStep
import org.xtext.example.mydsl.lts.RemoveDuplicatesStep
import org.xtext.example.mydsl.lts.Output
import org.xtext.example.mydsl.lts.SaveTableAction
import org.xtext.example.mydsl.lts.SaveLogAction
import java.util.List
import java.util.Map

/**
 * Generator for LTS DSL
 * Produces Java code for ETL processes
 */
class LtsGenerator extends AbstractGenerator {
	
	@Inject extension IFileSystemAccess2
	
	override void doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val models = input.allContents.toIterable.filter(LtsProcess)
		for (model : models) {
			generateLtsProcess(model, fsa)
		}
	}
	
	def void generateLtsProcess(LtsProcess process, IFileSystemAccess2 fsa) {
		val className = process.name.toClassName
		val packageName = "org.etl.generated"
		val fileName = packageName.replace(".", "/") + "/" + className + ".java"
		
		fsa.generateFile(fileName, generateProcessCode(process, className, packageName))
	}
	
	def String generateProcessCode(LtsProcess process, String className, String packageName) '''
		package «packageName»;
		
		import java.io.*;
		import java.util.*;
		import java.nio.file.*;
		import java.time.*;
		import java.time.format.*;
		import org.apache.commons.csv.*;
		
		/**
		 * Generated ETL Process: «process.name»
		 * This class was automatically generated from LTS DSL model
		 * 
		 * Manual Customization:
		 * - Extend this class to add custom functions
		 * - Override processData() method for custom logic
		 * - Implement ExternalFunction interface for custom operations
		 */
		public class «className» {
			
			«FOR source : process.dataSources»
				private static final String SOURCE_«source.name.toUpperCase» = "«getSourcePath(source.name)»";
			«ENDFOR»
			
			private Map<String, Table> tables = new LinkedHashMap<>();
			private List<String> warnings = new ArrayList<>();
			private List<String> errors = new ArrayList<>();
			
			«generateTableClasses(process)»
			
			public static void main(String[] args) {
				try {
					«className» processor = new «className»();
					processor.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			public void execute() throws IOException {
				System.out.println("Starting ETL Process: «process.name»");
				
				try {
					«generateInitializeTables(process)»
					«generateOperations(process)»
					«generateOutput(process)»
					System.out.println("Process completed successfully");
				} catch (Exception e) {
					errors.add("Process failed: " + e.getMessage());
					e.printStackTrace();
				} finally {
					«generateFinalOutput(process)»
				}
			}
			
			«generateOperationMethods(process)»
			
			«generateUtilityMethods()»
			
			«generateTableClass()»
		}
	'''
	
	def String generateTableClasses(LtsProcess process) '''
		// Table data classes
		«FOR table : process.tables»
			private static class «table.name.toClassName»Row {
				«FOR col : table.columns»
					public «col.type.toJavaType» «col.name»;
				«ENDFOR»
				
				public «table.name.toClassName»Row(«FOR col : table.columns SEPARATOR ", "»«col.type.toJavaType» «col.name»«ENDFOR») {
					«FOR col : table.columns»
						this.«col.name» = «col.name»;
					«ENDFOR»
				}
				
				@Override
				public String toString() {
					return «generateRowToString(table)»;
				}
			}
		«ENDFOR»
	'''
	
	def String generateRowToString(Table table) {
		val cols = table.columns.map['''"«name»=" + «name»'''].join(" + \", \" + ")
		'''"«table.name»{" + «cols» + "}"'''
	}
	
	def String generateInitializeTables(LtsProcess process) '''
		// Initialize tables
		«FOR table : process.tables»
			tables.put("«table.name»", new Table("«table.name»", Arrays.asList(«FOR col : table.columns SEPARATOR ", "»"«col.name»"«ENDFOR»)));
		«ENDFOR»
	'''
	
	def String generateOperations(LtsProcess process) '''
		«FOR step : process.operations.steps»
			«generateStep(step)»
		«ENDFOR»
	'''
	
	def String generateStep(Step step) {
		switch(step) {
			LoadStep: generateLoadStep(step)
			SaveStep: generateSaveStep(step)
			FilterStep: generateFilterStep(step)
			SortStep: generateSortStep(step)
			JoinStep: generateJoinStep(step)
			GroupStep: generateGroupStep(step)
			CalculatedColumnStep: generateCalculatedColumnStep(step)
			RemoveColumnStep: generateRemoveColumnStep(step)
			InsertColumnStep: generateInsertColumnStep(step)
			RemoveDuplicatesStep: generateRemoveDuplicatesStep(step)
			default: "// Unsupported step: " + step.class.simpleName
		}
	}
	
	def String generateLoadStep(LoadStep step) '''
		// Load data from source
		System.out.println("Loading «step.sourceTable» from «step.sourceName»...");
		try {
			loadTableFromCSV("«step.sourceName»", "«step.sourceTable»");
		} catch (IOException e) {
			errors.add("Failed to load «step.sourceName»: " + e.getMessage());
		}
	'''
	
	def String generateSaveStep(SaveStep step) '''
		// Save table to file
		System.out.println("Saving «step.tableName» to «step.filePath»...");
		try {
			saveTableToCSV("«step.tableName»", "«step.filePath»");
		} catch (IOException e) {
			errors.add("Failed to save «step.tableName»: " + e.getMessage());
		}
	'''
	
	def String generateFilterStep(FilterStep step) '''
		// Filter table
		System.out.println("Filtering «step.tableName»...");
		Table table = tables.get("«step.tableName»");
		if (table != null) {
			// TODO: Implement filter logic based on condition
			// Condition: «step.condition»
		}
	'''
	
	def String generateSortStep(SortStep step) '''
		// Sort table
		System.out.println("Sorting «step.tableName» by «FOR s : step.sorts SEPARATOR ", "»«s.columnName» «s.order»«ENDFOR»...");
		Table table = tables.get("«step.tableName»");
		if (table != null) {
			// TODO: Implement sort logic
		}
	'''
	
	def String generateJoinStep(JoinStep step) '''
		// Join tables
		System.out.println("Joining «step.leftTable» with «step.rightTable»...");
		Table leftTable = tables.get("«step.leftTable»");
		Table rightTable = tables.get("«step.rightTable»");
		if (leftTable != null && rightTable != null) {
			// TODO: Implement join logic
			// Condition: «step.joinCondition.leftColumn.table».«step.joinCondition.leftColumn.column» = «step.joinCondition.rightColumn.table».«step.joinCondition.rightColumn.column»
		}
	'''
	
	def String generateGroupStep(GroupStep step) '''
		// Group and aggregate
		System.out.println("Grouping «step.tableName» by «FOR col : step.groupColumns SEPARATOR ", "»«col.column»«ENDFOR»...");
		Table table = tables.get("«step.tableName»");
		if (table != null) {
			// TODO: Implement grouping and aggregation logic
		}
	'''
	
	def String generateCalculatedColumnStep(CalculatedColumnStep step) '''
		// Calculate column
		System.out.println("Calculating column «step.columnName» in «step.tableName»...");
		Table table = tables.get("«step.tableName»");
		if (table != null) {
			table.addColumn("«step.columnName»");
			// TODO: Implement calculation based on expression
			// Expression: «step.expression»
		}
	'''
	
	def String generateRemoveColumnStep(RemoveColumnStep step) '''
		// Remove column
		System.out.println("Removing column «step.columnName.column» from «step.tableName»...");
		Table table = tables.get("«step.tableName»");
		if (table != null) {
			table.removeColumn("«step.columnName.column»");
		}
	'''
	
	def String generateInsertColumnStep(InsertColumnStep step) '''
		// Insert column
		System.out.println("Inserting column «step.columnName» into «step.tableName»...");
		Table table = tables.get("«step.tableName»");
		if (table != null) {
			table.addColumn("«step.columnName»");
		}
	'''
	
	def String generateRemoveDuplicatesStep(RemoveDuplicatesStep step) '''
		// Remove duplicates
		System.out.println("Removing duplicates from «step.tableName»...");
		Table table = tables.get("«step.tableName»");
		if (table != null) {
			«IF !step.columns.empty»
				table.removeDuplicates(Arrays.asList(«FOR col : step.columns SEPARATOR ", "»"«col.column»"«ENDFOR»));
			«ELSE»
				table.removeDuplicates();
			«ENDIF»
		}
	'''
	
	def String generateOutput(LtsProcess process) '''
		«IF process.output !== null»
			«FOR action : process.output.actions»
				«IF action instanceof SaveTableAction»
					«generateSaveTableAction(action as SaveTableAction)»
				«ELSE IF action instanceof SaveLogAction»
					«generateSaveLogAction(action as SaveLogAction)»
				«ENDIF»
			«ENDFOR»
		«ENDIF»
	'''
	
	def String generateSaveTableAction(SaveTableAction action) '''
		// Save table output
		try {
			saveTableToCSV("«action.tableName»", "«action.filePath»");
		} catch (IOException e) {
			errors.add("Failed to save «action.tableName»: " + e.getMessage());
		}
	'''
	
	def String generateSaveLogAction(SaveLogAction action) '''
		// Save log file
		try {
			saveLog("«action.filePath»");
		} catch (IOException e) {
			System.err.println("Failed to save log: " + e.getMessage());
		}
	'''
	
	def String generateFinalOutput(LtsProcess process) '''
		try {
			if (!warnings.isEmpty() || !errors.isEmpty()) {
				System.out.println("Process completed with " + warnings.size() + " warnings and " + errors.size() + " errors");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	'''
	
	def String generateOperationMethods(LtsProcess process) '''
		private void loadTableFromCSV(String sourceName, String tableName) throws IOException {
			// Implementation of CSV loading
			System.out.println("Loading " + sourceName + " into " + tableName);
		}
		
		private void saveTableToCSV(String tableName, String filePath) throws IOException {
			// Implementation of CSV saving
			System.out.println("Saving " + tableName + " to " + filePath);
		}
		
		private void saveLog(String filePath) throws IOException {
			// Implementation of log saving
			try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
				for (String warning : warnings) {
					writer.println("WARNING: " + warning);
				}
				for (String error : errors) {
					writer.println("ERROR: " + error);
				}
			}
		}
	'''
	
	def String generateUtilityMethods() '''
		private String getSourcePath(String sourceName) {
			// Map source names to file paths
			return "data/" + sourceName + ".csv";
		}
		
		public void addWarning(String message) {
			warnings.add(message);
		}
		
		public void addError(String message) {
			errors.add(message);
		}
		
		public List<String> getWarnings() {
			return new ArrayList<>(warnings);
		}
		
		public List<String> getErrors() {
			return new ArrayList<>(errors);
		}
	'''
	
	def String generateTableClass() '''
		/**
		 * Internal Table representation
		 */
		private static class Table {
			private String name;
			private List<String> columns;
			private List<Map<String, Object>> rows;
			
			public Table(String name, List<String> columns) {
				this.name = name;
				this.columns = new ArrayList<>(columns);
				this.rows = new ArrayList<>();
			}
			
			public void addColumn(String columnName) {
				if (!columns.contains(columnName)) {
					columns.add(columnName);
				}
			}
			
			public void removeColumn(String columnName) {
				columns.remove(columnName);
			}
			
			public void addRow(Map<String, Object> row) {
				rows.add(new LinkedHashMap<>(row));
			}
			
			public void removeDuplicates(List<String> keyColumns) {
				// Implementation of duplicate removal
			}
			
			public void removeDuplicates() {
				// Implementation of full-row duplicate removal
			}
			
			public String getName() {
				return name;
			}
			
			public List<String> getColumns() {
				return new ArrayList<>(columns);
			}
			
			public List<Map<String, Object>> getRows() {
				return new ArrayList<>(rows);
			}
		}
	'''
	
	// Helper methods
	
	def String toClassName(String name) {
		val parts = name.split("_")
		parts.map[toFirstUpper].join
	}
	
	def String toFirstUpper(String str) {
		if (str.empty) return str
		str.charAt(0).toUpperCase + str.substring(1).toLowerCase
	}
	
	def String toJavaType(String ltsType) {
		switch(ltsType) {
			case "String": "String"
			case "Integer": "Integer"
			case "Decimal": "Double"
			case "Boolean": "Boolean"
			case "Date": "LocalDate"
			case "Time": "LocalTime"
			case "DateTime": "LocalDateTime"
			default: "Object"
		}
	}
	
	def String getSourcePath(String sourceName) {
		"data/" + sourceName + ".csv"
	}
}
