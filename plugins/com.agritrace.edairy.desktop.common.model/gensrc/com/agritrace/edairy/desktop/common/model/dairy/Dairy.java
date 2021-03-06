/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import com.agritrace.edairy.desktop.common.model.base.Company;

import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;

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
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getRegistrationNumber <em>Registration Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getEstablishedDate <em>Established Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getManagerName <em>Manager Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getNssfNumber <em>Nssf Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getNhifNumber <em>Nhif Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getFederalPin <em>Federal Pin</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getLicenseEffectiveDate <em>License Effective Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getLicenseExpirationDate <em>License Expiration Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getRoutes <em>Routes</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getVehicles <em>Vehicles</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getEmployees <em>Employees</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getMemberships <em>Memberships</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getBranchLocations <em>Branch Locations</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getCollectionJournals <em>Collection Journals</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getDeliveryJournals <em>Delivery Journals</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getSuppliers <em>Suppliers</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getCustomers <em>Customers</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getAnimalHealthRequests <em>Animal Health Requests</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getDairyBins <em>Dairy Bins</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getPriceHistory <em>Price History</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getVersion <em>Version</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getCollectionSessions <em>Collection Sessions</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy()
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_RegistrationNumber()
	 * @model required="true"
	 * @generated
	 */
	String getRegistrationNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getRegistrationNumber <em>Registration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registration Number</em>' attribute.
	 * @see #getRegistrationNumber()
	 * @generated
	 */
	void setRegistrationNumber(String value);

	/**
	 * Returns the value of the '<em><b>Established Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Established Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Established Date</em>' attribute.
	 * @see #setEstablishedDate(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_EstablishedDate()
	 * @model
	 * @generated
	 */
	Date getEstablishedDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getEstablishedDate <em>Established Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Established Date</em>' attribute.
	 * @see #getEstablishedDate()
	 * @generated
	 */
	void setEstablishedDate(Date value);

	/**
	 * Returns the value of the '<em><b>Manager Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manager Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manager Name</em>' attribute.
	 * @see #setManagerName(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_ManagerName()
	 * @model
	 * @generated
	 */
	String getManagerName();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getManagerName <em>Manager Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager Name</em>' attribute.
	 * @see #getManagerName()
	 * @generated
	 */
	void setManagerName(String value);

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_NssfNumber()
	 * @model
	 * @generated
	 */
	String getNssfNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getNssfNumber <em>Nssf Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nssf Number</em>' attribute.
	 * @see #getNssfNumber()
	 * @generated
	 */
	void setNssfNumber(String value);

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_NhifNumber()
	 * @model
	 * @generated
	 */
	String getNhifNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getNhifNumber <em>Nhif Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nhif Number</em>' attribute.
	 * @see #getNhifNumber()
	 * @generated
	 */
	void setNhifNumber(String value);

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_FederalPin()
	 * @model
	 * @generated
	 */
	String getFederalPin();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getFederalPin <em>Federal Pin</em>}' attribute.
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_LicenseEffectiveDate()
	 * @model
	 * @generated
	 */
	Date getLicenseEffectiveDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getLicenseEffectiveDate <em>License Effective Date</em>}' attribute.
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_LicenseExpirationDate()
	 * @model
	 * @generated
	 */
	Date getLicenseExpirationDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getLicenseExpirationDate <em>License Expiration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>License Expiration Date</em>' attribute.
	 * @see #getLicenseExpirationDate()
	 * @generated
	 */
	void setLicenseExpirationDate(Date value);

	/**
	 * Returns the value of the '<em><b>Routes</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Routes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Routes</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_Routes()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TransportRoute> getRoutes();

	/**
	 * Returns the value of the '<em><b>Vehicles</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vehicles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicles</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_Vehicles()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Vehicle> getVehicles();

	/**
	 * Returns the value of the '<em><b>Employees</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.Employee}.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getEmployer <em>Employer</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employees</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employees</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_Employees()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Employee#getEmployer
	 * @model opposite="employer" containment="true" ordered="false"
	 * @generated
	 */
	EList<Employee> getEmployees();

	/**
	 * Returns the value of the '<em><b>Memberships</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.Membership}.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getDairy <em>Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memberships</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memberships</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_Memberships()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership#getDairy
	 * @model opposite="dairy" containment="true" ordered="false"
	 * @generated
	 */
	EList<Membership> getMemberships();

	/**
	 * Returns the value of the '<em><b>Branch Locations</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.DairyLocation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch Locations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch Locations</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_BranchLocations()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DairyLocation> getBranchLocations();

	/**
	 * Returns the value of the '<em><b>Collection Journals</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Journals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Journals</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_CollectionJournals()
	 * @model containment="true" keys="referenceNumber" transient="true" ordered="false"
	 * @generated
	 */
	EList<CollectionGroup> getCollectionJournals();

	/**
	 * Returns the value of the '<em><b>Delivery Journals</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delivery Journals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delivery Journals</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_DeliveryJournals()
	 * @model containment="true" keys="referenceNumber" transient="true" ordered="false"
	 * @generated
	 */
	EList<MilkSaleGroup> getDeliveryJournals();

	/**
	 * Returns the value of the '<em><b>Suppliers</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.Supplier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suppliers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suppliers</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_Suppliers()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Supplier> getSuppliers();

	/**
	 * Returns the value of the '<em><b>Customers</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.Customer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customers</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_Customers()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Customer> getCustomers();

	/**
	 * Returns the value of the '<em><b>Animal Health Requests</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest}.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getDairy <em>Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animal Health Requests</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animal Health Requests</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_AnimalHealthRequests()
	 * @see com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getDairy
	 * @model opposite="dairy" containment="true" keys="requestId" ordered="false"
	 * @generated
	 */
	EList<AnimalHealthRequest> getAnimalHealthRequests();

	/**
	 * Returns the value of the '<em><b>Dairy Bins</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.Bin}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dairy Bins</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dairy Bins</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_DairyBins()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Bin> getDairyBins();

	/**
	 * Returns the value of the '<em><b>Price History</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Price History</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Price History</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_PriceHistory()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MemberPayment> getPriceHistory();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(long)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_Version()
	 * @model extendedMetaData="name='version' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@Version'"
	 * @generated
	 */
	long getVersion();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(long value);

	/**
	 * Returns the value of the '<em><b>Collection Sessions</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession}.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getDairy <em>Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Sessions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Sessions</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairy_CollectionSessions()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getDairy
	 * @model opposite="dairy" containment="true"
	 * @generated
	 */
	EList<CollectionSession> getCollectionSessions();

} // Dairy
