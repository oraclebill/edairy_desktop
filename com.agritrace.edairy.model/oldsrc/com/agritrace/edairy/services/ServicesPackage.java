/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.services;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.services.ServicesFactory
 * @model kind="package"
 * @generated
 */
public interface ServicesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "services";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://com.agritrace.edairy.model/services";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "services";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServicesPackage eINSTANCE = com.agritrace.edairy.services.impl.ServicesPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.services.impl.DairyServiceImpl <em>Dairy Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.services.impl.DairyServiceImpl
	 * @see com.agritrace.edairy.services.impl.ServicesPackageImpl#getDairyService()
	 * @generated
	 */
	int DAIRY_SERVICE = 0;

	/**
	 * The feature id for the '<em><b>Routes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_SERVICE__ROUTES = 0;

	/**
	 * The feature id for the '<em><b>Sessions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_SERVICE__SESSIONS = 1;

	/**
	 * The feature id for the '<em><b>Vehicles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_SERVICE__VEHICLES = 2;

	/**
	 * The feature id for the '<em><b>Employees</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_SERVICE__EMPLOYEES = 3;

	/**
	 * The feature id for the '<em><b>Containers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_SERVICE__CONTAINERS = 4;

	/**
	 * The number of structural features of the '<em>Dairy Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAIRY_SERVICE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.services.impl.CollectionServiceImpl <em>Collection Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.services.impl.CollectionServiceImpl
	 * @see com.agritrace.edairy.services.impl.ServicesPackageImpl#getCollectionService()
	 * @generated
	 */
	int COLLECTION_SERVICE = 1;

	/**
	 * The feature id for the '<em><b>Journals</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_SERVICE__JOURNALS = 0;

	/**
	 * The number of structural features of the '<em>Collection Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_SERVICE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.services.impl.RequestServiceImpl <em>Request Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.services.impl.RequestServiceImpl
	 * @see com.agritrace.edairy.services.impl.ServicesPackageImpl#getRequestService()
	 * @generated
	 */
	int REQUEST_SERVICE = 2;

	/**
	 * The number of structural features of the '<em>Request Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SERVICE_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.services.DairyService <em>Dairy Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dairy Service</em>'.
	 * @see com.agritrace.edairy.services.DairyService
	 * @generated
	 */
	EClass getDairyService();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.services.DairyService#getRoutes <em>Routes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Routes</em>'.
	 * @see com.agritrace.edairy.services.DairyService#getRoutes()
	 * @see #getDairyService()
	 * @generated
	 */
	EAttribute getDairyService_Routes();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.services.DairyService#getSessions <em>Sessions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sessions</em>'.
	 * @see com.agritrace.edairy.services.DairyService#getSessions()
	 * @see #getDairyService()
	 * @generated
	 */
	EAttribute getDairyService_Sessions();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.services.DairyService#getVehicles <em>Vehicles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vehicles</em>'.
	 * @see com.agritrace.edairy.services.DairyService#getVehicles()
	 * @see #getDairyService()
	 * @generated
	 */
	EAttribute getDairyService_Vehicles();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.services.DairyService#getEmployees <em>Employees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Employees</em>'.
	 * @see com.agritrace.edairy.services.DairyService#getEmployees()
	 * @see #getDairyService()
	 * @generated
	 */
	EAttribute getDairyService_Employees();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.services.DairyService#getContainers <em>Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Containers</em>'.
	 * @see com.agritrace.edairy.services.DairyService#getContainers()
	 * @see #getDairyService()
	 * @generated
	 */
	EAttribute getDairyService_Containers();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.services.CollectionService <em>Collection Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Service</em>'.
	 * @see com.agritrace.edairy.services.CollectionService
	 * @generated
	 */
	EClass getCollectionService();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.services.CollectionService#getJournals <em>Journals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Journals</em>'.
	 * @see com.agritrace.edairy.services.CollectionService#getJournals()
	 * @see #getCollectionService()
	 * @generated
	 */
	EAttribute getCollectionService_Journals();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.services.RequestService <em>Request Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Request Service</em>'.
	 * @see com.agritrace.edairy.services.RequestService
	 * @generated
	 */
	EClass getRequestService();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ServicesFactory getServicesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.services.impl.DairyServiceImpl <em>Dairy Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.services.impl.DairyServiceImpl
		 * @see com.agritrace.edairy.services.impl.ServicesPackageImpl#getDairyService()
		 * @generated
		 */
		EClass DAIRY_SERVICE = eINSTANCE.getDairyService();

		/**
		 * The meta object literal for the '<em><b>Routes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY_SERVICE__ROUTES = eINSTANCE.getDairyService_Routes();

		/**
		 * The meta object literal for the '<em><b>Sessions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY_SERVICE__SESSIONS = eINSTANCE.getDairyService_Sessions();

		/**
		 * The meta object literal for the '<em><b>Vehicles</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY_SERVICE__VEHICLES = eINSTANCE.getDairyService_Vehicles();

		/**
		 * The meta object literal for the '<em><b>Employees</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY_SERVICE__EMPLOYEES = eINSTANCE.getDairyService_Employees();

		/**
		 * The meta object literal for the '<em><b>Containers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAIRY_SERVICE__CONTAINERS = eINSTANCE.getDairyService_Containers();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.services.impl.CollectionServiceImpl <em>Collection Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.services.impl.CollectionServiceImpl
		 * @see com.agritrace.edairy.services.impl.ServicesPackageImpl#getCollectionService()
		 * @generated
		 */
		EClass COLLECTION_SERVICE = eINSTANCE.getCollectionService();

		/**
		 * The meta object literal for the '<em><b>Journals</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_SERVICE__JOURNALS = eINSTANCE.getCollectionService_Journals();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.services.impl.RequestServiceImpl <em>Request Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.services.impl.RequestServiceImpl
		 * @see com.agritrace.edairy.services.impl.ServicesPackageImpl#getRequestService()
		 * @generated
		 */
		EClass REQUEST_SERVICE = eINSTANCE.getRequestService();

	}

} //ServicesPackage
