package com.agritrace.edairy.desktop.services.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.ImageRegistry;
import com.agritrace.edairy.desktop.common.ui.util.ServiceUtils;
import com.agritrace.edairy.desktop.services.ui.Activator;
import com.agritrace.edairy.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.model.requests.RequestType;

/**
 * Service Log view Master detail Composite
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceRequestMasterDetailComposite extends MasterDetailsComposite {

    private Composite specialComp;
    private Group inseminationGroup;
    private Composite verternaryComp;
    private Composite inseminationComp;
    private RequestType previousType;
    public static final String SPECIFIC_RPEFIX = "specific";//$NON-NLS-1$
    public static final String BIND_ID_INSE_TIME_HEATED_DETECTED = SPECIFIC_RPEFIX + "time.heated.detected";//$NON-NLS-1$
    public static final String BIND_ID_INSE_FIRST_TRETMENT = SPECIFIC_RPEFIX + "time.first.repeat";//$NON-NLS-1$
    public static final String BIND_ID_INSE_SECOND_TRETMENT = SPECIFIC_RPEFIX + "time.second.repeat";//$NON-NLS-1$
    public static final String BIND_ID_INSE_THIRD_TRETMENT = SPECIFIC_RPEFIX + "time.third.repeat";//$NON-NLS-1$
    public static final String BIND_ID_VERY_THIRD_COMPLAINT = SPECIFIC_RPEFIX + "complaint";//$NON-NLS-1$
    public static final String BIND_ID_REQUEST_DATE = "request.date";//$NON-NLS-1$
    public static final String BIND_ID_MEMBER_NAME = "member.name";//$NON-NLS-1$
    public static final String BIND_ID_MEMBER_ID = "member.id";//$NON-NLS-1$
    public static final String BIND_ID_FARM_NAME = "farm.name";//$NON-NLS-1$
    public static final String BIND_ID_SPECIFIC_CONTAINER = "specific.container";//$NON-NLS-1$
    public static final int REQUEST_TYPE_CHANGED = 9999999;

    public ServiceRequestMasterDetailComposite(Composite parent, int style) {
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
	table.setHeaderVisible(true);
	table.setLinesVisible(true);
	return table;
    }

    @Override
    protected Composite createButtons(Composite parent) {
	final Composite compoiste = super.createButtons(parent);
	// hidden the buttons using zero size
	GridDataFactory.fillDefaults().hint(0, 0).applyTo(compoiste);
	return compoiste;
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

    private void createDetailscontrol(Composite parent) {
	final Group detailGroup = UIControlsFactory.createGroup(parent, "Request Detail");
	final GridLayout groupLayout = new GridLayout();
	groupLayout.numColumns = 2;
	detailGroup.setLayout(groupLayout);

	final GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
	data.horizontalSpan = 2;
	detailGroup.setLayoutData(data);
	detailGroup.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
	// Create common controls
	createCommonControls(detailGroup);
	// Create specific controls
	createTypeSpecificControls(detailGroup);

    }

    private void createCommonControls(Composite parent) {
	final Composite comonComp = UIControlsFactory.createComposite(parent);
	comonComp.setLayout(new GridLayout(3, false));

	UIControlsFactory.createLabel(comonComp, "Date");
	final Composite dateComposte = UIControlsFactory.createComposite(comonComp);
	dateComposte.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).margins(0, 0).create());

	GridDataFactory.fillDefaults().grab(true, false).span(2, 1).applyTo(dateComposte);

	final Text txtDate = UIControlsFactory.createText(dateComposte);
	final GridData dateData = new GridData(GridData.FILL_HORIZONTAL);
	dateData.horizontalSpan = 1;
	dateData.grabExcessHorizontalSpace = true;
	txtDate.setLayoutData(dateData);
	addUIControl(txtDate, BIND_ID_REQUEST_DATE);

	final Button button = new Button(dateComposte, SWT.PUSH);
	final Image calendar = Activator.getImage(ImageRegistry.calendar);
	button.setImage(calendar);
	GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(button);

	UIControlsFactory.createLabel(comonComp, "Member ID"); //$NON-NLS-1$
	final Text txtID = UIControlsFactory.createText(comonComp);
	final GridData textData = new GridData(GridData.FILL_HORIZONTAL);
	textData.horizontalSpan = 2;
	txtID.setLayoutData(textData);
	addUIControl(txtID, BIND_ID_MEMBER_ID);

	UIControlsFactory.createLabel(comonComp, "Member Name"); //$NON-NLS-1$
	final Text txtName = UIControlsFactory.createText(comonComp);
	txtName.setLayoutData(GridDataFactory.copyData(textData));
	addUIControl(txtName, BIND_ID_MEMBER_NAME);

	UIControlsFactory.createLabel(comonComp, "Farm Location"); //$NON-NLS-1$
	final Text txtFarm = UIControlsFactory.createText(comonComp, SWT.MULTI);
	final GridData data = new GridData(GridData.FILL_HORIZONTAL);
	data.heightHint = 50;
	data.horizontalSpan = 2;
	txtFarm.setLayoutData(data);
	addUIControl(txtFarm, BIND_ID_FARM_NAME);

	UIControlsFactory.createLabel(comonComp, "Request Type"); //$NON-NLS-1$
	final Button veterinaryBtn = UIControlsFactory.createButtonRadio(comonComp);
	veterinaryBtn.setText("Veterinary");
	addUIControl(veterinaryBtn, "veterinary"); //$NON-NLS-1$
	final Button inseminationBtn = UIControlsFactory.createButtonRadio(comonComp);
	inseminationBtn.setText("Insemination");
	addUIControl(inseminationBtn, "insemination"); //$NON-NLS-1$

    }

    private void createTypeSpecificControls(Group parent) {
	// "Veterinary"
	// Complaint
	specialComp = UIControlsFactory.createComposite(parent);
	specialComp.setLayout(new GridLayout(1, false));
	final GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
	specialComp.setLayoutData(data);
	this.addUIControl(specialComp, BIND_ID_SPECIFIC_CONTAINER);

    }

    private void createVeterinaryControls(Composite parent) {
	verternaryComp = UIControlsFactory.createComposite(parent);
	final GridLayout layout = new GridLayout(1, false);
	verternaryComp.setLayout(layout);
	verternaryComp.setLayoutData(new GridData(GridData.FILL_BOTH));

	UIControlsFactory.createLabel(verternaryComp, "Complaint");
	final Text complaintText = UIControlsFactory.createText(verternaryComp);
	final GridData data = new GridData(GridData.FILL_HORIZONTAL);
	data.heightHint = 100;
	data.widthHint = 300;
	parent.getParent().layout(true);
	complaintText.setLayoutData(data);
	this.addUIControl(complaintText, BIND_ID_VERY_THIRD_COMPLAINT);

    }

    private void createInseminationControls(Composite parent) {

	inseminationComp = UIControlsFactory.createComposite(parent);
	inseminationComp.setLayout(GridLayoutFactory.swtDefaults().margins(0, 0).create());
	GridDataFactory.fillDefaults().grab(true, true).applyTo(inseminationComp);
	this.addUIControl(inseminationComp, "insemination-comp");

	inseminationGroup = UIControlsFactory.createGroup(inseminationComp, "Request Details");
	final GridLayout layout = new GridLayout(3, false);
	inseminationGroup.setLayout(layout);
	GridDataFactory.fillDefaults().grab(true, true).applyTo(inseminationGroup);

	UIControlsFactory.createLabel(inseminationGroup, "Time Heat Detected"); //$NON-NLS-1$
	final Text txtDate = UIControlsFactory.createText(inseminationGroup);
	final GridData dateData = new GridData(GridData.FILL_HORIZONTAL);
	dateData.horizontalSpan = 1;
	txtDate.setLayoutData(dateData);
	addUIControl(txtDate, BIND_ID_INSE_TIME_HEATED_DETECTED);

	// Calendar Button
	final Button button = new Button(inseminationGroup, SWT.PUSH);
	final Image calendar = Activator.getImage(ImageRegistry.calendar);
	button.setImage(calendar);
	GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(button);
	// Insemination
	final Label insemLabel = UIControlsFactory.createLabel(inseminationGroup, "Insemination"); //$NON-NLS-1$
	GridDataFactory.fillDefaults().span(3, 1).applyTo(insemLabel);

	final GridDataFactory textGridFactory = GridDataFactory.fillDefaults().span(2, 1);
	final GridDataFactory indentGridFactory = GridDataFactory.fillDefaults().indent(10, 0);
	// First
	final Label firstLabel = UIControlsFactory.createLabel(inseminationGroup, "First"); //$NON-NLS-1$
	indentGridFactory.applyTo(firstLabel);

	final Text firstText = UIControlsFactory.createText(inseminationGroup);

	textGridFactory.applyTo(firstText);
	addUIControl(firstText, BIND_ID_INSE_FIRST_TRETMENT);

	// First Repeat
	final Label firstRepeatLabel = UIControlsFactory.createLabel(inseminationGroup, "First Repeat"); //$NON-NLS-1$
	indentGridFactory.applyTo(firstRepeatLabel);

	final Text firstRepeatText = UIControlsFactory.createText(inseminationGroup);
	textGridFactory.applyTo(firstRepeatText);
	addUIControl(firstRepeatText, BIND_ID_INSE_SECOND_TRETMENT);

	// 2nd Repeat
	final Label secondRepeatLabel = UIControlsFactory.createLabel(inseminationGroup, "2nd Repeat"); //$NON-NLS-1$
	indentGridFactory.applyTo(secondRepeatLabel);

	final Text secondRepeatText = UIControlsFactory.createText(inseminationGroup);
	textGridFactory.applyTo(secondRepeatText);

	addUIControl(secondRepeatText, BIND_ID_INSE_THIRD_TRETMENT);
    }

    @Override
    protected int getDetailsStyle() {
	return SWT.None;
    }

    public void updateUI(AnimalHealthRequest request) {

	final boolean isVeterinary = RequestType.VETERINARY.equals(request.getType());

	// If type doesn't change,we didn't need to do anything here
	if (request.getType().equals(this.previousType)) {
	    return;
	}
	ServiceUtils.disposeAllChildrens(this.specialComp);
	if (isVeterinary) {
	    // Create veterinaryControls
	    createVeterinaryControls(specialComp);
	} else {
	    createInseminationControls(specialComp);
	}
	this.getParent().layout(true, true);
	this.previousType = request.getType();
	this.getTable().forceFocus();
	this.getTable().showSelection();
	this.getTable().select(this.getTable().getSelectionIndex());

    }

    /**
     * Get type specific container composite
     * 
     * @return
     */
    public Composite getTypeSpecialComposite() {
	return this.specialComp;
    }
}
