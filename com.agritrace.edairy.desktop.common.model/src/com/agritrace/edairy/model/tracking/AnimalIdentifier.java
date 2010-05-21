/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.tracking;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Animal Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.tracking.AnimalIdentifier#getIssuer <em>Issuer</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.tracking.AnimalIdentifier#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.tracking.TrackingPackage#getAnimalIdentifier()
 * @model
 * @generated
 */
public interface AnimalIdentifier extends EObject {
	/**
	 * Returns the value of the '<em><b>Issuer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issuer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Issuer</em>' attribute.
	 * @see #setIssuer(String)
	 * @see com.agritrace.edairy.model.tracking.TrackingPackage#getAnimalIdentifier_Issuer()
	 * @model
	 * @generated
	 */
	String getIssuer();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.tracking.AnimalIdentifier#getIssuer <em>Issuer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Issuer</em>' attribute.
	 * @see #getIssuer()
	 * @generated
	 */
	void setIssuer(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see com.agritrace.edairy.model.tracking.TrackingPackage#getAnimalIdentifier_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.tracking.AnimalIdentifier#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // AnimalIdentifier
