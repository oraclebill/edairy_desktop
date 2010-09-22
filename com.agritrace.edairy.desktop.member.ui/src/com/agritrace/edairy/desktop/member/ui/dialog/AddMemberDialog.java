package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.member.ui.dialog.controller.AddMemberDialogController;
import com.agritrace.edairy.desktop.member.ui.views.MemberInfoGroup;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class AddMemberDialog extends ViewMemberDialog {
	@Inject
	public AddMemberDialog(@Named("current") Shell shell, AddMemberDialogController controller) {
		super(shell, controller);
	}

	@Override
	protected void createMemberHeadlineGroup(Composite composite) {
		// empty

	}

	@Override
	protected void createMemberInfoGroup(Composite parent) {
		final MemberInfoGroup infoGroup = new MemberInfoGroup(parent);
		infoGroup.getComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	}

	@Override
	protected void createMemberTabFolderGroup(Composite parent) {
		final MembershipTabFolder tabFolder = new MembershipTabFolder(parent, MembershipTabFolder.NEW_MEMBER_TABS);
		tabFolder.getTabComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

}
