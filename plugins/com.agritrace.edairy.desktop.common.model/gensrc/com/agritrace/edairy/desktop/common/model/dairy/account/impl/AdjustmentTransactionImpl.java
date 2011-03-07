/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.account.impl;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AdjustmentTransaction;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adjustment Transaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AdjustmentTransactionImpl#getSignedOffBy <em>Signed Off By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdjustmentTransactionImpl extends TransactionImpl implements AdjustmentTransaction {
	/**
	 * The cached value of the '{@link #getSignedOffBy() <em>Signed Off By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignedOffBy()
	 * @generated
	 * @ordered
	 */
	protected Employee signedOffBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdjustmentTransactionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccountPackage.Literals.ADJUSTMENT_TRANSACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getSignedOffBy() {
		if (signedOffBy != null && signedOffBy.eIsProxy())
		{
			InternalEObject oldSignedOffBy = (InternalEObject)signedOffBy;
			signedOffBy = (Employee)eResolveProxy(oldSignedOffBy);
			if (signedOffBy != oldSignedOffBy)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AccountPackage.ADJUSTMENT_TRANSACTION__SIGNED_OFF_BY, oldSignedOffBy, signedOffBy));
			}
		}
		return signedOffBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee basicGetSignedOffBy() {
		return signedOffBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignedOffBy(Employee newSignedOffBy) {
		Employee oldSignedOffBy = signedOffBy;
		signedOffBy = newSignedOffBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ADJUSTMENT_TRANSACTION__SIGNED_OFF_BY, oldSignedOffBy, signedOffBy));
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
			case AccountPackage.ADJUSTMENT_TRANSACTION__SIGNED_OFF_BY:
				if (resolve) return getSignedOffBy();
				return basicGetSignedOffBy();
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
			case AccountPackage.ADJUSTMENT_TRANSACTION__SIGNED_OFF_BY:
				setSignedOffBy((Employee)newValue);
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
			case AccountPackage.ADJUSTMENT_TRANSACTION__SIGNED_OFF_BY:
				setSignedOffBy((Employee)null);
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
			case AccountPackage.ADJUSTMENT_TRANSACTION__SIGNED_OFF_BY:
				return signedOffBy != null;
		}
		return super.eIsSet(featureID);
	}

} //AdjustmentTransactionImpl
