/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.util;

import com.agritrace.edairy.model.Company;
import com.agritrace.edairy.model.Party;
import com.agritrace.edairy.model.Person;

import com.agritrace.edairy.model.dairy.*;

import com.agritrace.edairy.model.tracking.Collection;
import com.agritrace.edairy.model.tracking.Transfer;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.model.dairy.DairyPackage
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
			public Adapter caseDriver(Driver object) {
				return createDriverAdapter();
			}
			@Override
			public Adapter caseCollectionRecord(CollectionRecord object) {
				return createCollectionRecordAdapter();
			}
			@Override
			public Adapter caseEmployee(Employee object) {
				return createEmployeeAdapter();
			}
			@Override
			public Adapter caseCollectionCentre(CollectionCentre object) {
				return createCollectionCentreAdapter();
			}
			@Override
			public Adapter caseServiceRecord(ServiceRecord object) {
				return createServiceRecordAdapter();
			}
			@Override
			public Adapter caseWorkstation(Workstation object) {
				return createWorkstationAdapter();
			}
			@Override
			public Adapter caseCollectionJournal(CollectionJournal object) {
				return createCollectionJournalAdapter();
			}
			@Override
			public Adapter caseRouteDefinition(RouteDefinition object) {
				return createRouteDefinitionAdapter();
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
			public Adapter caseSession(Session object) {
				return createSessionAdapter();
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
			public Adapter caseParty(Party object) {
				return createPartyAdapter();
			}
			@Override
			public Adapter casePerson(Person object) {
				return createPersonAdapter();
			}
			@Override
			public Adapter caseTransfer(Transfer object) {
				return createTransferAdapter();
			}
			@Override
			public Adapter caseCollection(Collection object) {
				return createCollectionAdapter();
			}
			@Override
			public Adapter caseCompany(Company object) {
				return createCompanyAdapter();
			}
			@Override
			public Adapter caseTracking_Dairy(com.agritrace.edairy.model.tracking.Dairy object) {
				return createTracking_DairyAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.dairy.Vehicle <em>Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.dairy.Vehicle
	 * @generated
	 */
	public Adapter createVehicleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.dairy.Driver <em>Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.dairy.Driver
	 * @generated
	 */
	public Adapter createDriverAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.dairy.CollectionRecord <em>Collection Record</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.dairy.CollectionRecord
	 * @generated
	 */
	public Adapter createCollectionRecordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.dairy.Employee <em>Employee</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.dairy.Employee
	 * @generated
	 */
	public Adapter createEmployeeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.dairy.CollectionCentre <em>Collection Centre</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.dairy.CollectionCentre
	 * @generated
	 */
	public Adapter createCollectionCentreAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.dairy.ServiceRecord <em>Service Record</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.dairy.ServiceRecord
	 * @generated
	 */
	public Adapter createServiceRecordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.dairy.Workstation <em>Workstation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.dairy.Workstation
	 * @generated
	 */
	public Adapter createWorkstationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.dairy.CollectionJournal <em>Collection Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.dairy.CollectionJournal
	 * @generated
	 */
	public Adapter createCollectionJournalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.dairy.RouteDefinition <em>Route Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.dairy.RouteDefinition
	 * @generated
	 */
	public Adapter createRouteDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.dairy.Trip <em>Trip</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.dairy.Trip
	 * @generated
	 */
	public Adapter createTripAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.dairy.DeliveryJournal <em>Delivery Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.dairy.DeliveryJournal
	 * @generated
	 */
	public Adapter createDeliveryJournalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.dairy.Session <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.dairy.Session
	 * @generated
	 */
	public Adapter createSessionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.dairy.Dairy <em>Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.dairy.Dairy
	 * @generated
	 */
	public Adapter createDairyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.dairy.Membership <em>Membership</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.dairy.Membership
	 * @generated
	 */
	public Adapter createMembershipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.Party <em>Party</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.Party
	 * @generated
	 */
	public Adapter createPartyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.Person
	 * @generated
	 */
	public Adapter createPersonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.tracking.Transfer <em>Transfer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.tracking.Transfer
	 * @generated
	 */
	public Adapter createTransferAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.tracking.Collection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.tracking.Collection
	 * @generated
	 */
	public Adapter createCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.Company <em>Company</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.Company
	 * @generated
	 */
	public Adapter createCompanyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.model.tracking.Dairy <em>Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.model.tracking.Dairy
	 * @generated
	 */
	public Adapter createTracking_DairyAdapter() {
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
