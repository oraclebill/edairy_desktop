package com.agritrace.edairy.desktop.finance.ui.dialogs;

import org.eclipse.core.databinding.observable.Observables;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class MemberTransactionEditController extends RecordDialogController<AccountTransaction> {
	
	private final IDairyRepository dairyRepo = new DairyRepository();
	
	public MemberTransactionEditController() {
		super();

		setEClass(AccountPackage.Literals.ACCOUNT_TRANSACTION);

		addRidgetFeatureMap(FinanceBindingConstants.ID_TRANSACTION_CHOICE,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__SOURCE);
		
		addRidgetFeatureMap(FinanceBindingConstants.ID_TRANSACTION_DATE,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_DATE);
		
		addRidgetFeatureMap(FinanceBindingConstants.ID_DAIRY_LOCATION_COMBO, 
				Observables.staticObservableList(dairyRepo.getLocalDairyLocations()),
				AccountPackage.Literals.ACCOUNT_TRANSACTION__RELATED_LOCATION);
		
		addRidgetFeatureMap(FinanceBindingConstants.ID_REF_NUMBER_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__REFERENCE_NUMBER);
		
		addRidgetFeatureMap(FinanceBindingConstants.ID_RECORD_ID_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__TRANSACTION_ID);
		
		addRidgetFeatureMap(FinanceBindingConstants.ID_MEMBER_NAME_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__ACCOUNT, AccountPackage.Literals.ACCOUNT__MEMBER,
				DairyPackage.Literals.MEMBERSHIP__MEMBER, ModelPackage.Literals.PERSON__FAMILY_NAME);
		
		addRidgetFeatureMap(FinanceBindingConstants.ID_TRANSACTION_AMOUNT_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__AMOUNT);
		
		addRidgetFeatureMap(FinanceBindingConstants.ID_TRANSACTION_DESCRIPTION_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__DESCRIPTION);
		
		addRidgetFeatureMap(FinanceBindingConstants.ID_CHECK_NUMBER_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__CHECK_NUMBER);
		
		addRidgetFeatureMap(FinanceBindingConstants.ID_SIGNED_BY_TEXT,
				AccountPackage.Literals.ACCOUNT_TRANSACTION__SIGNED_BY); 
	}

	@Override
	protected void configureUserRidgets() {
		// todo
	}
	
	

}
