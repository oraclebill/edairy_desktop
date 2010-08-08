package com.agritrace.edairy.desktop.dairy.locations.ui.controllers;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;

import com.agritrace.edairy.desktop.common.model.dairy.DairyFunction;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.MapGroupController;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.dairy.locations.ui.DairyLocationUIConstants;

public class DairyDialogController extends RecordDialogController<DairyLocation> {
	private DairyLocation editLocation = null;
	private IDateTimeRidget dateOpened;
	private IMultipleChoiceRidget functions;
	private IComboRidget routeCombo;

	@Override
	public void configureUserRidgets() {

		// ensure model available
		editLocation = getWorkingCopy();
		assert (null != editLocation);


		addTextMap(DairyLocationUIConstants.RIDGET_ID_NAME, DairyPackage.Literals.DAIRY_LOCATION__NAME);
		addTextMap(DairyLocationUIConstants.RIDGET_ID_PHONE, DairyPackage.Literals.DAIRY_LOCATION__PHONE);
		addTextMap(DairyLocationUIConstants.RIDGET_ID_DESCRIPTION, DairyPackage.Literals.DAIRY_LOCATION__DESCRIPTION);
		
		//functions
		functions = getRidget(IMultipleChoiceRidget.class,DairyLocationUIConstants.RIDGET_ID_FUNCTIONS);
		final IObservableList optionValues = new WritableList(Arrays.asList(DairyFunction.values()),
				DairyFunction.class);
		final IObservableList selectionValues = new WritableList(editLocation.getFunctions(), DairyFunction.class);
		functions.bindToModel(optionValues, selectionValues);
		functions.updateFromModel();
		
		addTextMap(DairyLocationUIConstants.RIDGET_ID_DATEOPENED,DairyPackage.Literals.DAIRY_LOCATION__DATE_OPENED);
		addComboMap(DairyLocationUIConstants.RIDGET_ID_ROUTE, getRoutes(), "getName", DairyPackage.Literals.DAIRY_LOCATION__ROUTE);

		// Configure address group
		final AddressGroupWidgetController addressGroupController = new AddressGroupWidgetController(this);
		addressGroupController.setInputModel(editLocation.getLocation().getPostalLocation());
		addressGroupController.updateBinding();

		// Configure Direction Group
		final DirectionGroupController directionController = new DirectionGroupController(this);
		directionController.setInputModel(editLocation.getLocation().getDescriptiveLocation());
		directionController.updateBinding();

		// Configure Map Group
		final MapGroupController mapController = new MapGroupController(this);
		mapController.setInputModel(editLocation.getLocation().getMapLocation());
		mapController.updateBinding();
	}

	@Override
	public DairyLocation getWorkingCopy() {
		return (DairyLocation) getContext("editObject");
	}

	@Override
	public void afterBind() {
		super.afterBind();
	}
	
	@SuppressWarnings("unchecked")
	public List<Route> getRoutes(){
		return (List<Route>)getContext("routes");
	}
}
