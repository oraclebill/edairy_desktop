/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.tests;

import com.agritrace.edairy.model.dairy.Dairy;
import com.agritrace.edairy.model.dairy.DairyFactory;

import com.agritrace.edairy.model.tests.CompanyTest;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Dairy</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DairyTest extends CompanyTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DairyTest.class);
	}

	/**
	 * Constructs a new Dairy test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Dairy test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Dairy getFixture() {
		return (Dairy)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(DairyFactory.eINSTANCE.createDairy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //DairyTest
