package com.agritrace.edairy.desktop.dairy.vehicles.ui.views;

import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import com.agritrace.edairy.desktop.common.ui.util.FormUtil;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.dairy.vehicles.ui.controls.VehicleLogDetailBindConstants;

public class VehicleLogDirectoryView extends AbstractDirectoryView {

	public static final String ID = "edairy.locations.vehicle.directory";

	public VehicleLogDirectoryView() {
	}

	@Override
	protected void createFilterConditions(Composite parent) {
		final Group filterGroup = UIControlsFactory.createGroup(parent, "Search Criteria");
		filterGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		filterGroup.setLayout(new GridLayout(2, false));
		filterGroup.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		//Vehicle type
		UIControlsFactory.createLabel(filterGroup, "Vehicle Type: ", SWT.LEFT);
		final CCombo vehicleCombo = UIControlsFactory.createCCombo(filterGroup,  VehicleLogDetailBindConstants.BIND_ID_VEHICLE_TYPE);
		final GridData gd = new GridData();
		gd.widthHint = FormUtil.WIDTH_UNIT * 3;
		gd.verticalAlignment = SWT.FILL;
		vehicleCombo.setLayoutData(gd);

		//Driver
		UIControlsFactory.createLabel(filterGroup, "Driver");
		final CCombo driverText = UIControlsFactory.createCCombo(filterGroup,VehicleLogDetailBindConstants.BIND_ID_DRIVER_NAME);
		final GridData gd2 = new GridData();
		gd2.widthHint = FormUtil.WIDTH_UNIT * 3;
		gd2.verticalAlignment = SWT.FILL;
		driverText.setLayoutData(gd2);
	}

}
