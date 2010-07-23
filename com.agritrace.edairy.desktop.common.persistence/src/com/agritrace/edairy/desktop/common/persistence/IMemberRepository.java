package com.agritrace.edairy.desktop.common.persistence;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;

public interface IMemberRepository {

	/**
	 * Return a list of all farms owned by members of the 'local' dairy.
	 * 
	 * @return a list, never null.
	 */
	public List<Farm> getMemberFarms();

	/**
	 * Return a list of all farms owned by members of the 'local' dairy.
	 * 
	 * @return a list, never null.
	 */
	public List<Membership> all();

	public void update(Membership selectedMember);

	public void delete(Membership selectedMember);

	public void saveNew(Membership selectedMember);

	// /**
	// * Return a list of all farms owned by members of the specified dairy.
	// *
	// * @param d
	// * @return a list, never null.
	// */
	// List<Farm> getMemberFarms(Dairy d);
	//
	//
}
