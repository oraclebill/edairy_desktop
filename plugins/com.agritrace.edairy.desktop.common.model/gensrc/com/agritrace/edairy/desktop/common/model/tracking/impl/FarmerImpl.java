/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking.impl;

import com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Farmer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.FarmerImpl#getFarms <em>Farms</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.FarmerImpl#getMembership <em>Membership</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FarmerImpl extends PersonImpl implements Farmer {
	/**
	 * The cached value of the '{@link #getFarms() <em>Farms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFarms()
	 * @generated
	 * @ordered
	 */
	protected EList<Farm> farms;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FarmerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackingPackage.Literals.FARMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Farm> getFarms() {
		if (farms == null) {
			farms = new EObjectContainmentWithInverseEList<Farm>(Farm.class, this, TrackingPackage.FARMER__FARMS, TrackingPackage.FARM__OWNER);
		}
		return farms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Membership getMembership() {
		if (eContainerFeatureID() != TrackingPackage.FARMER__MEMBERSHIP) return null;
		return (Membership)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMembership(Membership newMembership, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMembership, TrackingPackage.FARMER__MEMBERSHIP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMembership(Membership newMembership) {
		if (newMembership != eInternalContainer() || (eContainerFeatureID() != TrackingPackage.FARMER__MEMBERSHIP && newMembership != null)) {
			if (EcoreUtil.isAncestor(this, newMembership))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMembership != null)
				msgs = ((InternalEObject)newMembership).eInverseAdd(this, DairyPackage.MEMBERSHIP__FARMER, Membership.class, msgs);
			msgs = basicSetMembership(newMembership, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.FARMER__MEMBERSHIP, newMembership, newMembership));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackingPackage.FARMER__FARMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFarms()).basicAdd(otherEnd, msgs);
			case TrackingPackage.FARMER__MEMBERSHIP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMembership((Membership)otherEnd, msgs);
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
		switch (featureID) {
			case TrackingPackage.FARMER__FARMS:
				return ((InternalEList<?>)getFarms()).basicRemove(otherEnd, msgs);
			case TrackingPackage.FARMER__MEMBERSHIP:
				return basicSetMembership(null, msgs);
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
		switch (eContainerFeatureID()) {
			case TrackingPackage.FARMER__MEMBERSHIP:
				return eInternalContainer().eInverseRemove(this, DairyPackage.MEMBERSHIP__FARMER, Membership.class, msgs);
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
		switch (featureID) {
			case TrackingPackage.FARMER__FARMS:
				return getFarms();
			case TrackingPackage.FARMER__MEMBERSHIP:
				return getMembership();
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
		switch (featureID) {
			case TrackingPackage.FARMER__FARMS:
				getFarms().clear();
				getFarms().addAll((Collection<? extends Farm>)newValue);
				return;
			case TrackingPackage.FARMER__MEMBERSHIP:
				setMembership((Membership)newValue);
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
			case TrackingPackage.FARMER__FARMS:
				getFarms().clear();
				return;
			case TrackingPackage.FARMER__MEMBERSHIP:
				setMembership((Membership)null);
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
			case TrackingPackage.FARMER__FARMS:
				return farms != null && !farms.isEmpty();
			case TrackingPackage.FARMER__MEMBERSHIP:
				return getMembership() != null;
		}
		return super.eIsSet(featureID);
	}

} //FarmerImpl
