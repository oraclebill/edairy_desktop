/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.requests.impl;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;

import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.model.requests.RequestType;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;

import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Animal Health Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl#getRequestId <em>Request Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl#getRequestingMember <em>Requesting Member</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl#getDairy <em>Dairy</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl#getDate <em>Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl#getReportedProblem <em>Reported Problem</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl#getReportedAnimal <em>Reported Animal</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl#getDateHeatDetected <em>Date Heat Detected</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl#getFirstTreatment <em>First Treatment</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl#getSecondTreatment <em>Second Treatment</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl#getThirdTreatment <em>Third Treatment</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl#getMember <em>Member</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl#getFarm <em>Farm</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.requests.impl.AnimalHealthRequestImpl#getReferredTo <em>Referred To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnimalHealthRequestImpl extends EObjectImpl implements AnimalHealthRequest {
        /**
         * The default value of the '{@link #getRequestId() <em>Request Id</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getRequestId()
         * @generated
         * @ordered
         */
        protected static final Long REQUEST_ID_EDEFAULT = null;

        /**
         * The cached value of the '{@link #getRequestId() <em>Request Id</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getRequestId()
         * @generated
         * @ordered
         */
        protected Long requestId = REQUEST_ID_EDEFAULT;

        /**
         * The cached value of the '{@link #getRequestingMember() <em>Requesting Member</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getRequestingMember()
         * @generated
         * @ordered
         */
        protected Membership requestingMember;

        /**
         * The cached value of the '{@link #getDairy() <em>Dairy</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getDairy()
         * @generated
         * @ordered
         */
        protected Dairy dairy;

        /**
         * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getDate()
         * @generated
         * @ordered
         */
        protected static final Date DATE_EDEFAULT = null;

        /**
         * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getDate()
         * @generated
         * @ordered
         */
        protected Date date = DATE_EDEFAULT;

        /**
         * The default value of the '{@link #getType() <em>Type</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getType()
         * @generated
         * @ordered
         */
        protected static final RequestType TYPE_EDEFAULT = RequestType.VETERINARY;

        /**
         * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getType()
         * @generated
         * @ordered
         */
        protected RequestType type = TYPE_EDEFAULT;

        /**
         * The default value of the '{@link #getReportedProblem() <em>Reported Problem</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getReportedProblem()
         * @generated
         * @ordered
         */
        protected static final String REPORTED_PROBLEM_EDEFAULT = null;

        /**
         * The cached value of the '{@link #getReportedProblem() <em>Reported Problem</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getReportedProblem()
         * @generated
         * @ordered
         */
        protected String reportedProblem = REPORTED_PROBLEM_EDEFAULT;

        /**
         * The cached value of the '{@link #getReportedAnimal() <em>Reported Animal</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getReportedAnimal()
         * @generated
         * @ordered
         */
        protected RegisteredAnimal reportedAnimal;

        /**
         * The default value of the '{@link #getDateHeatDetected() <em>Date Heat Detected</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getDateHeatDetected()
         * @generated
         * @ordered
         */
        protected static final Date DATE_HEAT_DETECTED_EDEFAULT = null;

        /**
         * The cached value of the '{@link #getDateHeatDetected() <em>Date Heat Detected</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getDateHeatDetected()
         * @generated
         * @ordered
         */
        protected Date dateHeatDetected = DATE_HEAT_DETECTED_EDEFAULT;

        /**
         * The default value of the '{@link #getFirstTreatment() <em>First Treatment</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getFirstTreatment()
         * @generated
         * @ordered
         */
        protected static final Date FIRST_TREATMENT_EDEFAULT = null;

        /**
         * The cached value of the '{@link #getFirstTreatment() <em>First Treatment</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getFirstTreatment()
         * @generated
         * @ordered
         */
        protected Date firstTreatment = FIRST_TREATMENT_EDEFAULT;

        /**
         * The default value of the '{@link #getSecondTreatment() <em>Second Treatment</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getSecondTreatment()
         * @generated
         * @ordered
         */
        protected static final Date SECOND_TREATMENT_EDEFAULT = null;

        /**
         * The cached value of the '{@link #getSecondTreatment() <em>Second Treatment</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getSecondTreatment()
         * @generated
         * @ordered
         */
        protected Date secondTreatment = SECOND_TREATMENT_EDEFAULT;

        /**
         * The default value of the '{@link #getThirdTreatment() <em>Third Treatment</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getThirdTreatment()
         * @generated
         * @ordered
         */
        protected static final Date THIRD_TREATMENT_EDEFAULT = null;

        /**
         * The cached value of the '{@link #getThirdTreatment() <em>Third Treatment</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getThirdTreatment()
         * @generated
         * @ordered
         */
        protected Date thirdTreatment = THIRD_TREATMENT_EDEFAULT;

        /**
         * The cached value of the '{@link #getMember() <em>Member</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getMember()
         * @generated
         * @ordered
         */
        protected Membership member;

        /**
         * The cached value of the '{@link #getFarm() <em>Farm</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getFarm()
         * @generated
         * @ordered
         */
        protected Farm farm;

        /**
         * The cached value of the '{@link #getReferredTo() <em>Referred To</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getReferredTo()
         * @generated
         * @ordered
         */
        protected Supplier referredTo;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected AnimalHealthRequestImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Long getRequestId() {
                return requestId;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setRequestId(Long newRequestId) {
                Long oldRequestId = requestId;
                requestId = newRequestId;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, RequestsPackage.ANIMAL_HEALTH_REQUEST__REQUEST_ID, oldRequestId, requestId));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Membership getRequestingMember() {
                if (requestingMember != null && requestingMember.eIsProxy()) {
                        InternalEObject oldRequestingMember = (InternalEObject)requestingMember;
                        requestingMember = (Membership)eResolveProxy(oldRequestingMember);
                        if (requestingMember != oldRequestingMember) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequestsPackage.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER, oldRequestingMember, requestingMember));
                        }
                }
                return requestingMember;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Membership basicGetRequestingMember() {
                return requestingMember;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setRequestingMember(Membership newRequestingMember) {
                Membership oldRequestingMember = requestingMember;
                requestingMember = newRequestingMember;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, RequestsPackage.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER, oldRequestingMember, requestingMember));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Dairy getDairy() {
                if (dairy != null && dairy.eIsProxy()) {
                        InternalEObject oldDairy = (InternalEObject)dairy;
                        dairy = (Dairy)eResolveProxy(oldDairy);
                        if (dairy != oldDairy) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequestsPackage.ANIMAL_HEALTH_REQUEST__DAIRY, oldDairy, dairy));
                        }
                }
                return dairy;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Dairy basicGetDairy() {
                return dairy;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setDairy(Dairy newDairy) {
                Dairy oldDairy = dairy;
                dairy = newDairy;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, RequestsPackage.ANIMAL_HEALTH_REQUEST__DAIRY, oldDairy, dairy));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Date getDate() {
                return date;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setDate(Date newDate) {
                Date oldDate = date;
                date = newDate;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, RequestsPackage.ANIMAL_HEALTH_REQUEST__DATE, oldDate, date));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public RequestType getType() {
                return type;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setType(RequestType newType) {
                RequestType oldType = type;
                type = newType == null ? TYPE_EDEFAULT : newType;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, RequestsPackage.ANIMAL_HEALTH_REQUEST__TYPE, oldType, type));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public String getReportedProblem() {
                return reportedProblem;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setReportedProblem(String newReportedProblem) {
                String oldReportedProblem = reportedProblem;
                reportedProblem = newReportedProblem;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, RequestsPackage.ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM, oldReportedProblem, reportedProblem));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public RegisteredAnimal getReportedAnimal() {
                if (reportedAnimal != null && reportedAnimal.eIsProxy()) {
                        InternalEObject oldReportedAnimal = (InternalEObject)reportedAnimal;
                        reportedAnimal = (RegisteredAnimal)eResolveProxy(oldReportedAnimal);
                        if (reportedAnimal != oldReportedAnimal) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequestsPackage.ANIMAL_HEALTH_REQUEST__REPORTED_ANIMAL, oldReportedAnimal, reportedAnimal));
                        }
                }
                return reportedAnimal;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public RegisteredAnimal basicGetReportedAnimal() {
                return reportedAnimal;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setReportedAnimal(RegisteredAnimal newReportedAnimal) {
                RegisteredAnimal oldReportedAnimal = reportedAnimal;
                reportedAnimal = newReportedAnimal;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, RequestsPackage.ANIMAL_HEALTH_REQUEST__REPORTED_ANIMAL, oldReportedAnimal, reportedAnimal));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Date getDateHeatDetected() {
                return dateHeatDetected;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setDateHeatDetected(Date newDateHeatDetected) {
                Date oldDateHeatDetected = dateHeatDetected;
                dateHeatDetected = newDateHeatDetected;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, RequestsPackage.ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED, oldDateHeatDetected, dateHeatDetected));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Date getFirstTreatment() {
                return firstTreatment;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setFirstTreatment(Date newFirstTreatment) {
                Date oldFirstTreatment = firstTreatment;
                firstTreatment = newFirstTreatment;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, RequestsPackage.ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT, oldFirstTreatment, firstTreatment));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Date getSecondTreatment() {
                return secondTreatment;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setSecondTreatment(Date newSecondTreatment) {
                Date oldSecondTreatment = secondTreatment;
                secondTreatment = newSecondTreatment;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, RequestsPackage.ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT, oldSecondTreatment, secondTreatment));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Date getThirdTreatment() {
                return thirdTreatment;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setThirdTreatment(Date newThirdTreatment) {
                Date oldThirdTreatment = thirdTreatment;
                thirdTreatment = newThirdTreatment;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, RequestsPackage.ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT, oldThirdTreatment, thirdTreatment));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Membership getMember() {
                if (member != null && member.eIsProxy()) {
                        InternalEObject oldMember = (InternalEObject)member;
                        member = (Membership)eResolveProxy(oldMember);
                        if (member != oldMember) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequestsPackage.ANIMAL_HEALTH_REQUEST__MEMBER, oldMember, member));
                        }
                }
                return member;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Membership basicGetMember() {
                return member;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setMember(Membership newMember) {
                Membership oldMember = member;
                member = newMember;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, RequestsPackage.ANIMAL_HEALTH_REQUEST__MEMBER, oldMember, member));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Farm getFarm() {
                if (farm != null && farm.eIsProxy()) {
                        InternalEObject oldFarm = (InternalEObject)farm;
                        farm = (Farm)eResolveProxy(oldFarm);
                        if (farm != oldFarm) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequestsPackage.ANIMAL_HEALTH_REQUEST__FARM, oldFarm, farm));
                        }
                }
                return farm;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Farm basicGetFarm() {
                return farm;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setFarm(Farm newFarm) {
                Farm oldFarm = farm;
                farm = newFarm;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, RequestsPackage.ANIMAL_HEALTH_REQUEST__FARM, oldFarm, farm));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Supplier getReferredTo() {
                if (referredTo != null && referredTo.eIsProxy()) {
                        InternalEObject oldReferredTo = (InternalEObject)referredTo;
                        referredTo = (Supplier)eResolveProxy(oldReferredTo);
                        if (referredTo != oldReferredTo) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequestsPackage.ANIMAL_HEALTH_REQUEST__REFERRED_TO, oldReferredTo, referredTo));
                        }
                }
                return referredTo;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Supplier basicGetReferredTo() {
                return referredTo;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setReferredTo(Supplier newReferredTo) {
                Supplier oldReferredTo = referredTo;
                referredTo = newReferredTo;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, RequestsPackage.ANIMAL_HEALTH_REQUEST__REFERRED_TO, oldReferredTo, referredTo));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REQUEST_ID:
                                return getRequestId();
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER:
                                if (resolve) return getRequestingMember();
                                return basicGetRequestingMember();
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__DAIRY:
                                if (resolve) return getDairy();
                                return basicGetDairy();
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__DATE:
                                return getDate();
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__TYPE:
                                return getType();
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM:
                                return getReportedProblem();
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REPORTED_ANIMAL:
                                if (resolve) return getReportedAnimal();
                                return basicGetReportedAnimal();
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED:
                                return getDateHeatDetected();
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT:
                                return getFirstTreatment();
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT:
                                return getSecondTreatment();
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT:
                                return getThirdTreatment();
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__MEMBER:
                                if (resolve) return getMember();
                                return basicGetMember();
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__FARM:
                                if (resolve) return getFarm();
                                return basicGetFarm();
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REFERRED_TO:
                                if (resolve) return getReferredTo();
                                return basicGetReferredTo();
                }
                return super.eGet(featureID, resolve, coreType);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public void eSet(int featureID, Object newValue) {
                switch (featureID) {
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REQUEST_ID:
                                setRequestId((Long)newValue);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER:
                                setRequestingMember((Membership)newValue);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__DAIRY:
                                setDairy((Dairy)newValue);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__DATE:
                                setDate((Date)newValue);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__TYPE:
                                setType((RequestType)newValue);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM:
                                setReportedProblem((String)newValue);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REPORTED_ANIMAL:
                                setReportedAnimal((RegisteredAnimal)newValue);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED:
                                setDateHeatDetected((Date)newValue);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT:
                                setFirstTreatment((Date)newValue);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT:
                                setSecondTreatment((Date)newValue);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT:
                                setThirdTreatment((Date)newValue);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__MEMBER:
                                setMember((Membership)newValue);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__FARM:
                                setFarm((Farm)newValue);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REFERRED_TO:
                                setReferredTo((Supplier)newValue);
                                return;
                }
                super.eSet(featureID, newValue);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public void eUnset(int featureID) {
                switch (featureID) {
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REQUEST_ID:
                                setRequestId(REQUEST_ID_EDEFAULT);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER:
                                setRequestingMember((Membership)null);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__DAIRY:
                                setDairy((Dairy)null);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__DATE:
                                setDate(DATE_EDEFAULT);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__TYPE:
                                setType(TYPE_EDEFAULT);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM:
                                setReportedProblem(REPORTED_PROBLEM_EDEFAULT);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REPORTED_ANIMAL:
                                setReportedAnimal((RegisteredAnimal)null);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED:
                                setDateHeatDetected(DATE_HEAT_DETECTED_EDEFAULT);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT:
                                setFirstTreatment(FIRST_TREATMENT_EDEFAULT);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT:
                                setSecondTreatment(SECOND_TREATMENT_EDEFAULT);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT:
                                setThirdTreatment(THIRD_TREATMENT_EDEFAULT);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__MEMBER:
                                setMember((Membership)null);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__FARM:
                                setFarm((Farm)null);
                                return;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REFERRED_TO:
                                setReferredTo((Supplier)null);
                                return;
                }
                super.eUnset(featureID);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public boolean eIsSet(int featureID) {
                switch (featureID) {
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REQUEST_ID:
                                return REQUEST_ID_EDEFAULT == null ? requestId != null : !REQUEST_ID_EDEFAULT.equals(requestId);
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER:
                                return requestingMember != null;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__DAIRY:
                                return dairy != null;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__DATE:
                                return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__TYPE:
                                return type != TYPE_EDEFAULT;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM:
                                return REPORTED_PROBLEM_EDEFAULT == null ? reportedProblem != null : !REPORTED_PROBLEM_EDEFAULT.equals(reportedProblem);
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REPORTED_ANIMAL:
                                return reportedAnimal != null;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED:
                                return DATE_HEAT_DETECTED_EDEFAULT == null ? dateHeatDetected != null : !DATE_HEAT_DETECTED_EDEFAULT.equals(dateHeatDetected);
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT:
                                return FIRST_TREATMENT_EDEFAULT == null ? firstTreatment != null : !FIRST_TREATMENT_EDEFAULT.equals(firstTreatment);
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT:
                                return SECOND_TREATMENT_EDEFAULT == null ? secondTreatment != null : !SECOND_TREATMENT_EDEFAULT.equals(secondTreatment);
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT:
                                return THIRD_TREATMENT_EDEFAULT == null ? thirdTreatment != null : !THIRD_TREATMENT_EDEFAULT.equals(thirdTreatment);
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__MEMBER:
                                return member != null;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__FARM:
                                return farm != null;
                        case RequestsPackage.ANIMAL_HEALTH_REQUEST__REFERRED_TO:
                                return referredTo != null;
                }
                return super.eIsSet(featureID);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public String toString() {
                if (eIsProxy()) return super.toString();

                StringBuffer result = new StringBuffer(super.toString());
                result.append(" (requestId: ");
                result.append(requestId);
                result.append(", date: ");
                result.append(date);
                result.append(", type: ");
                result.append(type);
                result.append(", reportedProblem: ");
                result.append(reportedProblem);
                result.append(", dateHeatDetected: ");
                result.append(dateHeatDetected);
                result.append(", firstTreatment: ");
                result.append(firstTreatment);
                result.append(", secondTreatment: ");
                result.append(secondTreatment);
                result.append(", thirdTreatment: ");
                result.append(thirdTreatment);
                result.append(')');
                return result.toString();
        }

} //AnimalHealthRequestImpl
