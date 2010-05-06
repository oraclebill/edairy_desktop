package com.agritrace.edairy.riena.member.ui.views;

import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.model.tracking.TrackingFactory;

public class EMFObjectUtil {
	
	/**
	 * Create a Farm object
	 * @return
	 */
	public static Farm createFarm(){
		Farm farm = TrackingFactory.eINSTANCE.createFarm();
		Location location = ModelFactory.eINSTANCE.createLocation();
		PostalLocation postalLocation =  ModelFactory.eINSTANCE.createPostalLocation();
		location.setPostalLocation(postalLocation);
		farm.setLocation(location);
		return farm;
	}

}
