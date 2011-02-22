package com.agritrace.edairy.desktop.finance.ui.views;

import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.finance.ui.controllers.PaymentRequestViewController;

public class PaymentRequestView extends SubModuleView {
	
	public static final String ID = "com.agritrace.edairy.desktop.finance.ui.views.PaymentRequestView";
	public PaymentRequestView() {
	}
	private Text text;
	private Text text_1;
	private Table table;

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected void basicCreatePartControl(Composite parent) {
		// TODO Auto-generated method stub		
		parent.setLayout(new FillLayout());
		Composite container = UIControlsFactory.createComposite(parent, SWT.NONE);
		container.setLayout(new FormLayout());
//		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblPeriod = UIControlsFactory.createLabel(container,"Period");
		FormData fd_lblPeriod = new FormData();
		fd_lblPeriod.left = new FormAttachment(0, 10);
		fd_lblPeriod.top = new FormAttachment(0, 10);
		lblPeriod.setLayoutData(fd_lblPeriod);
		lblPeriod.setText("Period");
		
		Label lblPaymentRate = UIControlsFactory.createLabel(container,"Payment Rate");
		FormData fd_lblPaymentRate = new FormData();
		fd_lblPaymentRate.top = new FormAttachment(lblPeriod, 6);
		fd_lblPaymentRate.left = new FormAttachment(lblPeriod, 0, SWT.LEFT);
		fd_lblPaymentRate.right = new FormAttachment(0, 98);
		lblPaymentRate.setLayoutData(fd_lblPaymentRate);
		lblPaymentRate.setText("Payment Rate");
		
		Label lblTotalMilkCollected = UIControlsFactory.createLabel(container,"Gross Collections");
		FormData fd_lblTotalMilkCollected = new FormData();
		fd_lblTotalMilkCollected.top = new FormAttachment(lblPeriod, 0, SWT.TOP);
		lblTotalMilkCollected.setLayoutData(fd_lblTotalMilkCollected);
		lblTotalMilkCollected.setText("Gross Collections");
		
		CCombo combo = UIControlsFactory.createCCombo(container, PaymentRequestViewController.PAYMENT_PERIOD_COMBO);
		fd_lblTotalMilkCollected.left = new FormAttachment(combo, 35);
		fd_lblPeriod.right = new FormAttachment(combo, -31);
		FormData fd_combo = new FormData();
		fd_combo.left = new FormAttachment(0, 100);
		fd_combo.right = new FormAttachment(100, -342);
		fd_combo.top = new FormAttachment(lblPeriod, -1, SWT.TOP);
		fd_combo.bottom = new FormAttachment(0, 24);
		combo.setLayoutData(fd_combo);
		
		text = UIControlsFactory.createTextDecimal(container, PaymentRequestViewController.GROSS_COLLECTIONS_TEXT);
		fd_lblTotalMilkCollected.right = new FormAttachment(100, -204);
		FormData fd_text = new FormData();
		fd_text.right = new FormAttachment(lblTotalMilkCollected, 122, SWT.RIGHT);
		fd_text.left = new FormAttachment(lblTotalMilkCollected, 6);
		fd_text.top = new FormAttachment(lblPeriod, -3, SWT.TOP);
		text.setLayoutData(fd_text);
		text.setEditable(false);
		text.setEnabled(false);
		
		text_1 = UIControlsFactory.createTextDecimal(container, PaymentRequestViewController.PAYMENT_RATE_TEXT);
		FormData fd_text_1 = new FormData();
		fd_text_1.right = new FormAttachment(combo, 0, SWT.RIGHT);
		fd_text_1.left = new FormAttachment(lblPaymentRate, 2);
		fd_text_1.top = new FormAttachment(lblPaymentRate, -3, SWT.TOP);
		text_1.setLayoutData(fd_text_1);
		
		table = UIControlsFactory.createTable(container, SWT.BORDER | SWT.FULL_SELECTION, PaymentRequestViewController.RATE_TABLE);
		FormData fd_table = new FormData();
		fd_table.left = new FormAttachment(0, 10);
		fd_table.right = new FormAttachment(100, -10);
		table.setLayoutData(fd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnRate = new TableColumn(table, SWT.NONE);
		tblclmnRate.setWidth(141);
		tblclmnRate.setText("Rate");
		
		TableColumn tblclmnGrossPayment = new TableColumn(table, SWT.NONE);
		tblclmnGrossPayment.setWidth(283);
		tblclmnGrossPayment.setText("Gross Payment");
		
		Button btnGenerate = UIControlsFactory.createButton(container, "Calculate Payments", PaymentRequestViewController.CALCULATE_BUTTON);
		int buttonWidth = btnGenerate.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
		fd_table.top = new FormAttachment(btnGenerate, 6);
		FormData fd_btnGenerate = new FormData();
		fd_btnGenerate.top = new FormAttachment(text_1, 6);
		fd_btnGenerate.left = new FormAttachment(50, 100, -buttonWidth/2);
		fd_btnGenerate.right = new FormAttachment(50, 100, buttonWidth/2);
		btnGenerate.setLayoutData(fd_btnGenerate);
//		btnGenerate.setText("Generate");
		
		Button btnPrint = UIControlsFactory.createButton(container, "Print", PaymentRequestViewController.PRINT_BUTTON);
		 buttonWidth = btnPrint.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
		
		fd_table.bottom = new FormAttachment(100, -161);
		FormData fd_btnPrint = new FormData();
		fd_btnPrint.top = new FormAttachment(table, 6);
		fd_btnPrint.left = new FormAttachment(50, 100, -buttonWidth/2);
		fd_btnPrint.right = new FormAttachment(50, 100, buttonWidth/2);
		btnPrint.setLayoutData(fd_btnPrint);
		btnPrint.setText("Print");
	}

}
