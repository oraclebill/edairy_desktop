/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.dairy.Asset;
import com.agritrace.edairy.model.dairy.CollectionJournal;
import com.agritrace.edairy.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.model.dairy.Dairy;
import com.agritrace.edairy.model.dairy.DairyContainer;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.DairyFunction;
import com.agritrace.edairy.model.dairy.DairyLocation;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.DeliveryJournal;
import com.agritrace.edairy.model.dairy.Employee;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.dairy.MembershipStatus;
import com.agritrace.edairy.model.dairy.Route;
import com.agritrace.edairy.model.dairy.Session;
import com.agritrace.edairy.model.dairy.Supplier;
import com.agritrace.edairy.model.dairy.Trip;
import com.agritrace.edairy.model.dairy.Vehicle;
import com.agritrace.edairy.model.dairy.VendorStatus;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class DairyFactoryImpl extends EFactoryImpl implements DairyFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static DairyFactory init() {
	try {
	    final DairyFactory theDairyFactory = (DairyFactory) EPackage.Registry.INSTANCE
		    .getEFactory("http://com.agritrace.edairy.model/dairy/");
	    if (theDairyFactory != null) {
		return theDairyFactory;
	    }
	} catch (final Exception exception) {
	    EcorePlugin.INSTANCE.log(exception);
	}
	return new DairyFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public DairyFactoryImpl() {
	super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
	switch (eClass.getClassifierID()) {
	case DairyPackage.VEHICLE:
	    return createVehicle();
	case DairyPackage.COLLECTION_JOURNAL_LINE:
	    return createCollectionJournalLine();
	case DairyPackage.EMPLOYEE:
	    return createEmployee();
	case DairyPackage.DAIRY_LOCATION:
	    return createDairyLocation();
	case DairyPackage.COLLECTION_JOURNAL:
	    return createCollectionJournal();
	case DairyPackage.ROUTE:
	    return createRoute();
	case DairyPackage.TRIP:
	    return createTrip();
	case DairyPackage.DELIVERY_JOURNAL:
	    return createDeliveryJournal();
	case DairyPackage.DAIRY:
	    return createDairy();
	case DairyPackage.MEMBERSHIP:
	    return createMembership();
	case DairyPackage.ASSET:
	    return createAsset();
	case DairyPackage.DAIRY_CONTAINER:
	    return createDairyContainer();
	case DairyPackage.SUPPLIER:
	    return createSupplier();
	default:
	    throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
	}
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Vehicle createVehicle() {
	final VehicleImpl vehicle = new VehicleImpl();
	return vehicle;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CollectionJournalLine createCollectionJournalLine() {
	final CollectionJournalLineImpl collectionJournalLine = new CollectionJournalLineImpl();
	return collectionJournalLine;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public Employee createEmployee() {
	final EmployeeImpl employee = new EmployeeImpl();
	final Location homeAddress = ModelFactory.eINSTANCE.createLocation();
	employee.setLocation(homeAddress);
	return employee;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DairyLocation createDairyLocation() {
	final DairyLocationImpl dairyLocation = new DairyLocationImpl();
	return dairyLocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CollectionJournal createCollectionJournal() {
	final CollectionJournalImpl collectionJournal = new CollectionJournalImpl();
	return collectionJournal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Route createRoute() {
	final RouteImpl route = new RouteImpl();
	return route;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Trip createTrip() {
	final TripImpl trip = new TripImpl();
	return trip;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DeliveryJournal createDeliveryJournal() {
	final DeliveryJournalImpl deliveryJournal = new DeliveryJournalImpl();
	return deliveryJournal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Dairy createDairy() {
	final DairyImpl dairy = new DairyImpl();
	return dairy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Membership createMembership() {
	final MembershipImpl membership = new MembershipImpl();
	return membership;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Asset createAsset() {
	final AssetImpl asset = new AssetImpl();
	return asset;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DairyContainer createDairyContainer() {
	final DairyContainerImpl dairyContainer = new DairyContainerImpl();
	return dairyContainer;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Supplier createSupplier() {
	final SupplierImpl supplier = new SupplierImpl();
	return supplier;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public MembershipStatus createMembershipStatusFromString(EDataType eDataType, String initialValue) {
	final MembershipStatus result = MembershipStatus.get(initialValue);
	if (result == null) {
	    throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
		    + eDataType.getName() + "'");
	}
	return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertMembershipStatusToString(EDataType eDataType, Object instanceValue) {
	return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Session createSessionFromString(EDataType eDataType, String initialValue) {
	final Session result = Session.get(initialValue);
	if (result == null) {
	    throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
		    + eDataType.getName() + "'");
	}
	return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertSessionToString(EDataType eDataType, Object instanceValue) {
	return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public VendorStatus createVendorStatusFromString(EDataType eDataType, String initialValue) {
	final VendorStatus result = VendorStatus.get(initialValue);
	if (result == null) {
	    throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
		    + eDataType.getName() + "'");
	}
	return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertVendorStatusToString(EDataType eDataType, Object instanceValue) {
	return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DairyFunction createDairyFunctionFromString(EDataType eDataType, String initialValue) {
	final DairyFunction result = DairyFunction.get(initialValue);
	if (result == null) {
	    throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
		    + eDataType.getName() + "'");
	}
	return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertDairyFunctionToString(EDataType eDataType, Object instanceValue) {
	return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DairyPackage getDairyPackage() {
	return (DairyPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static DairyPackage getPackage() {
	return DairyPackage.eINSTANCE;
    }

} // DairyFactoryImpl
