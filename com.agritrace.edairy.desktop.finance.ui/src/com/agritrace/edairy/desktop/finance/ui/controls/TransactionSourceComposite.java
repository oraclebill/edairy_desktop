package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.riena.ui.swt.ChoiceComposite;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;

public class TransactionSourceComposite extends Composite {
	private static final String DEFAULT_LABEL_TEXT = "Transaction Source";
	
	private final boolean isMultipleChoice;
	private final Label label;

	private final ChoiceComposite typeCodeChoice;

	/**
	 * @wbp.parser.constructor
	 */
	public TransactionSourceComposite(Composite parent) {
		this(parent, false, DEFAULT_LABEL_TEXT);
	}

	public TransactionSourceComposite(Composite parent, boolean multipleChoice) {
		this(parent, multipleChoice, DEFAULT_LABEL_TEXT);
	}

	public TransactionSourceComposite(Composite parent, boolean multipleChoice, String labelString) {
		super(parent, SWT.NULL);
		isMultipleChoice = multipleChoice;

		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		final FormLayout rowLayout = new FormLayout();
		rowLayout.marginWidth = rowLayout.marginHeight = 10;
		setLayout(rowLayout);

		label = UIControlsFactory.createLabel(this, labelString);
		final FormData labelLayoutData = new FormData();
		labelLayoutData.width =  140 ;
		labelLayoutData.top = new FormAttachment(0, 0);
		labelLayoutData.left = new FormAttachment(0, 0);
		label.setLayoutData(labelLayoutData);

		typeCodeChoice = UIControlsFactory.createChoiceComposite(this, SWT.BORDER, isMultipleChoice,
				FinanceBindingConstants.FILTER_CHOICE_TX_SOURCE);

		final FormData fieldLayoutData = new FormData();
		fieldLayoutData.top = new FormAttachment(0, 0);
		fieldLayoutData.left = new FormAttachment(label, 6, SWT.RIGHT);
		fieldLayoutData.right = new FormAttachment(100, -8);
		typeCodeChoice.setLayoutData(fieldLayoutData);
	}

	public TransactionSourceComposite(Composite parent, String labelString) {
		this(parent, false, labelString);
	}

	public String getLabelText() {
		return label.getText();
	}

	public void setLabelText(String string) {
		label.setText(string);
	}
	
}