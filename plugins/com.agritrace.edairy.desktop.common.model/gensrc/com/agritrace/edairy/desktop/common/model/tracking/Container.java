/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking;

import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getContainerId <em>Container Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getTrackingNumber <em>Tracking Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getMeasureType <em>Measure Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getQuantity <em>Quantity</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends EObject {
	/**
	 * Returns the value of the '<em><b>Container Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Id</em>' attribute.
	 * @see #setContainerId(Long)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getContainer_ContainerId()
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID"
	 * @generated
	 */
	Long getContainerId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getContainerId <em>Container Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Id</em>' attribute.
	 * @see #getContainerId()
	 * @generated
	 */
	void setContainerId(Long value);

	/**
	 * Returns the value of the '<em><b>Tracking Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tracking Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tracking Number</em>' attribute.
	 * @see #setTrackingNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getContainer_TrackingNumber()
	 * @model required="true"
	 *        extendedMetaData="kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@NaturalId'"
	 * @generated
	 */
	String getTrackingNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getTrackingNumber <em>Tracking Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tracking Number</em>' attribute.
	 * @see #getTrackingNumber()
	 * @generated
	 */
	void setTrackingNumber(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(Farm)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getContainer_Owner()
	 * @model
	 * @generated
	 */
	Farm getOwner();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Farm value);

	/**
	 * Returns the value of the '<em><b>Capacity</b></em>' attribute.
	 * The default value is <code>"25"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity</em>' attribute.
	 * @see #setCapacity(double)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getContainer_Capacity()
	 * @model default="25" required="true"
	 * @generated
	 */
	double getCapacity();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getCapacity <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity</em>' attribute.
	 * @see #getCapacity()
	 * @generated
	 */
	void setCapacity(double value);

	/**
	 * Returns the value of the '<em><b>Measure Type</b></em>' attribute.
	 * The default value is <code>"KILOGRAM"</code>.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure Type</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure
	 * @see #setMeasureType(UnitOfMeasure)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getContainer_MeasureType()
	 * @model default="KILOGRAM"
	 * @generated
	 */
	UnitOfMeasure getMeasureType();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getMeasureType <em>Measure Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measure Type</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure
	 * @see #getMeasureType()
	 * @generated
	 */
	void setMeasureType(UnitOfMeasure value);

	/**
	 * Returns the value of the '<em><b>Quantity</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quantity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quantity</em>' attribute.
	 * @see #setQuantity(double)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getContainer_Quantity()
	 * @model default="0" required="true" transient="true"
	 * @generated
	 */
	double getQuantity();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getQuantity <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantity</em>' attribute.
	 * @see #getQuantity()
	 * @generated
	 */
	void setQuantity(double value);

} // Container
