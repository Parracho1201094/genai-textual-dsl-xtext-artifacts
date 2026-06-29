package excelltsmetamodel.design;

import java.util.List;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.eclipse.emf.ecore.EObject;
import excelltsmetamodel.AppendRows;
import excelltsmetamodel.Association;
import excelltsmetamodel.Column;
import excelltsmetamodel.Concat;
import excelltsmetamodel.Extract;
import excelltsmetamodel.Filter;
import excelltsmetamodel.Group;
import excelltsmetamodel.Import;
import excelltsmetamodel.Join;
import excelltsmetamodel.Lookup;
import excelltsmetamodel.Model;
import excelltsmetamodel.RemoveDuplicates;
import excelltsmetamodel.Save;
import excelltsmetamodel.Sort;
import excelltsmetamodel.Split;
import excelltsmetamodel.Step;
import excelltsmetamodel.Table;
import excelltsmetamodel.TableToImport;
import excelltsmetamodel.TableToSave;

/**
 * The services class used by VSM.
 */
public class ServicesTextual {

	protected static void textualProjectionAux(Model model) {

		PrintWriter writer = null;
		FileWriter w;
		try {
			String homeDir = System.getProperty("user.dir");
			w = new FileWriter(homeDir + "/" + "textual-" + model.getName() + ".txt");
			writer = new PrintWriter(w);
			writer.println("etl:");
			
			traverseTables("  ", writer, model.getTables());
			traverseSteps("  ", writer, model.getSteps());

			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void traverseTables(String indentation, PrintWriter writer, List<Table> tables) {
		writer.println(indentation + "tables:");
		for (Table tableNode : tables) {
			table(tableNode, indentation + "  ", writer);
		}
	}

	private static void table(Table tableNode, String indentation, PrintWriter writer) {
		writer.println(indentation + tableNode.getName() + ":");
		for (Column columnNode : tableNode.getColumns()) {
			writer.println(indentation + "  " + columnNode.getName() + " as " + columnNode.getDataType().getName());
		}
	}

	private static void traverseSteps(String indentation, PrintWriter writer, List<Step> steps) {
		writer.println(indentation + "steps:");
		String innerIndentation = indentation + "  ";
		for (Step step : steps) {
			if (step instanceof Import) {
				importStep((Import) step, innerIndentation, writer);
			} else if (step instanceof Save) {
				saveStep((Save) step, innerIndentation, writer);
			} else if (step instanceof Filter) {
				filterStep((Filter) step, innerIndentation, writer);
			} else if (step instanceof Group) {
				groupBy((Group) step, innerIndentation, writer);
			} else if (step instanceof Join) {
				join((Join) step, innerIndentation, writer);
			} else if (step instanceof Sort) {
				sort((Sort) step, innerIndentation, writer);
			} else if (step instanceof AppendRows) {
				appendRows((AppendRows) step, innerIndentation, writer);
			} else if (step instanceof RemoveDuplicates) {
				removeDuplicates((RemoveDuplicates) step, innerIndentation, writer);
			} else if (step instanceof Lookup) {
				lookup((Lookup) step, innerIndentation, writer);
			} else if (step instanceof Concat) {
				strConcat((Concat) step, innerIndentation, writer);
			} else if (step instanceof Split) {
				strSplit((Split) step, innerIndentation, writer);
			} else if (step instanceof Extract) {
				strExtract((Extract) step, innerIndentation, writer);
			}
		}
	}

	private static void importStep(Import stepNode, String indentation, PrintWriter writer) {
		writer.println(indentation + "IMPORT: ");
		for (TableToImport tableToImportNode : stepNode.getTablesToImport()) {
			writer.println(indentation + "  IMPORT FROM \"" + tableToImportNode.getPath() + "\" TO "
					+ tableToImportNode.getTable().getName() + " WITH DELIMITER \"" + tableToImportNode.getDelimiter()
					+ "\" AND DELETE_MISTMATCHED_TYPES AS " + tableToImportNode.getDelimiter());
		}
	}

	private static void saveStep(Save stepNode, String indentation, PrintWriter writer) {
		writer.println(indentation + "SAVE: ");
		for (TableToSave tableToSaveNode : stepNode.getTablesToSave()) {
			String content = indentation + "  SAVE " + tableToSaveNode.getTable().getName() + "(";

			for (String columnRefNode : tableToSaveNode.getColumnsNames()) {
				content += columnRefNode + ", ";
			}
			writer.println(
					content.substring(0, content.length() - 2) + ")" + " TO \"" + tableToSaveNode.getPath() + "\"");
		}
	}

	private static void filterStep(Filter stepNode, String indentation, PrintWriter writer) {
		writer.println(
				indentation + "FILTER " + stepNode.getTable().getName() + " WHERE " + stepNode.getColumn().getName()
						+ " " + stepNode.getOperator().getName() + " " + stepNode.getOperand());
	}

	private static void groupBy(Group stepNode, String indentation, PrintWriter writer) {
		String content = indentation + "GROUP " + stepNode.getTable().getName() + " BY (";

		for (Column columnRefNode : stepNode.getGroupBy()) {
			content += columnRefNode.getName() + ", ";
		}
		content = content.substring(0, content.length() - 2) + ")" + " AND PUT " + stepNode.getOperation().getName()
				+ "(" + stepNode.getOperandColumn().getName() + ") INTO " + stepNode.getResultTable().getName() + "("
				+ stepNode.getResultColumn().getName() + ")";

		writer.println(content);
	}

	private static void join(Join stepNode, String indentation, PrintWriter writer) {
		String content = indentation + stepNode.getType().getName() + " JOIN " + stepNode.getTableLeft().getName() + "("
				+ stepNode.getColumnLeft().getName() + ") WITH " + stepNode.getTableRight().getName() + "("
				+ stepNode.getColumnRight().getName() + ") INTO " + stepNode.getResultTable().getName() + "(";

		for (Column columnRefNode : stepNode.getSelectColumns()) {
			content += columnRefNode.getName() + ", ";
		}
		content = content.substring(0, content.length() - 2) + ")";
		writer.println(content);
	}

	private static void sort(Sort stepNode, String indentation, PrintWriter writer) {
		writer.println(indentation + "SORT " + stepNode.getTable().getName() + " BY " + stepNode.getColumn().getName()
				+ " WITH " + stepNode.getOrder().getName() + " ORDER");
	}

	private static void appendRows(AppendRows stepNode, String indentation, PrintWriter writer) {
		String content = indentation + "APPEND ROWS FROM " + stepNode.getOriginTable().getName() + "(";
		String toCols = "(";

		for (Association association : stepNode.getAssociations()) {
			content += association.getOriginCol().getName() + ", ";
			toCols += association.getOriginCol().getName() + ", ";
		}
		content = content.substring(0, content.length() - 2) + ")" + " TO " + stepNode.getDestinTable().getName()
				+ toCols.substring(0, toCols.length() - 2) + ")";

		writer.println(content);
	}

	private static void removeDuplicates(RemoveDuplicates stepNode, String indentation, PrintWriter writer) {
		writer.println(indentation + "REMOVE DUPLICATES FROM " + stepNode.getTable().getName() + "("
				+ stepNode.getColumn().getName() + ")");
	}

	private static void lookup(Lookup stepNode, String indentation, PrintWriter writer) {
		writer.println(indentation + "LOOKUP FROM " + stepNode.getTable().getName() + "("
				+ stepNode.getColumn().getName() + ") TO " + stepNode.getLookupTable().getName() + "("
				+ stepNode.getMatchColumn().getName() + ") AND PUT " + stepNode.getOperation().getName() + "("
				+ stepNode.getTable().getName() + "(" + stepNode.getOperandColumn().getName() + "), "
				+ stepNode.getLookupTable().getName() + "(" + stepNode.getLookupColumn().getName());
	}

	private static void strConcat(Concat stepNode, String indentation, PrintWriter writer) {
		writer.println(indentation + "STR CONCAT " + stepNode.getTable().getName() + "("
				+ stepNode.getSourceA().getName() + ", " + stepNode.getSourceB().getName() + ") INTO "
				+ stepNode.getResultTable().getName() + "(" + stepNode.getResultColumn().getName() + ")");
	}

	private static void strSplit(Split stepNode, String indentation, PrintWriter writer) {
		String content = indentation + "STR SPLIT " + stepNode.getTable().getName() + "("
				+ stepNode.getSource().getName() + ") ";

		if (stepNode.getNumOfChars() == -1) {
			content += "AT_FIRST_OCCURRENCE OF \"" + stepNode.getDelimiter() + "\"";
		} else {
			content += "AT_CHAR_INDEX " + stepNode.getNumOfChars();
		}

		writer.println(content + " INTO " + stepNode.getResultTable().getName() + "("
				+ stepNode.getResultColumnA().getName() + ", " + stepNode.getResultColumnB().getName() + ")");
	}

	private static void strExtract(Extract stepNode, String indentation, PrintWriter writer) {
		String content = indentation + "STR EXTRACT " + stepNode.getTable().getName() + "("
				+ stepNode.getColumn().getName() + ") ";

		if (stepNode.getLbChar() == -1 && stepNode.getUbChar() == -1) {
			content += "WITH PATTERN \"" + stepNode.getPattern() + "\"";
		} else {
			content += "FROM " + stepNode.getLbChar() + " TO " + stepNode.getUbChar();
		}
		writer.println(content);
	}
}
