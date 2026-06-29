/**
 */
package excelltsmetamodel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Split</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.Split#getSource <em>Source</em>}</li>
 *   <li>{@link excelltsmetamodel.Split#getResultColumnB <em>Result Column B</em>}</li>
 *   <li>{@link excelltsmetamodel.Split#getResultColumnA <em>Result Column A</em>}</li>
 *   <li>{@link excelltsmetamodel.Split#getDelimiter <em>Delimiter</em>}</li>
 *   <li>{@link excelltsmetamodel.Split#getNumOfChars <em>Num Of Chars</em>}</li>
 *   <li>{@link excelltsmetamodel.Split#getResultTable <em>Result Table</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getSplit()
 * @model
 * @generated
 */
public interface Split extends StringManipulation {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getSplit_Source()
	 * @model required="true"
	 * @generated
	 */
	Column getSource();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Split#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Column value);

	/**
	 * Returns the value of the '<em><b>Result Column B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Column B</em>' reference.
	 * @see #setResultColumnB(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getSplit_ResultColumnB()
	 * @model required="true"
	 * @generated
	 */
	Column getResultColumnB();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Split#getResultColumnB <em>Result Column B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Column B</em>' reference.
	 * @see #getResultColumnB()
	 * @generated
	 */
	void setResultColumnB(Column value);

	/**
	 * Returns the value of the '<em><b>Result Column A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Column A</em>' reference.
	 * @see #setResultColumnA(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getSplit_ResultColumnA()
	 * @model required="true"
	 * @generated
	 */
	Column getResultColumnA();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Split#getResultColumnA <em>Result Column A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Column A</em>' reference.
	 * @see #getResultColumnA()
	 * @generated
	 */
	void setResultColumnA(Column value);

	/**
	 * Returns the value of the '<em><b>Delimiter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delimiter</em>' attribute.
	 * @see #setDelimiter(char)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getSplit_Delimiter()
	 * @model required="true"
	 * @generated
	 */
	char getDelimiter();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Split#getDelimiter <em>Delimiter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delimiter</em>' attribute.
	 * @see #getDelimiter()
	 * @generated
	 */
	void setDelimiter(char value);

	/**
	 * Returns the value of the '<em><b>Num Of Chars</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Of Chars</em>' attribute.
	 * @see #setNumOfChars(Integer)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getSplit_NumOfChars()
	 * @model required="true"
	 * @generated
	 */
	Integer getNumOfChars();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Split#getNumOfChars <em>Num Of Chars</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Of Chars</em>' attribute.
	 * @see #getNumOfChars()
	 * @generated
	 */
	void setNumOfChars(Integer value);

	/**
	 * Returns the value of the '<em><b>Result Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Table</em>' reference.
	 * @see #setResultTable(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getSplit_ResultTable()
	 * @model required="true"
	 * @generated
	 */
	Table getResultTable();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Split#getResultTable <em>Result Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Table</em>' reference.
	 * @see #getResultTable()
	 * @generated
	 */
	void setResultTable(Table value);

} // Split
