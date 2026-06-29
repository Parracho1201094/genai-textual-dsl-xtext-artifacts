/**
 */
package excelltsmetamodel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.Filter#getTable <em>Table</em>}</li>
 *   <li>{@link excelltsmetamodel.Filter#getColumn <em>Column</em>}</li>
 *   <li>{@link excelltsmetamodel.Filter#getOperand <em>Operand</em>}</li>
 *   <li>{@link excelltsmetamodel.Filter#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getFilter()
 * @model
 * @generated
 */
public interface Filter extends FlowStep {
	/**
	 * Returns the value of the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' reference.
	 * @see #setTable(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getFilter_Table()
	 * @model required="true"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Filter#getTable <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' reference.
	 * @see #setColumn(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getFilter_Column()
	 * @model required="true"
	 * @generated
	 */
	Column getColumn();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Filter#getColumn <em>Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' reference.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(Column value);

	/**
	 * Returns the value of the '<em><b>Operand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand</em>' attribute.
	 * @see #setOperand(String)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getFilter_Operand()
	 * @model required="true"
	 * @generated
	 */
	String getOperand();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Filter#getOperand <em>Operand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand</em>' attribute.
	 * @see #getOperand()
	 * @generated
	 */
	void setOperand(String value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link excelltsmetamodel.FilterOperatorType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see excelltsmetamodel.FilterOperatorType
	 * @see #setOperator(FilterOperatorType)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getFilter_Operator()
	 * @model required="true"
	 * @generated
	 */
	FilterOperatorType getOperator();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Filter#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see excelltsmetamodel.FilterOperatorType
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(FilterOperatorType value);

} // Filter
