/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy;

import com.agritrace.edairy.model.Company;

import com.agritrace.edairy.model.requests.AnimalHealthRequest;

import com.agritrace.edairy.model.tracking.Farm;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dairy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getRegistrationNumber <em>Registration Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getNhifNumber <em>Nhif Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getNssfNumber <em>Nssf Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getFederalPin <em>Federal Pin</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getLicenseEffectiveDate <em>License Effective Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getLicenseExpirationDate <em>License Expiration Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getRoutes <em>Routes</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getVehicles <em>Vehicles</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getEmployees <em>Employees</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getMemberships <em>Memberships</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getBranchLocations <em>Branch Locations</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getCollectionJournals <em>Collection Journals</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getSuppliers <em>Suppliers</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getAnimalHealthRequests <em>Animal Health Requests</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getDairyId <em>Dairy Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Dairy#getDairyBins <em>Dairy Bins</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy()
 * @model
 * @generated
 */
public interface Dairy extends Company {
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
         * Returns the value of the '<em><b>License Effective Date</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>License Effective Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>License Effective Date</em>' attribute.
         * @see #setLicenseEffectiveDate(Date)
         * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_LicenseEffectiveDate()
         * @model
         * @generated
         */
	Date getLicenseEffectiveDate();

	/**
         * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Dairy#getLicenseEffectiveDate <em>License Effective Date</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>License Effective Date</em>' attribute.
         * @see #getLicenseEffectiveDate()
         * @generated
         */
	void setLicenseEffectiveDate(Date value);

	/**
         * Returns the value of the '<em><b>License Expiration Date</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>License Expiration Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>License Expiration Date</em>' attribute.
         * @see #setLicenseExpirationDate(Date)
         * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_LicenseExpirationDate()
         * @model
         * @generated
         */
	Date getLicenseExpirationDate();

	/**
         * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Dairy#getLicenseExpirationDate <em>License Expiration Date</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>License Expiration Date</em>' attribute.
         * @see #getLicenseExpirationDate()
         * @generated
         */
	void setLicenseExpirationDate(Date value);

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
         * @model containment="true"
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
         * @model containment="true"
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
         * @model containment="true"
         * @generated
         */
	EList<Employee> getEmployees();

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
         * @model containment="true"
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
         * @model containment="true"
         * @generated
         */
	EList<DairyLocation> getBranchLocations();

	/**
         * Returns the value of the '<em><b>Collection Journals</b></em>' containment reference list.
         * The list contents are of type {@link com.agritrace.edairy.model.dairy.CollectionJournal}.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Journals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Collection Journals</em>' containment reference list.
         * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_CollectionJournals()
         * @model containment="true"
         * @generated
         */
	EList<CollectionJournal> getCollectionJournals();

	/**
         * Returns the value of the '<em><b>Suppliers</b></em>' reference list.
         * The list contents are of type {@link com.agritrace.edairy.model.dairy.Supplier}.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suppliers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Suppliers</em>' reference list.
         * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_Suppliers()
         * @model
         * @generated
         */
	EList<Supplier> getSuppliers();

	/**
         * Returns the value of the '<em><b>Animal Health Requests</b></em>' containment reference list.
         * The list contents are of type {@link com.agritrace.edairy.model.requests.AnimalHealthRequest}.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animal Health Requests</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Animal Health Requests</em>' containment reference list.
         * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_AnimalHealthRequests()
         * @model containment="true"
         * @generated
         */
	EList<AnimalHealthRequest> getAnimalHealthRequests();

	/**
         * Returns the value of the '<em><b>Dairy Id</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dairy Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Dairy Id</em>' attribute.
         * @see #setDairyId(Long)
         * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_DairyId()
         * @model id="true" dataType="com.agritrace.edairy.model.UniqueID"
         * @generated
         */
	Long getDairyId();

	/**
         * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Dairy#getDairyId <em>Dairy Id</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>Dairy Id</em>' attribute.
         * @see #getDairyId()
         * @generated
         */
	void setDairyId(Long value);

	/**
         * Returns the value of the '<em><b>Dairy Bins</b></em>' containment reference list.
         * The list contents are of type {@link com.agritrace.edairy.model.dairy.DairyContainer}.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dairy Bins</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Dairy Bins</em>' containment reference list.
         * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairy_DairyBins()
         * @model containment="true"
         * @generated
         */
	EList<DairyContainer> getDairyBins();

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @model kind="operation" required="true" many="false"
         * @generated
         */
	EList<Farm> getMemberFarms();

} // Dairy
