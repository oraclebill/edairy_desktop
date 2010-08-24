/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.GlobalSettings;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.GlobalSettingsImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.GlobalSettingsImpl#isPasswordsEncrypted <em>Passwords Encrypted</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GlobalSettingsImpl extends EObjectImpl implements GlobalSettings {
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
	 * The default value of the '{@link #isPasswordsEncrypted() <em>Passwords Encrypted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPasswordsEncrypted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PASSWORDS_ENCRYPTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPasswordsEncrypted() <em>Passwords Encrypted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPasswordsEncrypted()
	 * @generated
	 * @ordered
	 */
	protected boolean passwordsEncrypted = PASSWORDS_ENCRYPTED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalSettingsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.GLOBAL_SETTINGS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.GLOBAL_SETTINGS__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPasswordsEncrypted() {
		return passwordsEncrypted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPasswordsEncrypted(boolean newPasswordsEncrypted) {
		boolean oldPasswordsEncrypted = passwordsEncrypted;
		passwordsEncrypted = newPasswordsEncrypted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.GLOBAL_SETTINGS__PASSWORDS_ENCRYPTED, oldPasswordsEncrypted, passwordsEncrypted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.GLOBAL_SETTINGS__ID:
				return getId();
			case DairyPackage.GLOBAL_SETTINGS__PASSWORDS_ENCRYPTED:
				return isPasswordsEncrypted();
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
			case DairyPackage.GLOBAL_SETTINGS__ID:
				setId((Long)newValue);
				return;
			case DairyPackage.GLOBAL_SETTINGS__PASSWORDS_ENCRYPTED:
				setPasswordsEncrypted((Boolean)newValue);
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
			case DairyPackage.GLOBAL_SETTINGS__ID:
				setId(ID_EDEFAULT);
				return;
			case DairyPackage.GLOBAL_SETTINGS__PASSWORDS_ENCRYPTED:
				setPasswordsEncrypted(PASSWORDS_ENCRYPTED_EDEFAULT);
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
			case DairyPackage.GLOBAL_SETTINGS__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case DairyPackage.GLOBAL_SETTINGS__PASSWORDS_ENCRYPTED:
				return passwordsEncrypted != PASSWORDS_ENCRYPTED_EDEFAULT;
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
		result.append(", passwordsEncrypted: ");
		result.append(passwordsEncrypted);
		result.append(')');
		return result.toString();
	}

} //GlobalSettingsImpl
