package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.Arrays;
import java.util.List;

import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ISingleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AdjustmentTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.model.dairy.security.EmployeePrincipal;
import com.agritrace.edairy.desktop.common.model.dairy.security.IPrincipal;
import com.agritrace.edairy.desktop.common.model.dairy.security.PrincipalManager;
import com.agritrace.edairy.desktop.common.model.util.MemberUtil;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberLookupAction;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AdjustmentTransactionEditController extends RecordDialogController<AdjustmentTransaction> {
	private final Provider<MemberSearchDialog> memberSearchProvider;

	@Inject
	public AdjustmentTransactionEditController(final Provider<MemberSearchDialog> memberSearchProvider) {
		super("Account Adjustment");
		this.memberSearchProvider = memberSearchProvider;
	}

	@Override
	protected void configureButtonsPanel() {
		super.configureButtonsPanel();

		if (getActionType() != AbstractDirectoryController.ACTION_NEW) {
			getRidget(IActionRidget.class, DialogConstants.BIND_ID_BUTTON_SAVE).setVisible(false);
			getRidget(IActionRidget.class, DialogConstants.BIND_ID_BUTTON_DELETE).setVisible(false);
			getRidget(IActionRidget.class, DialogConstants.BIND_ID_BUTTON_CANCEL).setText("Close");
		}
	}

	@Override
	protected void configureUserRidgets() {
		final AdjustmentTransaction model = getWorkingCopy();

		if (getActionType() != AbstractDirectoryController.ACTION_NEW) {
			// Disable editing
			getRidget(FinanceBindingConstants.ID_TRANSACTION_WRAPPER_FRAME).setEnabled(false);
			getRidget(FinanceBindingConstants.ID_TRANSACTION_ALERT_FRAME).setVisible(false);
		}

		final ISingleChoiceRidget typeRidget = getRidget(ISingleChoiceRidget.class,
				FinanceBindingConstants.ID_TRANSACTION_CHOICE);
		final List<String> optionValues = Arrays.asList("Credit Adjustment", "Debit Adjustment");
		typeRidget.bindToModel(TransactionType.VALUES, optionValues, model, "transactionType");

		addTextMap(FinanceBindingConstants.ID_TRANSACTION_AMOUNT_TEXT, AccountPackage.Literals.TRANSACTION__AMOUNT);
		addTextMap(FinanceBindingConstants.ID_TRANSACTION_DESCRIPTION_TEXT, AccountPackage.Literals.TRANSACTION__DESCRIPTION);
		addTextMap(FinanceBindingConstants.ID_TRANSACTION_DATE, AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE);

		final IDecimalTextRidget transactionText = getRidget(IDecimalTextRidget.class,
				FinanceBindingConstants.ID_TRANSACTION_AMOUNT_TEXT);
		transactionText.setGrouping(true);
		transactionText.setPrecision(2);
		transactionText.setSigned(false);
		transactionText.setMandatory(true);

		final IPrincipal principal = PrincipalManager.getInstance().getPrincipal();

		if (getActionType() == AbstractDirectoryController.ACTION_NEW && principal instanceof EmployeePrincipal) {
			model.setSignedOffBy(((EmployeePrincipal) principal).getEmployee());
		}

		final ITextRidget signedBy = getRidget(ITextRidget.class, FinanceBindingConstants.ID_SIGNED_BY_TEXT);
		signedBy.setOutputOnly(true);

		if (model.getSignedOffBy() != null) {
			signedBy.setText(MemberUtil.formattedMemberName(model.getSignedOffBy()));
		}

		final ITextRidget memberName = getRidget(ITextRidget.class, FinanceBindingConstants.ID_LOOKUP_RESULT_TXT);
		memberName.setMandatory(true);
		memberName.setOutputOnly(true);

		if (model.getAccount() != null) {
			final Membership member = model.getAccount().getMember();

			if (member != null) {
				memberName.setText(MemberUtil.formattedMemberName(member.getMember()));
			}
		}

		getRidget(IActionRidget.class, FinanceBindingConstants.ID_LOOKUP_BTN).addListener(new MemberLookupAction() {
			@Override
			protected void callback(Membership selectedMember) {
				model.setAccount(selectedMember.getAccount());
				memberName.setText(MemberUtil.formattedMemberName(selectedMember.getMember()));
			}

			@Override
			protected MemberSearchDialog getMemberSearchDialog() {
				return memberSearchProvider.get();
			}
		});
	}
}
