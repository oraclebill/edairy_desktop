package com.agritrace.edairy.dairy.ui.util;

import org.eclipse.emf.ecore.EObject;

public class EMFUtil {
    public static boolean compare(EObject src, EObject dst) {
	if (src == null && dst == null) {
	    return true;
	}
	if (src == null || dst == null) {
	    return false;
	}

	final String str1 = src.toString();
	final String str2 = dst.toString();
	return str1.substring(str1.indexOf('('), str1.indexOf(')')).equals(
		str2.substring(str2.indexOf('('), str2.indexOf(')')));
    }

}
