/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.requests;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see com.agritrace.edairy.desktop.common.model.requests.RequestsFactory
 * @model kind="package"
 * @generated
 */
public interface RequestsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "requests";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://edairy.agritrace.com/requests/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "requests";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RequestsPackage eINSTANCE = com.agritrace.edairy.desktop.common.model.requests.impl.RequestsPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl <em>Animal Health Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl
	 * @see com.agritrace.edairy.desktop.common.model.requests.impl.RequestsPackageImpl#getAnimalHealthRequest()
	 * @generated
	 */
	int ANIMAL_HEALTH_REQUEST = 0;

	/**
	 * The feature id for the '<em><b>Request Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_HEALTH_REQUEST__REQUEST_ID = 0;

	/**
	 * The feature id for the '<em><b>Requesting Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER = 1;

	/**
	 * The feature id for the '<em><b>Dairy</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_HEALTH_REQUEST__DAIRY = 2;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_HEALTH_REQUEST__DATE = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_HEALTH_REQUEST__TYPE = 4;

	/**
	 * The feature id for the '<em><b>Reported Problem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM = 5;

	/**
	 * The feature id for the '<em><b>Reported Animal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_HEALTH_REQUEST__REPORTED_ANIMAL = 6;

	/**
	 * The feature id for the '<em><b>Date Heat Detected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED = 7;

	/**
	 * The feature id for the '<em><b>First Treatment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT = 8;

	/**
	 * The feature id for the '<em><b>Second Treatment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT = 9;

	/**
	 * The feature id for the '<em><b>Third Treatment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT = 10;

	/**
	 * The feature id for the '<em><b>Farm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_HEALTH_REQUEST__FARM = 11;

	/**
	 * The feature id for the '<em><b>Referred To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_HEALTH_REQUEST__REFERRED_TO = 12;

	/**
	 * The number of structural features of the '<em>Animal Health Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMAL_HEALTH_REQUEST_FEATURE_COUNT = 13;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.requests.RequestType <em>Request Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.requests.RequestType
	 * @see com.agritrace.edairy.desktop.common.model.requests.impl.RequestsPackageImpl#getRequestType()
	 * @generated
	 */
	int REQUEST_TYPE = 1;


	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest <em>Animal Health Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Animal Health Request</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest
	 * @generated
	 */
	EClass getAnimalHealthRequest();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getRequestId <em>Request Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Request Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getRequestId()
	 * @see #getAnimalHealthRequest()
	 * @generated
	 */
	EAttribute getAnimalHealthRequest_RequestId();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getRequestingMember <em>Requesting Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Requesting Member</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getRequestingMember()
	 * @see #getAnimalHealthRequest()
	 * @generated
	 */
	EReference getAnimalHealthRequest_RequestingMember();

	/**
	 * Returns the meta object for the container reference '{@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getDairy <em>Dairy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dairy</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getDairy()
	 * @see #getAnimalHealthRequest()
	 * @generated
	 */
	EReference getAnimalHealthRequest_Dairy();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getDate()
	 * @see #getAnimalHealthRequest()
	 * @generated
	 */
	EAttribute getAnimalHealthRequest_Date();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getType()
	 * @see #getAnimalHealthRequest()
	 * @generated
	 */
	EAttribute getAnimalHealthRequest_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getReportedProblem <em>Reported Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reported Problem</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getReportedProblem()
	 * @see #getAnimalHealthRequest()
	 * @generated
	 */
	EAttribute getAnimalHealthRequest_ReportedProblem();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getReportedAnimal <em>Reported Animal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reported Animal</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getReportedAnimal()
	 * @see #getAnimalHealthRequest()
	 * @generated
	 */
	EReference getAnimalHealthRequest_ReportedAnimal();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getDateHeatDetected <em>Date Heat Detected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Heat Detected</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getDateHeatDetected()
	 * @see #getAnimalHealthRequest()
	 * @generated
	 */
	EAttribute getAnimalHealthRequest_DateHeatDetected();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getFirstTreatment <em>First Treatment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Treatment</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getFirstTreatment()
	 * @see #getAnimalHealthRequest()
	 * @generated
	 */
	EAttribute getAnimalHealthRequest_FirstTreatment();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getSecondTreatment <em>Second Treatment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Second Treatment</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getSecondTreatment()
	 * @see #getAnimalHealthRequest()
	 * @generated
	 */
	EAttribute getAnimalHealthRequest_SecondTreatment();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getThirdTreatment <em>Third Treatment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Third Treatment</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getThirdTreatment()
	 * @see #getAnimalHealthRequest()
	 * @generated
	 */
	EAttribute getAnimalHealthRequest_ThirdTreatment();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getFarm <em>Farm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Farm</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getFarm()
	 * @see #getAnimalHealthRequest()
	 * @generated
	 */
	EReference getAnimalHealthRequest_Farm();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getReferredTo <em>Referred To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred To</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest#getReferredTo()
	 * @see #getAnimalHealthRequest()
	 * @generated
	 */
	EReference getAnimalHealthRequest_ReferredTo();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.requests.RequestType <em>Request Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Request Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.requests.RequestType
	 * @generated
	 */
	EEnum getRequestType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RequestsFactory getRequestsFactory();

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
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl <em>Animal Health Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl
		 * @see com.agritrace.edairy.desktop.common.model.requests.impl.RequestsPackageImpl#getAnimalHealthRequest()
		 * @generated
		 */
		EClass ANIMAL_HEALTH_REQUEST = eINSTANCE.getAnimalHealthRequest();

		/**
		 * The meta object literal for the '<em><b>Request Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL_HEALTH_REQUEST__REQUEST_ID = eINSTANCE.getAnimalHealthRequest_RequestId();

		/**
		 * The meta object literal for the '<em><b>Requesting Member</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER = eINSTANCE.getAnimalHealthRequest_RequestingMember();

		/**
		 * The meta object literal for the '<em><b>Dairy</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANIMAL_HEALTH_REQUEST__DAIRY = eINSTANCE.getAnimalHealthRequest_Dairy();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL_HEALTH_REQUEST__DATE = eINSTANCE.getAnimalHealthRequest_Date();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL_HEALTH_REQUEST__TYPE = eINSTANCE.getAnimalHealthRequest_Type();

		/**
		 * The meta object literal for the '<em><b>Reported Problem</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM = eINSTANCE.getAnimalHealthRequest_ReportedProblem();

		/**
		 * The meta object literal for the '<em><b>Reported Animal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANIMAL_HEALTH_REQUEST__REPORTED_ANIMAL = eINSTANCE.getAnimalHealthRequest_ReportedAnimal();

		/**
		 * The meta object literal for the '<em><b>Date Heat Detected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED = eINSTANCE.getAnimalHealthRequest_DateHeatDetected();

		/**
		 * The meta object literal for the '<em><b>First Treatment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT = eINSTANCE.getAnimalHealthRequest_FirstTreatment();

		/**
		 * The meta object literal for the '<em><b>Second Treatment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT = eINSTANCE.getAnimalHealthRequest_SecondTreatment();

		/**
		 * The meta object literal for the '<em><b>Third Treatment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT = eINSTANCE.getAnimalHealthRequest_ThirdTreatment();

		/**
		 * The meta object literal for the '<em><b>Farm</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANIMAL_HEALTH_REQUEST__FARM = eINSTANCE.getAnimalHealthRequest_Farm();

		/**
		 * The meta object literal for the '<em><b>Referred To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANIMAL_HEALTH_REQUEST__REFERRED_TO = eINSTANCE.getAnimalHealthRequest_ReferredTo();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.requests.RequestType <em>Request Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.requests.RequestType
		 * @see com.agritrace.edairy.desktop.common.model.requests.impl.RequestsPackageImpl#getRequestType()
		 * @generated
		 */
		EEnum REQUEST_TYPE = eINSTANCE.getRequestType();

	}

} //RequestsPackage
