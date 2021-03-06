package com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard;

import java.math.BigDecimal;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.util.FormToolkit;
import com.agritrace.edairy.desktop.finance.ui.MilkPriceJournalConstants;
import com.google.inject.Inject;

public class PWPaymentRate extends PWPage {

	public static final String[] MONTHS = new String[] { "January", "February",
			"March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December", };

	private final String values[] = new String[2];

	/**
	 * Create the wizard.
	 *
	 * @param model
	 */
	@Inject
	public PWPaymentRate() {
		super("paymentRate");
		setTitle("Payment Rate");
		setDescription("Enter the payment rate for the selected period");
	}

	/**
	 * Create contents of the wizard.
	 *
	 * @param parent
	 */
	@Override
	public void createControl(Composite parent) {
		final Composite container = UIControlsFactory.createComposite(parent,
				SWT.NULL);
		final FormLayout topLayout = new FormLayout();
		topLayout.marginWidth = 10;
		topLayout.marginHeight = 10;
		container.setLayout(topLayout);

		final Composite comp = UIControlsFactory.createComposite(container, SWT.NULL);
		comp.setLayout(new GridLayout(1, false));
		{
			final Composite row = UIControlsFactory.createComposite(comp);
			row.setLayout(new GridLayout(2, false));
			row.setLayoutData(GridDataFactory.defaultsFor(row)
					.grab(true, false).create());

			final Label label = UIControlsFactory.createLabel(row, "Amount");
			GridDataFactory.defaultsFor(label)
					.hint(FormToolkit.WIDTH_UNIT * 2, SWT.DEFAULT).applyTo(label);

			final Text control = UIControlsFactory.createTextDecimal(row,
					MilkPriceJournalConstants.ID_TEXT_PRICE1);
			GridDataFactory.defaultsFor(control)
					.hint(FormToolkit.WIDTH_UNIT, SWT.DEFAULT).applyTo(control);
			control.addModifyListener(new ModifyListener() {

				@Override
				public void modifyText(ModifyEvent e) {
					values[0] = control.getText();
					validate();
				}
			});
		}
		{
			final Composite row = UIControlsFactory.createComposite(comp);
			row.setLayout(new GridLayout(2, false));
			row.setLayoutData(GridDataFactory.defaultsFor(row)
					.grab(true, false).create());

			final Label label = UIControlsFactory.createLabel(row, "Re-enter Amount");
			GridDataFactory.defaultsFor(label)
					.hint(FormToolkit.WIDTH_UNIT * 2, SWT.DEFAULT).applyTo(label);

			final Text control = UIControlsFactory.createTextDecimal(row,
					MilkPriceJournalConstants.ID_TEXT_PRICE2);
			GridDataFactory.defaultsFor(control)
					.hint(FormToolkit.WIDTH_UNIT, SWT.DEFAULT).applyTo(control);
			control.addModifyListener(new ModifyListener() {

				@Override
				public void modifyText(ModifyEvent e) {
					values[1] = control.getText();
					validate();
				}
			});
		}

		final FormData compData = new FormData();
		compData.top = new FormAttachment(20);
		compData.right = new FormAttachment(80);
		compData.bottom = new FormAttachment(80);
		compData.left = new FormAttachment(20);
		comp.setLayoutData(compData);

		setControl(container);
		setPageComplete(false);
	}

	private void validate() {

		try {
			final boolean valid = values[1] != null && values[1].equals(values[0]);
			setErrorMessage(null);
			
			if (valid) {
				put("paymentRate", new BigDecimal(values[1]).toPlainString());
				setPageComplete(true);
			} else {
				setPageComplete(false);
				
				if (!StringUtils.isEmpty(values[1]) && !StringUtils.isEmpty(values[0]) && !values[1].equals(values[0])) {
					setErrorMessage("The entered amounts do not match. Please enter the same amount twice.");
				}
			}
		}
		catch(final Exception e) {
			setPageComplete(false);
			setErrorMessage("You have not entered valid numbers.");
		}
	}
}
