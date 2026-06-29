/**
 */
package excelltsmetamodel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sort</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.Sort#getTable <em>Table</em>}</li>
 *   <li>{@link excelltsmetamodel.Sort#getColumn <em>Column</em>}</li>
 *   <li>{@link excelltsmetamodel.Sort#getOrder <em>Order</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getSort()
 * @model
 * @generated
 */
public interface Sort extends FlowStep {
	/**
	 * Returns the value of the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' reference.
	 * @see #setTable(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getSort_Table()
	 * @model required="true"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Sort#getTable <em>Table</em>}' reference.
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
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getSort_Column()
	 * @model required="true"
	 * @generated
	 */
	Column getColumn();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Sort#getColumn <em>Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' reference.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(Column value);

	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * The literals are from the enumeration {@link excelltsmetamodel.OrderType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see excelltsmetamodel.OrderType
	 * @see #setOrder(OrderType)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getSort_Order()
	 * @model required="true"
	 * @generated
	 */
	OrderType getOrder();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Sort#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see excelltsmetamodel.OrderType
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(OrderType value);

} // Sort
