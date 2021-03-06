package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.Date;
import org.apache.commons.collections.Predicate;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.model.util.MemberUtil;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controls.daterange.IDateRangeRidget;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberLookupAction;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberLookupDialog;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.internal.finance.ui.Activator;
import com.google.inject.Provider;

public abstract class TransactionJournalController<T extends Transaction>
		extends BasicDirectoryController<T> {

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
					final Membership membership = acct.getMember();
					ret = membership.equals(testMember);
					LOGGER.log(
							LogService.LOG_DEBUG,
							String.format(
									"comparing: arg('%s') to member('%s') returns: '%s'",
									membership, testMember, ret));
				}
			} else {
				if (null != obj) {
					throw new IllegalArgumentException("Objects of type: '"
							+ obj.getClass()
							+ "' are not valid for this operation.");
				} else {
					throw new IllegalArgumentException(
							"Invalid predicate parameter - (null).");
				}
			}
			return ret;
		}
	}

	private static final Logger LOGGER = Log4r.getLogger(
			Activator.getDefault(), TransactionJournalController.class);

	protected final TransactionJournalFilterBean filterBean = new TransactionJournalFilterBean();
	protected ITextRidget memberNameRidget;
	protected IDateRangeRidget dateRangeRidget;
	private IActionRidget memberLookupRidget;
	private final Provider<MemberLookupDialog> memberSearchProvider;

	// protected ITextRidget referenceNumberRidget;
	// protected ISingleChoiceRidget transactionSourceRidget;

	// abstract class requires subclass to
	protected TransactionJournalController(
			final Provider<MemberLookupDialog> memberSearchProvider) {
		this(null, memberSearchProvider);
	}

	protected TransactionJournalController(final ISubModuleNode node,
			final Provider<MemberLookupDialog> memberSearchProvider) {
		super(node);
		this.memberSearchProvider = memberSearchProvider;
	}

	@Override
	public void configureFilterRidgets() {
		dateRangeRidget = getRidget(IDateRangeRidget.class,
				FinanceBindingConstants.FILTER_DATE_RANGE);

		memberNameRidget = getRidget(ITextRidget.class,
				FinanceBindingConstants.FILTER_MEMBER_LOOKUP_TXT);
		memberNameRidget.setOutputOnly(true);

		memberLookupRidget = getRidget(IActionRidget.class,
				FinanceBindingConstants.FILTER_MEMBER_LOOKUP_BTN);
		memberLookupRidget.addListener(new MemberLookupAction() {
			@Override
			protected void callback(Membership selectedMember) {
				filterBean.setMember(selectedMember);
				memberNameRidget.setText(MemberUtil
						.formattedMemberName(selectedMember.getFarmer()));
			}

			@Override
			protected MemberLookupDialog getMemberSearchDialog() {
				return memberSearchProvider.get();
			}
		});
	}

	@Override
	public void afterBind() {
		super.afterBind();

		dateRangeRidget.bindToModel(
				BeansObservables.observeValue(filterBean, "startDate"),
				BeansObservables.observeValue(filterBean, "endDate"));
	}

//	protected Predicate buildFilterPredicate() {
//		final List<Predicate> predicateList = new ArrayList<Predicate>();
//		Predicate returnPredicate;
//
//		Date date;
//
//		date = filterBean.getStartDate();
//		if (date != null) {
//			predicateList
//					.add(NullIsTruePredicate
//							.getInstance(new FilterUtil.DateAfterPredicate(
//									date,
//									AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE
//											.getName())));
//		}
//
//		date = filterBean.getEndDate();
//		if (date != null) {
//			predicateList
//					.add(NullIsTruePredicate
//							.getInstance(new FilterUtil.DateBeforePredicate(
//									date,
//									AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE
//											.getName())));
//		}
//
//		final Membership member = filterBean.getMember();
//		if (member != null) {
//			predicateList.add(NullIsTruePredicate
//					.getInstance(new TransactionMemberEqualPredicate(member)));
//		}
//
//		// predicateList.add(NullIsTruePredicate.getInstance(new
//		// EqualPredicate(filterBean.getMember())));
//
//		if (predicateList.size() > 0) {
//			final Predicate[] predicates = new Predicate[predicateList.size()];
//			for (int i = 0; i < predicates.length; i++) {
//				predicates[i] = predicateList.get(i);
//			}
//			returnPredicate = new AllPredicate(predicates);
//		} else {
//			returnPredicate = TruePredicate.getInstance();
//		}
//
//		return returnPredicate;
//	}

	@Override
	protected T createNewModel() {
		final T transaction = super.createNewModel();
		transaction.setTransactionDate(new Date());
		return transaction;
	}

//	/**
//	 * todo: this will not work for long...
//	 * 
//	 * @return
//	 */
//	@Override
//	protected List<T> getFilteredResult() {
//		Membership member = filterBean.getMember();
//		List list = transactionRepo.findAccountTransactions(
//				member != null ? member.getAccount() : null,
//				filterBean.getStartDate(), filterBean.getEndDate());
//		return list;
//		// final List<T> filtered = new ArrayList<T>();
//		// final Predicate filterPredicate = buildFilterPredicate();
//		// try {
//		// for (final T tx : getRepository().all()) {
//		// if (filterPredicate.evaluate(tx)) {
//		// filtered.add(tx);
//		// }
//		// }
//		// } catch (final Exception e) {
//		// e.printStackTrace();
//		// }
//		// return filtered;
//	}

	@Override
	protected void resetFilterConditions() {
		filterBean.clear();
		memberNameRidget.setText("");
		updateAllRidgetsFromModel();
	}
}
