package com.agritrace.edairy.riena.ui.controllers;

import java.util.ArrayList;
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
import org.eclipse.riena.ui.ridgets.IMessageBoxRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.model.DescriptiveLocation;
import com.agritrace.edairy.model.MapLocation;
import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.DairyLocation;
import com.agritrace.edairy.model.dairy.Route;

public class DairyLocationsController extends SubModuleController {
	//top-half window
	public static final String RIDGET_ID_DAIRY_LOCATION_ID = "dairyLocationId";
	public static final String RIDGET_ID_NAME = "name";
	public static final String RIDGET_ID_FUNCTIONS = "functions";
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
	public static final String RIDGET_ID_DL_LANDMARK = "descriptiveLocation.landmark";
	public static final String RIDGET_ID_DL_DIRECTIONS = "descriptiveLocation.directions";
	
	//map tab
	public static final String RIDGET_ID_ML_LATITUDE = "mapLocation.latitude";
	public static final String RIDGET_ID_ML_LONGITUDE = "mapLocation.longitude";
	
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
	public DairyLocationsController(ISubModuleNode navigationNode) {
		super(navigationNode);
		initialize();
	}

	
	@InjectService(service = DairyLocations.class)
	public void bind(DairyLocations service) {
		this.service = service;
	}

	public void unbind(IDairyLocations service) {
		if (this.service == service)
			this.service = null;
	}

	
	@Override
	public void configureRidgets() {
		super.configureRidgets();

		DairyLocation dairyLocation = this.dairyLocation;

		//bindings for top-half window
		final ITextRidget dairyLocationId = getRidget(ITextRidget.class, RIDGET_ID_DAIRY_LOCATION_ID);
		dairyLocationId.setOutputOnly(true);
		dairyLocationId.bindToModel(dairyLocation, "dairyLocationId");
		dairyLocationId.updateFromModel();

		textName = getRidget(ITextRidget.class, RIDGET_ID_NAME);
		textName.bindToModel(dairyLocation, "name");
		textName.updateFromModel();
		

	/*	final IMultipleChoiceRidget functions = (IMultipleChoiceRidget) getRidget(RIDGET_ID_FUNCTIONS);
		functions.bindToModel(Arrays.asList(DairyFunction.MILK_COLLECTION, DairyFunction.MILK_STORAGE, DairyFunction.MILK_PROCESSING, DairyFunction.WAREHOUSE, DairyFunction.OFFICES), 
				  			Arrays.asList("Collection", "Store", "Processing", "Warehouse", "Offices"), 
				  			dairyLocation,
							"function");						
		functions.updateFromModel();
		functions.setSelection(dairyLocation.getFunction()); //$NON-NLS-1$
*/		
		final IComboRidget route = (IComboRidget) getRidget(RIDGET_ID_ROUTE);
		RouteService rs = new RouteService();
		rs.getRoutes().add(this.dairyLocation.getRoute());
		route.bindToModel(rs, "routes", Route.class, "getName", this.dairyLocation, "route");
		route.updateFromModel();
		
		final IActionRidget addRouteAction = (IActionRidget) getRidget(IActionRidget.class, RIDGET_ID_ADD_ROUTE_ACTION);
		addRouteAction.addListener(new AddRouteCallback());
		addRouteAction.setText("AddRoute");
		
		
		//bindings for address tab 
		configureAddressTab(dairyLocation);
		configureDirectionsTab(dairyLocation);
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
		textAddress.bindToModel(dairyLocation.getLocation().getPostalLocation(), "address");
		textAddress.updateFromModel();
			
		ITextRidget section = getRidget(ITextRidget.class, RIDGET_ID_PL_SECTION);
		section.bindToModel(dairyLocation.getLocation().getPostalLocation(), "section");
		section.updateFromModel();
		
		ITextRidget town = getRidget(ITextRidget.class, RIDGET_ID_PL_TOWN);
		town.bindToModel(dairyLocation.getLocation().getPostalLocation(), "village");
		town.updateFromModel();
		
		//#TODO uncommented below lines if we need this property
		//ITextRidget estate = getRidget(ITextRidget.class, RIDGET_ID_PL_ESTATE);
		//town.bindToModel(dairyLocation.getPostalComponent(), "estate");
		//town.updateFromModel();
		
		ITextRidget location = getRidget(ITextRidget.class, RIDGET_ID_PL_LOCATION);
		location.bindToModel(dairyLocation.getLocation().getPostalLocation(), "location");
		location.updateFromModel();
		
		ITextRidget sub = getRidget(ITextRidget.class, RIDGET_ID_PL_SUB);
		sub.bindToModel(dairyLocation.getLocation().getPostalLocation(), "subLocation");
		sub.updateFromModel();
		
		ITextRidget district = getRidget(ITextRidget.class, RIDGET_ID_PL_DISTRICT);
		district.bindToModel(dairyLocation.getLocation().getPostalLocation(), "district");
		district.updateFromModel();
		
		ITextRidget division = getRidget(ITextRidget.class, RIDGET_ID_PL_DIVISION);
		division.bindToModel(dairyLocation.getLocation().getPostalLocation(), "division");
		division.updateFromModel();
		
		ITextRidget postalCode = getRidget(ITextRidget.class, RIDGET_ID_PL_POSTALCODE);
		postalCode.bindToModel(dairyLocation.getLocation().getPostalLocation(), "postalCode");
		postalCode.updateFromModel();
		
		/*ITextRidget province = getRidget(ITextRidget.class, RIDGET_ID_PL_PROVINCE);
		province.bindToModel(dairyLocation.getPostalComponent(), "province");
		province.updateFromModel();*/
	}
	
	private void configureDirectionsTab(DairyLocation dairyLocation)
	{
		/*ITextRidget landmark = getRidget(ITextRidget.class, RIDGET_ID_DL_LANDMARK);
		landmark.bindToModel(dairyLocation.getDescriptiveComponent(), "landmarks");
		landmark.updateFromModel();
		
		ITextRidget directions = getRidget(ITextRidget.class, RIDGET_ID_DL_DIRECTIONS);
		directions.bindToModel(dairyLocation.getDescriptiveComponent(), "directions");
		directions.updateFromModel();*/
	}
	
	private void configureMapTab(DairyLocation dairyLocation)
	{
		/*ITextRidget landmark = getRidget(ITextRidget.class, RIDGET_ID_DL_LANDMARK);
		landmark.bindToModel(dairyLocation.getDescriptiveComponent(), "landmarks");
		landmark.updateFromModel();
		
		ITextRidget directions = getRidget(ITextRidget.class, RIDGET_ID_DL_DIRECTIONS);
		directions.bindToModel(dairyLocation.getDescriptiveComponent(), "directions");
		directions.updateFromModel();*/
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
		return service.query(id);
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
		long dairyLocationId = 1;
		for (int i = 0 ; i < 1; i ++) {
			DairyLocation dairyLocation = DairyFactory.eINSTANCE.createDairyLocation();
			/*dairyLocation.setDairyLocationId(dairyLocationId);
			dairyLocation.setName("testDairylocationName" + dairyLocationId);
			EList<DairyFunction> functions =  dairyLocation.getFunction();
			functions.add(DairyFunction.MILK_COLLECTION);
			functions.add(DairyFunction.MILK_PROCESSING);
			functions.add(DairyFunction.MILK_STORAGE);
			functions.add(DairyFunction.OFFICES);
			functions.add(DairyFunction.WAREHOUSE);*/
			Route route = DairyFactory.eINSTANCE.createRoute();
			//route.setId("route" + dairyLocationId);
			route.setName("testroute" + dairyLocationId);
			route.setDescription("testroutedesc" + dairyLocationId);
			//route.setColorCode("#66778" + dairyLocationId);
			
			dairyLocation.setRoute(route);
			PostalLocation postalLocation = ModelFactory.eINSTANCE.createPostalLocation();
			postalLocation.setAddress("test address " + dairyLocationId);
			postalLocation.setSection("test section " + dairyLocationId);
			postalLocation.setVillage("test village " + dairyLocationId);
			postalLocation.setLocation("test location " + dairyLocationId);
			postalLocation.setSubLocation("test sublocation " + dairyLocationId);
			postalLocation.setDistrict("test district " + dairyLocationId);
			postalLocation.setDivision("test division " + dairyLocationId);
			postalLocation.setPostalCode("123456 " + dairyLocationId);
			postalLocation.setProvince("TP " + dairyLocationId);
			//dairyLocation.setPostalComponent(postalLocation);
			
			DescriptiveLocation descriptiveLocation = ModelFactory.eINSTANCE.createDescriptiveLocation();
			descriptiveLocation.setLandmarks("test landmard " + dairyLocationId);
			descriptiveLocation.setDirections("test directions \r\n new line \r\n new line " + dairyLocationId);
			//dairyLocation.setDescriptiveComponent(descriptiveLocation);
			
			MapLocation mapLocation = ModelFactory.eINSTANCE.createMapLocation();
			mapLocation.setLatitude("");
			mapLocation.setLongitude("");
			this.dairyLocation = dairyLocation;
		}
	}

	
}
