package excelltsmetamodel.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import excelltsmetamodel.AppendRows;
import excelltsmetamodel.Association;
import excelltsmetamodel.Column;
import excelltsmetamodel.Concat;
import excelltsmetamodel.Extract;
import excelltsmetamodel.Filter;
import excelltsmetamodel.FlowStep;
import excelltsmetamodel.GenericStep;
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
public class ServicesGraphical {

	public static Model generateGraphicalProjectionAux(Model model) {

		PrintWriter writer = null;
		FileWriter w;

		try {
			String homeDir = System.getProperty("user.dir");
			w = new FileWriter(homeDir + "/" + "graphical-" + model.getName() + ".puml");

			writer = new PrintWriter(w);

			String graphStr = "";
			graphStr += ("@startuml\n");
			graphStr += "digraph foo {\n";

			Set<Table> resultTableList = new HashSet<Table>();

			for (Step s : model.getSteps()) {

				if (s instanceof Import) {
					graphStr += createTableColorSchemaGraphviz(
							((Import) s).getTablesToImport().stream().map(t -> t.getTable()).toList(), false);
				}
				if (s instanceof Join) {
					resultTableList.add(((Join) s).getResultTable());
				}
				if (s instanceof Group) {
					resultTableList.add(((Group) s).getResultTable());
				}
				if (s instanceof AppendRows) {
					resultTableList.add(((AppendRows) s).getDestinTable());
				}
				if (s instanceof Lookup) {
					resultTableList.add(((Lookup) s).getResultTable());
				}
				if (s instanceof Concat) {
					resultTableList.add(((Concat) s).getResultTable());
				}
				if (s instanceof Split) {
					resultTableList.add(((Split) s).getResultTable());
				}
			}

			graphStr += createTableColorSchemaGraphviz(new ArrayList<>(resultTableList), true);
			graphStr += createStepColorSchemaGraphviz(model.getSteps());

			List<Table> tablesCreated = new ArrayList<Table>();
			Map<Step, Integer> stepMapAssociationName = new HashMap<Step, Integer>();
			int associationCount = 0;
			// Create all forms for the steps
			for (Step step : model.getSteps()) {

				if (step instanceof Sort) {
					graphStr += "\t\"" + step.getName() + "\" ";
					Sort sortStep = (Sort) step;
					graphStr += "\t[ shape=box , label=\"Type = Sort\\n\\n";
					graphStr += "Name = " + step.getName() + "\\n";
					graphStr += "Description = " + step.getDescription() + "\\n";
					graphStr += "From Table = " + sortStep.getTable().getName() + "\\n";
					graphStr += "On column = " + sortStep.getColumn().getName() + "\\n";
					graphStr += "Order = " + sortStep.getOrder().getName() + "\\n";
					graphStr += ("\"]\n");

				} else if (step instanceof Filter) {
					graphStr += "\t\"" + step.getName() + "\" ";
					Filter parsedStep = (Filter) step;
					graphStr += "\t[ shape=box , label=\"Type = Filter\\n\\n";
					graphStr += "Name = " + step.getName() + "\\n";
					graphStr += "Description = " + step.getDescription() + "\\n";
					graphStr += "From Table = " + parsedStep.getTable().getName() + "\\n";
					graphStr += "Expression = " + parsedStep.getColumn().getName() + " "
							+ parsedStep.getOperator().toString() + " " + parsedStep.getOperand() + "\\n";
					graphStr += ("\"]\n");

				} else if (step instanceof RemoveDuplicates) {
					graphStr += "\t\"" + step.getName() + "\" ";
					RemoveDuplicates parsedStep = (RemoveDuplicates) step;
					graphStr += "[ shape=box , label=\"Type = Remove Duplicates\\n\\n";
					graphStr += "Name = " + step.getName() + "\\n";
					graphStr += "Description = " + step.getDescription() + "\\n";
					graphStr += "From Table = " + parsedStep.getTable().getName() + "\\n";
					graphStr += "Target Column = " + parsedStep.getColumn().getName() + "\\n";
					graphStr += ("\"]\n");

				} else if (step instanceof Join) {
					graphStr += "\t\"" + step.getName() + "\" ";
					Join parsedStep = (Join) step;
					graphStr += "[ shape=box , label=\"Type = Join\\n\\n";
					graphStr += "Name = " + step.getName() + "\\n";
					graphStr += "Description = " + step.getDescription() + "\\n";
					graphStr += "Table Left = " + parsedStep.getTableLeft().getName() + "\\n";
					graphStr += "Table Right = " + parsedStep.getTableRight().getName() + "\\n";
					graphStr += "Type = " + parsedStep.getType().getName() + "\\n";
					graphStr += "Condition = " + parsedStep.getColumnLeft().getName() + " ON "
							+ parsedStep.getColumnRight().getName() + "\\n";
					graphStr += "Select Columns = " + parsedStep.getSelectColumns().stream().map(Column::getName)
							.collect(Collectors.joining(", ")) + "\\n";
					graphStr += ("\"]\n");

					if (!tablesCreated.contains(parsedStep.getResultTable())) {
						graphStr += createTableGraphviz(parsedStep.getResultTable());
						tablesCreated.add(parsedStep.getResultTable());
					}

				} else if (step instanceof Group) {
					graphStr += "\t\"" + step.getName() + "\" ";
					Group parsedStep = (Group) step;
					graphStr += "[ shape=box , label=\"Type = Group by\\n\\n";
					graphStr += "Name = " + step.getName() + "\\n";
					graphStr += "Description = " + step.getDescription() + "\\n";
					graphStr += "From Table = " + parsedStep.getTable().getName() + "\\n";
					graphStr += "Result Table = " + parsedStep.getResultTable().getName() + "\\n";
					graphStr += "Result Column = " + parsedStep.getResultColumn().getName() + "\\n";
					graphStr += ("\"]\n");

					if (!tablesCreated.contains(parsedStep.getResultTable())) {
						graphStr += createTableGraphviz(parsedStep.getResultTable());
						tablesCreated.add(parsedStep.getResultTable());
					}

				} else if (step instanceof AppendRows) {
					graphStr += "\t\"" + step.getName() + "\" ";
					AppendRows parsedStep = (AppendRows) step;
					graphStr += "\t[ shape=box , label=\"Type = Append rows\\n\\n";
					graphStr += "Name = " + step.getName() + "\\n";
					graphStr += "Description = " + step.getDescription() + "\\n";
					graphStr += "From Table = " + parsedStep.getOriginTable().getName() + "\\n";
					graphStr += "Result Table = " + parsedStep.getDestinTable().getName() + "\\n";
					graphStr += ("\"]\n");

					if (!tablesCreated.contains(parsedStep.getDestinTable())) {
						graphStr += createTableGraphviz(parsedStep.getDestinTable());
						tablesCreated.add(parsedStep.getDestinTable());
					}

					// add associations
					graphStr += createAssociationGraphviz(parsedStep.getAssociations(), parsedStep.getOriginTable(),
							parsedStep.getDestinTable(), associationCount);
					stepMapAssociationName.put(step, associationCount++);

				} else if (step instanceof Lookup) {
					graphStr += "\t\"" + step.getName() + "\" ";
					Lookup parsedStep = (Lookup) step;
					graphStr += "\t[ shape=box , label=\"Type = Join\\n\\n";
					graphStr += "Name = " + step.getName() + "\\n";
					graphStr += "Description = " + step.getDescription() + "\\n";
					graphStr += "Origin Table = " + parsedStep.getTable().getName() + "\\n";
					graphStr += "Lookup Table = " + parsedStep.getLookupTable().getName() + "\\n";
					graphStr += "Result Table = " + parsedStep.getResultTable().getName() + "\\n";
					graphStr += "Base Column(origin table) = " + parsedStep.getColumn().getName() + "\\n";
					graphStr += "Match Column (lookup table) = " + parsedStep.getMatchColumn().getName() + "\\n";
					graphStr += "Operand column (origin table) = " + parsedStep.getOperandColumn().getName() + "\\n";
					graphStr += "Operation = " + parsedStep.getOperation().getName() + "\\n";
					graphStr += "Operator (lookup table) = " + parsedStep.getOperation().getName() + "\\n";
					graphStr += ("\"]\n");

					if (!tablesCreated.contains(parsedStep.getResultTable())) {
						graphStr += createTableGraphviz(parsedStep.getResultTable());
						tablesCreated.add(parsedStep.getResultTable());
					}

				} else if (step instanceof Import) {
					graphStr += "\t\"" + step.getName() + "\" ";
					Import parsedStep = (Import) step;
					graphStr += "\t[ shape=box , label=\"Type = Import\\n\\n";
					graphStr += "Name = " + step.getName() + "\\n";
					graphStr += "Description = " + step.getDescription() + "\\n";
					graphStr += "Table Info: \\n";
					for (TableToImport tableToImport : parsedStep.getTablesToImport()) {
						graphStr += "\\t" + tableToImport.getTable().getName() + " = Path(" + tableToImport.getPath()
								+ ") Delimiter(" + tableToImport.getDelimiter() + ") Delete Missmatched("
								+ tableToImport.getPath() + ")\\n";
					}

					graphStr += ("\"]\n");

					for (TableToImport t : parsedStep.getTablesToImport()) {
						if (!tablesCreated.contains(t.getTable())) {
							graphStr += createTableGraphviz(t.getTable());
							tablesCreated.add(t.getTable());
						}
					}

				} else if (step instanceof Save) {
					graphStr += "\t\"" + step.getName() + "\" ";
					Save parsedStep = (Save) step;
					graphStr += "\t[ shape=box , label=\"Type = Save\\n\\n";
					graphStr += "Name = " + step.getName() + "\\n";
					graphStr += "Description = " + step.getDescription() + "\\n";

					graphStr += "Table Info: \\n";
					for (TableToSave tableToSave : parsedStep.getTablesToSave()) {
						graphStr += "\\t" + tableToSave.getTable().getName() + " = Path(" + tableToSave.getPath()
								+ ")\\n";
					}
					graphStr += ("\"]\n");

					for (TableToSave t : parsedStep.getTablesToSave()) {
						if (!tablesCreated.contains(t.getTable())) {
							graphStr += createTableGraphviz(t.getTable());
							tablesCreated.add(t.getTable());
						}
					}

				} else if (step instanceof Concat) {
					graphStr += "\t\"" + step.getName() + "\" ";
					Concat parsedStep = (Concat) step;
					graphStr += "\t[ shape=box , label=\"Type = Concat\\n\\n";
					graphStr += "Name = " + step.getName() + "\\n";
					graphStr += "Description = " + step.getDescription() + "\\n";
					graphStr += "Base Table = " + parsedStep.getTable().getName() + "\\n";
					graphStr += "Source A = " + parsedStep.getSourceA().getName() + "\\n";
					graphStr += "Source B = " + parsedStep.getSourceB().getName() + "\\n";
					graphStr += "Result Column = " + parsedStep.getResultColumn().getName() + "\\n";
					graphStr += "Result Table = " + parsedStep.getResultTable().getName() + "\\n";
					graphStr += ("\"]\n");

					if (!tablesCreated.contains(parsedStep.getResultTable())) {
						graphStr += createTableGraphviz(parsedStep.getResultTable());
						tablesCreated.add(parsedStep.getResultTable());
					}

				} else if (step instanceof Split) {
					graphStr += "\t\"" + step.getName() + "\" ";
					Split parsedStep = (Split) step;
					boolean showChars = parsedStep.getNumOfChars() != -1;
					graphStr += "\t[ shape=box , label=\"Type = Split\\n\\n";
					graphStr += "Name = " + step.getName() + "\\n";
					graphStr += "Description = " + step.getDescription() + "\\n";
					graphStr += "Base Table = " + parsedStep.getTable().getName() + "\\n";
					if (showChars) {
						graphStr += "Num chars = " + parsedStep.getNumOfChars() + "\\n";
					} else {
						graphStr += "Delimiter = '" + parsedStep.getDelimiter() + "'\\n";
					}
					graphStr += "Result Column A = " + parsedStep.getResultColumnA().getName() + "\\n";
					graphStr += "Result Column B = " + parsedStep.getResultColumnB().getName() + "\\n";
					graphStr += "Result Table = " + parsedStep.getResultTable().getName() + "\\n";
					graphStr += ("\"]\n");

					if (!tablesCreated.contains(parsedStep.getResultTable())) {
						graphStr += createTableGraphviz(parsedStep.getResultTable());
						tablesCreated.add(parsedStep.getResultTable());
					}

				} else if (step instanceof Extract) {
					graphStr += "\t\"" + step.getName() + "\" ";
					Extract parsedStep = (Extract) step;
					boolean showPattern = parsedStep.getLbChar() == -1 && parsedStep.getUbChar() == -1;
					graphStr += "\t[ shape=box , label=\"Type = Extract\\n\\n";
					graphStr += "Name = " + step.getName() + "\\n";
					graphStr += "Description = " + step.getDescription() + "\\n";
					graphStr += "Base Table = " + parsedStep.getTable().getName() + "\\n";
					graphStr += "Column = " + parsedStep.getColumn().getName() + "\\n";
					if (showPattern) {
						graphStr += "Pattern = " + parsedStep.getPattern() + "\\n";
					} else {
						graphStr += "Lower bound = " + parsedStep.getLbChar() + "\\n";
						graphStr += "Upper bound = " + parsedStep.getUbChar() + "\\n";
					}
					graphStr += ("\"]\n");

				} else if (step instanceof GenericStep) {
					graphStr += "\t\"" + step.getName() + "\" ";
					graphStr += "\t[ shape=box , label=\"Type = Generic\\n\\n";
					graphStr += "Name = " + step.getName() + "\\n";
					graphStr += "Description = " + step.getDescription() + "\\n";
					graphStr += ("\"]\n");

				}
			}

			// Connect the steps
			for (Step step : model.getSteps()) {
				if (step instanceof FlowStep) {
					graphStr += ("\t\"" + step.getName() + "\" -> \"" + ((FlowStep) step).getNext().getName() + "\""
							+ " [ label= \"Next\" ]\n");
				}

				if (step instanceof Join) {
					Join parsedStep = (Join) step;
					graphStr += "\t\"" + step.getName() + "\" -> \"" + parsedStep.getResultTable().getName()
							+ "\" [ label= \"Produces\" ]\n";
				}

				if (step instanceof Group) {
					Group parsedStep = (Group) step;
					graphStr += "\t\"" + step.getName() + "\" -> \"" + parsedStep.getResultTable().getName()
							+ "\" [ label= \"Produces\" ]\n";
				}

				if (step instanceof AppendRows) {
					AppendRows parsedStep = (AppendRows) step;
					graphStr += "\t\"" + step.getName() + "\" -> \"" + parsedStep.getDestinTable().getName()
							+ "\" [ label= \"Produces\" ]\n";

					graphStr += "\t\"" + step.getName() + "\" -> \"" + "Association" + stepMapAssociationName.get(step)
							+ "\" [ label= \"Maps as\" ]\n";
				}

				if (step instanceof Lookup) {
					Lookup parsedStep = (Lookup) step;
					graphStr += "\t\"" + step.getName() + "\" -> \"" + parsedStep.getResultTable().getName()
							+ "\" [ label= \"Fill result on\" ]\n";
				}

				if (step instanceof Import) {
					Import parsedStep = (Import) step;
					for (TableToImport t : parsedStep.getTablesToImport()) {
						graphStr += "\t\"" + t.getTable().getName() + "\" -> \"" + step.getName()
								+ "\" [ label= \"Imported\" ]\n";
					}
				}

				if (step instanceof Save) {
					Save parsedStep = (Save) step;
					for (TableToSave t : parsedStep.getTablesToSave()) {
						graphStr += "\t\"" + step.getName() + "\" -> \"" + t.getTable().getName()
								+ "\" [ label= \"Saves\" ]\n";
					}
				}

				if (step instanceof Concat) {
					Concat parsedStep = (Concat) step;
					graphStr += "\t\"" + step.getName() + "\" -> \"" + parsedStep.getResultTable().getName()
							+ "\" [ label= \"Writes on\" ]\n";
				}

				if (step instanceof Split) {
					Split parsedStep = (Split) step;
					graphStr += "\t\"" + step.getName() + "\" -> \"" + parsedStep.getResultTable().getName()
							+ "\" [ label= \"Writes on\" ]\n";
				}

			}
			writer.println(graphStr);
			writer.println("}");
			writer.println("@enduml");
			writer.close();
		} catch (

		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.setName(e.getMessage());
		}

		return model;
	}

	private static String createTableGraphviz(Table table) {
		String node = "";
		node += "\t\"" + table.getName() + "\"";
		node += "[ shape=box , label=\"Table: " + table.getName() + "\\n";
		for (Column column : table.getColumns()) {
			node += column.getName() + " : " + column.getDataType().getName() + "\\n";
		}
		node += "\"]\n";
		return node;
	}

	private static String createAssociationGraphviz(List<Association> associationList, Table tableOrigin,
			Table tableDestin, int num) {
		String node = "";
		node += "\t\"Association" + num + "\" ";
		node += "[ shape=box , label=\"Association \\n";
		for (Association association : associationList) {
			node += tableOrigin.getName() + "." + association.getOriginCol().getName() + " -> " + tableDestin.getName()
					+ "." + association.getDestinCol().getName() + "\\n";
		}
		node += "\"]\n";
		return node;
	}

	private static String createTableColorSchemaGraphviz(List<Table> tables, boolean isResult) {
		StringBuilder node = new StringBuilder();
		if (isResult) {
			node.append("\tsubgraph tier2 {\n");
			node.append("\t\tnode [color=\"lightyellow\",style=\"filled\",group=\"tier2\"]\n");
		} else {
			node.append("\tsubgraph tier1 {\n");
			node.append("\t\tnode [color=\"#99ff99\",style=\"filled\",group=\"tier1\"]\n");
		}
		for (Table t : tables) {
			node.append("\t\t\"").append(t.getName()).append("\"\n");
		}
		node.append("\t}\n");
		return node.toString();
	}

	private static String createStepColorSchemaGraphviz(List<Step> steps) {
		StringBuilder node = new StringBuilder();

		node.append("\tsubgraph tier3 {\n");
		node.append("\t\tnode [color=\"lightblue\",style=\"filled\",group=\"tier2\"]\n");
		for (Step s : steps) {
			node.append("\t\t\"").append(s.getName()).append("\"\n");
		}
		node.append("\t}\n");
		return node.toString();
	}

}
