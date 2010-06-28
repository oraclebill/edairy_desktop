package com.agritrace.edairy.desktop.finance.ui.views;

import org.eclipse.riena.ui.swt.ChoiceComposite;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.grouplayout.GroupLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.internal.finance.ui.Activator;

public class TransactionEntryPanel extends Composite {

	private Text descriptionText;
	private Text checkNumberText;
	private Text signedByText;

	public TransactionEntryPanel(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout());
		final Composite middlePanel = UIControlsFactory.createGroup(this, "Transaction Entry");
		// middlePanel.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, true,
		// false));

		final Label lblTransactionType = UIControlsFactory.createLabel(middlePanel, "Transaction Type");

		final ChoiceComposite transactionTypeBox = UIControlsFactory.createChoiceComposite(middlePanel, SWT.NONE,
				false, FinanceBindingConstants.TRANSACTION_CHOICE);
		transactionTypeBox.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnStoreSale = UIControlsFactory.createButtonRadio(transactionTypeBox, "Store Sale",
				FinanceBindingConstants.STORE_SALE_BTN);

		final Button btnPayment = UIControlsFactory.createButtonRadio(transactionTypeBox, "Payment",
				FinanceBindingConstants.PAYMENT_BTN);

		final Button btnVeterinary = UIControlsFactory.createButtonRadio(transactionTypeBox, "Veterinary",
				FinanceBindingConstants.VETERINARY_BTN);

		final Button btnShareDeduction = UIControlsFactory.createButtonRadio(transactionTypeBox, "Share Deduction",
				FinanceBindingConstants.SHARE_DEDUCTION_BTN);

		final Label dateLabel = UIControlsFactory.createLabel(middlePanel, "Date");

		final DateTime transactionDate = UIControlsFactory.createDate(middlePanel, SWT.MEDIUM,
				FinanceBindingConstants.TRANSACTION_DATE);
		Label label = UIControlsFactory.createLabel(middlePanel, "");
		Label label_1 = UIControlsFactory.createLabel(middlePanel, "");

		final Label lblStore = UIControlsFactory.createLabel(middlePanel, "Store");

		final CCombo locationCombo = UIControlsFactory.createCCombo(middlePanel,
				FinanceBindingConstants.DAIRY_LOCATION_COMBO);
		locationCombo.setItems(new String[] { "Route 2 - Ngecha", "Route 3 - Kelly" });
		locationCombo.select(0);
		Label label_2 = UIControlsFactory.createLabel(middlePanel, "");
		Label label_3 = UIControlsFactory.createLabel(middlePanel, "");

		final Label lblRefNumber = UIControlsFactory.createLabel(middlePanel, "Reference #");

		final Text refNumberText = UIControlsFactory.createText(middlePanel, SWT.NONE,
				FinanceBindingConstants.REF_NUMBER_TEXT);
		refNumberText.setTextLimit(20);
		refNumberText.setText("V-4599887");
		Label label_4 = UIControlsFactory.createLabel(middlePanel, "");
		Label label_5 = UIControlsFactory.createLabel(middlePanel, "");
		Label label_6 = UIControlsFactory.createLabel(middlePanel, "");

		final Label lblRecordId = UIControlsFactory.createLabel(middlePanel, "Record ID");

		final Text recordIDText = UIControlsFactory.createText(middlePanel, SWT.NONE,
				FinanceBindingConstants.RECORD_ID_TEXT);
		recordIDText.setTextLimit(5);
		recordIDText.setText("2");
		Label label_7 = UIControlsFactory.createLabel(middlePanel, "");
		Label label_8 = UIControlsFactory.createLabel(middlePanel, "");
		Label label_9 = UIControlsFactory.createLabel(middlePanel, "");

		final Label lblMember = UIControlsFactory.createLabel(middlePanel, "Member");

		final Text memberText = UIControlsFactory.createText(middlePanel, SWT.NONE,
				FinanceBindingConstants.MEMBER_NAME_TEXT);
		memberText.setTextLimit(20);
		memberText.setText("#45678");

		ImageButton btnMemberLookup = UIControlsFactory.createImageButton(middlePanel, SWT.NULL,
				FinanceBindingConstants.MEMBER_LOOKUP_BTN);
		final Image lookupIcon = Activator.getDefault().getImageRegistry().get(Activator.MEMBER_SEARCH_ICON);
		btnMemberLookup.setImage(lookupIcon);
		Label label_10 = UIControlsFactory.createLabel(middlePanel, "");
		Label label_11 = UIControlsFactory.createLabel(middlePanel, "");

		final Label lblAmount = UIControlsFactory.createLabel(middlePanel, "Amount");

		final Text amountText = UIControlsFactory.createText(middlePanel, SWT.NONE,
				FinanceBindingConstants.TRANSACTION_AMOUNT_TEXT);
		amountText.setTextLimit(20);
		amountText.setText("90");
		Label label_12 = UIControlsFactory.createLabel(middlePanel, "");
		Label label_13 = UIControlsFactory.createLabel(middlePanel, "");

		Label lblDescription = UIControlsFactory.createLabel(middlePanel, "Description");

		descriptionText = UIControlsFactory.createText(middlePanel, SWT.NONE,
				FinanceBindingConstants.TRANSACTION_DESCRIPTION_TEXT);
		Label label_14 = UIControlsFactory.createLabel(middlePanel, "");
		Label label_15 = UIControlsFactory.createLabel(middlePanel, "");

		final Label lblCheckNumber = UIControlsFactory.createLabel(middlePanel, "Check Number");

		checkNumberText = UIControlsFactory
				.createText(middlePanel, SWT.NONE, FinanceBindingConstants.CHECK_NUMBER_TEXT);
		Label label_16 = UIControlsFactory.createLabel(middlePanel, "");
		Label label_17 = UIControlsFactory.createLabel(middlePanel, "");

		final Label lblSignedBy = UIControlsFactory.createLabel(middlePanel, "Signed By");

		signedByText = UIControlsFactory.createText(middlePanel, SWT.NONE, FinanceBindingConstants.SIGNED_BY_TEXT);
		Label label_18 = UIControlsFactory.createLabel(middlePanel, "");
		Label label_19 = UIControlsFactory.createLabel(middlePanel, "");

		final Label filler = UIControlsFactory.createLabel(middlePanel, "");
		Label label_20 = UIControlsFactory.createLabel(middlePanel, "");
		Label label_21 = UIControlsFactory.createLabel(middlePanel, "");
		Label label_22 = UIControlsFactory.createLabel(middlePanel, "");
		GroupLayout gl_middlePanel = new GroupLayout(middlePanel);
		gl_middlePanel
				.setHorizontalGroup(gl_middlePanel.createParallelGroup(GroupLayout.LEADING).add(
						gl_middlePanel
								.createSequentialGroup()
								.add(5)
								.add(gl_middlePanel
										.createParallelGroup(GroupLayout.LEADING)
										.add(gl_middlePanel
												.createSequentialGroup()
												.add(lblTransactionType)
												.add(5)
												.add(transactionTypeBox, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.add(gl_middlePanel
												.createSequentialGroup()
												.add(dateLabel)
												.add(72)
												.add(transactionDate, GroupLayout.PREFERRED_SIZE, 150,
														GroupLayout.PREFERRED_SIZE).add(244).add(label).add(5)
												.add(label_1))
										.add(gl_middlePanel
												.createSequentialGroup()
												.add(lblStore)
												.add(69)
												.add(locationCombo, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).add(215)
												.add(label_2).add(5).add(label_3))
										.add(gl_middlePanel
												.createSequentialGroup()
												.add(lblRefNumber)
												.add(34)
												.add(refNumberText, GroupLayout.PREFERRED_SIZE, 225,
														GroupLayout.PREFERRED_SIZE).add(5).add(label_4).add(98)
												.add(label_5).add(5).add(label_6))
										.add(gl_middlePanel
												.createSequentialGroup()
												.add(lblRecordId)
												.add(45)
												.add(recordIDText, GroupLayout.PREFERRED_SIZE, 225,
														GroupLayout.PREFERRED_SIZE).add(5).add(label_7).add(98)
												.add(label_8).add(5).add(label_9))
										.add(gl_middlePanel
												.createSequentialGroup()
												.add(lblMember)
												.add(53)
												.add(memberText, GroupLayout.PREFERRED_SIZE, 225,
														GroupLayout.PREFERRED_SIZE).add(5).add(btnMemberLookup).add(5)
												.add(label_10).add(5).add(label_11))
										.add(gl_middlePanel
												.createSequentialGroup()
												.add(lblAmount)
												.add(54)
												.add(amountText, GroupLayout.PREFERRED_SIZE, 225,
														GroupLayout.PREFERRED_SIZE).add(5).add(label_12).add(107)
												.add(label_13))
										.add(gl_middlePanel
												.createSequentialGroup()
												.add(lblDescription)
												.add(35)
												.add(descriptionText, GroupLayout.PREFERRED_SIZE, 225,
														GroupLayout.PREFERRED_SIZE).add(5).add(label_14).add(107)
												.add(label_15))
										.add(gl_middlePanel
												.createSequentialGroup()
												.add(lblCheckNumber)
												.add(18)
												.add(checkNumberText, GroupLayout.PREFERRED_SIZE, 225,
														GroupLayout.PREFERRED_SIZE).add(5).add(label_16).add(107)
												.add(label_17))
										.add(gl_middlePanel
												.createSequentialGroup()
												.add(lblSignedBy)
												.add(45)
												.add(signedByText, GroupLayout.PREFERRED_SIZE, 225,
														GroupLayout.PREFERRED_SIZE).add(5).add(label_18).add(107)
												.add(label_19))
										.add(gl_middlePanel.createSequentialGroup().add(filler).add(97).add(label_20)
												.add(226).add(label_21).add(107).add(label_22)))));
		gl_middlePanel.setVerticalGroup(gl_middlePanel.createParallelGroup(GroupLayout.LEADING).add(
				gl_middlePanel
						.createSequentialGroup()
						.add(5)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.LEADING)
								.add(gl_middlePanel.createSequentialGroup().add(5).add(lblTransactionType))
								.add(transactionTypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.add(5)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.LEADING)
								.add(gl_middlePanel.createSequentialGroup().add(4).add(dateLabel))
								.add(transactionDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.add(gl_middlePanel.createSequentialGroup().add(4).add(label))
								.add(gl_middlePanel.createSequentialGroup().add(4).add(label_1)))
						.add(5)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.LEADING)
								.add(lblStore)
								.add(locationCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE).add(label_2).add(label_3))
						.add(5)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.LEADING)
								.add(gl_middlePanel.createSequentialGroup().add(2).add(lblRefNumber))
								.add(refNumberText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.add(gl_middlePanel.createSequentialGroup().add(2).add(label_4))
								.add(gl_middlePanel.createSequentialGroup().add(2).add(label_5))
								.add(gl_middlePanel.createSequentialGroup().add(2).add(label_6)))
						.add(5)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.LEADING)
								.add(gl_middlePanel.createSequentialGroup().add(2).add(lblRecordId))
								.add(recordIDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.add(gl_middlePanel.createSequentialGroup().add(2).add(label_7))
								.add(gl_middlePanel.createSequentialGroup().add(2).add(label_8))
								.add(gl_middlePanel.createSequentialGroup().add(2).add(label_9)))
						.add(5)
						.add(gl_middlePanel.createParallelGroup(GroupLayout.LEADING)
								.add(gl_middlePanel.createSequentialGroup().add(4).add(lblMember))
								.add(memberText, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.add(btnMemberLookup).add(gl_middlePanel.createSequentialGroup().add(4).add(label_10))
								.add(gl_middlePanel.createSequentialGroup().add(4).add(label_11)))
						.add(5)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.LEADING)
								.add(gl_middlePanel.createSequentialGroup().add(2).add(lblAmount))
								.add(amountText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.add(gl_middlePanel.createSequentialGroup().add(2).add(label_12))
								.add(gl_middlePanel.createSequentialGroup().add(2).add(label_13)))
						.add(5)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.LEADING)
								.add(gl_middlePanel.createSequentialGroup().add(2).add(lblDescription))
								.add(descriptionText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.add(gl_middlePanel.createSequentialGroup().add(2).add(label_14))
								.add(gl_middlePanel.createSequentialGroup().add(2).add(label_15)))
						.add(5)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.LEADING)
								.add(gl_middlePanel.createSequentialGroup().add(2).add(lblCheckNumber))
								.add(checkNumberText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.add(gl_middlePanel.createSequentialGroup().add(2).add(label_16))
								.add(gl_middlePanel.createSequentialGroup().add(2).add(label_17)))
						.add(5)
						.add(gl_middlePanel
								.createParallelGroup(GroupLayout.LEADING)
								.add(gl_middlePanel.createSequentialGroup().add(2).add(lblSignedBy))
								.add(signedByText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.add(gl_middlePanel.createSequentialGroup().add(2).add(label_18))
								.add(gl_middlePanel.createSequentialGroup().add(2).add(label_19)))
						.add(5)
						.add(gl_middlePanel.createParallelGroup(GroupLayout.LEADING).add(filler).add(label_20)
								.add(label_21).add(label_22))));
		middlePanel.setLayout(gl_middlePanel);

		btnStoreSale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean enabled = btnStoreSale.getSelection();
				lblStore.setVisible(enabled);
				locationCombo.setVisible(enabled);
				locationCombo.setEnabled(enabled);
				locationCombo.setText("");
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				System.err.println(">>>>> default selection on " + e.getSource());
			}

		});
		btnPayment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean enabled = btnPayment.getSelection();

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