package com.agritrace.edairy.desktop.member.ui.views;

import java.util.Date;

import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.Person;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.Membership;
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

	public static Membership createMembership(){
		Membership member1 = DairyFactory.eINSTANCE.createMembership();
		long now = System.currentTimeMillis();
		Date appliedDate = new Date(now);;
		member1.setApplicationDate(appliedDate);

		Person member = ModelFactory.eINSTANCE.createPerson();
		member1.setMember(member);

		Location memberLocation = ModelFactory.eINSTANCE.createLocation();
		PostalLocation defaultLocation = ModelFactory.eINSTANCE.createPostalLocation();
		memberLocation.setPostalLocation(defaultLocation);
		member.setLocation(memberLocation);
		return member1;
	}

}
