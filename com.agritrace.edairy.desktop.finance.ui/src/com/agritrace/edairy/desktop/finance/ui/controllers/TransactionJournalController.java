package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.AllPredicate;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.NullIsTruePredicate;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controls.daterange.IDateRangeRidget;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.common.ui.util.FilterUtil;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;

public abstract class TransactionJournalController<T extends Transaction> extends BasicDirectoryController<T> {

	static class TransactionMemberEqualPredicate implements Predicate {
		final private Membership testMember;

		TransactionMemberEqualPredicate(Membership testMember) {
			this.testMember = testMember;
		}

		@Override
		public boolean evaluate(Object obj) {
			boolean ret = false;
			if (obj instanceof Transaction) {
				final Transaction tx = (Transaction) obj;
				final Account acct = tx.getAccount();
				if (acct != null) {
					ret = acct.getMember() == testMember;
				}
			} else {
				if (null != obj) {
					throw new IllegalArgumentException("Objects of type: '" + obj.getClass()
							+ "' are not valid for this operation.");
				} else {
					throw new IllegalArgumentException("Invalid predicate parameter - (null).");
				}
			}
			return ret;
		}
	}

	/**
	 * Open member search dialog, IActionListener for search button
	 * 
	 */
	public class MemberLookupAction implements IActionListener {
		@Override
		public void callback() {
			final MemberSearchDialog memberDialog = new MemberSearchDialog(null);
			final int retVal = memberDialog.open();
			if (retVal == Window.OK) {
				filterBean.setMember(memberDialog.getSelectedMember());
			}
		}
	}

	protected final TransactionJournalFilterBean filterBean = new TransactionJournalFilterBean();
	protected ITextRidget memberNameRidget;
	protected IDateRangeRidget dateRangeRidget;
	private IActionRidget memberLookupRidget;
//	protected ITextRidget referenceNumberRidget;
//	protected ISingleChoiceRidget transactionSourceRidget;

	// abstract class requires subclass to
	protected TransactionJournalController() {
		this(null);
	}

	protected TransactionJournalController(final ISubModuleNode node) {
		super(node);
	}

	@Override
	public void configureFilterRidgets() {

		dateRangeRidget = getRidget(IDateRangeRidget.class, FinanceBindingConstants.FILTER_DATE_RANGE);
		
		memberNameRidget = getRidget(ITextRidget.class, FinanceBindingConstants.FILTER_MEMBER_LOOKUP_TXT);
		memberNameRidget.setOutputOnly(true);
		
		memberLookupRidget = getRidget(IActionRidget.class, FinanceBindingConstants.FILTER_MEMBER_LOOKUP_BTN);
		memberLookupRidget.addListener(new MemberLookupAction());
		
//		referenceNumberRidget = getRidget(ITextRidget.class, FinanceBindingConstants.FILTER_TXT_REF_NO);
		
//		transactionSourceRidget = getRidget(ISingleChoiceRidget.class, FinanceBindingConstants.FILTER_CHOICE_TX_SOURCE);
	}

	@Override
	public void afterBind() {
		super.afterBind();

		dateRangeRidget.bindToModel(BeansObservables.observeValue(filterBean, "startDate"), 
				BeansObservables.observeValue(filterBean, "endDate"));
		
		memberNameRidget.bindToModel(filterBean, "member.memberId" );
		
//		referenceNumberRidget.bindToModel(filterBean, "referenceNumber"); 
		
//		transactionSourceRidget.bindToModel(filterBean, "sourceOptions", filterBean, "transactionSource");
	}

	protected Predicate buildFilterPredicate() {
		final List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList
				.add(NullIsTruePredicate.getInstance(
						FilterUtil.createDateAfterPredicate(filterBean.getStartDate())));

		predicateList
				.add(NullIsTruePredicate.getInstance(
						FilterUtil.createDateBeforePredicate(filterBean.getEndDate())));

		predicateList.add(
				NullIsTruePredicate.getInstance(
						new TransactionMemberEqualPredicate(filterBean.getMember())));
		predicateList.add(
				NullIsTruePredicate.getInstance(
						new EqualPredicate(filterBean.getMember())));

		final Predicate[] predicates = new Predicate[predicateList.size()];
		for (int i = 0; i < predicates.length; i++) {
			predicates[i] = predicateList.get(i);
		}
		return new AllPredicate(predicates);
	}

	@Override
	protected T createNewModel() {
		final T transaction = super.createNewModel();
		transaction.setTransactionDate(new Date());
		return transaction;
	}

	@Override
	protected void createEntity(T newEntity) {
		super.createEntity(newEntity);
	}

	@Override
	protected void updateEntity(T updateableEntity) {
		super.updateEntity(updateableEntity);
	}

	/**
	 * todo: this will not work for long...
	 * 
	 * @return
	 */
	@Override
	protected List<T> getFilteredResult() {
		final List<T> filtered = new ArrayList<T>();
		final Predicate filterPredicate = buildFilterPredicate();
		for (final T tx : getRepository().all()) {
			if (filterPredicate.evaluate(tx)) {
				filtered.add(tx);
			}
		}
		return filtered;
	}

	@Override
	protected void resetFilterConditions() {
		filterBean.clear();
		updateAllRidgetsFromModel();
	}
}
