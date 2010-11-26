package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.ui.dialogs.BaseDialogView;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.MemberEditDialogController;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.ViewMemberDialogController;
import com.agritrace.edairy.desktop.member.ui.views.MemberInfoGroup;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class MemberEditDialog extends BaseDialogView {
	private MembershipTabFolder tabFolder;

	@Inject
	public MemberEditDialog(@Named("current") Shell shell, MemberEditDialogController controller) {
		super(shell, controller);
	}

//	// TODO: This kind of weird cross-inheritance really should be fixed.
//	protected ViewMemberDialog(@Named("current") Shell shell, AddMemberDialogController controller) {
//		super(shell, controller);
//	}

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
		tabFolder = new MembershipTabFolder(parent, MembershipTabFolder.NEW_MEMBER_TABS);
//		tabFolder = new MembershipTabFolder(parent);
		tabFolder.getTabComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

}
