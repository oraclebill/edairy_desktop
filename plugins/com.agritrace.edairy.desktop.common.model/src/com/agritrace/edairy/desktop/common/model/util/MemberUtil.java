package com.agritrace.edairy.desktop.common.model.util;

import com.agritrace.edairy.desktop.common.model.base.Person;

public final class MemberUtil {
	private MemberUtil() {
	}

	public static boolean check(String s) {
		return null != s && s.length() > 0;
	}

	public static String formattedMemberName(Person person) {
		return formattedMemberName(person.getHonorific(), person.getGivenName(), person.getMiddleName(),
				person.getFamilyName(), person.getSuffix(), person.getAdditionalNames());
	}

	public static String formattedMemberName(String honorific, String first, String middle, String last, String additional,
			String suffix) {
		String ret = "";
		if (check(honorific)) {
			ret += honorific + " ";
		}

		if (check(last)) {
			ret += last + ", ";
		}

		if (check(first)) {
			ret += first + " ";
		}

		if (check(middle)) {
			ret += middle + " ";
		}

		if (check(additional)) {
			ret += "(" + additional + ") ";
		}

		if (check(suffix)) {
			ret += suffix + " ";
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
