/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.impl;

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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.agritrace.edairy.model.dairy.CollectionJournal;
import com.agritrace.edairy.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.model.dairy.DairyContainer;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Employee;
import com.agritrace.edairy.model.dairy.Route;
import com.agritrace.edairy.model.dairy.Session;
import com.agritrace.edairy.model.dairy.Vehicle;
import com.agritrace.edairy.model.tracking.Container;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Collection Journal</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionJournalImpl#getJournalEntries <em>Journal Entries</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionJournalImpl#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionJournalImpl#getJournalDate <em>Journal Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionJournalImpl#getSession <em>Session</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionJournalImpl#getDriver <em>Driver</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionJournalImpl#getRoute <em>Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionJournalImpl#getFarmContainer <em>Farm Container</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionJournalImpl#getBin <em>Bin</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionJournalImpl#getVehicle <em>Vehicle</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionJournalImpl#getDriverTotal <em>Driver Total</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.CollectionJournalImpl#getRecordTotal <em>Record Total</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionJournalImpl extends EObjectImpl implements CollectionJournal {
    /**
     * The cached value of the '{@link #getJournalEntries()
     * <em>Journal Entries</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getJournalEntries()
     * @generated
     * @ordered
     */
    protected EList<CollectionJournalLine> journalEntries;

    /**
	 * The default value of the '{@link #getReferenceNumber() <em>Reference Number</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getReferenceNumber()
	 * @generated
	 * @ordered
	 */
    protected static final String REFERENCE_NUMBER_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getReferenceNumber() <em>Reference Number</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getReferenceNumber()
	 * @generated
	 * @ordered
	 */
    protected String referenceNumber = REFERENCE_NUMBER_EDEFAULT;

    /**
	 * The default value of the '{@link #getJournalDate() <em>Journal Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getJournalDate()
	 * @generated
	 * @ordered
	 */
    protected static final Date JOURNAL_DATE_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getJournalDate() <em>Journal Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getJournalDate()
	 * @generated
	 * @ordered
	 */
    protected Date journalDate = JOURNAL_DATE_EDEFAULT;

    /**
	 * The default value of the '{@link #getSession() <em>Session</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSession()
	 * @generated
	 * @ordered
	 */
    protected static final Session SESSION_EDEFAULT = Session.EARLY_MORNING;

    /**
	 * The cached value of the '{@link #getSession() <em>Session</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSession()
	 * @generated
	 * @ordered
	 */
    protected Session session = SESSION_EDEFAULT;

    /**
	 * The cached value of the '{@link #getDriver() <em>Driver</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDriver()
	 * @generated
	 * @ordered
	 */
    protected Employee driver;

    /**
	 * The cached value of the '{@link #getRoute() <em>Route</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRoute()
	 * @generated
	 * @ordered
	 */
    protected Route route;

    /**
	 * The cached value of the '{@link #getFarmContainer() <em>Farm Container</em>}' reference.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getFarmContainer()
	 * @generated
	 * @ordered
	 */
    protected Container farmContainer;

    /**
     * The cached value of the '{@link #getBin() <em>Bin</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getBin()
     * @generated
     * @ordered
     */
    protected DairyContainer bin;

    /**
	 * The cached value of the '{@link #getVehicle() <em>Vehicle</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVehicle()
	 * @generated
	 * @ordered
	 */
    protected Vehicle vehicle;

    /**
	 * The default value of the '{@link #getDriverTotal() <em>Driver Total</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDriverTotal()
	 * @generated
	 * @ordered
	 */
    protected static final BigDecimal DRIVER_TOTAL_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getDriverTotal() <em>Driver Total</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDriverTotal()
	 * @generated
	 * @ordered
	 */
    protected BigDecimal driverTotal = DRIVER_TOTAL_EDEFAULT;

    /**
	 * The default value of the '{@link #getRecordTotal() <em>Record Total</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRecordTotal()
	 * @generated
	 * @ordered
	 */
    protected static final BigDecimal RECORD_TOTAL_EDEFAULT = new BigDecimal("0");

    /**
	 * The cached value of the '{@link #getRecordTotal() <em>Record Total</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRecordTotal()
	 * @generated
	 * @ordered
	 */
    protected BigDecimal recordTotal = RECORD_TOTAL_EDEFAULT;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected CollectionJournalImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return DairyPackage.Literals.COLLECTION_JOURNAL;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EList<CollectionJournalLine> getJournalEntries() {
		if (journalEntries == null) {
			journalEntries = new EObjectContainmentEList<CollectionJournalLine>(CollectionJournalLine.class, this, DairyPackage.COLLECTION_JOURNAL__JOURNAL_ENTRIES);
		}
		return journalEntries;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String getReferenceNumber() {
		return referenceNumber;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void setReferenceNumber(String newReferenceNumber) {
		String oldReferenceNumber = referenceNumber;
		referenceNumber = newReferenceNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__REFERENCE_NUMBER, oldReferenceNumber, referenceNumber));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Date getJournalDate() {
		return journalDate;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void setJournalDate(Date newJournalDate) {
		Date oldJournalDate = journalDate;
		journalDate = newJournalDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__JOURNAL_DATE, oldJournalDate, journalDate));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Session getSession() {
		return session;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void setSession(Session newSession) {
		Session oldSession = session;
		session = newSession == null ? SESSION_EDEFAULT : newSession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__SESSION, oldSession, session));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Employee getDriver() {
		if (driver != null && driver.eIsProxy()) {
			InternalEObject oldDriver = (InternalEObject)driver;
			driver = (Employee)eResolveProxy(oldDriver);
			if (driver != oldDriver) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL__DRIVER, oldDriver, driver));
			}
		}
		return driver;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public Employee basicGetDriver() {
		return driver;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void setDriver(Employee newDriver) {
		Employee oldDriver = driver;
		driver = newDriver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__DRIVER, oldDriver, driver));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Route getRoute() {
		if (route != null && route.eIsProxy()) {
			InternalEObject oldRoute = (InternalEObject)route;
			route = (Route)eResolveProxy(oldRoute);
			if (route != oldRoute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL__ROUTE, oldRoute, route));
			}
		}
		return route;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public Route basicGetRoute() {
		return route;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void setRoute(Route newRoute) {
		Route oldRoute = route;
		route = newRoute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__ROUTE, oldRoute, route));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Container getFarmContainer() {
		if (farmContainer != null && farmContainer.eIsProxy()) {
			InternalEObject oldFarmContainer = (InternalEObject)farmContainer;
			farmContainer = (Container)eResolveProxy(oldFarmContainer);
			if (farmContainer != oldFarmContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL__FARM_CONTAINER, oldFarmContainer, farmContainer));
			}
		}
		return farmContainer;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public Container basicGetFarmContainer() {
		return farmContainer;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void setFarmContainer(Container newFarmContainer) {
		Container oldFarmContainer = farmContainer;
		farmContainer = newFarmContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__FARM_CONTAINER, oldFarmContainer, farmContainer));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public DairyContainer getBin() {
		if (bin != null && bin.eIsProxy()) {
			InternalEObject oldBin = (InternalEObject)bin;
			bin = (DairyContainer)eResolveProxy(oldBin);
			if (bin != oldBin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL__BIN, oldBin, bin));
			}
		}
		return bin;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public DairyContainer basicGetBin() {
		return bin;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void setBin(DairyContainer newBin) {
		DairyContainer oldBin = bin;
		bin = newBin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__BIN, oldBin, bin));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Vehicle getVehicle() {
		if (vehicle != null && vehicle.eIsProxy()) {
			InternalEObject oldVehicle = (InternalEObject)vehicle;
			vehicle = (Vehicle)eResolveProxy(oldVehicle);
			if (vehicle != oldVehicle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL__VEHICLE, oldVehicle, vehicle));
			}
		}
		return vehicle;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public Vehicle basicGetVehicle() {
		return vehicle;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void setVehicle(Vehicle newVehicle) {
		Vehicle oldVehicle = vehicle;
		vehicle = newVehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__VEHICLE, oldVehicle, vehicle));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public BigDecimal getDriverTotal() {
		return driverTotal;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void setDriverTotal(BigDecimal newDriverTotal) {
		BigDecimal oldDriverTotal = driverTotal;
		driverTotal = newDriverTotal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__DRIVER_TOTAL, oldDriverTotal, driverTotal));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public BigDecimal getRecordTotal() {
		return recordTotal;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void setRecordTotal(BigDecimal newRecordTotal) {
		BigDecimal oldRecordTotal = recordTotal;
		recordTotal = newRecordTotal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__RECORD_TOTAL, oldRecordTotal, recordTotal));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DairyPackage.COLLECTION_JOURNAL__JOURNAL_ENTRIES:
				return ((InternalEList<?>)getJournalEntries()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.COLLECTION_JOURNAL__JOURNAL_ENTRIES:
				return getJournalEntries();
			case DairyPackage.COLLECTION_JOURNAL__REFERENCE_NUMBER:
				return getReferenceNumber();
			case DairyPackage.COLLECTION_JOURNAL__JOURNAL_DATE:
				return getJournalDate();
			case DairyPackage.COLLECTION_JOURNAL__SESSION:
				return getSession();
			case DairyPackage.COLLECTION_JOURNAL__DRIVER:
				if (resolve) return getDriver();
				return basicGetDriver();
			case DairyPackage.COLLECTION_JOURNAL__ROUTE:
				if (resolve) return getRoute();
				return basicGetRoute();
			case DairyPackage.COLLECTION_JOURNAL__FARM_CONTAINER:
				if (resolve) return getFarmContainer();
				return basicGetFarmContainer();
			case DairyPackage.COLLECTION_JOURNAL__BIN:
				if (resolve) return getBin();
				return basicGetBin();
			case DairyPackage.COLLECTION_JOURNAL__VEHICLE:
				if (resolve) return getVehicle();
				return basicGetVehicle();
			case DairyPackage.COLLECTION_JOURNAL__DRIVER_TOTAL:
				return getDriverTotal();
			case DairyPackage.COLLECTION_JOURNAL__RECORD_TOTAL:
				return getRecordTotal();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DairyPackage.COLLECTION_JOURNAL__JOURNAL_ENTRIES:
				getJournalEntries().clear();
				getJournalEntries().addAll((Collection<? extends CollectionJournalLine>)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__REFERENCE_NUMBER:
				setReferenceNumber((String)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__JOURNAL_DATE:
				setJournalDate((Date)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__SESSION:
				setSession((Session)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__DRIVER:
				setDriver((Employee)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__ROUTE:
				setRoute((Route)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__FARM_CONTAINER:
				setFarmContainer((Container)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__BIN:
				setBin((DairyContainer)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__VEHICLE:
				setVehicle((Vehicle)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__DRIVER_TOTAL:
				setDriverTotal((BigDecimal)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__RECORD_TOTAL:
				setRecordTotal((BigDecimal)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eUnset(int featureID) {
		switch (featureID) {
			case DairyPackage.COLLECTION_JOURNAL__JOURNAL_ENTRIES:
				getJournalEntries().clear();
				return;
			case DairyPackage.COLLECTION_JOURNAL__REFERENCE_NUMBER:
				setReferenceNumber(REFERENCE_NUMBER_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL__JOURNAL_DATE:
				setJournalDate(JOURNAL_DATE_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL__SESSION:
				setSession(SESSION_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL__DRIVER:
				setDriver((Employee)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL__ROUTE:
				setRoute((Route)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL__FARM_CONTAINER:
				setFarmContainer((Container)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL__BIN:
				setBin((DairyContainer)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL__VEHICLE:
				setVehicle((Vehicle)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL__DRIVER_TOTAL:
				setDriverTotal(DRIVER_TOTAL_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL__RECORD_TOTAL:
				setRecordTotal(RECORD_TOTAL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DairyPackage.COLLECTION_JOURNAL__JOURNAL_ENTRIES:
				return journalEntries != null && !journalEntries.isEmpty();
			case DairyPackage.COLLECTION_JOURNAL__REFERENCE_NUMBER:
				return REFERENCE_NUMBER_EDEFAULT == null ? referenceNumber != null : !REFERENCE_NUMBER_EDEFAULT.equals(referenceNumber);
			case DairyPackage.COLLECTION_JOURNAL__JOURNAL_DATE:
				return JOURNAL_DATE_EDEFAULT == null ? journalDate != null : !JOURNAL_DATE_EDEFAULT.equals(journalDate);
			case DairyPackage.COLLECTION_JOURNAL__SESSION:
				return session != SESSION_EDEFAULT;
			case DairyPackage.COLLECTION_JOURNAL__DRIVER:
				return driver != null;
			case DairyPackage.COLLECTION_JOURNAL__ROUTE:
				return route != null;
			case DairyPackage.COLLECTION_JOURNAL__FARM_CONTAINER:
				return farmContainer != null;
			case DairyPackage.COLLECTION_JOURNAL__BIN:
				return bin != null;
			case DairyPackage.COLLECTION_JOURNAL__VEHICLE:
				return vehicle != null;
			case DairyPackage.COLLECTION_JOURNAL__DRIVER_TOTAL:
				return DRIVER_TOTAL_EDEFAULT == null ? driverTotal != null : !DRIVER_TOTAL_EDEFAULT.equals(driverTotal);
			case DairyPackage.COLLECTION_JOURNAL__RECORD_TOTAL:
				return RECORD_TOTAL_EDEFAULT == null ? recordTotal != null : !RECORD_TOTAL_EDEFAULT.equals(recordTotal);
		}
		return super.eIsSet(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (referenceNumber: ");
		result.append(referenceNumber);
		result.append(", journalDate: ");
		result.append(journalDate);
		result.append(", session: ");
		result.append(session);
		result.append(", driverTotal: ");
		result.append(driverTotal);
		result.append(", recordTotal: ");
		result.append(recordTotal);
		result.append(')');
		return result.toString();
	}

} // CollectionJournalImpl
