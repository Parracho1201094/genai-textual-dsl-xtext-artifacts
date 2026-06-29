/**
 */
package excelltsmetamodel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.FlowStep#getNext <em>Next</em>}</li>
 * </ul>
 *
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getFlowStep()
 * @model abstract="true"
 * @generated
 */
public interface FlowStep extends Step {
	/**
	 * Returns the value of the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next</em>' reference.
	 * @see #setNext(Step)
	 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getFlowStep_Next()
	 * @model required="true"
	 * @generated
	 */
	Step getNext();

	/**
	 * Sets the value of the '{@link excelltsmetamodel.FlowStep#getNext <em>Next</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next</em>' reference.
	 * @see #getNext()
	 * @generated
	 */
	void setNext(Step value);

} // FlowStep
