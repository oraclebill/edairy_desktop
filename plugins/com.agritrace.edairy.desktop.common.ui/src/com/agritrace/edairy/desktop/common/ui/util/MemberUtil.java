package com.agritrace.edairy.desktop.common.ui.util;

import com.agritrace.edairy.desktop.common.model.base.Person;

public final class MemberUtil {
	private MemberUtil() {}

	public static boolean check(String s) {
		return null != s && s.length() > 0;
	}

	public static String formattedMemberName(Person member) {
		String ret = "";
		final Person person = member;
		if (check(person.getHonorific())) {
			ret += person.getHonorific() + " ";
		}

		if (check(person.getFamilyName())) {
			ret += person.getFamilyName() + ", ";
		}

		if (check(person.getGivenName())) {
			ret += person.getGivenName() + " ";
		}

		if (check(person.getMiddleName())) {
			ret += person.getMiddleName() + " ";
		}

		if (check(person.getAdditionalNames())) {
			ret += "(" + person.getAdditionalNames() + ") ";
		}

		if (check(person.getSuffix())) {
			ret += person.getSuffix() + " ";
		}
		return ret;
	}

	public static String expandMemberNumber(String memberNumber) {
		if (memberNumber.length() < 5) {
			memberNumber = "00000".substring(0, 5 - memberNumber.length()) + memberNumber;
		}
		
		return memberNumber;
	}
}
