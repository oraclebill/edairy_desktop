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
 * A representation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Location#getPostalLocation <em>Postal Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Location#getMapLocation <em>Map Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Location#getStatutoryLocation <em>Statutory Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Location#getDescriptiveLocation <em>Descriptive Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Location#getLocationId <em>Location Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getLocation()
 * @model
 * @generated
 */
public interface Location extends EObject {
	/**
	 * Returns the value of the '<em><b>Postal Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postal Location</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postal Location</em>' containment reference.
	 * @see #setPostalLocation(PostalLocation)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getLocation_PostalLocation()
	 * @model containment="true"
	 *        extendedMetaData="name='postalLocation' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@Embedded'"
	 * @generated
	 */
	PostalLocation getPostalLocation();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Location#getPostalLocation <em>Postal Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Location</em>' containment reference.
	 * @see #getPostalLocation()
	 * @generated
	 */
	void setPostalLocation(PostalLocation value);

	/**
	 * Returns the value of the '<em><b>Map Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Location</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Location</em>' containment reference.
	 * @see #setMapLocation(MapLocation)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getLocation_MapLocation()
	 * @model containment="true"
	 *        extendedMetaData="name='mapLocation' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@Embedded'"
	 * @generated
	 */
	MapLocation getMapLocation();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Location#getMapLocation <em>Map Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Location</em>' containment reference.
	 * @see #getMapLocation()
	 * @generated
	 */
	void setMapLocation(MapLocation value);

	/**
	 * Returns the value of the '<em><b>Statutory Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statutory Location</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statutory Location</em>' containment reference.
	 * @see #setStatutoryLocation(StatutoryLocation)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getLocation_StatutoryLocation()
	 * @model containment="true"
	 *        extendedMetaData="name='statutoryLocation' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@Embedded'"
	 * @generated
	 */
	StatutoryLocation getStatutoryLocation();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Location#getStatutoryLocation <em>Statutory Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statutory Location</em>' containment reference.
	 * @see #getStatutoryLocation()
	 * @generated
	 */
	void setStatutoryLocation(StatutoryLocation value);

	/**
	 * Returns the value of the '<em><b>Descriptive Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptive Location</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptive Location</em>' containment reference.
	 * @see #setDescriptiveLocation(DescriptiveLocation)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getLocation_DescriptiveLocation()
	 * @model containment="true"
	 *        extendedMetaData="name='descriptiveLocation' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@Embedded'"
	 * @generated
	 */
	DescriptiveLocation getDescriptiveLocation();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Location#getDescriptiveLocation <em>Descriptive Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptive Location</em>' containment reference.
	 * @see #getDescriptiveLocation()
	 * @generated
	 */
	void setDescriptiveLocation(DescriptiveLocation value);

	/**
	 * Returns the value of the '<em><b>Location Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location Id</em>' attribute.
	 * @see #setLocationId(Long)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getLocation_LocationId()
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID"
	 * @generated
	 */
	Long getLocationId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Location#getLocationId <em>Location Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location Id</em>' attribute.
	 * @see #getLocationId()
	 * @generated
	 */
	void setLocationId(Long value);

} // Location
