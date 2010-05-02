/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.impl;

import com.agritrace.edairy.model.dairy.Asset;
import com.agritrace.edairy.model.dairy.DairyContainer;
import com.agritrace.edairy.model.dairy.DairyPackage;

import com.agritrace.edairy.model.tracking.impl.ContainerImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.DairyContainerImpl#getAssetInfo <em>Asset Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DairyContainerImpl extends ContainerImpl implements DairyContainer {
	/**
	 * The cached value of the '{@link #getAssetInfo() <em>Asset Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssetInfo()
	 * @generated
	 * @ordered
	 */
	protected Asset assetInfo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DairyContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.DAIRY_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Asset getAssetInfo() {
		if (assetInfo != null && assetInfo.eIsProxy()) {
			InternalEObject oldAssetInfo = (InternalEObject)assetInfo;
			assetInfo = (Asset)eResolveProxy(oldAssetInfo);
			if (assetInfo != oldAssetInfo) {
				InternalEObject newAssetInfo = (InternalEObject)assetInfo;
				NotificationChain msgs = oldAssetInfo.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DairyPackage.DAIRY_CONTAINER__ASSET_INFO, null, null);
				if (newAssetInfo.eInternalContainer() == null) {
					msgs = newAssetInfo.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DairyPackage.DAIRY_CONTAINER__ASSET_INFO, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.DAIRY_CONTAINER__ASSET_INFO, oldAssetInfo, assetInfo));
			}
		}
		return assetInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Asset basicGetAssetInfo() {
		return assetInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssetInfo(Asset newAssetInfo, NotificationChain msgs) {
		Asset oldAssetInfo = assetInfo;
		assetInfo = newAssetInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_CONTAINER__ASSET_INFO, oldAssetInfo, newAssetInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssetInfo(Asset newAssetInfo) {
		if (newAssetInfo != assetInfo) {
			NotificationChain msgs = null;
			if (assetInfo != null)
				msgs = ((InternalEObject)assetInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DairyPackage.DAIRY_CONTAINER__ASSET_INFO, null, msgs);
			if (newAssetInfo != null)
				msgs = ((InternalEObject)newAssetInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DairyPackage.DAIRY_CONTAINER__ASSET_INFO, null, msgs);
			msgs = basicSetAssetInfo(newAssetInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_CONTAINER__ASSET_INFO, newAssetInfo, newAssetInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DairyPackage.DAIRY_CONTAINER__ASSET_INFO:
				return basicSetAssetInfo(null, msgs);
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
		switch (featureID) {
			case DairyPackage.DAIRY_CONTAINER__ASSET_INFO:
				if (resolve) return getAssetInfo();
				return basicGetAssetInfo();
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
			case DairyPackage.DAIRY_CONTAINER__ASSET_INFO:
				setAssetInfo((Asset)newValue);
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
			case DairyPackage.DAIRY_CONTAINER__ASSET_INFO:
				setAssetInfo((Asset)null);
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
			case DairyPackage.DAIRY_CONTAINER__ASSET_INFO:
				return assetInfo != null;
		}
		return super.eIsSet(featureID);
	}

} //DairyContainerImpl
