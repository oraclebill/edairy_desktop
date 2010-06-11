package com.agritrace.edairy.desktop.member.services.farm;

import java.util.List;

import org.junit.*;

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
	
}
