/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Role;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getOperatorCode <em>Operator Code</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getJobFunction <em>Job Function</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getDepartment <em>Department</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#isLocalEnabled <em>Local Enabled</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getRole <em>Role</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#isPasswordHashed <em>Password Hashed</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl#getLicenseNo <em>License No</em>}</li>
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
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #isLocalEnabled() <em>Local Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocalEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOCAL_ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isLocalEnabled() <em>Local Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocalEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean localEnabled = LOCAL_ENABLED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected Role role;

	/**
	 * The default value of the '{@link #isPasswordHashed() <em>Password Hashed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPasswordHashed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PASSWORD_HASHED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPasswordHashed() <em>Password Hashed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPasswordHashed()
	 * @generated
	 * @ordered
	 */
	protected boolean passwordHashed = PASSWORD_HASHED_EDEFAULT;

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
	public String getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLocalEnabled() {
		return localEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalEnabled(boolean newLocalEnabled) {
		boolean oldLocalEnabled = localEnabled;
		localEnabled = newLocalEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__LOCAL_ENABLED, oldLocalEnabled, localEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role getRole() {
		if (role != null && role.eIsProxy()) {
			InternalEObject oldRole = (InternalEObject)role;
			role = (Role)eResolveProxy(oldRole);
			if (role != oldRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.EMPLOYEE__ROLE, oldRole, role));
			}
		}
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role basicGetRole() {
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(Role newRole) {
		Role oldRole = role;
		role = newRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__ROLE, oldRole, role));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPasswordHashed() {
		return passwordHashed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPasswordHashed(boolean newPasswordHashed) {
		boolean oldPasswordHashed = passwordHashed;
		passwordHashed = newPasswordHashed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.EMPLOYEE__PASSWORD_HASHED, oldPasswordHashed, passwordHashed));
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.EMPLOYEE__ID:
				return getId();
			case DairyPackage.EMPLOYEE__OPERATOR_CODE:
				return getOperatorCode();
			case DairyPackage.EMPLOYEE__START_DATE:
				return getStartDate();
			case DairyPackage.EMPLOYEE__JOB_FUNCTION:
				return getJobFunction();
			case DairyPackage.EMPLOYEE__DEPARTMENT:
				return getDepartment();
			case DairyPackage.EMPLOYEE__USERNAME:
				return getUsername();
			case DairyPackage.EMPLOYEE__PASSWORD:
				return getPassword();
			case DairyPackage.EMPLOYEE__LOCAL_ENABLED:
				return isLocalEnabled();
			case DairyPackage.EMPLOYEE__ROLE:
				if (resolve) return getRole();
				return basicGetRole();
			case DairyPackage.EMPLOYEE__PASSWORD_HASHED:
				return isPasswordHashed();
			case DairyPackage.EMPLOYEE__LICENSE_NO:
				return getLicenseNo();
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
			case DairyPackage.EMPLOYEE__USERNAME:
				setUsername((String)newValue);
				return;
			case DairyPackage.EMPLOYEE__PASSWORD:
				setPassword((String)newValue);
				return;
			case DairyPackage.EMPLOYEE__LOCAL_ENABLED:
				setLocalEnabled((Boolean)newValue);
				return;
			case DairyPackage.EMPLOYEE__ROLE:
				setRole((Role)newValue);
				return;
			case DairyPackage.EMPLOYEE__PASSWORD_HASHED:
				setPasswordHashed((Boolean)newValue);
				return;
			case DairyPackage.EMPLOYEE__LICENSE_NO:
				setLicenseNo((String)newValue);
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
			case DairyPackage.EMPLOYEE__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case DairyPackage.EMPLOYEE__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case DairyPackage.EMPLOYEE__LOCAL_ENABLED:
				setLocalEnabled(LOCAL_ENABLED_EDEFAULT);
				return;
			case DairyPackage.EMPLOYEE__ROLE:
				setRole((Role)null);
				return;
			case DairyPackage.EMPLOYEE__PASSWORD_HASHED:
				setPasswordHashed(PASSWORD_HASHED_EDEFAULT);
				return;
			case DairyPackage.EMPLOYEE__LICENSE_NO:
				setLicenseNo(LICENSE_NO_EDEFAULT);
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
			case DairyPackage.EMPLOYEE__OPERATOR_CODE:
				return OPERATOR_CODE_EDEFAULT == null ? operatorCode != null : !OPERATOR_CODE_EDEFAULT.equals(operatorCode);
			case DairyPackage.EMPLOYEE__START_DATE:
				return START_DATE_EDEFAULT == null ? startDate != null : !START_DATE_EDEFAULT.equals(startDate);
			case DairyPackage.EMPLOYEE__JOB_FUNCTION:
				return JOB_FUNCTION_EDEFAULT == null ? jobFunction != null : !JOB_FUNCTION_EDEFAULT.equals(jobFunction);
			case DairyPackage.EMPLOYEE__DEPARTMENT:
				return DEPARTMENT_EDEFAULT == null ? department != null : !DEPARTMENT_EDEFAULT.equals(department);
			case DairyPackage.EMPLOYEE__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case DairyPackage.EMPLOYEE__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case DairyPackage.EMPLOYEE__LOCAL_ENABLED:
				return localEnabled != LOCAL_ENABLED_EDEFAULT;
			case DairyPackage.EMPLOYEE__ROLE:
				return role != null;
			case DairyPackage.EMPLOYEE__PASSWORD_HASHED:
				return passwordHashed != PASSWORD_HASHED_EDEFAULT;
			case DairyPackage.EMPLOYEE__LICENSE_NO:
				return LICENSE_NO_EDEFAULT == null ? licenseNo != null : !LICENSE_NO_EDEFAULT.equals(licenseNo);
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
		result.append(", operatorCode: ");
		result.append(operatorCode);
		result.append(", startDate: ");
		result.append(startDate);
		result.append(", jobFunction: ");
		result.append(jobFunction);
		result.append(", department: ");
		result.append(department);
		result.append(", username: ");
		result.append(username);
		result.append(", password: ");
		result.append(password);
		result.append(", localEnabled: ");
		result.append(localEnabled);
		result.append(", passwordHashed: ");
		result.append(passwordHashed);
		result.append(", licenseNo: ");
		result.append(licenseNo);
		result.append(')');
		return result.toString();
	}

	/**
	 * NOT AUTOGENERATED - do not delete
	 */
	@Override
	public String getNameAndLicense() {
		if (licenseNo != null && !licenseNo.isEmpty()) {
			return String.format("%s (%s)", familyName, licenseNo);
		} else {
			return familyName;
		}
	}

} //EmployeeImpl
