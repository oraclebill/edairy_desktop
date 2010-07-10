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

	}

	@Override
	protected void configureUserRidgets() {
		
		addRidgetFeatureMap(ViewConstants.ID_TXT_ROUTE_CODE, DairyPackage.Literals.ROUTE__CODE);
		addRidgetFeatureMap(ViewConstants.ID_TXT_ROUTE_NAME, DairyPackage.Literals.ROUTE__NAME);
		addRidgetFeatureMap(ViewConstants.ID_TXT_ROUTE_DESCRIPTION, DairyPackage.Literals.ROUTE__DESCRIPTION);

		final IListRidget stopsList = getRidget(IListRidget.class, ViewConstants.ID_LST_ROUTE_STOPS);
		stopsList.bindToModel(EMFObservables.observeList(this.getWorkingCopy(), DairyPackage.Literals.ROUTE__STOPS),
				DairyLocation.class, "name");
		stopsList.updateFromModel();
		stopsList.setOutputOnly(true);
		stopsList.setFocusable(false);
		stopsList.setEnabled(false);
	}	
}
