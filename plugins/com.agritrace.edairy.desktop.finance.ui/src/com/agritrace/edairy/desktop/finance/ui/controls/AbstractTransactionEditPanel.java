package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.ChoiceComposite;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.swtdesigner.ResourceManager;

public abstract class AbstractTransactionEditPanel extends Composite {
	private final Group middlePanel;

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
		UIControlsFactory.createLabel(middlePanel, label);
		final ChoiceComposite transactionTypeBox = UIControlsFactory.createChoiceComposite(middlePanel, SWT.NONE,
				false, FinanceBindingConstants.ID_TRANSACTION_CHOICE);
		GridLayoutFactory.fillDefaults().numColumns(3).applyTo(transactionTypeBox);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(transactionTypeBox);
	}

	protected final void addDateField(String label) {
		UIControlsFactory.createLabel(middlePanel, label);
		final DateTime transactionDate = UIControlsFactory.createDate(middlePanel, SWT.MEDIUM | SWT.BORDER,
				FinanceBindingConstants.ID_TRANSACTION_DATE);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(transactionDate);
	}

	protected final void addLookupField(String label) {
		addLookupField(label, null);
	}
	
	protected final void addLookupField(String labelText, String labelId) {
		final Label label = UIControlsFactory.createLabel(middlePanel, labelText);
		if (null != labelId) 
			SWTBindingPropertyLocator.getInstance().setBindingProperty(label, labelId);
		
		final Text memberText = UIControlsFactory.createText(middlePanel, SWT.NONE,
				FinanceBindingConstants.ID_LOOKUP_RESULT_TXT);
		memberText.setTextLimit(20);
		memberText.setText("V-4599887");
		GridDataFactory.fillDefaults().grab(true, true).span(1, 1).applyTo(memberText);

		final Button memberLookupButton = new Button(middlePanel, SWT.FLAT);
		memberLookupButton.setImage(ResourceManager.getPluginImage("com.agritrace.edairy.desktop.icons",
				"icons/find.png"));
		SWTBindingPropertyLocator.getInstance().setBindingProperty(memberLookupButton,
				FinanceBindingConstants.ID_LOOKUP_BTN);
	}

	protected final void addStoreCombo(String label) {
		UIControlsFactory.createLabel(middlePanel, label, FinanceBindingConstants.ID_DAIRY_LOCATION_COMBO_LBL);
		final Composite locationComposite = UIControlsFactory.createComposite(middlePanel);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(true).applyTo(locationComposite);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(locationComposite);

		final CCombo locationCombo = UIControlsFactory.createCCombo(locationComposite,
				FinanceBindingConstants.ID_DAIRY_LOCATION_COMBO);
		locationCombo.select(0);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(locationCombo);

		final Text locationText = UIControlsFactory.createText(locationComposite, SWT.SINGLE,
				FinanceBindingConstants.ID_DAIRY_LOCATION_TEXT);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(locationText);
	}

	protected final void addAmountField() {
		addAmountField("Amount", FinanceBindingConstants.ID_TRANSACTION_AMOUNT_TEXT);
	}

	protected final void addAmountField(String label, String bindId) {
		addAmountField(label, bindId, null);
	}

	protected final void addAmountField(String label, String bindId, String labelBindId) {
		UIControlsFactory.createLabel(middlePanel, label);
		if (null != labelBindId) SWTBindingPropertyLocator.getInstance().setBindingProperty(label, labelBindId);

		final Text amountText = UIControlsFactory.createTextDecimal(middlePanel, bindId);
		amountText.setTextLimit(20);
		amountText.setText("90");
		GridDataFactory.fillDefaults().grab(false, true).span(1, 1).hint(111, SWT.DEFAULT).applyTo(amountText);
		UIControlsFactory.createLabel(middlePanel, "");
	}

	protected final void addDescriptionField(String label) {
		UIControlsFactory.createLabel(middlePanel, label);
		final Text descriptionText = UIControlsFactory.createTextMulti(middlePanel, false, false,
				FinanceBindingConstants.ID_TRANSACTION_DESCRIPTION_TEXT);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).hint(SWT.DEFAULT, 74).applyTo(descriptionText);
	}

	protected final void addSignedField(String label) {
		UIControlsFactory.createLabel(middlePanel, label, FinanceBindingConstants.ID_SIGNED_BY_TEXT_LBL);
		final Text signedByText = UIControlsFactory.createText(middlePanel, SWT.NONE,
				FinanceBindingConstants.ID_SIGNED_BY_TEXT);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(signedByText);
	}

	protected void addTextField(final String label, String bindingId) {
		addTextField(label, bindingId, 20);
	}

	protected void addTextField(final String label, String bindingId, int limit) {
		addTextField(label, bindingId, limit, null);
	}

	protected void addTextField(final String label, String bindingId, int limit, String sampleValue) {
		UIControlsFactory.createLabel(middlePanel, label);
		final Text textField = UIControlsFactory.createText(middlePanel, SWT.NONE, bindingId);

		if (sampleValue != null) {
			textField.setText(sampleValue);
		}

		if (limit > 0) {
			textField.setTextLimit(limit);
			limit = limit * 5;
		} else {
			limit = SWT.DEFAULT;
		}

		GridDataFactory.fillDefaults().grab(true, false).span(2, 1).hint(limit, SWT.DEFAULT).applyTo(textField);
	}
	
	protected void addComboField(String label, String comboId, String labelId) {
		Composite parent = middlePanel;
		UIControlsFactory.createLabel(parent, label);
		if (null != labelId) SWTBindingPropertyLocator.getInstance().setBindingProperty(label, labelId);

		final CCombo combo = UIControlsFactory.createCCombo(parent, comboId);
		combo.select(0);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(combo);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(
				UIControlsFactory.createLabel(parent, "")); // FILLER
	}

	protected void addBooleanField(String labelText, String buttonId, String labelId) {
		Composite parent = middlePanel;
		Label label = UIControlsFactory.createLabel(parent, labelText);
		if (null != labelId) SWTBindingPropertyLocator.getInstance().setBindingProperty(label, labelId);

		GridDataFactory.fillDefaults().applyTo(
				UIControlsFactory.createButtonCheck(parent, "", buttonId));
		GridDataFactory.fillDefaults().grab(true, false).applyTo(
				UIControlsFactory.createLabel(parent, "")); // FILLER

	}
	
}