/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.base.Location;

import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFunction;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.TransportRoute;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyLocationImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyLocationImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyLocationImpl#getDateOpened <em>Date Opened</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyLocationImpl#getPhone <em>Phone</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyLocationImpl#getRoute <em>Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyLocationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyLocationImpl#getCode <em>Code</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyLocationImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyLocationImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyLocationImpl#getContainers <em>Containers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DairyLocationImpl extends EObjectImpl implements DairyLocation {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final long ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected long id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDateOpened() <em>Date Opened</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateOpened()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_OPENED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateOpened() <em>Date Opened</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateOpened()
	 * @generated
	 * @ordered
	 */
	protected Date dateOpened = DATE_OPENED_EDEFAULT;

	/**
	 * The default value of the '{@link #getPhone() <em>Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhone()
	 * @generated
	 * @ordered
	 */
	protected static final String PHONE_EDEFAULT = "+254";

	/**
	 * The cached value of the '{@link #getPhone() <em>Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhone()
	 * @generated
	 * @ordered
	 */
	protected String phone = PHONE_EDEFAULT;

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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected static final String CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected String code = CODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected Location location;

	/**
	 * The cached value of the '{@link #getFunctions() <em>Functions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<DairyFunction> functions;

	/**
	 * The cached value of the '{@link #getContainers() <em>Containers</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainers()
	 * @generated
	 * @ordered
	 */
	protected Bin containers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DairyLocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.DAIRY_LOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(long newId) {
		long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_LOCATION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_LOCATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDateOpened() {
		return dateOpened;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateOpened(Date newDateOpened) {
		Date oldDateOpened = dateOpened;
		dateOpened = newDateOpened;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_LOCATION__DATE_OPENED, oldDateOpened, dateOpened));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhone(String newPhone) {
		String oldPhone = phone;
		phone = newPhone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_LOCATION__PHONE, oldPhone, phone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransportRoute getRoute() {
		if (route != null && route.eIsProxy())
		{
			InternalEObject oldRoute = (InternalEObject)route;
			route = (TransportRoute)eResolveProxy(oldRoute);
			if (route != oldRoute)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.DAIRY_LOCATION__ROUTE, oldRoute, route));
			}
		}
		return route;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransportRoute basicGetRoute() {
		return route;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoute(TransportRoute newRoute, NotificationChain msgs) {
		TransportRoute oldRoute = route;
		route = newRoute;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_LOCATION__ROUTE, oldRoute, newRoute);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoute(TransportRoute newRoute) {
		if (newRoute != route)
		{
			NotificationChain msgs = null;
			if (route != null)
				msgs = ((InternalEObject)route).eInverseRemove(this, DairyPackage.TRANSPORT_ROUTE__STOPS, TransportRoute.class, msgs);
			if (newRoute != null)
				msgs = ((InternalEObject)newRoute).eInverseAdd(this, DairyPackage.TRANSPORT_ROUTE__STOPS, TransportRoute.class, msgs);
			msgs = basicSetRoute(newRoute, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_LOCATION__ROUTE, newRoute, newRoute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_LOCATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCode() {
		return code;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCode(String newCode) {
		String oldCode = code;
		code = newCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_LOCATION__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocation(Location newLocation, NotificationChain msgs) {
		Location oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_LOCATION__LOCATION, oldLocation, newLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(Location newLocation) {
		if (newLocation != location)
		{
			NotificationChain msgs = null;
			if (location != null)
				msgs = ((InternalEObject)location).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DairyPackage.DAIRY_LOCATION__LOCATION, null, msgs);
			if (newLocation != null)
				msgs = ((InternalEObject)newLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DairyPackage.DAIRY_LOCATION__LOCATION, null, msgs);
			msgs = basicSetLocation(newLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_LOCATION__LOCATION, newLocation, newLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DairyFunction> getFunctions() {
		if (functions == null)
		{
			functions = new EDataTypeUniqueEList<DairyFunction>(DairyFunction.class, this, DairyPackage.DAIRY_LOCATION__FUNCTIONS);
		}
		return functions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bin getContainers() {
		if (containers != null && containers.eIsProxy())
		{
			InternalEObject oldContainers = (InternalEObject)containers;
			containers = (Bin)eResolveProxy(oldContainers);
			if (containers != oldContainers)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.DAIRY_LOCATION__CONTAINERS, oldContainers, containers));
			}
		}
		return containers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bin basicGetContainers() {
		return containers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainers(Bin newContainers) {
		Bin oldContainers = containers;
		containers = newContainers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_LOCATION__CONTAINERS, oldContainers, containers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case DairyPackage.DAIRY_LOCATION__ROUTE:
				if (route != null)
					msgs = ((InternalEObject)route).eInverseRemove(this, DairyPackage.TRANSPORT_ROUTE__STOPS, TransportRoute.class, msgs);
				return basicSetRoute((TransportRoute)otherEnd, msgs);
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
			case DairyPackage.DAIRY_LOCATION__ROUTE:
				return basicSetRoute(null, msgs);
			case DairyPackage.DAIRY_LOCATION__LOCATION:
				return basicSetLocation(null, msgs);
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
			case DairyPackage.DAIRY_LOCATION__ID:
				return getId();
			case DairyPackage.DAIRY_LOCATION__NAME:
				return getName();
			case DairyPackage.DAIRY_LOCATION__DATE_OPENED:
				return getDateOpened();
			case DairyPackage.DAIRY_LOCATION__PHONE:
				return getPhone();
			case DairyPackage.DAIRY_LOCATION__ROUTE:
				if (resolve) return getRoute();
				return basicGetRoute();
			case DairyPackage.DAIRY_LOCATION__DESCRIPTION:
				return getDescription();
			case DairyPackage.DAIRY_LOCATION__CODE:
				return getCode();
			case DairyPackage.DAIRY_LOCATION__LOCATION:
				return getLocation();
			case DairyPackage.DAIRY_LOCATION__FUNCTIONS:
				return getFunctions();
			case DairyPackage.DAIRY_LOCATION__CONTAINERS:
				if (resolve) return getContainers();
				return basicGetContainers();
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
			case DairyPackage.DAIRY_LOCATION__ID:
				setId((Long)newValue);
				return;
			case DairyPackage.DAIRY_LOCATION__NAME:
				setName((String)newValue);
				return;
			case DairyPackage.DAIRY_LOCATION__DATE_OPENED:
				setDateOpened((Date)newValue);
				return;
			case DairyPackage.DAIRY_LOCATION__PHONE:
				setPhone((String)newValue);
				return;
			case DairyPackage.DAIRY_LOCATION__ROUTE:
				setRoute((TransportRoute)newValue);
				return;
			case DairyPackage.DAIRY_LOCATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case DairyPackage.DAIRY_LOCATION__CODE:
				setCode((String)newValue);
				return;
			case DairyPackage.DAIRY_LOCATION__LOCATION:
				setLocation((Location)newValue);
				return;
			case DairyPackage.DAIRY_LOCATION__FUNCTIONS:
				getFunctions().clear();
				getFunctions().addAll((Collection<? extends DairyFunction>)newValue);
				return;
			case DairyPackage.DAIRY_LOCATION__CONTAINERS:
				setContainers((Bin)newValue);
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
			case DairyPackage.DAIRY_LOCATION__ID:
				setId(ID_EDEFAULT);
				return;
			case DairyPackage.DAIRY_LOCATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DairyPackage.DAIRY_LOCATION__DATE_OPENED:
				setDateOpened(DATE_OPENED_EDEFAULT);
				return;
			case DairyPackage.DAIRY_LOCATION__PHONE:
				setPhone(PHONE_EDEFAULT);
				return;
			case DairyPackage.DAIRY_LOCATION__ROUTE:
				setRoute((TransportRoute)null);
				return;
			case DairyPackage.DAIRY_LOCATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case DairyPackage.DAIRY_LOCATION__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case DairyPackage.DAIRY_LOCATION__LOCATION:
				setLocation((Location)null);
				return;
			case DairyPackage.DAIRY_LOCATION__FUNCTIONS:
				getFunctions().clear();
				return;
			case DairyPackage.DAIRY_LOCATION__CONTAINERS:
				setContainers((Bin)null);
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
			case DairyPackage.DAIRY_LOCATION__ID:
				return id != ID_EDEFAULT;
			case DairyPackage.DAIRY_LOCATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DairyPackage.DAIRY_LOCATION__DATE_OPENED:
				return DATE_OPENED_EDEFAULT == null ? dateOpened != null : !DATE_OPENED_EDEFAULT.equals(dateOpened);
			case DairyPackage.DAIRY_LOCATION__PHONE:
				return PHONE_EDEFAULT == null ? phone != null : !PHONE_EDEFAULT.equals(phone);
			case DairyPackage.DAIRY_LOCATION__ROUTE:
				return route != null;
			case DairyPackage.DAIRY_LOCATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case DairyPackage.DAIRY_LOCATION__CODE:
				return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
			case DairyPackage.DAIRY_LOCATION__LOCATION:
				return location != null;
			case DairyPackage.DAIRY_LOCATION__FUNCTIONS:
				return functions != null && !functions.isEmpty();
			case DairyPackage.DAIRY_LOCATION__CONTAINERS:
				return containers != null;
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
		result.append(" (Id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", dateOpened: ");
		result.append(dateOpened);
		result.append(", phone: ");
		result.append(phone);
		result.append(", description: ");
		result.append(description);
		result.append(", code: ");
		result.append(code);
		result.append(", functions: ");
		result.append(functions);
		result.append(')');
		return result.toString();
	}

} //DairyLocationImpl
