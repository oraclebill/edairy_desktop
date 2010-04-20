/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model.tracking;

import edairy.model.Company;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edairy.model.tracking.Processor#getRegistrationNumber <em>Registration Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see edairy.model.tracking.TrackingPackage#getProcessor()
 * @model
 * @generated
 */
public interface Processor extends Company {
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
	 * @see edairy.model.tracking.TrackingPackage#getProcessor_RegistrationNumber()
	 * @model
	 * @generated
	 */
	String getRegistrationNumber();

	/**
	 * Sets the value of the '{@link edairy.model.tracking.Processor#getRegistrationNumber <em>Registration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registration Number</em>' attribute.
	 * @see #getRegistrationNumber()
	 * @generated
	 */
	void setRegistrationNumber(String value);

} // Processor
