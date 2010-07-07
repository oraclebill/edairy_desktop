/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.Trip;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trip</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.TripImpl#getCollections <em>Collections</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.TripImpl#getDeliveries <em>Deliveries</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.TripImpl#getStarted <em>Started</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.TripImpl#getEnded <em>Ended</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.TripImpl#getTripId <em>Trip Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TripImpl extends EObjectImpl implements Trip {
	/**
	 * The cached value of the '{@link #getCollections() <em>Collections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollections()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionJournalPage> collections;

	/**
	 * The cached value of the '{@link #getDeliveries() <em>Deliveries</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeliveries()
	 * @generated
	 * @ordered
	 */
	protected EList<DeliveryJournal> deliveries;

	/**
	 * The default value of the '{@link #getStarted() <em>Started</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStarted()
	 * @generated
	 * @ordered
	 */
	protected static final Date STARTED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStarted() <em>Started</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStarted()
	 * @generated
	 * @ordered
	 */
	protected Date started = STARTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnded() <em>Ended</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnded()
	 * @generated
	 * @ordered
	 */
	protected static final Date ENDED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnded() <em>Ended</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnded()
	 * @generated
	 * @ordered
	 */
	protected Date ended = ENDED_EDEFAULT;

	/**
	 * The default value of the '{@link #getTripId() <em>Trip Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTripId()
	 * @generated
	 * @ordered
	 */
	protected static final long TRIP_ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTripId() <em>Trip Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTripId()
	 * @generated
	 * @ordered
	 */
	protected long tripId = TRIP_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TripImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.TRIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CollectionJournalPage> getCollections() {
		if (collections == null) {
			collections = new EObjectResolvingEList<CollectionJournalPage>(CollectionJournalPage.class, this, DairyPackage.TRIP__COLLECTIONS);
		}
		return collections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeliveryJournal> getDeliveries() {
		if (deliveries == null) {
			deliveries = new EObjectResolvingEList<DeliveryJournal>(DeliveryJournal.class, this, DairyPackage.TRIP__DELIVERIES);
		}
		return deliveries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getStarted() {
		return started;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStarted(Date newStarted) {
		Date oldStarted = started;
		started = newStarted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.TRIP__STARTED, oldStarted, started));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEnded() {
		return ended;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnded(Date newEnded) {
		Date oldEnded = ended;
		ended = newEnded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.TRIP__ENDED, oldEnded, ended));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTripId() {
		return tripId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.TRIP__COLLECTIONS:
				return getCollections();
			case DairyPackage.TRIP__DELIVERIES:
				return getDeliveries();
			case DairyPackage.TRIP__STARTED:
				return getStarted();
			case DairyPackage.TRIP__ENDED:
				return getEnded();
			case DairyPackage.TRIP__TRIP_ID:
				return getTripId();
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
			case DairyPackage.TRIP__COLLECTIONS:
				getCollections().clear();
				getCollections().addAll((Collection<? extends CollectionJournalPage>)newValue);
				return;
			case DairyPackage.TRIP__DELIVERIES:
				getDeliveries().clear();
				getDeliveries().addAll((Collection<? extends DeliveryJournal>)newValue);
				return;
			case DairyPackage.TRIP__STARTED:
				setStarted((Date)newValue);
				return;
			case DairyPackage.TRIP__ENDED:
				setEnded((Date)newValue);
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
			case DairyPackage.TRIP__COLLECTIONS:
				getCollections().clear();
				return;
			case DairyPackage.TRIP__DELIVERIES:
				getDeliveries().clear();
				return;
			case DairyPackage.TRIP__STARTED:
				setStarted(STARTED_EDEFAULT);
				return;
			case DairyPackage.TRIP__ENDED:
				setEnded(ENDED_EDEFAULT);
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
			case DairyPackage.TRIP__COLLECTIONS:
				return collections != null && !collections.isEmpty();
			case DairyPackage.TRIP__DELIVERIES:
				return deliveries != null && !deliveries.isEmpty();
			case DairyPackage.TRIP__STARTED:
				return STARTED_EDEFAULT == null ? started != null : !STARTED_EDEFAULT.equals(started);
			case DairyPackage.TRIP__ENDED:
				return ENDED_EDEFAULT == null ? ended != null : !ENDED_EDEFAULT.equals(ended);
			case DairyPackage.TRIP__TRIP_ID:
				return tripId != TRIP_ID_EDEFAULT;
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
		result.append(" (started: ");
		result.append(started);
		result.append(", ended: ");
		result.append(ended);
		result.append(", tripId: ");
		result.append(tripId);
		result.append(')');
		return result.toString();
	}

} //TripImpl
