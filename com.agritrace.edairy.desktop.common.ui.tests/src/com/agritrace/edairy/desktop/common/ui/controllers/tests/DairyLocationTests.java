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
 * <!-- begin-user-doc --> A test suite for the '<em><b>dairy</b></em>' package.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DairyLocationTests extends TestSuite {

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
	final TestSuite suite = new DairyLocationTests("dairy Tests");
	suite.addTestSuite(DairyLocationControllerTest.class);
	return suite;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DairyLocationTests(String name) {
	super(name);
    }

}
