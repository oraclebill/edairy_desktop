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

public class AdjustmentTransactionEditPanel extends Composite {

	private final Text reasonText;
	private final Text signedOffByText;

	public AdjustmentTransactionEditPanel(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout());
		final Composite middlePanel = UIControlsFactory.createGroup(this, "Account Adjustment");

		final Label dateLabel = UIControlsFactory.createLabel(middlePanel, "Date");

		final DateTime transactionDate = UIControlsFactory.createDate(middlePanel, SWT.MEDIUM,
				FinanceBindingConstants.ID_TRANSACTION_DATE);

		final Label lblStore = UIControlsFactory.createLabel(middlePanel, "Adjustment Type");

		final CCombo typeCombo = UIControlsFactory.createCCombo(middlePanel,
				FinanceBindingConstants.ID_COMBO_ADJUSTMENT_TYPE);
		typeCombo.setItems(new String[] { "Sample Route" });
		typeCombo.select(0);

		final Label lblRefNumber = UIControlsFactory.createLabel(middlePanel, "Member");

		final Text refNumberText = UIControlsFactory.createText(middlePanel, SWT.NONE,
				FinanceBindingConstants.ID_MEMBER_NAME_TEXT);
		refNumberText.setTextLimit(20);
		refNumberText.setText("V-4599887");
		final Label lblAmount = UIControlsFactory.createLabel(middlePanel, "Amount");

		final Text amountText = UIControlsFactory.createTextDecimal(middlePanel,
				FinanceBindingConstants.ID_TRANSACTION_AMOUNT_TEXT);
		amountText.setTextLimit(20);
		amountText.setText("90");

		final Label lblDescription = UIControlsFactory.createLabel(middlePanel, "Reason");

		reasonText = UIControlsFactory.createTextMulti(middlePanel, false, false,
				FinanceBindingConstants.ID_TRANSACTION_DESCRIPTION_TEXT);

		final Label lblSignedBy = UIControlsFactory.createLabel(middlePanel, "Signed Off By");

		signedOffByText = UIControlsFactory.createText(middlePanel, SWT.NONE, FinanceBindingConstants.ID_SIGNED_BY_TEXT);

		final Button memberLookupButton = new Button(middlePanel, SWT.FLAT);
		memberLookupButton.setImage(ResourceManager.getPluginImage("com.agritrace.edairy.desktop.icons",
				"icons/find.png"));
		SWTBindingPropertyLocator.getInstance().setBindingProperty(memberLookupButton,
				FinanceBindingConstants.ID_MEMBER_LOOKUP_BTN);
		final GroupLayout gl_middlePanel = new GroupLayout(middlePanel);
		gl_middlePanel.setHorizontalGroup(
			gl_middlePanel.createParallelGroup(GroupLayout.LEADING)
				.add(gl_middlePanel.createSequentialGroup()
					.addContainerGap()
					.add(gl_middlePanel.createParallelGroup(GroupLayout.LEADING)
						.add(gl_middlePanel.createSequentialGroup()
							.add(gl_middlePanel.createParallelGroup(GroupLayout.LEADING)
								.add(lblAmount)
								.add(lblDescription)
								.add(lblSignedBy))
							.add(33)
							.add(gl_middlePanel.createParallelGroup(GroupLayout.LEADING)
								.add(reasonText, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
								.add(typeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.add(gl_middlePanel.createSequentialGroup()
									.add(refNumberText, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.RELATED)
									.add(memberLookupButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
								.add(transactionDate, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.add(amountText, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.add(signedOffByText, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))
						.add(dateLabel)
						.add(lblStore)
						.add(lblRefNumber))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_middlePanel.setVerticalGroup(
			gl_middlePanel.createParallelGroup(GroupLayout.LEADING)
				.add(gl_middlePanel.createSequentialGroup()
					.addContainerGap()
					.add(gl_middlePanel.createParallelGroup(GroupLayout.BASELINE)
						.add(transactionDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.add(dateLabel))
					.addPreferredGap(LayoutStyle.RELATED)
					.add(gl_middlePanel.createParallelGroup(GroupLayout.BASELINE)
						.add(refNumberText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.add(lblRefNumber)
						.add(memberLookupButton, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.RELATED)
					.add(gl_middlePanel.createParallelGroup(GroupLayout.BASELINE)
						.add(typeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.add(lblStore))
					.addPreferredGap(LayoutStyle.RELATED)
					.add(gl_middlePanel.createParallelGroup(GroupLayout.BASELINE)
						.add(amountText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.add(lblAmount))
					.addPreferredGap(LayoutStyle.RELATED)
					.add(gl_middlePanel.createParallelGroup(GroupLayout.LEADING)
						.add(gl_middlePanel.createSequentialGroup()
							.add(reasonText, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.RELATED)
							.add(gl_middlePanel.createParallelGroup(GroupLayout.BASELINE)
								.add(signedOffByText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.add(lblSignedBy)))
						.add(lblDescription))
					.addContainerGap(191, Short.MAX_VALUE))
		);
		gl_middlePanel.linkSize(new Control[] {typeCombo, refNumberText, amountText, signedOffByText, memberLookupButton}, GroupLayout.VERTICAL);
		middlePanel.setLayout(gl_middlePanel);
	}
}