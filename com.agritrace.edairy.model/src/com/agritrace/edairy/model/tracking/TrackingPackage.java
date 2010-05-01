/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.tracking;

import com.agritrace.edairy.model.ModelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.model.tracking.TrackingFactory
 * @model kind="package"
 * @generated
 */
public interface TrackingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tracking";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://com.agritrace.edairy.model/tracking/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tracking";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TrackingPackage eINSTANCE = com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.impl.DairyImpl <em>Dairy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.impl.DairyImpl
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getDairy()
	 * @generated
	 */
	int DAIRY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__NAME = ModelPackage.COMPANY__NAME;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__PHONE_NUMBER = ModelPackage.COMPANY__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__LOCATION = ModelPackage.COMPANY__LOCATION;

	/**
	 * The feature id for the '<em><b>Contact Person</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__CONTACT_PERSON = ModelPackage.COMPANY__CONTACT_PERSON;

	/**
	 * The feature id for the '<em><b>Registration Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__REGISTRATION_NUMBER = ModelPackage.COMPANY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dairy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_FEATURE_COUNT = ModelPackage.COMPANY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.impl.FarmImpl <em>Farm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.impl.FarmImpl
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getFarm()
	 * @generated
	 */
	int FARM = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FARM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Animals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FARM__ANIMALS = 1;

	/**
	 * The feature id for the '<em><b>Cans</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FARM__CANS = 2;

	/**
	 * The number of structural features of the '<em>Farm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FARM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.impl.AnimalImpl <em>Animal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.impl.AnimalImpl
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getAnimal()
	 * @generated
	 */
	int ANIMAL = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__NAME = 1;

	/**
	 * The feature id for the '<em><b>Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__BREED = 2;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL__AGE = 3;

	/**
	 * The number of structural features of the '<em>Animal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.impl.ContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.impl.ContainerImpl
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getContainer()
	 * @generated
	 */
	int CONTAINER = 3;

	/**
	 * The feature id for the '<em><b>Container Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__CONTAINER_ID = 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__OWNER = 1;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__CAPACITY = 2;

	/**
	 * The feature id for the '<em><b>Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__UNITS = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__TYPE = 4;

	/**
	 * The feature id for the '<em><b>Measure Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__MEASURE_TYPE = 5;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.impl.ProcessorImpl <em>Processor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.impl.ProcessorImpl
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getProcessor()
	 * @generated
	 */
	int PROCESSOR = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR__NAME = ModelPackage.COMPANY__NAME;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR__PHONE_NUMBER = ModelPackage.COMPANY__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR__LOCATION = ModelPackage.COMPANY__LOCATION;

	/**
	 * The feature id for the '<em><b>Contact Person</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR__CONTACT_PERSON = ModelPackage.COMPANY__CONTACT_PERSON;

	/**
	 * The feature id for the '<em><b>Registration Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR__REGISTRATION_NUMBER = ModelPackage.COMPANY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_FEATURE_COUNT = ModelPackage.COMPANY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.impl.SupplierImpl <em>Supplier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.impl.SupplierImpl
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getSupplier()
	 * @generated
	 */
	int SUPPLIER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__NAME = ModelPackage.COMPANY__NAME;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__PHONE_NUMBER = ModelPackage.COMPANY__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__LOCATION = ModelPackage.COMPANY__LOCATION;

	/**
	 * The feature id for the '<em><b>Contact Person</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__CONTACT_PERSON = ModelPackage.COMPANY__CONTACT_PERSON;

	/**
	 * The number of structural features of the '<em>Supplier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER_FEATURE_COUNT = ModelPackage.COMPANY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.impl.TransferImpl <em>Transfer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.impl.TransferImpl
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getTransfer()
	 * @generated
	 */
	int TRANSFER = 9;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__DATE = 0;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__QUANTITY = 1;

	/**
	 * The feature id for the '<em><b>Dairy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__DAIRY = 2;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER__CONTAINER = 3;

	/**
	 * The number of structural features of the '<em>Transfer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.impl.CollectionImpl <em>Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.impl.CollectionImpl
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getCollection()
	 * @generated
	 */
	int COLLECTION = 6;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__DATE = TRANSFER__DATE;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__QUANTITY = TRANSFER__QUANTITY;

	/**
	 * The feature id for the '<em><b>Dairy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__DAIRY = TRANSFER__DAIRY;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__CONTAINER = TRANSFER__CONTAINER;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__FROM = TRANSFER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contributed To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__CONTRIBUTED_TO = TRANSFER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_FEATURE_COUNT = TRANSFER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.impl.LotImpl <em>Lot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.impl.LotImpl
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getLot()
	 * @generated
	 */
	int LOT = 7;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOT__CONTAINER = 0;

	/**
	 * The number of structural features of the '<em>Lot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.impl.DeliveryImpl <em>Delivery</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.impl.DeliveryImpl
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getDelivery()
	 * @generated
	 */
	int DELIVERY = 8;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY__DATE = TRANSFER__DATE;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY__QUANTITY = TRANSFER__QUANTITY;

	/**
	 * The feature id for the '<em><b>Dairy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY__DAIRY = TRANSFER__DAIRY;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY__CONTAINER = TRANSFER__CONTAINER;

	/**
	 * The feature id for the '<em><b>Lot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY__LOT = TRANSFER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Customer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY__CUSTOMER = TRANSFER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Delivery</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY_FEATURE_COUNT = TRANSFER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.impl.RegisteredAnimalImpl <em>Registered Animal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.impl.RegisteredAnimalImpl
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getRegisteredAnimal()
	 * @generated
	 */
	int REGISTERED_ANIMAL = 10;

	/**
	 * The feature id for the '<em><b>Animnal Registration Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERED_ANIMAL__ANIMNAL_REGISTRATION_ID = 0;

	/**
	 * The feature id for the '<em><b>Given Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERED_ANIMAL__GIVEN_NAME = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERED_ANIMAL__LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Gender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERED_ANIMAL__GENDER = 3;

	/**
	 * The feature id for the '<em><b>Animal Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERED_ANIMAL__ANIMAL_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Sire Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERED_ANIMAL__SIRE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERED_ANIMAL__PURPOSE = 6;

	/**
	 * The feature id for the '<em><b>Date Of Acquisition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERED_ANIMAL__DATE_OF_ACQUISITION = 7;

	/**
	 * The feature id for the '<em><b>Acquisition Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERED_ANIMAL__ACQUISITION_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Identifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERED_ANIMAL__IDENTIFIERS = 9;

	/**
	 * The feature id for the '<em><b>Identifying Features</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERED_ANIMAL__IDENTIFYING_FEATURES = 10;

	/**
	 * The feature id for the '<em><b>Rearing Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERED_ANIMAL__REARING_MODE = 11;

	/**
	 * The feature id for the '<em><b>Past Owners</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERED_ANIMAL__PAST_OWNERS = 12;

	/**
	 * The feature id for the '<em><b>Insurance Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERED_ANIMAL__INSURANCE_NUMBER = 13;

	/**
	 * The number of structural features of the '<em>Registered Animal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERED_ANIMAL_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.impl.ReferenceAnimalTypeImpl <em>Reference Animal Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.impl.ReferenceAnimalTypeImpl
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getReferenceAnimalType()
	 * @generated
	 */
	int REFERENCE_ANIMAL_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Animal Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ANIMAL_TYPE__ANIMAL_TYPE_ID = 0;

	/**
	 * The feature id for the '<em><b>Species</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ANIMAL_TYPE__SPECIES = 1;

	/**
	 * The feature id for the '<em><b>Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ANIMAL_TYPE__BREED = 2;

	/**
	 * The number of structural features of the '<em>Reference Animal Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ANIMAL_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.impl.AnimalIdentifierImpl <em>Animal Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.impl.AnimalIdentifierImpl
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getAnimalIdentifier()
	 * @generated
	 */
	int ANIMAL_IDENTIFIER = 12;

	/**
	 * The feature id for the '<em><b>Issuer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_IDENTIFIER__ISSUER = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_IDENTIFIER__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Animal Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_IDENTIFIER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.UnitOfMeasure <em>Unit Of Measure</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.UnitOfMeasure
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getUnitOfMeasure()
	 * @generated
	 */
	int UNIT_OF_MEASURE = 13;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.ContainerType <em>Container Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.ContainerType
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getContainerType()
	 * @generated
	 */
	int CONTAINER_TYPE = 14;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.AcquisitionType <em>Acquisition Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.AcquisitionType
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getAcquisitionType()
	 * @generated
	 */
	int ACQUISITION_TYPE = 15;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.Purpose <em>Purpose</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.Purpose
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getPurpose()
	 * @generated
	 */
	int PURPOSE = 16;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.RearingMode <em>Rearing Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.RearingMode
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getRearingMode()
	 * @generated
	 */
	int REARING_MODE = 17;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.tracking.Mechanism <em>Mechanism</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.tracking.Mechanism
	 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getMechanism()
	 * @generated
	 */
	int MECHANISM = 18;


	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.tracking.Dairy <em>Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dairy</em>'.
	 * @see com.agritrace.edairy.model.tracking.Dairy
	 * @generated
	 */
	EClass getDairy();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.Dairy#getRegistrationNumber <em>Registration Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registration Number</em>'.
	 * @see com.agritrace.edairy.model.tracking.Dairy#getRegistrationNumber()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_RegistrationNumber();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.tracking.Farm <em>Farm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Farm</em>'.
	 * @see com.agritrace.edairy.model.tracking.Farm
	 * @generated
	 */
	EClass getFarm();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.Farm#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.agritrace.edairy.model.tracking.Farm#getName()
	 * @see #getFarm()
	 * @generated
	 */
	EAttribute getFarm_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.model.tracking.Farm#getAnimals <em>Animals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Animals</em>'.
	 * @see com.agritrace.edairy.model.tracking.Farm#getAnimals()
	 * @see #getFarm()
	 * @generated
	 */
	EReference getFarm_Animals();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.model.tracking.Farm#getCans <em>Cans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cans</em>'.
	 * @see com.agritrace.edairy.model.tracking.Farm#getCans()
	 * @see #getFarm()
	 * @generated
	 */
	EReference getFarm_Cans();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.tracking.Animal <em>Animal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Animal</em>'.
	 * @see com.agritrace.edairy.model.tracking.Animal
	 * @generated
	 */
	EClass getAnimal();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.Animal#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.model.tracking.Animal#getId()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.Animal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.agritrace.edairy.model.tracking.Animal#getName()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.Animal#getBreed <em>Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Breed</em>'.
	 * @see com.agritrace.edairy.model.tracking.Animal#getBreed()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_Breed();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.Animal#getAge <em>Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age</em>'.
	 * @see com.agritrace.edairy.model.tracking.Animal#getAge()
	 * @see #getAnimal()
	 * @generated
	 */
	EAttribute getAnimal_Age();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.tracking.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see com.agritrace.edairy.model.tracking.Container
	 * @generated
	 */
	EClass getContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.Container#getContainerId <em>Container Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container Id</em>'.
	 * @see com.agritrace.edairy.model.tracking.Container#getContainerId()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_ContainerId();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.tracking.Container#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see com.agritrace.edairy.model.tracking.Container#getOwner()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Owner();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.Container#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity</em>'.
	 * @see com.agritrace.edairy.model.tracking.Container#getCapacity()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_Capacity();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.Container#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Units</em>'.
	 * @see com.agritrace.edairy.model.tracking.Container#getUnits()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_Units();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.Container#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.agritrace.edairy.model.tracking.Container#getType()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.Container#getMeasureType <em>Measure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measure Type</em>'.
	 * @see com.agritrace.edairy.model.tracking.Container#getMeasureType()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_MeasureType();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.tracking.Processor <em>Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processor</em>'.
	 * @see com.agritrace.edairy.model.tracking.Processor
	 * @generated
	 */
	EClass getProcessor();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.Processor#getRegistrationNumber <em>Registration Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registration Number</em>'.
	 * @see com.agritrace.edairy.model.tracking.Processor#getRegistrationNumber()
	 * @see #getProcessor()
	 * @generated
	 */
	EAttribute getProcessor_RegistrationNumber();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.tracking.Supplier <em>Supplier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supplier</em>'.
	 * @see com.agritrace.edairy.model.tracking.Supplier
	 * @generated
	 */
	EClass getSupplier();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.tracking.Collection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection</em>'.
	 * @see com.agritrace.edairy.model.tracking.Collection
	 * @generated
	 */
	EClass getCollection();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.tracking.Collection#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see com.agritrace.edairy.model.tracking.Collection#getFrom()
	 * @see #getCollection()
	 * @generated
	 */
	EReference getCollection_From();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.tracking.Collection#getContributedTo <em>Contributed To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Contributed To</em>'.
	 * @see com.agritrace.edairy.model.tracking.Collection#getContributedTo()
	 * @see #getCollection()
	 * @generated
	 */
	EReference getCollection_ContributedTo();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.tracking.Lot <em>Lot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lot</em>'.
	 * @see com.agritrace.edairy.model.tracking.Lot
	 * @generated
	 */
	EClass getLot();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.tracking.Lot#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see com.agritrace.edairy.model.tracking.Lot#getContainer()
	 * @see #getLot()
	 * @generated
	 */
	EReference getLot_Container();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.tracking.Delivery <em>Delivery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delivery</em>'.
	 * @see com.agritrace.edairy.model.tracking.Delivery
	 * @generated
	 */
	EClass getDelivery();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.tracking.Delivery#getLot <em>Lot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lot</em>'.
	 * @see com.agritrace.edairy.model.tracking.Delivery#getLot()
	 * @see #getDelivery()
	 * @generated
	 */
	EReference getDelivery_Lot();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.tracking.Delivery#getCustomer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Customer</em>'.
	 * @see com.agritrace.edairy.model.tracking.Delivery#getCustomer()
	 * @see #getDelivery()
	 * @generated
	 */
	EReference getDelivery_Customer();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.tracking.Transfer <em>Transfer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transfer</em>'.
	 * @see com.agritrace.edairy.model.tracking.Transfer
	 * @generated
	 */
	EClass getTransfer();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.Transfer#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see com.agritrace.edairy.model.tracking.Transfer#getDate()
	 * @see #getTransfer()
	 * @generated
	 */
	EAttribute getTransfer_Date();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.Transfer#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see com.agritrace.edairy.model.tracking.Transfer#getQuantity()
	 * @see #getTransfer()
	 * @generated
	 */
	EAttribute getTransfer_Quantity();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.tracking.Transfer#getDairy <em>Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dairy</em>'.
	 * @see com.agritrace.edairy.model.tracking.Transfer#getDairy()
	 * @see #getTransfer()
	 * @generated
	 */
	EReference getTransfer_Dairy();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.tracking.Transfer#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see com.agritrace.edairy.model.tracking.Transfer#getContainer()
	 * @see #getTransfer()
	 * @generated
	 */
	EReference getTransfer_Container();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.tracking.RegisteredAnimal <em>Registered Animal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Registered Animal</em>'.
	 * @see com.agritrace.edairy.model.tracking.RegisteredAnimal
	 * @generated
	 */
	EClass getRegisteredAnimal();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.RegisteredAnimal#getAnimnalRegistrationId <em>Animnal Registration Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Animnal Registration Id</em>'.
	 * @see com.agritrace.edairy.model.tracking.RegisteredAnimal#getAnimnalRegistrationId()
	 * @see #getRegisteredAnimal()
	 * @generated
	 */
	EAttribute getRegisteredAnimal_AnimnalRegistrationId();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.RegisteredAnimal#getGivenName <em>Given Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Given Name</em>'.
	 * @see com.agritrace.edairy.model.tracking.RegisteredAnimal#getGivenName()
	 * @see #getRegisteredAnimal()
	 * @generated
	 */
	EAttribute getRegisteredAnimal_GivenName();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.tracking.RegisteredAnimal#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Location</em>'.
	 * @see com.agritrace.edairy.model.tracking.RegisteredAnimal#getLocation()
	 * @see #getRegisteredAnimal()
	 * @generated
	 */
	EReference getRegisteredAnimal_Location();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.RegisteredAnimal#getGender <em>Gender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gender</em>'.
	 * @see com.agritrace.edairy.model.tracking.RegisteredAnimal#getGender()
	 * @see #getRegisteredAnimal()
	 * @generated
	 */
	EAttribute getRegisteredAnimal_Gender();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.tracking.RegisteredAnimal#getAnimalType <em>Animal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Animal Type</em>'.
	 * @see com.agritrace.edairy.model.tracking.RegisteredAnimal#getAnimalType()
	 * @see #getRegisteredAnimal()
	 * @generated
	 */
	EReference getRegisteredAnimal_AnimalType();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.tracking.RegisteredAnimal#getSireType <em>Sire Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sire Type</em>'.
	 * @see com.agritrace.edairy.model.tracking.RegisteredAnimal#getSireType()
	 * @see #getRegisteredAnimal()
	 * @generated
	 */
	EReference getRegisteredAnimal_SireType();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.RegisteredAnimal#getPurpose <em>Purpose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Purpose</em>'.
	 * @see com.agritrace.edairy.model.tracking.RegisteredAnimal#getPurpose()
	 * @see #getRegisteredAnimal()
	 * @generated
	 */
	EAttribute getRegisteredAnimal_Purpose();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.RegisteredAnimal#getDateOfAcquisition <em>Date Of Acquisition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Of Acquisition</em>'.
	 * @see com.agritrace.edairy.model.tracking.RegisteredAnimal#getDateOfAcquisition()
	 * @see #getRegisteredAnimal()
	 * @generated
	 */
	EAttribute getRegisteredAnimal_DateOfAcquisition();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.RegisteredAnimal#getAcquisitionType <em>Acquisition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Acquisition Type</em>'.
	 * @see com.agritrace.edairy.model.tracking.RegisteredAnimal#getAcquisitionType()
	 * @see #getRegisteredAnimal()
	 * @generated
	 */
	EAttribute getRegisteredAnimal_AcquisitionType();

	/**
	 * Returns the meta object for the reference list '{@link com.agritrace.edairy.model.tracking.RegisteredAnimal#getIdentifiers <em>Identifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Identifiers</em>'.
	 * @see com.agritrace.edairy.model.tracking.RegisteredAnimal#getIdentifiers()
	 * @see #getRegisteredAnimal()
	 * @generated
	 */
	EReference getRegisteredAnimal_Identifiers();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.RegisteredAnimal#getIdentifyingFeatures <em>Identifying Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifying Features</em>'.
	 * @see com.agritrace.edairy.model.tracking.RegisteredAnimal#getIdentifyingFeatures()
	 * @see #getRegisteredAnimal()
	 * @generated
	 */
	EAttribute getRegisteredAnimal_IdentifyingFeatures();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.RegisteredAnimal#getRearingMode <em>Rearing Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rearing Mode</em>'.
	 * @see com.agritrace.edairy.model.tracking.RegisteredAnimal#getRearingMode()
	 * @see #getRegisteredAnimal()
	 * @generated
	 */
	EAttribute getRegisteredAnimal_RearingMode();

	/**
	 * Returns the meta object for the attribute list '{@link com.agritrace.edairy.model.tracking.RegisteredAnimal#getPastOwners <em>Past Owners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Past Owners</em>'.
	 * @see com.agritrace.edairy.model.tracking.RegisteredAnimal#getPastOwners()
	 * @see #getRegisteredAnimal()
	 * @generated
	 */
	EAttribute getRegisteredAnimal_PastOwners();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.RegisteredAnimal#getInsuranceNumber <em>Insurance Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Insurance Number</em>'.
	 * @see com.agritrace.edairy.model.tracking.RegisteredAnimal#getInsuranceNumber()
	 * @see #getRegisteredAnimal()
	 * @generated
	 */
	EAttribute getRegisteredAnimal_InsuranceNumber();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.tracking.ReferenceAnimalType <em>Reference Animal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Animal Type</em>'.
	 * @see com.agritrace.edairy.model.tracking.ReferenceAnimalType
	 * @generated
	 */
	EClass getReferenceAnimalType();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.ReferenceAnimalType#getAnimalTypeId <em>Animal Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Animal Type Id</em>'.
	 * @see com.agritrace.edairy.model.tracking.ReferenceAnimalType#getAnimalTypeId()
	 * @see #getReferenceAnimalType()
	 * @generated
	 */
	EAttribute getReferenceAnimalType_AnimalTypeId();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.ReferenceAnimalType#getSpecies <em>Species</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Species</em>'.
	 * @see com.agritrace.edairy.model.tracking.ReferenceAnimalType#getSpecies()
	 * @see #getReferenceAnimalType()
	 * @generated
	 */
	EAttribute getReferenceAnimalType_Species();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.ReferenceAnimalType#getBreed <em>Breed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Breed</em>'.
	 * @see com.agritrace.edairy.model.tracking.ReferenceAnimalType#getBreed()
	 * @see #getReferenceAnimalType()
	 * @generated
	 */
	EAttribute getReferenceAnimalType_Breed();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.tracking.AnimalIdentifier <em>Animal Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Animal Identifier</em>'.
	 * @see com.agritrace.edairy.model.tracking.AnimalIdentifier
	 * @generated
	 */
	EClass getAnimalIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.AnimalIdentifier#getIssuer <em>Issuer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Issuer</em>'.
	 * @see com.agritrace.edairy.model.tracking.AnimalIdentifier#getIssuer()
	 * @see #getAnimalIdentifier()
	 * @generated
	 */
	EAttribute getAnimalIdentifier_Issuer();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.tracking.AnimalIdentifier#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.agritrace.edairy.model.tracking.AnimalIdentifier#getValue()
	 * @see #getAnimalIdentifier()
	 * @generated
	 */
	EAttribute getAnimalIdentifier_Value();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.model.tracking.UnitOfMeasure <em>Unit Of Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unit Of Measure</em>'.
	 * @see com.agritrace.edairy.model.tracking.UnitOfMeasure
	 * @generated
	 */
	EEnum getUnitOfMeasure();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.model.tracking.ContainerType <em>Container Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Container Type</em>'.
	 * @see com.agritrace.edairy.model.tracking.ContainerType
	 * @generated
	 */
	EEnum getContainerType();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.model.tracking.AcquisitionType <em>Acquisition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Acquisition Type</em>'.
	 * @see com.agritrace.edairy.model.tracking.AcquisitionType
	 * @generated
	 */
	EEnum getAcquisitionType();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.model.tracking.Purpose <em>Purpose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Purpose</em>'.
	 * @see com.agritrace.edairy.model.tracking.Purpose
	 * @generated
	 */
	EEnum getPurpose();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.model.tracking.RearingMode <em>Rearing Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rearing Mode</em>'.
	 * @see com.agritrace.edairy.model.tracking.RearingMode
	 * @generated
	 */
	EEnum getRearingMode();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.model.tracking.Mechanism <em>Mechanism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Mechanism</em>'.
	 * @see com.agritrace.edairy.model.tracking.Mechanism
	 * @generated
	 */
	EEnum getMechanism();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TrackingFactory getTrackingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.impl.DairyImpl <em>Dairy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.impl.DairyImpl
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getDairy()
		 * @generated
		 */
		EClass DAIRY = eINSTANCE.getDairy();

		/**
		 * The meta object literal for the '<em><b>Registration Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY__REGISTRATION_NUMBER = eINSTANCE.getDairy_RegistrationNumber();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.impl.FarmImpl <em>Farm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.impl.FarmImpl
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getFarm()
		 * @generated
		 */
		EClass FARM = eINSTANCE.getFarm();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FARM__NAME = eINSTANCE.getFarm_Name();

		/**
		 * The meta object literal for the '<em><b>Animals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FARM__ANIMALS = eINSTANCE.getFarm_Animals();

		/**
		 * The meta object literal for the '<em><b>Cans</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FARM__CANS = eINSTANCE.getFarm_Cans();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.impl.AnimalImpl <em>Animal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.impl.AnimalImpl
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getAnimal()
		 * @generated
		 */
		EClass ANIMAL = eINSTANCE.getAnimal();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__ID = eINSTANCE.getAnimal_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__NAME = eINSTANCE.getAnimal_Name();

		/**
		 * The meta object literal for the '<em><b>Breed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__BREED = eINSTANCE.getAnimal_Breed();

		/**
		 * The meta object literal for the '<em><b>Age</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL__AGE = eINSTANCE.getAnimal_Age();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.impl.ContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.impl.ContainerImpl
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getContainer()
		 * @generated
		 */
		EClass CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em><b>Container Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__CONTAINER_ID = eINSTANCE.getContainer_ContainerId();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__OWNER = eINSTANCE.getContainer_Owner();

		/**
		 * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__CAPACITY = eINSTANCE.getContainer_Capacity();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__UNITS = eINSTANCE.getContainer_Units();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__TYPE = eINSTANCE.getContainer_Type();

		/**
		 * The meta object literal for the '<em><b>Measure Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__MEASURE_TYPE = eINSTANCE.getContainer_MeasureType();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.impl.ProcessorImpl <em>Processor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.impl.ProcessorImpl
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getProcessor()
		 * @generated
		 */
		EClass PROCESSOR = eINSTANCE.getProcessor();

		/**
		 * The meta object literal for the '<em><b>Registration Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR__REGISTRATION_NUMBER = eINSTANCE.getProcessor_RegistrationNumber();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.impl.SupplierImpl <em>Supplier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.impl.SupplierImpl
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getSupplier()
		 * @generated
		 */
		EClass SUPPLIER = eINSTANCE.getSupplier();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.impl.CollectionImpl <em>Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.impl.CollectionImpl
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getCollection()
		 * @generated
		 */
		EClass COLLECTION = eINSTANCE.getCollection();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION__FROM = eINSTANCE.getCollection_From();

		/**
		 * The meta object literal for the '<em><b>Contributed To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION__CONTRIBUTED_TO = eINSTANCE.getCollection_ContributedTo();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.impl.LotImpl <em>Lot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.impl.LotImpl
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getLot()
		 * @generated
		 */
		EClass LOT = eINSTANCE.getLot();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOT__CONTAINER = eINSTANCE.getLot_Container();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.impl.DeliveryImpl <em>Delivery</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.impl.DeliveryImpl
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getDelivery()
		 * @generated
		 */
		EClass DELIVERY = eINSTANCE.getDelivery();

		/**
		 * The meta object literal for the '<em><b>Lot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELIVERY__LOT = eINSTANCE.getDelivery_Lot();

		/**
		 * The meta object literal for the '<em><b>Customer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELIVERY__CUSTOMER = eINSTANCE.getDelivery_Customer();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.impl.TransferImpl <em>Transfer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.impl.TransferImpl
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getTransfer()
		 * @generated
		 */
		EClass TRANSFER = eINSTANCE.getTransfer();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFER__DATE = eINSTANCE.getTransfer_Date();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFER__QUANTITY = eINSTANCE.getTransfer_Quantity();

		/**
		 * The meta object literal for the '<em><b>Dairy</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFER__DAIRY = eINSTANCE.getTransfer_Dairy();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFER__CONTAINER = eINSTANCE.getTransfer_Container();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.impl.RegisteredAnimalImpl <em>Registered Animal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.impl.RegisteredAnimalImpl
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getRegisteredAnimal()
		 * @generated
		 */
		EClass REGISTERED_ANIMAL = eINSTANCE.getRegisteredAnimal();

		/**
		 * The meta object literal for the '<em><b>Animnal Registration Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTERED_ANIMAL__ANIMNAL_REGISTRATION_ID = eINSTANCE.getRegisteredAnimal_AnimnalRegistrationId();

		/**
		 * The meta object literal for the '<em><b>Given Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTERED_ANIMAL__GIVEN_NAME = eINSTANCE.getRegisteredAnimal_GivenName();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERED_ANIMAL__LOCATION = eINSTANCE.getRegisteredAnimal_Location();

		/**
		 * The meta object literal for the '<em><b>Gender</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTERED_ANIMAL__GENDER = eINSTANCE.getRegisteredAnimal_Gender();

		/**
		 * The meta object literal for the '<em><b>Animal Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERED_ANIMAL__ANIMAL_TYPE = eINSTANCE.getRegisteredAnimal_AnimalType();

		/**
		 * The meta object literal for the '<em><b>Sire Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERED_ANIMAL__SIRE_TYPE = eINSTANCE.getRegisteredAnimal_SireType();

		/**
		 * The meta object literal for the '<em><b>Purpose</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTERED_ANIMAL__PURPOSE = eINSTANCE.getRegisteredAnimal_Purpose();

		/**
		 * The meta object literal for the '<em><b>Date Of Acquisition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTERED_ANIMAL__DATE_OF_ACQUISITION = eINSTANCE.getRegisteredAnimal_DateOfAcquisition();

		/**
		 * The meta object literal for the '<em><b>Acquisition Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTERED_ANIMAL__ACQUISITION_TYPE = eINSTANCE.getRegisteredAnimal_AcquisitionType();

		/**
		 * The meta object literal for the '<em><b>Identifiers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERED_ANIMAL__IDENTIFIERS = eINSTANCE.getRegisteredAnimal_Identifiers();

		/**
		 * The meta object literal for the '<em><b>Identifying Features</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTERED_ANIMAL__IDENTIFYING_FEATURES = eINSTANCE.getRegisteredAnimal_IdentifyingFeatures();

		/**
		 * The meta object literal for the '<em><b>Rearing Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTERED_ANIMAL__REARING_MODE = eINSTANCE.getRegisteredAnimal_RearingMode();

		/**
		 * The meta object literal for the '<em><b>Past Owners</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTERED_ANIMAL__PAST_OWNERS = eINSTANCE.getRegisteredAnimal_PastOwners();

		/**
		 * The meta object literal for the '<em><b>Insurance Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTERED_ANIMAL__INSURANCE_NUMBER = eINSTANCE.getRegisteredAnimal_InsuranceNumber();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.impl.ReferenceAnimalTypeImpl <em>Reference Animal Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.impl.ReferenceAnimalTypeImpl
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getReferenceAnimalType()
		 * @generated
		 */
		EClass REFERENCE_ANIMAL_TYPE = eINSTANCE.getReferenceAnimalType();

		/**
		 * The meta object literal for the '<em><b>Animal Type Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_ANIMAL_TYPE__ANIMAL_TYPE_ID = eINSTANCE.getReferenceAnimalType_AnimalTypeId();

		/**
		 * The meta object literal for the '<em><b>Species</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_ANIMAL_TYPE__SPECIES = eINSTANCE.getReferenceAnimalType_Species();

		/**
		 * The meta object literal for the '<em><b>Breed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_ANIMAL_TYPE__BREED = eINSTANCE.getReferenceAnimalType_Breed();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.impl.AnimalIdentifierImpl <em>Animal Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.impl.AnimalIdentifierImpl
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getAnimalIdentifier()
		 * @generated
		 */
		EClass ANIMAL_IDENTIFIER = eINSTANCE.getAnimalIdentifier();

		/**
		 * The meta object literal for the '<em><b>Issuer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL_IDENTIFIER__ISSUER = eINSTANCE.getAnimalIdentifier_Issuer();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL_IDENTIFIER__VALUE = eINSTANCE.getAnimalIdentifier_Value();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.UnitOfMeasure <em>Unit Of Measure</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.UnitOfMeasure
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getUnitOfMeasure()
		 * @generated
		 */
		EEnum UNIT_OF_MEASURE = eINSTANCE.getUnitOfMeasure();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.ContainerType <em>Container Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.ContainerType
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getContainerType()
		 * @generated
		 */
		EEnum CONTAINER_TYPE = eINSTANCE.getContainerType();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.AcquisitionType <em>Acquisition Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.AcquisitionType
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getAcquisitionType()
		 * @generated
		 */
		EEnum ACQUISITION_TYPE = eINSTANCE.getAcquisitionType();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.Purpose <em>Purpose</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.Purpose
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getPurpose()
		 * @generated
		 */
		EEnum PURPOSE = eINSTANCE.getPurpose();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.RearingMode <em>Rearing Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.RearingMode
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getRearingMode()
		 * @generated
		 */
		EEnum REARING_MODE = eINSTANCE.getRearingMode();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.tracking.Mechanism <em>Mechanism</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.tracking.Mechanism
		 * @see com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl#getMechanism()
		 * @generated
		 */
		EEnum MECHANISM = eINSTANCE.getMechanism();

	}

} //TrackingPackage
