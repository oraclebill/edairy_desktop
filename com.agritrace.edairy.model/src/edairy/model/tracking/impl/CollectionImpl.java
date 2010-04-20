/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model.tracking.impl;

import edairy.model.tracking.Collection;
import edairy.model.tracking.Farm;
import edairy.model.tracking.Lot;
import edairy.model.tracking.TrackingPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edairy.model.tracking.impl.CollectionImpl#getFrom <em>From</em>}</li>
 *   <li>{@link edairy.model.tracking.impl.CollectionImpl#getContributedTo <em>Contributed To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionImpl extends TransferImpl implements Collection {
	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected Farm from;

	/**
	 * The cached value of the '{@link #getContributedTo() <em>Contributed To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributedTo()
	 * @generated
	 * @ordered
	 */
	protected Lot contributedTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackingPackage.Literals.COLLECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Farm getFrom() {
		if (from != null && from.eIsProxy()) {
			InternalEObject oldFrom = (InternalEObject)from;
			from = (Farm)eResolveProxy(oldFrom);
			if (from != oldFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrackingPackage.COLLECTION__FROM, oldFrom, from));
			}
		}
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Farm basicGetFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(Farm newFrom) {
		Farm oldFrom = from;
		from = newFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.COLLECTION__FROM, oldFrom, from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lot getContributedTo() {
		if (contributedTo != null && contributedTo.eIsProxy()) {
			InternalEObject oldContributedTo = (InternalEObject)contributedTo;
			contributedTo = (Lot)eResolveProxy(oldContributedTo);
			if (contributedTo != oldContributedTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrackingPackage.COLLECTION__CONTRIBUTED_TO, oldContributedTo, contributedTo));
			}
		}
		return contributedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lot basicGetContributedTo() {
		return contributedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContributedTo(Lot newContributedTo) {
		Lot oldContributedTo = contributedTo;
		contributedTo = newContributedTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.COLLECTION__CONTRIBUTED_TO, oldContributedTo, contributedTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackingPackage.COLLECTION__FROM:
				if (resolve) return getFrom();
				return basicGetFrom();
			case TrackingPackage.COLLECTION__CONTRIBUTED_TO:
				if (resolve) return getContributedTo();
				return basicGetContributedTo();
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
			case TrackingPackage.COLLECTION__FROM:
				setFrom((Farm)newValue);
				return;
			case TrackingPackage.COLLECTION__CONTRIBUTED_TO:
				setContributedTo((Lot)newValue);
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
			case TrackingPackage.COLLECTION__FROM:
				setFrom((Farm)null);
				return;
			case TrackingPackage.COLLECTION__CONTRIBUTED_TO:
				setContributedTo((Lot)null);
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
			case TrackingPackage.COLLECTION__FROM:
				return from != null;
			case TrackingPackage.COLLECTION__CONTRIBUTED_TO:
				return contributedTo != null;
		}
		return super.eIsSet(featureID);
	}

} //CollectionImpl
