/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model.tracking;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edairy.model.tracking.Lot#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see edairy.model.tracking.TrackingPackage#getLot()
 * @model
 * @generated
 */
public interface Lot extends EObject {
	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(Container)
	 * @see edairy.model.tracking.TrackingPackage#getLot_Container()
	 * @model required="true"
	 * @generated
	 */
	Container getContainer();

	/**
	 * Sets the value of the '{@link edairy.model.tracking.Lot#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Container value);

} // Lot
