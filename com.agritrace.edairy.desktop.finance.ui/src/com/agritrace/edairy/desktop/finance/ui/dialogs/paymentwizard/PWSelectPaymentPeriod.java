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
import com.agritrace.edairy.desktop.persistence.finance.IMemberPaymentsRepository;
import com.google.inject.Inject;

public class PWSelectPaymentPeriod extends WizardPage {

	public static final String[] MONTHS = new String[] { "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December", };

	public static final String PAYMENT_MONTH = "paymentMonth";
	public static final String PAYMENT_YEAR = "paymentYear";

	private IMemberPaymentsRepository paymentsRepo;

	/**
	 * Create the wizard.
	 * 
	 * @param wizardModel
	 * @param pmtRepo
	 */
	@Inject
	public PWSelectPaymentPeriod(IMemberPaymentsRepository pmtRepo) {
		super("paymentPeriod");
		setTitle("Select Payment Period");
		setDescription("Select the payment period you want to calculate member payments for.");
		this.paymentsRepo = pmtRepo;
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	@Override
	public void createControl(Composite parent) {
		basicCreateControl(parent);
	}

	private void basicCreateControl(Composite parent) {
		Composite container = UIControlsFactory.createComposite(parent, SWT.NULL);
		FormLayout topLayout = new FormLayout();
		topLayout.marginWidth = 10;
		topLayout.marginHeight = 10;
		container.setLayout(topLayout);

		Composite comp = UIControlsFactory.createComposite(container, SWT.NULL);
		comp.setLayout(new GridLayout(1, false));
		{
			Composite row = UIControlsFactory.createComposite(comp);
			row.setLayout(new GridLayout(2, false));
			row.setLayoutData(GridDataFactory.defaultsFor(row).grab(true, false).create());

			Label lbl = UIControlsFactory.createLabel(row, "Year");
			GridDataFactory.defaultsFor(lbl).hint(FormUtil.WIDTH_UNIT * 2, SWT.DEFAULT).applyTo(lbl);

			final Combo control = UIControlsFactory.createCombo(row, MilkPriceJournalConstants.ID_COMBO_RATEYEAR);
			GridDataFactory.defaultsFor(control).grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(control);
			final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			String[] items = new String[5];
			int count = 0;
			for (int i = (currentYear - 2); i < currentYear + 3; i++) {
				items[count++] = String.valueOf(i);
			}
			control.setItems(items);
			int paymentYear;
			try {
				paymentYear = getWizard().getDialogSettings().getInt("paymentYear");
				control.setText(items[currentYear - paymentYear + 2]);
			} catch (ArrayIndexOutOfBoundsException aioobe) {
				control.setText(items[2]);
			}

			control.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					int selected = control.getSelectionIndex();
					if (selected >= 0) {
						selected -= 2;
						getWizard().getDialogSettings().put("paymentYear", currentYear + selected);
						validateModel();
					}
				}
			});

		}
		{
			Composite row = UIControlsFactory.createComposite(comp);
			row.setLayout(new GridLayout(2, false));
			row.setLayoutData(GridDataFactory.defaultsFor(row).grab(true, false).create());

			Label lblMonth = UIControlsFactory.createLabel(row, "Month");
			GridDataFactory.defaultsFor(lblMonth).hint(FormUtil.WIDTH_UNIT * 2, SWT.DEFAULT).applyTo(lblMonth);

			final Combo control = UIControlsFactory.createCombo(row, MilkPriceJournalConstants.ID_COMBO_RATEMONTH);
			GridDataFactory.defaultsFor(control).grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(control);
			int paymentMonth = getWizard().getDialogSettings().getInt("paymentMonth");
			control.setItems(MONTHS);
			control.setText(MONTHS[paymentMonth]);
			control.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					int selected = control.getSelectionIndex();
					if (selected >= 0) {
						getWizard().getDialogSettings().put("paymentMonth", selected);
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
		validateModel();

	}

	private void validateModel() {
		int paymentYear = getWizard().getDialogSettings().getInt(PAYMENT_YEAR);
		int paymentMonth = getWizard().getDialogSettings().getInt(PAYMENT_MONTH);

		MilkPrice paymentRecord = paymentsRepo.getPaymentForPeriod(paymentYear, paymentMonth);
		if (paymentRecord != null) {
			Employee first = paymentRecord.getEnteredBy();
			setErrorMessage(String.format(
					"A payment run for the selected period was already executed on %s by %s %s (%s).",
					paymentRecord.getEntryDate(), first.getGivenName(), first.getFamilyName(), first.getId()));
			setPageComplete(false);
		} else {
			setErrorMessage(null);
			setPageComplete(true);

		}
	}

}