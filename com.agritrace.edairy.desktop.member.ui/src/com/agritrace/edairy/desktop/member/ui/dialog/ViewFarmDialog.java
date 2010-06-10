package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.swt.views.AbstractDialogView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.ViewFarmDialogController;

public class ViewFarmDialog extends AbstractDialogView {

	private Composite main;

	private FarmTabFolder tabFolder;

	private Button saveButton;
	private Button cancelButton;
	private Button deleteButton;

	public ViewFarmDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		// newShell.setSize(550, 450);
	}

	@Override
	protected Control buildView(Composite parent) {
		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		parent.setLayout(new GridLayout(1, false));

		main = UIControlsFactory.createComposite(parent);
		main.setLayout(new GridLayout(1, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(main);

		createHeader(main);
		tabFolder = new FarmTabFolder(main);
		GridDataFactory.fillDefaults().align(SWT.END, SWT.FILL).span(2, 1).grab(true, false)
				.applyTo(createOkCancelButtons(parent));
		return null;
	}

	@Override
	protected AbstractWindowController createController() {
		return new ViewFarmDialogController();
	}

	protected void createHeader(Composite parent) {

		Composite headerPanel = UIControlsFactory.createComposite(parent);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(headerPanel);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(headerPanel);

		Label titleLabel = UIControlsFactory.createLabel(headerPanel, "Farm Name :");
		addUIControl(titleLabel, ViewWidgetId.VIEW_FARM_NAME);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(3, 1).applyTo(titleLabel);
		Font labelFont = JFaceResources.getFontRegistry().getBold(JFaceResources.HEADER_FONT);
		titleLabel.setFont(labelFont);

		Label farmIdLabel = UIControlsFactory.createLabel(headerPanel, "Farm Id :");
		addUIControl(farmIdLabel, ViewWidgetId.VIEW_FARM_ID);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(farmIdLabel);

		Label memberIdLabel = UIControlsFactory.createLabel(headerPanel, "Member Id :");
		addUIControl(memberIdLabel, ViewWidgetId.VIEW_FARM_MEMBER_ID);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(memberIdLabel);

		Label memberNameLabel = UIControlsFactory.createLabel(headerPanel, "Member Name :");
		addUIControl(memberNameLabel, ViewWidgetId.VIEW_FARM_MEMBER_NAME);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(memberNameLabel);

	}

	private Composite createOkCancelButtons(Composite parent) {

		final Composite buttonComposite = UIControlsFactory.createComposite(parent);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(buttonComposite);

		deleteButton = UIControlsFactory.createButton(buttonComposite, "Delete");
		deleteButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(deleteButton, DialogConstants.BIND_ID_BUTTON_DELETE);

		saveButton = UIControlsFactory.createButton(buttonComposite, "Save");
		saveButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(saveButton, DialogConstants.BIND_ID_BUTTON_SAVE);

		cancelButton = UIControlsFactory.createButton(buttonComposite, "Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(cancelButton, DialogConstants.BIND_ID_BUTTON_CANCEL);
		return buttonComposite;
	}

}
