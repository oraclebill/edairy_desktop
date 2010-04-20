/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model.dairy;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edairy.model.dairy.DairyPackage
 * @generated
 */
public interface DairyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DairyFactory eINSTANCE = edairy.model.dairy.impl.DairyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vehicle</em>'.
	 * @generated
	 */
	Vehicle createVehicle();

	/**
	 * Returns a new object of class '<em>Driver</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Driver</em>'.
	 * @generated
	 */
	Driver createDriver();

	/**
	 * Returns a new object of class '<em>Collection Record</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Record</em>'.
	 * @generated
	 */
	CollectionRecord createCollectionRecord();

	/**
	 * Returns a new object of class '<em>Employee</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Employee</em>'.
	 * @generated
	 */
	Employee createEmployee();

	/**
	 * Returns a new object of class '<em>Collection Centre</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Centre</em>'.
	 * @generated
	 */
	CollectionCentre createCollectionCentre();

	/**
	 * Returns a new object of class '<em>Service Record</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Record</em>'.
	 * @generated
	 */
	ServiceRecord createServiceRecord();

	/**
	 * Returns a new object of class '<em>Workstation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Workstation</em>'.
	 * @generated
	 */
	Workstation createWorkstation();

	/**
	 * Returns a new object of class '<em>Collection Journal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Journal</em>'.
	 * @generated
	 */
	CollectionJournal createCollectionJournal();

	/**
	 * Returns a new object of class '<em>Route Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Route Definition</em>'.
	 * @generated
	 */
	RouteDefinition createRouteDefinition();

	/**
	 * Returns a new object of class '<em>Trip</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trip</em>'.
	 * @generated
	 */
	Trip createTrip();

	/**
	 * Returns a new object of class '<em>Delivery Journal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delivery Journal</em>'.
	 * @generated
	 */
	DeliveryJournal createDeliveryJournal();

	/**
	 * Returns a new object of class '<em>Session</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Session</em>'.
	 * @generated
	 */
	Session createSession();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DairyPackage getDairyPackage();

} //DairyFactory
