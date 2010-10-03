package com.agritrace.edairy.desktop.finance.ui.controllers;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard.MemberPaymentProcessWizard;

public class MemberPaymentsController extends SubModuleController {

	@Override
	public void configureRidgets() {
		getRidget(IActionRidget.class, FinanceBindingConstants.BTN_RUN_PAYMENTS)
				.addListener(new IActionListener() {
					@Override
					public void callback() {
						MemberPaymentProcessWizard paymentsWizard = new MemberPaymentProcessWizard();
						Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
						WizardDialog wizDialog = new WizardDialog(shell, paymentsWizard);
						
						if ( wizDialog.open() == Dialog.OK ) {
//							paymentsWizard;
						}
					}
				});
		
	}

	@Override
	public void afterBind() {
		// TODO Auto-generated method stub
		super.afterBind();
	}

}
