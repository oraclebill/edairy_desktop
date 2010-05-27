package com.agritrace.edairy.desktop.finance.ui.beans;

import java.util.Collections;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;

public class TestAccountTransactionGenerator {

	public static final TestAccountTransactionGenerator INSTANCE = new TestAccountTransactionGenerator();

	Random rand = new Random();

	static final String[] SOURCE_OPTIONS = { "Credit Sale", "Veterinary Services", "Cash Payment", "Share Deduction" };
	static final String[] NAMES = { "Bill", "Walt", "Ginger", "Rodgers", "Antonia", "Lilly", "Sam", "Dave", "Cross",
			"Creed" };
	static final TransactionType[] TRANSACTION_TYPES = TransactionType.values();

	public TestAccountTransactionGenerator() {

	}

	String randomSelect(String[] options) {
		int selection = Math.abs(rand.nextInt()) % options.length;
		return options[selection];
	}

	String randomSource() {
		return randomSelect(SOURCE_OPTIONS);
	}

	@SuppressWarnings("deprecation")
	Date randomDate() {
		int year = rand.nextInt(10) + 2000;
		int month = rand.nextInt(12);
		int day = rand.nextInt(28);
		Date d = new Date(year, month, day);

		return d;
	}

	Farmer randomPerson() {
		Farmer p = DairyUtil.createFarmer(randomSelect(NAMES), randomSelect(NAMES),randomSelect(NAMES), "",  (Farm)null); 
				
		return p;
	}

	Membership randomMember() {
		Membership member = DairyFactory.eINSTANCE.createMembership();
		member.setMember(randomPerson());
//		member.setMemberId(Long.toString(rand.nextLong()));
		return member;
	}

	Account randomAccount() {
		return createTestAccount(randomMember());
	}

	Account createTestAccount(Membership member) {
		Account testAccount = AccountFactory.eINSTANCE.createAccount();
		testAccount.setAccountId(rand.nextLong());
		testAccount.setEstablished(randomDate());
		testAccount.setType("CREDIT");
		testAccount.setMember(member);
		testAccount.getMember().setAccount(testAccount);
		return testAccount;
	}

	TransactionType randomTransactionType() {
		int selection = Math.abs(rand.nextInt()) % TRANSACTION_TYPES.length;
		return TRANSACTION_TYPES[selection];
	}

	AccountTransaction createTestAccountTransaction(int seq) {
		return createTestAccountTransaction(randomAccount(), seq);
	}

	AccountTransaction createTestAccountTransaction(Account acct, int seq) {
		AccountTransaction temp = AccountFactory.eINSTANCE.createAccountTransaction();
		temp.setAccount(acct);
		temp.setAmount(rand.nextLong());
		temp.setDescription("test account transaction # " + seq);
		temp.setSource(randomSource());
		temp.setTransactionId(rand.nextLong());
		temp.setTransactionType(randomTransactionType());
		return temp;
	}

	public List<AccountTransaction> createTransactions(int count) {
		List<AccountTransaction> txList = new ArrayList<AccountTransaction>();

		for (int i = 0; i < 100; i++) {
			txList.add(createTestAccountTransaction(i));
		}

		return txList;
	}

	public static void main(String[] args) {
		TestAccountTransactionGenerator tg = new TestAccountTransactionGenerator();
		;
		System.err.println(tg.createTransactions(300));
	}
}