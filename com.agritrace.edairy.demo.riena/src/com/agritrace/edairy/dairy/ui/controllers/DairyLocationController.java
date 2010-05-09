package com.agritrace.edairy.dairy.ui.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.riena.core.wire.InjectService;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTextRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IMessageBoxRidget;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;

import com.agritrace.edairy.dairy.ui.dialogs.RouteListDialog;
import com.agritrace.edairy.model.DescriptiveLocation;
import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.MapLocation;
import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.DairyFunction;
import com.agritrace.edairy.model.dairy.DairyLocation;
import com.agritrace.edairy.model.dairy.Route;
import com.agritrace.edairy.model.impl.ModelFactoryImpl;
import com.agritrace.edairy.ui.views.data.Staff;

public class DairyLocationController extends SubModuleController {
	public final static String NODE_ID = "com.agritrace.edairy.dairy.ui.views.DairyLocationView";
	//top-half window
	public static final String RIDGET_ID_COLLECTION_CENTRE_ID = "collectionCentreId";
	public static final String RIDGET_ID_NAME = "name";
	public static final String RIDGET_ID_DESCRIPTION = "description";
	public static final String RIDGET_ID_DATEOPENED = "dateOpened";
	public static final String RIDGET_ID_PHONE = "phone";
	public static final String RIDGET_ID_CODE = "code";
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
	public static final String DATE_FORMATE = "dd/MM/yyyy";
	
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
	private ArrayList<DairyLocation> input = new ArrayList<DairyLocation>();
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

		//DairyLocation dairyLocation = this.dairyLocation;

		String[] properties = new String[] {"name","description" };
		String[] headers = new String[] { "Name","Description"};

		final IMasterDetailsRidget master = (IMasterDetailsRidget) getRidget("master"); //$NON-NLS-1$
		if (master != null) {
			master.setDelegate(new DairyLocationDelegation());
			master.bindToModel(new WritableList(input, DairyLocation.class),
					DairyLocation.class, properties, headers);
			master.updateFromModel();

			IActionRidget actionApply = master.getRidget(IActionRidget.class,
					AbstractMasterDetailsComposite.BIND_ID_APPLY);
			addDefaultAction(master, actionApply);
		}
		//bindings for top-half window
		/*final ITextRidget dairyLocationId = getRidget(ITextRidget.class, RIDGET_ID_COLLECTION_CENTRE_ID);
		dairyLocationId.setOutputOnly(true);
		dairyLocationId.bindToModel(dairyLocation, "collectionCentreId");
		dairyLocationId.updateFromModel();*/

		
		
		
	}
	
	

	private DairyLocation query(long id) {
		return null;
	}

	
	public ArrayList<DairyLocation> getInput()
	{
		return input;
	}
	
	public void setInput(ArrayList<DairyLocation> input)
	{
		this.input = input;
	}
	
	private static final class DairyLocationDelegation extends	AbstractMasterDetailsDelegate {
		private DairyLocation workingCopy = createWorkingCopy();
		private DairyLocation dairyLocation;
		private ITextRidget textName;
		private ITextRidget textAddress;
		private IMessageBoxRidget duplicateNameDialog;
		private IMessageBoxRidget addressRequiredDialog;
		private IMessageBoxRidget deleteConfirmDialog;

		@Override
		public void configureRidgets(IRidgetContainer container) {
			textName =  container.getRidget(ITextRidget.class, RIDGET_ID_NAME);
			textName.bindToModel(workingCopy, "name");
			textName.updateFromModel();
			
			final ITextRidget description = container.getRidget(ITextRidget.class, RIDGET_ID_DESCRIPTION);
			description.bindToModel(workingCopy, "description");
			description.updateFromModel();
			
			final ITextRidget phone = container.getRidget(ITextRidget.class, RIDGET_ID_PHONE);
			phone.bindToModel(workingCopy, "phone");
			phone.updateFromModel();
			
			final IDateTextRidget dateOpened = container.getRidget(IDateTextRidget.class, RIDGET_ID_DATEOPENED);
			dateOpened.setFormat(DATE_FORMATE);
			dateOpened.bindToModel(workingCopy, "dateOpened");
			dateOpened.updateFromModel();
			
			final IMultipleChoiceRidget functions = container.getRidget(IMultipleChoiceRidget.class, RIDGET_ID_FUNCTIONS);
	        IObservableList optionValues = new WritableList( Arrays.asList(DairyFunction.values()), DairyFunction.class ) ;
	        IObservableList selectionValues = new WritableList( workingCopy.getFunctions(), DairyFunction.class );
	        functions.bindToModel( optionValues, selectionValues );                      
	        functions.updateFromModel();
	        
	        
			final IComboRidget route = container.getRidget(IComboRidget.class, RIDGET_ID_ROUTE);
			RouteService rs = new RouteService();
			rs.getRoutes().add(this.workingCopy.getRoute());
			route.bindToModel(rs, "routes", Route.class, "getName", this.workingCopy, "route");
			route.updateFromModel();

			
			final IActionRidget addRouteAction = container.getRidget(IActionRidget.class, RIDGET_ID_ADD_ROUTE_ACTION);
			addRouteAction.addListener(new AddRouteCallback());
			
			
			configureAddressTab(container, workingCopy);
			configureDirectionsTab(container, workingCopy);
			configureMapTab(container, workingCopy);
			//configureMessageBoxes(container);
			
			IActionRidget saveAction = container.getRidget(IActionRidget.class, RIDGET_ID_SAVE_ACTION);
			saveAction.addListener(new SaveCallback());
			saveAction.setText("Save");
			
			IActionRidget cancelAction = container.getRidget(IActionRidget.class, RIDGET_ID_CANCEL_ACTION);
			cancelAction.addListener(new CancelCallback());
			cancelAction.setText("Cancel");

			IActionRidget deleteAction = container.getRidget(IActionRidget.class, RIDGET_ID_DELETE_ACTION);
			deleteAction.addListener(new DeleteCallback());
			deleteAction.setText("Delete");
			
		}

		@Override
		public DairyLocation createWorkingCopy() {
			DairyLocation dairyLocation = DairyFactory.eINSTANCE.createDairyLocation();
			
			
			Route route = DairyFactory.eINSTANCE.createRoute();
			route.setName("testroute1");
			dairyLocation.setRoute(route);
			Location location = ModelFactoryImpl.eINSTANCE.createLocation();

			PostalLocation postalLocation = ModelFactory.eINSTANCE.createPostalLocation();
			
			DescriptiveLocation descriptiveLocation = ModelFactory.eINSTANCE.createDescriptiveLocation();
			
			MapLocation mapLocation = ModelFactory.eINSTANCE.createMapLocation();
			
			location.setPostalLocation(postalLocation);
			location.setDescriptiveLocation(descriptiveLocation);
			location.setMapLocation(mapLocation);
			dairyLocation.setLocation(location);
			return dairyLocation;
		}

		@Override
		public Object copyBean(Object source, Object target) {
			
			DairyLocation from = source != null ? (DairyLocation) source : createWorkingCopy();
			DairyLocation to = target != null ? (DairyLocation) target : createWorkingCopy();
			
			to.setName(from.getName());
			to.setDateOpened(from.getDateOpened());
			to.setDescription(from.getDescription());
			to.setPhone(from.getPhone());
			to.getRoute().setName(from.getRoute().getName());
			to.getRoute().setDescription(from.getRoute().getDescription());
			to.getRoute().setCode(from.getRoute().getCode());
			//to.setLocation(from.getLocation());
			to.setRoute(from.getRoute());
			to.getFunctions().addAll(from.getFunctions());
			to.getLocation().getPostalLocation().setAddress(from.getLocation().getPostalLocation().getAddress());
			to.getLocation().getPostalLocation().setEstate(from.getLocation().getPostalLocation().getEstate());
			to.getLocation().getPostalLocation().setVillage(from.getLocation().getPostalLocation().getVillage());
			to.getLocation().getPostalLocation().setPostalCode(from.getLocation().getPostalLocation().getPostalCode());
			to.getLocation().getPostalLocation().setProvince(from.getLocation().getPostalLocation().getProvince());
			to.getLocation().getPostalLocation().setSection(from.getLocation().getPostalLocation().getSection());
			to.getLocation().getPostalLocation().setDivision(from.getLocation().getPostalLocation().getDivision());
			to.getLocation().getPostalLocation().setLocation(from.getLocation().getPostalLocation().getLocation());
			to.getLocation().getPostalLocation().setSubLocation(from.getLocation().getPostalLocation().getSubLocation());
			to.getLocation().getPostalLocation().setDistrict(from.getLocation().getPostalLocation().getDistrict());
			to.getLocation().getDescriptiveLocation().setDirections(from.getLocation().getDescriptiveLocation().getDirections());
			to.getLocation().getDescriptiveLocation().setLandmarks(from.getLocation().getDescriptiveLocation().getLandmarks());
			to.getLocation().getMapLocation().setLatitude(from.getLocation().getMapLocation().getLatitude());
			to.getLocation().getMapLocation().setLongitude(from.getLocation().getMapLocation().getLongitude());
			return source;
		}

		@Override
		public DairyLocation getWorkingCopy() {
			// TODO Auto-generated method stub
			return workingCopy;
		}
		
		private void configureAddressTab(IRidgetContainer container, DairyLocation dairyLocation)
		{
			textAddress = container.getRidget(ITextRidget.class, RIDGET_ID_PL_ADDRESS);
			textAddress.bindToModel(dairyLocation.getLocation().getPostalLocation(), "address");
			textAddress.updateFromModel();
				
			ITextRidget section = container.getRidget(ITextRidget.class, RIDGET_ID_PL_SECTION);
			section.bindToModel(dairyLocation.getLocation().getPostalLocation(), "section");
			section.updateFromModel();
			
			ITextRidget town = container.getRidget(ITextRidget.class, RIDGET_ID_PL_TOWN);
			town.bindToModel(dairyLocation.getLocation().getPostalLocation(), "village");
			town.updateFromModel();
			
			
			ITextRidget estate = container.getRidget(ITextRidget.class, RIDGET_ID_PL_ESTATE);
			estate.bindToModel(dairyLocation.getLocation().getPostalLocation(), "estate");
			estate.updateFromModel();
			
			ITextRidget location = container.getRidget(ITextRidget.class, RIDGET_ID_PL_LOCATION);
			location.bindToModel(dairyLocation.getLocation().getPostalLocation(), "location");
			location.updateFromModel();
			
			ITextRidget sub = container.getRidget(ITextRidget.class, RIDGET_ID_PL_SUB);
			sub.bindToModel(dairyLocation.getLocation().getPostalLocation(), "subLocation");
			sub.updateFromModel();
			
			ITextRidget district = container.getRidget(ITextRidget.class, RIDGET_ID_PL_DISTRICT);
			district.bindToModel(dairyLocation.getLocation().getPostalLocation(), "district");
			district.updateFromModel();
			
			ITextRidget division = container.getRidget(ITextRidget.class, RIDGET_ID_PL_DIVISION);
			division.bindToModel(dairyLocation.getLocation().getPostalLocation(), "division");
			division.updateFromModel();
			
			ITextRidget postalCode = container.getRidget(ITextRidget.class, RIDGET_ID_PL_POSTALCODE);
			postalCode.bindToModel(dairyLocation.getLocation().getPostalLocation(), "postalCode");
			postalCode.updateFromModel();
			
			ITextRidget province = container.getRidget(ITextRidget.class, RIDGET_ID_PL_PROVINCE);
			province.bindToModel(dairyLocation.getLocation().getPostalLocation(), "province");
			province.updateFromModel();
			
		}
		
		private void configureDirectionsTab(IRidgetContainer container, DairyLocation dairyLocation)
		{
			ITextRidget landmark = container.getRidget(ITextRidget.class, RIDGET_ID_DL_LANDMARK);
			landmark.bindToModel(dairyLocation.getLocation().getDescriptiveLocation(), "landmarks");
			landmark.updateFromModel();
			
			ITextRidget directions = container.getRidget(ITextRidget.class, RIDGET_ID_DL_DIRECTIONS);
			directions.bindToModel(dairyLocation.getLocation().getDescriptiveLocation(), "directions");
			directions.updateFromModel();
		}
		
		private void configureMapTab(IRidgetContainer container, DairyLocation dairyLocation)
		{
			ITextRidget latitude = container.getRidget(ITextRidget.class, RIDGET_ID_ML_LATITUDE);
			latitude.bindToModel(dairyLocation.getLocation().getMapLocation(), "latitude");
			latitude.updateFromModel();
			
			ITextRidget longitude = container.getRidget(ITextRidget.class, RIDGET_ID_ML_LONGITUDE);
			longitude.bindToModel(dairyLocation.getLocation().getMapLocation(), "longitude");
			longitude.updateFromModel();
		}
		
		private void configureMessageBoxes(IRidgetContainer container)
		{
			duplicateNameDialog = container.getRidget(IMessageBoxRidget.class, RIDGET_ID_DUPLICATE_NAME_DIALOG);
			duplicateNameDialog.setType(IMessageBoxRidget.Type.ERROR);
			duplicateNameDialog.setTitle("Duplicate Name"); 
			duplicateNameDialog.setText("The name '" + textName.getText() + "' is already in use.\r\n\rPlease select a unique name for this new location.");
			
			addressRequiredDialog = container.getRidget(IMessageBoxRidget.class, RIDGET_ID_ADDRESS_REQUIRED_DIALOG);
			addressRequiredDialog.setType(IMessageBoxRidget.Type.ERROR);
			addressRequiredDialog.setTitle("Address Required"); 
			addressRequiredDialog.setText("You must specify an address for this location - either in the \"Address\" tab or the \"Directions\" tab.");
			
			deleteConfirmDialog = container.getRidget(IMessageBoxRidget.class, RIDGET_ID_DELETE_CONFIRM_DIALOG);
			deleteConfirmDialog.setType(IMessageBoxRidget.Type.QUESTION);
			deleteConfirmDialog.setTitle("Confirm"); 
			deleteConfirmDialog.setText("Do you want to delete this item?");
			IMessageBoxRidget.MessageBoxOption[] customOptions = new IMessageBoxRidget.MessageBoxOption[] {
					new IMessageBoxRidget.MessageBoxOption("Yes"), new IMessageBoxRidget.MessageBoxOption("No") };
			deleteConfirmDialog.setOptions(customOptions);
		}
		private  class SaveCallback implements IActionListener {
			IValidator uniqueNameValidator = new IValidator()
			{
				@Override
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
				@Override
				public IStatus validate(Object value) {
					if ("".equals(textAddress.getText()))
					{
							return Status.CANCEL_STATUS;
					}
					return Status.OK_STATUS;
				}
				
			};
			@Override
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
			@Override
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
					
					RouteListDialog dialog = new RouteListDialog();
					dialog.setBlockOnOpen(true);
					dialog.open();

			}
		}
		
		private List<Route> getAllRoutes()
		{
			List<Route> ret = new ArrayList<Route>();
			
			return ret;
		}
		
		
	
	}
	
	private void initialize() {
		long id = 1;
		for (int i = 0 ; i < 5; i ++) {
			DairyLocation dairyLocation = DairyFactory.eINSTANCE.createDairyLocation();
			dairyLocation.setName("testDairylocationName" + id);
			dairyLocation.setDescription("test dairy location description " + id);
			dairyLocation.setDateOpened(new Date());
			dairyLocation.setPhone("555-111-222");
			dairyLocation.getFunctions().addAll(Arrays.asList(DairyFunction.MILK_COLLECTION, DairyFunction.MILK_STORAGE, DairyFunction.MILK_PROCESSING, DairyFunction.WAREHOUSE, DairyFunction.STORE_SALES));
			dairyLocation.setCode("#66778" + id);
			
			Route route = DairyFactory.eINSTANCE.createRoute();
			route.setName("testroute" + id);
			route.setDescription("testroutedesc" + id);
			route.setCode("#66778" + id);
			
			dairyLocation.setRoute(route);
			Location location = ModelFactoryImpl.eINSTANCE.createLocation();

			PostalLocation postalLocation = ModelFactory.eINSTANCE.createPostalLocation();
			postalLocation.setAddress("test address " + id);
			postalLocation.setSection("test section " + id);
			postalLocation.setEstate("test estate " + id);
			postalLocation.setVillage("test village " + id);
			postalLocation.setLocation("test location " + id);
			postalLocation.setSubLocation("test sublocation " + id);
			postalLocation.setDistrict("test district " + id);
			postalLocation.setDivision("test division " + id);
			postalLocation.setPostalCode("123456 " + id);
			postalLocation.setProvince("TP " + id);
			
			DescriptiveLocation descriptiveLocation = ModelFactory.eINSTANCE.createDescriptiveLocation();
			descriptiveLocation.setLandmarks("test landmarks " + id);
			descriptiveLocation.setDirections("test directions " + id);
			
			MapLocation mapLocation = ModelFactory.eINSTANCE.createMapLocation();
			mapLocation.setLatitude("123.00");
			mapLocation.setLongitude("-100.00");
			
			location.setPostalLocation(postalLocation);
			location.setDescriptiveLocation(descriptiveLocation);
			location.setMapLocation(mapLocation);
			dairyLocation.setLocation(location);
		
			input.add(dairyLocation);
			id ++;
		}
	}

	public static final class RouteService
	{
		private ArrayList<Route> routes = new ArrayList<Route>() ;

		public ArrayList<Route> getRoutes() {
			return routes;
		}

		public void setRoutes(ArrayList<Route> routes) {
			this.routes = routes;
		}
		
	}
}
