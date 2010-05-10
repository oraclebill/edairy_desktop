/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.tracking.impl;

import com.agritrace.edairy.model.ModelPackage;

import com.agritrace.edairy.model.dairy.DairyPackage;

import com.agritrace.edairy.model.dairy.account.AccountPackage;

import com.agritrace.edairy.model.dairy.account.impl.AccountPackageImpl;

import com.agritrace.edairy.model.dairy.impl.DairyPackageImpl;

import com.agritrace.edairy.model.impl.ModelPackageImpl;

import com.agritrace.edairy.model.requests.RequestsPackage;

import com.agritrace.edairy.model.requests.impl.RequestsPackageImpl;

import com.agritrace.edairy.model.tracking.AcquisitionType;
import com.agritrace.edairy.model.tracking.AnimalIdentifier;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.model.tracking.Mechanism;
import com.agritrace.edairy.model.tracking.Purpose;
import com.agritrace.edairy.model.tracking.RearingMode;
import com.agritrace.edairy.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.model.tracking.TrackingFactory;
import com.agritrace.edairy.model.tracking.TrackingPackage;

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
public class TrackingPackageImpl extends EPackageImpl implements TrackingPackage {
	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	private EClass farmEClass = null;

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	private EClass containerEClass = null;

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	private EClass registeredAnimalEClass = null;

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	private EClass referenceAnimalTypeEClass = null;

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	private EClass animalIdentifierEClass = null;

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	private EEnum acquisitionTypeEEnum = null;

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	private EEnum purposeEEnum = null;

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	private EEnum rearingModeEEnum = null;

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	private EEnum mechanismEEnum = null;

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
         * @see com.agritrace.edairy.model.tracking.TrackingPackage#eNS_URI
         * @see #init()
         * @generated
         */
	private TrackingPackageImpl() {
                super(eNS_URI, TrackingFactory.eINSTANCE);
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
         * <p>This method is used to initialize {@link TrackingPackage#eINSTANCE} when that field is accessed.
         * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #eNS_URI
         * @see #createPackageContents()
         * @see #initializePackageContents()
         * @generated
         */
	public static TrackingPackage init() {
                if (isInited) return (TrackingPackage)EPackage.Registry.INSTANCE.getEPackage(TrackingPackage.eNS_URI);

                // Obtain or create and register package
                TrackingPackageImpl theTrackingPackage = (TrackingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TrackingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TrackingPackageImpl());

                isInited = true;

                // Obtain or create and register interdependencies
                DairyPackageImpl theDairyPackage = (DairyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DairyPackage.eNS_URI) instanceof DairyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DairyPackage.eNS_URI) : DairyPackage.eINSTANCE);
                AccountPackageImpl theAccountPackage = (AccountPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AccountPackage.eNS_URI) instanceof AccountPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AccountPackage.eNS_URI) : AccountPackage.eINSTANCE);
                ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
                RequestsPackageImpl theRequestsPackage = (RequestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RequestsPackage.eNS_URI) instanceof RequestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RequestsPackage.eNS_URI) : RequestsPackage.eINSTANCE);

                // Create package meta-data objects
                theTrackingPackage.createPackageContents();
                theDairyPackage.createPackageContents();
                theAccountPackage.createPackageContents();
                theModelPackage.createPackageContents();
                theRequestsPackage.createPackageContents();

                // Initialize created meta-data
                theTrackingPackage.initializePackageContents();
                theDairyPackage.initializePackageContents();
                theAccountPackage.initializePackageContents();
                theModelPackage.initializePackageContents();
                theRequestsPackage.initializePackageContents();

                // Mark meta-data to indicate it can't be changed
                theTrackingPackage.freeze();

  
                // Update the registry and return the package
                EPackage.Registry.INSTANCE.put(TrackingPackage.eNS_URI, theTrackingPackage);
                return theTrackingPackage;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EClass getFarm() {
                return farmEClass;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getFarm_Name() {
                return (EAttribute)farmEClass.getEStructuralFeatures().get(0);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EReference getFarm_Animals() {
                return (EReference)farmEClass.getEStructuralFeatures().get(1);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EReference getFarm_Cans() {
                return (EReference)farmEClass.getEStructuralFeatures().get(2);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EReference getFarm_Location() {
                return (EReference)farmEClass.getEStructuralFeatures().get(3);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getFarm_FarmId() {
                return (EAttribute)farmEClass.getEStructuralFeatures().get(4);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EClass getContainer() {
                return containerEClass;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getContainer_ContainerId() {
                return (EAttribute)containerEClass.getEStructuralFeatures().get(0);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EReference getContainer_Owner() {
                return (EReference)containerEClass.getEStructuralFeatures().get(1);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getContainer_Capacity() {
                return (EAttribute)containerEClass.getEStructuralFeatures().get(2);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getContainer_Type() {
                return (EAttribute)containerEClass.getEStructuralFeatures().get(3);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getContainer_MeasureType() {
                return (EAttribute)containerEClass.getEStructuralFeatures().get(4);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EClass getRegisteredAnimal() {
                return registeredAnimalEClass;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getRegisteredAnimal_AnimnalRegistrationId() {
                return (EAttribute)registeredAnimalEClass.getEStructuralFeatures().get(0);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getRegisteredAnimal_GivenName() {
                return (EAttribute)registeredAnimalEClass.getEStructuralFeatures().get(1);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EReference getRegisteredAnimal_Location() {
                return (EReference)registeredAnimalEClass.getEStructuralFeatures().get(2);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getRegisteredAnimal_Gender() {
                return (EAttribute)registeredAnimalEClass.getEStructuralFeatures().get(3);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EReference getRegisteredAnimal_AnimalType() {
                return (EReference)registeredAnimalEClass.getEStructuralFeatures().get(4);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EReference getRegisteredAnimal_SireType() {
                return (EReference)registeredAnimalEClass.getEStructuralFeatures().get(5);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getRegisteredAnimal_Purpose() {
                return (EAttribute)registeredAnimalEClass.getEStructuralFeatures().get(6);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getRegisteredAnimal_DateOfAcquisition() {
                return (EAttribute)registeredAnimalEClass.getEStructuralFeatures().get(7);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getRegisteredAnimal_AcquisitionType() {
                return (EAttribute)registeredAnimalEClass.getEStructuralFeatures().get(8);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EReference getRegisteredAnimal_Identifiers() {
                return (EReference)registeredAnimalEClass.getEStructuralFeatures().get(9);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getRegisteredAnimal_IdentifyingFeatures() {
                return (EAttribute)registeredAnimalEClass.getEStructuralFeatures().get(10);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getRegisteredAnimal_RearingMode() {
                return (EAttribute)registeredAnimalEClass.getEStructuralFeatures().get(11);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getRegisteredAnimal_PastOwners() {
                return (EAttribute)registeredAnimalEClass.getEStructuralFeatures().get(12);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getRegisteredAnimal_InsuranceNumber() {
                return (EAttribute)registeredAnimalEClass.getEStructuralFeatures().get(13);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getRegisteredAnimal_DateOfBirth() {
                return (EAttribute)registeredAnimalEClass.getEStructuralFeatures().get(14);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EClass getReferenceAnimalType() {
                return referenceAnimalTypeEClass;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getReferenceAnimalType_AnimalTypeId() {
                return (EAttribute)referenceAnimalTypeEClass.getEStructuralFeatures().get(0);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getReferenceAnimalType_Species() {
                return (EAttribute)referenceAnimalTypeEClass.getEStructuralFeatures().get(1);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getReferenceAnimalType_Breed() {
                return (EAttribute)referenceAnimalTypeEClass.getEStructuralFeatures().get(2);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EClass getAnimalIdentifier() {
                return animalIdentifierEClass;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getAnimalIdentifier_Issuer() {
                return (EAttribute)animalIdentifierEClass.getEStructuralFeatures().get(0);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EAttribute getAnimalIdentifier_Value() {
                return (EAttribute)animalIdentifierEClass.getEStructuralFeatures().get(1);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EEnum getAcquisitionType() {
                return acquisitionTypeEEnum;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EEnum getPurpose() {
                return purposeEEnum;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EEnum getRearingMode() {
                return rearingModeEEnum;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EEnum getMechanism() {
                return mechanismEEnum;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public TrackingFactory getTrackingFactory() {
                return (TrackingFactory)getEFactoryInstance();
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
                farmEClass = createEClass(FARM);
                createEAttribute(farmEClass, FARM__NAME);
                createEReference(farmEClass, FARM__ANIMALS);
                createEReference(farmEClass, FARM__CANS);
                createEReference(farmEClass, FARM__LOCATION);
                createEAttribute(farmEClass, FARM__FARM_ID);

                containerEClass = createEClass(CONTAINER);
                createEAttribute(containerEClass, CONTAINER__CONTAINER_ID);
                createEReference(containerEClass, CONTAINER__OWNER);
                createEAttribute(containerEClass, CONTAINER__CAPACITY);
                createEAttribute(containerEClass, CONTAINER__TYPE);
                createEAttribute(containerEClass, CONTAINER__MEASURE_TYPE);

                registeredAnimalEClass = createEClass(REGISTERED_ANIMAL);
                createEAttribute(registeredAnimalEClass, REGISTERED_ANIMAL__ANIMNAL_REGISTRATION_ID);
                createEAttribute(registeredAnimalEClass, REGISTERED_ANIMAL__GIVEN_NAME);
                createEReference(registeredAnimalEClass, REGISTERED_ANIMAL__LOCATION);
                createEAttribute(registeredAnimalEClass, REGISTERED_ANIMAL__GENDER);
                createEReference(registeredAnimalEClass, REGISTERED_ANIMAL__ANIMAL_TYPE);
                createEReference(registeredAnimalEClass, REGISTERED_ANIMAL__SIRE_TYPE);
                createEAttribute(registeredAnimalEClass, REGISTERED_ANIMAL__PURPOSE);
                createEAttribute(registeredAnimalEClass, REGISTERED_ANIMAL__DATE_OF_ACQUISITION);
                createEAttribute(registeredAnimalEClass, REGISTERED_ANIMAL__ACQUISITION_TYPE);
                createEReference(registeredAnimalEClass, REGISTERED_ANIMAL__IDENTIFIERS);
                createEAttribute(registeredAnimalEClass, REGISTERED_ANIMAL__IDENTIFYING_FEATURES);
                createEAttribute(registeredAnimalEClass, REGISTERED_ANIMAL__REARING_MODE);
                createEAttribute(registeredAnimalEClass, REGISTERED_ANIMAL__PAST_OWNERS);
                createEAttribute(registeredAnimalEClass, REGISTERED_ANIMAL__INSURANCE_NUMBER);
                createEAttribute(registeredAnimalEClass, REGISTERED_ANIMAL__DATE_OF_BIRTH);

                referenceAnimalTypeEClass = createEClass(REFERENCE_ANIMAL_TYPE);
                createEAttribute(referenceAnimalTypeEClass, REFERENCE_ANIMAL_TYPE__ANIMAL_TYPE_ID);
                createEAttribute(referenceAnimalTypeEClass, REFERENCE_ANIMAL_TYPE__SPECIES);
                createEAttribute(referenceAnimalTypeEClass, REFERENCE_ANIMAL_TYPE__BREED);

                animalIdentifierEClass = createEClass(ANIMAL_IDENTIFIER);
                createEAttribute(animalIdentifierEClass, ANIMAL_IDENTIFIER__ISSUER);
                createEAttribute(animalIdentifierEClass, ANIMAL_IDENTIFIER__VALUE);

                // Create enums
                acquisitionTypeEEnum = createEEnum(ACQUISITION_TYPE);
                purposeEEnum = createEEnum(PURPOSE);
                rearingModeEEnum = createEEnum(REARING_MODE);
                mechanismEEnum = createEEnum(MECHANISM);
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

                // Create type parameters

                // Set bounds for type parameters

                // Add supertypes to classes

                // Initialize classes and features; add operations and parameters
                initEClass(farmEClass, Farm.class, "Farm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEAttribute(getFarm_Name(), ecorePackage.getEString(), "name", null, 0, 1, Farm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEReference(getFarm_Animals(), this.getRegisteredAnimal(), null, "animals", null, 0, -1, Farm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEReference(getFarm_Cans(), this.getContainer(), null, "cans", null, 0, -1, Farm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEReference(getFarm_Location(), theModelPackage.getLocation(), null, "location", null, 0, 1, Farm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getFarm_FarmId(), theModelPackage.getUniqueID(), "farmId", null, 0, 1, Farm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                addEOperation(farmEClass, ecorePackage.getEInt(), "getNumberOfAnimals", 0, 1, IS_UNIQUE, IS_ORDERED);

                addEOperation(farmEClass, ecorePackage.getEInt(), "getNumberOfContainers", 0, 1, IS_UNIQUE, IS_ORDERED);

                initEClass(containerEClass, com.agritrace.edairy.model.tracking.Container.class, "Container", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEAttribute(getContainer_ContainerId(), ecorePackage.getEString(), "containerId", null, 0, 1, com.agritrace.edairy.model.tracking.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEReference(getContainer_Owner(), this.getFarm(), null, "owner", null, 1, 1, com.agritrace.edairy.model.tracking.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getContainer_Capacity(), ecorePackage.getEDouble(), "capacity", null, 0, 1, com.agritrace.edairy.model.tracking.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getContainer_Type(), theModelPackage.getContainerType(), "type", null, 0, 1, com.agritrace.edairy.model.tracking.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getContainer_MeasureType(), theModelPackage.getUnitOfMeasure(), "measureType", null, 0, 1, com.agritrace.edairy.model.tracking.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                initEClass(registeredAnimalEClass, RegisteredAnimal.class, "RegisteredAnimal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEAttribute(getRegisteredAnimal_AnimnalRegistrationId(), ecorePackage.getELong(), "animnalRegistrationId", null, 1, 1, RegisteredAnimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getRegisteredAnimal_GivenName(), ecorePackage.getEString(), "givenName", "", 1, 1, RegisteredAnimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEReference(getRegisteredAnimal_Location(), this.getFarm(), null, "location", null, 1, 1, RegisteredAnimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getRegisteredAnimal_Gender(), theModelPackage.getGender(), "gender", "", 1, 1, RegisteredAnimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEReference(getRegisteredAnimal_AnimalType(), this.getReferenceAnimalType(), null, "animalType", null, 1, 1, RegisteredAnimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEReference(getRegisteredAnimal_SireType(), this.getReferenceAnimalType(), null, "sireType", null, 0, 1, RegisteredAnimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getRegisteredAnimal_Purpose(), this.getPurpose(), "purpose", "", 1, 1, RegisteredAnimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getRegisteredAnimal_DateOfAcquisition(), ecorePackage.getEDate(), "dateOfAcquisition", null, 1, 1, RegisteredAnimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getRegisteredAnimal_AcquisitionType(), this.getAcquisitionType(), "acquisitionType", "", 1, 1, RegisteredAnimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEReference(getRegisteredAnimal_Identifiers(), this.getAnimalIdentifier(), null, "identifiers", null, 0, -1, RegisteredAnimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getRegisteredAnimal_IdentifyingFeatures(), ecorePackage.getEString(), "identifyingFeatures", null, 0, 1, RegisteredAnimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getRegisteredAnimal_RearingMode(), this.getRearingMode(), "rearingMode", "", 1, 1, RegisteredAnimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getRegisteredAnimal_PastOwners(), ecorePackage.getEString(), "pastOwners", null, 0, -1, RegisteredAnimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getRegisteredAnimal_InsuranceNumber(), ecorePackage.getEString(), "insuranceNumber", null, 0, 1, RegisteredAnimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getRegisteredAnimal_DateOfBirth(), ecorePackage.getEDate(), "dateOfBirth", null, 1, 1, RegisteredAnimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                initEClass(referenceAnimalTypeEClass, ReferenceAnimalType.class, "ReferenceAnimalType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEAttribute(getReferenceAnimalType_AnimalTypeId(), ecorePackage.getELong(), "animalTypeId", null, 0, 1, ReferenceAnimalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getReferenceAnimalType_Species(), ecorePackage.getEString(), "species", null, 0, 1, ReferenceAnimalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getReferenceAnimalType_Breed(), ecorePackage.getEString(), "breed", null, 0, 1, ReferenceAnimalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                initEClass(animalIdentifierEClass, AnimalIdentifier.class, "AnimalIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEAttribute(getAnimalIdentifier_Issuer(), ecorePackage.getEString(), "issuer", null, 0, 1, AnimalIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
                initEAttribute(getAnimalIdentifier_Value(), ecorePackage.getEString(), "value", null, 0, 1, AnimalIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                // Initialize enums and add enum literals
                initEEnum(acquisitionTypeEEnum, AcquisitionType.class, "AcquisitionType");
                addEEnumLiteral(acquisitionTypeEEnum, AcquisitionType.BIRTH);
                addEEnumLiteral(acquisitionTypeEEnum, AcquisitionType.PURCHASE);
                addEEnumLiteral(acquisitionTypeEEnum, AcquisitionType.OTHER);

                initEEnum(purposeEEnum, Purpose.class, "Purpose");
                addEEnumLiteral(purposeEEnum, Purpose.DAIRY);
                addEEnumLiteral(purposeEEnum, Purpose.BEEF);
                addEEnumLiteral(purposeEEnum, Purpose.BREEDING);
                addEEnumLiteral(purposeEEnum, Purpose.HIDE);
                addEEnumLiteral(purposeEEnum, Purpose.TRANSPORT);
                addEEnumLiteral(purposeEEnum, Purpose.OTHER);

                initEEnum(rearingModeEEnum, RearingMode.class, "RearingMode");
                addEEnumLiteral(rearingModeEEnum, RearingMode.GRAZE);
                addEEnumLiteral(rearingModeEEnum, RearingMode.ZEROGRAZE);
                addEEnumLiteral(rearingModeEEnum, RearingMode.PASTORALHERD);
                addEEnumLiteral(rearingModeEEnum, RearingMode.OTHER);

                initEEnum(mechanismEEnum, Mechanism.class, "Mechanism");
                addEEnumLiteral(mechanismEEnum, Mechanism.BRAND);
                addEEnumLiteral(mechanismEEnum, Mechanism.BADGE);
                addEEnumLiteral(mechanismEEnum, Mechanism.COLLAR);
                addEEnumLiteral(mechanismEEnum, Mechanism.EARTAG);
                addEEnumLiteral(mechanismEEnum, Mechanism.RFID);
                addEEnumLiteral(mechanismEEnum, Mechanism.GSMGPRS);
                addEEnumLiteral(mechanismEEnum, Mechanism.OTHER);

                // Create resource
                createResource(eNS_URI);
        }

} //TrackingPackageImpl
