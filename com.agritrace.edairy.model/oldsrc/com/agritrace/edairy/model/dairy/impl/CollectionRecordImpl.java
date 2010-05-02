/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.impl;

import com.agritrace.edairy.model.UnitOfMeasure;

import com.agritrace.edairy.model.dairy.CollectionRecord;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Membership;

import com.agritrace.edairy.model.tracking.Container;
import com.agritrace.edairy.model.tracking.Farm;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

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
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionRecordImpl#getDate <em>Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionRecordImpl#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionRecordImpl#getUnitOfMeasure <em>Unit Of Measure</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionRecordImpl#getFrom <em>From</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionRecordImpl#getFarmContainer <em>Farm Container</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionRecordImpl#getDairyContainer <em>Dairy Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionRecordImpl extends EObjectImpl implements CollectionRecord {
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
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final double QUANTITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected double quantity = QUANTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnitOfMeasure() <em>Unit Of Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitOfMeasure()
	 * @generated
	 * @ordered
	 */
	protected static final UnitOfMeasure UNIT_OF_MEASURE_EDEFAULT = UnitOfMeasure.LITRE;

	/**
	 * The cached value of the '{@link #getUnitOfMeasure() <em>Unit Of Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitOfMeasure()
	 * @generated
	 * @ordered
	 */
	protected UnitOfMeasure unitOfMeasure = UNIT_OF_MEASURE_EDEFAULT;

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
	 * The cached value of the '{@link #getFarmContainer() <em>Farm Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFarmContainer()
	 * @generated
	 * @ordered
	 */
	protected Container farmContainer;

	/**
	 * The cached value of the '{@link #getDairyContainer() <em>Dairy Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDairyContainer()
	 * @generated
	 * @ordered
	 */
	protected Container dairyContainer;

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
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_RECORD__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getQuantity() {
		return quantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuantity(double newQuantity) {
		double oldQuantity = quantity;
		quantity = newQuantity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_RECORD__QUANTITY, oldQuantity, quantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitOfMeasure(UnitOfMeasure newUnitOfMeasure) {
		UnitOfMeasure oldUnitOfMeasure = unitOfMeasure;
		unitOfMeasure = newUnitOfMeasure == null ? UNIT_OF_MEASURE_EDEFAULT : newUnitOfMeasure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_RECORD__UNIT_OF_MEASURE, oldUnitOfMeasure, unitOfMeasure));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_RECORD__FROM, oldFrom, from));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_RECORD__FROM, oldFrom, from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container getFarmContainer() {
		if (farmContainer != null && farmContainer.eIsProxy()) {
			InternalEObject oldFarmContainer = (InternalEObject)farmContainer;
			farmContainer = (Container)eResolveProxy(oldFarmContainer);
			if (farmContainer != oldFarmContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_RECORD__FARM_CONTAINER, oldFarmContainer, farmContainer));
			}
		}
		return farmContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container basicGetFarmContainer() {
		return farmContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFarmContainer(Container newFarmContainer) {
		Container oldFarmContainer = farmContainer;
		farmContainer = newFarmContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_RECORD__FARM_CONTAINER, oldFarmContainer, farmContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container getDairyContainer() {
		if (dairyContainer != null && dairyContainer.eIsProxy()) {
			InternalEObject oldDairyContainer = (InternalEObject)dairyContainer;
			dairyContainer = (Container)eResolveProxy(oldDairyContainer);
			if (dairyContainer != oldDairyContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_RECORD__DAIRY_CONTAINER, oldDairyContainer, dairyContainer));
			}
		}
		return dairyContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container basicGetDairyContainer() {
		return dairyContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDairyContainer(Container newDairyContainer) {
		Container oldDairyContainer = dairyContainer;
		dairyContainer = newDairyContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_RECORD__DAIRY_CONTAINER, oldDairyContainer, dairyContainer));
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
			case DairyPackage.COLLECTION_RECORD__DATE:
				return getDate();
			case DairyPackage.COLLECTION_RECORD__QUANTITY:
				return getQuantity();
			case DairyPackage.COLLECTION_RECORD__UNIT_OF_MEASURE:
				return getUnitOfMeasure();
			case DairyPackage.COLLECTION_RECORD__FROM:
				if (resolve) return getFrom();
				return basicGetFrom();
			case DairyPackage.COLLECTION_RECORD__FARM_CONTAINER:
				if (resolve) return getFarmContainer();
				return basicGetFarmContainer();
			case DairyPackage.COLLECTION_RECORD__DAIRY_CONTAINER:
				if (resolve) return getDairyContainer();
				return basicGetDairyContainer();
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
			case DairyPackage.COLLECTION_RECORD__DATE:
				setDate((Date)newValue);
				return;
			case DairyPackage.COLLECTION_RECORD__QUANTITY:
				setQuantity((Double)newValue);
				return;
			case DairyPackage.COLLECTION_RECORD__UNIT_OF_MEASURE:
				setUnitOfMeasure((UnitOfMeasure)newValue);
				return;
			case DairyPackage.COLLECTION_RECORD__FROM:
				setFrom((Farm)newValue);
				return;
			case DairyPackage.COLLECTION_RECORD__FARM_CONTAINER:
				setFarmContainer((Container)newValue);
				return;
			case DairyPackage.COLLECTION_RECORD__DAIRY_CONTAINER:
				setDairyContainer((Container)newValue);
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
			case DairyPackage.COLLECTION_RECORD__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_RECORD__QUANTITY:
				setQuantity(QUANTITY_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_RECORD__UNIT_OF_MEASURE:
				setUnitOfMeasure(UNIT_OF_MEASURE_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_RECORD__FROM:
				setFrom((Farm)null);
				return;
			case DairyPackage.COLLECTION_RECORD__FARM_CONTAINER:
				setFarmContainer((Container)null);
				return;
			case DairyPackage.COLLECTION_RECORD__DAIRY_CONTAINER:
				setDairyContainer((Container)null);
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
			case DairyPackage.COLLECTION_RECORD__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case DairyPackage.COLLECTION_RECORD__QUANTITY:
				return quantity != QUANTITY_EDEFAULT;
			case DairyPackage.COLLECTION_RECORD__UNIT_OF_MEASURE:
				return unitOfMeasure != UNIT_OF_MEASURE_EDEFAULT;
			case DairyPackage.COLLECTION_RECORD__FROM:
				return from != null;
			case DairyPackage.COLLECTION_RECORD__FARM_CONTAINER:
				return farmContainer != null;
			case DairyPackage.COLLECTION_RECORD__DAIRY_CONTAINER:
				return dairyContainer != null;
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
		result.append(", date: ");
		result.append(date);
		result.append(", quantity: ");
		result.append(quantity);
		result.append(", unitOfMeasure: ");
		result.append(unitOfMeasure);
		result.append(')');
		return result.toString();
	}

} //CollectionRecordImpl
