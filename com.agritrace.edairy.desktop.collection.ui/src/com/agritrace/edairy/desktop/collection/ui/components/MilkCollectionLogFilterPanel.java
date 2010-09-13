package com.agritrace.edairy.desktop.collection.ui.components;

import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;

import com.agritrace.edairy.desktop.collection.ui.ViewConstants;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public class MilkCollectionLogFilterPanel extends Composite {
	
	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public MilkCollectionLogFilterPanel(Composite parent, int style) {
		super(parent, style);
//		setLayout(new FillLayout(SWT.HORIZONTAL));

//		final Group grpSearch = UIControlsFactory.createGroup(this, "Search");

		final Composite grpSearch = this;
		setLayout(new FormLayout());
		final Label lblStartDate = UIControlsFactory.createLabel(grpSearch, "Start Date", SWT.NONE);
		FormData fd_lblStartDate = new FormData();
		fd_lblStartDate.top = new FormAttachment(0, 21);
		lblStartDate.setLayoutData(fd_lblStartDate);

		final DateTime startDate = UIControlsFactory.createDate(grpSearch, SWT.MEDIUM);
		fd_lblStartDate.right = new FormAttachment(startDate, -6);
		FormData fd_startDate = new FormData();
		fd_startDate.top = new FormAttachment(lblStartDate, -4, SWT.TOP);
		fd_startDate.left = new FormAttachment(0, 75);
		startDate.setLayoutData(fd_startDate);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(startDate,
				ViewConstants.COLLECTION_FILTER_START_DATE_TEXT);

		final Label lblEndDate = UIControlsFactory.createLabel(grpSearch, "End Date");
		FormData fd_lblEndDate = new FormData();
		fd_lblEndDate.top = new FormAttachment(lblStartDate, 0, SWT.TOP);
		fd_lblEndDate.left = new FormAttachment(startDate, 6);
		lblEndDate.setLayoutData(fd_lblEndDate);

		final DateTime endDate = UIControlsFactory.createDate(grpSearch, SWT.MEDIUM);
		FormData fd_endDate = new FormData();
		fd_endDate.left = new FormAttachment(lblEndDate, 6);
		fd_endDate.top = new FormAttachment(lblStartDate, -4, SWT.TOP);
		endDate.setLayoutData(fd_endDate);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(endDate,
				ViewConstants.COLLECTION_FILTER_END_DATE_TEXT);

		final CCombo routeCombo = UIControlsFactory.createCCombo(grpSearch);
		FormData fd_routeCombo = new FormData();
		fd_routeCombo.width = 120;
		fd_routeCombo.top = new FormAttachment(lblStartDate, 0, SWT.TOP);
		routeCombo.setLayoutData(fd_routeCombo);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(routeCombo,
				ViewConstants.COLLECTION_FILTER_ROUTE_COMBO);

		final Label lblRoute = UIControlsFactory.createLabel(grpSearch, "Transport Route");
		fd_routeCombo.right = new FormAttachment(lblRoute, 136, SWT.RIGHT);
		fd_routeCombo.left = new FormAttachment(lblRoute, 6);
		FormData fd_lblRoute = new FormData();
		fd_lblRoute.top = new FormAttachment(lblStartDate, 0, SWT.TOP);
		fd_lblRoute.left = new FormAttachment(endDate, 6);
		fd_lblRoute.left = new FormAttachment(endDate, 23);
		lblRoute.setLayoutData(fd_lblRoute);

		final Button btnSearch = UIControlsFactory.createButton(grpSearch);
		FormData fd_btnSearch = new FormData();
		fd_btnSearch.top = new FormAttachment(0, 13);
		fd_btnSearch.right = new FormAttachment(100, -10);
		btnSearch.setLayoutData(fd_btnSearch);
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnSearch.setText("Search");
		SWTBindingPropertyLocator.getInstance().setBindingProperty(btnSearch,
				AbstractDirectoryView.BIND_ID_FILTER_SEARCH);

		final Button btnReset = UIControlsFactory.createButton(grpSearch);
		FormData fd_btnReset = new FormData();
		fd_btnReset.top = new FormAttachment(btnSearch, 6);
		fd_btnReset.left = new FormAttachment(btnSearch, 0, SWT.LEFT);
		btnReset.setLayoutData(fd_btnReset);
		btnReset.setText("Reset");
		SWTBindingPropertyLocator.getInstance()
				.setBindingProperty(btnReset, AbstractDirectoryView.BIND_ID_FILTER_RESET);

		final Label lblMprMissing = UIControlsFactory.createLabel(grpSearch, "MPR Missing");
		FormData fd_lblMprMissing = new FormData();
		fd_lblMprMissing.top = new FormAttachment(btnReset, 8, SWT.TOP);
		lblMprMissing.setLayoutData(fd_lblMprMissing);
		final Button button = UIControlsFactory.createButtonCheck(grpSearch);
		fd_lblMprMissing.right = new FormAttachment(button, -6);
		FormData fd_button = new FormData();
		fd_button.top = new FormAttachment(lblMprMissing, -2, SWT.TOP);
		fd_button.left = new FormAttachment(0, 89);
		button.setLayoutData(fd_button);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(button,
				ViewConstants.COLLECTION_FILTER_MPR_MISSING_CHK);

		final Label lblMprMissing_1 = UIControlsFactory.createLabel(grpSearch, "Suspended");
		FormData fd_lblMprMissing_1 = new FormData();
		fd_lblMprMissing_1.top = new FormAttachment(lblMprMissing, 0, SWT.TOP);
		lblMprMissing_1.setLayoutData(fd_lblMprMissing_1);

		final Button button_1 = UIControlsFactory.createButtonCheck(grpSearch);
		fd_lblMprMissing_1.right = new FormAttachment(button_1, -6);
		FormData fd_button_1 = new FormData();
		fd_button_1.top = new FormAttachment(lblMprMissing, -2, SWT.TOP);
		fd_button_1.left = new FormAttachment(0, 198);
		button_1.setLayoutData(fd_button_1);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(button_1,
				ViewConstants.COLLECTION_FILTER_SUSPENDED_CHK);

		final Label lblRejected = UIControlsFactory.createLabel(grpSearch, "Rejected");
		FormData fd_lblRejected = new FormData();
		fd_lblRejected.top = new FormAttachment(lblMprMissing, 0, SWT.TOP);
		fd_lblRejected.left = new FormAttachment(button_1, 18);
		lblRejected.setLayoutData(fd_lblRejected);

		final Button button_2 = UIControlsFactory.createButtonCheck(grpSearch);
		FormData fd_button_2 = new FormData();
		fd_button_2.top = new FormAttachment(lblMprMissing, -2, SWT.TOP);
		fd_button_2.left = new FormAttachment(lblRejected, 6);
		button_2.setLayoutData(fd_button_2);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(button_2,
				ViewConstants.COLLECTION_FILTER_REJECTED_CHK);
		
		Label lblStatus = UIControlsFactory.createLabel(this, "Status");
		fd_button_2.right = new FormAttachment(lblStatus, -23);
		FormData fd_lblStatus = new FormData();
		fd_lblStatus.top = new FormAttachment(lblMprMissing, 0, SWT.TOP);
		fd_lblStatus.left = new FormAttachment(0, 338);
		lblStatus.setLayoutData(fd_lblStatus);
		
		CCombo statusCombo = UIControlsFactory.createCCombo(this, ViewConstants.COLLECTION_FILTER_STATUS_COMBO);
		FormData fd_statusCombo = new FormData();
		fd_statusCombo.right = new FormAttachment(routeCombo, 0, SWT.RIGHT);
		fd_statusCombo.width = 120;
		fd_statusCombo.top = new FormAttachment(lblMprMissing, 0, SWT.TOP);
		fd_statusCombo.left = new FormAttachment(lblStatus, 4);
		statusCombo.setLayoutData(fd_statusCombo);

		Label lblSession = UIControlsFactory.createLabel(this, "Session");		
		FormData fd_lblSession = new FormData();
		fd_lblSession.top = new FormAttachment(lblMprMissing, 0, SWT.TOP);
		fd_lblSession.left = new FormAttachment(statusCombo, 10);
		lblSession.setLayoutData(fd_lblSession);
		
		CCombo sessionCombo = UIControlsFactory.createCCombo(this, ViewConstants.COLLECTION_FILTER_SESSION_COMBO);
		FormData fd_sessionCombo = new FormData();
		//fd_sessionCombo.right = new FormAttachment(routeCombo, 0, SWT.RIGHT);
		fd_sessionCombo.width = 140;
		fd_sessionCombo.top = new FormAttachment(lblSession, 0, SWT.TOP);
		fd_sessionCombo.left = new FormAttachment(lblSession, 5);
		sessionCombo.setLayoutData(fd_sessionCombo);
		
	}
}
