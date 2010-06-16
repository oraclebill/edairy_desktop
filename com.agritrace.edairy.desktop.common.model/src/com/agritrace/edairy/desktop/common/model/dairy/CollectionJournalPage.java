/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import com.agritrace.edairy.desktop.common.model.tracking.Container;

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
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getJournalEntries <em>Journal Entries</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getJournalDate <em>Journal Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getSession <em>Session</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getDriver <em>Driver</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getRoute <em>Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getFarmContainer <em>Farm Container</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getBin <em>Bin</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getVehicle <em>Vehicle</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getDriverTotal <em>Driver Total</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getRecordTotal <em>Record Total</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getJournalId <em>Journal Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage()
 * @model
 * @generated
 */
public interface CollectionJournalPage extends EObject {
	/**
	 * Returns the value of the '<em><b>Journal Entries</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Journal Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Journal Entries</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_JournalEntries()
	 * @model containment="true"
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
	 * Returns the value of the '<em><b>Farm Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Farm Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Farm Container</em>' reference.
	 * @see #setFarmContainer(Container)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_FarmContainer()
	 * @model required="true"
	 * @generated
	 */
	Container getFarmContainer();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getFarmContainer <em>Farm Container</em>}' reference.
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
	 * If the meaning of the '<em>Bin</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bin</em>' reference.
	 * @see #setBin(DairyContainer)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionJournalPage_Bin()
	 * @model required="true"
	 * @generated
	 */
	DairyContainer getBin();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage#getBin <em>Bin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bin</em>' reference.
	 * @see #getBin()
	 * @generated
	 */
	void setBin(DairyContainer value);

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
	 * @model required="true"
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
	 * @model required="true"
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
	 * @model default="0" required="true" derived="true"
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
	 * @model dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID" required="true"
	 *        extendedMetaData="name='journalId' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@Id'"
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

} // CollectionJournalPage
