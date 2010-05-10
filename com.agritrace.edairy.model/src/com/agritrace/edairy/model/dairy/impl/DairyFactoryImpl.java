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
                        case DairyPackage.COLLECTION_JOURNAL_LINE: return createCollectionJournalLine();
                        case DairyPackage.EMPLOYEE: return createEmployee();
                        case DairyPackage.DAIRY_LOCATION: return createDairyLocation();
                        case DairyPackage.COLLECTION_JOURNAL: return createCollectionJournal();
                        case DairyPackage.ROUTE: return createRoute();
                        case DairyPackage.TRIP: return createTrip();
                        case DairyPackage.DELIVERY_JOURNAL: return createDeliveryJournal();
                        case DairyPackage.DAIRY: return createDairy();
                        case DairyPackage.MEMBERSHIP: return createMembership();
                        case DairyPackage.ASSET: return createAsset();
                        case DairyPackage.DAIRY_CONTAINER: return createDairyContainer();
                        case DairyPackage.SUPPLIER: return createSupplier();
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
                        case DairyPackage.SESSION:
                                return createSessionFromString(eDataType, initialValue);
                        case DairyPackage.VENDOR_STATUS:
                                return createVendorStatusFromString(eDataType, initialValue);
                        case DairyPackage.DAIRY_FUNCTION:
                                return createDairyFunctionFromString(eDataType, initialValue);
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
                        case DairyPackage.SESSION:
                                return convertSessionToString(eDataType, instanceValue);
                        case DairyPackage.VENDOR_STATUS:
                                return convertVendorStatusToString(eDataType, instanceValue);
                        case DairyPackage.DAIRY_FUNCTION:
                                return convertDairyFunctionToString(eDataType, instanceValue);
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
	public CollectionJournalLine createCollectionJournalLine() {
                CollectionJournalLineImpl collectionJournalLine = new CollectionJournalLineImpl();
                return collectionJournalLine;
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
	public DairyLocation createDairyLocation() {
                DairyLocationImpl dairyLocation = new DairyLocationImpl();
                return dairyLocation;
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
	public Route createRoute() {
                RouteImpl route = new RouteImpl();
                return route;
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
	public Asset createAsset() {
                AssetImpl asset = new AssetImpl();
                return asset;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public DairyContainer createDairyContainer() {
                DairyContainerImpl dairyContainer = new DairyContainerImpl();
                return dairyContainer;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public Supplier createSupplier() {
                SupplierImpl supplier = new SupplierImpl();
                return supplier;
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
	public Session createSessionFromString(EDataType eDataType, String initialValue) {
                Session result = Session.get(initialValue);
                if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
                return result;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public String convertSessionToString(EDataType eDataType, Object instanceValue) {
                return instanceValue == null ? null : instanceValue.toString();
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public VendorStatus createVendorStatusFromString(EDataType eDataType, String initialValue) {
                VendorStatus result = VendorStatus.get(initialValue);
                if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
                return result;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public String convertVendorStatusToString(EDataType eDataType, Object instanceValue) {
                return instanceValue == null ? null : instanceValue.toString();
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public DairyFunction createDairyFunctionFromString(EDataType eDataType, String initialValue) {
                DairyFunction result = DairyFunction.get(initialValue);
                if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
                return result;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public String convertDairyFunctionToString(EDataType eDataType, Object instanceValue) {
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
