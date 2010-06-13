package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.Collection;

public class MatchUtil {
	public static boolean matchContains(String userValue, String entityValue) {
		if (userValue == null || userValue.trim().length() == 0)
			return true;
		if (entityValue.contains(userValue))
			return true;
		return false;
	}

	public static boolean matchContains(Object userValue, Collection<String> entityValue) {
		if (userValue == null || userValue.toString().trim().length() == 0)
			return true;
		if (entityValue.contains(userValue))
			return true;
		return false;
	}

	public static <T> boolean matchEquals(T userValue, T entityValue) {
		if (userValue == null) 
			return true;
		return userValue.equals(entityValue);
	}


	public static boolean matchEquals(Object userValue, String entityValue) {
		if (userValue == null) 
			return true;
		return matchEquals(userValue.toString(), entityValue);
	}

	public static boolean matchEquals(String userValue, String entityValue) {
		if (userValue == null || userValue.trim().length() == 0)
			return true;
		if (entityValue.equals(userValue))
			return true;
		return false;
	}
	

}
