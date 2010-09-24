package com.agritrace.edairy.desktop.finance.payments;

import org.junit.Test;

/**
 * The member payments processor performs the typical end-of-month accounting
 * process which applies payments owed from dairy to member to each members
 * account. Once this has been completed it is possible to understand how much
 * each member should be paid to clear their balances - these payments are
 * conducted by the bank and we generate a simple report that can be sent to the
 * bank for this purpose. Finally, once these two steps are complete, we can
 * apply a transaction to each members account to move their balance to zero,
 * and prepare for the next months transactions;
 * 
 * FULL DESCRIPTION -
 * 
 * For each members account we maintain a list of transactions. Each transaction
 * has a type and a source, where type is debit or credit and the source would
 * be store, vet, etc. In our scheme credits reduce the amount payable to the
 * farmer and debits increase it.
 * 
 * We also maintain a list of calculated balances. To determine the current
 * value of a members account we start with the most recent calculated balance
 * then add the values of all debit transactions whose entry-dates are more
 * recent than that balance, and subtract the value of all credit transactions
 * after that date. This gives us a 'current' balance.
 * 
 * Balances can be calculated at any time, but they are always calculated as a
 * result of the monthly payments process.
 * 
 * The payment process determines the amount a farmer is owed, or the amount the
 * farmer owes the dairy, taking into account all of the farmers credit
 * transactions, any cash deposits made by the farmer and the value of the
 * farmers milk deposits (as determined by volume and monthly price).
 * Consequently the member payout cannot be calculated before the monthly milk
 * price has been determined and entered into the system.
 * 
 * When the monthly milk price is entered into the system this should trigger
 * the beginning of the monthly payout process. The system will calculate, for
 * each member, the sum of their milk deliveries multiplied by the price. This
 * value will be used to create a debit transaction in the members account.
 * Since the credit transactions are already present, a balance is calculated at
 * this point that represents the end-of-month balance for that account.
 * 
 * Once all of the balances have been calculated, it is possible to run the
 * payment report. The payment report generates a list of all members and their
 * balances for members with positive balances. This report can be transmitted
 * to the bank to indicate how much to transfer from the Dairys account to each
 * members personal accounts as payment for that months milk.
 * 
 * When the payment report is run, it can be run with the option of clearing
 * positive balances. If this option is selected an additional credit
 * transaction will be created for each members account which will be equal to
 * their positive balance, this transaction will offset the balance bringing it
 * to zero. This transaction will be logged as a payment transaction.
 * 
 * The option of clearing the account or reconciling payments may also be an
 * independent option, so that it would not be necessary to run a report to
 * perform it.
 * 
 * 
 * @author bjones
 * 
 */
public class MemberPaymentsProcessorTest {
	
	@Test
	public void testGeneratePaymentReport() throws Exception {
	}

//	@Test
	public void testRunPaymentProcess() throws Exception {
	}

//	@Test
	public void testProcessMemberPayout() throws Exception {
	}

}
