package com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard;

import java.util.HashMap;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

import com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard.MemberPaymentProcessWizard.PaymentWizardModel;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

public class PWSelectPaymentPeriod extends WizardPage {
	private Text text;

	/**
	 * Create the wizard.
	 * @param wizardModel 
	 */
	public PWSelectPaymentPeriod(PaymentWizardModel wizardModel) {
		super("wizardPage");
		setTitle("Select Payment Period");
		setDescription("Select the payment period you want to calculate member payments for.");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new FormLayout());
		
		Label lblPaymentPeriods = new Label(container, SWT.NONE);
		lblPaymentPeriods.setFont(SWTResourceManager.getFont("Lucida Grande", 16, SWT.NORMAL));
		FormData fd_lblPaymentPeriods = new FormData();
		fd_lblPaymentPeriods.top = new FormAttachment(0, 10);
		fd_lblPaymentPeriods.left = new FormAttachment(0, 10);
		lblPaymentPeriods.setLayoutData(fd_lblPaymentPeriods);
		lblPaymentPeriods.setText("Payment Periods");
		
		List list = new List(container, SWT.BORDER);
		FormData fd_list = new FormData();
		fd_list.bottom = new FormAttachment(lblPaymentPeriods, 236, SWT.BOTTOM);
		fd_list.top = new FormAttachment(lblPaymentPeriods, 21);
		fd_list.left = new FormAttachment(0, 10);
		list.setLayoutData(fd_list);
		
		text = new Text(container, SWT.BORDER | SWT.MULTI);
		fd_list.right = new FormAttachment(text, -6);
		FormData fd_text = new FormData();
		fd_text.left = new FormAttachment(0, 293);
		fd_text.right = new FormAttachment(100, -6);
		fd_text.top = new FormAttachment(0, 50);
		fd_text.bottom = new FormAttachment(100, -152);
		text.setLayoutData(fd_text);
	}
}
