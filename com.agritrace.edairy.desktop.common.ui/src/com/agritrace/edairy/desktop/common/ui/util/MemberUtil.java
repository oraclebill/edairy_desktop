package com.agritrace.edairy.desktop.common.ui.util;

import com.agritrace.edairy.desktop.common.model.base.Person;

public class MemberUtil {
	
	public static String formattedMemberName(Person member) {
		String ret = "";
		final Person person = member;
		if (check(person.getHonorific()))
			ret += person.getHonorific() + " ";

		if (check(person.getFamilyName()))
			ret += person.getFamilyName() + ", ";

		if (check(person.getGivenName()))
			ret += person.getGivenName() + " ";

		if (check(person.getMiddleName()))
			ret += person.getMiddleName() + " ";

		if (check(person.getAdditionalNames()))
			ret += "(" + person.getAdditionalNames() + ") ";

		if (check(person.getSuffix()))
			ret += person.getSuffix() + " ";
		return ret;
	}
	
	public static boolean check(String s) {
		return (null != s) && (s.length() > 0);
	}

}
