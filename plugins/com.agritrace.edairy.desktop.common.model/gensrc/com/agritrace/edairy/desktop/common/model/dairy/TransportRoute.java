/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Route</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getName <em>Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getDescription <em>Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getVehicle <em>Vehicle</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getStops <em>Stops</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getBins <em>Bins</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getTransportRoute()
 * @model
 * @generated
 */
public interface TransportRoute extends EObject {
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getTransportRoute_Id()
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID" required="true"
	 *        extendedMetaData="name='Id' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@Id\n@GeneratedValue'"
	 * @generated
	 */
	Long getId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Long value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getTransportRoute_Name()
	 * @model extendedMetaData="kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@NaturalId'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Stops</b></em>' reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.DairyLocation}.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getRoute <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stops</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stops</em>' reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getTransportRoute_Stops()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyLocation#getRoute
	 * @model opposite="route"
	 * @generated
	 */
	EList<DairyLocation> getStops();

	/**
	 * Returns the value of the '<em><b>Bins</b></em>' reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.Bin}.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.Bin#getZone <em>Zone</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bins</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bins</em>' reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getTransportRoute_Bins()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Bin#getZone
	 * @model opposite="zone"
	 * @generated
	 */
	EList<Bin> getBins();

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getTransportRoute_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vehicle</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle</em>' reference.
	 * @see #setVehicle(Vehicle)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getTransportRoute_Vehicle()
	 * @model
	 * @generated
	 */
	Vehicle getVehicle();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.TransportRoute#getVehicle <em>Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle</em>' reference.
	 * @see #getVehicle()
	 * @generated
	 */
	void setVehicle(Vehicle value);

} // Route
