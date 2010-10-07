package com.agritrace.edairy.desktop.finance.ui.dialogs;


import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.MemberPayment;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.FormUtil;
import com.agritrace.edairy.desktop.finance.ui.MilkPriceJournalConstants;
import com.ibm.icu.util.Calendar;

public class MilkPriceEditDialog extends RecordDialog<MemberPayment> {

	public static final String[] MONTHS = new String[] { "January",
			"February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December", };

	public MilkPriceEditDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void buildWorkArea(Composite comp) {
		comp.setLayout(new GridLayout(1, false));
		{
			Composite row = UIControlsFactory.createComposite(comp);
			row.setLayout(new GridLayout(2, false));
			row.setLayoutData(GridDataFactory.defaultsFor(row).grab(true, false).create());
			
			Label lblMonth = UIControlsFactory.createLabel(row, "Month");
			GridDataFactory.defaultsFor(lblMonth).hint(FormUtil.WIDTH_UNIT * 2, SWT.DEFAULT).applyTo(lblMonth);

			CCombo control = UIControlsFactory.createCCombo(row, MilkPriceJournalConstants.ID_COMBO_RATEMONTH);			
			GridDataFactory.defaultsFor(control).grab(true,true).align(SWT.FILL, SWT.FILL).applyTo(control);
			control.setItems(MONTHS);
		}
		{
			Composite row = UIControlsFactory.createComposite(comp);
			row.setLayout(new GridLayout(2, false));
			row.setLayoutData(GridDataFactory.defaultsFor(row).grab(true, false).create());
			
			Label lbl = UIControlsFactory.createLabel(row, "Year");
			GridDataFactory.defaultsFor(lbl).hint(FormUtil.WIDTH_UNIT * 2, SWT.DEFAULT).applyTo(lbl);

			CCombo control = UIControlsFactory.createCCombo(row, MilkPriceJournalConstants.ID_COMBO_RATEYEAR);			
			GridDataFactory.defaultsFor(control).grab(true,true).align(SWT.FILL, SWT.FILL).applyTo(control);
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			for (int i = (currentYear-2); i< currentYear+2; i++) {
				control.add(String.valueOf(i));
			}
		}
		UIControlsFactory.createLabel(comp, ""); // filler
		{
			Composite row = UIControlsFactory.createComposite(comp);
			row.setLayout(new GridLayout(2, false));
			row.setLayoutData(GridDataFactory.defaultsFor(row).grab(true, false).create());

			Label label = UIControlsFactory.createLabel(row, "Amount");
			GridDataFactory.defaultsFor(label).hint(FormUtil.WIDTH_UNIT * 2, SWT.DEFAULT).applyTo(label);

			Control control = UIControlsFactory.createTextDecimal(row, MilkPriceJournalConstants.ID_TEXT_PRICE1);			
			GridDataFactory.defaultsFor(control).hint(FormUtil.WIDTH_UNIT, SWT.DEFAULT).applyTo(control);
		}
		{
			Composite row = UIControlsFactory.createComposite(comp);
			row.setLayout(new GridLayout(2, false));
			row.setLayoutData(GridDataFactory.defaultsFor(row).grab(true, false).create());

			Label label = UIControlsFactory.createLabel(row, "Re-enter Amount");
			GridDataFactory.defaultsFor(label).hint(FormUtil.WIDTH_UNIT * 2, SWT.DEFAULT).applyTo(label);

			Control control = UIControlsFactory.createTextDecimal(row, MilkPriceJournalConstants.ID_TEXT_PRICE2);			
			GridDataFactory.defaultsFor(control).hint(FormUtil.WIDTH_UNIT , SWT.DEFAULT).applyTo(control);
		}
	}

	
	@Override
	protected AbstractWindowController createController() {
		return new MilkPriceEditController(); 
	}

}
