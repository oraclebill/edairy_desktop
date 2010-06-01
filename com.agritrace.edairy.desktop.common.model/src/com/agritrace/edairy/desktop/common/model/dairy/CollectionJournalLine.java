/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;

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
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getDairyContainer <em>Dairy Container</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getCollectionJournal <em>Collection Journal</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#isRejected <em>Rejected</em>}</li>
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
	 * @see #setQuantity(double)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_Quantity()
	 * @model required="true"
	 * @generated
	 */
	double getQuantity();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getQuantity <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantity</em>' attribute.
	 * @see #getQuantity()
	 * @generated
	 */
	void setQuantity(double value);

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
	 * @model required="true"
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
	 * @model required="true"
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
	 * Returns the value of the '<em><b>Dairy Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dairy Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dairy Container</em>' reference.
	 * @see #setDairyContainer(Container)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_DairyContainer()
	 * @model
	 * @generated
	 */
	Container getDairyContainer();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getDairyContainer <em>Dairy Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dairy Container</em>' reference.
	 * @see #getDairyContainer()
	 * @generated
	 */
	void setDairyContainer(Container value);

	/**
	 * Returns the value of the '<em><b>Collection Journal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Journal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Journal</em>' reference.
	 * @see #setCollectionJournal(CollectionJournal)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalLine_CollectionJournal()
	 * @model
	 * @generated
	 */
	CollectionJournal getCollectionJournal();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getCollectionJournal <em>Collection Journal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Journal</em>' reference.
	 * @see #getCollectionJournal()
	 * @generated
	 */
	void setCollectionJournal(CollectionJournal value);

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

} // CollectionJournalLine
