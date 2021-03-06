/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;

import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;

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
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyFactory
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
	String eNS_URI = "http://com.agritrace.edairy.desktop.common.model/dairy/";

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
	DairyPackage eINSTANCE = com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl <em>Vehicle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getVehicle()
	 * @generated
	 */
	int VEHICLE = 0;

	/**
	 * The feature id for the '<em><b>Vehicle Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__VEHICLE_ID = 0;

	/**
	 * The feature id for the '<em><b>Registration Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__REGISTRATION_NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Make</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__MAKE = 3;

	/**
	 * The feature id for the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__MODEL = 4;

	/**
	 * The feature id for the '<em><b>Engine Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__ENGINE_NUMBER = 5;

	/**
	 * The feature id for the '<em><b>Chassis Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__CHASSIS_NUMBER = 6;

	/**
	 * The feature id for the '<em><b>Log Book Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__LOG_BOOK_NUMBER = 7;

	/**
	 * The feature id for the '<em><b>Insurance Policy Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__INSURANCE_POLICY_NUMBER = 8;

	/**
	 * The feature id for the '<em><b>Insurance Expiration Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__INSURANCE_EXPIRATION_DATE = 9;

	/**
	 * The feature id for the '<em><b>Dominant Colour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__DOMINANT_COLOUR = 10;

	/**
	 * The feature id for the '<em><b>Capacity In Tonnes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__CAPACITY_IN_TONNES = 11;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__YEAR = 12;

	/**
	 * The feature id for the '<em><b>Driver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__DRIVER = 13;

	/**
	 * The feature id for the '<em><b>Asset Info</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__ASSET_INFO = 14;

	/**
	 * The number of structural features of the '<em>Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_FEATURE_COUNT = 15;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl <em>Collection Journal Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getCollectionJournalLine()
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
	 * The feature id for the '<em><b>Bin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__BIN = 10;

	/**
	 * The feature id for the '<em><b>Group</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__GROUP = 11;

	/**
	 * The feature id for the '<em><b>Rejected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__REJECTED = 12;

	/**
	 * The feature id for the '<em><b>Rejection Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__REJECTION_REASON = 13;

	/**
	 * The feature id for the '<em><b>Milk Fat Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__MILK_FAT_PERCENTAGE = 14;

	/**
	 * The feature id for the '<em><b>Alcohol Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__ALCOHOL_PERCENTAGE = 15;

	/**
	 * The feature id for the '<em><b>Water Added</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE__WATER_ADDED = 16;

	/**
	 * The number of structural features of the '<em>Collection Journal Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_LINE_FEATURE_COUNT = 17;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.ScaleImportRecordImpl <em>Scale Import Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.ScaleImportRecordImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getScaleImportRecord()
	 * @generated
	 */
	int SCALE_IMPORT_RECORD = 2;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__LINE_NUMBER = COLLECTION_JOURNAL_LINE__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Recorded Member</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__RECORDED_MEMBER = COLLECTION_JOURNAL_LINE__RECORDED_MEMBER;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__QUANTITY = COLLECTION_JOURNAL_LINE__QUANTITY;

	/**
	 * The feature id for the '<em><b>Flagged</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__FLAGGED = COLLECTION_JOURNAL_LINE__FLAGGED;

	/**
	 * The feature id for the '<em><b>Unit Of Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__UNIT_OF_MEASURE = COLLECTION_JOURNAL_LINE__UNIT_OF_MEASURE;

	/**
	 * The feature id for the '<em><b>Not Recorded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__NOT_RECORDED = COLLECTION_JOURNAL_LINE__NOT_RECORDED;

	/**
	 * The feature id for the '<em><b>Validated Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__VALIDATED_MEMBER = COLLECTION_JOURNAL_LINE__VALIDATED_MEMBER;

	/**
	 * The feature id for the '<em><b>Off Route</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__OFF_ROUTE = COLLECTION_JOURNAL_LINE__OFF_ROUTE;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__FROM = COLLECTION_JOURNAL_LINE__FROM;

	/**
	 * The feature id for the '<em><b>Farm Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__FARM_CONTAINER = COLLECTION_JOURNAL_LINE__FARM_CONTAINER;

	/**
	 * The feature id for the '<em><b>Bin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__BIN = COLLECTION_JOURNAL_LINE__BIN;

	/**
	 * The feature id for the '<em><b>Group</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__GROUP = COLLECTION_JOURNAL_LINE__GROUP;

	/**
	 * The feature id for the '<em><b>Rejected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__REJECTED = COLLECTION_JOURNAL_LINE__REJECTED;

	/**
	 * The feature id for the '<em><b>Rejection Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__REJECTION_REASON = COLLECTION_JOURNAL_LINE__REJECTION_REASON;

	/**
	 * The feature id for the '<em><b>Milk Fat Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__MILK_FAT_PERCENTAGE = COLLECTION_JOURNAL_LINE__MILK_FAT_PERCENTAGE;

	/**
	 * The feature id for the '<em><b>Alcohol Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__ALCOHOL_PERCENTAGE = COLLECTION_JOURNAL_LINE__ALCOHOL_PERCENTAGE;

	/**
	 * The feature id for the '<em><b>Water Added</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__WATER_ADDED = COLLECTION_JOURNAL_LINE__WATER_ADDED;

	/**
	 * The feature id for the '<em><b>Scale Serial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__SCALE_SERIAL = COLLECTION_JOURNAL_LINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Collection Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__COLLECTION_TIME = COLLECTION_JOURNAL_LINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Center Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__CENTER_NUMBER = COLLECTION_JOURNAL_LINE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Num Cans</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__NUM_CANS = COLLECTION_JOURNAL_LINE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Trip Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__TRIP_NUMBER = COLLECTION_JOURNAL_LINE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Operator Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__OPERATOR_CODE = COLLECTION_JOURNAL_LINE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Validated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD__VALIDATED = COLLECTION_JOURNAL_LINE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Scale Import Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALE_IMPORT_RECORD_FEATURE_COUNT = COLLECTION_JOURNAL_LINE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl <em>Employee</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getEmployee()
	 * @generated
	 */
	int EMPLOYEE = 3;

	/**
	 * The feature id for the '<em><b>Contact Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__CONTACT_METHODS = ModelPackage.PERSON__CONTACT_METHODS;

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
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__PHONE_NUMBER = ModelPackage.PERSON__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__LOCATION = ModelPackage.PERSON__LOCATION;

	/**
	 * The feature id for the '<em><b>Person Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__PERSON_ID = ModelPackage.PERSON__PERSON_ID;

	/**
	 * The feature id for the '<em><b>Nssf Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__NSSF_NUMBER = ModelPackage.PERSON__NSSF_NUMBER;

	/**
	 * The feature id for the '<em><b>Nhif Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__NHIF_NUMBER = ModelPackage.PERSON__NHIF_NUMBER;

	/**
	 * The feature id for the '<em><b>National Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__NATIONAL_ID = ModelPackage.PERSON__NATIONAL_ID;

	/**
	 * The feature id for the '<em><b>Employee Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__EMPLOYEE_NUMBER = ModelPackage.PERSON_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__OPERATOR_CODE = ModelPackage.PERSON_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__START_DATE = ModelPackage.PERSON_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Job Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__JOB_FUNCTION = ModelPackage.PERSON_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Department</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__DEPARTMENT = ModelPackage.PERSON_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>License No</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__LICENSE_NO = ModelPackage.PERSON_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Employer</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__EMPLOYER = ModelPackage.PERSON_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>System Identity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__SYSTEM_IDENTITY = ModelPackage.PERSON_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Employee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE_FEATURE_COUNT = ModelPackage.PERSON_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyLocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyLocationImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getDairyLocation()
	 * @generated
	 */
	int DAIRY_LOCATION = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Date Opened</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__DATE_OPENED = 2;

	/**
	 * The feature id for the '<em><b>Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__PHONE = 3;

	/**
	 * The feature id for the '<em><b>Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__ROUTE = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__DESCRIPTION = 5;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__CODE = 6;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__LOCATION = 7;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__FUNCTIONS = 8;

	/**
	 * The feature id for the '<em><b>Containers</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION__CONTAINERS = 9;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_LOCATION_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl <em>Collection Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getCollectionGroup()
	 * @generated
	 */
	int COLLECTION_GROUP = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__ID = 0;

	/**
	 * The feature id for the '<em><b>Reference Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__REFERENCE_NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Collection Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__COLLECTION_DATE = 2;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__STATUS = 3;

	/**
	 * The feature id for the '<em><b>Driver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__DRIVER = 4;

	/**
	 * The feature id for the '<em><b>Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__VEHICLE = 5;

	/**
	 * The feature id for the '<em><b>Driver Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__DRIVER_TOTAL = 6;

	/**
	 * The feature id for the '<em><b>Record Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__RECORD_TOTAL = 7;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__ENTRIES = 8;

	/**
	 * The feature id for the '<em><b>Suspended</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__SUSPENDED = 9;

	/**
	 * The feature id for the '<em><b>Entry Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__ENTRY_COUNT = 10;

	/**
	 * The feature id for the '<em><b>Suspended Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__SUSPENDED_COUNT = 11;

	/**
	 * The feature id for the '<em><b>Rejected Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__REJECTED_COUNT = 12;

	/**
	 * The feature id for the '<em><b>Journal Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__JOURNAL_NUMBER = 13;

	/**
	 * The feature id for the '<em><b>Session</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__SESSION = 14;

	/**
	 * The feature id for the '<em><b>Collection Center</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__COLLECTION_CENTER = 15;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP__TYPE = 16;

	/**
	 * The number of structural features of the '<em>Collection Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_GROUP_FEATURE_COUNT = 17;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.TransportRouteImpl <em>Transport Route</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.TransportRouteImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getTransportRoute()
	 * @generated
	 */
	int TRANSPORT_ROUTE = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSPORT_ROUTE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSPORT_ROUTE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSPORT_ROUTE__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSPORT_ROUTE__VEHICLE = 3;

	/**
	 * The feature id for the '<em><b>Stops</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSPORT_ROUTE__STOPS = 4;

	/**
	 * The feature id for the '<em><b>Bins</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSPORT_ROUTE__BINS = 5;

	/**
	 * The number of structural features of the '<em>Transport Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSPORT_ROUTE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.TripImpl <em>Trip</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.TripImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getTrip()
	 * @generated
	 */
	int TRIP = 7;

	/**
	 * The feature id for the '<em><b>Collections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIP__COLLECTIONS = 0;

	/**
	 * The feature id for the '<em><b>Deliveries</b></em>' containment reference list.
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
	 * The feature id for the '<em><b>Trip Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIP__TRIP_ID = 4;

	/**
	 * The number of structural features of the '<em>Trip</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIP_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleGroupImpl <em>Milk Sale Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleGroupImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMilkSaleGroup()
	 * @generated
	 */
	int MILK_SALE_GROUP = 8;

	/**
	 * The feature id for the '<em><b>Reference Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE_GROUP__REFERENCE_NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE_GROUP__DATE = 1;

	/**
	 * The feature id for the '<em><b>Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE_GROUP__ROUTE = 2;

	/**
	 * The feature id for the '<em><b>Customer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE_GROUP__CUSTOMER = 3;

	/**
	 * The feature id for the '<em><b>Driver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE_GROUP__DRIVER = 4;

	/**
	 * The feature id for the '<em><b>Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE_GROUP__VEHICLE = 5;

	/**
	 * The feature id for the '<em><b>Sales</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE_GROUP__SALES = 6;

	/**
	 * The feature id for the '<em><b>Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE_GROUP__TOTAL = 7;

	/**
	 * The feature id for the '<em><b>Session</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE_GROUP__SESSION = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE_GROUP__ID = 9;

	/**
	 * The number of structural features of the '<em>Milk Sale Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE_GROUP_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkGradeImpl <em>Milk Grade</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.MilkGradeImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMilkGrade()
	 * @generated
	 */
	int MILK_GRADE = 9;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_GRADE__CODE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_GRADE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_GRADE__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Milk Grade</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_GRADE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkGradeChangeImpl <em>Milk Grade Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.MilkGradeChangeImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMilkGradeChange()
	 * @generated
	 */
	int MILK_GRADE_CHANGE = 10;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_GRADE_CHANGE__DATE = 0;

	/**
	 * The feature id for the '<em><b>Starting Grade</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_GRADE_CHANGE__STARTING_GRADE = 1;

	/**
	 * The feature id for the '<em><b>Ending Grade</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_GRADE_CHANGE__ENDING_GRADE = 2;

	/**
	 * The feature id for the '<em><b>Changed By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_GRADE_CHANGE__CHANGED_BY = 3;

	/**
	 * The feature id for the '<em><b>Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_GRADE_CHANGE__REASON = 4;

	/**
	 * The number of structural features of the '<em>Milk Grade Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_GRADE_CHANGE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl <em>Milk Sale</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMilkSale()
	 * @generated
	 */
	int MILK_SALE = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__ID = 0;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__LINE_NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Reference Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__REFERENCE_NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Sale Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__SALE_DATE = 3;

	/**
	 * The feature id for the '<em><b>Session</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__SESSION = 4;

	/**
	 * The feature id for the '<em><b>Bin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__BIN = 5;

	/**
	 * The feature id for the '<em><b>Sale Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__SALE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__QUANTITY = 7;

	/**
	 * The feature id for the '<em><b>Grade</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__GRADE = 8;

	/**
	 * The feature id for the '<em><b>Unit Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__UNIT_PRICE = 9;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__DESCRIPTION = 10;

	/**
	 * The feature id for the '<em><b>Rejected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__REJECTED = 11;

	/**
	 * The feature id for the '<em><b>Store Or Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__STORE_OR_ROUTE = 12;

	/**
	 * The feature id for the '<em><b>Customer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__CUSTOMER = 13;

	/**
	 * The feature id for the '<em><b>Sold By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__SOLD_BY = 14;

	/**
	 * The feature id for the '<em><b>Sale Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__SALE_AMOUNT = 15;

	/**
	 * The feature id for the '<em><b>Contract Sale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__CONTRACT_SALE = 16;

	/**
	 * The feature id for the '<em><b>Sales Clerk</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE__SALES_CLERK = 17;

	/**
	 * The number of structural features of the '<em>Milk Sale</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILK_SALE_FEATURE_COUNT = 18;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl <em>Dairy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getDairy()
	 * @generated
	 */
	int DAIRY = 12;

	/**
	 * The feature id for the '<em><b>Contact Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__CONTACT_METHODS = ModelPackage.COMPANY__CONTACT_METHODS;

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
	 * The feature id for the '<em><b>Contacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__CONTACTS = ModelPackage.COMPANY__CONTACTS;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__LOCATION = ModelPackage.COMPANY__LOCATION;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__PHONE_NUMBER = ModelPackage.COMPANY__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Company Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__COMPANY_ID = ModelPackage.COMPANY__COMPANY_ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__DESCRIPTION = ModelPackage.COMPANY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Profile Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__PROFILE_PHOTO = ModelPackage.COMPANY__PROFILE_PHOTO;

	/**
	 * The feature id for the '<em><b>Registration Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__REGISTRATION_NUMBER = ModelPackage.COMPANY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Established Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__ESTABLISHED_DATE = ModelPackage.COMPANY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Manager Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__MANAGER_NAME = ModelPackage.COMPANY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Nssf Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__NSSF_NUMBER = ModelPackage.COMPANY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Nhif Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__NHIF_NUMBER = ModelPackage.COMPANY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Federal Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__FEDERAL_PIN = ModelPackage.COMPANY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>License Effective Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__LICENSE_EFFECTIVE_DATE = ModelPackage.COMPANY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>License Expiration Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__LICENSE_EXPIRATION_DATE = ModelPackage.COMPANY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Routes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__ROUTES = ModelPackage.COMPANY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Vehicles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__VEHICLES = ModelPackage.COMPANY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Employees</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__EMPLOYEES = ModelPackage.COMPANY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Memberships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__MEMBERSHIPS = ModelPackage.COMPANY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Branch Locations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__BRANCH_LOCATIONS = ModelPackage.COMPANY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Collection Journals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__COLLECTION_JOURNALS = ModelPackage.COMPANY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Delivery Journals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__DELIVERY_JOURNALS = ModelPackage.COMPANY_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Suppliers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__SUPPLIERS = ModelPackage.COMPANY_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Customers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__CUSTOMERS = ModelPackage.COMPANY_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Animal Health Requests</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__ANIMAL_HEALTH_REQUESTS = ModelPackage.COMPANY_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Dairy Bins</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__DAIRY_BINS = ModelPackage.COMPANY_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Price History</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__PRICE_HISTORY = ModelPackage.COMPANY_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__VERSION = ModelPackage.COMPANY_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Collection Sessions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__COLLECTION_SESSIONS = ModelPackage.COMPANY_FEATURE_COUNT + 21;

	/**
	 * The number of structural features of the '<em>Dairy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_FEATURE_COUNT = ModelPackage.COMPANY_FEATURE_COUNT + 22;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MembershipImpl <em>Membership</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.MembershipImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMembership()
	 * @generated
	 */
	int MEMBERSHIP = 13;

	/**
	 * The feature id for the '<em><b>Member Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__MEMBER_ID = 0;

	/**
	 * The feature id for the '<em><b>Member Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__MEMBER_NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Application Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__APPLICATION_DATE = 2;

	/**
	 * The feature id for the '<em><b>Effective Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__EFFECTIVE_DATE = 3;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__STATUS = 4;

	/**
	 * The feature id for the '<em><b>Default Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__DEFAULT_ROUTE = 5;

	/**
	 * The feature id for the '<em><b>Farmer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__FARMER = 6;

	/**
	 * The feature id for the '<em><b>Account</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__ACCOUNT = 7;

	/**
	 * The feature id for the '<em><b>Dairy</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__DAIRY = 8;

	/**
	 * The feature id for the '<em><b>Maziwa Card Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__MAZIWA_CARD_NUMBER = 9;

	/**
	 * The feature id for the '<em><b>Maziwa Card Issue Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__MAZIWA_CARD_ISSUE_DATE = 10;

	/**
	 * The number of structural features of the '<em>Membership</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.AssetImpl <em>Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.AssetImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getAsset()
	 * @generated
	 */
	int ASSET = 14;

	/**
	 * The feature id for the '<em><b>Tag Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__TAG_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Tag Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__TAG_VALUE = 1;

	/**
	 * The feature id for the '<em><b>Date Acquired</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DATE_ACQUIRED = 2;

	/**
	 * The feature id for the '<em><b>Damage Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DAMAGE_DATE = 3;

	/**
	 * The feature id for the '<em><b>Damage Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DAMAGE_DESCRIPTION = 4;

	/**
	 * The feature id for the '<em><b>Date Disposed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DATE_DISPOSED = 5;

	/**
	 * The feature id for the '<em><b>Disposal Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DISPOSAL_REASON = 6;

	/**
	 * The feature id for the '<em><b>Disposal Witness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DISPOSAL_WITNESS = 7;

	/**
	 * The number of structural features of the '<em>Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.BinImpl <em>Bin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.BinImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getBin()
	 * @generated
	 */
	int BIN = 15;

	/**
	 * The feature id for the '<em><b>Container Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIN__CONTAINER_ID = TrackingPackage.CONTAINER__CONTAINER_ID;

	/**
	 * The feature id for the '<em><b>Tracking Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIN__TRACKING_NUMBER = TrackingPackage.CONTAINER__TRACKING_NUMBER;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIN__OWNER = TrackingPackage.CONTAINER__OWNER;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIN__CAPACITY = TrackingPackage.CONTAINER__CAPACITY;

	/**
	 * The feature id for the '<em><b>Measure Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIN__MEASURE_TYPE = TrackingPackage.CONTAINER__MEASURE_TYPE;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIN__QUANTITY = TrackingPackage.CONTAINER__QUANTITY;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIN__STATUS = TrackingPackage.CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Zone</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIN__ZONE = TrackingPackage.CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Asset Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIN__ASSET_INFO = TrackingPackage.CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIN_FEATURE_COUNT = TrackingPackage.CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.SupplierImpl <em>Supplier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.SupplierImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getSupplier()
	 * @generated
	 */
	int SUPPLIER = 16;

	/**
	 * The feature id for the '<em><b>Contact Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__CONTACT_METHODS = ModelPackage.COMPANY__CONTACT_METHODS;

	/**
	 * The feature id for the '<em><b>Legal Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__LEGAL_NAME = ModelPackage.COMPANY__LEGAL_NAME;

	/**
	 * The feature id for the '<em><b>Company Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__COMPANY_NAME = ModelPackage.COMPANY__COMPANY_NAME;

	/**
	 * The feature id for the '<em><b>Contacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__CONTACTS = ModelPackage.COMPANY__CONTACTS;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__LOCATION = ModelPackage.COMPANY__LOCATION;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__PHONE_NUMBER = ModelPackage.COMPANY__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Company Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__COMPANY_ID = ModelPackage.COMPANY__COMPANY_ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__DESCRIPTION = ModelPackage.COMPANY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Profile Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__PROFILE_PHOTO = ModelPackage.COMPANY__PROFILE_PHOTO;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__CATEGORIES = ModelPackage.COMPANY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__ID = ModelPackage.COMPANY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Public Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__PUBLIC_DESCRIPTION = ModelPackage.COMPANY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__STATUS = ModelPackage.COMPANY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Registration Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__REGISTRATION_DATE = ModelPackage.COMPANY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Expiration Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__EXPIRATION_DATE = ModelPackage.COMPANY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__NOTES = ModelPackage.COMPANY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__RATING = ModelPackage.COMPANY_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Supplier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER_FEATURE_COUNT = ModelPackage.COMPANY_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CustomerImpl <em>Customer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.CustomerImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getCustomer()
	 * @generated
	 */
	int CUSTOMER = 17;

	/**
	 * The feature id for the '<em><b>Contact Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__CONTACT_METHODS = ModelPackage.COMPANY__CONTACT_METHODS;

	/**
	 * The feature id for the '<em><b>Legal Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__LEGAL_NAME = ModelPackage.COMPANY__LEGAL_NAME;

	/**
	 * The feature id for the '<em><b>Company Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__COMPANY_NAME = ModelPackage.COMPANY__COMPANY_NAME;

	/**
	 * The feature id for the '<em><b>Contacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__CONTACTS = ModelPackage.COMPANY__CONTACTS;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__LOCATION = ModelPackage.COMPANY__LOCATION;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__PHONE_NUMBER = ModelPackage.COMPANY__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Company Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__COMPANY_ID = ModelPackage.COMPANY__COMPANY_ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__DESCRIPTION = ModelPackage.COMPANY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Profile Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__PROFILE_PHOTO = ModelPackage.COMPANY__PROFILE_PHOTO;

	/**
	 * The feature id for the '<em><b>Customer Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__CUSTOMER_NUMBER = ModelPackage.COMPANY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Customer Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__CUSTOMER_TYPE = ModelPackage.COMPANY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__STATUS = ModelPackage.COMPANY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_FEATURE_COUNT = ModelPackage.COMPANY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MemberPaymentImpl <em>Member Payment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.MemberPaymentImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMemberPayment()
	 * @generated
	 */
	int MEMBER_PAYMENT = 18;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_PAYMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_PAYMENT__YEAR = 1;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_PAYMENT__MONTH = 2;

	/**
	 * The feature id for the '<em><b>Payment Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_PAYMENT__PAYMENT_RATE = 3;

	/**
	 * The feature id for the '<em><b>Payments Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_PAYMENT__PAYMENTS_TOTAL = 4;

	/**
	 * The feature id for the '<em><b>Payments Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_PAYMENT__PAYMENTS_COUNT = 5;

	/**
	 * The feature id for the '<em><b>Entered By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_PAYMENT__ENTERED_BY = 6;

	/**
	 * The feature id for the '<em><b>Entry Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_PAYMENT__ENTRY_DATE = 7;

	/**
	 * The number of structural features of the '<em>Member Payment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_PAYMENT_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.PreferenceImpl <em>Preference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.PreferenceImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getPreference()
	 * @generated
	 */
	int PREFERENCE = 19;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE__ID = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE__KEY = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Preference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.PreferenceKeyImpl <em>Preference Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.PreferenceKeyImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getPreferenceKey()
	 * @generated
	 */
	int PREFERENCE_KEY = 20;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE_KEY__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE_KEY__NAME = 1;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE_KEY__DEFAULT_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE_KEY__TYPE = 3;

	/**
	 * The number of structural features of the '<em>Preference Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE_KEY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionSessionImpl <em>Collection Session</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionSessionImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getCollectionSession()
	 * @generated
	 */
	int COLLECTION_SESSION = 21;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_SESSION__ID = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_SESSION__CODE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_SESSION__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Time Of Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_SESSION__TIME_OF_DAY = 3;

	/**
	 * The feature id for the '<em><b>Dairy</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_SESSION__DAIRY = 4;

	/**
	 * The number of structural features of the '<em>Collection Session</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_SESSION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.JournalStatus <em>Journal Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.JournalStatus
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getJournalStatus()
	 * @generated
	 */
	int JOURNAL_STATUS = 22;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleType <em>Milk Sale Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleType
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMilkSaleType()
	 * @generated
	 */
	int MILK_SALE_TYPE = 23;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus <em>Membership Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMembershipStatus()
	 * @generated
	 */
	int MEMBERSHIP_STATUS = 24;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.VendorStatus <em>Vendor Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.VendorStatus
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getVendorStatus()
	 * @generated
	 */
	int VENDOR_STATUS = 25;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyFunction <em>Function</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyFunction
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getDairyFunction()
	 * @generated
	 */
	int DAIRY_FUNCTION = 26;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.PreferenceType <em>Preference Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.PreferenceType
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getPreferenceType()
	 * @generated
	 */
	int PREFERENCE_TYPE = 27;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroupType <em>Collection Group Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroupType
	 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getCollectionGroupType()
	 * @generated
	 */
	int COLLECTION_GROUP_TYPE = 28;


	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle <em>Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vehicle</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle
	 * @generated
	 */
	EClass getVehicle();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getVehicleId <em>Vehicle Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vehicle Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getVehicleId()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_VehicleId();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getRegistrationNumber <em>Registration Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registration Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getRegistrationNumber()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_RegistrationNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getType()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getMake <em>Make</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Make</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getMake()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_Make();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getModel()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_Model();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getEngineNumber <em>Engine Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Engine Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getEngineNumber()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_EngineNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getChassisNumber <em>Chassis Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chassis Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getChassisNumber()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_ChassisNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getLogBookNumber <em>Log Book Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Book Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getLogBookNumber()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_LogBookNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getInsurancePolicyNumber <em>Insurance Policy Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Insurance Policy Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getInsurancePolicyNumber()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_InsurancePolicyNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getInsuranceExpirationDate <em>Insurance Expiration Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Insurance Expiration Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getInsuranceExpirationDate()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_InsuranceExpirationDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getDominantColour <em>Dominant Colour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dominant Colour</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getDominantColour()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_DominantColour();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getCapacityInTonnes <em>Capacity In Tonnes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity In Tonnes</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getCapacityInTonnes()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_CapacityInTonnes();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getYear()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_Year();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getDriver <em>Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Driver</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getDriver()
	 * @see #getVehicle()
	 * @generated
	 */
	EReference getVehicle_Driver();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getAssetInfo <em>Asset Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Asset Info</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getAssetInfo()
	 * @see #getVehicle()
	 * @generated
	 */
	EReference getVehicle_AssetInfo();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine <em>Collection Journal Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Journal Line</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine
	 * @generated
	 */
	EClass getCollectionJournalLine();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getLineNumber()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_LineNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getRecordedMember <em>Recorded Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recorded Member</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getRecordedMember()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_RecordedMember();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getQuantity()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_Quantity();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isFlagged <em>Flagged</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flagged</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isFlagged()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_Flagged();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getUnitOfMeasure <em>Unit Of Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit Of Measure</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getUnitOfMeasure()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_UnitOfMeasure();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isNotRecorded <em>Not Recorded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Not Recorded</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isNotRecorded()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_NotRecorded();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getValidatedMember <em>Validated Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Validated Member</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getValidatedMember()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EReference getCollectionJournalLine_ValidatedMember();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isOffRoute <em>Off Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Off Route</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isOffRoute()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_OffRoute();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getFrom()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EReference getCollectionJournalLine_From();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getFarmContainer <em>Farm Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Farm Container</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getFarmContainer()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EReference getCollectionJournalLine_FarmContainer();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getBin <em>Bin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bin</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getBin()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EReference getCollectionJournalLine_Bin();

	/**
	 * Returns the meta object for the container reference '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Group</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getGroup()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EReference getCollectionJournalLine_Group();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isRejected <em>Rejected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rejected</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isRejected()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_Rejected();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getRejectionReason <em>Rejection Reason</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rejection Reason</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getRejectionReason()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_RejectionReason();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getMilkFatPercentage <em>Milk Fat Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Milk Fat Percentage</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getMilkFatPercentage()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_MilkFatPercentage();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getAlcoholPercentage <em>Alcohol Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alcohol Percentage</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getAlcoholPercentage()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_AlcoholPercentage();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isWaterAdded <em>Water Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Water Added</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isWaterAdded()
	 * @see #getCollectionJournalLine()
	 * @generated
	 */
	EAttribute getCollectionJournalLine_WaterAdded();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord <em>Scale Import Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scale Import Record</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord
	 * @generated
	 */
	EClass getScaleImportRecord();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getScaleSerial <em>Scale Serial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale Serial</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getScaleSerial()
	 * @see #getScaleImportRecord()
	 * @generated
	 */
	EAttribute getScaleImportRecord_ScaleSerial();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getCollectionTime <em>Collection Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Collection Time</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getCollectionTime()
	 * @see #getScaleImportRecord()
	 * @generated
	 */
	EAttribute getScaleImportRecord_CollectionTime();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getCenterNumber <em>Center Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Center Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getCenterNumber()
	 * @see #getScaleImportRecord()
	 * @generated
	 */
	EAttribute getScaleImportRecord_CenterNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getNumCans <em>Num Cans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Cans</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getNumCans()
	 * @see #getScaleImportRecord()
	 * @generated
	 */
	EAttribute getScaleImportRecord_NumCans();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getTripNumber <em>Trip Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trip Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getTripNumber()
	 * @see #getScaleImportRecord()
	 * @generated
	 */
	EAttribute getScaleImportRecord_TripNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getOperatorCode <em>Operator Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator Code</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getOperatorCode()
	 * @see #getScaleImportRecord()
	 * @generated
	 */
	EAttribute getScaleImportRecord_OperatorCode();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#isValidated <em>Validated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validated</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#isValidated()
	 * @see #getScaleImportRecord()
	 * @generated
	 */
	EAttribute getScaleImportRecord_Validated();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee <em>Employee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Employee</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Employee
	 * @generated
	 */
	EClass getEmployee();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getEmployeeNumber <em>Employee Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Employee Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Employee#getEmployeeNumber()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_EmployeeNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getOperatorCode <em>Operator Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator Code</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Employee#getOperatorCode()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_OperatorCode();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getStartDate <em>Start Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Employee#getStartDate()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_StartDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getJobFunction <em>Job Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Job Function</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Employee#getJobFunction()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_JobFunction();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getDepartment <em>Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Department</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Employee#getDepartment()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_Department();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getLicenseNo <em>License No</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>License No</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Employee#getLicenseNo()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_LicenseNo();

	/**
	 * Returns the meta object for the container reference '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getEmployer <em>Employer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Employer</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Employee#getEmployer()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_Employer();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getSystemIdentity <em>System Identity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>System Identity</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Employee#getSystemIdentity()
	 * @see #getEmployee()
	 * @generated
	 */
	EReference getEmployee_SystemIdentity();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyLocation
	 * @generated
	 */
	EClass getDairyLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getId()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EAttribute getDairyLocation_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getName()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EAttribute getDairyLocation_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getDateOpened <em>Date Opened</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Opened</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getDateOpened()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EAttribute getDairyLocation_DateOpened();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getPhone <em>Phone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phone</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getPhone()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EAttribute getDairyLocation_Phone();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getRoute <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Route</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getRoute()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EReference getDairyLocation_Route();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getDescription()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EAttribute getDairyLocation_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getCode()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EAttribute getDairyLocation_Code();

	/**
	 * Returns the meta object for the containment reference '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getLocation()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EReference getDairyLocation_Location();

	/**
	 * Returns the meta object for the attribute list '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Functions</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getFunctions()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EAttribute getDairyLocation_Functions();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getContainers <em>Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Containers</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getContainers()
	 * @see #getDairyLocation()
	 * @generated
	 */
	EReference getDairyLocation_Containers();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup <em>Collection Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Group</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup
	 * @generated
	 */
	EClass getCollectionGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getId()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EAttribute getCollectionGroup_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getReferenceNumber <em>Reference Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getReferenceNumber()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EAttribute getCollectionGroup_ReferenceNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getCollectionDate <em>Collection Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Collection Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getCollectionDate()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EAttribute getCollectionGroup_CollectionDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getStatus()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EAttribute getCollectionGroup_Status();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getDriver <em>Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Driver</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getDriver()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EReference getCollectionGroup_Driver();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getVehicle <em>Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vehicle</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getVehicle()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EReference getCollectionGroup_Vehicle();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getDriverTotal <em>Driver Total</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Driver Total</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getDriverTotal()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EAttribute getCollectionGroup_DriverTotal();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getRecordTotal <em>Record Total</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Total</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getRecordTotal()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EAttribute getCollectionGroup_RecordTotal();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getEntries()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EReference getCollectionGroup_Entries();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#isSuspended <em>Suspended</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suspended</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#isSuspended()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EAttribute getCollectionGroup_Suspended();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getEntryCount <em>Entry Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Entry Count</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getEntryCount()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EAttribute getCollectionGroup_EntryCount();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getSuspendedCount <em>Suspended Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suspended Count</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getSuspendedCount()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EAttribute getCollectionGroup_SuspendedCount();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getRejectedCount <em>Rejected Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rejected Count</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getRejectedCount()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EAttribute getCollectionGroup_RejectedCount();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getJournalNumber <em>Journal Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Journal Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getJournalNumber()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EAttribute getCollectionGroup_JournalNumber();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getSession <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Session</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getSession()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EReference getCollectionGroup_Session();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getCollectionCenter <em>Collection Center</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Collection Center</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getCollectionCenter()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EReference getCollectionGroup_CollectionCenter();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getType()
	 * @see #getCollectionGroup()
	 * @generated
	 */
	EAttribute getCollectionGroup_Type();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute <em>Transport Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transport Route</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.TransportRoute
	 * @generated
	 */
	EClass getTransportRoute();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getId()
	 * @see #getTransportRoute()
	 * @generated
	 */
	EAttribute getTransportRoute_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getName()
	 * @see #getTransportRoute()
	 * @generated
	 */
	EAttribute getTransportRoute_Name();

	/**
	 * Returns the meta object for the reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getStops <em>Stops</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stops</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getStops()
	 * @see #getTransportRoute()
	 * @generated
	 */
	EReference getTransportRoute_Stops();

	/**
	 * Returns the meta object for the reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getBins <em>Bins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Bins</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getBins()
	 * @see #getTransportRoute()
	 * @generated
	 */
	EReference getTransportRoute_Bins();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getDescription()
	 * @see #getTransportRoute()
	 * @generated
	 */
	EAttribute getTransportRoute_Description();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getVehicle <em>Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vehicle</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getVehicle()
	 * @see #getTransportRoute()
	 * @generated
	 */
	EReference getTransportRoute_Vehicle();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.Trip <em>Trip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trip</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Trip
	 * @generated
	 */
	EClass getTrip();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.Trip#getCollections <em>Collections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collections</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Trip#getCollections()
	 * @see #getTrip()
	 * @generated
	 */
	EReference getTrip_Collections();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.Trip#getDeliveries <em>Deliveries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deliveries</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Trip#getDeliveries()
	 * @see #getTrip()
	 * @generated
	 */
	EReference getTrip_Deliveries();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Trip#getStarted <em>Started</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Started</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Trip#getStarted()
	 * @see #getTrip()
	 * @generated
	 */
	EAttribute getTrip_Started();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Trip#getEnded <em>Ended</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ended</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Trip#getEnded()
	 * @see #getTrip()
	 * @generated
	 */
	EAttribute getTrip_Ended();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Trip#getTripId <em>Trip Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trip Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Trip#getTripId()
	 * @see #getTrip()
	 * @generated
	 */
	EAttribute getTrip_TripId();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup <em>Milk Sale Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Milk Sale Group</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup
	 * @generated
	 */
	EClass getMilkSaleGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getReferenceNumber <em>Reference Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getReferenceNumber()
	 * @see #getMilkSaleGroup()
	 * @generated
	 */
	EAttribute getMilkSaleGroup_ReferenceNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getDate()
	 * @see #getMilkSaleGroup()
	 * @generated
	 */
	EAttribute getMilkSaleGroup_Date();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getRoute <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Route</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getRoute()
	 * @see #getMilkSaleGroup()
	 * @generated
	 */
	EReference getMilkSaleGroup_Route();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getCustomer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Customer</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getCustomer()
	 * @see #getMilkSaleGroup()
	 * @generated
	 */
	EReference getMilkSaleGroup_Customer();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getDriver <em>Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Driver</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getDriver()
	 * @see #getMilkSaleGroup()
	 * @generated
	 */
	EReference getMilkSaleGroup_Driver();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getVehicle <em>Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vehicle</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getVehicle()
	 * @see #getMilkSaleGroup()
	 * @generated
	 */
	EReference getMilkSaleGroup_Vehicle();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getSales <em>Sales</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sales</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getSales()
	 * @see #getMilkSaleGroup()
	 * @generated
	 */
	EReference getMilkSaleGroup_Sales();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getTotal <em>Total</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getTotal()
	 * @see #getMilkSaleGroup()
	 * @generated
	 */
	EAttribute getMilkSaleGroup_Total();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getSession <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Session</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getSession()
	 * @see #getMilkSaleGroup()
	 * @generated
	 */
	EReference getMilkSaleGroup_Session();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getId()
	 * @see #getMilkSaleGroup()
	 * @generated
	 */
	EAttribute getMilkSaleGroup_Id();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGrade <em>Milk Grade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Milk Grade</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkGrade
	 * @generated
	 */
	EClass getMilkGrade();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGrade#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkGrade#getCode()
	 * @see #getMilkGrade()
	 * @generated
	 */
	EAttribute getMilkGrade_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGrade#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkGrade#getName()
	 * @see #getMilkGrade()
	 * @generated
	 */
	EAttribute getMilkGrade_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGrade#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkGrade#getDescription()
	 * @see #getMilkGrade()
	 * @generated
	 */
	EAttribute getMilkGrade_Description();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange <em>Milk Grade Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Milk Grade Change</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange
	 * @generated
	 */
	EClass getMilkGradeChange();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getDate()
	 * @see #getMilkGradeChange()
	 * @generated
	 */
	EAttribute getMilkGradeChange_Date();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getStartingGrade <em>Starting Grade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Starting Grade</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getStartingGrade()
	 * @see #getMilkGradeChange()
	 * @generated
	 */
	EReference getMilkGradeChange_StartingGrade();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getEndingGrade <em>Ending Grade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ending Grade</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getEndingGrade()
	 * @see #getMilkGradeChange()
	 * @generated
	 */
	EReference getMilkGradeChange_EndingGrade();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getChangedBy <em>Changed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Changed By</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getChangedBy()
	 * @see #getMilkGradeChange()
	 * @generated
	 */
	EReference getMilkGradeChange_ChangedBy();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getReason <em>Reason</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reason</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getReason()
	 * @see #getMilkGradeChange()
	 * @generated
	 */
	EAttribute getMilkGradeChange_Reason();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale <em>Milk Sale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Milk Sale</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale
	 * @generated
	 */
	EClass getMilkSale();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getId()
	 * @see #getMilkSale()
	 * @generated
	 */
	EAttribute getMilkSale_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getLineNumber()
	 * @see #getMilkSale()
	 * @generated
	 */
	EAttribute getMilkSale_LineNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getReferenceNumber <em>Reference Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getReferenceNumber()
	 * @see #getMilkSale()
	 * @generated
	 */
	EAttribute getMilkSale_ReferenceNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSaleDate <em>Sale Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sale Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSaleDate()
	 * @see #getMilkSale()
	 * @generated
	 */
	EAttribute getMilkSale_SaleDate();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSession <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Session</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSession()
	 * @see #getMilkSale()
	 * @generated
	 */
	EReference getMilkSale_Session();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getBin <em>Bin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bin</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getBin()
	 * @see #getMilkSale()
	 * @generated
	 */
	EReference getMilkSale_Bin();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSaleType <em>Sale Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sale Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSaleType()
	 * @see #getMilkSale()
	 * @generated
	 */
	EAttribute getMilkSale_SaleType();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getQuantity()
	 * @see #getMilkSale()
	 * @generated
	 */
	EAttribute getMilkSale_Quantity();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getGrade <em>Grade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Grade</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getGrade()
	 * @see #getMilkSale()
	 * @generated
	 */
	EReference getMilkSale_Grade();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getUnitPrice <em>Unit Price</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit Price</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getUnitPrice()
	 * @see #getMilkSale()
	 * @generated
	 */
	EAttribute getMilkSale_UnitPrice();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getDescription()
	 * @see #getMilkSale()
	 * @generated
	 */
	EAttribute getMilkSale_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#isRejected <em>Rejected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rejected</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#isRejected()
	 * @see #getMilkSale()
	 * @generated
	 */
	EAttribute getMilkSale_Rejected();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getStoreOrRoute <em>Store Or Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Store Or Route</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getStoreOrRoute()
	 * @see #getMilkSale()
	 * @generated
	 */
	EReference getMilkSale_StoreOrRoute();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getCustomer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Customer</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getCustomer()
	 * @see #getMilkSale()
	 * @generated
	 */
	EReference getMilkSale_Customer();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSoldBy <em>Sold By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sold By</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSoldBy()
	 * @see #getMilkSale()
	 * @generated
	 */
	EReference getMilkSale_SoldBy();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSaleAmount <em>Sale Amount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sale Amount</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSaleAmount()
	 * @see #getMilkSale()
	 * @generated
	 */
	EAttribute getMilkSale_SaleAmount();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#isContractSale <em>Contract Sale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contract Sale</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#isContractSale()
	 * @see #getMilkSale()
	 * @generated
	 */
	EAttribute getMilkSale_ContractSale();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSalesClerk <em>Sales Clerk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sales Clerk</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSalesClerk()
	 * @see #getMilkSale()
	 * @generated
	 */
	EReference getMilkSale_SalesClerk();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy <em>Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dairy</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy
	 * @generated
	 */
	EClass getDairy();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getRegistrationNumber <em>Registration Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registration Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getRegistrationNumber()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_RegistrationNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getEstablishedDate <em>Established Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Established Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getEstablishedDate()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_EstablishedDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getManagerName <em>Manager Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manager Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getManagerName()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_ManagerName();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getNssfNumber <em>Nssf Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nssf Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getNssfNumber()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_NssfNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getNhifNumber <em>Nhif Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nhif Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getNhifNumber()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_NhifNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getFederalPin <em>Federal Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Federal Pin</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getFederalPin()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_FederalPin();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getLicenseEffectiveDate <em>License Effective Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>License Effective Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getLicenseEffectiveDate()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_LicenseEffectiveDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getLicenseExpirationDate <em>License Expiration Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>License Expiration Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getLicenseExpirationDate()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_LicenseExpirationDate();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getRoutes <em>Routes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Routes</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getRoutes()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Routes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getVehicles <em>Vehicles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vehicles</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getVehicles()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Vehicles();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getEmployees <em>Employees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Employees</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getEmployees()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Employees();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getMemberships <em>Memberships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Memberships</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getMemberships()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Memberships();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getBranchLocations <em>Branch Locations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Branch Locations</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getBranchLocations()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_BranchLocations();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getCollectionJournals <em>Collection Journals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collection Journals</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getCollectionJournals()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_CollectionJournals();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getDeliveryJournals <em>Delivery Journals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Delivery Journals</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getDeliveryJournals()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_DeliveryJournals();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getSuppliers <em>Suppliers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Suppliers</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getSuppliers()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Suppliers();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getCustomers <em>Customers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Customers</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getCustomers()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Customers();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getAnimalHealthRequests <em>Animal Health Requests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Animal Health Requests</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getAnimalHealthRequests()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_AnimalHealthRequests();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getDairyBins <em>Dairy Bins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dairy Bins</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getDairyBins()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_DairyBins();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getPriceHistory <em>Price History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Price History</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getPriceHistory()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_PriceHistory();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getVersion()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_Version();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getCollectionSessions <em>Collection Sessions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collection Sessions</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getCollectionSessions()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_CollectionSessions();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership <em>Membership</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Membership</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership
	 * @generated
	 */
	EClass getMembership();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getMemberId <em>Member Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Member Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership#getMemberId()
	 * @see #getMembership()
	 * @generated
	 */
	EAttribute getMembership_MemberId();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getMemberNumber <em>Member Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Member Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership#getMemberNumber()
	 * @see #getMembership()
	 * @generated
	 */
	EAttribute getMembership_MemberNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getApplicationDate <em>Application Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Application Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership#getApplicationDate()
	 * @see #getMembership()
	 * @generated
	 */
	EAttribute getMembership_ApplicationDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getEffectiveDate <em>Effective Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effective Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership#getEffectiveDate()
	 * @see #getMembership()
	 * @generated
	 */
	EAttribute getMembership_EffectiveDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership#getStatus()
	 * @see #getMembership()
	 * @generated
	 */
	EAttribute getMembership_Status();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getDefaultRoute <em>Default Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Route</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership#getDefaultRoute()
	 * @see #getMembership()
	 * @generated
	 */
	EReference getMembership_DefaultRoute();

	/**
	 * Returns the meta object for the containment reference '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getFarmer <em>Farmer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Farmer</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership#getFarmer()
	 * @see #getMembership()
	 * @generated
	 */
	EReference getMembership_Farmer();

	/**
	 * Returns the meta object for the containment reference '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getAccount <em>Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Account</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership#getAccount()
	 * @see #getMembership()
	 * @generated
	 */
	EReference getMembership_Account();

	/**
	 * Returns the meta object for the container reference '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getDairy <em>Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dairy</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership#getDairy()
	 * @see #getMembership()
	 * @generated
	 */
	EReference getMembership_Dairy();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getMaziwaCardNumber <em>Maziwa Card Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maziwa Card Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership#getMaziwaCardNumber()
	 * @see #getMembership()
	 * @generated
	 */
	EAttribute getMembership_MaziwaCardNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getMaziwaCardIssueDate <em>Maziwa Card Issue Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maziwa Card Issue Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership#getMaziwaCardIssueDate()
	 * @see #getMembership()
	 * @generated
	 */
	EAttribute getMembership_MaziwaCardIssueDate();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset <em>Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Asset</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Asset
	 * @generated
	 */
	EClass getAsset();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getTagType <em>Tag Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Asset#getTagType()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_TagType();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getTagValue <em>Tag Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag Value</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Asset#getTagValue()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_TagValue();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDateAcquired <em>Date Acquired</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Acquired</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Asset#getDateAcquired()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_DateAcquired();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDamageDate <em>Damage Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Damage Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Asset#getDamageDate()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_DamageDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDamageDescription <em>Damage Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Damage Description</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Asset#getDamageDescription()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_DamageDescription();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDateDisposed <em>Date Disposed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Disposed</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Asset#getDateDisposed()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_DateDisposed();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDisposalReason <em>Disposal Reason</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disposal Reason</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Asset#getDisposalReason()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_DisposalReason();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDisposalWitness <em>Disposal Witness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disposal Witness</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Asset#getDisposalWitness()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_DisposalWitness();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.Bin <em>Bin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bin</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Bin
	 * @generated
	 */
	EClass getBin();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Bin#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Bin#getStatus()
	 * @see #getBin()
	 * @generated
	 */
	EAttribute getBin_Status();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.Bin#getZone <em>Zone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Zone</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Bin#getZone()
	 * @see #getBin()
	 * @generated
	 */
	EReference getBin_Zone();

	/**
	 * Returns the meta object for the containment reference '{@link com.agritrace.edairy.desktop.common.model.dairy.Bin#getAssetInfo <em>Asset Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Asset Info</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Bin#getAssetInfo()
	 * @see #getBin()
	 * @generated
	 */
	EReference getBin_AssetInfo();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier <em>Supplier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supplier</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Supplier
	 * @generated
	 */
	EClass getSupplier();

	/**
	 * Returns the meta object for the attribute list '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Categories</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Supplier#getCategories()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_Categories();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Supplier#getId()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getPublicDescription <em>Public Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Public Description</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Supplier#getPublicDescription()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_PublicDescription();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Supplier#getStatus()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_Status();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getRegistrationDate <em>Registration Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registration Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Supplier#getRegistrationDate()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_RegistrationDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getExpirationDate <em>Expiration Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expiration Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Supplier#getExpirationDate()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_ExpirationDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getNotes <em>Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Notes</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Supplier#getNotes()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_Notes();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getRating <em>Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rating</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Supplier#getRating()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_Rating();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Customer
	 * @generated
	 */
	EClass getCustomer();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Customer#getCustomerNumber <em>Customer Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customer Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Customer#getCustomerNumber()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_CustomerNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Customer#getCustomerType <em>Customer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customer Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Customer#getCustomerType()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_CustomerType();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Customer#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Customer#getStatus()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_Status();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment <em>Member Payment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member Payment</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MemberPayment
	 * @generated
	 */
	EClass getMemberPayment();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getId()
	 * @see #getMemberPayment()
	 * @generated
	 */
	EAttribute getMemberPayment_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getYear()
	 * @see #getMemberPayment()
	 * @generated
	 */
	EAttribute getMemberPayment_Year();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getMonth()
	 * @see #getMemberPayment()
	 * @generated
	 */
	EAttribute getMemberPayment_Month();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getPaymentRate <em>Payment Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Payment Rate</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getPaymentRate()
	 * @see #getMemberPayment()
	 * @generated
	 */
	EAttribute getMemberPayment_PaymentRate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getPaymentsTotal <em>Payments Total</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Payments Total</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getPaymentsTotal()
	 * @see #getMemberPayment()
	 * @generated
	 */
	EAttribute getMemberPayment_PaymentsTotal();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getPaymentsCount <em>Payments Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Payments Count</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getPaymentsCount()
	 * @see #getMemberPayment()
	 * @generated
	 */
	EAttribute getMemberPayment_PaymentsCount();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getEnteredBy <em>Entered By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entered By</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getEnteredBy()
	 * @see #getMemberPayment()
	 * @generated
	 */
	EReference getMemberPayment_EnteredBy();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getEntryDate <em>Entry Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Entry Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getEntryDate()
	 * @see #getMemberPayment()
	 * @generated
	 */
	EAttribute getMemberPayment_EntryDate();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.Preference <em>Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Preference</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Preference
	 * @generated
	 */
	EClass getPreference();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Preference#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Preference#getId()
	 * @see #getPreference()
	 * @generated
	 */
	EAttribute getPreference_Id();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.Preference#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Preference#getKey()
	 * @see #getPreference()
	 * @generated
	 */
	EReference getPreference_Key();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.Preference#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Preference#getValue()
	 * @see #getPreference()
	 * @generated
	 */
	EAttribute getPreference_Value();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.PreferenceKey <em>Preference Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Preference Key</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.PreferenceKey
	 * @generated
	 */
	EClass getPreferenceKey();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.PreferenceKey#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.PreferenceKey#getId()
	 * @see #getPreferenceKey()
	 * @generated
	 */
	EAttribute getPreferenceKey_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.PreferenceKey#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.PreferenceKey#getName()
	 * @see #getPreferenceKey()
	 * @generated
	 */
	EAttribute getPreferenceKey_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.PreferenceKey#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.PreferenceKey#getDefaultValue()
	 * @see #getPreferenceKey()
	 * @generated
	 */
	EAttribute getPreferenceKey_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.PreferenceKey#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.PreferenceKey#getType()
	 * @see #getPreferenceKey()
	 * @generated
	 */
	EAttribute getPreferenceKey_Type();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession <em>Collection Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Session</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionSession
	 * @generated
	 */
	EClass getCollectionSession();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getId()
	 * @see #getCollectionSession()
	 * @generated
	 */
	EAttribute getCollectionSession_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getCode()
	 * @see #getCollectionSession()
	 * @generated
	 */
	EAttribute getCollectionSession_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getDescription()
	 * @see #getCollectionSession()
	 * @generated
	 */
	EAttribute getCollectionSession_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getTimeOfDay <em>Time Of Day</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Of Day</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getTimeOfDay()
	 * @see #getCollectionSession()
	 * @generated
	 */
	EAttribute getCollectionSession_TimeOfDay();

	/**
	 * Returns the meta object for the container reference '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getDairy <em>Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dairy</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getDairy()
	 * @see #getCollectionSession()
	 * @generated
	 */
	EReference getCollectionSession_Dairy();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.dairy.JournalStatus <em>Journal Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Journal Status</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.JournalStatus
	 * @generated
	 */
	EEnum getJournalStatus();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleType <em>Milk Sale Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Milk Sale Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleType
	 * @generated
	 */
	EEnum getMilkSaleType();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus <em>Membership Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Membership Status</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus
	 * @generated
	 */
	EEnum getMembershipStatus();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.dairy.VendorStatus <em>Vendor Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Vendor Status</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.VendorStatus
	 * @generated
	 */
	EEnum getVendorStatus();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Function</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyFunction
	 * @generated
	 */
	EEnum getDairyFunction();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.dairy.PreferenceType <em>Preference Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Preference Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.PreferenceType
	 * @generated
	 */
	EEnum getPreferenceType();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroupType <em>Collection Group Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Collection Group Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroupType
	 * @generated
	 */
	EEnum getCollectionGroupType();

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
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl <em>Vehicle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getVehicle()
		 * @generated
		 */
		EClass VEHICLE = eINSTANCE.getVehicle();

		/**
		 * The meta object literal for the '<em><b>Vehicle Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__VEHICLE_ID = eINSTANCE.getVehicle_VehicleId();

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
		 * The meta object literal for the '<em><b>Insurance Expiration Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__INSURANCE_EXPIRATION_DATE = eINSTANCE.getVehicle_InsuranceExpirationDate();

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
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__YEAR = eINSTANCE.getVehicle_Year();

		/**
		 * The meta object literal for the '<em><b>Driver</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VEHICLE__DRIVER = eINSTANCE.getVehicle_Driver();

		/**
		 * The meta object literal for the '<em><b>Asset Info</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VEHICLE__ASSET_INFO = eINSTANCE.getVehicle_AssetInfo();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl <em>Collection Journal Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getCollectionJournalLine()
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
		 * The meta object literal for the '<em><b>Bin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_JOURNAL_LINE__BIN = eINSTANCE.getCollectionJournalLine_Bin();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_JOURNAL_LINE__GROUP = eINSTANCE.getCollectionJournalLine_Group();

		/**
		 * The meta object literal for the '<em><b>Rejected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL_LINE__REJECTED = eINSTANCE.getCollectionJournalLine_Rejected();

		/**
		 * The meta object literal for the '<em><b>Rejection Reason</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL_LINE__REJECTION_REASON = eINSTANCE.getCollectionJournalLine_RejectionReason();

		/**
		 * The meta object literal for the '<em><b>Milk Fat Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL_LINE__MILK_FAT_PERCENTAGE = eINSTANCE.getCollectionJournalLine_MilkFatPercentage();

		/**
		 * The meta object literal for the '<em><b>Alcohol Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL_LINE__ALCOHOL_PERCENTAGE = eINSTANCE.getCollectionJournalLine_AlcoholPercentage();

		/**
		 * The meta object literal for the '<em><b>Water Added</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL_LINE__WATER_ADDED = eINSTANCE.getCollectionJournalLine_WaterAdded();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.ScaleImportRecordImpl <em>Scale Import Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.ScaleImportRecordImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getScaleImportRecord()
		 * @generated
		 */
		EClass SCALE_IMPORT_RECORD = eINSTANCE.getScaleImportRecord();

		/**
		 * The meta object literal for the '<em><b>Scale Serial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALE_IMPORT_RECORD__SCALE_SERIAL = eINSTANCE.getScaleImportRecord_ScaleSerial();

		/**
		 * The meta object literal for the '<em><b>Collection Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALE_IMPORT_RECORD__COLLECTION_TIME = eINSTANCE.getScaleImportRecord_CollectionTime();

		/**
		 * The meta object literal for the '<em><b>Center Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALE_IMPORT_RECORD__CENTER_NUMBER = eINSTANCE.getScaleImportRecord_CenterNumber();

		/**
		 * The meta object literal for the '<em><b>Num Cans</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALE_IMPORT_RECORD__NUM_CANS = eINSTANCE.getScaleImportRecord_NumCans();

		/**
		 * The meta object literal for the '<em><b>Trip Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALE_IMPORT_RECORD__TRIP_NUMBER = eINSTANCE.getScaleImportRecord_TripNumber();

		/**
		 * The meta object literal for the '<em><b>Operator Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALE_IMPORT_RECORD__OPERATOR_CODE = eINSTANCE.getScaleImportRecord_OperatorCode();

		/**
		 * The meta object literal for the '<em><b>Validated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALE_IMPORT_RECORD__VALIDATED = eINSTANCE.getScaleImportRecord_Validated();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl <em>Employee</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.EmployeeImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getEmployee()
		 * @generated
		 */
		EClass EMPLOYEE = eINSTANCE.getEmployee();

		/**
		 * The meta object literal for the '<em><b>Employee Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPLOYEE__EMPLOYEE_NUMBER = eINSTANCE.getEmployee_EmployeeNumber();

		/**
		 * The meta object literal for the '<em><b>Operator Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPLOYEE__OPERATOR_CODE = eINSTANCE.getEmployee_OperatorCode();

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
		 * The meta object literal for the '<em><b>Department</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPLOYEE__DEPARTMENT = eINSTANCE.getEmployee_Department();

		/**
		 * The meta object literal for the '<em><b>License No</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPLOYEE__LICENSE_NO = eINSTANCE.getEmployee_LicenseNo();

		/**
		 * The meta object literal for the '<em><b>Employer</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMPLOYEE__EMPLOYER = eINSTANCE.getEmployee_Employer();

		/**
		 * The meta object literal for the '<em><b>System Identity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMPLOYEE__SYSTEM_IDENTITY = eINSTANCE.getEmployee_SystemIdentity();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyLocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyLocationImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getDairyLocation()
		 * @generated
		 */
		EClass DAIRY_LOCATION = eINSTANCE.getDairyLocation();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY_LOCATION__ID = eINSTANCE.getDairyLocation_Id();

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
		 * The meta object literal for the '<em><b>Containers</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY_LOCATION__CONTAINERS = eINSTANCE.getDairyLocation_Containers();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl <em>Collection Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionGroupImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getCollectionGroup()
		 * @generated
		 */
		EClass COLLECTION_GROUP = eINSTANCE.getCollectionGroup();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_GROUP__ID = eINSTANCE.getCollectionGroup_Id();

		/**
		 * The meta object literal for the '<em><b>Reference Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_GROUP__REFERENCE_NUMBER = eINSTANCE.getCollectionGroup_ReferenceNumber();

		/**
		 * The meta object literal for the '<em><b>Collection Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_GROUP__COLLECTION_DATE = eINSTANCE.getCollectionGroup_CollectionDate();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_GROUP__STATUS = eINSTANCE.getCollectionGroup_Status();

		/**
		 * The meta object literal for the '<em><b>Driver</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_GROUP__DRIVER = eINSTANCE.getCollectionGroup_Driver();

		/**
		 * The meta object literal for the '<em><b>Vehicle</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_GROUP__VEHICLE = eINSTANCE.getCollectionGroup_Vehicle();

		/**
		 * The meta object literal for the '<em><b>Driver Total</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_GROUP__DRIVER_TOTAL = eINSTANCE.getCollectionGroup_DriverTotal();

		/**
		 * The meta object literal for the '<em><b>Record Total</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_GROUP__RECORD_TOTAL = eINSTANCE.getCollectionGroup_RecordTotal();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_GROUP__ENTRIES = eINSTANCE.getCollectionGroup_Entries();

		/**
		 * The meta object literal for the '<em><b>Suspended</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_GROUP__SUSPENDED = eINSTANCE.getCollectionGroup_Suspended();

		/**
		 * The meta object literal for the '<em><b>Entry Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_GROUP__ENTRY_COUNT = eINSTANCE.getCollectionGroup_EntryCount();

		/**
		 * The meta object literal for the '<em><b>Suspended Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_GROUP__SUSPENDED_COUNT = eINSTANCE.getCollectionGroup_SuspendedCount();

		/**
		 * The meta object literal for the '<em><b>Rejected Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_GROUP__REJECTED_COUNT = eINSTANCE.getCollectionGroup_RejectedCount();

		/**
		 * The meta object literal for the '<em><b>Journal Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_GROUP__JOURNAL_NUMBER = eINSTANCE.getCollectionGroup_JournalNumber();

		/**
		 * The meta object literal for the '<em><b>Session</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_GROUP__SESSION = eINSTANCE.getCollectionGroup_Session();

		/**
		 * The meta object literal for the '<em><b>Collection Center</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_GROUP__COLLECTION_CENTER = eINSTANCE.getCollectionGroup_CollectionCenter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_GROUP__TYPE = eINSTANCE.getCollectionGroup_Type();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.TransportRouteImpl <em>Transport Route</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.TransportRouteImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getTransportRoute()
		 * @generated
		 */
		EClass TRANSPORT_ROUTE = eINSTANCE.getTransportRoute();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSPORT_ROUTE__ID = eINSTANCE.getTransportRoute_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSPORT_ROUTE__NAME = eINSTANCE.getTransportRoute_Name();

		/**
		 * The meta object literal for the '<em><b>Stops</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSPORT_ROUTE__STOPS = eINSTANCE.getTransportRoute_Stops();

		/**
		 * The meta object literal for the '<em><b>Bins</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSPORT_ROUTE__BINS = eINSTANCE.getTransportRoute_Bins();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSPORT_ROUTE__DESCRIPTION = eINSTANCE.getTransportRoute_Description();

		/**
		 * The meta object literal for the '<em><b>Vehicle</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSPORT_ROUTE__VEHICLE = eINSTANCE.getTransportRoute_Vehicle();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.TripImpl <em>Trip</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.TripImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getTrip()
		 * @generated
		 */
		EClass TRIP = eINSTANCE.getTrip();

		/**
		 * The meta object literal for the '<em><b>Collections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIP__COLLECTIONS = eINSTANCE.getTrip_Collections();

		/**
		 * The meta object literal for the '<em><b>Deliveries</b></em>' containment reference list feature.
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
		 * The meta object literal for the '<em><b>Trip Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRIP__TRIP_ID = eINSTANCE.getTrip_TripId();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleGroupImpl <em>Milk Sale Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleGroupImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMilkSaleGroup()
		 * @generated
		 */
		EClass MILK_SALE_GROUP = eINSTANCE.getMilkSaleGroup();

		/**
		 * The meta object literal for the '<em><b>Reference Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_SALE_GROUP__REFERENCE_NUMBER = eINSTANCE.getMilkSaleGroup_ReferenceNumber();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_SALE_GROUP__DATE = eINSTANCE.getMilkSaleGroup_Date();

		/**
		 * The meta object literal for the '<em><b>Route</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_SALE_GROUP__ROUTE = eINSTANCE.getMilkSaleGroup_Route();

		/**
		 * The meta object literal for the '<em><b>Customer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_SALE_GROUP__CUSTOMER = eINSTANCE.getMilkSaleGroup_Customer();

		/**
		 * The meta object literal for the '<em><b>Driver</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_SALE_GROUP__DRIVER = eINSTANCE.getMilkSaleGroup_Driver();

		/**
		 * The meta object literal for the '<em><b>Vehicle</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_SALE_GROUP__VEHICLE = eINSTANCE.getMilkSaleGroup_Vehicle();

		/**
		 * The meta object literal for the '<em><b>Sales</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_SALE_GROUP__SALES = eINSTANCE.getMilkSaleGroup_Sales();

		/**
		 * The meta object literal for the '<em><b>Total</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_SALE_GROUP__TOTAL = eINSTANCE.getMilkSaleGroup_Total();

		/**
		 * The meta object literal for the '<em><b>Session</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_SALE_GROUP__SESSION = eINSTANCE.getMilkSaleGroup_Session();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_SALE_GROUP__ID = eINSTANCE.getMilkSaleGroup_Id();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkGradeImpl <em>Milk Grade</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.MilkGradeImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMilkGrade()
		 * @generated
		 */
		EClass MILK_GRADE = eINSTANCE.getMilkGrade();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_GRADE__CODE = eINSTANCE.getMilkGrade_Code();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_GRADE__NAME = eINSTANCE.getMilkGrade_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_GRADE__DESCRIPTION = eINSTANCE.getMilkGrade_Description();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkGradeChangeImpl <em>Milk Grade Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.MilkGradeChangeImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMilkGradeChange()
		 * @generated
		 */
		EClass MILK_GRADE_CHANGE = eINSTANCE.getMilkGradeChange();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_GRADE_CHANGE__DATE = eINSTANCE.getMilkGradeChange_Date();

		/**
		 * The meta object literal for the '<em><b>Starting Grade</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_GRADE_CHANGE__STARTING_GRADE = eINSTANCE.getMilkGradeChange_StartingGrade();

		/**
		 * The meta object literal for the '<em><b>Ending Grade</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_GRADE_CHANGE__ENDING_GRADE = eINSTANCE.getMilkGradeChange_EndingGrade();

		/**
		 * The meta object literal for the '<em><b>Changed By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_GRADE_CHANGE__CHANGED_BY = eINSTANCE.getMilkGradeChange_ChangedBy();

		/**
		 * The meta object literal for the '<em><b>Reason</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_GRADE_CHANGE__REASON = eINSTANCE.getMilkGradeChange_Reason();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl <em>Milk Sale</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMilkSale()
		 * @generated
		 */
		EClass MILK_SALE = eINSTANCE.getMilkSale();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_SALE__ID = eINSTANCE.getMilkSale_Id();

		/**
		 * The meta object literal for the '<em><b>Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_SALE__LINE_NUMBER = eINSTANCE.getMilkSale_LineNumber();

		/**
		 * The meta object literal for the '<em><b>Reference Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_SALE__REFERENCE_NUMBER = eINSTANCE.getMilkSale_ReferenceNumber();

		/**
		 * The meta object literal for the '<em><b>Sale Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_SALE__SALE_DATE = eINSTANCE.getMilkSale_SaleDate();

		/**
		 * The meta object literal for the '<em><b>Session</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_SALE__SESSION = eINSTANCE.getMilkSale_Session();

		/**
		 * The meta object literal for the '<em><b>Bin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_SALE__BIN = eINSTANCE.getMilkSale_Bin();

		/**
		 * The meta object literal for the '<em><b>Sale Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_SALE__SALE_TYPE = eINSTANCE.getMilkSale_SaleType();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_SALE__QUANTITY = eINSTANCE.getMilkSale_Quantity();

		/**
		 * The meta object literal for the '<em><b>Grade</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_SALE__GRADE = eINSTANCE.getMilkSale_Grade();

		/**
		 * The meta object literal for the '<em><b>Unit Price</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_SALE__UNIT_PRICE = eINSTANCE.getMilkSale_UnitPrice();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_SALE__DESCRIPTION = eINSTANCE.getMilkSale_Description();

		/**
		 * The meta object literal for the '<em><b>Rejected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_SALE__REJECTED = eINSTANCE.getMilkSale_Rejected();

		/**
		 * The meta object literal for the '<em><b>Store Or Route</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_SALE__STORE_OR_ROUTE = eINSTANCE.getMilkSale_StoreOrRoute();

		/**
		 * The meta object literal for the '<em><b>Customer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_SALE__CUSTOMER = eINSTANCE.getMilkSale_Customer();

		/**
		 * The meta object literal for the '<em><b>Sold By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_SALE__SOLD_BY = eINSTANCE.getMilkSale_SoldBy();

		/**
		 * The meta object literal for the '<em><b>Sale Amount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_SALE__SALE_AMOUNT = eINSTANCE.getMilkSale_SaleAmount();

		/**
		 * The meta object literal for the '<em><b>Contract Sale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILK_SALE__CONTRACT_SALE = eINSTANCE.getMilkSale_ContractSale();

		/**
		 * The meta object literal for the '<em><b>Sales Clerk</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILK_SALE__SALES_CLERK = eINSTANCE.getMilkSale_SalesClerk();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl <em>Dairy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getDairy()
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
		 * The meta object literal for the '<em><b>Established Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY__ESTABLISHED_DATE = eINSTANCE.getDairy_EstablishedDate();

		/**
		 * The meta object literal for the '<em><b>Manager Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY__MANAGER_NAME = eINSTANCE.getDairy_ManagerName();

		/**
		 * The meta object literal for the '<em><b>Nssf Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY__NSSF_NUMBER = eINSTANCE.getDairy_NssfNumber();

		/**
		 * The meta object literal for the '<em><b>Nhif Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY__NHIF_NUMBER = eINSTANCE.getDairy_NhifNumber();

		/**
		 * The meta object literal for the '<em><b>Federal Pin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY__FEDERAL_PIN = eINSTANCE.getDairy_FederalPin();

		/**
		 * The meta object literal for the '<em><b>License Effective Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY__LICENSE_EFFECTIVE_DATE = eINSTANCE.getDairy_LicenseEffectiveDate();

		/**
		 * The meta object literal for the '<em><b>License Expiration Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY__LICENSE_EXPIRATION_DATE = eINSTANCE.getDairy_LicenseExpirationDate();

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
		 * The meta object literal for the '<em><b>Collection Journals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__COLLECTION_JOURNALS = eINSTANCE.getDairy_CollectionJournals();

		/**
		 * The meta object literal for the '<em><b>Delivery Journals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__DELIVERY_JOURNALS = eINSTANCE.getDairy_DeliveryJournals();

		/**
		 * The meta object literal for the '<em><b>Suppliers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__SUPPLIERS = eINSTANCE.getDairy_Suppliers();

		/**
		 * The meta object literal for the '<em><b>Customers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__CUSTOMERS = eINSTANCE.getDairy_Customers();

		/**
		 * The meta object literal for the '<em><b>Animal Health Requests</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__ANIMAL_HEALTH_REQUESTS = eINSTANCE.getDairy_AnimalHealthRequests();

		/**
		 * The meta object literal for the '<em><b>Dairy Bins</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__DAIRY_BINS = eINSTANCE.getDairy_DairyBins();

		/**
		 * The meta object literal for the '<em><b>Price History</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__PRICE_HISTORY = eINSTANCE.getDairy_PriceHistory();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY__VERSION = eINSTANCE.getDairy_Version();

		/**
		 * The meta object literal for the '<em><b>Collection Sessions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__COLLECTION_SESSIONS = eINSTANCE.getDairy_CollectionSessions();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MembershipImpl <em>Membership</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.MembershipImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMembership()
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
		 * The meta object literal for the '<em><b>Member Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBERSHIP__MEMBER_NUMBER = eINSTANCE.getMembership_MemberNumber();

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
		 * The meta object literal for the '<em><b>Farmer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBERSHIP__FARMER = eINSTANCE.getMembership_Farmer();

		/**
		 * The meta object literal for the '<em><b>Account</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBERSHIP__ACCOUNT = eINSTANCE.getMembership_Account();

		/**
		 * The meta object literal for the '<em><b>Dairy</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBERSHIP__DAIRY = eINSTANCE.getMembership_Dairy();

		/**
		 * The meta object literal for the '<em><b>Maziwa Card Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBERSHIP__MAZIWA_CARD_NUMBER = eINSTANCE.getMembership_MaziwaCardNumber();

		/**
		 * The meta object literal for the '<em><b>Maziwa Card Issue Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBERSHIP__MAZIWA_CARD_ISSUE_DATE = eINSTANCE.getMembership_MaziwaCardIssueDate();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.AssetImpl <em>Asset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.AssetImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getAsset()
		 * @generated
		 */
		EClass ASSET = eINSTANCE.getAsset();

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
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.BinImpl <em>Bin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.BinImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getBin()
		 * @generated
		 */
		EClass BIN = eINSTANCE.getBin();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIN__STATUS = eINSTANCE.getBin_Status();

		/**
		 * The meta object literal for the '<em><b>Zone</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIN__ZONE = eINSTANCE.getBin_Zone();

		/**
		 * The meta object literal for the '<em><b>Asset Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIN__ASSET_INFO = eINSTANCE.getBin_AssetInfo();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.SupplierImpl <em>Supplier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.SupplierImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getSupplier()
		 * @generated
		 */
		EClass SUPPLIER = eINSTANCE.getSupplier();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__CATEGORIES = eINSTANCE.getSupplier_Categories();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__ID = eINSTANCE.getSupplier_Id();

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
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CustomerImpl <em>Customer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.CustomerImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getCustomer()
		 * @generated
		 */
		EClass CUSTOMER = eINSTANCE.getCustomer();

		/**
		 * The meta object literal for the '<em><b>Customer Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__CUSTOMER_NUMBER = eINSTANCE.getCustomer_CustomerNumber();

		/**
		 * The meta object literal for the '<em><b>Customer Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__CUSTOMER_TYPE = eINSTANCE.getCustomer_CustomerType();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__STATUS = eINSTANCE.getCustomer_Status();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MemberPaymentImpl <em>Member Payment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.MemberPaymentImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMemberPayment()
		 * @generated
		 */
		EClass MEMBER_PAYMENT = eINSTANCE.getMemberPayment();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER_PAYMENT__ID = eINSTANCE.getMemberPayment_Id();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER_PAYMENT__YEAR = eINSTANCE.getMemberPayment_Year();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER_PAYMENT__MONTH = eINSTANCE.getMemberPayment_Month();

		/**
		 * The meta object literal for the '<em><b>Payment Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER_PAYMENT__PAYMENT_RATE = eINSTANCE.getMemberPayment_PaymentRate();

		/**
		 * The meta object literal for the '<em><b>Payments Total</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER_PAYMENT__PAYMENTS_TOTAL = eINSTANCE.getMemberPayment_PaymentsTotal();

		/**
		 * The meta object literal for the '<em><b>Payments Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER_PAYMENT__PAYMENTS_COUNT = eINSTANCE.getMemberPayment_PaymentsCount();

		/**
		 * The meta object literal for the '<em><b>Entered By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBER_PAYMENT__ENTERED_BY = eINSTANCE.getMemberPayment_EnteredBy();

		/**
		 * The meta object literal for the '<em><b>Entry Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER_PAYMENT__ENTRY_DATE = eINSTANCE.getMemberPayment_EntryDate();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.PreferenceImpl <em>Preference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.PreferenceImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getPreference()
		 * @generated
		 */
		EClass PREFERENCE = eINSTANCE.getPreference();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCE__ID = eINSTANCE.getPreference_Id();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREFERENCE__KEY = eINSTANCE.getPreference_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCE__VALUE = eINSTANCE.getPreference_Value();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.PreferenceKeyImpl <em>Preference Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.PreferenceKeyImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getPreferenceKey()
		 * @generated
		 */
		EClass PREFERENCE_KEY = eINSTANCE.getPreferenceKey();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCE_KEY__ID = eINSTANCE.getPreferenceKey_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCE_KEY__NAME = eINSTANCE.getPreferenceKey_Name();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCE_KEY__DEFAULT_VALUE = eINSTANCE.getPreferenceKey_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCE_KEY__TYPE = eINSTANCE.getPreferenceKey_Type();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionSessionImpl <em>Collection Session</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionSessionImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getCollectionSession()
		 * @generated
		 */
		EClass COLLECTION_SESSION = eINSTANCE.getCollectionSession();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_SESSION__ID = eINSTANCE.getCollectionSession_Id();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_SESSION__CODE = eINSTANCE.getCollectionSession_Code();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_SESSION__DESCRIPTION = eINSTANCE.getCollectionSession_Description();

		/**
		 * The meta object literal for the '<em><b>Time Of Day</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_SESSION__TIME_OF_DAY = eINSTANCE.getCollectionSession_TimeOfDay();

		/**
		 * The meta object literal for the '<em><b>Dairy</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_SESSION__DAIRY = eINSTANCE.getCollectionSession_Dairy();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.JournalStatus <em>Journal Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.JournalStatus
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getJournalStatus()
		 * @generated
		 */
		EEnum JOURNAL_STATUS = eINSTANCE.getJournalStatus();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleType <em>Milk Sale Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleType
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMilkSaleType()
		 * @generated
		 */
		EEnum MILK_SALE_TYPE = eINSTANCE.getMilkSaleType();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus <em>Membership Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getMembershipStatus()
		 * @generated
		 */
		EEnum MEMBERSHIP_STATUS = eINSTANCE.getMembershipStatus();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.VendorStatus <em>Vendor Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.VendorStatus
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getVendorStatus()
		 * @generated
		 */
		EEnum VENDOR_STATUS = eINSTANCE.getVendorStatus();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyFunction <em>Function</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyFunction
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getDairyFunction()
		 * @generated
		 */
		EEnum DAIRY_FUNCTION = eINSTANCE.getDairyFunction();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.PreferenceType <em>Preference Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.PreferenceType
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getPreferenceType()
		 * @generated
		 */
		EEnum PREFERENCE_TYPE = eINSTANCE.getPreferenceType();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroupType <em>Collection Group Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroupType
		 * @see com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl#getCollectionGroupType()
		 * @generated
		 */
		EEnum COLLECTION_GROUP_TYPE = eINSTANCE.getCollectionGroupType();

	}

} //DairyPackage
