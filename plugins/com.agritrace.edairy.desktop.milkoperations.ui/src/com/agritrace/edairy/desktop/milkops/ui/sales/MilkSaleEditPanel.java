package com.agritrace.edairy.desktop.milkops.ui.sales;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.finance.ui.controls.AbstractTransactionEditPanel;

public class MilkSaleEditPanel extends AbstractTransactionEditPanel {


	public MilkSaleEditPanel(Composite parent, int style) {
		super(parent, style);
		final Group middlePanel = getContentArea();

		middlePanel.setText("Milk Sale Entry");

		addTextField("Reference No.", FinanceBindingConstants.ID_REF_NUMBER_TEXT);
		addDateField("Sale Date");
		
		addStoreCombo("Store/Center");

		addChoiceField("Sale Type");

		// If sale type 'credit'
		addLookupField("Customer", BindConstants.ID_LOOKUP_LABEL);
		addBooleanField("Contract Pricing?", BindConstants.ID_HAS_CONTRACT, BindConstants.ID_HAS_CONTRACT_LABEL);

		addAmountField("Milk Quantity", BindConstants.ID_QUANTITY);
		addComboField("Milk Grade", BindConstants.ID_GRADE, BindConstants.ID_GRADE_LABEL);
		addAmountField("Price/Kg", BindConstants.ID_PRICE_PER_KG, BindConstants.ID_PRICE_PER_KG_LABEL);

		addComboField("Bin", BindConstants.ID_BIN, BindConstants.ID_BIN_LABEL);
		addAmountField("Sale Amt.", BindConstants.ID_SALE_AMOUNT, null);

		addComboField("Sales Clerk", BindConstants.ID_SALES_CLERK, null);
		addDescriptionField("Notes");

// UIControlsFactory.createLabel(middlePanel, "Check Number", FinanceBindingConstants.ID_CHECK_NUMBER_TEXT_LBL);
// final Text checkNumberText = UIControlsFactory.createText(middlePanel, SWT.NONE,
// FinanceBindingConstants.ID_CHECK_NUMBER_TEXT);
// GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(checkNumberText);

// addSignedField("Signed By");

	}

}