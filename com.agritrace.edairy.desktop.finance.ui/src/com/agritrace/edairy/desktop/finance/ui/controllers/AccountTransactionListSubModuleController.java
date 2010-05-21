package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.model.SubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IDateTextRidget;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.workarea.WorkareaManager;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.common.ui.managers.IAccountTransactionSearch;
import com.agritrace.edairy.desktop.finance.ui.views.AccountTransactionDetailsSubModuleView;

public class AccountTransactionListSubModuleController extends
		SubModuleController {

	private static class QueryBean {
		public Date startDate = new Date();
		public Date endDate = new Date();
		public Long memberId = new Long(0);
		public Set<TransactionType> sourceOptions = new HashSet<TransactionType>();

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public Long getMemberId() {
			return memberId;
		}

		public void setMemberId(Long memberId) {
			this.memberId = memberId;
		}

		public Set<TransactionType> getSourceOptions() {
			return sourceOptions;
		}

		public void setSourceOptions(Set<TransactionType> typeCodes) {
			this.sourceOptions = typeCodes;
		}

	}

	private IAccountTransactionSearch service;
	private ITableRidget resultTable;
	private IActionRidget searchAction, clearAction, openAction;
	private IDateTextRidget startDateRidget, endDateRidget;
	private ITextRidget memberIdRidget;
	private IMultipleChoiceRidget typeSetRidget;
	private WritableValue selection;
	private List<AccountTransaction> list = new ArrayList<AccountTransaction>();
	private QueryBean sample;

	public AccountTransactionListSubModuleController(ISubModuleNode node) {
		super(node);
		sample = new QueryBean();
	}

	@Override
	public void configureRidgets() {
		service = DairyDemoResourceManager.INSTANCE;
		resultTable = getRidget(ITableRidget.class, "tableRidget");
		searchAction = getRidget(IActionRidget.class, "searchAction");
		clearAction = getRidget(IActionRidget.class, "clearAction");
		openAction = getRidget(IActionRidget.class, "openAction");

		startDateRidget = getRidget(IDateTextRidget.class, "startDateRidget");
		endDateRidget = getRidget(IDateTextRidget.class, "endDateRidget");
		memberIdRidget = getRidget(ITextRidget.class, "memberIdRidget");
		typeSetRidget = getRidget(IMultipleChoiceRidget.class, "typeSetRidget");
	}

	@Override
	public void afterBind() {
		super.afterBind();
		String[] columnProperties = new String[] {
				AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_DATE
						.getName(),
				AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_ID
						.getName(),
				AccountPackage.Literals.ACCOUNT_TRANSACTION__SOURCE.getName(),
				AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_TYPE
						.getName(),
				AccountPackage.Literals.ACCOUNT_TRANSACTION__DESCRIPTION
						.getName(),
				AccountPackage.Literals.ACCOUNT_TRANSACTION__AMOUNT.getName(), };
		String[] columnHeaders = new String[] { "Date", "ID", "Source", "Type",
				"Description", "Amount" };
		Assert.isTrue(columnHeaders.length == columnProperties.length);

		resultTable.bindToModel(this, "list", AccountTransaction.class,
				columnProperties, columnHeaders);
		resultTable.updateFromModel();
		resultTable.addDoubleClickListener(new OpenListener());

		selection = new WritableValue();
		resultTable.bindSingleSelectionToModel(selection);

		searchAction.addListener(new SearchListener());

		startDateRidget.bindToModel(sample, "startDate");
		endDateRidget.bindToModel(sample, "endDate");
		memberIdRidget.bindToModel(sample, "memberId");
		List<String> valueLabels = new ArrayList<String>();
		for (TransactionType val : TransactionType.VALUES) {
			valueLabels.add(val.toString());
		}
		typeSetRidget.bindToModel(TransactionType.VALUES, valueLabels, sample,
				"sourceOptions");

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

		SubModuleNode child = new SubModuleNode(new NavigationNodeId(
				AccountTransaction.class.getName(), Long.toString(selected
						.getTransactionId())), Long.toString(selected
				.getTransactionId()));

		child.setContext(AccountTransaction.class.getName(), selected);

		WorkareaManager.getInstance().registerDefinition(child,
				AccountTransactionDetailsSubModuleView.ID);

		getNavigationNode().addChild(child);
		child.activate();
	}

	public List<AccountTransaction> getList() {
		return list;
	}

	private class SearchListener implements IActionListener {
		@Override
		public void callback() {
			AccountTransaction[] result = service.findAccountTransaction(
					sample.startDate, sample.endDate, sample.memberId,
					sample.sourceOptions);
			list = Arrays.asList(result);

			resultTable.updateFromModel();
		}
	}

	private class ClearListener implements IActionListener {
		@Override
		public void callback() {
			sample = new QueryBean();
			startDateRidget.updateFromModel();
			endDateRidget.updateFromModel();
			memberIdRidget.updateFromModel();
			typeSetRidget.updateFromModel();
		}
	}

	private class OpenListener implements IActionListener {
		@Override
		public void callback() {
			openSelected();
		}
	}
}
