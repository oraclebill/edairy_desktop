package com.agritrace.edairy.desktop.common.ui.dialogs;

import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;


public abstract class MemberLookupAction implements IActionListener {
	public MemberLookupAction() {
	}

	@Override
	public void callback() {
		final MemberSearchDialog memberDialog = getMemberSearchDialog();
		final int retVal = memberDialog.open();

		if (retVal == Window.OK) {
			final Membership selectedMember = memberDialog.getSelectedMember();
			callback(selectedMember);
		}
	}

	protected abstract MemberSearchDialog getMemberSearchDialog();
	protected abstract void callback(Membership selectedMember);
}