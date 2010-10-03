package com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import com.agritrace.edairy.desktop.common.ui.util.FormUtil;
import com.agritrace.edairy.desktop.finance.ui.MilkPriceJournalConstants;
import com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard.MemberPaymentProcessWizard.PaymentWizardModel;

public class PWPaymentRate extends WizardPage {
	
	public static final String[] MONTHS = new String[] { "January",
		"February", "March", "April", "May", "June", "July", "August",
		"September", "October", "November", "December", };

	/**
	 * Create the wizard.
	 * @param model 
	 */
	public PWPaymentRate(PaymentWizardModel wizardModel) {
		super("paymentRate");
		setTitle("Payment Rate");
		setDescription("Enter the payment rate for the selected period");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = UIControlsFactory.createComposite(parent, SWT.NULL);
		FormLayout topLayout = new FormLayout( );
		topLayout.marginWidth = 10;
		topLayout.marginHeight = 10;
		container.setLayout(topLayout);
		
		Composite comp = UIControlsFactory.createComposite(container, SWT.NULL);
		comp.setLayout(new GridLayout(1, false));
		{
			Composite row = UIControlsFactory.createComposite(comp);
			row.setLayout(new GridLayout(2, false));
			row.setLayoutData(GridDataFactory.defaultsFor(row).grab(true, false).create());

			Label label = UIControlsFactory.createLabel(row, "Amount");
			GridDataFactory.defaultsFor(label).hint(FormUtil.WIDTH_UNIT * 2, SWT.DEFAULT).applyTo(label);

			Control control = UIControlsFactory.createTextDecimal(row, MilkPriceJournalConstants.ID_TEXT_PRICE1);			
			GridDataFactory.defaultsFor(control).hint(FormUtil.WIDTH_UNIT, SWT.DEFAULT).applyTo(control);
		}
		{
			Composite row = UIControlsFactory.createComposite(comp);
			row.setLayout(new GridLayout(2, false));
			row.setLayoutData(GridDataFactory.defaultsFor(row).grab(true, false).create());

			Label label = UIControlsFactory.createLabel(row, "Re-enter Amount");
			GridDataFactory.defaultsFor(label).hint(FormUtil.WIDTH_UNIT * 2, SWT.DEFAULT).applyTo(label);

			Control control = UIControlsFactory.createTextDecimal(row, MilkPriceJournalConstants.ID_TEXT_PRICE2);			
			GridDataFactory.defaultsFor(control).hint(FormUtil.WIDTH_UNIT , SWT.DEFAULT).applyTo(control);
		}
		
		FormData compData = new FormData();
		compData.top = new FormAttachment(20);
		compData.right = new FormAttachment(80);
		compData.bottom = new FormAttachment(80);
		compData.left = new FormAttachment(20);
		comp.setLayoutData(compData);

		setControl(container);
	}

}
