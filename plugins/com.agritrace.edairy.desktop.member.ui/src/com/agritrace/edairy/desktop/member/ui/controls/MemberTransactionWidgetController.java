package com.agritrace.edairy.desktop.member.ui.controls;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.ui.columnformatters.DatePropertyColumnFormatter;
import com.agritrace.edairy.desktop.common.ui.controllers.DateRangeFilter;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.controls.daterange.IDateRangeRidget;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberTransactionWidgetController implements WidgetController<Object>, DateRangeFilter {

	private static final String[] transactionColumnHeaders = { "Date", "Source", "Type", "Description", "Axmount" };
	private static final String[] transactionPropertyNames = { "transactionDate", "source", "transactionType", "description",
			"amount" };

	private final IRidgetContainer container;
	private ITableRidget transactionTable;
	private IDateRangeRidget dateRangeRidget;
	private IActionRidget updateButtonRidget;

	private IMemberRepository transactionRepo;
	private final List<Transaction> transactionRecords;
	private Membership member;

	public MemberTransactionWidgetController(IRidgetContainer controller, IMemberRepository transactionRepo ) {
		this.transactionRecords = new ArrayList<Transaction>();
		this.transactionRepo = transactionRepo;
		this.container = controller;
		configure();
	}

	@Override
	public void configure() {
		if (container == null) {
			return;
		}
		transactionTable = container.getRidget(ITableRidget.class, ViewWidgetId.TRANSACTION_TABLE);
		transactionTable.bindToModel(new WritableList(transactionRecords, AccountTransaction.class),
				AccountTransaction.class, transactionPropertyNames, transactionColumnHeaders);
		transactionTable.setColumnFormatter(0, new DatePropertyColumnFormatter(transactionPropertyNames[0]));

		dateRangeRidget = container.getRidget(IDateRangeRidget.class, ViewWidgetId.TRANSACTION_DATERANGE);
		dateRangeRidget.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				updateBinding();
			}
		});
		updateButtonRidget = container.getRidget(IActionRidget.class, ViewWidgetId.TRANSACTION_UPDATE_BTN);
		updateButtonRidget.setVisible(false);
//		updateButtonRidget.addListener(new IActionListener() {
//			@Override
//			public void callback() {
//				updateBinding();
//			}
//		});
	}

	@Override
	public List<AccountTransaction> filter(Date startDate, Date endDate) {
		// final List<AccountTransaction> objs = new
		// ArrayList<AccountTransaction>();
		// if (transactionTable == null) {
		// return objs;
		// }
		// final DateFilterUtil<AccountTransaction> filterUtil = new
		// DateFilterUtil<AccountTransaction>(
		// AccountTransaction.class,
		// AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE);
		// return filterUtil.filterDate(transactionRecords, startDate, endDate);
		throw new UnsupportedOperationException();
	}

	@Override
	public IRidgetContainer getContainer() {
		return container;
	}

	@Override
	public Object getInputModel() {
		return member;
	}

	@Override
	public void setController(IRidgetContainer container) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setInputModel(Object model) {
		// if (transactionTable == null) {
		// return;
		// }
		this.member = (Membership) model;
		// if (transactionTable != null) {
		updateBinding();
		// }
	}

	@Override
	public void updateBinding() {
		// if (transactionTable == null) {
		// return;
		// }
		Membership membership = (Membership) getInputModel();
		Date startDate = dateRangeRidget.getStartDate(), endDate = dateRangeRidget.getEndDate();

		transactionRecords.clear();
		transactionRecords.addAll(transactionRepo.findAccountTransactions(membership.getAccount(), startDate, endDate));
		transactionTable.updateFromModel();
	}

}
