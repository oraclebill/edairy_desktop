package com.agritrace.edairy.desktop.services.ui.controllers;

import org.eclipse.core.databinding.conversion.Converter;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;

/**
 * @author wanhui
 *
 */
public class Member2StringConverter extends Converter {

	public Member2StringConverter() {
		super(Membership.class, String.class);
	}

	@Override
	public Object convert(Object fromObject) {
		if (fromObject instanceof Membership) {
			final Membership ship = (Membership) fromObject;
			final Farmer farmer = ship.getFarmer();
			return farmer.getGivenName() + " " + farmer.getFamilyName();
		}
		return null;
	}

}
