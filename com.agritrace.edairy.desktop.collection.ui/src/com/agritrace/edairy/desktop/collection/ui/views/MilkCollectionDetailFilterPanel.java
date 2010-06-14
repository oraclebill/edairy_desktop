package com.agritrace.edairy.desktop.collection.ui.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;

public class MilkCollectionDetailFilterPanel extends Composite {
	
	public static final String FILTER_VEHICLE_TXT 		= "FILTER_VEHICLE_TXT";
	public static final String FILTER_DRIVER_TXT 		= "FILTER_DRIVER_TXT";
	public static final String FILTER_ROUTE_TXT 		= "FILTER_ROUTE_TXT";
	public static final String FILTER_SESSION_TXT 		= "FILTER_SESSION_TXT";
	public static final String FILTER_JRNLBOOK_DATE		= "FILTER_JRNLBOOK_DATE";
	public static final String FILTER_BACK_TO_LOG_BTN 	= "FILTER_BACK_TO_LOG_BTN";
	public static final String FILTER_JRNLBOOK_ID_TXT 	= "FILTER_JRNLBOOK_ID_TXT";
	
	private Text textJrnlBook;
	private Text textRoute;
	private Text textSession;
	private Text textDriver;
	private Text textVehicle;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public MilkCollectionDetailFilterPanel(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		Composite composite = UIControlsFactory.createComposite(this);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		GridLayout gl_composite = new GridLayout(7, false);
		gl_composite.marginTop = 5;
		gl_composite.marginRight = 8;
		gl_composite.marginLeft = 8;
		gl_composite.marginBottom = 8;
		composite.setLayout(gl_composite);

		Label lblJournalBook = UIControlsFactory.createLabel(composite, "Journal Book:");

		textJrnlBook = UIControlsFactory.createText(composite, SWT.READ_ONLY, FILTER_JRNLBOOK_ID_TXT);
		textJrnlBook.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		UIControlsFactory.createLabel(composite, "", SWT.NONE);
		UIControlsFactory.createLabel(composite, "", SWT.NONE);
		UIControlsFactory.createLabel(composite, "", SWT.NONE);
		UIControlsFactory.createLabel(composite, "", SWT.NONE);

		Button btnBackToLog = UIControlsFactory.createButton(composite,"Back to Log", FILTER_BACK_TO_LOG_BTN);
		btnBackToLog.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Label lblDate = UIControlsFactory.createLabel(composite, "Date:");

		DateTime dateTime = UIControlsFactory.createDate(composite, SWT.MEDIUM, FILTER_JRNLBOOK_DATE);

		Label lblSession = UIControlsFactory.createLabel(composite, "Session");

		textSession = UIControlsFactory.createText(composite, SWT.READ_ONLY, FILTER_SESSION_TXT);
		textSession.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		UIControlsFactory.createLabel(composite, "", SWT.NONE);
		UIControlsFactory.createLabel(composite, "", SWT.NONE);

		Button btnEdit = UIControlsFactory.createButton(composite, "Edit", AbstractRecordListView.BIND_ID_VIEW);
		btnEdit.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Label lblRoute = UIControlsFactory.createLabel(composite, "Route:");

		textRoute = UIControlsFactory.createText(composite, SWT.READ_ONLY, FILTER_ROUTE_TXT);
		textRoute.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblDriver = UIControlsFactory.createLabel(composite, "Driver");

		textDriver = UIControlsFactory.createText(composite, SWT.READ_ONLY, FILTER_DRIVER_TXT);
		GridData gd_textDriver = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_textDriver.widthHint = 104;
		textDriver.setLayoutData(gd_textDriver);

		Label lblVehicle = UIControlsFactory.createLabel(composite, "Vehicle");

		textVehicle = UIControlsFactory.createText(composite, SWT.READ_ONLY, FILTER_VEHICLE_TXT);
		textVehicle.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		UIControlsFactory.createLabel(composite, "",SWT.NONE);

		Group group = UIControlsFactory.createGroup(this, "");
		group.setLayout(new GridLayout(6, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

		Label lblViewPage = new Label(group, SWT.NONE);
		lblViewPage.setText("View Page");

		Spinner pageSpinner = new Spinner(group, SWT.BORDER);

		Button btnViewPage = UIControlsFactory.createButton(group, "Go To Page", AbstractRecordListView.BIND_ID_FILTER_SEARCH);

		Composite filler = UIControlsFactory.createComposite(group);
		filler.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		UIControlsFactory.createLabel(group, "",SWT.NONE);

		Button btnAddNewPage = UIControlsFactory.createButton(group, "Add New Page", AbstractRecordListView.BIND_ID_NEW);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
