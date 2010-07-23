package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.member.ui.dialog.controller.AddMemberDialogController;
import com.agritrace.edairy.desktop.member.ui.views.MemberInfoGroup;

public class AddMemberDialog extends ViewMemberDialog {
	public AddMemberDialog() {
	}

	@Override
	protected AbstractWindowController createController() {
		return new AddMemberDialogController();
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
