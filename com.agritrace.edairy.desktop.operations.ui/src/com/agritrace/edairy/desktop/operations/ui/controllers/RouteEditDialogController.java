package com.agritrace.edairy.desktop.operations.ui.controllers;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.IListRidget;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.operations.ui.ViewConstants;

public class RouteEditDialogController extends RecordDialogController<Route> {

	public RouteEditDialogController() {

		// setEClass(DairyPackage.Literals.ROUTE);

		addRidgetFeatureMap(ViewConstants.ID_TXT_ROUTE_CODE, DairyPackage.Literals.ROUTE__CODE);
		addRidgetFeatureMap(ViewConstants.ID_TXT_ROUTE_NAME, DairyPackage.Literals.ROUTE__NAME);
		addRidgetFeatureMap(ViewConstants.ID_TXT_ROUTE_DESCRIPTION, DairyPackage.Literals.ROUTE__DESCRIPTION);
		// TODO:
		// addRidgetFeatureMap(ViewConstants.ID_LST_ROUTE_STOPS,
		// DairyPackage.Literals.ROUTE__STOPS,
		// DairyPackage.Literals.DAIRY_LOCATION__NAME);

	}

	@Override
	protected void configureUserRidgets() {
		final IListRidget stopsList = getRidget(IListRidget.class, ViewConstants.ID_LST_ROUTE_STOPS);
		stopsList.setOutputOnly(true);
		stopsList.bindToModel(EMFObservables.observeList(this.getWorkingCopy(), DairyPackage.Literals.ROUTE__STOPS),
				DairyLocation.class, "name");
		System.err.println("STOPS: " + this.getWorkingCopy().getStops());
		stopsList.updateFromModel();
	}

}
