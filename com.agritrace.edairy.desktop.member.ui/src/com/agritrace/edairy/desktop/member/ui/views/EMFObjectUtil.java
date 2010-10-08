package com.agritrace.edairy.desktop.member.ui.views;

import java.util.Date;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingFactory;

public class EMFObjectUtil {

	/**
	 * Create a Farm object
	 *
	 * @return
	 */
	public static Farm createFarm() {
		final Farm farm = TrackingFactory.eINSTANCE.createFarm();
		final Location location = ModelFactory.eINSTANCE.createLocation();
		final PostalLocation postalLocation = ModelFactory.eINSTANCE.createPostalLocation();
		location.setPostalLocation(postalLocation);
		farm.setLocation(location);
		return farm;
	}

	public static Membership createMembership() {
		final Membership member1 = DairyFactory.eINSTANCE.createMembership();
		final long now = System.currentTimeMillis();
		member1.setMemberId(now);
		final Date appliedDate = new Date(now);
		member1.setApplicationDate(appliedDate);

		final Farmer member = TrackingFactory.eINSTANCE.createFarmer();
		member1.setMember(member);

		final Location memberLocation = ModelFactory.eINSTANCE.createLocation();
		final PostalLocation defaultLocation = ModelFactory.eINSTANCE.createPostalLocation();
		memberLocation.setPostalLocation(defaultLocation);
		member.setLocation(memberLocation);
		return member1;
	}

}
