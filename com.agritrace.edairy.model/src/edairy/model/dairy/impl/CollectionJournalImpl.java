/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model.dairy.impl;

import edairy.model.dairy.CollectionJournal;
import edairy.model.dairy.CollectionRecord;
import edairy.model.dairy.DairyPackage;
import edairy.model.dairy.Employee;
import edairy.model.dairy.RouteDefinition;
import edairy.model.dairy.Session;
import edairy.model.dairy.Vehicle;

import edairy.model.tracking.Container;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Journal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edairy.model.dairy.impl.CollectionJournalImpl#getJournalEntries <em>Journal Entries</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.CollectionJournalImpl#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.CollectionJournalImpl#getJournalDate <em>Journal Date</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.CollectionJournalImpl#getDriver <em>Driver</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.CollectionJournalImpl#getRoute <em>Route</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.CollectionJournalImpl#getSession <em>Session</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.CollectionJournalImpl#getCan <em>Can</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.CollectionJournalImpl#getBin <em>Bin</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.CollectionJournalImpl#getVehicle <em>Vehicle</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.CollectionJournalImpl#getDriverTotal <em>Driver Total</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.CollectionJournalImpl#getTotal <em>Total</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionJournalImpl extends EObjectImpl implements CollectionJournal {
	/**
	 * The cached value of the '{@link #getJournalEntries() <em>Journal Entries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJournalEntries()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionRecord> journalEntries;

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
	protected RouteDefinition route;

	/**
	 * The cached value of the '{@link #getSession() <em>Session</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSession()
	 * @generated
	 * @ordered
	 */
	protected Session session;

	/**
	 * The cached value of the '{@link #getCan() <em>Can</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCan()
	 * @generated
	 * @ordered
	 */
	protected Container can;

	/**
	 * The cached value of the '{@link #getBin() <em>Bin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBin()
	 * @generated
	 * @ordered
	 */
	protected Container bin;

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
	 * The default value of the '{@link #getTotal() <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotal()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal TOTAL_EDEFAULT = new BigDecimal("0");

	/**
	 * The cached value of the '{@link #getTotal() <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotal()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal total = TOTAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionJournalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.COLLECTION_JOURNAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CollectionRecord> getJournalEntries() {
		if (journalEntries == null) {
			journalEntries = new EObjectContainmentEList<CollectionRecord>(CollectionRecord.class, this, DairyPackage.COLLECTION_JOURNAL__JOURNAL_ENTRIES);
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__REFERENCE_NUMBER, oldReferenceNumber, referenceNumber));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__JOURNAL_DATE, oldJournalDate, journalDate));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL__DRIVER, oldDriver, driver));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__DRIVER, oldDriver, driver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouteDefinition getRoute() {
		if (route != null && route.eIsProxy()) {
			InternalEObject oldRoute = (InternalEObject)route;
			route = (RouteDefinition)eResolveProxy(oldRoute);
			if (route != oldRoute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL__ROUTE, oldRoute, route));
			}
		}
		return route;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouteDefinition basicGetRoute() {
		return route;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoute(RouteDefinition newRoute) {
		RouteDefinition oldRoute = route;
		route = newRoute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__ROUTE, oldRoute, route));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Session getSession() {
		if (session != null && session.eIsProxy()) {
			InternalEObject oldSession = (InternalEObject)session;
			session = (Session)eResolveProxy(oldSession);
			if (session != oldSession) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL__SESSION, oldSession, session));
			}
		}
		return session;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Session basicGetSession() {
		return session;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSession(Session newSession) {
		Session oldSession = session;
		session = newSession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__SESSION, oldSession, session));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container getCan() {
		if (can != null && can.eIsProxy()) {
			InternalEObject oldCan = (InternalEObject)can;
			can = (Container)eResolveProxy(oldCan);
			if (can != oldCan) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL__CAN, oldCan, can));
			}
		}
		return can;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container basicGetCan() {
		return can;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCan(Container newCan) {
		Container oldCan = can;
		can = newCan;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__CAN, oldCan, can));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container getBin() {
		if (bin != null && bin.eIsProxy()) {
			InternalEObject oldBin = (InternalEObject)bin;
			bin = (Container)eResolveProxy(oldBin);
			if (bin != oldBin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL__BIN, oldBin, bin));
			}
		}
		return bin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container basicGetBin() {
		return bin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBin(Container newBin) {
		Container oldBin = bin;
		bin = newBin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__BIN, oldBin, bin));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL__VEHICLE, oldVehicle, vehicle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__VEHICLE, oldVehicle, vehicle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__DRIVER_TOTAL, oldDriverTotal, driverTotal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotal(BigDecimal newTotal) {
		BigDecimal oldTotal = total;
		total = newTotal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL__TOTAL, oldTotal, total));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
			case DairyPackage.COLLECTION_JOURNAL__DRIVER:
				if (resolve) return getDriver();
				return basicGetDriver();
			case DairyPackage.COLLECTION_JOURNAL__ROUTE:
				if (resolve) return getRoute();
				return basicGetRoute();
			case DairyPackage.COLLECTION_JOURNAL__SESSION:
				if (resolve) return getSession();
				return basicGetSession();
			case DairyPackage.COLLECTION_JOURNAL__CAN:
				if (resolve) return getCan();
				return basicGetCan();
			case DairyPackage.COLLECTION_JOURNAL__BIN:
				if (resolve) return getBin();
				return basicGetBin();
			case DairyPackage.COLLECTION_JOURNAL__VEHICLE:
				if (resolve) return getVehicle();
				return basicGetVehicle();
			case DairyPackage.COLLECTION_JOURNAL__DRIVER_TOTAL:
				return getDriverTotal();
			case DairyPackage.COLLECTION_JOURNAL__TOTAL:
				return getTotal();
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
			case DairyPackage.COLLECTION_JOURNAL__JOURNAL_ENTRIES:
				getJournalEntries().clear();
				getJournalEntries().addAll((Collection<? extends CollectionRecord>)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__REFERENCE_NUMBER:
				setReferenceNumber((String)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__JOURNAL_DATE:
				setJournalDate((Date)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__DRIVER:
				setDriver((Employee)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__ROUTE:
				setRoute((RouteDefinition)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__SESSION:
				setSession((Session)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__CAN:
				setCan((Container)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__BIN:
				setBin((Container)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__VEHICLE:
				setVehicle((Vehicle)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__DRIVER_TOTAL:
				setDriverTotal((BigDecimal)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL__TOTAL:
				setTotal((BigDecimal)newValue);
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
			case DairyPackage.COLLECTION_JOURNAL__JOURNAL_ENTRIES:
				getJournalEntries().clear();
				return;
			case DairyPackage.COLLECTION_JOURNAL__REFERENCE_NUMBER:
				setReferenceNumber(REFERENCE_NUMBER_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL__JOURNAL_DATE:
				setJournalDate(JOURNAL_DATE_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL__DRIVER:
				setDriver((Employee)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL__ROUTE:
				setRoute((RouteDefinition)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL__SESSION:
				setSession((Session)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL__CAN:
				setCan((Container)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL__BIN:
				setBin((Container)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL__VEHICLE:
				setVehicle((Vehicle)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL__DRIVER_TOTAL:
				setDriverTotal(DRIVER_TOTAL_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL__TOTAL:
				setTotal(TOTAL_EDEFAULT);
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
			case DairyPackage.COLLECTION_JOURNAL__JOURNAL_ENTRIES:
				return journalEntries != null && !journalEntries.isEmpty();
			case DairyPackage.COLLECTION_JOURNAL__REFERENCE_NUMBER:
				return REFERENCE_NUMBER_EDEFAULT == null ? referenceNumber != null : !REFERENCE_NUMBER_EDEFAULT.equals(referenceNumber);
			case DairyPackage.COLLECTION_JOURNAL__JOURNAL_DATE:
				return JOURNAL_DATE_EDEFAULT == null ? journalDate != null : !JOURNAL_DATE_EDEFAULT.equals(journalDate);
			case DairyPackage.COLLECTION_JOURNAL__DRIVER:
				return driver != null;
			case DairyPackage.COLLECTION_JOURNAL__ROUTE:
				return route != null;
			case DairyPackage.COLLECTION_JOURNAL__SESSION:
				return session != null;
			case DairyPackage.COLLECTION_JOURNAL__CAN:
				return can != null;
			case DairyPackage.COLLECTION_JOURNAL__BIN:
				return bin != null;
			case DairyPackage.COLLECTION_JOURNAL__VEHICLE:
				return vehicle != null;
			case DairyPackage.COLLECTION_JOURNAL__DRIVER_TOTAL:
				return DRIVER_TOTAL_EDEFAULT == null ? driverTotal != null : !DRIVER_TOTAL_EDEFAULT.equals(driverTotal);
			case DairyPackage.COLLECTION_JOURNAL__TOTAL:
				return TOTAL_EDEFAULT == null ? total != null : !TOTAL_EDEFAULT.equals(total);
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
		result.append(" (referenceNumber: ");
		result.append(referenceNumber);
		result.append(", journalDate: ");
		result.append(journalDate);
		result.append(", driverTotal: ");
		result.append(driverTotal);
		result.append(", total: ");
		result.append(total);
		result.append(')');
		return result.toString();
	}

} //CollectionJournalImpl
