package com.agritrace.edairy.desktop.finance.ui.controls;

import java.sql.Date;
import java.util.Arrays;
import java.util.Random;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.nebula.widgets.datechooser.DateChooserCombo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ArrayContentProvider;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;

public class TransactionBatchEntry extends ViewPart {
	
	
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Table table;

	public TransactionBatchEntry() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		Composite detailPanel = createDetailEditPanel(parent);
		Composite tablePanel = createTablePanel(parent);
		Composite dialogButtonPanel = createDialogButtonPanel(parent);
		
	}

	
	
	public static class SourceButtonRow extends Composite {

		Label lblTransactionSource;
		Composite sourceSelectorPanel;
		
		SourceButtonRow(Composite parent, int backgroundMode, String label) {
			super(parent, SWT.NONE);

			GridLayout gl_composite = new GridLayout(2, false);
			gl_composite.marginLeft = 5;
			setLayout(gl_composite);

			lblTransactionSource = new Label(this, SWT.NONE);
			GridData gd_lblTransactionSource = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
			gd_lblTransactionSource.verticalIndent = 8;
			gd_lblTransactionSource.widthHint = 150;
			lblTransactionSource.setLayoutData(gd_lblTransactionSource);
			lblTransactionSource.setText(label);
			
			sourceSelectorPanel = new Composite(this, SWT.BORDER);
			sourceSelectorPanel.setBounds(0, 0, 64, 64);
			sourceSelectorPanel.setLayout(new GridLayout(2, false));
			
			addButton("Credit Sale");
			addButton("Cash Payment");
			addButton("Vet Services");
			addButton("Share Deduction");			
		}
		
		private Button addButton(String buttonLabel) {
			Button button = new Button(sourceSelectorPanel, SWT.FLAT | SWT.RADIO);
			GridData gd = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd.widthHint = 120;
			button.setLayoutData(gd);
			button.setText(buttonLabel);	
			return button;
		}
		
	}
	
	protected Composite createDetailEditPanel(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gl_composite = new GridLayout(2, false);
		gl_composite.marginLeft = 5;
		composite.setLayout(gl_composite);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		Label lblTransactionSource = new Label(composite, SWT.NONE);
		GridData gd_lblTransactionSource = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_lblTransactionSource.verticalIndent = 8;
		gd_lblTransactionSource.widthHint = 150;
		lblTransactionSource.setLayoutData(gd_lblTransactionSource);
		lblTransactionSource.setText("Transaction Source");
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setBounds(0, 0, 64, 64);
		composite_1.setLayout(new GridLayout(2, false));
		
		Button btnStoreSale = new Button(composite_1, SWT.FLAT | SWT.RADIO);
		GridData gd_btnStoreSale = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnStoreSale.widthHint = 120;
		btnStoreSale.setLayoutData(gd_btnStoreSale);
		btnStoreSale.setText("Store Sale");
		
		Button btnPayment = new Button(composite_1, SWT.FLAT | SWT.RADIO);
		GridData gd_btnPayment = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnPayment.widthHint = 120;
		btnPayment.setLayoutData(gd_btnPayment);
		btnPayment.setBounds(0, 0, 91, 18);
		btnPayment.setText("Payment");
		
		Button btnVeterinary = new Button(composite_1, SWT.FLAT | SWT.RADIO);
		GridData gd_btnVeterinary = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnVeterinary.widthHint = 120;
		btnVeterinary.setLayoutData(gd_btnVeterinary);
		btnVeterinary.setBounds(0, 0, 91, 18);
		btnVeterinary.setText("Veterinary");
		
		Button btnShareDeduction = new Button(composite_1, SWT.FLAT | SWT.RADIO);
		GridData gd_btnShareDeduction = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnShareDeduction.widthHint = 120;
		btnShareDeduction.setLayoutData(gd_btnShareDeduction);
		btnShareDeduction.setText("Share Deduction");
		
		Label lblDate = new Label(composite, SWT.NONE);
		lblDate.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblDate.setText("Date");
		
		DateTime dateTime = new DateTime(composite, SWT.BORDER);
		
		Label lblStore = new Label(composite, SWT.NONE);
		lblStore.setText("Store");
		
		ComboViewer comboViewer = new ComboViewer(composite, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 150;
		combo.setLayoutData(gd_combo);
		
		Label lblReference = new Label(composite, SWT.NONE);
		lblReference.setText("Reference #");
		
		text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblRecordId = new Label(composite, SWT.NONE);
		lblRecordId.setText("Record ID");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblMemberId = new Label(composite, SWT.NONE);
		lblMemberId.setText("Member ID");
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblAmount = new Label(composite, SWT.NONE);
		lblAmount.setText("Amount");
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDescription = new Label(composite, SWT.NONE);
		lblDescription.setText("Description");
		
		text_4 = new Text(composite, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblCheckNumber = new Label(composite, SWT.NONE);
		lblCheckNumber.setText("Check Number");
		
		text_5 = new Text(composite, SWT.BORDER);
		text_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblSignedBy = new Label(composite, SWT.NONE);
		GridData gd_lblSignedBy = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblSignedBy.widthHint = 120;
		lblSignedBy.setLayoutData(gd_lblSignedBy);
		lblSignedBy.setText("Signed By");
		
		
		text_6 = new Text(composite, SWT.BORDER);
		text_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		return composite;
	}
	
	
	
	protected Composite createTablePanel(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		composite.setLayout(new FillLayout());
		
		TableViewer tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmId = tableViewerColumn.getColumn();
		tblclmId.setWidth(50);
		tblclmId.setText("ID");
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnStore = tableViewerColumn_4.getColumn();
		tblclmnStore.setWidth(100);
		tblclmnStore.setText("Store");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnDate = tableViewerColumn_3.getColumn();
		tblclmnDate.setWidth(80);
		tblclmnDate.setText("Date");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnReferenceNo = tableViewerColumn_2.getColumn();
		tblclmnReferenceNo.setWidth(80);
		tblclmnReferenceNo.setText("Reference No.");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnMember = tableViewerColumn_1.getColumn();
		tblclmnMember.setWidth(150);
		tblclmnMember.setText("Member");
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnAmount = tableViewerColumn_5.getColumn();
		tblclmnAmount.setWidth(50);
		tblclmnAmount.setText("Amount");
		tableViewer.setContentProvider(new ArrayContentProvider() {

			private Random rand = new Random();
			
			private Account createTestAccount() {
				Account testAccount = AccountFactory.eINSTANCE.createAccount();
				testAccount.setAccountId( rand.nextLong() );
				testAccount.setEstablished( new Date( rand.nextLong() ) );
				testAccount.setType("CREDIT");			
				return testAccount;
			}
			
			private String randomSource() {
				final String[] options = { "Credit Sale", "Veterinary Services", "Cash Payment", "Share Deduction" };
				int selection = rand.nextInt() % 4;
				return options[selection];
			}
			
			private TransactionType randomTransactionType() {
				final TransactionType[] options = TransactionType.values();
				int selection = rand.nextInt() % options.length;
				return options[selection];
			}
			
			private AccountTransaction createTestAccountTransaction( int seq ) {
				AccountTransaction temp = AccountFactory.eINSTANCE.createAccountTransaction();
				temp.setAccount( createTestAccount() );
				temp.setAmount( rand.nextLong()  );
				temp.setDescription( "test account # " + seq);
				temp.setSource( randomSource() );
				temp.setTransactionId( rand.nextLong() );
				temp.setTransactionType( randomTransactionType() );
				return temp;				
			}
			

			
			@Override
			public Object[] getElements(Object inputElement) {
				AccountTransaction txArray[] = null;
				AccountTransaction temp; 
				
				for (int i =0; i< 100; i++ ) {
				}
				
				return txArray;
			}
			
		});
		
		return composite;
	}
	
	
	protected Composite createDialogButtonPanel(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		return composite;
	}
	
	private Composite createFieldRow(Composite parent, String labelText, Widget control, String controlName) {
		Composite row = new Composite(parent, SWT.None);
		
		return row;		
	}
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
