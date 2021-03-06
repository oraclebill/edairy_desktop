package com.agritrace.edairy.desktop.services.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.swt.DatePickerComposite;
import org.eclipse.riena.ui.swt.ImageButton;
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
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.model.requests.RequestType;
import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.services.ui.Activator;
import com.agritrace.edairy.desktop.services.ui.controllers.AnimalHealthRequestDialogController;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Service request list dialog
 *
 * @author Hui(Spark) Wan
 *
 */
public class AnimalHealthRequestDialog extends RecordDialog<AnimalHealthRequest> {
	public static final String SPECIFIC_RPEFIX = "specific.";//$NON-NLS-1$

	public static final String BIND_ID_FARM = "farm";//$NON-NLS-1$
	public static final String BIND_ID_FARM_BUTTON = "farm.lookup.button";//$NON-NLS-1$
	public static final String BIND_ID_FARM_TEXT = "farm.lookup.text";//$NON-NLS-1$
	public static final String BIND_ID_INSE_FIRST_TRETMENT = SPECIFIC_RPEFIX + "time.first.repeat";//$NON-NLS-1$
	public static final String BIND_ID_INSE_SECOND_TRETMENT = SPECIFIC_RPEFIX + "time.second.repeat";//$NON-NLS-1$
	public static final String BIND_ID_INSE_THIRD_TRETMENT = SPECIFIC_RPEFIX + "time.third.repeat";//$NON-NLS-1$
	public static final String BIND_ID_INSE_TIME_HEATED_DETECTED = SPECIFIC_RPEFIX + "time.heated.detected";//$NON-NLS-1$
	public static final String BIND_ID_MEMBER_BUTTON = "member.lookup.button";//$NON-NLS-1$
	public static final String BIND_ID_MEMBER_ID = "member.id";//$NON-NLS-1$
	public static final String BIND_ID_MEMBER_NAME = "member.name";//$NON-NLS-1$
	public static final String BIND_ID_MEMBER_TEXT = "member.lookup.text";//$NON-NLS-1$
	public static final String BIND_ID_REQUEST_DATE_BUTTON = "request.date.button";//$NON-NLS-1$
	public static final String BIND_ID_REQUEST_DATE_TEXT = "request.date.text";//$NON-NLS-1$
	public static final String BIND_ID_SPECIFIC_CONTAINER = "specific.container";//$NON-NLS-1$
	public static final String BIND_ID_VERY_THIRD_COMPLAINT = SPECIFIC_RPEFIX + "complaint";//$NON-NLS-1$
	private Composite comp;
	private final List<Object> injectedControls = new ArrayList<Object>();
	private Composite inseminationComp;
	private Group inseminationGroup;
	private RequestType previousType;
	private Composite specialComp;
	private Composite verternaryComp;

	@Inject
	public AnimalHealthRequestDialog(@Named("current") final Shell parentShell,
			final AnimalHealthRequestDialogController controller) {
		super(parentShell, controller);
		controller.addListener(new IActionListener() {
			@Override
			public void callback() {
				Display.getDefault().syncExec(new Runnable() {
					@Override
					public void run() {
						updateTypeSpecificControlls(controller.getWorkingCopy().getType());
					}
				});
			}
		});
	}

	public void updateUI(RequestType type) {

		final boolean isVeterinary = RequestType.CLINICAL.equals(type);

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

	private void configureLookupFields(Composite parent, String label, Image icon, String textBindId,
			String buttonBindId) {
		UIControlsFactory.createLabel(parent, label);

		// date text
		final Text textWidget = UIControlsFactory.createText(parent);
		textWidget.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		addUIControl(textWidget, textBindId);

		// Search Button
		final ImageButton buttonWidget = UIControlsFactory.createImageButton(parent, SWT.None);
		buttonWidget.setImage(icon);
		addUIControl(buttonWidget, buttonBindId);

	}

	private void createCommonControls(Composite parent) {
		final Composite commonComp = UIControlsFactory.createComposite(parent);
		commonComp.setLayout(new GridLayout(3, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(commonComp);

		// Create Start Date lookup
		// LookupComposite startDateLookup = new LookupComposite("Date",
		// Activator.getDefault().getImageRegistry()
		// .get(Activator.CALENDAR_ICON), BIND_ID_REQUEST_DATE_TEXT,
		// BIND_ID_REQUEST_DATE_BUTTON);
		// startDateLookup.createSection(comonComp);

		UIControlsFactory.createLabel(commonComp, "Date");
		final DateTime startDateLookup = UIControlsFactory.createDate(commonComp, SWT.DEFAULT);
		startDateLookup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		addUIControl(startDateLookup, BIND_ID_REQUEST_DATE_TEXT);
		UIControlsFactory.createLabel(commonComp, ""); // filler

		// Create member lookup
		configureLookupFields(commonComp, "Member",
				Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.MEMBER_SEARCH_ICON),
				BIND_ID_MEMBER_TEXT, BIND_ID_MEMBER_BUTTON);

		// Create farm lookup
		configureLookupFields(commonComp, "Farm",
				Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.FARM_SEARCH_ICON),
				BIND_ID_FARM_TEXT, BIND_ID_FARM_BUTTON);

		UIControlsFactory.createLabel(commonComp, "Request Type"); //$NON-NLS-1$
		final Composite typeComposite = UIControlsFactory.createComposite(commonComp);
		GridLayoutFactory.swtDefaults().numColumns(2).margins(0, 0).applyTo(typeComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).span(2, 1)
				.applyTo(typeComposite);

		final Button veterinaryBtn = UIControlsFactory.createButtonRadio(typeComposite);
		veterinaryBtn.setText("Clinical");
		addUIControl(veterinaryBtn, "veterinary"); //$NON-NLS-1$
		veterinaryBtn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				updateTypeSpecificControlls(RequestType.CLINICAL);

			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateTypeSpecificControlls(RequestType.CLINICAL);
			}
		});
		final Button inseminationBtn = UIControlsFactory.createButtonRadio(typeComposite);
		inseminationBtn.setText("Insemination");
		addUIControl(inseminationBtn, "insemination"); //$NON-NLS-1$
		inseminationBtn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				updateTypeSpecificControlls(RequestType.INSEMINATION);

			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateTypeSpecificControlls(RequestType.INSEMINATION);
			}
		});

	}

	private void createInseminationControls(Composite parent) {

		inseminationComp = UIControlsFactory.createComposite(parent);
		inseminationComp.setLayout(GridLayoutFactory.swtDefaults().margins(0, 0).create());
		GridDataFactory.fillDefaults().grab(true, true).applyTo(inseminationComp);
		this.addUIControl(inseminationComp, "insemination-comp");
		injectedControls.add(inseminationComp);

		inseminationGroup = UIControlsFactory.createGroup(inseminationComp, "Request Details");
		final GridLayout layout = new GridLayout(2, false);
		inseminationGroup.setLayout(layout);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(inseminationGroup);

		UIControlsFactory.createLabel(inseminationGroup, "Time Heat Detected"); //$NON-NLS-1$
		final DatePickerComposite txtDate = UIControlsFactory.createDatePickerComposite(inseminationGroup);
		txtDate.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		addUIControl(txtDate, BIND_ID_INSE_TIME_HEATED_DETECTED);
		injectedControls.add(txtDate);

		// Insemination
		final Label insemLabel = UIControlsFactory.createLabel(inseminationGroup, "Insemination"); //$NON-NLS-1$
		GridDataFactory.fillDefaults().span(2, 1).applyTo(insemLabel);

		GridDataFactory.fillDefaults().span(1, 1);
		final GridDataFactory indentGridFactory = GridDataFactory.fillDefaults().indent(10, 0);
		// First
		final Label firstLabel = UIControlsFactory.createLabel(inseminationGroup, "First"); //$NON-NLS-1$
		indentGridFactory.applyTo(firstLabel);

		// First Date
		final DatePickerComposite firstTextDate = UIControlsFactory.createDatePickerComposite(inseminationGroup);
		firstTextDate.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		addUIControl(firstTextDate, BIND_ID_INSE_FIRST_TRETMENT);
		injectedControls.add(firstTextDate);

		// First Repeat
		final Label firstRepeatLabel = UIControlsFactory.createLabel(inseminationGroup, "First Repeat"); //$NON-NLS-1$
		indentGridFactory.applyTo(firstRepeatLabel);
		// First repeat Date
		final DatePickerComposite firstRepeatText = UIControlsFactory.createDatePickerComposite(inseminationGroup);
		firstRepeatText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		addUIControl(firstRepeatText, BIND_ID_INSE_SECOND_TRETMENT);
		injectedControls.add(firstRepeatText);

		// 2nd Repeat
		final Label secondRepeatLabel = UIControlsFactory.createLabel(inseminationGroup, "2nd Repeat"); //$NON-NLS-1$
		indentGridFactory.applyTo(secondRepeatLabel);

		final DatePickerComposite secondRepeatText = UIControlsFactory.createDatePickerComposite(inseminationGroup);
		secondRepeatText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		addUIControl(secondRepeatText, BIND_ID_INSE_THIRD_TRETMENT);
		injectedControls.add(secondRepeatText);
	}

	private void createTypeSpecificControls(Composite comp) {
		// "Veterinary"
		// Complaint
		specialComp = UIControlsFactory.createComposite(comp);
		specialComp.setLayout(new GridLayout(1, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(specialComp);
		this.addUIControl(specialComp, BIND_ID_SPECIFIC_CONTAINER);
		// updateTypeSpecificControlls(RequestType.VETERINARY);
	}

	private void createVeterinaryControls(Composite parent) {
		verternaryComp = UIControlsFactory.createComposite(parent);
		final GridLayout layout = new GridLayout(1, false);
		verternaryComp.setLayout(layout);
		verternaryComp.setLayoutData(new GridData(GridData.FILL_BOTH));

		UIControlsFactory.createLabel(verternaryComp, "Complaint");
		final Text complaintText = UIControlsFactory.createText(verternaryComp, SWT.MULTI);
		final GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.heightHint = 100;
		data.widthHint = 300;
		parent.getParent().layout(true);
		complaintText.setLayoutData(data);
		this.addUIControl(complaintText, BIND_ID_VERY_THIRD_COMPLAINT);
		injectedControls.add(complaintText);

	}

	@Override
	protected void buildWorkArea(Composite comp) {

		// Create common controls
		createCommonControls(comp);
		this.comp = comp;
		// Create specific controls
		createTypeSpecificControls(comp);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		if (this.getActionType() == AbstractDirectoryController.ACTION_NEW) {
			this.setTitle("Add Service Request");
		} else if (this.getActionType() == AbstractDirectoryController.ACTION_VIEW) {
			this.setTitle("View Service Request");
		} else {
			this.setTitle("Edit Service Request");
		}
		this.setShellStyle(SWT.RESIZE | SWT.CLOSE | SWT.TITLE);
		newShell.setSize(340, 380);
		newShell.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
	}

	protected void updateTypeSpecificControlls(RequestType type) {
		updateUI(type);
		// SwtRidgetFactory.
		RidgetUtils.injectRidgets(Activator.getDefault().getBundle().getBundleContext(), getController(),
				injectedControls, SWTBindingPropertyLocator.getInstance());
	}

}
