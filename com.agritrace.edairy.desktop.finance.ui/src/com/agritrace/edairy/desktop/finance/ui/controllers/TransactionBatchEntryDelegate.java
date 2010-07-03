package com.agritrace.edairy.desktop.finance.ui.controllers;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTextRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ISingleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.validation.NotEmpty;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.finance.ui.FormConstants;

/**
 * A IMasterDetailsDelegate that edit an AccountTransaction.
 */
public class TransactionBatchEntryDelegate extends AbstractMasterDetailsDelegate {

	private final AccountTransaction workingCopy = createWorkingCopy();

	@Override
	public void configureRidgets(IRidgetContainer container) {

		// setup observables first..
		// transaction type
		final IObservableValue obTransactionType = // TODO: rename to
													// disambiguate
													// source (store, vet,
													// share,
													// etc) and type (db, cr)
		EMFObservables.observeValue(workingCopy, AccountPackage.Literals.ACCOUNT_TRANSACTION__SOURCE);
		// Date
		final IObservableValue obDate = EMFObservables.observeValue(workingCopy,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_TYPE);
		// Store
		final IObservableValue obStore = EMFObservables.observeValue(workingCopy,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_TYPE);
		EMFObservables.observeValue(workingCopy,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_TYPE);
		// Record Id
		// TODO: no record id in model !!
		// Member Id
		final IObservableValue obMemberId = EMFProperties.value(
				FeaturePath.fromList(AccountPackage.Literals.ACCOUNT_TRANSACTION__ACCOUNT,
						AccountPackage.Literals.ACCOUNT__MEMBER, DairyPackage.Literals.MEMBERSHIP__MEMBER_ID)).observe(
				workingCopy);
		// Member Name
		final IObservableValue obMemberName = EMFProperties.value(
				FeaturePath.fromList(AccountPackage.Literals.ACCOUNT_TRANSACTION__ACCOUNT,
						AccountPackage.Literals.ACCOUNT__MEMBER, DairyPackage.Literals.MEMBERSHIP__MEMBER,
						ModelPackage.Literals.PERSON__FAMILY_NAME)).observe(workingCopy); // TODO:
																							// Use
																							// the
																							// 'name'
																							// property
																							// to
																							// get
																							// a
																							// display
																							// name
																							// for
																							// member
		// Amount
		final IObservableValue obAmt = EMFObservables.observeValue(workingCopy,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__AMOUNT);
		EMFObservables.observeValue(workingCopy,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__DESCRIPTION);
		EMFObservables.observeValue(workingCopy,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__SOURCE);

		//
		// Bind stuff
		//

		// Bind Transaction Type Combo
		final ISingleChoiceRidget ridgetTransactionType = container.getRidget(ISingleChoiceRidget.class,
				"sourceSelectorPanel");
		ridgetTransactionType.bindToModel(ridgetTransactionType.getObservableList(), obTransactionType);
		ridgetTransactionType.updateFromModel();

		// Bind Date
		final IDateTextRidget ridgetDate = container.getRidget(IDateTextRidget.class, FormConstants.DATE_PICKER_RIDGET);
		ridgetDate.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
		ridgetDate.bindToModel(obDate);
		ridgetDate.updateFromModel();

		// Bind Store
		final IComboRidget ridgetStore = container.getRidget(IComboRidget.class, FormConstants.STORE_COMBO_RIDGET);
		ridgetStore.bindToModel(new WritableList(), String.class, "name", obStore);
		ridgetStore.updateFromModel();

		// Reference Number
		final ITextRidget ridgetRefNo = container.getRidget(ITextRidget.class, FormConstants.REF_NO_TEXT_RIDGET);
		ridgetRefNo.bindToModel(EMFObservables.observeValue(workingCopy,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_ID));
		ridgetRefNo.addValidationRule(new NotEmpty(), ValidationTime.ON_UI_CONTROL_EDIT);
		ridgetRefNo.updateFromModel();

		container.getRidget(ITextRidget.class, FormConstants.RECORD_ID_TEXT);

		// Member Id
		final ITextRidget ridgetMemberId = container.getRidget(ITextRidget.class, FormConstants.MEMBER_ID_TEXT_RIDGET);
		ridgetMemberId.bindToModel(obMemberId);
		ridgetMemberId.addValidationRule(new NotEmpty(), ValidationTime.ON_UI_CONTROL_EDIT);
		ridgetMemberId.updateFromModel();

		// Member Id
		final ILabelRidget ridgetMemberName = container.getRidget(ILabelRidget.class,
				FormConstants.LBL_MEMBER_NAME_RIDGET);
		ridgetMemberName.bindToModel(obMemberName);
		ridgetMemberName.updateFromModel();

		// Amount
		//		INumericTextRidget ridgetAmt = container.getRidget(INumericTextRidget.class, FormConstants.AMT_TEXT_RIDGET); //$NON-NLS-1$
		final ITextRidget ridgetAmt = container.getRidget(ITextRidget.class, FormConstants.AMT_TEXT_RIDGET);
		ridgetAmt.bindToModel(obAmt);
		ridgetAmt.addValidationRule(new NotEmpty(), ValidationTime.ON_UI_CONTROL_EDIT);
		ridgetAmt.updateFromModel();

		// // Description
		//				ITextRidget ridgetDesc = container.getRidget(ITextRidget.class, FormConstants.); //$NON-NLS-1$
		// ridgetDesc.bindToModel(obDesc);
		// ridgetDesc.addValidationRule(new NotEmpty(),
		// ValidationTime.ON_UI_CONTROL_EDIT);
		// ridgetDesc.updateFromModel();
		//
		// // Check Number
		//				ITextRidget txtLast = container.getRidget(ITextRidget.class, "txtLast"); //$NON-NLS-1$
		// txtLast.bindToModel(workingCopy, Person.PROPERTY_LASTNAME);
		// txtLast.addValidationRule(new NotEmpty(),
		// ValidationTime.ON_UI_CONTROL_EDIT);
		// txtLast.updateFromModel();
		//
		// // Signed By
		//
		//				ITextRidget txtLast = container.getRidget(ITextRidget.class, "txtLast"); //$NON-NLS-1$
		// txtLast.bindToModel(workingCopy, Person.PROPERTY_LASTNAME);
		// txtLast.addValidationRule(new NotEmpty(),
		// ValidationTime.ON_UI_CONTROL_EDIT);
		// txtLast.updateFromModel();
		//
		//				ITextRidget txtFirst = container.getRidget(ITextRidget.class, "txtFirst"); //$NON-NLS-1$
		// txtFirst.bindToModel(workingCopy, Person.PROPERTY_FIRSTNAME);
		// txtFirst.updateFromModel();
	}

	@Override
	public AccountTransaction copyBean(Object source, Object target) {
		final AccountTransaction to = target != null ? (AccountTransaction) target : createWorkingCopy();

		if ((source instanceof EObject) && (target instanceof EObject)) {
			EMFUtil.copy((EObject) source, (EObject) target, 1);
		} else {
			throw new IllegalArgumentException("Domain objects must be EObjects!");
		}
		return to;
	}

	@Override
	public AccountTransaction createWorkingCopy() {
		return AccountFactory.eINSTANCE.createAccountTransaction();
	}

	@Override
	public AccountTransaction getWorkingCopy() {
		return workingCopy;
	}

	@Override
	public boolean isChanged(Object source, Object target) {
		AccountTransaction srcTx, targTx;
		srcTx = (AccountTransaction) source;
		targTx = (AccountTransaction) target;

		return EMFUtil.compareAllFeatures(srcTx, targTx);

	}

	@Override
	public String isValid(IRidgetContainer container) {
		final ITextRidget txtLast = (ITextRidget) container.getRidget("txtLast"); //$NON-NLS-1$
		if (txtLast.isErrorMarked()) {
			return "'Last Name' is not valid."; //$NON-NLS-1$
		}
		return null;
	}
}