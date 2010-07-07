package com.agritrace.edairy.desktop.finance.ui.controls.util;

import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public class ComboRow extends LabeledRow<CCombo> {

	private CCombo combo;

	public ComboRow(Composite parent, String labelText) {
		super(parent, SWT.READ_ONLY, labelText);
	}

	@Override
	protected CCombo addControl() {
		combo = UIControlsFactory.createCCombo(this);
		final GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 150;
		combo.setLayoutData(gd_combo);
		return combo;
	}
}
