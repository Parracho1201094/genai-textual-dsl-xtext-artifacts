/**
 */
package excelltsmetamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Save</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.Save#getTablesToSave <em>Tables To Save</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getSave()
 * @model
 * @generated
 */
public interface Save extends FinalStep {
	/**
	 * Returns the value of the '<em><b>Tables To Save</b></em>' containment reference list.
	 * The list contents are of type {@link excelltsmetamodel.TableToSave}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tables To Save</em>' containment reference list.
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getSave_TablesToSave()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TableToSave> getTablesToSave();

} // Save
