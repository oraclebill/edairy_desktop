/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy;

import com.agritrace.edairy.model.UnitOfMeasure;

import com.agritrace.edairy.model.tracking.Container;
import com.agritrace.edairy.model.tracking.Farm;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.CollectionRecord#isSuspended <em>Suspended</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.CollectionRecord#isNotRecorded <em>Not Recorded</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.CollectionRecord#getRecordedMember <em>Recorded Member</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.CollectionRecord#isOffRoute <em>Off Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.CollectionRecord#getDate <em>Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.CollectionRecord#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.CollectionRecord#getUnitOfMeasure <em>Unit Of Measure</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.CollectionRecord#getFrom <em>From</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.CollectionRecord#getFarmContainer <em>Farm Container</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.CollectionRecord#getDairyContainer <em>Dairy Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.dairy.DairyPackage#getCollectionRecord()
 * @model
 * @generated
 */
public interface CollectionRecord extends EObject {
	/**
	 * Returns the value of the '<em><b>Suspended</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspended</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspended</em>' attribute.
	 * @see #setSuspended(boolean)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getCollectionRecord_Suspended()
	 * @model
	 * @generated
	 */
	boolean isSuspended();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.CollectionRecord#isSuspended <em>Suspended</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspended</em>' attribute.
	 * @see #isSuspended()
	 * @generated
	 */
	void setSuspended(boolean value);

	/**
	 * Returns the value of the '<em><b>Not Recorded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not Recorded</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Recorded</em>' attribute.
	 * @see #setNotRecorded(boolean)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getCollectionRecord_NotRecorded()
	 * @model
	 * @generated
	 */
	boolean isNotRecorded();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.CollectionRecord#isNotRecorded <em>Not Recorded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Recorded</em>' attribute.
	 * @see #isNotRecorded()
	 * @generated
	 */
	void setNotRecorded(boolean value);

	/**
	 * Returns the value of the '<em><b>Recorded Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recorded Member</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recorded Member</em>' reference.
	 * @see #setRecordedMember(Membership)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getCollectionRecord_RecordedMember()
	 * @model required="true"
	 * @generated
	 */
	Membership getRecordedMember();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.CollectionRecord#getRecordedMember <em>Recorded Member</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recorded Member</em>' reference.
	 * @see #getRecordedMember()
	 * @generated
	 */
	void setRecordedMember(Membership value);

	/**
	 * Returns the value of the '<em><b>Off Route</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Off Route</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Off Route</em>' attribute.
	 * @see #setOffRoute(boolean)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getCollectionRecord_OffRoute()
	 * @model derived="true"
	 * @generated
	 */
	boolean isOffRoute();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.CollectionRecord#isOffRoute <em>Off Route</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Off Route</em>' attribute.
	 * @see #isOffRoute()
	 * @generated
	 */
	void setOffRoute(boolean value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getCollectionRecord_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.CollectionRecord#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quantity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quantity</em>' attribute.
	 * @see #setQuantity(double)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getCollectionRecord_Quantity()
	 * @model
	 * @generated
	 */
	double getQuantity();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.CollectionRecord#getQuantity <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantity</em>' attribute.
	 * @see #getQuantity()
	 * @generated
	 */
	void setQuantity(double value);

	/**
	 * Returns the value of the '<em><b>Unit Of Measure</b></em>' attribute.
	 * The literals are from the enumeration {@link com.agritrace.edairy.model.UnitOfMeasure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Of Measure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Of Measure</em>' attribute.
	 * @see com.agritrace.edairy.model.UnitOfMeasure
	 * @see #setUnitOfMeasure(UnitOfMeasure)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getCollectionRecord_UnitOfMeasure()
	 * @model
	 * @generated
	 */
	UnitOfMeasure getUnitOfMeasure();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.CollectionRecord#getUnitOfMeasure <em>Unit Of Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Of Measure</em>' attribute.
	 * @see com.agritrace.edairy.model.UnitOfMeasure
	 * @see #getUnitOfMeasure()
	 * @generated
	 */
	void setUnitOfMeasure(UnitOfMeasure value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(Farm)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getCollectionRecord_From()
	 * @model required="true"
	 * @generated
	 */
	Farm getFrom();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.CollectionRecord#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(Farm value);

	/**
	 * Returns the value of the '<em><b>Farm Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Farm Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Farm Container</em>' reference.
	 * @see #setFarmContainer(Container)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getCollectionRecord_FarmContainer()
	 * @model required="true"
	 * @generated
	 */
	Container getFarmContainer();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.CollectionRecord#getFarmContainer <em>Farm Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Farm Container</em>' reference.
	 * @see #getFarmContainer()
	 * @generated
	 */
	void setFarmContainer(Container value);

	/**
	 * Returns the value of the '<em><b>Dairy Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dairy Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dairy Container</em>' reference.
	 * @see #setDairyContainer(Container)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getCollectionRecord_DairyContainer()
	 * @model
	 * @generated
	 */
	Container getDairyContainer();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.CollectionRecord#getDairyContainer <em>Dairy Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dairy Container</em>' reference.
	 * @see #getDairyContainer()
	 * @generated
	 */
	void setDairyContainer(Container value);

} // CollectionRecord
