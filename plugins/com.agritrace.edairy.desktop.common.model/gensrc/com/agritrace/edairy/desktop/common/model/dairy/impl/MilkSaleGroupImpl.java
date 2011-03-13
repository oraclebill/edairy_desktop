/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.MilkSale;
import com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup;
import com.agritrace.edairy.desktop.common.model.dairy.TransportRoute;
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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Milk Sale Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleGroupImpl#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleGroupImpl#getDate <em>Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleGroupImpl#getRoute <em>Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleGroupImpl#getCustomer <em>Customer</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleGroupImpl#getDriver <em>Driver</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleGroupImpl#getVehicle <em>Vehicle</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleGroupImpl#getSales <em>Sales</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleGroupImpl#getTotal <em>Total</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleGroupImpl#getSession <em>Session</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleGroupImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MilkSaleGroupImpl extends EObjectImpl implements MilkSaleGroup
{
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
	protected TransportRoute route;

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
	 * The cached value of the '{@link #getSales() <em>Sales</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSales()
	 * @generated
	 * @ordered
	 */
	protected EList<MilkSale> sales;

	/**
	 * The default value of the '{@link #getTotal() <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotal()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal TOTAL_EDEFAULT = new BigDecimal("0.0");

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
	 * The cached value of the '{@link #getSession() <em>Session</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSession()
	 * @generated
	 * @ordered
	 */
	protected CollectionSession session;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MilkSaleGroupImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return DairyPackage.Literals.MILK_SALE_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReferenceNumber()
	{
		return referenceNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceNumber(String newReferenceNumber)
	{
		String oldReferenceNumber = referenceNumber;
		referenceNumber = newReferenceNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE_GROUP__REFERENCE_NUMBER, oldReferenceNumber, referenceNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate()
	{
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate)
	{
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE_GROUP__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransportRoute getRoute()
	{
		if (route != null && route.eIsProxy())
		{
			InternalEObject oldRoute = (InternalEObject)route;
			route = (TransportRoute)eResolveProxy(oldRoute);
			if (route != oldRoute)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MILK_SALE_GROUP__ROUTE, oldRoute, route));
			}
		}
		return route;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransportRoute basicGetRoute()
	{
		return route;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoute(TransportRoute newRoute)
	{
		TransportRoute oldRoute = route;
		route = newRoute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE_GROUP__ROUTE, oldRoute, route));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer getCustomer()
	{
		if (customer != null && customer.eIsProxy())
		{
			InternalEObject oldCustomer = (InternalEObject)customer;
			customer = (Customer)eResolveProxy(oldCustomer);
			if (customer != oldCustomer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MILK_SALE_GROUP__CUSTOMER, oldCustomer, customer));
			}
		}
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer basicGetCustomer()
	{
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomer(Customer newCustomer)
	{
		Customer oldCustomer = customer;
		customer = newCustomer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE_GROUP__CUSTOMER, oldCustomer, customer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getDriver()
	{
		if (driver != null && driver.eIsProxy())
		{
			InternalEObject oldDriver = (InternalEObject)driver;
			driver = (Employee)eResolveProxy(oldDriver);
			if (driver != oldDriver)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MILK_SALE_GROUP__DRIVER, oldDriver, driver));
			}
		}
		return driver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee basicGetDriver()
	{
		return driver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDriver(Employee newDriver)
	{
		Employee oldDriver = driver;
		driver = newDriver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE_GROUP__DRIVER, oldDriver, driver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle getVehicle()
	{
		if (vehicle != null && vehicle.eIsProxy())
		{
			InternalEObject oldVehicle = (InternalEObject)vehicle;
			vehicle = (Vehicle)eResolveProxy(oldVehicle);
			if (vehicle != oldVehicle)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MILK_SALE_GROUP__VEHICLE, oldVehicle, vehicle));
			}
		}
		return vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle basicGetVehicle()
	{
		return vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicle(Vehicle newVehicle)
	{
		Vehicle oldVehicle = vehicle;
		vehicle = newVehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE_GROUP__VEHICLE, oldVehicle, vehicle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MilkSale> getSales()
	{
		if (sales == null)
		{
			sales = new EObjectContainmentEList<MilkSale>(MilkSale.class, this, DairyPackage.MILK_SALE_GROUP__SALES);
		}
		return sales;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getTotal()
	{
		return total;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotal(BigDecimal newTotal)
	{
		BigDecimal oldTotal = total;
		total = newTotal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE_GROUP__TOTAL, oldTotal, total));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionSession getSession()
	{
		if (session != null && session.eIsProxy())
		{
			InternalEObject oldSession = (InternalEObject)session;
			session = (CollectionSession)eResolveProxy(oldSession);
			if (session != oldSession)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MILK_SALE_GROUP__SESSION, oldSession, session));
			}
		}
		return session;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionSession basicGetSession()
	{
		return session;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSession(CollectionSession newSession)
	{
		CollectionSession oldSession = session;
		session = newSession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE_GROUP__SESSION, oldSession, session));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE_GROUP__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case DairyPackage.MILK_SALE_GROUP__SALES:
				return ((InternalEList<?>)getSales()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case DairyPackage.MILK_SALE_GROUP__REFERENCE_NUMBER:
				return getReferenceNumber();
			case DairyPackage.MILK_SALE_GROUP__DATE:
				return getDate();
			case DairyPackage.MILK_SALE_GROUP__ROUTE:
				if (resolve) return getRoute();
				return basicGetRoute();
			case DairyPackage.MILK_SALE_GROUP__CUSTOMER:
				if (resolve) return getCustomer();
				return basicGetCustomer();
			case DairyPackage.MILK_SALE_GROUP__DRIVER:
				if (resolve) return getDriver();
				return basicGetDriver();
			case DairyPackage.MILK_SALE_GROUP__VEHICLE:
				if (resolve) return getVehicle();
				return basicGetVehicle();
			case DairyPackage.MILK_SALE_GROUP__SALES:
				return getSales();
			case DairyPackage.MILK_SALE_GROUP__TOTAL:
				return getTotal();
			case DairyPackage.MILK_SALE_GROUP__SESSION:
				if (resolve) return getSession();
				return basicGetSession();
			case DairyPackage.MILK_SALE_GROUP__ID:
				return getId();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case DairyPackage.MILK_SALE_GROUP__REFERENCE_NUMBER:
				setReferenceNumber((String)newValue);
				return;
			case DairyPackage.MILK_SALE_GROUP__DATE:
				setDate((Date)newValue);
				return;
			case DairyPackage.MILK_SALE_GROUP__ROUTE:
				setRoute((TransportRoute)newValue);
				return;
			case DairyPackage.MILK_SALE_GROUP__CUSTOMER:
				setCustomer((Customer)newValue);
				return;
			case DairyPackage.MILK_SALE_GROUP__DRIVER:
				setDriver((Employee)newValue);
				return;
			case DairyPackage.MILK_SALE_GROUP__VEHICLE:
				setVehicle((Vehicle)newValue);
				return;
			case DairyPackage.MILK_SALE_GROUP__SALES:
				getSales().clear();
				getSales().addAll((Collection<? extends MilkSale>)newValue);
				return;
			case DairyPackage.MILK_SALE_GROUP__TOTAL:
				setTotal((BigDecimal)newValue);
				return;
			case DairyPackage.MILK_SALE_GROUP__SESSION:
				setSession((CollectionSession)newValue);
				return;
			case DairyPackage.MILK_SALE_GROUP__ID:
				setId((Long)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case DairyPackage.MILK_SALE_GROUP__REFERENCE_NUMBER:
				setReferenceNumber(REFERENCE_NUMBER_EDEFAULT);
				return;
			case DairyPackage.MILK_SALE_GROUP__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case DairyPackage.MILK_SALE_GROUP__ROUTE:
				setRoute((TransportRoute)null);
				return;
			case DairyPackage.MILK_SALE_GROUP__CUSTOMER:
				setCustomer((Customer)null);
				return;
			case DairyPackage.MILK_SALE_GROUP__DRIVER:
				setDriver((Employee)null);
				return;
			case DairyPackage.MILK_SALE_GROUP__VEHICLE:
				setVehicle((Vehicle)null);
				return;
			case DairyPackage.MILK_SALE_GROUP__SALES:
				getSales().clear();
				return;
			case DairyPackage.MILK_SALE_GROUP__TOTAL:
				setTotal(TOTAL_EDEFAULT);
				return;
			case DairyPackage.MILK_SALE_GROUP__SESSION:
				setSession((CollectionSession)null);
				return;
			case DairyPackage.MILK_SALE_GROUP__ID:
				setId(ID_EDEFAULT);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case DairyPackage.MILK_SALE_GROUP__REFERENCE_NUMBER:
				return REFERENCE_NUMBER_EDEFAULT == null ? referenceNumber != null : !REFERENCE_NUMBER_EDEFAULT.equals(referenceNumber);
			case DairyPackage.MILK_SALE_GROUP__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case DairyPackage.MILK_SALE_GROUP__ROUTE:
				return route != null;
			case DairyPackage.MILK_SALE_GROUP__CUSTOMER:
				return customer != null;
			case DairyPackage.MILK_SALE_GROUP__DRIVER:
				return driver != null;
			case DairyPackage.MILK_SALE_GROUP__VEHICLE:
				return vehicle != null;
			case DairyPackage.MILK_SALE_GROUP__SALES:
				return sales != null && !sales.isEmpty();
			case DairyPackage.MILK_SALE_GROUP__TOTAL:
				return TOTAL_EDEFAULT == null ? total != null : !TOTAL_EDEFAULT.equals(total);
			case DairyPackage.MILK_SALE_GROUP__SESSION:
				return session != null;
			case DairyPackage.MILK_SALE_GROUP__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (referenceNumber: ");
		result.append(referenceNumber);
		result.append(", date: ");
		result.append(date);
		result.append(", total: ");
		result.append(total);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //MilkSaleGroupImpl
