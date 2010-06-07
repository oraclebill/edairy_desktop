package com.agritrace.edairy.desktop.services.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.controls.LookupComposite;
import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;
import com.agritrace.edairy.desktop.services.ui.Activator;

/**
 * Service request view
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceRequestView extends AbstractRecordListView {

	public static final String ID = "animalhealth.services.edit.view";

	/**
	 * Binding ID for All Request Types Radio Button Binding ID
	 */
	public static final String REQUEST_TYPE_ALL = "filter.type.all";
	/**
	 * Binding ID for Request Type-- VERTERNARY Radio Button Binding ID
	 */
	public static final String REQUEST_TYPE_VERTERNARY = "filter.type.veterinary";
	/**
	 * Request Type-- Insemination Radio Button Binding ID
	 */
	public static final String REQUEST_TYPE_INSEMINATION = "filter.type.insemination";
	public static final String MEMBER_LOOKUP_TEXT = "filter.member.text";
	public static final String FARM_LOOKUP_TEXT = "filter.farm.text";
	public static final String MEMBER_LOOKUP_BUTTON = "filter.member.button";
	public static final String FARM_LOOKUP_BUTTON = "filter.farm.button";
	public static final String START_DATE_TEXT = "start.date.text";
	public static final String START_DATE_BUTTON = "start.date.button";
	public static final String END_DATE_TEXT = "end.date.text";
	public static final String END_DATE_BUTTON = "end.date.button";

	@Override
	protected void createFilterCondtions(Composite comp) {
		super.createFilterCondtions(comp);

		// Date Range
		createDateRange(comp);

		// Request type
		createRequestType(comp);

		createMemberFarm(comp);

	}

	private void createMemberFarm(Composite parent) {
		Composite comp = UIControlsFactory.createComposite(parent);
		comp.setLayout(GridLayoutFactory.swtDefaults().margins(0, 0)
				.numColumns(3).create());
		GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL,
				SWT.FILL).applyTo(comp);
		// Create farm/member lookup
		LookupComposite farmLookup = new LookupComposite("Farm Lookup",
				Activator.getDefault().getImageRegistry().get(
						Activator.FARM_SEARCH_ICON), FARM_LOOKUP_TEXT,
				FARM_LOOKUP_BUTTON);
		farmLookup.createSection(comp);

		LookupComposite memberLookup = new LookupComposite("Member Lookup",
				Activator.getDefault().getImageRegistry().get(
						Activator.MEMBER_SEARCH_ICON), MEMBER_LOOKUP_TEXT,
				MEMBER_LOOKUP_BUTTON);
		memberLookup.createSection(comp);

	}

	private void createDateRange(Composite parent) {
		// Creates Date Range control
		UIControlsFactory.createLabel(parent, "Date Range");
		Composite startDateComp = UIControlsFactory.createComposite(parent);
		GridLayout layout = new GridLayout(3, false);
		startDateComp.setLayout(layout);
		GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL,
				SWT.FILL).applyTo(startDateComp);

		// Create Start Date lookup
		LookupComposite startDateLookup = new LookupComposite("Start",
				Activator.getDefault().getImageRegistry().get(
						Activator.CALENDAR_ICON), START_DATE_TEXT,
				START_DATE_BUTTON);
		startDateLookup.createSection(startDateComp);

		Composite endDateComp = UIControlsFactory.createComposite(parent);
		endDateComp.setLayout(GridLayoutFactory.swtDefaults().numColumns(3)
				.margins(0, 0).create());
		endDateComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		LookupComposite endDateLookup = new LookupComposite("End", Activator
				.getDefault().getImageRegistry().get(Activator.CALENDAR_ICON),
				END_DATE_TEXT, END_DATE_BUTTON);
		endDateLookup.createSection(endDateComp);
	}

	private void createRequestType(Composite parent) {
		// Request Type
		UIControlsFactory.createLabel(parent, "Request Type");
		Composite requestTypeComp = UIControlsFactory.createComposite(parent);
		GridLayout requestTypeLayout = new GridLayout(1, false);		
		requestTypeComp.setLayout(requestTypeLayout);		
		GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL,
				SWT.FILL).applyTo(requestTypeComp);
		
		// Text startText = UIControlsFactory.createText(dateComp);
		// By default the start text is the beginning of current month
		UIControlsFactory.createButtonRadio(requestTypeComp, "All",
				REQUEST_TYPE_ALL);
		UIControlsFactory.createButtonRadio(requestTypeComp, "Velterinary",
				REQUEST_TYPE_VERTERNARY);
		UIControlsFactory.createButtonRadio(requestTypeComp, "Insemination",
				REQUEST_TYPE_INSEMINATION);
	}
}
