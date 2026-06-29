/**
 */
package excelltsmetamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.Group#getTable <em>Table</em>}</li>
 *   <li>{@link excelltsmetamodel.Group#getGroupBy <em>Group By</em>}</li>
 *   <li>{@link excelltsmetamodel.Group#getResultTable <em>Result Table</em>}</li>
 *   <li>{@link excelltsmetamodel.Group#getOperandColumn <em>Operand Column</em>}</li>
 *   <li>{@link excelltsmetamodel.Group#getOperation <em>Operation</em>}</li>
 *   <li>{@link excelltsmetamodel.Group#getResultColumn <em>Result Column</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getGroup()
 * @model
 * @generated
 */
public interface Group extends FlowStep {
	/**
	 * Returns the value of the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' reference.
	 * @see #setTable(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getGroup_Table()
	 * @model required="true"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Group#getTable <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

	/**
	 * Returns the value of the '<em><b>Group By</b></em>' reference list.
	 * The list contents are of type {@link excelltsmetamodel.Column}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group By</em>' reference list.
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getGroup_GroupBy()
	 * @model required="true"
	 * @generated
	 */
	EList<Column> getGroupBy();

	/**
	 * Returns the value of the '<em><b>Result Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Table</em>' reference.
	 * @see #setResultTable(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getGroup_ResultTable()
	 * @model required="true"
	 * @generated
	 */
	Table getResultTable();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Group#getResultTable <em>Result Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Table</em>' reference.
	 * @see #getResultTable()
	 * @generated
	 */
	void setResultTable(Table value);

	/**
	 * Returns the value of the '<em><b>Operand Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand Column</em>' reference.
	 * @see #setOperandColumn(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getGroup_OperandColumn()
	 * @model required="true"
	 * @generated
	 */
	Column getOperandColumn();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Group#getOperandColumn <em>Operand Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand Column</em>' reference.
	 * @see #getOperandColumn()
	 * @generated
	 */
	void setOperandColumn(Column value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * The literals are from the enumeration {@link excelltsmetamodel.GroupOperationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see excelltsmetamodel.GroupOperationType
	 * @see #setOperation(GroupOperationType)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getGroup_Operation()
	 * @model required="true"
	 * @generated
	 */
	GroupOperationType getOperation();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Group#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see excelltsmetamodel.GroupOperationType
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(GroupOperationType value);

	/**
	 * Returns the value of the '<em><b>Result Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Column</em>' reference.
	 * @see #setResultColumn(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getGroup_ResultColumn()
	 * @model required="true"
	 * @generated
	 */
	Column getResultColumn();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Group#getResultColumn <em>Result Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Column</em>' reference.
	 * @see #getResultColumn()
	 * @generated
	 */
	void setResultColumn(Column value);

} // Group
