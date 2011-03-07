/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.dairy.Asset;
import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.TransportRoute;

import com.agritrace.edairy.desktop.common.model.tracking.impl.ContainerImpl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.BinImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.BinImpl#getZone <em>Zone</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.BinImpl#getAssetInfo <em>Asset Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BinImpl extends ContainerImpl implements Bin {
	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_EDEFAULT = "IN_CIRCULATION";

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
	 * The cached value of the '{@link #getZone() <em>Zone</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZone()
	 * @generated
	 * @ordered
	 */
	protected TransportRoute zone;

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
	protected BinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.BIN;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.BIN__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransportRoute getZone() {
		if (zone != null && zone.eIsProxy())
		{
			InternalEObject oldZone = (InternalEObject)zone;
			zone = (TransportRoute)eResolveProxy(oldZone);
			if (zone != oldZone)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.BIN__ZONE, oldZone, zone));
			}
		}
		return zone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransportRoute basicGetZone() {
		return zone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetZone(TransportRoute newZone, NotificationChain msgs) {
		TransportRoute oldZone = zone;
		zone = newZone;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DairyPackage.BIN__ZONE, oldZone, newZone);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZone(TransportRoute newZone) {
		if (newZone != zone)
		{
			NotificationChain msgs = null;
			if (zone != null)
				msgs = ((InternalEObject)zone).eInverseRemove(this, DairyPackage.TRANSPORT_ROUTE__BINS, TransportRoute.class, msgs);
			if (newZone != null)
				msgs = ((InternalEObject)newZone).eInverseAdd(this, DairyPackage.TRANSPORT_ROUTE__BINS, TransportRoute.class, msgs);
			msgs = basicSetZone(newZone, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.BIN__ZONE, newZone, newZone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Asset getAssetInfo() {
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
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DairyPackage.BIN__ASSET_INFO, oldAssetInfo, newAssetInfo);
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
		if (newAssetInfo != assetInfo)
		{
			NotificationChain msgs = null;
			if (assetInfo != null)
				msgs = ((InternalEObject)assetInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DairyPackage.BIN__ASSET_INFO, null, msgs);
			if (newAssetInfo != null)
				msgs = ((InternalEObject)newAssetInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DairyPackage.BIN__ASSET_INFO, null, msgs);
			msgs = basicSetAssetInfo(newAssetInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.BIN__ASSET_INFO, newAssetInfo, newAssetInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case DairyPackage.BIN__ZONE:
				if (zone != null)
					msgs = ((InternalEObject)zone).eInverseRemove(this, DairyPackage.TRANSPORT_ROUTE__BINS, TransportRoute.class, msgs);
				return basicSetZone((TransportRoute)otherEnd, msgs);
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
			case DairyPackage.BIN__ZONE:
				return basicSetZone(null, msgs);
			case DairyPackage.BIN__ASSET_INFO:
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
		switch (featureID)
		{
			case DairyPackage.BIN__STATUS:
				return getStatus();
			case DairyPackage.BIN__ZONE:
				if (resolve) return getZone();
				return basicGetZone();
			case DairyPackage.BIN__ASSET_INFO:
				return getAssetInfo();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case DairyPackage.BIN__STATUS:
				setStatus((String)newValue);
				return;
			case DairyPackage.BIN__ZONE:
				setZone((TransportRoute)newValue);
				return;
			case DairyPackage.BIN__ASSET_INFO:
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
		switch (featureID)
		{
			case DairyPackage.BIN__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case DairyPackage.BIN__ZONE:
				setZone((TransportRoute)null);
				return;
			case DairyPackage.BIN__ASSET_INFO:
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
		switch (featureID)
		{
			case DairyPackage.BIN__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
			case DairyPackage.BIN__ZONE:
				return zone != null;
			case DairyPackage.BIN__ASSET_INFO:
				return assetInfo != null;
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
		result.append(" (status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //BinImpl
