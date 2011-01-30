package com.agritrace.edairy.desktop.milkops.ui.intake.util;

import java.util.HashMap;
import java.util.Map;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.util.MemberUtil;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.milkops.ui.intake.collectionline.IMemberLookup;
import com.google.inject.Inject;

public class CachingMemberLookup implements IMemberLookup {
//	private List<Membership> allMembers;
	private Map<String, Membership> memberCache;
	private IMemberRepository repo;

	@Inject
	public CachingMemberLookup(IMemberRepository repo) {
		this.repo = repo;
		memberCache = new HashMap<String, Membership>();
	}

	@Override
	public Membership getMember(String memberNumber) {
		return getMember(memberNumber, false);
	}
	
	public Membership getMember(String memberNumber, boolean speculate) {
		Membership member = memberCache.get(memberNumber);
		if (member == null) {
			member = repo.findByMemberNumber(memberNumber);
			if (member != null) {
				memberCache.put(memberNumber, member);
			}
		}
		if (null == member && speculate) {
			member = getMember(MemberUtil.expandMemberNumber(memberNumber), false);
		}
		return member;
	}

}
