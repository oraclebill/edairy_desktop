package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.AllPredicate;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.NullIsTruePredicate;
import org.eclipse.equinox.log.Logger;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.model.dairy.security.Permission;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.finance.ui.dialogs.AccountTransactionBatchEntryDialog;
import com.agritrace.edairy.desktop.finance.ui.dialogs.AccountTransactionEditDialog;
import com.agritrace.edairy.desktop.internal.finance.ui.Activator;
import com.google.inject.Inject;
import com.google.inject.Provider;

@PermissionRequired(Permission.VIEW_TRANSACTIONS)
public class AccountTransactionJournalController extends TransactionJournalController<AccountTransaction> {

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

	// ridgets specific to an AccountTransaction
	private static final Logger LOGGER = Log4r.getLogger(Activator.getDefault(), AccountTransactionJournalController.class);

	private IMultipleChoiceRidget sourceListRidget;
	private ITextRidget referenceNumRidget;
	private IActionRidget batchEditRidget;

	private final Provider<AccountTransactionEditDialog> editDialogProvider;
	private final Provider<AccountTransactionBatchEntryDialog> batchEntryProvider;

	@Inject
	public AccountTransactionJournalController(final IRepository<AccountTransaction> repo,
			final Provider<MemberSearchDialog> memberSearchProvider,
			final Provider<AccountTransactionEditDialog> editDialogProvider,
			final Provider<AccountTransactionBatchEntryDialog> batchEntryProvider) {
		super(memberSearchProvider);
		this.editDialogProvider = editDialogProvider;
		this.batchEntryProvider = batchEntryProvider;

		setEClass(AccountPackage.Literals.ACCOUNT_TRANSACTION);
		setRepository(repo);

		this.addTableColumn("ID", AccountPackage.Literals.TRANSACTION__TRANSACTION_ID);
		this.addTableColumn("Date", AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE);
		this.addTableColumn("Source", AccountPackage.Literals.ACCOUNT_TRANSACTION__SOURCE);
		this.addTableColumn("Ref. Num.", AccountPackage.Literals.ACCOUNT_TRANSACTION__REFERENCE_NUMBER);
		this.addTableColumn("Account ID", "account.member.member.familyName", String.class );
		this.addTableColumn("Amount", AccountPackage.Literals.TRANSACTION__AMOUNT);
	}

	@Override
	public void configureFilterRidgets() {
		super.configureFilterRidgets();

		referenceNumRidget = getRidget(ITextRidget.class, FinanceBindingConstants.FILTER_TXT_REF_NO);
		sourceListRidget = getRidget(IMultipleChoiceRidget.class, FinanceBindingConstants.FILTER_CHOICE_TX_SOURCE);
		batchEditRidget = getRidget(IActionRidget.class, FinanceBindingConstants.ID_BTN_BATCH_ENTRY);
	}


	@Override
	public void afterBind() {
		super.afterBind();

		referenceNumRidget.bindToModel(filterBean, "referenceNumber");

		sourceListRidget.bindToModel(filterBean, "sourceOptions", filterBean, "sourceSelections");
		sourceListRidget.updateFromModel();

//		sourceListRidget.addSelectionListener(new ISelectionListener() {
//			@Override
//			public void ridgetSelected(SelectionEvent event) {
//				List<TransactionSource> selection = (List<TransactionSource>)
//					sourceListRidget.getSelection();
//
//				filterBean.getSourceSelections().clear();
//				filterBean.getSourceSelections().addAll(selection);
//
//				System.err.println("Selection: " + selection);
//			}
//		});

		batchEditRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleBatchEntryAction();
			}
		});

		updateAllRidgetsFromModel();
	}

	@Override
	protected void updateEntity(AccountTransaction updateableEntity) {
		// the 'all' has the side effect of flushing the currnet session.. this is what we want to do, not 'update'...
		getRepository().all();
	}

	@Override
	protected Predicate buildFilterPredicate() {

		final Predicate superPredicate = super.buildFilterPredicate();

		final List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList.add(superPredicate);

		final String refNum = filterBean.getReferenceNumber();
		if (refNum != null && refNum.length() > 0) {
			predicateList.add(NullIsTruePredicate.getInstance(new EqualPredicate(refNum)));
		}

		final List<TransactionSource> sources = filterBean.getSourceSelections();
		System.err.println("Sources: " + sources);
		if (sources != null && sources.size() > 0) {
			predicateList.add(NullIsTruePredicate.getInstance(new TransactionSourceMatchPredicate(sources)));
		}

		final Predicate[] predicates = new Predicate[predicateList.size()];
		for (int i = 0; i < predicates.length; i++) {
			predicates[i] = predicateList.get(i);
		}

		return new AllPredicate(predicates);
	}

	private void handleBatchEntryAction() {
		final AccountTransactionBatchEntryDialog dialog = batchEntryProvider.get();
		final List<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
		dialog.getController().setContext("tranaction-list", transactionList);
		final int returnCode = dialog.open();

		if (returnCode == Window.OK) {
			for (final AccountTransaction tx : transactionList) {
				getRepository().saveNew(tx);
			}

			refreshTableContents();
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
	protected RecordDialog<AccountTransaction> getRecordDialog(Shell shell) {
		return editDialogProvider.get();
	}

}
