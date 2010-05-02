/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy;

import com.agritrace.edairy.model.tracking.Container;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.DairyContainer#getAssetInfo <em>Asset Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairyContainer()
 * @model
 * @generated
 */
public interface DairyContainer extends Container {
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
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getDairyContainer_AssetInfo()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	Asset getAssetInfo();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.DairyContainer#getAssetInfo <em>Asset Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asset Info</em>' containment reference.
	 * @see #getAssetInfo()
	 * @generated
	 */
	void setAssetInfo(Asset value);

} // DairyContainer
