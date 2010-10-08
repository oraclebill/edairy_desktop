package com.agritrace.edairy.desktop.collection.ui.components;

import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.collection.ui.ViewConstants;

public class MilkCollectionDetailLogFilterPanel extends Composite {

	public static final String FILTER_BACK_TO_LOG_BTN = ViewConstants.COLLECTION_DETAIL_BACK_BTN;
	public static final String FILTER_DRIVER_TXT = ViewConstants.COLLECTION_DETAIL_HEADER_DRIVER_TXT;
	public static final String FILTER_JRNLBOOK_DATE = ViewConstants.COLLECTION_DETAIL_HEADER_DATE_TXT;
	public static final String FILTER_JRNLBOOK_ID_TXT = ViewConstants.COLLECTION_DETAIL_HEADER_BOOK_TXT;
	public static final String FILTER_ROUTE_TXT = ViewConstants.COLLECTION_DETAIL_HEADER_ROUTE_TXT;
	public static final String FILTER_SESSION_TXT = ViewConstants.COLLECTION_DETAIL_HEADER_SESSION_TXT;
	public static final String FILTER_VEHICLE_TXT = ViewConstants.COLLECTION_DETAIL_HEADER_VEHICLE_TXT;

	private final Text textDriver;
	private final Text textJrnlBook;
	private final Text textRoute;
	private final Text textSession;
	private final Text textVehicle;

	/**
	 * Create the composite.
	 *
	 * @param parent
	 * @param style
	 */
	public MilkCollectionDetailLogFilterPanel(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		final Composite composite = UIControlsFactory.createComposite(this);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		final GridLayout gl_composite = new GridLayout(7, false);
		gl_composite.marginTop = 5;
		gl_composite.marginRight = 8;
		gl_composite.marginLeft = 8;
		gl_composite.marginBottom = 8;
		composite.setLayout(gl_composite);

		UIControlsFactory.createLabel(composite, "Journal Book:");

		textJrnlBook = UIControlsFactory.createText(composite, SWT.READ_ONLY, FILTER_JRNLBOOK_ID_TXT);
		textJrnlBook.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		UIControlsFactory.createLabel(composite, "", SWT.NONE);
		UIControlsFactory.createLabel(composite, "", SWT.NONE);
		UIControlsFactory.createLabel(composite, "", SWT.NONE);
		UIControlsFactory.createLabel(composite, "", SWT.NONE);

		final Button btnBackToLog = UIControlsFactory.createButton(composite, "Back to Log", FILTER_BACK_TO_LOG_BTN);
		btnBackToLog.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		UIControlsFactory.createLabel(composite, "Date:");

		UIControlsFactory.createDate(composite, SWT.MEDIUM, FILTER_JRNLBOOK_DATE);

		UIControlsFactory.createLabel(composite, "Session");

		textSession = UIControlsFactory.createText(composite, SWT.READ_ONLY, FILTER_SESSION_TXT);
		textSession.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		UIControlsFactory.createLabel(composite, "", SWT.NONE);
		UIControlsFactory.createLabel(composite, "", SWT.NONE);

		final Button btnEdit = UIControlsFactory.createButton(composite, "Edit",
				ViewConstants.COLLECTION_DETAIL_EDIT_BTN);
		btnEdit.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		UIControlsFactory.createLabel(composite, "Transport Route:");

		textRoute = UIControlsFactory.createText(composite, SWT.READ_ONLY, FILTER_ROUTE_TXT);
		textRoute.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		UIControlsFactory.createLabel(composite, "Driver");

		textDriver = UIControlsFactory.createText(composite, SWT.READ_ONLY, FILTER_DRIVER_TXT);
		final GridData gd_textDriver = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_textDriver.widthHint = 104;
		textDriver.setLayoutData(gd_textDriver);

		UIControlsFactory.createLabel(composite, "Vehicle");

		textVehicle = UIControlsFactory.createText(composite, SWT.READ_ONLY, FILTER_VEHICLE_TXT);
		textVehicle.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		UIControlsFactory.createLabel(composite, "", SWT.NONE);

		final Group group = UIControlsFactory.createGroup(this, "");
		group.setLayout(new GridLayout(6, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

		final Label lblViewPage = new Label(group, SWT.NONE);
		lblViewPage.setText("View Page");
		UIControlsFactory.createSpinner(group, SWT.BORDER,
				ViewConstants.COLLECTION_DETAIL_FILTER_PAGE_SPIN);

		UIControlsFactory.createButton(group, "Go To Page",
				ViewConstants.COLLECTION_DETAIL_FILTER_BTN);

		final Composite filler = UIControlsFactory.createComposite(group);
		filler.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		UIControlsFactory.createLabel(group, "", SWT.NONE);

		UIControlsFactory.createButton(group, "Add New Page",
				ViewConstants.COLLECTION_DETAIL_NEW_BTN);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
