package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.riena.core.wire.InjectService;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.model.SubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.workarea.WorkareaManager;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.ui.managers.IAccountTransactionSearch;
import com.agritrace.edairy.desktop.finance.ui.views.AccountTransactionDetailsSubModuleView;

public class AccountTransactionListSubModuleController extends SubModuleController {

    private IAccountTransactionSearch service;

    private ITableRidget resultTable;
    private IActionRidget searchAction, clearAction, openAction;

    private ITextRidget firstNameRidget, lastNameRidget;

    private WritableValue selection;

    private AccountTransaction sample;

    private List<AccountTransaction> list = new ArrayList<AccountTransaction>();

    public AccountTransactionListSubModuleController(ISubModuleNode node) {
	super(node);
    }

    @InjectService(service = IAccountTransactionSearch.class)
    public void bind(IAccountTransactionSearch service) {
	this.service = service;
    }

    public void unbind(IAccountTransactionSearch service) {
	if (this.service == service)
	    this.service = null;
    }

    @Override
    public void configureRidgets() {
	resultTable = getRidget(ITableRidget.class, "tableRidget");
	searchAction = getRidget(IActionRidget.class, "searchAction");
	clearAction = getRidget(IActionRidget.class, "clearAction");
	openAction = getRidget(IActionRidget.class, "openAction");
	firstNameRidget = getRidget(ITextRidget.class, "firstNameRidget");
	lastNameRidget = getRidget(ITextRidget.class, "lastNameRidget");
    }

    @Override
    public void afterBind() {
	super.afterBind();
	String[] columnProperties = new String[] { 
		AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_DATE.getName(), 
		AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_ID.getName(), 
		AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_TYPE.getName(), 
		AccountPackage.Literals.ACCOUNT_TRANSACTION__DESCRIPTION.getName(), 
		AccountPackage.Literals.ACCOUNT_TRANSACTION__AMOUNT.getName(), 
	};
	String[] columnHeaders = new String[] { "Date", "Tx ID", "Type", "Description", "Amount" };
	Assert.isTrue(columnHeaders.length == columnProperties.length);

	resultTable.bindToModel(this, "list", AccountTransaction.class, columnProperties, columnHeaders);
	resultTable.updateFromModel();
	resultTable.addDoubleClickListener(new OpenListener());

	selection = new WritableValue();
	resultTable.bindSingleSelectionToModel(selection);

	searchAction.addListener(new SearchListener());
	firstNameRidget.bindToModel(sample, "firstName");
	lastNameRidget.bindToModel(sample, "lastName");
	clearAction.addListener(new ClearListener());
	openAction.addListener(new OpenListener());
    }

    private void openSelected() {
	Object selectedValue = selection.getValue();
	if (selectedValue == null)
	    return;

	if (!(selectedValue instanceof AccountTransaction))
	    throw new RuntimeException("Invalid datatype for selected value");

	AccountTransaction selected = (AccountTransaction) selectedValue;

	SubModuleNode child = new SubModuleNode(
		new NavigationNodeId(
			AccountTransaction.class.getName(), Long.toString(selected.getTransactionId())), 
			Long.toString(selected.getTransactionId()));

	child.setContext(AccountTransaction.class.getName(), selected);

	WorkareaManager.getInstance().registerDefinition(child, AccountTransactionDetailsSubModuleView.ID);

	getNavigationNode().addChild(child);
	child.activate();
    }

    public List<AccountTransaction> getList() {
	return list;
    }

    private class SearchListener implements IActionListener {
	@Override
	public void callback() {
	    AccountTransaction[] result = service.findAccountTransaction(sample);
	    list = Arrays.asList(result);

	    resultTable.updateFromModel();
	}
    }

    private class ClearListener implements IActionListener {
	@Override
	public void callback() {
	    sample.setTransactionId(-1);
	    sample.setSource("");

	    firstNameRidget.updateFromModel();
	    lastNameRidget.updateFromModel();
	}
    }

    private class OpenListener implements IActionListener {
	@Override
	public void callback() {
	    openSelected();
	}
    }
}
