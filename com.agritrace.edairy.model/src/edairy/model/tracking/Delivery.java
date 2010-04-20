/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model.tracking;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delivery</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edairy.model.tracking.Delivery#getLot <em>Lot</em>}</li>
 *   <li>{@link edairy.model.tracking.Delivery#getCustomer <em>Customer</em>}</li>
 * </ul>
 * </p>
 *
 * @see edairy.model.tracking.TrackingPackage#getDelivery()
 * @model
 * @generated
 */
public interface Delivery extends Transfer {
	/**
	 * Returns the value of the '<em><b>Lot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lot</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lot</em>' reference.
	 * @see #setLot(Lot)
	 * @see edairy.model.tracking.TrackingPackage#getDelivery_Lot()
	 * @model required="true"
	 * @generated
	 */
	Lot getLot();

	/**
	 * Sets the value of the '{@link edairy.model.tracking.Delivery#getLot <em>Lot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lot</em>' reference.
	 * @see #getLot()
	 * @generated
	 */
	void setLot(Lot value);

	/**
	 * Returns the value of the '<em><b>Customer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer</em>' reference.
	 * @see #setCustomer(Processor)
	 * @see edairy.model.tracking.TrackingPackage#getDelivery_Customer()
	 * @model required="true"
	 * @generated
	 */
	Processor getCustomer();

	/**
	 * Sets the value of the '{@link edairy.model.tracking.Delivery#getCustomer <em>Customer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer</em>' reference.
	 * @see #getCustomer()
	 * @generated
	 */
	void setCustomer(Processor value);

} // Delivery
