/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '
 * <em><b>Membership Status</b></em>', and utility methods for working with
 * them. <!-- end-user-doc -->
 * 
 * @see com.agritrace.edairy.model.dairy.DairyPackage#getMembershipStatus()
 * @model
 * @generated
 */
public enum MembershipStatus implements Enumerator {
    /**
     * The '<em><b>Active</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #ACTIVE_VALUE
     * @generated
     * @ordered
     */
    ACTIVE(0, "Active", "Active"),

    /**
     * The '<em><b>Inactive</b></em>' literal object. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #INACTIVE_VALUE
     * @generated
     * @ordered
     */
    INACTIVE(1, "Inactive", "Inactive"),

    /**
     * The '<em><b>Dormant</b></em>' literal object. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #DORMANT_VALUE
     * @generated
     * @ordered
     */
    DORMANT(2, "Dormant", "Dormant");

    /**
     * The '<em><b>Active</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Active</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #ACTIVE
     * @model name="Active"
     * @generated
     * @ordered
     */
    public static final int ACTIVE_VALUE = 0;

    /**
     * The '<em><b>Inactive</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Inactive</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #INACTIVE
     * @model name="Inactive"
     * @generated
     * @ordered
     */
    public static final int INACTIVE_VALUE = 1;

    /**
     * The '<em><b>Dormant</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Dormant</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #DORMANT
     * @model name="Dormant"
     * @generated
     * @ordered
     */
    public static final int DORMANT_VALUE = 2;

    /**
     * An array of all the '<em><b>Membership Status</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static final MembershipStatus[] VALUES_ARRAY = new MembershipStatus[] { ACTIVE, INACTIVE, DORMANT, };

    /**
     * A public read-only list of all the '<em><b>Membership Status</b></em>'
     * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final List<MembershipStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Membership Status</b></em>' literal with the
     * specified literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static MembershipStatus get(String literal) {
	for (int i = 0; i < VALUES_ARRAY.length; ++i) {
	    final MembershipStatus result = VALUES_ARRAY[i];
	    if (result.toString().equals(literal)) {
		return result;
	    }
	}
	return null;
    }

    /**
     * Returns the '<em><b>Membership Status</b></em>' literal with the
     * specified name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static MembershipStatus getByName(String name) {
	for (int i = 0; i < VALUES_ARRAY.length; ++i) {
	    final MembershipStatus result = VALUES_ARRAY[i];
	    if (result.getName().equals(name)) {
		return result;
	    }
	}
	return null;
    }

    /**
     * Returns the '<em><b>Membership Status</b></em>' literal with the
     * specified integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static MembershipStatus get(int value) {
	switch (value) {
	case ACTIVE_VALUE:
	    return ACTIVE;
	case INACTIVE_VALUE:
	    return INACTIVE;
	case DORMANT_VALUE:
	    return DORMANT;
	}
	return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    private MembershipStatus(int value, String name, String literal) {
	this.value = value;
	this.name = name;
	this.literal = literal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getValue() {
	return value;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getName() {
	return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getLiteral() {
	return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string
     * representation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
	return literal;
    }

} // MembershipStatus
