/**
 */
package excelltsmetamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.Model#getName <em>Name</em>}</li>
 *   <li>{@link excelltsmetamodel.Model#isLogs <em>Logs</em>}</li>
 *   <li>{@link excelltsmetamodel.Model#getTables <em>Tables</em>}</li>
 *   <li>{@link excelltsmetamodel.Model#getSteps <em>Steps</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getModel_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Model#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Logs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logs</em>' attribute.
	 * @see #setLogs(boolean)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getModel_Logs()
	 * @model required="true"
	 * @generated
	 */
	boolean isLogs();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Model#isLogs <em>Logs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logs</em>' attribute.
	 * @see #isLogs()
	 * @generated
	 */
	void setLogs(boolean value);

	/**
	 * Returns the value of the '<em><b>Tables</b></em>' containment reference list.
	 * The list contents are of type {@link excelltsmetamodel.Table}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tables</em>' containment reference list.
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getModel_Tables()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Table> getTables();

	/**
	 * Returns the value of the '<em><b>Steps</b></em>' containment reference list.
	 * The list contents are of type {@link excelltsmetamodel.Step}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steps</em>' containment reference list.
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getModel_Steps()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Step> getSteps();

} // Model
