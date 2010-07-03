package com.agritrace.edairy.desktop.finance.ui.dialogs;

import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.finance.ui.controllers.TransactionBatchEntryDelegate;

public class TransactionBatchEntryDialogController extends AbstractWindowController {

	private static final String[] LIST_COLUMN_HEADERS = { "ID", "Date", "Type", "Reference Number", "Member", "Amount" };

	private static final String[] LIST_PROPERTY_NAMES = { "id", "date", "source", "referenceNumber", "member", "amount" };

	@Override
	public void afterBind() {
		super.afterBind();
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();
		final IMasterDetailsRidget master = getRidget(IMasterDetailsRidget.class, "master");
		master.setDelegate(new TransactionBatchEntryDelegate());
		final List<AccountTransaction> transactionList = (List<AccountTransaction>) getContext("transaction-list");
		if (transactionList != null) {
			master.bindToModel(new WritableList(transactionList, AccountTransaction.class), AccountTransaction.class,
					LIST_PROPERTY_NAMES, LIST_COLUMN_HEADERS);
		} else {
			throw new IllegalStateException("ERR: no list in configureRidgets");
		}
	}

}
