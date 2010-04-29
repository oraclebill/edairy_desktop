/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.impl;

import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Driver;
import com.agritrace.edairy.model.dairy.Vehicle;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Driver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.DriverImpl#getVehicleAssignment <em>Vehicle Assignment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DriverImpl extends EmployeeImpl implements Driver {
	/**
	 * The cached value of the '{@link #getVehicleAssignment() <em>Vehicle Assignment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleAssignment()
	 * @generated
	 * @ordered
	 */
	protected Vehicle vehicleAssignment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DriverImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.DRIVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle getVehicleAssignment() {
		if (vehicleAssignment != null && vehicleAssignment.eIsProxy()) {
			InternalEObject oldVehicleAssignment = (InternalEObject)vehicleAssignment;
			vehicleAssignment = (Vehicle)eResolveProxy(oldVehicleAssignment);
			if (vehicleAssignment != oldVehicleAssignment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.DRIVER__VEHICLE_ASSIGNMENT, oldVehicleAssignment, vehicleAssignment));
			}
		}
		return vehicleAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle basicGetVehicleAssignment() {
		return vehicleAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicleAssignment(Vehicle newVehicleAssignment) {
		Vehicle oldVehicleAssignment = vehicleAssignment;
		vehicleAssignment = newVehicleAssignment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DRIVER__VEHICLE_ASSIGNMENT, oldVehicleAssignment, vehicleAssignment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.DRIVER__VEHICLE_ASSIGNMENT:
				if (resolve) return getVehicleAssignment();
				return basicGetVehicleAssignment();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DairyPackage.DRIVER__VEHICLE_ASSIGNMENT:
				setVehicleAssignment((Vehicle)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DairyPackage.DRIVER__VEHICLE_ASSIGNMENT:
				setVehicleAssignment((Vehicle)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DairyPackage.DRIVER__VEHICLE_ASSIGNMENT:
				return vehicleAssignment != null;
		}
		return super.eIsSet(featureID);
	}

} //DriverImpl
