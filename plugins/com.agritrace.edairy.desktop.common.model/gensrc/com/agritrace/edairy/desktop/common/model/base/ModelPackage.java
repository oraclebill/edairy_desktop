/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see com.agritrace.edairy.desktop.common.model.base.ModelFactory
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
	String eNAME = "base";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://com.agritrace.edairy.desktop.common.model/base/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "base";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.MapLocationImpl <em>Map Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.MapLocationImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getMapLocation()
	 * @generated
	 */
	int MAP_LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LOCATION__LONGITUDE = 0;

	/**
	 * The feature id for the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LOCATION__LATITUDE = 1;

	/**
	 * The number of structural features of the '<em>Map Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LOCATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.PostalLocationImpl <em>Postal Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.PostalLocationImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getPostalLocation()
	 * @generated
	 */
	int POSTAL_LOCATION = 1;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__ADDRESS = 0;

	/**
	 * The feature id for the '<em><b>Section</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__SECTION = 1;

	/**
	 * The feature id for the '<em><b>Estate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__ESTATE = 2;

	/**
	 * The feature id for the '<em><b>Village</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__VILLAGE = 3;

	/**
	 * The feature id for the '<em><b>Sub Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__SUB_LOCATION = 4;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__LOCATION = 5;

	/**
	 * The feature id for the '<em><b>District</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__DISTRICT = 6;

	/**
	 * The feature id for the '<em><b>Division</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__DIVISION = 7;

	/**
	 * The feature id for the '<em><b>Province</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__PROVINCE = 8;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION__POSTAL_CODE = 9;

	/**
	 * The number of structural features of the '<em>Postal Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTAL_LOCATION_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.StatutoryLocationImpl <em>Statutory Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.StatutoryLocationImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getStatutoryLocation()
	 * @generated
	 */
	int STATUTORY_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Land Reference Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUTORY_LOCATION__LAND_REFERENCE_NUMBER = 0;

	/**
	 * The number of structural features of the '<em>Statutory Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUTORY_LOCATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.AuditedImpl <em>Audited</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.AuditedImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getAudited()
	 * @generated
	 */
	int AUDITED = 3;

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
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.VersionedImpl <em>Versioned</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.VersionedImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getVersioned()
	 * @generated
	 */
	int VERSIONED = 4;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONED__VERSION = 0;

	/**
	 * The number of structural features of the '<em>Versioned</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONED_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.ContactableImpl <em>Contactable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ContactableImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getContactable()
	 * @generated
	 */
	int CONTACTABLE = 5;

	/**
	 * The feature id for the '<em><b>Contact Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACTABLE__CONTACT_METHODS = 0;

	/**
	 * The number of structural features of the '<em>Contactable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACTABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 6;

	/**
	 * The feature id for the '<em><b>Contact Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__CONTACT_METHODS = CONTACTABLE__CONTACT_METHODS;

	/**
	 * The feature id for the '<em><b>Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__PHOTO = CONTACTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Honorific</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__HONORIFIC = CONTACTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Family Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__FAMILY_NAME = CONTACTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Given Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__GIVEN_NAME = CONTACTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Middle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__MIDDLE_NAME = CONTACTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Additional Names</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ADDITIONAL_NAMES = CONTACTABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__SUFFIX = CONTACTABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Nick Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NICK_NAME = CONTACTABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__PHONE_NUMBER = CONTACTABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__LOCATION = CONTACTABLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Person Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__PERSON_ID = CONTACTABLE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Nssf Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NSSF_NUMBER = CONTACTABLE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Nhif Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NHIF_NUMBER = CONTACTABLE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>National Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NATIONAL_ID = CONTACTABLE_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = CONTACTABLE_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl <em>Company</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getCompany()
	 * @generated
	 */
	int COMPANY = 7;

	/**
	 * The feature id for the '<em><b>Contact Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__CONTACT_METHODS = CONTACTABLE__CONTACT_METHODS;

	/**
	 * The feature id for the '<em><b>Legal Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__LEGAL_NAME = CONTACTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Company Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__COMPANY_NAME = CONTACTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Contacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__CONTACTS = CONTACTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__LOCATION = CONTACTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__PHONE_NUMBER = CONTACTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Company Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__COMPANY_ID = CONTACTABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__DESCRIPTION = CONTACTABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Profile Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__PROFILE_PHOTO = CONTACTABLE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Company</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY_FEATURE_COUNT = CONTACTABLE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.DescriptiveLocationImpl <em>Descriptive Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.DescriptiveLocationImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getDescriptiveLocation()
	 * @generated
	 */
	int DESCRIPTIVE_LOCATION = 8;

	/**
	 * The feature id for the '<em><b>Directions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTIVE_LOCATION__DIRECTIONS = 0;

	/**
	 * The feature id for the '<em><b>Landmarks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTIVE_LOCATION__LANDMARKS = 1;

	/**
	 * The number of structural features of the '<em>Descriptive Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTIVE_LOCATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.LocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.LocationImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getLocation()
	 * @generated
	 */
	int LOCATION = 9;

	/**
	 * The feature id for the '<em><b>Postal Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__POSTAL_LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Map Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__MAP_LOCATION = 1;

	/**
	 * The feature id for the '<em><b>Statutory Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__STATUTORY_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Descriptive Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__DESCRIPTIVE_LOCATION = 3;

	/**
	 * The feature id for the '<em><b>Location Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__LOCATION_ID = 4;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.ContactMethodImpl <em>Contact Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ContactMethodImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getContactMethod()
	 * @generated
	 */
	int CONTACT_METHOD = 10;

	/**
	 * The feature id for the '<em><b>Cm Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT_METHOD__CM_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Cm Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT_METHOD__CM_VALUE = 1;

	/**
	 * The number of structural features of the '<em>Contact Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT_METHOD_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.ImageEntryImpl <em>Image Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ImageEntryImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getImageEntry()
	 * @generated
	 */
	int IMAGE_ENTRY = 11;

	/**
	 * The feature id for the '<em><b>Image Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_ENTRY__IMAGE_ID = 0;

	/**
	 * The feature id for the '<em><b>Mime Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_ENTRY__MIME_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Image Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_ENTRY__IMAGE_DATA = 2;

	/**
	 * The number of structural features of the '<em>Image Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_ENTRY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.SystemUserImpl <em>System User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.SystemUserImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getSystemUser()
	 * @generated
	 */
	int SYSTEM_USER = 12;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_USER__USERNAME = 0;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_USER__PASSWORD = 1;

	/**
	 * The feature id for the '<em><b>Related Employee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_USER__RELATED_EMPLOYEE = 2;

	/**
	 * The feature id for the '<em><b>Local Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_USER__LOCAL_ENABLED = 3;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_USER__ROLE = 4;

	/**
	 * The feature id for the '<em><b>Password Hashed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_USER__PASSWORD_HASHED = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_USER__ID = 6;

	/**
	 * The number of structural features of the '<em>System User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_USER_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.RoleImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__PERMISSIONS = 3;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.PermissionNamespaceImpl <em>Permission Namespace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.PermissionNamespaceImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getPermissionNamespace()
	 * @generated
	 */
	int PERMISSION_NAMESPACE = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_NAMESPACE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_NAMESPACE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Permission Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_NAMESPACE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.PermissionImpl <em>Permission</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.PermissionImpl
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getPermission()
	 * @generated
	 */
	int PERMISSION = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__ID = 0;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__NAMESPACE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__NAME = 2;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__DISPLAY_NAME = 3;

	/**
	 * The number of structural features of the '<em>Permission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.Gender <em>Gender</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.Gender
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getGender()
	 * @generated
	 */
	int GENDER = 16;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.ContactMethodType <em>Contact Method Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.ContactMethodType
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getContactMethodType()
	 * @generated
	 */
	int CONTACT_METHOD_TYPE = 17;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure <em>Unit Of Measure</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getUnitOfMeasure()
	 * @generated
	 */
	int UNIT_OF_MEASURE = 18;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.base.ContainerType <em>Container Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.base.ContainerType
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getContainerType()
	 * @generated
	 */
	int CONTAINER_TYPE = 19;

	/**
	 * The meta object id for the '<em>Transaction ID</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getTransactionID()
	 * @generated
	 */
	int TRANSACTION_ID = 20;

	/**
	 * The meta object id for the '<em>Unique ID</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Long
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getUniqueID()
	 * @generated
	 */
	int UNIQUE_ID = 21;

	/**
	 * The meta object id for the '<em>Image Reference</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getImageReference()
	 * @generated
	 */
	int IMAGE_REFERENCE = 22;

	/**
	 * The meta object id for the '<em>Permission T</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getPermissionT()
	 * @generated
	 */
	int PERMISSION_T = 23;


	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.MapLocation <em>Map Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.MapLocation
	 * @generated
	 */
	EClass getMapLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.MapLocation#getLongitude <em>Longitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Longitude</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.MapLocation#getLongitude()
	 * @see #getMapLocation()
	 * @generated
	 */
	EAttribute getMapLocation_Longitude();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.MapLocation#getLatitude <em>Latitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Latitude</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.MapLocation#getLatitude()
	 * @see #getMapLocation()
	 * @generated
	 */
	EAttribute getMapLocation_Latitude();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.PostalLocation <em>Postal Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Postal Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.PostalLocation
	 * @generated
	 */
	EClass getPostalLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.PostalLocation#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.PostalLocation#getAddress()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_Address();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.PostalLocation#getSection <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Section</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.PostalLocation#getSection()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_Section();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.PostalLocation#getEstate <em>Estate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Estate</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.PostalLocation#getEstate()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_Estate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.PostalLocation#getVillage <em>Village</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Village</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.PostalLocation#getVillage()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_Village();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.PostalLocation#getSubLocation <em>Sub Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.PostalLocation#getSubLocation()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_SubLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.PostalLocation#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.PostalLocation#getLocation()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_Location();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.PostalLocation#getDistrict <em>District</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>District</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.PostalLocation#getDistrict()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_District();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.PostalLocation#getDivision <em>Division</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Division</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.PostalLocation#getDivision()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_Division();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.PostalLocation#getProvince <em>Province</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Province</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.PostalLocation#getProvince()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_Province();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.PostalLocation#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Postal Code</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.PostalLocation#getPostalCode()
	 * @see #getPostalLocation()
	 * @generated
	 */
	EAttribute getPostalLocation_PostalCode();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.StatutoryLocation <em>Statutory Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statutory Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.StatutoryLocation
	 * @generated
	 */
	EClass getStatutoryLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.StatutoryLocation#getLandReferenceNumber <em>Land Reference Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Land Reference Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.StatutoryLocation#getLandReferenceNumber()
	 * @see #getStatutoryLocation()
	 * @generated
	 */
	EAttribute getStatutoryLocation_LandReferenceNumber();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.Audited <em>Audited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Audited</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Audited
	 * @generated
	 */
	EClass getAudited();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Audited#getLastUpdated <em>Last Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Updated</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Audited#getLastUpdated()
	 * @see #getAudited()
	 * @generated
	 */
	EAttribute getAudited_LastUpdated();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Audited#getVoidDate <em>Void Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Void Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Audited#getVoidDate()
	 * @see #getAudited()
	 * @generated
	 */
	EAttribute getAudited_VoidDate();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.Versioned <em>Versioned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Versioned</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Versioned
	 * @generated
	 */
	EClass getVersioned();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Versioned#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Versioned#getVersion()
	 * @see #getVersioned()
	 * @generated
	 */
	EAttribute getVersioned_Version();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.Contactable <em>Contactable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contactable</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Contactable
	 * @generated
	 */
	EClass getContactable();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.base.Contactable#getContactMethods <em>Contact Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contact Methods</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Contactable#getContactMethods()
	 * @see #getContactable()
	 * @generated
	 */
	EReference getContactable_ContactMethods();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Person#getPhoto <em>Photo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Photo</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person#getPhoto()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Photo();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Person#getHonorific <em>Honorific</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Honorific</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person#getHonorific()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Honorific();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Person#getFamilyName <em>Family Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Family Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person#getFamilyName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_FamilyName();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Person#getGivenName <em>Given Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Given Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person#getGivenName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_GivenName();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Person#getMiddleName <em>Middle Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Middle Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person#getMiddleName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_MiddleName();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Person#getAdditionalNames <em>Additional Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Additional Names</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person#getAdditionalNames()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_AdditionalNames();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Person#getSuffix <em>Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suffix</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person#getSuffix()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Suffix();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Person#getNickName <em>Nick Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nick Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person#getNickName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_NickName();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Person#getPhoneNumber <em>Phone Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phone Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person#getPhoneNumber()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_PhoneNumber();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.base.Person#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person#getLocation()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Location();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Person#getPersonId <em>Person Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Person Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person#getPersonId()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_PersonId();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Person#getNssfNumber <em>Nssf Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nssf Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person#getNssfNumber()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_NssfNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Person#getNhifNumber <em>Nhif Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nhif Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person#getNhifNumber()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_NhifNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Person#getNationalId <em>National Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>National Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person#getNationalId()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_NationalId();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.Company <em>Company</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Company</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Company
	 * @generated
	 */
	EClass getCompany();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Company#getLegalName <em>Legal Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Legal Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Company#getLegalName()
	 * @see #getCompany()
	 * @generated
	 */
	EAttribute getCompany_LegalName();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Company#getCompanyName <em>Company Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Company Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Company#getCompanyName()
	 * @see #getCompany()
	 * @generated
	 */
	EAttribute getCompany_CompanyName();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.base.Company#getContacts <em>Contacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contacts</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Company#getContacts()
	 * @see #getCompany()
	 * @generated
	 */
	EReference getCompany_Contacts();

	/**
	 * Returns the meta object for the containment reference '{@link com.agritrace.edairy.desktop.common.model.base.Company#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Company#getLocation()
	 * @see #getCompany()
	 * @generated
	 */
	EReference getCompany_Location();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Company#getPhoneNumber <em>Phone Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phone Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Company#getPhoneNumber()
	 * @see #getCompany()
	 * @generated
	 */
	EAttribute getCompany_PhoneNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Company#getCompanyId <em>Company Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Company Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Company#getCompanyId()
	 * @see #getCompany()
	 * @generated
	 */
	EAttribute getCompany_CompanyId();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Company#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Company#getDescription()
	 * @see #getCompany()
	 * @generated
	 */
	EAttribute getCompany_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Company#getProfilePhoto <em>Profile Photo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Photo</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Company#getProfilePhoto()
	 * @see #getCompany()
	 * @generated
	 */
	EAttribute getCompany_ProfilePhoto();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation <em>Descriptive Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptive Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation
	 * @generated
	 */
	EClass getDescriptiveLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation#getDirections <em>Directions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Directions</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation#getDirections()
	 * @see #getDescriptiveLocation()
	 * @generated
	 */
	EAttribute getDescriptiveLocation_Directions();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation#getLandmarks <em>Landmarks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Landmarks</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation#getLandmarks()
	 * @see #getDescriptiveLocation()
	 * @generated
	 */
	EAttribute getDescriptiveLocation_Landmarks();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Location
	 * @generated
	 */
	EClass getLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.agritrace.edairy.desktop.common.model.base.Location#getPostalLocation <em>Postal Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postal Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Location#getPostalLocation()
	 * @see #getLocation()
	 * @generated
	 */
	EReference getLocation_PostalLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.agritrace.edairy.desktop.common.model.base.Location#getMapLocation <em>Map Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Map Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Location#getMapLocation()
	 * @see #getLocation()
	 * @generated
	 */
	EReference getLocation_MapLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.agritrace.edairy.desktop.common.model.base.Location#getStatutoryLocation <em>Statutory Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Statutory Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Location#getStatutoryLocation()
	 * @see #getLocation()
	 * @generated
	 */
	EReference getLocation_StatutoryLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.agritrace.edairy.desktop.common.model.base.Location#getDescriptiveLocation <em>Descriptive Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Descriptive Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Location#getDescriptiveLocation()
	 * @see #getLocation()
	 * @generated
	 */
	EReference getLocation_DescriptiveLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Location#getLocationId <em>Location Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Location#getLocationId()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_LocationId();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.ContactMethod <em>Contact Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contact Method</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.ContactMethod
	 * @generated
	 */
	EClass getContactMethod();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.ContactMethod#getCmType <em>Cm Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cm Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.ContactMethod#getCmType()
	 * @see #getContactMethod()
	 * @generated
	 */
	EAttribute getContactMethod_CmType();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.ContactMethod#getCmValue <em>Cm Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cm Value</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.ContactMethod#getCmValue()
	 * @see #getContactMethod()
	 * @generated
	 */
	EAttribute getContactMethod_CmValue();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.ImageEntry <em>Image Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Entry</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.ImageEntry
	 * @generated
	 */
	EClass getImageEntry();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.ImageEntry#getImageId <em>Image Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.ImageEntry#getImageId()
	 * @see #getImageEntry()
	 * @generated
	 */
	EAttribute getImageEntry_ImageId();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.ImageEntry#getMimeType <em>Mime Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mime Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.ImageEntry#getMimeType()
	 * @see #getImageEntry()
	 * @generated
	 */
	EAttribute getImageEntry_MimeType();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.ImageEntry#getImageData <em>Image Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Data</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.ImageEntry#getImageData()
	 * @see #getImageEntry()
	 * @generated
	 */
	EAttribute getImageEntry_ImageData();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser <em>System User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System User</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.SystemUser
	 * @generated
	 */
	EClass getSystemUser();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.SystemUser#getUsername()
	 * @see #getSystemUser()
	 * @generated
	 */
	EAttribute getSystemUser_Username();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.SystemUser#getPassword()
	 * @see #getSystemUser()
	 * @generated
	 */
	EAttribute getSystemUser_Password();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#getRelatedEmployee <em>Related Employee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Related Employee</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.SystemUser#getRelatedEmployee()
	 * @see #getSystemUser()
	 * @generated
	 */
	EReference getSystemUser_RelatedEmployee();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#isLocalEnabled <em>Local Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Enabled</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.SystemUser#isLocalEnabled()
	 * @see #getSystemUser()
	 * @generated
	 */
	EAttribute getSystemUser_LocalEnabled();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.SystemUser#getRole()
	 * @see #getSystemUser()
	 * @generated
	 */
	EReference getSystemUser_Role();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#isPasswordHashed <em>Password Hashed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password Hashed</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.SystemUser#isPasswordHashed()
	 * @see #getSystemUser()
	 * @generated
	 */
	EAttribute getSystemUser_PasswordHashed();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.SystemUser#getId()
	 * @see #getSystemUser()
	 * @generated
	 */
	EAttribute getSystemUser_Id();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Role#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Role#getId()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Role#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Role#getName()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Role#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Role#getDescription()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Description();

	/**
	 * Returns the meta object for the attribute list '{@link com.agritrace.edairy.desktop.common.model.base.Role#getPermissions <em>Permissions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Permissions</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Role#getPermissions()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Permissions();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.PermissionNamespace <em>Permission Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Permission Namespace</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.PermissionNamespace
	 * @generated
	 */
	EClass getPermissionNamespace();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.PermissionNamespace#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.PermissionNamespace#getId()
	 * @see #getPermissionNamespace()
	 * @generated
	 */
	EAttribute getPermissionNamespace_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.PermissionNamespace#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.PermissionNamespace#getName()
	 * @see #getPermissionNamespace()
	 * @generated
	 */
	EAttribute getPermissionNamespace_Name();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.base.Permission <em>Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Permission</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Permission
	 * @generated
	 */
	EClass getPermission();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Permission#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Permission#getId()
	 * @see #getPermission()
	 * @generated
	 */
	EAttribute getPermission_Id();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.base.Permission#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Namespace</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Permission#getNamespace()
	 * @see #getPermission()
	 * @generated
	 */
	EReference getPermission_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Permission#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Permission#getName()
	 * @see #getPermission()
	 * @generated
	 */
	EAttribute getPermission_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.base.Permission#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Permission#getDisplayName()
	 * @see #getPermission()
	 * @generated
	 */
	EAttribute getPermission_DisplayName();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.base.Gender <em>Gender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Gender</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.Gender
	 * @generated
	 */
	EEnum getGender();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.base.ContactMethodType <em>Contact Method Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Contact Method Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.ContactMethodType
	 * @generated
	 */
	EEnum getContactMethodType();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure <em>Unit Of Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unit Of Measure</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure
	 * @generated
	 */
	EEnum getUnitOfMeasure();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.base.ContainerType <em>Container Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Container Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.base.ContainerType
	 * @generated
	 */
	EEnum getContainerType();

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
	 * Returns the meta object for data type '{@link java.lang.Long <em>Unique ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Unique ID</em>'.
	 * @see java.lang.Long
	 * @model instanceClass="java.lang.Long"
	 * @generated
	 */
	EDataType getUniqueID();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Image Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Image Reference</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getImageReference();

	/**
	 * Returns the meta object for data type '{@link com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission <em>Permission T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Permission T</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission
	 * @model instanceClass="com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission"
	 * @generated
	 */
	EDataType getPermissionT();

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
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.MapLocationImpl <em>Map Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.MapLocationImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getMapLocation()
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
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.PostalLocationImpl <em>Postal Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.PostalLocationImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getPostalLocation()
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
		 * The meta object literal for the '<em><b>Section</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__SECTION = eINSTANCE.getPostalLocation_Section();

		/**
		 * The meta object literal for the '<em><b>Estate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__ESTATE = eINSTANCE.getPostalLocation_Estate();

		/**
		 * The meta object literal for the '<em><b>Village</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__VILLAGE = eINSTANCE.getPostalLocation_Village();

		/**
		 * The meta object literal for the '<em><b>Sub Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__SUB_LOCATION = eINSTANCE.getPostalLocation_SubLocation();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__LOCATION = eINSTANCE.getPostalLocation_Location();

		/**
		 * The meta object literal for the '<em><b>District</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__DISTRICT = eINSTANCE.getPostalLocation_District();

		/**
		 * The meta object literal for the '<em><b>Division</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__DIVISION = eINSTANCE.getPostalLocation_Division();

		/**
		 * The meta object literal for the '<em><b>Province</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__PROVINCE = eINSTANCE.getPostalLocation_Province();

		/**
		 * The meta object literal for the '<em><b>Postal Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTAL_LOCATION__POSTAL_CODE = eINSTANCE.getPostalLocation_PostalCode();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.StatutoryLocationImpl <em>Statutory Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.StatutoryLocationImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getStatutoryLocation()
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
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.AuditedImpl <em>Audited</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.AuditedImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getAudited()
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
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.VersionedImpl <em>Versioned</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.VersionedImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getVersioned()
		 * @generated
		 */
		EClass VERSIONED = eINSTANCE.getVersioned();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSIONED__VERSION = eINSTANCE.getVersioned_Version();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.ContactableImpl <em>Contactable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ContactableImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getContactable()
		 * @generated
		 */
		EClass CONTACTABLE = eINSTANCE.getContactable();

		/**
		 * The meta object literal for the '<em><b>Contact Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTACTABLE__CONTACT_METHODS = eINSTANCE.getContactable_ContactMethods();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Photo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__PHOTO = eINSTANCE.getPerson_Photo();

		/**
		 * The meta object literal for the '<em><b>Honorific</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__HONORIFIC = eINSTANCE.getPerson_Honorific();

		/**
		 * The meta object literal for the '<em><b>Family Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__FAMILY_NAME = eINSTANCE.getPerson_FamilyName();

		/**
		 * The meta object literal for the '<em><b>Given Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__GIVEN_NAME = eINSTANCE.getPerson_GivenName();

		/**
		 * The meta object literal for the '<em><b>Middle Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__MIDDLE_NAME = eINSTANCE.getPerson_MiddleName();

		/**
		 * The meta object literal for the '<em><b>Additional Names</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__ADDITIONAL_NAMES = eINSTANCE.getPerson_AdditionalNames();

		/**
		 * The meta object literal for the '<em><b>Suffix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__SUFFIX = eINSTANCE.getPerson_Suffix();

		/**
		 * The meta object literal for the '<em><b>Nick Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NICK_NAME = eINSTANCE.getPerson_NickName();

		/**
		 * The meta object literal for the '<em><b>Phone Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__PHONE_NUMBER = eINSTANCE.getPerson_PhoneNumber();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__LOCATION = eINSTANCE.getPerson_Location();

		/**
		 * The meta object literal for the '<em><b>Person Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__PERSON_ID = eINSTANCE.getPerson_PersonId();

		/**
		 * The meta object literal for the '<em><b>Nssf Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NSSF_NUMBER = eINSTANCE.getPerson_NssfNumber();

		/**
		 * The meta object literal for the '<em><b>Nhif Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NHIF_NUMBER = eINSTANCE.getPerson_NhifNumber();

		/**
		 * The meta object literal for the '<em><b>National Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NATIONAL_ID = eINSTANCE.getPerson_NationalId();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl <em>Company</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getCompany()
		 * @generated
		 */
		EClass COMPANY = eINSTANCE.getCompany();

		/**
		 * The meta object literal for the '<em><b>Legal Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPANY__LEGAL_NAME = eINSTANCE.getCompany_LegalName();

		/**
		 * The meta object literal for the '<em><b>Company Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPANY__COMPANY_NAME = eINSTANCE.getCompany_CompanyName();

		/**
		 * The meta object literal for the '<em><b>Contacts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPANY__CONTACTS = eINSTANCE.getCompany_Contacts();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPANY__LOCATION = eINSTANCE.getCompany_Location();

		/**
		 * The meta object literal for the '<em><b>Phone Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPANY__PHONE_NUMBER = eINSTANCE.getCompany_PhoneNumber();

		/**
		 * The meta object literal for the '<em><b>Company Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPANY__COMPANY_ID = eINSTANCE.getCompany_CompanyId();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPANY__DESCRIPTION = eINSTANCE.getCompany_Description();

		/**
		 * The meta object literal for the '<em><b>Profile Photo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPANY__PROFILE_PHOTO = eINSTANCE.getCompany_ProfilePhoto();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.DescriptiveLocationImpl <em>Descriptive Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.DescriptiveLocationImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getDescriptiveLocation()
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
		 * The meta object literal for the '<em><b>Landmarks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTIVE_LOCATION__LANDMARKS = eINSTANCE.getDescriptiveLocation_Landmarks();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.LocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.LocationImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getLocation()
		 * @generated
		 */
		EClass LOCATION = eINSTANCE.getLocation();

		/**
		 * The meta object literal for the '<em><b>Postal Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION__POSTAL_LOCATION = eINSTANCE.getLocation_PostalLocation();

		/**
		 * The meta object literal for the '<em><b>Map Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION__MAP_LOCATION = eINSTANCE.getLocation_MapLocation();

		/**
		 * The meta object literal for the '<em><b>Statutory Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION__STATUTORY_LOCATION = eINSTANCE.getLocation_StatutoryLocation();

		/**
		 * The meta object literal for the '<em><b>Descriptive Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION__DESCRIPTIVE_LOCATION = eINSTANCE.getLocation_DescriptiveLocation();

		/**
		 * The meta object literal for the '<em><b>Location Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__LOCATION_ID = eINSTANCE.getLocation_LocationId();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.ContactMethodImpl <em>Contact Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ContactMethodImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getContactMethod()
		 * @generated
		 */
		EClass CONTACT_METHOD = eINSTANCE.getContactMethod();

		/**
		 * The meta object literal for the '<em><b>Cm Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTACT_METHOD__CM_TYPE = eINSTANCE.getContactMethod_CmType();

		/**
		 * The meta object literal for the '<em><b>Cm Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTACT_METHOD__CM_VALUE = eINSTANCE.getContactMethod_CmValue();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.ImageEntryImpl <em>Image Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ImageEntryImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getImageEntry()
		 * @generated
		 */
		EClass IMAGE_ENTRY = eINSTANCE.getImageEntry();

		/**
		 * The meta object literal for the '<em><b>Image Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_ENTRY__IMAGE_ID = eINSTANCE.getImageEntry_ImageId();

		/**
		 * The meta object literal for the '<em><b>Mime Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_ENTRY__MIME_TYPE = eINSTANCE.getImageEntry_MimeType();

		/**
		 * The meta object literal for the '<em><b>Image Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_ENTRY__IMAGE_DATA = eINSTANCE.getImageEntry_ImageData();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.SystemUserImpl <em>System User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.SystemUserImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getSystemUser()
		 * @generated
		 */
		EClass SYSTEM_USER = eINSTANCE.getSystemUser();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_USER__USERNAME = eINSTANCE.getSystemUser_Username();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_USER__PASSWORD = eINSTANCE.getSystemUser_Password();

		/**
		 * The meta object literal for the '<em><b>Related Employee</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_USER__RELATED_EMPLOYEE = eINSTANCE.getSystemUser_RelatedEmployee();

		/**
		 * The meta object literal for the '<em><b>Local Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_USER__LOCAL_ENABLED = eINSTANCE.getSystemUser_LocalEnabled();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_USER__ROLE = eINSTANCE.getSystemUser_Role();

		/**
		 * The meta object literal for the '<em><b>Password Hashed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_USER__PASSWORD_HASHED = eINSTANCE.getSystemUser_PasswordHashed();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_USER__ID = eINSTANCE.getSystemUser_Id();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.RoleImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__ID = eINSTANCE.getRole_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__NAME = eINSTANCE.getRole_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__DESCRIPTION = eINSTANCE.getRole_Description();

		/**
		 * The meta object literal for the '<em><b>Permissions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__PERMISSIONS = eINSTANCE.getRole_Permissions();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.PermissionNamespaceImpl <em>Permission Namespace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.PermissionNamespaceImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getPermissionNamespace()
		 * @generated
		 */
		EClass PERMISSION_NAMESPACE = eINSTANCE.getPermissionNamespace();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION_NAMESPACE__ID = eINSTANCE.getPermissionNamespace_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION_NAMESPACE__NAME = eINSTANCE.getPermissionNamespace_Name();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.impl.PermissionImpl <em>Permission</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.PermissionImpl
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getPermission()
		 * @generated
		 */
		EClass PERMISSION = eINSTANCE.getPermission();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION__ID = eINSTANCE.getPermission_Id();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERMISSION__NAMESPACE = eINSTANCE.getPermission_Namespace();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION__NAME = eINSTANCE.getPermission_Name();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION__DISPLAY_NAME = eINSTANCE.getPermission_DisplayName();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.Gender <em>Gender</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.Gender
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getGender()
		 * @generated
		 */
		EEnum GENDER = eINSTANCE.getGender();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.ContactMethodType <em>Contact Method Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.ContactMethodType
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getContactMethodType()
		 * @generated
		 */
		EEnum CONTACT_METHOD_TYPE = eINSTANCE.getContactMethodType();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure <em>Unit Of Measure</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getUnitOfMeasure()
		 * @generated
		 */
		EEnum UNIT_OF_MEASURE = eINSTANCE.getUnitOfMeasure();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.base.ContainerType <em>Container Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.base.ContainerType
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getContainerType()
		 * @generated
		 */
		EEnum CONTAINER_TYPE = eINSTANCE.getContainerType();

		/**
		 * The meta object literal for the '<em>Transaction ID</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getTransactionID()
		 * @generated
		 */
		EDataType TRANSACTION_ID = eINSTANCE.getTransactionID();

		/**
		 * The meta object literal for the '<em>Unique ID</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Long
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getUniqueID()
		 * @generated
		 */
		EDataType UNIQUE_ID = eINSTANCE.getUniqueID();

		/**
		 * The meta object literal for the '<em>Image Reference</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getImageReference()
		 * @generated
		 */
		EDataType IMAGE_REFERENCE = eINSTANCE.getImageReference();

		/**
		 * The meta object literal for the '<em>Permission T</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission
		 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl#getPermissionT()
		 * @generated
		 */
		EDataType PERMISSION_T = eINSTANCE.getPermissionT();

	}

} //ModelPackage
