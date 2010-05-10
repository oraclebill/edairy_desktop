/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statutory Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.StatutoryLocation#getLandReferenceNumber <em>Land Reference Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.ModelPackage#getStatutoryLocation()
 * @model
 * @generated
 */
public interface StatutoryLocation extends EObject {
	/**
         * Returns the value of the '<em><b>Land Reference Number</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Land Reference Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Land Reference Number</em>' attribute.
         * @see #setLandReferenceNumber(String)
         * @see com.agritrace.edairy.model.ModelPackage#getStatutoryLocation_LandReferenceNumber()
         * @model required="true"
         * @generated
         */
	String getLandReferenceNumber();

	/**
         * Sets the value of the '{@link com.agritrace.edairy.model.StatutoryLocation#getLandReferenceNumber <em>Land Reference Number</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>Land Reference Number</em>' attribute.
         * @see #getLandReferenceNumber()
         * @generated
         */
	void setLandReferenceNumber(String value);

} // StatutoryLocation
