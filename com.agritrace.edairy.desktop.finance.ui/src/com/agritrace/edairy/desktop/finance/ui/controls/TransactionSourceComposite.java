package com.agritrace.edairy.desktop.finance.ui.controls;

import java.util.HashMap;

import org.eclipse.riena.ui.swt.ChoiceComposite;
import org.eclipse.riena.ui.swt.lnf.LnFUpdater;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.finance.ui.views.MemberTransactionRegisterView;

public class TransactionSourceComposite extends Composite {

	private final static LnFUpdater LNF_UPDATER = new LnFUpdater();
	public static final Color CYAN = PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_CYAN);

	public static final String LABEL = "transaction-type-compsite.label";
	public static final String CHOICE_COMPOSITE = "CHOICE_COMPOSITE";
	public static final String CHOICE_STORE_CREDIT = "CHOICE_COMPOSITE-CHOICE_STORE_CREDIT";
	public static final String CHOICE_CLINICAL_SVC = "CHOICE_COMPOSITE-CHOICE_CLINICAL_SVC";
	public static final String CHOICE_CASH_PAYMENT = "CHOICE_COMPOSITE-CHOICE_CASH_PAYMENT";
	public static final String CHOICE_SHARE_DEDUCTION = "CHOICE_COMPOSITE-CHOICE_SHARE_DEDUCTION";

	private final Label label;
//	private final ChoiceComposite txypeCodeChoice;
	private final boolean isMultipleChoice;

	private Button btnStoreCredit;

	private Button btnClinicalServices;

	private Button btnPayments;

	private Button btnShareDeductions;

	private ChoiceComposite typeCodeChoice;

	/**
	 * @wbp.parser.constructor
	 */
	public TransactionSourceComposite(Composite parent) {
		this(parent, false, "");
	}

	public TransactionSourceComposite(Composite parent, boolean multipleChoice) {
		this(parent, multipleChoice, "");
	}

	public TransactionSourceComposite(Composite parent, String labelString) {
		this(parent, false, labelString);
	}

	public TransactionSourceComposite(Composite parent, boolean multipleChoice, String labelString) {

		super(parent, SWT.NONE);
		isMultipleChoice = multipleChoice;
		
		//setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		FormLayout rowLayout = new FormLayout();
		rowLayout.marginWidth = rowLayout.marginHeight = 10;
		setLayout(rowLayout);

		label = UIControlsFactory.createLabel(this, labelString);
		FormData labelLayoutData = new FormData();
		labelLayoutData.width = labelString.trim().length() > 0 ? 140 : 0;
		labelLayoutData.top = new FormAttachment(0, 0);
		labelLayoutData.left = new FormAttachment(0, 0);
		label.setLayoutData(labelLayoutData);

		typeCodeChoice = UIControlsFactory.createChoiceComposite(this, MemberTransactionRegisterView.LEFT,
				isMultipleChoice, "typeSetRidget");

		FormData fieldLayoutData = new FormData();
		fieldLayoutData.top = new FormAttachment(0, 5);
		fieldLayoutData.left = new FormAttachment(label, 5, SWT.RIGHT);
		fieldLayoutData.right = new FormAttachment(100, 100, 8);
		fieldLayoutData.bottom = new FormAttachment(100, 100, 5);
		typeCodeChoice.setLayoutData(fieldLayoutData);

		btnStoreCredit = UIControlsFactory.createButtonRadio(typeCodeChoice);
		btnStoreCredit.setText("Store Credits");
		btnStoreCredit.setToolTipText("Account deductions for store purchases using account credit.");


		btnClinicalServices = UIControlsFactory.createButtonRadio(typeCodeChoice);
		btnClinicalServices.setText("Veterinary Services ");
		btnClinicalServices
				.setToolTipText("Account deductions for vet and animal services purchased with account credit.");

		btnPayments = UIControlsFactory.createButtonRadio(typeCodeChoice);
		btnPayments.setText("Cash Payments");
		btnPayments.setToolTipText("Account deductions for cash payments to member from members' account.");

		btnShareDeductions = UIControlsFactory.createButtonRadio(typeCodeChoice);
		btnShareDeductions.setText("Share Deductions");
		btnShareDeductions.setToolTipText("Account deductions for recoupment of member shares.");	
	}
	
	private Button createButton(Composite parent, String text, String toolTipText) {
		final int buttonStyle = isMultipleChoice ? SWT.CHECK : SWT.RADIO;
		final Button button = new Button(parent, buttonStyle);
		
		button.setToolTipText(toolTipText);
		button.setText(text);
		
		return button;
	}

	public String getLabelText() {
		return label.getText();
	}

	public void setLabelText(String string) {
		label.setText(string);
	}
}