package com.agritrace.edairy.desktop.dairy.locations.ui.controllers;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTextRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;

import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.MapLocation;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFunction;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.common.ui.managers.IDairyResourceManager;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.dairy.locations.ui.dialogs.RouteListDialog;

public class DairyLocationController extends SubModuleController {
    public final static String NODE_ID = "com.agritrace.edairy.dairy.ui.views.DairyLocationView";
    // top-half window
    public static final String RIDGET_ID_COLLECTION_CENTRE_ID = "collectionCentreId";
    public static final String RIDGET_ID_NAME = "name";
    public static final String RIDGET_ID_DESCRIPTION = "description";
    public static final String RIDGET_ID_DATEOPENED = "dateOpened";
    public static final String RIDGET_ID_PHONE = "phone";
    public static final String RIDGET_ID_CODE = "code";
    public static final String RIDGET_ID_FUNCTIONS = "functions";
    public static final String RIDGET_ID_ROUTE = "route";

    // address tab
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

    // directions tab
    public static final String RIDGET_ID_DL_LANDMARK = "locationLandmarks";
    public static final String RIDGET_ID_DL_DIRECTIONS = "locationDirections";

    // map tab
    public static final String RIDGET_ID_ML_LATITUDE = "latitude";
    public static final String RIDGET_ID_ML_LONGITUDE = "longitude";

    // actions
    public static final String RIDGET_ID_CONFIGURE_ROUTE_ACTION = "configureRouteAction";
    public static final String RIDGET_ID_SAVE_ACTION = "saveAction";
    public static final String RIDGET_ID_CANCEL_ACTION = "cancelAction";
    public static final String RIDGET_ID_DELETE_ACTION = "deleteAction";

    private IDairyResourceManager resourceManager = null;
    private Dairy myDairy = null;

    
    public DairyLocationController() {
	initResources();
    }
    
    
    public DairyLocationController(ISubModuleNode navigationNode) {
	super(navigationNode);
	initResources();
    }
    
    private void initResources() {
	resourceManager = DairyDemoResourceManager.INSTANCE;
	try {	
	    	myDairy = resourceManager.getLocalDairy();
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}	
    }

//    public void setResourceManager(IDairyResourceManager manager) {
//	resourceManager = manager;
//	if (null != manager) {
//	    myDairy = manager.getLocalDairy();	    
//	}
//	else {
//	    myDairy = null;
//	}
//    }
//
//    public IDairyResourceManager getResourceManager() {
//	return resourceManager;
//    }

    public void store() {
	assert(null != resourceManager);
	resourceManager.store(myDairy);
	
    }
    
    @Override
    public void configureRidgets() {
	super.configureRidgets();

	final String[] properties = new String[] { "name", "description" };
	final String[] headers = new String[] { "Name", "Description" };

	final IMasterDetailsRidget master = (IMasterDetailsRidget) getRidget("master");
	if (master != null) {
	    master.setDelegate(new DairyLocationDelegate());
	    master.bindToModel(new WritableList(myDairy.getBranchLocations(), DairyLocation.class), DairyLocation.class, properties, headers);
	    master.updateFromModel();

	    final IActionRidget actionApply = master.getRidget(IActionRidget.class,
		    AbstractMasterDetailsComposite.BIND_ID_APPLY);

	    addDefaultAction(master, actionApply);

	    actionApply.addListener(new IActionListener() {

		@Override
		public void callback() {
		    store();
		}

	    });

	}
    }

    private final class DairyLocationDelegate extends AbstractMasterDetailsDelegate {
	private DairyLocation workingCopy = createWorkingCopy();
	private Route workingRoute;
	private ITextRidget textName;
	private ITextRidget textAddress;
	private IComboRidget routeCombo;
	private ITableRidget table;
	private IRidgetContainer detailsContainer;

	@Override
	public void configureRidgets(IRidgetContainer container) {
	    detailsContainer = container;
	    bindRidgets(container);
	    configureValidators(container);
	    configureActionListeners(container);
	}

	private void bindRidgets(IRidgetContainer container) {
	    table = container.getRidget(ITableRidget.class, AbstractMasterDetailsComposite.BIND_ID_TABLE);

	    final ITextRidget textId = container.getRidget(ITextRidget.class, RIDGET_ID_COLLECTION_CENTRE_ID);
	    textId.bindToModel(workingCopy, "id");
	    textId.setOutputOnly(true);
	    textId.updateFromModel();

	    textName = container.getRidget(ITextRidget.class, RIDGET_ID_NAME);
	    textName.bindToModel(workingCopy, "name");
	    textName.updateFromModel();

	    final ITextRidget description = container.getRidget(ITextRidget.class, RIDGET_ID_DESCRIPTION);
	    description.bindToModel(workingCopy, "description");
	    description.updateFromModel();
	    description.setMandatory(true);

	    final ITextRidget phone = container.getRidget(ITextRidget.class, RIDGET_ID_PHONE);
	    phone.bindToModel(workingCopy, "phone");
	    phone.updateFromModel();

	    final IDateTextRidget dateOpened = container.getRidget(IDateTextRidget.class, RIDGET_ID_DATEOPENED);
	    dateOpened.setFormat(DATE_FORMATE);
	    dateOpened.bindToModel(workingCopy, "dateOpened");
	    dateOpened.updateFromModel();

	    final IMultipleChoiceRidget functions = container.getRidget(IMultipleChoiceRidget.class,
		    RIDGET_ID_FUNCTIONS);
	    final IObservableList optionValues = new WritableList(Arrays.asList(DairyFunction.values()),
		    DairyFunction.class);
	    final IObservableList selectionValues = new WritableList(workingCopy.getFunctions(), DairyFunction.class);
	    functions.bindToModel(optionValues, selectionValues);
	    functions.updateFromModel();

	    routeCombo = container.getRidget(IComboRidget.class, RIDGET_ID_ROUTE);
	    bindRouteCombo();

	    configureAddressTab(container, workingCopy);
	    configureDirectionsTab(container, workingCopy);
	    configureMapTab(container, workingCopy);
	}

	private void configureValidators(IRidgetContainer container) {
	    final DairyLocationNameValidator nameValidator = new DairyLocationNameValidator();
	    if (textName.getValidationRules().size() <= 0) {
		textName.addValidationRule(nameValidator, ValidationTime.ON_UPDATE_TO_MODEL);
	    }
	    final AddressValidator addressValidator = new AddressValidator();
	    if (textAddress.getValidationRules().size() <= 0) {
		textAddress.addValidationRule(addressValidator, ValidationTime.ON_UPDATE_TO_MODEL);
		textAddress.addValidationMessage("required", addressValidator);
	    }
	}

	private void configureActionListeners(IRidgetContainer container) {
	    routeCombo.addSelectionListener(new RouteSelectCallback());

	    final IActionRidget configureRouteAction = container.getRidget(IActionRidget.class,
		    RIDGET_ID_CONFIGURE_ROUTE_ACTION);
	    configureRouteAction.addListener(new ConfigureRouteCallback());
	}

	private void bindRouteCombo() {
	    if (null != myDairy) {
//		routeCombo.bindToModel(myDairy.getRoutes(), "name", Route.class, "name", workingRoute, "name");
//		routeCombo.bindToModel(new WritableList(myDairy.getRoutes()), Route, Route.class, "name", new IO
		routeCombo.updateFromModel();
	    }

	}

	@Override
	public void itemApplied(Object changedItem) {
	    if (changedItem instanceof DairyLocation) {
		final DairyLocation changedDairyLocation = (DairyLocation) changedItem;
		if (changedDairyLocation.getId() == 0) {
		    // perform create action to SQL
		    resourceManager.store(changedDairyLocation);
		} else {
		    // perform update action to SQL

		}
	    }
	    super.itemApplied(changedItem);
	}

	@Override
	public void itemRemoved(Object oldItem) {
//	    DairyLocationService.getInstance().store(); 
	    throw new UnsupportedOperationException(); // TODO: persist deletions.
	}

	@Override
	public boolean isChanged(Object source, Object target) {
	    if (source != null && target != null) {

		final DairyLocation src = (DairyLocation) source;
		final DairyLocation dst = (DairyLocation) target;
		if (src.getId() == 0) {
		    // always return true for id=0 since it's a new created
		    // object;
		    return true;
		}
		if (EMFUtil.compare(src, dst)
			&& EMFUtil.compare(src.getRoute(), dst.getRoute())
			&& EMFUtil
				.compare(src.getLocation().getPostalLocation(), dst.getLocation().getPostalLocation())
			&& EMFUtil.compare(src.getLocation().getDescriptiveLocation(), dst.getLocation()
				.getDescriptiveLocation())
			&& EMFUtil.compare(src.getLocation().getMapLocation(), dst.getLocation().getMapLocation())) {
		    return false;
		}
	    }

	    return true;
	}

	@Override
	public DairyLocation createWorkingCopy() {
	    final DairyLocation dairyLocation = DairyFactory.eINSTANCE.createDairyLocation();
	    workingCopy = dairyLocation;

	    final Route route = DairyFactory.eINSTANCE.createRoute();
	    workingRoute = route;
	    dairyLocation.setRoute(route);
	    dairyLocation.getRoute().setName("");
	    dairyLocation.getFunctions();

	    final Location location = ModelFactory.eINSTANCE.createLocation();

	    final PostalLocation postalLocation = ModelFactory.eINSTANCE.createPostalLocation();

	    final DescriptiveLocation descriptiveLocation = ModelFactory.eINSTANCE.createDescriptiveLocation();

	    final MapLocation mapLocation = ModelFactory.eINSTANCE.createMapLocation();

	    location.setPostalLocation(postalLocation);
	    location.setDescriptiveLocation(descriptiveLocation);
	    location.setMapLocation(mapLocation);
	    dairyLocation.setLocation(location);
	    return workingCopy;
	}

	@Override
	public void itemCreated(Object newItem) {
	    bindRidgets(detailsContainer);
	    super.itemCreated(newItem);
	}

	@Override
	public Object copyBean(Object source, Object target) {
	    if (source.equals(target)) {
		return source;
	    }
	    final DairyLocation from = source != null ? (DairyLocation) source : createWorkingCopy();
	    final DairyLocation to = target != null ? (DairyLocation) target : createWorkingCopy();
	    to.setId(from.getId());
	    to.setName(from.getName());
	    to.setDateOpened(from.getDateOpened());
	    to.setDescription(from.getDescription());
	    to.setPhone(from.getPhone());
	    to.setCode(from.getCode());
	    if (from.getRoute() == null) {
		to.setRoute(null);
	    } else {
		if (to.getRoute() == null) {
		    to.setRoute(DairyFactory.eINSTANCE.createRoute());
		}
		to.getRoute().setId(from.getRoute().getId());
		to.getRoute().setName(from.getRoute().getName());
		to.getRoute().setDescription(from.getRoute().getDescription());
		to.getRoute().setCode(from.getRoute().getCode());
		// ECoreUtil.co
	    }
	    // to.setLocation(from.getLocation());
	    to.getFunctions().clear();
	    to.getFunctions().addAll(from.getFunctions());
	    to.getLocation().getPostalLocation().setAddress(from.getLocation().getPostalLocation().getAddress());
	    to.getLocation().getPostalLocation().setEstate(from.getLocation().getPostalLocation().getEstate());
	    to.getLocation().getPostalLocation().setVillage(from.getLocation().getPostalLocation().getVillage());
	    to.getLocation().getPostalLocation().setPostalCode(from.getLocation().getPostalLocation().getPostalCode());
	    to.getLocation().getPostalLocation().setProvince(from.getLocation().getPostalLocation().getProvince());
	    to.getLocation().getPostalLocation().setSection(from.getLocation().getPostalLocation().getSection());
	    to.getLocation().getPostalLocation().setDivision(from.getLocation().getPostalLocation().getDivision());
	    to.getLocation().getPostalLocation().setLocation(from.getLocation().getPostalLocation().getLocation());
	    to.getLocation().getPostalLocation()
		    .setSubLocation(from.getLocation().getPostalLocation().getSubLocation());
	    to.getLocation().getPostalLocation().setDistrict(from.getLocation().getPostalLocation().getDistrict());
	    to.getLocation().getDescriptiveLocation()
		    .setDirections(from.getLocation().getDescriptiveLocation().getDirections());
	    to.getLocation().getDescriptiveLocation()
		    .setLandmarks(from.getLocation().getDescriptiveLocation().getLandmarks());
	    to.getLocation().getMapLocation().setLatitude(from.getLocation().getMapLocation().getLatitude());
	    to.getLocation().getMapLocation().setLongitude(from.getLocation().getMapLocation().getLongitude());
	    return target;
	}

	@Override
	public String isRemovable(Object item) {
	    // TODO Auto-generated method stub
	    return super.isRemovable(item);
	}

	@Override
	public String isValid(IRidgetContainer container) {
	    if (!textName.revalidate()) {
		if ("".equals(textName.getText())) {
		    return "The name can't be empty!";
		}
		textName.requestFocus();
		return "The name '" + textName.getText()
			+ "' is already in use.\r\n\rPlease select a unique name for this new location.";
	    } else if (!textAddress.revalidate()) {
		textAddress.requestFocus();
		return "You must specify an address for this location.";
	    }
	    return super.isValid(container);
	}

	@Override
	public void prepareItemSelected(Object newSelection) {
	    // TODO Auto-generated method stub
	    super.prepareItemSelected(newSelection);
	}

	@Override
	public void itemSelected(Object newSelection) {
	    // TODO Auto-generated method stub
	    super.itemSelected(newSelection);
	}

	@Override
	public DairyLocation getWorkingCopy() {
	    // TODO Auto-generated method stub
	    return workingCopy;
	}

	private void configureAddressTab(IRidgetContainer container, DairyLocation dairyLocation) {
	    textAddress = container.getRidget(ITextRidget.class, RIDGET_ID_PL_ADDRESS);
	    textAddress.setMandatory(true);
	    textAddress.bindToModel(dairyLocation.getLocation().getPostalLocation(), "address");
	    textAddress.updateFromModel();

	    final ITextRidget section = container.getRidget(ITextRidget.class, RIDGET_ID_PL_SECTION);
	    section.bindToModel(dairyLocation.getLocation().getPostalLocation(), "section");
	    section.updateFromModel();

	    final ITextRidget town = container.getRidget(ITextRidget.class, RIDGET_ID_PL_TOWN);
	    town.bindToModel(dairyLocation.getLocation().getPostalLocation(), "village");
	    town.updateFromModel();

	    final ITextRidget estate = container.getRidget(ITextRidget.class, RIDGET_ID_PL_ESTATE);
	    estate.bindToModel(dairyLocation.getLocation().getPostalLocation(), "estate");
	    estate.updateFromModel();

	    final ITextRidget location = container.getRidget(ITextRidget.class, RIDGET_ID_PL_LOCATION);
	    location.bindToModel(dairyLocation.getLocation().getPostalLocation(), "location");
	    location.updateFromModel();

	    final ITextRidget sub = container.getRidget(ITextRidget.class, RIDGET_ID_PL_SUB);
	    sub.bindToModel(dairyLocation.getLocation().getPostalLocation(), "subLocation");
	    sub.updateFromModel();

	    final ITextRidget district = container.getRidget(ITextRidget.class, RIDGET_ID_PL_DISTRICT);
	    district.bindToModel(dairyLocation.getLocation().getPostalLocation(), "district");
	    district.updateFromModel();

	    final ITextRidget division = container.getRidget(ITextRidget.class, RIDGET_ID_PL_DIVISION);
	    division.bindToModel(dairyLocation.getLocation().getPostalLocation(), "division");
	    division.updateFromModel();

	    final ITextRidget postalCode = container.getRidget(ITextRidget.class, RIDGET_ID_PL_POSTALCODE);
	    postalCode.bindToModel(dairyLocation.getLocation().getPostalLocation(), "postalCode");
	    postalCode.updateFromModel();

	    final ITextRidget province = container.getRidget(ITextRidget.class, RIDGET_ID_PL_PROVINCE);
	    province.bindToModel(dairyLocation.getLocation().getPostalLocation(), "province");
	    province.updateFromModel();

	}

	private void configureDirectionsTab(IRidgetContainer container, DairyLocation dairyLocation) {
	    final ITextRidget landmark = container.getRidget(ITextRidget.class, RIDGET_ID_DL_LANDMARK);
	    landmark.bindToModel(dairyLocation.getLocation().getDescriptiveLocation(), "landmarks");
	    landmark.updateFromModel();

	    final ITextRidget directions = container.getRidget(ITextRidget.class, RIDGET_ID_DL_DIRECTIONS);
	    directions.bindToModel(dairyLocation.getLocation().getDescriptiveLocation(), "directions");
	    directions.updateFromModel();
	}

	private void configureMapTab(IRidgetContainer container, DairyLocation dairyLocation) {
	    final ITextRidget latitude = container.getRidget(ITextRidget.class, RIDGET_ID_ML_LATITUDE);
	    latitude.bindToModel(dairyLocation.getLocation().getMapLocation(), "latitude");
	    latitude.updateFromModel();

	    final ITextRidget longitude = container.getRidget(ITextRidget.class, RIDGET_ID_ML_LONGITUDE);
	    longitude.bindToModel(dairyLocation.getLocation().getMapLocation(), "longitude");
	    longitude.updateFromModel();
	}

	private class RouteSelectCallback implements ISelectionListener {

	    @Override
	    public void ridgetSelected(SelectionEvent event) {
		if (event.getNewSelection().size() > 0) {
		    final String selectedName = (String) event.getNewSelection().get(0);
		    Route selectedRoute = null;
		    for (Route test : myDairy.getRoutes()) {
			String testName = test.getName();
			if ( null != testName && testName.equals(selectedName) ) {
			    selectedRoute = test;
			    break;
			}
		    }		    
		    final IComboRidget select = (IComboRidget) event.getSource();
		    if (selectedRoute == null) { 			// selection is invalid since the route
				     			// might be removed by someone else.
			select.setErrorMarked(true);
		    } else {
			select.setErrorMarked(false);
		    }
		    workingRoute.setId(selectedRoute.getId());
		    workingRoute.setDescription(selectedRoute.getDescription());
		    workingRoute.setCode(selectedRoute.getCode());
		}
	    }

	}

	private class ConfigureRouteCallback implements IActionListener {

	    @Override
	    public void callback() {

		final RouteListDialog dialog = new RouteListDialog();
		dialog.setBlockOnOpen(true);
		dialog.open();
		bindRouteCombo();
	    }
	}

	private class DairyLocationNameValidator implements IValidator {
	    @Override
	    public IStatus validate(Object value) {
		if ("".equals(textName.getText())) {
		    return Status.CANCEL_STATUS;
		}

		List<DairyLocation> input = myDairy.getBranchLocations();
		for (int i = 0; i < input.size(); i++) {
		    if (textName.getText().equals(input.get(i).getName()) && i != table.getSelectionIndex()) {

			return Status.CANCEL_STATUS;
		    }
		}
		return Status.OK_STATUS;
	    }
	}

	private class AddressValidator implements IValidator {
	    @Override
	    public IStatus validate(Object value) {
		if ("".equals(textAddress.getText())) {
		    return Status.CANCEL_STATUS;
		}

		return Status.OK_STATUS;
	    }
	}
    }

}
