/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CustomerImpl#getCustomerNumber <em>Customer Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CustomerImpl#getCustomerType <em>Customer Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CustomerImpl#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomerImpl extends CompanyImpl implements Customer {
	/**
	 * The default value of the '{@link #getCustomerNumber() <em>Customer Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOMER_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCustomerNumber() <em>Customer Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerNumber()
	 * @generated
	 * @ordered
	 */
	protected String customerNumber = CUSTOMER_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getCustomerType() <em>Customer Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerType()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOMER_TYPE_EDEFAULT = "Milk Processor";

	/**
	 * The cached value of the '{@link #getCustomerType() <em>Customer Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerType()
	 * @generated
	 * @ordered
	 */
	protected String customerType = CUSTOMER_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_EDEFAULT = "Active";

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected String status = STATUS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.CUSTOMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomerNumber(String newCustomerNumber) {
		String oldCustomerNumber = customerNumber;
		customerNumber = newCustomerNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.CUSTOMER__CUSTOMER_NUMBER, oldCustomerNumber, customerNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomerType() {
		return customerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomerType(String newCustomerType) {
		String oldCustomerType = customerType;
		customerType = newCustomerType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.CUSTOMER__CUSTOMER_TYPE, oldCustomerType, customerType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(String newStatus) {
		String oldStatus = status;
		status = newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.CUSTOMER__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.CUSTOMER__CUSTOMER_NUMBER:
				return getCustomerNumber();
			case DairyPackage.CUSTOMER__CUSTOMER_TYPE:
				return getCustomerType();
			case DairyPackage.CUSTOMER__STATUS:
				return getStatus();
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
			case DairyPackage.CUSTOMER__CUSTOMER_NUMBER:
				setCustomerNumber((String)newValue);
				return;
			case DairyPackage.CUSTOMER__CUSTOMER_TYPE:
				setCustomerType((String)newValue);
				return;
			case DairyPackage.CUSTOMER__STATUS:
				setStatus((String)newValue);
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
			case DairyPackage.CUSTOMER__CUSTOMER_NUMBER:
				setCustomerNumber(CUSTOMER_NUMBER_EDEFAULT);
				return;
			case DairyPackage.CUSTOMER__CUSTOMER_TYPE:
				setCustomerType(CUSTOMER_TYPE_EDEFAULT);
				return;
			case DairyPackage.CUSTOMER__STATUS:
				setStatus(STATUS_EDEFAULT);
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
			case DairyPackage.CUSTOMER__CUSTOMER_NUMBER:
				return CUSTOMER_NUMBER_EDEFAULT == null ? customerNumber != null : !CUSTOMER_NUMBER_EDEFAULT.equals(customerNumber);
			case DairyPackage.CUSTOMER__CUSTOMER_TYPE:
				return CUSTOMER_TYPE_EDEFAULT == null ? customerType != null : !CUSTOMER_TYPE_EDEFAULT.equals(customerType);
			case DairyPackage.CUSTOMER__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
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
		result.append(" (customerNumber: ");
		result.append(customerNumber);
		result.append(", customerType: ");
		result.append(customerType);
		result.append(", status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //CustomerImpl
