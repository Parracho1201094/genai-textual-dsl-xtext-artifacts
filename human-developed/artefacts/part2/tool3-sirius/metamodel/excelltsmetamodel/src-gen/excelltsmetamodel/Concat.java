/**
 */
package excelltsmetamodel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concat</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.Concat#getSourceA <em>Source A</em>}</li>
 *   <li>{@link excelltsmetamodel.Concat#getSourceB <em>Source B</em>}</li>
 *   <li>{@link excelltsmetamodel.Concat#getResultColumn <em>Result Column</em>}</li>
 *   <li>{@link excelltsmetamodel.Concat#getResultTable <em>Result Table</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getConcat()
 * @model
 * @generated
 */
public interface Concat extends StringManipulation {
	/**
	 * Returns the value of the '<em><b>Source A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source A</em>' reference.
	 * @see #setSourceA(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getConcat_SourceA()
	 * @model required="true"
	 * @generated
	 */
	Column getSourceA();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Concat#getSourceA <em>Source A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source A</em>' reference.
	 * @see #getSourceA()
	 * @generated
	 */
	void setSourceA(Column value);

	/**
	 * Returns the value of the '<em><b>Source B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source B</em>' reference.
	 * @see #setSourceB(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getConcat_SourceB()
	 * @model required="true"
	 * @generated
	 */
	Column getSourceB();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Concat#getSourceB <em>Source B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source B</em>' reference.
	 * @see #getSourceB()
	 * @generated
	 */
	void setSourceB(Column value);

	/**
	 * Returns the value of the '<em><b>Result Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Column</em>' reference.
	 * @see #setResultColumn(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getConcat_ResultColumn()
	 * @model required="true"
	 * @generated
	 */
	Column getResultColumn();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Concat#getResultColumn <em>Result Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Column</em>' reference.
	 * @see #getResultColumn()
	 * @generated
	 */
	void setResultColumn(Column value);

	/**
	 * Returns the value of the '<em><b>Result Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Table</em>' reference.
	 * @see #setResultTable(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getConcat_ResultTable()
	 * @model required="true"
	 * @generated
	 */
	Table getResultTable();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Concat#getResultTable <em>Result Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Table</em>' reference.
	 * @see #getResultTable()
	 * @generated
	 */
	void setResultTable(Table value);

} // Concat
