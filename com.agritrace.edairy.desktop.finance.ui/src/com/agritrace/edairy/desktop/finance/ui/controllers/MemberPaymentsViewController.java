package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.MilkPrice;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard.MemberPaymentProcessWizard;
import com.google.inject.Inject;

public class MemberPaymentsViewController extends
		BasicDirectoryController<MilkPrice> {


	private final class BlankColumnFormatter extends ColumnFormatter {
		@Override
		public String getText(Object element) {
			return "?";
		}
	}

	private static final class PaymentButtonListener implements IActionListener {
		@Override
		public void callback() {
			MemberPaymentProcessWizard paymentsWizard = new MemberPaymentProcessWizard();
			Shell shell = PlatformUI.getWorkbench().getDisplay()
					.getActiveShell();
			WizardDialog wizDialog = new WizardDialog(shell, paymentsWizard);

			if (wizDialog.open() == Dialog.OK) {
				// paymentsWizard;
			}
		}
	}

	@Inject
	public MemberPaymentsViewController(IRepository<MilkPrice> paymentsRepository) {
		setEClass(DairyPackage.Literals.MILK_PRICE);
		setRepository(paymentsRepository);

		addTableColumn("Year", DairyPackage.Literals.MILK_PRICE__YEAR);
		addTableColumn("Month", DairyPackage.Literals.MILK_PRICE__YEAR);
		addTableColumn("Rate", DairyPackage.Literals.MILK_PRICE__VALUE);
		addTableColumn("Farmer Count", DairyPackage.Literals.MILK_PRICE__ID,
				new BlankColumnFormatter());
		addTableColumn("Average Payment", DairyPackage.Literals.MILK_PRICE__ID,
				new BlankColumnFormatter());
		addTableColumn("Total Payments", DairyPackage.Literals.MILK_PRICE__ID,
				new BlankColumnFormatter());
		addTableColumn("Run On", DairyPackage.Literals.MILK_PRICE__ENTRY_DATE);
		addTableColumn("By", DairyPackage.Literals.MILK_PRICE__ENTERED_BY);
	}

	@Override
	protected void configureFilterRidgets() {
		// TODO:
	}

	@Override
	protected List<MilkPrice> getFilteredResult() {
		return getRepository().all();
	}

	@Override
	protected void configureViewItemButton(IActionRidget viewBtnRidget) {
		viewBtnRidget.setVisible(false);
	}

	@Override
	protected void configureNewItemButton(IActionRidget newBtnRidget) {
		newBtnRidget.setText("Run Member Payment Process");
		newBtnRidget.addListener(new PaymentButtonListener());
	}

	@Override
	protected RecordDialog<MilkPrice> getRecordDialog(Shell shell) {
		throw new UnsupportedOperationException("unused");
	}

	@Override
	protected void resetFilterConditions() {
		// TODO Auto-generated method stub

	}

}
