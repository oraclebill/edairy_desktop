package com.agritrace.edairy.desktop.services.ui.controllers;

import org.eclipse.core.databinding.conversion.IConverter;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;

/**
 * @author wanhui
 * 
 */
public class Member2StringConverter implements IConverter {

	@Override
	public Object getFromType() {
		return Membership.class;
	}

	@Override
	public Object getToType() {
		return String.class;
	}

	@Override
	public Object convert(Object fromObject) {
		if (fromObject instanceof Membership) {
			Membership ship = (Membership) fromObject;
			Farmer farmer = ship.getMember();
			return farmer.getGivenName() + " " + farmer.getFamilyName();
		}
		return null;
	}

}
