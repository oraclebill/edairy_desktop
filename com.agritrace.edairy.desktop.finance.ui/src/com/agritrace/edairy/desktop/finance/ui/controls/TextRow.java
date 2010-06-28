package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.finance.ui.FormConstants;

public class TextRow extends LabeledRow<Text> {
	
	public TextRow(Composite parent, String labelText) {
		super(parent, SWT.NONE, labelText);		
	}

	@Override
	protected Text addControl() {
		Text text = new Text(this, SWT.BORDER);
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_text.widthHint = FormConstants.TEXT_FIELD_WIDTH;
		text.setLayoutData(gd_text);
		return text;
	}


	public String getText() {
		return getControl().getText();
	}

	public String getText(int start, int end) {
		return getControl().getText(start, end);
	}

	public int getTextLimit() {
		return getControl().getTextLimit();
	}

	public void insert(String string) {
		getControl().insert(string);
	}

	public void setText(String string) {
		getControl().setText(string);
	}

	public void setTextLimit(int limit) {
		getControl().setTextLimit(limit);
	}
}