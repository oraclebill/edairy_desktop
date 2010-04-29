/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.impl;

import com.agritrace.edairy.model.ModelPackage;

import com.agritrace.edairy.model.dairy.Bin;
import com.agritrace.edairy.model.dairy.CollectionCentre;
import com.agritrace.edairy.model.dairy.CollectionJournal;
import com.agritrace.edairy.model.dairy.CollectionRecord;
import com.agritrace.edairy.model.dairy.Dairy;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.DeliveryJournal;
import com.agritrace.edairy.model.dairy.Driver;
import com.agritrace.edairy.model.dairy.Employee;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.dairy.MembershipStatus;
import com.agritrace.edairy.model.dairy.RouteDefinition;
import com.agritrace.edairy.model.dairy.ServiceRecord;
import com.agritrace.edairy.model.dairy.Session;
import com.agritrace.edairy.model.dairy.Trip;
import com.agritrace.edairy.model.dairy.Vehicle;
import com.agritrace.edairy.model.dairy.Workstation;

import com.agritrace.edairy.model.impl.ModelPackageImpl;

import com.agritrace.edairy.model.tracking.TrackingPackage;

import com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl;

import com.agritrace.edairy.services.ServicesPackage;

import com.agritrace.edairy.services.impl.ServicesPackageImpl;

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
	private EClass driverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionRecordEClass = null;

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
	private EClass collectionCentreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceRecordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workstationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionJournalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass routeDefinitionEClass = null;

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
	private EClass sessionEClass = null;

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
	private EClass binEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum membershipStatusEEnum = null;

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
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#eNS_URI
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
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		TrackingPackageImpl theTrackingPackage = (TrackingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TrackingPackage.eNS_URI) instanceof TrackingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TrackingPackage.eNS_URI) : TrackingPackage.eINSTANCE);
		ServicesPackageImpl theServicesPackage = (ServicesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServicesPackage.eNS_URI) instanceof ServicesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServicesPackage.eNS_URI) : ServicesPackage.eINSTANCE);

		// Create package meta-data objects
		theDairyPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theTrackingPackage.createPackageContents();
		theServicesPackage.createPackageContents();

		// Initialize created meta-data
		theDairyPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theTrackingPackage.initializePackageContents();
		theServicesPackage.initializePackageContents();

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
	public EReference getVehicle_ServiceRecords() {
		return (EReference)vehicleEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getVehicle_InsurancePurchaseDate() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_PurchaseDate() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_DisposalDate() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_DominantColour() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_CapacityInTonnes() {
		return (EAttribute)vehicleEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDriver() {
		return driverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDriver_VehicleAssignment() {
		return (EReference)driverEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionRecord() {
		return collectionRecordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionRecord_Suspended() {
		return (EAttribute)collectionRecordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionRecord_NotRecorded() {
		return (EAttribute)collectionRecordEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionRecord_RecordedMember() {
		return (EReference)collectionRecordEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionRecord_OffRoute() {
		return (EAttribute)collectionRecordEClass.getEStructuralFeatures().get(3);
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
	public EClass getCollectionCentre() {
		return collectionCentreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionCentre_Name() {
		return (EAttribute)collectionCentreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceRecord() {
		return serviceRecordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceRecord_Id() {
		return (EAttribute)serviceRecordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceRecord_Date() {
		return (EAttribute)serviceRecordEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceRecord_Description() {
		return (EAttribute)serviceRecordEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkstation() {
		return workstationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkstation_Id() {
		return (EAttribute)workstationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkstation_Location() {
		return (EAttribute)workstationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkstation_Type() {
		return (EAttribute)workstationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionJournal() {
		return collectionJournalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournal_JournalEntries() {
		return (EReference)collectionJournalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournal_ReferenceNumber() {
		return (EAttribute)collectionJournalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournal_JournalDate() {
		return (EAttribute)collectionJournalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournal_Driver() {
		return (EReference)collectionJournalEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournal_Route() {
		return (EReference)collectionJournalEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournal_Session() {
		return (EReference)collectionJournalEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournal_Can() {
		return (EReference)collectionJournalEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournal_Bin() {
		return (EReference)collectionJournalEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionJournal_Vehicle() {
		return (EReference)collectionJournalEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournal_DriverTotal() {
		return (EAttribute)collectionJournalEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionJournal_Total() {
		return (EAttribute)collectionJournalEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRouteDefinition() {
		return routeDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRouteDefinition_Name() {
		return (EAttribute)routeDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRouteDefinition_Stops() {
		return (EReference)routeDefinitionEClass.getEStructuralFeatures().get(1);
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
	public EClass getSession() {
		return sessionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSession_Name() {
		return (EAttribute)sessionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSession_Sequence() {
		return (EAttribute)sessionEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getDairy_NhifNumber() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_NssfNumber() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDairy_FederalPin() {
		return (EAttribute)dairyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Workstations() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Routes() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Vehicles() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Employees() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Sessions() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDairy_Memberships() {
		return (EReference)dairyEClass.getEStructuralFeatures().get(8);
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
	public EAttribute getMembership_ApplicationDate() {
		return (EAttribute)membershipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMembership_EffectiveDate() {
		return (EAttribute)membershipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMembership_Status() {
		return (EAttribute)membershipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMembership_DefaultRoute() {
		return (EReference)membershipEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMembership_Member() {
		return (EReference)membershipEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMembership_MemberId() {
		return (EAttribute)membershipEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMembership_Containers() {
		return (EReference)membershipEClass.getEStructuralFeatures().get(6);
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
	public EEnum getMembershipStatus() {
		return membershipStatusEEnum;
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
		createEReference(vehicleEClass, VEHICLE__SERVICE_RECORDS);
		createEAttribute(vehicleEClass, VEHICLE__REGISTRATION_NUMBER);
		createEAttribute(vehicleEClass, VEHICLE__TYPE);
		createEAttribute(vehicleEClass, VEHICLE__MAKE);
		createEAttribute(vehicleEClass, VEHICLE__MODEL);
		createEAttribute(vehicleEClass, VEHICLE__ENGINE_NUMBER);
		createEAttribute(vehicleEClass, VEHICLE__CHASSIS_NUMBER);
		createEAttribute(vehicleEClass, VEHICLE__LOG_BOOK_NUMBER);
		createEAttribute(vehicleEClass, VEHICLE__INSURANCE_POLICY_NUMBER);
		createEAttribute(vehicleEClass, VEHICLE__INSURANCE_PURCHASE_DATE);
		createEAttribute(vehicleEClass, VEHICLE__PURCHASE_DATE);
		createEAttribute(vehicleEClass, VEHICLE__DISPOSAL_DATE);
		createEAttribute(vehicleEClass, VEHICLE__DOMINANT_COLOUR);
		createEAttribute(vehicleEClass, VEHICLE__CAPACITY_IN_TONNES);

		driverEClass = createEClass(DRIVER);
		createEReference(driverEClass, DRIVER__VEHICLE_ASSIGNMENT);

		collectionRecordEClass = createEClass(COLLECTION_RECORD);
		createEAttribute(collectionRecordEClass, COLLECTION_RECORD__SUSPENDED);
		createEAttribute(collectionRecordEClass, COLLECTION_RECORD__NOT_RECORDED);
		createEReference(collectionRecordEClass, COLLECTION_RECORD__RECORDED_MEMBER);
		createEAttribute(collectionRecordEClass, COLLECTION_RECORD__OFF_ROUTE);

		employeeEClass = createEClass(EMPLOYEE);
		createEAttribute(employeeEClass, EMPLOYEE__ID);
		createEAttribute(employeeEClass, EMPLOYEE__START_DATE);
		createEAttribute(employeeEClass, EMPLOYEE__JOB_FUNCTION);

		collectionCentreEClass = createEClass(COLLECTION_CENTRE);
		createEAttribute(collectionCentreEClass, COLLECTION_CENTRE__NAME);

		serviceRecordEClass = createEClass(SERVICE_RECORD);
		createEAttribute(serviceRecordEClass, SERVICE_RECORD__ID);
		createEAttribute(serviceRecordEClass, SERVICE_RECORD__DATE);
		createEAttribute(serviceRecordEClass, SERVICE_RECORD__DESCRIPTION);

		workstationEClass = createEClass(WORKSTATION);
		createEAttribute(workstationEClass, WORKSTATION__ID);
		createEAttribute(workstationEClass, WORKSTATION__LOCATION);
		createEAttribute(workstationEClass, WORKSTATION__TYPE);

		collectionJournalEClass = createEClass(COLLECTION_JOURNAL);
		createEReference(collectionJournalEClass, COLLECTION_JOURNAL__JOURNAL_ENTRIES);
		createEAttribute(collectionJournalEClass, COLLECTION_JOURNAL__REFERENCE_NUMBER);
		createEAttribute(collectionJournalEClass, COLLECTION_JOURNAL__JOURNAL_DATE);
		createEReference(collectionJournalEClass, COLLECTION_JOURNAL__DRIVER);
		createEReference(collectionJournalEClass, COLLECTION_JOURNAL__ROUTE);
		createEReference(collectionJournalEClass, COLLECTION_JOURNAL__SESSION);
		createEReference(collectionJournalEClass, COLLECTION_JOURNAL__CAN);
		createEReference(collectionJournalEClass, COLLECTION_JOURNAL__BIN);
		createEReference(collectionJournalEClass, COLLECTION_JOURNAL__VEHICLE);
		createEAttribute(collectionJournalEClass, COLLECTION_JOURNAL__DRIVER_TOTAL);
		createEAttribute(collectionJournalEClass, COLLECTION_JOURNAL__TOTAL);

		routeDefinitionEClass = createEClass(ROUTE_DEFINITION);
		createEAttribute(routeDefinitionEClass, ROUTE_DEFINITION__NAME);
		createEReference(routeDefinitionEClass, ROUTE_DEFINITION__STOPS);

		tripEClass = createEClass(TRIP);
		createEReference(tripEClass, TRIP__COLLECTIONS);
		createEReference(tripEClass, TRIP__DELIVERIES);
		createEAttribute(tripEClass, TRIP__STARTED);
		createEAttribute(tripEClass, TRIP__ENDED);

		deliveryJournalEClass = createEClass(DELIVERY_JOURNAL);
		createEAttribute(deliveryJournalEClass, DELIVERY_JOURNAL__REFERENCE_NUMBER);

		sessionEClass = createEClass(SESSION);
		createEAttribute(sessionEClass, SESSION__NAME);
		createEAttribute(sessionEClass, SESSION__SEQUENCE);

		dairyEClass = createEClass(DAIRY);
		createEAttribute(dairyEClass, DAIRY__NHIF_NUMBER);
		createEAttribute(dairyEClass, DAIRY__NSSF_NUMBER);
		createEAttribute(dairyEClass, DAIRY__FEDERAL_PIN);
		createEReference(dairyEClass, DAIRY__WORKSTATIONS);
		createEReference(dairyEClass, DAIRY__ROUTES);
		createEReference(dairyEClass, DAIRY__VEHICLES);
		createEReference(dairyEClass, DAIRY__EMPLOYEES);
		createEReference(dairyEClass, DAIRY__SESSIONS);
		createEReference(dairyEClass, DAIRY__MEMBERSHIPS);

		membershipEClass = createEClass(MEMBERSHIP);
		createEAttribute(membershipEClass, MEMBERSHIP__APPLICATION_DATE);
		createEAttribute(membershipEClass, MEMBERSHIP__EFFECTIVE_DATE);
		createEAttribute(membershipEClass, MEMBERSHIP__STATUS);
		createEReference(membershipEClass, MEMBERSHIP__DEFAULT_ROUTE);
		createEReference(membershipEClass, MEMBERSHIP__MEMBER);
		createEAttribute(membershipEClass, MEMBERSHIP__MEMBER_ID);
		createEReference(membershipEClass, MEMBERSHIP__CONTAINERS);

		binEClass = createEClass(BIN);

		// Create enums
		membershipStatusEEnum = createEEnum(MEMBERSHIP_STATUS);
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
		TrackingPackage theTrackingPackage = (TrackingPackage)EPackage.Registry.INSTANCE.getEPackage(TrackingPackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		driverEClass.getESuperTypes().add(this.getEmployee());
		collectionRecordEClass.getESuperTypes().add(theTrackingPackage.getCollection());
		employeeEClass.getESuperTypes().add(theModelPackage.getPerson());
		dairyEClass.getESuperTypes().add(theTrackingPackage.getDairy());
		binEClass.getESuperTypes().add(theTrackingPackage.getContainer());

		// Initialize classes and features; add operations and parameters
		initEClass(vehicleEClass, Vehicle.class, "Vehicle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVehicle_ServiceRecords(), this.getServiceRecord(), null, "serviceRecords", null, 1, -1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_RegistrationNumber(), ecorePackage.getEString(), "registrationNumber", null, 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_Type(), ecorePackage.getEString(), "type", null, 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_Make(), ecorePackage.getEString(), "make", null, 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_Model(), ecorePackage.getEString(), "model", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_EngineNumber(), ecorePackage.getEString(), "engineNumber", null, 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_ChassisNumber(), ecorePackage.getEString(), "chassisNumber", null, 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_LogBookNumber(), ecorePackage.getEString(), "logBookNumber", null, 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_InsurancePolicyNumber(), ecorePackage.getEString(), "insurancePolicyNumber", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_InsurancePurchaseDate(), ecorePackage.getEString(), "insurancePurchaseDate", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_PurchaseDate(), ecorePackage.getEString(), "purchaseDate", null, 1, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_DisposalDate(), ecorePackage.getEString(), "disposalDate", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_DominantColour(), ecorePackage.getEString(), "dominantColour", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicle_CapacityInTonnes(), ecorePackage.getEString(), "capacityInTonnes", null, 0, 1, Vehicle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(driverEClass, Driver.class, "Driver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDriver_VehicleAssignment(), this.getVehicle(), null, "vehicleAssignment", null, 0, 1, Driver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionRecordEClass, CollectionRecord.class, "CollectionRecord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectionRecord_Suspended(), ecorePackage.getEBoolean(), "suspended", null, 0, 1, CollectionRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionRecord_NotRecorded(), ecorePackage.getEBoolean(), "notRecorded", null, 0, 1, CollectionRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionRecord_RecordedMember(), this.getMembership(), null, "recordedMember", null, 1, 1, CollectionRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionRecord_OffRoute(), ecorePackage.getEBoolean(), "offRoute", null, 0, 1, CollectionRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(employeeEClass, Employee.class, "Employee", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEmployee_Id(), ecorePackage.getEString(), "id", null, 1, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmployee_StartDate(), ecorePackage.getEDate(), "startDate", null, 1, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmployee_JobFunction(), ecorePackage.getEString(), "jobFunction", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionCentreEClass, CollectionCentre.class, "CollectionCentre", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectionCentre_Name(), ecorePackage.getEString(), "name", null, 1, 1, CollectionCentre.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceRecordEClass, ServiceRecord.class, "ServiceRecord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceRecord_Id(), ecorePackage.getEString(), "id", null, 1, 1, ServiceRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceRecord_Date(), ecorePackage.getEDate(), "date", null, 1, 1, ServiceRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceRecord_Description(), ecorePackage.getEString(), "description", null, 1, 1, ServiceRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workstationEClass, Workstation.class, "Workstation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWorkstation_Id(), ecorePackage.getEString(), "id", null, 1, 1, Workstation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkstation_Location(), ecorePackage.getEString(), "location", null, 1, 1, Workstation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkstation_Type(), ecorePackage.getEString(), "type", null, 1, 1, Workstation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionJournalEClass, CollectionJournal.class, "CollectionJournal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionJournal_JournalEntries(), this.getCollectionRecord(), null, "journalEntries", null, 0, -1, CollectionJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournal_ReferenceNumber(), ecorePackage.getEString(), "referenceNumber", null, 1, 1, CollectionJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournal_JournalDate(), ecorePackage.getEDate(), "journalDate", null, 1, 1, CollectionJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournal_Driver(), this.getEmployee(), null, "driver", null, 1, 1, CollectionJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournal_Route(), this.getRouteDefinition(), null, "route", null, 1, 1, CollectionJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournal_Session(), this.getSession(), null, "session", null, 1, 1, CollectionJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournal_Can(), theTrackingPackage.getContainer(), null, "can", null, 1, 1, CollectionJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournal_Bin(), theTrackingPackage.getContainer(), null, "bin", null, 1, 1, CollectionJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionJournal_Vehicle(), this.getVehicle(), null, "vehicle", null, 1, 1, CollectionJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournal_DriverTotal(), ecorePackage.getEBigDecimal(), "driverTotal", null, 1, 1, CollectionJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionJournal_Total(), ecorePackage.getEBigDecimal(), "total", "0", 1, 1, CollectionJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(routeDefinitionEClass, RouteDefinition.class, "RouteDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRouteDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, RouteDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRouteDefinition_Stops(), this.getCollectionCentre(), null, "stops", null, 0, -1, RouteDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tripEClass, Trip.class, "Trip", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrip_Collections(), this.getCollectionJournal(), null, "collections", null, 1, -1, Trip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrip_Deliveries(), this.getDeliveryJournal(), null, "deliveries", null, 1, -1, Trip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrip_Started(), ecorePackage.getEDate(), "started", null, 1, 1, Trip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrip_Ended(), ecorePackage.getEDate(), "ended", null, 1, 1, Trip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deliveryJournalEClass, DeliveryJournal.class, "DeliveryJournal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeliveryJournal_ReferenceNumber(), ecorePackage.getEString(), "referenceNumber", null, 0, 1, DeliveryJournal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sessionEClass, Session.class, "Session", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSession_Name(), ecorePackage.getEString(), "name", null, 1, 1, Session.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSession_Sequence(), ecorePackage.getEShort(), "sequence", null, 1, 1, Session.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dairyEClass, Dairy.class, "Dairy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDairy_NhifNumber(), ecorePackage.getEString(), "nhifNumber", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_NssfNumber(), ecorePackage.getEString(), "nssfNumber", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDairy_FederalPin(), ecorePackage.getEString(), "federalPin", null, 0, 1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_Workstations(), this.getWorkstation(), null, "workstations", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_Routes(), this.getRouteDefinition(), null, "routes", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_Vehicles(), this.getVehicle(), null, "vehicles", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_Employees(), this.getEmployee(), null, "employees", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_Sessions(), this.getSession(), null, "sessions", null, 2, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDairy_Memberships(), this.getMembership(), null, "memberships", null, 0, -1, Dairy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(membershipEClass, Membership.class, "Membership", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMembership_ApplicationDate(), ecorePackage.getEDate(), "applicationDate", null, 1, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMembership_EffectiveDate(), ecorePackage.getEDate(), "effectiveDate", null, 0, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMembership_Status(), this.getMembershipStatus(), "status", null, 1, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMembership_DefaultRoute(), this.getRouteDefinition(), null, "defaultRoute", null, 1, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMembership_Member(), theModelPackage.getPerson(), null, "member", null, 1, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMembership_MemberId(), ecorePackage.getEString(), "memberId", null, 0, 1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMembership_Containers(), theTrackingPackage.getContainer(), null, "containers", null, 0, -1, Membership.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binEClass, Bin.class, "Bin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(membershipStatusEEnum, MembershipStatus.class, "MembershipStatus");
		addEEnumLiteral(membershipStatusEEnum, MembershipStatus.ACTIVE);
		addEEnumLiteral(membershipStatusEEnum, MembershipStatus.INACTIVE);
		addEEnumLiteral(membershipStatusEEnum, MembershipStatus.DORMANT);
	}

} //DairyPackageImpl
