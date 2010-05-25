/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking;

import com.agritrace.edairy.desktop.common.model.base.ContainerType;
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
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getType <em>Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getMeasureType <em>Measure Type</em>}</li>
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
	 * @see #setContainerId(String)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getContainer_ContainerId()
	 * @model
	 * @generated
	 */
	String getContainerId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getContainerId <em>Container Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Id</em>' attribute.
	 * @see #getContainerId()
	 * @generated
	 */
	void setContainerId(String value);

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
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity</em>' attribute.
	 * @see #setCapacity(double)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getContainer_Capacity()
	 * @model
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
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.base.ContainerType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.base.ContainerType
	 * @see #setType(ContainerType)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getContainer_Type()
	 * @model
	 * @generated
	 */
	ContainerType getType();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.Container#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.base.ContainerType
	 * @see #getType()
	 * @generated
	 */
	void setType(ContainerType value);

	/**
	 * Returns the value of the '<em><b>Measure Type</b></em>' attribute.
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
	 * @model
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

} // Container
