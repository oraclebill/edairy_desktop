package com.agritrace.edairy.ui.views;


import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.ui.views.data.MilkCollectionRecord;

public class ModifyMilkRecordDialog extends TitleAreaDialog implements ModifyListener,SelectionListener{
	
	private MilkCollectionRecord record;
	
	private Text lineText;

	private Text memberText;
	
	private Text binText; 
	
	private Text quantityText;
	
	private Button nprMissing;
	
	private Button rejected;

	/**
	 * AddMilkRecordDialog constructor
	 * 
	 * @param shell the parent shell
	 */
	public ModifyMilkRecordDialog(Shell shell) {
		super(shell);

	}

	/**
	 * Closes the dialog box Override so we can dispose the image we created
	 */
	@Override
	public boolean close() {

		return super.close();
	}

	/**
	 * Creates the dialog's contents
	 * 
	 * @param parent the parent composite
	 * @return Control
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		setTitle("Add Milk Collection Records");
		setMessage("Please input milk collection records");
		return contents;
	}
	
	 @Override
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
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		Composite dialogArea = new Composite(composite,SWT.NULL);
		dialogArea.setLayout(new GridLayout(2,false));
		dialogArea.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));

//		Composite panel = new Composite(dialogArea, SWT.NULL);
//		panel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,4));
		
		Label lineLabel = new Label(dialogArea, SWT.NULL);
		lineLabel.setText("Line :");
		
		lineText = new Text(dialogArea,SWT.READ_ONLY|SWT.BORDER|SWT.SINGLE);
		lineText.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		
		Label memberLabel = new Label(dialogArea, SWT.NULL);
		memberLabel.setText("Member :");
		
		memberText = new Text(dialogArea,SWT.READ_ONLY|SWT.BORDER|SWT.SINGLE);
		memberText.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		

		Label binLabel = new Label(dialogArea, SWT.NULL);
		binLabel.setText("Bin :");
		
		binText = new Text(dialogArea,SWT.BORDER|SWT.SINGLE);
		binText.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		
		Label quantityLabel = new Label(dialogArea, SWT.NULL);
		quantityLabel.setText("Quantity *:");
		
		quantityText = new Text(dialogArea,SWT.BORDER|SWT.SINGLE);
		quantityText.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		
		nprMissing = new Button(dialogArea,SWT.CHECK);
		nprMissing.setText("NPR Missing");
		nprMissing.setSelection(false);
		
		rejected = new Button(dialogArea,SWT.CHECK);
		rejected.setText("Rejected");
		rejected.setSelection(true);
		initValue();
		nprMissing.addSelectionListener(this);
		rejected.addSelectionListener(this);

		quantityText.addModifyListener(this);

		return composite;
	}

	/**
	 * Creates the buttons for the button bar
	 * 
	 * @param parent the parent composite
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, true);
		getButton(IDialogConstants.OK_ID).setEnabled(false);

	}

	@Override
	public void modifyText(ModifyEvent e) {
		if(record == null){
			return;
		}
		if(e.getSource() == quantityText){
			String text = quantityText.getText();
			try{
				Double value = new Double(text);
				record.setQuantity(value.doubleValue());
				setErrorMessage(null);
			}catch(NumberFormatException ex){
				setErrorMessage("Invalid input, only numberic number is allowed for 'Quantity' field");
				getButton(IDialogConstants.OK_ID).setEnabled(false);
			}
		}
		getButton(IDialogConstants.OK_ID).setEnabled(validatePage());
		
	}
	
	private void initValue(){
		if(record != null){
			lineText.setText(record.getLine());
			memberText.setText(record.getMemberId());
			binText.setText(record.getCanId());
			quantityText.setText(new Double(record.getQuantity()).toString());
			nprMissing.setSelection(record.isnPRMissing());
			rejected.setSelection(record.isRejected());
		}
		
	}
	
	private boolean validatePage(){
		return true;
	}

	public MilkCollectionRecord getRecord() {
		return record;
	}

	public void setRecord(MilkCollectionRecord record) {
		this.record = record;
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		widgetSelected(e);
		
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if(record != null){
			record.setnPRMissing(nprMissing.getSelection());
			record.setRejected(rejected.getSelection());

		}
		
	}

}



