/**
 */
package excelltsmetamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Join</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.Join#getTableLeft <em>Table Left</em>}</li>
 *   <li>{@link excelltsmetamodel.Join#getTableRight <em>Table Right</em>}</li>
 *   <li>{@link excelltsmetamodel.Join#getColumnLeft <em>Column Left</em>}</li>
 *   <li>{@link excelltsmetamodel.Join#getColumnRight <em>Column Right</em>}</li>
 *   <li>{@link excelltsmetamodel.Join#getType <em>Type</em>}</li>
 *   <li>{@link excelltsmetamodel.Join#getResultTable <em>Result Table</em>}</li>
 *   <li>{@link excelltsmetamodel.Join#getSelectColumns <em>Select Columns</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getJoin()
 * @model
 * @generated
 */
public interface Join extends FlowStep {
	/**
	 * Returns the value of the '<em><b>Table Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table Left</em>' reference.
	 * @see #setTableLeft(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getJoin_TableLeft()
	 * @model required="true"
	 * @generated
	 */
	Table getTableLeft();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Join#getTableLeft <em>Table Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table Left</em>' reference.
	 * @see #getTableLeft()
	 * @generated
	 */
	void setTableLeft(Table value);

	/**
	 * Returns the value of the '<em><b>Table Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table Right</em>' reference.
	 * @see #setTableRight(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getJoin_TableRight()
	 * @model required="true"
	 * @generated
	 */
	Table getTableRight();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Join#getTableRight <em>Table Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table Right</em>' reference.
	 * @see #getTableRight()
	 * @generated
	 */
	void setTableRight(Table value);

	/**
	 * Returns the value of the '<em><b>Column Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column Left</em>' reference.
	 * @see #setColumnLeft(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getJoin_ColumnLeft()
	 * @model required="true"
	 * @generated
	 */
	Column getColumnLeft();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Join#getColumnLeft <em>Column Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column Left</em>' reference.
	 * @see #getColumnLeft()
	 * @generated
	 */
	void setColumnLeft(Column value);

	/**
	 * Returns the value of the '<em><b>Column Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column Right</em>' reference.
	 * @see #setColumnRight(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getJoin_ColumnRight()
	 * @model required="true"
	 * @generated
	 */
	Column getColumnRight();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Join#getColumnRight <em>Column Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column Right</em>' reference.
	 * @see #getColumnRight()
	 * @generated
	 */
	void setColumnRight(Column value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link excelltsmetamodel.JoinType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see excelltsmetamodel.JoinType
	 * @see #setType(JoinType)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getJoin_Type()
	 * @model required="true"
	 * @generated
	 */
	JoinType getType();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Join#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see excelltsmetamodel.JoinType
	 * @see #getType()
	 * @generated
	 */
	void setType(JoinType value);

	/**
	 * Returns the value of the '<em><b>Result Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Table</em>' reference.
	 * @see #setResultTable(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getJoin_ResultTable()
	 * @model required="true"
	 * @generated
	 */
	Table getResultTable();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Join#getResultTable <em>Result Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Table</em>' reference.
	 * @see #getResultTable()
	 * @generated
	 */
	void setResultTable(Table value);

	/**
	 * Returns the value of the '<em><b>Select Columns</b></em>' reference list.
	 * The list contents are of type {@link excelltsmetamodel.Column}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Select Columns</em>' reference list.
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getJoin_SelectColumns()
	 * @model required="true"
	 * @generated
	 */
	EList<Column> getSelectColumns();

} // Join
