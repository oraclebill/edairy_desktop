package com.agritrace.edairy.desktop.milkops.ui.intake;

import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;

import com.agritrace.edairy.desktop.common.ui.views.BaseListView;

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
		final FormData fd_lblStartDate = new FormData();
		fd_lblStartDate.top = new FormAttachment(0, 21);
		lblStartDate.setLayoutData(fd_lblStartDate);

		final DateTime startDate = UIControlsFactory.createDate(grpSearch, SWT.MEDIUM);
		fd_lblStartDate.right = new FormAttachment(startDate, -6);
		final FormData fd_startDate = new FormData();
		fd_startDate.top = new FormAttachment(lblStartDate, -4, SWT.TOP);
		fd_startDate.left = new FormAttachment(0, 75);
		startDate.setLayoutData(fd_startDate);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(startDate,
				ViewConstants.COLLECTION_FILTER_START_DATE_TEXT);

		final Label lblEndDate = UIControlsFactory.createLabel(grpSearch, "End Date");
		final FormData fd_lblEndDate = new FormData();
		fd_lblEndDate.top = new FormAttachment(lblStartDate, 0, SWT.TOP);
		fd_lblEndDate.left = new FormAttachment(startDate, 6);
		lblEndDate.setLayoutData(fd_lblEndDate);

		final DateTime endDate = UIControlsFactory.createDate(grpSearch, SWT.MEDIUM);
		final FormData fd_endDate = new FormData();
		fd_endDate.left = new FormAttachment(lblEndDate, 6);
		fd_endDate.top = new FormAttachment(lblStartDate, -4, SWT.TOP);
		endDate.setLayoutData(fd_endDate);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(endDate,
				ViewConstants.COLLECTION_FILTER_END_DATE_TEXT);

		final CCombo centerCombo = UIControlsFactory.createCCombo(grpSearch);
		final FormData fd_centerCombo = new FormData();
		fd_centerCombo.width = 120;
		fd_centerCombo.top = new FormAttachment(lblStartDate, 0, SWT.TOP);
		centerCombo.setLayoutData(fd_centerCombo);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(centerCombo,
				ViewConstants.COLLECTION_FILTER_CENTER_COMBO);

		final Label lblCenter = UIControlsFactory.createLabel(grpSearch, "Collection Center");
		fd_centerCombo.right = new FormAttachment(lblCenter, 136, SWT.RIGHT);
		fd_centerCombo.left = new FormAttachment(lblCenter, 6);
		final FormData fd_lblCenter = new FormData();
		fd_lblCenter.top = new FormAttachment(lblStartDate, 0, SWT.TOP);
		fd_lblCenter.left = new FormAttachment(endDate, 6);
		fd_lblCenter.left = new FormAttachment(endDate, 23);
		lblCenter.setLayoutData(fd_lblCenter);

		final Button btnSearch = UIControlsFactory.createButton(grpSearch);
		final FormData fd_btnSearch = new FormData();
		fd_btnSearch.top = new FormAttachment(0, 13);
		fd_btnSearch.right = new FormAttachment(100, -10);
		btnSearch.setLayoutData(fd_btnSearch);
		btnSearch.setText("Search");
		SWTBindingPropertyLocator.getInstance().setBindingProperty(btnSearch,
				BaseListView.BIND_ID_FILTER_SEARCH);

		final Button btnReset = UIControlsFactory.createButton(grpSearch);
		final FormData fd_btnReset = new FormData();
		fd_btnReset.top = new FormAttachment(btnSearch, 6);
		fd_btnReset.left = new FormAttachment(btnSearch, 0, SWT.LEFT);
		btnReset.setLayoutData(fd_btnReset);
		btnReset.setText("Reset");
		SWTBindingPropertyLocator.getInstance()
				.setBindingProperty(btnReset, BaseListView.BIND_ID_FILTER_RESET);

		final Label lblMprMissing = UIControlsFactory.createLabel(grpSearch, "MPR Missing");
		final FormData fd_lblMprMissing = new FormData();
		fd_lblMprMissing.top = new FormAttachment(btnReset, 8, SWT.TOP);
		lblMprMissing.setLayoutData(fd_lblMprMissing);
		final Button button = UIControlsFactory.createButtonCheck(grpSearch);
		fd_lblMprMissing.right = new FormAttachment(button, -6);
		final FormData fd_button = new FormData();
		fd_button.top = new FormAttachment(lblMprMissing, -2, SWT.TOP);
		fd_button.left = new FormAttachment(0, 89);
		button.setLayoutData(fd_button);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(button,
				ViewConstants.COLLECTION_FILTER_MPR_MISSING_CHK);

		final Label lblMprMissing_1 = UIControlsFactory.createLabel(grpSearch, "Suspended");
		final FormData fd_lblMprMissing_1 = new FormData();
		fd_lblMprMissing_1.top = new FormAttachment(lblMprMissing, 0, SWT.TOP);
		lblMprMissing_1.setLayoutData(fd_lblMprMissing_1);

		final Button button_1 = UIControlsFactory.createButtonCheck(grpSearch);
		fd_lblMprMissing_1.right = new FormAttachment(button_1, -6);
		final FormData fd_button_1 = new FormData();
		fd_button_1.top = new FormAttachment(lblMprMissing, -2, SWT.TOP);
		fd_button_1.left = new FormAttachment(0, 198);
		button_1.setLayoutData(fd_button_1);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(button_1,
				ViewConstants.COLLECTION_FILTER_SUSPENDED_CHK);

		final Label lblRejected = UIControlsFactory.createLabel(grpSearch, "Rejected");
		final FormData fd_lblRejected = new FormData();
		fd_lblRejected.top = new FormAttachment(lblMprMissing, 0, SWT.TOP);
		fd_lblRejected.left = new FormAttachment(button_1, 18);
		lblRejected.setLayoutData(fd_lblRejected);

		final Button button_2 = UIControlsFactory.createButtonCheck(grpSearch);
		final FormData fd_button_2 = new FormData();
		fd_button_2.top = new FormAttachment(lblMprMissing, -2, SWT.TOP);
		fd_button_2.left = new FormAttachment(lblRejected, 6);
		button_2.setLayoutData(fd_button_2);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(button_2,
				ViewConstants.COLLECTION_FILTER_REJECTED_CHK);

		final Label lblStatus = UIControlsFactory.createLabel(this, "Status");
		fd_button_2.right = new FormAttachment(lblStatus, -23);
		final FormData fd_lblStatus = new FormData();
		fd_lblStatus.top = new FormAttachment(lblMprMissing, 0, SWT.TOP);
		fd_lblStatus.left = new FormAttachment(0, 338);
		lblStatus.setLayoutData(fd_lblStatus);

		final CCombo statusCombo = UIControlsFactory.createCCombo(this, ViewConstants.COLLECTION_FILTER_STATUS_COMBO);
		final FormData fd_statusCombo = new FormData();
		fd_statusCombo.right = new FormAttachment(centerCombo, 0, SWT.RIGHT);
		fd_statusCombo.width = 120;
		fd_statusCombo.top = new FormAttachment(lblMprMissing, 0, SWT.TOP);
		fd_statusCombo.left = new FormAttachment(lblStatus, 4);
		statusCombo.setLayoutData(fd_statusCombo);

		final Label lblSession = UIControlsFactory.createLabel(this, "Session");
		final FormData fd_lblSession = new FormData();
		fd_lblSession.top = new FormAttachment(lblMprMissing, 0, SWT.TOP);
		fd_lblSession.left = new FormAttachment(statusCombo, 10);
		lblSession.setLayoutData(fd_lblSession);

		final CCombo sessionCombo = UIControlsFactory.createCCombo(this, ViewConstants.COLLECTION_FILTER_SESSION_COMBO);
		final FormData fd_sessionCombo = new FormData();
		//fd_sessionCombo.right = new FormAttachment(routeCombo, 0, SWT.RIGHT);
		fd_sessionCombo.width = 140;
		fd_sessionCombo.top = new FormAttachment(lblSession, 0, SWT.TOP);
		fd_sessionCombo.left = new FormAttachment(lblSession, 5);
		sessionCombo.setLayoutData(fd_sessionCombo);

	}
}
