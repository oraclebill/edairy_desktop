/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.tracking.impl;

import com.agritrace.edairy.model.impl.CompanyImpl;

import com.agritrace.edairy.model.tracking.Dairy;
import com.agritrace.edairy.model.tracking.TrackingPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dairy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.tracking.impl.DairyImpl#getRegistrationNumber <em>Registration Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DairyImpl extends CompanyImpl implements Dairy {
	/**
	 * The default value of the '{@link #getRegistrationNumber() <em>Registration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistrationNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String REGISTRATION_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRegistrationNumber() <em>Registration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistrationNumber()
	 * @generated
	 * @ordered
	 */
	protected String registrationNumber = REGISTRATION_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DairyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackingPackage.Literals.DAIRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistrationNumber(String newRegistrationNumber) {
		String oldRegistrationNumber = registrationNumber;
		registrationNumber = newRegistrationNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.DAIRY__REGISTRATION_NUMBER, oldRegistrationNumber, registrationNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackingPackage.DAIRY__REGISTRATION_NUMBER:
				return getRegistrationNumber();
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
			case TrackingPackage.DAIRY__REGISTRATION_NUMBER:
				setRegistrationNumber((String)newValue);
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
			case TrackingPackage.DAIRY__REGISTRATION_NUMBER:
				setRegistrationNumber(REGISTRATION_NUMBER_EDEFAULT);
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
			case TrackingPackage.DAIRY__REGISTRATION_NUMBER:
				return REGISTRATION_NUMBER_EDEFAULT == null ? registrationNumber != null : !REGISTRATION_NUMBER_EDEFAULT.equals(registrationNumber);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (registrationNumber: ");
		result.append(registrationNumber);
		result.append(')');
		return result.toString();
	}

} //DairyImpl
