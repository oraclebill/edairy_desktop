/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy;

import com.agritrace.edairy.model.ModelPackage;

import com.agritrace.edairy.model.tracking.TrackingPackage;

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
 * @see com.agritrace.edairy.model.dairy.DairyFactory
 * @model kind="package"
 * @generated
 */
public interface DairyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dairy";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://com.agritrace.edairy.model/dairy/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dairy";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DairyPackage eINSTANCE = com.agritrace.edairy.model.dairy.impl.DairyPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.impl.AssetImpl <em>Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.impl.AssetImpl
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getAsset()
	 * @generated
	 */
	int ASSET = 10;

	/**
	 * The feature id for the '<em><b>Asset Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__ASSET_ID = 0;

	/**
	 * The feature id for the '<em><b>Tag Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__TAG_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Tag Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__TAG_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Date Acquired</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DATE_ACQUIRED = 3;

	/**
	 * The feature id for the '<em><b>Damage Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DAMAGE_DATE = 4;

	/**
	 * The feature id for the '<em><b>Damage Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DAMAGE_DESCRIPTION = 5;

	/**
	 * The feature id for the '<em><b>Date Disposed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DATE_DISPOSED = 6;

	/**
	 * The feature id for the '<em><b>Disposal Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DISPOSAL_REASON = 7;

	/**
	 * The feature id for the '<em><b>Disposal Witness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DISPOSAL_WITNESS = 8;

	/**
	 * The number of structural features of the '<em>Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.impl.VehicleImpl <em>Vehicle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.impl.VehicleImpl
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getVehicle()
	 * @generated
	 */
	int VEHICLE = 0;

	/**
	 * The feature id for the '<em><b>Asset Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__ASSET_ID = ASSET__ASSET_ID;

	/**
	 * The feature id for the '<em><b>Tag Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__TAG_TYPE = ASSET__TAG_TYPE;

	/**
	 * The feature id for the '<em><b>Tag Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__TAG_VALUE = ASSET__TAG_VALUE;

	/**
	 * The feature id for the '<em><b>Date Acquired</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__DATE_ACQUIRED = ASSET__DATE_ACQUIRED;

	/**
	 * The feature id for the '<em><b>Damage Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__DAMAGE_DATE = ASSET__DAMAGE_DATE;

	/**
	 * The feature id for the '<em><b>Damage Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__DAMAGE_DESCRIPTION = ASSET__DAMAGE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Date Disposed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__DATE_DISPOSED = ASSET__DATE_DISPOSED;

	/**
	 * The feature id for the '<em><b>Disposal Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__DISPOSAL_REASON = ASSET__DISPOSAL_REASON;

	/**
	 * The feature id for the '<em><b>Disposal Witness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__DISPOSAL_WITNESS = ASSET__DISPOSAL_WITNESS;

	/**
	 * The feature id for the '<em><b>Registration Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__REGISTRATION_NUMBER = ASSET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__TYPE = ASSET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Make</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__MAKE = ASSET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__MODEL = ASSET_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Engine Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__ENGINE_NUMBER = ASSET_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Chassis Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__CHASSIS_NUMBER = ASSET_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Log Book Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__LOG_BOOK_NUMBER = ASSET_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Insurance Policy Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__INSURANCE_POLICY_NUMBER = ASSET_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Insurance Purchase Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__INSURANCE_PURCHASE_DATE = ASSET_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Dominant Colour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__DOMINANT_COLOUR = ASSET_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Capacity In Tonnes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__CAPACITY_IN_TONNES = ASSET_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Driver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__DRIVER = ASSET_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_FEATURE_COUNT = ASSET_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.impl.CollectionJournalLineImpl <em>Collection Journal Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.impl.CollectionJournalLineImpl
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getCollectionJournalLine()
	 * @generated
	 */
	int COLLECTION_JOURNAL_LINE = 1;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__LINE_NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Recorded Member</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__RECORDED_MEMBER = 1;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__QUANTITY = 2;

	/**
	 * The feature id for the '<em><b>Flagged</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__FLAGGED = 3;

	/**
	 * The feature id for the '<em><b>Unit Of Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__UNIT_OF_MEASURE = 4;

	/**
	 * The feature id for the '<em><b>Not Recorded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__NOT_RECORDED = 5;

	/**
	 * The feature id for the '<em><b>Validated Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__VALIDATED_MEMBER = 6;

	/**
	 * The feature id for the '<em><b>Off Route</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__OFF_ROUTE = 7;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__FROM = 8;

	/**
	 * The feature id for the '<em><b>Farm Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__FARM_CONTAINER = 9;

	/**
	 * The feature id for the '<em><b>Dairy Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__DAIRY_CONTAINER = 10;

	/**
	 * The feature id for the '<em><b>Collection Journal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__COLLECTION_JOURNAL = 11;

	/**
	 * The feature id for the '<em><b>Rejected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__REJECTED = 12;

	/**
	 * The number of structural features of the '<em>Collection Journal Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE_FEATURE_COUNT = 13;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.impl.EmployeeImpl <em>Employee</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.impl.EmployeeImpl
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getEmployee()
	 * @generated
	 */
	int EMPLOYEE = 2;

	/**
	 * The feature id for the '<em><b>Party Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__PARTY_ID = ModelPackage.PERSON__PARTY_ID;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__PHONE_NUMBER = ModelPackage.PERSON__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__LOCATION = ModelPackage.PERSON__LOCATION;

	/**
	 * The feature id for the '<em><b>Contact Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__CONTACT_METHODS = ModelPackage.PERSON__CONTACT_METHODS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__NAME = ModelPackage.PERSON__NAME;

	/**
	 * The feature id for the '<em><b>Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__PHOTO = ModelPackage.PERSON__PHOTO;

	/**
	 * The feature id for the '<em><b>Honorific</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__HONORIFIC = ModelPackage.PERSON__HONORIFIC;

	/**
	 * The feature id for the '<em><b>Family Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__FAMILY_NAME = ModelPackage.PERSON__FAMILY_NAME;

	/**
	 * The feature id for the '<em><b>Given Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__GIVEN_NAME = ModelPackage.PERSON__GIVEN_NAME;

	/**
	 * The feature id for the '<em><b>Middle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__MIDDLE_NAME = ModelPackage.PERSON__MIDDLE_NAME;

	/**
	 * The feature id for the '<em><b>Additional Names</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__ADDITIONAL_NAMES = ModelPackage.PERSON__ADDITIONAL_NAMES;

	/**
	 * The feature id for the '<em><b>Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__SUFFIX = ModelPackage.PERSON__SUFFIX;

	/**
	 * The feature id for the '<em><b>Nick Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__NICK_NAME = ModelPackage.PERSON__NICK_NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__ID = ModelPackage.PERSON_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__START_DATE = ModelPackage.PERSON_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Job Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__JOB_FUNCTION = ModelPackage.PERSON_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>National Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__NATIONAL_ID = ModelPackage.PERSON_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Nhif Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__NHIF_NUMBER = ModelPackage.PERSON_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Nssf Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__NSSF_NUMBER = ModelPackage.PERSON_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Employee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE_FEATURE_COUNT = ModelPackage.PERSON_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.impl.DairyLocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.impl.DairyLocationImpl
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getDairyLocation()
	 * @generated
	 */
	int DAIRY_LOCATION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Date Opened</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__DATE_OPENED = 1;

	/**
	 * The feature id for the '<em><b>Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__PHONE = 2;

	/**
	 * The feature id for the '<em><b>Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__ROUTE = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__DESCRIPTION = 4;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__CODE = 5;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__LOCATION = 6;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__FUNCTIONS = 7;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.impl.CollectionJournalImpl <em>Collection Journal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.impl.CollectionJournalImpl
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getCollectionJournal()
	 * @generated
	 */
	int COLLECTION_JOURNAL = 4;

	/**
	 * The feature id for the '<em><b>Journal Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__JOURNAL_ENTRIES = 0;

	/**
	 * The feature id for the '<em><b>Reference Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__REFERENCE_NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Journal Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__JOURNAL_DATE = 2;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__SESSION = 3;

	/**
	 * The feature id for the '<em><b>Driver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__DRIVER = 4;

	/**
	 * The feature id for the '<em><b>Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__ROUTE = 5;

	/**
	 * The feature id for the '<em><b>Farm Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__FARM_CONTAINER = 6;

	/**
	 * The feature id for the '<em><b>Bin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__BIN = 7;

	/**
	 * The feature id for the '<em><b>Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__VEHICLE = 8;

	/**
	 * The feature id for the '<em><b>Driver Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__DRIVER_TOTAL = 9;

	/**
	 * The feature id for the '<em><b>Record Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__RECORD_TOTAL = 10;

	/**
	 * The number of structural features of the '<em>Collection Journal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.impl.RouteImpl <em>Route</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.impl.RouteImpl
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getRoute()
	 * @generated
	 */
	int ROUTE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Stops</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__STOPS = 1;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__CODE = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__DESCRIPTION = 3;

	/**
	 * The number of structural features of the '<em>Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.impl.TripImpl <em>Trip</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.impl.TripImpl
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getTrip()
	 * @generated
	 */
	int TRIP = 6;

	/**
	 * The feature id for the '<em><b>Collections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIP__COLLECTIONS = 0;

	/**
	 * The feature id for the '<em><b>Deliveries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIP__DELIVERIES = 1;

	/**
	 * The feature id for the '<em><b>Started</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIP__STARTED = 2;

	/**
	 * The feature id for the '<em><b>Ended</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIP__ENDED = 3;

	/**
	 * The number of structural features of the '<em>Trip</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIP_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.impl.DeliveryJournalImpl <em>Delivery Journal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.impl.DeliveryJournalImpl
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getDeliveryJournal()
	 * @generated
	 */
	int DELIVERY_JOURNAL = 7;

	/**
	 * The feature id for the '<em><b>Reference Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY_JOURNAL__REFERENCE_NUMBER = 0;

	/**
	 * The number of structural features of the '<em>Delivery Journal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY_JOURNAL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.impl.DairyImpl <em>Dairy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.impl.DairyImpl
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getDairy()
	 * @generated
	 */
	int DAIRY = 8;

	/**
	 * The feature id for the '<em><b>Party Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__PARTY_ID = ModelPackage.COMPANY__PARTY_ID;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__PHONE_NUMBER = ModelPackage.COMPANY__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__LOCATION = ModelPackage.COMPANY__LOCATION;

	/**
	 * The feature id for the '<em><b>Contact Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__CONTACT_METHODS = ModelPackage.COMPANY__CONTACT_METHODS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__NAME = ModelPackage.COMPANY__NAME;

	/**
	 * The feature id for the '<em><b>Contacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__CONTACTS = ModelPackage.COMPANY__CONTACTS;

	/**
	 * The feature id for the '<em><b>Legal Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__LEGAL_NAME = ModelPackage.COMPANY__LEGAL_NAME;

	/**
	 * The feature id for the '<em><b>Company Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__COMPANY_NAME = ModelPackage.COMPANY__COMPANY_NAME;

	/**
	 * The feature id for the '<em><b>Nhif Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__NHIF_NUMBER = ModelPackage.COMPANY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nssf Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__NSSF_NUMBER = ModelPackage.COMPANY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Federal Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__FEDERAL_PIN = ModelPackage.COMPANY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Routes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__ROUTES = ModelPackage.COMPANY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Vehicles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__VEHICLES = ModelPackage.COMPANY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Employees</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__EMPLOYEES = ModelPackage.COMPANY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Memberships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__MEMBERSHIPS = ModelPackage.COMPANY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Branch Locations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__BRANCH_LOCATIONS = ModelPackage.COMPANY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Registration Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__REGISTRATION_NUMBER = ModelPackage.COMPANY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Collection Journals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__COLLECTION_JOURNALS = ModelPackage.COMPANY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Suppliers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__SUPPLIERS = ModelPackage.COMPANY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Animal Health Requests</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__ANIMAL_HEALTH_REQUESTS = ModelPackage.COMPANY_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Dairy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_FEATURE_COUNT = ModelPackage.COMPANY_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.impl.MembershipImpl <em>Membership</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.impl.MembershipImpl
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getMembership()
	 * @generated
	 */
	int MEMBERSHIP = 9;

	/**
	 * The feature id for the '<em><b>Member Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__MEMBER_ID = 0;

	/**
	 * The feature id for the '<em><b>Application Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__APPLICATION_DATE = 1;

	/**
	 * The feature id for the '<em><b>Effective Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__EFFECTIVE_DATE = 2;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__STATUS = 3;

	/**
	 * The feature id for the '<em><b>Default Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__DEFAULT_ROUTE = 4;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__MEMBER = 5;

	/**
	 * The feature id for the '<em><b>Farms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__FARMS = 6;

	/**
	 * The number of structural features of the '<em>Membership</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.impl.DairyContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.impl.DairyContainerImpl
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getDairyContainer()
	 * @generated
	 */
	int DAIRY_CONTAINER = 11;

	/**
	 * The feature id for the '<em><b>Container Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER__CONTAINER_ID = TrackingPackage.CONTAINER__CONTAINER_ID;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER__OWNER = TrackingPackage.CONTAINER__OWNER;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER__CAPACITY = TrackingPackage.CONTAINER__CAPACITY;

	/**
	 * The feature id for the '<em><b>Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER__UNITS = TrackingPackage.CONTAINER__UNITS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER__TYPE = TrackingPackage.CONTAINER__TYPE;

	/**
	 * The feature id for the '<em><b>Measure Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER__MEASURE_TYPE = TrackingPackage.CONTAINER__MEASURE_TYPE;

	/**
	 * The feature id for the '<em><b>Asset Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER__ASSET_ID = TrackingPackage.CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tag Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER__TAG_TYPE = TrackingPackage.CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tag Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER__TAG_VALUE = TrackingPackage.CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Date Acquired</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER__DATE_ACQUIRED = TrackingPackage.CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Damage Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER__DAMAGE_DATE = TrackingPackage.CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Damage Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER__DAMAGE_DESCRIPTION = TrackingPackage.CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Date Disposed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER__DATE_DISPOSED = TrackingPackage.CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Disposal Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER__DISPOSAL_REASON = TrackingPackage.CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Disposal Witness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER__DISPOSAL_WITNESS = TrackingPackage.CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_CONTAINER_FEATURE_COUNT = TrackingPackage.CONTAINER_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.impl.SupplierImpl <em>Supplier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.impl.SupplierImpl
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getSupplier()
	 * @generated
	 */
	int SUPPLIER = 12;

	/**
	 * The feature id for the '<em><b>Party Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__PARTY_ID = ModelPackage.PERSON__PARTY_ID;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__PHONE_NUMBER = ModelPackage.PERSON__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__LOCATION = ModelPackage.PERSON__LOCATION;

	/**
	 * The feature id for the '<em><b>Contact Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__CONTACT_METHODS = ModelPackage.PERSON__CONTACT_METHODS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__NAME = ModelPackage.PERSON__NAME;

	/**
	 * The feature id for the '<em><b>Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__PHOTO = ModelPackage.PERSON__PHOTO;

	/**
	 * The feature id for the '<em><b>Honorific</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__HONORIFIC = ModelPackage.PERSON__HONORIFIC;

	/**
	 * The feature id for the '<em><b>Family Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__FAMILY_NAME = ModelPackage.PERSON__FAMILY_NAME;

	/**
	 * The feature id for the '<em><b>Given Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__GIVEN_NAME = ModelPackage.PERSON__GIVEN_NAME;

	/**
	 * The feature id for the '<em><b>Middle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__MIDDLE_NAME = ModelPackage.PERSON__MIDDLE_NAME;

	/**
	 * The feature id for the '<em><b>Additional Names</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__ADDITIONAL_NAMES = ModelPackage.PERSON__ADDITIONAL_NAMES;

	/**
	 * The feature id for the '<em><b>Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__SUFFIX = ModelPackage.PERSON__SUFFIX;

	/**
	 * The feature id for the '<em><b>Nick Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__NICK_NAME = ModelPackage.PERSON__NICK_NAME;

	/**
	 * The feature id for the '<em><b>Supplier Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__SUPPLIER_ID = ModelPackage.PERSON_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__CATEGORIES = ModelPackage.PERSON_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Public Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__PUBLIC_DESCRIPTION = ModelPackage.PERSON_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__STATUS = ModelPackage.PERSON_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Registration Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__REGISTRATION_DATE = ModelPackage.PERSON_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Expiration Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__EXPIRATION_DATE = ModelPackage.PERSON_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__NOTES = ModelPackage.PERSON_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__RATING = ModelPackage.PERSON_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Supplier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER_FEATURE_COUNT = ModelPackage.PERSON_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.MembershipStatus <em>Membership Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.MembershipStatus
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getMembershipStatus()
	 * @generated
	 */
	int MEMBERSHIP_STATUS = 13;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.Session <em>Session</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.Session
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getSession()
	 * @generated
	 */
	int SESSION = 14;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.VendorStatus <em>Vendor Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.VendorStatus
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getVendorStatus()
	 * @generated
	 */
	int VENDOR_STATUS = 15;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.model.dairy.DairyFunction <em>Function</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.model.dairy.DairyFunction
	 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getDairyFunction()
	 * @generated
	 */
	int DAIRY_FUNCTION = 16;


	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.dairy.Vehicle <em>Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vehicle</em>'.
	 * @see com.agritrace.edairy.model.dairy.Vehicle
	 * @generated
	 */
	EClass getVehicle();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Vehicle#getRegistrationNumber <em>Registration Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registration Number</em>'.
	 * @see com.agritrace.edairy.model.dairy.Vehicle#getRegistrationNumber()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_RegistrationNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Vehicle#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.agritrace.edairy.model.dairy.Vehicle#getType()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Vehicle#getMake <em>Make</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Make</em>'.
	 * @see com.agritrace.edairy.model.dairy.Vehicle#getMake()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_Make();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Vehicle#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model</em>'.
	 * @see com.agritrace.edairy.model.dairy.Vehicle#getModel()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_Model();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Vehicle#getEngineNumber <em>Engine Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Engine Number</em>'.
	 * @see com.agritrace.edairy.model.dairy.Vehicle#getEngineNumber()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_EngineNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Vehicle#getChassisNumber <em>Chassis Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chassis Number</em>'.
	 * @see com.agritrace.edairy.model.dairy.Vehicle#getChassisNumber()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_ChassisNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Vehicle#getLogBookNumber <em>Log Book Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Book Number</em>'.
	 * @see com.agritrace.edairy.model.dairy.Vehicle#getLogBookNumber()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_LogBookNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Vehicle#getInsurancePolicyNumber <em>Insurance Policy Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Insurance Policy Number</em>'.
	 * @see com.agritrace.edairy.model.dairy.Vehicle#getInsurancePolicyNumber()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_InsurancePolicyNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Vehicle#getInsurancePurchaseDate <em>Insurance Purchase Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Insurance Purchase Date</em>'.
	 * @see com.agritrace.edairy.model.dairy.Vehicle#getInsurancePurchaseDate()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_InsurancePurchaseDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Vehicle#getDominantColour <em>Dominant Colour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dominant Colour</em>'.
	 * @see com.agritrace.edairy.model.dairy.Vehicle#getDominantColour()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_DominantColour();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Vehicle#getCapacityInTonnes <em>Capacity In Tonnes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity In Tonnes</em>'.
	 * @see com.agritrace.edairy.model.dairy.Vehicle#getCapacityInTonnes()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_CapacityInTonnes();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.dairy.Vehicle#getDriver <em>Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Driver</em>'.
	 * @see com.agritrace.edairy.model.dairy.Vehicle#getDriver()
	 * @see #getVehicle()
	 * @generated
	 */
	EReference getVehicle_Driver();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.dairy.CollectionJournalLine <em>Collection Journal Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Journal Line</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournalLine
	 * @generated
	 */
	EClass getCollectionJournalLine();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.CollectionJournalLine#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournalLine#getLineNumber()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_LineNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.CollectionJournalLine#getRecordedMember <em>Recorded Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recorded Member</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournalLine#getRecordedMember()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_RecordedMember();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.CollectionJournalLine#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournalLine#getQuantity()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_Quantity();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.CollectionJournalLine#isFlagged <em>Flagged</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flagged</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournalLine#isFlagged()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_Flagged();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.CollectionJournalLine#getUnitOfMeasure <em>Unit Of Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit Of Measure</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournalLine#getUnitOfMeasure()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_UnitOfMeasure();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.CollectionJournalLine#isNotRecorded <em>Not Recorded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Not Recorded</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournalLine#isNotRecorded()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_NotRecorded();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.dairy.CollectionJournalLine#getValidatedMember <em>Validated Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Validated Member</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournalLine#getValidatedMember()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EReference getCollectionJournalLine_ValidatedMember();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.CollectionJournalLine#isOffRoute <em>Off Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Off Route</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournalLine#isOffRoute()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_OffRoute();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.dairy.CollectionJournalLine#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournalLine#getFrom()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EReference getCollectionJournalLine_From();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.dairy.CollectionJournalLine#getFarmContainer <em>Farm Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Farm Container</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournalLine#getFarmContainer()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EReference getCollectionJournalLine_FarmContainer();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.dairy.CollectionJournalLine#getDairyContainer <em>Dairy Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dairy Container</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournalLine#getDairyContainer()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EReference getCollectionJournalLine_DairyContainer();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.dairy.CollectionJournalLine#getCollectionJournal <em>Collection Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Collection Journal</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournalLine#getCollectionJournal()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EReference getCollectionJournalLine_CollectionJournal();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.CollectionJournalLine#isRejected <em>Rejected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rejected</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournalLine#isRejected()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_Rejected();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.dairy.Employee <em>Employee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Employee</em>'.
	 * @see com.agritrace.edairy.model.dairy.Employee
	 * @generated
	 */
	EClass getEmployee();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Employee#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.model.dairy.Employee#getId()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Employee#getStartDate <em>Start Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Date</em>'.
	 * @see com.agritrace.edairy.model.dairy.Employee#getStartDate()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_StartDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Employee#getJobFunction <em>Job Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Job Function</em>'.
	 * @see com.agritrace.edairy.model.dairy.Employee#getJobFunction()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_JobFunction();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Employee#getNationalId <em>National Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>National Id</em>'.
	 * @see com.agritrace.edairy.model.dairy.Employee#getNationalId()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_NationalId();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Employee#getNhifNumber <em>Nhif Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nhif Number</em>'.
	 * @see com.agritrace.edairy.model.dairy.Employee#getNhifNumber()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_NhifNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Employee#getNssfNumber <em>Nssf Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nssf Number</em>'.
	 * @see com.agritrace.edairy.model.dairy.Employee#getNssfNumber()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_NssfNumber();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.dairy.DairyLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see com.agritrace.edairy.model.dairy.DairyLocation
	 * @generated
	 */
	EClass getDairyLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.DairyLocation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.agritrace.edairy.model.dairy.DairyLocation#getName()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EAttribute getDairyLocation_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.DairyLocation#getDateOpened <em>Date Opened</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Opened</em>'.
	 * @see com.agritrace.edairy.model.dairy.DairyLocation#getDateOpened()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EAttribute getDairyLocation_DateOpened();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.DairyLocation#getPhone <em>Phone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phone</em>'.
	 * @see com.agritrace.edairy.model.dairy.DairyLocation#getPhone()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EAttribute getDairyLocation_Phone();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.dairy.DairyLocation#getRoute <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Route</em>'.
	 * @see com.agritrace.edairy.model.dairy.DairyLocation#getRoute()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EReference getDairyLocation_Route();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.DairyLocation#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.agritrace.edairy.model.dairy.DairyLocation#getDescription()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EAttribute getDairyLocation_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.DairyLocation#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.agritrace.edairy.model.dairy.DairyLocation#getCode()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EAttribute getDairyLocation_Code();

	/**
	 * Returns the meta object for the containment reference '{@link com.agritrace.edairy.model.dairy.DairyLocation#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see com.agritrace.edairy.model.dairy.DairyLocation#getLocation()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EReference getDairyLocation_Location();

	/**
	 * Returns the meta object for the attribute list '{@link com.agritrace.edairy.model.dairy.DairyLocation#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Functions</em>'.
	 * @see com.agritrace.edairy.model.dairy.DairyLocation#getFunctions()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EAttribute getDairyLocation_Functions();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.dairy.CollectionJournal <em>Collection Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Journal</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournal
	 * @generated
	 */
	EClass getCollectionJournal();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.model.dairy.CollectionJournal#getJournalEntries <em>Journal Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Journal Entries</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournal#getJournalEntries()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EReference getCollectionJournal_JournalEntries();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.CollectionJournal#getReferenceNumber <em>Reference Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference Number</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournal#getReferenceNumber()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EAttribute getCollectionJournal_ReferenceNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.CollectionJournal#getJournalDate <em>Journal Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Journal Date</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournal#getJournalDate()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EAttribute getCollectionJournal_JournalDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.CollectionJournal#getSession <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Session</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournal#getSession()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EAttribute getCollectionJournal_Session();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.dairy.CollectionJournal#getDriver <em>Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Driver</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournal#getDriver()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EReference getCollectionJournal_Driver();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.dairy.CollectionJournal#getRoute <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Route</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournal#getRoute()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EReference getCollectionJournal_Route();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.dairy.CollectionJournal#getFarmContainer <em>Farm Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Farm Container</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournal#getFarmContainer()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EReference getCollectionJournal_FarmContainer();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.dairy.CollectionJournal#getBin <em>Bin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bin</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournal#getBin()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EReference getCollectionJournal_Bin();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.dairy.CollectionJournal#getVehicle <em>Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vehicle</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournal#getVehicle()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EReference getCollectionJournal_Vehicle();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.CollectionJournal#getDriverTotal <em>Driver Total</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Driver Total</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournal#getDriverTotal()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EAttribute getCollectionJournal_DriverTotal();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.CollectionJournal#getRecordTotal <em>Record Total</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Total</em>'.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournal#getRecordTotal()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EAttribute getCollectionJournal_RecordTotal();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.dairy.Route <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Route</em>'.
	 * @see com.agritrace.edairy.model.dairy.Route
	 * @generated
	 */
	EClass getRoute();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Route#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.agritrace.edairy.model.dairy.Route#getName()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_Name();

	/**
	 * Returns the meta object for the reference list '{@link com.agritrace.edairy.model.dairy.Route#getStops <em>Stops</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stops</em>'.
	 * @see com.agritrace.edairy.model.dairy.Route#getStops()
	 * @see #getRoute()
	 * @generated
	 */
	EReference getRoute_Stops();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Route#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.agritrace.edairy.model.dairy.Route#getCode()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Route#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.agritrace.edairy.model.dairy.Route#getDescription()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_Description();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.dairy.Trip <em>Trip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trip</em>'.
	 * @see com.agritrace.edairy.model.dairy.Trip
	 * @generated
	 */
	EClass getTrip();

	/**
	 * Returns the meta object for the reference list '{@link com.agritrace.edairy.model.dairy.Trip#getCollections <em>Collections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Collections</em>'.
	 * @see com.agritrace.edairy.model.dairy.Trip#getCollections()
	 * @see #getTrip()
	 * @generated
	 */
	EReference getTrip_Collections();

	/**
	 * Returns the meta object for the reference list '{@link com.agritrace.edairy.model.dairy.Trip#getDeliveries <em>Deliveries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Deliveries</em>'.
	 * @see com.agritrace.edairy.model.dairy.Trip#getDeliveries()
	 * @see #getTrip()
	 * @generated
	 */
	EReference getTrip_Deliveries();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Trip#getStarted <em>Started</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Started</em>'.
	 * @see com.agritrace.edairy.model.dairy.Trip#getStarted()
	 * @see #getTrip()
	 * @generated
	 */
	EAttribute getTrip_Started();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Trip#getEnded <em>Ended</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ended</em>'.
	 * @see com.agritrace.edairy.model.dairy.Trip#getEnded()
	 * @see #getTrip()
	 * @generated
	 */
	EAttribute getTrip_Ended();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.dairy.DeliveryJournal <em>Delivery Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delivery Journal</em>'.
	 * @see com.agritrace.edairy.model.dairy.DeliveryJournal
	 * @generated
	 */
	EClass getDeliveryJournal();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.DeliveryJournal#getReferenceNumber <em>Reference Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference Number</em>'.
	 * @see com.agritrace.edairy.model.dairy.DeliveryJournal#getReferenceNumber()
	 * @see #getDeliveryJournal()
	 * @generated
	 */
	EAttribute getDeliveryJournal_ReferenceNumber();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.dairy.Dairy <em>Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dairy</em>'.
	 * @see com.agritrace.edairy.model.dairy.Dairy
	 * @generated
	 */
	EClass getDairy();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Dairy#getNhifNumber <em>Nhif Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nhif Number</em>'.
	 * @see com.agritrace.edairy.model.dairy.Dairy#getNhifNumber()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_NhifNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Dairy#getNssfNumber <em>Nssf Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nssf Number</em>'.
	 * @see com.agritrace.edairy.model.dairy.Dairy#getNssfNumber()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_NssfNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Dairy#getFederalPin <em>Federal Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Federal Pin</em>'.
	 * @see com.agritrace.edairy.model.dairy.Dairy#getFederalPin()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_FederalPin();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.model.dairy.Dairy#getRoutes <em>Routes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Routes</em>'.
	 * @see com.agritrace.edairy.model.dairy.Dairy#getRoutes()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Routes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.model.dairy.Dairy#getVehicles <em>Vehicles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vehicles</em>'.
	 * @see com.agritrace.edairy.model.dairy.Dairy#getVehicles()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Vehicles();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.model.dairy.Dairy#getEmployees <em>Employees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Employees</em>'.
	 * @see com.agritrace.edairy.model.dairy.Dairy#getEmployees()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Employees();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.model.dairy.Dairy#getMemberships <em>Memberships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Memberships</em>'.
	 * @see com.agritrace.edairy.model.dairy.Dairy#getMemberships()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Memberships();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.model.dairy.Dairy#getBranchLocations <em>Branch Locations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Branch Locations</em>'.
	 * @see com.agritrace.edairy.model.dairy.Dairy#getBranchLocations()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_BranchLocations();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Dairy#getRegistrationNumber <em>Registration Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registration Number</em>'.
	 * @see com.agritrace.edairy.model.dairy.Dairy#getRegistrationNumber()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_RegistrationNumber();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.model.dairy.Dairy#getCollectionJournals <em>Collection Journals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collection Journals</em>'.
	 * @see com.agritrace.edairy.model.dairy.Dairy#getCollectionJournals()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_CollectionJournals();

	/**
	 * Returns the meta object for the reference list '{@link com.agritrace.edairy.model.dairy.Dairy#getSuppliers <em>Suppliers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Suppliers</em>'.
	 * @see com.agritrace.edairy.model.dairy.Dairy#getSuppliers()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Suppliers();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.model.dairy.Dairy#getAnimalHealthRequests <em>Animal Health Requests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Animal Health Requests</em>'.
	 * @see com.agritrace.edairy.model.dairy.Dairy#getAnimalHealthRequests()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_AnimalHealthRequests();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.dairy.Membership <em>Membership</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Membership</em>'.
	 * @see com.agritrace.edairy.model.dairy.Membership
	 * @generated
	 */
	EClass getMembership();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Membership#getMemberId <em>Member Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Member Id</em>'.
	 * @see com.agritrace.edairy.model.dairy.Membership#getMemberId()
	 * @see #getMembership()
	 * @generated
	 */
	EAttribute getMembership_MemberId();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Membership#getApplicationDate <em>Application Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Application Date</em>'.
	 * @see com.agritrace.edairy.model.dairy.Membership#getApplicationDate()
	 * @see #getMembership()
	 * @generated
	 */
	EAttribute getMembership_ApplicationDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Membership#getEffectiveDate <em>Effective Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effective Date</em>'.
	 * @see com.agritrace.edairy.model.dairy.Membership#getEffectiveDate()
	 * @see #getMembership()
	 * @generated
	 */
	EAttribute getMembership_EffectiveDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Membership#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see com.agritrace.edairy.model.dairy.Membership#getStatus()
	 * @see #getMembership()
	 * @generated
	 */
	EAttribute getMembership_Status();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.dairy.Membership#getDefaultRoute <em>Default Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Route</em>'.
	 * @see com.agritrace.edairy.model.dairy.Membership#getDefaultRoute()
	 * @see #getMembership()
	 * @generated
	 */
	EReference getMembership_DefaultRoute();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.model.dairy.Membership#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Member</em>'.
	 * @see com.agritrace.edairy.model.dairy.Membership#getMember()
	 * @see #getMembership()
	 * @generated
	 */
	EReference getMembership_Member();

	/**
	 * Returns the meta object for the reference list '{@link com.agritrace.edairy.model.dairy.Membership#getFarms <em>Farms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Farms</em>'.
	 * @see com.agritrace.edairy.model.dairy.Membership#getFarms()
	 * @see #getMembership()
	 * @generated
	 */
	EReference getMembership_Farms();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.dairy.Asset <em>Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Asset</em>'.
	 * @see com.agritrace.edairy.model.dairy.Asset
	 * @generated
	 */
	EClass getAsset();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Asset#getAssetId <em>Asset Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Asset Id</em>'.
	 * @see com.agritrace.edairy.model.dairy.Asset#getAssetId()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_AssetId();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Asset#getTagType <em>Tag Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag Type</em>'.
	 * @see com.agritrace.edairy.model.dairy.Asset#getTagType()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_TagType();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Asset#getTagValue <em>Tag Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag Value</em>'.
	 * @see com.agritrace.edairy.model.dairy.Asset#getTagValue()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_TagValue();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Asset#getDateAcquired <em>Date Acquired</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Acquired</em>'.
	 * @see com.agritrace.edairy.model.dairy.Asset#getDateAcquired()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_DateAcquired();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Asset#getDamageDate <em>Damage Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Damage Date</em>'.
	 * @see com.agritrace.edairy.model.dairy.Asset#getDamageDate()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_DamageDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Asset#getDamageDescription <em>Damage Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Damage Description</em>'.
	 * @see com.agritrace.edairy.model.dairy.Asset#getDamageDescription()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_DamageDescription();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Asset#getDateDisposed <em>Date Disposed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Disposed</em>'.
	 * @see com.agritrace.edairy.model.dairy.Asset#getDateDisposed()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_DateDisposed();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Asset#getDisposalReason <em>Disposal Reason</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disposal Reason</em>'.
	 * @see com.agritrace.edairy.model.dairy.Asset#getDisposalReason()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_DisposalReason();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Asset#getDisposalWitness <em>Disposal Witness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disposal Witness</em>'.
	 * @see com.agritrace.edairy.model.dairy.Asset#getDisposalWitness()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_DisposalWitness();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.dairy.DairyContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see com.agritrace.edairy.model.dairy.DairyContainer
	 * @generated
	 */
	EClass getDairyContainer();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.model.dairy.Supplier <em>Supplier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supplier</em>'.
	 * @see com.agritrace.edairy.model.dairy.Supplier
	 * @generated
	 */
	EClass getSupplier();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Supplier#getSupplierId <em>Supplier Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Supplier Id</em>'.
	 * @see com.agritrace.edairy.model.dairy.Supplier#getSupplierId()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_SupplierId();

	/**
	 * Returns the meta object for the attribute list '{@link com.agritrace.edairy.model.dairy.Supplier#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Categories</em>'.
	 * @see com.agritrace.edairy.model.dairy.Supplier#getCategories()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_Categories();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Supplier#getPublicDescription <em>Public Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Public Description</em>'.
	 * @see com.agritrace.edairy.model.dairy.Supplier#getPublicDescription()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_PublicDescription();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Supplier#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see com.agritrace.edairy.model.dairy.Supplier#getStatus()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_Status();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Supplier#getRegistrationDate <em>Registration Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registration Date</em>'.
	 * @see com.agritrace.edairy.model.dairy.Supplier#getRegistrationDate()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_RegistrationDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Supplier#getExpirationDate <em>Expiration Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expiration Date</em>'.
	 * @see com.agritrace.edairy.model.dairy.Supplier#getExpirationDate()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_ExpirationDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Supplier#getNotes <em>Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Notes</em>'.
	 * @see com.agritrace.edairy.model.dairy.Supplier#getNotes()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_Notes();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.model.dairy.Supplier#getRating <em>Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rating</em>'.
	 * @see com.agritrace.edairy.model.dairy.Supplier#getRating()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_Rating();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.model.dairy.MembershipStatus <em>Membership Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Membership Status</em>'.
	 * @see com.agritrace.edairy.model.dairy.MembershipStatus
	 * @generated
	 */
	EEnum getMembershipStatus();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.model.dairy.Session <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Session</em>'.
	 * @see com.agritrace.edairy.model.dairy.Session
	 * @generated
	 */
	EEnum getSession();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.model.dairy.VendorStatus <em>Vendor Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Vendor Status</em>'.
	 * @see com.agritrace.edairy.model.dairy.VendorStatus
	 * @generated
	 */
	EEnum getVendorStatus();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.model.dairy.DairyFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Function</em>'.
	 * @see com.agritrace.edairy.model.dairy.DairyFunction
	 * @generated
	 */
	EEnum getDairyFunction();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DairyFactory getDairyFactory();

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
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.impl.VehicleImpl <em>Vehicle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.impl.VehicleImpl
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getVehicle()
		 * @generated
		 */
		EClass VEHICLE = eINSTANCE.getVehicle();

		/**
		 * The meta object literal for the '<em><b>Registration Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__REGISTRATION_NUMBER = eINSTANCE.getVehicle_RegistrationNumber();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__TYPE = eINSTANCE.getVehicle_Type();

		/**
		 * The meta object literal for the '<em><b>Make</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__MAKE = eINSTANCE.getVehicle_Make();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__MODEL = eINSTANCE.getVehicle_Model();

		/**
		 * The meta object literal for the '<em><b>Engine Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__ENGINE_NUMBER = eINSTANCE.getVehicle_EngineNumber();

		/**
		 * The meta object literal for the '<em><b>Chassis Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__CHASSIS_NUMBER = eINSTANCE.getVehicle_ChassisNumber();

		/**
		 * The meta object literal for the '<em><b>Log Book Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__LOG_BOOK_NUMBER = eINSTANCE.getVehicle_LogBookNumber();

		/**
		 * The meta object literal for the '<em><b>Insurance Policy Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__INSURANCE_POLICY_NUMBER = eINSTANCE.getVehicle_InsurancePolicyNumber();

		/**
		 * The meta object literal for the '<em><b>Insurance Purchase Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__INSURANCE_PURCHASE_DATE = eINSTANCE.getVehicle_InsurancePurchaseDate();

		/**
		 * The meta object literal for the '<em><b>Dominant Colour</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__DOMINANT_COLOUR = eINSTANCE.getVehicle_DominantColour();

		/**
		 * The meta object literal for the '<em><b>Capacity In Tonnes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__CAPACITY_IN_TONNES = eINSTANCE.getVehicle_CapacityInTonnes();

		/**
		 * The meta object literal for the '<em><b>Driver</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VEHICLE__DRIVER = eINSTANCE.getVehicle_Driver();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.impl.CollectionJournalLineImpl <em>Collection Journal Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.impl.CollectionJournalLineImpl
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getCollectionJournalLine()
		 * @generated
		 */
		EClass COLLECTION_JOURNAL_LINE = eINSTANCE.getCollectionJournalLine();

		/**
		 * The meta object literal for the '<em><b>Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL_LINE__LINE_NUMBER = eINSTANCE.getCollectionJournalLine_LineNumber();

		/**
		 * The meta object literal for the '<em><b>Recorded Member</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL_LINE__RECORDED_MEMBER = eINSTANCE.getCollectionJournalLine_RecordedMember();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL_LINE__QUANTITY = eINSTANCE.getCollectionJournalLine_Quantity();

		/**
		 * The meta object literal for the '<em><b>Flagged</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL_LINE__FLAGGED = eINSTANCE.getCollectionJournalLine_Flagged();

		/**
		 * The meta object literal for the '<em><b>Unit Of Measure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL_LINE__UNIT_OF_MEASURE = eINSTANCE.getCollectionJournalLine_UnitOfMeasure();

		/**
		 * The meta object literal for the '<em><b>Not Recorded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL_LINE__NOT_RECORDED = eINSTANCE.getCollectionJournalLine_NotRecorded();

		/**
		 * The meta object literal for the '<em><b>Validated Member</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_JOURNAL_LINE__VALIDATED_MEMBER = eINSTANCE.getCollectionJournalLine_ValidatedMember();

		/**
		 * The meta object literal for the '<em><b>Off Route</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL_LINE__OFF_ROUTE = eINSTANCE.getCollectionJournalLine_OffRoute();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_JOURNAL_LINE__FROM = eINSTANCE.getCollectionJournalLine_From();

		/**
		 * The meta object literal for the '<em><b>Farm Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_JOURNAL_LINE__FARM_CONTAINER = eINSTANCE.getCollectionJournalLine_FarmContainer();

		/**
		 * The meta object literal for the '<em><b>Dairy Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_JOURNAL_LINE__DAIRY_CONTAINER = eINSTANCE.getCollectionJournalLine_DairyContainer();

		/**
		 * The meta object literal for the '<em><b>Collection Journal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_JOURNAL_LINE__COLLECTION_JOURNAL = eINSTANCE.getCollectionJournalLine_CollectionJournal();

		/**
		 * The meta object literal for the '<em><b>Rejected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL_LINE__REJECTED = eINSTANCE.getCollectionJournalLine_Rejected();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.impl.EmployeeImpl <em>Employee</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.impl.EmployeeImpl
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getEmployee()
		 * @generated
		 */
		EClass EMPLOYEE = eINSTANCE.getEmployee();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPLOYEE__ID = eINSTANCE.getEmployee_Id();

		/**
		 * The meta object literal for the '<em><b>Start Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPLOYEE__START_DATE = eINSTANCE.getEmployee_StartDate();

		/**
		 * The meta object literal for the '<em><b>Job Function</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPLOYEE__JOB_FUNCTION = eINSTANCE.getEmployee_JobFunction();

		/**
		 * The meta object literal for the '<em><b>National Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPLOYEE__NATIONAL_ID = eINSTANCE.getEmployee_NationalId();

		/**
		 * The meta object literal for the '<em><b>Nhif Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPLOYEE__NHIF_NUMBER = eINSTANCE.getEmployee_NhifNumber();

		/**
		 * The meta object literal for the '<em><b>Nssf Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPLOYEE__NSSF_NUMBER = eINSTANCE.getEmployee_NssfNumber();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.impl.DairyLocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.impl.DairyLocationImpl
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getDairyLocation()
		 * @generated
		 */
		EClass DAIRY_LOCATION = eINSTANCE.getDairyLocation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY_LOCATION__NAME = eINSTANCE.getDairyLocation_Name();

		/**
		 * The meta object literal for the '<em><b>Date Opened</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY_LOCATION__DATE_OPENED = eINSTANCE.getDairyLocation_DateOpened();

		/**
		 * The meta object literal for the '<em><b>Phone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY_LOCATION__PHONE = eINSTANCE.getDairyLocation_Phone();

		/**
		 * The meta object literal for the '<em><b>Route</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY_LOCATION__ROUTE = eINSTANCE.getDairyLocation_Route();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY_LOCATION__DESCRIPTION = eINSTANCE.getDairyLocation_Description();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY_LOCATION__CODE = eINSTANCE.getDairyLocation_Code();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY_LOCATION__LOCATION = eINSTANCE.getDairyLocation_Location();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY_LOCATION__FUNCTIONS = eINSTANCE.getDairyLocation_Functions();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.impl.CollectionJournalImpl <em>Collection Journal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.impl.CollectionJournalImpl
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getCollectionJournal()
		 * @generated
		 */
		EClass COLLECTION_JOURNAL = eINSTANCE.getCollectionJournal();

		/**
		 * The meta object literal for the '<em><b>Journal Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_JOURNAL__JOURNAL_ENTRIES = eINSTANCE.getCollectionJournal_JournalEntries();

		/**
		 * The meta object literal for the '<em><b>Reference Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL__REFERENCE_NUMBER = eINSTANCE.getCollectionJournal_ReferenceNumber();

		/**
		 * The meta object literal for the '<em><b>Journal Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL__JOURNAL_DATE = eINSTANCE.getCollectionJournal_JournalDate();

		/**
		 * The meta object literal for the '<em><b>Session</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL__SESSION = eINSTANCE.getCollectionJournal_Session();

		/**
		 * The meta object literal for the '<em><b>Driver</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_JOURNAL__DRIVER = eINSTANCE.getCollectionJournal_Driver();

		/**
		 * The meta object literal for the '<em><b>Route</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_JOURNAL__ROUTE = eINSTANCE.getCollectionJournal_Route();

		/**
		 * The meta object literal for the '<em><b>Farm Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_JOURNAL__FARM_CONTAINER = eINSTANCE.getCollectionJournal_FarmContainer();

		/**
		 * The meta object literal for the '<em><b>Bin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_JOURNAL__BIN = eINSTANCE.getCollectionJournal_Bin();

		/**
		 * The meta object literal for the '<em><b>Vehicle</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_JOURNAL__VEHICLE = eINSTANCE.getCollectionJournal_Vehicle();

		/**
		 * The meta object literal for the '<em><b>Driver Total</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL__DRIVER_TOTAL = eINSTANCE.getCollectionJournal_DriverTotal();

		/**
		 * The meta object literal for the '<em><b>Record Total</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL__RECORD_TOTAL = eINSTANCE.getCollectionJournal_RecordTotal();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.impl.RouteImpl <em>Route</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.impl.RouteImpl
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getRoute()
		 * @generated
		 */
		EClass ROUTE = eINSTANCE.getRoute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTE__NAME = eINSTANCE.getRoute_Name();

		/**
		 * The meta object literal for the '<em><b>Stops</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTE__STOPS = eINSTANCE.getRoute_Stops();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTE__CODE = eINSTANCE.getRoute_Code();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTE__DESCRIPTION = eINSTANCE.getRoute_Description();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.impl.TripImpl <em>Trip</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.impl.TripImpl
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getTrip()
		 * @generated
		 */
		EClass TRIP = eINSTANCE.getTrip();

		/**
		 * The meta object literal for the '<em><b>Collections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIP__COLLECTIONS = eINSTANCE.getTrip_Collections();

		/**
		 * The meta object literal for the '<em><b>Deliveries</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIP__DELIVERIES = eINSTANCE.getTrip_Deliveries();

		/**
		 * The meta object literal for the '<em><b>Started</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRIP__STARTED = eINSTANCE.getTrip_Started();

		/**
		 * The meta object literal for the '<em><b>Ended</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRIP__ENDED = eINSTANCE.getTrip_Ended();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.impl.DeliveryJournalImpl <em>Delivery Journal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.impl.DeliveryJournalImpl
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getDeliveryJournal()
		 * @generated
		 */
		EClass DELIVERY_JOURNAL = eINSTANCE.getDeliveryJournal();

		/**
		 * The meta object literal for the '<em><b>Reference Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELIVERY_JOURNAL__REFERENCE_NUMBER = eINSTANCE.getDeliveryJournal_ReferenceNumber();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.impl.DairyImpl <em>Dairy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.impl.DairyImpl
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getDairy()
		 * @generated
		 */
		EClass DAIRY = eINSTANCE.getDairy();

		/**
		 * The meta object literal for the '<em><b>Nhif Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY__NHIF_NUMBER = eINSTANCE.getDairy_NhifNumber();

		/**
		 * The meta object literal for the '<em><b>Nssf Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY__NSSF_NUMBER = eINSTANCE.getDairy_NssfNumber();

		/**
		 * The meta object literal for the '<em><b>Federal Pin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY__FEDERAL_PIN = eINSTANCE.getDairy_FederalPin();

		/**
		 * The meta object literal for the '<em><b>Routes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__ROUTES = eINSTANCE.getDairy_Routes();

		/**
		 * The meta object literal for the '<em><b>Vehicles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__VEHICLES = eINSTANCE.getDairy_Vehicles();

		/**
		 * The meta object literal for the '<em><b>Employees</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__EMPLOYEES = eINSTANCE.getDairy_Employees();

		/**
		 * The meta object literal for the '<em><b>Memberships</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__MEMBERSHIPS = eINSTANCE.getDairy_Memberships();

		/**
		 * The meta object literal for the '<em><b>Branch Locations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__BRANCH_LOCATIONS = eINSTANCE.getDairy_BranchLocations();

		/**
		 * The meta object literal for the '<em><b>Registration Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY__REGISTRATION_NUMBER = eINSTANCE.getDairy_RegistrationNumber();

		/**
		 * The meta object literal for the '<em><b>Collection Journals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__COLLECTION_JOURNALS = eINSTANCE.getDairy_CollectionJournals();

		/**
		 * The meta object literal for the '<em><b>Suppliers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__SUPPLIERS = eINSTANCE.getDairy_Suppliers();

		/**
		 * The meta object literal for the '<em><b>Animal Health Requests</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__ANIMAL_HEALTH_REQUESTS = eINSTANCE.getDairy_AnimalHealthRequests();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.impl.MembershipImpl <em>Membership</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.impl.MembershipImpl
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getMembership()
		 * @generated
		 */
		EClass MEMBERSHIP = eINSTANCE.getMembership();

		/**
		 * The meta object literal for the '<em><b>Member Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBERSHIP__MEMBER_ID = eINSTANCE.getMembership_MemberId();

		/**
		 * The meta object literal for the '<em><b>Application Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBERSHIP__APPLICATION_DATE = eINSTANCE.getMembership_ApplicationDate();

		/**
		 * The meta object literal for the '<em><b>Effective Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBERSHIP__EFFECTIVE_DATE = eINSTANCE.getMembership_EffectiveDate();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBERSHIP__STATUS = eINSTANCE.getMembership_Status();

		/**
		 * The meta object literal for the '<em><b>Default Route</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBERSHIP__DEFAULT_ROUTE = eINSTANCE.getMembership_DefaultRoute();

		/**
		 * The meta object literal for the '<em><b>Member</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBERSHIP__MEMBER = eINSTANCE.getMembership_Member();

		/**
		 * The meta object literal for the '<em><b>Farms</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBERSHIP__FARMS = eINSTANCE.getMembership_Farms();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.impl.AssetImpl <em>Asset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.impl.AssetImpl
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getAsset()
		 * @generated
		 */
		EClass ASSET = eINSTANCE.getAsset();

		/**
		 * The meta object literal for the '<em><b>Asset Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSET__ASSET_ID = eINSTANCE.getAsset_AssetId();

		/**
		 * The meta object literal for the '<em><b>Tag Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSET__TAG_TYPE = eINSTANCE.getAsset_TagType();

		/**
		 * The meta object literal for the '<em><b>Tag Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSET__TAG_VALUE = eINSTANCE.getAsset_TagValue();

		/**
		 * The meta object literal for the '<em><b>Date Acquired</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSET__DATE_ACQUIRED = eINSTANCE.getAsset_DateAcquired();

		/**
		 * The meta object literal for the '<em><b>Damage Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSET__DAMAGE_DATE = eINSTANCE.getAsset_DamageDate();

		/**
		 * The meta object literal for the '<em><b>Damage Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSET__DAMAGE_DESCRIPTION = eINSTANCE.getAsset_DamageDescription();

		/**
		 * The meta object literal for the '<em><b>Date Disposed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSET__DATE_DISPOSED = eINSTANCE.getAsset_DateDisposed();

		/**
		 * The meta object literal for the '<em><b>Disposal Reason</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSET__DISPOSAL_REASON = eINSTANCE.getAsset_DisposalReason();

		/**
		 * The meta object literal for the '<em><b>Disposal Witness</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSET__DISPOSAL_WITNESS = eINSTANCE.getAsset_DisposalWitness();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.impl.DairyContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.impl.DairyContainerImpl
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getDairyContainer()
		 * @generated
		 */
		EClass DAIRY_CONTAINER = eINSTANCE.getDairyContainer();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.impl.SupplierImpl <em>Supplier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.impl.SupplierImpl
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getSupplier()
		 * @generated
		 */
		EClass SUPPLIER = eINSTANCE.getSupplier();

		/**
		 * The meta object literal for the '<em><b>Supplier Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__SUPPLIER_ID = eINSTANCE.getSupplier_SupplierId();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__CATEGORIES = eINSTANCE.getSupplier_Categories();

		/**
		 * The meta object literal for the '<em><b>Public Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__PUBLIC_DESCRIPTION = eINSTANCE.getSupplier_PublicDescription();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__STATUS = eINSTANCE.getSupplier_Status();

		/**
		 * The meta object literal for the '<em><b>Registration Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__REGISTRATION_DATE = eINSTANCE.getSupplier_RegistrationDate();

		/**
		 * The meta object literal for the '<em><b>Expiration Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__EXPIRATION_DATE = eINSTANCE.getSupplier_ExpirationDate();

		/**
		 * The meta object literal for the '<em><b>Notes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__NOTES = eINSTANCE.getSupplier_Notes();

		/**
		 * The meta object literal for the '<em><b>Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__RATING = eINSTANCE.getSupplier_Rating();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.MembershipStatus <em>Membership Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.MembershipStatus
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getMembershipStatus()
		 * @generated
		 */
		EEnum MEMBERSHIP_STATUS = eINSTANCE.getMembershipStatus();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.Session <em>Session</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.Session
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getSession()
		 * @generated
		 */
		EEnum SESSION = eINSTANCE.getSession();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.VendorStatus <em>Vendor Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.VendorStatus
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getVendorStatus()
		 * @generated
		 */
		EEnum VENDOR_STATUS = eINSTANCE.getVendorStatus();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.model.dairy.DairyFunction <em>Function</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.model.dairy.DairyFunction
		 * @see com.agritrace.edairy.model.dairy.impl.DairyPackageImpl#getDairyFunction()
		 * @generated
		 */
		EEnum DAIRY_FUNCTION = eINSTANCE.getDairyFunction();

	}

} //DairyPackage
