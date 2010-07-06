package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.AllPredicate;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.NullIsTruePredicate;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.FilterUtil;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.finance.ui.dialogs.MemberTransactionEditDialog;
import com.agritrace.edairy.desktop.finance.ui.dialogs.TransactionBatchEntryDialog;
import com.agritrace.edairy.desktop.member.services.member.IMemberRepository;
import com.agritrace.edairy.desktop.member.services.member.MemberRepository;

public class MemberTransactionRegisterController extends BasicDirectoryController<AccountTransaction> {

	static class TransactionMemberEqualPredicate implements Predicate {
		final private Membership testMember;

		TransactionMemberEqualPredicate(Membership testMember) {
			this.testMember = testMember;
		}

		@Override
		public boolean evaluate(Object obj) {
			boolean ret = false;
			if (obj instanceof AccountTransaction) {
				final AccountTransaction tx = (AccountTransaction) obj;
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

	static class TransactionSourceMatchPredicate implements Predicate {
		final private Set<TransactionSource> testSources = new HashSet<TransactionSource>();

		TransactionSourceMatchPredicate(List<TransactionSource> sources) {
			this.testSources.addAll(sources);
		}

		TransactionSourceMatchPredicate(TransactionSource... sources) {
			this(Arrays.asList(sources));
		}

		@Override
		public boolean evaluate(Object obj) {
			boolean ret = false;
			if (obj instanceof AccountTransaction) {
				final AccountTransaction tx = (AccountTransaction) obj;
				final TransactionSource src = tx.getSource();
				if (src != null) {
					ret = testSources.contains(src);
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

	private IActionRidget batchEditRidget;
	private final MemberTransactionFilterBean filterBean = new MemberTransactionFilterBean();
	private ITextRidget memberNameRidget;

	private final IMemberRepository memberRepo = new MemberRepository();
	private IDateTimeRidget startDateRidget, endDateRidget;
	private final List<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
	private IMultipleChoiceRidget typeSetRidget;
	IComboRidget referenceNumRidget;

	public MemberTransactionRegisterController() {
		this(null);
	}

	public MemberTransactionRegisterController(ISubModuleNode node) {
		super(node);
		setEClass(AccountPackage.Literals.ACCOUNT_TRANSACTION);
		setRepository(memberRepo.getTransactionRepository());

		this.addTableColumn("ID", AccountPackage.Literals.TRANSACTION__TRANSACTION_ID);
		this.addTableColumn("Date", AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE);
		this.addTableColumn("Source", AccountPackage.Literals.ACCOUNT_TRANSACTION__SOURCE);
		this.addTableColumn("Ref. Num.", AccountPackage.Literals.ACCOUNT_TRANSACTION__REFERENCE_NUMBER);
		this.addTableColumn("Account ID", AccountPackage.Literals.TRANSACTION__ACCOUNT, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				String ret = "n/a";
				if (element instanceof Account) {
					final Account acct = (Account) element;
					try {
						ret = acct.getMember().getMember().getFamilyName();
					} catch (final Exception e) {
						ret = "account # " + acct.getAccountId();
					}
				}
				return ret;
			}

		});
		this.addTableColumn("Amount", AccountPackage.Literals.TRANSACTION__AMOUNT);
	}

	@Override
	public void afterBind() {
		super.afterBind();

		startDateRidget.bindToModel(filterBean, "startDate");

		endDateRidget.bindToModel(filterBean, "endDate");

		memberNameRidget.bindToModel(PojoObservables.observeDetailValue(
				PojoObservables.observeValue(filterBean, "member"), "memberId", String.class));

		referenceNumRidget.bindToModel(Observables.staticObservableList(memberRepo.all(), Membership.class),
				Membership.class, "getMemberId", PojoObservables.observeValue(filterBean, "member"));

		typeSetRidget.bindToModel(Observables.staticObservableList(TransactionSource.VALUES, TransactionSource.class),
				BeansObservables.observeList(filterBean, "sourceOptions"));

		batchEditRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleBatchEntryAction();
			}
		});
	}

	@Override
	public void configureFilterRidgets() {

		startDateRidget = getRidget(IDateTimeRidget.class, FinanceBindingConstants.FILTER_DATE_START_DATE);
		// startDateRidget.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
		endDateRidget = getRidget(IDateTimeRidget.class, FinanceBindingConstants.FILTER_DATE_END_DATE);
		// endDateRidget.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);

		referenceNumRidget = getRidget(IComboRidget.class, FinanceBindingConstants.FILTER_TXT_REF_NO);
		memberNameRidget = getRidget(ITextRidget.class, FinanceBindingConstants.FILTER_TXT_MEMBER_LOOKUP);
		typeSetRidget = getRidget(IMultipleChoiceRidget.class, FinanceBindingConstants.FILTER_CHOICE_TX_SOURCE);
		batchEditRidget = getRidget(IActionRidget.class, FinanceBindingConstants.ID_BTN_BATCH_ENTRY);
	}

	private Predicate buildFilterPredicate() {
		final List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList
				.add(NullIsTruePredicate.getInstance(FilterUtil.createDateAfterPredicate(filterBean.getStartDate())));

		predicateList
				.add(NullIsTruePredicate.getInstance(FilterUtil.createDateBeforePredicate(filterBean.getEndDate())));

		predicateList.add(NullIsTruePredicate.getInstance(new TransactionMemberEqualPredicate(filterBean.getMember())));

		predicateList.add(NullIsTruePredicate.getInstance(new EqualPredicate(filterBean.getReferenceNumber())));

		predicateList.add(NullIsTruePredicate.getInstance(new TransactionSourceMatchPredicate(filterBean
				.getSourceOptions())));

		final Predicate[] predicates = new Predicate[predicateList.size()];
		for (int i = 0; i < predicates.length; i++) {
			predicates[i] = predicateList.get(i);
		}
		return new AllPredicate(predicates);
	}

	private void handleBatchEntryAction() {
		final TransactionBatchEntryDialog dialog = new TransactionBatchEntryDialog();
		final ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
		dialog.getController().setContext("tranaction-list", transactionList);
		final int returnCode = dialog.open();
		if (returnCode == Window.OK) {
			for (final AccountTransaction tx : transactionList) {
				getRepository().saveNew(tx);
			}
		} else {
			for (final AccountTransaction tx : transactionList) {
				if (tx != null) {
					tx.setAccount(null);
					tx.setRelatedLocation(null);
				}
			}
		}
	}

	@Override
	protected AccountTransaction createNewModel() {
		final AccountTransaction transaction = super.createNewModel();
		transaction.setTransactionDate(new Date());
		return transaction;
	}

	/**
	 * todo: this will not work for long...
	 * 
	 * @return
	 */
	@Override
	protected List<AccountTransaction> getFilteredResult() {
		final List<AccountTransaction> filtered = new ArrayList<AccountTransaction>();
		final Predicate filterPredicate = buildFilterPredicate();
		for (final AccountTransaction tx : getRepository().all()) {
			if (filterPredicate.evaluate(tx)) {
				filtered.add(tx);
			}
		}
		return filtered;
	}

	@Override
	protected RecordDialog<AccountTransaction, ?> getRecordDialog(Shell shell) {
		return new MemberTransactionEditDialog(shell);
	}

	@Override
	protected void resetFilterConditions() {
		filterBean.clear();
		updateAllRidgetsFromModel();
	}
}
