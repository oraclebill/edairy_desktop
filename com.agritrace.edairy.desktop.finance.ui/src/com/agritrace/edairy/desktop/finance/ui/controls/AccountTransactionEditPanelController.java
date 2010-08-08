package com.agritrace.edairy.desktop.finance.ui.controls;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.util.Assert;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ISingleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.ui.controllers.util.BindingHelper;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberLookupAction;
import com.agritrace.edairy.desktop.common.ui.util.MemberUtil;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

/**
 * A controller type thing for the account transaction edit panel.
 * 
 * Lifecycle is - instantiate -
 * 
 * @author oraclebill
 * 
 */
public class AccountTransactionEditPanelController {

	public class TransactionSourceSelectionListener implements ISelectionListener {
		@Override
		public void ridgetSelected(SelectionEvent event) {
			List<Object> selected = event.getNewSelection();
			if (selected != null && selected.size() > 0) {
				Object obj = selected.get(0);
				if (obj instanceof TransactionSource) {
					updateWidgetsForSource((TransactionSource) obj);
				}
			}
		}

	}

	private IRidgetContainer container;
	private final IDairyRepository dairyRepo = DairyRepository.getInstance();
	private BindingHelper<AccountTransaction> mapper;
	AccountTransaction model;
	private IComboRidget storeLocation;
	private ITextRidget memberName;

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
		updateWidgetsForSource(model.getSource());
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
		sourceRidget.bindToModel(Observables.staticObservableList(TransactionSource.VALUES, TransactionSource.class),
				PojoObservables.observeValue(model, "source"));
		sourceRidget.updateFromModel();
		sourceRidget.addSelectionListener(new TransactionSourceSelectionListener());

		//
		final IDecimalTextRidget transactionText = container.getRidget(IDecimalTextRidget.class,
				FinanceBindingConstants.ID_TRANSACTION_AMOUNT_TEXT);
		transactionText.setGrouping(true);
		transactionText.setPrecision(2);
		transactionText.setSigned(false);
		transactionText.setMandatory(true);
		transactionText.bindToModel(model, "amount");
		transactionText.updateFromModel();

		memberName = container.getRidget(ITextRidget.class, FinanceBindingConstants.ID_MEMBER_NAME_TEXT);
		memberName.setOutputOnly(true);
		if (model.getAccount() != null)
			setSelectedMember(model.getAccount().getMember());

		// configure member lookup action
		final IActionRidget memberLookup = container.getRidget(IActionRidget.class,
				FinanceBindingConstants.ID_MEMBER_LOOKUP_BTN);
		memberLookup.addListener(new MemberLookupAction() {
			@Override
			protected void callback(Membership selectedMember) {
				setSelectedMember(selectedMember);
			}
		});

		storeLocation = container.getRidget(IComboRidget.class, FinanceBindingConstants.ID_DAIRY_LOCATION_COMBO);
		List<DairyLocation> locations = dairyRepo.getLocalDairyLocations();
		if (locations.size() == 0) {
			locations = Arrays.asList();
		}
		IObservableList optionList = Observables.staticObservableList(locations);
		IObservableValue selectedValue = PojoObservables.observeValue(model, "relatedLocation"); 
		storeLocation.bindToModel(optionList, DairyLocation.class, "getName", selectedValue);
		System.err.println("Binding: >>>> " + dairyRepo.getLocalDairyLocations());
		System.err.println(" to Model: >>>> " + model);
		storeLocation.updateFromModel();

	}

	private void setSelectedMember(Membership selectedMember) {
		Account memberAccount = selectedMember.getAccount();
		if (memberAccount == null) {
			memberAccount = AccountFactory.eINSTANCE.createAccount();
			selectedMember.setAccount(memberAccount);
		}
		model.setAccount(memberAccount);
		memberName.setText(MemberUtil.formattedMemberName(selectedMember.getMember()));
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

	private void updateWidgetsForSource(TransactionSource source) {
		boolean showStoreLocation = false, showCheckNo = false, showSignedBy = false;
		if (source == TransactionSource.CASH_PAYMENT) {
			showCheckNo = true;
			showSignedBy = true;
		} else if (source == TransactionSource.STORE_CREDIT) {
			showStoreLocation = true;
		}
		enableMandatoryRidget(container.getRidget(ITextRidget.class, FinanceBindingConstants.ID_CHECK_NUMBER_TEXT),
				showCheckNo);
		enableMandatoryRidget(
				container.getRidget(ILabelRidget.class, FinanceBindingConstants.ID_CHECK_NUMBER_TEXT_LBL), showCheckNo);

		enableMandatoryRidget(container.getRidget(ITextRidget.class, FinanceBindingConstants.ID_SIGNED_BY_TEXT),
				showSignedBy);
		enableMandatoryRidget(container.getRidget(ILabelRidget.class, FinanceBindingConstants.ID_SIGNED_BY_TEXT_LBL),
				showSignedBy);

		enableMandatoryRidget(container.getRidget(IComboRidget.class, FinanceBindingConstants.ID_DAIRY_LOCATION_COMBO),
				showStoreLocation);
		enableMandatoryRidget(
				container.getRidget(ILabelRidget.class, FinanceBindingConstants.ID_DAIRY_LOCATION_COMBO_LBL),
				showStoreLocation);
	}

	private void enableMandatoryRidget(IRidget ridget, boolean enabled) {
		ridget.setEnabled(enabled);
		if (ridget instanceof ITextRidget) {
			ITextRidget editable = (ITextRidget) ridget;
			editable.setMandatory(enabled);
		} else if (ridget instanceof IComboRidget) {
			IComboRidget editable = (IComboRidget) ridget;
			editable.setMandatory(enabled);
		}
		// else if (ridget instanceof ILabelRidget) {
		// ILabelRidget editable = (ILabelRidget) ridget;
		// }
	}

}
