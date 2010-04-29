/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.impl;

import com.agritrace.edairy.model.dairy.CollectionRecord;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Membership;

import com.agritrace.edairy.model.tracking.impl.CollectionImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Record</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionRecordImpl#isSuspended <em>Suspended</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionRecordImpl#isNotRecorded <em>Not Recorded</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionRecordImpl#getRecordedMember <em>Recorded Member</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionRecordImpl#isOffRoute <em>Off Route</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionRecordImpl extends CollectionImpl implements CollectionRecord {
	/**
	 * The default value of the '{@link #isSuspended() <em>Suspended</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuspended()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUSPENDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSuspended() <em>Suspended</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuspended()
	 * @generated
	 * @ordered
	 */
	protected boolean suspended = SUSPENDED_EDEFAULT;

	/**
	 * The default value of the '{@link #isNotRecorded() <em>Not Recorded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNotRecorded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NOT_RECORDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNotRecorded() <em>Not Recorded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNotRecorded()
	 * @generated
	 * @ordered
	 */
	protected boolean notRecorded = NOT_RECORDED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRecordedMember() <em>Recorded Member</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordedMember()
	 * @generated
	 * @ordered
	 */
	protected Membership recordedMember;

	/**
	 * The default value of the '{@link #isOffRoute() <em>Off Route</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOffRoute()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OFF_ROUTE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOffRoute() <em>Off Route</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOffRoute()
	 * @generated
	 * @ordered
	 */
	protected boolean offRoute = OFF_ROUTE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionRecordImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.COLLECTION_RECORD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSuspended() {
		return suspended;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspended(boolean newSuspended) {
		boolean oldSuspended = suspended;
		suspended = newSuspended;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_RECORD__SUSPENDED, oldSuspended, suspended));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNotRecorded() {
		return notRecorded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotRecorded(boolean newNotRecorded) {
		boolean oldNotRecorded = notRecorded;
		notRecorded = newNotRecorded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_RECORD__NOT_RECORDED, oldNotRecorded, notRecorded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Membership getRecordedMember() {
		if (recordedMember != null && recordedMember.eIsProxy()) {
			InternalEObject oldRecordedMember = (InternalEObject)recordedMember;
			recordedMember = (Membership)eResolveProxy(oldRecordedMember);
			if (recordedMember != oldRecordedMember) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_RECORD__RECORDED_MEMBER, oldRecordedMember, recordedMember));
			}
		}
		return recordedMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Membership basicGetRecordedMember() {
		return recordedMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecordedMember(Membership newRecordedMember) {
		Membership oldRecordedMember = recordedMember;
		recordedMember = newRecordedMember;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_RECORD__RECORDED_MEMBER, oldRecordedMember, recordedMember));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOffRoute() {
		return offRoute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffRoute(boolean newOffRoute) {
		boolean oldOffRoute = offRoute;
		offRoute = newOffRoute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_RECORD__OFF_ROUTE, oldOffRoute, offRoute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.COLLECTION_RECORD__SUSPENDED:
				return isSuspended();
			case DairyPackage.COLLECTION_RECORD__NOT_RECORDED:
				return isNotRecorded();
			case DairyPackage.COLLECTION_RECORD__RECORDED_MEMBER:
				if (resolve) return getRecordedMember();
				return basicGetRecordedMember();
			case DairyPackage.COLLECTION_RECORD__OFF_ROUTE:
				return isOffRoute();
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
			case DairyPackage.COLLECTION_RECORD__SUSPENDED:
				setSuspended((Boolean)newValue);
				return;
			case DairyPackage.COLLECTION_RECORD__NOT_RECORDED:
				setNotRecorded((Boolean)newValue);
				return;
			case DairyPackage.COLLECTION_RECORD__RECORDED_MEMBER:
				setRecordedMember((Membership)newValue);
				return;
			case DairyPackage.COLLECTION_RECORD__OFF_ROUTE:
				setOffRoute((Boolean)newValue);
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
			case DairyPackage.COLLECTION_RECORD__SUSPENDED:
				setSuspended(SUSPENDED_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_RECORD__NOT_RECORDED:
				setNotRecorded(NOT_RECORDED_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_RECORD__RECORDED_MEMBER:
				setRecordedMember((Membership)null);
				return;
			case DairyPackage.COLLECTION_RECORD__OFF_ROUTE:
				setOffRoute(OFF_ROUTE_EDEFAULT);
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
			case DairyPackage.COLLECTION_RECORD__SUSPENDED:
				return suspended != SUSPENDED_EDEFAULT;
			case DairyPackage.COLLECTION_RECORD__NOT_RECORDED:
				return notRecorded != NOT_RECORDED_EDEFAULT;
			case DairyPackage.COLLECTION_RECORD__RECORDED_MEMBER:
				return recordedMember != null;
			case DairyPackage.COLLECTION_RECORD__OFF_ROUTE:
				return offRoute != OFF_ROUTE_EDEFAULT;
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
		result.append(" (suspended: ");
		result.append(suspended);
		result.append(", notRecorded: ");
		result.append(notRecorded);
		result.append(", offRoute: ");
		result.append(offRoute);
		result.append(')');
		return result.toString();
	}

} //CollectionRecordImpl
