package com.agritrace.edairy.desktop.common.ui.controllers.tests;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.ui.swt.controllers.AbstractSubModuleControllerTest;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.collection.services.TestPersistenceModule;
import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.MapLocation;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFunction;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.dairy.locations.ui.DairyLocationUIConstants;
import com.agritrace.edairy.desktop.dairy.locations.ui.controllers.DairyLocationDirectoryController;
import com.google.inject.Guice;

public class DairyLocationControllerTest extends AbstractSubModuleControllerTest<DairyLocationDirectoryController> {

	private DairyLocation dairyLocation;
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(DairyLocationUIConstants.DATE_FORMATE);

	@Override
	protected DairyLocationDirectoryController createController(ISubModuleNode node) {
		initTestData();
		node.setNodeId(new NavigationNodeId(DairyLocationUIConstants.NODE_ID));
		final DairyLocationDirectoryController newInst = 
			Guice.createInjector(new TestPersistenceModule()).getInstance(DairyLocationDirectoryController.class);
		newInst.setNavigationNode(node);
		// newInst.getInput().add(dairyLocation);
		return newInst;
	}

	private DairyLocation initTestData() {
		dairyLocation = DairyFactory.eINSTANCE.createDairyLocation();

		dairyLocation.setName("testDairylocationName");
		dairyLocation.setDescription("test dairy location description ");
		dairyLocation.setDateOpened(new Date());
		dairyLocation.setPhone("555-111-222");
		dairyLocation.getFunctions().addAll(
				Arrays.asList(DairyFunction.MILK_COLLECTION, DairyFunction.MILK_STORAGE, DairyFunction.MILK_PROCESSING,
						DairyFunction.WAREHOUSE, DairyFunction.STORE_SALES));
		dairyLocation.setCode("RED");

		final Route route = DairyFactory.eINSTANCE.createRoute();
		route.setName("testroutename");
		route.setDescription("testroutedesc");
		// route.setCode("BLUE");

		dairyLocation.setRoute(route);
		final Location location = ModelFactory.eINSTANCE.createLocation();

		final PostalLocation postalLocation = ModelFactory.eINSTANCE.createPostalLocation();
		postalLocation.setAddress("test address");
		postalLocation.setSection("test section");
		postalLocation.setEstate("test estate");
		postalLocation.setVillage("test village");
		postalLocation.setLocation("test location");
		postalLocation.setSubLocation("test sublocation");
		postalLocation.setDistrict("test district");
		postalLocation.setDivision("test division");
		postalLocation.setPostalCode("123456");
		postalLocation.setProvince("TP");

		final DescriptiveLocation descriptiveLocation = ModelFactory.eINSTANCE.createDescriptiveLocation();
		descriptiveLocation.setLandmarks("test landmarks");
		descriptiveLocation.setDirections("test directions");

		final MapLocation mapLocation = ModelFactory.eINSTANCE.createMapLocation();
		mapLocation.setLatitude(Double.valueOf("123.00"));
		mapLocation.setLongitude(Double.valueOf("-100.00"));

		location.setPostalLocation(postalLocation);
		location.setDescriptiveLocation(descriptiveLocation);
		location.setMapLocation(mapLocation);
		dairyLocation.setLocation(location);
		return dairyLocation;
	}

	public void testDairyLocationBasicInfo() {
		final ITextRidget nameText = getController().getRidget(ITextRidget.class,
				DairyLocationUIConstants.RIDGET_ID_NAME);
		Assert.assertEquals("testDairylocationName", nameText.getText());
		nameText.setText("newname");
		Assert.assertEquals("newname", dairyLocation.getName());

		final ITextRidget description = getController().getRidget(ITextRidget.class,
				DairyLocationUIConstants.RIDGET_ID_DESCRIPTION);
		Assert.assertEquals("test dairy location description ", description.getText());
		description.setText("newdesc");
		Assert.assertEquals("newdesc", dairyLocation.getDescription());

		final ITextRidget phone = getController()
				.getRidget(ITextRidget.class, DairyLocationUIConstants.RIDGET_ID_PHONE);
		Assert.assertEquals("555-111-222", phone.getText());
		phone.setText("111-222-333");
		Assert.assertEquals("111-222-333", dairyLocation.getPhone());

		final IDateTimeRidget dateOpened = getController().getRidget(IDateTimeRidget.class,
				DairyLocationUIConstants.RIDGET_ID_DATEOPENED);
		Assert.assertEquals(dateFormat.format(new Date()), dateOpened.getText());
		dateOpened.setText("03/04/2001");
		Assert.assertEquals("03/04/2001", dateFormat.format(dairyLocation.getDateOpened()));

		final IMultipleChoiceRidget functions = getController().getRidget(IMultipleChoiceRidget.class,
				DairyLocationUIConstants.RIDGET_ID_FUNCTIONS);
		final List<DairyFunction> list1 = dairyLocation.getFunctions();
		Assert.assertEquals(list1.size(), functions.getSelection().size());
		functions.setSelection(null);
		Assert.assertEquals(0, list1.size());

		final IComboRidget route = getController().getRidget(IComboRidget.class,
				DairyLocationUIConstants.RIDGET_ID_ROUTE);
		Assert.assertEquals(dairyLocation.getRoute().getName(), ((Route) route.getSelection()).getName());
	}

	public void testAddressTab() {
		final ITextRidget textAddress = getController().getRidget(ITextRidget.class,
				DairyLocationUIConstants.RIDGET_ID_PL_ADDRESS);
		Assert.assertEquals("test address", textAddress.getText());
		textAddress.setText("newaddress");
		Assert.assertEquals("newaddress", dairyLocation.getLocation().getPostalLocation().getAddress());

		final ITextRidget section = getController().getRidget(ITextRidget.class,
				DairyLocationUIConstants.RIDGET_ID_PL_SECTION);
		Assert.assertEquals("test section", section.getText());
		section.setText("newsection");
		Assert.assertEquals("newsection", dairyLocation.getLocation().getPostalLocation().getSection());

		final ITextRidget town = getController().getRidget(ITextRidget.class,
				DairyLocationUIConstants.RIDGET_ID_PL_TOWN);
		Assert.assertEquals("test village", town.getText());
		town.setText("newvillage");
		Assert.assertEquals("newvillage", dairyLocation.getLocation().getPostalLocation().getVillage());

		final ITextRidget estate = getController().getRidget(ITextRidget.class,
				DairyLocationUIConstants.RIDGET_ID_PL_ESTATE);
		Assert.assertEquals("test estate", estate.getText());
		estate.setText("newestate");
		Assert.assertEquals("newestate", dairyLocation.getLocation().getPostalLocation().getEstate());

		final ITextRidget location = getController().getRidget(ITextRidget.class,
				DairyLocationUIConstants.RIDGET_ID_PL_LOCATION);
		Assert.assertEquals("test location", location.getText());
		location.setText("newlocation");
		Assert.assertEquals("newlocation", dairyLocation.getLocation().getPostalLocation().getLocation());

		final ITextRidget sub = getController().getRidget(ITextRidget.class, DairyLocationUIConstants.RIDGET_ID_PL_SUB);
		Assert.assertEquals("test sublocation", sub.getText());
		sub.setText("newsublocation");
		Assert.assertEquals("newsublocation", dairyLocation.getLocation().getPostalLocation().getSubLocation());

		final ITextRidget district = getController().getRidget(ITextRidget.class,
				DairyLocationUIConstants.RIDGET_ID_PL_DISTRICT);
		Assert.assertEquals("test district", district.getText());
		district.setText("newdistrict");
		Assert.assertEquals("newdistrict", dairyLocation.getLocation().getPostalLocation().getDistrict());

		final ITextRidget division = getController().getRidget(ITextRidget.class,
				DairyLocationUIConstants.RIDGET_ID_PL_DIVISION);
		Assert.assertEquals("test division", division.getText());
		division.setText("newdivision");
		Assert.assertEquals("newdivision", dairyLocation.getLocation().getPostalLocation().getDivision());

		final ITextRidget postalCode = getController().getRidget(ITextRidget.class,
				DairyLocationUIConstants.RIDGET_ID_PL_POSTALCODE);
		Assert.assertEquals("123456", postalCode.getText());
		postalCode.setText("234567");
		Assert.assertEquals("234567", dairyLocation.getLocation().getPostalLocation().getPostalCode());

		final ITextRidget province = getController().getRidget(ITextRidget.class,
				DairyLocationUIConstants.RIDGET_ID_PL_PROVINCE);
		Assert.assertEquals("TP", province.getText());
		province.setText("newTP");
		Assert.assertEquals("newTP", dairyLocation.getLocation().getPostalLocation().getProvince());
	}

	public void testDirectionsTab() {
		final ITextRidget landmark = getController().getRidget(ITextRidget.class,
				DairyLocationUIConstants.RIDGET_ID_DL_LANDMARK);
		Assert.assertEquals("test landmarks", landmark.getText());
		landmark.setText("newlandmark");
		Assert.assertEquals("newlandmark", dairyLocation.getLocation().getDescriptiveLocation().getLandmarks());

		final ITextRidget directions = getController().getRidget(ITextRidget.class,
				DairyLocationUIConstants.RIDGET_ID_DL_DIRECTIONS);
		Assert.assertEquals("test directions", directions.getText());
		directions.setText("newdirections");
		Assert.assertEquals("newdirections", dairyLocation.getLocation().getDescriptiveLocation().getDirections());
	}

	public void testMapTab() {
		final ITextRidget latitude = getController().getRidget(ITextRidget.class,
				DairyLocationUIConstants.RIDGET_ID_ML_LATITUDE);
		Assert.assertEquals("123.00", latitude.getText());
		latitude.setText("222.00");
		Assert.assertEquals("222.00", dairyLocation.getLocation().getMapLocation().getLatitude());

		final ITextRidget longitude = getController().getRidget(ITextRidget.class,
				DairyLocationUIConstants.RIDGET_ID_ML_LONGITUDE);
		Assert.assertEquals("-100.00", longitude.getText());
		longitude.setText("-99.00");
		Assert.assertEquals("-99.00", dairyLocation.getLocation().getMapLocation().getLongitude());
	}
}
