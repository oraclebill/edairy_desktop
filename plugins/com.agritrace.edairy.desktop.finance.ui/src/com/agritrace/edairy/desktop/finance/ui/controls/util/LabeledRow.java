package com.agritrace.edairy.desktop.finance.ui.controls.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import com.agritrace.edairy.desktop.finance.ui.FormConstants;

public abstract class LabeledRow<T extends Control> extends Composite {

	private final T control;
	private Label label;

	public LabeledRow(Composite parent, int style, String labelText) {
		super(parent, style);
		final GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		setLayout(layout);
		label = addLabel(labelText);
		control = addControl();
	}

	public T getControl() {
		return control;
	}

	public Label getLabel() {
		return label;
	}

	protected abstract T addControl();

	protected Label addLabel(String labelText) {
		label = new Label(this, SWT.NONE);

		final GridData gd_lbl = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lbl.widthHint = FormConstants.LABEL_WIDTH;
		label.setText(labelText);
		label.setLayoutData(gd_lbl);

		return label;
	}

}
