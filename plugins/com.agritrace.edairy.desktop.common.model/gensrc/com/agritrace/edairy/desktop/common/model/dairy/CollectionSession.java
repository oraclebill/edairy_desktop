/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Session</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getCode <em>Code</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getDescription <em>Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getTimeOfDay <em>Time Of Day</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getDairy <em>Dairy</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionSession()
 * @model
 * @generated
 */
public interface CollectionSession extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(Long)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionSession_Id()
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID" required="true"
	 * @generated
	 */
	Long getId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Long value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionSession_Code()
	 * @model annotation="teneo.jpa appinfo='@Column(unique=\"true\")'"
	 * @generated
	 */
	String getCode();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionSession_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Time Of Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Of Day</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Of Day</em>' attribute.
	 * @see #setTimeOfDay(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionSession_TimeOfDay()
	 * @model
	 * @generated
	 */
	Date getTimeOfDay();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getTimeOfDay <em>Time Of Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Of Day</em>' attribute.
	 * @see #getTimeOfDay()
	 * @generated
	 */
	void setTimeOfDay(Date value);

	/**
	 * Returns the value of the '<em><b>Dairy</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getCollectionSessions <em>Collection Sessions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dairy</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dairy</em>' container reference.
	 * @see #setDairy(Dairy)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionSession_Dairy()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getCollectionSessions
	 * @model opposite="collectionSessions" transient="false"
	 * @generated
	 */
	Dairy getDairy();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionSession#getDairy <em>Dairy</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dairy</em>' container reference.
	 * @see #getDairy()
	 * @generated
	 */
	void setDairy(Dairy value);

} // CollectionSession
