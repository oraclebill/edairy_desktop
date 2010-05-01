/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.impl;

import com.agritrace.edairy.model.dairy.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DairyFactoryImpl extends EFactoryImpl implements DairyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DairyFactory init() {
		try {
			DairyFactory theDairyFactory = (DairyFactory)EPackage.Registry.INSTANCE.getEFactory("http://com.agritrace.edairy.model/dairy/"); 
			if (theDairyFactory != null) {
				return theDairyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DairyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DairyPackage.VEHICLE: return createVehicle();
			case DairyPackage.DRIVER: return createDriver();
			case DairyPackage.COLLECTION_RECORD: return createCollectionRecord();
			case DairyPackage.EMPLOYEE: return createEmployee();
			case DairyPackage.COLLECTION_CENTRE: return createCollectionCentre();
			case DairyPackage.SERVICE_RECORD: return createServiceRecord();
			case DairyPackage.WORKSTATION: return createWorkstation();
			case DairyPackage.COLLECTION_JOURNAL: return createCollectionJournal();
			case DairyPackage.ROUTE_DEFINITION: return createRouteDefinition();
			case DairyPackage.TRIP: return createTrip();
			case DairyPackage.DELIVERY_JOURNAL: return createDeliveryJournal();
			case DairyPackage.SESSION: return createSession();
			case DairyPackage.DAIRY: return createDairy();
			case DairyPackage.MEMBERSHIP: return createMembership();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DairyPackage.MEMBERSHIP_STATUS:
				return createMembershipStatusFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DairyPackage.MEMBERSHIP_STATUS:
				return convertMembershipStatusToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle createVehicle() {
		VehicleImpl vehicle = new VehicleImpl();
		return vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver createDriver() {
		DriverImpl driver = new DriverImpl();
		return driver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionRecord createCollectionRecord() {
		CollectionRecordImpl collectionRecord = new CollectionRecordImpl();
		return collectionRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee createEmployee() {
		EmployeeImpl employee = new EmployeeImpl();
		return employee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionCentre createCollectionCentre() {
		CollectionCentreImpl collectionCentre = new CollectionCentreImpl();
		return collectionCentre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceRecord createServiceRecord() {
		ServiceRecordImpl serviceRecord = new ServiceRecordImpl();
		return serviceRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Workstation createWorkstation() {
		WorkstationImpl workstation = new WorkstationImpl();
		return workstation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionJournal createCollectionJournal() {
		CollectionJournalImpl collectionJournal = new CollectionJournalImpl();
		return collectionJournal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouteDefinition createRouteDefinition() {
		RouteDefinitionImpl routeDefinition = new RouteDefinitionImpl();
		return routeDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trip createTrip() {
		TripImpl trip = new TripImpl();
		return trip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeliveryJournal createDeliveryJournal() {
		DeliveryJournalImpl deliveryJournal = new DeliveryJournalImpl();
		return deliveryJournal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Session createSession() {
		SessionImpl session = new SessionImpl();
		return session;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dairy createDairy() {
		DairyImpl dairy = new DairyImpl();
		return dairy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Membership createMembership() {
		MembershipImpl membership = new MembershipImpl();
		return membership;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MembershipStatus createMembershipStatusFromString(EDataType eDataType, String initialValue) {
		MembershipStatus result = MembershipStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMembershipStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyPackage getDairyPackage() {
		return (DairyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DairyPackage getPackage() {
		return DairyPackage.eINSTANCE;
	}

} //DairyFactoryImpl
