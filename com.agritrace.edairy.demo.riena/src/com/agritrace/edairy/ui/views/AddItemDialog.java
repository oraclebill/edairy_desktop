package com.agritrace.edairy.ui.views;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.ui.views.data.Item;

public class AddItemDialog extends TitleAreaDialog implements ModifyListener{


	private Item newItem = new Item();
	
	private Text idText;
	private Text numberText;
	private Text descriptionText; 
	/**
	 * MyTitleAreaDialog constructor
	 * 
	 * @param shell the parent shell
	 */
	public AddItemDialog(Shell shell) {
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
		setTitle("Add Delivery Record");
		setMessage("Please input item details");
		return contents;
	}
	
	 @Override
	protected void configureShell(Shell newShell) {
	        super.configureShell(newShell);
	        newShell.setSize(350, 250);

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

		Label id = new Label(dialogArea,SWT.NULL);
		id.setText("ID:*");
		
		idText = new Text(dialogArea, SWT.BORDER|SWT.SINGLE);
		idText.setTextLimit(10);
		idText.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		idText.addModifyListener(this);
		
		Label numbre = new Label(dialogArea,SWT.NULL);
		numbre.setText("Number:*");
		
		numberText = new Text(dialogArea, SWT.BORDER|SWT.SINGLE);
		numberText.setTextLimit(10);
		numberText.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		numberText.addModifyListener(this);
		
		Label description = new Label(dialogArea,SWT.NULL);
		description.setText("Description:");
		
		descriptionText = new Text(dialogArea, SWT.BORDER|SWT.MULTI);
		descriptionText.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		descriptionText.addModifyListener(this);
		return composite;
	}

	/**
	 * Creates the buttons for the button bar
	 * 
	 * @param parent the parent composite
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		okButton.setEnabled(false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, true);

	}

	//@Override
	@Override
	public void modifyText(ModifyEvent e) {
		if(e.getSource() == idText){
			newItem.setId(idText.getText().trim());
		}else if(e.getSource() == numberText){
			String value = numberText.getText();
			if(value != null && !value.trim().equals("")){
				newItem.setNumber(new Integer(value).intValue());
			}
		}else if(e.getSource() == descriptionText){
			newItem.setDescription(descriptionText.getText().trim());
		}
		
		if(newItem.getId() != null && newItem.getNumber() != 0){
			getButton(IDialogConstants.OK_ID).setEnabled(true);
		}else{
			getButton(IDialogConstants.OK_ID).setEnabled(false);

		}
		
	}

	public Item getNewItem() {
		return newItem;
	}

	public void setNewItem(Item newItem) {
		this.newItem = newItem;
	}
	
	@Override
	protected boolean isResizable() {
		return true;
	}


}



