package com.agritrace.edairy.desktop.dairy.vehicles.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Spinner;

public class VehicleLogDetailComposite extends Composite {

	public VehicleLogDetailComposite(Composite parent) {
		super(parent, SWT.NONE);
		setLayout(new FillLayout());
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		final CTabFolder tabFolder = new CTabFolder(this, 0);
		CTabItem mainInfoTab = new CTabItem(tabFolder, SWT.None);
		mainInfoTab.setText("Main Info");
		Composite detailGroup = UIControlsFactory.createComposite(tabFolder);
		mainInfoTab.setControl(detailGroup);

		createIdentificationControls(detailGroup);
		createRegistrationGroup(detailGroup);
		createDescriptionGroup(detailGroup);
		createInsuranceInfoGroup(detailGroup);
		GridLayoutFactory.fillDefaults().numColumns(2).generateLayout(detailGroup);

		CTabItem assetInfoTab = new CTabItem(tabFolder, SWT.None);
		assetInfoTab.setText("Asset Info");
		assetInfoTab.setControl(createAssetInfoGroup(tabFolder));

		this.pack();
	}

	private Composite createAssetInfoGroup(Composite parent) {
		final Composite detailGroup = UIControlsFactory.createComposite(parent);
		detailGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		GridDataFactory.swtDefaults().span(2, 1).applyTo(detailGroup);

		// Date Acquired
		UIControlsFactory.createLabel(detailGroup, "Date Acquired");
		final DateTime dateAcqText = UIControlsFactory.createDate(detailGroup, SWT.MEDIUM,
				VehicleLogDetailBindConstants.BIND_ID_ASSET_DATE_ACQUIRED);
		GridDataFactory.swtDefaults().grab(false, false).applyTo(dateAcqText);
		// addUIControl(dateAcqText, BIND_ID_ASSET_DATE_ACQUIRED);

		// Damage Date
		UIControlsFactory.createLabel(detailGroup, "Damage Date");
		final DateTime damageDateText = UIControlsFactory.createDate(detailGroup, SWT.MEDIUM,
				VehicleLogDetailBindConstants.BIND_ID_ASSET_DATE_DAMAGE);
		GridDataFactory.swtDefaults().grab(false, false).applyTo(damageDateText);
		// addUIControl(damageDateText, BIND_ID_ASSET_DATE_DAMAGE);

		// Damage Description
		UIControlsFactory.createLabel(detailGroup, "Damage Description"); //$NON-NLS-1$
		final Text damageDescText = UIControlsFactory.createTextMulti(detailGroup, true, true,
				VehicleLogDetailBindConstants.BIND_ID_ASSET_DESC_DAMAGE);
		GridDataFactory.fillDefaults().grab(true, false).hint(-1, 50).applyTo(damageDescText);
		// addUIControl(damageDescText, BIND_ID_ASSET_DESC_DAMAGE);

		// Disposal Date
		UIControlsFactory.createLabel(detailGroup, "Disposal Date"); //$NON-NLS-1$
		final DateTime disposalDateText = UIControlsFactory.createDate(detailGroup, SWT.MEDIUM,
				VehicleLogDetailBindConstants.BIND_ID_ASSET_DATE_DISPOSAL);
		GridDataFactory.swtDefaults().grab(false, false).applyTo(disposalDateText);
		// addUIControl(disposalDateText, BIND_ID_ASSET_DATE_DISPOSAL);

		// Disposal Reason
		UIControlsFactory.createLabel(detailGroup, "Disposal Reason"); //$NON-NLS-1$
		final Text disposalReasonText = UIControlsFactory.createTextMulti(detailGroup, true, true,
				VehicleLogDetailBindConstants.BIND_ID_ASSET_REASON_DISPOSAL);
		GridDataFactory.fillDefaults().grab(true, false).hint(-1, 50).applyTo(disposalReasonText);
		// addUIControl(disposalReasonText, BIND_ID_ASSET_REASON_DISPOSAL);

		// Disposal Witness
		UIControlsFactory.createLabel(detailGroup, "Disposal Witness"); //$NON-NLS-1$
		final Text witnessText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				VehicleLogDetailBindConstants.BIND_ID_ASSET_WITNESS_DISPOSAL);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(witnessText);
		// addUIControl(witnessText, BIND_ID_ASSET_WITNESS_DISPOSAL);
		return detailGroup;

	}

	private void createDescriptionGroup(Composite parent) {
		final Group detailGroup = UIControlsFactory.createGroup(parent, "Description");
		detailGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		GridDataFactory.fillDefaults().grab(true, false).applyTo(detailGroup);

		// Make
		UIControlsFactory.createLabel(detailGroup, "Make");
		final Text makeText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				VehicleLogDetailBindConstants.BIND_ID_DESC_MAKE);
		GridDataFactory.swtDefaults().grab(true, false).applyTo(makeText);
		// addUIControl(makeText, BIND_ID_DESC_MAKE);

		// Model
		UIControlsFactory.createLabel(detailGroup, "Model");
		final Text modelText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				VehicleLogDetailBindConstants.BIND_ID_DESC_MODEL);
		GridDataFactory.swtDefaults().grab(true, false).applyTo(modelText);
		// addUIControl(modelText, BIND_ID_DESC_MODEL);

		// Color
		UIControlsFactory.createLabel(detailGroup, "Color");
		final Text colorText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				VehicleLogDetailBindConstants.BIND_ID_DESC_COLOR);
		GridDataFactory.swtDefaults().grab(true, false).applyTo(colorText);
		// addUIControl(colorText, BIND_ID_DESC_COLOR);

		// Year
		UIControlsFactory.createLabel(detailGroup, "Year");
		final Spinner yearText = UIControlsFactory.createSpinner(detailGroup, SWT.BORDER,
				VehicleLogDetailBindConstants.BIND_ID_DESC_YEAR);
		yearText.setMaximum(3000);
		yearText.setMinimum(1900);
		GridDataFactory.swtDefaults().grab(true, false).applyTo(yearText);
		// addUIControl(yearText, BIND_ID_DESC_YEAR);

		// Compacity
		UIControlsFactory.createLabel(detailGroup, "Capacity");
		final Text compacityText = UIControlsFactory.createTextNumeric(detailGroup,
				VehicleLogDetailBindConstants.BIND_ID_DESC_CAPACITY);
		GridDataFactory.swtDefaults().grab(true, false).applyTo(compacityText);
		// addUIControl(compacityText, BIND_ID_DESC_CAPACITY);

	}

	private void createIdentificationControls(Composite parent) {
		final Group comonComp = UIControlsFactory.createGroup(parent, "");
		comonComp.setLayout(new GridLayout(2, false));
		GridDataFactory.fillDefaults().grab(true, false).applyTo(comonComp);

		UIControlsFactory.createLabel(comonComp, "Log Book Number");
		final Text logNumber = UIControlsFactory.createText(comonComp, SWT.NONE,
				VehicleLogDetailBindConstants.BIND_ID_LOG_NUM);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(logNumber);

		Label lblVehicleType = UIControlsFactory.createLabel(comonComp, "Vehicle Type" );

		final CCombo combo = UIControlsFactory.createCCombo(comonComp, VehicleLogDetailBindConstants.BIND_ID_VEHICLE_TYPE);
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
		detailGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		GridDataFactory.fillDefaults().grab(true, false).applyTo(detailGroup);

		// Insurance Number
		UIControlsFactory.createLabel(detailGroup, "Insurance Number"); //$NON-NLS-1$
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
		detailGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		GridDataFactory.fillDefaults().grab(true, false).applyTo(detailGroup);

		// Registration Number
		UIControlsFactory.createLabel(detailGroup, "Registration Number");
		final Text regText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				VehicleLogDetailBindConstants.BIND_ID_REG_NUM);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(regText);
		// addUIControl(regText, BIND_ID_REG_NUM);

		// Chassis Number
		UIControlsFactory.createLabel(detailGroup, "Chassis Number");
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