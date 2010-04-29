/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.services;

import com.agritrace.edairy.model.dairy.CollectionJournal;
import com.agritrace.edairy.model.dairy.Driver;
import com.agritrace.edairy.model.dairy.RouteDefinition;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.services.CollectionService#getJournals <em>Journals</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.services.ServicesPackage#getCollectionService()
 * @model
 * @generated
 */
public interface CollectionService extends EObject {
	/**
	 * Returns the value of the '<em><b>Journals</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Journals</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Journals</em>' attribute.
	 * @see #setJournals(String)
	 * @see com.agritrace.edairy.services.ServicesPackage#getCollectionService_Journals()
	 * @model required="true"
	 * @generated
	 */
	String getJournals();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.services.CollectionService#getJournals <em>Journals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Journals</em>' attribute.
	 * @see #getJournals()
	 * @generated
	 */
	void setJournals(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	CollectionJournal createJournal(String refNum, Date date, RouteDefinition route, Driver driver);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="com.agritrace.edairy.model.TransactionID" required="true"
	 * @generated
	 */
	String postJournal(CollectionJournal journal, Boolean suspend);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="com.agritrace.edairy.model.TransactionID" required="true" journalIDDataType="com.agritrace.edairy.model.UniqueID"
	 * @generated
	 */
	String voidJournal(String journalID);

} // CollectionService
