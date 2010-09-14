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

public class RouteEditDialog extends RecordDialog<Route> {
	private Text routeDescriptionTxt;
	private Text routeNameTxt;

	public RouteEditDialog(Shell parentShell) {
		super(parentShell);
		setTitle("Transport Route");
		setShellStyle(SWT.RESIZE | SWT.TITLE);
	}

	@Override
	protected void buildWorkArea(Composite comp) {
		/*
		final Label lblRouteCode = UIControlsFactory.createLabel(comp, "Route Code", SWT.NONE);

		routeCodeTxt = UIControlsFactory.createText(comp);
		addUIControl(routeCodeTxt, ViewConstants.ID_TXT_ROUTE_CODE);
		*/

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

		/*
		final GroupLayout gl_comp = new GroupLayout(comp);
		gl_comp.setHorizontalGroup(gl_comp.createParallelGroup(GroupLayout.LEADING).add(
				gl_comp.createSequentialGroup()
						.addContainerGap()
						.add(gl_comp.createParallelGroup(GroupLayout.LEADING).add(lblRouteName)
								.add(lblDescription).add(lblStops))
						.add(32)
						.add(gl_comp
								.createParallelGroup(GroupLayout.LEADING)
								.add(stopsList, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.add(gl_comp
										.createParallelGroup(GroupLayout.LEADING, false)
										.add(routeNameTxt, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
										.add(routeDescriptionTxt, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)))
						.addContainerGap(38, Short.MAX_VALUE)));
		gl_comp.setVerticalGroup(gl_comp.createParallelGroup(GroupLayout.LEADING).add(
				gl_comp.createSequentialGroup()
						.addContainerGap()
						.add(gl_comp
								.createParallelGroup(GroupLayout.BASELINE))
						.add(18)
						.add(gl_comp
								.createParallelGroup(GroupLayout.BASELINE)
								.add(lblRouteName)
								.add(routeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.add(18)
						.add(gl_comp.createParallelGroup(GroupLayout.BASELINE).add(lblDescription)
								.add(routeDescriptionTxt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.add(18)
						.add(gl_comp.createParallelGroup(GroupLayout.LEADING).add(lblStops)
								.add(stopsList, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(28, Short.MAX_VALUE)));
		comp.setLayout(gl_comp);
		*/
		
		GridLayoutFactory.fillDefaults().numColumns(2).margins(6, 6).generateLayout(comp);
	}

	@Override
	protected RouteEditDialogController createController() {
		return new RouteEditDialogController();
	}
}
