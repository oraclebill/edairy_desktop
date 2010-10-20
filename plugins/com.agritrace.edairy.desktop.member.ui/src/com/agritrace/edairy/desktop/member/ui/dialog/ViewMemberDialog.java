package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.ui.dialogs.BaseDialogView;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.AddMemberDialogController;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.ViewMemberDialogController;
import com.agritrace.edairy.desktop.member.ui.views.MemberInfoGroup;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class ViewMemberDialog extends BaseDialogView {
	private MembershipTabFolder tabFolder;

	@Inject
	public ViewMemberDialog(@Named("current") Shell shell, ViewMemberDialogController controller) {
		super(shell, controller);
	}

	// TODO: This kind of weird cross-inheritance really should be fixed.
	protected ViewMemberDialog(@Named("current") Shell shell, AddMemberDialogController controller) {
		super(shell, controller);
	}

	@Override
	protected void buildWorkArea(Composite parent) {
		createMemberHeadlineGroup(parent);
		createMemberInfoGroup(parent);
		createMemberTabFolderGroup(parent);
	}

	protected void createMemberHeadlineGroup(Composite composite) {
//		final Composite infoPanel = UIControlsFactory.createComposite(composite);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(infoPanel);
//		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(infoPanel);
//
//		final Label titleLabel = UIControlsFactory.createLabel(infoPanel, "Member Name :");
//		addUIControl(titleLabel, ViewWidgetId.VIEW_MEMBER_NAME_HEADER);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(titleLabel);
//		final Font labelFont = JFaceResources.getFontRegistry().getBold(JFaceResources.HEADER_FONT);
//		titleLabel.setFont(labelFont);
//
//		final Label photoLabel = UIControlsFactory.createLabel(infoPanel, "");
//		addUIControl(photoLabel, ViewWidgetId.VIEW_MEMBER_NAME_PHOTO);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).span(1, 3).grab(false, false).applyTo(photoLabel);
//
//		final Label idLabel = UIControlsFactory.createLabel(infoPanel, "");
//		addUIControl(idLabel, ViewWidgetId.VIEW_MEMBER_ID);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(idLabel);
//
//		final Label balanceLabel = UIControlsFactory.createLabel(infoPanel, "");
//		addUIControl(balanceLabel, ViewWidgetId.VIEW_MEMBER_BALANCE);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(balanceLabel);
	}

	protected void createMemberInfoGroup(Composite parent) {
		final MemberInfoGroup infoGroup = new MemberInfoGroup(parent);
		infoGroup.getComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	}

	protected void createMemberTabFolderGroup(Composite parent) {
		tabFolder = new MembershipTabFolder(parent);
		tabFolder.getTabComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

}