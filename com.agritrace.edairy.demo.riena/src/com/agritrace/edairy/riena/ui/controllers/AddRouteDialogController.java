package com.agritrace.edairy.riena.ui.controllers;

import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMessageBoxRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.common.datamodel.dairy.Route;
import com.agritrace.edairy.riena.ui.controllers.DairyLocationController.RouteService;

public class AddRouteDialogController extends AbstractWindowController {
	public static final String RIDGET_ID_ROUTE_ID = "routeId"; //$NON-NLS-1$
	public static final String RIDGET_ID_NAME = "name"; //$NON-NLS-1$
	public static final String RIDGET_ID_DESCRIPTION = "description"; //$NON-NLS-1$
	public static final String RIDGET_ID_SAVE = "saveButton"; //$NON-NLS-1$
	public static final String RIDGET_ID_CANCEL = "cancelButton"; //$NON-NLS-1$
	
	public static final String RIDGET_ID_DUPLICATE_NAME_DIALOG = "duplicateNameDialog"; //$NON-NLS-1$

	private RouteService service ;
	
	private ITextRidget textName;
	private IMessageBoxRidget duplicateNameDialog;
	
	public AddRouteDialogController() {
		super();
		initialize();
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle("Add Route");

		final Route route = service.getRoutes().get(0);
		
		final ITextRidget routeId = getRidget(ITextRidget.class, RIDGET_ID_ROUTE_ID);
		routeId.setOutputOnly(true);
		routeId.bindToModel(route, "routeId");
		routeId.updateFromModel();
		
		textName = getRidget(ITextRidget.class, RIDGET_ID_NAME);
		textName.bindToModel(route, "name");
		textName.updateFromModel();
		
		final ITextRidget routeDescription = getRidget(ITextRidget.class, RIDGET_ID_DESCRIPTION);
		routeDescription.bindToModel(route, "description");
		routeDescription.updateFromModel();
		
		duplicateNameDialog = (IMessageBoxRidget) getRidget(RIDGET_ID_DUPLICATE_NAME_DIALOG);
		duplicateNameDialog.setType(IMessageBoxRidget.Type.ERROR);
		duplicateNameDialog.setTitle("Duplicate Name"); 
		duplicateNameDialog.setText("The name '" + textName.getText() + "' is already in use.\r\n\rPlease select a unique name for this new location.");
		
		IActionRidget saveAction = (IActionRidget) getRidget(RIDGET_ID_SAVE);
		saveAction.addListener(new IActionListener() {
			public void callback() {
				if (textName.getText().equals(route.getName())) {
					duplicateNameDialog.show();
				}
					
			}
		});
		
		IActionRidget cencelAction = (IActionRidget) getRidget(RIDGET_ID_CANCEL);
		cencelAction.addListener(new IActionListener() {
			public void callback() {
				
				getWindowRidget().dispose();
			}
		});
	}
	
	private void initialize()
	{
		service = new RouteService();
		for (int i = 0 ; i < 5; i ++) {
			Route r = new Route();
			r.setName("route name " + i);
			r.setDescription("route description" + i);
			r.setRouteId((long)i);
			r.setDescription("route desc " + i);
			service.getRoutes().add(r);
		}
		
	}

}
