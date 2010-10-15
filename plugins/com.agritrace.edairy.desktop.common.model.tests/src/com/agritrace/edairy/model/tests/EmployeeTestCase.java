/**
 *
 */
package com.agritrace.edairy.model.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;

/**
 * @author oraclebill
 *
 */
public class EmployeeTestCase {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.agritrace.edairy.model.impl.PartyImpl#getPhoneNumber()}.
	 */
	@Test
	public void testGetPhoneNumber() {
		final Employee emp = DairyFactory.eINSTANCE.createEmployee();
		assertNull( emp.getPhoneNumber() ); // default values
		emp.setPhoneNumber("215-878-6947");
		assertEquals("215-878-6947", emp.getPhoneNumber());

	}

	/**
	 * Test method for {@link com.agritrace.edairy.model.impl.PartyImpl#getLocation()}.
	 */
	@Test
	public void testGetLocation() {
		final Employee emp = DairyFactory.eINSTANCE.createEmployee();
		assertNotNull(emp.getLocation());
	}

	/**
	 * Test method for {@link com.agritrace.edairy.model.impl.PartyImpl#getContactMethods()}.
	 */
	@Test
	public void testGetContactMethods() {
		final Employee emp = DairyFactory.eINSTANCE.createEmployee();
		assertNotNull(emp.getContactMethods());
	}

	/**
	 * Test method for {@link com.agritrace.edairy.model.impl.PartyImpl#getName()}.
	 */
	@Test
	public void testGetName() {
		final Employee emp = DairyFactory.eINSTANCE.createEmployee();
		emp.setGivenName("William");
		emp.setMiddleName("Harold");
		emp.setAdditionalNames("Esteban Garcia");
		emp.setFamilyName("Jones");

		//assertEquals("William Harold Jones Esteban Garcia", emp.getName());

	}

	/**
	 * Test method for {@link com.agritrace.edairy.model.impl.PartyImpl#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		DairyFactory.eINSTANCE.createEmployee();
		try {
			//emp.setName("test this" );
		}
		catch (final UnsupportedOperationException e) {
			;
		}
	}

}
