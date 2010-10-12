/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.agritrace.edairy.desktop.common.model.dairy.Asset;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroupType;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
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
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.model.dairy.MemberPayment;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;
import com.agritrace.edairy.desktop.common.model.dairy.Permission;
import com.agritrace.edairy.desktop.common.model.dairy.PermissionNamespace;
import com.agritrace.edairy.desktop.common.model.dairy.Preference;
import com.agritrace.edairy.desktop.common.model.dairy.PreferenceKey;
import com.agritrace.edairy.desktop.common.model.dairy.PreferenceType;
import com.agritrace.edairy.desktop.common.model.dairy.Role;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.Trip;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;

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
			final DairyFactory theDairyFactory = (DairyFactory)EPackage.Registry.INSTANCE.getEFactory("http://com.agritrace.edairy.desktop.common.model/dairy/");
			if (theDairyFactory != null) {
				return theDairyFactory;
			}
		}
		catch (final Exception exception) {
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
			case DairyPackage.SCALE_IMPORT_RECORD: return createScaleImportRecord();
			case DairyPackage.EMPLOYEE: return createEmployee();
			case DairyPackage.DAIRY_LOCATION: return createDairyLocation();
			case DairyPackage.COLLECTION_GROUP: return createCollectionGroup();
			case DairyPackage.ROUTE: return createRoute();
			case DairyPackage.TRIP: return createTrip();
			case DairyPackage.DELIVERY_JOURNAL: return createDeliveryJournal();
			case DairyPackage.DELIVERY_JOURNAL_LINE: return createDeliveryJournalLine();
			case DairyPackage.DAIRY: return createDairy();
			case DairyPackage.MEMBERSHIP: return createMembership();
			case DairyPackage.ASSET: return createAsset();
			case DairyPackage.DAIRY_CONTAINER: return createDairyContainer();
			case DairyPackage.SUPPLIER: return createSupplier();
			case DairyPackage.CUSTOMER: return createCustomer();
			case DairyPackage.MEMBER_PAYMENT: return createMemberPayment();
			case DairyPackage.PREFERENCE: return createPreference();
			case DairyPackage.PREFERENCE_KEY: return createPreferenceKey();
			case DairyPackage.ROLE: return createRole();
			case DairyPackage.PERMISSION_NAMESPACE: return createPermissionNamespace();
			case DairyPackage.PERMISSION: return createPermission();
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
		switch (eDataType.getClassifierID()) {
			case DairyPackage.JOURNAL_STATUS:
				return createJournalStatusFromString(eDataType, initialValue);
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
			case DairyPackage.PERMISSION_T:
				return createPermissionTFromString(eDataType, initialValue);
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
			case DairyPackage.JOURNAL_STATUS:
				return convertJournalStatusToString(eDataType, instanceValue);
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
			case DairyPackage.PERMISSION_T:
				return convertPermissionTToString(eDataType, instanceValue);
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
	public Vehicle createVehicle() {
		final VehicleImpl vehicle = new VehicleImpl();
		return vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CollectionJournalLine createCollectionJournalLine() {
		final CollectionJournalLineImpl collectionJournalLine = new CollectionJournalLineImpl();
		return collectionJournalLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScaleImportRecord createScaleImportRecord() {
		final ScaleImportRecordImpl scaleImportRecord = new ScaleImportRecordImpl();
		return scaleImportRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Employee createEmployee() {
		final EmployeeImpl employee = new EmployeeImpl();
		return employee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DairyLocation createDairyLocation() {
		final DairyLocationImpl dairyLocation = new DairyLocationImpl();
		return dairyLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CollectionGroup createCollectionGroup() {
		final CollectionGroupImpl collectionGroup = new CollectionGroupImpl();
		return collectionGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Route createRoute() {
		final RouteImpl route = new RouteImpl();
		return route;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Trip createTrip() {
		final TripImpl trip = new TripImpl();
		return trip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeliveryJournal createDeliveryJournal() {
		final DeliveryJournalImpl deliveryJournal = new DeliveryJournalImpl();
		return deliveryJournal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeliveryJournalLine createDeliveryJournalLine() {
		final DeliveryJournalLineImpl deliveryJournalLine = new DeliveryJournalLineImpl();
		return deliveryJournalLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Dairy createDairy() {
		final DairyImpl dairy = new DairyImpl();
		return dairy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Membership createMembership() {
		final MembershipImpl membership = new MembershipImpl();
		return membership;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Asset createAsset() {
		final AssetImpl asset = new AssetImpl();
		return asset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DairyContainer createDairyContainer() {
		final DairyContainerImpl dairyContainer = new DairyContainerImpl();
		return dairyContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Supplier createSupplier() {
		final SupplierImpl supplier = new SupplierImpl();
		return supplier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Customer createCustomer() {
		final CustomerImpl customer = new CustomerImpl();
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MemberPayment createMemberPayment() {
		final MemberPaymentImpl memberPayment = new MemberPaymentImpl();
		return memberPayment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Preference createPreference() {
		final PreferenceImpl preference = new PreferenceImpl();
		return preference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PreferenceKey createPreferenceKey() {
		final PreferenceKeyImpl preferenceKey = new PreferenceKeyImpl();
		return preferenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Role createRole() {
		final RoleImpl role = new RoleImpl();
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PermissionNamespace createPermissionNamespace() {
		final PermissionNamespaceImpl permissionNamespace = new PermissionNamespaceImpl();
		return permissionNamespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Permission createPermission() {
		final PermissionImpl permission = new PermissionImpl();
		return permission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CollectionSession createCollectionSession() {
		final CollectionSessionImpl collectionSession = new CollectionSessionImpl();
		return collectionSession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JournalStatus createJournalStatusFromString(EDataType eDataType, String initialValue) {
		final JournalStatus result = JournalStatus.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
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
	public MembershipStatus createMembershipStatusFromString(EDataType eDataType, String initialValue) {
		final MembershipStatus result = MembershipStatus.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
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
		final VendorStatus result = VendorStatus.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
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
		final DairyFunction result = DairyFunction.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
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
		final PreferenceType result = PreferenceType.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
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
		final CollectionGroupType result = CollectionGroupType.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
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
	 * NOT AUTOGENERATED - DO NOT REPLACE
	 */
	public com.agritrace.edairy.desktop.common.model.dairy.security.Permission createPermissionTFromString(EDataType eDataType, String initialValue) {
		return com.agritrace.edairy.desktop.common.model.dairy.security.Permission.valueOf(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * NOT AUTOGENERATED - DO NOT REPLACE
	 */
	public String convertPermissionTToString(EDataType eDataType, Object instanceValue) {
		return ((com.agritrace.edairy.desktop.common.model.dairy.security.Permission) instanceValue).name();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
