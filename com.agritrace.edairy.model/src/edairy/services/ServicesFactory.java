/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.services;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edairy.services.ServicesPackage
 * @generated
 */
public interface ServicesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServicesFactory eINSTANCE = edairy.services.impl.ServicesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Dairy Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dairy Service</em>'.
	 * @generated
	 */
	DairyService createDairyService();

	/**
	 * Returns a new object of class '<em>Collection Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Service</em>'.
	 * @generated
	 */
	CollectionService createCollectionService();

	/**
	 * Returns a new object of class '<em>Request Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Request Service</em>'.
	 * @generated
	 */
	RequestService createRequestService();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ServicesPackage getServicesPackage();

} //ServicesFactory
