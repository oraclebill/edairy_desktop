package com.agritrace.edairy.riena.ui.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.riena.core.wire.InjectService;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTextRidget;
import org.eclipse.riena.ui.ridgets.IMessageBoxRidget;
import org.eclipse.riena.ui.ridgets.ISingleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.common.datamodel.common.Location;
import com.agritrace.edairy.common.datamodel.dairy.DairyLocation;
import com.agritrace.edairy.common.datamodel.dairy.DairyLocation.DairyFunction;
import com.agritrace.edairy.common.datamodel.dairy.Route;
import com.agritrace.edairy.common.services.DairyLocations;

public class DairyLocationController extends SubModuleController {
	//top-half window
	public static final String RIDGET_ID_COLLECTION_CENTRE_ID = "collectionCentreId";
	public static final String RIDGET_ID_NAME = "name";
	public static final String RIDGET_ID_DESCRIPTION = "description";
	public static final String RIDGET_ID_DATEOPENED = "dateOpened";
	public static final String RIDGET_ID_PHONE = "phone";
	public static final String RIDGET_ID_CODE = "code";
	public static final String RIDGET_ID_FUNCTION = "function";
	public static final String RIDGET_ID_ROUTE = "route";
	
	//address tab
	public static final String RIDGET_ID_PL_ADDRESS = "postalLocation.address";
	public static final String RIDGET_ID_PL_SECTION = "postalLocation.section";
	public static final String RIDGET_ID_PL_ESTATE = "postalLocation.estate";
	public static final String RIDGET_ID_PL_TOWN = "postalLocation.town";
	public static final String RIDGET_ID_PL_LOCATION = "postalLocation.location";
	public static final String RIDGET_ID_PL_SUB = "postalLocation.subLocation";
	public static final String RIDGET_ID_PL_DISTRICT = "postalLocation.district";
	public static final String RIDGET_ID_PL_DIVISION = "postalLocation.division";
	public static final String RIDGET_ID_PL_POSTALCODE = "postalLocation.postalCode";
	public static final String RIDGET_ID_PL_PROVINCE = "postalLocation.province";
	
	//directions tab
	public static final String RIDGET_ID_DL_LANDMARK = "locationLandmarks";
	public static final String RIDGET_ID_DL_DIRECTIONS = "locationDirections";
	
	//map tab
	public static final String RIDGET_ID_ML_LATITUDE = "latitude";
	public static final String RIDGET_ID_ML_LONGITUDE = "longitude";
	
	//actions
	public static final String RIDGET_ID_ADD_ROUTE_ACTION = "addRouteAction";
	public static final String RIDGET_ID_SAVE_ACTION = "saveAction";
	public static final String RIDGET_ID_CANCEL_ACTION = "cancelAction";
	public static final String RIDGET_ID_DELETE_ACTION = "deleteAction";
	
	//messageboxes
	public static final String RIDGET_ID_DUPLICATE_NAME_DIALOG = "duplicateNameDialog";
	public static final String RIDGET_ID_ADDRESS_REQUIRED_DIALOG = "addressRequiredDialog";
	public static final String RIDGET_ID_DELETE_CONFIRM_DIALOG = "deleteConfirmDialog";
	private DairyLocations service;
	private DairyLocation dairyLocation;
	private ITextRidget textName;
	private ITextRidget textAddress;
	private IMessageBoxRidget duplicateNameDialog;
	private IMessageBoxRidget addressRequiredDialog;
	private IMessageBoxRidget deleteConfirmDialog;
	public DairyLocationController(ISubModuleNode navigationNode) {
		super(navigationNode);
		initialize();
	}

	
	@InjectService(service = DairyLocations.class)
	public void bind(DairyLocations service) {
		this.service = service;
	}

	public void unbind(DairyLocations service) {
		if (this.service == service)
			this.service = null;
	}

	
	@Override
	public void configureRidgets() {
		super.configureRidgets();

		DairyLocation dairyLocation = this.dairyLocation;

		//bindings for top-half window
		final ITextRidget dairyLocationId = getRidget(ITextRidget.class, RIDGET_ID_COLLECTION_CENTRE_ID);
		dairyLocationId.setOutputOnly(true);
		dairyLocationId.bindToModel(dairyLocation, "collectionCentreId");
		dairyLocationId.updateFromModel();

		textName = getRidget(ITextRidget.class, RIDGET_ID_NAME);
		textName.bindToModel(dairyLocation, "name");
		textName.updateFromModel();
		
		final ITextRidget description = getRidget(ITextRidget.class, RIDGET_ID_DESCRIPTION);
		description.bindToModel(dairyLocation, "description");
		description.updateFromModel();
		
		final IDateTextRidget dateOpened = getRidget(IDateTextRidget.class, RIDGET_ID_DATEOPENED);
		dateOpened.setFormat("dd/MM/yyyy");
		dateOpened.bindToModel(dairyLocation, "dateOpened");
		dateOpened.updateFromModel();

		final ISingleChoiceRidget  function = (ISingleChoiceRidget) getRidget(RIDGET_ID_FUNCTION);
		function.bindToModel(Arrays.asList(DairyFunction.MILK_COLLECTION, DairyFunction.MILK_STORAGE, DairyFunction.MILK_PROCESSING, DairyFunction.WAREHOUSE, DairyFunction.OFFICES, DairyFunction.STORE_SALES), 
				  			Arrays.asList("Collection", "Storage", "Processing", "Warehouse", "Offices", "Sales"), 
				  			dairyLocation,
							"function");
	
		function.updateFromModel();
		function.setSelection(dairyLocation.getFunction()); //$NON-NLS-1$
		
		final IComboRidget route = (IComboRidget) getRidget(RIDGET_ID_ROUTE);
		RouteService rs = new RouteService();
		rs.getRoutes().add(this.dairyLocation.getRoute());
		route.bindToModel(rs, "routes", Route.class, "getName", this.dairyLocation, "route");
		route.updateFromModel();
		
		final IActionRidget addRouteAction = (IActionRidget) getRidget(IActionRidget.class, RIDGET_ID_ADD_ROUTE_ACTION);
		addRouteAction.addListener(new AddRouteCallback());
		
		
		configureAddressTab(dairyLocation);
		configureDirectionsTab(dairyLocation);
		configureMapTab(dairyLocation);
		configureMessageBoxes();
		
		IActionRidget saveAction = getRidget(IActionRidget.class, RIDGET_ID_SAVE_ACTION);
		saveAction.addListener(new SaveCallback());
		saveAction.setText("Save");
		
		IActionRidget cancelAction = getRidget(IActionRidget.class, RIDGET_ID_CANCEL_ACTION);
		cancelAction.addListener(new CancelCallback());
		cancelAction.setText("Cancel");

		IActionRidget deleteAction = getRidget(IActionRidget.class, RIDGET_ID_DELETE_ACTION);
		deleteAction.addListener(new DeleteCallback());
		deleteAction.setText("Delete");
		
		
	}
	
	private void configureAddressTab(DairyLocation dairyLocation)
	{
		textAddress = getRidget(ITextRidget.class, RIDGET_ID_PL_ADDRESS);
		textAddress.bindToModel(dairyLocation.getLocation(), "address");
		textAddress.updateFromModel();
			
		ITextRidget section = getRidget(ITextRidget.class, RIDGET_ID_PL_SECTION);
		section.bindToModel(dairyLocation.getLocation(), "section");
		section.updateFromModel();
		
		ITextRidget town = getRidget(ITextRidget.class, RIDGET_ID_PL_TOWN);
		town.bindToModel(dairyLocation.getLocation(), "village");
		town.updateFromModel();
		
		
		ITextRidget estate = getRidget(ITextRidget.class, RIDGET_ID_PL_ESTATE);
		estate.bindToModel(dairyLocation.getLocation(), "estate");
		estate.updateFromModel();
		
		ITextRidget location = getRidget(ITextRidget.class, RIDGET_ID_PL_LOCATION);
		location.bindToModel(dairyLocation.getLocation(), "location");
		location.updateFromModel();
		
		ITextRidget sub = getRidget(ITextRidget.class, RIDGET_ID_PL_SUB);
		sub.bindToModel(dairyLocation.getLocation(), "subLocation");
		sub.updateFromModel();
		
		ITextRidget district = getRidget(ITextRidget.class, RIDGET_ID_PL_DISTRICT);
		district.bindToModel(dairyLocation.getLocation(), "district");
		district.updateFromModel();
		
		ITextRidget division = getRidget(ITextRidget.class, RIDGET_ID_PL_DIVISION);
		division.bindToModel(dairyLocation.getLocation(), "division");
		division.updateFromModel();
		
		ITextRidget postalCode = getRidget(ITextRidget.class, RIDGET_ID_PL_POSTALCODE);
		postalCode.bindToModel(dairyLocation.getLocation(), "postalCode");
		postalCode.updateFromModel();
		
	}
	
	private void configureDirectionsTab(DairyLocation dairyLocation)
	{
		ITextRidget landmark = getRidget(ITextRidget.class, RIDGET_ID_DL_LANDMARK);
		landmark.bindToModel(dairyLocation.getLocation(), "landmarkLocations");
		landmark.updateFromModel();
		
		ITextRidget directions = getRidget(ITextRidget.class, RIDGET_ID_DL_DIRECTIONS);
		directions.bindToModel(dairyLocation.getLocation(), "locationDirections");
		directions.updateFromModel();
	}
	
	private void configureMapTab(DairyLocation dairyLocation)
	{
		ITextRidget latitude = getRidget(ITextRidget.class, RIDGET_ID_ML_LATITUDE);
		latitude.bindToModel(dairyLocation.getLocation(), "latitude");
		latitude.updateFromModel();
		
		ITextRidget longitude = getRidget(ITextRidget.class, RIDGET_ID_ML_LONGITUDE);
		longitude.bindToModel(dairyLocation.getLocation(), "longitude");
		longitude.updateFromModel();
	}
	
	private void configureMessageBoxes()
	{
		duplicateNameDialog = (IMessageBoxRidget) getRidget(RIDGET_ID_DUPLICATE_NAME_DIALOG);
		duplicateNameDialog.setType(IMessageBoxRidget.Type.ERROR);
		duplicateNameDialog.setTitle("Duplicate Name"); 
		duplicateNameDialog.setText("The name '" + textName.getText() + "' is already in use.\r\n\rPlease select a unique name for this new location.");
		
		addressRequiredDialog = (IMessageBoxRidget) getRidget(RIDGET_ID_ADDRESS_REQUIRED_DIALOG);
		addressRequiredDialog.setType(IMessageBoxRidget.Type.ERROR);
		addressRequiredDialog.setTitle("Address Required"); 
		addressRequiredDialog.setText("You must specify an address for this location - either in the \"Address\" tab or the \"Directions\" tab.");
		
		deleteConfirmDialog = (IMessageBoxRidget) getRidget(RIDGET_ID_DELETE_CONFIRM_DIALOG);
		deleteConfirmDialog.setType(IMessageBoxRidget.Type.QUESTION);
		deleteConfirmDialog.setTitle("Confirm"); 
		deleteConfirmDialog.setText("Do you want to delete this item?");
		IMessageBoxRidget.MessageBoxOption[] customOptions = new IMessageBoxRidget.MessageBoxOption[] {
				new IMessageBoxRidget.MessageBoxOption("Yes"), new IMessageBoxRidget.MessageBoxOption("No") };
		deleteConfirmDialog.setOptions(customOptions);
	}
	
	private List<Route> getAllRoutes()
	{
		List<Route> ret = new ArrayList<Route>();
		
		return ret;
	}
	
	public final class RouteService
	{
		private ArrayList<Route> routes = new ArrayList<Route>() ;

		public ArrayList<Route> getRoutes() {
			return routes;
		}

		public void setRoutes(ArrayList<Route> routes) {
			this.routes = routes;
		}
		
	}

	private DairyLocation query(long id) {
		return null;
	}

	private  class SaveCallback implements IActionListener {
		IValidator uniqueNameValidator = new IValidator()
		{
			public IStatus validate(Object value) {
				//#TODO invoke the real service to query locationby name
				if ("testDairylocationName1".equals(textName.getText()))
				{
						return Status.CANCEL_STATUS;
				}
				return Status.OK_STATUS;
			}
			
		};
		
		IValidator addressValidator = new IValidator()
		{
			public IStatus validate(Object value) {
				if ("".equals(textAddress.getText()))
				{
						return Status.CANCEL_STATUS;
				}
				return Status.OK_STATUS;
			}
			
		};
		public void callback() {
			textName.addValidationRule(uniqueNameValidator, ValidationTime.ON_UPDATE_TO_MODEL);
			if (!textName.revalidate())
			{
				duplicateNameDialog.show();
				textName.requestFocus();
			}
			textName.removeValidationRule(uniqueNameValidator);
			textAddress.addValidationRule(addressValidator, ValidationTime.ON_UPDATE_TO_MODEL);
			if (!textAddress.revalidate())
			{
				addressRequiredDialog.show();
				textAddress.requestFocus();
			}
			textAddress.removeValidationRule(addressValidator);
		}
	}
	
	
	
	private  class CancelCallback implements IActionListener {
		public void callback() {
			
		}
	}

	private class DeleteCallback implements IActionListener {

		public void callback() {
			if (deleteConfirmDialog.show().getLabel().equals("Yes"))
			{
				//#TODO delete the item
				
			}
		}
	}
	
	private class AddRouteCallback implements IActionListener {

		public void callback() {
			
		}
	}
	
	private void initialize() {
		long id = 1;
		for (int i = 0 ; i < 1; i ++) {
			DairyLocation dairyLocation = new DairyLocation();
			dairyLocation.setCollectionCentreId(id);
			dairyLocation.setName("testDairylocationName" + id);
			dairyLocation.setDescription("test dairy location description " + id);
			dairyLocation.setDateOpened(new Date());
			dairyLocation.setPhoneNumber("555-111-222");
			dairyLocation.setFunction(DairyFunction.OFFICES);
			dairyLocation.setColorCode("#66778" + id);
			Route route = new Route();
			route.setRouteId(id);
			route.setName("testroute" + id);
			route.setDescription("testroutedesc" + id);

			dairyLocation.setRoute(route);
			Location location = new Location();
			location.setAddress("test address " + id);
			location.setSection("test section " + id);
			location.setVillage("test village " + id);
			location.setLocation("test location " + id);
			location.setSubLocation("test sublocation " + id);
			location.setDistrict("test district " + id);
			location.setDivision("test division " + id);
			location.setPostalCode("123456 " + id);
			location.setEstate("test estate" + id);
			location.setLandmarkLocations("test landmark" + id);
			location.setLocationDirections("test directions " + id);
			location.setLatitude(123.0);
			location.setLongitude(-123);
			dairyLocation.setLocation(location);
		
			this.dairyLocation = dairyLocation;
		}
	}

	
}
