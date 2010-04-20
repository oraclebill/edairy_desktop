/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postal Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edairy.model.PostalLocation#getAddress <em>Address</em>}</li>
 *   <li>{@link edairy.model.PostalLocation#getProvince <em>Province</em>}</li>
 *   <li>{@link edairy.model.PostalLocation#getDivision <em>Division</em>}</li>
 *   <li>{@link edairy.model.PostalLocation#getDistrict <em>District</em>}</li>
 *   <li>{@link edairy.model.PostalLocation#getLocation <em>Location</em>}</li>
 *   <li>{@link edairy.model.PostalLocation#getSubLocation <em>Sub Location</em>}</li>
 *   <li>{@link edairy.model.PostalLocation#getVillage <em>Village</em>}</li>
 *   <li>{@link edairy.model.PostalLocation#getPostalCode <em>Postal Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see edairy.model.ModelPackage#getPostalLocation()
 * @model
 * @generated
 */
public interface PostalLocation extends Location {
	/**
	 * Returns the value of the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' attribute.
	 * @see #setAddress(String)
	 * @see edairy.model.ModelPackage#getPostalLocation_Address()
	 * @model
	 * @generated
	 */
	String getAddress();

	/**
	 * Sets the value of the '{@link edairy.model.PostalLocation#getAddress <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' attribute.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(String value);

	/**
	 * Returns the value of the '<em><b>Province</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Province</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Province</em>' attribute.
	 * @see #setProvince(String)
	 * @see edairy.model.ModelPackage#getPostalLocation_Province()
	 * @model required="true"
	 * @generated
	 */
	String getProvince();

	/**
	 * Sets the value of the '{@link edairy.model.PostalLocation#getProvince <em>Province</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Province</em>' attribute.
	 * @see #getProvince()
	 * @generated
	 */
	void setProvince(String value);

	/**
	 * Returns the value of the '<em><b>Division</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Division</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Division</em>' attribute.
	 * @see #setDivision(String)
	 * @see edairy.model.ModelPackage#getPostalLocation_Division()
	 * @model required="true"
	 * @generated
	 */
	String getDivision();

	/**
	 * Sets the value of the '{@link edairy.model.PostalLocation#getDivision <em>Division</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Division</em>' attribute.
	 * @see #getDivision()
	 * @generated
	 */
	void setDivision(String value);

	/**
	 * Returns the value of the '<em><b>District</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>District</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>District</em>' attribute.
	 * @see #setDistrict(String)
	 * @see edairy.model.ModelPackage#getPostalLocation_District()
	 * @model required="true"
	 * @generated
	 */
	String getDistrict();

	/**
	 * Sets the value of the '{@link edairy.model.PostalLocation#getDistrict <em>District</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>District</em>' attribute.
	 * @see #getDistrict()
	 * @generated
	 */
	void setDistrict(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see edairy.model.ModelPackage#getPostalLocation_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link edairy.model.PostalLocation#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Sub Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Location</em>' attribute.
	 * @see #setSubLocation(String)
	 * @see edairy.model.ModelPackage#getPostalLocation_SubLocation()
	 * @model
	 * @generated
	 */
	String getSubLocation();

	/**
	 * Sets the value of the '{@link edairy.model.PostalLocation#getSubLocation <em>Sub Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Location</em>' attribute.
	 * @see #getSubLocation()
	 * @generated
	 */
	void setSubLocation(String value);

	/**
	 * Returns the value of the '<em><b>Village</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Village</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Village</em>' attribute.
	 * @see #setVillage(String)
	 * @see edairy.model.ModelPackage#getPostalLocation_Village()
	 * @model
	 * @generated
	 */
	String getVillage();

	/**
	 * Sets the value of the '{@link edairy.model.PostalLocation#getVillage <em>Village</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Village</em>' attribute.
	 * @see #getVillage()
	 * @generated
	 */
	void setVillage(String value);

	/**
	 * Returns the value of the '<em><b>Postal Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postal Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postal Code</em>' attribute.
	 * @see #setPostalCode(String)
	 * @see edairy.model.ModelPackage#getPostalLocation_PostalCode()
	 * @model required="true"
	 * @generated
	 */
	String getPostalCode();

	/**
	 * Sets the value of the '{@link edairy.model.PostalLocation#getPostalCode <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Code</em>' attribute.
	 * @see #getPostalCode()
	 * @generated
	 */
	void setPostalCode(String value);

} // PostalLocation
