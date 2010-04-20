/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edairy.model.Location#getPostalComponent <em>Postal Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see edairy.model.ModelPackage#getLocation()
 * @model abstract="true"
 * @generated
 */
public interface Location extends EObject {
	/**
	 * Returns the value of the '<em><b>Postal Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postal Component</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postal Component</em>' containment reference.
	 * @see #setPostalComponent(PostalLocation)
	 * @see edairy.model.ModelPackage#getLocation_PostalComponent()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PostalLocation getPostalComponent();

	/**
	 * Sets the value of the '{@link edairy.model.Location#getPostalComponent <em>Postal Component</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Component</em>' containment reference.
	 * @see #getPostalComponent()
	 * @generated
	 */
	void setPostalComponent(PostalLocation value);

} // Location
