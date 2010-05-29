package com.agritrace.edairy.desktop.common.ui.dialogs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.swt.views.AbstractDialogView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;

/**
 * Record List Dialog
 * 
 * @author Hui(Spark) Wan
 * 
 */
public abstract class RecordDialog extends AbstractDialogView {

	/**
	 * Dialog style which means the dialog is a dialog to create a new record
	 */
	public static final int DIALOG_STYLE_NEW = 1;

	/**
	 * Dialog style which means the dialog is a dialog to view a new record
	 */
	public static final int DIALOG_STYLE_VIEW = 2;

	/**
	 * Dialog style which means the dialog is a dialog to view a new record
	 * Currently, view/edit are same
	 */
	public static final int DIALOG_STYLE_EDIT = 3;
	/**
	 * Bind id for OK button, the label maybe change, but the bind id will not change
	 */
	public static final String BIND_ID_BUTTON_OK = "bind.id.btn.ok";
	/**
	 * Bind id for cancel button
	 */
	public static final String BIND_ID_BUTTON_CANCEL = "bind.id.btn.cancel";

	private int style;

	private EObject selectedEObject;

	/**
	 * Default constructor
	 * 
	 * @param style Dialog style, possible values are <code>RecordDialog.DIALOG_STYLE_NEW</code>
	 * <code>RecordDialog.DIALOG_STYLE_VIEW</code>,<code>RecordDialog.DIALOG_STYLE_EDIT</code>
	 * RecordDialog.DIALOG_STYLE_NEW means creating a new record
	 * RecordDialog.DIALOG_STYLE_VIEW means viewing a new record
	 * RecordDialog.DIALOG_STYLE_EDIT means editing a new record
	 * @param parentShell Parent shell
	 * @param selectedObject Selected object in the table list
	 */
	public RecordDialog(int style, Shell parentShell, EObject selectedObject) {
		super(parentShell);
		this.style = style;
		this.selectedEObject = selectedObject;
		((RecordDialogController) this.getController()).itemSelected();

	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		this.setShellStyle(SWT.RESIZE | SWT.CLOSE | SWT.TITLE);
		// newShell.setSize(240, 400);
		newShell.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));
	}

	/**
	 * Gets the selected object in table list. If user doesn't select any row,
	 * this object will be null
	 * 
	 * @return
	 */
	public EObject getSelectedEObject() {
		return this.selectedEObject;
	}

	/**
	 * Gets the working copying which is used for data binding
	 * 
	 * @return
	 */
	public EObject getWorkingCopy() {
		return ((RecordDialogController) this.getController()).getWorkingCopy();
	}

	/**
	 * Gets dialog style which will indicate the dialog is a  new/view/edit dialog
	 * 
	 * @return RecordDialog.DIALOG_STYLE_NEW or RecordDialog.DIALOG_STYLE_VIEW or RecordDialog.DIALOG_STYLE_EDIT
	 */
	public int getDialogStyle() {
		return this.style;
	}

	@Override
	protected Control buildView(Composite parent) {
		Composite comp = UIControlsFactory.createComposite(parent);
		comp.setLayout(GridLayoutFactory.swtDefaults().create());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).applyTo(comp);
		comp.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));
		comp.getParent().setBackground(
				LnfManager.getLnf().getColor(
						LnfKeyConstants.SUB_MODULE_BACKGROUND));

		createUIComponent(comp);
		createButtons(comp);
		return null;
	}

	/**
	 * Create UI components in this dialog
	 * 
	 * @param comp Parent composit
	 */
	protected abstract void createUIComponent(Composite comp);

	/**
	 * Create buttons for dialog
	 * 
	 * @param parent
	 */
	private void createButtons(Composite parent) {
		Composite composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(GridLayoutFactory.swtDefaults().numColumns(2)
				.spacing(20, 20).create());
		GridDataFactory.swtDefaults().grab(true, true)
				.align(GridData.CENTER, GridData.BEGINNING).applyTo(composite);

		Button okButton = UIControlsFactory.createButton(composite);
		okButton.setText("&Ok"); //$NON-NLS-1$
		addUIControl(okButton, BIND_ID_BUTTON_OK);

		Button cancelButton = UIControlsFactory.createButton(composite);
		cancelButton.setText("&Cancel"); //$NON-NLS-1$
		addUIControl(cancelButton, BIND_ID_BUTTON_CANCEL);
		GridDataFactory
				.swtDefaults()
				.hint(cancelButton.computeSize(-1, -1).x,
						cancelButton.computeSize(-1, -1).y).applyTo(okButton);
		okButton.pack();

	}

}
