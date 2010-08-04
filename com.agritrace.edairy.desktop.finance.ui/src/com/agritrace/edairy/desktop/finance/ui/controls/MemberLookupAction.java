package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;

public abstract class MemberLookupAction implements IActionListener {
	

	public MemberLookupAction() {
	}

	@Override
	public void callback() {
		final MemberSearchDialog memberDialog = new MemberSearchDialog(null);
		final int retVal = memberDialog.open();
		if (retVal == Window.OK) {
			final Membership selectedMember = memberDialog.getSelectedMember();
			callback(selectedMember);
		}
	}

	protected abstract void callback(Membership selectedMember);
}