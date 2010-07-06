package com.agritrace.edairy.desktop.finance.ui.controllers;


import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.MilkPrice;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.finance.ui.controls.MilkPriceLogConstants;

public class MilkPriceEditDialog extends RecordDialog<MilkPrice, MilkPriceEditController> {

	public MilkPriceEditDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void buildWorkArea(Composite comp) {
		comp.setLayout(new GridLayout());
		{
			Composite row = UIControlsFactory.createComposite(comp);
			UIControlsFactory.createLabel(row, "Date");
			UIControlsFactory.createDate(row, SWT.BORDER, MilkPriceLogConstants.ID_DATE_PRICEDATE);			
		}
		UIControlsFactory.createLabel(comp, ""); // filler
		{
			Composite row = UIControlsFactory.createComposite(comp);
			UIControlsFactory.createLabel(row, "Amount");
			UIControlsFactory.createTextDecimal(row, MilkPriceLogConstants.ID_TEXT_PRICE1);			
		}
		{
			Composite row = UIControlsFactory.createComposite(comp);
			UIControlsFactory.createLabel(row, "Re-enter Amount");
			UIControlsFactory.createTextDecimal(row, MilkPriceLogConstants.ID_TEXT_PRICE2);			
		}
	}

	
	@Override
	protected AbstractWindowController createController() {
		return new MilkPriceEditController();
	}

}
