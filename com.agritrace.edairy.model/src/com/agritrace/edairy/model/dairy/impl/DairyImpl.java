/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.impl;

import com.agritrace.edairy.model.dairy.Dairy;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Employee;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.dairy.RouteDefinition;
import com.agritrace.edairy.model.dairy.Session;
import com.agritrace.edairy.model.dairy.Vehicle;
import com.agritrace.edairy.model.dairy.Workstation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dairy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.DairyImpl#getNhifNumber <em>Nhif Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.DairyImpl#getNssfNumber <em>Nssf Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.DairyImpl#getFederalPin <em>Federal Pin</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.DairyImpl#getWorkstations <em>Workstations</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.DairyImpl#getRoutes <em>Routes</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.DairyImpl#getVehicles <em>Vehicles</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.DairyImpl#getEmployees <em>Employees</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.DairyImpl#getSessions <em>Sessions</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.impl.DairyImpl#getMemberships <em>Memberships</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DairyImpl extends com.agritrace.edairy.model.tracking.impl.DairyImpl implements Dairy {
	/**
	 * The default value of the '{@link #getNhifNumber() <em>Nhif Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNhifNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String NHIF_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNhifNumber() <em>Nhif Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNhifNumber()
	 * @generated
	 * @ordered
	 */
	protected String nhifNumber = NHIF_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getNssfNumber() <em>Nssf Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNssfNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String NSSF_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNssfNumber() <em>Nssf Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNssfNumber()
	 * @generated
	 * @ordered
	 */
	protected String nssfNumber = NSSF_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getFederalPin() <em>Federal Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFederalPin()
	 * @generated
	 * @ordered
	 */
	protected static final String FEDERAL_PIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFederalPin() <em>Federal Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFederalPin()
	 * @generated
	 * @ordered
	 */
	protected String federalPin = FEDERAL_PIN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWorkstations() <em>Workstations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkstations()
	 * @generated
	 * @ordered
	 */
	protected EList<Workstation> workstations;

	/**
	 * The cached value of the '{@link #getRoutes() <em>Routes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutes()
	 * @generated
	 * @ordered
	 */
	protected EList<RouteDefinition> routes;

	/**
	 * The cached value of the '{@link #getVehicles() <em>Vehicles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicles()
	 * @generated
	 * @ordered
	 */
	protected EList<Vehicle> vehicles;

	/**
	 * The cached value of the '{@link #getEmployees() <em>Employees</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployees()
	 * @generated
	 * @ordered
	 */
	protected EList<Employee> employees;

	/**
	 * The cached value of the '{@link #getSessions() <em>Sessions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSessions()
	 * @generated
	 * @ordered
	 */
	protected EList<Session> sessions;

	/**
	 * The cached value of the '{@link #getMemberships() <em>Memberships</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberships()
	 * @generated
	 * @ordered
	 */
	protected EList<Membership> memberships;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DairyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.DAIRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNhifNumber() {
		return nhifNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNhifNumber(String newNhifNumber) {
		String oldNhifNumber = nhifNumber;
		nhifNumber = newNhifNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY__NHIF_NUMBER, oldNhifNumber, nhifNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNssfNumber() {
		return nssfNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNssfNumber(String newNssfNumber) {
		String oldNssfNumber = nssfNumber;
		nssfNumber = newNssfNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY__NSSF_NUMBER, oldNssfNumber, nssfNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFederalPin() {
		return federalPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFederalPin(String newFederalPin) {
		String oldFederalPin = federalPin;
		federalPin = newFederalPin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY__FEDERAL_PIN, oldFederalPin, federalPin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Workstation> getWorkstations() {
		if (workstations == null) {
			workstations = new EObjectResolvingEList<Workstation>(Workstation.class, this, DairyPackage.DAIRY__WORKSTATIONS);
		}
		return workstations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RouteDefinition> getRoutes() {
		if (routes == null) {
			routes = new EObjectContainmentEList.Resolving<RouteDefinition>(RouteDefinition.class, this, DairyPackage.DAIRY__ROUTES);
		}
		return routes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vehicle> getVehicles() {
		if (vehicles == null) {
			vehicles = new EObjectContainmentEList.Resolving<Vehicle>(Vehicle.class, this, DairyPackage.DAIRY__VEHICLES);
		}
		return vehicles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Employee> getEmployees() {
		if (employees == null) {
			employees = new EObjectContainmentEList.Resolving<Employee>(Employee.class, this, DairyPackage.DAIRY__EMPLOYEES);
		}
		return employees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Session> getSessions() {
		if (sessions == null) {
			sessions = new EObjectContainmentEList.Resolving<Session>(Session.class, this, DairyPackage.DAIRY__SESSIONS);
		}
		return sessions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Membership> getMemberships() {
		if (memberships == null) {
			memberships = new EObjectContainmentEList.Resolving<Membership>(Membership.class, this, DairyPackage.DAIRY__MEMBERSHIPS);
		}
		return memberships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DairyPackage.DAIRY__ROUTES:
				return ((InternalEList<?>)getRoutes()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__VEHICLES:
				return ((InternalEList<?>)getVehicles()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__EMPLOYEES:
				return ((InternalEList<?>)getEmployees()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__SESSIONS:
				return ((InternalEList<?>)getSessions()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__MEMBERSHIPS:
				return ((InternalEList<?>)getMemberships()).basicRemove(otherEnd, msgs);
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
			case DairyPackage.DAIRY__NHIF_NUMBER:
				return getNhifNumber();
			case DairyPackage.DAIRY__NSSF_NUMBER:
				return getNssfNumber();
			case DairyPackage.DAIRY__FEDERAL_PIN:
				return getFederalPin();
			case DairyPackage.DAIRY__WORKSTATIONS:
				return getWorkstations();
			case DairyPackage.DAIRY__ROUTES:
				return getRoutes();
			case DairyPackage.DAIRY__VEHICLES:
				return getVehicles();
			case DairyPackage.DAIRY__EMPLOYEES:
				return getEmployees();
			case DairyPackage.DAIRY__SESSIONS:
				return getSessions();
			case DairyPackage.DAIRY__MEMBERSHIPS:
				return getMemberships();
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
			case DairyPackage.DAIRY__NHIF_NUMBER:
				setNhifNumber((String)newValue);
				return;
			case DairyPackage.DAIRY__NSSF_NUMBER:
				setNssfNumber((String)newValue);
				return;
			case DairyPackage.DAIRY__FEDERAL_PIN:
				setFederalPin((String)newValue);
				return;
			case DairyPackage.DAIRY__WORKSTATIONS:
				getWorkstations().clear();
				getWorkstations().addAll((Collection<? extends Workstation>)newValue);
				return;
			case DairyPackage.DAIRY__ROUTES:
				getRoutes().clear();
				getRoutes().addAll((Collection<? extends RouteDefinition>)newValue);
				return;
			case DairyPackage.DAIRY__VEHICLES:
				getVehicles().clear();
				getVehicles().addAll((Collection<? extends Vehicle>)newValue);
				return;
			case DairyPackage.DAIRY__EMPLOYEES:
				getEmployees().clear();
				getEmployees().addAll((Collection<? extends Employee>)newValue);
				return;
			case DairyPackage.DAIRY__SESSIONS:
				getSessions().clear();
				getSessions().addAll((Collection<? extends Session>)newValue);
				return;
			case DairyPackage.DAIRY__MEMBERSHIPS:
				getMemberships().clear();
				getMemberships().addAll((Collection<? extends Membership>)newValue);
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
			case DairyPackage.DAIRY__NHIF_NUMBER:
				setNhifNumber(NHIF_NUMBER_EDEFAULT);
				return;
			case DairyPackage.DAIRY__NSSF_NUMBER:
				setNssfNumber(NSSF_NUMBER_EDEFAULT);
				return;
			case DairyPackage.DAIRY__FEDERAL_PIN:
				setFederalPin(FEDERAL_PIN_EDEFAULT);
				return;
			case DairyPackage.DAIRY__WORKSTATIONS:
				getWorkstations().clear();
				return;
			case DairyPackage.DAIRY__ROUTES:
				getRoutes().clear();
				return;
			case DairyPackage.DAIRY__VEHICLES:
				getVehicles().clear();
				return;
			case DairyPackage.DAIRY__EMPLOYEES:
				getEmployees().clear();
				return;
			case DairyPackage.DAIRY__SESSIONS:
				getSessions().clear();
				return;
			case DairyPackage.DAIRY__MEMBERSHIPS:
				getMemberships().clear();
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
			case DairyPackage.DAIRY__NHIF_NUMBER:
				return NHIF_NUMBER_EDEFAULT == null ? nhifNumber != null : !NHIF_NUMBER_EDEFAULT.equals(nhifNumber);
			case DairyPackage.DAIRY__NSSF_NUMBER:
				return NSSF_NUMBER_EDEFAULT == null ? nssfNumber != null : !NSSF_NUMBER_EDEFAULT.equals(nssfNumber);
			case DairyPackage.DAIRY__FEDERAL_PIN:
				return FEDERAL_PIN_EDEFAULT == null ? federalPin != null : !FEDERAL_PIN_EDEFAULT.equals(federalPin);
			case DairyPackage.DAIRY__WORKSTATIONS:
				return workstations != null && !workstations.isEmpty();
			case DairyPackage.DAIRY__ROUTES:
				return routes != null && !routes.isEmpty();
			case DairyPackage.DAIRY__VEHICLES:
				return vehicles != null && !vehicles.isEmpty();
			case DairyPackage.DAIRY__EMPLOYEES:
				return employees != null && !employees.isEmpty();
			case DairyPackage.DAIRY__SESSIONS:
				return sessions != null && !sessions.isEmpty();
			case DairyPackage.DAIRY__MEMBERSHIPS:
				return memberships != null && !memberships.isEmpty();
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
		result.append(" (nhifNumber: ");
		result.append(nhifNumber);
		result.append(", nssfNumber: ");
		result.append(nssfNumber);
		result.append(", federalPin: ");
		result.append(federalPin);
		result.append(')');
		return result.toString();
	}

} //DairyImpl
