/**
 * 
 */
package com.agritrace.edairy.desktop.common.persistence;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.internal.common.persistence.TransactionRepository;
import com.google.inject.ImplementedBy;

/**
 * @author bjones
 * 
 */
@ImplementedBy(TransactionRepository.class)
public interface ITransactionRepository extends IRepository<Transaction> {

	//
	public static enum BalanceType {
		STARTING, ENDING
	};

	//
	// QUERIES
	//

	List<Transaction> findAccountTransactions(Account account, Date start, Date end);

	BalancePoint findLatestBalancePoint(Account primaryAcct);

	BigDecimal calculateBalance(Account primaryAcct, Date cutoffDate);

	BigDecimal calculateBalance(Account primaryAcct);

	//
	// MUTATORS
	//

	AccountTransaction createCredit(Account primaryAcct, TransactionSource cashPayment, BigDecimal totalPayment,
			String string);

	AccountTransaction createDebit(Account primaryAcct, TransactionSource cashPayment, BigDecimal totalPayment,
			String format);

	BalancePoint createBalancePoint(Account primaryAcct, Calendar balanceDate, BigDecimal startingBalance);

	// BalancePoint createBalancePoint(Account primaryAcct, BalanceType type,
	// int month, int year, BigDecimal value);
	// BalancePoint createPeriodBalancePoint(Account primaryAcct, BalanceType
	// starting, int priceYear, int priceMonth,
	// String string);
	// void createPeriodBalancePoint(Account primaryAcct, BalanceType starting,
	// int month, int year, BigDecimal startingBalance);

	//
	// Utility
	//
	Calendar createPeriodDate(BalanceType starting, int priceMonth, int priceYear);
}
