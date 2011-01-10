/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base.util;

import com.agritrace.edairy.desktop.common.model.base.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
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
	protected ModelSwitch<Adapter> modelSwitch =
		new ModelSwitch<Adapter>() {
			@Override
			public Adapter caseMapLocation(MapLocation object) {
				return createMapLocationAdapter();
			}
			@Override
			public Adapter casePostalLocation(PostalLocation object) {
				return createPostalLocationAdapter();
			}
			@Override
			public Adapter caseStatutoryLocation(StatutoryLocation object) {
				return createStatutoryLocationAdapter();
			}
			@Override
			public Adapter caseAudited(Audited object) {
				return createAuditedAdapter();
			}
			@Override
			public Adapter caseVersioned(Versioned object) {
				return createVersionedAdapter();
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
			public Adapter caseDescriptiveLocation(DescriptiveLocation object) {
				return createDescriptiveLocationAdapter();
			}
			@Override
			public Adapter caseLocation(Location object) {
				return createLocationAdapter();
			}
			@Override
			public Adapter caseContactMethod(ContactMethod object) {
				return createContactMethodAdapter();
			}
			@Override
			public Adapter caseImageEntry(ImageEntry object) {
				return createImageEntryAdapter();
			}
			@Override
			public Adapter caseSystemUser(SystemUser object) {
				return createSystemUserAdapter();
			}
			@Override
			public Adapter caseRole(Role object) {
				return createRoleAdapter();
			}
			@Override
			public Adapter casePermissionNamespace(PermissionNamespace object) {
				return createPermissionNamespaceAdapter();
			}
			@Override
			public Adapter casePermission(Permission object) {
				return createPermissionAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.MapLocation <em>Map Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.MapLocation
	 * @generated
	 */
	public Adapter createMapLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.PostalLocation <em>Postal Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.PostalLocation
	 * @generated
	 */
	public Adapter createPostalLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.StatutoryLocation <em>Statutory Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.StatutoryLocation
	 * @generated
	 */
	public Adapter createStatutoryLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.Audited <em>Audited</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.Audited
	 * @generated
	 */
	public Adapter createAuditedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.Versioned <em>Versioned</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.Versioned
	 * @generated
	 */
	public Adapter createVersionedAdapter() {
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
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation <em>Descriptive Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation
	 * @generated
	 */
	public Adapter createDescriptiveLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.Location
	 * @generated
	 */
	public Adapter createLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.ContactMethod <em>Contact Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.ContactMethod
	 * @generated
	 */
	public Adapter createContactMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.ImageEntry <em>Image Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.ImageEntry
	 * @generated
	 */
	public Adapter createImageEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser <em>System User</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.SystemUser
	 * @generated
	 */
	public Adapter createSystemUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.Role
	 * @generated
	 */
	public Adapter createRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.PermissionNamespace <em>Permission Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.PermissionNamespace
	 * @generated
	 */
	public Adapter createPermissionNamespaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.base.Permission <em>Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.agritrace.edairy.desktop.common.model.base.Permission
	 * @generated
	 */
	public Adapter createPermissionAdapter() {
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

} //ModelAdapterFactory
