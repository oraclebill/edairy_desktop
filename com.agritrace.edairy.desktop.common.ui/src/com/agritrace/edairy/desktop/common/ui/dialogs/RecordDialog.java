package com.agritrace.edairy.desktop.common.ui.dialogs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.swt.views.AbstractDialogView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.ui.controllers.ResultListDialogController;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;

public abstract class RecordDialog extends AbstractDialogView {

	public static final int DIALOG_STYLE_NEW = 1;

	public static final int DIALOG_STYLE_VIEW = 2;

	public static final int DIALOG_STYLE_EDIT = 3;
	public static final String BIND_ID_BUTTON_OK = "bind.id.btn.ok";
	public static final String BIND_ID_BUTTON_CANCEL = "bind.id.btn.cancel";

	private int style;

	private EObject selectedEObject;

	public RecordDialog(int style, Shell parentShell, EObject selectedObject) {
		super(parentShell);
		this.style = style;
		this.selectedEObject = selectedObject;

	}

	public EObject getSelectedEObject() {
		return this.selectedEObject;
	}

	public EObject getWorkingCopy() {
		return ((ResultListDialogController) this.getController())
				.getWorkingCopy();
	}

	public int getDialogStyle() {
		return this.style;
	}

	@Override
	protected Control buildView(Composite parent) {
		Composite comp = UIControlsFactory.createComposite(parent);
		comp.setLayout(GridLayoutFactory.swtDefaults().create());
		GridDataFactory.swtDefaults().grab(true, true).applyTo(comp);
		comp.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));

		createUIComponent(comp);
		createButtons(comp);
		return null;
	}

	/**
	 * Create UI components
	 * 
	 * @param comp
	 */
	protected abstract void createUIComponent(Composite comp);

	private void createButtons(Composite parent) {
		Composite composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(GridLayoutFactory.swtDefaults().numColumns(2)
				.spacing(20, 20).create());
		GridDataFactory.swtDefaults().grab(true, true).align(GridData.CENTER,
				GridData.BEGINNING).applyTo(composite);

		Button okButton = UIControlsFactory.createButton(composite);
		okButton.setText("&Ok"); //$NON-NLS-1$
		addUIControl(okButton, BIND_ID_BUTTON_OK);

		Button cancelButton = UIControlsFactory.createButton(composite);
		cancelButton.setText("&Cancel"); //$NON-NLS-1$
		addUIControl(cancelButton, BIND_ID_BUTTON_CANCEL);
		GridDataFactory.swtDefaults().hint(cancelButton.computeSize(-1, -1).x,
				cancelButton.computeSize(-1, -1).y).applyTo(okButton);
		okButton.pack();

	}

}
