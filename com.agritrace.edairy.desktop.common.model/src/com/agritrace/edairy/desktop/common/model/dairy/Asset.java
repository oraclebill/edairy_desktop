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
 * A representation of the model object '<em><b>Asset</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getAssetId <em>Asset Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getTagType <em>Tag Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getTagValue <em>Tag Value</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDateAcquired <em>Date Acquired</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDamageDate <em>Damage Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDamageDescription <em>Damage Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDateDisposed <em>Date Disposed</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDisposalReason <em>Disposal Reason</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDisposalWitness <em>Disposal Witness</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getAsset()
 * @model
 * @generated
 */
public interface Asset extends EObject {
	/**
	 * Returns the value of the '<em><b>Asset Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asset Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asset Id</em>' attribute.
	 * @see #setAssetId(Long)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getAsset_AssetId()
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID" required="true"
	 * @generated
	 */
	Long getAssetId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getAssetId <em>Asset Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asset Id</em>' attribute.
	 * @see #getAssetId()
	 * @generated
	 */
	void setAssetId(Long value);

	/**
	 * Returns the value of the '<em><b>Tag Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag Type</em>' attribute.
	 * @see #setTagType(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getAsset_TagType()
	 * @model required="true"
	 * @generated
	 */
	String getTagType();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getTagType <em>Tag Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag Type</em>' attribute.
	 * @see #getTagType()
	 * @generated
	 */
	void setTagType(String value);

	/**
	 * Returns the value of the '<em><b>Tag Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag Value</em>' attribute.
	 * @see #setTagValue(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getAsset_TagValue()
	 * @model required="true"
	 * @generated
	 */
	String getTagValue();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getTagValue <em>Tag Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag Value</em>' attribute.
	 * @see #getTagValue()
	 * @generated
	 */
	void setTagValue(String value);

	/**
	 * Returns the value of the '<em><b>Date Acquired</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Acquired</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Acquired</em>' attribute.
	 * @see #setDateAcquired(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getAsset_DateAcquired()
	 * @model required="true"
	 * @generated
	 */
	Date getDateAcquired();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDateAcquired <em>Date Acquired</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Acquired</em>' attribute.
	 * @see #getDateAcquired()
	 * @generated
	 */
	void setDateAcquired(Date value);

	/**
	 * Returns the value of the '<em><b>Damage Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Damage Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Damage Date</em>' attribute.
	 * @see #setDamageDate(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getAsset_DamageDate()
	 * @model
	 * @generated
	 */
	Date getDamageDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDamageDate <em>Damage Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Damage Date</em>' attribute.
	 * @see #getDamageDate()
	 * @generated
	 */
	void setDamageDate(Date value);

	/**
	 * Returns the value of the '<em><b>Damage Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Damage Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Damage Description</em>' attribute.
	 * @see #setDamageDescription(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getAsset_DamageDescription()
	 * @model
	 * @generated
	 */
	String getDamageDescription();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDamageDescription <em>Damage Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Damage Description</em>' attribute.
	 * @see #getDamageDescription()
	 * @generated
	 */
	void setDamageDescription(String value);

	/**
	 * Returns the value of the '<em><b>Date Disposed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Disposed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Disposed</em>' attribute.
	 * @see #setDateDisposed(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getAsset_DateDisposed()
	 * @model
	 * @generated
	 */
	Date getDateDisposed();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDateDisposed <em>Date Disposed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Disposed</em>' attribute.
	 * @see #getDateDisposed()
	 * @generated
	 */
	void setDateDisposed(Date value);

	/**
	 * Returns the value of the '<em><b>Disposal Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disposal Reason</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disposal Reason</em>' attribute.
	 * @see #setDisposalReason(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getAsset_DisposalReason()
	 * @model
	 * @generated
	 */
	String getDisposalReason();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDisposalReason <em>Disposal Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disposal Reason</em>' attribute.
	 * @see #getDisposalReason()
	 * @generated
	 */
	void setDisposalReason(String value);

	/**
	 * Returns the value of the '<em><b>Disposal Witness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disposal Witness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disposal Witness</em>' attribute.
	 * @see #setDisposalWitness(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getAsset_DisposalWitness()
	 * @model
	 * @generated
	 */
	String getDisposalWitness();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Asset#getDisposalWitness <em>Disposal Witness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disposal Witness</em>' attribute.
	 * @see #getDisposalWitness()
	 * @generated
	 */
	void setDisposalWitness(String value);

} // Asset
