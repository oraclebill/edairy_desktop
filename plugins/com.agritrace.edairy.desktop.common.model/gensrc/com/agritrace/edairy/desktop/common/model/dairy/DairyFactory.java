/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage
 * @generated
 */
public interface DairyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DairyFactory eINSTANCE = com.agritrace.edairy.desktop.common.model.dairy.impl.DairyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vehicle</em>'.
	 * @generated
	 */
	Vehicle createVehicle();

	/**
	 * Returns a new object of class '<em>Collection Journal Line</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Journal Line</em>'.
	 * @generated
	 */
	CollectionJournalLine createCollectionJournalLine();

	/**
	 * Returns a new object of class '<em>Scale Import Record</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scale Import Record</em>'.
	 * @generated
	 */
	ScaleImportRecord createScaleImportRecord();

	/**
	 * Returns a new object of class '<em>Employee</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Employee</em>'.
	 * @generated
	 */
	Employee createEmployee();

	/**
	 * Returns a new object of class '<em>Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Location</em>'.
	 * @generated
	 */
	DairyLocation createDairyLocation();

	/**
	 * Returns a new object of class '<em>Collection Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Group</em>'.
	 * @generated
	 */
	CollectionGroup createCollectionGroup();

	/**
	 * Returns a new object of class '<em>Transport Route</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transport Route</em>'.
	 * @generated
	 */
	TransportRoute createTransportRoute();

	/**
	 * Returns a new object of class '<em>Trip</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trip</em>'.
	 * @generated
	 */
	Trip createTrip();

	/**
	 * Returns a new object of class '<em>Milk Sale Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Milk Sale Group</em>'.
	 * @generated
	 */
	MilkSaleGroup createMilkSaleGroup();

	/**
	 * Returns a new object of class '<em>Milk Grade</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Milk Grade</em>'.
	 * @generated
	 */
	MilkGrade createMilkGrade();

	/**
	 * Returns a new object of class '<em>Milk Grade Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Milk Grade Change</em>'.
	 * @generated
	 */
	MilkGradeChange createMilkGradeChange();

	/**
	 * Returns a new object of class '<em>Milk Sale</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Milk Sale</em>'.
	 * @generated
	 */
	MilkSale createMilkSale();

	/**
	 * Returns a new object of class '<em>Dairy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dairy</em>'.
	 * @generated
	 */
	Dairy createDairy();

	/**
	 * Returns a new object of class '<em>Membership</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Membership</em>'.
	 * @generated
	 */
	Membership createMembership();

	/**
	 * Returns a new object of class '<em>Asset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Asset</em>'.
	 * @generated
	 */
	Asset createAsset();

	/**
	 * Returns a new object of class '<em>Bin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bin</em>'.
	 * @generated
	 */
	Bin createBin();

	/**
	 * Returns a new object of class '<em>Supplier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Supplier</em>'.
	 * @generated
	 */
	Supplier createSupplier();

	/**
	 * Returns a new object of class '<em>Customer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Customer</em>'.
	 * @generated
	 */
	Customer createCustomer();

	/**
	 * Returns a new object of class '<em>Member Payment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Member Payment</em>'.
	 * @generated
	 */
	MemberPayment createMemberPayment();

	/**
	 * Returns a new object of class '<em>Preference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Preference</em>'.
	 * @generated
	 */
	Preference createPreference();

	/**
	 * Returns a new object of class '<em>Preference Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Preference Key</em>'.
	 * @generated
	 */
	PreferenceKey createPreferenceKey();

	/**
	 * Returns a new object of class '<em>Collection Session</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Session</em>'.
	 * @generated
	 */
	CollectionSession createCollectionSession();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DairyPackage getDairyPackage();

} //DairyFactory
