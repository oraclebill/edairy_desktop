package com.agritrace.edairy.member.ui.views;

import com.agritrace.edairy.model.dairy.Membership;



public interface MemberSearchSelectionListener {
	
	public void memberSelectionChanged(Membership selectedMember);
	
	public void memberModified(Membership modifiedMember);
	
}