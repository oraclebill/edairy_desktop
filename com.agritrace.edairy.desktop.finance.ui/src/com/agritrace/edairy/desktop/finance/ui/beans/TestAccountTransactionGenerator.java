package com.agritrace.edairy.desktop.finance.ui.beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.jface.viewers.ArrayContentProvider;

import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;

public class TestAccountTransactionGenerator {
	
	public static final TestAccountTransactionGenerator INSTANCE = new TestAccountTransactionGenerator();

	private Random rand = new Random();

	private static final String[] SOURCE_OPTIONS = { "Credit Sale", "Veterinary Services", "Cash Payment", "Share Deduction" };
	private static final String[] NAMES = { "Bill", "Walt", "Ginger", "Rodgers", "Antonia", "Lilly", "Sam", "Dave", "Cross", "Creed" }; 
	private static final TransactionType[] TRANSACTION_TYPES = TransactionType.values();

	public TestAccountTransactionGenerator() {
		
	}
	
	private String randomSelect(String[] options) {
		int selection = Math.abs(rand.nextInt()) % options.length;
		return options[selection];
	}

	private String randomSource() {
		return randomSelect(SOURCE_OPTIONS);
	}
	
	private Person randomPerson() {
		Person p =  ModelFactory.eINSTANCE.createPerson();
		p.setFamilyName(randomSelect(NAMES));
		p.setGivenName(randomSelect(NAMES));
		p.setMiddleName(randomSelect(NAMES));
		
		return p;		
	}

	private Membership randomMember() {
		Membership member = DairyFactory.eINSTANCE.createMembership();
		member.setMember(randomPerson());
		member.setMemberId(Long.toString(rand.nextLong()));
		return member;
	}
	
	private Account createTestAccount() {
		Account testAccount = AccountFactory.eINSTANCE.createAccount();
		testAccount.setAccountId(rand.nextLong());
		testAccount.setEstablished(new Date(rand.nextLong()));
		testAccount.setType("CREDIT");
		testAccount.setMember(randomMember());
		testAccount.getMember().setAccount(testAccount);
		return testAccount;
	}

	
	private TransactionType randomTransactionType() {
		int selection = Math.abs(rand.nextInt()) % TRANSACTION_TYPES.length;
		return TRANSACTION_TYPES[selection];
	}

	private AccountTransaction createTestAccountTransaction(int seq) {
		AccountTransaction temp = AccountFactory.eINSTANCE
				.createAccountTransaction();
		temp.setAccount(createTestAccount());
		temp.setAmount(rand.nextLong());
		temp.setDescription("test account # " + seq);
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

	public static void main(String[] args ) {
		TestAccountTransactionGenerator tg = new TestAccountTransactionGenerator();
		;
		System.err.println(tg.createTransactions(300));
	}
}