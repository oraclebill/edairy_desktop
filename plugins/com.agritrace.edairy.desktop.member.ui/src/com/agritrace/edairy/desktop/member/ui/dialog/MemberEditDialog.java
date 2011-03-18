package com.agritrace.edairy.desktop.member.ui.dialog;

import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.MemberEditDialogController;
import com.agritrace.edairy.desktop.member.ui.views.MemberInfoGroup;

public class MemberEditDialog extends RecordDialog<Membership> {
	private MembershipTabFolder tabFolder;
	private Set<MembershipTabFolder.TabItem> tabSet;

	public MemberEditDialog(Shell shell, MemberEditDialogController controller) {
		super(shell, controller);
		if (controller.isNewMemberDialog()) {
			tabSet = MembershipTabFolder.NEW_MEMBER_TABS;
		}
		else {
			tabSet = MembershipTabFolder.ALL_TABS;
		}
 	}

	@Override
	protected void buildWorkArea(Composite parent) {
		createMemberInfoGroup(parent);
		createMemberTabFolderGroup(parent);
	}

	protected void createMemberInfoGroup(Composite parent) {
		final MemberInfoGroup infoGroup = new MemberInfoGroup(parent);
		infoGroup.getComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	}

	protected void createMemberTabFolderGroup(Composite parent) {
		tabFolder = new MembershipTabFolder(parent, tabSet);
		tabFolder.getTabComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setSize(800, 800);
	}

}
