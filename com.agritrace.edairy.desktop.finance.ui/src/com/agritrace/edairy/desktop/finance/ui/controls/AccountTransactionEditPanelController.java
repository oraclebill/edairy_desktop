package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.util.Assert;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ISingleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.ui.controllers.util.BindingHelper;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.common.ui.util.MemberUtil;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class AccountTransactionEditPanelController {
	public class MemberLookupAction implements IActionListener {
		private final ITextRidget nameRidget;

		public MemberLookupAction(ITextRidget nameRidget) {
			this.nameRidget = nameRidget;
		}

		@Override
		public void callback() {
			final MemberSearchDialog memberDialog = new MemberSearchDialog(null);
			final int retVal = memberDialog.open();
			if (retVal == Window.OK) {
				final Membership selectedMember = memberDialog.getSelectedMember();
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
					// memberAccount.setMember(selectedMember);
					selectedMember.setAccount(memberAccount);
					Assert.isTrue(selectedMember.getAccount() == memberAccount);
				}
				AccountTransactionEditPanelController.this.model.setAccount(memberAccount);
				nameRidget.setText(MemberUtil.formattedMemberName(selectedMember.getMember()));
			}
		}
	}

	private IRidgetContainer container;
	private final IDairyRepository dairyRepo = DairyRepository.getInstance();
	private BindingHelper<AccountTransaction> mapper;
	private AccountTransaction model;

	public AccountTransactionEditPanelController() {
		;
		;
	}

	public void checkValid() {

	}

	/**
	 * 
	 */
	public void configureAndBind() {
		if (container == null) {
			throw new IllegalStateException("RidgetContainer must be set before configureAndBind");
		}
		if (model == null) {
			throw new IllegalStateException("Model must be set before configureAndBind");
		}
		createMapper();
		mapFieldsToModel();
		bindMappedRidgets();
		bindConfiguredRidgets();
	}

	/**
	 * 
	 * @param tx
	 */
	public void setModel(AccountTransaction tx) {
		this.model = tx;
	}

	/**
	 * 
	 * @param container
	 */
	public void setRidgetContainer(IRidgetContainer container) {
		this.container = container;
	}

	/**
	 * 
	 */
	private void bindConfiguredRidgets() {

		// configure and bind transaction source
		final ISingleChoiceRidget sourceRidget = container.getRidget(ISingleChoiceRidget.class,
				FinanceBindingConstants.ID_TRANSACTION_CHOICE);
		final IObservableList optionValues = Observables.staticObservableList(TransactionSource.VALUES,
				TransactionSource.class);
		final IObservableValue selectionValue = PojoObservables.observeValue(model, "source"); 
		sourceRidget.bindToModel(optionValues, selectionValue);
		sourceRidget.setMandatory(true);
		sourceRidget.updateFromModel();

		//
		final IDecimalTextRidget transactionText = container.getRidget(IDecimalTextRidget.class,
				FinanceBindingConstants.ID_TRANSACTION_AMOUNT_TEXT);
		transactionText.setGrouping(true);
		transactionText.setPrecision(2);
		transactionText.setSigned(false);
		transactionText.setMandatory(true);
		transactionText.bindToModel(PojoObservables.observeValue(model, "amount"));
		transactionText.updateFromModel();

		// configure member name ridget
		final ITextRidget memberName = container.getRidget(ITextRidget.class,
				FinanceBindingConstants.ID_MEMBER_NAME_TEXT);
		memberName.setOutputOnly(true);

		// configure member lookup action
		final IActionRidget memberLookup = container.getRidget(IActionRidget.class,
				FinanceBindingConstants.ID_MEMBER_LOOKUP_BTN);
		memberLookup.addListener(new MemberLookupAction(memberName));

		// configure route combo
		final IComboRidget combo = container.getRidget(IComboRidget.class,
				FinanceBindingConstants.ID_DAIRY_LOCATION_COMBO);
		IObservableList optionList = Observables.staticObservableList(dairyRepo.getLocalDairyLocations());
		IObservableValue selectedValue = PojoObservables.observeValue(model, "relatedLocation");
		combo.bindToModel(optionList, DairyLocation.class, "getName", selectedValue);
			System.err.println("Binding: >>>> " + dairyRepo.getLocalDairyLocations());
			System.err.println(" to Model: >>>> " + model);
		combo.updateFromModel();

	}

	private void bindMappedRidgets() {
		mapper.configureRidgets();
	}

	private void createMapper() {
		mapper = new BindingHelper<AccountTransaction>(container, model);
	}

	private void mapFieldsToModel() {

		// addMapping(FinanceBindingConstants.ID_TRANSACTION_CHOICE,
		// AccountPackage.Literals.ACCOUNT_TRANSACTION__SOURCE);

		mapper.addMapping(FinanceBindingConstants.ID_TRANSACTION_DATE,
				AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE);

		// mapper.addMapping(FinanceBindingConstants.ID_DAIRY_LOCATION_COMBO,
		// Observables.staticObservableList(dairyRepo.getLocalDairyLocations()),
		// AccountPackage.Literals.TRANSACTION__RELATED_LOCATION);

		mapper.addMapping(FinanceBindingConstants.ID_REF_NUMBER_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__REFERENCE_NUMBER);

		// addMapping(FinanceBindingConstants.ID_MEMBER_NAME_TEXT,
		// AccountPackage.Literals.TRANSACTION__ACCOUNT,
		// AccountPackage.Literals.ACCOUNT__MEMBER,
		// DairyPackage.Literals.MEMBERSHIP__MEMBER,
		// ModelPackage.Literals.PERSON__FAMILY_NAME);

		// addMapping(FinanceBindingConstants.ID_TRANSACTION_AMOUNT_TEXT,
		// AccountPackage.Literals.TRANSACTION__AMOUNT);

		mapper.addMapping(FinanceBindingConstants.ID_TRANSACTION_DESCRIPTION_TEXT,
				AccountPackage.Literals.TRANSACTION__DESCRIPTION);

		mapper.addMapping(FinanceBindingConstants.ID_CHECK_NUMBER_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__CHECK_NUMBER);

		mapper.addMapping(FinanceBindingConstants.ID_SIGNED_BY_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__SIGNED_BY);
	}
}
