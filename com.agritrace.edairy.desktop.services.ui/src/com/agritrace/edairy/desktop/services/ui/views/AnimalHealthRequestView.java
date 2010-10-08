package com.agritrace.edairy.desktop.services.ui.views;

import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
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
	public static final String ID = "animalhealth.services.edit.view";

	public static final String START_DATE_TEXT = "start.date.text";
	public static final String END_DATE_TEXT = "end.date.text";

	public static final String FARM_LOOKUP_BUTTON = "filter.farm.button";
	public static final String FARM_LOOKUP_TEXT = "filter.farm.text";

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

	public AnimalHealthRequestView() {
	}

	private void configureLookupFields(Composite parent, String label, Image icon, String textBindId,
			String buttonBindId) {
		final Label label_1 = UIControlsFactory.createLabel(parent, label);
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
		final RowLayout rl_composite = new RowLayout(SWT.HORIZONTAL);
		rl_composite.spacing = 5;
		composite.setLayout(rl_composite);

		final Label label = UIControlsFactory.createLabel(composite, "Date Range");
		label.setLayoutData(new RowData(120, SWT.DEFAULT));

		UIControlsFactory.createLabel(composite, "Start");
		final DateTime startDateLookup = UIControlsFactory.createDate(composite, SWT.NULL);
//		startDateLookup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		addUIControl(startDateLookup, START_DATE_TEXT);

		UIControlsFactory.createLabel(composite, "End");
		final DateTime endDateLookup = UIControlsFactory.createDate(composite, SWT.NULL);
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
		final RowLayout rl_requestTypeComp = new RowLayout(SWT.HORIZONTAL);
		rl_requestTypeComp.spacing = 5;
		requestTypeComp.setLayout(rl_requestTypeComp);
		final Label label = UIControlsFactory.createLabel(requestTypeComp, "Request Type");
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
