package org.example.lts.ui.quickfix;

import static org.example.lts.validation.LtsIssueCodes.*;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

public class LtsQuickfixProvider extends DefaultQuickfixProvider {
    @Fix(UNKNOWN_COLUMN)
    public void replaceUnknownColumn(Issue issue, IssueResolutionAcceptor acceptor) {
        String suggestion = data(issue, 0);
        if (!suggestion.isEmpty()) {
            acceptor.accept(issue, "Change to '" + suggestion + "'",
                    "Replace the unknown column with the closest schema column.",
                    null,
                    context -> context.getXtextDocument().replace(
                            issue.getOffset(), issue.getLength(), suggestion));
        }
    }

    @Fix(UNKNOWN_FUNCTION)
    public void replaceUnknownFunction(Issue issue, IssueResolutionAcceptor acceptor) {
        String suggestion = data(issue, 0);
        if (!suggestion.isEmpty()) {
            acceptor.accept(issue, "Change to '" + suggestion + "'",
                    "Replace the unknown function with the closest built-in function.",
                    null,
                    context -> context.getXtextDocument().replace(
                            issue.getOffset(), issue.getLength(), suggestion));
        }
    }

    @Fix(INCOMPATIBLE_TYPES)
    public void convertExpression(Issue issue, IssueResolutionAcceptor acceptor) {
        String targetType = data(issue, 0);
        String conversion = "to" + Character.toUpperCase(targetType.charAt(0))
                + targetType.substring(1);
        acceptor.accept(issue, "Convert expression with " + conversion,
                "Wrap the expression in an explicit LTS conversion.",
                null,
                context -> {
                    IXtextDocument document = context.getXtextDocument();
                    String original = document.get(issue.getOffset(), issue.getLength());
                    document.replace(issue.getOffset(), issue.getLength(),
                            conversion + "(" + original + ")");
                });
    }

    @Fix(TABLE_NOT_READY)
    public void initializeTable(Issue issue, IssueResolutionAcceptor acceptor) {
        String table = data(issue, 0);
        String action = data(issue, 1);
        String statement = action + " " + table + ";";
        acceptor.accept(issue, "Insert '" + statement + "'",
                "Initialize the table immediately before this operation.",
                null,
                context -> insertAtLineStart(context.getXtextDocument(),
                        issue.getOffset(), statement));
    }

    @Fix(MISSING_LOG_LEVEL)
    public void addLogLevel(Issue issue, IssueResolutionAcceptor acceptor) {
        String level = data(issue, 0);
        acceptor.accept(issue, "Add '" + level + "' to log levels",
                "Include this diagnostic level in the log output.",
                null,
                context -> {
                    IXtextDocument document = context.getXtextDocument();
                    int line = document.getLineOfOffset(issue.getOffset());
                    int start = document.getLineOffset(line);
                    int length = document.getLineLength(line);
                    String text = document.get(start, length);
                    int semicolon = text.indexOf(';');
                    if (semicolon >= 0) {
                        document.replace(start + semicolon, 0, ", " + level);
                    }
                });
    }

    @Fix(COLUMN_ALREADY_DECLARED)
    public void replaceInsertWithCalculate(Issue issue, IssueResolutionAcceptor acceptor) {
        acceptor.accept(issue, "Use 'calculate column'",
                "A declared column should be populated with a calculation.",
                null,
                context -> {
                    IXtextDocument document = context.getXtextDocument();
                    int line = document.getLineOfOffset(issue.getOffset());
                    int start = document.getLineOffset(line);
                    int length = document.getLineLength(line);
                    String text = document.get(start, length);
                    int insert = text.indexOf("insert column");
                    if (insert >= 0) {
                        document.replace(start + insert, "insert column".length(),
                                "calculate column");
                        int colon = text.indexOf(':', insert);
                        int equals = text.indexOf('=', insert);
                        if (colon >= 0 && equals > colon) {
                            document.replace(start + colon, equals - colon, " ");
                        }
                    }
                });
    }

    private void insertAtLineStart(IXtextDocument document, int offset, String statement)
            throws BadLocationException {
        int line = document.getLineOfOffset(offset);
        int start = document.getLineOffset(line);
        String current = document.get(start, document.getLineLength(line));
        String indentation = current.substring(0,
                current.length() - current.replaceFirst("^\\s+", "").length());
        document.replace(start, 0, indentation + statement + System.lineSeparator());
    }

    private String data(Issue issue, int index) {
        return issue.getData() != null && issue.getData().length > index
                && issue.getData()[index] != null ? issue.getData()[index] : "";
    }
}
