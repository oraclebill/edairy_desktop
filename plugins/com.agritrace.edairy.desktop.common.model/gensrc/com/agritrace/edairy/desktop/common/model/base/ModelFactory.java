/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelFactory eINSTANCE = com.agritrace.edairy.desktop.common.model.base.impl.ModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Map Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Location</em>'.
	 * @generated
	 */
	MapLocation createMapLocation();

	/**
	 * Returns a new object of class '<em>Postal Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Postal Location</em>'.
	 * @generated
	 */
	PostalLocation createPostalLocation();

	/**
	 * Returns a new object of class '<em>Statutory Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statutory Location</em>'.
	 * @generated
	 */
	StatutoryLocation createStatutoryLocation();

	/**
	 * Returns a new object of class '<em>Audited</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Audited</em>'.
	 * @generated
	 */
	Audited createAudited();

	/**
	 * Returns a new object of class '<em>Versioned</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Versioned</em>'.
	 * @generated
	 */
	Versioned createVersioned();

	/**
	 * Returns a new object of class '<em>Contactable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contactable</em>'.
	 * @generated
	 */
	Contactable createContactable();

	/**
	 * Returns a new object of class '<em>Person</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Person</em>'.
	 * @generated
	 */
	Person createPerson();

	/**
	 * Returns a new object of class '<em>Company</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Company</em>'.
	 * @generated
	 */
	Company createCompany();

	/**
	 * Returns a new object of class '<em>Descriptive Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Descriptive Location</em>'.
	 * @generated
	 */
	DescriptiveLocation createDescriptiveLocation();

	/**
	 * Returns a new object of class '<em>Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Location</em>'.
	 * @generated
	 */
	Location createLocation();

	/**
	 * Returns a new object of class '<em>Contact Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contact Method</em>'.
	 * @generated
	 */
	ContactMethod createContactMethod();

	/**
	 * Returns a new object of class '<em>Image Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Entry</em>'.
	 * @generated
	 */
	ImageEntry createImageEntry();

	/**
	 * Returns a new object of class '<em>System User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System User</em>'.
	 * @generated
	 */
	SystemUser createSystemUser();

	/**
	 * Returns a new object of class '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role</em>'.
	 * @generated
	 */
	Role createRole();

	/**
	 * Returns a new object of class '<em>Permission Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Permission Namespace</em>'.
	 * @generated
	 */
	PermissionNamespace createPermissionNamespace();

	/**
	 * Returns a new object of class '<em>Permission</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Permission</em>'.
	 * @generated
	 */
	Permission createPermission();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();

} //ModelFactory
