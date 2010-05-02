/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package requests;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see requests.RequestsPackage
 * @generated
 */
public interface RequestsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RequestsFactory eINSTANCE = requests.impl.RequestsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Animal Health Request</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Animal Health Request</em>'.
	 * @generated
	 */
	AnimalHealthRequest createAnimalHealthRequest();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RequestsPackage getRequestsPackage();

} //RequestsFactory
