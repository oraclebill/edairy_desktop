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

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.ViewMemberDialogController;

public class ViewMemberDialog extends AbstractDialogView {

	private Composite main;
	
	private MembershipTabFolder tabFolder;

	private Button saveButton;
	private Button cancelButton;
	private Button deleteButton;


	public ViewMemberDialog() {
		super(null);
	}

	@Override
	protected Control buildView(Composite parent) {
		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		parent.setLayout(new GridLayout(1, false));

		main = UIControlsFactory.createComposite(parent);
		main.setLayout(new GridLayout(1, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(main);

		createMemberSelectorGroup(main);
		tabFolder = new MembershipTabFolder(main);
		tabFolder.getTabComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		GridDataFactory.fillDefaults().align(SWT.END, SWT.FILL).span(2, 1).grab(true, false).applyTo(createOkCancelButtons(parent));
		return main;
	}

	@Override
	protected AbstractWindowController createController() {
		return new ViewMemberDialogController();
	}

	private void createMemberSelectorGroup(Composite composite) {
		Composite infoPanel = UIControlsFactory.createComposite(composite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(infoPanel);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(infoPanel);

		
		Label titleLabel =UIControlsFactory.createLabel(infoPanel,"Member Name :");
		addUIControl(titleLabel, ViewWidgetId.VIEW_MEMBER_NAME_HEADER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,false).applyTo(titleLabel);
		Font labelFont = JFaceResources.getFontRegistry().getBold(JFaceResources.HEADER_FONT);
		titleLabel.setFont(labelFont);
	 
		Label photoLabel = UIControlsFactory.createLabel(infoPanel, "");
		addUIControl(photoLabel, ViewWidgetId.VIEW_MEMBER_NAME_PHOTO);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).span(1, 3).grab(false,false).applyTo(photoLabel);

		Label idLabel = UIControlsFactory.createLabel(infoPanel, "");
		addUIControl(idLabel, ViewWidgetId.VIEW_MEMBER_ID);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,false).applyTo(idLabel);
		
		Label balanceLabel = UIControlsFactory.createLabel(infoPanel,"");
		addUIControl(balanceLabel, ViewWidgetId.VIEW_MEMBER_BALANCE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,false).applyTo(balanceLabel);
		
	}


	private Composite createOkCancelButtons(Composite parent) {

		final Composite buttonComposite = UIControlsFactory.createComposite(parent);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(buttonComposite);

		deleteButton = UIControlsFactory.createButton(buttonComposite, "Delete");
		deleteButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(deleteButton, ViewWidgetId.deleteButton);

		saveButton = UIControlsFactory.createButton(buttonComposite, "Save");
		saveButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(saveButton, ViewWidgetId.memberInfo_saveButton);

		cancelButton = UIControlsFactory.createButton(buttonComposite, "Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(cancelButton, ViewWidgetId.memberInfo_cacelButton);
		return buttonComposite;
	}

}


