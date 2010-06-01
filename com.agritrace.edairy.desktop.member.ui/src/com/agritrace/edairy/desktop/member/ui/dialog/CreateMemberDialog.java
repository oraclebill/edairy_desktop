package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.swt.views.AbstractDialogView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.CreateMemberDialogController;
import com.agritrace.edairy.desktop.member.ui.views.MemberInfoGroup;

public class CreateMemberDialog extends ViewMemberDialog {


	@Override
	protected AbstractWindowController createController() {
		return new CreateMemberDialogController();
	}

	@Override
	protected void createMemberTabFolderGroup(Composite parent) {
		MembershipTabFolder tabFolder = new MembershipTabFolder(parent, MembershipTabFolder.NEW_MEMBER_TABS);
		tabFolder.getTabComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	protected void createMemberHeadlineGroup(Composite composite) {
		// do nothing..
	}



}

