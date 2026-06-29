package excelltsmetamodel.design;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import excelltsmetamodel.design.ServicesTextual;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import excelltsmetamodel.AppendRows;
import excelltsmetamodel.Association;
import excelltsmetamodel.Column;
import excelltsmetamodel.Concat;
import excelltsmetamodel.ExcelltsmetamodelFactory;
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
public class Services {

	public void textualProjection(Model model) {
		ServicesTextual.textualProjectionAux(model);
	}

	/**
	 * Generates a graphically representation of Model.
	 * @param model Instance to be projected.
	 */
	public void generateGraphicalProjection(Model model) {
		ServicesGraphical.generateGraphicalProjectionAux(model);
	}

	/**
	 * Method responsible to delete tables that had been signal to be imported more
	 * than one time.
	 */
	public Import fixTableCanOnlyBeImportedOneTime(Import importStep) {
		Set<Table> uniqueTables = new HashSet<>();
		List<TableToImport> tablesToRemove = new ArrayList<>();

		for (TableToImport tableEntry : importStep.getTablesToImport()) {
			if (uniqueTables.contains(tableEntry.getTable())) {
				tablesToRemove.add(tableEntry);
			} else {
				uniqueTables.add(tableEntry.getTable());
			}
		}
		importStep.getTablesToImport().removeAll(tablesToRemove);
		return importStep;
	}

	/**
	 * Method responsible to remove tables that had been signal to be saved more
	 * than one time.
	 */
	public Save fixTableCanOnlyBeSavedOneTime(Save saveStep) {
		Set<Table> uniqueTables = new HashSet<>();
		List<TableToSave> tablesToRemove = new ArrayList<>();

		for (TableToSave tableEntry : saveStep.getTablesToSave()) {
			if (uniqueTables.contains(tableEntry.getTable())) {
				tablesToRemove.add(tableEntry);
			} else {
				uniqueTables.add(tableEntry.getTable());
			}
		}
		saveStep.getTablesToSave().removeAll(tablesToRemove);
		return saveStep;
	}

	/**
	 * Method responsible to delete imports steps, if exists more than one. Note: It
	 * remains the first one found on the list.
	 */
	public Model fixHasMoreThanOneImportStep(Model model) {
		List<Step> toRemove = new ArrayList<>();
		Integer count = 0;

		for (Step step : model.getSteps()) {
			if (step instanceof Import) {
				Import importStep = (Import) step;
				if (count > 0) {
					toRemove.add(importStep);
				}
				count++;
			}
		}
		model.getSteps().removeAll(toRemove);
		return model;
	}

	/**
	 * Method responsible to delete save steps, if exists more than one. Note: It
	 * remains the first one found on the list.
	 */
	public Model fixHasMoreThanOneSaveStep(Model model) {
		List<Step> toRemove = new ArrayList<>();
		Integer count = 0;

		for (Step step : model.getSteps()) {
			if (step instanceof Save) {
				Save saveStep = (Save) step;
				if (count > 0) {
					toRemove.add(saveStep);
				}
				count++;
			}
		}
		model.getSteps().removeAll(toRemove);
		return model;
	}

	/**
	 * Method responsible to insert a default Import method in the Model.
	 */
	public Model fixMissingImportStep(Model model) {
		Import nImport = ExcelltsmetamodelFactory.eINSTANCE.createImport();
		nImport.setName("[Generated] Import name");
		nImport.setDescription("[Generated] Import description");

		model.getSteps().add(nImport);

		return model;
	}

	/**
	 * Method responsible to insert a default Save method in the Model.
	 */
	public Model fixMissingSaveStep(Model model) {
		Save nSave = ExcelltsmetamodelFactory.eINSTANCE.createSave();
		nSave.setName("[Generated] Save name");
		nSave.setDescription("[Generated] Save description");

		model.getSteps().add(nSave);

		return model;
	}

	/**
	 * Method responsible to delete all tables that are not being used.
	 */
	public Model fixTablesThatAreNotBeingUsed(Model model) {
		// Collect all tables that are referenced in the model.
		Set<Table> referencedTables = new HashSet<>();
		TreeIterator<EObject> iterator = model.eAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			for (EReference eReference : eObject.eClass().getEAllReferences()) {
				if (!eReference.isMany()) {
					Object value = eObject.eGet(eReference);
					if (value instanceof Table) {
						referencedTables.add((Table) value);
					}
				} else {
					Collection<?> valueList = (Collection<?>) eObject.eGet(eReference);
					valueList.stream().filter(Table.class::isInstance).map(Table.class::cast)
							.forEach(referencedTables::add);
				}
			}
		}

		// Identify and report unused tables.
		for (int i = 0; i < model.getTables().size(); i++) {
			Table modelTable = model.getTables().get(i);
			if (!referencedTables.contains(modelTable)) {
				model.getTables().remove(modelTable);
			}
		}
		return model;
	}

	/**
	 * Method responsible to delete steps that are not being used.
	 */
	public Model fixStepsThatAreNotBeingUsed(Model model) {
		// Collect all steps that are referenced in the model.
		Set<Step> referencedSteps = new HashSet<>();
		TreeIterator<EObject> iterator = model.eAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			for (EReference eReference : eObject.eClass().getEAllReferences()) {
				if (!eReference.isMany()) {
					Object value = eObject.eGet(eReference);
					if (value instanceof Step) {
						referencedSteps.add((Step) value);
					}
				} else {
					Collection<?> valueList = (Collection<?>) eObject.eGet(eReference);
					valueList.stream().filter(Step.class::isInstance).map(Step.class::cast)
							.forEach(referencedSteps::add);
				}
			}
		}

		// Identify and report unused steps.
		for (int i = 0; i < model.getSteps().size(); i++) {
			Step mStep = model.getSteps().get(i);
			if (!referencedSteps.contains(mStep) && !(mStep instanceof Import)) {
				model.getSteps().remove(mStep);
			}
		}
		return model;
	}
}
