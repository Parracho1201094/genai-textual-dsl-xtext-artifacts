/**
 */
package excelltsmetamodel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.Extract#getColumn <em>Column</em>}</li>
 *   <li>{@link excelltsmetamodel.Extract#getLbChar <em>Lb Char</em>}</li>
 *   <li>{@link excelltsmetamodel.Extract#getUbChar <em>Ub Char</em>}</li>
 *   <li>{@link excelltsmetamodel.Extract#getPattern <em>Pattern</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getExtract()
 * @model
 * @generated
 */
public interface Extract extends StringManipulation {
	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' reference.
	 * @see #setColumn(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getExtract_Column()
	 * @model required="true"
	 * @generated
	 */
	Column getColumn();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Extract#getColumn <em>Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' reference.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(Column value);

	/**
	 * Returns the value of the '<em><b>Lb Char</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lb Char</em>' attribute.
	 * @see #setLbChar(Integer)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getExtract_LbChar()
	 * @model required="true"
	 * @generated
	 */
	Integer getLbChar();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Extract#getLbChar <em>Lb Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lb Char</em>' attribute.
	 * @see #getLbChar()
	 * @generated
	 */
	void setLbChar(Integer value);

	/**
	 * Returns the value of the '<em><b>Ub Char</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ub Char</em>' attribute.
	 * @see #setUbChar(Integer)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getExtract_UbChar()
	 * @model required="true"
	 * @generated
	 */
	Integer getUbChar();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Extract#getUbChar <em>Ub Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ub Char</em>' attribute.
	 * @see #getUbChar()
	 * @generated
	 */
	void setUbChar(Integer value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(String)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getExtract_Pattern()
	 * @model required="true"
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Extract#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

} // Extract
