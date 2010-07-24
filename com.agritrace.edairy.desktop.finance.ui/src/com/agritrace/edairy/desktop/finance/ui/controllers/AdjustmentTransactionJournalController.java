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
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.ui.ridgets.ICompositeRidget;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.AdjustmentTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

public class AdjustmentTransactionJournalController extends TransactionJournalController {

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

	private final IMemberRepository memberRepo = DairyRepository.getInstance();
	private IMultipleChoiceRidget typeSetRidget;

	private ICompositeRidget sourceRow;

	public AdjustmentTransactionJournalController() {
		this(null);
	}

	public AdjustmentTransactionJournalController(ISubModuleNode node) {
		super(node);
		
		setEClass(AccountPackage.Literals.ADJUSTMENT_TRANSACTION);
		setRepository(new HibernateRepository<AccountTransaction>() {
			@Override
			protected Class<?> getClassType() {
				return AccountTransaction.class;
			}			
		});

		this.addTableColumn("ID", AccountPackage.Literals.TRANSACTION__TRANSACTION_ID);
		this.addTableColumn("Date", AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE);
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
		this.addTableColumn("Type", AccountPackage.Literals.TRANSACTION__TRANSACTION_TYPE);
		this.addTableColumn("Amount", AccountPackage.Literals.TRANSACTION__AMOUNT);
	}

	@Override
	public void configureFilterRidgets() {
		super.configureFilterRidgets();
		
		typeSetRidget = getRidget(IMultipleChoiceRidget.class, FinanceBindingConstants.FILTER_CHOICE_TX_SOURCE);		
		sourceRow = getRidget(ICompositeRidget.class, FinanceBindingConstants.FILTER_SOURCE_ROW);
	}


	@Override
	public void afterBind() {
		super.afterBind();

		typeSetRidget.bindToModel(Observables.staticObservableList(TransactionType.VALUES, TransactionType.class),
				BeansObservables.observeList(filterBean, "typeOptions"));
	
	}

	
	protected Predicate buildFilterPredicate() {
		Predicate superPredicate = super.buildFilterPredicate();
		
		final List<Predicate> predicateList = new ArrayList<Predicate>();

		predicateList.add(superPredicate);
		
		predicateList.add(NullIsTruePredicate.getInstance(new EqualPredicate(filterBean.getReferenceNumber())));

		predicateList.add(NullIsTruePredicate.getInstance(new TransactionTypeMatchPredicate(filterBean
				.getTypeOptions())));

		final Predicate[] predicates = new Predicate[predicateList.size()];
		for (int i = 0; i < predicates.length; i++) {
			predicates[i] = predicateList.get(i);
		}
		
		return new AllPredicate(predicates);
	}


	@Override
	protected RecordDialog<AdjustmentTransaction> getRecordDialog(Shell shell) {
		return new AdjustmentTransactionEditDialog(shell);
	}

}
