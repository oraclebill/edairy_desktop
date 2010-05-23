package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;

public class MemberTransactionWidgetController implements WidgetController {
	
	private IController controller;
	
	private Membership member;
	
	private ITableRidget transactionTable;
	private final String[] transactionPropertyNames = { "transactionId", "transactionDate", "transactionType",
			"description", "amount" };
	private final String[] transactionColumnHeaders = { "ID", "Date", "Type", "Description", "Amount" };
	private final List<AccountTransaction> transactionRecords = new ArrayList<AccountTransaction>();
	
	public MemberTransactionWidgetController(SubModuleController controller){
		this.controller = controller;
		configue();
	}

	@Override
	public void configue() {
		transactionTable = controller.getRidget(ITableRidget.class, ViewWidgetId.TRANSACTION_TABLE);
		transactionTable.bindToModel(new WritableList(transactionRecords, AccountTransaction.class),
				AccountTransaction.class, transactionPropertyNames, transactionColumnHeaders);

	}

	@Override
	public Object getInputModel() {
		return member;
	}

	@Override
	public void setInputModel(Object model) {
		this.member =(Membership)model;
		if(transactionTable != null){
			updateBinding();
		}

	}

	@Override
	public IController getController() {
		return controller;
	}

	@Override
	public void setController(IController controller) {
		this.controller = controller;
 	}

	@Override
	public void updateBinding() {
		transactionRecords.clear();
		transactionRecords.addAll(getAccountTransactions());
		transactionTable.setColumnFormatter(1, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof AccountTransaction) {
					final Date entryDate = ((AccountTransaction) element).getTransactionDate();
					final SimpleFormattedDateBean dateFormatter = new SimpleFormattedDateBean();
					dateFormatter.setDate(entryDate);
					return dateFormatter.getFormattedDate();
				}
				return null;
			}
		});
		// transactionTable.updateFromModel();
	}
	
	private List<AccountTransaction> getAccountTransactions() {
		final List<AccountTransaction> transactions = new ArrayList<AccountTransaction>();
		return transactions;
	}

}
