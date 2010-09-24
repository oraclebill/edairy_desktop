/**
 * 
 */
package com.agritrace.edairy.desktop.common.persistence;

import java.util.Date;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;

/**
 * @author bjones
 *
 */
public interface ITransactionRepository extends IRepository<Transaction> {
	List<Transaction> accountTransactionsInRange(Account account, Date start, Date end);
}
