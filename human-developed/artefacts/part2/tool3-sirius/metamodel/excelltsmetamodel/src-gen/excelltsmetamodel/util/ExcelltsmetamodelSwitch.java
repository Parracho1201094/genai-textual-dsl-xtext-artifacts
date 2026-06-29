/**
 */
package excelltsmetamodel.util;

import excelltsmetamodel.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see excelltsmetamodel.ExcelltsmetamodelPackage
 * @generated
 */
public class ExcelltsmetamodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExcelltsmetamodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExcelltsmetamodelSwitch() {
		if (modelPackage == null) {
			modelPackage = ExcelltsmetamodelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case ExcelltsmetamodelPackage.MODEL: {
			Model model = (Model) theEObject;
			T result = caseModel(model);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.STEP: {
			Step step = (Step) theEObject;
			T result = caseStep(step);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.FLOW_STEP: {
			FlowStep flowStep = (FlowStep) theEObject;
			T result = caseFlowStep(flowStep);
			if (result == null)
				result = caseStep(flowStep);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.FINAL_STEP: {
			FinalStep finalStep = (FinalStep) theEObject;
			T result = caseFinalStep(finalStep);
			if (result == null)
				result = caseStep(finalStep);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.SAVE: {
			Save save = (Save) theEObject;
			T result = caseSave(save);
			if (result == null)
				result = caseFinalStep(save);
			if (result == null)
				result = caseStep(save);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.TABLE: {
			Table table = (Table) theEObject;
			T result = caseTable(table);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.GROUP: {
			Group group = (Group) theEObject;
			T result = caseGroup(group);
			if (result == null)
				result = caseFlowStep(group);
			if (result == null)
				result = caseStep(group);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.COLUMN: {
			Column column = (Column) theEObject;
			T result = caseColumn(column);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.SORT: {
			Sort sort = (Sort) theEObject;
			T result = caseSort(sort);
			if (result == null)
				result = caseFlowStep(sort);
			if (result == null)
				result = caseStep(sort);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.APPEND_ROWS: {
			AppendRows appendRows = (AppendRows) theEObject;
			T result = caseAppendRows(appendRows);
			if (result == null)
				result = caseFlowStep(appendRows);
			if (result == null)
				result = caseStep(appendRows);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.TABLE_TO_SAVE: {
			TableToSave tableToSave = (TableToSave) theEObject;
			T result = caseTableToSave(tableToSave);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.ASSOCIATION: {
			Association association = (Association) theEObject;
			T result = caseAssociation(association);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.FILTER: {
			Filter filter = (Filter) theEObject;
			T result = caseFilter(filter);
			if (result == null)
				result = caseFlowStep(filter);
			if (result == null)
				result = caseStep(filter);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.GENERIC_STEP: {
			GenericStep genericStep = (GenericStep) theEObject;
			T result = caseGenericStep(genericStep);
			if (result == null)
				result = caseFlowStep(genericStep);
			if (result == null)
				result = caseStep(genericStep);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.JOIN: {
			Join join = (Join) theEObject;
			T result = caseJoin(join);
			if (result == null)
				result = caseFlowStep(join);
			if (result == null)
				result = caseStep(join);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.IMPORT: {
			Import import_ = (Import) theEObject;
			T result = caseImport(import_);
			if (result == null)
				result = caseFlowStep(import_);
			if (result == null)
				result = caseStep(import_);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT: {
			TableToImport tableToImport = (TableToImport) theEObject;
			T result = caseTableToImport(tableToImport);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.LOOKUP: {
			Lookup lookup = (Lookup) theEObject;
			T result = caseLookup(lookup);
			if (result == null)
				result = caseFlowStep(lookup);
			if (result == null)
				result = caseStep(lookup);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.REMOVE_DUPLICATES: {
			RemoveDuplicates removeDuplicates = (RemoveDuplicates) theEObject;
			T result = caseRemoveDuplicates(removeDuplicates);
			if (result == null)
				result = caseFlowStep(removeDuplicates);
			if (result == null)
				result = caseStep(removeDuplicates);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.CONCAT: {
			Concat concat = (Concat) theEObject;
			T result = caseConcat(concat);
			if (result == null)
				result = caseStringManipulation(concat);
			if (result == null)
				result = caseFlowStep(concat);
			if (result == null)
				result = caseStep(concat);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.STRING_MANIPULATION: {
			StringManipulation stringManipulation = (StringManipulation) theEObject;
			T result = caseStringManipulation(stringManipulation);
			if (result == null)
				result = caseFlowStep(stringManipulation);
			if (result == null)
				result = caseStep(stringManipulation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.SPLIT: {
			Split split = (Split) theEObject;
			T result = caseSplit(split);
			if (result == null)
				result = caseStringManipulation(split);
			if (result == null)
				result = caseFlowStep(split);
			if (result == null)
				result = caseStep(split);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExcelltsmetamodelPackage.EXTRACT: {
			Extract extract = (Extract) theEObject;
			T result = caseExtract(extract);
			if (result == null)
				result = caseStringManipulation(extract);
			if (result == null)
				result = caseFlowStep(extract);
			if (result == null)
				result = caseStep(extract);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStep(Step object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowStep(FlowStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Final Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Final Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFinalStep(FinalStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Save</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Save</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSave(Save object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Table</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTable(Table object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroup(Group object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Column</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Column</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColumn(Column object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sort</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sort</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSort(Sort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Append Rows</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Append Rows</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAppendRows(AppendRows object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Table To Save</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Table To Save</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTableToSave(TableToSave object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssociation(Association object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilter(Filter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericStep(GenericStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Join</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Join</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJoin(Join object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImport(Import object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Table To Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Table To Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTableToImport(TableToImport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lookup</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lookup</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLookup(Lookup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Duplicates</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Duplicates</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveDuplicates(RemoveDuplicates object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concat</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concat</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcat(Concat object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Manipulation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Manipulation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringManipulation(StringManipulation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Split</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Split</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSplit(Split object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extract</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extract</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtract(Extract object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ExcelltsmetamodelSwitch
