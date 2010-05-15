package com.agritrace.edairy.desktop.setup.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

/**
 * Vehicle log master/detail
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class VehicleMasterDetailComposite extends MasterDetailsComposite {

    public static final String BIND_ID_LOG_NUM = "log.num";
    public static final String BIND_ID_DRIVER_NAME = "driver.name";
    public static final String BIND_ID_REG_NUM = "reg.num";
    public static final String BIND_ID_CHASSIS_NUM = "chassis.num";
    public static final String BIND_ID_ENGINE_NUM = "engine.num";
    public static final String BIND_ID_DESC_MAKE = "desc.make";
    public static final String BIND_ID_DESC_MODEL = "desc.model";
    public static final String BIND_ID_DESC_COLOR = "desc.color";
    public static final String BIND_ID_DESC_YEAR = "desc.year";
    public static final String BIND_ID_DESC_CAPACITY = "desc.capacity";
    public static final String BIND_ID_ASSET_DATE_ACQUIRED = "asset.date.acquired";
    public static final String BIND_ID_ASSET_DATE_DAMAGE = "asset.date.damage";
    public static final String BIND_ID_ASSET_DESC_DAMAGE = "asset.des.damage";
    public static final String BIND_ID_ASSET_DATE_DISPOSAL = "asset.date.disposal";
    public static final String BIND_ID_ASSET_REASON_DISPOSAL = "asset.date.reason";
    public static final String BIND_ID_ASSET_WITNESS_DISPOSAL = "asset.witness.disposal";
    public static final String BIND_ID_INSURANCE_NUMBER = "insurance.num";
    public static final String BIND_ID_INSURANCE_EXP_DATE = "insurance.exp.date";

    public VehicleMasterDetailComposite(Composite parent, int style) {
	super(parent, style);
	setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }

    @Override
    protected Table createTable(Composite tableComposite, TableColumnLayout layout) {

	final Table table = super.createTable(tableComposite, layout);
	final GridData data = new GridData(GridData.FILL_BOTH);
	data.grabExcessVerticalSpace = true;
	// Same height with the filter section
	data.heightHint = getParent().getChildren()[0].computeSize(-1, -1).y;
	tableComposite.setLayoutData(data);
	tableComposite.setLayout(layout);
	return table;
    }

    @Override
    protected void createDetails(Composite parent) {

	// Since the master/detail are not in same composite
	final Composite grand = this.getParent();
	GridLayoutFactory.fillDefaults().numColumns(2).margins(20, 20).spacing(10, 10).equalWidth(false)
		.applyTo(parent);
	final GridData data = new GridData();
	data.heightHint = 0;
	parent.setLayoutData(data);

	GridDataFactory.fillDefaults().grab(true, false);

	createDetailscontrol(grand);
    }

    protected void createDetailscontrol(Composite parent) {

	final Group detailGroup = UIControlsFactory.createGroup(parent, "Vehicle Detail");
	final GridLayout groupLayout = new GridLayout();
	groupLayout.numColumns = 3;
	detailGroup.setLayout(groupLayout);

	final GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
	data.horizontalSpan = 2;
	detailGroup.setLayoutData(data);
	detailGroup.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
	// Create common controls
	createIdentificationControls(detailGroup);

	createRegistrationGroup(detailGroup);
	// Create description group
	createDescriptionGroup(detailGroup);
	// Create Assset Info group
	createAssetInfoGroup(detailGroup);
	// Create Insurance Info group
	createInsuranceInfoGroup(detailGroup);

    }

    private void createIdentificationControls(Composite parent) {
	final Composite comonComp = UIControlsFactory.createComposite(parent);
	comonComp.setLayout(new GridLayout(2, false));
	GridDataFactory.fillDefaults().grab(true, false).applyTo(comonComp);

	UIControlsFactory.createLabel(comonComp, "Log Book Number"); //$NON-NLS-1$
	final Text logNumber = UIControlsFactory.createText(comonComp);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(logNumber);
	addUIControl(logNumber, BIND_ID_LOG_NUM);

	UIControlsFactory.createLabel(comonComp, "Driver"); //$NON-NLS-1$
	final Text driverText = UIControlsFactory.createText(comonComp);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(driverText);
	addUIControl(driverText, BIND_ID_DRIVER_NAME);

    }

    private void createRegistrationGroup(Composite parent) {
	final Group detailGroup = UIControlsFactory.createGroup(parent, "Registration");
	detailGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
	GridDataFactory.fillDefaults().grab(true, false).applyTo(detailGroup);

	// Registration Number
	UIControlsFactory.createLabel(detailGroup, "Registration Number"); //$NON-NLS-1$
	final Text regText = UIControlsFactory.createText(detailGroup);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(regText);
	addUIControl(regText, BIND_ID_REG_NUM);

	// Chassis Number
	UIControlsFactory.createLabel(detailGroup, "Chassis Number"); //$NON-NLS-1$
	final Text chassisText = UIControlsFactory.createText(detailGroup);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(chassisText);
	addUIControl(chassisText, BIND_ID_CHASSIS_NUM);
	// Enigine Number
	UIControlsFactory.createLabel(detailGroup, "Engine Number"); //$NON-NLS-1$
	final Text engineText = UIControlsFactory.createText(detailGroup);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(engineText);
	addUIControl(engineText, BIND_ID_ENGINE_NUM);

    }

    private void createDescriptionGroup(Composite parent) {
	final Group detailGroup = UIControlsFactory.createGroup(parent, "Description");
	detailGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
	GridDataFactory.fillDefaults().grab(true, false).applyTo(detailGroup);

	// Make
	UIControlsFactory.createLabel(detailGroup, "Make"); //$NON-NLS-1$
	final Text makeText = UIControlsFactory.createText(detailGroup);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(makeText);
	addUIControl(makeText, BIND_ID_DESC_MAKE);

	// Model
	UIControlsFactory.createLabel(detailGroup, "Model"); //$NON-NLS-1$
	final Text modelText = UIControlsFactory.createText(detailGroup);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(modelText);
	addUIControl(modelText, BIND_ID_DESC_MODEL);

	// Color
	UIControlsFactory.createLabel(detailGroup, "Color"); //$NON-NLS-1$
	final Text colorText = UIControlsFactory.createText(detailGroup);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(colorText);
	addUIControl(colorText, BIND_ID_DESC_COLOR);

	// Year
	UIControlsFactory.createLabel(detailGroup, "Year"); //$NON-NLS-1$
	final Text yearText = UIControlsFactory.createText(detailGroup);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(yearText);
	addUIControl(yearText, BIND_ID_DESC_YEAR);

	// Compacity
	UIControlsFactory.createLabel(detailGroup, "Compacity"); //$NON-NLS-1$
	final Text compacityText = UIControlsFactory.createText(detailGroup);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(compacityText);
	addUIControl(compacityText, BIND_ID_DESC_CAPACITY);

    }

    private void createAssetInfoGroup(Composite parent) {
	final Group detailGroup = UIControlsFactory.createGroup(parent, "Asset Info");
	detailGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
	GridDataFactory.fillDefaults().span(2, 1).applyTo(detailGroup);

	// Date Acquired
	UIControlsFactory.createLabel(detailGroup, "Date Acquired"); //$NON-NLS-1$
	final Text dateAcqText = UIControlsFactory.createText(detailGroup);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(dateAcqText);
	addUIControl(dateAcqText, BIND_ID_ASSET_DATE_ACQUIRED);

	// Damage Date
	UIControlsFactory.createLabel(detailGroup, "Damage Date"); //$NON-NLS-1$
	final Text damageDateText = UIControlsFactory.createText(detailGroup);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(damageDateText);
	addUIControl(damageDateText, BIND_ID_ASSET_DATE_DAMAGE);

	// Damage Description
	UIControlsFactory.createLabel(detailGroup, "Damage Description"); //$NON-NLS-1$
	final Text damageDescText = UIControlsFactory.createTextMulti(detailGroup, true, true);
	GridDataFactory.fillDefaults().grab(true, false).hint(-1, 50).applyTo(damageDescText);
	addUIControl(damageDescText, BIND_ID_ASSET_DESC_DAMAGE);

	// Disposal Date
	UIControlsFactory.createLabel(detailGroup, "Disposal Date"); //$NON-NLS-1$
	final Text disposalDateText = UIControlsFactory.createText(detailGroup);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(disposalDateText);
	addUIControl(disposalDateText, BIND_ID_ASSET_DATE_DISPOSAL);

	// Disposal Reason
	UIControlsFactory.createLabel(detailGroup, "Disposal Reason"); //$NON-NLS-1$
	final Text disposalReasonText = UIControlsFactory.createTextMulti(detailGroup, true, true);
	GridDataFactory.fillDefaults().grab(true, false).hint(-1, 50).applyTo(disposalReasonText);
	addUIControl(disposalReasonText, BIND_ID_ASSET_REASON_DISPOSAL);

	// Disposal Witness
	UIControlsFactory.createLabel(detailGroup, "Disposal Witness"); //$NON-NLS-1$
	final Text witnessText = UIControlsFactory.createText(detailGroup);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(witnessText);
	addUIControl(witnessText, BIND_ID_ASSET_WITNESS_DISPOSAL);

    }

    private void createInsuranceInfoGroup(Composite parent) {
	final Group detailGroup = UIControlsFactory.createGroup(parent, "Insurance Info");
	detailGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
	GridDataFactory.fillDefaults().grab(true, false).applyTo(detailGroup);

	// Insurance Number
	UIControlsFactory.createLabel(detailGroup, "Insurance Number"); //$NON-NLS-1$
	final Text dateAcqText = UIControlsFactory.createText(detailGroup);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(dateAcqText);
	addUIControl(dateAcqText, BIND_ID_INSURANCE_NUMBER);

	// Expiration Date
	UIControlsFactory.createLabel(detailGroup, "Expiration Date"); //$NON-NLS-1$
	final Text damageDateText = UIControlsFactory.createText(detailGroup);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(damageDateText);
	addUIControl(damageDateText, BIND_ID_INSURANCE_EXP_DATE);

    }

}
