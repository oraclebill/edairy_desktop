package com.agritrace.edairy.desktop.operations.ui.controllers;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;

public class RouteEditDialogController extends RecordDialogController<Route> {

	
	

	public RouteEditDialogController() {
		
		setEClass(DairyPackage.Literals.ROUTE);		
		
		addRidgetFeatureMap("route-id", 	DairyPackage.Literals.ROUTE__ID );
		addRidgetFeatureMap("route-code", DairyPackage.Literals.ROUTE__CODE );
		addRidgetFeatureMap("route-name", DairyPackage.Literals.ROUTE__NAME);
		addRidgetFeatureMap("route-description", DairyPackage.Literals.ROUTE__DESCRIPTION);
		addRidgetFeatureMap("route-stops-list", DairyPackage.Literals.ROUTE__STOPS );
		
	}
	
}
