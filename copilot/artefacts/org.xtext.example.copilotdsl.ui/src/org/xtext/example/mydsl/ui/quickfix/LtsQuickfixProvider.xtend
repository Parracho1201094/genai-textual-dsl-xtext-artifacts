/*
 * Quick Fixes for LTS DSL
 * Provides automatic fixes for common validation errors
 */
package org.xtext.example.mydsl.ui.quickfix

import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.xtext.example.mydsl.validation.LtsValidator
import org.eclipse.xtext.ui.editor.quickfix.AbstractDeclarativeQuickfixProvider

/**
 * Quick fix provider for LTS DSL
 * Provides suggestions to fix common errors
 */
class LtsQuickfixProvider extends AbstractDeclarativeQuickfixProvider {
	
	/**
	 * Quick fix for duplicate column errors
	 * Removes the duplicate column definition
	 */
	@Fix(LtsValidator.DUPLICATE_COLUMN)
	def fixDuplicateColumn(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove duplicate column", 
			"Remove the duplicate column definition", null) [ context |
			val model = context.resource.contents.get(0)
			// Implementation: Find and remove the duplicate column
			// This would need to traverse the model and remove the column
		]
	}
	
	/**
	 * Quick fix for undefined table references
	 * Suggests creating the missing table or correcting the name
	 */
	@Fix(LtsValidator.UNDEFINED_TABLE)
	def fixUndefinedTable(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Create missing table", 
			"Create a new table with the referenced name", null) [ context |
			val model = context.resource.contents.get(0)
			// Implementation: Create a new table definition
		]
		
		acceptor.accept(issue, "Choose from existing tables", 
			"Choose from a list of available tables", null) [ context |
			val model = context.resource.contents.get(0)
			// Implementation: Show a menu of available tables for selection
		]
	}
	
	/**
	 * Quick fix for undefined column references
	 * Suggests creating the missing column or correcting the name
	 */
	@Fix(LtsValidator.UNDEFINED_COLUMN)
	def fixUndefinedColumn(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Create missing column", 
			"Create a new column with the referenced name", null) [ context |
			val model = context.resource.contents.get(0)
			// Implementation: Create a new column definition
		]
		
		acceptor.accept(issue, "Choose from available columns", 
			"Choose from a list of available columns", null) [ context |
			val model = context.resource.contents.get(0)
			// Implementation: Show a menu of available columns
		]
	}
	
	/**
	 * Quick fix for type mismatches in joins
	 * Suggests adding a type conversion
	 */
	@Fix(LtsValidator.TYPE_MISMATCH)
	def fixTypeMismatch(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add type conversion", 
			"Convert one of the columns to match the other's type", null) [ context |
			val model = context.resource.contents.get(0)
			// Implementation: Suggest converting one column to the other's type
		]
		
		acceptor.accept(issue, "Change join condition", 
			"Select different columns with matching types", null) [ context |
			val model = context.resource.contents.get(0)
			// Implementation: Show available columns with matching types
		]
	}
	
	/**
	 * Quick fix for missing output block
	 * Adds a template output block
	 */
	@Fix(LtsValidator.MISSING_OUTPUT)
	def fixMissingOutput(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add output block", 
			"Insert a template output block with save operations", null) [ context |
			val model = context.resource.contents.get(0)
			// Implementation: Add a template output block
			// output {
			//   save log to "process.log";
			// }
		]
	}
	
	/**
	 * Refactoring: Rename table across all references
	 */
	def renameTable(String oldName, String newName) {
		// Implementation: Find all references to oldName and replace with newName
		// This would be called from a refactoring action
	}
	
	/**
	 * Refactoring: Rename column across all references
	 */
	def renameColumn(String tableName, String oldColumnName, String newColumnName) {
		// Implementation: Find all references to tableName.oldColumnName and replace with newColumnName
	}
	
	/**
	 * Refactoring: Extract operation into a separate process
	 */
	def extractOperations(java.util.List<?> selectedOperations, String processName) {
		// Implementation: Create a new process with the selected operations
		// and replace them with a call to the new process
	}
	
	/**
	 * Refactoring: Inline operation
	 */
	def inlineOperation(String operationName) {
		// Implementation: Replace operation call with its definition
	}
	
	/**
	 * Refactoring: Replace manual join with built-in join operation
	 */
	def simplifyJoin() {
		// Implementation: Detect patterns that could be simplified using join operations
	}
	
	/**
	 * Refactoring: Combine filters
	 */
	def combineFilters() {
		// Implementation: Detect multiple consecutive filters on the same table
		// and combine them into a single filter with AND logic
	}
}
