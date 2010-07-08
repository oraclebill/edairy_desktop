/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delivery Journal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DeliveryJournalImpl#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DeliveryJournalImpl#getDate <em>Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DeliveryJournalImpl#getRoute <em>Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DeliveryJournalImpl#getSession <em>Session</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DeliveryJournalImpl#getCustomer <em>Customer</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DeliveryJournalImpl#getDriver <em>Driver</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DeliveryJournalImpl#getVehicle <em>Vehicle</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DeliveryJournalImpl#getLines <em>Lines</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DeliveryJournalImpl#getTotal <em>Total</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeliveryJournalImpl extends EObjectImpl implements DeliveryJournal {
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
	 * The cached value of the '{@link #getRoute() <em>Route</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoute()
	 * @generated
	 * @ordered
	 */
	protected Route route;

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
	 * The cached value of the '{@link #getCustomer() <em>Customer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomer()
	 * @generated
	 * @ordered
	 */
	protected Customer customer;

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
	 * The cached value of the '{@link #getLines() <em>Lines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLines()
	 * @generated
	 * @ordered
	 */
	protected EList<DeliveryJournalLine> lines;

	/**
	 * The default value of the '{@link #getTotal() <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotal()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal TOTAL_EDEFAULT = null;

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
	protected DeliveryJournalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.DELIVERY_JOURNAL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DELIVERY_JOURNAL__REFERENCE_NUMBER, oldReferenceNumber, referenceNumber));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DELIVERY_JOURNAL__DATE, oldDate, date));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.DELIVERY_JOURNAL__ROUTE, oldRoute, route));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DELIVERY_JOURNAL__ROUTE, oldRoute, route));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DELIVERY_JOURNAL__SESSION, oldSession, session));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer getCustomer() {
		if (customer != null && customer.eIsProxy()) {
			InternalEObject oldCustomer = (InternalEObject)customer;
			customer = (Customer)eResolveProxy(oldCustomer);
			if (customer != oldCustomer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.DELIVERY_JOURNAL__CUSTOMER, oldCustomer, customer));
			}
		}
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer basicGetCustomer() {
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomer(Customer newCustomer) {
		Customer oldCustomer = customer;
		customer = newCustomer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DELIVERY_JOURNAL__CUSTOMER, oldCustomer, customer));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.DELIVERY_JOURNAL__DRIVER, oldDriver, driver));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DELIVERY_JOURNAL__DRIVER, oldDriver, driver));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.DELIVERY_JOURNAL__VEHICLE, oldVehicle, vehicle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DELIVERY_JOURNAL__VEHICLE, oldVehicle, vehicle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeliveryJournalLine> getLines() {
		if (lines == null) {
			lines = new EObjectResolvingEList<DeliveryJournalLine>(DeliveryJournalLine.class, this, DairyPackage.DELIVERY_JOURNAL__LINES);
		}
		return lines;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DELIVERY_JOURNAL__TOTAL, oldTotal, total));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.DELIVERY_JOURNAL__REFERENCE_NUMBER:
				return getReferenceNumber();
			case DairyPackage.DELIVERY_JOURNAL__DATE:
				return getDate();
			case DairyPackage.DELIVERY_JOURNAL__ROUTE:
				if (resolve) return getRoute();
				return basicGetRoute();
			case DairyPackage.DELIVERY_JOURNAL__SESSION:
				return getSession();
			case DairyPackage.DELIVERY_JOURNAL__CUSTOMER:
				if (resolve) return getCustomer();
				return basicGetCustomer();
			case DairyPackage.DELIVERY_JOURNAL__DRIVER:
				if (resolve) return getDriver();
				return basicGetDriver();
			case DairyPackage.DELIVERY_JOURNAL__VEHICLE:
				if (resolve) return getVehicle();
				return basicGetVehicle();
			case DairyPackage.DELIVERY_JOURNAL__LINES:
				return getLines();
			case DairyPackage.DELIVERY_JOURNAL__TOTAL:
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
			case DairyPackage.DELIVERY_JOURNAL__REFERENCE_NUMBER:
				setReferenceNumber((String)newValue);
				return;
			case DairyPackage.DELIVERY_JOURNAL__DATE:
				setDate((Date)newValue);
				return;
			case DairyPackage.DELIVERY_JOURNAL__ROUTE:
				setRoute((Route)newValue);
				return;
			case DairyPackage.DELIVERY_JOURNAL__SESSION:
				setSession((Session)newValue);
				return;
			case DairyPackage.DELIVERY_JOURNAL__CUSTOMER:
				setCustomer((Customer)newValue);
				return;
			case DairyPackage.DELIVERY_JOURNAL__DRIVER:
				setDriver((Employee)newValue);
				return;
			case DairyPackage.DELIVERY_JOURNAL__VEHICLE:
				setVehicle((Vehicle)newValue);
				return;
			case DairyPackage.DELIVERY_JOURNAL__LINES:
				getLines().clear();
				getLines().addAll((Collection<? extends DeliveryJournalLine>)newValue);
				return;
			case DairyPackage.DELIVERY_JOURNAL__TOTAL:
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
			case DairyPackage.DELIVERY_JOURNAL__REFERENCE_NUMBER:
				setReferenceNumber(REFERENCE_NUMBER_EDEFAULT);
				return;
			case DairyPackage.DELIVERY_JOURNAL__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case DairyPackage.DELIVERY_JOURNAL__ROUTE:
				setRoute((Route)null);
				return;
			case DairyPackage.DELIVERY_JOURNAL__SESSION:
				setSession(SESSION_EDEFAULT);
				return;
			case DairyPackage.DELIVERY_JOURNAL__CUSTOMER:
				setCustomer((Customer)null);
				return;
			case DairyPackage.DELIVERY_JOURNAL__DRIVER:
				setDriver((Employee)null);
				return;
			case DairyPackage.DELIVERY_JOURNAL__VEHICLE:
				setVehicle((Vehicle)null);
				return;
			case DairyPackage.DELIVERY_JOURNAL__LINES:
				getLines().clear();
				return;
			case DairyPackage.DELIVERY_JOURNAL__TOTAL:
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
			case DairyPackage.DELIVERY_JOURNAL__REFERENCE_NUMBER:
				return REFERENCE_NUMBER_EDEFAULT == null ? referenceNumber != null : !REFERENCE_NUMBER_EDEFAULT.equals(referenceNumber);
			case DairyPackage.DELIVERY_JOURNAL__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case DairyPackage.DELIVERY_JOURNAL__ROUTE:
				return route != null;
			case DairyPackage.DELIVERY_JOURNAL__SESSION:
				return session != SESSION_EDEFAULT;
			case DairyPackage.DELIVERY_JOURNAL__CUSTOMER:
				return customer != null;
			case DairyPackage.DELIVERY_JOURNAL__DRIVER:
				return driver != null;
			case DairyPackage.DELIVERY_JOURNAL__VEHICLE:
				return vehicle != null;
			case DairyPackage.DELIVERY_JOURNAL__LINES:
				return lines != null && !lines.isEmpty();
			case DairyPackage.DELIVERY_JOURNAL__TOTAL:
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
		result.append(", date: ");
		result.append(date);
		result.append(", session: ");
		result.append(session);
		result.append(", total: ");
		result.append(total);
		result.append(')');
		return result.toString();
	}

} //DeliveryJournalImpl
