/**
 */
package excelltsmetamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.Import#getTablesToImport <em>Tables To Import</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getImport()
 * @model
 * @generated
 */
public interface Import extends FlowStep {
	/**
	 * Returns the value of the '<em><b>Tables To Import</b></em>' containment reference list.
	 * The list contents are of type {@link excelltsmetamodel.TableToImport}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tables To Import</em>' containment reference list.
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getImport_TablesToImport()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TableToImport> getTablesToImport();

} // Import
