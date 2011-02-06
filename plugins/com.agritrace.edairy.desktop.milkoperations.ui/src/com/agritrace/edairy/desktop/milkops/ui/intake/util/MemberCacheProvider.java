package com.agritrace.edairy.desktop.milkops.ui.intake.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.milkops.ui.intake.collectionline.IMemberLookup;

public class MemberCacheProvider implements IMemberLookup {

	private final Map<String, Membership> memberCache = new HashMap<String, Membership>();

	public MemberCacheProvider(Collection<Membership> members) {
		for (final Membership member : members) {
			System.err.printf("Adding member %s: %s \n", member.getMemberNumber(), member.getMember().getFamilyName());
			memberCache.put(member.getMemberNumber(), member);
		}
	}

	@Override
	public Membership getMember(String memberNumber) {
		return memberCache.get(memberNumber);
	}

}
