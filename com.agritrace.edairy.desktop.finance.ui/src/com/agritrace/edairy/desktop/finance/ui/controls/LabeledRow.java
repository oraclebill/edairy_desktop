package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

public abstract class LabeledRow<T extends Control> extends Composite {

	private Label label;
	private T control;

	public LabeledRow(Composite parent, int style, String labelText) {
		super(parent, style);
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		setLayout(layout);
		label = addLabel(labelText);
		control = addControl();
	}

	protected abstract T addControl();

	protected Label addLabel(String labelText) {
		label = new Label(this, SWT.NONE);

		GridData gd_lbl = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lbl.widthHint = FormConstants.LABEL_WIDTH;
		label.setText(labelText);
		label.setLayoutData(gd_lbl);

		return label;
	}

	public Label getLabel() {
		return label;
	}

	public T getControl() {
		return control;
	}
	
}
