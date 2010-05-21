package com.agritrace.edairy.desktop.common.ui.dialogs;

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

// TODO: get domain objects out of dialog
import com.agritrace.edairy.desktop.common.model.dairy.*;

/**
 * This is a demo dialog copied from MemberSearchDialog
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class FarmSearchDialog extends TitleAreaDialog {

    /**
     * MyTitleAreaDialog constructor
     * 
     * @param shell
     *            the parent shell
     */
    public FarmSearchDialog(Shell shell) {
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
     * @param parent
     *            the parent composite
     * @return Control
     */
    @Override
    protected Control createContents(Composite parent) {
	final Control contents = super.createContents(parent);
	setTitle("Farm Lookup");
	setMessage("Please input farm search criterias");
	return contents;
    }

    @Override
    protected void configureShell(Shell newShell) {
	newShell.setSize(450, 500);
	super.configureShell(newShell);
    }

    /**
     * Creates the gray area
     * 
     * @param parent
     *            the parent composite
     * @return Control
     */
    @Override
    protected Control createDialogArea(Composite parent) {
	final Composite composite = (Composite) super.createDialogArea(parent);
	final Composite dialogArea = new Composite(composite, SWT.NULL);
	dialogArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	dialogArea.setLayout(new GridLayout(4, false));
	final Label label = new Label(dialogArea, SWT.NULL);
	label.setText("Lookup field:");
	label.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));

	final Combo combo = new Combo(dialogArea, SWT.BORDER);
	combo.setItems(new String[] { "ID", "Name", "Location" });
	combo.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, false, false));

	final Text filterText = new Text(dialogArea, SWT.NULL | SWT.BORDER | SWT.SINGLE);
	filterText.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

	final Button lookupButton = new Button(dialogArea, SWT.PUSH);
	lookupButton.setText("Lookup");
	lookupButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
	lookupButton.addSelectionListener(new SelectionAdapter() {
	    /**
	     * Sent when selection occurs in the control. The default behavior
	     * is to do nothing.
	     * 
	     * @param e
	     *            an event containing information about the selection
	     */
	    @Override
	    public void widgetSelected(SelectionEvent e) {
	    }

	    /**
	     * Sent when default selection occurs in the control. The default
	     * behavior is to do nothing.
	     * 
	     * @param e
	     *            an event containing information about the default
	     *            selection
	     */
	    @Override
	    public void widgetDefaultSelected(SelectionEvent e) {
	    }
	});

	final Composite panel = new Composite(dialogArea, SWT.NULL);
	panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
	final TableViewer tableView = new TableViewer(panel, SWT.FULL_SELECTION | SWT.BORDER | SWT.MULTI);
	final Table table = tableView.getTable();
	table.setHeaderVisible(true);
	table.setLinesVisible(true);

	// Create two columns and show
	final TableColumn id = new TableColumn(table, SWT.LEFT);
	id.setText("ID");

	final TableColumn name = new TableColumn(table, SWT.LEFT);
	name.setText("Name");

	final TableColumn location = new TableColumn(table, SWT.LEFT);
	location.setText("Location");

	final TableColumnLayout layout = new TableColumnLayout();
	layout.setColumnData(id, new ColumnWeightData(20));
	layout.setColumnData(name, new ColumnWeightData(30));
	layout.setColumnData(location, new ColumnWeightData(50));

	tableView.setContentProvider(new ArrayContentProvider());
	tableView.setLabelProvider(new MemberLabelProvider());
	
	tableView.setInput(null); // TODO: TEST - setup 

	panel.setLayout(layout);
	return composite;
    }

    /**
     * Creates the buttons for the button bar
     * 
     * @param parent
     *            the parent composite
     */
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
	createButton(parent, IDialogConstants.OK_ID, "Select", true);
    }

    public class MemberLabelProvider implements ITableLabelProvider {

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
	    if (element instanceof Membership) {
		Membership member = (Membership) element;
		assert(member.getMember() != null);
		switch (columnIndex) {
		case 0:
		    return member.getMemberId().toString();
		case 1:
		    return member.getMember().getGivenName() + member.getMember().getFamilyName();
		case 2:
		    try {		
			return member.getMember().getLocation().getPostalLocation().getAddress();
		    } catch (Exception e) {
			return "<location not found>";
		    }
		}
	    }
	    return null;
	}

    }
}
