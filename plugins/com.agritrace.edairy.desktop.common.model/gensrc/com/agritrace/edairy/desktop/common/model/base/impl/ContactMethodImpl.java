/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base.impl;

import com.agritrace.edairy.desktop.common.model.base.ContactMethod;
import com.agritrace.edairy.desktop.common.model.base.ContactMethodType;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contact Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.ContactMethodImpl#getCmType <em>Cm Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.ContactMethodImpl#getCmValue <em>Cm Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContactMethodImpl extends EObjectImpl implements ContactMethod {
	/**
	 * The default value of the '{@link #getCmType() <em>Cm Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCmType()
	 * @generated
	 * @ordered
	 */
	protected static final ContactMethodType CM_TYPE_EDEFAULT = ContactMethodType.EMAIL;

	/**
	 * The cached value of the '{@link #getCmType() <em>Cm Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCmType()
	 * @generated
	 * @ordered
	 */
	protected ContactMethodType cmType = CM_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCmValue() <em>Cm Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCmValue()
	 * @generated
	 * @ordered
	 */
	protected static final String CM_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCmValue() <em>Cm Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCmValue()
	 * @generated
	 * @ordered
	 */
	protected String cmValue = CM_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContactMethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CONTACT_METHOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContactMethodType getCmType() {
		return cmType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCmType(ContactMethodType newCmType) {
		ContactMethodType oldCmType = cmType;
		cmType = newCmType == null ? CM_TYPE_EDEFAULT : newCmType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTACT_METHOD__CM_TYPE, oldCmType, cmType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCmValue() {
		return cmValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCmValue(String newCmValue) {
		String oldCmValue = cmValue;
		cmValue = newCmValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTACT_METHOD__CM_VALUE, oldCmValue, cmValue));
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
			case ModelPackage.CONTACT_METHOD__CM_TYPE:
				return getCmType();
			case ModelPackage.CONTACT_METHOD__CM_VALUE:
				return getCmValue();
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
			case ModelPackage.CONTACT_METHOD__CM_TYPE:
				setCmType((ContactMethodType)newValue);
				return;
			case ModelPackage.CONTACT_METHOD__CM_VALUE:
				setCmValue((String)newValue);
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
			case ModelPackage.CONTACT_METHOD__CM_TYPE:
				setCmType(CM_TYPE_EDEFAULT);
				return;
			case ModelPackage.CONTACT_METHOD__CM_VALUE:
				setCmValue(CM_VALUE_EDEFAULT);
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
			case ModelPackage.CONTACT_METHOD__CM_TYPE:
				return cmType != CM_TYPE_EDEFAULT;
			case ModelPackage.CONTACT_METHOD__CM_VALUE:
				return CM_VALUE_EDEFAULT == null ? cmValue != null : !CM_VALUE_EDEFAULT.equals(cmValue);
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
		result.append(" (cmType: ");
		result.append(cmType);
		result.append(", cmValue: ");
		result.append(cmValue);
		result.append(')');
		return result.toString();
	}

} //ContactMethodImpl
