package com.agritrace.edairy.desktop.common.ui.dialogs;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;

/**
 * Record List Dialog
 * 
 * @author Hui(Spark) Wan
 * 
 */
public abstract class RecordDialog<T extends EObject, C extends RecordDialogController<T>> 
	extends BaseDialogView implements DialogConstants {


	@Override
	protected abstract C createController();

	/**
	 * Create UI components in this dialog
	 * 
	 * @param comp
	 *            Parent composite
	 */
	protected abstract void buildWorkArea(Composite comp);

	private T selectedEObject;

	public RecordDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		this.setShellStyle(SWT.RESIZE | SWT.CLOSE | SWT.TITLE);
		// newShell.setSize(240, 400);
		newShell.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
	}

	/**
	 * Gets the selected object in table list. If user doesn't select any row,
	 * this object will be null
	 * 
	 * @return
	 */
	public T getSelectedEObject() {
		return this.selectedEObject;
	}

	/**
	 * Gets dialog style which will indicate the dialog is a new/view/edit
	 * dialog
	 * 
	 * @return RecordDialog.DIALOG_STYLE_NEW or RecordDialog.DIALOG_STYLE_VIEW
	 *         or RecordDialog.DIALOG_STYLE_EDIT
	 */
	public int getActionType() {
		return (Integer) this.getController().getContext(
				AbstractDirectoryController.EDITED_ACTION_TYPE);
	}

//	@Override
//	protected Control buildView(Composite parent) {
//		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
//		parent.setLayout(new GridLayout(1, false));
//
//		final Composite comp = UIControlsFactory.createComposite(parent);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(comp);
//
//		comp.setLayout(GridLayoutFactory.swtDefaults().create());
//		comp.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
//
//		buildWorkArea(comp);
//		createButtons(comp);
//		return null;
//	}
//	
//
//	/**
//	 * Create buttons for dialog
//	 * 
//	 * @param parent
//	 */
//	private void createButtons(Composite parent) {
//		Composite composite = UIControlsFactory.createComposite(parent);
//		int columns = 2;
//		boolean needDeleteButton = !(this.getActionType() == AbstractRecordListController.ACTION_NEW);
//		if (needDeleteButton) {
//			columns = 3;
//		}
//		composite.setLayout(GridLayoutFactory.swtDefaults().numColumns(columns).spacing(20, 20).create());
//		GridDataFactory.swtDefaults().grab(true, true).align(GridData.CENTER, GridData.BEGINNING).applyTo(composite);
//
//		if (needDeleteButton) {
//			Button deleteButton = UIControlsFactory.createButton(composite);
//			deleteButton.setText("&Delete"); //$NON-NLS-1$
//			addUIControl(deleteButton, BIND_ID_BUTTON_DELETE);
//
//		}
//
//		Button okButton = UIControlsFactory.createButton(composite);
//		if (this.getActionType() == AbstractRecordListController.ACTION_NEW) {
//			okButton.setText("&Save"); //$NON-NLS-1$
//		} else {
//			okButton.setText("&Update"); //$NON-NLS-1$
//		}
//		addUIControl(okButton, BIND_ID_BUTTON_SAVE);
//
//		final Button cancelButton = UIControlsFactory.createButton(composite);
//		cancelButton.setText("&Cancel"); //$NON-NLS-1$
//		addUIControl(cancelButton, BIND_ID_BUTTON_CANCEL);
//		GridDataFactory.swtDefaults().hint(cancelButton.computeSize(-1, -1).x, cancelButton.computeSize(-1, -1).y)
//				.applyTo(okButton);
//		okButton.pack();
//	}

	}
