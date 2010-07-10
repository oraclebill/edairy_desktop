package com.agritrace.edairy.desktop.common.ui.dialogs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.BaseDialogController;

/**
 * Record List Dialog
 * 
 * @author Hui(Spark) Wan
 * 
 */
public abstract class RecordDialog<T extends EObject, C extends BaseDialogController<T>> extends BaseDialogView
		implements DialogConstants {

	private T selectedEObject;

	public RecordDialog(Shell parentShell) {
		super(parentShell);
		// setReturnCode(CANCEL); // default to cancel,
	}

	/**
	 * Gets dialog style which will indicate the dialog is a new/view/edit
	 * dialog
	 * 
	 * @return RecordDialog.DIALOG_STYLE_NEW or RecordDialog.DIALOG_STYLE_VIEW
	 *         or RecordDialog.DIALOG_STYLE_EDIT
	 */
	public int getActionType() {
		return (Integer) this.getController().getContext(AbstractDirectoryController.EDITED_ACTION_TYPE);
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
	 * Create UI components in this dialog
	 * 
	 * @param comp
	 *            Parent composite
	 */
	@Override
	protected abstract void buildWorkArea(Composite comp);

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		this.setShellStyle(SWT.RESIZE | SWT.CLOSE | SWT.TITLE);
		// newShell.setSize(240, 400);
		newShell.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
	}

	@Override
	protected abstract AbstractWindowController createController();

}
