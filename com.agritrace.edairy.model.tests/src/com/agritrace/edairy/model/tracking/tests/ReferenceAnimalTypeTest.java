/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.tracking.tests;

import com.agritrace.edairy.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.model.tracking.TrackingFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Reference Animal Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReferenceAnimalTypeTest extends TestCase {

	/**
	 * The fixture for this Reference Animal Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceAnimalType fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ReferenceAnimalTypeTest.class);
	}

	/**
	 * Constructs a new Reference Animal Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceAnimalTypeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Reference Animal Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ReferenceAnimalType fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Reference Animal Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceAnimalType getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TrackingFactory.eINSTANCE.createReferenceAnimalType());
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

} //ReferenceAnimalTypeTest
