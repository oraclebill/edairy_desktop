package com.agritrace.edairy.desktop.finance.ui.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.model.util.DairyUtil;

public class TestAccountTransactionGenerator {

	public static final TestAccountTransactionGenerator INSTANCE = new TestAccountTransactionGenerator();

	// static final TransactionSource[] SOURCE_OPTIONS = { "Credit Sale",
	// "Veterinary Services", "Cash Payment", "Share Deduction" };
	static final String[] NAMES = { "Bill", "Walt", "Ginger", "Rodgers", "Antonia", "Lilly", "Sam", "Dave", "Cross",
			"Creed" };

	static final TransactionType[] TRANSACTION_TYPES = TransactionType.values();

	public static void main(String[] args) {
		final TestAccountTransactionGenerator tg = new TestAccountTransactionGenerator();
		;
		System.err.println(tg.createTransactions(300));
	}

	Random rand = new Random();

	public TestAccountTransactionGenerator() {

	}

	public List<AccountTransaction> createTransactions(int count) {
		final List<AccountTransaction> txList = new ArrayList<AccountTransaction>();

		for (int i = 0; i < count; i++) {
			txList.add(createTestAccountTransaction(i));
		}

		return txList;
	}

	Account createTestAccount(Membership member) {
		final Account testAccount = AccountFactory.eINSTANCE.createAccount();
		testAccount.setAccountId(rand.nextLong());
		testAccount.setEstablished(randomDate());
		testAccount.setType("CREDIT");
		testAccount.setMember(member);
		testAccount.setAccountNumber("V"+member.getMemberNumber());
		testAccount.getMember().setAccount(testAccount);
		return testAccount;
	}

	AccountTransaction createTestAccountTransaction(Account acct, int seq) {
		final AccountTransaction temp = AccountFactory.eINSTANCE.createAccountTransaction();
		temp.setAccount(acct);
		temp.setAmount(new BigDecimal(rand.nextInt()));
		temp.setDescription("test account transaction # " + seq);
		temp.setSource(randomSource());
		temp.setTransactionId(rand.nextLong());
		temp.setTransactionType(randomTransactionType());
		temp.setTransactionDate(new Date(System.currentTimeMillis()));
		return temp;
	}

	AccountTransaction createTestAccountTransaction(int seq) {
		return createTestAccountTransaction(randomAccount(), seq);
	}

	Account randomAccount() {
		return createTestAccount(randomMember());
	}

	@SuppressWarnings("deprecation")
	Date randomDate() {
		final int year = rand.nextInt(10) + 2000;
		final int month = rand.nextInt(12);
		final int day = rand.nextInt(28);
		final Date d = new Date(year, month, day);

		return d;
	}

	Membership randomMember() {
		final Membership member = DairyFactory.eINSTANCE.createMembership();
		member.setFarmer(randomPerson());
		// member.setMemberId(Long.toString(rand.nextLong()));
		return member;
	}

	Farmer randomPerson() {
		final Farmer p = DairyUtil.createFarmer(randomSelect(NAMES), randomSelect(NAMES), randomSelect(NAMES), "",
				(Farm) null);

		return p;
	}

	<X> X randomSelect(List<X> options) {
		final int selection = Math.abs(rand.nextInt()) % options.size();
		return options.get(selection);
	}

	<X> X randomSelect(X[] options) {
		return randomSelect(Arrays.asList(options));
	}

	TransactionSource randomSource() {
		return randomSelect(TransactionSource.VALUES);
	}

	TransactionType randomTransactionType() {
		final int selection = Math.abs(rand.nextInt()) % TRANSACTION_TYPES.length;
		return TRANSACTION_TYPES[selection];
	}
}