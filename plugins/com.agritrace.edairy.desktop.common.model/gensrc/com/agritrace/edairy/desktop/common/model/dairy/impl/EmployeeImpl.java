/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.SystemUser;
import com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getEmployeeNumber <em>Employee Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getOperatorCode <em>Operator Code</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getJobFunction <em>Job Function</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getDepartment <em>Department</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getLicenseNo <em>License No</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getEmployer <em>Employer</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getSystemIdentity <em>System Identity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmployeeImpl extends PersonImpl implements Employee {
	/**
	 * The default value of the '{@link #getEmployeeNumber() <em>Employee Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployeeNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String EMPLOYEE_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEmployeeNumber() <em>Employee Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployeeNumber()
	 * @generated
	 * @ordered
	 */
	protected String employeeNumber = EMPLOYEE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getOperatorCode() <em>Operator Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorCode()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATOR_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperatorCode() <em>Operator Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorCode()
	 * @generated
	 * @ordered
	 */
	protected String operatorCode = OPERATOR_CODE_EDEFAULT;

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
	 * The default value of the '{@link #getDepartment() <em>Department</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartment()
	 * @generated
	 * @ordered
	 */
	protected static final String DEPARTMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDepartment() <em>Department</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartment()
	 * @generated
	 * @ordered
	 */
	protected String department = DEPARTMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLicenseNo() <em>License No</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicenseNo()
	 * @generated
	 * @ordered
	 */
	protected static final String LICENSE_NO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLicenseNo() <em>License No</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicenseNo()
	 * @generated
	 * @ordered
	 */
	protected String licenseNo = LICENSE_NO_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSystemIdentity() <em>System Identity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemIdentity()
	 * @generated
	 * @ordered
	 */
	protected SystemUser systemIdentity;

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
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmployeeNumber(String newEmployeeNumber) {
		String oldEmployeeNumber = employeeNumber;
		employeeNumber = newEmployeeNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__EMPLOYEE_NUMBER, oldEmployeeNumber, employeeNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperatorCode() {
		return operatorCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperatorCode(String newOperatorCode) {
		String oldOperatorCode = operatorCode;
		operatorCode = newOperatorCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__OPERATOR_CODE, oldOperatorCode, operatorCode));
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
	public String getDepartment() {
		return department;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepartment(String newDepartment) {
		String oldDepartment = department;
		department = newDepartment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__DEPARTMENT, oldDepartment, department));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLicenseNo() {
		return licenseNo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLicenseNo(String newLicenseNo) {
		String oldLicenseNo = licenseNo;
		licenseNo = newLicenseNo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__LICENSE_NO, oldLicenseNo, licenseNo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dairy getEmployer() {
		if (eContainerFeatureID() != DairyPackage.EMPLOYEE__EMPLOYER) return null;
		return (Dairy)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEmployer(Dairy newEmployer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEmployer, DairyPackage.EMPLOYEE__EMPLOYER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmployer(Dairy newEmployer) {
		if (newEmployer != eInternalContainer() || (eContainerFeatureID() != DairyPackage.EMPLOYEE__EMPLOYER && newEmployer != null))
		{
			if (EcoreUtil.isAncestor(this, newEmployer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEmployer != null)
				msgs = ((InternalEObject)newEmployer).eInverseAdd(this, DairyPackage.DAIRY__EMPLOYEES, Dairy.class, msgs);
			msgs = basicSetEmployer(newEmployer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__EMPLOYER, newEmployer, newEmployer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemUser getSystemIdentity() {
		if (systemIdentity != null && systemIdentity.eIsProxy())
		{
			InternalEObject oldSystemIdentity = (InternalEObject)systemIdentity;
			systemIdentity = (SystemUser)eResolveProxy(oldSystemIdentity);
			if (systemIdentity != oldSystemIdentity)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.EMPLOYEE__SYSTEM_IDENTITY, oldSystemIdentity, systemIdentity));
			}
		}
		return systemIdentity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemUser basicGetSystemIdentity() {
		return systemIdentity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystemIdentity(SystemUser newSystemIdentity, NotificationChain msgs) {
		SystemUser oldSystemIdentity = systemIdentity;
		systemIdentity = newSystemIdentity;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__SYSTEM_IDENTITY, oldSystemIdentity, newSystemIdentity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemIdentity(SystemUser newSystemIdentity) {
		if (newSystemIdentity != systemIdentity)
		{
			NotificationChain msgs = null;
			if (systemIdentity != null)
				msgs = ((InternalEObject)systemIdentity).eInverseRemove(this, ModelPackage.SYSTEM_USER__RELATED_EMPLOYEE, SystemUser.class, msgs);
			if (newSystemIdentity != null)
				msgs = ((InternalEObject)newSystemIdentity).eInverseAdd(this, ModelPackage.SYSTEM_USER__RELATED_EMPLOYEE, SystemUser.class, msgs);
			msgs = basicSetSystemIdentity(newSystemIdentity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__SYSTEM_IDENTITY, newSystemIdentity, newSystemIdentity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNameAndLicense() {
		if (licenseNo != null && !licenseNo.isEmpty()) {
					return String.format("%s (%s)", familyName, licenseNo);
				} else {
					return familyName;
				}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case DairyPackage.EMPLOYEE__EMPLOYER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEmployer((Dairy)otherEnd, msgs);
			case DairyPackage.EMPLOYEE__SYSTEM_IDENTITY:
				if (systemIdentity != null)
					msgs = ((InternalEObject)systemIdentity).eInverseRemove(this, ModelPackage.SYSTEM_USER__RELATED_EMPLOYEE, SystemUser.class, msgs);
				return basicSetSystemIdentity((SystemUser)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case DairyPackage.EMPLOYEE__EMPLOYER:
				return basicSetEmployer(null, msgs);
			case DairyPackage.EMPLOYEE__SYSTEM_IDENTITY:
				return basicSetSystemIdentity(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID())
		{
			case DairyPackage.EMPLOYEE__EMPLOYER:
				return eInternalContainer().eInverseRemove(this, DairyPackage.DAIRY__EMPLOYEES, Dairy.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case DairyPackage.EMPLOYEE__EMPLOYEE_NUMBER:
				return getEmployeeNumber();
			case DairyPackage.EMPLOYEE__OPERATOR_CODE:
				return getOperatorCode();
			case DairyPackage.EMPLOYEE__START_DATE:
				return getStartDate();
			case DairyPackage.EMPLOYEE__JOB_FUNCTION:
				return getJobFunction();
			case DairyPackage.EMPLOYEE__DEPARTMENT:
				return getDepartment();
			case DairyPackage.EMPLOYEE__LICENSE_NO:
				return getLicenseNo();
			case DairyPackage.EMPLOYEE__EMPLOYER:
				return getEmployer();
			case DairyPackage.EMPLOYEE__SYSTEM_IDENTITY:
				if (resolve) return getSystemIdentity();
				return basicGetSystemIdentity();
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
		switch (featureID)
		{
			case DairyPackage.EMPLOYEE__EMPLOYEE_NUMBER:
				setEmployeeNumber((String)newValue);
				return;
			case DairyPackage.EMPLOYEE__OPERATOR_CODE:
				setOperatorCode((String)newValue);
				return;
			case DairyPackage.EMPLOYEE__START_DATE:
				setStartDate((Date)newValue);
				return;
			case DairyPackage.EMPLOYEE__JOB_FUNCTION:
				setJobFunction((String)newValue);
				return;
			case DairyPackage.EMPLOYEE__DEPARTMENT:
				setDepartment((String)newValue);
				return;
			case DairyPackage.EMPLOYEE__LICENSE_NO:
				setLicenseNo((String)newValue);
				return;
			case DairyPackage.EMPLOYEE__EMPLOYER:
				setEmployer((Dairy)newValue);
				return;
			case DairyPackage.EMPLOYEE__SYSTEM_IDENTITY:
				setSystemIdentity((SystemUser)newValue);
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
		switch (featureID)
		{
			case DairyPackage.EMPLOYEE__EMPLOYEE_NUMBER:
				setEmployeeNumber(EMPLOYEE_NUMBER_EDEFAULT);
				return;
			case DairyPackage.EMPLOYEE__OPERATOR_CODE:
				setOperatorCode(OPERATOR_CODE_EDEFAULT);
				return;
			case DairyPackage.EMPLOYEE__START_DATE:
				setStartDate(START_DATE_EDEFAULT);
				return;
			case DairyPackage.EMPLOYEE__JOB_FUNCTION:
				setJobFunction(JOB_FUNCTION_EDEFAULT);
				return;
			case DairyPackage.EMPLOYEE__DEPARTMENT:
				setDepartment(DEPARTMENT_EDEFAULT);
				return;
			case DairyPackage.EMPLOYEE__LICENSE_NO:
				setLicenseNo(LICENSE_NO_EDEFAULT);
				return;
			case DairyPackage.EMPLOYEE__EMPLOYER:
				setEmployer((Dairy)null);
				return;
			case DairyPackage.EMPLOYEE__SYSTEM_IDENTITY:
				setSystemIdentity((SystemUser)null);
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
		switch (featureID)
		{
			case DairyPackage.EMPLOYEE__EMPLOYEE_NUMBER:
				return EMPLOYEE_NUMBER_EDEFAULT == null ? employeeNumber != null : !EMPLOYEE_NUMBER_EDEFAULT.equals(employeeNumber);
			case DairyPackage.EMPLOYEE__OPERATOR_CODE:
				return OPERATOR_CODE_EDEFAULT == null ? operatorCode != null : !OPERATOR_CODE_EDEFAULT.equals(operatorCode);
			case DairyPackage.EMPLOYEE__START_DATE:
				return START_DATE_EDEFAULT == null ? startDate != null : !START_DATE_EDEFAULT.equals(startDate);
			case DairyPackage.EMPLOYEE__JOB_FUNCTION:
				return JOB_FUNCTION_EDEFAULT == null ? jobFunction != null : !JOB_FUNCTION_EDEFAULT.equals(jobFunction);
			case DairyPackage.EMPLOYEE__DEPARTMENT:
				return DEPARTMENT_EDEFAULT == null ? department != null : !DEPARTMENT_EDEFAULT.equals(department);
			case DairyPackage.EMPLOYEE__LICENSE_NO:
				return LICENSE_NO_EDEFAULT == null ? licenseNo != null : !LICENSE_NO_EDEFAULT.equals(licenseNo);
			case DairyPackage.EMPLOYEE__EMPLOYER:
				return getEmployer() != null;
			case DairyPackage.EMPLOYEE__SYSTEM_IDENTITY:
				return systemIdentity != null;
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
		result.append(" (employeeNumber: ");
		result.append(employeeNumber);
		result.append(", operatorCode: ");
		result.append(operatorCode);
		result.append(", startDate: ");
		result.append(startDate);
		result.append(", jobFunction: ");
		result.append(jobFunction);
		result.append(", department: ");
		result.append(department);
		result.append(", licenseNo: ");
		result.append(licenseNo);
		result.append(')');
		return result.toString();
	}

} //EmployeeImpl
