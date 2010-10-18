package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.Predicate;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AdjustmentTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.finance.ui.dialogs.AdjustmentTransactionEditDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

public final class AdjustmentTransactionJournalController extends TransactionJournalController<AdjustmentTransaction> {

	static class TransactionTypeMatchPredicate implements Predicate {
		final private Set<TransactionType> testSources = new HashSet<TransactionType>();

		TransactionTypeMatchPredicate(List<TransactionType> sources) {
			this.testSources.addAll(sources);
		}

		TransactionTypeMatchPredicate(TransactionType... sources) {
			this(Arrays.asList(sources));
		}

		@Override
		public boolean evaluate(Object obj) {
			boolean ret = false;
			if (obj instanceof AdjustmentTransaction) {
				final AdjustmentTransaction tx = (AdjustmentTransaction) obj;
				final TransactionType src = tx.getTransactionType();
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

	// private final IMemberRepository memberRepo = RepositoryFactory.getMemberRepository();
	private IMultipleChoiceRidget typeSetRidget;

	private final Provider<AdjustmentTransactionEditDialog> dialogProvider;

	@Inject
	public AdjustmentTransactionJournalController(final IRepository<AdjustmentTransaction> repo,
			final Provider<MemberSearchDialog> memberSearchProvider,
			final Provider<AdjustmentTransactionEditDialog> dialogProvider) {
		super(memberSearchProvider);
		this.dialogProvider = dialogProvider;

		setEClass(AccountPackage.Literals.ADJUSTMENT_TRANSACTION);
		setRepository(repo);

//		this.addTableColumn("ID", AccountPackage.Literals.TRANSACTION__TRANSACTION_ID);
		this.addTableColumn("Date", AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE);
		this.addTableColumn("Account ID", AccountPackage.Literals.TRANSACTION__ACCOUNT, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				String ret = "n/a";
				if (element instanceof Account) {
					final Account acct = (Account) element;
					try {
						Person member = acct.getMember().getMember();
						ret = String.format("%s %s", member.getGivenName(), member.getFamilyName());
					} catch (final Exception e) {
						ret = "account # " + acct.getAccountId();
					}
				}
				return ret;
			}

		});

		this.addTableColumn("Type", AccountPackage.Literals.TRANSACTION__TRANSACTION_TYPE);
		this.addTableColumn("Amount", AccountPackage.Literals.TRANSACTION__AMOUNT);
//		this.addTableColumn("Approver", AccountPackage.Literals.ADJUSTMENT_TRANSACTION__SIGNED_OFF_BY);
		this.addTableColumn("Description", AccountPackage.Literals.TRANSACTION__DESCRIPTION);
	}

	@Override
	public void configureFilterRidgets() {
		super.configureFilterRidgets();

		typeSetRidget = getRidget(IMultipleChoiceRidget.class, FinanceBindingConstants.FILTER_CHOICE_TX_SOURCE);
	}


	@Override
	public void afterBind() {
		super.afterBind();

		final List<String> optionValues = Arrays.asList("Credit Adjustment", "Debit Adjustment");
		typeSetRidget.bindToModel(TransactionType.VALUES, optionValues, filterBean, "typeSelections");
		typeSetRidget.updateFromModel();
	}


//	@Override
//	protected Predicate buildFilterPredicate() {
//		final Predicate superPredicate = super.buildFilterPredicate();
//
//		final List<Predicate> predicateList = new ArrayList<Predicate>();
//		predicateList.add(superPredicate);
//		predicateList.add(NullIsTruePredicate.getInstance(
//				new TransactionTypeMatchPredicate(filterBean.getTypeOptions())));
//
//		return new AllPredicate(predicateList.toArray(new Predicate[predicateList.size()]));
//	}
//

	@Override
	protected RecordDialog<AdjustmentTransaction> getRecordDialog(Shell shell) {
		return dialogProvider.get();
	}

	@Override
	protected List<AdjustmentTransaction> getFilteredResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
