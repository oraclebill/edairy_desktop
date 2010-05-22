/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contact Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.ContactMethod#getCmType <em>Cm Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.ContactMethod#getCmValue <em>Cm Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getContactMethod()
 * @model
 * @generated
 */
public interface ContactMethod extends EObject {
	/**
         * Returns the value of the '<em><b>Cm Type</b></em>' attribute.
         * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.base.ContactMethodType}.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cm Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Cm Type</em>' attribute.
         * @see com.agritrace.edairy.desktop.common.model.base.ContactMethodType
         * @see #setCmType(ContactMethodType)
         * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getContactMethod_CmType()
         * @model
         * @generated
         */
	ContactMethodType getCmType();

	/**
         * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.ContactMethod#getCmType <em>Cm Type</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>Cm Type</em>' attribute.
         * @see com.agritrace.edairy.desktop.common.model.base.ContactMethodType
         * @see #getCmType()
         * @generated
         */
	void setCmType(ContactMethodType value);

	/**
         * Returns the value of the '<em><b>Cm Value</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cm Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Cm Value</em>' attribute.
         * @see #setCmValue(String)
         * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getContactMethod_CmValue()
         * @model
         * @generated
         */
	String getCmValue();

	/**
         * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.ContactMethod#getCmValue <em>Cm Value</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>Cm Value</em>' attribute.
         * @see #getCmValue()
         * @generated
         */
	void setCmValue(String value);

} // ContactMethod
