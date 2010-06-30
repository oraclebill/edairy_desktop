package com.agritrace.edairy.desktop.finance.ui.dialogs;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.util.Assert;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ISingleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.common.ui.util.MemberUtil;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class MemberTransactionEditController extends RecordDialogController<AccountTransaction> {

	public class MemberLookupAction implements IActionListener {
		private ITextRidget nameRidget;

		public MemberLookupAction(ITextRidget nameRidget) {
			this.nameRidget = nameRidget;
		}

		@Override
		public void callback() {
			MemberSearchDialog memberDialog = new MemberSearchDialog(null);
			int retVal = memberDialog.open();
			if (retVal == MemberSearchDialog.OK) {
				Membership selectedMember = memberDialog.getSelectedMember();
				// String memberName =
				// MemberUtil.formattedMemberName(selectedMember.getMember());
				// memberNameFilter.setText(memberName);
				// updateFarmCombo();
				// if (searchButton != null) {
				// searchButton.setEnabled(true);
				// }
				Account memberAccount = selectedMember.getAccount();
				if (memberAccount == null) {
					memberAccount = AccountFactory.eINSTANCE.createAccount();
//					memberAccount.setMember(selectedMember);
					selectedMember.setAccount(memberAccount);
					Assert.isTrue(selectedMember.getAccount() == memberAccount);
				}
				getWorkingCopy().setAccount(memberAccount);
				nameRidget.setText(MemberUtil.formattedMemberName(selectedMember.getMember()));

			}

		}
	}

	private final IDairyRepository dairyRepo = new DairyRepository();

	public MemberTransactionEditController() {
		super();

		setEClass(AccountPackage.Literals.ACCOUNT_TRANSACTION);

		// addRidgetFeatureMap(FinanceBindingConstants.ID_TRANSACTION_CHOICE,
		// AccountPackage.Literals.ACCOUNT_TRANSACTION__SOURCE);

		addRidgetFeatureMap(FinanceBindingConstants.ID_TRANSACTION_DATE,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_DATE);

		addRidgetFeatureMap(FinanceBindingConstants.ID_DAIRY_LOCATION_COMBO,
				Observables.staticObservableList(dairyRepo.getLocalDairyLocations()),
				AccountPackage.Literals.ACCOUNT_TRANSACTION__RELATED_LOCATION);

		addRidgetFeatureMap(FinanceBindingConstants.ID_REF_NUMBER_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__REFERENCE_NUMBER);

//		addRidgetFeatureMap(FinanceBindingConstants.ID_MEMBER_NAME_TEXT,
//				AccountPackage.Literals.ACCOUNT_TRANSACTION__ACCOUNT, AccountPackage.Literals.ACCOUNT__MEMBER,
//				DairyPackage.Literals.MEMBERSHIP__MEMBER, ModelPackage.Literals.PERSON__FAMILY_NAME);

//		addRidgetFeatureMap(FinanceBindingConstants.ID_TRANSACTION_AMOUNT_TEXT,
//				AccountPackage.Literals.ACCOUNT_TRANSACTION__AMOUNT);

		addRidgetFeatureMap(FinanceBindingConstants.ID_TRANSACTION_DESCRIPTION_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__DESCRIPTION);

		addRidgetFeatureMap(FinanceBindingConstants.ID_CHECK_NUMBER_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__CHECK_NUMBER);

		addRidgetFeatureMap(FinanceBindingConstants.ID_SIGNED_BY_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__SIGNED_BY);
	}

	@Override
	protected void configureUserRidgets() {
		// configure and bind transaction source
		ISingleChoiceRidget sourceRidget = getRidget(ISingleChoiceRidget.class,
				FinanceBindingConstants.ID_TRANSACTION_CHOICE);
		IObservableList optionValues = Observables.staticObservableList(TransactionSource.VALUES,
				TransactionSource.class);
		IObservableValue selectionValue = PojoObservables.observeValue(getWorkingCopy(), "source");
		sourceRidget.bindToModel(optionValues, selectionValue);
		sourceRidget.setMandatory(true);
		sourceRidget.updateFromModel();

		// 
		IDecimalTextRidget transactionText = getRidget(IDecimalTextRidget.class, FinanceBindingConstants.ID_TRANSACTION_AMOUNT_TEXT);
		transactionText.setGrouping(true);
		transactionText.setPrecision(2);
		transactionText.setSigned(false);
		transactionText.setMandatory(true);
		transactionText.bindToModel(PojoObservables.observeValue(getWorkingCopy(), "amount"));
		transactionText.updateFromModel();
		
		// configure member name ridget
		ITextRidget memberName = getRidget(ITextRidget.class, FinanceBindingConstants.ID_MEMBER_NAME_TEXT);
		memberName.setOutputOnly(true);

		// configure member lookup action
		IActionRidget memberLookup = getRidget(IActionRidget.class, FinanceBindingConstants.ID_MEMBER_LOOKUP_BTN);
		memberLookup.addListener(new MemberLookupAction(memberName));

	}

	@Override
	protected void handleSaveAction() {
		checkValid();
		super.handleSaveAction();
	}

	private void checkValid() {
		
		
	}

	
}
