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
import org.apache.commons.collections.functors.TruePredicate;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.FilterUtil;
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
	private IMultipleChoiceRidget typeSetRidget;

	public MemberTransactionRegisterController() {
		this(null);
	}

	public MemberTransactionRegisterController(ISubModuleNode node) {
		super(node);
		setEClass(AccountPackage.Literals.ACCOUNT_TRANSACTION);
		setEntityClass(AccountTransaction.class);
		setRepository(memberRepo.getTransactionRepository());

		this.addTableColumn("ID", AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_ID);
		this.addTableColumn("Date", AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_DATE);
		this.addTableColumn("Source", AccountPackage.Literals.ACCOUNT_TRANSACTION__SOURCE);
		this.addTableColumn("Ref. Num.", AccountPackage.Literals.ACCOUNT_TRANSACTION__REFERENCE_NUMBER);
		this.addTableColumn("Account ID", AccountPackage.Literals.ACCOUNT_TRANSACTION__ACCOUNT);
		this.addTableColumn("Amount", AccountPackage.Literals.ACCOUNT_TRANSACTION__AMOUNT);
	}

	@Override
	public void configureFilterRidgets() {

		startDateRidget = getRidget(IDateTimeRidget.class, "startDateRidget");
		// startDateRidget.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
		endDateRidget = getRidget(IDateTimeRidget.class, "endDateRidget");
		// endDateRidget.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);

		memberNameRidget = getRidget(ITextRidget.class, "memberIdRidget");
		typeSetRidget = getRidget(IMultipleChoiceRidget.class, "typeSetRidget");
	}

	@Override
	public void afterBind() {
		super.afterBind();

		startDateRidget.bindToModel(filterBean, "startDate");

		endDateRidget.bindToModel(filterBean, "endDate");

		memberNameRidget.bindToModel(PojoObservables.observeDetailValue(
				PojoObservables.observeValue(filterBean, "member"), "familyName", String.class));

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
		for (AccountTransaction tx : memberRepo.getTransactionRepository().all()) {
			if (filterPredicate.evaluate(tx)) {
				filtered.add(tx);
			}
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void resetFilterConditions() {
		filterBean.clear();
	}
}
