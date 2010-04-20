/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model.dairy;

import edairy.model.tracking.Container;

import java.math.BigDecimal;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Journal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edairy.model.dairy.CollectionJournal#getJournalEntries <em>Journal Entries</em>}</li>
 *   <li>{@link edairy.model.dairy.CollectionJournal#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link edairy.model.dairy.CollectionJournal#getJournalDate <em>Journal Date</em>}</li>
 *   <li>{@link edairy.model.dairy.CollectionJournal#getDriver <em>Driver</em>}</li>
 *   <li>{@link edairy.model.dairy.CollectionJournal#getRoute <em>Route</em>}</li>
 *   <li>{@link edairy.model.dairy.CollectionJournal#getSession <em>Session</em>}</li>
 *   <li>{@link edairy.model.dairy.CollectionJournal#getCan <em>Can</em>}</li>
 *   <li>{@link edairy.model.dairy.CollectionJournal#getBin <em>Bin</em>}</li>
 *   <li>{@link edairy.model.dairy.CollectionJournal#getVehicle <em>Vehicle</em>}</li>
 *   <li>{@link edairy.model.dairy.CollectionJournal#getDriverTotal <em>Driver Total</em>}</li>
 *   <li>{@link edairy.model.dairy.CollectionJournal#getTotal <em>Total</em>}</li>
 * </ul>
 * </p>
 *
 * @see edairy.model.dairy.DairyPackage#getCollectionJournal()
 * @model
 * @generated
 */
public interface CollectionJournal extends EObject {
	/**
	 * Returns the value of the '<em><b>Journal Entries</b></em>' containment reference list.
	 * The list contents are of type {@link edairy.model.dairy.CollectionRecord}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Journal Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Journal Entries</em>' containment reference list.
	 * @see edairy.model.dairy.DairyPackage#getCollectionJournal_JournalEntries()
	 * @model containment="true"
	 * @generated
	 */
	EList<CollectionRecord> getJournalEntries();

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
	 * @see edairy.model.dairy.DairyPackage#getCollectionJournal_ReferenceNumber()
	 * @model required="true"
	 * @generated
	 */
	String getReferenceNumber();

	/**
	 * Sets the value of the '{@link edairy.model.dairy.CollectionJournal#getReferenceNumber <em>Reference Number</em>}' attribute.
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
	 * @see edairy.model.dairy.DairyPackage#getCollectionJournal_JournalDate()
	 * @model required="true"
	 * @generated
	 */
	Date getJournalDate();

	/**
	 * Sets the value of the '{@link edairy.model.dairy.CollectionJournal#getJournalDate <em>Journal Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Journal Date</em>' attribute.
	 * @see #getJournalDate()
	 * @generated
	 */
	void setJournalDate(Date value);

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
	 * @see edairy.model.dairy.DairyPackage#getCollectionJournal_Driver()
	 * @model required="true"
	 * @generated
	 */
	Employee getDriver();

	/**
	 * Sets the value of the '{@link edairy.model.dairy.CollectionJournal#getDriver <em>Driver</em>}' reference.
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
	 * @see #setRoute(RouteDefinition)
	 * @see edairy.model.dairy.DairyPackage#getCollectionJournal_Route()
	 * @model required="true"
	 * @generated
	 */
	RouteDefinition getRoute();

	/**
	 * Sets the value of the '{@link edairy.model.dairy.CollectionJournal#getRoute <em>Route</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Route</em>' reference.
	 * @see #getRoute()
	 * @generated
	 */
	void setRoute(RouteDefinition value);

	/**
	 * Returns the value of the '<em><b>Session</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session</em>' reference.
	 * @see #setSession(Session)
	 * @see edairy.model.dairy.DairyPackage#getCollectionJournal_Session()
	 * @model required="true"
	 * @generated
	 */
	Session getSession();

	/**
	 * Sets the value of the '{@link edairy.model.dairy.CollectionJournal#getSession <em>Session</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session</em>' reference.
	 * @see #getSession()
	 * @generated
	 */
	void setSession(Session value);

	/**
	 * Returns the value of the '<em><b>Can</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Can</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Can</em>' reference.
	 * @see #setCan(Container)
	 * @see edairy.model.dairy.DairyPackage#getCollectionJournal_Can()
	 * @model required="true"
	 * @generated
	 */
	Container getCan();

	/**
	 * Sets the value of the '{@link edairy.model.dairy.CollectionJournal#getCan <em>Can</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can</em>' reference.
	 * @see #getCan()
	 * @generated
	 */
	void setCan(Container value);

	/**
	 * Returns the value of the '<em><b>Bin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bin</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bin</em>' reference.
	 * @see #setBin(Container)
	 * @see edairy.model.dairy.DairyPackage#getCollectionJournal_Bin()
	 * @model required="true"
	 * @generated
	 */
	Container getBin();

	/**
	 * Sets the value of the '{@link edairy.model.dairy.CollectionJournal#getBin <em>Bin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bin</em>' reference.
	 * @see #getBin()
	 * @generated
	 */
	void setBin(Container value);

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
	 * @see edairy.model.dairy.DairyPackage#getCollectionJournal_Vehicle()
	 * @model required="true"
	 * @generated
	 */
	Vehicle getVehicle();

	/**
	 * Sets the value of the '{@link edairy.model.dairy.CollectionJournal#getVehicle <em>Vehicle</em>}' reference.
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
	 * @see edairy.model.dairy.DairyPackage#getCollectionJournal_DriverTotal()
	 * @model required="true"
	 * @generated
	 */
	BigDecimal getDriverTotal();

	/**
	 * Sets the value of the '{@link edairy.model.dairy.CollectionJournal#getDriverTotal <em>Driver Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver Total</em>' attribute.
	 * @see #getDriverTotal()
	 * @generated
	 */
	void setDriverTotal(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Total</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total</em>' attribute.
	 * @see #setTotal(BigDecimal)
	 * @see edairy.model.dairy.DairyPackage#getCollectionJournal_Total()
	 * @model default="0" required="true" derived="true"
	 * @generated
	 */
	BigDecimal getTotal();

	/**
	 * Sets the value of the '{@link edairy.model.dairy.CollectionJournal#getTotal <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total</em>' attribute.
	 * @see #getTotal()
	 * @generated
	 */
	void setTotal(BigDecimal value);

} // CollectionJournal
