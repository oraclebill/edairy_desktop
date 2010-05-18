package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.DatePickerComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;


public class TransactionBatchEntrySubModuleView extends SubModuleView implements
		FormConstants {
	public static final String ID = "transaction.batch-entry.view";

	private Composite sourceSelectorPanel;
	private DatePickerComposite datePicker;
	private Combo storeText;
	private Text refNoText;
	private Text recordIdText;
	private Text memberIdText;
	private Text amtText;
	private Text descText;
	private Text chkNoText;
	private Text signedByText;
	private Table detailTable;
	private Label lblMemberName;
	private Button btnCancelAll;
	private Button btnSaveAllRecords;
	private Group grpTransactions;

	public TransactionBatchEntrySubModuleView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void basicCreatePartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Composite detailPanel = createDetailEditPanel(parent);
		Composite tablePanel = createTablePanel(parent);
		Composite dialogButtonPanel = createDialogButtonPanel(parent);

	}

	protected Composite createDetailEditPanel(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,
				1, 1));
		composite.setLayout(new GridLayout(2, false));

		SourceButtonRow buttonPanel = new SourceButtonRow(composite, "Sources");
		sourceSelectorPanel = buttonPanel.getSourceSelectorPanel();
		addUIControl(sourceSelectorPanel, "sourceSelectorPanel");
		new Label(composite, SWT.NONE);

		DatePickerRow date = new DatePickerRow(composite, "Date");
		datePicker = date.getControl();
		addUIControl(datePicker, DATE_PICKER_RIDGET);
		new Label(composite, SWT.NONE);

		ComboRow store = new ComboRow(composite, "Store");
		storeText = store.getControl();
		addUIControl(storeText, STORE_COMBO_RIDGET);
		new Label(composite, SWT.NONE);

		TextRow refNo = new TextRow(composite, "Reference No.");
		refNoText = refNo.getControl();
		addUIControl(refNoText, REF_NO_TEXT_RIDGET);
		new Label(composite, SWT.NONE);

		TextRow recordId = new TextRow(composite, "Record Id");
		recordIdText = recordId.getControl();
		addUIControl(recordIdText, "recordIdText");
		new Label(composite, SWT.NONE);

		TextRow memberId = new TextRow(composite, "Member Id");
		memberIdText = memberId.getControl();
		addUIControl(memberIdText, MEMBER_ID_TEXT_RIDGET);
		
		lblMemberName = new Label(composite, SWT.NONE);
		addUIControl(lblMemberName, LBL_MEMBER_NAME_RIDGET);

		TextRow amt = new TextRow(composite, "Amount");
		amtText = amt.getControl();
		addUIControl(amtText, AMT_TEXT_RIDGET);
		new Label(composite, SWT.NONE);

		TextRow desc = new TextRow(composite, "Description");
		descText = desc.getControl();
		addUIControl(descText, "descText");
		new Label(composite, SWT.NONE);

		TextRow chkNo = new TextRow(composite, "Check No.");
		chkNoText = chkNo.getControl();
		addUIControl(chkNoText, CHK_NO_TEXT_RIDGET);
		new Label(composite, SWT.NONE);

		TextRow signedBy = new TextRow(composite, "Signed By");
		signedByText = signedBy.getControl();
		addUIControl(signedByText, SIGNED_BY_TEXT_RIDGET);
		new Label(composite, SWT.NONE);

		Composite editButtonPanel = new Composite(composite, SWT.NONE);
		editButtonPanel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 2, 1));
		editButtonPanel.setLayout(new GridLayout(3, false));

		Button btnClearCurrent = new Button(editButtonPanel, SWT.BORDER);
		btnClearCurrent.setText("Clear");
		addUIControl(btnClearCurrent, BTN_CLEAR_CURRENT);

		Label lblFiller = new Label(editButtonPanel, SWT.NONE);
		lblFiller.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		Button btnAddTransaction = new Button(editButtonPanel, SWT.RIGHT);
		btnAddTransaction.setText("Add Transaction");
		addUIControl(btnAddTransaction, BTN_ADD_TRANSACTION);
		new Label(composite, SWT.NONE);

		return composite;
	}

	protected Composite createTablePanel(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		composite.setLayout(new GridLayout(1, true));
		
		grpTransactions = new Group(composite, SWT.BORDER | SWT.SHADOW_ETCHED_IN);
		grpTransactions.setText("Transaction Details");
		grpTransactions.setLayout(new GridLayout(1, false));
		grpTransactions.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		addUIControl(grpTransactions, GRP_TRANSACTIONS_TBLLABEL);
		
		TableViewer tableViewer = new TableViewer(grpTransactions, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
		detailTable = tableViewer.getTable();
		detailTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		detailTable.setHeaderVisible(true);
		detailTable.setLinesVisible(true);
		
		TableViewerColumn tableViewerIdColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmId = tableViewerIdColumn.getColumn();
		tblclmId.setWidth(50);
		tblclmId.setText("ID");
		
		TableViewerColumn tableViewerStoreColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnStore = tableViewerStoreColumn.getColumn();
		tblclmnStore.setWidth(100);
		tblclmnStore.setText("Store");
		
		TableViewerColumn tableViewerDateColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnDate = tableViewerDateColumn.getColumn();
		tblclmnDate.setWidth(80);
		tblclmnDate.setText("Date");
		
		TableViewerColumn tableViewerRefNoColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnReferenceNo = tableViewerRefNoColumn.getColumn();
		tblclmnReferenceNo.setWidth(80);
		tblclmnReferenceNo.setText("Reference No.");
		
		TableViewerColumn tableViewerMemberColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnMember = tableViewerMemberColumn.getColumn();
		tblclmnMember.setWidth(150);
		tblclmnMember.setText("Member");
		
		TableViewerColumn tableViewerAmountColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnAmount = tableViewerAmountColumn.getColumn();
		tblclmnAmount.setWidth(50);
		tblclmnAmount.setText("Amount");
		
		addUIControl(detailTable, DETAIL_TABLE_RIDGET);
		
		Composite tableButtonsPanel = new Composite(grpTransactions, SWT.NONE);
		tableButtonsPanel.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, true, false, 1, 1));
		tableButtonsPanel.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		Button btnDelete = new Button(tableButtonsPanel, SWT.NONE);
		btnDelete.setText("Delete");
		addUIControl(btnDelete,BTN_DELETE);
		
		Button btnView = new Button(tableButtonsPanel, SWT.NONE);
		btnView.setText("View");
		addUIControl(btnView,BTN_VIEW);

		
		return composite;
	}

	protected Composite createDialogButtonPanel(Composite parent) {
		Composite dialogButtonPanel = new Composite(parent, SWT.BORDER);
		dialogButtonPanel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		dialogButtonPanel.setLayout(new GridLayout(3, false));

		btnCancelAll = new Button(dialogButtonPanel, SWT.RIGHT);
		btnCancelAll.setAlignment(SWT.CENTER);
		btnCancelAll.setText("Cancel All");
		addUIControl(btnCancelAll,BTN_CANCEL_ALL);
		
		Label label = new Label(dialogButtonPanel, SWT.NONE);
		GridData gd_label = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_label.minimumWidth = 50;
		label.setLayoutData(gd_label);

		btnSaveAllRecords = new Button(dialogButtonPanel, SWT.NONE);
		btnSaveAllRecords.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnSaveAllRecords.setText("Save All Records");
		addUIControl(btnSaveAllRecords,BTN_SAVE_ALL_RECORDS);
		return dialogButtonPanel;
	}

	
}
