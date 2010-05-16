/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Audited</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.agritrace.edairy.model.Audited#getLastUpdated <em>Last Updated
 * </em>}</li>
 * <li>{@link com.agritrace.edairy.model.Audited#getVoidDate <em>Void Date</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @see com.agritrace.edairy.model.ModelPackage#getAudited()
 * @model
 * @generated
 */
public interface Audited extends EObject {
    /**
     * Returns the value of the '<em><b>Last Updated</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Last Updated</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Last Updated</em>' attribute.
     * @see #setLastUpdated(Date)
     * @see com.agritrace.edairy.model.ModelPackage#getAudited_LastUpdated()
     * @model
     * @generated
     */
    Date getLastUpdated();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.Audited#getLastUpdated
     * <em>Last Updated</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Last Updated</em>' attribute.
     * @see #getLastUpdated()
     * @generated
     */
    void setLastUpdated(Date value);

    /**
     * Returns the value of the '<em><b>Void Date</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Void Date</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Void Date</em>' attribute.
     * @see #setVoidDate(Date)
     * @see com.agritrace.edairy.model.ModelPackage#getAudited_VoidDate()
     * @model extendedMetaData="kind='element'"
     * @generated
     */
    Date getVoidDate();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.Audited#getVoidDate <em>Void Date</em>}
     * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Void Date</em>' attribute.
     * @see #getVoidDate()
     * @generated
     */
    void setVoidDate(Date value);

} // Audited
