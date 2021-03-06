package com.agritrace.edairy.desktop.member.ui.data;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
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

	public LiveStockListViewTableNode(RegisteredAnimal animal) {
		this(getMembership(animal), animal);
	}

	public LiveStockListViewTableNode(Membership membership, RegisteredAnimal animal) {
		this.animal = animal;
		this.membership = membership;
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
	
	private static Membership getMembership(RegisteredAnimal animal) {
		Farm farm = (Farm) animal.eContainer();
		Farmer farmer = farm.getOwner();
		return (Membership) farmer.eContainer();
	}
	
}
