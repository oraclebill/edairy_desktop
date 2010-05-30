package com.agritrace.edairy.desktop.services.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.requests.RequestType;
import com.agritrace.edairy.desktop.common.ui.ImageRegistry;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractRecordListController;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controls.LookupComposite;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.common.ui.util.RidgetUtils;
import com.agritrace.edairy.desktop.services.ui.Activator;
import com.agritrace.edairy.desktop.services.ui.controllers.ServiceRecordDialogController;
//import com.agritrace.edairy.desktop.services.ui.controllers.ServiceRecordDialogController;

/**
 * Service request list dialog
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceRequestListDialog extends RecordDialog {
	private Composite specialComp;
	private Group inseminationGroup;
	private Composite verternaryComp;
	private Composite inseminationComp;
	private RequestType previousType;
	private Composite comp;
	public static final String SPECIFIC_RPEFIX = "specific.";//$NON-NLS-1$
	public static final String BIND_ID_INSE_TIME_HEATED_DETECTED = SPECIFIC_RPEFIX
			+ "time.heated.detected";//$NON-NLS-1$
	public static final String BIND_ID_INSE_FIRST_TRETMENT = SPECIFIC_RPEFIX
			+ "time.first.repeat";//$NON-NLS-1$
	public static final String BIND_ID_INSE_SECOND_TRETMENT = SPECIFIC_RPEFIX
			+ "time.second.repeat";//$NON-NLS-1$
	public static final String BIND_ID_INSE_THIRD_TRETMENT = SPECIFIC_RPEFIX
			+ "time.third.repeat";//$NON-NLS-1$
	public static final String BIND_ID_VERY_THIRD_COMPLAINT = SPECIFIC_RPEFIX
			+ "complaint";//$NON-NLS-1$
	public static final String BIND_ID_REQUEST_DATE_TEXT = "request.date.text";//$NON-NLS-1$
	public static final String BIND_ID_REQUEST_DATE_BUTTON = "request.date.button";//$NON-NLS-1$
	public static final String BIND_ID_MEMBER_TEXT = "member.lookup.text";//$NON-NLS-1$
	public static final String BIND_ID_MEMBER_BUTTON = "member.lookup.button";//$NON-NLS-1$
	public static final String BIND_ID_FARM_TEXT = "farm.lookup.text";//$NON-NLS-1$
	public static final String BIND_ID_FARM_BUTTON = "farm.lookup.button";//$NON-NLS-1$
	public static final String BIND_ID_MEMBER_NAME = "member.name";//$NON-NLS-1$
	public static final String BIND_ID_MEMBER_ID = "member.id";//$NON-NLS-1$
	public static final String BIND_ID_FARM = "farm";//$NON-NLS-1$
	public static final String BIND_ID_SPECIFIC_CONTAINER = "specific.container";//$NON-NLS-1$
	private List<Object> injectedControls = new ArrayList<Object>();

	public ServiceRequestListDialog(int style, Shell parentShell,
			EObject selectedEObject) {
		super(style, parentShell, selectedEObject);

	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		if (this.getActionType() == AbstractRecordListController.ACTION_NEW) {
			this.setTitle("Add Service Request");
		} else if (this.getActionType() == AbstractRecordListController.ACTION_VIEW) {
			this.setTitle("View Service Request");
		} else {
			this.setTitle("Edit Service Request");
		}
		this.setShellStyle(SWT.RESIZE | SWT.CLOSE | SWT.TITLE);
		newShell.setSize(340, 380);
		newShell.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));
	}

	@Override
	protected void createUIComponent(Composite comp) {

		// Create common controls
		createCommonControls(comp);
		this.comp = comp;
		// Create specific controls
		createTypeSpecificControls(comp);
	}

	private void createTypeSpecificControls(Composite comp) {
		// "Veterinary"
		// Complaint
		specialComp = UIControlsFactory.createComposite(comp);
		specialComp.setLayout(new GridLayout(1, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).applyTo(specialComp);
		this.addUIControl(specialComp, BIND_ID_SPECIFIC_CONTAINER); //$NON-NLS-1$	
	}

	private void createCommonControls(Composite parent) {
		Composite comonComp = UIControlsFactory.createComposite(parent);
		comonComp.setLayout(new GridLayout(3, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true,
				false).applyTo(comonComp);

		// Create Start Date lookup
		LookupComposite startDateLookup = new LookupComposite("Date", Activator
				.getDefault().getImageRegistry().get(Activator.CALENDAR_ICON),
				BIND_ID_REQUEST_DATE_TEXT, BIND_ID_REQUEST_DATE_BUTTON);
		startDateLookup.createSection(comonComp);

		// UIControlsFactory.createLabel(comonComp, "Date");
		// Composite dateComposte =
		// UIControlsFactory.createComposite(comonComp);
		// dateComposte.setLayout(GridLayoutFactory.swtDefaults().numColumns(2)
		// .margins(0, 0).create());
		//
		// GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(
		// true, false).span(2, 1).applyTo(dateComposte);
		//
		// Text txtDate = UIControlsFactory.createText(dateComposte);
		// GridData dateData = new GridData(GridData.FILL_HORIZONTAL);
		// dateData.horizontalSpan = 1;
		// dateData.grabExcessHorizontalSpace = true;
		// txtDate.setLayoutData(dateData);
		//		addUIControl(txtDate, BIND_ID_REQUEST_DATE); //$NON-NLS-1$

		// Button button = new Button(dateComposte, SWT.PUSH);
		// Image calendar = Activator.getImage(ImageRegistry.calendar);
		// button.setImage(calendar);
		// GridDataFactory.swtDefaults().align(SWT.BEGINNING,
		// SWT.BEGINNING).hint(
		// 17, 16).applyTo(button);

		//		UIControlsFactory.createLabel(comonComp, "Member Lookup"); //$NON-NLS-1$
		// Text memberLookupText = UIControlsFactory.createText(comonComp);
		// GridData memberLookupData = new GridData(GridData.FILL_HORIZONTAL);
		// memberLookupData.horizontalSpan = 2;
		// memberLookupText.setLayoutData(memberLookupData);
		//		addUIControl(memberLookupText, BIND_ID_MEMBER_LOOKUP); //$NON-NLS-1$
		//
		//		UIControlsFactory.createLabel(comonComp, "Member ID"); //$NON-NLS-1$
		// Text txtID = UIControlsFactory.createText(comonComp);
		// GridData textData = new GridData(GridData.FILL_HORIZONTAL);
		// textData.horizontalSpan = 2;
		// txtID.setLayoutData(textData);
		//		addUIControl(txtID, BIND_ID_MEMBER_ID); //$NON-NLS-1$
		//
		//		UIControlsFactory.createLabel(comonComp, "Member Name"); //$NON-NLS-1$
		// Text txtName = UIControlsFactory.createText(comonComp);
		// txtName.setLayoutData(GridDataFactory.copyData(textData));
		//		addUIControl(txtName, BIND_ID_MEMBER_NAME); //$NON-NLS-1$
		//
		//		UIControlsFactory.createLabel(comonComp, "Farm"); //$NON-NLS-1$
		// // Text txtFarm = UIControlsFactory.createText(comonComp, SWT.MULTI);
		// // GridData data = new GridData(GridData.FILL_HORIZONTAL);
		// // data.heightHint = 50;
		// // data.horizontalSpan = 2;
		// // txtFarm.setLayoutData(data);
		//		//		addUIControl(txtFarm, BIND_ID_FARM_NAME); //$NON-NLS-1$
		//
		// Combo farmCombo = UIControlsFactory.createCombo(comonComp);
		// // //GridDataFactory.swtDefaults().grab(true,
		// false).span(2,1).applyTo(farmCombo);
		// // GridData data = new GridData(GridData.FILL_HORIZONTAL);
		// // data.horizontalSpan =2;
		// // farmCombo.setLayoutData(data);
		// GridDataFactory.swtDefaults().align(SWT.FILL,
		// SWT.BEGINNING).grab(true, false).span(2,1).applyTo(farmCombo);
		// addUIControl(farmCombo, BIND_ID_FARM);

		// Create farm lookup
		LookupComposite farmLookup = new LookupComposite("Farm", Activator
				.getDefault().getImageRegistry()
				.get(Activator.FARM_SEARCH_ICON), BIND_ID_FARM_TEXT,
				BIND_ID_FARM_BUTTON);
		farmLookup.createSection(comonComp);
		// Create member lookup
		LookupComposite memberLookup = new LookupComposite("Member", Activator
				.getDefault().getImageRegistry()
				.get(Activator.MEMBER_SEARCH_ICON), BIND_ID_MEMBER_TEXT,
				BIND_ID_MEMBER_BUTTON);
		memberLookup.createSection(comonComp);

		UIControlsFactory.createLabel(comonComp, "Request Type"); //$NON-NLS-1$
		Composite typeComposite = UIControlsFactory.createComposite(comonComp);
		GridLayoutFactory.swtDefaults().numColumns(2).margins(0, 0).applyTo(
				typeComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true,
				false).span(2, 1).applyTo(typeComposite);

		Button veterinaryBtn = UIControlsFactory
				.createButtonRadio(typeComposite);
		veterinaryBtn.setText("Veterinary");
		addUIControl(veterinaryBtn, "veterinary"); //$NON-NLS-1$
		veterinaryBtn.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateTypeSpecificControlls(RequestType.VETERINARY);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				updateTypeSpecificControlls(RequestType.VETERINARY);
				
			}});
		Button inseminationBtn = UIControlsFactory
				.createButtonRadio(typeComposite);
		inseminationBtn.setText("Insemination");
		addUIControl(inseminationBtn, "insemination"); //$NON-NLS-1$
		inseminationBtn.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateTypeSpecificControlls(RequestType.INSEMINATION);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				updateTypeSpecificControlls(RequestType.INSEMINATION);
				
			}});

	}
	
	protected  void updateTypeSpecificControlls(RequestType type)
	{
		updateUI(type);
		// SwtRidgetFactory.
		RidgetUtils.injectRidgets(Activator.getDefault().getBundle()
				.getBundleContext(), getController(), injectedControls,
				SWTBindingPropertyLocator.getInstance());
	}

	@Override
	protected AbstractWindowController createController() {
		RecordDialogController controller = new ServiceRecordDialogController() ;
//		controller.addListener(new IActionListener() {
//
//			@Override
//			public void callback() {
//				if (getSelectedEObject()!=null)
// {
//					EMFUtil.copy(getWorkingCopy(), getSelectedEObject(), 3);
//				}
//
//			}
//		});
		return controller;
	}

	public void updateUI(RequestType type) {

		boolean isVeterinary = RequestType.VETERINARY.equals(type);

		// If type doesn't change,we didn't need to do anything here
		if (type.equals(this.previousType)) {
			return;
		}
		DateTimeUtils.disposeAllChildrens(this.specialComp);
		if (isVeterinary) {
			// Create veterinaryControls
			createVeterinaryControls(specialComp);
		} else {
			createInseminationControls(specialComp);
		}
		this.comp.layout(true, true);
		// this.comp.getParent().layout(true,true);
		this.previousType = type;

	}

	private void createVeterinaryControls(Composite parent) {
		verternaryComp = UIControlsFactory.createComposite(parent);
		GridLayout layout = new GridLayout(1, false);
		verternaryComp.setLayout(layout);
		verternaryComp.setLayoutData(new GridData(GridData.FILL_BOTH));

		UIControlsFactory.createLabel(verternaryComp, "Complaint");
		Text complaintText = UIControlsFactory.createText(verternaryComp);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.heightHint = 100;
		data.widthHint = 300;
		parent.getParent().layout(true);
		complaintText.setLayoutData(data);
		this.addUIControl(complaintText, BIND_ID_VERY_THIRD_COMPLAINT);
		injectedControls.add(complaintText);

	}

	private void createInseminationControls(Composite parent) {

		inseminationComp = UIControlsFactory.createComposite(parent);
		inseminationComp.setLayout(GridLayoutFactory.swtDefaults()
				.margins(0, 0).create());
		GridDataFactory.fillDefaults().grab(true, true).applyTo(
				inseminationComp);
		this.addUIControl(inseminationComp, "insemination-comp");
		injectedControls.add(inseminationComp);

		inseminationGroup = UIControlsFactory.createGroup(inseminationComp,
				"Request Details");
		GridLayout layout = new GridLayout(3, false);
		inseminationGroup.setLayout(layout);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(
				inseminationGroup);

		UIControlsFactory.createLabel(inseminationGroup, "Time Heat Detected"); //$NON-NLS-1$
		Text txtDate = UIControlsFactory.createText(inseminationGroup);
		GridData dateData = new GridData(GridData.FILL_HORIZONTAL);
		dateData.horizontalSpan = 1;
		txtDate.setLayoutData(dateData);
		addUIControl(txtDate, BIND_ID_INSE_TIME_HEATED_DETECTED);
		injectedControls.add(txtDate);

		// Calendar Button
		Button button = new Button(inseminationGroup, SWT.PUSH);
		Image calendar = Activator.getImage(ImageRegistry.calendar);
		button.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(
				17, 16).applyTo(button);
		// Insemination
		Label insemLabel = UIControlsFactory.createLabel(inseminationGroup,
				"Insemination"); //$NON-NLS-1$
		GridDataFactory.fillDefaults().span(3, 1).applyTo(insemLabel);

		GridDataFactory textGridFactory = GridDataFactory.fillDefaults().span(
				2, 1);
		GridDataFactory indentGridFactory = GridDataFactory.fillDefaults()
				.indent(10, 0);
		// First
		Label firstLabel = UIControlsFactory.createLabel(inseminationGroup,
				"First"); //$NON-NLS-1$
		indentGridFactory.applyTo(firstLabel);

		Text firstText = UIControlsFactory.createText(inseminationGroup);

		textGridFactory.applyTo(firstText);
		addUIControl(firstText, BIND_ID_INSE_FIRST_TRETMENT);
		injectedControls.add(firstText);

		// First Repeat
		Label firstRepeatLabel = UIControlsFactory.createLabel(
				inseminationGroup, "First Repeat"); //$NON-NLS-1$
		indentGridFactory.applyTo(firstRepeatLabel);

		Text firstRepeatText = UIControlsFactory.createText(inseminationGroup);
		textGridFactory.applyTo(firstRepeatText);
		addUIControl(firstRepeatText, BIND_ID_INSE_SECOND_TRETMENT);
		injectedControls.add(firstRepeatText);

		// 2nd Repeat
		Label secondRepeatLabel = UIControlsFactory.createLabel(
				inseminationGroup, "2nd Repeat"); //$NON-NLS-1$
		indentGridFactory.applyTo(secondRepeatLabel);

		Text secondRepeatText = UIControlsFactory.createText(inseminationGroup);
		textGridFactory.applyTo(secondRepeatText);

		addUIControl(secondRepeatText, BIND_ID_INSE_THIRD_TRETMENT);
		injectedControls.add(secondRepeatText);
	}
}
