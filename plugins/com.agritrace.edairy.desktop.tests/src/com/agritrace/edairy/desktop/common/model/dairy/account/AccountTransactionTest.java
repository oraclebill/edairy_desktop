package com.agritrace.edairy.desktop.common.model.dairy.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;

public class AccountTransactionTest {

	@Test
	public void testESetAmount() throws Exception {
		final AccountTransaction at = AccountFactory.eINSTANCE.createAccountTransaction();
			at.eSet(AccountPackage.Literals.TRANSACTION__AMOUNT, 12);
			assertEquals(at.getAmount(), new Integer(12));
	}

	@Test
	public void testSetAmount() throws Exception {
		final AccountTransaction at = AccountFactory.eINSTANCE.createAccountTransaction();
		try {
			at.setAmount(new BigDecimal(12));
			assertEquals(at.getAmount(), new BigDecimal(12));
		} catch (final Exception e) {
			fail(e.toString());
		}
	}
}
