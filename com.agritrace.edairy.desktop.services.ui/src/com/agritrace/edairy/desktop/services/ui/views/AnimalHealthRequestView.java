package com.agritrace.edairy.desktop.services.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.DatePickerComposite;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.services.ui.Activator;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.RowData;

/**
 * Service request view
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class AnimalHealthRequestView extends AbstractDirectoryView {
	// public static final String START_DATE_BUTTON = "start.date.button";
	public static final String END_DATE_TEXT = "end.date.text";
	// public static final String END_DATE_BUTTON = "end.date.button";

	public static final String FARM_LOOKUP_BUTTON = "filter.farm.button";

	public static final String FARM_LOOKUP_TEXT = "filter.farm.text";
	public static final String ID = "animalhealth.services.edit.view";
	public static final String MEMBER_LOOKUP_BUTTON = "filter.member.button";
	public static final String MEMBER_LOOKUP_TEXT = "filter.member.text";
	/**
	 * Binding ID for All Request Types Radio Button Binding ID
	 */
	public static final String REQUEST_TYPE_ALL = "filter.type.all";
	/**
	 * Request Type-- Insemination Radio Button Binding ID
	 */
	public static final String REQUEST_TYPE_INSEMINATION = "filter.type.insemination";
	/**
	 * Binding ID for Request Type-- VERTERNARY Radio Button Binding ID
	 */
	public static final String REQUEST_TYPE_VERTERNARY = "filter.type.veterinary";
	public static final String START_DATE_TEXT = "start.date.text";
	private Composite comp_1;
	public AnimalHealthRequestView() {
	}

	private void configureLookupFields(Composite parent, String label, Image icon, String textBindId,
			String buttonBindId) {
		Label label_1 = UIControlsFactory.createLabel(parent, label);
		label_1.setLayoutData(new RowData(120, SWT.DEFAULT));

		// date text
		final Text textWidget = UIControlsFactory.createText(parent);
		textWidget.setLayoutData(new RowData(180, SWT.DEFAULT));
		addUIControl(textWidget, textBindId);

		// Search Button
		final ImageButton buttonWidget = UIControlsFactory.createImageButton(parent, SWT.None);
		buttonWidget.setImage(icon);
		addUIControl(buttonWidget, buttonBindId);

	}

	private void createDateRange(Composite parent) {
		final Composite composite = UIControlsFactory.createComposite(parent);
		RowLayout rl_composite = new RowLayout(SWT.HORIZONTAL);
		rl_composite.spacing = 5;
		composite.setLayout(rl_composite);
		
		// Creates Date Range control
		Label label = UIControlsFactory.createLabel(composite, "Date Range");
		label.setLayoutData(new RowData(120, SWT.DEFAULT));
		
//		final Composite startDateComp = UIControlsFactory.createComposite(parent);
		
//		final GridLayout layout = new GridLayout(3, false);
//		startDateComp.setLayout(layout);
//		GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(startDateComp);

		UIControlsFactory.createLabel(composite, "Start");
		final DatePickerComposite startDateLookup = UIControlsFactory.createDatePickerComposite(composite);
		
//		startDateLookup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		addUIControl(startDateLookup, START_DATE_TEXT);

//		final Composite endDateComp = UIControlsFactory.createComposite(parent);
//		endDateComp.setLayout(GridLayoutFactory.swtDefaults().numColumns(3).margins(0, 0).create());
//		endDateComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		UIControlsFactory.createLabel(composite, "End");
		final DatePickerComposite endDateLookup = UIControlsFactory.createDatePickerComposite(composite);
//		endDateLookup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		addUIControl(endDateLookup, END_DATE_TEXT);

	}

	@Override
	protected void createFilterConditions(Composite comp) {

		// Date Range
		createDateRange(comp);

		// Request type
		createRequestType(comp);

		createMemberFarm(comp);

	}

	private void createMemberFarm(Composite parent) {
		Composite composite = UIControlsFactory.createComposite(parent);
		RowLayout rl_composite = new RowLayout(SWT.HORIZONTAL);
		rl_composite.wrap = false;
		rl_composite.spacing = 5;
		composite.setLayout(rl_composite);

		// Configure member lookup
		configureLookupFields(composite, "Member Lookup",
				Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.MEMBER_SEARCH_ICON),
				MEMBER_LOOKUP_TEXT, MEMBER_LOOKUP_BUTTON);
		
		composite = UIControlsFactory.createComposite(parent);
		rl_composite = new RowLayout(SWT.HORIZONTAL);
		rl_composite.wrap = false;
		rl_composite.spacing = 5;
		composite.setLayout(rl_composite);
		
		// Create farm lookup
		configureLookupFields(composite, "Farm Lookup",
				Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.FARM_SEARCH_ICON), FARM_LOOKUP_TEXT,
				FARM_LOOKUP_BUTTON);

	}

	private void createRequestType(Composite parent) {
		// Request Type
		final Composite requestTypeComp = UIControlsFactory.createComposite(parent);
		RowLayout rl_requestTypeComp = new RowLayout(SWT.HORIZONTAL);
		rl_requestTypeComp.spacing = 5;
		requestTypeComp.setLayout(rl_requestTypeComp);
		Label label = UIControlsFactory.createLabel(requestTypeComp, "Request Type");
		label.setLayoutData(new RowData(120, SWT.DEFAULT));
//		final GridLayout requestTypeLayout = new GridLayout(1, false);
//		requestTypeComp.setLayout(requestTypeLayout);
//		GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(requestTypeComp);

		// Text startText = UIControlsFactory.createText(dateComp);
		// By default the start text is the beginning of current month
		UIControlsFactory.createButtonRadio(requestTypeComp, "All", REQUEST_TYPE_ALL);
		UIControlsFactory.createButtonRadio(requestTypeComp, "Veterinary", REQUEST_TYPE_VERTERNARY);
		UIControlsFactory.createButtonRadio(requestTypeComp, "Insemination", REQUEST_TYPE_INSEMINATION);
	}
}
