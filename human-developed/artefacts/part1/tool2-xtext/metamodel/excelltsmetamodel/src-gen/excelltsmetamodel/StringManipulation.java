/**
 */
package excelltsmetamodel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Manipulation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.StringManipulation#getTable <em>Table</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getStringManipulation()
 * @model abstract="true"
 * @generated
 */
public interface StringManipulation extends FlowStep {
	/**
	 * Returns the value of the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' reference.
	 * @see #setTable(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getStringManipulation_Table()
	 * @model required="true"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.StringManipulation#getTable <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

} // StringManipulation
