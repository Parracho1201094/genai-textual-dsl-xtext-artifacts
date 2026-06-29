/**
 */
package excelltsmetamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.Association#getOriginCol <em>Origin Col</em>}</li>
 *   <li>{@link excelltsmetamodel.Association#getDestinCol <em>Destin Col</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends EObject {
	/**
	 * Returns the value of the '<em><b>Origin Col</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin Col</em>' reference.
	 * @see #setOriginCol(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getAssociation_OriginCol()
	 * @model required="true"
	 * @generated
	 */
	Column getOriginCol();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Association#getOriginCol <em>Origin Col</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin Col</em>' reference.
	 * @see #getOriginCol()
	 * @generated
	 */
	void setOriginCol(Column value);

	/**
	 * Returns the value of the '<em><b>Destin Col</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destin Col</em>' reference.
	 * @see #setDestinCol(Column)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getAssociation_DestinCol()
	 * @model required="true"
	 * @generated
	 */
	Column getDestinCol();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.Association#getDestinCol <em>Destin Col</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destin Col</em>' reference.
	 * @see #getDestinCol()
	 * @generated
	 */
	void setDestinCol(Column value);

} // Association
