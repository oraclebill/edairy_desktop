/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Descriptive Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edairy.model.DescriptiveLocation#getDirections <em>Directions</em>}</li>
 * </ul>
 * </p>
 *
 * @see edairy.model.ModelPackage#getDescriptiveLocation()
 * @model
 * @generated
 */
public interface DescriptiveLocation extends Location {
	/**
	 * Returns the value of the '<em><b>Directions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directions</em>' attribute.
	 * @see #setDirections(String)
	 * @see edairy.model.ModelPackage#getDescriptiveLocation_Directions()
	 * @model required="true"
	 * @generated
	 */
	String getDirections();

	/**
	 * Sets the value of the '{@link edairy.model.DescriptiveLocation#getDirections <em>Directions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directions</em>' attribute.
	 * @see #getDirections()
	 * @generated
	 */
	void setDirections(String value);

} // DescriptiveLocation
