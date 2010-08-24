/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.GlobalSettings#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.GlobalSettings#isPasswordsEncrypted <em>Passwords Encrypted</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getGlobalSettings()
 * @model
 * @generated
 */
public interface GlobalSettings extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(Long)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getGlobalSettings_Id()
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID" required="true"
	 * @generated
	 */
	Long getId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.GlobalSettings#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Long value);

	/**
	 * Returns the value of the '<em><b>Passwords Encrypted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Passwords Encrypted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passwords Encrypted</em>' attribute.
	 * @see #setPasswordsEncrypted(boolean)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getGlobalSettings_PasswordsEncrypted()
	 * @model derived="true"
	 * @generated
	 */
	boolean isPasswordsEncrypted();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.GlobalSettings#isPasswordsEncrypted <em>Passwords Encrypted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Passwords Encrypted</em>' attribute.
	 * @see #isPasswordsEncrypted()
	 * @generated
	 */
	void setPasswordsEncrypted(boolean value);

} // GlobalSettings
