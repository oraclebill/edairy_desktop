package com.agritrace.edairy.desktop.dairy.locations.ui.controllers;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.operations.services.dairylocation.DairyLocationRepository;

;

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

	final DairyLocationRepository locationRepository = new DairyLocationRepository();

	final IObservableList locations = new WritableList();
	final IObservableList routes = new WritableList();

	public DairyLocationController() {
	}

	public DairyLocationController(ISubModuleNode navigationNode) {
		super(navigationNode);
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		final String[] properties = new String[] { "name", "description" };
		final String[] headers = new String[] { "Name", "Description" };

		locations.clear();
		locations.addAll(locationRepository.all());

		final IMasterDetailsRidget master = (IMasterDetailsRidget) getRidget("master");
		if (master != null) {
			master.setDelegate(new DairyLocationDelegate(this));
			master.bindToModel(locations, DairyLocation.class, properties,
					headers);
			master.updateFromModel();

			final IActionRidget actionApply = master.getRidget(
					IActionRidget.class,
					AbstractMasterDetailsComposite.BIND_ID_APPLY);

			addDefaultAction(master, actionApply);
		}
	}

	@Override
	public void afterBind() {
		super.afterBind();
	}

}
