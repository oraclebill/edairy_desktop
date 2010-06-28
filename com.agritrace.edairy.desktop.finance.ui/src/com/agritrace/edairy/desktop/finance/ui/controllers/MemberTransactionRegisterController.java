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
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.riena.navigation.ISubModuleNode;
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
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.FilterUtil;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.finance.ui.beans.TestAccountTransactionGenerator;
import com.agritrace.edairy.desktop.finance.ui.dialogs.MemberTransactionEditDialog;
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
				AccountTransaction tx = (AccountTransaction) obj;
				Account acct = tx.getAccount();
				if (acct != null) {
					ret = acct.getMember() == testMember;
				}
			} else {
				if (null != obj)
					throw new IllegalArgumentException("Objects of type: '" + obj.getClass()
							+ "' are not valid for this operation.");
				else
					throw new IllegalArgumentException("Invalid predicate parameter - (null).");
			}
			return ret;
		}
	}

	static class TransactionSourceMatchPredicate implements Predicate {
		final private Set<TransactionSource> testSources = new HashSet<TransactionSource>();

		TransactionSourceMatchPredicate(TransactionSource... sources) {
			this(Arrays.asList(sources));
		}
		
		TransactionSourceMatchPredicate(List<TransactionSource> sources) {
			this.testSources.addAll(sources);
		}

		@Override
		public boolean evaluate(Object obj) {
			boolean ret = false;
			if (obj instanceof AccountTransaction) {
				AccountTransaction tx = (AccountTransaction) obj;
				TransactionSource src = tx.getSource();
				if (src != null) {
					ret = testSources.contains(src);
				}
			} else {
				if (null != obj)
					throw new IllegalArgumentException("Objects of type: '" 
							+ obj.getClass()
							+ "' are not valid for this operation.");
				else
					throw new IllegalArgumentException("Invalid predicate parameter - (null).");
			}
			return ret;
		}
	}
	
	private final IMemberRepository memberRepo = new MemberRepository();
	private List<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
	private final MemberTransactionFilterBean filterBean = new MemberTransactionFilterBean();

	private IDateTimeRidget startDateRidget, endDateRidget;
	private ITextRidget memberNameRidget;
	IComboRidget referenceNumRidget; 
	private IMultipleChoiceRidget typeSetRidget;

	public MemberTransactionRegisterController() {
		this(null);
	}

	public MemberTransactionRegisterController(ISubModuleNode node) {
		super(node);
		setEClass(AccountPackage.Literals.ACCOUNT_TRANSACTION);
//		setEntityClass(AccountTransaction.class);
		// TEST
		//		setRepository(memberRepo.getTransactionRepository());

		setRepository( new IRepository<AccountTransaction>() {

			@Override
			public List<?> find(String rawQuery) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<?> find(String query, Object[] params) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<AccountTransaction> all() {
				// TODO Auto-generated method stub
				
				TestAccountTransactionGenerator ret = new TestAccountTransactionGenerator();
				return ret.createTransactions(30);
			}

			@Override
			public AccountTransaction findByKey(long key) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void saveNew(AccountTransaction newEntity) throws AlreadyExistsException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void update(AccountTransaction updateableEntity) throws NonExistingEntityException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void delete(AccountTransaction deletableEntity) throws NonExistingEntityException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void save(Object obj) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.addTableColumn("ID", AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_ID);
		this.addTableColumn("Date", AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_DATE);
		this.addTableColumn("Source", AccountPackage.Literals.ACCOUNT_TRANSACTION__SOURCE);
		this.addTableColumn("Ref. Num.", AccountPackage.Literals.ACCOUNT_TRANSACTION__REFERENCE_NUMBER);
		this.addTableColumn("Account ID", AccountPackage.Literals.ACCOUNT_TRANSACTION__ACCOUNT, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				String ret = "n/a";
				if (element instanceof Account) {
					Account acct = (Account)element;
					try {
						ret = acct.getMember().getMember().getFamilyName();
					}
					catch(Exception e) {
						ret = "account # " + acct.getAccountId();
					}
				}
				return ret;
			}
			
		});
		this.addTableColumn("Amount", AccountPackage.Literals.ACCOUNT_TRANSACTION__AMOUNT);
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
	}
	
	
	/**
	 * todo: this will not work for long...
	 * @return
	 */
	@Override
	protected List<AccountTransaction> getFilteredResult() {
		List<AccountTransaction> filtered = new ArrayList<AccountTransaction>();
		Predicate filterPredicate = buildFilterPredicate();
		for (AccountTransaction tx : getRepository().all()) {
//			if (filterPredicate.evaluate(tx)) {
				filtered.add(tx);
//			}
		}
		return filtered;
	}


	private Predicate buildFilterPredicate() {
		List<Predicate> predicateList = new ArrayList<Predicate>();
		
		predicateList.add(
				NullIsTruePredicate.getInstance(
						FilterUtil.createDateAfterPredicate(filterBean.getStartDate())));
		
		predicateList.add(
				NullIsTruePredicate.getInstance(
						FilterUtil.createDateBeforePredicate(filterBean.getEndDate())));
		
		predicateList.add(
				NullIsTruePredicate.getInstance(
						new TransactionMemberEqualPredicate(filterBean.getMember())));
		
		predicateList.add(
				NullIsTruePredicate.getInstance(
						new EqualPredicate(filterBean.getReferenceNumber())));
		
		predicateList.add(
				NullIsTruePredicate.getInstance(
						new TransactionSourceMatchPredicate(filterBean.getSourceOptions())));
		
		Predicate[] predicates = new Predicate[predicateList.size()];
		for (int i = 0; i < predicates.length; i++) {
			predicates[i] = predicateList.get(i);
		}
		return new AllPredicate(predicates);
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
