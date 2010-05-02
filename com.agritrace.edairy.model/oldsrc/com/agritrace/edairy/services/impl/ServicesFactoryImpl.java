/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.services.impl;

import com.agritrace.edairy.services.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServicesFactoryImpl extends EFactoryImpl implements ServicesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServicesFactory init() {
		try {
			ServicesFactory theServicesFactory = (ServicesFactory)EPackage.Registry.INSTANCE.getEFactory("http://com.agritrace.edairy.model/services"); 
			if (theServicesFactory != null) {
				return theServicesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ServicesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicesFactoryImpl() {
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
			case ServicesPackage.DAIRY_SERVICE: return createDairyService();
			case ServicesPackage.COLLECTION_SERVICE: return createCollectionService();
			case ServicesPackage.REQUEST_SERVICE: return createRequestService();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyService createDairyService() {
		DairyServiceImpl dairyService = new DairyServiceImpl();
		return dairyService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionService createCollectionService() {
		CollectionServiceImpl collectionService = new CollectionServiceImpl();
		return collectionService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequestService createRequestService() {
		RequestServiceImpl requestService = new RequestServiceImpl();
		return requestService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicesPackage getServicesPackage() {
		return (ServicesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ServicesPackage getPackage() {
		return ServicesPackage.eINSTANCE;
	}

} //ServicesFactoryImpl
