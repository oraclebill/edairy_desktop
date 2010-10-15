/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking;

import com.agritrace.edairy.desktop.common.model.base.Gender;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Registered Animal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getRegistrationId <em>Registration Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getGivenName <em>Given Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getLocation <em>Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getGender <em>Gender</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getAnimalType <em>Animal Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getSireType <em>Sire Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getDateOfAcquisition <em>Date Of Acquisition</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getAcquisitionType <em>Acquisition Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getIdentifiers <em>Identifiers</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getIdentifyingFeatures <em>Identifying Features</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getRearingMode <em>Rearing Mode</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getPastOwners <em>Past Owners</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getInsuranceNumber <em>Insurance Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getDateOfBirth <em>Date Of Birth</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getBirthCertificateNumber <em>Birth Certificate Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getVeterinaryCertificateNumber <em>Veterinary Certificate Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getMinistryId <em>Ministry Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getInsuranceCompany <em>Insurance Company</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getFeedingHabit <em>Feeding Habit</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getFeedType <em>Feed Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getFeedBrand <em>Feed Brand</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getSupplements <em>Supplements</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getAntibiotics <em>Antibiotics</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getVeterinary <em>Veterinary</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getAwards <em>Awards</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getNotes <em>Notes</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal()
 * @model
 * @generated
 */
public interface RegisteredAnimal extends EObject {
	/**
	 * Returns the value of the '<em><b>Registration Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registration Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registration Id</em>' attribute.
	 * @see #setRegistrationId(long)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_RegistrationId()
	 * @model id="true" required="true"
	 * @generated
	 */
	long getRegistrationId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getRegistrationId <em>Registration Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registration Id</em>' attribute.
	 * @see #getRegistrationId()
	 * @generated
	 */
	void setRegistrationId(long value);

	/**
	 * Returns the value of the '<em><b>Given Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Given Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Given Name</em>' attribute.
	 * @see #setGivenName(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_GivenName()
	 * @model default="" required="true"
	 * @generated
	 */
	String getGivenName();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getGivenName <em>Given Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Given Name</em>' attribute.
	 * @see #getGivenName()
	 * @generated
	 */
	void setGivenName(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' reference.
	 * @see #setLocation(Farm)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_Location()
	 * @model required="true"
	 * @generated
	 */
	Farm getLocation();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getLocation <em>Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Farm value);

	/**
	 * Returns the value of the '<em><b>Gender</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.base.Gender}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gender</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gender</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.base.Gender
	 * @see #setGender(Gender)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_Gender()
	 * @model default="" required="true"
	 * @generated
	 */
	Gender getGender();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getGender <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gender</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.base.Gender
	 * @see #getGender()
	 * @generated
	 */
	void setGender(Gender value);

	/**
	 * Returns the value of the '<em><b>Animal Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animal Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animal Type</em>' reference.
	 * @see #setAnimalType(ReferenceAnimalType)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_AnimalType()
	 * @model required="true"
	 *        extendedMetaData="name='animalType' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@ManyToOne(cascade=PERSIST)'"
	 * @generated
	 */
	ReferenceAnimalType getAnimalType();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getAnimalType <em>Animal Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Animal Type</em>' reference.
	 * @see #getAnimalType()
	 * @generated
	 */
	void setAnimalType(ReferenceAnimalType value);

	/**
	 * Returns the value of the '<em><b>Sire Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sire Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sire Type</em>' containment reference.
	 * @see #setSireType(ReferenceAnimalType)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_SireType()
	 * @model containment="true"
	 * @generated
	 */
	ReferenceAnimalType getSireType();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getSireType <em>Sire Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sire Type</em>' containment reference.
	 * @see #getSireType()
	 * @generated
	 */
	void setSireType(ReferenceAnimalType value);

	/**
	 * Returns the value of the '<em><b>Purpose</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.tracking.Purpose}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Purpose</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Purpose</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.tracking.Purpose
	 * @see #setPurpose(Purpose)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_Purpose()
	 * @model default="" required="true"
	 * @generated
	 */
	Purpose getPurpose();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getPurpose <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Purpose</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.tracking.Purpose
	 * @see #getPurpose()
	 * @generated
	 */
	void setPurpose(Purpose value);

	/**
	 * Returns the value of the '<em><b>Date Of Acquisition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Of Acquisition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Of Acquisition</em>' attribute.
	 * @see #setDateOfAcquisition(Date)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_DateOfAcquisition()
	 * @model
	 * @generated
	 */
	Date getDateOfAcquisition();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getDateOfAcquisition <em>Date Of Acquisition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Of Acquisition</em>' attribute.
	 * @see #getDateOfAcquisition()
	 * @generated
	 */
	void setDateOfAcquisition(Date value);

	/**
	 * Returns the value of the '<em><b>Acquisition Type</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.tracking.AcquisitionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Acquisition Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acquisition Type</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.tracking.AcquisitionType
	 * @see #setAcquisitionType(AcquisitionType)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_AcquisitionType()
	 * @model default=""
	 * @generated
	 */
	AcquisitionType getAcquisitionType();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getAcquisitionType <em>Acquisition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acquisition Type</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.tracking.AcquisitionType
	 * @see #getAcquisitionType()
	 * @generated
	 */
	void setAcquisitionType(AcquisitionType value);

	/**
	 * Returns the value of the '<em><b>Identifiers</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.tracking.AnimalIdentifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifiers</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_Identifiers()
	 * @model containment="true"
	 * @generated
	 */
	EList<AnimalIdentifier> getIdentifiers();

	/**
	 * Returns the value of the '<em><b>Identifying Features</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifying Features</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifying Features</em>' attribute.
	 * @see #setIdentifyingFeatures(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_IdentifyingFeatures()
	 * @model
	 * @generated
	 */
	String getIdentifyingFeatures();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getIdentifyingFeatures <em>Identifying Features</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifying Features</em>' attribute.
	 * @see #getIdentifyingFeatures()
	 * @generated
	 */
	void setIdentifyingFeatures(String value);

	/**
	 * Returns the value of the '<em><b>Rearing Mode</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.tracking.RearingMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rearing Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rearing Mode</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.tracking.RearingMode
	 * @see #setRearingMode(RearingMode)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_RearingMode()
	 * @model default="" required="true"
	 * @generated
	 */
	RearingMode getRearingMode();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getRearingMode <em>Rearing Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rearing Mode</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.tracking.RearingMode
	 * @see #getRearingMode()
	 * @generated
	 */
	void setRearingMode(RearingMode value);

	/**
	 * Returns the value of the '<em><b>Past Owners</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Past Owners</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Past Owners</em>' attribute list.
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_PastOwners()
	 * @model
	 * @generated
	 */
	EList<String> getPastOwners();

	/**
	 * Returns the value of the '<em><b>Insurance Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Insurance Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Insurance Number</em>' attribute.
	 * @see #setInsuranceNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_InsuranceNumber()
	 * @model
	 * @generated
	 */
	String getInsuranceNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getInsuranceNumber <em>Insurance Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Insurance Number</em>' attribute.
	 * @see #getInsuranceNumber()
	 * @generated
	 */
	void setInsuranceNumber(String value);

	/**
	 * Returns the value of the '<em><b>Date Of Birth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Of Birth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Of Birth</em>' attribute.
	 * @see #setDateOfBirth(Date)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_DateOfBirth()
	 * @model required="true"
	 * @generated
	 */
	Date getDateOfBirth();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getDateOfBirth <em>Date Of Birth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Of Birth</em>' attribute.
	 * @see #getDateOfBirth()
	 * @generated
	 */
	void setDateOfBirth(Date value);

	/**
	 * Returns the value of the '<em><b>Birth Certificate Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Birth Certificate Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Birth Certificate Number</em>' attribute.
	 * @see #setBirthCertificateNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_BirthCertificateNumber()
	 * @model
	 * @generated
	 */
	String getBirthCertificateNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getBirthCertificateNumber <em>Birth Certificate Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Birth Certificate Number</em>' attribute.
	 * @see #getBirthCertificateNumber()
	 * @generated
	 */
	void setBirthCertificateNumber(String value);

	/**
	 * Returns the value of the '<em><b>Veterinary Certificate Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Veterinary Certificate Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Veterinary Certificate Number</em>' attribute.
	 * @see #setVeterinaryCertificateNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_VeterinaryCertificateNumber()
	 * @model
	 * @generated
	 */
	String getVeterinaryCertificateNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getVeterinaryCertificateNumber <em>Veterinary Certificate Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Veterinary Certificate Number</em>' attribute.
	 * @see #getVeterinaryCertificateNumber()
	 * @generated
	 */
	void setVeterinaryCertificateNumber(String value);

	/**
	 * Returns the value of the '<em><b>Ministry Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ministry Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ministry Id</em>' attribute.
	 * @see #setMinistryId(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_MinistryId()
	 * @model
	 * @generated
	 */
	String getMinistryId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getMinistryId <em>Ministry Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ministry Id</em>' attribute.
	 * @see #getMinistryId()
	 * @generated
	 */
	void setMinistryId(String value);

	/**
	 * Returns the value of the '<em><b>Insurance Company</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Insurance Company</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Insurance Company</em>' attribute.
	 * @see #setInsuranceCompany(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_InsuranceCompany()
	 * @model
	 * @generated
	 */
	String getInsuranceCompany();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getInsuranceCompany <em>Insurance Company</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Insurance Company</em>' attribute.
	 * @see #getInsuranceCompany()
	 * @generated
	 */
	void setInsuranceCompany(String value);

	/**
	 * Returns the value of the '<em><b>Feeding Habit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feeding Habit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feeding Habit</em>' attribute.
	 * @see #setFeedingHabit(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_FeedingHabit()
	 * @model
	 * @generated
	 */
	String getFeedingHabit();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getFeedingHabit <em>Feeding Habit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feeding Habit</em>' attribute.
	 * @see #getFeedingHabit()
	 * @generated
	 */
	void setFeedingHabit(String value);

	/**
	 * Returns the value of the '<em><b>Feed Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feed Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feed Type</em>' attribute.
	 * @see #setFeedType(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_FeedType()
	 * @model
	 * @generated
	 */
	String getFeedType();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getFeedType <em>Feed Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feed Type</em>' attribute.
	 * @see #getFeedType()
	 * @generated
	 */
	void setFeedType(String value);

	/**
	 * Returns the value of the '<em><b>Feed Brand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feed Brand</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feed Brand</em>' attribute.
	 * @see #setFeedBrand(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_FeedBrand()
	 * @model
	 * @generated
	 */
	String getFeedBrand();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getFeedBrand <em>Feed Brand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feed Brand</em>' attribute.
	 * @see #getFeedBrand()
	 * @generated
	 */
	void setFeedBrand(String value);

	/**
	 * Returns the value of the '<em><b>Supplements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supplements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supplements</em>' attribute.
	 * @see #setSupplements(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_Supplements()
	 * @model
	 * @generated
	 */
	String getSupplements();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getSupplements <em>Supplements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supplements</em>' attribute.
	 * @see #getSupplements()
	 * @generated
	 */
	void setSupplements(String value);

	/**
	 * Returns the value of the '<em><b>Antibiotics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Antibiotics</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Antibiotics</em>' attribute.
	 * @see #setAntibiotics(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_Antibiotics()
	 * @model
	 * @generated
	 */
	String getAntibiotics();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getAntibiotics <em>Antibiotics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Antibiotics</em>' attribute.
	 * @see #getAntibiotics()
	 * @generated
	 */
	void setAntibiotics(String value);

	/**
	 * Returns the value of the '<em><b>Veterinary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Veterinary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Veterinary</em>' attribute.
	 * @see #setVeterinary(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_Veterinary()
	 * @model
	 * @generated
	 */
	String getVeterinary();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getVeterinary <em>Veterinary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Veterinary</em>' attribute.
	 * @see #getVeterinary()
	 * @generated
	 */
	void setVeterinary(String value);

	/**
	 * Returns the value of the '<em><b>Awards</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Awards</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Awards</em>' attribute.
	 * @see #setAwards(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_Awards()
	 * @model
	 * @generated
	 */
	String getAwards();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getAwards <em>Awards</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Awards</em>' attribute.
	 * @see #getAwards()
	 * @generated
	 */
	void setAwards(String value);

	/**
	 * Returns the value of the '<em><b>Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notes</em>' attribute.
	 * @see #setNotes(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getRegisteredAnimal_Notes()
	 * @model
	 * @generated
	 */
	String getNotes();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal#getNotes <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notes</em>' attribute.
	 * @see #getNotes()
	 * @generated
	 */
	void setNotes(String value);

} // RegisteredAnimal
