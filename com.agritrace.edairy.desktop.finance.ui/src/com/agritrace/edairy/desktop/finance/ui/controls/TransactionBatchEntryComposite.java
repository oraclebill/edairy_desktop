package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.DatePickerComposite;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.finance.ui.FormConstants;
import com.agritrace.edairy.desktop.finance.ui.controls.util.ComboRow;
import com.agritrace.edairy.desktop.finance.ui.controls.util.DatePickerRow;
import com.agritrace.edairy.desktop.finance.ui.controls.util.SourceButtonRow;
import com.agritrace.edairy.desktop.finance.ui.controls.util.TextRow;

/**
 * A master details widget with a text fields for renaming a person.
 */
public final class TransactionBatchEntryComposite extends MasterDetailsComposite {

	public TransactionBatchEntryComposite(Composite parent, int style) {
		super(parent, style, SWT.TOP);
		setMargins(5, 5);
	}

	@Override
	protected void createDetails(Composite parent) {
		Composite sourceSelectorPanel;
		DatePickerComposite datePicker;
		CCombo storeText;
		Text refNoText;
		Text recordIdText;
		Text memberIdText;
		Label lblMemberName;
		Text amtText;
		Text descText;
		Text chkNoText;
		Text signedByText;

		GridLayoutFactory.fillDefaults().numColumns(1).margins(20, 20).spacing(10, 10).equalWidth(false)
				.applyTo(parent);
		GridDataFactory.fillDefaults().grab(true, false);

		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		composite.setLayout(new GridLayout(2, false));

		final SourceButtonRow buttonPanel = new SourceButtonRow(composite, "Sources");
		sourceSelectorPanel = buttonPanel.getSourceSelectorPanel();
		addUIControl(sourceSelectorPanel, "sourceSelectorPanel");
		new Label(composite, SWT.NONE);

		final DatePickerRow date = new DatePickerRow(composite, "Date");
		datePicker = date.getControl();
		addUIControl(datePicker, FormConstants.DATE_PICKER_RIDGET);
		new Label(composite, SWT.NONE);

		final ComboRow store = new ComboRow(composite, "Store");
		storeText = store.getControl();
		addUIControl(storeText, FormConstants.STORE_COMBO_RIDGET);
		new Label(composite, SWT.NONE);

		final TextRow refNo = new TextRow(composite, "Reference No.");
		refNoText = refNo.getControl();
		addUIControl(refNoText, FormConstants.REF_NO_TEXT_RIDGET);
		new Label(composite, SWT.NONE);

		final TextRow recordId = new TextRow(composite, "Record Id");
		recordIdText = recordId.getControl();
		addUIControl(recordIdText, FormConstants.RECORD_ID_TEXT);
		new Label(composite, SWT.NONE);

		final TextRow memberId = new TextRow(composite, "Member Id");
		memberIdText = memberId.getControl();
		addUIControl(memberIdText, FormConstants.MEMBER_ID_TEXT_RIDGET);

		lblMemberName = new Label(composite, SWT.NONE);
		addUIControl(lblMemberName, FormConstants.LBL_MEMBER_NAME_RIDGET);

		final TextRow amt = new TextRow(composite, "Amount");
		amtText = amt.getControl();
		addUIControl(amtText, FormConstants.AMT_TEXT_RIDGET);
		new Label(composite, SWT.NONE);

		final TextRow desc = new TextRow(composite, "Description");
		descText = desc.getControl();
		addUIControl(descText, FormConstants.DESC_TEXT);
		new Label(composite, SWT.NONE);

		final TextRow chkNo = new TextRow(composite, "Check No.");
		chkNoText = chkNo.getControl();
		addUIControl(chkNoText, FormConstants.CHK_NO_TEXT_RIDGET);
		new Label(composite, SWT.NONE);

		final TextRow signedBy = new TextRow(composite, "Signed By");
		signedByText = signedBy.getControl();
		addUIControl(signedByText, FormConstants.SIGNED_BY_TEXT_RIDGET);
		new Label(composite, SWT.NONE);

		final Composite editButtonPanel = new Composite(composite, SWT.NONE);
		editButtonPanel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		editButtonPanel.setLayout(new GridLayout(3, false));

		final Button btnClearCurrent = new Button(editButtonPanel, SWT.BORDER);
		btnClearCurrent.setText("Clear");
		addUIControl(btnClearCurrent, FormConstants.BTN_CLEAR_CURRENT);

		final Label lblFiller = new Label(editButtonPanel, SWT.NONE);
		lblFiller.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		final Button btnAddTransaction = new Button(editButtonPanel, SWT.RIGHT);
		btnAddTransaction.setText("Add Transaction");
		addUIControl(btnAddTransaction, FormConstants.BTN_ADD_TRANSACTION);
		new Label(composite, SWT.NONE);
	}

}