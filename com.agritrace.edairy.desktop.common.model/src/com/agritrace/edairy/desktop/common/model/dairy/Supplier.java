/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import com.agritrace.edairy.desktop.common.model.base.Company;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Supplier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getCategories <em>Categories</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getPublicDescription <em>Public Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getStatus <em>Status</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getRegistrationDate <em>Registration Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getExpirationDate <em>Expiration Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getNotes <em>Notes</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getRating <em>Rating</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getSupplier()
 * @model
 * @generated
 */
public interface Supplier extends Company {
	/**
	 * Returns the value of the '<em><b>Categories</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' attribute list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getSupplier_Categories()
	 * @model
	 * @generated
	 */
	EList<String> getCategories();

	/**
	 * Returns the value of the '<em><b>Public Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Public Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Public Description</em>' attribute.
	 * @see #setPublicDescription(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getSupplier_PublicDescription()
	 * @model required="true"
	 * @generated
	 */
	String getPublicDescription();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getPublicDescription <em>Public Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Public Description</em>' attribute.
	 * @see #getPublicDescription()
	 * @generated
	 */
	void setPublicDescription(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.dairy.VendorStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.VendorStatus
	 * @see #setStatus(VendorStatus)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getSupplier_Status()
	 * @model required="true"
	 * @generated
	 */
	VendorStatus getStatus();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.VendorStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(VendorStatus value);

	/**
	 * Returns the value of the '<em><b>Registration Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registration Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registration Date</em>' attribute.
	 * @see #setRegistrationDate(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getSupplier_RegistrationDate()
	 * @model required="true"
	 * @generated
	 */
	Date getRegistrationDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getRegistrationDate <em>Registration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registration Date</em>' attribute.
	 * @see #getRegistrationDate()
	 * @generated
	 */
	void setRegistrationDate(Date value);

	/**
	 * Returns the value of the '<em><b>Expiration Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expiration Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expiration Date</em>' attribute.
	 * @see #setExpirationDate(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getSupplier_ExpirationDate()
	 * @model
	 * @generated
	 */
	Date getExpirationDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getExpirationDate <em>Expiration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expiration Date</em>' attribute.
	 * @see #getExpirationDate()
	 * @generated
	 */
	void setExpirationDate(Date value);

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getSupplier_Notes()
	 * @model
	 * @generated
	 */
	String getNotes();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getNotes <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notes</em>' attribute.
	 * @see #getNotes()
	 * @generated
	 */
	void setNotes(String value);

	/**
	 * Returns the value of the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rating</em>' attribute.
	 * @see #setRating(int)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getSupplier_Rating()
	 * @model
	 * @generated
	 */
	int getRating();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Supplier#getRating <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rating</em>' attribute.
	 * @see #getRating()
	 * @generated
	 */
	void setRating(int value);

} // Supplier
