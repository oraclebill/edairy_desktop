/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Driver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.Driver#getVehicleAssignment <em>Vehicle Assignment</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDriver()
 * @model
 * @generated
 */
public interface Driver extends Employee {
	/**
	 * Returns the value of the '<em><b>Vehicle Assignment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vehicle Assignment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Assignment</em>' reference.
	 * @see #setVehicleAssignment(Vehicle)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDriver_VehicleAssignment()
	 * @model
	 * @generated
	 */
	Vehicle getVehicleAssignment();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Driver#getVehicleAssignment <em>Vehicle Assignment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Assignment</em>' reference.
	 * @see #getVehicleAssignment()
	 * @generated
	 */
	void setVehicleAssignment(Vehicle value);

} // Driver
