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
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.equinox.log.Logger;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.finance.ui.dialogs.AccountTransactionBatchEntryDialog;
import com.agritrace.edairy.desktop.finance.ui.dialogs.AccountTransactionEditDialog;
import com.agritrace.edairy.desktop.internal.finance.ui.Activator;

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

	public AccountTransactionJournalController() {
		this(null);
	}

	public AccountTransactionJournalController(ISubModuleNode node) {
		super(node);
		
		setEClass(AccountPackage.Literals.ACCOUNT_TRANSACTION);
		setRepository(new HibernateRepository<AccountTransaction>() {
			@Override
			protected Class<?> getClassType() {
				return AccountTransaction.class;
			}			
		});

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
		
//		ICompositeRidget typeRow = 
//			getRidget(ICompositeRidget.class, FinanceBindingConstants.FILTER_TYPE_ROW);
//		typeRow.setEnabled(false);
//		typeRow.setVisible(false);
	}


	@Override
	public void afterBind() {
		super.afterBind();

		referenceNumRidget.bindToModel(filterBean, "referenceNumber"); 

		sourceListRidget.bindToModel(Observables.staticObservableList(TransactionSource.VALUES, TransactionSource.class),
				BeansObservables.observeList(filterBean, "sourceOptions"));

		batchEditRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleBatchEntryAction();
			}
		});
		
		updateAllRidgetsFromModel();
	}

	protected void updateEntity(AccountTransaction updateableEntity) {
		// the 'all' has the side effect of flushing the currnet session.. this is what we want to do, not 'update'...
		getRepository().all();		
	}

	protected Predicate buildFilterPredicate() {

		Predicate superPredicate = super.buildFilterPredicate();
		
		final List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList.add(superPredicate);
		
		String refNum = filterBean.getReferenceNumber();
		if (refNum != null && refNum.length() > 0) {
			predicateList.add(NullIsTruePredicate.getInstance(new EqualPredicate(refNum)));
		}

		List<TransactionSource> sources = filterBean.getSourceOptions();
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
		final AccountTransactionBatchEntryDialog dialog = new AccountTransactionBatchEntryDialog();
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
	protected RecordDialog<AccountTransaction> getRecordDialog(Shell shell) {
		return new AccountTransactionEditDialog(shell);
	}

}
