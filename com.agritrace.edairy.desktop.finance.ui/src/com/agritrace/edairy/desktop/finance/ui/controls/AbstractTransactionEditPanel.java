package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.ChoiceComposite;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.swtdesigner.ResourceManager;

public abstract class AbstractTransactionEditPanel extends Composite {
	private Group middlePanel;

	public AbstractTransactionEditPanel(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout());
		middlePanel = UIControlsFactory.createGroup(this, "", FinanceBindingConstants.ID_TRANSACTION_WRAPPER_FRAME);
		GridLayoutFactory.fillDefaults().numColumns(3).margins(6, 6).applyTo(middlePanel);
	}
	
	protected final Group getContentArea() {
		return middlePanel;
	}
	
	protected final void addChoiceField(String label) {
		UIControlsFactory.createLabel(middlePanel, "Type");
		final ChoiceComposite transactionTypeBox = UIControlsFactory.createChoiceComposite(middlePanel, SWT.NONE,
				false, FinanceBindingConstants.ID_TRANSACTION_CHOICE);
		GridLayoutFactory.fillDefaults().numColumns(3).applyTo(transactionTypeBox);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(transactionTypeBox);
	}

	protected final void addDateField() {
		UIControlsFactory.createLabel(middlePanel, "Date");
		final DateTime transactionDate = UIControlsFactory.createDate(middlePanel, SWT.MEDIUM | SWT.BORDER,
				FinanceBindingConstants.ID_TRANSACTION_DATE);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(transactionDate);
	}

	protected final void addMemberField() {
		UIControlsFactory.createLabel(middlePanel, "Member");
		final Text memberText = UIControlsFactory.createText(middlePanel, SWT.NONE,
				FinanceBindingConstants.ID_MEMBER_NAME_TEXT);
		memberText.setTextLimit(20);
		memberText.setText("V-4599887");
		GridDataFactory.fillDefaults().grab(true, true).span(1, 1).applyTo(memberText);

		final Button memberLookupButton = new Button(middlePanel, SWT.FLAT);
		memberLookupButton.setImage(ResourceManager.getPluginImage("com.agritrace.edairy.desktop.icons",
				"icons/find.png"));
		SWTBindingPropertyLocator.getInstance().setBindingProperty(memberLookupButton,
				FinanceBindingConstants.ID_MEMBER_LOOKUP_BTN);
	}

	protected final void addAmountField() {
		UIControlsFactory.createLabel(middlePanel, "Amount");
		final Text amountText = UIControlsFactory.createTextDecimal(middlePanel,
				FinanceBindingConstants.ID_TRANSACTION_AMOUNT_TEXT);
		amountText.setTextLimit(20);
		amountText.setText("90");
		GridDataFactory.fillDefaults().grab(false, true).span(2, 1).hint(111, SWT.DEFAULT).applyTo(amountText);
	}

	protected final void addDescriptionField(String label) {
		UIControlsFactory.createLabel(middlePanel, label);
		final Text descriptionText = UIControlsFactory.createTextMulti(middlePanel, false, false,
				FinanceBindingConstants.ID_TRANSACTION_DESCRIPTION_TEXT);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).hint(SWT.DEFAULT, 74).applyTo(descriptionText);		
	}

	protected final void addSignedField(String label) {
		UIControlsFactory.createLabel(middlePanel, label, FinanceBindingConstants.ID_SIGNED_BY_TEXT_LBL);
		final Text signedByText = UIControlsFactory.createText(middlePanel, SWT.NONE, FinanceBindingConstants.ID_SIGNED_BY_TEXT);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(signedByText);
	}
}