package com.agritrace.edairy.desktop.member.ui.data;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;

public class FarmListViewTableNode {
	
	private Membership membership;
	
	private Farm farm;
	
	public FarmListViewTableNode(Membership membership, Farm farm){
		this.membership = membership;
		this.farm = farm;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	public Farm getFarm() {
		return farm;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
	}

}
