/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.requests;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.model.dairy.Dairy;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.dairy.Supplier;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.model.tracking.RegisteredAnimal;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Animal Health Request</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getRequestId
 * <em>Request Id</em>}</li>
 * <li>
 * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getRequestingMember
 * <em>Requesting Member</em>}</li>
 * <li>{@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getDairy
 * <em>Dairy</em>}</li>
 * <li>{@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getDate
 * <em>Date</em>}</li>
 * <li>{@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getType
 * <em>Type</em>}</li>
 * <li>
 * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getReportedProblem
 * <em>Reported Problem</em>}</li>
 * <li>
 * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getReportedAnimal
 * <em>Reported Animal</em>}</li>
 * <li>
 * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getDateHeatDetected
 * <em>Date Heat Detected</em>}</li>
 * <li>
 * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getFirstTreatment
 * <em>First Treatment</em>}</li>
 * <li>
 * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getSecondTreatment
 * <em>Second Treatment</em>}</li>
 * <li>
 * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getThirdTreatment
 * <em>Third Treatment</em>}</li>
 * <li>{@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getMember
 * <em>Member</em>}</li>
 * <li>{@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getFarm
 * <em>Farm</em>}</li>
 * <li>
 * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getReferredTo
 * <em>Referred To</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.agritrace.edairy.model.requests.RequestsPackage#getAnimalHealthRequest()
 * @model
 * @generated
 */
public interface AnimalHealthRequest extends EObject {
    /**
     * Returns the value of the '<em><b>Request Id</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Request Id</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Request Id</em>' attribute.
     * @see #setRequestId(Long)
     * @see com.agritrace.edairy.model.requests.RequestsPackage#getAnimalHealthRequest_RequestId()
     * @model dataType="com.agritrace.edairy.model.UniqueID"
     * @generated
     */
    Long getRequestId();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getRequestId
     * <em>Request Id</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Request Id</em>' attribute.
     * @see #getRequestId()
     * @generated
     */
    void setRequestId(Long value);

    /**
     * Returns the value of the '<em><b>Requesting Member</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Requesting Member</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Requesting Member</em>' reference.
     * @see #setRequestingMember(Membership)
     * @see com.agritrace.edairy.model.requests.RequestsPackage#getAnimalHealthRequest_RequestingMember()
     * @model required="true"
     * @generated
     */
    Membership getRequestingMember();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getRequestingMember
     * <em>Requesting Member</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Requesting Member</em>' reference.
     * @see #getRequestingMember()
     * @generated
     */
    void setRequestingMember(Membership value);

    /**
     * Returns the value of the '<em><b>Dairy</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dairy</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Dairy</em>' reference.
     * @see #setDairy(Dairy)
     * @see com.agritrace.edairy.model.requests.RequestsPackage#getAnimalHealthRequest_Dairy()
     * @model required="true"
     * @generated
     */
    Dairy getDairy();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getDairy
     * <em>Dairy</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Dairy</em>' reference.
     * @see #getDairy()
     * @generated
     */
    void setDairy(Dairy value);

    /**
     * Returns the value of the '<em><b>Date</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Date</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Date</em>' attribute.
     * @see #setDate(Date)
     * @see com.agritrace.edairy.model.requests.RequestsPackage#getAnimalHealthRequest_Date()
     * @model
     * @generated
     */
    Date getDate();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getDate
     * <em>Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Date</em>' attribute.
     * @see #getDate()
     * @generated
     */
    void setDate(Date value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute. The literals
     * are from the enumeration
     * {@link com.agritrace.edairy.model.requests.RequestType}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Type</em>' attribute.
     * @see com.agritrace.edairy.model.requests.RequestType
     * @see #setType(RequestType)
     * @see com.agritrace.edairy.model.requests.RequestsPackage#getAnimalHealthRequest_Type()
     * @model
     * @generated
     */
    RequestType getType();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getType
     * <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Type</em>' attribute.
     * @see com.agritrace.edairy.model.requests.RequestType
     * @see #getType()
     * @generated
     */
    void setType(RequestType value);

    /**
     * Returns the value of the '<em><b>Reported Problem</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reported Problem</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Reported Problem</em>' attribute.
     * @see #setReportedProblem(String)
     * @see com.agritrace.edairy.model.requests.RequestsPackage#getAnimalHealthRequest_ReportedProblem()
     * @model
     * @generated
     */
    String getReportedProblem();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getReportedProblem
     * <em>Reported Problem</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Reported Problem</em>' attribute.
     * @see #getReportedProblem()
     * @generated
     */
    void setReportedProblem(String value);

    /**
     * Returns the value of the '<em><b>Reported Animal</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reported Animal</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Reported Animal</em>' reference.
     * @see #setReportedAnimal(RegisteredAnimal)
     * @see com.agritrace.edairy.model.requests.RequestsPackage#getAnimalHealthRequest_ReportedAnimal()
     * @model
     * @generated
     */
    RegisteredAnimal getReportedAnimal();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getReportedAnimal
     * <em>Reported Animal</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Reported Animal</em>' reference.
     * @see #getReportedAnimal()
     * @generated
     */
    void setReportedAnimal(RegisteredAnimal value);

    /**
     * Returns the value of the '<em><b>Date Heat Detected</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Date Heat Detected</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Date Heat Detected</em>' attribute.
     * @see #setDateHeatDetected(Date)
     * @see com.agritrace.edairy.model.requests.RequestsPackage#getAnimalHealthRequest_DateHeatDetected()
     * @model
     * @generated
     */
    Date getDateHeatDetected();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getDateHeatDetected
     * <em>Date Heat Detected</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Date Heat Detected</em>' attribute.
     * @see #getDateHeatDetected()
     * @generated
     */
    void setDateHeatDetected(Date value);

    /**
     * Returns the value of the '<em><b>First Treatment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>First Treatment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>First Treatment</em>' attribute.
     * @see #setFirstTreatment(Date)
     * @see com.agritrace.edairy.model.requests.RequestsPackage#getAnimalHealthRequest_FirstTreatment()
     * @model
     * @generated
     */
    Date getFirstTreatment();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getFirstTreatment
     * <em>First Treatment</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>First Treatment</em>' attribute.
     * @see #getFirstTreatment()
     * @generated
     */
    void setFirstTreatment(Date value);

    /**
     * Returns the value of the '<em><b>Second Treatment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Second Treatment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Second Treatment</em>' attribute.
     * @see #setSecondTreatment(Date)
     * @see com.agritrace.edairy.model.requests.RequestsPackage#getAnimalHealthRequest_SecondTreatment()
     * @model
     * @generated
     */
    Date getSecondTreatment();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getSecondTreatment
     * <em>Second Treatment</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Second Treatment</em>' attribute.
     * @see #getSecondTreatment()
     * @generated
     */
    void setSecondTreatment(Date value);

    /**
     * Returns the value of the '<em><b>Third Treatment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Third Treatment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Third Treatment</em>' attribute.
     * @see #setThirdTreatment(Date)
     * @see com.agritrace.edairy.model.requests.RequestsPackage#getAnimalHealthRequest_ThirdTreatment()
     * @model
     * @generated
     */
    Date getThirdTreatment();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getThirdTreatment
     * <em>Third Treatment</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Third Treatment</em>' attribute.
     * @see #getThirdTreatment()
     * @generated
     */
    void setThirdTreatment(Date value);

    /**
     * Returns the value of the '<em><b>Member</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Member</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Member</em>' reference.
     * @see #setMember(Membership)
     * @see com.agritrace.edairy.model.requests.RequestsPackage#getAnimalHealthRequest_Member()
     * @model required="true"
     * @generated
     */
    Membership getMember();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getMember
     * <em>Member</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Member</em>' reference.
     * @see #getMember()
     * @generated
     */
    void setMember(Membership value);

    /**
     * Returns the value of the '<em><b>Farm</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Farm</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Farm</em>' reference.
     * @see #setFarm(Farm)
     * @see com.agritrace.edairy.model.requests.RequestsPackage#getAnimalHealthRequest_Farm()
     * @model required="true"
     * @generated
     */
    Farm getFarm();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getFarm
     * <em>Farm</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Farm</em>' reference.
     * @see #getFarm()
     * @generated
     */
    void setFarm(Farm value);

    /**
     * Returns the value of the '<em><b>Referred To</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referred To</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Referred To</em>' reference.
     * @see #setReferredTo(Supplier)
     * @see com.agritrace.edairy.model.requests.RequestsPackage#getAnimalHealthRequest_ReferredTo()
     * @model
     * @generated
     */
    Supplier getReferredTo();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.requests.AnimalHealthRequest#getReferredTo
     * <em>Referred To</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Referred To</em>' reference.
     * @see #getReferredTo()
     * @generated
     */
    void setReferredTo(Supplier value);

} // AnimalHealthRequest
