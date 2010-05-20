/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Location</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.Location#getPostalLocation <em>Postal Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.Location#getMapLocation <em>Map Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.Location#getStatutoryLocation <em>Statutory Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.Location#getDescriptiveLocation <em>Descriptive Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.ModelPackage#getLocation()
 * @model
 * @generated
 */
public interface Location extends EObject {
    /**
	 * Returns the value of the '<em><b>Postal Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Postal Location</em>' containment reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Postal Location</em>' containment reference.
	 * @see #setPostalLocation(PostalLocation)
	 * @see com.agritrace.edairy.model.ModelPackage#getLocation_PostalLocation()
	 * @model containment="true"
	 * @generated
	 */
    PostalLocation getPostalLocation();

    /**
	 * Sets the value of the '{@link com.agritrace.edairy.model.Location#getPostalLocation <em>Postal Location</em>}' containment reference.
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
     * If the meaning of the '<em>Map Location</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Location</em>' containment reference.
	 * @see #setMapLocation(MapLocation)
	 * @see com.agritrace.edairy.model.ModelPackage#getLocation_MapLocation()
	 * @model containment="true"
	 * @generated
	 */
    MapLocation getMapLocation();

    /**
	 * Sets the value of the '{@link com.agritrace.edairy.model.Location#getMapLocation <em>Map Location</em>}' containment reference.
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
     * If the meaning of the '<em>Statutory Location</em>' containment reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Statutory Location</em>' containment reference.
	 * @see #setStatutoryLocation(StatutoryLocation)
	 * @see com.agritrace.edairy.model.ModelPackage#getLocation_StatutoryLocation()
	 * @model containment="true"
	 * @generated
	 */
    StatutoryLocation getStatutoryLocation();

    /**
	 * Sets the value of the '{@link com.agritrace.edairy.model.Location#getStatutoryLocation <em>Statutory Location</em>}' containment reference.
	 * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statutory Location</em>' containment reference.
	 * @see #getStatutoryLocation()
	 * @generated
	 */
    void setStatutoryLocation(StatutoryLocation value);

    /**
	 * Returns the value of the '<em><b>Descriptive Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Descriptive Location</em>' containment
     * reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptive Location</em>' containment reference.
	 * @see #setDescriptiveLocation(DescriptiveLocation)
	 * @see com.agritrace.edairy.model.ModelPackage#getLocation_DescriptiveLocation()
	 * @model containment="true"
	 * @generated
	 */
    DescriptiveLocation getDescriptiveLocation();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.Location#getDescriptiveLocation
     * <em>Descriptive Location</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Descriptive Location</em>'
     *            containment reference.
     * @see #getDescriptiveLocation()
     * @generated
     */
    void setDescriptiveLocation(DescriptiveLocation value);

} // Location
