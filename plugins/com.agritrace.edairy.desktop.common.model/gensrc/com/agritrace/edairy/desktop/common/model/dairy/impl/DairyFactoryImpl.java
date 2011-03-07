/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.dairy.*;

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
		try
		{
			DairyFactory theDairyFactory = (DairyFactory)EPackage.Registry.INSTANCE.getEFactory("http://com.agritrace.edairy.desktop.common.model/dairy/"); 
			if (theDairyFactory != null)
			{
				return theDairyFactory;
			}
		}
		catch (Exception exception)
		{
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
		switch (eClass.getClassifierID())
		{
			case DairyPackage.VEHICLE: return createVehicle();
			case DairyPackage.COLLECTION_JOURNAL_LINE: return createCollectionJournalLine();
			case DairyPackage.SCALE_IMPORT_RECORD: return createScaleImportRecord();
			case DairyPackage.EMPLOYEE: return createEmployee();
			case DairyPackage.DAIRY_LOCATION: return createDairyLocation();
			case DairyPackage.COLLECTION_GROUP: return createCollectionGroup();
			case DairyPackage.TRANSPORT_ROUTE: return createTransportRoute();
			case DairyPackage.TRIP: return createTrip();
			case DairyPackage.DELIVERY_JOURNAL: return createDeliveryJournal();
			case DairyPackage.MILK_GRADE: return createMilkGrade();
			case DairyPackage.MILK_GRADE_CHANGE: return createMilkGradeChange();
			case DairyPackage.MILK_SALE: return createMilkSale();
			case DairyPackage.DAIRY: return createDairy();
			case DairyPackage.MEMBERSHIP: return createMembership();
			case DairyPackage.ASSET: return createAsset();
			case DairyPackage.BIN: return createBin();
			case DairyPackage.SUPPLIER: return createSupplier();
			case DairyPackage.CUSTOMER: return createCustomer();
			case DairyPackage.MEMBER_PAYMENT: return createMemberPayment();
			case DairyPackage.PREFERENCE: return createPreference();
			case DairyPackage.PREFERENCE_KEY: return createPreferenceKey();
			case DairyPackage.COLLECTION_SESSION: return createCollectionSession();
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
		switch (eDataType.getClassifierID())
		{
			case DairyPackage.JOURNAL_STATUS:
				return createJournalStatusFromString(eDataType, initialValue);
			case DairyPackage.MILK_SALE_TYPE:
				return createMilkSaleTypeFromString(eDataType, initialValue);
			case DairyPackage.MEMBERSHIP_STATUS:
				return createMembershipStatusFromString(eDataType, initialValue);
			case DairyPackage.VENDOR_STATUS:
				return createVendorStatusFromString(eDataType, initialValue);
			case DairyPackage.DAIRY_FUNCTION:
				return createDairyFunctionFromString(eDataType, initialValue);
			case DairyPackage.PREFERENCE_TYPE:
				return createPreferenceTypeFromString(eDataType, initialValue);
			case DairyPackage.COLLECTION_GROUP_TYPE:
				return createCollectionGroupTypeFromString(eDataType, initialValue);
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
		switch (eDataType.getClassifierID())
		{
			case DairyPackage.JOURNAL_STATUS:
				return convertJournalStatusToString(eDataType, instanceValue);
			case DairyPackage.MILK_SALE_TYPE:
				return convertMilkSaleTypeToString(eDataType, instanceValue);
			case DairyPackage.MEMBERSHIP_STATUS:
				return convertMembershipStatusToString(eDataType, instanceValue);
			case DairyPackage.VENDOR_STATUS:
				return convertVendorStatusToString(eDataType, instanceValue);
			case DairyPackage.DAIRY_FUNCTION:
				return convertDairyFunctionToString(eDataType, instanceValue);
			case DairyPackage.PREFERENCE_TYPE:
				return convertPreferenceTypeToString(eDataType, instanceValue);
			case DairyPackage.COLLECTION_GROUP_TYPE:
				return convertCollectionGroupTypeToString(eDataType, instanceValue);
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
	public ScaleImportRecord createScaleImportRecord() {
		ScaleImportRecordImpl scaleImportRecord = new ScaleImportRecordImpl();
		return scaleImportRecord;
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
	public CollectionGroup createCollectionGroup() {
		CollectionGroupImpl collectionGroup = new CollectionGroupImpl();
		return collectionGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransportRoute createTransportRoute() {
		TransportRouteImpl transportRoute = new TransportRouteImpl();
		return transportRoute;
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
	public MilkGrade createMilkGrade() {
		MilkGradeImpl milkGrade = new MilkGradeImpl();
		return milkGrade;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MilkGradeChange createMilkGradeChange() {
		MilkGradeChangeImpl milkGradeChange = new MilkGradeChangeImpl();
		return milkGradeChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MilkSale createMilkSale() {
		MilkSaleImpl milkSale = new MilkSaleImpl();
		return milkSale;
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
	public Bin createBin() {
		BinImpl bin = new BinImpl();
		return bin;
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
	public Customer createCustomer() {
		CustomerImpl customer = new CustomerImpl();
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemberPayment createMemberPayment() {
		MemberPaymentImpl memberPayment = new MemberPaymentImpl();
		return memberPayment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Preference createPreference() {
		PreferenceImpl preference = new PreferenceImpl();
		return preference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreferenceKey createPreferenceKey() {
		PreferenceKeyImpl preferenceKey = new PreferenceKeyImpl();
		return preferenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionSession createCollectionSession() {
		CollectionSessionImpl collectionSession = new CollectionSessionImpl();
		return collectionSession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JournalStatus createJournalStatusFromString(EDataType eDataType, String initialValue) {
		JournalStatus result = JournalStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJournalStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MilkSaleType createMilkSaleTypeFromString(EDataType eDataType, String initialValue) {
		MilkSaleType result = MilkSaleType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMilkSaleTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
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
	public PreferenceType createPreferenceTypeFromString(EDataType eDataType, String initialValue) {
		PreferenceType result = PreferenceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPreferenceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionGroupType createCollectionGroupTypeFromString(EDataType eDataType, String initialValue) {
		CollectionGroupType result = CollectionGroupType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCollectionGroupTypeToString(EDataType eDataType, Object instanceValue) {
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
