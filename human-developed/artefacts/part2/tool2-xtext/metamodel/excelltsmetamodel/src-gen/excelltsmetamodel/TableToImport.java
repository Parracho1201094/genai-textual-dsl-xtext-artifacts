/**
 */
package excelltsmetamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table To Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.TableToImport#getTable <em>Table</em>}</li>
 *   <li>{@link excelltsmetamodel.TableToImport#getPath <em>Path</em>}</li>
 *   <li>{@link excelltsmetamodel.TableToImport#getDelimiter <em>Delimiter</em>}</li>
 *   <li>{@link excelltsmetamodel.TableToImport#isDeleteMismatchedTypes <em>Delete Mismatched Types</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getTableToImport()
 * @model
 * @generated
 */
public interface TableToImport extends EObject {
	/**
	 * Returns the value of the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' reference.
	 * @see #setTable(Table)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getTableToImport_Table()
	 * @model required="true"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.TableToImport#getTable <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getTableToImport_Path()
	 * @model required="true"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.TableToImport#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Delimiter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delimiter</em>' attribute.
	 * @see #setDelimiter(String)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getTableToImport_Delimiter()
	 * @model required="true"
	 * @generated
	 */
	String getDelimiter();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.TableToImport#getDelimiter <em>Delimiter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delimiter</em>' attribute.
	 * @see #getDelimiter()
	 * @generated
	 */
	void setDelimiter(String value);

	/**
	 * Returns the value of the '<em><b>Delete Mismatched Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delete Mismatched Types</em>' attribute.
	 * @see #setDeleteMismatchedTypes(boolean)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getTableToImport_DeleteMismatchedTypes()
	 * @model required="true"
	 * @generated
	 */
	boolean isDeleteMismatchedTypes();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.TableToImport#isDeleteMismatchedTypes <em>Delete Mismatched Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delete Mismatched Types</em>' attribute.
	 * @see #isDeleteMismatchedTypes()
	 * @generated
	 */
	void setDeleteMismatchedTypes(boolean value);

} // TableToImport
