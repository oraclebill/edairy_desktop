package com.agritrace.edairy.setup.ui.views;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.window.Window;
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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

//import com.agritrace.edairy.riena.ui.Activator;
//import com.agritrace.edairy.riena.ui.EDairyActivator;
import com.agritrace.edairy.ui.ImageRegistry;
//import com.agritrace.edairy.ui.views.CalendarSelectionDialog;
import com.agritrace.edairy.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.riena.ui.views.FarmSearchDialog;
import com.agritrace.edairy.ui.views.data.SimpleFormattedDateBean;
import com.agritrace.edairy.service.ui.views.utils.ServiceUtils;
import com.agritrace.edairy.ui.EDairyActivator;
import com.agritrace.edairy.ui.views.CalendarSelectionDialog;

/**
 * @author Spark Wan
 * 
 */
public class VehicleFilterSection {

	private static final int INDENT_WIDTH = 10;
	public static final String BIND_ID_APPLY = "filter.button";
	public static final String BIND_ID_RESET = "filter.reset";
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
	private Text startDateText;
	private Text endDateText;
	private Button applyBtn;
	private ImageButton memberSearchButton;
	private Text memberText;
	private Text farmText;
	private Listener listener = new Listener() {

		@Override
		public void handleEvent(Event event) {

			if (event != null && event.widget == memberSearchButton) {
				MemberSearchDialog dialog = new MemberSearchDialog(new Shell());
				int ret = dialog.open();
				if (Window.OK == ret) {
					// Demo code
					memberText.setText("Spark Wan");
				}
			}
			if (event != null && event.widget == farmLookupButton) {
				FarmSearchDialog dialog = new FarmSearchDialog(new Shell());
				int ret = dialog.open();
				if (Window.OK == ret) {
					// Demo code
					farmText.setText("Farm1");
				}
			}
		}

	};
	private ImageButton farmLookupButton;



	public void createSection(Composite parent) {

		// Creates composite
		Composite comp = UIControlsFactory.createComposite(parent);
		comp.setLayout(new GridLayout());
		GridData data = new GridData(GridData.FILL_VERTICAL);
		data.verticalAlignment = GridData.BEGINNING;
		comp.setLayoutData(data);
		// Date Range
		createDateRange(comp);

		// Request type
		createRequestType(comp);

		// Member Lookup
		createMemberLookup(comp);

		// Create farm lookup
		createFarmLookup(comp);

		createButtons(comp);

	}

	private void createDateRange(Composite parent) {
		// Creates Date Range control
		UIControlsFactory.createLabel(parent, "Date Range");

		Composite dateComp = UIControlsFactory.createComposite(parent);
		GridLayout layout = new GridLayout(3, false);
		layout.marginLeft = INDENT_WIDTH;
		dateComp.setLayout(layout);
		dateComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		UIControlsFactory.createLabel(dateComp, "Start");
		startDateText = UIControlsFactory.createText(dateComp, SWT.BORDER, STARTE_DATE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,
				false).applyTo(startDateText);
		// Default start time is the first day of this month
		startDateText.setText(ServiceUtils.DATE_FORMAT.format(ServiceUtils
				.getFirstDayOfMonth(Calendar.getInstance().getTime())));
	
		Button calendarButton = new Button(dateComp, SWT.PUSH);
		Image calendar = EDairyActivator.getImage(ImageRegistry.calendar);
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

		UIControlsFactory.createLabel(dateComp, "End");
		endDateText = UIControlsFactory.createText(dateComp, SWT.READ_ONLY
				| SWT.BORDER, END_DATE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,
				false).applyTo(endDateText);
		endDateText.setText(ServiceUtils.DATE_FORMAT.format(ServiceUtils
				.getLastDayOfMonth(Calendar.getInstance().getTime())));		


		Button calendarButton2 = new Button(dateComp, SWT.PUSH);
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
		GridLayout requestTypeLayout = new GridLayout(3, false);
		requestTypeLayout.marginLeft = INDENT_WIDTH;
		requestTypeComp.setLayout(requestTypeLayout);
		// Text startText = UIControlsFactory.createText(dateComp);
		// By default the start text is the beginning of current month
		UIControlsFactory.createButtonRadio(requestTypeComp,
				"All", REQUEST_TYPE_ALL);
		UIControlsFactory.createButtonRadio(requestTypeComp,
				"Velterinary", REQUEST_TYPE_VERTERNARY);
		UIControlsFactory.createButtonRadio(requestTypeComp,
				"Insemination", REQUEST_TYPE_INSEMINATION);	
	}

	private void createMemberLookup(Composite parent) {
		// Member lookup
		UIControlsFactory.createLabel(parent, "Member Lookup");
		Composite comp = UIControlsFactory.createComposite(parent);
		GridLayout layout = new GridLayout(2, false);
		layout.marginLeft = INDENT_WIDTH;
		comp.setLayout(layout);
		comp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		memberText = UIControlsFactory.createText(comp, SWT.None,
				MEMBER_LOOKUP_TEXT);
		memberText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		// Search Button
		memberSearchButton = UIControlsFactory
				.createImageButton(comp, SWT.None);
		memberSearchButton.setImage(EDairyActivator.getImage(SEARCH_ICON_PATH));
		memberSearchButton.addListener(SWT.Selection, listener);

	}

	private void createFarmLookup(Composite parent) {
		// Farm lookup
		UIControlsFactory.createLabel(parent, "Farm Lookup");
		Composite comp = UIControlsFactory.createComposite(parent);
		GridLayout requestTypeLayout = new GridLayout(2, false);
		requestTypeLayout.marginLeft = INDENT_WIDTH;
		comp.setLayout(requestTypeLayout);
		comp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		farmText = UIControlsFactory.createText(comp, SWT.None,
				FARM_LOOKUP_TEXT);
		farmText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		// Search Button
		farmLookupButton = UIControlsFactory.createImageButton(comp,
				SWT.None);
		farmLookupButton.setImage(EDairyActivator.getImage(SEARCH_ICON_PATH));
		farmLookupButton.addListener(SWT.Selection, listener);

	}

	private void createButtons(Composite parent) {
		// Reset Apply buttons
		Composite comp = UIControlsFactory.createComposite(parent);
		GridLayout layout = new GridLayout(2, false);
		layout.horizontalSpacing = 40;
		comp.setLayout(layout);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalAlignment = GridData.CENTER;
	
		comp.setLayoutData(data);
		// ResetButton
		Button resetBtn = UIControlsFactory.createButton(comp,"Reset", BIND_ID_RESET);
		resetBtn.addListener(SWT.Selection, listener);
		// Apply Button
		applyBtn = UIControlsFactory.createButton(comp, "Apply", BIND_ID_APPLY);
		applyBtn.addListener(SWT.Selection, listener);

	}
}