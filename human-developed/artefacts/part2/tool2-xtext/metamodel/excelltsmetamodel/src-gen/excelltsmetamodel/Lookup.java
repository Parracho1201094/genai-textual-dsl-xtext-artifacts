/**
 */
package excelltsmetamodel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lookup</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.Lookup#getTable <em>Table</em>}</li>
 *   <li>{@link excelltsmetamodel.Lookup#getLookupTable <em>Lookup Table</em>}</li>
 *   <li>{@link excelltsmetamodel.Lookup#getColumn <em>Column</em>}</li>
 *   <li>{@link excelltsmetamodel.Lookup#getOperandColumn <em>Operand Column</em>}</li>
 *   <li>{@link excelltsmetamodel.Lookup#getMatchColumn <em>Match Column</em>}</li>
 *   <li>{@link excelltsmetamodel.Lookup#getLookupColumn <em>Lookup Column</em>}</li>
 *   <li>{@link excelltsmetamodel.Lookup#getResultColumn <em>Result Column</em>}</li>
 *   <li>{@link excelltsmetamodel.Lookup#getOperation <em>Operation</em>}</li>
 *   <li>{@link excelltsmetamodel.Lookup#getResultTable <em>Result Table</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getLookup()
 * @model
 * @generated
 */
public interface Lookup extends FlowStep {
	/**
	 * Returns the value of the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' reference.
	 * @see #setTable(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getLookup_Table()
	 * @model required="true"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Lookup#getTable <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

	/**
	 * Returns the value of the '<em><b>Lookup Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lookup Table</em>' reference.
	 * @see #setLookupTable(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getLookup_LookupTable()
	 * @model required="true"
	 * @generated
	 */
	Table getLookupTable();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Lookup#getLookupTable <em>Lookup Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lookup Table</em>' reference.
	 * @see #getLookupTable()
	 * @generated
	 */
	void setLookupTable(Table value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' reference.
	 * @see #setColumn(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getLookup_Column()
	 * @model required="true"
	 * @generated
	 */
	Column getColumn();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Lookup#getColumn <em>Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' reference.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(Column value);

	/**
	 * Returns the value of the '<em><b>Operand Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand Column</em>' reference.
	 * @see #setOperandColumn(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getLookup_OperandColumn()
	 * @model required="true"
	 * @generated
	 */
	Column getOperandColumn();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Lookup#getOperandColumn <em>Operand Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand Column</em>' reference.
	 * @see #getOperandColumn()
	 * @generated
	 */
	void setOperandColumn(Column value);

	/**
	 * Returns the value of the '<em><b>Match Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match Column</em>' reference.
	 * @see #setMatchColumn(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getLookup_MatchColumn()
	 * @model required="true"
	 * @generated
	 */
	Column getMatchColumn();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Lookup#getMatchColumn <em>Match Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Match Column</em>' reference.
	 * @see #getMatchColumn()
	 * @generated
	 */
	void setMatchColumn(Column value);

	/**
	 * Returns the value of the '<em><b>Lookup Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lookup Column</em>' reference.
	 * @see #setLookupColumn(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getLookup_LookupColumn()
	 * @model required="true"
	 * @generated
	 */
	Column getLookupColumn();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Lookup#getLookupColumn <em>Lookup Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lookup Column</em>' reference.
	 * @see #getLookupColumn()
	 * @generated
	 */
	void setLookupColumn(Column value);

	/**
	 * Returns the value of the '<em><b>Result Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Column</em>' reference.
	 * @see #setResultColumn(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getLookup_ResultColumn()
	 * @model required="true"
	 * @generated
	 */
	Column getResultColumn();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Lookup#getResultColumn <em>Result Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Column</em>' reference.
	 * @see #getResultColumn()
	 * @generated
	 */
	void setResultColumn(Column value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * The literals are from the enumeration {@link excelltsmetamodel.LookupOperationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see excelltsmetamodel.LookupOperationType
	 * @see #setOperation(LookupOperationType)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getLookup_Operation()
	 * @model required="true"
	 * @generated
	 */
	LookupOperationType getOperation();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Lookup#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see excelltsmetamodel.LookupOperationType
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(LookupOperationType value);

	/**
	 * Returns the value of the '<em><b>Result Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Table</em>' reference.
	 * @see #setResultTable(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getLookup_ResultTable()
	 * @model required="true"
	 * @generated
	 */
	Table getResultTable();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Lookup#getResultTable <em>Result Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Table</em>' reference.
	 * @see #getResultTable()
	 * @generated
	 */
	void setResultTable(Table value);

} // Lookup
