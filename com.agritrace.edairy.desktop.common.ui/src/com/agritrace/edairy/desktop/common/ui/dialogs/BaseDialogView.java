package com.agritrace.edairy.desktop.common.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.swt.views.AbstractDialogView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.ui.DialogConstants;

public abstract class BaseDialogView extends AbstractDialogView {
	
	public static final int DEFAULT_LABEL_WIDTH = 90;
	public static final int DEFAULT_FIELD_WIDTH = 150;

	private Composite main;

	private Button saveButton;
	private Button cancelButton;
	private Button deleteButton;

	public BaseDialogView(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control buildView(Composite parent) {
		// configure my parent
		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		parent.setLayout(new GridLayout(1, false));

		// create a composite child for the work area.
		main = UIControlsFactory.createComposite(parent);
		main.setLayout(new GridLayout(1, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(main);

		// delegate to subclasses to build workarea
		buildWorkArea(main);

		// create button panel below work area.
		GridDataFactory.fillDefaults().align(SWT.END, SWT.FILL).span(2, 1).grab(true, false)
				.applyTo(createOkCancelButtons(parent));
		return main;
	}

	/**
	 * Subclasses can control these via ridget bindings.
	 * 
	 * @param parent
	 * @return
	 */
	private Composite createOkCancelButtons(Composite parent) {

		final Composite buttonComposite = UIControlsFactory.createComposite(parent);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(buttonComposite);

		deleteButton = UIControlsFactory.createButton(buttonComposite, "Delete");
		deleteButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(deleteButton, DialogConstants.BIND_ID_BUTTON_DELETE);

		saveButton = UIControlsFactory.createButton(buttonComposite, "Save");
		saveButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(saveButton, DialogConstants.BIND_ID_BUTTON_SAVE);

		cancelButton = UIControlsFactory.createButton(buttonComposite, "Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(cancelButton, DialogConstants.BIND_ID_BUTTON_CANCEL);
		return buttonComposite;
	}

	protected abstract void buildWorkArea(Composite parent);
	
//	protected abstract void onSave();
//	
//	protected abstract void onCancel();
//	
//	protected abstract void onDelete();
	
	
}