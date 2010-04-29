/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy;

import com.agritrace.edairy.model.tracking.Collection;

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
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.dairy.DairyPackage#getCollectionRecord()
 * @model
 * @generated
 */
public interface CollectionRecord extends Collection {
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

} // CollectionRecord
