/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy;

import com.agritrace.edairy.model.Company;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dairy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getNhifNumber <em>Nhif Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getNssfNumber <em>Nssf Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getFederalPin <em>Federal Pin</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getWorkstations <em>Workstations</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getRoutes <em>Routes</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getVehicles <em>Vehicles</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getEmployees <em>Employees</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getSessions <em>Sessions</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getMemberships <em>Memberships</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getBranchLocations <em>Branch Locations</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getRegistrationNumber <em>Registration Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getCollections <em>Collections</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy()
 * @model
 * @generated
 */
public interface Dairy extends Company {
	/**
	 * Returns the value of the '<em><b>Nhif Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nhif Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nhif Number</em>' attribute.
	 * @see #setNhifNumber(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_NhifNumber()
	 * @model
	 * @generated
	 */
	String getNhifNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Dairy#getNhifNumber <em>Nhif Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nhif Number</em>' attribute.
	 * @see #getNhifNumber()
	 * @generated
	 */
	void setNhifNumber(String value);

	/**
	 * Returns the value of the '<em><b>Nssf Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nssf Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nssf Number</em>' attribute.
	 * @see #setNssfNumber(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_NssfNumber()
	 * @model
	 * @generated
	 */
	String getNssfNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Dairy#getNssfNumber <em>Nssf Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nssf Number</em>' attribute.
	 * @see #getNssfNumber()
	 * @generated
	 */
	void setNssfNumber(String value);

	/**
	 * Returns the value of the '<em><b>Federal Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Federal Pin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Federal Pin</em>' attribute.
	 * @see #setFederalPin(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_FederalPin()
	 * @model
	 * @generated
	 */
	String getFederalPin();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Dairy#getFederalPin <em>Federal Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Federal Pin</em>' attribute.
	 * @see #getFederalPin()
	 * @generated
	 */
	void setFederalPin(String value);

	/**
	 * Returns the value of the '<em><b>Workstations</b></em>' reference list.
	 * The list contents are of type {@link com.agritrace.edairy.model.dairy.Workstation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workstations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workstations</em>' reference list.
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_Workstations()
	 * @model
	 * @generated
	 */
	EList<Workstation> getWorkstations();

	/**
	 * Returns the value of the '<em><b>Routes</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.model.dairy.Route}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Routes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Routes</em>' containment reference list.
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_Routes()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Route> getRoutes();

	/**
	 * Returns the value of the '<em><b>Vehicles</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.model.dairy.Vehicle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vehicles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicles</em>' containment reference list.
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_Vehicles()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Vehicle> getVehicles();

	/**
	 * Returns the value of the '<em><b>Employees</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.model.dairy.Employee}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employees</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employees</em>' containment reference list.
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_Employees()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Employee> getEmployees();

	/**
	 * Returns the value of the '<em><b>Sessions</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.model.dairy.Session}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sessions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sessions</em>' containment reference list.
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_Sessions()
	 * @model containment="true" resolveProxies="true" lower="2"
	 * @generated
	 */
	EList<Session> getSessions();

	/**
	 * Returns the value of the '<em><b>Memberships</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.model.dairy.Membership}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memberships</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memberships</em>' containment reference list.
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_Memberships()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Membership> getMemberships();

	/**
	 * Returns the value of the '<em><b>Branch Locations</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.model.dairy.DairyLocation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch Locations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch Locations</em>' containment reference list.
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_BranchLocations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<DairyLocation> getBranchLocations();

	/**
	 * Returns the value of the '<em><b>Registration Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registration Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registration Number</em>' attribute.
	 * @see #setRegistrationNumber(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_RegistrationNumber()
	 * @model required="true"
	 * @generated
	 */
	String getRegistrationNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Dairy#getRegistrationNumber <em>Registration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registration Number</em>' attribute.
	 * @see #getRegistrationNumber()
	 * @generated
	 */
	void setRegistrationNumber(String value);

	/**
	 * Returns the value of the '<em><b>Collections</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.model.dairy.CollectionJournal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collections</em>' containment reference list.
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_Collections()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<CollectionJournal> getCollections();

} // Dairy
