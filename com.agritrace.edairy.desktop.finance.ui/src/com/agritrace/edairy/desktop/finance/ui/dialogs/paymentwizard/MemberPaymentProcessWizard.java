package com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

import com.google.inject.Inject;

public class MemberPaymentProcessWizard extends Wizard {

	private PWSelectPaymentPeriod periodPage;
	private PWPaymentRate ratePage;
	private PWPaymentComplete reviewAndCompletePage;

	@Inject
	public MemberPaymentProcessWizard(PWSelectPaymentPeriod periodPage, PWPaymentRate ratePage,
			PWPaymentComplete reviewAndCompletePage) {
		setWindowTitle("Run Member Payments Process");
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		addPage(periodPage);
		addPage(ratePage);
		addPage(reviewAndCompletePage);
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage newPage = super.getNextPage(page);
		if (page.getName().equals("previewAndComplete")) {

		}
		return newPage;
	}

	@Override
	public boolean performFinish() {
		return true;
	}

	@Override
	public boolean canFinish() {
		return true;
	}

}
