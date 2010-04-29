package com.agritrace.edairy.riena.ui.views;


import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.agritrace.edairy.riena.ui.views.data.MemberFactory;
import com.agritrace.edairy.riena.ui.views.data.MilkRecord;

public class AddMilkRecordDialog extends TitleAreaDialog {


	/**
	 * MyTitleAreaDialog constructor
	 * 
	 * @param shell the parent shell
	 */
	public AddMilkRecordDialog(Shell shell) {
		super(shell);

	}

	/**
	 * Closes the dialog box Override so we can dispose the image we created
	 */
	public boolean close() {

		return super.close();
	}

	/**
	 * Creates the dialog's contents
	 * 
	 * @param parent the parent composite
	 * @return Control
	 */
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		setTitle("Add Milk Collection Records");
		setMessage("Please input milk collection records");
		return contents;
	}
	
	 protected void configureShell(Shell newShell) {
	        newShell.setSize(650, 450);
	        super.configureShell(newShell);
	    }


	

	/**
	 * Creates the gray area
	 * 
	 * @param parent the parent composite
	 * @return Control
	 */
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		Composite dialogArea = new Composite(composite,SWT.NULL);
		dialogArea.setLayout(new GridLayout(2,false));
		dialogArea.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));

		Composite panel = new Composite(dialogArea, SWT.NULL);
		panel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,4));
		TableViewer tableView = new TableViewer(panel,SWT.FULL_SELECTION | SWT.BORDER|SWT.MULTI|SWT.H_SCROLL|SWT.V_SCROLL);
		Table table=tableView.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);



		// Create 6 columns and show
		
		TableColumn member = new TableColumn(table, SWT.LEFT);
		member.setText("Member");
		
		TableColumn farm = new TableColumn(table, SWT.LEFT);
		farm.setText("Farm");
		
		TableColumn can = new TableColumn(table, SWT.LEFT);
		can.setText("Can");
		
		TableColumn bin = new TableColumn(table, SWT.LEFT);
		bin.setText("Bin");
		
		TableColumn amount = new TableColumn(table, SWT.LEFT);
		amount.setText("Amount");
		
		TableColumn testResult = new TableColumn(table, SWT.LEFT);
		testResult.setText("Test Result");
		


		TableColumnLayout layout = new TableColumnLayout();
		
		layout.setColumnData(member, new ColumnWeightData(10));
		layout.setColumnData(farm, new ColumnWeightData(10));
		layout.setColumnData(can, new ColumnWeightData(10));
		layout.setColumnData(bin, new ColumnWeightData(10));
		layout.setColumnData(amount, new ColumnWeightData(10));
		layout.setColumnData(testResult, new ColumnWeightData(10));

		

		tableView.setContentProvider(new ArrayContentProvider());
		tableView.setLabelProvider(new MilkRecordLabelProvider());
		tableView.setInput(MemberFactory.createMemberList());

		panel.setLayout(layout);
		
		Button removeButton = new Button(dialogArea,SWT.PUSH);
		removeButton.setText("Remove");
		//removeButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
		return composite;
	}

	/**
	 * Creates the buttons for the button bar
	 * 
	 * @param parent the parent composite
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, true);

	}

	public class MilkRecordLabelProvider implements ITableLabelProvider {

		@Override
		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if(element instanceof MilkRecord){
				MilkRecord record = (MilkRecord)element;
				switch (columnIndex){
				case 0:
					return record.getMemberName();
				case 1:
					return record.getFarmName();
				case 2:
					return record.getCanNumber();
				case 3:
					return record.getBinNumber();
				case 4:
					return record.getAmount()+"";
				case 5:
					return record.getResult().toString();
					
				}
			}
			return null;
		}

	}

}



