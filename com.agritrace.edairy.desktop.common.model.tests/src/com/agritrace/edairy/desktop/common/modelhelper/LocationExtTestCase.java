package com.agritrace.edairy.desktop.common.modelhelper;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;

public class LocationExtTestCase {

	@Test
	public void testILocationExtFactory() {
		final Dairy dairy = DairyFactory.eINSTANCE.createDairy();
		assertNull(dairy.getLocation());
		try {
			dairy.getLocation().getPostalLocation().setAddress("fail");
			fail();
		}
		catch( final Throwable t) {
			;;
		}
//		LocationExtFactory factory = new LocationExtFactory();
//
////		ILocationExt adaptedDairy = (ILocationExt) factory.getAdapter(dairy, ILocationExt.class);
////		assertNotNull(adaptedDairy);
////		adaptedDairy.setAddress("will fail normally with NPE");
//
//		Person person = ModelFactory.eINSTANCE.createPerson();
//		assertNull(person.getLocation());
//		ILocationExt adaptedPerson = (ILocationExt) factory.getAdapter(person, ILocationExt.class);
//		assertNotNull(adaptedPerson);
//		adaptedPerson.setAddress("will fail normally with NPE");

	}
}
