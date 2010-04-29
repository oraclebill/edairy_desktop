/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.services.impl;

import com.agritrace.edairy.model.dairy.Employee;
import com.agritrace.edairy.model.dairy.RouteDefinition;
import com.agritrace.edairy.model.dairy.Session;
import com.agritrace.edairy.model.dairy.Vehicle;

import com.agritrace.edairy.model.tracking.Container;

import com.agritrace.edairy.services.DairyService;
import com.agritrace.edairy.services.ServicesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dairy Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.services.impl.DairyServiceImpl#getRoutes <em>Routes</em>}</li>
 *   <li>{@link com.agritrace.edairy.services.impl.DairyServiceImpl#getSessions <em>Sessions</em>}</li>
 *   <li>{@link com.agritrace.edairy.services.impl.DairyServiceImpl#getVehicles <em>Vehicles</em>}</li>
 *   <li>{@link com.agritrace.edairy.services.impl.DairyServiceImpl#getEmployees <em>Employees</em>}</li>
 *   <li>{@link com.agritrace.edairy.services.impl.DairyServiceImpl#getContainers <em>Containers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DairyServiceImpl extends EObjectImpl implements DairyService {
	/**
	 * The cached value of the '{@link #getRoutes() <em>Routes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutes()
	 * @generated
	 * @ordered
	 */
	protected EList<RouteDefinition> routes;

	/**
	 * The cached value of the '{@link #getSessions() <em>Sessions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSessions()
	 * @generated
	 * @ordered
	 */
	protected EList<Session> sessions;

	/**
	 * The cached value of the '{@link #getVehicles() <em>Vehicles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicles()
	 * @generated
	 * @ordered
	 */
	protected EList<Vehicle> vehicles;

	/**
	 * The cached value of the '{@link #getEmployees() <em>Employees</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployees()
	 * @generated
	 * @ordered
	 */
	protected EList<Employee> employees;

	/**
	 * The cached value of the '{@link #getContainers() <em>Containers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainers()
	 * @generated
	 * @ordered
	 */
	protected EList<Container> containers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DairyServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicesPackage.Literals.DAIRY_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RouteDefinition> getRoutes() {
		return routes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoutes(EList<RouteDefinition> newRoutes) {
		EList<RouteDefinition> oldRoutes = routes;
		routes = newRoutes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.DAIRY_SERVICE__ROUTES, oldRoutes, routes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Session> getSessions() {
		return sessions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSessions(EList<Session> newSessions) {
		EList<Session> oldSessions = sessions;
		sessions = newSessions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.DAIRY_SERVICE__SESSIONS, oldSessions, sessions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicles(EList<Vehicle> newVehicles) {
		EList<Vehicle> oldVehicles = vehicles;
		vehicles = newVehicles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.DAIRY_SERVICE__VEHICLES, oldVehicles, vehicles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Employee> getEmployees() {
		return employees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmployees(EList<Employee> newEmployees) {
		EList<Employee> oldEmployees = employees;
		employees = newEmployees;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.DAIRY_SERVICE__EMPLOYEES, oldEmployees, employees));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Container> getContainers() {
		return containers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainers(EList<Container> newContainers) {
		EList<Container> oldContainers = containers;
		containers = newContainers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.DAIRY_SERVICE__CONTAINERS, oldContainers, containers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicesPackage.DAIRY_SERVICE__ROUTES:
				return getRoutes();
			case ServicesPackage.DAIRY_SERVICE__SESSIONS:
				return getSessions();
			case ServicesPackage.DAIRY_SERVICE__VEHICLES:
				return getVehicles();
			case ServicesPackage.DAIRY_SERVICE__EMPLOYEES:
				return getEmployees();
			case ServicesPackage.DAIRY_SERVICE__CONTAINERS:
				return getContainers();
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
			case ServicesPackage.DAIRY_SERVICE__ROUTES:
				setRoutes((EList<RouteDefinition>)newValue);
				return;
			case ServicesPackage.DAIRY_SERVICE__SESSIONS:
				setSessions((EList<Session>)newValue);
				return;
			case ServicesPackage.DAIRY_SERVICE__VEHICLES:
				setVehicles((EList<Vehicle>)newValue);
				return;
			case ServicesPackage.DAIRY_SERVICE__EMPLOYEES:
				setEmployees((EList<Employee>)newValue);
				return;
			case ServicesPackage.DAIRY_SERVICE__CONTAINERS:
				setContainers((EList<Container>)newValue);
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
			case ServicesPackage.DAIRY_SERVICE__ROUTES:
				setRoutes((EList<RouteDefinition>)null);
				return;
			case ServicesPackage.DAIRY_SERVICE__SESSIONS:
				setSessions((EList<Session>)null);
				return;
			case ServicesPackage.DAIRY_SERVICE__VEHICLES:
				setVehicles((EList<Vehicle>)null);
				return;
			case ServicesPackage.DAIRY_SERVICE__EMPLOYEES:
				setEmployees((EList<Employee>)null);
				return;
			case ServicesPackage.DAIRY_SERVICE__CONTAINERS:
				setContainers((EList<Container>)null);
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
			case ServicesPackage.DAIRY_SERVICE__ROUTES:
				return routes != null;
			case ServicesPackage.DAIRY_SERVICE__SESSIONS:
				return sessions != null;
			case ServicesPackage.DAIRY_SERVICE__VEHICLES:
				return vehicles != null;
			case ServicesPackage.DAIRY_SERVICE__EMPLOYEES:
				return employees != null;
			case ServicesPackage.DAIRY_SERVICE__CONTAINERS:
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
		result.append(" (routes: ");
		result.append(routes);
		result.append(", sessions: ");
		result.append(sessions);
		result.append(", vehicles: ");
		result.append(vehicles);
		result.append(", employees: ");
		result.append(employees);
		result.append(", containers: ");
		result.append(containers);
		result.append(')');
		return result.toString();
	}

} //DairyServiceImpl
