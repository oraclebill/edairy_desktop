package com.agritrace.edairy.desktop.dairy.locations.ui.dialogs;

import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.swt.views.AbstractDialogView;
import org.eclipse.riena.ui.swt.MessageBox;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;

public class RouteListDialog extends AbstractDialogView {
	private final static int WIDTH_UNIT = 100;

	private Composite contentArea;

	public RouteListDialog() {
		super(null);
	}

	@Override
	protected Control buildView(Composite parent) {
		parent.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));
		contentArea = new Composite(parent, SWT.NONE);
		contentArea.setLayout(new GridLayout(2, false));

		final Table routeTable = UIControlsFactory.createTable(contentArea,
				SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION,
				RouteListDialogController.RIDGET_ID_ROUTE_TABLE);
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = SWT.FILL;
		gd.verticalSpan = 3;
		gd.widthHint = WIDTH_UNIT * 3;
		gd.heightHint = WIDTH_UNIT * 3;
		routeTable.setLayoutData(gd);

		final Button addButton = UIControlsFactory.createButton(contentArea,
				"Add", RouteListDialogController.RIDGET_ID_ADD);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		addButton.setLayoutData(gd);

		final Button deleteButton = UIControlsFactory.createButton(contentArea,
				"Delete", RouteListDialogController.RIDGET_ID_DELETE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		deleteButton.setLayoutData(gd);

		final Button closeButton = UIControlsFactory.createButton(contentArea,
				"Close", RouteListDialogController.RIDGET_ID_CLOSE);
		gd = new GridData();
		gd.horizontalAlignment = SWT.CENTER;
		gd.widthHint = WIDTH_UNIT;
		gd.horizontalSpan = 2;
		closeButton.setLayoutData(gd);

		createMessageBoxes();
		return contentArea;

	}

	private void createMessageBoxes() {
		final MessageBox deleteConfirmMessage = UIControlsFactory
				.createMessageBox(contentArea);
		this.addUIControl(deleteConfirmMessage,
				RouteListDialogController.RIDGET_ID_DELETE_CONFIRM_DIALOG);
	}

	@Override
	protected AbstractWindowController createController() {
		return new RouteListDialogController();
	}

}
