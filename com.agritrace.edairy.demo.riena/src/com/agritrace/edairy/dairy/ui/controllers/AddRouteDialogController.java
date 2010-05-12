package com.agritrace.edairy.dairy.ui.controllers;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMessageBoxRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.Route;

public class AddRouteDialogController extends AbstractWindowController {
	public static final String RIDGET_ID_ROUTE_ID = "routeId"; //$NON-NLS-1$
	public static final String RIDGET_ID_NAME = "name"; //$NON-NLS-1$
	public static final String RIDGET_ID_DESCRIPTION = "description"; //$NON-NLS-1$
	public static final String RIDGET_ID_CODE = "code"; //$NON-NLS-1$
	public static final String RIDGET_ID_SAVE = "saveButton"; //$NON-NLS-1$
	public static final String RIDGET_ID_CANCEL = "cancelButton"; //$NON-NLS-1$
	
	public static final String RIDGET_ID_DUPLICATE_NAME_DIALOG = "duplicateNameDialog"; //$NON-NLS-1$

	private RouteService service = RouteService.getInstance();
	
	private ITextRidget textName;
	private IMessageBoxRidget duplicateNameDialog;
	private Route input;
	public AddRouteDialogController() {
		super();

	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle("Add Route");

		input = DairyFactory.eINSTANCE.createRoute();
		
/*		final ITextRidget routeId = getRidget(ITextRidget.class, RIDGET_ID_ROUTE_ID);
		routeId.setOutputOnly(true);
		routeId.bindToModel(route, "routeId");
		routeId.updateFromModel();*/
		
		textName = getRidget(ITextRidget.class, RIDGET_ID_NAME);
		textName.bindToModel(input, "name");
		textName.updateFromModel();
		textName.addValidationMessage("Invalid route name!");
		textName.setMandatory(true);
		textName.addValidationRule(new IValidator() {

			@Override
			public IStatus validate(Object value) {
				if ("".equals(textName.getText())) return Status.CANCEL_STATUS;
				service.refresh();
				for (Route r : service.getRoutes()) {
					if (textName.getText().equals(r.getName())) {
						
						return Status.CANCEL_STATUS;
					}
				}
				return Status.OK_STATUS;
			}
			
		}, ValidationTime.ON_UPDATE_TO_MODEL);
		
		final ITextRidget routeDescription = getRidget(ITextRidget.class, RIDGET_ID_DESCRIPTION);
		routeDescription.bindToModel(input, "description");
		routeDescription.updateFromModel();
		
		final ITextRidget routeCode = getRidget(ITextRidget.class, RIDGET_ID_CODE);
		routeCode.bindToModel(input, "code");
		routeCode.updateFromModel();
		
		duplicateNameDialog = (IMessageBoxRidget) getRidget(RIDGET_ID_DUPLICATE_NAME_DIALOG);
		duplicateNameDialog.setType(IMessageBoxRidget.Type.ERROR);
		duplicateNameDialog.setTitle("Duplicate Name"); 
		duplicateNameDialog.setText("The name '" + textName.getText() + "' is already in use.\r\n\rPlease select a unique name for this new location.");
		
		IActionRidget saveAction = (IActionRidget) getRidget(RIDGET_ID_SAVE);
		saveAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				if (textName.revalidate()) {
					service.getRoutes().add(input);
					service.store();
					getWindowRidget().dispose();
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
	


}
