/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournal;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;

import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;

import com.agritrace.edairy.desktop.common.model.tracking.Farm;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
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
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getRegistrationNumber <em>Registration Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getNhifNumber <em>Nhif Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getNssfNumber <em>Nssf Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getFederalPin <em>Federal Pin</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getLicenseEffectiveDate <em>License Effective Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getLicenseExpirationDate <em>License Expiration Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getRoutes <em>Routes</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getVehicles <em>Vehicles</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getEmployees <em>Employees</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getMemberships <em>Memberships</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getBranchLocations <em>Branch Locations</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getCollectionJournals <em>Collection Journals</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getSuppliers <em>Suppliers</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getAnimalHealthRequests <em>Animal Health Requests</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getDairyId <em>Dairy Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl#getDairyBins <em>Dairy Bins</em>}</li>
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
	protected EList<Route> routes;

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
	protected EList<CollectionJournal> collectionJournals;

	/**
	 * The cached value of the '{@link #getSuppliers() <em>Suppliers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppliers()
	 * @generated
	 * @ordered
	 */
	protected EList<Supplier> suppliers;

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
	 * The default value of the '{@link #getDairyId() <em>Dairy Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDairyId()
	 * @generated
	 * @ordered
	 */
	protected static final Long DAIRY_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDairyId() <em>Dairy Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDairyId()
	 * @generated
	 * @ordered
	 */
	protected Long dairyId = DAIRY_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDairyBins() <em>Dairy Bins</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDairyBins()
	 * @generated
	 * @ordered
	 */
	protected EList<DairyContainer> dairyBins;

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
	public EList<Route> getRoutes() {
		if (routes == null) {
			routes = new EObjectContainmentEList<Route>(Route.class, this, DairyPackage.DAIRY__ROUTES);
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
			memberships = new EObjectContainmentEList<Membership>(Membership.class, this, DairyPackage.DAIRY__MEMBERSHIPS);
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
	public EList<CollectionJournal> getCollectionJournals() {
		if (collectionJournals == null) {
			collectionJournals = new EObjectContainmentEList<CollectionJournal>(CollectionJournal.class, this, DairyPackage.DAIRY__COLLECTION_JOURNALS);
		}
		return collectionJournals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Supplier> getSuppliers() {
		if (suppliers == null) {
			suppliers = new EObjectResolvingEList<Supplier>(Supplier.class, this, DairyPackage.DAIRY__SUPPLIERS);
		}
		return suppliers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnimalHealthRequest> getAnimalHealthRequests() {
		if (animalHealthRequests == null) {
			animalHealthRequests = new EObjectContainmentEList<AnimalHealthRequest>(AnimalHealthRequest.class, this, DairyPackage.DAIRY__ANIMAL_HEALTH_REQUESTS);
		}
		return animalHealthRequests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getDairyId() {
		return dairyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDairyId(Long newDairyId) {
		Long oldDairyId = dairyId;
		dairyId = newDairyId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY__DAIRY_ID, oldDairyId, dairyId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DairyContainer> getDairyBins() {
		if (dairyBins == null) {
			dairyBins = new EObjectContainmentEList<DairyContainer>(DairyContainer.class, this, DairyPackage.DAIRY__DAIRY_BINS);
		}
		return dairyBins;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * FIXME: This is guaranteed to be terribly inefficient... replace with query
	 */
	public EList<Farm> getMemberFarms() {
	    BasicEList<Farm> memberFarms = new BasicEList<Farm>();
	    EList<Membership> members = getMemberships();
	    for (Membership member : members) {
		memberFarms.addAll(member.getFarms());
	    }
	    return memberFarms;
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
			case DairyPackage.DAIRY__ANIMAL_HEALTH_REQUESTS:
				return ((InternalEList<?>)getAnimalHealthRequests()).basicRemove(otherEnd, msgs);
			case DairyPackage.DAIRY__DAIRY_BINS:
				return ((InternalEList<?>)getDairyBins()).basicRemove(otherEnd, msgs);
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
			case DairyPackage.DAIRY__NHIF_NUMBER:
				return getNhifNumber();
			case DairyPackage.DAIRY__NSSF_NUMBER:
				return getNssfNumber();
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
			case DairyPackage.DAIRY__SUPPLIERS:
				return getSuppliers();
			case DairyPackage.DAIRY__ANIMAL_HEALTH_REQUESTS:
				return getAnimalHealthRequests();
			case DairyPackage.DAIRY__DAIRY_ID:
				return getDairyId();
			case DairyPackage.DAIRY__DAIRY_BINS:
				return getDairyBins();
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
			case DairyPackage.DAIRY__NHIF_NUMBER:
				setNhifNumber((String)newValue);
				return;
			case DairyPackage.DAIRY__NSSF_NUMBER:
				setNssfNumber((String)newValue);
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
				getRoutes().addAll((Collection<? extends Route>)newValue);
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
				getCollectionJournals().addAll((Collection<? extends CollectionJournal>)newValue);
				return;
			case DairyPackage.DAIRY__SUPPLIERS:
				getSuppliers().clear();
				getSuppliers().addAll((Collection<? extends Supplier>)newValue);
				return;
			case DairyPackage.DAIRY__ANIMAL_HEALTH_REQUESTS:
				getAnimalHealthRequests().clear();
				getAnimalHealthRequests().addAll((Collection<? extends AnimalHealthRequest>)newValue);
				return;
			case DairyPackage.DAIRY__DAIRY_ID:
				setDairyId((Long)newValue);
				return;
			case DairyPackage.DAIRY__DAIRY_BINS:
				getDairyBins().clear();
				getDairyBins().addAll((Collection<? extends DairyContainer>)newValue);
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
			case DairyPackage.DAIRY__NHIF_NUMBER:
				setNhifNumber(NHIF_NUMBER_EDEFAULT);
				return;
			case DairyPackage.DAIRY__NSSF_NUMBER:
				setNssfNumber(NSSF_NUMBER_EDEFAULT);
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
			case DairyPackage.DAIRY__SUPPLIERS:
				getSuppliers().clear();
				return;
			case DairyPackage.DAIRY__ANIMAL_HEALTH_REQUESTS:
				getAnimalHealthRequests().clear();
				return;
			case DairyPackage.DAIRY__DAIRY_ID:
				setDairyId(DAIRY_ID_EDEFAULT);
				return;
			case DairyPackage.DAIRY__DAIRY_BINS:
				getDairyBins().clear();
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
			case DairyPackage.DAIRY__NHIF_NUMBER:
				return NHIF_NUMBER_EDEFAULT == null ? nhifNumber != null : !NHIF_NUMBER_EDEFAULT.equals(nhifNumber);
			case DairyPackage.DAIRY__NSSF_NUMBER:
				return NSSF_NUMBER_EDEFAULT == null ? nssfNumber != null : !NSSF_NUMBER_EDEFAULT.equals(nssfNumber);
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
			case DairyPackage.DAIRY__SUPPLIERS:
				return suppliers != null && !suppliers.isEmpty();
			case DairyPackage.DAIRY__ANIMAL_HEALTH_REQUESTS:
				return animalHealthRequests != null && !animalHealthRequests.isEmpty();
			case DairyPackage.DAIRY__DAIRY_ID:
				return DAIRY_ID_EDEFAULT == null ? dairyId != null : !DAIRY_ID_EDEFAULT.equals(dairyId);
			case DairyPackage.DAIRY__DAIRY_BINS:
				return dairyBins != null && !dairyBins.isEmpty();
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
		result.append(", nhifNumber: ");
		result.append(nhifNumber);
		result.append(", nssfNumber: ");
		result.append(nssfNumber);
		result.append(", federalPin: ");
		result.append(federalPin);
		result.append(", licenseEffectiveDate: ");
		result.append(licenseEffectiveDate);
		result.append(", licenseExpirationDate: ");
		result.append(licenseExpirationDate);
		result.append(", dairyId: ");
		result.append(dairyId);
		result.append(')');
		return result.toString();
	}

} //DairyImpl
