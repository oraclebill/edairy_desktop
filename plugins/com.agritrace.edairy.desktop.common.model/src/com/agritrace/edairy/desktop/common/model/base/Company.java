/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Company#getLegalName <em>Legal Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Company#getCompanyName <em>Company Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Company#getContacts <em>Contacts</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Company#getLocation <em>Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Company#getPhoneNumber <em>Phone Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Company#getCompanyId <em>Company Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Company#getDescription <em>Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Company#getProfilePhoto <em>Profile Photo</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getCompany()
 * @model extendedMetaData="name='Company' kind='elementOnly'"
 *        annotation="teneo.jpa appinfo='@MappedSuperclass'"
 * @generated
 */
public interface Company extends Contactable {
	/**
	 * Returns the value of the '<em><b>Legal Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Legal Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Legal Name</em>' attribute.
	 * @see #setLegalName(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getCompany_LegalName()
	 * @model
	 * @generated
	 */
	String getLegalName();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Company#getLegalName <em>Legal Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Legal Name</em>' attribute.
	 * @see #getLegalName()
	 * @generated
	 */
	void setLegalName(String value);

	/**
	 * Returns the value of the '<em><b>Company Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Company Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Company Name</em>' attribute.
	 * @see #setCompanyName(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getCompany_CompanyName()
	 * @model required="true"
	 * @generated
	 */
	String getCompanyName();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Company#getCompanyName <em>Company Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Company Name</em>' attribute.
	 * @see #getCompanyName()
	 * @generated
	 */
	void setCompanyName(String value);

	/**
	 * Returns the value of the '<em><b>Contacts</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.base.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contacts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contacts</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getCompany_Contacts()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Person> getContacts();

	/**
	 * Returns the value of the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' containment reference.
	 * @see #setLocation(Location)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getCompany_Location()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Location getLocation();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Company#getLocation <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' containment reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Location value);

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
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getCompany_PhoneNumber()
	 * @model required="true"
	 * @generated
	 */
	String getPhoneNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Company#getPhoneNumber <em>Phone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phone Number</em>' attribute.
	 * @see #getPhoneNumber()
	 * @generated
	 */
	void setPhoneNumber(String value);

	/**
	 * Returns the value of the '<em><b>Company Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Company Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Company Id</em>' attribute.
	 * @see #setCompanyId(Long)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getCompany_CompanyId()
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID" required="true"
	 * @generated
	 */
	Long getCompanyId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Company#getCompanyId <em>Company Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Company Id</em>' attribute.
	 * @see #getCompanyId()
	 * @generated
	 */
	void setCompanyId(Long value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getCompany_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Company#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Profile Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Photo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Photo</em>' attribute.
	 * @see #setProfilePhoto(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getCompany_ProfilePhoto()
	 * @model dataType="com.agritrace.edairy.desktop.common.model.base.ImageReference"
	 * @generated
	 */
	String getProfilePhoto();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Company#getProfilePhoto <em>Profile Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Photo</em>' attribute.
	 * @see #getProfilePhoto()
	 * @generated
	 */
	void setProfilePhoto(String value);

} // Company
