package com.agritrace.edairy.desktop.member.services.farm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.services.HsqldbMemoryPersistenceManager;
import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;


public class FarmServiceTest {

	@Before
	public void setup() throws Exception {
		// setup a test persistence manager..
		//     need to set this first in order to use the 'reset' method.
		System.setProperty("riena.test", "true");  // RIENA_TEST_SYSTEM_PROPERTY == "riena.test"
		PersistenceManager.reset(new HsqldbMemoryPersistenceManager());
	}
	
	@Test
	public void testCreatingAFarm() throws Exception {
		IFarmRepository farmRepo = new FarmRepository();
		List<Farm> myFarms = farmRepo.all();
		Assert.assertEquals(0, myFarms.size());
		farmRepo.saveNew(
				DairyUtil.createFarm(
						"Test Farm", 
						DairyUtil.createLocation(null, null, null)));
		myFarms = farmRepo.all();
		String farmName = myFarms.get(0).getName();
		Assert.assertEquals("Test Farm", farmName);
	
	}
	
	@Test
	public void testCreateFarmList() throws Exception {
		IFarmRepository farmRepo = new FarmRepository();
		List<Farm> myFarms = new ArrayList<Farm>();
		final Location location1 = DairyUtil.createLocation("1 - Ngeche",
				"Section A", "Building B", "West Windosr",
				"Princeton Junction", "Princeton", "Central", "Mercer",
				"Western", "08550");
		Farm farm1 = DairyUtil.createFarm("Farm 1", location1);
		farm1.setFarmId(10001l);
		myFarms.add(farm1);

		final Location location2 = DairyUtil.createLocation("2 -North Post",
				"Section A", "Building B", "West Windosr",
				"Princeton Junction", "Princeton", "Central", "Mercer",
				"Western", "08550");

		Farm farm2 = DairyUtil.createFarm("Farm 2", location2);
		farm2.setFarmId(10002l);
		myFarms.add(farm2);
		farmRepo.saveNew(farm1);
		farmRepo.saveNew(farm2);	
		
		System.err.println(farmRepo.all());
		assertEquals(2, farmRepo.all().size());
		assertEquals("Section A", farmRepo.all().get(0).getLocation().getPostalLocation().getSection());
	}
	
}
