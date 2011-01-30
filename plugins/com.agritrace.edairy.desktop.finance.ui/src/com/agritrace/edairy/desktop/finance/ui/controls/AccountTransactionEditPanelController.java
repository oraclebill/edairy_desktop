package com.agritrace.edairy.desktop.finance.ui.controls;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
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
import com.agritrace.edairy.desktop.common.model.util.MemberUtil;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDetailPanelController;
import com.agritrace.edairy.desktop.common.ui.controllers.util.BindingHelper;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberLookupAction;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * A controller type thing for the account transaction edit panel.
 *
 * Lifecycle is - instantiate -
 *
 * @author oraclebill
 *
 */
public class AccountTransactionEditPanelController extends AbstractDetailPanelController<AccountTransaction> {

	public class TransactionSourceSelectionListener implements ISelectionListener {
		@Override
		public void ridgetSelected(SelectionEvent event) {
			final List<Object> selected = event.getNewSelection();
			if (selected != null && selected.size() > 0) {
				final Object obj = selected.get(0);
				if (obj instanceof TransactionSource) {
					updateWidgetsForSource((TransactionSource) obj);
				}
			}
		}

	}

	private IComboRidget storeLocation;
	private ITextRidget storeLocText;
	private ITextRidget memberName;

	private final IDairyRepository dairyRepo;
	private final Provider<MemberSearchDialog> memberSearchProvider;

	@Inject
	public AccountTransactionEditPanelController(final IDairyRepository dairyRepo,
			final Provider<MemberSearchDialog> memberSearchProvider) {
		this.dairyRepo = dairyRepo;
		this.memberSearchProvider = memberSearchProvider;
	}

	@Override
	public void configureAndBind() {
		super.configureAndBind();
		updateWidgetsForSource(getModel().getSource());
	}

	@Override
	protected void bindRidgets() {
		final BindingHelper<AccountTransaction> mapper = getMapper();
		mapper.addMapping(FinanceBindingConstants.ID_TRANSACTION_DATE,
				AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE);
		mapper.addMapping(FinanceBindingConstants.ID_REF_NUMBER_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__REFERENCE_NUMBER);
		mapper.addMapping(FinanceBindingConstants.ID_TRANSACTION_DESCRIPTION_TEXT,
				AccountPackage.Literals.TRANSACTION__DESCRIPTION);
		mapper.addMapping(FinanceBindingConstants.ID_CHECK_NUMBER_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__CHECK_NUMBER);
		mapper.addMapping(FinanceBindingConstants.ID_SIGNED_BY_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__SIGNED_BY);

		final IRidgetContainer container = getRidgetContainer();
		final AccountTransaction model = getModel();

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

		memberName = container.getRidget(ITextRidget.class, FinanceBindingConstants.ID_LOOKUP_RESULT_TXT);
		memberName.setOutputOnly(true);
		if (model.getAccount() != null) {
			setSelectedMember(model.getAccount().getMember());
		}

		// configure member lookup action
		final IActionRidget memberLookup = container.getRidget(IActionRidget.class,
				FinanceBindingConstants.ID_LOOKUP_BTN);
		memberLookup.addListener(new MemberLookupAction() {
			@Override
			protected void callback(Membership selectedMember) {
				setSelectedMember(selectedMember);
			}

			@Override
			protected MemberSearchDialog getMemberSearchDialog() {
				return memberSearchProvider.get();
			}
		});
		
		storeLocText = container.getRidget(ITextRidget.class, FinanceBindingConstants.ID_DAIRY_LOCATION_TEXT);
		storeLocText.setOutputOnly(true);
		
		storeLocation = container.getRidget(IComboRidget.class, FinanceBindingConstants.ID_DAIRY_LOCATION_COMBO);
		List<DairyLocation> locations = dairyRepo.getLocalDairyLocations();
		
		if (locations.size() == 0) {
			locations = Arrays.asList();
		}
		
		final IObservableList optionList = Observables.staticObservableList(locations);
		final IObservableValue selectedValue = PojoObservables.observeValue(model, "relatedLocation");
		storeLocation.bindToModel(optionList, DairyLocation.class, "getCode", selectedValue);
		storeLocation.updateFromModel();
		updateStoreName();
		
		storeLocation.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				updateStoreName();
			}
		});
	}
	
	private void updateStoreName() {
		final AccountTransaction model = getModel();
		
		if (model.getRelatedLocation() != null) {
			storeLocText.setText(model.getRelatedLocation().getName());
		} else {
			storeLocText.setText("");
		}
	}

	private void setSelectedMember(Membership selectedMember) {
		Account memberAccount = selectedMember.getAccount();
		if (memberAccount == null) {
			memberAccount = AccountFactory.eINSTANCE.createAccount();
			selectedMember.setAccount(memberAccount);
		}

		getModel().setAccount(memberAccount);
		memberName.setText(MemberUtil.formattedMemberName(selectedMember.getMember()));
	}

	void updateWidgetsForSource(TransactionSource source) {
		final IRidgetContainer container = getRidgetContainer();
		boolean showStoreLocation = false, showCheckNo = false, showSignedBy = false;

		if (container.getRidget(FinanceBindingConstants.ID_TRANSACTION_CHOICE).isEnabled()) {
			if (source == TransactionSource.CASH_PAYMENT) {
				showCheckNo = true;
				showSignedBy = true;
			} else if (source == TransactionSource.STORE_CREDIT) {
				showStoreLocation = true;
			}
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

}
