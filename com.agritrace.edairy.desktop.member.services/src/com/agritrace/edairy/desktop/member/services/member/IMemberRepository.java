package com.agritrace.edairy.desktop.member.services.member;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.services.IRepository;

public interface IMemberRepository extends IRepository<Membership> {
	
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
	public List<Membership> getMemberships();

	public IRepository<AccountTransaction> getTransactionRepository();
	
//	/**
//	 * Return a list of all farms owned by members of the specified dairy.
//	 * 
//	 * @param d
//	 * @return a list, never null.
//	 */
//	List<Farm> getMemberFarms(Dairy d);
//	
//	
}
