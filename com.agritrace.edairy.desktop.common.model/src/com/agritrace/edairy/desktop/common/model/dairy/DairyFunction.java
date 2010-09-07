/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Function</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getDairyFunction()
 * @model
 * @generated
 */
public enum DairyFunction implements Enumerator {
	/**
	 * The '<em><b>Milk Collection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MILK_COLLECTION_VALUE
	 * @generated
	 * @ordered
	 */
	MILK_COLLECTION(0, "MilkCollection", "Milk Collection"),

	/**
	 * The '<em><b>Milk Storage</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MILK_STORAGE_VALUE
	 * @generated
	 * @ordered
	 */
	MILK_STORAGE(1, "MilkStorage", "Milk Storage"),

	/**
	 * The '<em><b>Store Sales</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORE_SALES_VALUE
	 * @generated
	 * @ordered
	 */
	STORE_SALES(2, "StoreSales", "Store Sales"),

	/**
	 * The '<em><b>Warehouse</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WAREHOUSE_VALUE
	 * @generated
	 * @ordered
	 */
	WAREHOUSE(3, "Warehouse", "Warehouse"),

	/**
	 * The '<em><b>Milk Processing</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MILK_PROCESSING_VALUE
	 * @generated
	 * @ordered
	 */
	MILK_PROCESSING(4, "MilkProcessing", "Milk Processing");

	/**
	 * The '<em><b>Milk Collection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Milk Collection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MILK_COLLECTION
	 * @model name="MilkCollection" literal="Milk Collection"
	 * @generated
	 * @ordered
	 */
	public static final int MILK_COLLECTION_VALUE = 0;

	/**
	 * The '<em><b>Milk Storage</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Milk Storage</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MILK_STORAGE
	 * @model name="MilkStorage" literal="Milk Storage"
	 * @generated
	 * @ordered
	 */
	public static final int MILK_STORAGE_VALUE = 1;

	/**
	 * The '<em><b>Store Sales</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Store Sales</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STORE_SALES
	 * @model name="StoreSales" literal="Store Sales"
	 * @generated
	 * @ordered
	 */
	public static final int STORE_SALES_VALUE = 2;

	/**
	 * The '<em><b>Warehouse</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Warehouse</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WAREHOUSE
	 * @model name="Warehouse"
	 * @generated
	 * @ordered
	 */
	public static final int WAREHOUSE_VALUE = 3;

	/**
	 * The '<em><b>Milk Processing</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Milk Processing</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MILK_PROCESSING
	 * @model name="MilkProcessing" literal="Milk Processing"
	 * @generated
	 * @ordered
	 */
	public static final int MILK_PROCESSING_VALUE = 4;

	/**
	 * An array of all the '<em><b>Function</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DairyFunction[] VALUES_ARRAY =
		new DairyFunction[] {
			MILK_COLLECTION,
			MILK_STORAGE,
			STORE_SALES,
			WAREHOUSE,
			MILK_PROCESSING,
		};

	/**
	 * A public read-only list of all the '<em><b>Function</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DairyFunction> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Function</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DairyFunction get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DairyFunction result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Function</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DairyFunction getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DairyFunction result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Function</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DairyFunction get(int value) {
		switch (value) {
			case MILK_COLLECTION_VALUE: return MILK_COLLECTION;
			case MILK_STORAGE_VALUE: return MILK_STORAGE;
			case STORE_SALES_VALUE: return STORE_SALES;
			case WAREHOUSE_VALUE: return WAREHOUSE;
			case MILK_PROCESSING_VALUE: return MILK_PROCESSING;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private DairyFunction(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //DairyFunction
