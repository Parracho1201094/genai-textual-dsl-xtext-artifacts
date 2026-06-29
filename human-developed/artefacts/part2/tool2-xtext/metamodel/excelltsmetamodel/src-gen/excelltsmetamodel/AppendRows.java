/**
 */
package excelltsmetamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Append Rows</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.AppendRows#getOriginTable <em>Origin Table</em>}</li>
 *   <li>{@link excelltsmetamodel.AppendRows#getDestinTable <em>Destin Table</em>}</li>
 *   <li>{@link excelltsmetamodel.AppendRows#getAssociations <em>Associations</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getAppendRows()
 * @model
 * @generated
 */
public interface AppendRows extends FlowStep {
	/**
	 * Returns the value of the '<em><b>Origin Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin Table</em>' reference.
	 * @see #setOriginTable(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getAppendRows_OriginTable()
	 * @model required="true"
	 * @generated
	 */
	Table getOriginTable();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.AppendRows#getOriginTable <em>Origin Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin Table</em>' reference.
	 * @see #getOriginTable()
	 * @generated
	 */
	void setOriginTable(Table value);

	/**
	 * Returns the value of the '<em><b>Destin Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destin Table</em>' reference.
	 * @see #setDestinTable(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getAppendRows_DestinTable()
	 * @model required="true"
	 * @generated
	 */
	Table getDestinTable();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.AppendRows#getDestinTable <em>Destin Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destin Table</em>' reference.
	 * @see #getDestinTable()
	 * @generated
	 */
	void setDestinTable(Table value);

	/**
	 * Returns the value of the '<em><b>Associations</b></em>' containment reference list.
	 * The list contents are of type {@link excelltsmetamodel.Association}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associations</em>' containment reference list.
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getAppendRows_Associations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Association> getAssociations();

} // AppendRows
