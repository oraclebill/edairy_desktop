package com.agritrace.edairy.desktop.internal.common.persistence;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import org.junit.Before;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountStatus;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingFactory;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.csvreader.CsvReader;

public class TransactionTestCase {

	private String testFile = "../test-data/member-transactions/06.210.stores.csv";

	public void setTestFile(String testFile) {
		this.testFile = testFile;
	}

	public String getTestFile() {
		return testFile;
	}

	@Before
	public void setup() throws Exception {
//		HsqldbMemoryPersistenceManager pm = new HsqldbMemoryPersistenceManager();
//		PersistenceManager.setDefault(pm);

		final Dairy dairy = DairyFactory.eINSTANCE.createDairy();
		dairy.setCompanyName("test");
		dairy.setDescription("");
		dairy.setRegistrationNumber("");
		dairy.setLocation(DairyUtil.createLocation(null, null, null));
		dairy.setPhoneNumber("");

		final CsvReader reader = new CsvReader(
				getTestFile());

		// HEADERS:
		// Type,Date,Reference,Member No.,Class,Amount

		reader.readHeaders();
		while (reader.readRecord()) {
			final AccountTransaction tx = createTransaction(reader.getValues());
			if ( tx != null ) {
				dairy.getMemberships().add(tx.getAccount().getMember());
			}
			else {
				System.err.println("Import failed on line : " + reader.getCurrentRecord());
				System.err.println("Import failed for : " + Arrays.toString(reader.getValues()));
			}
		}

//		DairyRepository.getInstance().save(dairy);

	}

	final static HashMap<String, Account> accounts = new HashMap<String, Account>();
	final static int TYPE = 0, DATE = 1, REFNO = 2, MEMBER = 3, CLASS = 4,
			AMOUNT = 5;
	final static DateFormat TX_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

	protected Account getAccount(String accountNo) {
		Account account = accounts.get(accountNo);
		if (account == null) {
			account = createAccount(accountNo);
			accounts.put(accountNo, account);
		}
		return account;
	}

	protected AccountTransaction createTransaction(String[] record) {
		final AccountTransaction tx = AccountFactory.eINSTANCE
				.createAccountTransaction();
		tx.setAccount(getAccount(record[MEMBER]));
		Date txDate = null;
		try {
			txDate = TX_FORMAT.parse(record[DATE]);
		} catch (final ParseException pe) {
			pe.printStackTrace();
			return null;
		}

		tx.setTransactionDate(txDate);
		tx.setTransactionType(TransactionType.CREDIT);
		try {
			final Number num = NumberFormat.getInstance().parse(record[AMOUNT]);
			tx.setAmount(new BigDecimal(num.doubleValue()));
		} catch (final Exception e) {
			e.printStackTrace();
			System.err.println(record[AMOUNT]);
			return null;
		}
		tx.setReferenceNumber(record[REFNO]);
		tx.setSource(TransactionSource.CLINICAL_SERVICES);

		return tx;
	}

	protected Account createAccount(String accountNo) {
		final Farmer farmer = TrackingFactory.eINSTANCE.createFarmer();
		farmer.setNickName(accountNo);

		final Membership member = DairyFactory.eINSTANCE.createMembership();
		member.setMemberNumber(accountNo);
		member.setApplicationDate(new Date());
		member.setStatus(MembershipStatus.ACTIVE);

		member.setMember(farmer);

		final Account account = AccountFactory.eINSTANCE.createAccount();
		account.setAccountNumber(accountNo);
		account.setStatus(AccountStatus.ACTIVE);
		account.setMember(member);
		member.setAccount(account);

		return account;
	}
}
