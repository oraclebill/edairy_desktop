package com.agritrace.edairy.desktop.finance.ui.navigation;

import java.util.Collection;

import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.finance.ui.controllers.AccountTransactionJournalController;
import com.agritrace.edairy.desktop.finance.ui.controllers.AdjustmentTransactionJournalController;
import com.agritrace.edairy.desktop.finance.ui.controllers.MemberPaymentsViewController;
import com.agritrace.edairy.desktop.finance.ui.controllers.MilkPriceJournalController;
import com.agritrace.edairy.desktop.finance.ui.controllers.PaymentRequestViewController;
import com.google.inject.AbstractModule;

public class FinanceModule extends AbstractModule {
	public static void contributeControllers(Collection<Class<? extends IController>> list) {
		list.add(AccountTransactionJournalController.class);
		list.add(AdjustmentTransactionJournalController.class);
		list.add(MilkPriceJournalController.class);
		list.add(MemberPaymentsViewController.class);
		list.add(PaymentRequestViewController.class);
	}

	@Override
	protected void configure() {

	}
}
