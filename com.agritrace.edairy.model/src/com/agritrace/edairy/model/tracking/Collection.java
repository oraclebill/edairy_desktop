/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.tracking;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.tracking.Collection#getFrom <em>From</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.tracking.Collection#getContributedTo <em>Contributed To</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.tracking.TrackingPackage#getCollection()
 * @model
 * @generated
 */
public interface Collection extends Transfer {
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
	 * @see com.agritrace.edairy.model.tracking.TrackingPackage#getCollection_From()
	 * @model required="true"
	 * @generated
	 */
	Farm getFrom();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.tracking.Collection#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(Farm value);

	/**
	 * Returns the value of the '<em><b>Contributed To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contributed To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributed To</em>' reference.
	 * @see #setContributedTo(Lot)
	 * @see com.agritrace.edairy.model.tracking.TrackingPackage#getCollection_ContributedTo()
	 * @model required="true"
	 * @generated
	 */
	Lot getContributedTo();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.tracking.Collection#getContributedTo <em>Contributed To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contributed To</em>' reference.
	 * @see #getContributedTo()
	 * @generated
	 */
	void setContributedTo(Lot value);

} // Collection
