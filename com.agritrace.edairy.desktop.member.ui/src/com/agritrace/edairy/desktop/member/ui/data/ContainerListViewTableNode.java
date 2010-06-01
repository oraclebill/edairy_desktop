package com.agritrace.edairy.desktop.member.ui.data;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Container;

public class ContainerListViewTableNode {
	private Membership membership;
	
	private Container container;
	
	public ContainerListViewTableNode(Membership membership, Container container){
		this.membership = membership;
		this.container = container;
		
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

}
