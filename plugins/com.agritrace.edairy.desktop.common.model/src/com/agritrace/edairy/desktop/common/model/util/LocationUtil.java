package com.agritrace.edairy.desktop.common.model.util;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;

public class LocationUtil {
	public static final String NONE_STRING = "(none)";
	
	public static String formatLocation(Location l) {		
		String formatted = NONE_STRING;
		if (l != null) {
			PostalLocation postal = l.getPostalLocation();			
			if (postal != null) {
				formatted = postal.getAddress() + ", " + postal.getVillage() + ", " + postal.getPostalCode();
			} 
			else if (l.getDescriptiveLocation() != null) {
				String directions = l.getDescriptiveLocation().getDirections();
				String landmarks = l.getDescriptiveLocation().getLandmarks();
				
				if (directions != null) formatted = directions;
				else if (landmarks != null) formatted = landmarks;				
			}
		}
		return formatted;
	}
}
