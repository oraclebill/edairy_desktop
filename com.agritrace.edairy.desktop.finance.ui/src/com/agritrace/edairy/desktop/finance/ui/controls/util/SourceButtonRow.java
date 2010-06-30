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

		Label lblTransactionSource;
		ChoiceComposite sourceSelectorPanel;
		Button btnCreditSale;
		Button btnCashPayment;
		Button btnVetServices;
		Button btnShareDeduction;
		
		
		public SourceButtonRow(Composite parent, String string) {
			this(parent, SWT.NONE, string);
		}

		public SourceButtonRow(Composite parent, int backgroundMode, String label) {
			super(parent, SWT.NONE);

			GridLayout gl_composite = new GridLayout(2, false);
			gl_composite.marginLeft = 5;
			setLayout(gl_composite);

			lblTransactionSource = new Label(this, SWT.NONE);
			GridData gd_lblTransactionSource = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
			gd_lblTransactionSource.verticalIndent = 8;
			gd_lblTransactionSource.widthHint = FormConstants.LABEL_WIDTH;
			lblTransactionSource.setLayoutData(gd_lblTransactionSource);
			lblTransactionSource.setText(label);
			
			sourceSelectorPanel = new ChoiceComposite(this, SWT.BORDER, false);
//			sourceSelectorPanel.setBounds(0, 0, 64, 64);
			sourceSelectorPanel.setLayout(new GridLayout(2, false));
			
			btnCreditSale = addButton("Credit Sale", "btnCreditSale");
			btnCashPayment =  addButton("Cash Payment", "btnCashPayment");
			btnVetServices  = addButton("Vet Services", "btnVetServices");
			btnShareDeduction = addButton("Share Deduction", "btnShareDeduction");			
		}
		
		private Button addButton(String buttonLabel, String ridgetId) {
			Button button = new Button(sourceSelectorPanel, SWT.FLAT | SWT.RADIO);
			GridData gd = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd.widthHint = 120;
			button.setLayoutData(gd);
			button.setText(buttonLabel);	
//			SWTBindingPropertyLocator.getInstance().setBindingProperty(button, ridgetId);
			return button;
		}

		public ChoiceComposite getSourceSelectorPanel() {
			return sourceSelectorPanel;
		}

		public void setSourceSelectorPanel(ChoiceComposite sourceSelectorPanel) {
			this.sourceSelectorPanel = sourceSelectorPanel;
		}

		public Button getBtnCreditSale() {
			return btnCreditSale;
		}

		public void setBtnCreditSale(Button btnCreditSale) {
			this.btnCreditSale = btnCreditSale;
		}

		public Button getBtnCashPayment() {
			return btnCashPayment;
		}

		public void setBtnCashPayment(Button btnCashPayment) {
			this.btnCashPayment = btnCashPayment;
		}

		public Button getBtnVetServices() {
			return btnVetServices;
		}

		public void setBtnVetServices(Button btnVetServices) {
			this.btnVetServices = btnVetServices;
		}

		public Button getBtnShareDeduction() {
			return btnShareDeduction;
		}

		public void setBtnShareDeduction(Button btnShareDeduction) {
			this.btnShareDeduction = btnShareDeduction;
		}		
		
		
	}