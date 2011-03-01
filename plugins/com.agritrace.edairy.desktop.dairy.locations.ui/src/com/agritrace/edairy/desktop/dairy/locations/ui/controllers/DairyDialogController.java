package com.agritrace.edairy.desktop.dairy.locations.ui.controllers;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ICompositeRidget;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.dairy.DairyFunction;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.TransportRoute;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.MapGroupController;
import com.agritrace.edairy.desktop.common.ui.validators.PhoneNumberValidatiionRule;
import com.agritrace.edairy.desktop.dairy.locations.ui.DairyLocationUIConstants;

public class DairyDialogController extends RecordDialogController<DairyLocation> {
	
	private DairyLocation editLocation = null;
	//private IDateTimeRidget dateOpened;
	private IMultipleChoiceRidget functions;
	//private IComboRidget routeCombo;
	private ITextRidget phone;
	private ICompositeRidget detailArea;
	private ITextRidget txtCode;
	private IComboRidget comboRoute;

	public DairyDialogController() {
		super("Dairy Branch Location");
	}
	
	@Override
	public void configureUserRidgets() {

		// ensure model available
		editLocation = getWorkingCopy();
		assert null != editLocation;

		detailArea = getRidget(ICompositeRidget.class, DairyLocationUIConstants.RIDGET_ID_ROUTE_DETAIL_AREA);
		txtCode = getRidget(ITextRidget.class, DairyLocationUIConstants.RIDGET_ID_CODE);
		txtCode.setMandatory(true);

		comboRoute = getRidget(IComboRidget.class, DairyLocationUIConstants.RIDGET_ID_ROUTE);

		phone = getRidget(ITextRidget.class,DairyLocationUIConstants.RIDGET_ID_PHONE);
		phone.addValidationRule(new PhoneNumberValidatiionRule(), ValidationTime.ON_UI_CONTROL_EDIT);
		phone.setDirectWriting(true);
		addTextMap(DairyLocationUIConstants.RIDGET_ID_NAME, DairyPackage.Literals.DAIRY_LOCATION__NAME);
		addTextMap(DairyLocationUIConstants.RIDGET_ID_PHONE, DairyPackage.Literals.DAIRY_LOCATION__PHONE);
		addTextMap(DairyLocationUIConstants.RIDGET_ID_DESCRIPTION, DairyPackage.Literals.DAIRY_LOCATION__DESCRIPTION);
		addTextMap(DairyLocationUIConstants.RIDGET_ID_CODE, DairyPackage.Literals.DAIRY_LOCATION__CODE);

		//functions
		functions = getRidget(IMultipleChoiceRidget.class,DairyLocationUIConstants.RIDGET_ID_FUNCTIONS);
		final IObservableList optionValues = new WritableList(Arrays.asList(DairyFunction.values()),
				DairyFunction.class);
		final IObservableList selectionValues = new WritableList(editLocation.getFunctions(), DairyFunction.class);
		functions.bindToModel(optionValues, selectionValues);

		functions.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				resetDetailArea();
			}
		});
		functions.updateFromModel();

		addTextMap(DairyLocationUIConstants.RIDGET_ID_DATEOPENED, DairyPackage.Literals.DAIRY_LOCATION__DATE_OPENED);
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
	public void afterBind() {
		super.afterBind();
		resetDetailArea();
	}

	@SuppressWarnings("unchecked")
	public List<TransportRoute> getRoutes(){
		return (List<TransportRoute>)getContext("routes");
	}

	private void resetDetailArea() {
		final boolean isCollectionCenter = editLocation.getFunctions().contains(DairyFunction.MILK_COLLECTION);
		detailArea.setEnabled(isCollectionCenter);
		if (!isCollectionCenter) {
			comboRoute.setSelection(null);
		}
		detailArea.setVisible(isCollectionCenter);
	}

}
