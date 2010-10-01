/**
 * 
 */
package com.agritrace.edairy.desktop.common.persistence;

import java.util.Date;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.internal.common.persistence.TransactionRepository;
import com.google.inject.ImplementedBy;

/**
 * @author bjones
 *
 */
@ImplementedBy(TransactionRepository.class)
public interface ITransactionRepository extends IRepository<Transaction> {
	List<Transaction> accountTransactionsInRange(Account account, Date start, Date end);
}
