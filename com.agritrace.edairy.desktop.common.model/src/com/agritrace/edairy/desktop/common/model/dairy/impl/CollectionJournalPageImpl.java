/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;

import java.math.BigDecimal;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Journal Page</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#getJournalId <em>Journal Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#getJournalDate <em>Journal Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#getSession <em>Session</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#getDriver <em>Driver</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#getRoute <em>Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#getVehicle <em>Vehicle</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#getDriverTotal <em>Driver Total</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#getRecordTotal <em>Record Total</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#getJournalEntries <em>Journal Entries</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#isSuspended <em>Suspended</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#getEntryCount <em>Entry Count</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#getSuspendedCount <em>Suspended Count</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#getRejectedCount <em>Rejected Count</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalPageImpl#getJournalNumber <em>Journal Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionJournalPageImpl extends EObjectImpl implements CollectionJournalPage {
	/**
	 * The default value of the '{@link #getJournalId() <em>Journal Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJournalId()
	 * @generated
	 * @ordered
	 */
	protected static final Long JOURNAL_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJournalId() <em>Journal Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJournalId()
	 * @generated
	 * @ordered
	 */
	protected Long journalId = JOURNAL_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getReferenceNumber() <em>Reference Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERENCE_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferenceNumber() <em>Reference Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceNumber()
	 * @generated
	 * @ordered
	 */
	protected String referenceNumber = REFERENCE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getJournalDate() <em>Journal Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJournalDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date JOURNAL_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJournalDate() <em>Journal Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJournalDate()
	 * @generated
	 * @ordered
	 */
	protected Date journalDate = JOURNAL_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final JournalStatus STATUS_EDEFAULT = JournalStatus.NEW;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected JournalStatus status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSession() <em>Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSession()
	 * @generated
	 * @ordered
	 */
	protected static final Session SESSION_EDEFAULT = Session.EARLY_MORNING;

	/**
	 * The cached value of the '{@link #getSession() <em>Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSession()
	 * @generated
	 * @ordered
	 */
	protected Session session = SESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDriver() <em>Driver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriver()
	 * @generated
	 * @ordered
	 */
	protected Employee driver;

	/**
	 * The cached value of the '{@link #getRoute() <em>Route</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoute()
	 * @generated
	 * @ordered
	 */
	protected Route route;

	/**
	 * The cached value of the '{@link #getVehicle() <em>Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicle()
	 * @generated
	 * @ordered
	 */
	protected Vehicle vehicle;

	/**
	 * The default value of the '{@link #getDriverTotal() <em>Driver Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriverTotal()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal DRIVER_TOTAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDriverTotal() <em>Driver Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriverTotal()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal driverTotal = DRIVER_TOTAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getRecordTotal() <em>Record Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordTotal()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal RECORD_TOTAL_EDEFAULT = new BigDecimal("0");

	/**
	 * The cached value of the '{@link #getRecordTotal() <em>Record Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordTotal()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal recordTotal = RECORD_TOTAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getJournalEntries() <em>Journal Entries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJournalEntries()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionJournalLine> journalEntries;

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
	 * The default value of the '{@link #getEntryCount() <em>Entry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryCount()
	 * @generated
	 * @ordered
	 */
	protected static final int ENTRY_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEntryCount() <em>Entry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryCount()
	 * @generated
	 * @ordered
	 */
	protected int entryCount = ENTRY_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuspendedCount() <em>Suspended Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspendedCount()
	 * @generated
	 * @ordered
	 */
	protected static final int SUSPENDED_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSuspendedCount() <em>Suspended Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspendedCount()
	 * @generated
	 * @ordered
	 */
	protected int suspendedCount = SUSPENDED_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRejectedCount() <em>Rejected Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRejectedCount()
	 * @generated
	 * @ordered
	 */
	protected static final int REJECTED_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRejectedCount() <em>Rejected Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRejectedCount()
	 * @generated
	 * @ordered
	 */
	protected int rejectedCount = REJECTED_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getJournalNumber() <em>Journal Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJournalNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String JOURNAL_NUMBER_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getJournalNumber() <em>Journal Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJournalNumber()
	 * @generated
	 * @ordered
	 */
	protected String journalNumber = JOURNAL_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionJournalPageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.COLLECTION_JOURNAL_PAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getJournalId() {
		return journalId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJournalId(Long newJournalId) {
		Long oldJournalId = journalId;
		journalId = newJournalId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_ID, oldJournalId, journalId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CollectionJournalLine> getJournalEntries() {
		if (journalEntries == null) {
			journalEntries = new EObjectContainmentWithInverseEList<CollectionJournalLine>(CollectionJournalLine.class, this, DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_ENTRIES, DairyPackage.COLLECTION_JOURNAL_LINE__COLLECTION_JOURNAL);
		}
		return journalEntries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReferenceNumber() {
		return referenceNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceNumber(String newReferenceNumber) {
		String oldReferenceNumber = referenceNumber;
		referenceNumber = newReferenceNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_PAGE__REFERENCE_NUMBER, oldReferenceNumber, referenceNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getJournalDate() {
		return journalDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJournalDate(Date newJournalDate) {
		Date oldJournalDate = journalDate;
		journalDate = newJournalDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE, oldJournalDate, journalDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JournalStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(JournalStatus newStatus) {
		JournalStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_PAGE__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSession(Session newSession) {
		Session oldSession = session;
		session = newSession == null ? SESSION_EDEFAULT : newSession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_PAGE__SESSION, oldSession, session));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getDriver() {
		if (driver != null && driver.eIsProxy()) {
			InternalEObject oldDriver = (InternalEObject)driver;
			driver = (Employee)eResolveProxy(oldDriver);
			if (driver != oldDriver) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL_PAGE__DRIVER, oldDriver, driver));
			}
		}
		return driver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee basicGetDriver() {
		return driver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDriver(Employee newDriver) {
		Employee oldDriver = driver;
		driver = newDriver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_PAGE__DRIVER, oldDriver, driver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Route getRoute() {
		if (route != null && route.eIsProxy()) {
			InternalEObject oldRoute = (InternalEObject)route;
			route = (Route)eResolveProxy(oldRoute);
			if (route != oldRoute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL_PAGE__ROUTE, oldRoute, route));
			}
		}
		return route;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Route basicGetRoute() {
		return route;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoute(Route newRoute) {
		Route oldRoute = route;
		route = newRoute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_PAGE__ROUTE, oldRoute, route));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle getVehicle() {
		if (vehicle != null && vehicle.eIsProxy()) {
			InternalEObject oldVehicle = (InternalEObject)vehicle;
			vehicle = (Vehicle)eResolveProxy(oldVehicle);
			if (vehicle != oldVehicle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL_PAGE__VEHICLE, oldVehicle, vehicle));
			}
		}
		return vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle basicGetVehicle() {
		return vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicle(Vehicle newVehicle) {
		Vehicle oldVehicle = vehicle;
		vehicle = newVehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_PAGE__VEHICLE, oldVehicle, vehicle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getDriverTotal() {
		return driverTotal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDriverTotal(BigDecimal newDriverTotal) {
		BigDecimal oldDriverTotal = driverTotal;
		driverTotal = newDriverTotal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_PAGE__DRIVER_TOTAL, oldDriverTotal, driverTotal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getRecordTotal() {
		return recordTotal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecordTotal(BigDecimal newRecordTotal) {
		BigDecimal oldRecordTotal = recordTotal;
		recordTotal = newRecordTotal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_PAGE__RECORD_TOTAL, oldRecordTotal, recordTotal));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_PAGE__SUSPENDED, oldSuspended, suspended));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEntryCount() {
		return entryCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryCount(int newEntryCount) {
		int oldEntryCount = entryCount;
		entryCount = newEntryCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_PAGE__ENTRY_COUNT, oldEntryCount, entryCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSuspendedCount() {
		return suspendedCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspendedCount(int newSuspendedCount) {
		int oldSuspendedCount = suspendedCount;
		suspendedCount = newSuspendedCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_PAGE__SUSPENDED_COUNT, oldSuspendedCount, suspendedCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRejectedCount() {
		return rejectedCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRejectedCount(int newRejectedCount) {
		int oldRejectedCount = rejectedCount;
		rejectedCount = newRejectedCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_PAGE__REJECTED_COUNT, oldRejectedCount, rejectedCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJournalNumber() {
		return journalNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJournalNumber(String newJournalNumber) {
		String oldJournalNumber = journalNumber;
		journalNumber = newJournalNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_NUMBER, oldJournalNumber, journalNumber));
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
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_ENTRIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getJournalEntries()).basicAdd(otherEnd, msgs);
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
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_ENTRIES:
				return ((InternalEList<?>)getJournalEntries()).basicRemove(otherEnd, msgs);
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
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_ID:
				return getJournalId();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__REFERENCE_NUMBER:
				return getReferenceNumber();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE:
				return getJournalDate();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__STATUS:
				return getStatus();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__SESSION:
				return getSession();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__DRIVER:
				if (resolve) return getDriver();
				return basicGetDriver();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__ROUTE:
				if (resolve) return getRoute();
				return basicGetRoute();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__VEHICLE:
				if (resolve) return getVehicle();
				return basicGetVehicle();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__DRIVER_TOTAL:
				return getDriverTotal();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__RECORD_TOTAL:
				return getRecordTotal();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_ENTRIES:
				return getJournalEntries();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__SUSPENDED:
				return isSuspended();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__ENTRY_COUNT:
				return getEntryCount();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__SUSPENDED_COUNT:
				return getSuspendedCount();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__REJECTED_COUNT:
				return getRejectedCount();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_NUMBER:
				return getJournalNumber();
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
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_ID:
				setJournalId((Long)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__REFERENCE_NUMBER:
				setReferenceNumber((String)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE:
				setJournalDate((Date)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__STATUS:
				setStatus((JournalStatus)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__SESSION:
				setSession((Session)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__DRIVER:
				setDriver((Employee)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__ROUTE:
				setRoute((Route)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__VEHICLE:
				setVehicle((Vehicle)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__DRIVER_TOTAL:
				setDriverTotal((BigDecimal)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__RECORD_TOTAL:
				setRecordTotal((BigDecimal)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_ENTRIES:
				getJournalEntries().clear();
				getJournalEntries().addAll((Collection<? extends CollectionJournalLine>)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__SUSPENDED:
				setSuspended((Boolean)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__ENTRY_COUNT:
				setEntryCount((Integer)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__SUSPENDED_COUNT:
				setSuspendedCount((Integer)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__REJECTED_COUNT:
				setRejectedCount((Integer)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_NUMBER:
				setJournalNumber((String)newValue);
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
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_ID:
				setJournalId(JOURNAL_ID_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__REFERENCE_NUMBER:
				setReferenceNumber(REFERENCE_NUMBER_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE:
				setJournalDate(JOURNAL_DATE_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__SESSION:
				setSession(SESSION_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__DRIVER:
				setDriver((Employee)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__ROUTE:
				setRoute((Route)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__VEHICLE:
				setVehicle((Vehicle)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__DRIVER_TOTAL:
				setDriverTotal(DRIVER_TOTAL_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__RECORD_TOTAL:
				setRecordTotal(RECORD_TOTAL_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_ENTRIES:
				getJournalEntries().clear();
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__SUSPENDED:
				setSuspended(SUSPENDED_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__ENTRY_COUNT:
				setEntryCount(ENTRY_COUNT_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__SUSPENDED_COUNT:
				setSuspendedCount(SUSPENDED_COUNT_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__REJECTED_COUNT:
				setRejectedCount(REJECTED_COUNT_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_NUMBER:
				setJournalNumber(JOURNAL_NUMBER_EDEFAULT);
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
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_ID:
				return JOURNAL_ID_EDEFAULT == null ? journalId != null : !JOURNAL_ID_EDEFAULT.equals(journalId);
			case DairyPackage.COLLECTION_JOURNAL_PAGE__REFERENCE_NUMBER:
				return REFERENCE_NUMBER_EDEFAULT == null ? referenceNumber != null : !REFERENCE_NUMBER_EDEFAULT.equals(referenceNumber);
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE:
				return JOURNAL_DATE_EDEFAULT == null ? journalDate != null : !JOURNAL_DATE_EDEFAULT.equals(journalDate);
			case DairyPackage.COLLECTION_JOURNAL_PAGE__STATUS:
				return status != STATUS_EDEFAULT;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__SESSION:
				return session != SESSION_EDEFAULT;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__DRIVER:
				return driver != null;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__ROUTE:
				return route != null;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__VEHICLE:
				return vehicle != null;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__DRIVER_TOTAL:
				return DRIVER_TOTAL_EDEFAULT == null ? driverTotal != null : !DRIVER_TOTAL_EDEFAULT.equals(driverTotal);
			case DairyPackage.COLLECTION_JOURNAL_PAGE__RECORD_TOTAL:
				return RECORD_TOTAL_EDEFAULT == null ? recordTotal != null : !RECORD_TOTAL_EDEFAULT.equals(recordTotal);
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_ENTRIES:
				return journalEntries != null && !journalEntries.isEmpty();
			case DairyPackage.COLLECTION_JOURNAL_PAGE__SUSPENDED:
				return suspended != SUSPENDED_EDEFAULT;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__ENTRY_COUNT:
				return entryCount != ENTRY_COUNT_EDEFAULT;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__SUSPENDED_COUNT:
				return suspendedCount != SUSPENDED_COUNT_EDEFAULT;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__REJECTED_COUNT:
				return rejectedCount != REJECTED_COUNT_EDEFAULT;
			case DairyPackage.COLLECTION_JOURNAL_PAGE__JOURNAL_NUMBER:
				return JOURNAL_NUMBER_EDEFAULT == null ? journalNumber != null : !JOURNAL_NUMBER_EDEFAULT.equals(journalNumber);
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
		result.append(" (journalId: ");
		result.append(journalId);
		result.append(", referenceNumber: ");
		result.append(referenceNumber);
		result.append(", journalDate: ");
		result.append(journalDate);
		result.append(", status: ");
		result.append(status);
		result.append(", session: ");
		result.append(session);
		result.append(", driverTotal: ");
		result.append(driverTotal);
		result.append(", recordTotal: ");
		result.append(recordTotal);
		result.append(", suspended: ");
		result.append(suspended);
		result.append(", entryCount: ");
		result.append(entryCount);
		result.append(", suspendedCount: ");
		result.append(suspendedCount);
		result.append(", rejectedCount: ");
		result.append(rejectedCount);
		result.append(", journalNumber: ");
		result.append(journalNumber);
		result.append(')');
		return result.toString();
	}

} //CollectionJournalPageImpl
