package com.agritrace.edairy.desktop.finance.payments;

import java.math.BigDecimal;
import java.util.Date;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;

public class MemberAccountManager {
	public MemberAccountManager() {

	}

	public void createBalancePoint(Account account, String string) {
		// TODO Auto-generated method stub
	}

	public void createDebit(Account primaryAcct,
			TransactionSource cashPayment, BigDecimal amountDue,
			String format) {
		// TODO Auto-generated method stub

	}

	public BigDecimal getCurrentDebitBalance(Account primaryAcct) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createCredit(Account primaryAcct,
			TransactionSource cashPayment, BigDecimal balance, String string) {
		// TODO Auto-generated method stub

	}

	public Date getEffectiveDate() {
		// TODO Auto-generated method stub
		return null;
	}
}