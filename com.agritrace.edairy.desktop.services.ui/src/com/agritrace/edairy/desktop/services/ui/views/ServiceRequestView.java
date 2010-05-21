package com.agritrace.edairy.desktop.services.ui.views;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.ImageRegistry;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.dialogs.CalendarSelectionDialog;
import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;
import com.agritrace.edairy.desktop.services.ui.Activator;
import com.agritrace.edairy.desktop.services.ui.utils.ServiceUtils;

public class ServiceRequestView extends AbstractRecordListView {

	public static final String STARTE_DATE = "filter.start.date";
	public static final String END_DATE = "filter.end.date";
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
	public static final String SEARCH_ICON_PATH = "icons/ext/search16.png";
	public static final String ID = ServiceRequestView.class.getName();

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
				.numColumns(2).create());
		GridDataFactory.swtDefaults().grab(true, true).applyTo(comp);

		// Member Lookup
		createMemberLookup(comp);

		// Create farm lookup
		createFarmLookup(comp);

	}

	private void createDateRange(Composite parent) {
		// Creates Date Range control
		UIControlsFactory.createLabel(parent, "Date Range");

		Composite startDateComp = UIControlsFactory.createComposite(parent);
		GridLayout layout = new GridLayout(3, false);
		startDateComp.setLayout(layout);
		startDateComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		UIControlsFactory.createLabel(startDateComp, "Start");
		final Text startDateText = UIControlsFactory.createText(startDateComp, SWT.BORDER,
				STARTE_DATE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,
				false).applyTo(startDateText);
		// Default start time is the first day of this month
		startDateText.setText(ServiceUtils.DATE_FORMAT.format(ServiceUtils
				.getFirstDayOfMonth(Calendar.getInstance().getTime())));

		Button calendarButton = new Button(startDateComp, SWT.PUSH);
		Image calendar = Activator.getImage(ImageRegistry.calendar);
		calendarButton.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(
				17, 16).applyTo(calendarButton);
		// addUIControl(calendarButton,ViewWidgetId.calendarButton);

		calendarButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
				calDialog.getController().setContext(
						SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
						startDateText.getText());

				if (calDialog.open() == AbstractWindowController.OK) {
					Date selectedDate = (Date) calDialog.getController()
							.getContext(SimpleFormattedDateBean.DATE_PROR);
					SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
					bean.setDate(selectedDate);
					startDateText.setText(bean.getFormattedDate());
				}
			}
		});

		Composite endDateComp = UIControlsFactory.createComposite(parent);
		endDateComp.setLayout(GridLayoutFactory.swtDefaults().numColumns(3)
				.margins(0, 0).create());
		endDateComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		UIControlsFactory.createLabel(endDateComp, "End");
		final Text endDateText = UIControlsFactory.createText(endDateComp, SWT.READ_ONLY
				| SWT.BORDER, END_DATE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,
				false).applyTo(endDateText);
		endDateText.setText(ServiceUtils.DATE_FORMAT.format(ServiceUtils
				.getLastDayOfMonth(Calendar.getInstance().getTime())));

		Button calendarButton2 = new Button(endDateComp, SWT.PUSH);
		calendarButton2.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(
				17, 16).applyTo(calendarButton2);
		// addUIControl(calendarButton,ViewWidgetId.calendarButton);

		calendarButton2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
				calDialog.getController().setContext(
						SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
						endDateText.getText());

				if (calDialog.open() == AbstractWindowController.OK) {
					Date selectedDate = (Date) calDialog.getController()
							.getContext(SimpleFormattedDateBean.DATE_PROR);
					SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
					bean.setDate(selectedDate);
					endDateText.setText(bean.getFormattedDate());
				}
			}
		});

	}

	private void createRequestType(Composite parent) {
		// Request Type
		UIControlsFactory.createLabel(parent, "Request Type");
		Composite requestTypeComp = UIControlsFactory.createComposite(parent);
		GridLayout requestTypeLayout = new GridLayout(1, false);
		requestTypeComp.setLayout(requestTypeLayout);
		// Text startText = UIControlsFactory.createText(dateComp);
		// By default the start text is the beginning of current month
		UIControlsFactory.createButtonRadio(requestTypeComp, "All",
				REQUEST_TYPE_ALL);
		UIControlsFactory.createButtonRadio(requestTypeComp, "Velterinary",
				REQUEST_TYPE_VERTERNARY);
		UIControlsFactory.createButtonRadio(requestTypeComp, "Insemination",
				REQUEST_TYPE_INSEMINATION);
	}

	private void createMemberLookup(Composite parent) {
		// Member lookup
		UIControlsFactory.createLabel(parent, "Member Lookup");
		Composite comp = UIControlsFactory.createComposite(parent);
		GridLayout layout = new GridLayout(2, false);
		comp.setLayout(layout);
		comp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Text memberText = UIControlsFactory.createText(comp, SWT.None,
				MEMBER_LOOKUP_TEXT);
		memberText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		// Search Button
		ImageButton memberSearchButton = UIControlsFactory
				.createImageButton(comp, SWT.None);
		memberSearchButton.setImage(Activator.getImage(SEARCH_ICON_PATH));


	}

	private void createFarmLookup(Composite parent) {
		// Farm lookup
		UIControlsFactory.createLabel(parent, "Farm Lookup");
		Composite comp = UIControlsFactory.createComposite(parent);
		comp.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		GridDataFactory.swtDefaults().grab(true, true).applyTo(comp);
		Text farmText = UIControlsFactory.createText(comp, SWT.None,
				FARM_LOOKUP_TEXT);
		farmText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		// Search Button
		ImageButton farmLookupButton = UIControlsFactory.createImageButton(comp, SWT.None);
		farmLookupButton.setImage(Activator.getImage(SEARCH_ICON_PATH));
		//farmLookupButton.addListener(SWT.Selection, listener);

	}
	

}
