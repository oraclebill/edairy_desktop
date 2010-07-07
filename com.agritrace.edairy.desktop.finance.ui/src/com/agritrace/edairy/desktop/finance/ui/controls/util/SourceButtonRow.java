package com.agritrace.edairy.desktop.finance.ui.controls.util;

import org.eclipse.riena.ui.swt.ChoiceComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.agritrace.edairy.desktop.finance.ui.FormConstants;

public class SourceButtonRow extends Composite {

	Button btnCashPayment;
	Button btnCreditSale;
	Button btnShareDeduction;
	Button btnVetServices;
	Label lblTransactionSource;
	ChoiceComposite sourceSelectorPanel;

	public SourceButtonRow(Composite parent, int backgroundMode, String label) {
		super(parent, SWT.NONE);

		final GridLayout gl_composite = new GridLayout(2, false);
		gl_composite.marginLeft = 5;
		setLayout(gl_composite);

		lblTransactionSource = new Label(this, SWT.NONE);
		final GridData gd_lblTransactionSource = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_lblTransactionSource.verticalIndent = 8;
		gd_lblTransactionSource.widthHint = FormConstants.LABEL_WIDTH;
		lblTransactionSource.setLayoutData(gd_lblTransactionSource);
		lblTransactionSource.setText(label);

		sourceSelectorPanel = new ChoiceComposite(this, SWT.BORDER, false);
		// sourceSelectorPanel.setBounds(0, 0, 64, 64);
		sourceSelectorPanel.setLayout(new GridLayout(2, false));

		btnCreditSale = addButton("Credit Sale", "btnCreditSale");
		btnCashPayment = addButton("Cash Payment", "btnCashPayment");
		btnVetServices = addButton("Vet Services", "btnVetServices");
		btnShareDeduction = addButton("Share Deduction", "btnShareDeduction");
	}

	public SourceButtonRow(Composite parent, String string) {
		this(parent, SWT.NONE, string);
	}

	public Button getBtnCashPayment() {
		return btnCashPayment;
	}

	public Button getBtnCreditSale() {
		return btnCreditSale;
	}

	public Button getBtnShareDeduction() {
		return btnShareDeduction;
	}

	public Button getBtnVetServices() {
		return btnVetServices;
	}

	public ChoiceComposite getSourceSelectorPanel() {
		return sourceSelectorPanel;
	}

	public void setBtnCashPayment(Button btnCashPayment) {
		this.btnCashPayment = btnCashPayment;
	}

	public void setBtnCreditSale(Button btnCreditSale) {
		this.btnCreditSale = btnCreditSale;
	}

	public void setBtnShareDeduction(Button btnShareDeduction) {
		this.btnShareDeduction = btnShareDeduction;
	}

	public void setBtnVetServices(Button btnVetServices) {
		this.btnVetServices = btnVetServices;
	}

	public void setSourceSelectorPanel(ChoiceComposite sourceSelectorPanel) {
		this.sourceSelectorPanel = sourceSelectorPanel;
	}

	private Button addButton(String buttonLabel, String ridgetId) {
		final Button button = new Button(sourceSelectorPanel, SWT.FLAT | SWT.RADIO);
		final GridData gd = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd.widthHint = 120;
		button.setLayoutData(gd);
		button.setText(buttonLabel);
		// SWTBindingPropertyLocator.getInstance().setBindingProperty(button,
		// ridgetId);
		return button;
	}

}