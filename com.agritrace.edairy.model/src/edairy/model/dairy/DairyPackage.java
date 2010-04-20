/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model.dairy;

import edairy.model.ModelPackage;

import edairy.model.tracking.TrackingPackage;

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
 * @see edairy.model.dairy.DairyFactory
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
	DairyPackage eINSTANCE = edairy.model.dairy.impl.DairyPackageImpl.init();

	/**
	 * The meta object id for the '{@link edairy.model.dairy.impl.VehicleImpl <em>Vehicle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.dairy.impl.VehicleImpl
	 * @see edairy.model.dairy.impl.DairyPackageImpl#getVehicle()
	 * @generated
	 */
	int VEHICLE = 0;

	/**
	 * The feature id for the '<em><b>Service Records</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__SERVICE_RECORDS = 0;

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
	 * The feature id for the '<em><b>Insurance Purchase Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__INSURANCE_PURCHASE_DATE = 9;

	/**
	 * The feature id for the '<em><b>Purchase Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__PURCHASE_DATE = 10;

	/**
	 * The feature id for the '<em><b>Disposal Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__DISPOSAL_DATE = 11;

	/**
	 * The feature id for the '<em><b>Dominant Colour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__DOMINANT_COLOUR = 12;

	/**
	 * The feature id for the '<em><b>Capacity In Tonnes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__CAPACITY_IN_TONNES = 13;

	/**
	 * The number of structural features of the '<em>Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link edairy.model.dairy.impl.EmployeeImpl <em>Employee</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.dairy.impl.EmployeeImpl
	 * @see edairy.model.dairy.impl.DairyPackageImpl#getEmployee()
	 * @generated
	 */
	int EMPLOYEE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__NAME = ModelPackage.PERSON__NAME;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__PHONE_NUMBER = ModelPackage.PERSON__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__LOCATION = ModelPackage.PERSON__LOCATION;

	/**
	 * The feature id for the '<em><b>National Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__NATIONAL_ID = ModelPackage.PERSON__NATIONAL_ID;

	/**
	 * The feature id for the '<em><b>Nhif Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__NHIF_NUMBER = ModelPackage.PERSON__NHIF_NUMBER;

	/**
	 * The feature id for the '<em><b>Nssf Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE__NSSF_NUMBER = ModelPackage.PERSON__NSSF_NUMBER;

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
	 * The number of structural features of the '<em>Employee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPLOYEE_FEATURE_COUNT = ModelPackage.PERSON_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edairy.model.dairy.impl.DriverImpl <em>Driver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.dairy.impl.DriverImpl
	 * @see edairy.model.dairy.impl.DairyPackageImpl#getDriver()
	 * @generated
	 */
	int DRIVER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__NAME = EMPLOYEE__NAME;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__PHONE_NUMBER = EMPLOYEE__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__LOCATION = EMPLOYEE__LOCATION;

	/**
	 * The feature id for the '<em><b>National Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__NATIONAL_ID = EMPLOYEE__NATIONAL_ID;

	/**
	 * The feature id for the '<em><b>Nhif Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__NHIF_NUMBER = EMPLOYEE__NHIF_NUMBER;

	/**
	 * The feature id for the '<em><b>Nssf Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__NSSF_NUMBER = EMPLOYEE__NSSF_NUMBER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__ID = EMPLOYEE__ID;

	/**
	 * The feature id for the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__START_DATE = EMPLOYEE__START_DATE;

	/**
	 * The feature id for the '<em><b>Job Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__JOB_FUNCTION = EMPLOYEE__JOB_FUNCTION;

	/**
	 * The feature id for the '<em><b>Vehicle Assignment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__VEHICLE_ASSIGNMENT = EMPLOYEE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Driver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_FEATURE_COUNT = EMPLOYEE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edairy.model.dairy.impl.CollectionRecordImpl <em>Collection Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.dairy.impl.CollectionRecordImpl
	 * @see edairy.model.dairy.impl.DairyPackageImpl#getCollectionRecord()
	 * @generated
	 */
	int COLLECTION_RECORD = 2;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RECORD__DATE = TrackingPackage.COLLECTION__DATE;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RECORD__QUANTITY = TrackingPackage.COLLECTION__QUANTITY;

	/**
	 * The feature id for the '<em><b>Dairy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RECORD__DAIRY = TrackingPackage.COLLECTION__DAIRY;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RECORD__CONTAINER = TrackingPackage.COLLECTION__CONTAINER;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RECORD__FROM = TrackingPackage.COLLECTION__FROM;

	/**
	 * The feature id for the '<em><b>Contributed To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RECORD__CONTRIBUTED_TO = TrackingPackage.COLLECTION__CONTRIBUTED_TO;

	/**
	 * The feature id for the '<em><b>Suspended</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RECORD__SUSPENDED = TrackingPackage.COLLECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Not Recorded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RECORD__NOT_RECORDED = TrackingPackage.COLLECTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Recorded Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RECORD__RECORDED_MEMBER = TrackingPackage.COLLECTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Off Route</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RECORD__OFF_ROUTE = TrackingPackage.COLLECTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Collection Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RECORD_FEATURE_COUNT = TrackingPackage.COLLECTION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link edairy.model.dairy.impl.CollectionCentreImpl <em>Collection Centre</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.dairy.impl.CollectionCentreImpl
	 * @see edairy.model.dairy.impl.DairyPackageImpl#getCollectionCentre()
	 * @generated
	 */
	int COLLECTION_CENTRE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_CENTRE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Collection Centre</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_CENTRE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edairy.model.dairy.impl.ServiceRecordImpl <em>Service Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.dairy.impl.ServiceRecordImpl
	 * @see edairy.model.dairy.impl.DairyPackageImpl#getServiceRecord()
	 * @generated
	 */
	int SERVICE_RECORD = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_RECORD__ID = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_RECORD__DATE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_RECORD__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Service Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_RECORD_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link edairy.model.dairy.impl.WorkstationImpl <em>Workstation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.dairy.impl.WorkstationImpl
	 * @see edairy.model.dairy.impl.DairyPackageImpl#getWorkstation()
	 * @generated
	 */
	int WORKSTATION = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSTATION__ID = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSTATION__LOCATION = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSTATION__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Workstation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSTATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link edairy.model.dairy.impl.CollectionJournalImpl <em>Collection Journal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.dairy.impl.CollectionJournalImpl
	 * @see edairy.model.dairy.impl.DairyPackageImpl#getCollectionJournal()
	 * @generated
	 */
	int COLLECTION_JOURNAL = 7;

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
	 * The feature id for the '<em><b>Driver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__DRIVER = 3;

	/**
	 * The feature id for the '<em><b>Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__ROUTE = 4;

	/**
	 * The feature id for the '<em><b>Session</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__SESSION = 5;

	/**
	 * The feature id for the '<em><b>Can</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__CAN = 6;

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
	 * The feature id for the '<em><b>Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL__TOTAL = 10;

	/**
	 * The number of structural features of the '<em>Collection Journal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_JOURNAL_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link edairy.model.dairy.impl.RouteDefinitionImpl <em>Route Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.dairy.impl.RouteDefinitionImpl
	 * @see edairy.model.dairy.impl.DairyPackageImpl#getRouteDefinition()
	 * @generated
	 */
	int ROUTE_DEFINITION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_DEFINITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Stops</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_DEFINITION__STOPS = 1;

	/**
	 * The number of structural features of the '<em>Route Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_DEFINITION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edairy.model.dairy.impl.TripImpl <em>Trip</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.dairy.impl.TripImpl
	 * @see edairy.model.dairy.impl.DairyPackageImpl#getTrip()
	 * @generated
	 */
	int TRIP = 9;

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
	 * The meta object id for the '{@link edairy.model.dairy.impl.DeliveryJournalImpl <em>Delivery Journal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.dairy.impl.DeliveryJournalImpl
	 * @see edairy.model.dairy.impl.DairyPackageImpl#getDeliveryJournal()
	 * @generated
	 */
	int DELIVERY_JOURNAL = 10;

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
	 * The meta object id for the '{@link edairy.model.dairy.impl.SessionImpl <em>Session</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.dairy.impl.SessionImpl
	 * @see edairy.model.dairy.impl.DairyPackageImpl#getSession()
	 * @generated
	 */
	int SESSION = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION__SEQUENCE = 1;

	/**
	 * The number of structural features of the '<em>Session</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edairy.model.dairy.impl.DairyImpl <em>Dairy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.dairy.impl.DairyImpl
	 * @see edairy.model.dairy.impl.DairyPackageImpl#getDairy()
	 * @generated
	 */
	int DAIRY = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__NAME = TrackingPackage.DAIRY__NAME;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__PHONE_NUMBER = TrackingPackage.DAIRY__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__LOCATION = TrackingPackage.DAIRY__LOCATION;

	/**
	 * The feature id for the '<em><b>Contact Person</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__CONTACT_PERSON = TrackingPackage.DAIRY__CONTACT_PERSON;

	/**
	 * The feature id for the '<em><b>Registration Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__REGISTRATION_NUMBER = TrackingPackage.DAIRY__REGISTRATION_NUMBER;

	/**
	 * The feature id for the '<em><b>Nhif Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__NHIF_NUMBER = TrackingPackage.DAIRY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nssf Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__NSSF_NUMBER = TrackingPackage.DAIRY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Federal Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__FEDERAL_PIN = TrackingPackage.DAIRY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Workstations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__WORKSTATIONS = TrackingPackage.DAIRY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Routes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__ROUTES = TrackingPackage.DAIRY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Vehicles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__VEHICLES = TrackingPackage.DAIRY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Employees</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__EMPLOYEES = TrackingPackage.DAIRY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Sessions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__SESSIONS = TrackingPackage.DAIRY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Memberships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY__MEMBERSHIPS = TrackingPackage.DAIRY_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Dairy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_FEATURE_COUNT = TrackingPackage.DAIRY_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link edairy.model.dairy.impl.MembershipImpl <em>Membership</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.dairy.impl.MembershipImpl
	 * @see edairy.model.dairy.impl.DairyPackageImpl#getMembership()
	 * @generated
	 */
	int MEMBERSHIP = 13;

	/**
	 * The feature id for the '<em><b>Application Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__APPLICATION_DATE = 0;

	/**
	 * The feature id for the '<em><b>Effective Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__EFFECTIVE_DATE = 1;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__STATUS = 2;

	/**
	 * The feature id for the '<em><b>Default Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP__DEFAULT_ROUTE = 3;

	/**
	 * The number of structural features of the '<em>Membership</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBERSHIP_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link edairy.model.dairy.MembershipStatus <em>Membership Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.dairy.MembershipStatus
	 * @see edairy.model.dairy.impl.DairyPackageImpl#getMembershipStatus()
	 * @generated
	 */
	int MEMBERSHIP_STATUS = 14;


	/**
	 * Returns the meta object for class '{@link edairy.model.dairy.Vehicle <em>Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vehicle</em>'.
	 * @see edairy.model.dairy.Vehicle
	 * @generated
	 */
	EClass getVehicle();

	/**
	 * Returns the meta object for the containment reference list '{@link edairy.model.dairy.Vehicle#getServiceRecords <em>Service Records</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Records</em>'.
	 * @see edairy.model.dairy.Vehicle#getServiceRecords()
	 * @see #getVehicle()
	 * @generated
	 */
	EReference getVehicle_ServiceRecords();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Vehicle#getRegistrationNumber <em>Registration Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registration Number</em>'.
	 * @see edairy.model.dairy.Vehicle#getRegistrationNumber()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_RegistrationNumber();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Vehicle#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edairy.model.dairy.Vehicle#getType()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_Type();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Vehicle#getMake <em>Make</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Make</em>'.
	 * @see edairy.model.dairy.Vehicle#getMake()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_Make();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Vehicle#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model</em>'.
	 * @see edairy.model.dairy.Vehicle#getModel()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_Model();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Vehicle#getEngineNumber <em>Engine Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Engine Number</em>'.
	 * @see edairy.model.dairy.Vehicle#getEngineNumber()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_EngineNumber();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Vehicle#getChassisNumber <em>Chassis Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chassis Number</em>'.
	 * @see edairy.model.dairy.Vehicle#getChassisNumber()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_ChassisNumber();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Vehicle#getLogBookNumber <em>Log Book Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Book Number</em>'.
	 * @see edairy.model.dairy.Vehicle#getLogBookNumber()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_LogBookNumber();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Vehicle#getInsurancePolicyNumber <em>Insurance Policy Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Insurance Policy Number</em>'.
	 * @see edairy.model.dairy.Vehicle#getInsurancePolicyNumber()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_InsurancePolicyNumber();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Vehicle#getInsurancePurchaseDate <em>Insurance Purchase Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Insurance Purchase Date</em>'.
	 * @see edairy.model.dairy.Vehicle#getInsurancePurchaseDate()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_InsurancePurchaseDate();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Vehicle#getPurchaseDate <em>Purchase Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Purchase Date</em>'.
	 * @see edairy.model.dairy.Vehicle#getPurchaseDate()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_PurchaseDate();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Vehicle#getDisposalDate <em>Disposal Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disposal Date</em>'.
	 * @see edairy.model.dairy.Vehicle#getDisposalDate()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_DisposalDate();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Vehicle#getDominantColour <em>Dominant Colour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dominant Colour</em>'.
	 * @see edairy.model.dairy.Vehicle#getDominantColour()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_DominantColour();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Vehicle#getCapacityInTonnes <em>Capacity In Tonnes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity In Tonnes</em>'.
	 * @see edairy.model.dairy.Vehicle#getCapacityInTonnes()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_CapacityInTonnes();

	/**
	 * Returns the meta object for class '{@link edairy.model.dairy.Driver <em>Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Driver</em>'.
	 * @see edairy.model.dairy.Driver
	 * @generated
	 */
	EClass getDriver();

	/**
	 * Returns the meta object for the reference '{@link edairy.model.dairy.Driver#getVehicleAssignment <em>Vehicle Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vehicle Assignment</em>'.
	 * @see edairy.model.dairy.Driver#getVehicleAssignment()
	 * @see #getDriver()
	 * @generated
	 */
	EReference getDriver_VehicleAssignment();

	/**
	 * Returns the meta object for class '{@link edairy.model.dairy.CollectionRecord <em>Collection Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Record</em>'.
	 * @see edairy.model.dairy.CollectionRecord
	 * @generated
	 */
	EClass getCollectionRecord();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.CollectionRecord#isSuspended <em>Suspended</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suspended</em>'.
	 * @see edairy.model.dairy.CollectionRecord#isSuspended()
	 * @see #getCollectionRecord()
	 * @generated
	 */
	EAttribute getCollectionRecord_Suspended();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.CollectionRecord#isNotRecorded <em>Not Recorded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Not Recorded</em>'.
	 * @see edairy.model.dairy.CollectionRecord#isNotRecorded()
	 * @see #getCollectionRecord()
	 * @generated
	 */
	EAttribute getCollectionRecord_NotRecorded();

	/**
	 * Returns the meta object for the reference '{@link edairy.model.dairy.CollectionRecord#getRecordedMember <em>Recorded Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Recorded Member</em>'.
	 * @see edairy.model.dairy.CollectionRecord#getRecordedMember()
	 * @see #getCollectionRecord()
	 * @generated
	 */
	EReference getCollectionRecord_RecordedMember();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.CollectionRecord#isOffRoute <em>Off Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Off Route</em>'.
	 * @see edairy.model.dairy.CollectionRecord#isOffRoute()
	 * @see #getCollectionRecord()
	 * @generated
	 */
	EAttribute getCollectionRecord_OffRoute();

	/**
	 * Returns the meta object for class '{@link edairy.model.dairy.Employee <em>Employee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Employee</em>'.
	 * @see edairy.model.dairy.Employee
	 * @generated
	 */
	EClass getEmployee();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Employee#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edairy.model.dairy.Employee#getId()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_Id();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Employee#getStartDate <em>Start Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Date</em>'.
	 * @see edairy.model.dairy.Employee#getStartDate()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_StartDate();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Employee#getJobFunction <em>Job Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Job Function</em>'.
	 * @see edairy.model.dairy.Employee#getJobFunction()
	 * @see #getEmployee()
	 * @generated
	 */
	EAttribute getEmployee_JobFunction();

	/**
	 * Returns the meta object for class '{@link edairy.model.dairy.CollectionCentre <em>Collection Centre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Centre</em>'.
	 * @see edairy.model.dairy.CollectionCentre
	 * @generated
	 */
	EClass getCollectionCentre();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.CollectionCentre#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edairy.model.dairy.CollectionCentre#getName()
	 * @see #getCollectionCentre()
	 * @generated
	 */
	EAttribute getCollectionCentre_Name();

	/**
	 * Returns the meta object for class '{@link edairy.model.dairy.ServiceRecord <em>Service Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Record</em>'.
	 * @see edairy.model.dairy.ServiceRecord
	 * @generated
	 */
	EClass getServiceRecord();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.ServiceRecord#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edairy.model.dairy.ServiceRecord#getId()
	 * @see #getServiceRecord()
	 * @generated
	 */
	EAttribute getServiceRecord_Id();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.ServiceRecord#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see edairy.model.dairy.ServiceRecord#getDate()
	 * @see #getServiceRecord()
	 * @generated
	 */
	EAttribute getServiceRecord_Date();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.ServiceRecord#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edairy.model.dairy.ServiceRecord#getDescription()
	 * @see #getServiceRecord()
	 * @generated
	 */
	EAttribute getServiceRecord_Description();

	/**
	 * Returns the meta object for class '{@link edairy.model.dairy.Workstation <em>Workstation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workstation</em>'.
	 * @see edairy.model.dairy.Workstation
	 * @generated
	 */
	EClass getWorkstation();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Workstation#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edairy.model.dairy.Workstation#getId()
	 * @see #getWorkstation()
	 * @generated
	 */
	EAttribute getWorkstation_Id();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Workstation#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see edairy.model.dairy.Workstation#getLocation()
	 * @see #getWorkstation()
	 * @generated
	 */
	EAttribute getWorkstation_Location();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Workstation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edairy.model.dairy.Workstation#getType()
	 * @see #getWorkstation()
	 * @generated
	 */
	EAttribute getWorkstation_Type();

	/**
	 * Returns the meta object for class '{@link edairy.model.dairy.CollectionJournal <em>Collection Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Journal</em>'.
	 * @see edairy.model.dairy.CollectionJournal
	 * @generated
	 */
	EClass getCollectionJournal();

	/**
	 * Returns the meta object for the containment reference list '{@link edairy.model.dairy.CollectionJournal#getJournalEntries <em>Journal Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Journal Entries</em>'.
	 * @see edairy.model.dairy.CollectionJournal#getJournalEntries()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EReference getCollectionJournal_JournalEntries();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.CollectionJournal#getReferenceNumber <em>Reference Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference Number</em>'.
	 * @see edairy.model.dairy.CollectionJournal#getReferenceNumber()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EAttribute getCollectionJournal_ReferenceNumber();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.CollectionJournal#getJournalDate <em>Journal Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Journal Date</em>'.
	 * @see edairy.model.dairy.CollectionJournal#getJournalDate()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EAttribute getCollectionJournal_JournalDate();

	/**
	 * Returns the meta object for the reference '{@link edairy.model.dairy.CollectionJournal#getDriver <em>Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Driver</em>'.
	 * @see edairy.model.dairy.CollectionJournal#getDriver()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EReference getCollectionJournal_Driver();

	/**
	 * Returns the meta object for the reference '{@link edairy.model.dairy.CollectionJournal#getRoute <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Route</em>'.
	 * @see edairy.model.dairy.CollectionJournal#getRoute()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EReference getCollectionJournal_Route();

	/**
	 * Returns the meta object for the reference '{@link edairy.model.dairy.CollectionJournal#getSession <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Session</em>'.
	 * @see edairy.model.dairy.CollectionJournal#getSession()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EReference getCollectionJournal_Session();

	/**
	 * Returns the meta object for the reference '{@link edairy.model.dairy.CollectionJournal#getCan <em>Can</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Can</em>'.
	 * @see edairy.model.dairy.CollectionJournal#getCan()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EReference getCollectionJournal_Can();

	/**
	 * Returns the meta object for the reference '{@link edairy.model.dairy.CollectionJournal#getBin <em>Bin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bin</em>'.
	 * @see edairy.model.dairy.CollectionJournal#getBin()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EReference getCollectionJournal_Bin();

	/**
	 * Returns the meta object for the reference '{@link edairy.model.dairy.CollectionJournal#getVehicle <em>Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vehicle</em>'.
	 * @see edairy.model.dairy.CollectionJournal#getVehicle()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EReference getCollectionJournal_Vehicle();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.CollectionJournal#getDriverTotal <em>Driver Total</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Driver Total</em>'.
	 * @see edairy.model.dairy.CollectionJournal#getDriverTotal()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EAttribute getCollectionJournal_DriverTotal();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.CollectionJournal#getTotal <em>Total</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total</em>'.
	 * @see edairy.model.dairy.CollectionJournal#getTotal()
	 * @see #getCollectionJournal()
	 * @generated
	 */
	EAttribute getCollectionJournal_Total();

	/**
	 * Returns the meta object for class '{@link edairy.model.dairy.RouteDefinition <em>Route Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Route Definition</em>'.
	 * @see edairy.model.dairy.RouteDefinition
	 * @generated
	 */
	EClass getRouteDefinition();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.RouteDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edairy.model.dairy.RouteDefinition#getName()
	 * @see #getRouteDefinition()
	 * @generated
	 */
	EAttribute getRouteDefinition_Name();

	/**
	 * Returns the meta object for the reference list '{@link edairy.model.dairy.RouteDefinition#getStops <em>Stops</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stops</em>'.
	 * @see edairy.model.dairy.RouteDefinition#getStops()
	 * @see #getRouteDefinition()
	 * @generated
	 */
	EReference getRouteDefinition_Stops();

	/**
	 * Returns the meta object for class '{@link edairy.model.dairy.Trip <em>Trip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trip</em>'.
	 * @see edairy.model.dairy.Trip
	 * @generated
	 */
	EClass getTrip();

	/**
	 * Returns the meta object for the reference list '{@link edairy.model.dairy.Trip#getCollections <em>Collections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Collections</em>'.
	 * @see edairy.model.dairy.Trip#getCollections()
	 * @see #getTrip()
	 * @generated
	 */
	EReference getTrip_Collections();

	/**
	 * Returns the meta object for the reference list '{@link edairy.model.dairy.Trip#getDeliveries <em>Deliveries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Deliveries</em>'.
	 * @see edairy.model.dairy.Trip#getDeliveries()
	 * @see #getTrip()
	 * @generated
	 */
	EReference getTrip_Deliveries();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Trip#getStarted <em>Started</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Started</em>'.
	 * @see edairy.model.dairy.Trip#getStarted()
	 * @see #getTrip()
	 * @generated
	 */
	EAttribute getTrip_Started();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Trip#getEnded <em>Ended</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ended</em>'.
	 * @see edairy.model.dairy.Trip#getEnded()
	 * @see #getTrip()
	 * @generated
	 */
	EAttribute getTrip_Ended();

	/**
	 * Returns the meta object for class '{@link edairy.model.dairy.DeliveryJournal <em>Delivery Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delivery Journal</em>'.
	 * @see edairy.model.dairy.DeliveryJournal
	 * @generated
	 */
	EClass getDeliveryJournal();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.DeliveryJournal#getReferenceNumber <em>Reference Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference Number</em>'.
	 * @see edairy.model.dairy.DeliveryJournal#getReferenceNumber()
	 * @see #getDeliveryJournal()
	 * @generated
	 */
	EAttribute getDeliveryJournal_ReferenceNumber();

	/**
	 * Returns the meta object for class '{@link edairy.model.dairy.Session <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Session</em>'.
	 * @see edairy.model.dairy.Session
	 * @generated
	 */
	EClass getSession();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Session#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edairy.model.dairy.Session#getName()
	 * @see #getSession()
	 * @generated
	 */
	EAttribute getSession_Name();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Session#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequence</em>'.
	 * @see edairy.model.dairy.Session#getSequence()
	 * @see #getSession()
	 * @generated
	 */
	EAttribute getSession_Sequence();

	/**
	 * Returns the meta object for class '{@link edairy.model.dairy.Dairy <em>Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dairy</em>'.
	 * @see edairy.model.dairy.Dairy
	 * @generated
	 */
	EClass getDairy();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Dairy#getNhifNumber <em>Nhif Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nhif Number</em>'.
	 * @see edairy.model.dairy.Dairy#getNhifNumber()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_NhifNumber();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Dairy#getNssfNumber <em>Nssf Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nssf Number</em>'.
	 * @see edairy.model.dairy.Dairy#getNssfNumber()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_NssfNumber();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Dairy#getFederalPin <em>Federal Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Federal Pin</em>'.
	 * @see edairy.model.dairy.Dairy#getFederalPin()
	 * @see #getDairy()
	 * @generated
	 */
	EAttribute getDairy_FederalPin();

	/**
	 * Returns the meta object for the reference list '{@link edairy.model.dairy.Dairy#getWorkstations <em>Workstations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Workstations</em>'.
	 * @see edairy.model.dairy.Dairy#getWorkstations()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Workstations();

	/**
	 * Returns the meta object for the containment reference list '{@link edairy.model.dairy.Dairy#getRoutes <em>Routes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Routes</em>'.
	 * @see edairy.model.dairy.Dairy#getRoutes()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Routes();

	/**
	 * Returns the meta object for the containment reference list '{@link edairy.model.dairy.Dairy#getVehicles <em>Vehicles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vehicles</em>'.
	 * @see edairy.model.dairy.Dairy#getVehicles()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Vehicles();

	/**
	 * Returns the meta object for the containment reference list '{@link edairy.model.dairy.Dairy#getEmployees <em>Employees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Employees</em>'.
	 * @see edairy.model.dairy.Dairy#getEmployees()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Employees();

	/**
	 * Returns the meta object for the containment reference list '{@link edairy.model.dairy.Dairy#getSessions <em>Sessions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sessions</em>'.
	 * @see edairy.model.dairy.Dairy#getSessions()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Sessions();

	/**
	 * Returns the meta object for the containment reference list '{@link edairy.model.dairy.Dairy#getMemberships <em>Memberships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Memberships</em>'.
	 * @see edairy.model.dairy.Dairy#getMemberships()
	 * @see #getDairy()
	 * @generated
	 */
	EReference getDairy_Memberships();

	/**
	 * Returns the meta object for class '{@link edairy.model.dairy.Membership <em>Membership</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Membership</em>'.
	 * @see edairy.model.dairy.Membership
	 * @generated
	 */
	EClass getMembership();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Membership#getApplicationDate <em>Application Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Application Date</em>'.
	 * @see edairy.model.dairy.Membership#getApplicationDate()
	 * @see #getMembership()
	 * @generated
	 */
	EAttribute getMembership_ApplicationDate();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Membership#getEffectiveDate <em>Effective Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effective Date</em>'.
	 * @see edairy.model.dairy.Membership#getEffectiveDate()
	 * @see #getMembership()
	 * @generated
	 */
	EAttribute getMembership_EffectiveDate();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.dairy.Membership#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see edairy.model.dairy.Membership#getStatus()
	 * @see #getMembership()
	 * @generated
	 */
	EAttribute getMembership_Status();

	/**
	 * Returns the meta object for the reference '{@link edairy.model.dairy.Membership#getDefaultRoute <em>Default Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Route</em>'.
	 * @see edairy.model.dairy.Membership#getDefaultRoute()
	 * @see #getMembership()
	 * @generated
	 */
	EReference getMembership_DefaultRoute();

	/**
	 * Returns the meta object for enum '{@link edairy.model.dairy.MembershipStatus <em>Membership Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Membership Status</em>'.
	 * @see edairy.model.dairy.MembershipStatus
	 * @generated
	 */
	EEnum getMembershipStatus();

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
		 * The meta object literal for the '{@link edairy.model.dairy.impl.VehicleImpl <em>Vehicle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.dairy.impl.VehicleImpl
		 * @see edairy.model.dairy.impl.DairyPackageImpl#getVehicle()
		 * @generated
		 */
		EClass VEHICLE = eINSTANCE.getVehicle();

		/**
		 * The meta object literal for the '<em><b>Service Records</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VEHICLE__SERVICE_RECORDS = eINSTANCE.getVehicle_ServiceRecords();

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
		 * The meta object literal for the '<em><b>Purchase Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__PURCHASE_DATE = eINSTANCE.getVehicle_PurchaseDate();

		/**
		 * The meta object literal for the '<em><b>Disposal Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__DISPOSAL_DATE = eINSTANCE.getVehicle_DisposalDate();

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
		 * The meta object literal for the '{@link edairy.model.dairy.impl.DriverImpl <em>Driver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.dairy.impl.DriverImpl
		 * @see edairy.model.dairy.impl.DairyPackageImpl#getDriver()
		 * @generated
		 */
		EClass DRIVER = eINSTANCE.getDriver();

		/**
		 * The meta object literal for the '<em><b>Vehicle Assignment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRIVER__VEHICLE_ASSIGNMENT = eINSTANCE.getDriver_VehicleAssignment();

		/**
		 * The meta object literal for the '{@link edairy.model.dairy.impl.CollectionRecordImpl <em>Collection Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.dairy.impl.CollectionRecordImpl
		 * @see edairy.model.dairy.impl.DairyPackageImpl#getCollectionRecord()
		 * @generated
		 */
		EClass COLLECTION_RECORD = eINSTANCE.getCollectionRecord();

		/**
		 * The meta object literal for the '<em><b>Suspended</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_RECORD__SUSPENDED = eINSTANCE.getCollectionRecord_Suspended();

		/**
		 * The meta object literal for the '<em><b>Not Recorded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_RECORD__NOT_RECORDED = eINSTANCE.getCollectionRecord_NotRecorded();

		/**
		 * The meta object literal for the '<em><b>Recorded Member</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_RECORD__RECORDED_MEMBER = eINSTANCE.getCollectionRecord_RecordedMember();

		/**
		 * The meta object literal for the '<em><b>Off Route</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_RECORD__OFF_ROUTE = eINSTANCE.getCollectionRecord_OffRoute();

		/**
		 * The meta object literal for the '{@link edairy.model.dairy.impl.EmployeeImpl <em>Employee</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.dairy.impl.EmployeeImpl
		 * @see edairy.model.dairy.impl.DairyPackageImpl#getEmployee()
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
		 * The meta object literal for the '{@link edairy.model.dairy.impl.CollectionCentreImpl <em>Collection Centre</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.dairy.impl.CollectionCentreImpl
		 * @see edairy.model.dairy.impl.DairyPackageImpl#getCollectionCentre()
		 * @generated
		 */
		EClass COLLECTION_CENTRE = eINSTANCE.getCollectionCentre();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_CENTRE__NAME = eINSTANCE.getCollectionCentre_Name();

		/**
		 * The meta object literal for the '{@link edairy.model.dairy.impl.ServiceRecordImpl <em>Service Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.dairy.impl.ServiceRecordImpl
		 * @see edairy.model.dairy.impl.DairyPackageImpl#getServiceRecord()
		 * @generated
		 */
		EClass SERVICE_RECORD = eINSTANCE.getServiceRecord();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_RECORD__ID = eINSTANCE.getServiceRecord_Id();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_RECORD__DATE = eINSTANCE.getServiceRecord_Date();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_RECORD__DESCRIPTION = eINSTANCE.getServiceRecord_Description();

		/**
		 * The meta object literal for the '{@link edairy.model.dairy.impl.WorkstationImpl <em>Workstation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.dairy.impl.WorkstationImpl
		 * @see edairy.model.dairy.impl.DairyPackageImpl#getWorkstation()
		 * @generated
		 */
		EClass WORKSTATION = eINSTANCE.getWorkstation();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKSTATION__ID = eINSTANCE.getWorkstation_Id();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKSTATION__LOCATION = eINSTANCE.getWorkstation_Location();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKSTATION__TYPE = eINSTANCE.getWorkstation_Type();

		/**
		 * The meta object literal for the '{@link edairy.model.dairy.impl.CollectionJournalImpl <em>Collection Journal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.dairy.impl.CollectionJournalImpl
		 * @see edairy.model.dairy.impl.DairyPackageImpl#getCollectionJournal()
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
		 * The meta object literal for the '<em><b>Session</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_JOURNAL__SESSION = eINSTANCE.getCollectionJournal_Session();

		/**
		 * The meta object literal for the '<em><b>Can</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_JOURNAL__CAN = eINSTANCE.getCollectionJournal_Can();

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
		 * The meta object literal for the '<em><b>Total</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_JOURNAL__TOTAL = eINSTANCE.getCollectionJournal_Total();

		/**
		 * The meta object literal for the '{@link edairy.model.dairy.impl.RouteDefinitionImpl <em>Route Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.dairy.impl.RouteDefinitionImpl
		 * @see edairy.model.dairy.impl.DairyPackageImpl#getRouteDefinition()
		 * @generated
		 */
		EClass ROUTE_DEFINITION = eINSTANCE.getRouteDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTE_DEFINITION__NAME = eINSTANCE.getRouteDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Stops</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTE_DEFINITION__STOPS = eINSTANCE.getRouteDefinition_Stops();

		/**
		 * The meta object literal for the '{@link edairy.model.dairy.impl.TripImpl <em>Trip</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.dairy.impl.TripImpl
		 * @see edairy.model.dairy.impl.DairyPackageImpl#getTrip()
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
		 * The meta object literal for the '{@link edairy.model.dairy.impl.DeliveryJournalImpl <em>Delivery Journal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.dairy.impl.DeliveryJournalImpl
		 * @see edairy.model.dairy.impl.DairyPackageImpl#getDeliveryJournal()
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
		 * The meta object literal for the '{@link edairy.model.dairy.impl.SessionImpl <em>Session</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.dairy.impl.SessionImpl
		 * @see edairy.model.dairy.impl.DairyPackageImpl#getSession()
		 * @generated
		 */
		EClass SESSION = eINSTANCE.getSession();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SESSION__NAME = eINSTANCE.getSession_Name();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SESSION__SEQUENCE = eINSTANCE.getSession_Sequence();

		/**
		 * The meta object literal for the '{@link edairy.model.dairy.impl.DairyImpl <em>Dairy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.dairy.impl.DairyImpl
		 * @see edairy.model.dairy.impl.DairyPackageImpl#getDairy()
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
		 * The meta object literal for the '<em><b>Workstations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__WORKSTATIONS = eINSTANCE.getDairy_Workstations();

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
		 * The meta object literal for the '<em><b>Sessions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__SESSIONS = eINSTANCE.getDairy_Sessions();

		/**
		 * The meta object literal for the '<em><b>Memberships</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DAIRY__MEMBERSHIPS = eINSTANCE.getDairy_Memberships();

		/**
		 * The meta object literal for the '{@link edairy.model.dairy.impl.MembershipImpl <em>Membership</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.dairy.impl.MembershipImpl
		 * @see edairy.model.dairy.impl.DairyPackageImpl#getMembership()
		 * @generated
		 */
		EClass MEMBERSHIP = eINSTANCE.getMembership();

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
		 * The meta object literal for the '{@link edairy.model.dairy.MembershipStatus <em>Membership Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.dairy.MembershipStatus
		 * @see edairy.model.dairy.impl.DairyPackageImpl#getMembershipStatus()
		 * @generated
		 */
		EEnum MEMBERSHIP_STATUS = eINSTANCE.getMembershipStatus();

	}

} //DairyPackage
