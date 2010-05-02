/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.tracking.tests;

import com.agritrace.edairy.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.model.tracking.TrackingFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Registered Animal</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RegisteredAnimalTest extends TestCase {

	/**
	 * The fixture for this Registered Animal test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegisteredAnimal fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RegisteredAnimalTest.class);
	}

	/**
	 * Constructs a new Registered Animal test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegisteredAnimalTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Registered Animal test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(RegisteredAnimal fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Registered Animal test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegisteredAnimal getFixture() {
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
		setFixture(TrackingFactory.eINSTANCE.createRegisteredAnimal());
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

} //RegisteredAnimalTest
