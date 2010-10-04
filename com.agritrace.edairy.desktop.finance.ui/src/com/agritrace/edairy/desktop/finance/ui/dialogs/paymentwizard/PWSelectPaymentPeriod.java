package com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard;

import java.util.Calendar;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.MilkPrice;
import com.agritrace.edairy.desktop.common.ui.util.FormUtil;
import com.agritrace.edairy.desktop.finance.ui.MilkPriceJournalConstants;
import com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard.MemberPaymentProcessWizard.PaymentWizardModel;
import com.agritrace.edairy.desktop.persistence.finance.IMemberPaymentsRepository;

public class PWSelectPaymentPeriod extends WizardPage {
	private PaymentWizardModel wizardModel;
	private IMemberPaymentsRepository paymentsRepo;

	/**
	 * Create the wizard.
	 * 
	 * @param wizardModel
	 * @param pmtRepo
	 */
	public PWSelectPaymentPeriod(PaymentWizardModel wizardModel,
			IMemberPaymentsRepository pmtRepo) {
		super("wizardPage");
		setTitle("Select Payment Period");
		setDescription("Select the payment period you want to calculate member payments for.");
		this.wizardModel = wizardModel;
		this.paymentsRepo = pmtRepo;
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		basicCreateControl(parent);
	}

	private void basicCreateControl(Composite parent) {
		Composite container = UIControlsFactory.createComposite(parent,
				SWT.NULL);
		FormLayout topLayout = new FormLayout();
		topLayout.marginWidth = 10;
		topLayout.marginHeight = 10;
		container.setLayout(topLayout);

		Composite comp = UIControlsFactory.createComposite(container, SWT.NULL);
		comp.setLayout(new GridLayout(1, false));
		{
			Composite row = UIControlsFactory.createComposite(comp);
			row.setLayout(new GridLayout(2, false));
			row.setLayoutData(GridDataFactory.defaultsFor(row)
					.grab(true, false).create());

			Label lbl = UIControlsFactory.createLabel(row, "Year");
			GridDataFactory.defaultsFor(lbl)
					.hint(FormUtil.WIDTH_UNIT * 2, SWT.DEFAULT).applyTo(lbl);

			final Combo control = UIControlsFactory.createCombo(row,
					MilkPriceJournalConstants.ID_COMBO_RATEYEAR);
			GridDataFactory.defaultsFor(control).grab(true, true)
					.align(SWT.FILL, SWT.FILL).applyTo(control);
			final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			String[] items = new String[5];
			int count = 0;
			for (int i = (currentYear - 2); i < currentYear + 3; i++) {
				items[count++] = String.valueOf(i);
			}
			control.setItems(items);
			try {
				control.setText(items[currentYear - wizardModel.getPaymentYear() + 2]);
			}
			catch(ArrayIndexOutOfBoundsException aioobe) {
				control.setText(items[2]);
			}
			
			
			control.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					int selected = control.getSelectionIndex();
					System.err.println("YEAR: ---- " + selected);
					if (selected >= 0) {
						selected -= 2;
						System.err.println("YEAR: ---- "
								+ (currentYear + selected));
						wizardModel.setPaymentYear(currentYear + selected);
						validateModel();
					}
				}
			});

		}
		{
			Composite row = UIControlsFactory.createComposite(comp);
			row.setLayout(new GridLayout(2, false));
			row.setLayoutData(GridDataFactory.defaultsFor(row)
					.grab(true, false).create());

			Label lblMonth = UIControlsFactory.createLabel(row, "Month");
			GridDataFactory.defaultsFor(lblMonth)
					.hint(FormUtil.WIDTH_UNIT * 2, SWT.DEFAULT)
					.applyTo(lblMonth);

			final Combo control = UIControlsFactory.createCombo(row,
					MilkPriceJournalConstants.ID_COMBO_RATEMONTH);
			GridDataFactory.defaultsFor(control).grab(true, true)
					.align(SWT.FILL, SWT.FILL).applyTo(control);
			String[] items = wizardModel.getMonths();
			control.setItems(items);
			control.setText(items[wizardModel.getPaymentMonth()]);
			control.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					int selected = control.getSelectionIndex();
					System.err.println("MONTH: ---- " + selected);
					if (selected >= 0) {
						System.err.println("MONTH: ---- " + selected);
						wizardModel.setPaymentMonth(selected);
						validateModel();
					}
				}
			});
		}

		FormData compData = new FormData();
		compData.top = new FormAttachment(20);
		compData.right = new FormAttachment(80);
		compData.bottom = new FormAttachment(80);
		compData.left = new FormAttachment(20);
		comp.setLayoutData(compData);

		setControl(container);
		setPageComplete(false);

	}

//	@Override
//	public boolean isPageComplete() {
//		boolean hasMonth, hasYear;
//		String message = "";
//		hasMonth = wizardModel.getPaymentMonth() > -1;
//		if (!hasMonth) {
//			message = "You must enter a payment month to continue.";
//		}
//		hasYear = wizardModel.getPaymentYear() > 1990
//				&& wizardModel.getPaymentYear() < 3000;
//		if (!hasYear) {
//			message += "\nYou must enter a payment year to continue";
//		}
//		boolean isValid = hasMonth && hasYear;
//		if (!isValid)
//			setErrorMessage(message);
//		else
//			setErrorMessage(null);
//		System.err.println("VALIDATE: year = " + isValid);
//		return isValid;
//	}

	private void validateModel() {
		MilkPrice paymentRecord = paymentsRepo.getPaymentForPeriod(
				wizardModel.getPaymentYear(), wizardModel.getPaymentMonth());
		if (paymentRecord != null) {
			Employee first = paymentRecord.getEnteredBy();
			setErrorMessage(String
					.format("A payment run for the selected period was already executed on %s by %s %s (%s).",
							paymentRecord.getEntryDate(), first.getGivenName(),
							first.getFamilyName(), first.getId()));
			setPageComplete(false);
		} else {
			setErrorMessage(null);
			setPageComplete(true);

		}
	}

}
