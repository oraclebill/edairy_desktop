/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.util;

import com.agritrace.edairy.desktop.common.model.base.Company;
import com.agritrace.edairy.desktop.common.model.base.Contactable;
import com.agritrace.edairy.desktop.common.model.base.Person;

import com.agritrace.edairy.desktop.common.model.dairy.*;

import com.agritrace.edairy.desktop.common.model.tracking.Container;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage
 * @generated
 */
public class DairyAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DairyPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DairyPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DairySwitch<Adapter> modelSwitch =
		new DairySwitch<Adapter>() {
			@Override
			public Adapter caseVehicle(Vehicle object) {
				return createVehicleAdapter();
			}
			@Override
			public Adapter caseCollectionJournalLine(CollectionJournalLine object) {
				return createCollectionJournalLineAdapter();
			}
			@Override
			public Adapter caseScaleImportRecord(ScaleImportRecord object) {
				return createScaleImportRecordAdapter();
			}
			@Override
			public Adapter caseEmployee(Employee object) {
				return createEmployeeAdapter();
			}
			@Override
			public Adapter caseDairyLocation(DairyLocation object) {
				return createDairyLocationAdapter();
			}
			@Override
			public Adapter caseCollectionGroup(CollectionGroup object) {
				return createCollectionGroupAdapter();
			}
			@Override
			public Adapter caseRoute(Route object) {
				return createRouteAdapter();
			}
			@Override
			public Adapter caseTrip(Trip object) {
				return createTripAdapter();
			}
			@Override
			public Adapter caseDeliveryJournal(DeliveryJournal object) {
				return createDeliveryJournalAdapter();
			}
			@Override
			public Adapter caseDeliveryJournalLine(DeliveryJournalLine object) {
				return createDeliveryJournalLineAdapter();
			}
			@Override
			public Adapter caseDairy(Dairy object) {
				return createDairyAdapter();
			}
			@Override
			public Adapter caseMembership(Membership object) {
				return createMembershipAdapter();
			}
			@Override
			public Adapter caseAsset(Asset object) {
				return createAssetAdapter();
			}
			@Override
			public Adapter caseDairyContainer(DairyContainer object) {
				return createDairyContainerAdapter();
			}
			@Override
			public Adapter caseSupplier(Supplier object) {
				return createSupplierAdapter();
			}
			@Override
			public Adapter caseCustomer(Customer object) {
				return createCustomerAdapter();
			}
			@Override
			public Adapter caseMemberPayment(MemberPayment object) {
				return createMemberPaymentAdapter();
			}
			@Override
			public Adapter casePreference(Preference object) {
				return createPreferenceAdapter();
			}
			@Override
			public Adapter casePreferenceKey(PreferenceKey object) {
				return createPreferenceKeyAdapter();
			}
			@Override
			public Adapter caseCollectionSession(CollectionSession object) {
				return createCollectionSessionAdapter();
			}
			@Override
			public Adapter caseContactable(Contactable object) {
				return createContactableAdapter();
			}
			@Override
			public Adapter casePerson(Person object) {
				return createPersonAdapter();
			}
			@Override
			public Adapter caseCompany(Company object) {
				return createCompanyAdapter();
			}
			@Override
			public Adapter caseContainer(Container object) {
				return createContainerAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle <em>Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Vehicle
	 * @generated
	 */
	public Adapter createVehicleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine <em>Collection Journal Line</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine
	 * @generated
	 */
	public Adapter createCollectionJournalLineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord <em>Scale Import Record</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord
	 * @generated
	 */
	public Adapter createScaleImportRecordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee <em>Employee</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Employee
	 * @generated
	 */
	public Adapter createEmployeeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyLocation
	 * @generated
	 */
	public Adapter createDairyLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup <em>Collection Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup
	 * @generated
	 */
	public Adapter createCollectionGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.Route <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Route
	 * @generated
	 */
	public Adapter createRouteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.Trip <em>Trip</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Trip
	 * @generated
	 */
	public Adapter createTripAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal <em>Delivery Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal
	 * @generated
	 */
	public Adapter createDeliveryJournalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine <em>Delivery Journal Line</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine
	 * @generated
	 */
	public Adapter createDeliveryJournalLineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy <em>Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy
	 * @generated
	 */
	public Adapter createDairyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership <em>Membership</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership
	 * @generated
	 */
	public Adapter createMembershipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset <em>Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Asset
	 * @generated
	 */
	public Adapter createAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyContainer
	 * @generated
	 */
	public Adapter createDairyContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier <em>Supplier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Supplier
	 * @generated
	 */
	public Adapter createSupplierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Customer
	 * @generated
	 */
	public Adapter createCustomerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment <em>Member Payment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MemberPayment
	 * @generated
	 */
	public Adapter createMemberPaymentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.Preference <em>Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Preference
	 * @generated
	 */
	public Adapter createPreferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.PreferenceKey <em>Preference Key</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.PreferenceKey
	 * @generated
	 */
	public Adapter createPreferenceKeyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession <em>Collection Session</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionSession
	 * @generated
	 */
	public Adapter createCollectionSessionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.Contactable <em>Contactable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.Contactable
	 * @generated
	 */
	public Adapter createContactableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.Person
	 * @generated
	 */
	public Adapter createPersonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.Company <em>Company</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.Company
	 * @generated
	 */
	public Adapter createCompanyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.tracking.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.tracking.Container
	 * @generated
	 */
	public Adapter createContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DairyAdapterFactory
