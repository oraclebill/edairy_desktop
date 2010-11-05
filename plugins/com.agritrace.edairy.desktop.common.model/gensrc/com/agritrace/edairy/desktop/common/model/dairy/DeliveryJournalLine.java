/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delivery Journal Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine#getBin <em>Bin</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine#getDescription <em>Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine#isRejected <em>Rejected</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDeliveryJournalLine()
 * @model
 * @generated
 */
public interface DeliveryJournalLine extends EObject {
	/**
	 * Returns the value of the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Number</em>' attribute.
	 * @see #setLineNumber(int)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDeliveryJournalLine_LineNumber()
	 * @model required="true"
	 * @generated
	 */
	int getLineNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine#getLineNumber <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Number</em>' attribute.
	 * @see #getLineNumber()
	 * @generated
	 */
	void setLineNumber(int value);

	/**
	 * Returns the value of the '<em><b>Bin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bin</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bin</em>' reference.
	 * @see #setBin(DairyContainer)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDeliveryJournalLine_Bin()
	 * @model
	 * @generated
	 */
	DairyContainer getBin();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine#getBin <em>Bin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bin</em>' reference.
	 * @see #getBin()
	 * @generated
	 */
	void setBin(DairyContainer value);

	/**
	 * Returns the value of the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quantity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quantity</em>' attribute.
	 * @see #setQuantity(BigDecimal)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDeliveryJournalLine_Quantity()
	 * @model required="true"
	 * @generated
	 */
	BigDecimal getQuantity();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine#getQuantity <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantity</em>' attribute.
	 * @see #getQuantity()
	 * @generated
	 */
	void setQuantity(BigDecimal value);

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDeliveryJournalLine_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Rejected</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rejected</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rejected</em>' attribute.
	 * @see #setRejected(boolean)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDeliveryJournalLine_Rejected()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isRejected();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine#isRejected <em>Rejected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rejected</em>' attribute.
	 * @see #isRejected()
	 * @generated
	 */
	void setRejected(boolean value);

} // DeliveryJournalLine
