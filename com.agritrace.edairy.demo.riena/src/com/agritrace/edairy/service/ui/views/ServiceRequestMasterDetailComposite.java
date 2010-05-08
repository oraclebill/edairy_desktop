package com.agritrace.edairy.service.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

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
	public static final String INSE_TIME_HEATED_DETECTED = "time_heated_detected";//$NON-NLS-1$

	public ServiceRequestMasterDetailComposite(Composite parent, int style) {
		super(parent, style);
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	@Override
	protected Table createTable(Composite tableComposite,
			TableColumnLayout layout) {

		Table table = super.createTable(tableComposite, layout);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessVerticalSpace = true;
		tableComposite.setLayoutData(data);
		tableComposite.setLayoutData(GridDataFactory.copyData(data));
		tableComposite.setLayout(layout);
		return table;
	}

	@Override
	protected void createDetails(Composite parent) {

		// Since the master/detail are not in same composite
		Composite grand = this.getParent();
		GridLayoutFactory.fillDefaults().numColumns(2).margins(20, 20).spacing(
				10, 10).equalWidth(false).applyTo(parent);
		GridData data = new GridData();
		data.heightHint = 0;
		parent.setLayoutData(data);

		GridDataFactory.fillDefaults().grab(true, false);

		createDetailscontrol(grand);
	}

	private void createDetailscontrol(Composite parent) {
		Group detailGroup = UIControlsFactory.createGroup(parent,
				"Request Detail");
		GridLayout groupLayout = new GridLayout();
		groupLayout.numColumns = 2;
		detailGroup.setLayout(groupLayout);

		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.horizontalSpan = 2;
		detailGroup.setLayoutData(data);
		detailGroup.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));
		// Create common controls
		createCommonControls(detailGroup);
		// Create specific controls
		createSpecificControls(detailGroup);

	}

	private void createCommonControls(Composite parent) {
		Composite comonComp = UIControlsFactory.createComposite(parent);
		comonComp.setLayout(new GridLayout(3, false));

		UIControlsFactory.createLabel(comonComp, "Date"); //$NON-NLS-1$
		Text txtDate = UIControlsFactory.createText(comonComp);
		GridData dateData = new GridData();
		dateData.horizontalSpan = 1;
		txtDate.setLayoutData(dateData);
		addUIControl(txtDate, "date"); //$NON-NLS-1$

		ImageButton button = UIControlsFactory.createImageButton(comonComp,
				SWT.None);

		UIControlsFactory.createLabel(comonComp, "Member ID"); //$NON-NLS-1$
		Text txtID = UIControlsFactory.createText(comonComp);
		GridData textData = new GridData(GridData.FILL_HORIZONTAL);
		textData.horizontalSpan = 2;
		txtID.setLayoutData(textData);
		addUIControl(txtID, "id"); //$NON-NLS-1$

		UIControlsFactory.createLabel(comonComp, "Member Name"); //$NON-NLS-1$
		Text txtName = UIControlsFactory.createText(comonComp);
		txtName.setLayoutData(GridDataFactory.copyData(textData));
		addUIControl(txtName, "name"); //$NON-NLS-1$

		UIControlsFactory.createLabel(comonComp, "Farm Location"); //$NON-NLS-1$
		Text txtFarm = UIControlsFactory.createText(comonComp, SWT.MULTI);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.heightHint = 50;
		data.horizontalSpan = 2;
		txtFarm.setLayoutData(data);
		addUIControl(txtFarm, "farm"); //$NON-NLS-1$

		UIControlsFactory.createLabel(comonComp, "Request Type"); //$NON-NLS-1$
		Button veterinaryBtn = UIControlsFactory.createButtonRadio(comonComp);
		veterinaryBtn.setText("Veterinary");
		addUIControl(veterinaryBtn, "veterinary"); //$NON-NLS-1$
		Button inseminationBtn = UIControlsFactory.createButtonRadio(comonComp);
		inseminationBtn.setText("Insemination");
		addUIControl(inseminationBtn, "insemination"); //$NON-NLS-1$

	}

	private void createSpecificControls(Group parent) {
		// "Veterinary"
		// Complaint
		specialComp = UIControlsFactory.createComposite(parent);
		specialComp.setLayout(new GridLayout(1, false));
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		specialComp.setLayoutData(data);
		this.addUIControl(specialComp, "sepcialcomp"); //$NON-NLS-1$		

	}

	private void createInseminationControls(Composite parent) {

		Group group = UIControlsFactory.createGroup(parent, "Request Details");
		GridLayout layout = new GridLayout(3, false);
		group.setLayout(layout);
		group.setLayoutData(new GridData(GridData.FILL_BOTH));
		this.addUIControl(group, "insemination-group");

		UIControlsFactory.createLabel(group, "Time Heat Detected"); //$NON-NLS-1$
		Text txtDate = UIControlsFactory.createText(group);
		GridData dateData = new GridData(GridData.FILL_HORIZONTAL);
		dateData.horizontalSpan = 1;
		txtDate.setLayoutData(dateData);
		addUIControl(txtDate, INSE_TIME_HEATED_DETECTED); 
		ImageButton button = UIControlsFactory.createImageButton(group,
				SWT.None);

		// Insemination
		Label insemLabel = UIControlsFactory.createLabel(group, "Insemination"); //$NON-NLS-1$
		GridDataFactory.fillDefaults().span(3, 1).applyTo(insemLabel);

		GridDataFactory textGridFactory = GridDataFactory.fillDefaults().span(
				2, 1);
		GridDataFactory indentGridFactory = GridDataFactory.fillDefaults()
				.indent(10, 0);
		// First
		Label firstLabel = UIControlsFactory.createLabel(group, "First"); //$NON-NLS-1$
		indentGridFactory.applyTo(firstLabel);

		Text firstText = UIControlsFactory.createText(group); 
		textGridFactory.applyTo(firstText);

		// First Repeat
		Label firstRepeatLabel = UIControlsFactory.createLabel(group,
				"First Repeat"); //$NON-NLS-1$
		indentGridFactory.applyTo(firstRepeatLabel);

		Text firstRepeatText = UIControlsFactory.createText(group); 
		textGridFactory.applyTo(firstRepeatText);

		// 2nd Repeat
		Label secondRepeatLabel = UIControlsFactory.createLabel(group,
				"2nd Repeat"); //$NON-NLS-1$
		indentGridFactory.applyTo(secondRepeatLabel);

		Text secondRepeatText = UIControlsFactory.createText(group); 
		textGridFactory.applyTo(secondRepeatText);
	}

	private void createVeterinaryControls(Composite parent) {
		Group group = UIControlsFactory.createGroup(parent, "");
		GridLayout layout = new GridLayout(1, false);
		group.setLayout(layout);
		group.setLayoutData(new GridData(GridData.FILL_BOTH));
		this.addUIControl(group, "veterinary-group");

		UIControlsFactory.createLabel(group, "Complaint");
		Text complaintText = UIControlsFactory.createText(group);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.heightHint = 100;
		data.widthHint = 300;
		parent.getParent().layout(true);
		complaintText.setLayoutData(data);
		this.addUIControl(complaintText, "complaint");

	}

	@Override
	protected int getDetailsStyle() {
		return SWT.None;
	}

	public void typeChanged(AnimalHealthRequest request) {

		boolean isVeterinary = RequestType.VETERINARY.equals(request.getType());

		if (isVeterinary) {
			// Create veterinaryControls
			disposeAllChildrens(this.specialComp);
			createVeterinaryControls(specialComp); //);
			specialComp.pack(true);

		} else {
			disposeAllChildrens(specialComp);
			createInseminationControls(specialComp);
			specialComp.pack(true);
		}

	}

	private void disposeAllChildrens(Composite comp) {
		for (Control control : comp.getChildren()) {
			if (control instanceof Composite) {
				disposeAllChildrens((Composite) control);

			}
			if (!control.isDisposed()) {
				control.dispose();
			}
		}
	}

}
