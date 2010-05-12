/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.requests.impl;

import com.agritrace.edairy.model.ModelPackage;

import com.agritrace.edairy.model.dairy.DairyPackage;

import com.agritrace.edairy.model.dairy.account.AccountPackage;

import com.agritrace.edairy.model.dairy.account.impl.AccountPackageImpl;

import com.agritrace.edairy.model.dairy.impl.DairyPackageImpl;

import com.agritrace.edairy.model.impl.ModelPackageImpl;

import com.agritrace.edairy.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.model.requests.RequestType;
import com.agritrace.edairy.model.requests.RequestsFactory;
import com.agritrace.edairy.model.requests.RequestsPackage;

import com.agritrace.edairy.model.tracking.TrackingPackage;

import com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
public class RequestsPackageImpl extends EPackageImpl implements RequestsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass animalHealthRequestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum requestTypeEEnum = null;

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
	 * @see com.agritrace.edairy.model.requests.RequestsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RequestsPackageImpl() {
		super(eNS_URI, RequestsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RequestsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RequestsPackage init() {
		if (isInited) return (RequestsPackage)EPackage.Registry.INSTANCE.getEPackage(RequestsPackage.eNS_URI);

		// Obtain or create and register package
		RequestsPackageImpl theRequestsPackage = (RequestsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RequestsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RequestsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DairyPackageImpl theDairyPackage = (DairyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DairyPackage.eNS_URI) instanceof DairyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DairyPackage.eNS_URI) : DairyPackage.eINSTANCE);
		AccountPackageImpl theAccountPackage = (AccountPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AccountPackage.eNS_URI) instanceof AccountPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AccountPackage.eNS_URI) : AccountPackage.eINSTANCE);
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		TrackingPackageImpl theTrackingPackage = (TrackingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TrackingPackage.eNS_URI) instanceof TrackingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TrackingPackage.eNS_URI) : TrackingPackage.eINSTANCE);

		// Create package meta-data objects
		theRequestsPackage.createPackageContents();
		theDairyPackage.createPackageContents();
		theAccountPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theTrackingPackage.createPackageContents();

		// Initialize created meta-data
		theRequestsPackage.initializePackageContents();
		theDairyPackage.initializePackageContents();
		theAccountPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theTrackingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRequestsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RequestsPackage.eNS_URI, theRequestsPackage);
		return theRequestsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnimalHealthRequest() {
		return animalHealthRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimalHealthRequest_RequestId() {
		return (EAttribute)animalHealthRequestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimalHealthRequest_RequestingMember() {
		return (EReference)animalHealthRequestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimalHealthRequest_Dairy() {
		return (EReference)animalHealthRequestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimalHealthRequest_Date() {
		return (EAttribute)animalHealthRequestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimalHealthRequest_Type() {
		return (EAttribute)animalHealthRequestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimalHealthRequest_ReportedProblem() {
		return (EAttribute)animalHealthRequestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimalHealthRequest_ReportedAnimal() {
		return (EReference)animalHealthRequestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimalHealthRequest_DateHeatDetected() {
		return (EAttribute)animalHealthRequestEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimalHealthRequest_FirstTreatment() {
		return (EAttribute)animalHealthRequestEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimalHealthRequest_SecondTreatment() {
		return (EAttribute)animalHealthRequestEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimalHealthRequest_ThirdTreatment() {
		return (EAttribute)animalHealthRequestEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimalHealthRequest_Member() {
		return (EReference)animalHealthRequestEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimalHealthRequest_Farm() {
		return (EReference)animalHealthRequestEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimalHealthRequest_ReferredTo() {
		return (EReference)animalHealthRequestEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRequestType() {
		return requestTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequestsFactory getRequestsFactory() {
		return (RequestsFactory)getEFactoryInstance();
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
		animalHealthRequestEClass = createEClass(ANIMAL_HEALTH_REQUEST);
		createEAttribute(animalHealthRequestEClass, ANIMAL_HEALTH_REQUEST__REQUEST_ID);
		createEReference(animalHealthRequestEClass, ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER);
		createEReference(animalHealthRequestEClass, ANIMAL_HEALTH_REQUEST__DAIRY);
		createEAttribute(animalHealthRequestEClass, ANIMAL_HEALTH_REQUEST__DATE);
		createEAttribute(animalHealthRequestEClass, ANIMAL_HEALTH_REQUEST__TYPE);
		createEAttribute(animalHealthRequestEClass, ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM);
		createEReference(animalHealthRequestEClass, ANIMAL_HEALTH_REQUEST__REPORTED_ANIMAL);
		createEAttribute(animalHealthRequestEClass, ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED);
		createEAttribute(animalHealthRequestEClass, ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT);
		createEAttribute(animalHealthRequestEClass, ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT);
		createEAttribute(animalHealthRequestEClass, ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT);
		createEReference(animalHealthRequestEClass, ANIMAL_HEALTH_REQUEST__MEMBER);
		createEReference(animalHealthRequestEClass, ANIMAL_HEALTH_REQUEST__FARM);
		createEReference(animalHealthRequestEClass, ANIMAL_HEALTH_REQUEST__REFERRED_TO);

		// Create enums
		requestTypeEEnum = createEEnum(REQUEST_TYPE);
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

		// Obtain other dependent packages
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		DairyPackage theDairyPackage = (DairyPackage)EPackage.Registry.INSTANCE.getEPackage(DairyPackage.eNS_URI);
		TrackingPackage theTrackingPackage = (TrackingPackage)EPackage.Registry.INSTANCE.getEPackage(TrackingPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(animalHealthRequestEClass, AnimalHealthRequest.class, "AnimalHealthRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnimalHealthRequest_RequestId(), theModelPackage.getUniqueID(), "requestId", null, 0, 1, AnimalHealthRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnimalHealthRequest_RequestingMember(), theDairyPackage.getMembership(), null, "requestingMember", null, 1, 1, AnimalHealthRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnimalHealthRequest_Dairy(), theDairyPackage.getDairy(), null, "dairy", null, 1, 1, AnimalHealthRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimalHealthRequest_Date(), ecorePackage.getEDate(), "date", null, 0, 1, AnimalHealthRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimalHealthRequest_Type(), this.getRequestType(), "type", null, 0, 1, AnimalHealthRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimalHealthRequest_ReportedProblem(), ecorePackage.getEString(), "reportedProblem", null, 0, 1, AnimalHealthRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnimalHealthRequest_ReportedAnimal(), theTrackingPackage.getRegisteredAnimal(), null, "reportedAnimal", null, 0, 1, AnimalHealthRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimalHealthRequest_DateHeatDetected(), ecorePackage.getEDate(), "dateHeatDetected", null, 0, 1, AnimalHealthRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimalHealthRequest_FirstTreatment(), ecorePackage.getEDate(), "firstTreatment", null, 0, 1, AnimalHealthRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimalHealthRequest_SecondTreatment(), ecorePackage.getEDate(), "secondTreatment", null, 0, 1, AnimalHealthRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimalHealthRequest_ThirdTreatment(), ecorePackage.getEDate(), "thirdTreatment", null, 0, 1, AnimalHealthRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnimalHealthRequest_Member(), theDairyPackage.getMembership(), null, "member", null, 1, 1, AnimalHealthRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnimalHealthRequest_Farm(), theTrackingPackage.getFarm(), null, "farm", null, 1, 1, AnimalHealthRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnimalHealthRequest_ReferredTo(), theDairyPackage.getSupplier(), null, "referredTo", null, 0, 1, AnimalHealthRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(requestTypeEEnum, RequestType.class, "RequestType");
		addEEnumLiteral(requestTypeEEnum, RequestType.VETERINARY);
		addEEnumLiteral(requestTypeEEnum, RequestType.INSEMINATION);

		// Create resource
		createResource(eNS_URI);
	}

} //RequestsPackageImpl
