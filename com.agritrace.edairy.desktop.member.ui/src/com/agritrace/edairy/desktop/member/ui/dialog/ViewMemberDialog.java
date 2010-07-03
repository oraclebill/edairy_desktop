package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.ui.dialogs.BaseDialogView;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.ViewMemberDialogController;

public class ViewMemberDialog extends BaseDialogView {

	MembershipTabFolder tabFolder;

	public ViewMemberDialog() {
		this(null);
	}

	public ViewMemberDialog(Shell shell) {
		super(shell);
	}

	@Override
	protected void buildWorkArea(Composite parent) {

		createMemberHeadlineGroup(parent);

		createMemberInfoGroup(parent);

		createMemberTabFolderGroup(parent);
	}

	@Override
	protected AbstractWindowController createController() {
		return new ViewMemberDialogController();
	}

	protected void createMemberHeadlineGroup(Composite composite) {
		final Composite infoPanel = UIControlsFactory.createComposite(composite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(infoPanel);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(infoPanel);

		final Label titleLabel = UIControlsFactory.createLabel(infoPanel, "Member Name :");
		addUIControl(titleLabel, ViewWidgetId.VIEW_MEMBER_NAME_HEADER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(titleLabel);
		final Font labelFont = JFaceResources.getFontRegistry().getBold(JFaceResources.HEADER_FONT);
		titleLabel.setFont(labelFont);

		final Label photoLabel = UIControlsFactory.createLabel(infoPanel, "");
		addUIControl(photoLabel, ViewWidgetId.VIEW_MEMBER_NAME_PHOTO);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).span(1, 3).grab(false, false).applyTo(photoLabel);

		final Label idLabel = UIControlsFactory.createLabel(infoPanel, "");
		addUIControl(idLabel, ViewWidgetId.VIEW_MEMBER_ID);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(idLabel);

		final Label balanceLabel = UIControlsFactory.createLabel(infoPanel, "");
		addUIControl(balanceLabel, ViewWidgetId.VIEW_MEMBER_BALANCE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(balanceLabel);
	}

	protected void createMemberInfoGroup(Composite parent) {
		// infoGroup = new MemberInfoGroup(parent);
		// infoGroup.getComposite().setLayoutData(new GridData(SWT.FILL,
		// SWT.FILL, true, false));
	}

	protected void createMemberTabFolderGroup(Composite parent) {
		tabFolder = new MembershipTabFolder(parent);
		tabFolder.getTabComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

}
