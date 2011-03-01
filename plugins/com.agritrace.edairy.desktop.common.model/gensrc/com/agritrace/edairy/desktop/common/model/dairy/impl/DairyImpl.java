/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.MemberPayment;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.TransportRoute;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;

import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dairy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getRegistrationNumber <em>Registration Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getEstablishedDate <em>Established Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getManagerName <em>Manager Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getNssfNumber <em>Nssf Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getNhifNumber <em>Nhif Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getFederalPin <em>Federal Pin</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getLicenseEffectiveDate <em>License Effective Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getLicenseExpirationDate <em>License Expiration Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getRoutes <em>Routes</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getVehicles <em>Vehicles</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getEmployees <em>Employees</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getMemberships <em>Memberships</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getBranchLocations <em>Branch Locations</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getCollectionJournals <em>Collection Journals</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getDeliveryJournals <em>Delivery Journals</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getSuppliers <em>Suppliers</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getCustomers <em>Customers</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getAnimalHealthRequests <em>Animal Health Requests</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getDairyBins <em>Dairy Bins</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getPriceHistory <em>Price History</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getCollectionSessions <em>Collection Sessions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DairyImpl extends CompanyImpl implements Dairy {
	/**
	 * The default value of the '{@link #getRegistrationNumber() <em>Registration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistrationNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String REGISTRATION_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRegistrationNumber() <em>Registration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistrationNumber()
	 * @generated
	 * @ordered
	 */
	protected String registrationNumber = REGISTRATION_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getEstablishedDate() <em>Established Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstablishedDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date ESTABLISHED_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEstablishedDate() <em>Established Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstablishedDate()
	 * @generated
	 * @ordered
	 */
	protected Date establishedDate = ESTABLISHED_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getManagerName() <em>Manager Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagerName()
	 * @generated
	 * @ordered
	 */
	protected static final String MANAGER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManagerName() <em>Manager Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagerName()
	 * @generated
	 * @ordered
	 */
	protected String managerName = MANAGER_NAME_EDEFAULT;

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
	 * The default value of the '{@link #getLicenseEffectiveDate() <em>License Effective Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicenseEffectiveDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date LICENSE_EFFECTIVE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLicenseEffectiveDate() <em>License Effective Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicenseEffectiveDate()
	 * @generated
	 * @ordered
	 */
	protected Date licenseEffectiveDate = LICENSE_EFFECTIVE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLicenseExpirationDate() <em>License Expiration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicenseExpirationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date LICENSE_EXPIRATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLicenseExpirationDate() <em>License Expiration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicenseExpirationDate()
	 * @generated
	 * @ordered
	 */
	protected Date licenseExpirationDate = LICENSE_EXPIRATION_DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRoutes() <em>Routes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutes()
	 * @generated
	 * @ordered
	 */
	protected EList<TransportRoute> routes;

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
	 * The cached value of the '{@link #getMemberships() <em>Memberships</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberships()
	 * @generated
	 * @ordered
	 */
	protected EList<Membership> memberships;

	/**
	 * The cached value of the '{@link #getBranchLocations() <em>Branch Locations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchLocations()
	 * @generated
	 * @ordered
	 */
	protected EList<DairyLocation> branchLocations;

	/**
	 * The cached value of the '{@link #getCollectionJournals() <em>Collection Journals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionJournals()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionGroup> collectionJournals;

	/**
	 * The cached value of the '{@link #getDeliveryJournals() <em>Delivery Journals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeliveryJournals()
	 * @generated
	 * @ordered
	 */
	protected EList<DeliveryJournal> deliveryJournals;

	/**
	 * The cached value of the '{@link #getSuppliers() <em>Suppliers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppliers()
	 * @generated
	 * @ordered
	 */
	protected EList<Supplier> suppliers;

	/**
	 * The cached value of the '{@link #getCustomers() <em>Customers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomers()
	 * @generated
	 * @ordered
	 */
	protected EList<Customer> customers;

	/**
	 * The cached value of the '{@link #getAnimalHealthRequests() <em>Animal Health Requests</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnimalHealthRequests()
	 * @generated
	 * @ordered
	 */
	protected EList<AnimalHealthRequest> animalHealthRequests;

	/**
	 * The cached value of the '{@link #getDairyBins() <em>Dairy Bins</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDairyBins()
	 * @generated
	 * @ordered
	 */
	protected EList<Bin> dairyBins;

	/**
	 * The cached value of the '{@link #getPriceHistory() <em>Price History</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriceHistory()
	 * @generated
	 * @ordered
	 */
	protected EList<MemberPayment> priceHistory;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final long VERSION_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected long version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCollectionSessions() <em>Collection Sessions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionSessions()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionSession> collectionSessions;

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
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistrationNumber(String newRegistrationNumber) {
		String oldRegistrationNumber = registrationNumber;
		registrationNumber = newRegistrationNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY__REGISTRATION_NUMBER, oldRegistrationNumber, registrationNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEstablishedDate() {
		return establishedDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEstablishedDate(Date newEstablishedDate) {
		Date oldEstablishedDate = establishedDate;
		establishedDate = newEstablishedDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY__ESTABLISHED_DATE, oldEstablishedDate, establishedDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getManagerName() {
		return managerName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManagerName(String newManagerName) {
		String oldManagerName = managerName;
		managerName = newManagerName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY__MANAGER_NAME, oldManagerName, managerName));
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
	public Date getLicenseEffectiveDate() {
		return licenseEffectiveDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLicenseEffectiveDate(Date newLicenseEffectiveDate) {
		Date oldLicenseEffectiveDate = licenseEffectiveDate;
		licenseEffectiveDate = newLicenseEffectiveDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY__LICENSE_EFFECTIVE_DATE, oldLicenseEffectiveDate, licenseEffectiveDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getLicenseExpirationDate() {
		return licenseExpirationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLicenseExpirationDate(Date newLicenseExpirationDate) {
		Date oldLicenseExpirationDate = licenseExpirationDate;
		licenseExpirationDate = newLicenseExpirationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY__LICENSE_EXPIRATION_DATE, oldLicenseExpirationDate, licenseExpirationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransportRoute> getRoutes() {
		if (routes == null) {
			routes = new EObjectContainmentEList<TransportRoute>(TransportRoute.class, this, DairyPackage.DAIRY__ROUTES);
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
			vehicles = new EObjectContainmentEList<Vehicle>(Vehicle.class, this, DairyPackage.DAIRY__VEHICLES);
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
			employees = new EObjectContainmentEList<Employee>(Employee.class, this, DairyPackage.DAIRY__EMPLOYEES);
		}
		return employees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Membership> getMemberships() {
		if (memberships == null) {
			memberships = new EObjectContainmentWithInverseEList<Membership>(Membership.class, this, DairyPackage.DAIRY__MEMBERSHIPS, DairyPackage.MEMBERSHIP__DAIRY);
		}
		return memberships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DairyLocation> getBranchLocations() {
		if (branchLocations == null) {
			branchLocations = new EObjectContainmentEList<DairyLocation>(DairyLocation.class, this, DairyPackage.DAIRY__BRANCH_LOCATIONS);
		}
		return branchLocations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CollectionGroup> getCollectionJournals() {
		if (collectionJournals == null) {
			collectionJournals = new EObjectContainmentEList<CollectionGroup>(CollectionGroup.class, this, DairyPackage.DAIRY__COLLECTION_JOURNALS);
		}
		return collectionJournals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeliveryJournal> getDeliveryJournals() {
		if (deliveryJournals == null) {
			deliveryJournals = new EObjectContainmentEList<DeliveryJournal>(DeliveryJournal.class, this, DairyPackage.DAIRY__DELIVERY_JOURNALS);
		}
		return deliveryJournals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Supplier> getSuppliers() {
		if (suppliers == null) {
			suppliers = new EObjectContainmentEList<Supplier>(Supplier.class, this, DairyPackage.DAIRY__SUPPLIERS);
		}
		return suppliers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Customer> getCustomers() {
		if (customers == null) {
			customers = new EObjectContainmentEList<Customer>(Customer.class, this, DairyPackage.DAIRY__CUSTOMERS);
		}
		return customers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnimalHealthRequest> getAnimalHealthRequests() {
		if (animalHealthRequests == null) {
			animalHealthRequests = new EObjectContainmentWithInverseEList<AnimalHealthRequest>(AnimalHealthRequest.class, this, DairyPackage.DAIRY__ANIMAL_HEALTH_REQUESTS, RequestsPackage.ANIMAL_HEALTH_REQUEST__DAIRY);
		}
		return animalHealthRequests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Bin> getDairyBins() {
		if (dairyBins == null) {
			dairyBins = new EObjectContainmentEList<Bin>(Bin.class, this, DairyPackage.DAIRY__DAIRY_BINS);
		}
		return dairyBins;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MemberPayment> getPriceHistory() {
		if (priceHistory == null) {
			priceHistory = new EObjectContainmentEList<MemberPayment>(MemberPayment.class, this, DairyPackage.DAIRY__PRICE_HISTORY);
		}
		return priceHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(long newVersion) {
		long oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CollectionSession> getCollectionSessions() {
		if (collectionSessions == null) {
			collectionSessions = new EObjectContainmentWithInverseEList<CollectionSession>(CollectionSession.class, this, DairyPackage.DAIRY__COLLECTION_SESSIONS, DairyPackage.COLLECTION_SESSION__DAIRY);
		}
		return collectionSessions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DairyPackage.DAIRY__MEMBERSHIPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMemberships()).basicAdd(otherEnd, msgs);
			case DairyPackage.DAIRY__ANIMAL_HEALTH_REQUESTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnimalHealthRequests()).basicAdd(otherEnd, msgs);
			case DairyPackage.DAIRY__COLLECTION_SESSIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCollectionSessions()).basicAdd(otherEnd, msgs);
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
		switch (featureID) {
			case DairyPackage.DAIRY__ROUTES:
				return ((InternalEList<?>)getRoutes()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__VEHICLES:
				return ((InternalEList<?>)getVehicles()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__EMPLOYEES:
				return ((InternalEList<?>)getEmployees()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__MEMBERSHIPS:
				return ((InternalEList<?>)getMemberships()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__BRANCH_LOCATIONS:
				return ((InternalEList<?>)getBranchLocations()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__COLLECTION_JOURNALS:
				return ((InternalEList<?>)getCollectionJournals()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__DELIVERY_JOURNALS:
				return ((InternalEList<?>)getDeliveryJournals()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__SUPPLIERS:
				return ((InternalEList<?>)getSuppliers()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__CUSTOMERS:
				return ((InternalEList<?>)getCustomers()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__ANIMAL_HEALTH_REQUESTS:
				return ((InternalEList<?>)getAnimalHealthRequests()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__DAIRY_BINS:
				return ((InternalEList<?>)getDairyBins()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__PRICE_HISTORY:
				return ((InternalEList<?>)getPriceHistory()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__COLLECTION_SESSIONS:
				return ((InternalEList<?>)getCollectionSessions()).basicRemove(otherEnd, msgs);
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
			case DairyPackage.DAIRY__REGISTRATION_NUMBER:
				return getRegistrationNumber();
			case DairyPackage.DAIRY__ESTABLISHED_DATE:
				return getEstablishedDate();
			case DairyPackage.DAIRY__MANAGER_NAME:
				return getManagerName();
			case DairyPackage.DAIRY__NSSF_NUMBER:
				return getNssfNumber();
			case DairyPackage.DAIRY__NHIF_NUMBER:
				return getNhifNumber();
			case DairyPackage.DAIRY__FEDERAL_PIN:
				return getFederalPin();
			case DairyPackage.DAIRY__LICENSE_EFFECTIVE_DATE:
				return getLicenseEffectiveDate();
			case DairyPackage.DAIRY__LICENSE_EXPIRATION_DATE:
				return getLicenseExpirationDate();
			case DairyPackage.DAIRY__ROUTES:
				return getRoutes();
			case DairyPackage.DAIRY__VEHICLES:
				return getVehicles();
			case DairyPackage.DAIRY__EMPLOYEES:
				return getEmployees();
			case DairyPackage.DAIRY__MEMBERSHIPS:
				return getMemberships();
			case DairyPackage.DAIRY__BRANCH_LOCATIONS:
				return getBranchLocations();
			case DairyPackage.DAIRY__COLLECTION_JOURNALS:
				return getCollectionJournals();
			case DairyPackage.DAIRY__DELIVERY_JOURNALS:
				return getDeliveryJournals();
			case DairyPackage.DAIRY__SUPPLIERS:
				return getSuppliers();
			case DairyPackage.DAIRY__CUSTOMERS:
				return getCustomers();
			case DairyPackage.DAIRY__ANIMAL_HEALTH_REQUESTS:
				return getAnimalHealthRequests();
			case DairyPackage.DAIRY__DAIRY_BINS:
				return getDairyBins();
			case DairyPackage.DAIRY__PRICE_HISTORY:
				return getPriceHistory();
			case DairyPackage.DAIRY__VERSION:
				return getVersion();
			case DairyPackage.DAIRY__COLLECTION_SESSIONS:
				return getCollectionSessions();
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
			case DairyPackage.DAIRY__REGISTRATION_NUMBER:
				setRegistrationNumber((String)newValue);
				return;
			case DairyPackage.DAIRY__ESTABLISHED_DATE:
				setEstablishedDate((Date)newValue);
				return;
			case DairyPackage.DAIRY__MANAGER_NAME:
				setManagerName((String)newValue);
				return;
			case DairyPackage.DAIRY__NSSF_NUMBER:
				setNssfNumber((String)newValue);
				return;
			case DairyPackage.DAIRY__NHIF_NUMBER:
				setNhifNumber((String)newValue);
				return;
			case DairyPackage.DAIRY__FEDERAL_PIN:
				setFederalPin((String)newValue);
				return;
			case DairyPackage.DAIRY__LICENSE_EFFECTIVE_DATE:
				setLicenseEffectiveDate((Date)newValue);
				return;
			case DairyPackage.DAIRY__LICENSE_EXPIRATION_DATE:
				setLicenseExpirationDate((Date)newValue);
				return;
			case DairyPackage.DAIRY__ROUTES:
				getRoutes().clear();
				getRoutes().addAll((Collection<? extends TransportRoute>)newValue);
				return;
			case DairyPackage.DAIRY__VEHICLES:
				getVehicles().clear();
				getVehicles().addAll((Collection<? extends Vehicle>)newValue);
				return;
			case DairyPackage.DAIRY__EMPLOYEES:
				getEmployees().clear();
				getEmployees().addAll((Collection<? extends Employee>)newValue);
				return;
			case DairyPackage.DAIRY__MEMBERSHIPS:
				getMemberships().clear();
				getMemberships().addAll((Collection<? extends Membership>)newValue);
				return;
			case DairyPackage.DAIRY__BRANCH_LOCATIONS:
				getBranchLocations().clear();
				getBranchLocations().addAll((Collection<? extends DairyLocation>)newValue);
				return;
			case DairyPackage.DAIRY__COLLECTION_JOURNALS:
				getCollectionJournals().clear();
				getCollectionJournals().addAll((Collection<? extends CollectionGroup>)newValue);
				return;
			case DairyPackage.DAIRY__DELIVERY_JOURNALS:
				getDeliveryJournals().clear();
				getDeliveryJournals().addAll((Collection<? extends DeliveryJournal>)newValue);
				return;
			case DairyPackage.DAIRY__SUPPLIERS:
				getSuppliers().clear();
				getSuppliers().addAll((Collection<? extends Supplier>)newValue);
				return;
			case DairyPackage.DAIRY__CUSTOMERS:
				getCustomers().clear();
				getCustomers().addAll((Collection<? extends Customer>)newValue);
				return;
			case DairyPackage.DAIRY__ANIMAL_HEALTH_REQUESTS:
				getAnimalHealthRequests().clear();
				getAnimalHealthRequests().addAll((Collection<? extends AnimalHealthRequest>)newValue);
				return;
			case DairyPackage.DAIRY__DAIRY_BINS:
				getDairyBins().clear();
				getDairyBins().addAll((Collection<? extends Bin>)newValue);
				return;
			case DairyPackage.DAIRY__PRICE_HISTORY:
				getPriceHistory().clear();
				getPriceHistory().addAll((Collection<? extends MemberPayment>)newValue);
				return;
			case DairyPackage.DAIRY__VERSION:
				setVersion((Long)newValue);
				return;
			case DairyPackage.DAIRY__COLLECTION_SESSIONS:
				getCollectionSessions().clear();
				getCollectionSessions().addAll((Collection<? extends CollectionSession>)newValue);
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
			case DairyPackage.DAIRY__REGISTRATION_NUMBER:
				setRegistrationNumber(REGISTRATION_NUMBER_EDEFAULT);
				return;
			case DairyPackage.DAIRY__ESTABLISHED_DATE:
				setEstablishedDate(ESTABLISHED_DATE_EDEFAULT);
				return;
			case DairyPackage.DAIRY__MANAGER_NAME:
				setManagerName(MANAGER_NAME_EDEFAULT);
				return;
			case DairyPackage.DAIRY__NSSF_NUMBER:
				setNssfNumber(NSSF_NUMBER_EDEFAULT);
				return;
			case DairyPackage.DAIRY__NHIF_NUMBER:
				setNhifNumber(NHIF_NUMBER_EDEFAULT);
				return;
			case DairyPackage.DAIRY__FEDERAL_PIN:
				setFederalPin(FEDERAL_PIN_EDEFAULT);
				return;
			case DairyPackage.DAIRY__LICENSE_EFFECTIVE_DATE:
				setLicenseEffectiveDate(LICENSE_EFFECTIVE_DATE_EDEFAULT);
				return;
			case DairyPackage.DAIRY__LICENSE_EXPIRATION_DATE:
				setLicenseExpirationDate(LICENSE_EXPIRATION_DATE_EDEFAULT);
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
			case DairyPackage.DAIRY__MEMBERSHIPS:
				getMemberships().clear();
				return;
			case DairyPackage.DAIRY__BRANCH_LOCATIONS:
				getBranchLocations().clear();
				return;
			case DairyPackage.DAIRY__COLLECTION_JOURNALS:
				getCollectionJournals().clear();
				return;
			case DairyPackage.DAIRY__DELIVERY_JOURNALS:
				getDeliveryJournals().clear();
				return;
			case DairyPackage.DAIRY__SUPPLIERS:
				getSuppliers().clear();
				return;
			case DairyPackage.DAIRY__CUSTOMERS:
				getCustomers().clear();
				return;
			case DairyPackage.DAIRY__ANIMAL_HEALTH_REQUESTS:
				getAnimalHealthRequests().clear();
				return;
			case DairyPackage.DAIRY__DAIRY_BINS:
				getDairyBins().clear();
				return;
			case DairyPackage.DAIRY__PRICE_HISTORY:
				getPriceHistory().clear();
				return;
			case DairyPackage.DAIRY__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case DairyPackage.DAIRY__COLLECTION_SESSIONS:
				getCollectionSessions().clear();
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
			case DairyPackage.DAIRY__REGISTRATION_NUMBER:
				return REGISTRATION_NUMBER_EDEFAULT == null ? registrationNumber != null : !REGISTRATION_NUMBER_EDEFAULT.equals(registrationNumber);
			case DairyPackage.DAIRY__ESTABLISHED_DATE:
				return ESTABLISHED_DATE_EDEFAULT == null ? establishedDate != null : !ESTABLISHED_DATE_EDEFAULT.equals(establishedDate);
			case DairyPackage.DAIRY__MANAGER_NAME:
				return MANAGER_NAME_EDEFAULT == null ? managerName != null : !MANAGER_NAME_EDEFAULT.equals(managerName);
			case DairyPackage.DAIRY__NSSF_NUMBER:
				return NSSF_NUMBER_EDEFAULT == null ? nssfNumber != null : !NSSF_NUMBER_EDEFAULT.equals(nssfNumber);
			case DairyPackage.DAIRY__NHIF_NUMBER:
				return NHIF_NUMBER_EDEFAULT == null ? nhifNumber != null : !NHIF_NUMBER_EDEFAULT.equals(nhifNumber);
			case DairyPackage.DAIRY__FEDERAL_PIN:
				return FEDERAL_PIN_EDEFAULT == null ? federalPin != null : !FEDERAL_PIN_EDEFAULT.equals(federalPin);
			case DairyPackage.DAIRY__LICENSE_EFFECTIVE_DATE:
				return LICENSE_EFFECTIVE_DATE_EDEFAULT == null ? licenseEffectiveDate != null : !LICENSE_EFFECTIVE_DATE_EDEFAULT.equals(licenseEffectiveDate);
			case DairyPackage.DAIRY__LICENSE_EXPIRATION_DATE:
				return LICENSE_EXPIRATION_DATE_EDEFAULT == null ? licenseExpirationDate != null : !LICENSE_EXPIRATION_DATE_EDEFAULT.equals(licenseExpirationDate);
			case DairyPackage.DAIRY__ROUTES:
				return routes != null && !routes.isEmpty();
			case DairyPackage.DAIRY__VEHICLES:
				return vehicles != null && !vehicles.isEmpty();
			case DairyPackage.DAIRY__EMPLOYEES:
				return employees != null && !employees.isEmpty();
			case DairyPackage.DAIRY__MEMBERSHIPS:
				return memberships != null && !memberships.isEmpty();
			case DairyPackage.DAIRY__BRANCH_LOCATIONS:
				return branchLocations != null && !branchLocations.isEmpty();
			case DairyPackage.DAIRY__COLLECTION_JOURNALS:
				return collectionJournals != null && !collectionJournals.isEmpty();
			case DairyPackage.DAIRY__DELIVERY_JOURNALS:
				return deliveryJournals != null && !deliveryJournals.isEmpty();
			case DairyPackage.DAIRY__SUPPLIERS:
				return suppliers != null && !suppliers.isEmpty();
			case DairyPackage.DAIRY__CUSTOMERS:
				return customers != null && !customers.isEmpty();
			case DairyPackage.DAIRY__ANIMAL_HEALTH_REQUESTS:
				return animalHealthRequests != null && !animalHealthRequests.isEmpty();
			case DairyPackage.DAIRY__DAIRY_BINS:
				return dairyBins != null && !dairyBins.isEmpty();
			case DairyPackage.DAIRY__PRICE_HISTORY:
				return priceHistory != null && !priceHistory.isEmpty();
			case DairyPackage.DAIRY__VERSION:
				return version != VERSION_EDEFAULT;
			case DairyPackage.DAIRY__COLLECTION_SESSIONS:
				return collectionSessions != null && !collectionSessions.isEmpty();
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
		result.append(" (registrationNumber: ");
		result.append(registrationNumber);
		result.append(", establishedDate: ");
		result.append(establishedDate);
		result.append(", managerName: ");
		result.append(managerName);
		result.append(", nssfNumber: ");
		result.append(nssfNumber);
		result.append(", nhifNumber: ");
		result.append(nhifNumber);
		result.append(", federalPin: ");
		result.append(federalPin);
		result.append(", licenseEffectiveDate: ");
		result.append(licenseEffectiveDate);
		result.append(", licenseExpirationDate: ");
		result.append(licenseExpirationDate);
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //DairyImpl
