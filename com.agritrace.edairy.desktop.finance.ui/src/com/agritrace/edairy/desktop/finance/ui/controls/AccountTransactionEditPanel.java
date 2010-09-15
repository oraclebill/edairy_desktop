package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;

public class AccountTransactionEditPanel extends AbstractTransactionEditPanel {
	public AccountTransactionEditPanel(Composite parent, int style) {
		super(parent, style);
		Group middlePanel = getContentArea();
		middlePanel.setText("Transaction Entry");
		
		addChoiceField("Type");
		addDateField();

		UIControlsFactory.createLabel(middlePanel, "Store", FinanceBindingConstants.ID_DAIRY_LOCATION_COMBO_LBL);
		final CCombo locationCombo = UIControlsFactory.createCCombo(middlePanel, FinanceBindingConstants.ID_DAIRY_LOCATION_COMBO);
		locationCombo.select(0);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(locationCombo);

		addMemberField();

		UIControlsFactory.createLabel(middlePanel, "Reference No.");
		final Text refNumText = UIControlsFactory.createText(middlePanel, SWT.NONE,
				FinanceBindingConstants.ID_REF_NUMBER_TEXT);
		refNumText.setTextLimit(20);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(refNumText);

		addAmountField();
		addDescriptionField("Description");

		UIControlsFactory.createLabel(middlePanel, "Check Number", FinanceBindingConstants.ID_CHECK_NUMBER_TEXT_LBL);
		final Text checkNumberText = UIControlsFactory.createText(middlePanel, SWT.NONE,
				FinanceBindingConstants.ID_CHECK_NUMBER_TEXT);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(checkNumberText);
		
		addSignedField("Signed By");
	}
}