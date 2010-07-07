package com.agritrace.edairy.desktop.member.ui.controls;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.numbers.NumberAdapter;
import org.eclipse.emf.query.conditions.numbers.NumberCondition;
import org.eclipse.emf.query.conditions.numbers.NumberCondition.RelationalOperator;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
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
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberTransactionWidgetController implements WidgetController, DateRangeFilter {

	private IController controller;

	private DateRangeSearchController dateSearchController;
	private Membership member;

	private final String[] transactionColumnHeaders = { "ID", "Date", "Type", "Description", "Amount" };
	private final String[] transactionPropertyNames = { "transactionId", "transactionDate", "transactionType",
			"description", "amount" };
	private final List<AccountTransaction> transactionRecords = new ArrayList<AccountTransaction>();
	private ITableRidget transactionTable;

	public MemberTransactionWidgetController(IController controller) {
		this.controller = controller;
		configure();
	}

	@Override
	public void configure() {
		if (controller == null) {
			return;
		}
		transactionTable = controller.getRidget(ITableRidget.class, ViewWidgetId.TRANSACTION_TABLE);
		if (transactionTable == null) {
			return;
		}
		transactionTable.bindToModel(new WritableList(transactionRecords, AccountTransaction.class),
				AccountTransaction.class, transactionPropertyNames, transactionColumnHeaders);
		dateSearchController = new DateRangeSearchController(controller, ViewWidgetId.TRANSACTION_FILTER_STARTDATE,
				ViewWidgetId.TRANSACTION_FILTER_ENDDATE, ViewWidgetId.TRANSACTION_FILTER_STARTDATE_BUTTON,
				ViewWidgetId.TRANSACTION_FILTER_ENDDATE_BUTTON, this);

	}

	@Override
	public List<AccountTransaction> filter(String startDate, String endDate) {
		final List<AccountTransaction> objs = new ArrayList<AccountTransaction>();
		if (transactionTable == null) {
			return objs;
		}
		if ((transactionRecords != null) && !transactionRecords.isEmpty()) {
			try {
				final NumberAdapter.LongAdapter dateAdapter = new NumberAdapter.LongAdapter() {
					@Override
					public Long adapt(Object value) {
						return longValue(value);
					}

					@Override
					public long longValue(Object object) {
						return ((Date) object).getTime();
					}
				};

				final List<EObjectCondition> condtions = new ArrayList<EObjectCondition>();

				SELECT select = null;
				if (startDate != null) {
					// StartDate
					if (!"".equals(startDate)) {
						final Condition startDateCondition = new NumberCondition<Long>(DateTimeUtils.DATE_FORMAT.parse(
								startDate).getTime(), RelationalOperator.GREATER_THAN_OR_EQUAL_TO, dateAdapter);

						final EObjectAttributeValueCondition startDateAttributeCondition = new EObjectAttributeValueCondition(
								AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE, startDateCondition);
						condtions.add(startDateAttributeCondition);
					}
				}

				// End Date
				if (endDate != null) {
					if (!"".equals(endDate)) {
						final Condition endDateCondition = new NumberCondition<Long>(DateTimeUtils.DATE_FORMAT.parse(
								endDate).getTime() + 86400000l, RelationalOperator.LESS_THAN_OR_EQUAL_TO, dateAdapter);

						final EObjectAttributeValueCondition endDateAttributeCondition = new EObjectAttributeValueCondition(
								AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE, endDateCondition);
						condtions.add(endDateAttributeCondition);
					}
				}
				// AND all conditions
				if (condtions.size() > 0) {
					final EObjectCondition first = condtions.get(0);
					EObjectCondition ret = first;
					for (int i = 1; i < condtions.size(); i++) {
						ret = ret.AND(condtions.get(i));
					}
					select = new SELECT(new FROM(transactionRecords), new WHERE(ret));

				} else {
					select = new SELECT(new FROM(transactionRecords), new WHERE(EObjectCondition.E_TRUE));
				}
				final IQueryResult result = select.execute();
				for (final EObject object : result.getEObjects()) {
					objs.add((AccountTransaction) object);
				}

			} catch (final ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Activator.getDefault().logError(e, e.getMessage());
			} finally {
				transactionTable.bindToModel(new WritableList(objs, AccountTransaction.class),
						AccountTransaction.class, transactionPropertyNames, transactionColumnHeaders);
				transactionTable.updateFromModel();
			}
		}
		return objs;

	}

	@Override
	public IController getController() {
		return controller;
	}

	@Override
	public Object getInputModel() {
		return member;
	}

	@Override
	public void setController(IController controller) {
		this.controller = controller;
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
