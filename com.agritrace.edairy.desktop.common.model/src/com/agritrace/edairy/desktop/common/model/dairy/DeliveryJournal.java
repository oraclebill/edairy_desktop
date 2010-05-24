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
 * A representation of the model object '<em><b>Delivery Journal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal#getSession <em>Session</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal#getRoute <em>Route</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDeliveryJournal()
 * @model
 * @generated
 */
public interface DeliveryJournal extends EObject {
	/**
	 * Returns the value of the '<em><b>Reference Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Number</em>' attribute.
	 * @see #setReferenceNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDeliveryJournal_ReferenceNumber()
	 * @model
	 * @generated
	 */
	String getReferenceNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal#getReferenceNumber <em>Reference Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Number</em>' attribute.
	 * @see #getReferenceNumber()
	 * @generated
	 */
	void setReferenceNumber(String value);

	/**
	 * Returns the value of the '<em><b>Session</b></em>' attribute.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.dairy.Session}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Session
	 * @see #setSession(Session)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDeliveryJournal_Session()
	 * @model
	 * @generated
	 */
	Session getSession();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal#getSession <em>Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Session
	 * @see #getSession()
	 * @generated
	 */
	void setSession(Session value);

	/**
	 * Returns the value of the '<em><b>Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Route</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Route</em>' reference.
	 * @see #setRoute(Route)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDeliveryJournal_Route()
	 * @model
	 * @generated
	 */
	Route getRoute();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal#getRoute <em>Route</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Route</em>' reference.
	 * @see #getRoute()
	 * @generated
	 */
	void setRoute(Route value);

} // DeliveryJournal
