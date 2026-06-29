package org.enorm.lts.ui.quickfix

import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.enorm.lts.validation.LtsValidator

class LtsQuickfixProvider extends DefaultQuickfixProvider {

    @Fix(LtsValidator.INVALID_CSV)
    def fixCsvExtension(Issue issue, IssueResolutionAcceptor acceptor) {
        acceptor.accept(issue,
            "Change extension to .csv",
            "Replace the file extension with .csv.",
            null
        ) [ context |
            val doc = context.xtextDocument
            doc.modify [
                val text = get(issue.offset, issue.length)
                val fixed = text.replaceAll("\\.[A-Za-z0-9_]+\\\"$", ".csv\\\"")
                replace(issue.offset, issue.length, fixed)
                null
            ]
        ]
    }

    @Fix(LtsValidator.DUPLICATE_TABLE)
    def renameDuplicateTable(Issue issue, IssueResolutionAcceptor acceptor) {
        acceptor.accept(issue,
            "Rename duplicate table",
            "Append _1 to the table name.",
            null
        ) [ context |
            val doc = context.xtextDocument
            doc.modify [
                val text = get(issue.offset, issue.length)
                replace(issue.offset, issue.length, text + "_1")
                null
            ]
        ]
    }

    @Fix(LtsValidator.DUPLICATE_COLUMN)
    def renameDuplicateColumn(Issue issue, IssueResolutionAcceptor acceptor) {
        acceptor.accept(issue,
            "Rename duplicate column",
            "Append _1 to the column name.",
            null
        ) [ context |
            val doc = context.xtextDocument
            doc.modify [
                val text = get(issue.offset, issue.length)
                replace(issue.offset, issue.length, text + "_1")
                null
            ]
        ]
    }
}
