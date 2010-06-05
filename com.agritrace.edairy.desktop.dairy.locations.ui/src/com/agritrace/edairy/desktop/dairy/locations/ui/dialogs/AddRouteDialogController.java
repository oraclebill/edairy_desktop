package com.agritrace.edairy.desktop.dairy.locations.ui.dialogs;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMessageBoxRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.operations.services.dairylocation.DairyLocationRepository;

public class AddRouteDialogController extends AbstractWindowController {
	private ITextRidget textName;
	private IMessageBoxRidget duplicateNameDialog;
	private Route newRoute;
	DairyLocationRepository repo;

	public AddRouteDialogController(DairyLocationRepository dairy) {
		super();
		repo = dairy;
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle("Add Route");

		newRoute = DairyFactory.eINSTANCE.createRoute();

		/*
		 * final ITextRidget routeId = getRidget(ITextRidget.class,
		 * RIDGET_ID_ROUTE_ID); routeId.setOutputOnly(true);
		 * routeId.bindToModel(route, "routeId"); routeId.updateFromModel();
		 */

		textName = getRidget(ITextRidget.class,
				AddRouteDialogIDs.RIDGET_ID_NAME);
		textName.bindToModel(newRoute, "name");
		textName.updateFromModel();
		textName.addValidationMessage("Invalid route name!");
		textName.setMandatory(true);
		textName.addValidationRule(new IValidator() {

			@Override
			public IStatus validate(Object value) {
				if ("".equals(textName.getText())) {
					return Status.CANCEL_STATUS;
				}
				for (final Route r : repo.getRoutes()) {
					if (textName.getText().equals(r.getName())) {

						return Status.CANCEL_STATUS;
					}
				}
				return Status.OK_STATUS;
			}

		}, ValidationTime.ON_UPDATE_TO_MODEL);

		final ITextRidget routeDescription = getRidget(ITextRidget.class,
				AddRouteDialogIDs.RIDGET_ID_DESCRIPTION);
		routeDescription.bindToModel(newRoute, "description");
		routeDescription.updateFromModel();

		final ITextRidget routeCode = getRidget(ITextRidget.class,
				AddRouteDialogIDs.RIDGET_ID_CODE);
		routeCode.bindToModel(newRoute, "code");
		routeCode.updateFromModel();

		duplicateNameDialog = (IMessageBoxRidget) getRidget(AddRouteDialogIDs.RIDGET_ID_DUPLICATE_NAME_DIALOG);
		duplicateNameDialog.setType(IMessageBoxRidget.Type.ERROR);
		duplicateNameDialog.setTitle("Duplicate Name");
		duplicateNameDialog
				.setText("The name '"
						+ textName.getText()
						+ "' is already in use.\r\n\rPlease select a unique name for this new location.");

		final IActionRidget saveAction = (IActionRidget) getRidget(AddRouteDialogIDs.RIDGET_ID_SAVE);
		saveAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				if (textName.revalidate()) {
					repo.saveNewRoute(newRoute);
					// service.store(); // TODO: TEST PERSISTENCE
					getWindowRidget().dispose();
				}
			}
		});

		final IActionRidget cencelAction = (IActionRidget) getRidget(AddRouteDialogIDs.RIDGET_ID_CANCEL);
		cencelAction.addListener(new IActionListener() {
			@Override
			public void callback() {

				getWindowRidget().dispose();
			}
		});
	}

}
