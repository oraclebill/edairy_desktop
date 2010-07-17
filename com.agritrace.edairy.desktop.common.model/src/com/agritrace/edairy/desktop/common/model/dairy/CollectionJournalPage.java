/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import java.math.BigDecimal;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Journal Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getJournalId <em>Journal Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getJournalDate <em>Journal Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getStatus <em>Status</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getSession <em>Session</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getDriver <em>Driver</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getRoute <em>Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getVehicle <em>Vehicle</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getDriverTotal <em>Driver Total</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getRecordTotal <em>Record Total</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getJournalEntries <em>Journal Entries</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#isSuspended <em>Suspended</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getEntryCount <em>Entry Count</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getSuspendedCount <em>Suspended Count</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getRejectedCount <em>Rejected Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage()
 * @model
 * @generated
 */
public interface CollectionJournalPage extends EObject {
	/**
	 * Returns the value of the '<em><b>Journal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Journal Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Journal Id</em>' attribute.
	 * @see #setJournalId(Long)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_JournalId()
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID" required="true"
	 * @generated
	 */
	Long getJournalId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getJournalId <em>Journal Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Journal Id</em>' attribute.
	 * @see #getJournalId()
	 * @generated
	 */
	void setJournalId(Long value);

	/**
	 * Returns the value of the '<em><b>Journal Entries</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine}.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getCollectionJournal <em>Collection Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Journal Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Journal Entries</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_JournalEntries()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine#getCollectionJournal
	 * @model opposite="collectionJournal" containment="true"
	 * @generated
	 */
	EList<CollectionJournalLine> getJournalEntries();

	/**
	 * Returns the value of the '<em><b>Reference Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Number</em>' attribute.
	 * @see #setReferenceNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_ReferenceNumber()
	 * @model required="true"
	 * @generated
	 */
	String getReferenceNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getReferenceNumber <em>Reference Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Number</em>' attribute.
	 * @see #getReferenceNumber()
	 * @generated
	 */
	void setReferenceNumber(String value);

	/**
	 * Returns the value of the '<em><b>Journal Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Journal Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Journal Date</em>' attribute.
	 * @see #setJournalDate(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_JournalDate()
	 * @model required="true"
	 * @generated
	 */
	Date getJournalDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getJournalDate <em>Journal Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Journal Date</em>' attribute.
	 * @see #getJournalDate()
	 * @generated
	 */
	void setJournalDate(Date value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The default value is <code>"NEW"</code>.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.dairy.JournalStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.JournalStatus
	 * @see #setStatus(JournalStatus)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_Status()
	 * @model default="NEW" required="true"
	 * @generated
	 */
	JournalStatus getStatus();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.JournalStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(JournalStatus value);

	/**
	 * Returns the value of the '<em><b>Session</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.dairy.Session}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Session
	 * @see #setSession(Session)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_Session()
	 * @model default="0" required="true"
	 * @generated
	 */
	Session getSession();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getSession <em>Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Session
	 * @see #getSession()
	 * @generated
	 */
	void setSession(Session value);

	/**
	 * Returns the value of the '<em><b>Driver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Driver</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver</em>' reference.
	 * @see #setDriver(Employee)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_Driver()
	 * @model required="true"
	 * @generated
	 */
	Employee getDriver();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getDriver <em>Driver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver</em>' reference.
	 * @see #getDriver()
	 * @generated
	 */
	void setDriver(Employee value);

	/**
	 * Returns the value of the '<em><b>Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Route</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Route</em>' reference.
	 * @see #setRoute(Route)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_Route()
	 * @model required="true"
	 * @generated
	 */
	Route getRoute();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getRoute <em>Route</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Route</em>' reference.
	 * @see #getRoute()
	 * @generated
	 */
	void setRoute(Route value);

	/**
	 * Returns the value of the '<em><b>Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vehicle</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle</em>' reference.
	 * @see #setVehicle(Vehicle)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_Vehicle()
	 * @model
	 * @generated
	 */
	Vehicle getVehicle();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getVehicle <em>Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle</em>' reference.
	 * @see #getVehicle()
	 * @generated
	 */
	void setVehicle(Vehicle value);

	/**
	 * Returns the value of the '<em><b>Driver Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Driver Total</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver Total</em>' attribute.
	 * @see #setDriverTotal(BigDecimal)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_DriverTotal()
	 * @model
	 * @generated
	 */
	BigDecimal getDriverTotal();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getDriverTotal <em>Driver Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver Total</em>' attribute.
	 * @see #getDriverTotal()
	 * @generated
	 */
	void setDriverTotal(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Record Total</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Record Total</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Record Total</em>' attribute.
	 * @see #setRecordTotal(BigDecimal)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_RecordTotal()
	 * @model default="0" derived="true"
	 * @generated
	 */
	BigDecimal getRecordTotal();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getRecordTotal <em>Record Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Record Total</em>' attribute.
	 * @see #getRecordTotal()
	 * @generated
	 */
	void setRecordTotal(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Suspended</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspended</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspended</em>' attribute.
	 * @see #setSuspended(boolean)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_Suspended()
	 * @model default="false"
	 * @generated
	 */
	boolean isSuspended();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#isSuspended <em>Suspended</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspended</em>' attribute.
	 * @see #isSuspended()
	 * @generated
	 */
	void setSuspended(boolean value);

	/**
	 * Returns the value of the '<em><b>Entry Count</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Count</em>' attribute.
	 * @see #setEntryCount(int)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_EntryCount()
	 * @model default="0"
	 * @generated
	 */
	int getEntryCount();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getEntryCount <em>Entry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Count</em>' attribute.
	 * @see #getEntryCount()
	 * @generated
	 */
	void setEntryCount(int value);

	/**
	 * Returns the value of the '<em><b>Suspended Count</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspended Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspended Count</em>' attribute.
	 * @see #setSuspendedCount(int)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_SuspendedCount()
	 * @model default="0"
	 * @generated
	 */
	int getSuspendedCount();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getSuspendedCount <em>Suspended Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspended Count</em>' attribute.
	 * @see #getSuspendedCount()
	 * @generated
	 */
	void setSuspendedCount(int value);

	/**
	 * Returns the value of the '<em><b>Rejected Count</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rejected Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rejected Count</em>' attribute.
	 * @see #setRejectedCount(int)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_RejectedCount()
	 * @model default="0"
	 * @generated
	 */
	int getRejectedCount();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getRejectedCount <em>Rejected Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rejected Count</em>' attribute.
	 * @see #getRejectedCount()
	 * @generated
	 */
	void setRejectedCount(int value);

} // CollectionJournalPage
