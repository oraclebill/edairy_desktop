package com.agritrace.edairy.ui.views;


import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.ui.views.data.MemberFactory;
import com.agritrace.edairy.ui.views.data.MemberShip;

public class MemberSearchDialog extends TitleAreaDialog {


	/**
	 * MyTitleAreaDialog constructor
	 * 
	 * @param shell the parent shell
	 */
	public MemberSearchDialog(Shell shell) {
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
		setTitle("Member Lookup");
		setMessage("Please input member search criterias");
		return contents;
	}
	
	 protected void configureShell(Shell newShell) {
	        newShell.setSize(450, 500);
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
		dialogArea.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		dialogArea.setLayout(new GridLayout(4,false));
		Label label = new Label(dialogArea,SWT.NULL);
		label.setText("Lookup field:");
		label.setLayoutData(new GridData(SWT.BEGINNING,SWT.BEGINNING,false,false));

		Combo combo = new Combo(dialogArea,SWT.BORDER);
		combo.setItems(new String[]{"ID","Name","Location"});
		combo.setLayoutData(new GridData(SWT.FILL,SWT.BEGINNING,false,false));

		Text filterText = new Text(dialogArea,SWT.NULL|SWT.BORDER|SWT.SINGLE);
		filterText.setLayoutData(new GridData(SWT.FILL,SWT.BEGINNING,true,false));

		Button lookupButton = new Button(dialogArea,SWT.PUSH);
		lookupButton.setText("Lookup");
		lookupButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
		lookupButton.addSelectionListener(new SelectionAdapter() {
			/**
			 * Sent when selection occurs in the control.
			 * The default behavior is to do nothing.
			 *
			 * @param e an event containing information about the selection
			 */
			public void widgetSelected(SelectionEvent e) {
			}

			/**
			 * Sent when default selection occurs in the control.
			 * The default behavior is to do nothing.
			 *
			 * @param e an event containing information about the default selection
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		Composite panel = new Composite(dialogArea, SWT.NULL);
		panel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,4,1));
		TableViewer tableView = new TableViewer(panel,SWT.FULL_SELECTION | SWT.BORDER|SWT.MULTI);
		Table table=tableView.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);



		// Create two columns and show
		TableColumn id = new TableColumn(table, SWT.LEFT);
		id.setText("ID");

		TableColumn name = new TableColumn(table, SWT.LEFT);
		name.setText("Name");

		TableColumn location = new TableColumn(table, SWT.LEFT);
		location.setText("Location");


		TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(id, new ColumnWeightData(20));
		layout.setColumnData(name, new ColumnWeightData(30));
		layout.setColumnData(location, new ColumnWeightData(50));

		tableView.setContentProvider(new ArrayContentProvider());
		tableView.setLabelProvider(new MemberLabelProvider());
		tableView.setInput(MemberFactory.createMemberList());

		panel.setLayout(layout);
		return composite;
	}

	/**
	 * Creates the buttons for the button bar
	 * 
	 * @param parent the parent composite
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "Select", true);
	}

	public class MemberLabelProvider implements ITableLabelProvider{

		
		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

		
		public void dispose() {
			// TODO Auto-generated method stub

		}

		
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

		
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		
		public String getColumnText(Object element, int columnIndex) {
			if(element instanceof MemberShip){
				switch(columnIndex){
				case 0:
					return ((MemberShip)element).getId().toString();
				case 1:
					return ((MemberShip)element).getFirstname()+((MemberShip)element).getLastname();
				case 2:
					return 
					((MemberShip)element).getAddress();
				}
			}
			return null;
		}

	}
}



