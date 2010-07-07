package com.agritrace.edairy.desktop.member.ui.data;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Container;

public class ContainerListViewTableNode {
	private Container container;

	private Membership membership;

	public ContainerListViewTableNode(Membership membership, Container container) {
		this.membership = membership;
		this.container = container;

	}

	public Container getContainer() {
		return container;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

}
