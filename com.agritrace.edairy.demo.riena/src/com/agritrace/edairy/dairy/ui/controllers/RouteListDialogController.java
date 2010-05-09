package com.agritrace.edairy.dairy.ui.controllers;

import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMessageBoxRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.dairy.ui.controllers.DairyLocationController.RouteService;
import com.agritrace.edairy.dairy.ui.dialogs.AddRouteDialog;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.Route;

public class RouteListDialogController extends AbstractWindowController {
	public static final String RIDGET_ID_ROUTE_TABLE = "routeTable";
	public static final String RIDGET_ID_ADD = "addButton"; //$NON-NLS-1$
	public static final String RIDGET_ID_DELETE = "deleteButton"; //$NON-NLS-1$
	public static final String RIDGET_ID_CLOSE = "closeButton"; //$NON-NLS-1$
	public static final String RIDGET_ID_DELETE_CONFIRM_DIALOG = "deleteConfirmDialog";
	
	public static final String RIDGET_ID_NO_SELECTION_DIALOG = "noSelectionError";

	private RouteService service ;
	
	private IMessageBoxRidget deleteConfirmDialog;
	
	public RouteListDialogController() {
		super();
		initialize();
	}

	private ITableRidget routeTable;
	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle("Route List");

		routeTable = (ITableRidget) getRidget(RIDGET_ID_ROUTE_TABLE);
		routeTable.bindToModel(service, "routes", Route.class, new String[]{"name", "description", "code"}, new String[]{"Name", "Description", "Code"});
		routeTable.updateFromModel();
		
		deleteConfirmDialog = (IMessageBoxRidget) getRidget(RIDGET_ID_DELETE_CONFIRM_DIALOG);
		deleteConfirmDialog.setType(IMessageBoxRidget.Type.QUESTION);
		deleteConfirmDialog.setTitle("Confirm"); 
		deleteConfirmDialog.setText("Do you want to delete this item?");
		IMessageBoxRidget.MessageBoxOption[] customOptions = new IMessageBoxRidget.MessageBoxOption[] {
				new IMessageBoxRidget.MessageBoxOption("Yes"), new IMessageBoxRidget.MessageBoxOption("No") };
		deleteConfirmDialog.setOptions(customOptions);
		
		IActionRidget addAction = (IActionRidget) getRidget(RIDGET_ID_ADD);
		addAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				AddRouteDialog dialog = new AddRouteDialog();
				dialog.setBlockOnOpen(true);
				dialog.open();
			}
		});
		
		IActionRidget deleteAction = (IActionRidget) getRidget(RIDGET_ID_DELETE);
		deleteAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				if (routeTable.getSelectionIndex() >=0) {
					if (deleteConfirmDialog.show().getLabel().equals("Yes"))
					{
						//#TODO : delete the route
					}
				}
				
			}
		});
		
		IActionRidget closeAction = (IActionRidget) getRidget(RIDGET_ID_CLOSE);
		closeAction.addListener(new IActionListener() {
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
			r.setCode("RED" + i);
			service.getRoutes().add(r);
		}
		
	}

}