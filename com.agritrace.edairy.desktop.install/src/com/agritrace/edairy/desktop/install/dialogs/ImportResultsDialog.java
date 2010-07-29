package com.agritrace.edairy.desktop.install.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class ImportResultsDialog extends TitleAreaDialog {
	final private List<String> messages;
	final private boolean enableSave;
	
	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public ImportResultsDialog(Shell parentShell, List<String> messages, boolean enableSave) {
		super(parentShell);
		this.messages = messages;
		this.enableSave = enableSave;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		setTitle("Import Results");
		setMessage("Review the import messages and" 
				+ " select 'Save' to complete the import operation, or 'Cancel' to abort without saving.");

		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, false));

		ListViewer listView = new ListViewer(container);
		listView.setContentProvider(new ArrayContentProvider());

		listView.setInput(messages);
		listView.getList().setLayoutData(
				GridDataFactory.defaultsFor(listView.getList()).create());
		
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button button = createButton(parent, IDialogConstants.OK_ID,
				IDialogConstants.OK_LABEL, true);
		button.setText("Save");
		button.setEnabled(enableSave);

		Button button_1 = createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		button_1.setText("Cancel");
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

}
