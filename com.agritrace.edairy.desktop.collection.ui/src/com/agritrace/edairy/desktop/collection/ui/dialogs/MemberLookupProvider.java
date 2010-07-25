package com.agritrace.edairy.desktop.collection.ui.dialogs;

import com.agritrace.edairy.desktop.collection.ui.components.collectionline.IMemberInfoProvider;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class MemberLookupProvider implements IMemberInfoProvider {

	private final IDairyRepository memberRepo;
	
	public MemberLookupProvider( IDairyRepository repo ) {
		memberRepo = repo;
	}
	
	@Override
	public Membership getMember(String memberNumber) {
		return memberRepo.getMemberByMemberId(memberNumber);
	}

}
