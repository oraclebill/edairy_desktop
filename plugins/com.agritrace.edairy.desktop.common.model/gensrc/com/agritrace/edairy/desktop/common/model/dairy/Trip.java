/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trip</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Trip#getCollections <em>Collections</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Trip#getDeliveries <em>Deliveries</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Trip#getStarted <em>Started</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Trip#getEnded <em>Ended</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Trip#getTripId <em>Trip Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getTrip()
 * @model
 * @generated
 */
public interface Trip extends EObject {
	/**
	 * Returns the value of the '<em><b>Collections</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collections</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getTrip_Collections()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<CollectionGroup> getCollections();

	/**
	 * Returns the value of the '<em><b>Deliveries</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deliveries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deliveries</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getTrip_Deliveries()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<MilkSaleGroup> getDeliveries();

	/**
	 * Returns the value of the '<em><b>Started</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Started</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Started</em>' attribute.
	 * @see #setStarted(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getTrip_Started()
	 * @model required="true"
	 * @generated
	 */
	Date getStarted();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Trip#getStarted <em>Started</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Started</em>' attribute.
	 * @see #getStarted()
	 * @generated
	 */
	void setStarted(Date value);

	/**
	 * Returns the value of the '<em><b>Ended</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ended</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ended</em>' attribute.
	 * @see #setEnded(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getTrip_Ended()
	 * @model required="true"
	 * @generated
	 */
	Date getEnded();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Trip#getEnded <em>Ended</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ended</em>' attribute.
	 * @see #getEnded()
	 * @generated
	 */
	void setEnded(Date value);

	/**
	 * Returns the value of the '<em><b>Trip Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trip Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trip Id</em>' attribute.
	 * @see #setTripId(long)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getTrip_TripId()
	 * @model required="true"
	 *        extendedMetaData="name='tripId' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@Id\n@GeneratedValue'"
	 * @generated
	 */
	long getTripId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Trip#getTripId <em>Trip Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trip Id</em>' attribute.
	 * @see #getTripId()
	 * @generated
	 */
	void setTripId(long value);

} // Trip
