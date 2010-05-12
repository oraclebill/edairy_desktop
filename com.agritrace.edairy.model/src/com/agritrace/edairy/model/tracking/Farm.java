/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.tracking;

import com.agritrace.edairy.model.Location;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Farm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.tracking.Farm#getName <em>Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.tracking.Farm#getAnimals <em>Animals</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.tracking.Farm#getCans <em>Cans</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.tracking.Farm#getLocation <em>Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.tracking.Farm#getFarmId <em>Farm Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.tracking.TrackingPackage#getFarm()
 * @model
 * @generated
 */
public interface Farm extends EObject {
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
	 * @see com.agritrace.edairy.model.tracking.TrackingPackage#getFarm_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.tracking.Farm#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Animals</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.model.tracking.RegisteredAnimal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animals</em>' containment reference list.
	 * @see com.agritrace.edairy.model.tracking.TrackingPackage#getFarm_Animals()
	 * @model containment="true"
	 * @generated
	 */
	EList<RegisteredAnimal> getAnimals();

	/**
	 * Returns the value of the '<em><b>Cans</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.model.tracking.Container}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cans</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cans</em>' containment reference list.
	 * @see com.agritrace.edairy.model.tracking.TrackingPackage#getFarm_Cans()
	 * @model containment="true"
	 * @generated
	 */
	EList<Container> getCans();

	/**
	 * Returns the value of the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' containment reference.
	 * @see #setLocation(Location)
	 * @see com.agritrace.edairy.model.tracking.TrackingPackage#getFarm_Location()
	 * @model containment="true"
	 * @generated
	 */
	Location getLocation();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.tracking.Farm#getLocation <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' containment reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Location value);

	/**
	 * Returns the value of the '<em><b>Farm Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Farm Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Farm Id</em>' attribute.
	 * @see #setFarmId(Long)
	 * @see com.agritrace.edairy.model.tracking.TrackingPackage#getFarm_FarmId()
	 * @model dataType="com.agritrace.edairy.model.UniqueID"
	 * @generated
	 */
	Long getFarmId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.tracking.Farm#getFarmId <em>Farm Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Farm Id</em>' attribute.
	 * @see #getFarmId()
	 * @generated
	 */
	void setFarmId(Long value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getAnimals().size();'"
	 * @generated
	 */
	int getNumberOfAnimals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getCans().size();'"
	 * @generated
	 */
	int getNumberOfContainers();

} // Farm
