/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;

import com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl;

import com.agritrace.edairy.desktop.common.model.dairy.Asset;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFunction;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.Trip;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;

import com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl;

import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;

import com.agritrace.edairy.desktop.common.model.requests.impl.RequestsPackageImpl;

import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;

import com.agritrace.edairy.desktop.common.model.tracking.impl.TrackingPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DairyPackageImpl extends EPackageImpl implements DairyPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vehicleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionJournalLineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass employeeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dairyLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionJournalPageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass routeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tripEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deliveryJournalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deliveryJournalLineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dairyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass membershipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dairyContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass supplierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum membershipStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sessionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum vendorStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dairyFunctionEEnum = null;

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DairyPackageImpl() {
		super(eNS_URI, DairyFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DairyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DairyPackage init() {
		if (isInited) return (DairyPackage)EPackage.Registry.INSTANCE.getEPackage(DairyPackage.eNS_URI);

		// Obtain or create and register package
		DairyPackageImpl theDairyPackage = (DairyPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DairyPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DairyPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AccountPackageImpl theAccountPackage = (AccountPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AccountPackage.eNS_URI) instanceof AccountPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AccountPackage.eNS_URI) : AccountPackage.eINSTANCE);
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		TrackingPackageImpl theTrackingPackage = (TrackingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TrackingPackage.eNS_URI) instanceof TrackingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TrackingPackage.eNS_URI) : TrackingPackage.eINSTANCE);
		RequestsPackageImpl theRequestsPackage = (RequestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RequestsPackage.eNS_URI) instanceof RequestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RequestsPackage.eNS_URI) : RequestsPackage.eINSTANCE);

		// Create package meta-data objects
		theDairyPackage.createPackageContents();
		theAccountPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theTrackingPackage.createPackageContents();
		theRequestsPackage.createPackageContents();

		// Initialize created meta-data
		theDairyPackage.initializePackageContents();
		theAccountPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theTrackingPackage.initializePackageContents();
		theRequestsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDairyPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DairyPackage.eNS_URI, theDairyPackage);
		return theDairyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVehicle() {
		return vehicleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_VehicleId() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_RegistrationNumber() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Type() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Make() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Model() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_EngineNumber() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_ChassisNumber() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_LogBookNumber() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_InsurancePolicyNumber() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_InsuranceExpirationDate() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_DominantColour() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_CapacityInTonnes() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Year() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVehicle_Driver() {
		return (EReference)vehicleEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVehicle_AssetInfo() {
		return (EReference)vehicleEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionJournalLine() {
		return collectionJournalLineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalLine_LineNumber() {
		return (EAttribute)collectionJournalLineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalLine_RecordedMember() {
		return (EAttribute)collectionJournalLineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalLine_Quantity() {
		return (EAttribute)collectionJournalLineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalLine_Flagged() {
		return (EAttribute)collectionJournalLineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalLine_UnitOfMeasure() {
		return (EAttribute)collectionJournalLineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalLine_NotRecorded() {
		return (EAttribute)collectionJournalLineEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournalLine_ValidatedMember() {
		return (EReference)collectionJournalLineEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalLine_OffRoute() {
		return (EAttribute)collectionJournalLineEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournalLine_From() {
		return (EReference)collectionJournalLineEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournalLine_FarmContainer() {
		return (EReference)collectionJournalLineEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournalLine_DairyContainer() {
		return (EReference)collectionJournalLineEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournalLine_CollectionJournal() {
		return (EReference)collectionJournalLineEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalLine_Rejected() {
		return (EAttribute)collectionJournalLineEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmployee() {
		return employeeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmployee_Id() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmployee_StartDate() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmployee_JobFunction() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmployee_NationalId() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmployee_NhifNumber() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmployee_NssfNumber() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDairyLocation() {
		return dairyLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairyLocation_Id() {
		return (EAttribute)dairyLocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairyLocation_Name() {
		return (EAttribute)dairyLocationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairyLocation_DateOpened() {
		return (EAttribute)dairyLocationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairyLocation_Phone() {
		return (EAttribute)dairyLocationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairyLocation_Route() {
		return (EReference)dairyLocationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairyLocation_Description() {
		return (EAttribute)dairyLocationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairyLocation_Code() {
		return (EAttribute)dairyLocationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairyLocation_Location() {
		return (EReference)dairyLocationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairyLocation_Functions() {
		return (EAttribute)dairyLocationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionJournalPage() {
		return collectionJournalPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalPage_JournalId() {
		return (EAttribute)collectionJournalPageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournalPage_JournalEntries() {
		return (EReference)collectionJournalPageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalPage_ReferenceNumber() {
		return (EAttribute)collectionJournalPageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalPage_JournalDate() {
		return (EAttribute)collectionJournalPageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalPage_Session() {
		return (EAttribute)collectionJournalPageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournalPage_Driver() {
		return (EReference)collectionJournalPageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournalPage_Route() {
		return (EReference)collectionJournalPageEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournalPage_FarmContainer() {
		return (EReference)collectionJournalPageEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournalPage_Bin() {
		return (EReference)collectionJournalPageEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournalPage_Vehicle() {
		return (EReference)collectionJournalPageEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalPage_DriverTotal() {
		return (EAttribute)collectionJournalPageEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalPage_RecordTotal() {
		return (EAttribute)collectionJournalPageEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalPage_Suspended() {
		return (EAttribute)collectionJournalPageEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalPage_EntryCount() {
		return (EAttribute)collectionJournalPageEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalPage_SuspendedCount() {
		return (EAttribute)collectionJournalPageEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalPage_RejectedCount() {
		return (EAttribute)collectionJournalPageEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoute() {
		return routeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoute_Id() {
		return (EAttribute)routeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoute_Name() {
		return (EAttribute)routeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoute_Stops() {
		return (EReference)routeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoute_Code() {
		return (EAttribute)routeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoute_Description() {
		return (EAttribute)routeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrip() {
		return tripEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrip_Collections() {
		return (EReference)tripEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrip_Deliveries() {
		return (EReference)tripEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrip_Started() {
		return (EAttribute)tripEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrip_Ended() {
		return (EAttribute)tripEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrip_TripId() {
		return (EAttribute)tripEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeliveryJournal() {
		return deliveryJournalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeliveryJournal_ReferenceNumber() {
		return (EAttribute)deliveryJournalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeliveryJournal_Date() {
		return (EAttribute)deliveryJournalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeliveryJournal_Route() {
		return (EReference)deliveryJournalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeliveryJournal_Session() {
		return (EAttribute)deliveryJournalEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeliveryJournal_Customer() {
		return (EReference)deliveryJournalEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeliveryJournal_Driver() {
		return (EReference)deliveryJournalEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeliveryJournal_Vehicle() {
		return (EReference)deliveryJournalEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeliveryJournal_Lines() {
		return (EReference)deliveryJournalEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeliveryJournal_Total() {
		return (EAttribute)deliveryJournalEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeliveryJournalLine() {
		return deliveryJournalLineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeliveryJournalLine_LineNumber() {
		return (EAttribute)deliveryJournalLineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeliveryJournalLine_Description() {
		return (EAttribute)deliveryJournalLineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeliveryJournalLine_Bin() {
		return (EReference)deliveryJournalLineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeliveryJournalLine_Quantity() {
		return (EAttribute)deliveryJournalLineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDairy() {
		return dairyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_RegistrationNumber() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_NhifNumber() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_NssfNumber() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_FederalPin() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_LicenseEffectiveDate() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_LicenseExpirationDate() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Routes() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Vehicles() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Employees() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Memberships() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_BranchLocations() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_CollectionJournals() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Suppliers() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Customers() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_AnimalHealthRequests() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_DairyBins() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_ManagerName() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_EstablishedDate() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMembership() {
		return membershipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMembership_MemberId() {
		return (EAttribute)membershipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMembership_ApplicationDate() {
		return (EAttribute)membershipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMembership_EffectiveDate() {
		return (EAttribute)membershipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMembership_Status() {
		return (EAttribute)membershipEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMembership_DefaultRoute() {
		return (EReference)membershipEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMembership_Member() {
		return (EReference)membershipEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMembership_Account() {
		return (EReference)membershipEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAsset() {
		return assetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsset_TagType() {
		return (EAttribute)assetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsset_TagValue() {
		return (EAttribute)assetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsset_DateAcquired() {
		return (EAttribute)assetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsset_DamageDate() {
		return (EAttribute)assetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsset_DamageDescription() {
		return (EAttribute)assetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsset_DateDisposed() {
		return (EAttribute)assetEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsset_DisposalReason() {
		return (EAttribute)assetEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsset_DisposalWitness() {
		return (EAttribute)assetEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDairyContainer() {
		return dairyContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairyContainer_AssetInfo() {
		return (EReference)dairyContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSupplier() {
		return supplierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplier_Categories() {
		return (EAttribute)supplierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplier_PublicDescription() {
		return (EAttribute)supplierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplier_Status() {
		return (EAttribute)supplierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplier_RegistrationDate() {
		return (EAttribute)supplierEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplier_ExpirationDate() {
		return (EAttribute)supplierEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplier_Notes() {
		return (EAttribute)supplierEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplier_Rating() {
		return (EAttribute)supplierEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomer() {
		return customerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomer_CustomerType() {
		return (EAttribute)customerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomer_Status() {
		return (EAttribute)customerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMembershipStatus() {
		return membershipStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSession() {
		return sessionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVendorStatus() {
		return vendorStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDairyFunction() {
		return dairyFunctionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyFactory getDairyFactory() {
		return (DairyFactory)getEFactoryInstance();
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
		vehicleEClass = createEClass(VEHICLE);
		createEAttribute(vehicleEClass, VEHICLE__VEHICLE_ID);
		createEAttribute(vehicleEClass, VEHICLE__REGISTRATION_NUMBER);
		createEAttribute(vehicleEClass, VEHICLE__TYPE);
		createEAttribute(vehicleEClass, VEHICLE__MAKE);
		createEAttribute(vehicleEClass, VEHICLE__MODEL);
		createEAttribute(vehicleEClass, VEHICLE__ENGINE_NUMBER);
		createEAttribute(vehicleEClass, VEHICLE__CHASSIS_NUMBER);
		createEAttribute(vehicleEClass, VEHICLE__LOG_BOOK_NUMBER);
		createEAttribute(vehicleEClass, VEHICLE__INSURANCE_POLICY_NUMBER);
		createEAttribute(vehicleEClass, VEHICLE__INSURANCE_EXPIRATION_DATE);
		createEAttribute(vehicleEClass, VEHICLE__DOMINANT_COLOUR);
		createEAttribute(vehicleEClass, VEHICLE__CAPACITY_IN_TONNES);
		createEAttribute(vehicleEClass, VEHICLE__YEAR);
		createEReference(vehicleEClass, VEHICLE__DRIVER);
		createEReference(vehicleEClass, VEHICLE__ASSET_INFO);

		collectionJournalLineEClass = createEClass(COLLECTION_JOURNAL_LINE);
		createEAttribute(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__LINE_NUMBER);
		createEAttribute(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__RECORDED_MEMBER);
		createEAttribute(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__QUANTITY);
		createEAttribute(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__FLAGGED);
		createEAttribute(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__UNIT_OF_MEASURE);
		createEAttribute(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__NOT_RECORDED);
		createEReference(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__VALIDATED_MEMBER);
		createEAttribute(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__OFF_ROUTE);
		createEReference(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__FROM);
		createEReference(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__FARM_CONTAINER);
		createEReference(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__DAIRY_CONTAINER);
		createEReference(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__COLLECTION_JOURNAL);
		createEAttribute(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__REJECTED);

		employeeEClass = createEClass(EMPLOYEE);
		createEAttribute(employeeEClass, EMPLOYEE__ID);
		createEAttribute(employeeEClass, EMPLOYEE__START_DATE);
		createEAttribute(employeeEClass, EMPLOYEE__JOB_FUNCTION);
		createEAttribute(employeeEClass, EMPLOYEE__NATIONAL_ID);
		createEAttribute(employeeEClass, EMPLOYEE__NHIF_NUMBER);
		createEAttribute(employeeEClass, EMPLOYEE__NSSF_NUMBER);

		dairyLocationEClass = createEClass(DAIRY_LOCATION);
		createEAttribute(dairyLocationEClass, DAIRY_LOCATION__ID);
		createEAttribute(dairyLocationEClass, DAIRY_LOCATION__NAME);
		createEAttribute(dairyLocationEClass, DAIRY_LOCATION__DATE_OPENED);
		createEAttribute(dairyLocationEClass, DAIRY_LOCATION__PHONE);
		createEReference(dairyLocationEClass, DAIRY_LOCATION__ROUTE);
		createEAttribute(dairyLocationEClass, DAIRY_LOCATION__DESCRIPTION);
		createEAttribute(dairyLocationEClass, DAIRY_LOCATION__CODE);
		createEReference(dairyLocationEClass, DAIRY_LOCATION__LOCATION);
		createEAttribute(dairyLocationEClass, DAIRY_LOCATION__FUNCTIONS);

		collectionJournalPageEClass = createEClass(COLLECTION_JOURNAL_PAGE);
		createEAttribute(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__JOURNAL_ID);
		createEReference(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__JOURNAL_ENTRIES);
		createEAttribute(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__REFERENCE_NUMBER);
		createEAttribute(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__JOURNAL_DATE);
		createEAttribute(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__SESSION);
		createEReference(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__DRIVER);
		createEReference(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__ROUTE);
		createEReference(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__FARM_CONTAINER);
		createEReference(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__BIN);
		createEReference(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__VEHICLE);
		createEAttribute(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__DRIVER_TOTAL);
		createEAttribute(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__RECORD_TOTAL);
		createEAttribute(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__SUSPENDED);
		createEAttribute(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__ENTRY_COUNT);
		createEAttribute(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__SUSPENDED_COUNT);
		createEAttribute(collectionJournalPageEClass, COLLECTION_JOURNAL_PAGE__REJECTED_COUNT);

		routeEClass = createEClass(ROUTE);
		createEAttribute(routeEClass, ROUTE__ID);
		createEAttribute(routeEClass, ROUTE__NAME);
		createEReference(routeEClass, ROUTE__STOPS);
		createEAttribute(routeEClass, ROUTE__CODE);
		createEAttribute(routeEClass, ROUTE__DESCRIPTION);

		tripEClass = createEClass(TRIP);
		createEReference(tripEClass, TRIP__COLLECTIONS);
		createEReference(tripEClass, TRIP__DELIVERIES);
		createEAttribute(tripEClass, TRIP__STARTED);
		createEAttribute(tripEClass, TRIP__ENDED);
		createEAttribute(tripEClass, TRIP__TRIP_ID);

		deliveryJournalEClass = createEClass(DELIVERY_JOURNAL);
		createEAttribute(deliveryJournalEClass, DELIVERY_JOURNAL__REFERENCE_NUMBER);
		createEAttribute(deliveryJournalEClass, DELIVERY_JOURNAL__DATE);
		createEReference(deliveryJournalEClass, DELIVERY_JOURNAL__ROUTE);
		createEAttribute(deliveryJournalEClass, DELIVERY_JOURNAL__SESSION);
		createEReference(deliveryJournalEClass, DELIVERY_JOURNAL__CUSTOMER);
		createEReference(deliveryJournalEClass, DELIVERY_JOURNAL__DRIVER);
		createEReference(deliveryJournalEClass, DELIVERY_JOURNAL__VEHICLE);
		createEReference(deliveryJournalEClass, DELIVERY_JOURNAL__LINES);
		createEAttribute(deliveryJournalEClass, DELIVERY_JOURNAL__TOTAL);

		deliveryJournalLineEClass = createEClass(DELIVERY_JOURNAL_LINE);
		createEAttribute(deliveryJournalLineEClass, DELIVERY_JOURNAL_LINE__LINE_NUMBER);
		createEReference(deliveryJournalLineEClass, DELIVERY_JOURNAL_LINE__BIN);
		createEAttribute(deliveryJournalLineEClass, DELIVERY_JOURNAL_LINE__QUANTITY);
		createEAttribute(deliveryJournalLineEClass, DELIVERY_JOURNAL_LINE__DESCRIPTION);

		dairyEClass = createEClass(DAIRY);
		createEAttribute(dairyEClass, DAIRY__REGISTRATION_NUMBER);
		createEAttribute(dairyEClass, DAIRY__NHIF_NUMBER);
		createEAttribute(dairyEClass, DAIRY__NSSF_NUMBER);
		createEAttribute(dairyEClass, DAIRY__FEDERAL_PIN);
		createEAttribute(dairyEClass, DAIRY__LICENSE_EFFECTIVE_DATE);
		createEAttribute(dairyEClass, DAIRY__LICENSE_EXPIRATION_DATE);
		createEReference(dairyEClass, DAIRY__ROUTES);
		createEReference(dairyEClass, DAIRY__VEHICLES);
		createEReference(dairyEClass, DAIRY__EMPLOYEES);
		createEReference(dairyEClass, DAIRY__MEMBERSHIPS);
		createEReference(dairyEClass, DAIRY__BRANCH_LOCATIONS);
		createEReference(dairyEClass, DAIRY__COLLECTION_JOURNALS);
		createEReference(dairyEClass, DAIRY__SUPPLIERS);
		createEReference(dairyEClass, DAIRY__CUSTOMERS);
		createEReference(dairyEClass, DAIRY__ANIMAL_HEALTH_REQUESTS);
		createEReference(dairyEClass, DAIRY__DAIRY_BINS);
		createEAttribute(dairyEClass, DAIRY__MANAGER_NAME);
		createEAttribute(dairyEClass, DAIRY__ESTABLISHED_DATE);

		membershipEClass = createEClass(MEMBERSHIP);
		createEAttribute(membershipEClass, MEMBERSHIP__MEMBER_ID);
		createEAttribute(membershipEClass, MEMBERSHIP__APPLICATION_DATE);
		createEAttribute(membershipEClass, MEMBERSHIP__EFFECTIVE_DATE);
		createEAttribute(membershipEClass, MEMBERSHIP__STATUS);
		createEReference(membershipEClass, MEMBERSHIP__DEFAULT_ROUTE);
		createEReference(membershipEClass, MEMBERSHIP__MEMBER);
		createEReference(membershipEClass, MEMBERSHIP__ACCOUNT);

		assetEClass = createEClass(ASSET);
		createEAttribute(assetEClass, ASSET__TAG_TYPE);
		createEAttribute(assetEClass, ASSET__TAG_VALUE);
		createEAttribute(assetEClass, ASSET__DATE_ACQUIRED);
		createEAttribute(assetEClass, ASSET__DAMAGE_DATE);
		createEAttribute(assetEClass, ASSET__DAMAGE_DESCRIPTION);
		createEAttribute(assetEClass, ASSET__DATE_DISPOSED);
		createEAttribute(assetEClass, ASSET__DISPOSAL_REASON);
		createEAttribute(assetEClass, ASSET__DISPOSAL_WITNESS);

		dairyContainerEClass = createEClass(DAIRY_CONTAINER);
		createEReference(dairyContainerEClass, DAIRY_CONTAINER__ASSET_INFO);

		supplierEClass = createEClass(SUPPLIER);
		createEAttribute(supplierEClass, SUPPLIER__CATEGORIES);
		createEAttribute(supplierEClass, SUPPLIER__PUBLIC_DESCRIPTION);
		createEAttribute(supplierEClass, SUPPLIER__STATUS);
		createEAttribute(supplierEClass, SUPPLIER__REGISTRATION_DATE);
		createEAttribute(supplierEClass, SUPPLIER__EXPIRATION_DATE);
		createEAttribute(supplierEClass, SUPPLIER__NOTES);
		createEAttribute(supplierEClass, SUPPLIER__RATING);

		customerEClass = createEClass(CUSTOMER);
		createEAttribute(customerEClass, CUSTOMER__CUSTOMER_TYPE);
		createEAttribute(customerEClass, CUSTOMER__STATUS);

		// Create enums
		membershipStatusEEnum = createEEnum(MEMBERSHIP_STATUS);
		sessionEEnum = createEEnum(SESSION);
		vendorStatusEEnum = createEEnum(VENDOR_STATUS);
		dairyFunctionEEnum = createEEnum(DAIRY_FUNCTION);
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
		AccountPackage theAccountPackage = (AccountPackage)EPackage.Registry.INSTANCE.getEPackage(AccountPackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		TrackingPackage theTrackingPackage = (TrackingPackage)EPackage.Registry.INSTANCE.getEPackage(TrackingPackage.eNS_URI);
		RequestsPackage theRequestsPackage = (RequestsPackage)EPackage.Registry.INSTANCE.getEPackage(RequestsPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theAccountPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		employeeEClass.getESuperTypes().add(theModelPackage.getPerson());
		dairyEClass.getESuperTypes().add(theModelPackage.getCompany());
		dairyContainerEClass.getESuperTypes().add(theTrackingPackage.getContainer());
		supplierEClass.getESuperTypes().add(theModelPackage.getCompany());
		customerEClass.getESuperTypes().add(theModelPackage.getCompany());

		// Initialize classes and features; add operations and parameters
		initEClass(vehicleEClass, Vehicle.class, "Vehicle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVehicle_VehicleId(), theModelPackage.getUniqueID(), "vehicleId", null, 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_RegistrationNumber(), ecorePackage.getEString(), "registrationNumber", null, 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_Type(), ecorePackage.getEString(), "type", null, 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_Make(), ecorePackage.getEString(), "make", null, 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_Model(), ecorePackage.getEString(), "model", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_EngineNumber(), ecorePackage.getEString(), "engineNumber", null, 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_ChassisNumber(), ecorePackage.getEString(), "chassisNumber", null, 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_LogBookNumber(), ecorePackage.getEString(), "logBookNumber", null, 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_InsurancePolicyNumber(), ecorePackage.getEString(), "insurancePolicyNumber", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_InsuranceExpirationDate(), ecorePackage.getEDate(), "insuranceExpirationDate", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_DominantColour(), ecorePackage.getEString(), "dominantColour", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_CapacityInTonnes(), ecorePackage.getEDouble(), "capacityInTonnes", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_Year(), ecorePackage.getEIntegerObject(), "year", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVehicle_Driver(), this.getEmployee(), null, "driver", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVehicle_AssetInfo(), this.getAsset(), null, "assetInfo", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionJournalLineEClass, CollectionJournalLine.class, "CollectionJournalLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectionJournalLine_LineNumber(), ecorePackage.getEInt(), "lineNumber", null, 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalLine_RecordedMember(), ecorePackage.getEString(), "recordedMember", null, 1, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalLine_Quantity(), ecorePackage.getEBigDecimal(), "quantity", null, 1, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalLine_Flagged(), ecorePackage.getEBoolean(), "flagged", null, 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalLine_UnitOfMeasure(), theModelPackage.getUnitOfMeasure(), "unitOfMeasure", "KILOGRAMS", 1, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalLine_NotRecorded(), ecorePackage.getEBoolean(), "notRecorded", null, 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournalLine_ValidatedMember(), this.getMembership(), null, "validatedMember", null, 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalLine_OffRoute(), ecorePackage.getEBoolean(), "offRoute", null, 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournalLine_From(), theTrackingPackage.getFarm(), null, "from", null, 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournalLine_FarmContainer(), theTrackingPackage.getContainer(), null, "farmContainer", null, 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournalLine_DairyContainer(), this.getDairyContainer(), null, "dairyContainer", null, 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournalLine_CollectionJournal(), this.getCollectionJournalPage(), this.getCollectionJournalPage_JournalEntries(), "collectionJournal", null, 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalLine_Rejected(), ecorePackage.getEBoolean(), "rejected", null, 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(employeeEClass, Employee.class, "Employee", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEmployee_Id(), ecorePackage.getEString(), "id", null, 1, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmployee_StartDate(), ecorePackage.getEDate(), "startDate", null, 1, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmployee_JobFunction(), ecorePackage.getEString(), "jobFunction", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmployee_NationalId(), ecorePackage.getEString(), "nationalId", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEmployee_NhifNumber(), ecorePackage.getEString(), "nhifNumber", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmployee_NssfNumber(), ecorePackage.getEString(), "nssfNumber", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dairyLocationEClass, DairyLocation.class, "DairyLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDairyLocation_Id(), ecorePackage.getELong(), "Id", null, 0, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairyLocation_Name(), ecorePackage.getEString(), "name", null, 1, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairyLocation_DateOpened(), ecorePackage.getEDate(), "dateOpened", null, 0, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairyLocation_Phone(), ecorePackage.getEString(), "phone", null, 0, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairyLocation_Route(), this.getRoute(), this.getRoute_Stops(), "route", null, 0, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairyLocation_Description(), ecorePackage.getEString(), "description", null, 0, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairyLocation_Code(), ecorePackage.getEString(), "code", null, 0, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairyLocation_Location(), theModelPackage.getLocation(), null, "location", null, 1, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairyLocation_Functions(), this.getDairyFunction(), "functions", null, 0, -1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionJournalPageEClass, CollectionJournalPage.class, "CollectionJournalPage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectionJournalPage_JournalId(), theModelPackage.getUniqueID(), "journalId", null, 1, 1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournalPage_JournalEntries(), this.getCollectionJournalLine(), this.getCollectionJournalLine_CollectionJournal(), "journalEntries", null, 0, -1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalPage_ReferenceNumber(), ecorePackage.getEString(), "referenceNumber", null, 1, 1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalPage_JournalDate(), ecorePackage.getEDate(), "journalDate", null, 1, 1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalPage_Session(), this.getSession(), "session", "0", 1, 1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournalPage_Driver(), this.getEmployee(), null, "driver", null, 1, 1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournalPage_Route(), this.getRoute(), null, "route", null, 1, 1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournalPage_FarmContainer(), theTrackingPackage.getContainer(), null, "farmContainer", null, 0, 1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournalPage_Bin(), this.getDairyContainer(), null, "bin", null, 0, 1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournalPage_Vehicle(), this.getVehicle(), null, "vehicle", null, 0, 1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalPage_DriverTotal(), ecorePackage.getEBigDecimal(), "driverTotal", null, 0, 1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalPage_RecordTotal(), ecorePackage.getEBigDecimal(), "recordTotal", "0", 0, 1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalPage_Suspended(), ecorePackage.getEBoolean(), "suspended", "false", 0, 1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalPage_EntryCount(), ecorePackage.getEInt(), "entryCount", "0", 0, 1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalPage_SuspendedCount(), ecorePackage.getEInt(), "suspendedCount", "0", 0, 1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalPage_RejectedCount(), ecorePackage.getEInt(), "rejectedCount", "0", 0, 1, CollectionJournalPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(routeEClass, Route.class, "Route", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoute_Id(), ecorePackage.getELong(), "Id", null, 0, 1, Route.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoute_Name(), ecorePackage.getEString(), "name", null, 0, 1, Route.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoute_Stops(), this.getDairyLocation(), this.getDairyLocation_Route(), "stops", null, 0, -1, Route.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoute_Code(), ecorePackage.getEString(), "code", null, 0, 1, Route.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoute_Description(), ecorePackage.getEString(), "description", null, 0, 1, Route.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tripEClass, Trip.class, "Trip", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrip_Collections(), this.getCollectionJournalPage(), null, "collections", null, 1, -1, Trip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrip_Deliveries(), this.getDeliveryJournal(), null, "deliveries", null, 1, -1, Trip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrip_Started(), ecorePackage.getEDate(), "started", null, 1, 1, Trip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrip_Ended(), ecorePackage.getEDate(), "ended", null, 1, 1, Trip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrip_TripId(), ecorePackage.getELong(), "tripId", null, 1, 1, Trip.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deliveryJournalEClass, DeliveryJournal.class, "DeliveryJournal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeliveryJournal_ReferenceNumber(), ecorePackage.getEString(), "referenceNumber", null, 0, 1, DeliveryJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeliveryJournal_Date(), ecorePackage.getEDate(), "date", null, 1, 1, DeliveryJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeliveryJournal_Route(), this.getRoute(), null, "route", null, 1, 1, DeliveryJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeliveryJournal_Session(), this.getSession(), "session", null, 1, 1, DeliveryJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeliveryJournal_Customer(), this.getCustomer(), null, "customer", null, 1, 1, DeliveryJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeliveryJournal_Driver(), this.getEmployee(), null, "driver", null, 0, 1, DeliveryJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeliveryJournal_Vehicle(), this.getVehicle(), null, "vehicle", null, 0, 1, DeliveryJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeliveryJournal_Lines(), this.getCollectionJournalLine(), null, "lines", null, 1, -1, DeliveryJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeliveryJournal_Total(), ecorePackage.getEBigDecimal(), "total", null, 0, 1, DeliveryJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deliveryJournalLineEClass, DeliveryJournalLine.class, "DeliveryJournalLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeliveryJournalLine_LineNumber(), ecorePackage.getEInt(), "lineNumber", null, 1, 1, DeliveryJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeliveryJournalLine_Bin(), this.getDairyContainer(), null, "bin", null, 0, 1, DeliveryJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeliveryJournalLine_Quantity(), ecorePackage.getEBigDecimal(), "quantity", null, 1, 1, DeliveryJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeliveryJournalLine_Description(), ecorePackage.getEString(), "description", null, 1, 1, DeliveryJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dairyEClass, Dairy.class, "Dairy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDairy_RegistrationNumber(), ecorePackage.getEString(), "registrationNumber", null, 1, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_NhifNumber(), ecorePackage.getEString(), "nhifNumber", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_NssfNumber(), ecorePackage.getEString(), "nssfNumber", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_FederalPin(), ecorePackage.getEString(), "federalPin", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_LicenseEffectiveDate(), ecorePackage.getEDate(), "licenseEffectiveDate", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_LicenseExpirationDate(), ecorePackage.getEDate(), "licenseExpirationDate", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_Routes(), this.getRoute(), null, "routes", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_Vehicles(), this.getVehicle(), null, "vehicles", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_Employees(), this.getEmployee(), null, "employees", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_Memberships(), this.getMembership(), null, "memberships", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_BranchLocations(), this.getDairyLocation(), null, "branchLocations", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_CollectionJournals(), this.getCollectionJournalPage(), null, "collectionJournals", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_Suppliers(), this.getSupplier(), null, "suppliers", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDairy_Customers(), this.getCustomer(), null, "customers", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_AnimalHealthRequests(), theRequestsPackage.getAnimalHealthRequest(), theRequestsPackage.getAnimalHealthRequest_Dairy(), "animalHealthRequests", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getDairy_AnimalHealthRequests().getEKeys().add(theRequestsPackage.getAnimalHealthRequest_RequestId());
		initEReference(getDairy_DairyBins(), this.getDairyContainer(), null, "dairyBins", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_ManagerName(), ecorePackage.getEString(), "managerName", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_EstablishedDate(), ecorePackage.getEDate(), "establishedDate", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(dairyEClass, null, "getMemberFarms", 1, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType(theTrackingPackage.getFarm());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(membershipEClass, Membership.class, "Membership", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMembership_MemberId(), theModelPackage.getUniqueID(), "memberId", null, 1, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMembership_ApplicationDate(), ecorePackage.getEDate(), "applicationDate", null, 1, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMembership_EffectiveDate(), ecorePackage.getEDate(), "effectiveDate", null, 0, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMembership_Status(), this.getMembershipStatus(), "status", null, 1, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMembership_DefaultRoute(), this.getRoute(), null, "defaultRoute", null, 0, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMembership_Member(), theTrackingPackage.getFarmer(), null, "member", null, 1, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getMembership_Member().getEKeys().add(theModelPackage.getPerson_PersonId());
		initEReference(getMembership_Account(), theAccountPackage.getAccount(), theAccountPackage.getAccount_Member(), "account", null, 0, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assetEClass, Asset.class, "Asset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAsset_TagType(), ecorePackage.getEString(), "tagType", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsset_TagValue(), ecorePackage.getEString(), "tagValue", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsset_DateAcquired(), ecorePackage.getEDate(), "dateAcquired", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsset_DamageDate(), ecorePackage.getEDate(), "damageDate", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsset_DamageDescription(), ecorePackage.getEString(), "damageDescription", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsset_DateDisposed(), ecorePackage.getEDate(), "dateDisposed", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsset_DisposalReason(), ecorePackage.getEString(), "disposalReason", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsset_DisposalWitness(), ecorePackage.getEString(), "disposalWitness", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dairyContainerEClass, DairyContainer.class, "DairyContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDairyContainer_AssetInfo(), this.getAsset(), null, "assetInfo", null, 0, 1, DairyContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getDairyContainer_AssetInfo().getEKeys().add(this.getAsset_TagValue());

		initEClass(supplierEClass, Supplier.class, "Supplier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSupplier_Categories(), ecorePackage.getEString(), "categories", null, 0, -1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupplier_PublicDescription(), ecorePackage.getEString(), "publicDescription", null, 1, 1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupplier_Status(), this.getVendorStatus(), "status", null, 1, 1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupplier_RegistrationDate(), ecorePackage.getEDate(), "registrationDate", null, 1, 1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupplier_ExpirationDate(), ecorePackage.getEDate(), "expirationDate", null, 0, 1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupplier_Notes(), ecorePackage.getEString(), "notes", null, 0, 1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupplier_Rating(), ecorePackage.getEInt(), "rating", null, 0, 1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customerEClass, Customer.class, "Customer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomer_CustomerType(), ecorePackage.getEString(), "customerType", "Milk Processor", 0, 1, Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomer_Status(), ecorePackage.getEString(), "status", "Active", 0, 1, Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(membershipStatusEEnum, MembershipStatus.class, "MembershipStatus");
		addEEnumLiteral(membershipStatusEEnum, MembershipStatus.ACTIVE);
		addEEnumLiteral(membershipStatusEEnum, MembershipStatus.INACTIVE);
		addEEnumLiteral(membershipStatusEEnum, MembershipStatus.DORMANT);

		initEEnum(sessionEEnum, Session.class, "Session");
		addEEnumLiteral(sessionEEnum, Session.EARLY_MORNING);
		addEEnumLiteral(sessionEEnum, Session.MORNING);
		addEEnumLiteral(sessionEEnum, Session.EARLY_AFTERNOON);
		addEEnumLiteral(sessionEEnum, Session.AFTERNOON);
		addEEnumLiteral(sessionEEnum, Session.EVENING1);
		addEEnumLiteral(sessionEEnum, Session.EVENING2);

		initEEnum(vendorStatusEEnum, VendorStatus.class, "VendorStatus");
		addEEnumLiteral(vendorStatusEEnum, VendorStatus.PENDING);
		addEEnumLiteral(vendorStatusEEnum, VendorStatus.VALID);
		addEEnumLiteral(vendorStatusEEnum, VendorStatus.INVALID);
		addEEnumLiteral(vendorStatusEEnum, VendorStatus.SUSPENDED);
		addEEnumLiteral(vendorStatusEEnum, VendorStatus.OTHER);

		initEEnum(dairyFunctionEEnum, DairyFunction.class, "DairyFunction");
		addEEnumLiteral(dairyFunctionEEnum, DairyFunction.MILK_COLLECTION);
		addEEnumLiteral(dairyFunctionEEnum, DairyFunction.MILK_STORAGE);
		addEEnumLiteral(dairyFunctionEEnum, DairyFunction.STORE_SALES);
		addEEnumLiteral(dairyFunctionEEnum, DairyFunction.WAREHOUSE);
		addEEnumLiteral(dairyFunctionEEnum, DairyFunction.MILK_PROCESSING);

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
		  (getVehicle_AssetInfo(), 
		   source, 
		   new String[] {
			 "name", "assetInfo",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getEmployee_Id(), 
		   source, 
		   new String[] {
			 "name", "id",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDairyLocation_Id(), 
		   source, 
		   new String[] {
			 "name", "Id",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getRoute_Id(), 
		   source, 
		   new String[] {
			 "name", "Id",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getTrip_TripId(), 
		   source, 
		   new String[] {
			 "name", "tripId",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getMembership_MemberId(), 
		   source, 
		   new String[] {
			 "name", "memberId",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (assetEClass, 
		   source, 
		   new String[] {
			 "name", "Asset",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getDairyContainer_AssetInfo(), 
		   source, 
		   new String[] {
			 "name", "assetInfo",
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
		  (getVehicle_AssetInfo(), 
		   source, 
		   new String[] {
			 "appinfo", "@Embedded"
		   });				
		addAnnotation
		  (getDairyLocation_Id(), 
		   source, 
		   new String[] {
			 "appinfo", "@Id\n@GeneratedValue"
		   });			
		addAnnotation
		  (getRoute_Id(), 
		   source, 
		   new String[] {
			 "appinfo", "@Id\n@GeneratedValue"
		   });			
		addAnnotation
		  (getTrip_TripId(), 
		   source, 
		   new String[] {
			 "appinfo", "@Id\n@GeneratedValue"
		   });				
		addAnnotation
		  (assetEClass, 
		   source, 
		   new String[] {
			 "appinfo", "@Embeddable"
		   });			
		addAnnotation
		  (getDairyContainer_AssetInfo(), 
		   source, 
		   new String[] {
			 "appinfo", "@Embedded"
		   });
	}

} //DairyPackageImpl
