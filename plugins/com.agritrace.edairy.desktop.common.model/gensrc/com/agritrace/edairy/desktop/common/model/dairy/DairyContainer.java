/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import com.agritrace.edairy.desktop.common.model.tracking.Container;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.DairyContainer#getStatus <em>Status</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.DairyContainer#getZone <em>Zone</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.DairyContainer#getAssetInfo <em>Asset Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairyContainer()
 * @model
 * @generated
 */
public interface DairyContainer extends Container {
	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The default value is <code>"IN_CIRCULATION"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see #setStatus(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairyContainer_Status()
	 * @model default="IN_CIRCULATION"
	 * @generated
	 */
	String getStatus();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyContainer#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(String value);

	/**
	 * Returns the value of the '<em><b>Zone</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zone</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zone</em>' reference.
	 * @see #setZone(TransportRoute)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairyContainer_Zone()
	 * @model
	 * @generated
	 */
	TransportRoute getZone();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyContainer#getZone <em>Zone</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zone</em>' reference.
	 * @see #getZone()
	 * @generated
	 */
	void setZone(TransportRoute value);

	/**
	 * Returns the value of the '<em><b>Asset Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asset Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asset Info</em>' containment reference.
	 * @see #setAssetInfo(Asset)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairyContainer_AssetInfo()
	 * @model containment="true" keys="tagValue"
	 *        extendedMetaData="name='assetInfo' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@Embedded'"
	 * @generated
	 */
	Asset getAssetInfo();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.DairyContainer#getAssetInfo <em>Asset Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asset Info</em>' containment reference.
	 * @see #getAssetInfo()
	 * @generated
	 */
	void setAssetInfo(Asset value);

} // DairyContainer
