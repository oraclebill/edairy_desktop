/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.impl.ModelPackageImpl;
import com.agritrace.edairy.desktop.common.model.dairy.Asset;
import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroupType;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFunction;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.model.dairy.MemberPayment;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;
import com.agritrace.edairy.desktop.common.model.dairy.MilkGrade;
import com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange;
import com.agritrace.edairy.desktop.common.model.dairy.MilkSale;
import com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup;
import com.agritrace.edairy.desktop.common.model.dairy.MilkSaleType;
import com.agritrace.edairy.desktop.common.model.dairy.Preference;
import com.agritrace.edairy.desktop.common.model.dairy.PreferenceKey;
import com.agritrace.edairy.desktop.common.model.dairy.PreferenceType;
import com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.TransportRoute;
import com.agritrace.edairy.desktop.common.model.dairy.Trip;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.model.requests.impl.RequestsPackageImpl;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.model.tracking.impl.TrackingPackageImpl;

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
	private EClass scaleImportRecordEClass = null;

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
	private EClass collectionGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transportRouteEClass = null;

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
	private EClass milkSaleGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass milkGradeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass milkGradeChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass milkSaleEClass = null;

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
	private EClass binEClass = null;

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
	private EClass memberPaymentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preferenceKeyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionSessionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum journalStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum milkSaleTypeEEnum = null;

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
	private EEnum vendorStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dairyFunctionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum preferenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum collectionGroupTypeEEnum = null;

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
	public EReference getCollectionJournalLine_Bin() {
		return (EReference)collectionJournalLineEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournalLine_Group() {
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
	public EAttribute getCollectionJournalLine_RejectionReason() {
		return (EAttribute)collectionJournalLineEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalLine_MilkFatPercentage() {
		return (EAttribute)collectionJournalLineEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalLine_AlcoholPercentage() {
		return (EAttribute)collectionJournalLineEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournalLine_WaterAdded() {
		return (EAttribute)collectionJournalLineEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScaleImportRecord() {
		return scaleImportRecordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScaleImportRecord_ScaleSerial() {
		return (EAttribute)scaleImportRecordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScaleImportRecord_CollectionTime() {
		return (EAttribute)scaleImportRecordEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScaleImportRecord_CenterNumber() {
		return (EAttribute)scaleImportRecordEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScaleImportRecord_NumCans() {
		return (EAttribute)scaleImportRecordEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScaleImportRecord_TripNumber() {
		return (EAttribute)scaleImportRecordEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScaleImportRecord_OperatorCode() {
		return (EAttribute)scaleImportRecordEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScaleImportRecord_Validated() {
		return (EAttribute)scaleImportRecordEClass.getEStructuralFeatures().get(6);
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
	public EAttribute getEmployee_EmployeeNumber() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmployee_OperatorCode() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmployee_StartDate() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmployee_JobFunction() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmployee_Department() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmployee_LicenseNo() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEmployee_Employer() {
		return (EReference)employeeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEmployee_SystemIdentity() {
		return (EReference)employeeEClass.getEStructuralFeatures().get(7);
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
	public EReference getDairyLocation_Containers() {
		return (EReference)dairyLocationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionGroup() {
		return collectionGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionGroup_Id()
	{
		return (EAttribute)collectionGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionGroup_ReferenceNumber() {
		return (EAttribute)collectionGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionGroup_CollectionDate()
	{
		return (EAttribute)collectionGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionGroup_Status() {
		return (EAttribute)collectionGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionGroup_Driver() {
		return (EReference)collectionGroupEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionGroup_Vehicle() {
		return (EReference)collectionGroupEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionGroup_DriverTotal() {
		return (EAttribute)collectionGroupEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionGroup_RecordTotal() {
		return (EAttribute)collectionGroupEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionGroup_Entries()
	{
		return (EReference)collectionGroupEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionGroup_Suspended() {
		return (EAttribute)collectionGroupEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionGroup_EntryCount() {
		return (EAttribute)collectionGroupEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionGroup_SuspendedCount() {
		return (EAttribute)collectionGroupEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionGroup_RejectedCount() {
		return (EAttribute)collectionGroupEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionGroup_JournalNumber() {
		return (EAttribute)collectionGroupEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionGroup_Session() {
		return (EReference)collectionGroupEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionGroup_CollectionCenter() {
		return (EReference)collectionGroupEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionGroup_Type() {
		return (EAttribute)collectionGroupEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransportRoute() {
		return transportRouteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransportRoute_Id() {
		return (EAttribute)transportRouteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransportRoute_Name() {
		return (EAttribute)transportRouteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransportRoute_Stops() {
		return (EReference)transportRouteEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransportRoute_Bins() {
		return (EReference)transportRouteEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransportRoute_Description() {
		return (EAttribute)transportRouteEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransportRoute_Vehicle() {
		return (EReference)transportRouteEClass.getEStructuralFeatures().get(3);
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
	public EClass getMilkSaleGroup()
	{
		return milkSaleGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkSaleGroup_ReferenceNumber()
	{
		return (EAttribute)milkSaleGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkSaleGroup_Date()
	{
		return (EAttribute)milkSaleGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkSaleGroup_Route()
	{
		return (EReference)milkSaleGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkSaleGroup_Customer()
	{
		return (EReference)milkSaleGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkSaleGroup_Driver()
	{
		return (EReference)milkSaleGroupEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkSaleGroup_Vehicle()
	{
		return (EReference)milkSaleGroupEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkSaleGroup_Sales()
	{
		return (EReference)milkSaleGroupEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkSaleGroup_Total()
	{
		return (EAttribute)milkSaleGroupEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkSaleGroup_Session()
	{
		return (EReference)milkSaleGroupEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkSaleGroup_Id()
	{
		return (EAttribute)milkSaleGroupEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMilkGrade() {
		return milkGradeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkGrade_Code() {
		return (EAttribute)milkGradeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkGrade_Name() {
		return (EAttribute)milkGradeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkGrade_Description() {
		return (EAttribute)milkGradeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMilkGradeChange() {
		return milkGradeChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkGradeChange_Date() {
		return (EAttribute)milkGradeChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkGradeChange_StartingGrade() {
		return (EReference)milkGradeChangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkGradeChange_EndingGrade() {
		return (EReference)milkGradeChangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkGradeChange_ChangedBy() {
		return (EReference)milkGradeChangeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkGradeChange_Reason() {
		return (EAttribute)milkGradeChangeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMilkSale() {
		return milkSaleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkSale_Id() {
		return (EAttribute)milkSaleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkSale_LineNumber() {
		return (EAttribute)milkSaleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkSale_ReferenceNumber() {
		return (EAttribute)milkSaleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkSale_SaleDate() {
		return (EAttribute)milkSaleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkSale_Session()
	{
		return (EReference)milkSaleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkSale_Bin() {
		return (EReference)milkSaleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkSale_SaleType() {
		return (EAttribute)milkSaleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkSale_Quantity() {
		return (EAttribute)milkSaleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkSale_Grade() {
		return (EReference)milkSaleEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkSale_UnitPrice() {
		return (EAttribute)milkSaleEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkSale_Description() {
		return (EAttribute)milkSaleEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkSale_Rejected() {
		return (EAttribute)milkSaleEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkSale_StoreOrRoute() {
		return (EReference)milkSaleEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkSale_Customer() {
		return (EReference)milkSaleEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkSale_SoldBy() {
		return (EReference)milkSaleEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkSale_SaleAmount() {
		return (EAttribute)milkSaleEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMilkSale_ContractSale() {
		return (EAttribute)milkSaleEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMilkSale_SalesClerk() {
		return (EReference)milkSaleEClass.getEStructuralFeatures().get(17);
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
	public EAttribute getDairy_EstablishedDate() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_ManagerName() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_NssfNumber() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_NhifNumber() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_FederalPin() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_LicenseEffectiveDate() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_LicenseExpirationDate() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Routes() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Vehicles() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Employees() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Memberships() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_BranchLocations() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_CollectionJournals() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_DeliveryJournals() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Suppliers() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Customers() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_AnimalHealthRequests() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_DairyBins() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_PriceHistory() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_Version() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_CollectionSessions() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(21);
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
	public EAttribute getMembership_MemberNumber() {
		return (EAttribute)membershipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMembership_ApplicationDate() {
		return (EAttribute)membershipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMembership_EffectiveDate() {
		return (EAttribute)membershipEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMembership_Status() {
		return (EAttribute)membershipEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMembership_DefaultRoute() {
		return (EReference)membershipEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMembership_Farmer() {
		return (EReference)membershipEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMembership_Account() {
		return (EReference)membershipEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMembership_Dairy() {
		return (EReference)membershipEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMembership_MaziwaCardNumber() {
		return (EAttribute)membershipEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMembership_MaziwaCardIssueDate() {
		return (EAttribute)membershipEClass.getEStructuralFeatures().get(10);
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
	public EClass getBin() {
		return binEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBin_Status() {
		return (EAttribute)binEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBin_Zone() {
		return (EReference)binEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBin_AssetInfo() {
		return (EReference)binEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getSupplier_Id() {
		return (EAttribute)supplierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplier_PublicDescription() {
		return (EAttribute)supplierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplier_Status() {
		return (EAttribute)supplierEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplier_RegistrationDate() {
		return (EAttribute)supplierEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplier_ExpirationDate() {
		return (EAttribute)supplierEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplier_Notes() {
		return (EAttribute)supplierEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplier_Rating() {
		return (EAttribute)supplierEClass.getEStructuralFeatures().get(7);
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
	public EAttribute getCustomer_CustomerNumber() {
		return (EAttribute)customerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomer_CustomerType() {
		return (EAttribute)customerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomer_Status() {
		return (EAttribute)customerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemberPayment() {
		return memberPaymentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemberPayment_Id() {
		return (EAttribute)memberPaymentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemberPayment_Year() {
		return (EAttribute)memberPaymentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemberPayment_Month() {
		return (EAttribute)memberPaymentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemberPayment_PaymentRate() {
		return (EAttribute)memberPaymentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemberPayment_PaymentsTotal() {
		return (EAttribute)memberPaymentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemberPayment_PaymentsCount() {
		return (EAttribute)memberPaymentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemberPayment_EnteredBy() {
		return (EReference)memberPaymentEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemberPayment_EntryDate() {
		return (EAttribute)memberPaymentEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreference() {
		return preferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreference_Id() {
		return (EAttribute)preferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreference_Key() {
		return (EReference)preferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreference_Value() {
		return (EAttribute)preferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreferenceKey() {
		return preferenceKeyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferenceKey_Id() {
		return (EAttribute)preferenceKeyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferenceKey_Name() {
		return (EAttribute)preferenceKeyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferenceKey_DefaultValue() {
		return (EAttribute)preferenceKeyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferenceKey_Type() {
		return (EAttribute)preferenceKeyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionSession() {
		return collectionSessionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionSession_Id() {
		return (EAttribute)collectionSessionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionSession_Code() {
		return (EAttribute)collectionSessionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionSession_Description() {
		return (EAttribute)collectionSessionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionSession_TimeOfDay() {
		return (EAttribute)collectionSessionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionSession_Dairy() {
		return (EReference)collectionSessionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJournalStatus() {
		return journalStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMilkSaleType() {
		return milkSaleTypeEEnum;
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
	public EEnum getPreferenceType() {
		return preferenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCollectionGroupType() {
		return collectionGroupTypeEEnum;
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
		createEReference(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__BIN);
		createEReference(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__GROUP);
		createEAttribute(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__REJECTED);
		createEAttribute(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__REJECTION_REASON);
		createEAttribute(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__MILK_FAT_PERCENTAGE);
		createEAttribute(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__ALCOHOL_PERCENTAGE);
		createEAttribute(collectionJournalLineEClass, COLLECTION_JOURNAL_LINE__WATER_ADDED);

		scaleImportRecordEClass = createEClass(SCALE_IMPORT_RECORD);
		createEAttribute(scaleImportRecordEClass, SCALE_IMPORT_RECORD__SCALE_SERIAL);
		createEAttribute(scaleImportRecordEClass, SCALE_IMPORT_RECORD__COLLECTION_TIME);
		createEAttribute(scaleImportRecordEClass, SCALE_IMPORT_RECORD__CENTER_NUMBER);
		createEAttribute(scaleImportRecordEClass, SCALE_IMPORT_RECORD__NUM_CANS);
		createEAttribute(scaleImportRecordEClass, SCALE_IMPORT_RECORD__TRIP_NUMBER);
		createEAttribute(scaleImportRecordEClass, SCALE_IMPORT_RECORD__OPERATOR_CODE);
		createEAttribute(scaleImportRecordEClass, SCALE_IMPORT_RECORD__VALIDATED);

		employeeEClass = createEClass(EMPLOYEE);
		createEAttribute(employeeEClass, EMPLOYEE__EMPLOYEE_NUMBER);
		createEAttribute(employeeEClass, EMPLOYEE__OPERATOR_CODE);
		createEAttribute(employeeEClass, EMPLOYEE__START_DATE);
		createEAttribute(employeeEClass, EMPLOYEE__JOB_FUNCTION);
		createEAttribute(employeeEClass, EMPLOYEE__DEPARTMENT);
		createEAttribute(employeeEClass, EMPLOYEE__LICENSE_NO);
		createEReference(employeeEClass, EMPLOYEE__EMPLOYER);
		createEReference(employeeEClass, EMPLOYEE__SYSTEM_IDENTITY);

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
		createEReference(dairyLocationEClass, DAIRY_LOCATION__CONTAINERS);

		collectionGroupEClass = createEClass(COLLECTION_GROUP);
		createEAttribute(collectionGroupEClass, COLLECTION_GROUP__ID);
		createEAttribute(collectionGroupEClass, COLLECTION_GROUP__REFERENCE_NUMBER);
		createEAttribute(collectionGroupEClass, COLLECTION_GROUP__COLLECTION_DATE);
		createEAttribute(collectionGroupEClass, COLLECTION_GROUP__STATUS);
		createEReference(collectionGroupEClass, COLLECTION_GROUP__DRIVER);
		createEReference(collectionGroupEClass, COLLECTION_GROUP__VEHICLE);
		createEAttribute(collectionGroupEClass, COLLECTION_GROUP__DRIVER_TOTAL);
		createEAttribute(collectionGroupEClass, COLLECTION_GROUP__RECORD_TOTAL);
		createEReference(collectionGroupEClass, COLLECTION_GROUP__ENTRIES);
		createEAttribute(collectionGroupEClass, COLLECTION_GROUP__SUSPENDED);
		createEAttribute(collectionGroupEClass, COLLECTION_GROUP__ENTRY_COUNT);
		createEAttribute(collectionGroupEClass, COLLECTION_GROUP__SUSPENDED_COUNT);
		createEAttribute(collectionGroupEClass, COLLECTION_GROUP__REJECTED_COUNT);
		createEAttribute(collectionGroupEClass, COLLECTION_GROUP__JOURNAL_NUMBER);
		createEReference(collectionGroupEClass, COLLECTION_GROUP__SESSION);
		createEReference(collectionGroupEClass, COLLECTION_GROUP__COLLECTION_CENTER);
		createEAttribute(collectionGroupEClass, COLLECTION_GROUP__TYPE);

		transportRouteEClass = createEClass(TRANSPORT_ROUTE);
		createEAttribute(transportRouteEClass, TRANSPORT_ROUTE__ID);
		createEAttribute(transportRouteEClass, TRANSPORT_ROUTE__NAME);
		createEAttribute(transportRouteEClass, TRANSPORT_ROUTE__DESCRIPTION);
		createEReference(transportRouteEClass, TRANSPORT_ROUTE__VEHICLE);
		createEReference(transportRouteEClass, TRANSPORT_ROUTE__STOPS);
		createEReference(transportRouteEClass, TRANSPORT_ROUTE__BINS);

		tripEClass = createEClass(TRIP);
		createEReference(tripEClass, TRIP__COLLECTIONS);
		createEReference(tripEClass, TRIP__DELIVERIES);
		createEAttribute(tripEClass, TRIP__STARTED);
		createEAttribute(tripEClass, TRIP__ENDED);
		createEAttribute(tripEClass, TRIP__TRIP_ID);

		milkSaleGroupEClass = createEClass(MILK_SALE_GROUP);
		createEAttribute(milkSaleGroupEClass, MILK_SALE_GROUP__REFERENCE_NUMBER);
		createEAttribute(milkSaleGroupEClass, MILK_SALE_GROUP__DATE);
		createEReference(milkSaleGroupEClass, MILK_SALE_GROUP__ROUTE);
		createEReference(milkSaleGroupEClass, MILK_SALE_GROUP__CUSTOMER);
		createEReference(milkSaleGroupEClass, MILK_SALE_GROUP__DRIVER);
		createEReference(milkSaleGroupEClass, MILK_SALE_GROUP__VEHICLE);
		createEReference(milkSaleGroupEClass, MILK_SALE_GROUP__SALES);
		createEAttribute(milkSaleGroupEClass, MILK_SALE_GROUP__TOTAL);
		createEReference(milkSaleGroupEClass, MILK_SALE_GROUP__SESSION);
		createEAttribute(milkSaleGroupEClass, MILK_SALE_GROUP__ID);

		milkGradeEClass = createEClass(MILK_GRADE);
		createEAttribute(milkGradeEClass, MILK_GRADE__CODE);
		createEAttribute(milkGradeEClass, MILK_GRADE__NAME);
		createEAttribute(milkGradeEClass, MILK_GRADE__DESCRIPTION);

		milkGradeChangeEClass = createEClass(MILK_GRADE_CHANGE);
		createEAttribute(milkGradeChangeEClass, MILK_GRADE_CHANGE__DATE);
		createEReference(milkGradeChangeEClass, MILK_GRADE_CHANGE__STARTING_GRADE);
		createEReference(milkGradeChangeEClass, MILK_GRADE_CHANGE__ENDING_GRADE);
		createEReference(milkGradeChangeEClass, MILK_GRADE_CHANGE__CHANGED_BY);
		createEAttribute(milkGradeChangeEClass, MILK_GRADE_CHANGE__REASON);

		milkSaleEClass = createEClass(MILK_SALE);
		createEAttribute(milkSaleEClass, MILK_SALE__ID);
		createEAttribute(milkSaleEClass, MILK_SALE__LINE_NUMBER);
		createEAttribute(milkSaleEClass, MILK_SALE__REFERENCE_NUMBER);
		createEAttribute(milkSaleEClass, MILK_SALE__SALE_DATE);
		createEReference(milkSaleEClass, MILK_SALE__SESSION);
		createEReference(milkSaleEClass, MILK_SALE__BIN);
		createEAttribute(milkSaleEClass, MILK_SALE__SALE_TYPE);
		createEAttribute(milkSaleEClass, MILK_SALE__QUANTITY);
		createEReference(milkSaleEClass, MILK_SALE__GRADE);
		createEAttribute(milkSaleEClass, MILK_SALE__UNIT_PRICE);
		createEAttribute(milkSaleEClass, MILK_SALE__DESCRIPTION);
		createEAttribute(milkSaleEClass, MILK_SALE__REJECTED);
		createEReference(milkSaleEClass, MILK_SALE__STORE_OR_ROUTE);
		createEReference(milkSaleEClass, MILK_SALE__CUSTOMER);
		createEReference(milkSaleEClass, MILK_SALE__SOLD_BY);
		createEAttribute(milkSaleEClass, MILK_SALE__SALE_AMOUNT);
		createEAttribute(milkSaleEClass, MILK_SALE__CONTRACT_SALE);
		createEReference(milkSaleEClass, MILK_SALE__SALES_CLERK);

		dairyEClass = createEClass(DAIRY);
		createEAttribute(dairyEClass, DAIRY__REGISTRATION_NUMBER);
		createEAttribute(dairyEClass, DAIRY__ESTABLISHED_DATE);
		createEAttribute(dairyEClass, DAIRY__MANAGER_NAME);
		createEAttribute(dairyEClass, DAIRY__NSSF_NUMBER);
		createEAttribute(dairyEClass, DAIRY__NHIF_NUMBER);
		createEAttribute(dairyEClass, DAIRY__FEDERAL_PIN);
		createEAttribute(dairyEClass, DAIRY__LICENSE_EFFECTIVE_DATE);
		createEAttribute(dairyEClass, DAIRY__LICENSE_EXPIRATION_DATE);
		createEReference(dairyEClass, DAIRY__ROUTES);
		createEReference(dairyEClass, DAIRY__VEHICLES);
		createEReference(dairyEClass, DAIRY__EMPLOYEES);
		createEReference(dairyEClass, DAIRY__MEMBERSHIPS);
		createEReference(dairyEClass, DAIRY__BRANCH_LOCATIONS);
		createEReference(dairyEClass, DAIRY__COLLECTION_JOURNALS);
		createEReference(dairyEClass, DAIRY__DELIVERY_JOURNALS);
		createEReference(dairyEClass, DAIRY__SUPPLIERS);
		createEReference(dairyEClass, DAIRY__CUSTOMERS);
		createEReference(dairyEClass, DAIRY__ANIMAL_HEALTH_REQUESTS);
		createEReference(dairyEClass, DAIRY__DAIRY_BINS);
		createEReference(dairyEClass, DAIRY__PRICE_HISTORY);
		createEAttribute(dairyEClass, DAIRY__VERSION);
		createEReference(dairyEClass, DAIRY__COLLECTION_SESSIONS);

		membershipEClass = createEClass(MEMBERSHIP);
		createEAttribute(membershipEClass, MEMBERSHIP__MEMBER_ID);
		createEAttribute(membershipEClass, MEMBERSHIP__MEMBER_NUMBER);
		createEAttribute(membershipEClass, MEMBERSHIP__APPLICATION_DATE);
		createEAttribute(membershipEClass, MEMBERSHIP__EFFECTIVE_DATE);
		createEAttribute(membershipEClass, MEMBERSHIP__STATUS);
		createEReference(membershipEClass, MEMBERSHIP__DEFAULT_ROUTE);
		createEReference(membershipEClass, MEMBERSHIP__FARMER);
		createEReference(membershipEClass, MEMBERSHIP__ACCOUNT);
		createEReference(membershipEClass, MEMBERSHIP__DAIRY);
		createEAttribute(membershipEClass, MEMBERSHIP__MAZIWA_CARD_NUMBER);
		createEAttribute(membershipEClass, MEMBERSHIP__MAZIWA_CARD_ISSUE_DATE);

		assetEClass = createEClass(ASSET);
		createEAttribute(assetEClass, ASSET__TAG_TYPE);
		createEAttribute(assetEClass, ASSET__TAG_VALUE);
		createEAttribute(assetEClass, ASSET__DATE_ACQUIRED);
		createEAttribute(assetEClass, ASSET__DAMAGE_DATE);
		createEAttribute(assetEClass, ASSET__DAMAGE_DESCRIPTION);
		createEAttribute(assetEClass, ASSET__DATE_DISPOSED);
		createEAttribute(assetEClass, ASSET__DISPOSAL_REASON);
		createEAttribute(assetEClass, ASSET__DISPOSAL_WITNESS);

		binEClass = createEClass(BIN);
		createEAttribute(binEClass, BIN__STATUS);
		createEReference(binEClass, BIN__ZONE);
		createEReference(binEClass, BIN__ASSET_INFO);

		supplierEClass = createEClass(SUPPLIER);
		createEAttribute(supplierEClass, SUPPLIER__CATEGORIES);
		createEAttribute(supplierEClass, SUPPLIER__ID);
		createEAttribute(supplierEClass, SUPPLIER__PUBLIC_DESCRIPTION);
		createEAttribute(supplierEClass, SUPPLIER__STATUS);
		createEAttribute(supplierEClass, SUPPLIER__REGISTRATION_DATE);
		createEAttribute(supplierEClass, SUPPLIER__EXPIRATION_DATE);
		createEAttribute(supplierEClass, SUPPLIER__NOTES);
		createEAttribute(supplierEClass, SUPPLIER__RATING);

		customerEClass = createEClass(CUSTOMER);
		createEAttribute(customerEClass, CUSTOMER__CUSTOMER_NUMBER);
		createEAttribute(customerEClass, CUSTOMER__CUSTOMER_TYPE);
		createEAttribute(customerEClass, CUSTOMER__STATUS);

		memberPaymentEClass = createEClass(MEMBER_PAYMENT);
		createEAttribute(memberPaymentEClass, MEMBER_PAYMENT__ID);
		createEAttribute(memberPaymentEClass, MEMBER_PAYMENT__YEAR);
		createEAttribute(memberPaymentEClass, MEMBER_PAYMENT__MONTH);
		createEAttribute(memberPaymentEClass, MEMBER_PAYMENT__PAYMENT_RATE);
		createEAttribute(memberPaymentEClass, MEMBER_PAYMENT__PAYMENTS_TOTAL);
		createEAttribute(memberPaymentEClass, MEMBER_PAYMENT__PAYMENTS_COUNT);
		createEReference(memberPaymentEClass, MEMBER_PAYMENT__ENTERED_BY);
		createEAttribute(memberPaymentEClass, MEMBER_PAYMENT__ENTRY_DATE);

		preferenceEClass = createEClass(PREFERENCE);
		createEAttribute(preferenceEClass, PREFERENCE__ID);
		createEReference(preferenceEClass, PREFERENCE__KEY);
		createEAttribute(preferenceEClass, PREFERENCE__VALUE);

		preferenceKeyEClass = createEClass(PREFERENCE_KEY);
		createEAttribute(preferenceKeyEClass, PREFERENCE_KEY__ID);
		createEAttribute(preferenceKeyEClass, PREFERENCE_KEY__NAME);
		createEAttribute(preferenceKeyEClass, PREFERENCE_KEY__DEFAULT_VALUE);
		createEAttribute(preferenceKeyEClass, PREFERENCE_KEY__TYPE);

		collectionSessionEClass = createEClass(COLLECTION_SESSION);
		createEAttribute(collectionSessionEClass, COLLECTION_SESSION__ID);
		createEAttribute(collectionSessionEClass, COLLECTION_SESSION__CODE);
		createEAttribute(collectionSessionEClass, COLLECTION_SESSION__DESCRIPTION);
		createEAttribute(collectionSessionEClass, COLLECTION_SESSION__TIME_OF_DAY);
		createEReference(collectionSessionEClass, COLLECTION_SESSION__DAIRY);

		// Create enums
		journalStatusEEnum = createEEnum(JOURNAL_STATUS);
		milkSaleTypeEEnum = createEEnum(MILK_SALE_TYPE);
		membershipStatusEEnum = createEEnum(MEMBERSHIP_STATUS);
		vendorStatusEEnum = createEEnum(VENDOR_STATUS);
		dairyFunctionEEnum = createEEnum(DAIRY_FUNCTION);
		preferenceTypeEEnum = createEEnum(PREFERENCE_TYPE);
		collectionGroupTypeEEnum = createEEnum(COLLECTION_GROUP_TYPE);
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
		scaleImportRecordEClass.getESuperTypes().add(this.getCollectionJournalLine());
		employeeEClass.getESuperTypes().add(theModelPackage.getPerson());
		dairyEClass.getESuperTypes().add(theModelPackage.getCompany());
		binEClass.getESuperTypes().add(theTrackingPackage.getContainer());
		supplierEClass.getESuperTypes().add(theModelPackage.getCompany());
		customerEClass.getESuperTypes().add(theModelPackage.getCompany());

		// Initialize classes and features; add operations and parameters
		initEClass(vehicleEClass, Vehicle.class, "Vehicle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVehicle_VehicleId(), theModelPackage.getUniqueID(), "vehicleId", null, 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_RegistrationNumber(), ecorePackage.getEString(), "registrationNumber", " ", 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_Type(), ecorePackage.getEString(), "type", " ", 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_Make(), ecorePackage.getEString(), "make", " ", 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_Model(), ecorePackage.getEString(), "model", " ", 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_EngineNumber(), ecorePackage.getEString(), "engineNumber", " ", 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_ChassisNumber(), ecorePackage.getEString(), "chassisNumber", " ", 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_LogBookNumber(), ecorePackage.getEString(), "logBookNumber", " ", 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_InsurancePolicyNumber(), ecorePackage.getEString(), "insurancePolicyNumber", " ", 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_InsuranceExpirationDate(), ecorePackage.getEDate(), "insuranceExpirationDate", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_DominantColour(), ecorePackage.getEString(), "dominantColour", " ", 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_CapacityInTonnes(), ecorePackage.getEDouble(), "capacityInTonnes", "0", 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_Year(), ecorePackage.getEIntegerObject(), "year", "2005", 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVehicle_Driver(), this.getEmployee(), null, "driver", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVehicle_AssetInfo(), this.getAsset(), null, "assetInfo", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		initEReference(getCollectionJournalLine_Bin(), this.getBin(), null, "bin", null, 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournalLine_Group(), this.getCollectionGroup(), this.getCollectionGroup_Entries(), "group", null, 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalLine_Rejected(), ecorePackage.getEBoolean(), "rejected", null, 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalLine_RejectionReason(), ecorePackage.getEString(), "rejectionReason", null, 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalLine_MilkFatPercentage(), ecorePackage.getEBigDecimal(), "milkFatPercentage", "0.0", 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalLine_AlcoholPercentage(), ecorePackage.getEBigDecimal(), "alcoholPercentage", "0.0", 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournalLine_WaterAdded(), ecorePackage.getEBoolean(), "waterAdded", "false", 0, 1, CollectionJournalLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scaleImportRecordEClass, ScaleImportRecord.class, "ScaleImportRecord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScaleImportRecord_ScaleSerial(), ecorePackage.getEString(), "scaleSerial", null, 0, 1, ScaleImportRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScaleImportRecord_CollectionTime(), ecorePackage.getEDate(), "collectionTime", null, 0, 1, ScaleImportRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScaleImportRecord_CenterNumber(), ecorePackage.getEString(), "centerNumber", null, 0, 1, ScaleImportRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScaleImportRecord_NumCans(), ecorePackage.getEString(), "numCans", null, 0, 1, ScaleImportRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScaleImportRecord_TripNumber(), ecorePackage.getEString(), "tripNumber", null, 0, 1, ScaleImportRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScaleImportRecord_OperatorCode(), ecorePackage.getEString(), "operatorCode", "", 0, 1, ScaleImportRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScaleImportRecord_Validated(), ecorePackage.getEBoolean(), "validated", "false", 0, 1, ScaleImportRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(employeeEClass, Employee.class, "Employee", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEmployee_EmployeeNumber(), ecorePackage.getEString(), "employeeNumber", null, 1, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmployee_OperatorCode(), ecorePackage.getEString(), "operatorCode", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmployee_StartDate(), ecorePackage.getEDate(), "startDate", null, 1, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmployee_JobFunction(), ecorePackage.getEString(), "jobFunction", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmployee_Department(), ecorePackage.getEString(), "department", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmployee_LicenseNo(), ecorePackage.getEString(), "licenseNo", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEmployee_Employer(), this.getDairy(), this.getDairy_Employees(), "employer", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEmployee_SystemIdentity(), theModelPackage.getSystemUser(), theModelPackage.getSystemUser_RelatedEmployee(), "systemIdentity", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(employeeEClass, ecorePackage.getEString(), "getNameAndLicense", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(dairyLocationEClass, DairyLocation.class, "DairyLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDairyLocation_Id(), ecorePackage.getELong(), "Id", null, 0, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairyLocation_Name(), ecorePackage.getEString(), "name", null, 1, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairyLocation_DateOpened(), ecorePackage.getEDate(), "dateOpened", null, 0, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairyLocation_Phone(), ecorePackage.getEString(), "phone", "+254", 0, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairyLocation_Route(), this.getTransportRoute(), this.getTransportRoute_Stops(), "route", null, 0, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairyLocation_Description(), ecorePackage.getEString(), "description", null, 0, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairyLocation_Code(), ecorePackage.getEString(), "code", null, 0, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairyLocation_Location(), theModelPackage.getLocation(), null, "location", null, 1, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairyLocation_Functions(), this.getDairyFunction(), "functions", null, 0, -1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairyLocation_Containers(), this.getBin(), null, "containers", null, 0, 1, DairyLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionGroupEClass, CollectionGroup.class, "CollectionGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectionGroup_Id(), theModelPackage.getUniqueID(), "id", null, 1, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionGroup_ReferenceNumber(), ecorePackage.getEString(), "referenceNumber", null, 1, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionGroup_CollectionDate(), ecorePackage.getEDate(), "collectionDate", null, 1, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionGroup_Status(), this.getJournalStatus(), "status", "NEW", 1, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionGroup_Driver(), this.getEmployee(), null, "driver", null, 1, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionGroup_Vehicle(), this.getVehicle(), null, "vehicle", null, 0, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionGroup_DriverTotal(), ecorePackage.getEBigDecimal(), "driverTotal", null, 0, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionGroup_RecordTotal(), ecorePackage.getEBigDecimal(), "recordTotal", "0", 0, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionGroup_Entries(), this.getCollectionJournalLine(), this.getCollectionJournalLine_Group(), "entries", null, 0, -1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionGroup_Suspended(), ecorePackage.getEBoolean(), "suspended", "false", 0, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionGroup_EntryCount(), ecorePackage.getEInt(), "entryCount", "0", 0, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionGroup_SuspendedCount(), ecorePackage.getEInt(), "suspendedCount", "0", 0, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionGroup_RejectedCount(), ecorePackage.getEInt(), "rejectedCount", "0", 0, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionGroup_JournalNumber(), ecorePackage.getEString(), "journalNumber", "", 0, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionGroup_Session(), this.getCollectionSession(), null, "session", null, 1, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionGroup_CollectionCenter(), this.getDairyLocation(), null, "collectionCenter", null, 1, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionGroup_Type(), this.getCollectionGroupType(), "type", "ScaleGroup", 1, 1, CollectionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transportRouteEClass, TransportRoute.class, "TransportRoute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransportRoute_Id(), theModelPackage.getUniqueID(), "Id", null, 1, 1, TransportRoute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransportRoute_Name(), ecorePackage.getEString(), "name", null, 0, 1, TransportRoute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransportRoute_Description(), ecorePackage.getEString(), "description", null, 0, 1, TransportRoute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransportRoute_Vehicle(), this.getVehicle(), null, "vehicle", null, 0, 1, TransportRoute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransportRoute_Stops(), this.getDairyLocation(), this.getDairyLocation_Route(), "stops", null, 0, -1, TransportRoute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransportRoute_Bins(), this.getBin(), this.getBin_Zone(), "bins", null, 0, -1, TransportRoute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tripEClass, Trip.class, "Trip", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrip_Collections(), this.getCollectionGroup(), null, "collections", null, 1, -1, Trip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrip_Deliveries(), this.getMilkSaleGroup(), null, "deliveries", null, 1, -1, Trip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrip_Started(), ecorePackage.getEDate(), "started", null, 1, 1, Trip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrip_Ended(), ecorePackage.getEDate(), "ended", null, 1, 1, Trip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrip_TripId(), ecorePackage.getELong(), "tripId", null, 1, 1, Trip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(milkSaleGroupEClass, MilkSaleGroup.class, "MilkSaleGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMilkSaleGroup_ReferenceNumber(), ecorePackage.getEString(), "referenceNumber", null, 1, 1, MilkSaleGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkSaleGroup_Date(), ecorePackage.getEDate(), "date", null, 1, 1, MilkSaleGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkSaleGroup_Route(), this.getTransportRoute(), null, "route", null, 1, 1, MilkSaleGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkSaleGroup_Customer(), this.getCustomer(), null, "customer", null, 0, 1, MilkSaleGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkSaleGroup_Driver(), this.getEmployee(), null, "driver", null, 0, 1, MilkSaleGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkSaleGroup_Vehicle(), this.getVehicle(), null, "vehicle", null, 0, 1, MilkSaleGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkSaleGroup_Sales(), this.getMilkSale(), null, "sales", null, 0, -1, MilkSaleGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMilkSaleGroup_Total(), ecorePackage.getEBigDecimal(), "total", "0.0", 1, 1, MilkSaleGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkSaleGroup_Session(), this.getCollectionSession(), null, "session", null, 1, 1, MilkSaleGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkSaleGroup_Id(), theModelPackage.getUniqueID(), "id", null, 1, 1, MilkSaleGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(milkGradeEClass, MilkGrade.class, "MilkGrade", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMilkGrade_Code(), ecorePackage.getEString(), "code", null, 1, 1, MilkGrade.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkGrade_Name(), ecorePackage.getEString(), "name", null, 1, 1, MilkGrade.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkGrade_Description(), ecorePackage.getEString(), "description", null, 0, 1, MilkGrade.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(milkGradeChangeEClass, MilkGradeChange.class, "MilkGradeChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMilkGradeChange_Date(), ecorePackage.getEDate(), "date", null, 1, 1, MilkGradeChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkGradeChange_StartingGrade(), this.getMilkGrade(), null, "startingGrade", null, 1, 1, MilkGradeChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkGradeChange_EndingGrade(), this.getMilkGrade(), null, "endingGrade", null, 1, 1, MilkGradeChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkGradeChange_ChangedBy(), this.getEmployee(), null, "changedBy", null, 0, 1, MilkGradeChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkGradeChange_Reason(), ecorePackage.getEString(), "reason", null, 0, 1, MilkGradeChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(milkSaleEClass, MilkSale.class, "MilkSale", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMilkSale_Id(), theModelPackage.getUniqueID(), "id", null, 1, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkSale_LineNumber(), ecorePackage.getEInt(), "lineNumber", null, 0, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkSale_ReferenceNumber(), ecorePackage.getEString(), "referenceNumber", null, 0, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkSale_SaleDate(), ecorePackage.getEDate(), "saleDate", null, 1, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkSale_Session(), this.getCollectionSession(), null, "session", null, 1, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkSale_Bin(), this.getBin(), null, "bin", null, 0, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkSale_SaleType(), this.getMilkSaleType(), "saleType", "", 1, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkSale_Quantity(), ecorePackage.getEBigDecimal(), "quantity", null, 1, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkSale_Grade(), this.getMilkGrade(), null, "grade", null, 1, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkSale_UnitPrice(), ecorePackage.getEBigDecimal(), "unitPrice", null, 1, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMilkSale_Description(), ecorePackage.getEString(), "description", null, 0, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkSale_Rejected(), ecorePackage.getEBoolean(), "rejected", "false", 1, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkSale_StoreOrRoute(), this.getDairyLocation(), null, "storeOrRoute", null, 1, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkSale_Customer(), this.getCustomer(), null, "customer", null, 0, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkSale_SoldBy(), this.getEmployee(), null, "soldBy", null, 0, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMilkSale_SaleAmount(), ecorePackage.getEBigDecimal(), "saleAmount", null, 1, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMilkSale_ContractSale(), ecorePackage.getEBoolean(), "contractSale", "false", 1, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMilkSale_SalesClerk(), this.getEmployee(), null, "salesClerk", null, 0, 1, MilkSale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dairyEClass, Dairy.class, "Dairy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDairy_RegistrationNumber(), ecorePackage.getEString(), "registrationNumber", null, 1, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_EstablishedDate(), ecorePackage.getEDate(), "establishedDate", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_ManagerName(), ecorePackage.getEString(), "managerName", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_NssfNumber(), ecorePackage.getEString(), "nssfNumber", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_NhifNumber(), ecorePackage.getEString(), "nhifNumber", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_FederalPin(), ecorePackage.getEString(), "federalPin", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_LicenseEffectiveDate(), ecorePackage.getEDate(), "licenseEffectiveDate", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_LicenseExpirationDate(), ecorePackage.getEDate(), "licenseExpirationDate", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_Routes(), this.getTransportRoute(), null, "routes", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDairy_Vehicles(), this.getVehicle(), null, "vehicles", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDairy_Employees(), this.getEmployee(), this.getEmployee_Employer(), "employees", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDairy_Memberships(), this.getMembership(), this.getMembership_Dairy(), "memberships", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDairy_BranchLocations(), this.getDairyLocation(), null, "branchLocations", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDairy_CollectionJournals(), this.getCollectionGroup(), null, "collectionJournals", null, 0, -1, Dairy.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		getDairy_CollectionJournals().getEKeys().add(this.getCollectionGroup_ReferenceNumber());
		initEReference(getDairy_DeliveryJournals(), this.getMilkSaleGroup(), null, "deliveryJournals", null, 0, -1, Dairy.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		getDairy_DeliveryJournals().getEKeys().add(this.getMilkSaleGroup_ReferenceNumber());
		initEReference(getDairy_Suppliers(), this.getSupplier(), null, "suppliers", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDairy_Customers(), this.getCustomer(), null, "customers", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDairy_AnimalHealthRequests(), theRequestsPackage.getAnimalHealthRequest(), theRequestsPackage.getAnimalHealthRequest_Dairy(), "animalHealthRequests", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		getDairy_AnimalHealthRequests().getEKeys().add(theRequestsPackage.getAnimalHealthRequest_RequestId());
		initEReference(getDairy_DairyBins(), this.getBin(), null, "dairyBins", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDairy_PriceHistory(), this.getMemberPayment(), null, "priceHistory", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDairy_Version(), ecorePackage.getELong(), "version", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_CollectionSessions(), this.getCollectionSession(), this.getCollectionSession_Dairy(), "collectionSessions", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(membershipEClass, Membership.class, "Membership", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMembership_MemberId(), theModelPackage.getUniqueID(), "memberId", null, 1, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMembership_MemberNumber(), ecorePackage.getEString(), "memberNumber", null, 1, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMembership_ApplicationDate(), ecorePackage.getEDate(), "applicationDate", null, 1, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMembership_EffectiveDate(), ecorePackage.getEDate(), "effectiveDate", null, 0, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMembership_Status(), this.getMembershipStatus(), "status", null, 1, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMembership_DefaultRoute(), this.getDairyLocation(), null, "defaultRoute", null, 0, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMembership_Farmer(), theTrackingPackage.getFarmer(), theTrackingPackage.getFarmer_Membership(), "farmer", null, 1, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getMembership_Farmer().getEKeys().add(theModelPackage.getPerson_PersonId());
		initEReference(getMembership_Account(), theAccountPackage.getAccount(), theAccountPackage.getAccount_Member(), "account", null, 1, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getMembership_Account().getEKeys().add(theAccountPackage.getAccount_AccountId());
		initEReference(getMembership_Dairy(), this.getDairy(), this.getDairy_Memberships(), "dairy", null, 1, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMembership_MaziwaCardNumber(), ecorePackage.getEString(), "maziwaCardNumber", null, 0, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMembership_MaziwaCardIssueDate(), ecorePackage.getEDate(), "maziwaCardIssueDate", null, 0, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assetEClass, Asset.class, "Asset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAsset_TagType(), ecorePackage.getEString(), "tagType", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsset_TagValue(), ecorePackage.getEString(), "tagValue", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsset_DateAcquired(), ecorePackage.getEDate(), "dateAcquired", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsset_DamageDate(), ecorePackage.getEDate(), "damageDate", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsset_DamageDescription(), ecorePackage.getEString(), "damageDescription", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsset_DateDisposed(), ecorePackage.getEDate(), "dateDisposed", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsset_DisposalReason(), ecorePackage.getEString(), "disposalReason", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsset_DisposalWitness(), ecorePackage.getEString(), "disposalWitness", null, 0, 1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binEClass, Bin.class, "Bin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBin_Status(), ecorePackage.getEString(), "status", "IN_CIRCULATION", 0, 1, Bin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBin_Zone(), this.getTransportRoute(), this.getTransportRoute_Bins(), "zone", null, 0, 1, Bin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBin_AssetInfo(), this.getAsset(), null, "assetInfo", null, 0, 1, Bin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getBin_AssetInfo().getEKeys().add(this.getAsset_TagValue());

		initEClass(supplierEClass, Supplier.class, "Supplier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSupplier_Categories(), ecorePackage.getEString(), "categories", null, 0, -1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupplier_Id(), ecorePackage.getEString(), "id", null, 1, 1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupplier_PublicDescription(), ecorePackage.getEString(), "publicDescription", null, 1, 1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupplier_Status(), this.getVendorStatus(), "status", null, 1, 1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupplier_RegistrationDate(), ecorePackage.getEDate(), "registrationDate", null, 1, 1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupplier_ExpirationDate(), ecorePackage.getEDate(), "expirationDate", null, 0, 1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupplier_Notes(), ecorePackage.getEString(), "notes", null, 0, 1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupplier_Rating(), ecorePackage.getEInt(), "rating", null, 0, 1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customerEClass, Customer.class, "Customer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomer_CustomerNumber(), ecorePackage.getEString(), "customerNumber", null, 1, 1, Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomer_CustomerType(), ecorePackage.getEString(), "customerType", "Milk Processor", 0, 1, Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomer_Status(), ecorePackage.getEString(), "status", "Active", 0, 1, Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(memberPaymentEClass, MemberPayment.class, "MemberPayment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMemberPayment_Id(), theModelPackage.getUniqueID(), "id", null, 1, 1, MemberPayment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemberPayment_Year(), ecorePackage.getEInt(), "year", null, 1, 1, MemberPayment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemberPayment_Month(), ecorePackage.getEInt(), "month", null, 1, 1, MemberPayment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemberPayment_PaymentRate(), ecorePackage.getEBigDecimal(), "paymentRate", null, 1, 1, MemberPayment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemberPayment_PaymentsTotal(), ecorePackage.getEBigDecimal(), "paymentsTotal", null, 0, 1, MemberPayment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemberPayment_PaymentsCount(), ecorePackage.getEInt(), "paymentsCount", null, 0, 1, MemberPayment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMemberPayment_EnteredBy(), this.getEmployee(), null, "enteredBy", null, 1, 1, MemberPayment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemberPayment_EntryDate(), ecorePackage.getEDate(), "entryDate", null, 1, 1, MemberPayment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preferenceEClass, Preference.class, "Preference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPreference_Id(), theModelPackage.getUniqueID(), "id", null, 1, 1, Preference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPreference_Key(), this.getPreferenceKey(), null, "key", null, 0, 1, Preference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreference_Value(), ecorePackage.getEString(), "value", null, 0, 1, Preference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preferenceKeyEClass, PreferenceKey.class, "PreferenceKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPreferenceKey_Id(), theModelPackage.getUniqueID(), "id", null, 1, 1, PreferenceKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferenceKey_Name(), ecorePackage.getEString(), "name", null, 0, 1, PreferenceKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferenceKey_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 0, 1, PreferenceKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferenceKey_Type(), this.getPreferenceType(), "type", null, 0, 1, PreferenceKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionSessionEClass, CollectionSession.class, "CollectionSession", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectionSession_Id(), theModelPackage.getUniqueID(), "id", null, 1, 1, CollectionSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionSession_Code(), ecorePackage.getEString(), "code", null, 0, 1, CollectionSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionSession_Description(), ecorePackage.getEString(), "description", null, 0, 1, CollectionSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionSession_TimeOfDay(), ecorePackage.getEDate(), "timeOfDay", null, 0, 1, CollectionSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionSession_Dairy(), this.getDairy(), this.getDairy_CollectionSessions(), "dairy", null, 0, 1, CollectionSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(journalStatusEEnum, JournalStatus.class, "JournalStatus");
		addEEnumLiteral(journalStatusEEnum, JournalStatus.NEW);
		addEEnumLiteral(journalStatusEEnum, JournalStatus.PENDING);
		addEEnumLiteral(journalStatusEEnum, JournalStatus.COMPLETE);
		addEEnumLiteral(journalStatusEEnum, JournalStatus.SUSPENDED);
		addEEnumLiteral(journalStatusEEnum, JournalStatus.ARCHIVED);

		initEEnum(milkSaleTypeEEnum, MilkSaleType.class, "MilkSaleType");
		addEEnumLiteral(milkSaleTypeEEnum, MilkSaleType.CASH);
		addEEnumLiteral(milkSaleTypeEEnum, MilkSaleType.CREDIT);

		initEEnum(membershipStatusEEnum, MembershipStatus.class, "MembershipStatus");
		addEEnumLiteral(membershipStatusEEnum, MembershipStatus.ACTIVE);
		addEEnumLiteral(membershipStatusEEnum, MembershipStatus.INACTIVE);
		addEEnumLiteral(membershipStatusEEnum, MembershipStatus.DORMANT);
		addEEnumLiteral(membershipStatusEEnum, MembershipStatus.DELETED);

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

		initEEnum(preferenceTypeEEnum, PreferenceType.class, "PreferenceType");
		addEEnumLiteral(preferenceTypeEEnum, PreferenceType.STRING);
		addEEnumLiteral(preferenceTypeEEnum, PreferenceType.BOOLEAN);
		addEEnumLiteral(preferenceTypeEEnum, PreferenceType.INT);
		addEEnumLiteral(preferenceTypeEEnum, PreferenceType.LONG);
		addEEnumLiteral(preferenceTypeEEnum, PreferenceType.FLOAT);
		addEEnumLiteral(preferenceTypeEEnum, PreferenceType.DOUBLE);

		initEEnum(collectionGroupTypeEEnum, CollectionGroupType.class, "CollectionGroupType");
		addEEnumLiteral(collectionGroupTypeEEnum, CollectionGroupType.SCALE_GROUP);
		addEEnumLiteral(collectionGroupTypeEEnum, CollectionGroupType.JOURNAL_GROUP);

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
		  (getVehicle_RegistrationNumber(), 
		   source, 
		   new String[] 
		   {
			 "name", "registrationNumber",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getVehicle_LogBookNumber(), 
		   source, 
		   new String[] 
		   {
			 "name", "logBookNumber",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getVehicle_AssetInfo(), 
		   source, 
		   new String[] 
		   {
			 "name", "assetInfo",
			 "kind", "elementOnly"
		   });				
		addAnnotation
		  (getEmployee_EmployeeNumber(), 
		   source, 
		   new String[] 
		   {
			 "name", "employeeNumber",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getDairyLocation_Id(), 
		   source, 
		   new String[] 
		   {
			 "name", "Id",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getDairyLocation_Code(), 
		   source, 
		   new String[] 
		   {
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getCollectionGroup_CollectionDate(), 
		   source, 
		   new String[] 
		   {
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getTransportRoute_Id(), 
		   source, 
		   new String[] 
		   {
			 "name", "Id",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getTransportRoute_Name(), 
		   source, 
		   new String[] 
		   {
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getTrip_TripId(), 
		   source, 
		   new String[] 
		   {
			 "name", "tripId",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getMilkGrade_Code(), 
		   source, 
		   new String[] 
		   {
			 "name", "code",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getDairy_Version(), 
		   source, 
		   new String[] 
		   {
			 "name", "version",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getMembership_MemberId(), 
		   source, 
		   new String[] 
		   {
			 "name", "memberId",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMembership_MemberNumber(), 
		   source, 
		   new String[] 
		   {
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (assetEClass, 
		   source, 
		   new String[] 
		   {
			 "name", "Asset",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getBin_AssetInfo(), 
		   source, 
		   new String[] 
		   {
			 "name", "assetInfo",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getSupplier_Id(), 
		   source, 
		   new String[] 
		   {
			 "name", "id",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCustomer_CustomerNumber(), 
		   source, 
		   new String[] 
		   {
			 "name", "id",
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
		  (getVehicle_RegistrationNumber(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@NaturalId\n"
		   });			
		addAnnotation
		  (getVehicle_LogBookNumber(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@Column(unique=true)\n"
		   });			
		addAnnotation
		  (getVehicle_AssetInfo(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@Embedded"
		   });				
		addAnnotation
		  (getEmployee_EmployeeNumber(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@Column(unique=true)\n"
		   });			
		addAnnotation
		  (getDairyLocation_Id(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@Id\n@GeneratedValue"
		   });			
		addAnnotation
		  (getDairyLocation_Code(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@NaturalId"
		   });			
		addAnnotation
		  (getCollectionGroup_CollectionDate(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@Temporal(TemporalType.DATE)"
		   });			
		addAnnotation
		  (getTransportRoute_Id(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@Id\n@GeneratedValue"
		   });			
		addAnnotation
		  (getTransportRoute_Name(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@NaturalId"
		   });			
		addAnnotation
		  (getTrip_TripId(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@Id\n@GeneratedValue"
		   });			
		addAnnotation
		  (getMilkGrade_Code(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@NaturalId\n"
		   });			
		addAnnotation
		  (getDairy_Version(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@Version"
		   });				
		addAnnotation
		  (getMembership_MemberNumber(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@NaturalId"
		   });			
		addAnnotation
		  (assetEClass, 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@Embeddable"
		   });			
		addAnnotation
		  (getBin_AssetInfo(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@Embedded"
		   });				
		addAnnotation
		  (getCustomer_CustomerNumber(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@NaturalId"
		   });		
		addAnnotation
		  (getCollectionSession_Code(), 
		   source, 
		   new String[] 
		   {
			 "appinfo", "@Column(unique=\"true\")"
		   });
	}

} //DairyPackageImpl
