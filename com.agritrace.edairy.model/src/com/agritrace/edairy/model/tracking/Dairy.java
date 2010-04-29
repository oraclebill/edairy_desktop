/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.tracking;

import com.agritrace.edairy.model.Company;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dairy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.tracking.Dairy#getRegistrationNumber <em>Registration Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.tracking.TrackingPackage#getDairy()
 * @model
 * @generated
 */
public interface Dairy extends Company {
	/**
	 * Returns the value of the '<em><b>Registration Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registration Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registration Number</em>' attribute.
	 * @see #setRegistrationNumber(String)
	 * @see com.agritrace.edairy.model.tracking.TrackingPackage#getDairy_RegistrationNumber()
	 * @model required="true"
	 * @generated
	 */
	String getRegistrationNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.tracking.Dairy#getRegistrationNumber <em>Registration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registration Number</em>' attribute.
	 * @see #getRegistrationNumber()
	 * @generated
	 */
	void setRegistrationNumber(String value);

} // Dairy
