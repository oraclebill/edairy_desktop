/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;

import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Journal Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getRecordedMember <em>Recorded Member</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isFlagged <em>Flagged</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getUnitOfMeasure <em>Unit Of Measure</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isNotRecorded <em>Not Recorded</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getValidatedMember <em>Validated Member</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isOffRoute <em>Off Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getFrom <em>From</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getFarmContainer <em>Farm Container</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getBin <em>Bin</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getGroup <em>Group</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isRejected <em>Rejected</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getRejectionReason <em>Rejection Reason</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getMilkFatPercentage <em>Milk Fat Percentage</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getAlcoholPercentage <em>Alcohol Percentage</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isWaterAdded <em>Water Added</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine()
 * @model
 * @generated
 */
public interface CollectionJournalLine extends EObject {
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_LineNumber()
	 * @model
	 * @generated
	 */
	int getLineNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getLineNumber <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Number</em>' attribute.
	 * @see #getLineNumber()
	 * @generated
	 */
	void setLineNumber(int value);

	/**
	 * Returns the value of the '<em><b>Recorded Member</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recorded Member</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recorded Member</em>' attribute.
	 * @see #setRecordedMember(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_RecordedMember()
	 * @model required="true"
	 * @generated
	 */
	String getRecordedMember();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getRecordedMember <em>Recorded Member</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recorded Member</em>' attribute.
	 * @see #getRecordedMember()
	 * @generated
	 */
	void setRecordedMember(String value);

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_Quantity()
	 * @model required="true"
	 * @generated
	 */
	BigDecimal getQuantity();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getQuantity <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantity</em>' attribute.
	 * @see #getQuantity()
	 * @generated
	 */
	void setQuantity(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Flagged</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flagged</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flagged</em>' attribute.
	 * @see #setFlagged(boolean)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_Flagged()
	 * @model
	 * @generated
	 */
	boolean isFlagged();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isFlagged <em>Flagged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flagged</em>' attribute.
	 * @see #isFlagged()
	 * @generated
	 */
	void setFlagged(boolean value);

	/**
	 * Returns the value of the '<em><b>Unit Of Measure</b></em>' attribute.
	 * The default value is <code>"KILOGRAMS"</code>.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Of Measure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Of Measure</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure
	 * @see #setUnitOfMeasure(UnitOfMeasure)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_UnitOfMeasure()
	 * @model default="KILOGRAMS" required="true"
	 * @generated
	 */
	UnitOfMeasure getUnitOfMeasure();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getUnitOfMeasure <em>Unit Of Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Of Measure</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure
	 * @see #getUnitOfMeasure()
	 * @generated
	 */
	void setUnitOfMeasure(UnitOfMeasure value);

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_NotRecorded()
	 * @model
	 * @generated
	 */
	boolean isNotRecorded();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isNotRecorded <em>Not Recorded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Recorded</em>' attribute.
	 * @see #isNotRecorded()
	 * @generated
	 */
	void setNotRecorded(boolean value);

	/**
	 * Returns the value of the '<em><b>Validated Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validated Member</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validated Member</em>' reference.
	 * @see #setValidatedMember(Membership)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_ValidatedMember()
	 * @model
	 * @generated
	 */
	Membership getValidatedMember();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getValidatedMember <em>Validated Member</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validated Member</em>' reference.
	 * @see #getValidatedMember()
	 * @generated
	 */
	void setValidatedMember(Membership value);

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_OffRoute()
	 * @model derived="true"
	 * @generated
	 */
	boolean isOffRoute();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isOffRoute <em>Off Route</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Off Route</em>' attribute.
	 * @see #isOffRoute()
	 * @generated
	 */
	void setOffRoute(boolean value);

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_From()
	 * @model
	 * @generated
	 */
	Farm getFrom();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getFrom <em>From</em>}' reference.
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_FarmContainer()
	 * @model
	 * @generated
	 */
	Container getFarmContainer();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getFarmContainer <em>Farm Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Farm Container</em>' reference.
	 * @see #getFarmContainer()
	 * @generated
	 */
	void setFarmContainer(Container value);

	/**
	 * Returns the value of the '<em><b>Bin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dairy Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bin</em>' reference.
	 * @see #setBin(Bin)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_Bin()
	 * @model
	 * @generated
	 */
	Bin getBin();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getBin <em>Bin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bin</em>' reference.
	 * @see #getBin()
	 * @generated
	 */
	void setBin(Bin value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Journal</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' container reference.
	 * @see #setGroup(CollectionGroup)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_Group()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup#getEntries
	 * @model opposite="entries" transient="false"
	 * @generated
	 */
	CollectionGroup getGroup();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getGroup <em>Group</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' container reference.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(CollectionGroup value);

	/**
	 * Returns the value of the '<em><b>Rejected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rejected</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rejected</em>' attribute.
	 * @see #setRejected(boolean)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_Rejected()
	 * @model
	 * @generated
	 */
	boolean isRejected();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isRejected <em>Rejected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rejected</em>' attribute.
	 * @see #isRejected()
	 * @generated
	 */
	void setRejected(boolean value);

	/**
	 * Returns the value of the '<em><b>Rejection Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rejection Reason</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rejection Reason</em>' attribute.
	 * @see #setRejectionReason(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_RejectionReason()
	 * @model
	 * @generated
	 */
	String getRejectionReason();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getRejectionReason <em>Rejection Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rejection Reason</em>' attribute.
	 * @see #getRejectionReason()
	 * @generated
	 */
	void setRejectionReason(String value);

	/**
	 * Returns the value of the '<em><b>Milk Fat Percentage</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Milk Fat Percentage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Milk Fat Percentage</em>' attribute.
	 * @see #setMilkFatPercentage(BigDecimal)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_MilkFatPercentage()
	 * @model default="0.0"
	 * @generated
	 */
	BigDecimal getMilkFatPercentage();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getMilkFatPercentage <em>Milk Fat Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Milk Fat Percentage</em>' attribute.
	 * @see #getMilkFatPercentage()
	 * @generated
	 */
	void setMilkFatPercentage(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Alcohol Percentage</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alcohol Percentage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alcohol Percentage</em>' attribute.
	 * @see #setAlcoholPercentage(BigDecimal)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_AlcoholPercentage()
	 * @model default="0.0"
	 * @generated
	 */
	BigDecimal getAlcoholPercentage();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getAlcoholPercentage <em>Alcohol Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alcohol Percentage</em>' attribute.
	 * @see #getAlcoholPercentage()
	 * @generated
	 */
	void setAlcoholPercentage(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Water Added</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Water Added</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Water Added</em>' attribute.
	 * @see #setWaterAdded(boolean)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_WaterAdded()
	 * @model default="false"
	 * @generated
	 */
	boolean isWaterAdded();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isWaterAdded <em>Water Added</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Water Added</em>' attribute.
	 * @see #isWaterAdded()
	 * @generated
	 */
	void setWaterAdded(boolean value);

} // CollectionJournalLine
