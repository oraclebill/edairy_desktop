/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.impl;

import com.agritrace.edairy.model.ModelPackage;
import com.agritrace.edairy.model.Person;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.impl.PersonImpl#getNationalId <em>National Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.impl.PersonImpl#getNhifNumber <em>Nhif Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.impl.PersonImpl#getNssfNumber <em>Nssf Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PersonImpl extends PartyImpl implements Person {
	/**
	 * The default value of the '{@link #getNationalId() <em>National Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNationalId()
	 * @generated
	 * @ordered
	 */
	protected static final String NATIONAL_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNationalId() <em>National Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNationalId()
	 * @generated
	 * @ordered
	 */
	protected String nationalId = NATIONAL_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getNhifNumber() <em>Nhif Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNhifNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String NHIF_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNhifNumber() <em>Nhif Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNhifNumber()
	 * @generated
	 * @ordered
	 */
	protected String nhifNumber = NHIF_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getNssfNumber() <em>Nssf Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNssfNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String NSSF_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNssfNumber() <em>Nssf Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNssfNumber()
	 * @generated
	 * @ordered
	 */
	protected String nssfNumber = NSSF_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PERSON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNationalId() {
		return nationalId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNationalId(String newNationalId) {
		String oldNationalId = nationalId;
		nationalId = newNationalId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__NATIONAL_ID, oldNationalId, nationalId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNhifNumber() {
		return nhifNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNhifNumber(String newNhifNumber) {
		String oldNhifNumber = nhifNumber;
		nhifNumber = newNhifNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__NHIF_NUMBER, oldNhifNumber, nhifNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNssfNumber() {
		return nssfNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNssfNumber(String newNssfNumber) {
		String oldNssfNumber = nssfNumber;
		nssfNumber = newNssfNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__NSSF_NUMBER, oldNssfNumber, nssfNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.PERSON__NATIONAL_ID:
				return getNationalId();
			case ModelPackage.PERSON__NHIF_NUMBER:
				return getNhifNumber();
			case ModelPackage.PERSON__NSSF_NUMBER:
				return getNssfNumber();
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
			case ModelPackage.PERSON__NATIONAL_ID:
				setNationalId((String)newValue);
				return;
			case ModelPackage.PERSON__NHIF_NUMBER:
				setNhifNumber((String)newValue);
				return;
			case ModelPackage.PERSON__NSSF_NUMBER:
				setNssfNumber((String)newValue);
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
			case ModelPackage.PERSON__NATIONAL_ID:
				setNationalId(NATIONAL_ID_EDEFAULT);
				return;
			case ModelPackage.PERSON__NHIF_NUMBER:
				setNhifNumber(NHIF_NUMBER_EDEFAULT);
				return;
			case ModelPackage.PERSON__NSSF_NUMBER:
				setNssfNumber(NSSF_NUMBER_EDEFAULT);
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
			case ModelPackage.PERSON__NATIONAL_ID:
				return NATIONAL_ID_EDEFAULT == null ? nationalId != null : !NATIONAL_ID_EDEFAULT.equals(nationalId);
			case ModelPackage.PERSON__NHIF_NUMBER:
				return NHIF_NUMBER_EDEFAULT == null ? nhifNumber != null : !NHIF_NUMBER_EDEFAULT.equals(nhifNumber);
			case ModelPackage.PERSON__NSSF_NUMBER:
				return NSSF_NUMBER_EDEFAULT == null ? nssfNumber != null : !NSSF_NUMBER_EDEFAULT.equals(nssfNumber);
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
		result.append(" (nationalId: ");
		result.append(nationalId);
		result.append(", nhifNumber: ");
		result.append(nhifNumber);
		result.append(", nssfNumber: ");
		result.append(nssfNumber);
		result.append(')');
		return result.toString();
	}

} //PersonImpl
