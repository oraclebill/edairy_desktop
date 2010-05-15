/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.model.Location;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.DairyLocation#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.DairyLocation#getName <em>Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.DairyLocation#getDateOpened <em>Date Opened</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.DairyLocation#getPhone <em>Phone</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.DairyLocation#getRoute <em>Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.DairyLocation#getDescription <em>Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.DairyLocation#getCode <em>Code</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.DairyLocation#getLocation <em>Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.DairyLocation#getFunctions <em>Functions</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairyLocation()
 * @model
 * @generated
 */
public interface DairyLocation extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(long)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairyLocation_Id()
	 * @model id="true"
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.DairyLocation#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(long value);

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
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairyLocation_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.DairyLocation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Date Opened</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Opened</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Opened</em>' attribute.
	 * @see #setDateOpened(Date)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairyLocation_DateOpened()
	 * @model
	 * @generated
	 */
	Date getDateOpened();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.DairyLocation#getDateOpened <em>Date Opened</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Opened</em>' attribute.
	 * @see #getDateOpened()
	 * @generated
	 */
	void setDateOpened(Date value);

	/**
	 * Returns the value of the '<em><b>Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phone</em>' attribute.
	 * @see #setPhone(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairyLocation_Phone()
	 * @model
	 * @generated
	 */
	String getPhone();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.DairyLocation#getPhone <em>Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phone</em>' attribute.
	 * @see #getPhone()
	 * @generated
	 */
	void setPhone(String value);

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
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairyLocation_Route()
	 * @model
	 * @generated
	 */
	Route getRoute();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.DairyLocation#getRoute <em>Route</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Route</em>' reference.
	 * @see #getRoute()
	 * @generated
	 */
	void setRoute(Route value);

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
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairyLocation_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.DairyLocation#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairyLocation_Code()
	 * @model
	 * @generated
	 */
	String getCode();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.DairyLocation#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(String value);

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
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairyLocation_Location()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Location getLocation();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.DairyLocation#getLocation <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' containment reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Location value);

	/**
	 * Returns the value of the '<em><b>Functions</b></em>' attribute list.
	 * The list contents are of type {@link com.agritrace.edairy.model.dairy.DairyFunction}.
	 * The literals are from the enumeration {@link com.agritrace.edairy.model.dairy.DairyFunction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' attribute list.
	 * @see com.agritrace.edairy.model.dairy.DairyFunction
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairyLocation_Functions()
	 * @model
	 * @generated
	 */
	EList<DairyFunction> getFunctions();

} // DairyLocation
