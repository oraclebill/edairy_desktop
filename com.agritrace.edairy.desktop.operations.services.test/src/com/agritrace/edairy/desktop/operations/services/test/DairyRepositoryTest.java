package com.agritrace.edairy.desktop.operations.services.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.services.HsqldbMemoryPersistenceManager;
import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class DairyRepositoryTest {

	@Before
	public void setupPersistenceManager() {
		System.setProperty("riena.test", "true"); // required to use 'reset' api
		PersistenceManager.reset(new HsqldbMemoryPersistenceManager());
	}

	@Test
	public void testDeliveryJournalQuery() throws Exception {

		IDairyRepository dairyRepo = DairyRepository.getInstance();

		//
		Dairy testDairy = setupTestDairy();
		dairyRepo.save(testDairy);

		//
		Date testDate = new Date( 2009, 10, 10);
		Date afterTestDate = new Date( 2010, 10, 10);
		Date beforeTestDate = new Date( 2008, 10, 10);
		
		DeliveryJournal testJournal;
		testJournal = DairyFactory.eINSTANCE.createDeliveryJournal();
		testJournal.setCustomer(testDairy.getCustomers().get(0));
		testJournal.setDate( testDate );
		testJournal.setDriver(testDairy.getEmployees().get(0));
		testJournal.setReferenceNumber("D-12345");
		testJournal.setRoute(testDairy.getRoutes().get(0));
		testJournal.setSession(Session.AFTERNOON);
		testJournal.setTotal(new BigDecimal(10));
		testJournal.setVehicle(testDairy.getVehicles().get(0));
		
		// save the (updated) dairy, cascades to save journal
		testDairy.getDeliveryJournals().add(testJournal);
		dairyRepo.save(testDairy);
		
		List<DeliveryJournal> journals = dairyRepo.getDeliveryJournals(null, null, null, null); // get
																								// all
		Assert.assertNotNull(journals);
		Assert.assertTrue(journals.size() == 1);
		Assert.assertTrue(journals.contains(testJournal));
		
		journals = dairyRepo.getDeliveryJournals(afterTestDate, null, null, null); 
		
		Assert.assertNotNull(journals);
		Assert.assertTrue(journals.size() == 0);
		Assert.assertTrue(!journals.contains(testJournal));

		journals = dairyRepo.getDeliveryJournals(null, afterTestDate, null, null); 
		
		Assert.assertNotNull(journals);
		Assert.assertTrue(journals.size() == 1);
		Assert.assertTrue(journals.contains(testJournal));

		journals = dairyRepo.getDeliveryJournals(beforeTestDate, afterTestDate, null, null); 
		
		Assert.assertNotNull(journals);
		Assert.assertTrue(journals.size() == 1);
		Assert.assertTrue(journals.contains(testJournal));
		
		journals = dairyRepo.getDeliveryJournals(null, null, testDairy.getRoutes().get(0), null); 
		
		Assert.assertNotNull(journals);
		Assert.assertTrue(journals.size() == 1);
		Assert.assertTrue(journals.contains(testJournal));

		Route testRoute = DairyUtil.createRoute(-1, "Test Route #2", "R-2", "another test route");
		
		journals = dairyRepo.getDeliveryJournals(null, null, testRoute, null); 
		
		Assert.assertNotNull(journals);
		Assert.assertTrue(journals.size() == 0);
		Assert.assertTrue(!journals.contains(testJournal));

		journals = dairyRepo.getDeliveryJournals(null, null, null, testDairy.getCustomers().get(0)); 
		
		Assert.assertNotNull(journals);
		Assert.assertTrue(journals.size() == 1);
		Assert.assertTrue(journals.contains(testJournal));

		Customer testCustomer = DairyUtil.createCustomer("boo-yah enterprises", "BYA", "Milk Bar", "Defunct");
		
		journals = dairyRepo.getDeliveryJournals(null, null, null, testCustomer); 
		
		Assert.assertNotNull(journals);
		Assert.assertTrue(journals.size() == 0);
		Assert.assertTrue(!journals.contains(testJournal));


	}

	private Dairy setupTestDairy() throws ParseException {
		Dairy testDairy = createTestDairy();

		testDairy.getCustomers()
				.add(DairyUtil.createCustomer("Fubar", "Fubar Heavy Industries", "Processor", "Active"));

		testDairy.getEmployees().add(
				DairyUtil.createEmployee(DairyUtil.createPerson("William", "Preston", "Smith", "+1 856.905.2342"), "",
						new Date(), "Driver"));

		testDairy.getRoutes().add(DairyUtil.createRoute(-1, "Route #1", "R-1", "First Route"));

		testDairy.getVehicles().add(
				DairyUtil.createVehicle("logNo", "regNo", 1999, "", "", "color", 2.0d, "chassis", new Date(),
						"engineNo", testDairy.getEmployees().get(0), "tagType", "tagType"));

		return testDairy;
	}

	private Dairy createTestDairy() {
		Dairy dairy = DairyFactory.eINSTANCE.createDairy();

		dairy.setCompanyId(1L);
		dairy.setCompanyName("Test Dairy #1");
		dairy.setLegalName("#1 Test Dairy, Inc.");
		dairy.setDescription("A test dairy");
		dairy.setEstablishedDate(new Date());
		dairy.setFederalPin("1234567");
		dairy.setLicenseEffectiveDate(new Date());
		dairy.setLocation(DairyUtil.createLocation(null, null, null));
		dairy.setManagerName("Bill Jones");
		dairy.setPhoneNumber("+1-212-123-1234");
		dairy.setRegistrationNumber("R1234567");
		dairy.setNhifNumber("NHIF-123445");
		dairy.setNssfNumber("NSSF-123445");

		return dairy;
	}

}
