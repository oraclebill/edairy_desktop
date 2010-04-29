/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.services;

import com.agritrace.edairy.model.dairy.Employee;
import com.agritrace.edairy.model.dairy.RouteDefinition;
import com.agritrace.edairy.model.dairy.Session;
import com.agritrace.edairy.model.dairy.Vehicle;

import com.agritrace.edairy.model.tracking.Container;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dairy Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.services.DairyService#getRoutes <em>Routes</em>}</li>
 *   <li>{@link com.agritrace.edairy.services.DairyService#getSessions <em>Sessions</em>}</li>
 *   <li>{@link com.agritrace.edairy.services.DairyService#getVehicles <em>Vehicles</em>}</li>
 *   <li>{@link com.agritrace.edairy.services.DairyService#getEmployees <em>Employees</em>}</li>
 *   <li>{@link com.agritrace.edairy.services.DairyService#getContainers <em>Containers</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.services.ServicesPackage#getDairyService()
 * @model
 * @generated
 */
public interface DairyService extends EObject {
	/**
	 * Returns the value of the '<em><b>Routes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Routes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Routes</em>' attribute.
	 * @see #setRoutes(EList)
	 * @see com.agritrace.edairy.services.ServicesPackage#getDairyService_Routes()
	 * @model required="true" many="false" transient="true"
	 * @generated
	 */
	EList<RouteDefinition> getRoutes();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.services.DairyService#getRoutes <em>Routes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Routes</em>' attribute.
	 * @see #getRoutes()
	 * @generated
	 */
	void setRoutes(EList<RouteDefinition> value);

	/**
	 * Returns the value of the '<em><b>Sessions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sessions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sessions</em>' attribute.
	 * @see #setSessions(EList)
	 * @see com.agritrace.edairy.services.ServicesPackage#getDairyService_Sessions()
	 * @model required="true" many="false" transient="true"
	 * @generated
	 */
	EList<Session> getSessions();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.services.DairyService#getSessions <em>Sessions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sessions</em>' attribute.
	 * @see #getSessions()
	 * @generated
	 */
	void setSessions(EList<Session> value);

	/**
	 * Returns the value of the '<em><b>Vehicles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vehicles</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicles</em>' attribute.
	 * @see #setVehicles(EList)
	 * @see com.agritrace.edairy.services.ServicesPackage#getDairyService_Vehicles()
	 * @model required="true" many="false" transient="true"
	 * @generated
	 */
	EList<Vehicle> getVehicles();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.services.DairyService#getVehicles <em>Vehicles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicles</em>' attribute.
	 * @see #getVehicles()
	 * @generated
	 */
	void setVehicles(EList<Vehicle> value);

	/**
	 * Returns the value of the '<em><b>Employees</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employees</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employees</em>' attribute.
	 * @see #setEmployees(EList)
	 * @see com.agritrace.edairy.services.ServicesPackage#getDairyService_Employees()
	 * @model required="true" many="false" transient="true"
	 * @generated
	 */
	EList<Employee> getEmployees();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.services.DairyService#getEmployees <em>Employees</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Employees</em>' attribute.
	 * @see #getEmployees()
	 * @generated
	 */
	void setEmployees(EList<Employee> value);

	/**
	 * Returns the value of the '<em><b>Containers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containers</em>' attribute.
	 * @see #setContainers(EList)
	 * @see com.agritrace.edairy.services.ServicesPackage#getDairyService_Containers()
	 * @model required="true" many="false" transient="true"
	 * @generated
	 */
	EList<Container> getContainers();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.services.DairyService#getContainers <em>Containers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containers</em>' attribute.
	 * @see #getContainers()
	 * @generated
	 */
	void setContainers(EList<Container> value);

} // DairyService
