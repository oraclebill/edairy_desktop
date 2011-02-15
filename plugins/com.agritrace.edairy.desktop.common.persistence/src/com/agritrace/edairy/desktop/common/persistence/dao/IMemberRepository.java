package com.agritrace.edairy.desktop.common.persistence.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.IRepository;

public interface IMemberRepository extends IRepository<Membership> {

	/**
	 * Return a list of all farms owned by members of the 'local' dairy.
	 *
	 * @return a list, never null.
	 */
	public List<Farm> getMemberFarms();

	public List<Account> allAccounts();

	public Account findAccountByMemberNo(String memberNo);

	public Collection<? extends Transaction> findAccountTransactions(Account account, Date startDate, Date endDate);

	public Membership findByMemberNumber(String memberNumber);

	public List<String> findAllMemberNumbers(boolean activeOnly);

}
