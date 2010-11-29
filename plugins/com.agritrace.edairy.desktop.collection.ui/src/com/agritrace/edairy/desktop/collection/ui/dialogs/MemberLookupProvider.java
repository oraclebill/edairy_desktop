package com.agritrace.edairy.desktop.collection.ui.dialogs;

import java.util.List;

import com.agritrace.edairy.desktop.collection.ui.components.collectionline.IMemberInfoProvider;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.util.MemberUtil;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.google.inject.Inject;

public class MemberLookupProvider implements IMemberInfoProvider {
	private List<Membership> allMembers;

	@Inject
	public MemberLookupProvider(IMemberRepository repo) {
		allMembers = repo.all();
		// Force prefetch
		allMembers.size();
	}

	@Override
	public Membership getMember(String memberNumber) {
		memberNumber = MemberUtil.expandMemberNumber(memberNumber);
		
		for (Membership member: allMembers) {
			if (memberNumber.equals(member.getMemberNumber()))
				return member;
		}
		
		return null;
	}

}
