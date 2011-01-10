/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Person#getPhoto <em>Photo</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Person#getHonorific <em>Honorific</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Person#getFamilyName <em>Family Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Person#getGivenName <em>Given Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Person#getMiddleName <em>Middle Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Person#getAdditionalNames <em>Additional Names</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Person#getSuffix <em>Suffix</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Person#getNickName <em>Nick Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Person#getPhoneNumber <em>Phone Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Person#getLocation <em>Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Person#getPersonId <em>Person Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Person#getNssfNumber <em>Nssf Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Person#getNhifNumber <em>Nhif Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Person#getNationalId <em>National Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends Contactable {
	/**
	 * Returns the value of the '<em><b>Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Photo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Photo</em>' attribute.
	 * @see #setPhoto(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getPerson_Photo()
	 * @model dataType="com.agritrace.edairy.desktop.common.model.base.ImageReference"
	 * @generated
	 */
	String getPhoto();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Person#getPhoto <em>Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Photo</em>' attribute.
	 * @see #getPhoto()
	 * @generated
	 */
	void setPhoto(String value);

	/**
	 * Returns the value of the '<em><b>Honorific</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Honorific</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Honorific</em>' attribute.
	 * @see #setHonorific(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getPerson_Honorific()
	 * @model
	 * @generated
	 */
	String getHonorific();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Person#getHonorific <em>Honorific</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Honorific</em>' attribute.
	 * @see #getHonorific()
	 * @generated
	 */
	void setHonorific(String value);

	/**
	 * Returns the value of the '<em><b>Family Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Family Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Family Name</em>' attribute.
	 * @see #setFamilyName(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getPerson_FamilyName()
	 * @model required="true"
	 * @generated
	 */
	String getFamilyName();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Person#getFamilyName <em>Family Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family Name</em>' attribute.
	 * @see #getFamilyName()
	 * @generated
	 */
	void setFamilyName(String value);

	/**
	 * Returns the value of the '<em><b>Given Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Given Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Given Name</em>' attribute.
	 * @see #setGivenName(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getPerson_GivenName()
	 * @model required="true"
	 * @generated
	 */
	String getGivenName();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Person#getGivenName <em>Given Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Given Name</em>' attribute.
	 * @see #getGivenName()
	 * @generated
	 */
	void setGivenName(String value);

	/**
	 * Returns the value of the '<em><b>Middle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Middle Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Middle Name</em>' attribute.
	 * @see #setMiddleName(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getPerson_MiddleName()
	 * @model
	 * @generated
	 */
	String getMiddleName();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Person#getMiddleName <em>Middle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Middle Name</em>' attribute.
	 * @see #getMiddleName()
	 * @generated
	 */
	void setMiddleName(String value);

	/**
	 * Returns the value of the '<em><b>Additional Names</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional Names</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional Names</em>' attribute.
	 * @see #setAdditionalNames(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getPerson_AdditionalNames()
	 * @model
	 * @generated
	 */
	String getAdditionalNames();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Person#getAdditionalNames <em>Additional Names</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Additional Names</em>' attribute.
	 * @see #getAdditionalNames()
	 * @generated
	 */
	void setAdditionalNames(String value);

	/**
	 * Returns the value of the '<em><b>Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suffix</em>' attribute.
	 * @see #setSuffix(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getPerson_Suffix()
	 * @model
	 * @generated
	 */
	String getSuffix();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Person#getSuffix <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suffix</em>' attribute.
	 * @see #getSuffix()
	 * @generated
	 */
	void setSuffix(String value);

	/**
	 * Returns the value of the '<em><b>Nick Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nick Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nick Name</em>' attribute.
	 * @see #setNickName(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getPerson_NickName()
	 * @model
	 * @generated
	 */
	String getNickName();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Person#getNickName <em>Nick Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nick Name</em>' attribute.
	 * @see #getNickName()
	 * @generated
	 */
	void setNickName(String value);

	/**
	 * Returns the value of the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phone Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phone Number</em>' attribute.
	 * @see #setPhoneNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getPerson_PhoneNumber()
	 * @model
	 * @generated
	 */
	String getPhoneNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Person#getPhoneNumber <em>Phone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phone Number</em>' attribute.
	 * @see #getPhoneNumber()
	 * @generated
	 */
	void setPhoneNumber(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' reference.
	 * @see #setLocation(Location)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getPerson_Location()
	 * @model extendedMetaData="name='location' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@OneToOne'"
	 * @generated
	 */
	Location getLocation();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Person#getLocation <em>Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Location value);

	/**
	 * Returns the value of the '<em><b>Person Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Person Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person Id</em>' attribute.
	 * @see #setPersonId(Long)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getPerson_PersonId()
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID"
	 * @generated
	 */
	Long getPersonId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Person#getPersonId <em>Person Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Person Id</em>' attribute.
	 * @see #getPersonId()
	 * @generated
	 */
	void setPersonId(Long value);

	/**
	 * Returns the value of the '<em><b>Nssf Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nssf Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nssf Number</em>' attribute.
	 * @see #setNssfNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getPerson_NssfNumber()
	 * @model
	 * @generated
	 */
	String getNssfNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Person#getNssfNumber <em>Nssf Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nssf Number</em>' attribute.
	 * @see #getNssfNumber()
	 * @generated
	 */
	void setNssfNumber(String value);

	/**
	 * Returns the value of the '<em><b>Nhif Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nhif Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nhif Number</em>' attribute.
	 * @see #setNhifNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getPerson_NhifNumber()
	 * @model
	 * @generated
	 */
	String getNhifNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Person#getNhifNumber <em>Nhif Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nhif Number</em>' attribute.
	 * @see #getNhifNumber()
	 * @generated
	 */
	void setNhifNumber(String value);

	/**
	 * Returns the value of the '<em><b>National Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>National Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>National Id</em>' attribute.
	 * @see #setNationalId(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getPerson_NationalId()
	 * @model extendedMetaData="name='nationalId' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@Column(unique=true)\n'"
	 * @generated
	 */
	String getNationalId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Person#getNationalId <em>National Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>National Id</em>' attribute.
	 * @see #getNationalId()
	 * @generated
	 */
	void setNationalId(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return com.agritrace.edairy.desktop.common.model.util.MemberUtil.formattedMemberName(this);'"
	 * @generated
	 */
	String getFormattedName();

} // Person
