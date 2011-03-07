/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base.impl;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Role;
import com.agritrace.edairy.desktop.common.model.base.SystemUser;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.SystemUserImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.SystemUserImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.SystemUserImpl#getRelatedEmployee <em>Related Employee</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.SystemUserImpl#isLocalEnabled <em>Local Enabled</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.SystemUserImpl#getRole <em>Role</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.SystemUserImpl#isPasswordHashed <em>Password Hashed</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.SystemUserImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemUserImpl extends EObjectImpl implements SystemUser {
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
	 * The cached value of the '{@link #getRelatedEmployee() <em>Related Employee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedEmployee()
	 * @generated
	 * @ordered
	 */
	protected Employee relatedEmployee;

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
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final Long ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Long id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemUserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SYSTEM_USER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SYSTEM_USER__USERNAME, oldUsername, username));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SYSTEM_USER__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getRelatedEmployee() {
		if (relatedEmployee != null && relatedEmployee.eIsProxy())
		{
			InternalEObject oldRelatedEmployee = (InternalEObject)relatedEmployee;
			relatedEmployee = (Employee)eResolveProxy(oldRelatedEmployee);
			if (relatedEmployee != oldRelatedEmployee)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.SYSTEM_USER__RELATED_EMPLOYEE, oldRelatedEmployee, relatedEmployee));
			}
		}
		return relatedEmployee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee basicGetRelatedEmployee() {
		return relatedEmployee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelatedEmployee(Employee newRelatedEmployee, NotificationChain msgs) {
		Employee oldRelatedEmployee = relatedEmployee;
		relatedEmployee = newRelatedEmployee;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.SYSTEM_USER__RELATED_EMPLOYEE, oldRelatedEmployee, newRelatedEmployee);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedEmployee(Employee newRelatedEmployee) {
		if (newRelatedEmployee != relatedEmployee)
		{
			NotificationChain msgs = null;
			if (relatedEmployee != null)
				msgs = ((InternalEObject)relatedEmployee).eInverseRemove(this, DairyPackage.EMPLOYEE__SYSTEM_IDENTITY, Employee.class, msgs);
			if (newRelatedEmployee != null)
				msgs = ((InternalEObject)newRelatedEmployee).eInverseAdd(this, DairyPackage.EMPLOYEE__SYSTEM_IDENTITY, Employee.class, msgs);
			msgs = basicSetRelatedEmployee(newRelatedEmployee, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SYSTEM_USER__RELATED_EMPLOYEE, newRelatedEmployee, newRelatedEmployee));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SYSTEM_USER__LOCAL_ENABLED, oldLocalEnabled, localEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role getRole() {
		if (role != null && role.eIsProxy())
		{
			InternalEObject oldRole = (InternalEObject)role;
			role = (Role)eResolveProxy(oldRole);
			if (role != oldRole)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.SYSTEM_USER__ROLE, oldRole, role));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SYSTEM_USER__ROLE, oldRole, role));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SYSTEM_USER__PASSWORD_HASHED, oldPasswordHashed, passwordHashed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(Long newId) {
		Long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SYSTEM_USER__ID, oldId, id));
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
			case ModelPackage.SYSTEM_USER__RELATED_EMPLOYEE:
				if (relatedEmployee != null)
					msgs = ((InternalEObject)relatedEmployee).eInverseRemove(this, DairyPackage.EMPLOYEE__SYSTEM_IDENTITY, Employee.class, msgs);
				return basicSetRelatedEmployee((Employee)otherEnd, msgs);
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
			case ModelPackage.SYSTEM_USER__RELATED_EMPLOYEE:
				return basicSetRelatedEmployee(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case ModelPackage.SYSTEM_USER__USERNAME:
				return getUsername();
			case ModelPackage.SYSTEM_USER__PASSWORD:
				return getPassword();
			case ModelPackage.SYSTEM_USER__RELATED_EMPLOYEE:
				if (resolve) return getRelatedEmployee();
				return basicGetRelatedEmployee();
			case ModelPackage.SYSTEM_USER__LOCAL_ENABLED:
				return isLocalEnabled();
			case ModelPackage.SYSTEM_USER__ROLE:
				if (resolve) return getRole();
				return basicGetRole();
			case ModelPackage.SYSTEM_USER__PASSWORD_HASHED:
				return isPasswordHashed();
			case ModelPackage.SYSTEM_USER__ID:
				return getId();
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
			case ModelPackage.SYSTEM_USER__USERNAME:
				setUsername((String)newValue);
				return;
			case ModelPackage.SYSTEM_USER__PASSWORD:
				setPassword((String)newValue);
				return;
			case ModelPackage.SYSTEM_USER__RELATED_EMPLOYEE:
				setRelatedEmployee((Employee)newValue);
				return;
			case ModelPackage.SYSTEM_USER__LOCAL_ENABLED:
				setLocalEnabled((Boolean)newValue);
				return;
			case ModelPackage.SYSTEM_USER__ROLE:
				setRole((Role)newValue);
				return;
			case ModelPackage.SYSTEM_USER__PASSWORD_HASHED:
				setPasswordHashed((Boolean)newValue);
				return;
			case ModelPackage.SYSTEM_USER__ID:
				setId((Long)newValue);
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
			case ModelPackage.SYSTEM_USER__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case ModelPackage.SYSTEM_USER__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case ModelPackage.SYSTEM_USER__RELATED_EMPLOYEE:
				setRelatedEmployee((Employee)null);
				return;
			case ModelPackage.SYSTEM_USER__LOCAL_ENABLED:
				setLocalEnabled(LOCAL_ENABLED_EDEFAULT);
				return;
			case ModelPackage.SYSTEM_USER__ROLE:
				setRole((Role)null);
				return;
			case ModelPackage.SYSTEM_USER__PASSWORD_HASHED:
				setPasswordHashed(PASSWORD_HASHED_EDEFAULT);
				return;
			case ModelPackage.SYSTEM_USER__ID:
				setId(ID_EDEFAULT);
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
			case ModelPackage.SYSTEM_USER__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case ModelPackage.SYSTEM_USER__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case ModelPackage.SYSTEM_USER__RELATED_EMPLOYEE:
				return relatedEmployee != null;
			case ModelPackage.SYSTEM_USER__LOCAL_ENABLED:
				return localEnabled != LOCAL_ENABLED_EDEFAULT;
			case ModelPackage.SYSTEM_USER__ROLE:
				return role != null;
			case ModelPackage.SYSTEM_USER__PASSWORD_HASHED:
				return passwordHashed != PASSWORD_HASHED_EDEFAULT;
			case ModelPackage.SYSTEM_USER__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (username: ");
		result.append(username);
		result.append(", password: ");
		result.append(password);
		result.append(", localEnabled: ");
		result.append(localEnabled);
		result.append(", passwordHashed: ");
		result.append(passwordHashed);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //SystemUserImpl
