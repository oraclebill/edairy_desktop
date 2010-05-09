package com.agritrace.edairy.dairy.ui.controllers;

import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMessageBoxRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.dairy.ui.controllers.DairyLocationController.RouteService;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.Route;
<<<<<<< HEAD
import com.agritrace.edairy.model.impl.ModelFactoryImpl;
=======
>>>>>>> master

public class AddRouteDialogController extends AbstractWindowController {
	public static final String RIDGET_ID_ROUTE_ID = "routeId"; //$NON-NLS-1$
	public static final String RIDGET_ID_NAME = "name"; //$NON-NLS-1$
	public static final String RIDGET_ID_DESCRIPTION = "description"; //$NON-NLS-1$
	public static final String RIDGET_ID_CODE = "code"; //$NON-NLS-1$
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
		
/*		final ITextRidget routeId = getRidget(ITextRidget.class, RIDGET_ID_ROUTE_ID);
		routeId.setOutputOnly(true);
		routeId.bindToModel(route, "routeId");
		routeId.updateFromModel();*/
		
		textName = getRidget(ITextRidget.class, RIDGET_ID_NAME);
		textName.bindToModel(route, "name");
		textName.updateFromModel();
		
		final ITextRidget routeDescription = getRidget(ITextRidget.class, RIDGET_ID_DESCRIPTION);
		routeDescription.bindToModel(route, "description");
		routeDescription.updateFromModel();
		
		final ITextRidget routeCode = getRidget(ITextRidget.class, RIDGET_ID_CODE);
		routeCode.bindToModel(route, "code");
		routeCode.updateFromModel();
		
		duplicateNameDialog = (IMessageBoxRidget) getRidget(RIDGET_ID_DUPLICATE_NAME_DIALOG);
		duplicateNameDialog.setType(IMessageBoxRidget.Type.ERROR);
		duplicateNameDialog.setTitle("Duplicate Name"); 
		duplicateNameDialog.setText("The name '" + textName.getText() + "' is already in use.\r\n\rPlease select a unique name for this new location.");
		
		IActionRidget saveAction = (IActionRidget) getRidget(RIDGET_ID_SAVE);
		saveAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				if (textName.getText().equals(route.getName())) {
					duplicateNameDialog.show();
				}
					
			}
		});
		
		IActionRidget cencelAction = (IActionRidget) getRidget(RIDGET_ID_CANCEL);
		cencelAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				
				getWindowRidget().dispose();
			}
		});
	}
	
	private void initialize()
	{
		service = new RouteService();
		for (int i = 0 ; i < 5; i ++) {
			Route r = DairyFactory.eINSTANCE.createRoute();
			r.setName("route name " + i);
			r.setDescription("route description" + i);
			r.setDescription("route desc " + i);
			r.setCode("#12345" + i);
			service.getRoutes().add(r);
		}
		
	}

}
