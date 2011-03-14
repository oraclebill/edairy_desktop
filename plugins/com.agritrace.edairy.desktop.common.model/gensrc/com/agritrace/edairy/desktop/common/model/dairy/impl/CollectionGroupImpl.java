/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroupType;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
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
 * An implementation of the model object '<em><b>Collection Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getCollectionDate <em>Collection Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getDriver <em>Driver</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getVehicle <em>Vehicle</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getDriverTotal <em>Driver Total</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getRecordTotal <em>Record Total</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getEntries <em>Entries</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#isSuspended <em>Suspended</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getEntryCount <em>Entry Count</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getSuspendedCount <em>Suspended Count</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getRejectedCount <em>Rejected Count</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getJournalNumber <em>Journal Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getSession <em>Session</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getCollectionCenter <em>Collection Center</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionGroupImpl extends EObjectImpl implements CollectionGroup {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final Long ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Long id = ID_EDEFAULT;

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
	 * The default value of the '{@link #getCollectionDate() <em>Collection Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date COLLECTION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCollectionDate() <em>Collection Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionDate()
	 * @generated
	 * @ordered
	 */
	protected Date collectionDate = COLLECTION_DATE_EDEFAULT;

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
	 * The cached value of the '{@link #getDriver() <em>Driver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriver()
	 * @generated
	 * @ordered
	 */
	protected Employee driver;

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
	 * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntries()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionJournalLine> entries;

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
	 * The cached value of the '{@link #getSession() <em>Session</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSession()
	 * @generated
	 * @ordered
	 */
	protected CollectionSession session;

	/**
	 * The cached value of the '{@link #getCollectionCenter() <em>Collection Center</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionCenter()
	 * @generated
	 * @ordered
	 */
	protected DairyLocation collectionCenter;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final CollectionGroupType TYPE_EDEFAULT = CollectionGroupType.SCALE_GROUP;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected CollectionGroupType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.COLLECTION_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(Long newId)
	{
		Long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__REFERENCE_NUMBER, oldReferenceNumber, referenceNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCollectionDate()
	{
		return collectionDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollectionDate(Date newCollectionDate)
	{
		Date oldCollectionDate = collectionDate;
		collectionDate = newCollectionDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__COLLECTION_DATE, oldCollectionDate, collectionDate));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getDriver() {
		if (driver != null && driver.eIsProxy())
		{
			InternalEObject oldDriver = (InternalEObject)driver;
			driver = (Employee)eResolveProxy(oldDriver);
			if (driver != oldDriver)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_GROUP__DRIVER, oldDriver, driver));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__DRIVER, oldDriver, driver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle getVehicle() {
		if (vehicle != null && vehicle.eIsProxy())
		{
			InternalEObject oldVehicle = (InternalEObject)vehicle;
			vehicle = (Vehicle)eResolveProxy(oldVehicle);
			if (vehicle != oldVehicle)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_GROUP__VEHICLE, oldVehicle, vehicle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__VEHICLE, oldVehicle, vehicle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__DRIVER_TOTAL, oldDriverTotal, driverTotal));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__RECORD_TOTAL, oldRecordTotal, recordTotal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CollectionJournalLine> getEntries()
	{
		if (entries == null)
		{
			entries = new EObjectContainmentWithInverseEList<CollectionJournalLine>(CollectionJournalLine.class, this, DairyPackage.COLLECTION_GROUP__ENTRIES, DairyPackage.COLLECTION_JOURNAL_LINE__GROUP);
		}
		return entries;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__SUSPENDED, oldSuspended, suspended));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__ENTRY_COUNT, oldEntryCount, entryCount));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__SUSPENDED_COUNT, oldSuspendedCount, suspendedCount));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__REJECTED_COUNT, oldRejectedCount, rejectedCount));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__JOURNAL_NUMBER, oldJournalNumber, journalNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionSession getSession() {
		if (session != null && session.eIsProxy())
		{
			InternalEObject oldSession = (InternalEObject)session;
			session = (CollectionSession)eResolveProxy(oldSession);
			if (session != oldSession)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_GROUP__SESSION, oldSession, session));
			}
		}
		return session;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionSession basicGetSession() {
		return session;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSession(CollectionSession newSession) {
		CollectionSession oldSession = session;
		session = newSession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__SESSION, oldSession, session));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyLocation getCollectionCenter() {
		if (collectionCenter != null && collectionCenter.eIsProxy())
		{
			InternalEObject oldCollectionCenter = (InternalEObject)collectionCenter;
			collectionCenter = (DairyLocation)eResolveProxy(oldCollectionCenter);
			if (collectionCenter != oldCollectionCenter)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_GROUP__COLLECTION_CENTER, oldCollectionCenter, collectionCenter));
			}
		}
		return collectionCenter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyLocation basicGetCollectionCenter() {
		return collectionCenter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollectionCenter(DairyLocation newCollectionCenter) {
		DairyLocation oldCollectionCenter = collectionCenter;
		collectionCenter = newCollectionCenter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__COLLECTION_CENTER, oldCollectionCenter, collectionCenter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionGroupType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(CollectionGroupType newType) {
		CollectionGroupType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_GROUP__TYPE, oldType, type));
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
			case DairyPackage.COLLECTION_GROUP__ENTRIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEntries()).basicAdd(otherEnd, msgs);
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
			case DairyPackage.COLLECTION_GROUP__ENTRIES:
				return ((InternalEList<?>)getEntries()).basicRemove(otherEnd, msgs);
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
			case DairyPackage.COLLECTION_GROUP__ID:
				return getId();
			case DairyPackage.COLLECTION_GROUP__REFERENCE_NUMBER:
				return getReferenceNumber();
			case DairyPackage.COLLECTION_GROUP__COLLECTION_DATE:
				return getCollectionDate();
			case DairyPackage.COLLECTION_GROUP__STATUS:
				return getStatus();
			case DairyPackage.COLLECTION_GROUP__DRIVER:
				if (resolve) return getDriver();
				return basicGetDriver();
			case DairyPackage.COLLECTION_GROUP__VEHICLE:
				if (resolve) return getVehicle();
				return basicGetVehicle();
			case DairyPackage.COLLECTION_GROUP__DRIVER_TOTAL:
				return getDriverTotal();
			case DairyPackage.COLLECTION_GROUP__RECORD_TOTAL:
				return getRecordTotal();
			case DairyPackage.COLLECTION_GROUP__ENTRIES:
				return getEntries();
			case DairyPackage.COLLECTION_GROUP__SUSPENDED:
				return isSuspended();
			case DairyPackage.COLLECTION_GROUP__ENTRY_COUNT:
				return getEntryCount();
			case DairyPackage.COLLECTION_GROUP__SUSPENDED_COUNT:
				return getSuspendedCount();
			case DairyPackage.COLLECTION_GROUP__REJECTED_COUNT:
				return getRejectedCount();
			case DairyPackage.COLLECTION_GROUP__JOURNAL_NUMBER:
				return getJournalNumber();
			case DairyPackage.COLLECTION_GROUP__SESSION:
				if (resolve) return getSession();
				return basicGetSession();
			case DairyPackage.COLLECTION_GROUP__COLLECTION_CENTER:
				if (resolve) return getCollectionCenter();
				return basicGetCollectionCenter();
			case DairyPackage.COLLECTION_GROUP__TYPE:
				return getType();
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
			case DairyPackage.COLLECTION_GROUP__ID:
				setId((Long)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__REFERENCE_NUMBER:
				setReferenceNumber((String)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__COLLECTION_DATE:
				setCollectionDate((Date)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__STATUS:
				setStatus((JournalStatus)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__DRIVER:
				setDriver((Employee)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__VEHICLE:
				setVehicle((Vehicle)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__DRIVER_TOTAL:
				setDriverTotal((BigDecimal)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__RECORD_TOTAL:
				setRecordTotal((BigDecimal)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__ENTRIES:
				getEntries().clear();
				getEntries().addAll((Collection<? extends CollectionJournalLine>)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__SUSPENDED:
				setSuspended((Boolean)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__ENTRY_COUNT:
				setEntryCount((Integer)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__SUSPENDED_COUNT:
				setSuspendedCount((Integer)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__REJECTED_COUNT:
				setRejectedCount((Integer)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__JOURNAL_NUMBER:
				setJournalNumber((String)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__SESSION:
				setSession((CollectionSession)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__COLLECTION_CENTER:
				setCollectionCenter((DairyLocation)newValue);
				return;
			case DairyPackage.COLLECTION_GROUP__TYPE:
				setType((CollectionGroupType)newValue);
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
			case DairyPackage.COLLECTION_GROUP__ID:
				setId(ID_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_GROUP__REFERENCE_NUMBER:
				setReferenceNumber(REFERENCE_NUMBER_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_GROUP__COLLECTION_DATE:
				setCollectionDate(COLLECTION_DATE_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_GROUP__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_GROUP__DRIVER:
				setDriver((Employee)null);
				return;
			case DairyPackage.COLLECTION_GROUP__VEHICLE:
				setVehicle((Vehicle)null);
				return;
			case DairyPackage.COLLECTION_GROUP__DRIVER_TOTAL:
				setDriverTotal(DRIVER_TOTAL_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_GROUP__RECORD_TOTAL:
				setRecordTotal(RECORD_TOTAL_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_GROUP__ENTRIES:
				getEntries().clear();
				return;
			case DairyPackage.COLLECTION_GROUP__SUSPENDED:
				setSuspended(SUSPENDED_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_GROUP__ENTRY_COUNT:
				setEntryCount(ENTRY_COUNT_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_GROUP__SUSPENDED_COUNT:
				setSuspendedCount(SUSPENDED_COUNT_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_GROUP__REJECTED_COUNT:
				setRejectedCount(REJECTED_COUNT_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_GROUP__JOURNAL_NUMBER:
				setJournalNumber(JOURNAL_NUMBER_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_GROUP__SESSION:
				setSession((CollectionSession)null);
				return;
			case DairyPackage.COLLECTION_GROUP__COLLECTION_CENTER:
				setCollectionCenter((DairyLocation)null);
				return;
			case DairyPackage.COLLECTION_GROUP__TYPE:
				setType(TYPE_EDEFAULT);
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
			case DairyPackage.COLLECTION_GROUP__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case DairyPackage.COLLECTION_GROUP__REFERENCE_NUMBER:
				return REFERENCE_NUMBER_EDEFAULT == null ? referenceNumber != null : !REFERENCE_NUMBER_EDEFAULT.equals(referenceNumber);
			case DairyPackage.COLLECTION_GROUP__COLLECTION_DATE:
				return COLLECTION_DATE_EDEFAULT == null ? collectionDate != null : !COLLECTION_DATE_EDEFAULT.equals(collectionDate);
			case DairyPackage.COLLECTION_GROUP__STATUS:
				return status != STATUS_EDEFAULT;
			case DairyPackage.COLLECTION_GROUP__DRIVER:
				return driver != null;
			case DairyPackage.COLLECTION_GROUP__VEHICLE:
				return vehicle != null;
			case DairyPackage.COLLECTION_GROUP__DRIVER_TOTAL:
				return DRIVER_TOTAL_EDEFAULT == null ? driverTotal != null : !DRIVER_TOTAL_EDEFAULT.equals(driverTotal);
			case DairyPackage.COLLECTION_GROUP__RECORD_TOTAL:
				return RECORD_TOTAL_EDEFAULT == null ? recordTotal != null : !RECORD_TOTAL_EDEFAULT.equals(recordTotal);
			case DairyPackage.COLLECTION_GROUP__ENTRIES:
				return entries != null && !entries.isEmpty();
			case DairyPackage.COLLECTION_GROUP__SUSPENDED:
				return suspended != SUSPENDED_EDEFAULT;
			case DairyPackage.COLLECTION_GROUP__ENTRY_COUNT:
				return entryCount != ENTRY_COUNT_EDEFAULT;
			case DairyPackage.COLLECTION_GROUP__SUSPENDED_COUNT:
				return suspendedCount != SUSPENDED_COUNT_EDEFAULT;
			case DairyPackage.COLLECTION_GROUP__REJECTED_COUNT:
				return rejectedCount != REJECTED_COUNT_EDEFAULT;
			case DairyPackage.COLLECTION_GROUP__JOURNAL_NUMBER:
				return JOURNAL_NUMBER_EDEFAULT == null ? journalNumber != null : !JOURNAL_NUMBER_EDEFAULT.equals(journalNumber);
			case DairyPackage.COLLECTION_GROUP__SESSION:
				return session != null;
			case DairyPackage.COLLECTION_GROUP__COLLECTION_CENTER:
				return collectionCenter != null;
			case DairyPackage.COLLECTION_GROUP__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", referenceNumber: ");
		result.append(referenceNumber);
		result.append(", collectionDate: ");
		result.append(collectionDate);
		result.append(", status: ");
		result.append(status);
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
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //CollectionGroupImpl
