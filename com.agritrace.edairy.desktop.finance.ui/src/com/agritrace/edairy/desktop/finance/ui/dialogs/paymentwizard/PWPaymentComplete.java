package com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.finance.ui.dialogs.paymentwizard.MemberPaymentProcessWizard.PaymentWizardModel;

public class PWPaymentComplete extends WizardPage {
	private Table table;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;

	/**
	 * Create the wizard.
	 */
	public PWPaymentComplete(PaymentWizardModel wizardModel) {
		super("wizardPage");
		setTitle("Apply Payments");
		setDescription("This table displays the payments that have been calculated. If you complete the wizard, these payments will be entered.");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		GridLayout gl_container = new GridLayout(1, false);
		gl_container.marginWidth = 10;
		container.setLayout(gl_container);
		
		Composite composite = new Composite(container, SWT.NONE);
		GridLayout gl_composite = new GridLayout(2, false);
		gl_composite.marginHeight = 15;
		gl_composite.marginWidth = 10;
		gl_composite.horizontalSpacing = 15;
		composite.setLayout(gl_composite);
		
		Label lblRunDate = new Label(composite, SWT.NONE);
		lblRunDate.setText("Run Date");
		
		text_5 = new Text(composite, SWT.BORDER);
		text_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPaymentPeriod = new Label(composite, SWT.NONE);
		lblPaymentPeriod.setBounds(0, 0, 59, 14);
		lblPaymentPeriod.setText("Payment Period");
		
		text = new Text(composite, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text.widthHint = 80;
		text.setLayoutData(gd_text);
		
		Label lblPaymentRate = new Label(composite, SWT.NONE);
		lblPaymentRate.setBounds(0, 0, 59, 14);
		lblPaymentRate.setText("Payment Rate");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblFarmers = new Label(composite, SWT.NONE);
		lblFarmers.setBounds(0, 0, 59, 14);
		lblFarmers.setText("# Farmers");
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblAvgPayment = new Label(composite, SWT.NONE);
		lblAvgPayment.setBounds(0, 0, 59, 14);
		lblAvgPayment.setText("Avg. Payment");
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblTotalPaidThis = new Label(composite, SWT.NONE);
		lblTotalPaidThis.setBounds(0, 0, 59, 14);
		lblTotalPaidThis.setText("Total Paid this Period");
		
		text_4 = new Text(composite, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnMember = new TableColumn(table, SWT.CENTER);
		tblclmnMember.setWidth(40);
		tblclmnMember.setText("ID");
		
		TableColumn tblclmnMemberName = new TableColumn(table, SWT.CENTER);
		tblclmnMemberName.setWidth(200);
		tblclmnMemberName.setText(" Name");
		
		TableColumn tblclmnMilkIncome = new TableColumn(table, SWT.CENTER);
		tblclmnMilkIncome.setWidth(80);
		tblclmnMilkIncome.setText("Milk Income");
		
		TableColumn tblclmnCreditSales = new TableColumn(table, SWT.CENTER);
		tblclmnCreditSales.setWidth(80);
		tblclmnCreditSales.setText("Credit Sales");
		
		TableColumn tblclmnAdjustments = new TableColumn(table, SWT.CENTER);
		tblclmnAdjustments.setWidth(80);
		tblclmnAdjustments.setText("Adjustments");
		
		TableColumn tblclmnPayment = new TableColumn(table, SWT.CENTER);
		tblclmnPayment.setWidth(100);
		tblclmnPayment.setText("Payment");
	}
}
