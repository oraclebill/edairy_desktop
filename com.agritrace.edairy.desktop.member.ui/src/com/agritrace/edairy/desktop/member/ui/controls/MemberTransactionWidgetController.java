package com.agritrace.edairy.desktop.member.ui.controls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.DateRangeFilter;
import com.agritrace.edairy.desktop.common.ui.controllers.DateRangeSearchController;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.util.DateFilterUtil;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberTransactionWidgetController implements WidgetController<Object>, DateRangeFilter {

	private IRidgetContainer container;

	private DateRangeSearchController dateSearchController;
	private Membership member;

	private final String[] transactionColumnHeaders = { "ID", "Date", "Type", "Description", "Amount" };
	private final String[] transactionPropertyNames = { "transactionId", "transactionDate", "transactionType",
			"description", "amount" };
	private final List<AccountTransaction> transactionRecords = new ArrayList<AccountTransaction>();
	private ITableRidget transactionTable;

	public MemberTransactionWidgetController(IController controller) {
		this.container = controller;
		configure();
	}

	@Override
	public void configure() {
		if (container == null) {
			return;
		}
		transactionTable = container.getRidget(ITableRidget.class, ViewWidgetId.TRANSACTION_TABLE);
		if (transactionTable == null) {
			return;
		}
		transactionTable.bindToModel(new WritableList(transactionRecords, AccountTransaction.class),
				AccountTransaction.class, transactionPropertyNames, transactionColumnHeaders);
		dateSearchController = new DateRangeSearchController(container, ViewWidgetId.TRANSACTION_FILTER_STARTDATE,
				ViewWidgetId.TRANSACTION_FILTER_ENDDATE, ViewWidgetId.TRANSACTION_FILTER_STARTDATE_BUTTON,
				ViewWidgetId.TRANSACTION_FILTER_ENDDATE_BUTTON, this);

	}

	@Override
	public List<AccountTransaction> filter(Date startDate, Date endDate) {
		final List<AccountTransaction> objs = new ArrayList<AccountTransaction>();
		if (transactionTable == null) {
			return objs;
		}
		DateFilterUtil<AccountTransaction> filterUtil = new DateFilterUtil<AccountTransaction>(AccountTransaction.class,
				AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE);
		return filterUtil.filterDate(transactionRecords, startDate, endDate);
		
//
//		if ((transactionRecords != null) && !transactionRecords.isEmpty()) {
//			try {
//				final NumberAdapter.LongAdapter dateAdapter = new NumberAdapter.LongAdapter() {
//					@Override
//					public Long adapt(Object value) {
//						return longValue(value);
//					}
//
//					@Override
//					public long longValue(Object object) {
//						return ((Date) object).getTime();
//					}
//				};
//
//				final List<EObjectCondition> condtions = new ArrayList<EObjectCondition>();
//
//				SELECT select = null;
//				if (startDate != null) {
//					// StartDate
//					if (!"".equals(startDate)) {
//						final Condition startDateCondition = new NumberCondition<Long>(DateTimeUtils.DATE_FORMAT.parse(
//								startDate).getTime(), RelationalOperator.GREATER_THAN_OR_EQUAL_TO, dateAdapter);
//
//						final EObjectAttributeValueCondition startDateAttributeCondition = new EObjectAttributeValueCondition(
//								AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE, startDateCondition);
//						condtions.add(startDateAttributeCondition);
//					}
//				}
//
//				// End Date
//				if (endDate != null) {
//					if (!"".equals(endDate)) {
//						final Condition endDateCondition = new NumberCondition<Long>(DateTimeUtils.DATE_FORMAT.parse(
//								endDate).getTime() + 86400000l, RelationalOperator.LESS_THAN_OR_EQUAL_TO, dateAdapter);
//
//						final EObjectAttributeValueCondition endDateAttributeCondition = new EObjectAttributeValueCondition(
//								AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE, endDateCondition);
//						condtions.add(endDateAttributeCondition);
//					}
//				}
//				// AND all conditions
//				if (condtions.size() > 0) {
//					final EObjectCondition first = condtions.get(0);
//					EObjectCondition ret = first;
//					for (int i = 1; i < condtions.size(); i++) {
//						ret = ret.AND(condtions.get(i));
//					}
//					select = new SELECT(new FROM(transactionRecords), new WHERE(ret));
//
//				} else {
//					select = new SELECT(new FROM(transactionRecords), new WHERE(EObjectCondition.E_TRUE));
//				}
//				final IQueryResult result = select.execute();
//				for (final EObject object : result.getEObjects()) {
//					objs.add((AccountTransaction) object);
//				}
//
//			} catch (final ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				Activator.getDefault().logError(e, e.getMessage());
//			} finally {
//				transactionTable.bindToModel(new WritableList(objs, AccountTransaction.class),
//						AccountTransaction.class, transactionPropertyNames, transactionColumnHeaders);
//				transactionTable.updateFromModel();
//			}
//		}
//		return objs;

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
		this.container = container;
	}

	@Override
	public void setInputModel(Object model) {
		if (transactionTable == null) {
			return;
		}
		this.member = (Membership) model;
		if (transactionTable != null) {
			updateBinding();
		}

	}

	@Override
	public void updateBinding() {
		if (transactionTable == null) {
			return;
		}
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
