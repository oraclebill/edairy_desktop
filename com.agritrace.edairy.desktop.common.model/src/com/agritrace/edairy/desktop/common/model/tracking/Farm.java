/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.base.Location;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Farm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Farm#getFarmId <em>Farm Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Farm#getName <em>Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Farm#getAnimals <em>Animals</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Farm#getCans <em>Cans</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Farm#getLocation <em>Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Farm#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Farm#getProfilePhoto <em>Profile Photo</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getFarm()
 * @model
 * @generated
 */
public interface Farm extends EObject {
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
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getFarm_FarmId()
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID"
	 * @generated
	 */
	Long getFarmId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.Farm#getFarmId <em>Farm Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Farm Id</em>' attribute.
	 * @see #getFarmId()
	 * @generated
	 */
	void setFarmId(Long value);

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
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getFarm_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.Farm#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Animals</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animals</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getFarm_Animals()
	 * @model containment="true"
	 * @generated
	 */
	EList<RegisteredAnimal> getAnimals();

	/**
	 * Returns the value of the '<em><b>Cans</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.tracking.Container}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cans</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cans</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getFarm_Cans()
	 * @model containment="true"
	 * @generated
	 */
	EList<Container> getCans();

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
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getFarm_Location()
	 * @model containment="true"
	 * @generated
	 */
	Location getLocation();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.Farm#getLocation <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' containment reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Location value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.tracking.Farmer#getFarms <em>Farms</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Farmer)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getFarm_Owner()
	 * @see com.agritrace.edairy.desktop.common.model.tracking.Farmer#getFarms
	 * @model opposite="farms" required="true" transient="false"
	 * @generated
	 */
	Farmer getOwner();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.Farm#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Farmer value);

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
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getFarm_ProfilePhoto()
	 * @model dataType="com.agritrace.edairy.desktop.common.model.base.ImageReference" ordered="false"
	 * @generated
	 */
	String getProfilePhoto();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.Farm#getProfilePhoto <em>Profile Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Photo</em>' attribute.
	 * @see #getProfilePhoto()
	 * @generated
	 */
	void setProfilePhoto(String value);

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
