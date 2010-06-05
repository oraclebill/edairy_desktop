package com.agritrace.edairy.desktop.dairy.locations.ui.dialogs;

import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMessageBoxRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.operations.services.dairylocation.DairyLocationRepository;

public class RouteListDialogController extends AbstractWindowController {
	public static final String RIDGET_ID_ROUTE_TABLE = "routeTable";
	public static final String RIDGET_ID_ADD = "addButton"; //$NON-NLS-1$
	public static final String RIDGET_ID_DELETE = "deleteButton"; //$NON-NLS-1$
	public static final String RIDGET_ID_CLOSE = "closeButton"; //$NON-NLS-1$
	public static final String RIDGET_ID_DELETE_CONFIRM_DIALOG = "deleteConfirmDialog";

	public static final String RIDGET_ID_NO_SELECTION_DIALOG = "noSelectionError";

	private ITableRidget routeTable;

	private IMessageBoxRidget deleteConfirmDialog;
	private DairyLocationRepository repo = new DairyLocationRepository();

	public RouteListDialogController() {
		super();
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle("Route List");

		routeTable = (ITableRidget) getRidget(RIDGET_ID_ROUTE_TABLE);
		routeTable.bindToModel(repo, "routes", Route.class, new String[] {
				"name", "description", "code" }, new String[] { "Name",
				"Description", "Code" });
		routeTable.updateFromModel();

		deleteConfirmDialog = (IMessageBoxRidget) getRidget(RIDGET_ID_DELETE_CONFIRM_DIALOG);
		deleteConfirmDialog.setType(IMessageBoxRidget.Type.QUESTION);
		deleteConfirmDialog.setTitle("Confirm");
		deleteConfirmDialog.setText("Do you want to delete this item?");
		final IMessageBoxRidget.MessageBoxOption[] customOptions = new IMessageBoxRidget.MessageBoxOption[] {
				new IMessageBoxRidget.MessageBoxOption("Yes"),
				new IMessageBoxRidget.MessageBoxOption("No") };
		deleteConfirmDialog.setOptions(customOptions);

		final IActionRidget addAction = (IActionRidget) getRidget(RIDGET_ID_ADD);
		addAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				final AddRouteDialog dialog = new AddRouteDialog(
						new AddRouteDialogController(repo));
				dialog.setBlockOnOpen(true);
				dialog.open();
				routeTable.updateFromModel();
			}
		});

		final IActionRidget deleteAction = (IActionRidget) getRidget(RIDGET_ID_DELETE);
		deleteAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				if (routeTable.getSelectionIndex() >= 0) {
					if (deleteConfirmDialog.show().getLabel().equals("Yes")) {
						repo.deleteRoute((Route)routeTable.getSelection().get(0));
						routeTable.updateFromModel();
					}
				}

			}
		});

		final IActionRidget closeAction = (IActionRidget) getRidget(RIDGET_ID_CLOSE);
		closeAction.addListener(new IActionListener() {
			@Override
			public void callback() {

				getWindowRidget().dispose();
			}
		});
	}

}
