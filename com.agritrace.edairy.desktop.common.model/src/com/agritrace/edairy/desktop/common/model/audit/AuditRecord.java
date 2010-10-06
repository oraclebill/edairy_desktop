/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.audit;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getDate <em>Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getUser <em>User</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getEntity <em>Entity</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getChangeType <em>Change Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.audit.AuditPackage#getAuditRecord()
 * @model
 * @generated
 */
public interface AuditRecord extends EObject {
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
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditPackage#getAuditRecord_Id()
	 * @model id="true"
	 * @generated
	 */
	Long getId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Long value);

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
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditPackage#getAuditRecord_Date()
	 * @model required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' attribute.
	 * @see #setUser(String)
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditPackage#getAuditRecord_User()
	 * @model required="true"
	 * @generated
	 */
	String getUser();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getUser <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' attribute.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(String value);

	/**
	 * Returns the value of the '<em><b>Entity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity</em>' attribute.
	 * @see #setEntity(String)
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditPackage#getAuditRecord_Entity()
	 * @model
	 * @generated
	 */
	String getEntity();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getEntity <em>Entity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' attribute.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(String value);

	/**
	 * Returns the value of the '<em><b>Change Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.audit.ChangeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Type</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.audit.ChangeType
	 * @see #setChangeType(ChangeType)
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditPackage#getAuditRecord_ChangeType()
	 * @model required="true"
	 * @generated
	 */
	ChangeType getChangeType();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getChangeType <em>Change Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Type</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.audit.ChangeType
	 * @see #getChangeType()
	 * @generated
	 */
	void setChangeType(ChangeType value);

	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditPackage#getAuditRecord_Content()
	 * @model required="true"
	 *        annotation="teneo.jpa appinfo='@Column(length=2000)'"
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

} // AuditRecord
