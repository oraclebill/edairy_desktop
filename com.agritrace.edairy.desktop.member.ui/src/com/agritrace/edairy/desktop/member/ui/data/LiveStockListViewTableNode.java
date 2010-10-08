package com.agritrace.edairy.desktop.member.ui.data;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;

/**
 * This class create instance of the table of
 * <code>LiveStockLitController</code>
 *
 * @author cin
 *
 */
public class LiveStockListViewTableNode {
	private RegisteredAnimal animal;

	private Membership membership;

	public LiveStockListViewTableNode(Membership membership, RegisteredAnimal animal) {
		this.membership = membership;
		this.animal = animal;
	}

	public RegisteredAnimal getAnimal() {
		return animal;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setAnimal(RegisteredAnimal animial) {
		this.animal = animial;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

}
