/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edairy.model.MapLocation#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link edairy.model.MapLocation#getLatitude <em>Latitude</em>}</li>
 * </ul>
 * </p>
 *
 * @see edairy.model.ModelPackage#getMapLocation()
 * @model
 * @generated
 */
public interface MapLocation extends Location {
	/**
	 * Returns the value of the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitude</em>' attribute.
	 * @see #setLongitude(String)
	 * @see edairy.model.ModelPackage#getMapLocation_Longitude()
	 * @model
	 * @generated
	 */
	String getLongitude();

	/**
	 * Sets the value of the '{@link edairy.model.MapLocation#getLongitude <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitude</em>' attribute.
	 * @see #getLongitude()
	 * @generated
	 */
	void setLongitude(String value);

	/**
	 * Returns the value of the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latitude</em>' attribute.
	 * @see #setLatitude(String)
	 * @see edairy.model.ModelPackage#getMapLocation_Latitude()
	 * @model
	 * @generated
	 */
	String getLatitude();

	/**
	 * Sets the value of the '{@link edairy.model.MapLocation#getLatitude <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latitude</em>' attribute.
	 * @see #getLatitude()
	 * @generated
	 */
	void setLatitude(String value);

} // MapLocation
