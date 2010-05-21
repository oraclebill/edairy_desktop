/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.impl;



import com.agritrace.edairy.model.Audited;
import com.agritrace.edairy.model.Company;
import com.agritrace.edairy.model.ContactMethod;
import com.agritrace.edairy.model.ContactMethodType;
import com.agritrace.edairy.model.ContainerType;
import com.agritrace.edairy.model.DescriptiveLocation;
import com.agritrace.edairy.model.Gender;
import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.MapLocation;
import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.ModelPackage;
import com.agritrace.edairy.model.Party;
import com.agritrace.edairy.model.Person;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.StatutoryLocation;
import com.agritrace.edairy.model.UnitOfMeasure;

import com.agritrace.edairy.model.dairy.DairyPackage;

import com.agritrace.edairy.model.dairy.account.AccountPackage;
import com.agritrace.edairy.model.dairy.account.impl.AccountPackageImpl;
import com.agritrace.edairy.model.dairy.impl.DairyPackageImpl;

import com.agritrace.edairy.model.requests.RequestsPackage;

import com.agritrace.edairy.model.requests.impl.RequestsPackageImpl;

import com.agritrace.edairy.model.tracking.TrackingPackage;

import com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postalLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statutoryLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass auditedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass companyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptiveLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass locationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contactMethodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum genderEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum contactMethodTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unitOfMeasureEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum containerTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType transactionIDEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uniqueIDEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType imageReferenceEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.agritrace.edairy.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DairyPackageImpl theDairyPackage = (DairyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DairyPackage.eNS_URI) instanceof DairyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DairyPackage.eNS_URI) : DairyPackage.eINSTANCE);
		AccountPackageImpl theAccountPackage = (AccountPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AccountPackage.eNS_URI) instanceof AccountPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AccountPackage.eNS_URI) : AccountPackage.eINSTANCE);
		TrackingPackageImpl theTrackingPackage = (TrackingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TrackingPackage.eNS_URI) instanceof TrackingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TrackingPackage.eNS_URI) : TrackingPackage.eINSTANCE);
		RequestsPackageImpl theRequestsPackage = (RequestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RequestsPackage.eNS_URI) instanceof RequestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RequestsPackage.eNS_URI) : RequestsPackage.eINSTANCE);

		// Create package meta-data objects
		theModelPackage.createPackageContents();
		theDairyPackage.createPackageContents();
		theAccountPackage.createPackageContents();
		theTrackingPackage.createPackageContents();
		theRequestsPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();
		theDairyPackage.initializePackageContents();
		theAccountPackage.initializePackageContents();
		theTrackingPackage.initializePackageContents();
		theRequestsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParty() {
		return partyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParty_PartyId() {
		return (EAttribute)partyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParty_PhoneNumber() {
		return (EAttribute)partyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParty_Location() {
		return (EReference)partyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParty_ContactMethods() {
		return (EReference)partyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParty_Name() {
		return (EAttribute)partyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapLocation() {
		return mapLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapLocation_Longitude() {
		return (EAttribute)mapLocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapLocation_Latitude() {
		return (EAttribute)mapLocationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostalLocation() {
		return postalLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalLocation_Address() {
		return (EAttribute)postalLocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalLocation_Section() {
		return (EAttribute)postalLocationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalLocation_Estate() {
		return (EAttribute)postalLocationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalLocation_Village() {
		return (EAttribute)postalLocationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalLocation_SubLocation() {
		return (EAttribute)postalLocationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalLocation_Location() {
		return (EAttribute)postalLocationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalLocation_District() {
		return (EAttribute)postalLocationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalLocation_Division() {
		return (EAttribute)postalLocationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalLocation_Province() {
		return (EAttribute)postalLocationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalLocation_PostalCode() {
		return (EAttribute)postalLocationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatutoryLocation() {
		return statutoryLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatutoryLocation_LandReferenceNumber() {
		return (EAttribute)statutoryLocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAudited() {
		return auditedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudited_LastUpdated() {
		return (EAttribute)auditedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudited_VoidDate() {
		return (EAttribute)auditedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerson() {
		return personEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Photo() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Honorific() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_FamilyName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_GivenName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_MiddleName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_AdditionalNames() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Suffix() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_NickName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompany() {
		return companyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompany_Contacts() {
		return (EReference)companyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompany_LegalName() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompany_CompanyName() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptiveLocation() {
		return descriptiveLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescriptiveLocation_Directions() {
		return (EAttribute)descriptiveLocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescriptiveLocation_Landmarks() {
		return (EAttribute)descriptiveLocationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocation() {
		return locationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocation_PostalLocation() {
		return (EReference)locationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocation_MapLocation() {
		return (EReference)locationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocation_StatutoryLocation() {
		return (EReference)locationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocation_DescriptiveLocation() {
		return (EReference)locationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContactMethod() {
		return contactMethodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContactMethod_CmType() {
		return (EAttribute)contactMethodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContactMethod_CmValue() {
		return (EAttribute)contactMethodEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGender() {
		return genderEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getContactMethodType() {
		return contactMethodTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUnitOfMeasure() {
		return unitOfMeasureEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getContainerType() {
		return containerTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTransactionID() {
		return transactionIDEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUniqueID() {
		return uniqueIDEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getImageReference() {
		return imageReferenceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		partyEClass = createEClass(PARTY);
		createEAttribute(partyEClass, PARTY__PARTY_ID);
		createEAttribute(partyEClass, PARTY__PHONE_NUMBER);
		createEReference(partyEClass, PARTY__LOCATION);
		createEReference(partyEClass, PARTY__CONTACT_METHODS);
		createEAttribute(partyEClass, PARTY__NAME);

		mapLocationEClass = createEClass(MAP_LOCATION);
		createEAttribute(mapLocationEClass, MAP_LOCATION__LONGITUDE);
		createEAttribute(mapLocationEClass, MAP_LOCATION__LATITUDE);

		postalLocationEClass = createEClass(POSTAL_LOCATION);
		createEAttribute(postalLocationEClass, POSTAL_LOCATION__ADDRESS);
		createEAttribute(postalLocationEClass, POSTAL_LOCATION__SECTION);
		createEAttribute(postalLocationEClass, POSTAL_LOCATION__ESTATE);
		createEAttribute(postalLocationEClass, POSTAL_LOCATION__VILLAGE);
		createEAttribute(postalLocationEClass, POSTAL_LOCATION__SUB_LOCATION);
		createEAttribute(postalLocationEClass, POSTAL_LOCATION__LOCATION);
		createEAttribute(postalLocationEClass, POSTAL_LOCATION__DISTRICT);
		createEAttribute(postalLocationEClass, POSTAL_LOCATION__DIVISION);
		createEAttribute(postalLocationEClass, POSTAL_LOCATION__PROVINCE);
		createEAttribute(postalLocationEClass, POSTAL_LOCATION__POSTAL_CODE);

		statutoryLocationEClass = createEClass(STATUTORY_LOCATION);
		createEAttribute(statutoryLocationEClass, STATUTORY_LOCATION__LAND_REFERENCE_NUMBER);

		auditedEClass = createEClass(AUDITED);
		createEAttribute(auditedEClass, AUDITED__LAST_UPDATED);
		createEAttribute(auditedEClass, AUDITED__VOID_DATE);

		personEClass = createEClass(PERSON);
		createEAttribute(personEClass, PERSON__PHOTO);
		createEAttribute(personEClass, PERSON__HONORIFIC);
		createEAttribute(personEClass, PERSON__FAMILY_NAME);
		createEAttribute(personEClass, PERSON__GIVEN_NAME);
		createEAttribute(personEClass, PERSON__MIDDLE_NAME);
		createEAttribute(personEClass, PERSON__ADDITIONAL_NAMES);
		createEAttribute(personEClass, PERSON__SUFFIX);
		createEAttribute(personEClass, PERSON__NICK_NAME);

		companyEClass = createEClass(COMPANY);
		createEReference(companyEClass, COMPANY__CONTACTS);
		createEAttribute(companyEClass, COMPANY__LEGAL_NAME);
		createEAttribute(companyEClass, COMPANY__COMPANY_NAME);

		descriptiveLocationEClass = createEClass(DESCRIPTIVE_LOCATION);
		createEAttribute(descriptiveLocationEClass, DESCRIPTIVE_LOCATION__DIRECTIONS);
		createEAttribute(descriptiveLocationEClass, DESCRIPTIVE_LOCATION__LANDMARKS);

		locationEClass = createEClass(LOCATION);
		createEReference(locationEClass, LOCATION__POSTAL_LOCATION);
		createEReference(locationEClass, LOCATION__MAP_LOCATION);
		createEReference(locationEClass, LOCATION__STATUTORY_LOCATION);
		createEReference(locationEClass, LOCATION__DESCRIPTIVE_LOCATION);

		contactMethodEClass = createEClass(CONTACT_METHOD);
		createEAttribute(contactMethodEClass, CONTACT_METHOD__CM_TYPE);
		createEAttribute(contactMethodEClass, CONTACT_METHOD__CM_VALUE);

		// Create enums
		genderEEnum = createEEnum(GENDER);
		contactMethodTypeEEnum = createEEnum(CONTACT_METHOD_TYPE);
		unitOfMeasureEEnum = createEEnum(UNIT_OF_MEASURE);
		containerTypeEEnum = createEEnum(CONTAINER_TYPE);

		// Create data types
		transactionIDEDataType = createEDataType(TRANSACTION_ID);
		uniqueIDEDataType = createEDataType(UNIQUE_ID);
		imageReferenceEDataType = createEDataType(IMAGE_REFERENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		personEClass.getESuperTypes().add(this.getParty());
		companyEClass.getESuperTypes().add(this.getParty());

		// Initialize classes and features; add operations and parameters
		initEClass(partyEClass, Party.class, "Party", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParty_PartyId(), ecorePackage.getEString(), "partyId", null, 1, 1, Party.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParty_PhoneNumber(), ecorePackage.getEString(), "phoneNumber", null, 0, 1, Party.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParty_Location(), this.getLocation(), null, "location", null, 1, 1, Party.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParty_ContactMethods(), this.getContactMethod(), null, "contactMethods", null, 0, -1, Party.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParty_Name(), ecorePackage.getEString(), "name", "", 1, 1, Party.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapLocationEClass, MapLocation.class, "MapLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMapLocation_Longitude(), ecorePackage.getEString(), "longitude", null, 1, 1, MapLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMapLocation_Latitude(), ecorePackage.getEString(), "latitude", null, 1, 1, MapLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(postalLocationEClass, PostalLocation.class, "PostalLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPostalLocation_Address(), ecorePackage.getEString(), "address", null, 0, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_Section(), ecorePackage.getEString(), "section", null, 1, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_Estate(), ecorePackage.getEString(), "estate", null, 0, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_Village(), ecorePackage.getEString(), "village", null, 1, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_SubLocation(), ecorePackage.getEString(), "subLocation", null, 0, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_Location(), ecorePackage.getEString(), "location", null, 1, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_District(), ecorePackage.getEString(), "district", null, 1, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_Division(), ecorePackage.getEString(), "division", null, 1, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_Province(), ecorePackage.getEString(), "province", null, 1, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_PostalCode(), ecorePackage.getEString(), "postalCode", null, 1, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statutoryLocationEClass, StatutoryLocation.class, "StatutoryLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStatutoryLocation_LandReferenceNumber(), ecorePackage.getEString(), "landReferenceNumber", null, 1, 1, StatutoryLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(auditedEClass, Audited.class, "Audited", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAudited_LastUpdated(), ecorePackage.getEDate(), "lastUpdated", null, 0, 1, Audited.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudited_VoidDate(), ecorePackage.getEDate(), "voidDate", null, 0, 1, Audited.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerson_Photo(), this.getImageReference(), "photo", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Honorific(), ecorePackage.getEString(), "honorific", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_FamilyName(), ecorePackage.getEString(), "familyName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_GivenName(), ecorePackage.getEString(), "givenName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_MiddleName(), ecorePackage.getEString(), "middleName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_AdditionalNames(), ecorePackage.getEString(), "additionalNames", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Suffix(), ecorePackage.getEString(), "suffix", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_NickName(), ecorePackage.getEString(), "nickName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(companyEClass, Company.class, "Company", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompany_Contacts(), this.getPerson(), null, "contacts", null, 1, -1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompany_LegalName(), ecorePackage.getEString(), "legalName", null, 0, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompany_CompanyName(), ecorePackage.getEString(), "companyName", null, 0, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptiveLocationEClass, DescriptiveLocation.class, "DescriptiveLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescriptiveLocation_Directions(), ecorePackage.getEString(), "directions", null, 1, 1, DescriptiveLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDescriptiveLocation_Landmarks(), ecorePackage.getEString(), "landmarks", null, 0, 1, DescriptiveLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(locationEClass, Location.class, "Location", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLocation_PostalLocation(), this.getPostalLocation(), null, "postalLocation", null, 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocation_MapLocation(), this.getMapLocation(), null, "mapLocation", null, 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocation_StatutoryLocation(), this.getStatutoryLocation(), null, "statutoryLocation", null, 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocation_DescriptiveLocation(), this.getDescriptiveLocation(), null, "descriptiveLocation", null, 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contactMethodEClass, ContactMethod.class, "ContactMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContactMethod_CmType(), this.getContactMethodType(), "cmType", null, 0, 1, ContactMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContactMethod_CmValue(), ecorePackage.getEString(), "cmValue", null, 0, 1, ContactMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(genderEEnum, Gender.class, "Gender");
		addEEnumLiteral(genderEEnum, Gender.MALE);
		addEEnumLiteral(genderEEnum, Gender.FEMALE);

		initEEnum(contactMethodTypeEEnum, ContactMethodType.class, "ContactMethodType");
		addEEnumLiteral(contactMethodTypeEEnum, ContactMethodType.EMAIL);
		addEEnumLiteral(contactMethodTypeEEnum, ContactMethodType.SMS);
		addEEnumLiteral(contactMethodTypeEEnum, ContactMethodType.PHONE);
		addEEnumLiteral(contactMethodTypeEEnum, ContactMethodType.FAX);
		addEEnumLiteral(contactMethodTypeEEnum, ContactMethodType.IM_AIM);
		addEEnumLiteral(contactMethodTypeEEnum, ContactMethodType.IM_SKYPE);
		addEEnumLiteral(contactMethodTypeEEnum, ContactMethodType.IM_MSN);
		addEEnumLiteral(contactMethodTypeEEnum, ContactMethodType.IM_GTALK);
		addEEnumLiteral(contactMethodTypeEEnum, ContactMethodType.IM_YAHOO);
		addEEnumLiteral(contactMethodTypeEEnum, ContactMethodType.IM_OTHER);
		addEEnumLiteral(contactMethodTypeEEnum, ContactMethodType.OTHER);

		initEEnum(unitOfMeasureEEnum, UnitOfMeasure.class, "UnitOfMeasure");
		addEEnumLiteral(unitOfMeasureEEnum, UnitOfMeasure.LITRE);
		addEEnumLiteral(unitOfMeasureEEnum, UnitOfMeasure.KILOGRAM);
		addEEnumLiteral(unitOfMeasureEEnum, UnitOfMeasure.UNKNOWN);

		initEEnum(containerTypeEEnum, ContainerType.class, "ContainerType");
		addEEnumLiteral(containerTypeEEnum, ContainerType.BIN);
		addEEnumLiteral(containerTypeEEnum, ContainerType.CAN);

		// Initialize data types
		initEDataType(transactionIDEDataType, String.class, "TransactionID", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uniqueIDEDataType, Long.class, "UniqueID", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(imageReferenceEDataType, String.class, "ImageReference", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (getAudited_VoidDate(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });
	}

} //ModelPackageImpl
