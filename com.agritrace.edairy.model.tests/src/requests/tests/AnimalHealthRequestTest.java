/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package requests.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import requests.AnimalHealthRequest;
import requests.RequestsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Animal Health Request</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnimalHealthRequestTest extends TestCase {

	/**
	 * The fixture for this Animal Health Request test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnimalHealthRequest fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AnimalHealthRequestTest.class);
	}

	/**
	 * Constructs a new Animal Health Request test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimalHealthRequestTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Animal Health Request test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(AnimalHealthRequest fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Animal Health Request test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnimalHealthRequest getFixture() {
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
		setFixture(RequestsFactory.eINSTANCE.createAnimalHealthRequest());
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

} //AnimalHealthRequestTest
