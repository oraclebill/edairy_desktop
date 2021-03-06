package com.agritrace.edairy.desktop.finance.ui.controls.util;

import org.eclipse.riena.ui.swt.DatePickerComposite;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public class DatePickerRow extends LabeledRow<DatePickerComposite> {

	public DatePickerRow(Composite parent, String labelText) {
		super(parent, SWT.NONE, labelText);
	}

	@Override
	protected DatePickerComposite addControl() {
		final DatePickerComposite combo = UIControlsFactory.createDatePickerComposite(this); // new
																								// DateTime(this,
																								// SWT.BORDER);
		final GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 150;
		combo.setLayoutData(gd_combo);
		return combo;
	}

}
