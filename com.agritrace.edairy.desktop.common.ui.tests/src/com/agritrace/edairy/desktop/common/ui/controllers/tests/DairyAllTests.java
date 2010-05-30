/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.ui.controllers.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test suite for the '<em><b>Dairy</b></em>' model.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DairyAllTests extends TestSuite {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(String[] args) {
	TestRunner.run(suite());
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static Test suite() {
	final TestSuite suite = new DairyAllTests("Dairy Tests");
	suite.addTest(DairyLocationTests.suite());
	return suite;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DairyAllTests(String name) {
	super(name);
    }

} // DairyAllTests
