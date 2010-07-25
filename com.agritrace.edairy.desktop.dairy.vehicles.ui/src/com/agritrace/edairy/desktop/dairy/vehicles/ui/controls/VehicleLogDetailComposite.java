package com.agritrace.edairy.desktop.dairy.vehicles.ui.controls;


import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.controls.assetinfo.AssetInfo;

public class VehicleLogDetailComposite extends Composite {

	public VehicleLogDetailComposite(Composite parent) {
		super(parent, SWT.NONE);
		setLayout(new FillLayout());
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		final CTabFolder tabFolder = new CTabFolder(this, 0);
		final CTabItem mainInfoTab = new CTabItem(tabFolder, SWT.None);
		mainInfoTab.setText("Main Info");
		final Composite detailGroup = UIControlsFactory.createComposite(tabFolder);
		mainInfoTab.setControl(detailGroup);

		createIdentificationControls(detailGroup);
		createRegistrationGroup(detailGroup);
		createDescriptionGroup(detailGroup);
		createInsuranceInfoGroup(detailGroup);
		GridLayoutFactory.fillDefaults().numColumns(2).generateLayout(detailGroup);

		final CTabItem assetInfoTab = new CTabItem(tabFolder, SWT.None);
		assetInfoTab.setText("Asset Info");
		Control control = new AssetInfo(tabFolder, SWT.None);
		assetInfoTab.setControl(control);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(control, "asset-info");

		tabFolder.setSelection(mainInfoTab);
		tabFolder.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		// this.pack();
	}

	private void createDescriptionGroup(Composite parent) {
		final Group detailGroup = UIControlsFactory.createGroup(parent, "Description");
		GridLayout gl_detailGroup = GridLayoutFactory.swtDefaults().numColumns(2).create();
		// gl_detailGroup.makeColumnsEqualWidth = true;
		detailGroup.setLayout(gl_detailGroup);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(detailGroup);

		GridDataFactory fieldDataFactory = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false)
				.hint(120, -1);

		// Make
		Label lblMake = UIControlsFactory.createLabel(detailGroup, "Make");
		GridData gd_lblMake = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblMake.widthHint = 100;
		lblMake.setLayoutData(gd_lblMake);
		final Text makeText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				VehicleLogDetailBindConstants.BIND_ID_DESC_MAKE);
		fieldDataFactory.applyTo(makeText);

		// Model
		UIControlsFactory.createLabel(detailGroup, "Model");
		final Text modelText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				VehicleLogDetailBindConstants.BIND_ID_DESC_MODEL);
		fieldDataFactory.applyTo(modelText);

		// Color
		UIControlsFactory.createLabel(detailGroup, "Color");
		final Text colorText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				VehicleLogDetailBindConstants.BIND_ID_DESC_COLOR);
		fieldDataFactory.applyTo(colorText);

		// Year
		UIControlsFactory.createLabel(detailGroup, "Year");
		final Spinner yearText = UIControlsFactory.createSpinner(detailGroup, SWT.BORDER,
				VehicleLogDetailBindConstants.BIND_ID_DESC_YEAR);
		yearText.setMaximum(3000);
		yearText.setMinimum(1900);
		fieldDataFactory.copy().align(SWT.LEFT, SWT.CENTER).applyTo(yearText);

		// Compacity
		UIControlsFactory.createLabel(detailGroup, "Capacity");
		final Text compacityText = UIControlsFactory.createTextNumeric(detailGroup,
				VehicleLogDetailBindConstants.BIND_ID_DESC_CAPACITY);
		fieldDataFactory.applyTo(compacityText);

	}

	private void createIdentificationControls(Composite parent) {
		final Group comonComp = UIControlsFactory.createGroup(parent, "");
		comonComp.setLayout(new GridLayout(2, true));
		GridDataFactory.fillDefaults().grab(true, false).applyTo(comonComp);

		Label label = UIControlsFactory.createLabel(comonComp, "Log Book No.");
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label.minimumWidth = 120;
		label.setLayoutData(gd_label);
		final Text logNumber = UIControlsFactory.createText(comonComp, SWT.NONE,
				VehicleLogDetailBindConstants.BIND_ID_LOG_NUM);
		logNumber.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		GridDataFactory.fillDefaults().grab(true, false).applyTo(logNumber);

		UIControlsFactory.createLabel(comonComp, "Vehicle Type");

		final CCombo combo = UIControlsFactory.createCCombo(comonComp,
				VehicleLogDetailBindConstants.BIND_ID_VEHICLE_TYPE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		// addUIControl(logNumber, BIND_ID_LOG_NUM);

		UIControlsFactory.createLabel(comonComp, "Driver");
		final CCombo driverText = UIControlsFactory.createCCombo(comonComp,
				VehicleLogDetailBindConstants.BIND_ID_DRIVER_NAME);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(driverText);
		// addUIControl(driverText, BIND_ID_DRIVER_NAME);

	}

	private void createInsuranceInfoGroup(Composite parent) {
		final Group detailGroup = UIControlsFactory.createGroup(parent, "Insurance Info");
		GridLayout gl_detailGroup = GridLayoutFactory.swtDefaults().numColumns(2).create();
		gl_detailGroup.makeColumnsEqualWidth = true;
		detailGroup.setLayout(gl_detailGroup);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(detailGroup);

		// Insurance Number
		Label label = UIControlsFactory.createLabel(detailGroup, "Insurance Number"); //$NON-NLS-1$
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label.minimumWidth = 120;
		label.setLayoutData(gd_label);
		final Text dateAcqText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				VehicleLogDetailBindConstants.BIND_ID_INSURANCE_NUMBER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(dateAcqText);
		// addUIControl(dateAcqText, BIND_ID_INSURANCE_NUMBER);

		// Expiration Date
		UIControlsFactory.createLabel(detailGroup, "Expiration Date"); //$NON-NLS-1$
		final DateTime damageDateText = UIControlsFactory.createDate(detailGroup, SWT.BORDER,
				VehicleLogDetailBindConstants.BIND_ID_INSURANCE_EXP_DATE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(damageDateText);
		// addUIControl(damageDateText, BIND_ID_INSURANCE_EXP_DATE);

	}

	private void createRegistrationGroup(Composite parent) {
		final Group detailGroup = UIControlsFactory.createGroup(parent, "Registration");
		GridLayout gl_detailGroup = GridLayoutFactory.swtDefaults().numColumns(2).create();
		gl_detailGroup.makeColumnsEqualWidth = true;
		detailGroup.setLayout(gl_detailGroup);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(detailGroup);

		// Registration Number
		Label label_1 = UIControlsFactory.createLabel(detailGroup, "Registration No.");
		GridData gd_label_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label_1.minimumWidth = 120;
		label_1.setLayoutData(gd_label_1);
		final Text regText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				VehicleLogDetailBindConstants.BIND_ID_REG_NUM);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(regText);
		// addUIControl(regText, BIND_ID_REG_NUM);

		// Chassis Number
		Label lblChassisNumber = UIControlsFactory.createLabel(detailGroup, "Chassis Number");
		GridData gd_lblChassisNumber = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblChassisNumber.widthHint = 114;
		lblChassisNumber.setLayoutData(gd_lblChassisNumber);
		final Text chassisText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				VehicleLogDetailBindConstants.BIND_ID_CHASSIS_NUM);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(chassisText);
		// addUIControl(chassisText, BIND_ID_CHASSIS_NUM);

		// Enigine Number
		UIControlsFactory.createLabel(detailGroup, "Engine Number");
		final Text engineText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				VehicleLogDetailBindConstants.BIND_ID_ENGINE_NUM);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(engineText);
		// addUIControl(engineText, BIND_ID_ENGINE_NUM);

	}
}