package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public class ComboRow extends LabeledRow<Combo> {

	private ComboViewer comboViewer;
	
	public ComboRow(Composite parent, String labelText) {
		super(parent, SWT.NONE, labelText);
	}
	
	@Override
	protected Combo addControl() {
		comboViewer = new ComboViewer(this, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 150;
		combo.setLayoutData(gd_combo);
		return combo;
	}

	public ComboViewer getViewer() {
		return comboViewer;
	}

}
