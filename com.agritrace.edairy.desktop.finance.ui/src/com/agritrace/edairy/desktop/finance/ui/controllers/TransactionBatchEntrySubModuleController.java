package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IRidget;

import com.agritrace.edairy.desktop.common.model.dairy.account.*;
import com.agritrace.edairy.desktop.finance.ui.beans.TestAccountTransactionGenerator;

public class TransactionBatchEntrySubModuleController extends
		SubModuleController {

	private static final String[] columnPropertyNames = {
		"id", "store", "date", "referenceNumber", "memberId", "amount"
	};
	
	private static final String[] columnHeaders = {
		"ID", "Source", "Date", "Reference Number", "Member Id", "Amount"
	};
	
	List<AccountTransaction> testTransactions = TestAccountTransactionGenerator.INSTANCE.createTransactions(30);
	
	public TransactionBatchEntrySubModuleController(ISubModuleNode node) {
		super(node);
	}
	
	@Override
	public void addDefaultAction(IRidget focusRidget, IActionRidget action) {
		// TODO Auto-generated method stub
		super.addDefaultAction(focusRidget, action);
	}

	@Override
	public void configureRidgets() {
		// TODO Auto-generated method stub
		IMasterDetailsRidget ridgetMaster = getRidget(IMasterDetailsRidget.class, "master");
		ridgetMaster.setDelegate(new TransactionBatchEntryDelegate());
		ridgetMaster.bindToModel(
				getModel(), 
				AccountTransaction.class,
				columnPropertyNames,
				columnHeaders
				);
		ridgetMaster.updateFromModel();
	}
	
	private IObservableList getModel() {
		IObservableList oList = null;
		oList = new WritableList(testTransactions, AccountTransaction.class);
		return oList;
	}

	@Override
	public void afterBind() {
		// TODO Auto-generated method stub
		super.afterBind();
	}


}
