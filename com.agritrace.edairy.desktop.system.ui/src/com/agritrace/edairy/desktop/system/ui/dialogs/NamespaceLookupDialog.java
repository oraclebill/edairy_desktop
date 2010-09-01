package com.agritrace.edairy.desktop.system.ui.dialogs;

import java.util.Map;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.PermissionNamespace;
import com.agritrace.edairy.desktop.system.ui.controllers.NamespaceLookupDialogController;

public final class NamespaceLookupDialog extends TitleAreaDialog {
	private NamespaceLookupDialogController controller;
	private List list;
	private Map<String, PermissionNamespace> nsMap;
	private PermissionNamespace selectedNamespace = null;
	
	public NamespaceLookupDialog(Shell parentShell) {
		super(parentShell);
		controller = new NamespaceLookupDialogController();
	}

	private static void placeDialogInCenter(Shell parent, Shell shell){
		final Rectangle parentSize = parent.getBounds();
		final Rectangle mySize = shell.getBounds();

		final int locationX = (parentSize.width - mySize.width) / 2 + parentSize.x;
		final int locationY = (parentSize.height - mySize.height) / 2 + parentSize.y;

		shell.setLocation(new Point(locationX, locationY));
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		newShell.setSize(300, 400);
		placeDialogInCenter(getParentShell(), newShell);
		super.configureShell(newShell);
	}
	
	@Override
	protected Control createButtonBar(Composite parent) {
		Control ctrl = super.createButtonBar(parent);
		getButton(IDialogConstants.OK_ID).setText("Select");
		return ctrl;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Permission Namespaces");
		setMessage("Select a namespace from the list, or enter a new one.");

		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(3, false));
		
		final Text newNamespace = new Text(composite, SWT.BORDER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(newNamespace);
		
		final Button addButton = new Button(composite, SWT.PUSH);
		addButton.setText("Add");
		addButton.setEnabled(false);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(false, false).applyTo(addButton);
		
		newNamespace.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				addButton.setEnabled(!newNamespace.getText().isEmpty());
			}
		});
		
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					controller.add(newNamespace.getText());
					newNamespace.setText("");
					newNamespace.setFocus();
					updateList();
				} catch (Exception ex) {
					// Namespace already exists?
					MessageDialog.openError(getShell(), "Error adding namespace", ex.getMessage());
				}
			}
		});
		
		final Button removeButton = new Button(composite, SWT.PUSH);
		removeButton.setText("Remove");
		removeButton.setEnabled(false);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(false, false).applyTo(removeButton);
		
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					int index = list.getSelectionIndex();
					
					if (index != -1) {
						controller.delete(nsMap.get(list.getItem(index)));
						removeButton.setEnabled(false);
						updateList();
					} else {
						MessageDialog.openWarning(getShell(), "No namespace selected", "Please select a namespace to delete.");
					}
				} catch (Exception ex) {
					// Namespace already exists?
					MessageDialog.openError(getShell(), "Error removing namespace", ex.getMessage());
				}
			}
		});
		
		list = new List(composite, SWT.SINGLE | SWT.BORDER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(3, 1).applyTo(list);
		
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				okPressed();
			}
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeButton.setEnabled(list.getSelectionIndex() != -1);
			}
		});
		
		updateList();
		return composite;
	}
	
	private void updateList() {
		nsMap = controller.findAll();
		list.removeAll();
		
		for (String name: nsMap.keySet()) {
			list.add(name);
		}
	}
	
	@Override
	protected void okPressed() {
		int index = list.getSelectionIndex();
		
		if (index != -1) {
			selectedNamespace = nsMap.get(list.getItem(index));
			super.okPressed();
		} else {
			MessageDialog.openWarning(getShell(), "No namespace selected", "Please select a namespace.");
		}
	}

	public PermissionNamespace getSelectedNamespace() {
		return selectedNamespace;
	}
}
