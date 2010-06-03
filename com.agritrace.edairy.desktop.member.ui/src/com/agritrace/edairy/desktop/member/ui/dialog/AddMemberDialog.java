package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.member.ui.dialog.controller.AddMemberDialogController;

public class AddMemberDialog extends ViewMemberDialog {

	@Override
	protected AbstractWindowController createController() {
		return new AddMemberDialogController();
	}

	@Override
	protected void createMemberTabFolderGroup(Composite parent) {
		final MembershipTabFolder tabFolder = new MembershipTabFolder(parent, MembershipTabFolder.NEW_MEMBER_TABS);
		tabFolder.getTabComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	@Override
	protected void createMemberHeadlineGroup(Composite composite) {

	}

}
