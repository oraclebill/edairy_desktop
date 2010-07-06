package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.riena.ui.swt.ChoiceComposite;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.grouplayout.GroupLayout;
import org.eclipse.swt.layout.grouplayout.LayoutStyle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.swtdesigner.ResourceManager;

public class AccountTransactionEditPanel extends Composite {

	private final Text checkNumberText;
	private final Text descriptionText;
	private final Text signedByText;

	public AccountTransactionEditPanel(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout());
		final Composite middlePanel = UIControlsFactory.createGroup(this, "Transaction Entry");
		// middlePanel.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, true,
		// false));

		final Label lblTransactionType = UIControlsFactory.createLabel(middlePanel, "Type");

		final ChoiceComposite transactionTypeBox = UIControlsFactory.createChoiceComposite(middlePanel, SWT.NONE,
				false, FinanceBindingConstants.ID_TRANSACTION_CHOICE);
		transactionTypeBox.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnStoreSale = UIControlsFactory.createButtonRadio(transactionTypeBox, "Store Sale",
				FinanceBindingConstants.ID_STORE_SALE_CHOICEBTN);

		final Button btnPayment = UIControlsFactory.createButtonRadio(transactionTypeBox, "Payment",
				FinanceBindingConstants.ID_PAYMENT_CHOICEBTN);

		UIControlsFactory.createButtonRadio(transactionTypeBox, "Veterinary",
				FinanceBindingConstants.ID_VETERINARY_CHOICEBTN);

		UIControlsFactory.createButtonRadio(transactionTypeBox, "Share Deduction",
				FinanceBindingConstants.ID_SHARE_DEDUCTION_CHOICEBTN);

		final Label dateLabel = UIControlsFactory.createLabel(middlePanel, "Date");

		final DateTime transactionDate = UIControlsFactory.createDate(middlePanel, SWT.MEDIUM,
				FinanceBindingConstants.ID_TRANSACTION_DATE);

		final Label lblStore = UIControlsFactory.createLabel(middlePanel, "Store");

		final CCombo locationCombo = UIControlsFactory.createCCombo(middlePanel,
				FinanceBindingConstants.ID_DAIRY_LOCATION_COMBO);
		locationCombo.setItems(new String[] { "Sample Route" });
		locationCombo.select(0);

		final Label lblRefNumber = UIControlsFactory.createLabel(middlePanel, "Member");

		final Text refNumberText = UIControlsFactory.createText(middlePanel, SWT.NONE,
				FinanceBindingConstants.ID_MEMBER_NAME_TEXT);
		refNumberText.setTextLimit(20);
		refNumberText.setText("V-4599887");

		final Label lblMember = UIControlsFactory.createLabel(middlePanel, "Reference No.");

		final Text memberText = UIControlsFactory.createText(middlePanel, SWT.NONE,
				FinanceBindingConstants.ID_REF_NUMBER_TEXT);
		memberText.setTextLimit(20);
		memberText.setText("#45678");
		final Label lblAmount = UIControlsFactory.createLabel(middlePanel, "Amount");

		final Text amountText = UIControlsFactory.createTextDecimal(middlePanel,
				FinanceBindingConstants.ID_TRANSACTION_AMOUNT_TEXT);
		amountText.setTextLimit(20);
		amountText.setText("90");

		final Label lblDescription = UIControlsFactory.createLabel(middlePanel, "Description");

		descriptionText = UIControlsFactory.createTextMulti(middlePanel, false, false,
				FinanceBindingConstants.ID_TRANSACTION_DESCRIPTION_TEXT);

		final Label lblCheckNumber = UIControlsFactory.createLabel(middlePanel, "Check Number");

		checkNumberText = UIControlsFactory.createText(middlePanel, SWT.NONE,
				FinanceBindingConstants.ID_CHECK_NUMBER_TEXT);

		final Label lblSignedBy = UIControlsFactory.createLabel(middlePanel, "Signed By");

		signedByText = UIControlsFactory.createText(middlePanel, SWT.NONE, FinanceBindingConstants.ID_SIGNED_BY_TEXT);

		final Button memberLookupButton = new Button(middlePanel, SWT.FLAT);
		memberLookupButton.setImage(ResourceManager.getPluginImage("com.agritrace.edairy.desktop.icons",
				"icons/find.png"));
		SWTBindingPropertyLocator.getInstance().setBindingProperty(memberLookupButton,
				FinanceBindingConstants.ID_MEMBER_LOOKUP_BTN);
		final GroupLayout gl_middlePanel = new GroupLayout(middlePanel);
		gl_middlePanel.setHorizontalGroup(gl_middlePanel.createParallelGroup(GroupLayout.LEADING).add(
				gl_middlePanel
						.createSequentialGroup()
						.add(5)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.LEADING)
								.add(gl_middlePanel
										.createSequentialGroup()
										.add(gl_middlePanel.createParallelGroup(GroupLayout.LEADING).add(lblSignedBy)
												.add(lblCheckNumber).add(lblDescription).add(lblAmount).add(lblMember))
										.addPreferredGap(LayoutStyle.RELATED)
										.add(gl_middlePanel
												.createParallelGroup(GroupLayout.LEADING)
												.add(signedByText, GroupLayout.PREFERRED_SIZE, 225,
														GroupLayout.PREFERRED_SIZE)
												.add(checkNumberText, GroupLayout.PREFERRED_SIZE, 225,
														GroupLayout.PREFERRED_SIZE)
												.add(descriptionText, GroupLayout.PREFERRED_SIZE, 225,
														GroupLayout.PREFERRED_SIZE)
												.add(amountText, GroupLayout.PREFERRED_SIZE, 111,
														GroupLayout.PREFERRED_SIZE)
												.add(memberText, GroupLayout.PREFERRED_SIZE, 225,
														GroupLayout.PREFERRED_SIZE)
												.add(locationCombo, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.add(gl_middlePanel
														.createSequentialGroup()
														.add(refNumberText, GroupLayout.PREFERRED_SIZE, 196,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.RELATED)
														.add(memberLookupButton, GroupLayout.PREFERRED_SIZE, 35,
																GroupLayout.PREFERRED_SIZE))
												.add(transactionDate, GroupLayout.PREFERRED_SIZE, 150,
														GroupLayout.PREFERRED_SIZE)
												.add(transactionTypeBox, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.add(lblTransactionType).add(dateLabel).add(lblStore).add(lblRefNumber))
						.addContainerGap(123, Short.MAX_VALUE)));
		gl_middlePanel.setVerticalGroup(gl_middlePanel.createParallelGroup(GroupLayout.LEADING).add(
				gl_middlePanel
						.createSequentialGroup()
						.add(10)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.BASELINE)
								.add(lblTransactionType)
								.add(transactionTypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.RELATED)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.BASELINE)
								.add(transactionDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE).add(dateLabel))
						.addPreferredGap(LayoutStyle.RELATED)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.BASELINE)
								.add(refNumberText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE).add(lblRefNumber)
								.add(memberLookupButton, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.RELATED)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.BASELINE)
								.add(locationCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE).add(lblStore))
						.add(40)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.BASELINE)
								.add(memberText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE).add(lblMember))
						.add(9)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.BASELINE)
								.add(amountText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE).add(lblAmount))
						.add(5)
						.add(gl_middlePanel.createParallelGroup(GroupLayout.BASELINE)
								.add(descriptionText, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.add(lblDescription))
						.addPreferredGap(LayoutStyle.RELATED)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.BASELINE)
								.add(checkNumberText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE).add(lblCheckNumber))
						.add(5)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.BASELINE)
								.add(signedByText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE).add(lblSignedBy)).add(71)));
		gl_middlePanel.linkSize(new Control[] { locationCombo, refNumberText, memberLookupButton, memberText,
				amountText, checkNumberText, signedByText }, GroupLayout.VERTICAL);
		middlePanel.setLayout(gl_middlePanel);

		btnStoreSale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				System.err.println(">>>>> default selection on " + e.getSource());
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				final boolean enabled = btnStoreSale.getSelection();
				lblStore.setVisible(enabled);
				locationCombo.setVisible(enabled);
				locationCombo.setEnabled(enabled);
				locationCombo.setText("");
			}

		});
		btnPayment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final boolean enabled = btnPayment.getSelection();

				lblCheckNumber.setVisible(enabled);
				checkNumberText.setVisible(enabled);
				checkNumberText.setEnabled(enabled);
				checkNumberText.setText("");

				lblSignedBy.setVisible(enabled);
				signedByText.setVisible(enabled);
				signedByText.setEnabled(enabled);
				signedByText.setText("");
			}

		});

	}
}