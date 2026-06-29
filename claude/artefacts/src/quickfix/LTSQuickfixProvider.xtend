/*
 * LTSQuickfixProvider.xtend
 *
 * Quick-fix proposals for validation errors detected by LTSValidator.
 * Each @Fix method is triggered by the matching error/warning code and
 * receives an IssueResolutionAcceptor into which it registers one or more
 * automated corrections.
 *
 * Package: org.lts.ui.quickfix
 */
package org.lts.ui.quickfix

import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.lts.validation.LTSValidator

class LTSQuickfixProvider extends DefaultQuickfixProvider {

    // ─────────────────────────────────────────────────────────────────────────
    // QF-01  noLoadStep
    //
    // The process has no LoadStep at all.
    // Resolution: insert a 'load <firstTable>' line at the start of the steps.
    // ─────────────────────────────────────────────────────────────────────────
    @Fix(LTSValidator.NO_LOAD_STEP)
    def addMissingLoadStep(Issue issue, IssueResolutionAcceptor acceptor) {
        acceptor.accept(
            issue,
            "Add 'load' step for the first declared table",
            "Inserts a load step for the first table declared in the process.",
            "load.gif"
        ) [ context |
            val document = context.xtextDocument
            val text     = document.get

            // Locate the opening brace of the step section.
            // Strategy: find the last '}' of a table/datasource/log block
            // and insert the load statement right after it.
            val insertMarker = findStepInsertionPoint(text)
            if (insertMarker >= 0) {
                document.replace(insertMarker, 0, "\n    load /* TODO: replace with your table name */\n")
            }
        ]
    }

    // ─────────────────────────────────────────────────────────────────────────
    // QF-02  unknownSortColumn
    //
    // A sort key names a column that does not exist in the table.
    // The issue data carries the offending column name.
    // Resolution options:
    //   a) Remove the unknown sort key entirely.
    //   b) Replace with the closest matching column name (Levenshtein).
    // ─────────────────────────────────────────────────────────────────────────
    @Fix(LTSValidator.UNKNOWN_SORT_COLUMN)
    def fixUnknownSortColumn(Issue issue, IssueResolutionAcceptor acceptor) {
        val badName = issue.data?.get(0) ?: "unknown"

        // Option a: remove the bad sort key
        acceptor.accept(
            issue,
            "Remove unknown sort key '" + badName + "'",
            "Deletes the sort key referencing a non-existent column.",
            "delete.gif"
        ) [ context |
            deleteTextAtIssue(context.xtextDocument, issue)
        ]

        // Option b: let the user pick a replacement by opening rename refactoring
        acceptor.accept(
            issue,
            "Rename sort key '" + badName + "'",
            "Opens an inline rename dialog to correct the column name.",
            "rename.gif"
        ) [ context |
            // In a real plugin this delegates to the linked-mode rename refactoring.
            // Here we replace with a TODO placeholder so the user sees it clearly.
            replaceTextAtIssue(context.xtextDocument, issue, "/* TODO: valid column name */")
        ]
    }

    // ─────────────────────────────────────────────────────────────────────────
    // QF-03  calculateUnknownColumn
    //
    // A CalculateColumnStep refers to a column that does not exist.
    // Resolution: replace the 'calculate' with 'add column' which creates it.
    // ─────────────────────────────────────────────────────────────────────────
    @Fix(LTSValidator.CALCULATE_UNKNOWN_COLUMN)
    def fixCalculateToAddColumn(Issue issue, IssueResolutionAcceptor acceptor) {
        val colName = issue.data?.get(0) ?: "newColumn"

        acceptor.accept(
            issue,
            "Change to 'add column " + colName + "'",
            "Converts the 'calculate' step into an 'add column' step, " +
            "which creates the column before assigning the expression.",
            "add.gif"
        ) [ context |
            val doc  = context.xtextDocument
            val text = doc.get(issue.offset, issue.length)
            // Replace 'calculate <col> =' with 'add column <col> : /* TYPE */ ='
            val fixed = text.replaceFirst("^calculate\\s+", "add column ").
                             replaceFirst("\\s*=", " : /* DataType */ =")
            doc.replace(issue.offset, issue.length, fixed)
        ]
    }

    // ─────────────────────────────────────────────────────────────────────────
    // QF-04  joinTypeMismatch
    //
    // Two join key columns have incompatible types.
    // Resolution: wrap the right-hand key in a type-cast comment so the user
    // knows a manual fix is needed (Xtext cannot auto-change schema types
    // without deeper model access, so we provide a guidance comment).
    // ─────────────────────────────────────────────────────────────────────────
    @Fix(LTSValidator.JOIN_TYPE_MISMATCH)
    def fixJoinTypeMismatch(Issue issue, IssueResolutionAcceptor acceptor) {
        acceptor.accept(
            issue,
            "Mark join key for manual type correction",
            "Adds a TODO comment next to the join so you can fix the type mismatch.",
            "warning.gif"
        ) [ context |
            val doc    = context.xtextDocument
            val offset = issue.offset + issue.length
            doc.replace(offset, 0, " /* TODO: ensure both key columns share the same DataType */")
        ]
    }

    // ─────────────────────────────────────────────────────────────────────────
    // QF-05  missingLogDeclaration
    //
    // The process has no log declaration.
    // Resolution: insert a default log block before the first step.
    // ─────────────────────────────────────────────────────────────────────────
    @Fix(LTSValidator.MISSING_LOG_DECLARATION)
    def addMissingLog(Issue issue, IssueResolutionAcceptor acceptor) {
        acceptor.accept(
            issue,
            "Add default log declaration",
            "Inserts a log declaration that writes WARNING-level messages to 'output/process.log'.",
            "log.gif"
        ) [ context |
            val doc  = context.xtextDocument
            val text = doc.get
            // Insert before first 'load' keyword
            val loadIdx = text.indexOf("load ")
            if (loadIdx >= 0) {
                doc.replace(loadIdx, 0,
                    "log processLog to \"output/process.log\"\n        level: WARNING\n\n    "
                )
            }
        ]
    }

    // ─────────────────────────────────────────────────────────────────────────
    // QF-06  duplicateColumnName
    //
    // Two columns share the same name inside a table declaration.
    // Resolution: append a numeric suffix to the second occurrence.
    // ─────────────────────────────────────────────────────────────────────────
    @Fix(LTSValidator.DUPLICATE_COLUMN_NAME)
    def fixDuplicateColumnName(Issue issue, IssueResolutionAcceptor acceptor) {
        acceptor.accept(
            issue,
            "Rename duplicate column (append '_2')",
            "Appends '_2' to the duplicate column name so both can coexist.",
            "rename.gif"
        ) [ context |
            val doc  = context.xtextDocument
            val orig = doc.get(issue.offset, issue.length)
            doc.replace(issue.offset, issue.length, orig + "_2")
        ]
    }

    // ─────────────────────────────────────────────────────────────────────────
    // QF-07  removeUnknownColumn  (used by both RemoveColumnsStep & RemoveDuplicatesStep)
    //
    // The column name to drop/key does not exist.
    // Resolution: remove the entry from the list.
    // ─────────────────────────────────────────────────────────────────────────
    @Fix(LTSValidator.REMOVE_UNKNOWN_COLUMN)
    def fixRemoveUnknownColumn(Issue issue, IssueResolutionAcceptor acceptor) {
        acceptor.accept(
            issue,
            "Remove reference to unknown column",
            "Deletes the non-existent column name from the step.",
            "delete.gif"
        ) [ context |
            deleteTextAtIssue(context.xtextDocument, issue)
        ]
    }

    // ─────────────────────────────────────────────────────────────────────────
    // QF-08  copySchemaIncompatible
    //
    // A source column is absent from the target table.
    // Resolution: add the missing column declaration to the target table.
    // ─────────────────────────────────────────────────────────────────────────
    @Fix(LTSValidator.COPY_SCHEMA_INCOMPATIBLE)
    def fixCopySchemaMismatch(Issue issue, IssueResolutionAcceptor acceptor) {
        acceptor.accept(
            issue,
            "Add missing column to target table",
            "Inserts a placeholder column declaration into the target table. " +
            "You must set the correct DataType manually.",
            "add.gif"
        ) [ context |
            val doc  = context.xtextDocument
            val text = doc.get
            // Find the closing brace of the target output table and insert before it.
            // This is a simplified heuristic; a full implementation would use the
            // semantic model to navigate to the correct location.
            val targetKeyword = "output table"
            val idx = text.lastIndexOf(targetKeyword)
            if (idx >= 0) {
                val closeBrace = text.indexOf("}", idx)
                if (closeBrace >= 0) {
                    doc.replace(closeBrace, 0, "    missingColumn : /* DataType */\n    ")
                }
            }
        ]
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Internal helpers
    // ─────────────────────────────────────────────────────────────────────────

    def private void deleteTextAtIssue(IXtextDocument doc, Issue issue) {
        // Widen deletion to consume a trailing comma and optional whitespace
        var offset = issue.offset
        var length = issue.length
        val fullText = doc.get
        val after = if (offset + length < fullText.length) fullText.charAt(offset + length) else 0 as char
        if (after == ',') length++ // eat trailing comma
        doc.replace(offset, length, "")
    }

    def private void replaceTextAtIssue(IXtextDocument doc, Issue issue, String replacement) {
        doc.replace(issue.offset, issue.length, replacement)
    }

    def private int findStepInsertionPoint(String text) {
        // Return the position right after the last closing brace of a table/datasource/log block.
        var depth = 0
        var lastTopLevelClose = -1
        var inString = false
        for (var i = 0; i < text.length; i++) {
            val ch = text.charAt(i)
            if (ch == '"') inString = !inString
            if (!inString) {
                if (ch == '{') depth++
                else if (ch == '}') {
                    depth--
                    if (depth == 1) lastTopLevelClose = i + 1
                }
            }
        }
        lastTopLevelClose
    }
}
