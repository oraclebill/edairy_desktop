package com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard;

import java.util.HashMap;

import org.eclipse.jface.wizard.Wizard;


public class MemberPaymentProcessWizard extends Wizard {

	
	static class PaymentWizardModel {
		
	}
	
	private final PaymentWizardModel wizardModel;
	
	public MemberPaymentProcessWizard() {
		setWindowTitle("Run Member Payments Process");
		wizardModel = new PaymentWizardModel();
	}

	@Override
	public void addPages() {
		addPage(new PWSelectPaymentPeriod(wizardModel));
		addPage(new PWPaymentRate(wizardModel));
		addPage(new PWPaymentComplete(wizardModel));
	}

	@Override
	public boolean performFinish() {
		return false;
	}

	@Override
	public boolean canFinish() {
		return false;
	}
	

	@Override
	public boolean needsPreviousAndNextButtons() {
		// TODO Auto-generated method stub
		return super.needsPreviousAndNextButtons();
	}

	@Override
	public boolean needsProgressMonitor() {
		// TODO Auto-generated method stub
		return super.needsProgressMonitor();
	}

	
}
