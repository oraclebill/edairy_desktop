package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.List;

import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.MemberPayment;
import com.agritrace.edairy.desktop.common.persistence.dao.IMemberPaymentsRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard.MemberPaymentProcessWizard;
import com.google.inject.Inject;

public class MemberPaymentsViewController extends
		BasicDirectoryController<MemberPayment> {

	MemberPaymentProcessWizard paymentsWizard;

	private final class BlankColumnFormatter extends ColumnFormatter {
		@Override
		public String getText(Object element) {
			return "?";
		}
	}

	@Inject
	public MemberPaymentsViewController(IMemberPaymentsRepository paymentsRepository, MemberPaymentProcessWizard paymentsWizard) {
		setEClass(DairyPackage.Literals.MEMBER_PAYMENT);
		setRepository(paymentsRepository);

		addTableColumn("Year", DairyPackage.Literals.MEMBER_PAYMENT__YEAR);
		addTableColumn("Month", DairyPackage.Literals.MEMBER_PAYMENT__YEAR);
		addTableColumn("Rate", DairyPackage.Literals.MEMBER_PAYMENT__PAYMENT_RATE);
		addTableColumn("Farmer Count", DairyPackage.Literals.MEMBER_PAYMENT__ID,
				new BlankColumnFormatter());
		addTableColumn("Average Payment", DairyPackage.Literals.MEMBER_PAYMENT__ID,
				new BlankColumnFormatter());
		addTableColumn("Total Payments", DairyPackage.Literals.MEMBER_PAYMENT__ID,
				new BlankColumnFormatter());
		addTableColumn("Run On", DairyPackage.Literals.MEMBER_PAYMENT__ENTRY_DATE);
		addTableColumn("By", DairyPackage.Literals.MEMBER_PAYMENT__ENTERED_BY);

		this.paymentsWizard  = paymentsWizard;
	}

	@Override
	protected void configureFilterRidgets() {
		// TODO:
	}

	private void handlePaymentButton() {
		final Shell shell = PlatformUI.getWorkbench().getDisplay()
				.getActiveShell();
		final WizardDialog wizDialog = new WizardDialog(shell, paymentsWizard);

		if (wizDialog.open() == Window.OK) {
			// paymentsWizard;
		}
	}

	@Override
	public IMemberPaymentsRepository getRepository() {
		return (IMemberPaymentsRepository) super.getRepository();
	}

	@Override
	protected List<MemberPayment> getFilteredResult() {
		return getRepository().all();
	}

	@Override
	protected void configureViewItemButton(IActionRidget viewBtnRidget) {
		viewBtnRidget.setVisible(false);
	}

	@Override
	protected void configureNewItemButton(IActionRidget newBtnRidget) {
		newBtnRidget.setText("Run Member Payment Process");
		newBtnRidget.addListener(new IActionListener() {
			@Override
			public void callback() {
				handlePaymentButton();
			}
		});
	}

	@Override
	protected RecordDialog<MemberPayment> getRecordDialog(Shell shell) {
		throw new UnsupportedOperationException("unused");
	}

	@Override
	protected void resetFilterConditions() {
		// TODO Auto-generated method stub

	}

}
