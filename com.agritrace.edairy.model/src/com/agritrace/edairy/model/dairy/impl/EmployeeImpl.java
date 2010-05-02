/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.impl;

import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Employee;

import com.agritrace.edairy.model.impl.PersonImpl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.EmployeeImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.EmployeeImpl#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.EmployeeImpl#getJobFunction <em>Job Function</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.EmployeeImpl#getNationalId <em>National Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.EmployeeImpl#getNhifNumber <em>Nhif Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.EmployeeImpl#getNssfNumber <em>Nssf Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmployeeImpl extends PersonImpl implements Employee {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date START_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected Date startDate = START_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getJobFunction() <em>Job Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobFunction()
	 * @generated
	 * @ordered
	 */
	protected static final String JOB_FUNCTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJobFunction() <em>Job Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobFunction()
	 * @generated
	 * @ordered
	 */
	protected String jobFunction = JOB_FUNCTION_EDEFAULT;

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
	protected EmployeeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.EMPLOYEE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartDate(Date newStartDate) {
		Date oldStartDate = startDate;
		startDate = newStartDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__START_DATE, oldStartDate, startDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJobFunction() {
		return jobFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJobFunction(String newJobFunction) {
		String oldJobFunction = jobFunction;
		jobFunction = newJobFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__JOB_FUNCTION, oldJobFunction, jobFunction));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__NATIONAL_ID, oldNationalId, nationalId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__NHIF_NUMBER, oldNhifNumber, nhifNumber));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__NSSF_NUMBER, oldNssfNumber, nssfNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.EMPLOYEE__ID:
				return getId();
			case DairyPackage.EMPLOYEE__START_DATE:
				return getStartDate();
			case DairyPackage.EMPLOYEE__JOB_FUNCTION:
				return getJobFunction();
			case DairyPackage.EMPLOYEE__NATIONAL_ID:
				return getNationalId();
			case DairyPackage.EMPLOYEE__NHIF_NUMBER:
				return getNhifNumber();
			case DairyPackage.EMPLOYEE__NSSF_NUMBER:
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
			case DairyPackage.EMPLOYEE__ID:
				setId((String)newValue);
				return;
			case DairyPackage.EMPLOYEE__START_DATE:
				setStartDate((Date)newValue);
				return;
			case DairyPackage.EMPLOYEE__JOB_FUNCTION:
				setJobFunction((String)newValue);
				return;
			case DairyPackage.EMPLOYEE__NATIONAL_ID:
				setNationalId((String)newValue);
				return;
			case DairyPackage.EMPLOYEE__NHIF_NUMBER:
				setNhifNumber((String)newValue);
				return;
			case DairyPackage.EMPLOYEE__NSSF_NUMBER:
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
			case DairyPackage.EMPLOYEE__ID:
				setId(ID_EDEFAULT);
				return;
			case DairyPackage.EMPLOYEE__START_DATE:
				setStartDate(START_DATE_EDEFAULT);
				return;
			case DairyPackage.EMPLOYEE__JOB_FUNCTION:
				setJobFunction(JOB_FUNCTION_EDEFAULT);
				return;
			case DairyPackage.EMPLOYEE__NATIONAL_ID:
				setNationalId(NATIONAL_ID_EDEFAULT);
				return;
			case DairyPackage.EMPLOYEE__NHIF_NUMBER:
				setNhifNumber(NHIF_NUMBER_EDEFAULT);
				return;
			case DairyPackage.EMPLOYEE__NSSF_NUMBER:
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
			case DairyPackage.EMPLOYEE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case DairyPackage.EMPLOYEE__START_DATE:
				return START_DATE_EDEFAULT == null ? startDate != null : !START_DATE_EDEFAULT.equals(startDate);
			case DairyPackage.EMPLOYEE__JOB_FUNCTION:
				return JOB_FUNCTION_EDEFAULT == null ? jobFunction != null : !JOB_FUNCTION_EDEFAULT.equals(jobFunction);
			case DairyPackage.EMPLOYEE__NATIONAL_ID:
				return NATIONAL_ID_EDEFAULT == null ? nationalId != null : !NATIONAL_ID_EDEFAULT.equals(nationalId);
			case DairyPackage.EMPLOYEE__NHIF_NUMBER:
				return NHIF_NUMBER_EDEFAULT == null ? nhifNumber != null : !NHIF_NUMBER_EDEFAULT.equals(nhifNumber);
			case DairyPackage.EMPLOYEE__NSSF_NUMBER:
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
		result.append(" (id: ");
		result.append(id);
		result.append(", startDate: ");
		result.append(startDate);
		result.append(", jobFunction: ");
		result.append(jobFunction);
		result.append(", nationalId: ");
		result.append(nationalId);
		result.append(", nhifNumber: ");
		result.append(nhifNumber);
		result.append(", nssfNumber: ");
		result.append(nssfNumber);
		result.append(')');
		return result.toString();
	}

} //EmployeeImpl