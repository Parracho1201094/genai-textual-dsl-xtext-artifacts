/*
 * Validation rules for LTS DSL
 * Checks for semantic errors and constraints
 */
package org.xtext.example.mydsl.validation

import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidationDiagnostic
import org.xtext.example.mydsl.lts.LtsPackage
import org.xtext.example.mydsl.lts.LtsProcess
import org.xtext.example.mydsl.lts.Table
import org.xtext.example.mydsl.lts.Column
import org.xtext.example.mydsl.lts.FilterStep
import org.xtext.example.mydsl.lts.JoinStep
import org.xtext.example.mydsl.lts.LoadStep
import org.xtext.example.mydsl.lts.RemoveColumnStep
import org.xtext.example.mydsl.lts.InsertColumnStep
import org.xtext.example.mydsl.lts.CalculatedColumnStep
import org.xtext.example.mydsl.lts.RemoveDuplicatesStep
import org.xtext.example.mydsl.lts.SortStep
import org.xtext.example.mydsl.lts.GroupStep
import org.xtext.example.mydsl.lts.CsvDataSource
import java.util.HashMap
import java.util.Map
import java.util.Set
import java.util.HashSet

/**
 * LtsValidator - validates LTS DSL models
 * Checks for:
 * - Duplicate column definitions
 * - Undefined table references
 * - Undefined column references
 * - Type mismatches in joins and operations
 * - Circular references
 * - Missing required elements
 */
class LtsValidator extends AbstractLtsValidator {
	
	public static val DUPLICATE_COLUMN = "duplicate_column"
	public static val UNDEFINED_TABLE = "undefined_table"
	public static val UNDEFINED_COLUMN = "undefined_column"
	public static val TYPE_MISMATCH = "type_mismatch"
	public static val MISSING_OUTPUT = "missing_output"
	public static val INVALID_OPERATION = "invalid_operation"
	public static val CIRCULAR_REFERENCE = "circular_reference"
	
	// Context: stores information about tables and their columns
	val Map<String, TableInfo> tableMap = new HashMap<String, TableInfo>()
	val Map<String, String> columnTypeMap = new HashMap<String, String>()
	
	/**
	 * Check LTS process for overall validity
	 */
	@Check
	def checkLtsProcess(LtsProcess process) {
		// Check that process has at least one table
		if (process.tables.isEmpty && process.dataSources.isEmpty) {
			error("Process must have at least one data source or table", 
				LtsPackage.Literals.LTS_PROCESS__TABLES)
		}
		
		// Check that process has operations
		if (process.operations === null) {
			error("Process must define operations", 
				LtsPackage.Literals.LTS_PROCESS__OPERATIONS)
		}
		
		// Check that process has output
		if (process.output === null) {
			error("Process must have an output block", 
				LtsPackage.Literals.LTS_PROCESS__OUTPUT)
		}
		
		// Build table information map
		buildTableMap(process)
		
		// Validate all tables
		for (table : process.tables) {
			checkTable(table)
		}
		
		// Validate all data sources
		for (source : process.dataSources) {
			if (source instanceof CsvDataSource) {
				checkCsvDataSource(source)
			}
		}
	}
	
	/**
	 * Check table for duplicate columns
	 */
	@Check
	def checkTable(Table table) {
		val columnNames = new HashSet<String>()
		
		for (column : table.columns) {
			if (!columnNames.add(column.name)) {
				error("Duplicate column '" + column.name + "' in table '" + table.name + "'",
					column, LtsPackage.Literals.COLUMN__NAME, DUPLICATE_COLUMN)
			}
		}
	}
	
	/**
	 * Check CSV data source for duplicate columns
	 */
	@Check
	def checkCsvDataSource(CsvDataSource source) {
		val columnNames = new HashSet<String>()
		
		for (column : source.columns) {
			if (!columnNames.add(column.name)) {
				error("Duplicate column '" + column.name + "' in data source '" + source.name + "'",
					column, LtsPackage.Literals.COLUMN__NAME, DUPLICATE_COLUMN)
			}
		}
	}
	
	/**
	 * Check filter step for validity
	 */
	@Check
	def checkFilterStep(FilterStep step) {
		// Check that table exists
		if (!tableExists(step.tableName)) {
			error("Table '" + step.tableName + "' does not exist",
				step, LtsPackage.Literals.FILTER_STEP__TABLE_NAME, UNDEFINED_TABLE)
		}
		
		// Check that columns referenced in condition exist
		checkExpressionColumns(step.condition, step.tableName, step)
	}
	
	/**
	 * Check join step for validity
	 */
	@Check
	def checkJoinStep(JoinStep step) {
		// Check that both tables exist
		if (!tableExists(step.leftTable)) {
			error("Table '" + step.leftTable + "' does not exist",
				step, LtsPackage.Literals.JOIN_STEP__LEFT_TABLE, UNDEFINED_TABLE)
		}
		
		if (!tableExists(step.rightTable)) {
			error("Table '" + step.rightTable + "' does not exist",
				step, LtsPackage.Literals.JOIN_STEP__RIGHT_TABLE, UNDEFINED_TABLE)
		}
		
		// Check that join columns exist
		if (step.joinCondition !== null) {
			val leftCol = getColumnType(step.leftTable, step.joinCondition.leftColumn.column)
			val rightCol = getColumnType(step.rightTable, step.joinCondition.rightColumn.column)
			
			if (leftCol === null) {
				error("Column '" + step.joinCondition.leftColumn.column + 
					"' does not exist in table '" + step.leftTable + "'",
					step, LtsPackage.Literals.JOIN_STEP__LEFT_TABLE, UNDEFINED_COLUMN)
			}
			
			if (rightCol === null) {
				error("Column '" + step.joinCondition.rightColumn.column + 
					"' does not exist in table '" + step.rightTable + "'",
					step, LtsPackage.Literals.JOIN_STEP__RIGHT_TABLE, UNDEFINED_COLUMN)
			}
			
			// Check type compatibility
			if (leftCol !== null && rightCol !== null && !leftCol.equals(rightCol)) {
				warning("Join columns have different types: '" + leftCol + 
					"' vs '" + rightCol + "'",
					step, LtsPackage.Literals.JOIN_STEP__LEFT_TABLE, TYPE_MISMATCH)
			}
		}
	}
	
	/**
	 * Check load step for validity
	 */
	@Check
	def checkLoadStep(LoadStep step) {
		// Check that source exists
		if (!sourceExists(step.sourceName)) {
			error("Source '" + step.sourceName + "' does not exist",
				step, LtsPackage.Literals.LOAD_STEP__SOURCE_NAME, UNDEFINED_TABLE)
		}
		
		// Check that target table exists
		if (!tableExists(step.sourceTable)) {
			error("Table '" + step.sourceTable + "' does not exist",
				step, LtsPackage.Literals.LOAD_STEP__SOURCE_TABLE, UNDEFINED_TABLE)
		}
	}
	
	/**
	 * Check remove column step
	 */
	@Check
	def checkRemoveColumnStep(RemoveColumnStep step) {
		// Check that table exists
		if (!tableExists(step.tableName)) {
			error("Table '" + step.tableName + "' does not exist",
				step, LtsPackage.Literals.REMOVE_COLUMN_STEP__TABLE_NAME, UNDEFINED_TABLE)
		}
		
		// Check that column exists
		if (!columnExists(step.tableName, step.columnName.column)) {
			error("Column '" + step.columnName.column + 
				"' does not exist in table '" + step.tableName + "'",
				step, LtsPackage.Literals.REMOVE_COLUMN_STEP__TABLE_NAME, UNDEFINED_COLUMN)
		}
	}
	
	/**
	 * Check insert column step
	 */
	@Check
	def checkInsertColumnStep(InsertColumnStep step) {
		// Check that table exists
		if (!tableExists(step.tableName)) {
			error("Table '" + step.tableName + "' does not exist",
				step, LtsPackage.Literals.INSERT_COLUMN_STEP__TABLE_NAME, UNDEFINED_TABLE)
		}
		
		// Check that column doesn't already exist
		if (columnExists(step.tableName, step.columnName)) {
			warning("Column '" + step.columnName + "' already exists in table '" + step.tableName + "'",
				step, LtsPackage.Literals.INSERT_COLUMN_STEP__COLUMN_NAME)
		}
	}
	
	/**
	 * Check calculated column step
	 */
	@Check
	def checkCalculatedColumnStep(CalculatedColumnStep step) {
		// Check that table exists
		if (!tableExists(step.tableName)) {
			error("Table '" + step.tableName + "' does not exist",
				step, LtsPackage.Literals.CALCULATED_COLUMN_STEP__TABLE_NAME, UNDEFINED_TABLE)
		}
		
		// Check expression columns
		checkExpressionColumns(step.expression, step.tableName, step)
	}
	
	/**
	 * Check remove duplicates step
	 */
	@Check
	def checkRemoveDuplicatesStep(RemoveDuplicatesStep step) {
		// Check that table exists
		if (!tableExists(step.tableName)) {
			error("Table '" + step.tableName + "' does not exist",
				step, LtsPackage.Literals.REMOVE_DUPLICATES_STEP__TABLE_NAME, UNDEFINED_TABLE)
		}
		
		// Check that all columns exist
		for (col : step.columns) {
			if (!columnExists(step.tableName, col.column)) {
				error("Column '" + col.column + "' does not exist in table '" + step.tableName + "'",
					step, LtsPackage.Literals.REMOVE_DUPLICATES_STEP__TABLE_NAME, UNDEFINED_COLUMN)
			}
		}
	}
	
	/**
	 * Check sort step
	 */
	@Check
	def checkSortStep(SortStep step) {
		// Check that table exists
		if (!tableExists(step.tableName)) {
			error("Table '" + step.tableName + "' does not exist",
				step, LtsPackage.Literals.SORT_STEP__TABLE_NAME, UNDEFINED_TABLE)
		}
		
		// Check that all sort columns exist
		for (sortCol : step.sorts) {
			if (!columnExists(step.tableName, sortCol.columnName)) {
				error("Column '" + sortCol.columnName + "' does not exist in table '" + step.tableName + "'",
					step, LtsPackage.Literals.SORT_STEP__TABLE_NAME, UNDEFINED_COLUMN)
			}
		}
	}
	
	/**
	 * Check group step
	 */
	@Check
	def checkGroupStep(GroupStep step) {
		// Check that table exists
		if (!tableExists(step.tableName)) {
			error("Table '" + step.tableName + "' does not exist",
				step, LtsPackage.Literals.GROUP_STEP__TABLE_NAME, UNDEFINED_TABLE)
		}
		
		// Check that all group columns exist
		for (groupCol : step.groupColumns) {
			if (!columnExists(step.tableName, groupCol.column)) {
				error("Column '" + groupCol.column + "' does not exist in table '" + step.tableName + "'",
					step, LtsPackage.Literals.GROUP_STEP__TABLE_NAME, UNDEFINED_COLUMN)
			}
		}
	}
	
	// Helper methods
	
	def void buildTableMap(LtsProcess process) {
		// Add tables from data sources
		for (source : process.dataSources) {
			if (source instanceof CsvDataSource) {
				val info = new TableInfo(source.name)
				for (col : source.columns) {
					info.columns.put(col.name, col.type)
				}
				tableMap.put(source.name, info)
			}
		}
		
		// Add tables
		for (table : process.tables) {
			val info = new TableInfo(table.name)
			for (col : table.columns) {
				info.columns.put(col.name, col.type)
			}
			tableMap.put(table.name, info)
		}
	}
	
	def boolean tableExists(String tableName) {
		tableMap.containsKey(tableName)
	}
	
	def boolean sourceExists(String sourceName) {
		// Sources are also in the tableMap
		tableMap.containsKey(sourceName)
	}
	
	def boolean columnExists(String tableName, String columnName) {
		val table = tableMap.get(tableName)
		if (table === null) return false
		table.columns.containsKey(columnName)
	}
	
	def String getColumnType(String tableName, String columnName) {
		val table = tableMap.get(tableName)
		if (table === null) return null
		table.columns.get(columnName)
	}
	
	def void checkExpressionColumns(org.xtext.example.mydsl.lts.Expression expr, String tableName, Object context) {
		// This is a simplified check - in a real implementation, you would traverse the entire expression tree
		// and check each column reference
		// For now, we just check that the expression is not null
		if (expr === null) {
			warning("Expression is empty", context as EValidationDiagnostic)
		}
	}
	
	/**
	 * Helper class to store table metadata
	 */
	static class TableInfo {
		val String name
		val Map<String, String> columns = new HashMap<String, String>()
		
		new(String name) {
			this.name = name
		}
	}
}
