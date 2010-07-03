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

	private void createDateRange(Composite parent) {
		// Creates Date Range control
		UIControlsFactory.createLabel(parent, "Date Range");
		final Composite startDateComp = UIControlsFactory.createComposite(parent);
		final GridLayout layout = new GridLayout(3, false);
		startDateComp.setLayout(layout);
		GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(startDateComp);

		UIControlsFactory.createLabel(startDateComp, "Start");
		final DatePickerComposite startDateLookup = UIControlsFactory.createDatePickerComposite(startDateComp);
		startDateLookup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		addUIControl(startDateLookup, START_DATE_TEXT);

		final Composite endDateComp = UIControlsFactory.createComposite(parent);
		endDateComp.setLayout(GridLayoutFactory.swtDefaults().numColumns(3).margins(0, 0).create());
		endDateComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		UIControlsFactory.createLabel(endDateComp, "End");
		final DatePickerComposite endDateLookup = UIControlsFactory.createDatePickerComposite(endDateComp);
		endDateLookup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		addUIControl(endDateLookup, END_DATE_TEXT);

	}

	private void createMemberFarm(Composite parent) {
		final Composite comp = UIControlsFactory.createComposite(parent);
		comp.setLayout(GridLayoutFactory.swtDefaults().margins(0, 0).numColumns(3).create());
		GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(comp);

		// Configure member lookup
		configureLookupFields(comp, "Member Lookup",
				Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.MEMBER_SEARCH_ICON),
				MEMBER_LOOKUP_TEXT, MEMBER_LOOKUP_BUTTON);

		// Create farm lookup
		configureLookupFields(comp, "Farm Lookup",
				Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.FARM_SEARCH_ICON), FARM_LOOKUP_TEXT,
				FARM_LOOKUP_BUTTON);

	}

	private void createRequestType(Composite parent) {
		// Request Type
		UIControlsFactory.createLabel(parent, "Request Type");
		final Composite requestTypeComp = UIControlsFactory.createComposite(parent);
		final GridLayout requestTypeLayout = new GridLayout(1, false);
		requestTypeComp.setLayout(requestTypeLayout);
		GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(requestTypeComp);

		// Text startText = UIControlsFactory.createText(dateComp);
		// By default the start text is the beginning of current month
		UIControlsFactory.createButtonRadio(requestTypeComp, "All", REQUEST_TYPE_ALL);
		UIControlsFactory.createButtonRadio(requestTypeComp, "Velterinary", REQUEST_TYPE_VERTERNARY);
		UIControlsFactory.createButtonRadio(requestTypeComp, "Insemination", REQUEST_TYPE_INSEMINATION);
	}

	@Override
	protected void createFilterPanel(Composite comp) {

		// Date Range
		createDateRange(comp);

		// Request type
		createRequestType(comp);

		createMemberFarm(comp);

	}
}
