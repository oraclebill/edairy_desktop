/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Person</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.agritrace.edairy.model.Person#getPhoto <em>Photo</em>}</li>
 * <li>{@link com.agritrace.edairy.model.Person#getHonorific <em>Honorific</em>}
 * </li>
 * <li>{@link com.agritrace.edairy.model.Person#getFamilyName <em>Family Name
 * </em>}</li>
 * <li>{@link com.agritrace.edairy.model.Person#getGivenName <em>Given Name
 * </em>}</li>
 * <li>{@link com.agritrace.edairy.model.Person#getMiddleName <em>Middle Name
 * </em>}</li>
 * <li>{@link com.agritrace.edairy.model.Person#getAdditionalNames <em>
 * Additional Names</em>}</li>
 * <li>{@link com.agritrace.edairy.model.Person#getSuffix <em>Suffix</em>}</li>
 * <li>{@link com.agritrace.edairy.model.Person#getNickName <em>Nick Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.agritrace.edairy.model.ModelPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends Party {
    /**
     * Returns the value of the '<em><b>Photo</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Photo</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Photo</em>' attribute.
     * @see #setPhoto(String)
     * @see com.agritrace.edairy.model.ModelPackage#getPerson_Photo()
     * @model dataType="com.agritrace.edairy.model.ImageReference"
     * @generated
     */
    String getPhoto();

    /**
     * Sets the value of the '{@link com.agritrace.edairy.model.Person#getPhoto
     * <em>Photo</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Photo</em>' attribute.
     * @see #getPhoto()
     * @generated
     */
    void setPhoto(String value);

    /**
     * Returns the value of the '<em><b>Honorific</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Honorific</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Honorific</em>' attribute.
     * @see #setHonorific(String)
     * @see com.agritrace.edairy.model.ModelPackage#getPerson_Honorific()
     * @model
     * @generated
     */
    String getHonorific();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.Person#getHonorific <em>Honorific</em>}
     * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Honorific</em>' attribute.
     * @see #getHonorific()
     * @generated
     */
    void setHonorific(String value);

    /**
     * Returns the value of the '<em><b>Family Name</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Family Name</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Family Name</em>' attribute.
     * @see #setFamilyName(String)
     * @see com.agritrace.edairy.model.ModelPackage#getPerson_FamilyName()
     * @model
     * @generated
     */
    String getFamilyName();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.Person#getFamilyName
     * <em>Family Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Family Name</em>' attribute.
     * @see #getFamilyName()
     * @generated
     */
    void setFamilyName(String value);

    /**
     * Returns the value of the '<em><b>Given Name</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Given Name</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Given Name</em>' attribute.
     * @see #setGivenName(String)
     * @see com.agritrace.edairy.model.ModelPackage#getPerson_GivenName()
     * @model
     * @generated
     */
    String getGivenName();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.Person#getGivenName
     * <em>Given Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Given Name</em>' attribute.
     * @see #getGivenName()
     * @generated
     */
    void setGivenName(String value);

    /**
     * Returns the value of the '<em><b>Middle Name</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Middle Name</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Middle Name</em>' attribute.
     * @see #setMiddleName(String)
     * @see com.agritrace.edairy.model.ModelPackage#getPerson_MiddleName()
     * @model
     * @generated
     */
    String getMiddleName();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.Person#getMiddleName
     * <em>Middle Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Middle Name</em>' attribute.
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
     * 
     * @return the value of the '<em>Additional Names</em>' attribute.
     * @see #setAdditionalNames(String)
     * @see com.agritrace.edairy.model.ModelPackage#getPerson_AdditionalNames()
     * @model
     * @generated
     */
    String getAdditionalNames();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.Person#getAdditionalNames
     * <em>Additional Names</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Additional Names</em>' attribute.
     * @see #getAdditionalNames()
     * @generated
     */
    void setAdditionalNames(String value);

    /**
     * Returns the value of the '<em><b>Suffix</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Suffix</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Suffix</em>' attribute.
     * @see #setSuffix(String)
     * @see com.agritrace.edairy.model.ModelPackage#getPerson_Suffix()
     * @model
     * @generated
     */
    String getSuffix();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.Person#getSuffix <em>Suffix</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Suffix</em>' attribute.
     * @see #getSuffix()
     * @generated
     */
    void setSuffix(String value);

    /**
     * Returns the value of the '<em><b>Nick Name</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Nick Name</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Nick Name</em>' attribute.
     * @see #setNickName(String)
     * @see com.agritrace.edairy.model.ModelPackage#getPerson_NickName()
     * @model
     * @generated
     */
    String getNickName();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.Person#getNickName <em>Nick Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Nick Name</em>' attribute.
     * @see #getNickName()
     * @generated
     */
    void setNickName(String value);

} // Person
