/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base.impl;

import com.agritrace.edairy.desktop.common.model.base.Audited;
import com.agritrace.edairy.desktop.common.model.base.Company;
import com.agritrace.edairy.desktop.common.model.base.ContactMethod;
import com.agritrace.edairy.desktop.common.model.base.ContactMethodType;
import com.agritrace.edairy.desktop.common.model.base.Contactable;
import com.agritrace.edairy.desktop.common.model.base.ContainerType;
import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;
import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.base.ImageEntry;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.MapLocation;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Permission;
import com.agritrace.edairy.desktop.common.model.base.PermissionNamespace;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.base.Role;
import com.agritrace.edairy.desktop.common.model.base.StatutoryLocation;
import com.agritrace.edairy.desktop.common.model.base.SystemUser;
import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.base.Versioned;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;

import com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl;

import com.agritrace.edairy.desktop.common.model.dairy.impl.DairyPackageImpl;

import com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission;

import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;

import com.agritrace.edairy.desktop.common.model.requests.impl.RequestsPackageImpl;

import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;

import com.agritrace.edairy.desktop.common.model.tracking.impl.TrackingPackageImpl;

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
	private EClass versionedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contactableEClass = null;

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
	private EClass imageEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemUserEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass permissionNamespaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass permissionEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType permissionTEDataType = null;

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
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#eNS_URI
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
	public EClass getVersioned() {
		return versionedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersioned_Version() {
		return (EAttribute)versionedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContactable() {
		return contactableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContactable_ContactMethods() {
		return (EReference)contactableEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getPerson_PhoneNumber() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerson_Location() {
		return (EReference)personEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_PersonId() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_NssfNumber() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_NhifNumber() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_NationalId() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(13);
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
	public EAttribute getCompany_LegalName() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompany_CompanyName() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompany_Contacts() {
		return (EReference)companyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompany_Location() {
		return (EReference)companyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompany_PhoneNumber() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompany_CompanyId() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompany_Description() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompany_ProfilePhoto() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(7);
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
	public EAttribute getLocation_LocationId() {
		return (EAttribute)locationEClass.getEStructuralFeatures().get(4);
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
	public EClass getImageEntry() {
		return imageEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageEntry_ImageId() {
		return (EAttribute)imageEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageEntry_MimeType() {
		return (EAttribute)imageEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageEntry_ImageData() {
		return (EAttribute)imageEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemUser() {
		return systemUserEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemUser_Username() {
		return (EAttribute)systemUserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemUser_Password() {
		return (EAttribute)systemUserEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemUser_RelatedEmployee() {
		return (EReference)systemUserEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemUser_LocalEnabled() {
		return (EAttribute)systemUserEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemUser_Role() {
		return (EReference)systemUserEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemUser_PasswordHashed() {
		return (EAttribute)systemUserEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRole() {
		return roleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRole_Id() {
		return (EAttribute)roleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRole_Name() {
		return (EAttribute)roleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRole_Description() {
		return (EAttribute)roleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRole_Permissions() {
		return (EAttribute)roleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPermissionNamespace() {
		return permissionNamespaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermissionNamespace_Id() {
		return (EAttribute)permissionNamespaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermissionNamespace_Name() {
		return (EAttribute)permissionNamespaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPermission() {
		return permissionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermission_Id() {
		return (EAttribute)permissionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPermission_Namespace() {
		return (EReference)permissionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermission_Name() {
		return (EAttribute)permissionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermission_DisplayName() {
		return (EAttribute)permissionEClass.getEStructuralFeatures().get(3);
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
	public EDataType getPermissionT() {
		return permissionTEDataType;
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

		versionedEClass = createEClass(VERSIONED);
		createEAttribute(versionedEClass, VERSIONED__VERSION);

		contactableEClass = createEClass(CONTACTABLE);
		createEReference(contactableEClass, CONTACTABLE__CONTACT_METHODS);

		personEClass = createEClass(PERSON);
		createEAttribute(personEClass, PERSON__PHOTO);
		createEAttribute(personEClass, PERSON__HONORIFIC);
		createEAttribute(personEClass, PERSON__FAMILY_NAME);
		createEAttribute(personEClass, PERSON__GIVEN_NAME);
		createEAttribute(personEClass, PERSON__MIDDLE_NAME);
		createEAttribute(personEClass, PERSON__ADDITIONAL_NAMES);
		createEAttribute(personEClass, PERSON__SUFFIX);
		createEAttribute(personEClass, PERSON__NICK_NAME);
		createEAttribute(personEClass, PERSON__PHONE_NUMBER);
		createEReference(personEClass, PERSON__LOCATION);
		createEAttribute(personEClass, PERSON__PERSON_ID);
		createEAttribute(personEClass, PERSON__NSSF_NUMBER);
		createEAttribute(personEClass, PERSON__NHIF_NUMBER);
		createEAttribute(personEClass, PERSON__NATIONAL_ID);

		companyEClass = createEClass(COMPANY);
		createEAttribute(companyEClass, COMPANY__LEGAL_NAME);
		createEAttribute(companyEClass, COMPANY__COMPANY_NAME);
		createEReference(companyEClass, COMPANY__CONTACTS);
		createEReference(companyEClass, COMPANY__LOCATION);
		createEAttribute(companyEClass, COMPANY__PHONE_NUMBER);
		createEAttribute(companyEClass, COMPANY__COMPANY_ID);
		createEAttribute(companyEClass, COMPANY__DESCRIPTION);
		createEAttribute(companyEClass, COMPANY__PROFILE_PHOTO);

		descriptiveLocationEClass = createEClass(DESCRIPTIVE_LOCATION);
		createEAttribute(descriptiveLocationEClass, DESCRIPTIVE_LOCATION__DIRECTIONS);
		createEAttribute(descriptiveLocationEClass, DESCRIPTIVE_LOCATION__LANDMARKS);

		locationEClass = createEClass(LOCATION);
		createEReference(locationEClass, LOCATION__POSTAL_LOCATION);
		createEReference(locationEClass, LOCATION__MAP_LOCATION);
		createEReference(locationEClass, LOCATION__STATUTORY_LOCATION);
		createEReference(locationEClass, LOCATION__DESCRIPTIVE_LOCATION);
		createEAttribute(locationEClass, LOCATION__LOCATION_ID);

		contactMethodEClass = createEClass(CONTACT_METHOD);
		createEAttribute(contactMethodEClass, CONTACT_METHOD__CM_TYPE);
		createEAttribute(contactMethodEClass, CONTACT_METHOD__CM_VALUE);

		imageEntryEClass = createEClass(IMAGE_ENTRY);
		createEAttribute(imageEntryEClass, IMAGE_ENTRY__IMAGE_ID);
		createEAttribute(imageEntryEClass, IMAGE_ENTRY__MIME_TYPE);
		createEAttribute(imageEntryEClass, IMAGE_ENTRY__IMAGE_DATA);

		systemUserEClass = createEClass(SYSTEM_USER);
		createEAttribute(systemUserEClass, SYSTEM_USER__USERNAME);
		createEAttribute(systemUserEClass, SYSTEM_USER__PASSWORD);
		createEReference(systemUserEClass, SYSTEM_USER__RELATED_EMPLOYEE);
		createEAttribute(systemUserEClass, SYSTEM_USER__LOCAL_ENABLED);
		createEReference(systemUserEClass, SYSTEM_USER__ROLE);
		createEAttribute(systemUserEClass, SYSTEM_USER__PASSWORD_HASHED);

		roleEClass = createEClass(ROLE);
		createEAttribute(roleEClass, ROLE__ID);
		createEAttribute(roleEClass, ROLE__NAME);
		createEAttribute(roleEClass, ROLE__DESCRIPTION);
		createEAttribute(roleEClass, ROLE__PERMISSIONS);

		permissionNamespaceEClass = createEClass(PERMISSION_NAMESPACE);
		createEAttribute(permissionNamespaceEClass, PERMISSION_NAMESPACE__ID);
		createEAttribute(permissionNamespaceEClass, PERMISSION_NAMESPACE__NAME);

		permissionEClass = createEClass(PERMISSION);
		createEAttribute(permissionEClass, PERMISSION__ID);
		createEReference(permissionEClass, PERMISSION__NAMESPACE);
		createEAttribute(permissionEClass, PERMISSION__NAME);
		createEAttribute(permissionEClass, PERMISSION__DISPLAY_NAME);

		// Create enums
		genderEEnum = createEEnum(GENDER);
		contactMethodTypeEEnum = createEEnum(CONTACT_METHOD_TYPE);
		unitOfMeasureEEnum = createEEnum(UNIT_OF_MEASURE);
		containerTypeEEnum = createEEnum(CONTAINER_TYPE);

		// Create data types
		transactionIDEDataType = createEDataType(TRANSACTION_ID);
		uniqueIDEDataType = createEDataType(UNIQUE_ID);
		imageReferenceEDataType = createEDataType(IMAGE_REFERENCE);
		permissionTEDataType = createEDataType(PERMISSION_T);
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
		DairyPackage theDairyPackage = (DairyPackage)EPackage.Registry.INSTANCE.getEPackage(DairyPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		personEClass.getESuperTypes().add(this.getContactable());
		companyEClass.getESuperTypes().add(this.getContactable());

		// Initialize classes and features; add operations and parameters
		initEClass(mapLocationEClass, MapLocation.class, "MapLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMapLocation_Longitude(), ecorePackage.getEDouble(), "longitude", null, 0, 1, MapLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMapLocation_Latitude(), ecorePackage.getEDouble(), "latitude", null, 0, 1, MapLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(postalLocationEClass, PostalLocation.class, "PostalLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPostalLocation_Address(), ecorePackage.getEString(), "address", null, 0, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_Section(), ecorePackage.getEString(), "section", null, 0, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_Estate(), ecorePackage.getEString(), "estate", null, 0, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_Village(), ecorePackage.getEString(), "village", null, 0, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_SubLocation(), ecorePackage.getEString(), "subLocation", null, 0, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_Location(), ecorePackage.getEString(), "location", null, 0, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_District(), ecorePackage.getEString(), "district", null, 0, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_Division(), ecorePackage.getEString(), "division", null, 0, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_Province(), ecorePackage.getEString(), "province", null, 0, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalLocation_PostalCode(), ecorePackage.getEString(), "postalCode", null, 0, 1, PostalLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statutoryLocationEClass, StatutoryLocation.class, "StatutoryLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStatutoryLocation_LandReferenceNumber(), ecorePackage.getEString(), "landReferenceNumber", null, 0, 1, StatutoryLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(auditedEClass, Audited.class, "Audited", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAudited_LastUpdated(), ecorePackage.getEDate(), "lastUpdated", null, 0, 1, Audited.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudited_VoidDate(), ecorePackage.getEDate(), "voidDate", null, 0, 1, Audited.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versionedEClass, Versioned.class, "Versioned", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersioned_Version(), ecorePackage.getELong(), "version", null, 1, 1, Versioned.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contactableEClass, Contactable.class, "Contactable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContactable_ContactMethods(), this.getContactMethod(), null, "contactMethods", null, 0, -1, Contactable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerson_Photo(), this.getImageReference(), "photo", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Honorific(), ecorePackage.getEString(), "honorific", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_FamilyName(), ecorePackage.getEString(), "familyName", null, 1, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_GivenName(), ecorePackage.getEString(), "givenName", null, 1, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_MiddleName(), ecorePackage.getEString(), "middleName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_AdditionalNames(), ecorePackage.getEString(), "additionalNames", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Suffix(), ecorePackage.getEString(), "suffix", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_NickName(), ecorePackage.getEString(), "nickName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_PhoneNumber(), ecorePackage.getEString(), "phoneNumber", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_Location(), this.getLocation(), null, "location", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_PersonId(), this.getUniqueID(), "personId", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_NssfNumber(), ecorePackage.getEString(), "nssfNumber", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_NhifNumber(), ecorePackage.getEString(), "nhifNumber", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_NationalId(), ecorePackage.getEString(), "nationalId", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(personEClass, ecorePackage.getEString(), "getFormattedName", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(companyEClass, Company.class, "Company", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompany_LegalName(), ecorePackage.getEString(), "legalName", null, 0, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompany_CompanyName(), ecorePackage.getEString(), "companyName", null, 1, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompany_Contacts(), this.getPerson(), null, "contacts", null, 1, -1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompany_Location(), this.getLocation(), null, "location", null, 1, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompany_PhoneNumber(), ecorePackage.getEString(), "phoneNumber", "+254", 1, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompany_CompanyId(), this.getUniqueID(), "companyId", null, 1, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompany_Description(), ecorePackage.getEString(), "description", null, 0, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompany_ProfilePhoto(), this.getImageReference(), "profilePhoto", null, 0, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptiveLocationEClass, DescriptiveLocation.class, "DescriptiveLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescriptiveLocation_Directions(), ecorePackage.getEString(), "directions", null, 0, 1, DescriptiveLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDescriptiveLocation_Landmarks(), ecorePackage.getEString(), "landmarks", null, 0, 1, DescriptiveLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(locationEClass, Location.class, "Location", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLocation_PostalLocation(), this.getPostalLocation(), null, "postalLocation", null, 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocation_MapLocation(), this.getMapLocation(), null, "mapLocation", null, 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocation_StatutoryLocation(), this.getStatutoryLocation(), null, "statutoryLocation", null, 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocation_DescriptiveLocation(), this.getDescriptiveLocation(), null, "descriptiveLocation", null, 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocation_LocationId(), this.getUniqueID(), "locationId", null, 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(locationEClass, ecorePackage.getEString(), "getFormattedLocation", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(contactMethodEClass, ContactMethod.class, "ContactMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContactMethod_CmType(), this.getContactMethodType(), "cmType", null, 0, 1, ContactMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContactMethod_CmValue(), ecorePackage.getEString(), "cmValue", null, 0, 1, ContactMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageEntryEClass, ImageEntry.class, "ImageEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageEntry_ImageId(), this.getImageReference(), "imageId", null, 1, 1, ImageEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageEntry_MimeType(), ecorePackage.getEString(), "mimeType", null, 1, 1, ImageEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageEntry_ImageData(), ecorePackage.getEByteArray(), "imageData", null, 0, 1, ImageEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemUserEClass, SystemUser.class, "SystemUser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSystemUser_Username(), ecorePackage.getEString(), "username", null, 0, 1, SystemUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemUser_Password(), ecorePackage.getEString(), "password", "", 0, 1, SystemUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemUser_RelatedEmployee(), theDairyPackage.getEmployee(), theDairyPackage.getEmployee_SystemIdentity(), "relatedEmployee", null, 0, 1, SystemUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemUser_LocalEnabled(), ecorePackage.getEBoolean(), "localEnabled", "true", 0, 1, SystemUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemUser_Role(), this.getRole(), null, "role", null, 0, 1, SystemUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemUser_PasswordHashed(), ecorePackage.getEBoolean(), "passwordHashed", "false", 1, 1, SystemUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRole_Id(), this.getUniqueID(), "id", null, 1, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRole_Name(), ecorePackage.getEString(), "name", null, 0, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRole_Description(), ecorePackage.getEString(), "description", null, 0, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRole_Permissions(), this.getPermissionT(), "permissions", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(permissionNamespaceEClass, PermissionNamespace.class, "PermissionNamespace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPermissionNamespace_Id(), this.getUniqueID(), "id", null, 1, 1, PermissionNamespace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermissionNamespace_Name(), ecorePackage.getEString(), "name", null, 0, 1, PermissionNamespace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(permissionEClass, Permission.class, "Permission", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPermission_Id(), this.getUniqueID(), "id", null, 1, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPermission_Namespace(), this.getPermissionNamespace(), null, "namespace", null, 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermission_Name(), ecorePackage.getEString(), "name", null, 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermission_DisplayName(), ecorePackage.getEString(), "displayName", null, 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		initEDataType(permissionTEDataType, UIPermission.class, "PermissionT", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
		// teneo.jpa
		createTeneoAnnotations();
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
		  (mapLocationEClass, 
		   source, 
		   new String[] {
			 "name", "MapLocation",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (postalLocationEClass, 
		   source, 
		   new String[] {
			 "name", "PostalLocation",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (statutoryLocationEClass, 
		   source, 
		   new String[] {
			 "name", "StatutoryLocation",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (auditedEClass, 
		   source, 
		   new String[] {
			 "name", "Audited",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getAudited_VoidDate(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (versionedEClass, 
		   source, 
		   new String[] {
			 "name", "Versioned",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (contactableEClass, 
		   source, 
		   new String[] {
			 "name", "Contactable",
			 "kind", "elementOnly"
		   });				
		addAnnotation
		  (getPerson_Location(), 
		   source, 
		   new String[] {
			 "name", "location",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getPerson_NationalId(), 
		   source, 
		   new String[] {
			 "name", "nationalId",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (companyEClass, 
		   source, 
		   new String[] {
			 "name", "Company",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (descriptiveLocationEClass, 
		   source, 
		   new String[] {
			 "name", "DescriptiveLocation",
			 "kind", "elementOnly"
		   });				
		addAnnotation
		  (getLocation_PostalLocation(), 
		   source, 
		   new String[] {
			 "name", "postalLocation",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getLocation_MapLocation(), 
		   source, 
		   new String[] {
			 "name", "mapLocation",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getLocation_StatutoryLocation(), 
		   source, 
		   new String[] {
			 "name", "statutoryLocation",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getLocation_DescriptiveLocation(), 
		   source, 
		   new String[] {
			 "name", "descriptiveLocation",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getImageEntry_ImageData(), 
		   source, 
		   new String[] {
			 "name", "imageData",
			 "kind", "elementOnly"
		   });					
	}

	/**
	 * Initializes the annotations for <b>teneo.jpa</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createTeneoAnnotations() {
		String source = "teneo.jpa";			
		addAnnotation
		  (mapLocationEClass, 
		   source, 
		   new String[] {
			 "appinfo", "@Embeddable"
		   });			
		addAnnotation
		  (postalLocationEClass, 
		   source, 
		   new String[] {
			 "appinfo", "@Embeddable"
		   });			
		addAnnotation
		  (statutoryLocationEClass, 
		   source, 
		   new String[] {
			 "appinfo", "@Embeddable"
		   });			
		addAnnotation
		  (auditedEClass, 
		   source, 
		   new String[] {
			 "appinfo", "@Embeddable"
		   });				
		addAnnotation
		  (versionedEClass, 
		   source, 
		   new String[] {
			 "appinfo", "@MappedSuperclass"
		   });			
		addAnnotation
		  (contactableEClass, 
		   source, 
		   new String[] {
			 "appinfo", "@MappedSuperclass"
		   });				
		addAnnotation
		  (getPerson_Location(), 
		   source, 
		   new String[] {
			 "appinfo", "@OneToOne"
		   });			
		addAnnotation
		  (getPerson_NationalId(), 
		   source, 
		   new String[] {
			 "appinfo", "@Column(unique=true)\n"
		   });			
		addAnnotation
		  (companyEClass, 
		   source, 
		   new String[] {
			 "appinfo", "@MappedSuperclass"
		   });			
		addAnnotation
		  (descriptiveLocationEClass, 
		   source, 
		   new String[] {
			 "appinfo", "@Embeddable"
		   });				
		addAnnotation
		  (getLocation_PostalLocation(), 
		   source, 
		   new String[] {
			 "appinfo", "@Embedded"
		   });			
		addAnnotation
		  (getLocation_MapLocation(), 
		   source, 
		   new String[] {
			 "appinfo", "@Embedded"
		   });			
		addAnnotation
		  (getLocation_StatutoryLocation(), 
		   source, 
		   new String[] {
			 "appinfo", "@Embedded"
		   });			
		addAnnotation
		  (getLocation_DescriptiveLocation(), 
		   source, 
		   new String[] {
			 "appinfo", "@Embedded"
		   });			
		addAnnotation
		  (getImageEntry_ImageData(), 
		   source, 
		   new String[] {
			 "appinfo", "@Lob\n@Column(length=1048576)"
		   });		
		addAnnotation
		  (getSystemUser_Username(), 
		   source, 
		   new String[] {
			 "appinfo", "@Column(unique=\"true\")"
		   });		
		addAnnotation
		  (getSystemUser_Password(), 
		   source, 
		   new String[] {
			 "appinfo", "@Column(length=64)"
		   });		
		addAnnotation
		  (getRole_Name(), 
		   source, 
		   new String[] {
			 "appinfo", "@Column(unique=\"true\")"
		   });		
		addAnnotation
		  (getPermissionNamespace_Name(), 
		   source, 
		   new String[] {
			 "appinfo", "@Column(unique=\"true\")"
		   });
	}

} //ModelPackageImpl
