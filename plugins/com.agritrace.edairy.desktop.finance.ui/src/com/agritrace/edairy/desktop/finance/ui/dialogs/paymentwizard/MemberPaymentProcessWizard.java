package com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard;

import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.wizard.Wizard;

import com.google.inject.Inject;

public class MemberPaymentProcessWizard extends Wizard {

	private final PWSelectPaymentPeriod periodPage;
	private final PWPaymentRate ratePage;
	private final PWPaymentComplete reviewAndCompletePage;

	@Inject
	public MemberPaymentProcessWizard(PWSelectPaymentPeriod periodPage, PWPaymentRate ratePage,
			PWPaymentComplete reviewAndCompletePage) {
		setWindowTitle("Run Member Payments Process");
		setNeedsProgressMonitor(true);
		this.periodPage = periodPage;
		this.ratePage = ratePage;
		this.reviewAndCompletePage = reviewAndCompletePage;
		this.setDialogSettings(new DialogSettings(""));
	}

	@Override
	public void addPages() {
		addPage(periodPage);
		addPage(ratePage);
		addPage(reviewAndCompletePage);
	}

	@Override
	public boolean performFinish() {
		reviewAndCompletePage.performFinish();
		return true;
	}
}
