package com.agritrace.edairy.desktop.collection.services;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.MilkPrice;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.services.HsqldbMemoryPersistenceManager;
import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;
import com.agritrace.edairy.desktop.internal.collection.services.MilkCollectionJournalLineRepository;
import com.csvreader.CsvReader;

public class MilkCollectionJournalLineQueryTest {

	private PersistenceManager testPM;

	@Before
	public void setup() {
	}

	// @Test
	public void testCountByMemberCenterDate() {
		createTestContext();
		ICollectionJournalLineRepository repo = new MilkCollectionJournalLineRepository();
		assertEquals(0, repo.countByMemberCenterDate(null, null, null));
	}

	public void testAllForDate() {
		long queryDate = 100000;

		createTestContext();
		ICollectionJournalLineRepository repo = new MilkCollectionJournalLineRepository();

		List<CollectionGroup> collections = repo
				.allForDate(new Date(queryDate));
		assertEquals(1, collections.size());
	}

	@Test
	public void testGetMilkPrice() throws Exception {
		createTestContext();
		ICollectionJournalLineRepository repo = new MilkCollectionJournalLineRepository();

		// initially empty
		assertEquals(0, dairy.getPriceHistory().size());

		// create some data
		long queryDate = 100000;
		MilkPrice milkPrice = DairyFactory.eINSTANCE.createMilkPrice();
		milkPrice.setEnteredBy(driver);
		milkPrice.setEntryDate(new Date(queryDate));
		milkPrice.setMonth(1);
		milkPrice.setYear(1990);
		milkPrice.setValue(new BigDecimal("23.22"));

		dairy.getPriceHistory().add(milkPrice);
		testPM.getSession().save(dairy);

		assertEquals(1, dairy.getPriceHistory().size());
		BigDecimal rate = repo.getMilkPrice(1, 1990);
		assertEquals(new BigDecimal("23.22"), rate);

	}

	public void testGetMembersWithDeliveriesFor() throws Exception {

	}

	public void testGetPayableDeliveriesForMember() throws Exception {

	}

	public void testGetSumOfPayableDeliveries() throws Exception {

	}

	private Dairy createSampleDairy(PersistenceManager pm) {
		Dairy dairy = DairyFactory.eINSTANCE.createDairy();
		dairy.setCompanyName("test");
		dairy.setDescription("");
		dairy.setRegistrationNumber("");
		dairy.setLocation(DairyUtil.createLocation(null, null, null));
		dairy.setPhoneNumber("");
		
		driver = DairyUtil.createEmployee(null, "Driver", new Date(100000),
				"Strom", "", "Thurmond", "", null, null);
		dairy.getEmployees().add(driver);

		pm.getSession().save(dairy);
		return dairy;
	}

	Dairy dairy;
	Employee driver;

	private void createTestContext( ) {
		createTestContext(null);
	}
	
	private void createTestContext(String testFile) {
		testPM = new HsqldbMemoryPersistenceManager();
		System.setProperty("riena.test", "true");
		PersistenceManager.reset(testPM);

		dairy = createSampleDairy(testPM);


		if (testFile != null) {
			try {
				CsvReader reader = new CsvReader(testFile);
				reader.readHeaders();
				while (reader.readRecord()) {
					final String[] rec = reader.getValues();
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
