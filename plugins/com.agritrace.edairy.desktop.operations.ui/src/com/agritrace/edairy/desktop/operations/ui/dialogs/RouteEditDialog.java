package com.agritrace.edairy.desktop.operations.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.operations.ui.ViewConstants;
import com.agritrace.edairy.desktop.operations.ui.controllers.RouteEditDialogController;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class RouteEditDialog extends RecordDialog<Route> {
	private Text routeDescriptionTxt;
	private Text routeNameTxt;

	@Inject
	public RouteEditDialog(@Named("current") Shell parentShell, final RouteEditDialogController controller) {
		super(parentShell, controller);
		setTitle("Transport Route");
		setShellStyle(SWT.RESIZE | SWT.TITLE);
	}

	@Override
	protected void buildWorkArea(Composite comp) {
		UIControlsFactory.createLabel(comp, "Route Name");
		routeNameTxt = UIControlsFactory.createText(comp);
		addUIControl(routeNameTxt, ViewConstants.ID_TXT_ROUTE_NAME);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(routeNameTxt);

		UIControlsFactory.createLabel(comp, "Description");
		routeDescriptionTxt = UIControlsFactory.createText(comp);
		addUIControl(routeDescriptionTxt, ViewConstants.ID_TXT_ROUTE_DESCRIPTION);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(routeDescriptionTxt);

		UIControlsFactory.createLabel(comp, "Vehicle");
		final CCombo vehicle = UIControlsFactory.createCCombo(comp);
		addUIControl(vehicle, ViewConstants.ID_TXT_ROUTE_VEHICLE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(vehicle);

		UIControlsFactory.createLabel(comp, "Stops");
		final List stopsList = UIControlsFactory.createList(comp, false, false);
		stopsList.setEnabled(false);
		addUIControl(stopsList, ViewConstants.ID_LST_ROUTE_STOPS);
		GridDataFactory.fillDefaults().grab(true, true).hint(300, 150).applyTo(stopsList);

		GridLayoutFactory.fillDefaults().numColumns(2).margins(6, 6).generateLayout(comp);
	}

}
