package com.agritrace.edairy.desktop.member.ui.data;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;

public class FarmListViewTableNode {

	private Farm farm;

	private Membership membership;

	public FarmListViewTableNode(Membership membership, Farm farm) {
		this.membership = membership;
		this.farm = farm;
	}

	public Farm getFarm() {
		return farm;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

}
