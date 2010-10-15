package com.agritrace.edairy.desktop.member.ui.views;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;

public interface MemberSearchSelectionListener {

	public void memberModified(Membership modifiedMember);

	public void memberSelectionChanged(Membership selectedMember);

	public void refreshView(String viewId);
}
