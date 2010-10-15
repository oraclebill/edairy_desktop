package com.agritrace.edairy.desktop.common.ui.util;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.core.databinding.observable.Realm;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.util.DateFilterUtil;

public class DateFilterUtilTest {

	class TestRealm extends Realm {
		@Override
		public boolean isCurrent() {
			return true;
		}

		@Override
		public void exec(Runnable runnable) {
			// TODO Auto-generated method stub
			super.exec(runnable);
		}
	}

	@Test
	public void testDateCompareIgnoresTime() throws Exception {
		Realm.runWithDefault(new TestRealm(), new Runnable() {

			@Override
			public void run() {
				final List<Account> list = new LinkedList<Account>();

				final Date beforeAll = new Date();
				try {
					Thread.sleep(1000);
				} catch (final InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				final Date transactionDate = new Date();
				try {
					Thread.sleep(1000);
				} catch (final InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				final Date afterAll = new Date();

				final Account account = AccountFactory.eINSTANCE.createAccount();
				account.setAccountNumber("TEST123");
				account.setEstablished(transactionDate);
				list.add(account);


				final DateFilterUtil<Account> filterUtil = new DateFilterUtil<Account>(Account.class,
						AccountPackage.Literals.ACCOUNT__ESTABLISHED);

				List<Account> result = filterUtil.filterDate(list, beforeAll, afterAll);
				Assert.assertEquals(1, result.size());

				result = filterUtil.filterDate(list, afterAll, beforeAll);
				Assert.assertEquals(0, result.size());

				result = filterUtil.filterDate(list,  beforeAll, transactionDate);
				Assert.assertEquals(1, result.size());


			}

		});


	}


	@Test
	public void testDateFilterUtil() throws Exception {

		Realm.runWithDefault(new TestRealm(), new Runnable() {

			@Override
			public void run() {
				final List<Account> list = new LinkedList<Account>();
				final Calendar cal = Calendar.getInstance();
				final int STARTYEAR = 1990;
				for (int i = 0; i < 20; i++) {
					final Account account = AccountFactory.eINSTANCE.createAccount();
					cal.set(STARTYEAR + i, 6, 1);
					account.setAccountNumber("" + i);
					account.setEstablished(cal.getTime());
					list.add(account);
				}
				cal.set(1975, 1, 1);
				final Date beforeAll = cal.getTime();
				cal.set(2000, 1, 1);
				final Date midWay = cal.getTime();
				cal.set(2100, 1, 1);
				final Date afterAll = cal.getTime();
				final DateFilterUtil<Account> filterUtil = new DateFilterUtil<Account>(Account.class,
						AccountPackage.Literals.ACCOUNT__ESTABLISHED);
				List<Account> result = filterUtil.filterDate(list, beforeAll, midWay);
				Assert.assertEquals(10, result.size());
				result = filterUtil.filterDate(list, beforeAll, afterAll);
				Assert.assertEquals(20, result.size());

				cal.set(2001, 5, 29);
				final Date d2001_05_29 = cal.getTime();

				cal.set(2002, 5, 29);
				final Date d2002_05_29 = cal.getTime();

				result = filterUtil.filterDate(list, d2001_05_29, d2002_05_29);
				Assert.assertEquals(1, result.size());
			}

		});

	}

	@Test
	public void testDateFilterUtilPerformance() throws Exception {

		Realm.runWithDefault(new TestRealm(), new Runnable() {

			@Override
			public void run() {
				final List<Account> list = new LinkedList<Account>();
				final Calendar cal = Calendar.getInstance();
				final int STARTYEAR = 1990;
				cal.set(STARTYEAR, 0, 1);
				for (int i = 0; i < 100000; i++) {
					final Account account = AccountFactory.eINSTANCE.createAccount();
					cal.add(Calendar.DAY_OF_YEAR, i);
					account.setAccountNumber("" + i);
					account.setEstablished(cal.getTime());
					list.add(account);
				}

				cal.set(1975, 1, 1);
				final Date beforeAll = cal.getTime();
				cal.set(2000, 1, 1);
				final Date midWay = cal.getTime();
				cal.set(2100, 1, 1);
				cal.getTime();
				final DateFilterUtil<Account> filterUtil = new DateFilterUtil<Account>(Account.class,
						AccountPackage.Literals.ACCOUNT__ESTABLISHED);

				final long start = System.currentTimeMillis();
				filterUtil.filterDate(list, beforeAll, midWay);
				final long end = System.currentTimeMillis();
				System.out.println(end - start);
				Assert.assertTrue(start - end < 1000);
			}

		});

	}
}
