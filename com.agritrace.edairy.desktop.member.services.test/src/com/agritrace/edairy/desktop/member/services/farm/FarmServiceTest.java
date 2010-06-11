package com.agritrace.edairy.desktop.member.services.farm;

import java.util.List;

import org.junit.*;

import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.services.HsqldbMemoryPersistenceManager;
import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;


public class FarmServiceTest {

	@BeforeClass
	public static void setupClass() throws Exception {
		// setup a test persistence manager..
		PersistenceManager.setDefault(new HsqldbMemoryPersistenceManager());
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
