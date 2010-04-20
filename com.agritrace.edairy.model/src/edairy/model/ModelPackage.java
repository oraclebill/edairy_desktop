/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see edairy.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://com.agritrace.edairy.model/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = edairy.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link edairy.model.impl.PartyImpl <em>Party</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.impl.PartyImpl
	 * @see edairy.model.impl.ModelPackageImpl#getParty()
	 * @generated
	 */
	int PARTY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTY__PHONE_NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTY__LOCATION = 2;

	/**
	 * The number of structural features of the '<em>Party</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link edairy.model.impl.LocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.impl.LocationImpl
	 * @see edairy.model.impl.ModelPackageImpl#getLocation()
	 * @generated
	 */
	int LOCATION = 1;

	/**
	 * The feature id for the '<em><b>Postal Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__POSTAL_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edairy.model.impl.MapLocationImpl <em>Map Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.impl.MapLocationImpl
	 * @see edairy.model.impl.ModelPackageImpl#getMapLocation()
	 * @generated
	 */
	int MAP_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Postal Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LOCATION__POSTAL_COMPONENT = LOCATION__POSTAL_COMPONENT;

	/**
	 * The feature id for the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LOCATION__LONGITUDE = LOCATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LOCATION__LATITUDE = LOCATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Map Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LOCATION_FEATURE_COUNT = LOCATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edairy.model.impl.PostalLocationImpl <em>Postal Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.impl.PostalLocationImpl
	 * @see edairy.model.impl.ModelPackageImpl#getPostalLocation()
	 * @generated
	 */
	int POSTAL_LOCATION = 3;

	/**
	 * The feature id for the '<em><b>Postal Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__POSTAL_COMPONENT = LOCATION__POSTAL_COMPONENT;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__ADDRESS = LOCATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Province</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__PROVINCE = LOCATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Division</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__DIVISION = LOCATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>District</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__DISTRICT = LOCATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__LOCATION = LOCATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Sub Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__SUB_LOCATION = LOCATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Village</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__VILLAGE = LOCATION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__POSTAL_CODE = LOCATION_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Postal Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION_FEATURE_COUNT = LOCATION_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link edairy.model.impl.StatutoryLocationImpl <em>Statutory Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.impl.StatutoryLocationImpl
	 * @see edairy.model.impl.ModelPackageImpl#getStatutoryLocation()
	 * @generated
	 */
	int STATUTORY_LOCATION = 4;

	/**
	 * The feature id for the '<em><b>Postal Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUTORY_LOCATION__POSTAL_COMPONENT = LOCATION__POSTAL_COMPONENT;

	/**
	 * The feature id for the '<em><b>Land Reference Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUTORY_LOCATION__LAND_REFERENCE_NUMBER = LOCATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Statutory Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUTORY_LOCATION_FEATURE_COUNT = LOCATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edairy.model.impl.AuditedImpl <em>Audited</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.impl.AuditedImpl
	 * @see edairy.model.impl.ModelPackageImpl#getAudited()
	 * @generated
	 */
	int AUDITED = 5;

	/**
	 * The feature id for the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDITED__LAST_UPDATED = 0;

	/**
	 * The feature id for the '<em><b>Void Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDITED__VOID_DATE = 1;

	/**
	 * The number of structural features of the '<em>Audited</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDITED_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edairy.model.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.impl.PersonImpl
	 * @see edairy.model.impl.ModelPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = PARTY__NAME;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__PHONE_NUMBER = PARTY__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__LOCATION = PARTY__LOCATION;

	/**
	 * The feature id for the '<em><b>National Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NATIONAL_ID = PARTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nhif Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NHIF_NUMBER = PARTY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Nssf Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NSSF_NUMBER = PARTY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = PARTY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edairy.model.impl.CompanyImpl <em>Company</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.impl.CompanyImpl
	 * @see edairy.model.impl.ModelPackageImpl#getCompany()
	 * @generated
	 */
	int COMPANY = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__NAME = PARTY__NAME;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__PHONE_NUMBER = PARTY__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__LOCATION = PARTY__LOCATION;

	/**
	 * The feature id for the '<em><b>Contact Person</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__CONTACT_PERSON = PARTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Company</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY_FEATURE_COUNT = PARTY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edairy.model.impl.DescriptiveLocationImpl <em>Descriptive Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edairy.model.impl.DescriptiveLocationImpl
	 * @see edairy.model.impl.ModelPackageImpl#getDescriptiveLocation()
	 * @generated
	 */
	int DESCRIPTIVE_LOCATION = 8;

	/**
	 * The feature id for the '<em><b>Postal Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTIVE_LOCATION__POSTAL_COMPONENT = LOCATION__POSTAL_COMPONENT;

	/**
	 * The feature id for the '<em><b>Directions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTIVE_LOCATION__DIRECTIONS = LOCATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Descriptive Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTIVE_LOCATION_FEATURE_COUNT = LOCATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>Transaction ID</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see edairy.model.impl.ModelPackageImpl#getTransactionID()
	 * @generated
	 */
	int TRANSACTION_ID = 9;

	/**
	 * The meta object id for the '<em>Unique ID</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see edairy.model.impl.ModelPackageImpl#getUniqueID()
	 * @generated
	 */
	int UNIQUE_ID = 10;


	/**
	 * Returns the meta object for class '{@link edairy.model.Party <em>Party</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Party</em>'.
	 * @see edairy.model.Party
	 * @generated
	 */
	EClass getParty();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.Party#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edairy.model.Party#getName()
	 * @see #getParty()
	 * @generated
	 */
	EAttribute getParty_Name();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.Party#getPhoneNumber <em>Phone Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phone Number</em>'.
	 * @see edairy.model.Party#getPhoneNumber()
	 * @see #getParty()
	 * @generated
	 */
	EAttribute getParty_PhoneNumber();

	/**
	 * Returns the meta object for the containment reference list '{@link edairy.model.Party#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Location</em>'.
	 * @see edairy.model.Party#getLocation()
	 * @see #getParty()
	 * @generated
	 */
	EReference getParty_Location();

	/**
	 * Returns the meta object for class '{@link edairy.model.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see edairy.model.Location
	 * @generated
	 */
	EClass getLocation();

	/**
	 * Returns the meta object for the containment reference '{@link edairy.model.Location#getPostalComponent <em>Postal Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Component</em>'.
	 * @see edairy.model.Location#getPostalComponent()
	 * @see #getLocation()
	 * @generated
	 */
	EReference getLocation_PostalComponent();

	/**
	 * Returns the meta object for class '{@link edairy.model.MapLocation <em>Map Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Location</em>'.
	 * @see edairy.model.MapLocation
	 * @generated
	 */
	EClass getMapLocation();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.MapLocation#getLongitude <em>Longitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Longitude</em>'.
	 * @see edairy.model.MapLocation#getLongitude()
	 * @see #getMapLocation()
	 * @generated
	 */
	EAttribute getMapLocation_Longitude();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.MapLocation#getLatitude <em>Latitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Latitude</em>'.
	 * @see edairy.model.MapLocation#getLatitude()
	 * @see #getMapLocation()
	 * @generated
	 */
	EAttribute getMapLocation_Latitude();

	/**
	 * Returns the meta object for class '{@link edairy.model.PostalLocation <em>Postal Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Postal Location</em>'.
	 * @see edairy.model.PostalLocation
	 * @generated
	 */
	EClass getPostalLocation();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.PostalLocation#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see edairy.model.PostalLocation#getAddress()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_Address();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.PostalLocation#getProvince <em>Province</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Province</em>'.
	 * @see edairy.model.PostalLocation#getProvince()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_Province();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.PostalLocation#getDivision <em>Division</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Division</em>'.
	 * @see edairy.model.PostalLocation#getDivision()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_Division();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.PostalLocation#getDistrict <em>District</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>District</em>'.
	 * @see edairy.model.PostalLocation#getDistrict()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_District();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.PostalLocation#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see edairy.model.PostalLocation#getLocation()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_Location();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.PostalLocation#getSubLocation <em>Sub Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Location</em>'.
	 * @see edairy.model.PostalLocation#getSubLocation()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_SubLocation();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.PostalLocation#getVillage <em>Village</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Village</em>'.
	 * @see edairy.model.PostalLocation#getVillage()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_Village();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.PostalLocation#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Postal Code</em>'.
	 * @see edairy.model.PostalLocation#getPostalCode()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_PostalCode();

	/**
	 * Returns the meta object for class '{@link edairy.model.StatutoryLocation <em>Statutory Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statutory Location</em>'.
	 * @see edairy.model.StatutoryLocation
	 * @generated
	 */
	EClass getStatutoryLocation();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.StatutoryLocation#getLandReferenceNumber <em>Land Reference Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Land Reference Number</em>'.
	 * @see edairy.model.StatutoryLocation#getLandReferenceNumber()
	 * @see #getStatutoryLocation()
	 * @generated
	 */
	EAttribute getStatutoryLocation_LandReferenceNumber();

	/**
	 * Returns the meta object for class '{@link edairy.model.Audited <em>Audited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Audited</em>'.
	 * @see edairy.model.Audited
	 * @generated
	 */
	EClass getAudited();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.Audited#getLastUpdated <em>Last Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Updated</em>'.
	 * @see edairy.model.Audited#getLastUpdated()
	 * @see #getAudited()
	 * @generated
	 */
	EAttribute getAudited_LastUpdated();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.Audited#getVoidDate <em>Void Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Void Date</em>'.
	 * @see edairy.model.Audited#getVoidDate()
	 * @see #getAudited()
	 * @generated
	 */
	EAttribute getAudited_VoidDate();

	/**
	 * Returns the meta object for class '{@link edairy.model.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see edairy.model.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.Person#getNationalId <em>National Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>National Id</em>'.
	 * @see edairy.model.Person#getNationalId()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_NationalId();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.Person#getNhifNumber <em>Nhif Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nhif Number</em>'.
	 * @see edairy.model.Person#getNhifNumber()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_NhifNumber();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.Person#getNssfNumber <em>Nssf Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nssf Number</em>'.
	 * @see edairy.model.Person#getNssfNumber()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_NssfNumber();

	/**
	 * Returns the meta object for class '{@link edairy.model.Company <em>Company</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Company</em>'.
	 * @see edairy.model.Company
	 * @generated
	 */
	EClass getCompany();

	/**
	 * Returns the meta object for the containment reference list '{@link edairy.model.Company#getContactPerson <em>Contact Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contact Person</em>'.
	 * @see edairy.model.Company#getContactPerson()
	 * @see #getCompany()
	 * @generated
	 */
	EReference getCompany_ContactPerson();

	/**
	 * Returns the meta object for class '{@link edairy.model.DescriptiveLocation <em>Descriptive Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptive Location</em>'.
	 * @see edairy.model.DescriptiveLocation
	 * @generated
	 */
	EClass getDescriptiveLocation();

	/**
	 * Returns the meta object for the attribute '{@link edairy.model.DescriptiveLocation#getDirections <em>Directions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Directions</em>'.
	 * @see edairy.model.DescriptiveLocation#getDirections()
	 * @see #getDescriptiveLocation()
	 * @generated
	 */
	EAttribute getDescriptiveLocation_Directions();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Transaction ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Transaction ID</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getTransactionID();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Unique ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Unique ID</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getUniqueID();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link edairy.model.impl.PartyImpl <em>Party</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.impl.PartyImpl
		 * @see edairy.model.impl.ModelPackageImpl#getParty()
		 * @generated
		 */
		EClass PARTY = eINSTANCE.getParty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTY__NAME = eINSTANCE.getParty_Name();

		/**
		 * The meta object literal for the '<em><b>Phone Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTY__PHONE_NUMBER = eINSTANCE.getParty_PhoneNumber();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTY__LOCATION = eINSTANCE.getParty_Location();

		/**
		 * The meta object literal for the '{@link edairy.model.impl.LocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.impl.LocationImpl
		 * @see edairy.model.impl.ModelPackageImpl#getLocation()
		 * @generated
		 */
		EClass LOCATION = eINSTANCE.getLocation();

		/**
		 * The meta object literal for the '<em><b>Postal Component</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION__POSTAL_COMPONENT = eINSTANCE.getLocation_PostalComponent();

		/**
		 * The meta object literal for the '{@link edairy.model.impl.MapLocationImpl <em>Map Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.impl.MapLocationImpl
		 * @see edairy.model.impl.ModelPackageImpl#getMapLocation()
		 * @generated
		 */
		EClass MAP_LOCATION = eINSTANCE.getMapLocation();

		/**
		 * The meta object literal for the '<em><b>Longitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAP_LOCATION__LONGITUDE = eINSTANCE.getMapLocation_Longitude();

		/**
		 * The meta object literal for the '<em><b>Latitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAP_LOCATION__LATITUDE = eINSTANCE.getMapLocation_Latitude();

		/**
		 * The meta object literal for the '{@link edairy.model.impl.PostalLocationImpl <em>Postal Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.impl.PostalLocationImpl
		 * @see edairy.model.impl.ModelPackageImpl#getPostalLocation()
		 * @generated
		 */
		EClass POSTAL_LOCATION = eINSTANCE.getPostalLocation();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__ADDRESS = eINSTANCE.getPostalLocation_Address();

		/**
		 * The meta object literal for the '<em><b>Province</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__PROVINCE = eINSTANCE.getPostalLocation_Province();

		/**
		 * The meta object literal for the '<em><b>Division</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__DIVISION = eINSTANCE.getPostalLocation_Division();

		/**
		 * The meta object literal for the '<em><b>District</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__DISTRICT = eINSTANCE.getPostalLocation_District();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__LOCATION = eINSTANCE.getPostalLocation_Location();

		/**
		 * The meta object literal for the '<em><b>Sub Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__SUB_LOCATION = eINSTANCE.getPostalLocation_SubLocation();

		/**
		 * The meta object literal for the '<em><b>Village</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__VILLAGE = eINSTANCE.getPostalLocation_Village();

		/**
		 * The meta object literal for the '<em><b>Postal Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__POSTAL_CODE = eINSTANCE.getPostalLocation_PostalCode();

		/**
		 * The meta object literal for the '{@link edairy.model.impl.StatutoryLocationImpl <em>Statutory Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.impl.StatutoryLocationImpl
		 * @see edairy.model.impl.ModelPackageImpl#getStatutoryLocation()
		 * @generated
		 */
		EClass STATUTORY_LOCATION = eINSTANCE.getStatutoryLocation();

		/**
		 * The meta object literal for the '<em><b>Land Reference Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATUTORY_LOCATION__LAND_REFERENCE_NUMBER = eINSTANCE.getStatutoryLocation_LandReferenceNumber();

		/**
		 * The meta object literal for the '{@link edairy.model.impl.AuditedImpl <em>Audited</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.impl.AuditedImpl
		 * @see edairy.model.impl.ModelPackageImpl#getAudited()
		 * @generated
		 */
		EClass AUDITED = eINSTANCE.getAudited();

		/**
		 * The meta object literal for the '<em><b>Last Updated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDITED__LAST_UPDATED = eINSTANCE.getAudited_LastUpdated();

		/**
		 * The meta object literal for the '<em><b>Void Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDITED__VOID_DATE = eINSTANCE.getAudited_VoidDate();

		/**
		 * The meta object literal for the '{@link edairy.model.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.impl.PersonImpl
		 * @see edairy.model.impl.ModelPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>National Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NATIONAL_ID = eINSTANCE.getPerson_NationalId();

		/**
		 * The meta object literal for the '<em><b>Nhif Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NHIF_NUMBER = eINSTANCE.getPerson_NhifNumber();

		/**
		 * The meta object literal for the '<em><b>Nssf Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NSSF_NUMBER = eINSTANCE.getPerson_NssfNumber();

		/**
		 * The meta object literal for the '{@link edairy.model.impl.CompanyImpl <em>Company</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.impl.CompanyImpl
		 * @see edairy.model.impl.ModelPackageImpl#getCompany()
		 * @generated
		 */
		EClass COMPANY = eINSTANCE.getCompany();

		/**
		 * The meta object literal for the '<em><b>Contact Person</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPANY__CONTACT_PERSON = eINSTANCE.getCompany_ContactPerson();

		/**
		 * The meta object literal for the '{@link edairy.model.impl.DescriptiveLocationImpl <em>Descriptive Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edairy.model.impl.DescriptiveLocationImpl
		 * @see edairy.model.impl.ModelPackageImpl#getDescriptiveLocation()
		 * @generated
		 */
		EClass DESCRIPTIVE_LOCATION = eINSTANCE.getDescriptiveLocation();

		/**
		 * The meta object literal for the '<em><b>Directions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTIVE_LOCATION__DIRECTIONS = eINSTANCE.getDescriptiveLocation_Directions();

		/**
		 * The meta object literal for the '<em>Transaction ID</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see edairy.model.impl.ModelPackageImpl#getTransactionID()
		 * @generated
		 */
		EDataType TRANSACTION_ID = eINSTANCE.getTransactionID();

		/**
		 * The meta object literal for the '<em>Unique ID</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see edairy.model.impl.ModelPackageImpl#getUniqueID()
		 * @generated
		 */
		EDataType UNIQUE_ID = eINSTANCE.getUniqueID();

	}

} //ModelPackage
