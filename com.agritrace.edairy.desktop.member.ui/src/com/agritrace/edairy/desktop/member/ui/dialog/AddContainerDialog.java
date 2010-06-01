package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.swt.views.AbstractDialogView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.AddContainerDialogController;

public class AddContainerDialog extends AbstractDialogView  {

	private Composite main;

	/**
	 * AddContainerDialog constructor
	 * 
	 * @param shell
	 *            the parent shell
	 */
	public AddContainerDialog(Shell shell) {
		super(shell);

	}

	@Override
	protected Control buildView(Composite parent) {
		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		parent.setLayout(new GridLayout(1, false));

		main = UIControlsFactory.createComposite(parent);
		main.setLayout(new GridLayout(1, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(main);

		createMainArea(main);
		GridDataFactory.fillDefaults().align(SWT.END, SWT.FILL).span(2, 1).grab(true, false).applyTo(createOkCancelButtons(parent));

		return null;
	}

	@Override
	protected AbstractWindowController createController() {
		return new AddContainerDialogController();
	}

	/**
	 * Closes the dialog box Override so we can dispose the image we created
	 */
	@Override
	public boolean close() {
		return super.close();
	}


	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setSize(550, 450);
	}

	/**
	 * Creates the gray area
	 * 
	 * @param parent
	 *            the parent composite
	 * @return Control
	 */
	protected Control createMainArea(Composite parent) {
		final Composite dialogArea = UIControlsFactory.createComposite(parent);
		dialogArea.setLayout(new GridLayout(2, false));
		dialogArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		UIControlsFactory.createLabel(dialogArea, "ID:");

		Label idLabel = UIControlsFactory.createLabel(dialogArea, "", ViewWidgetId.VIEW_CONTAINER_ID);
		idLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		UIControlsFactory.createLabel(dialogArea, "Container Type:");
		final Combo containerCombo = UIControlsFactory.createCombo(dialogArea,ViewWidgetId.VIEW_CONTAINER_TYPE);
		containerCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		UIControlsFactory.createLabel(dialogArea, "Unit Of Measure:");
		final Combo measureCombo = UIControlsFactory.createCombo(dialogArea,ViewWidgetId.VIEW_CONTAINER_UNIT);
		measureCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));


		UIControlsFactory.createLabel(dialogArea, "Capacity:");

		Text capacityText = UIControlsFactory.createText(dialogArea,SWT.BORDER|SWT.SINGLE,ViewWidgetId.VIEW_CONTAINER_COMPACITY);
		capacityText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));


		UIControlsFactory.createLabel(dialogArea, "Farm:");
		final Combo farmCombo = UIControlsFactory.createCombo(dialogArea, ViewWidgetId.VIEW_CONTAINER_FARM);
		farmCombo.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		return dialogArea;
	}

	private Composite createOkCancelButtons(Composite parent) {

		final Composite buttonComposite = UIControlsFactory.createComposite(parent);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(buttonComposite);

		Button deleteButton = UIControlsFactory.createButton(buttonComposite, "Delete");
		deleteButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(deleteButton, ViewWidgetId.deleteButton);

		Button saveButton = UIControlsFactory.createButton(buttonComposite, "Save");
		saveButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(saveButton, ViewWidgetId.memberInfo_saveButton);

		Button cancelButton = UIControlsFactory.createButton(buttonComposite, "Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(cancelButton, ViewWidgetId.memberInfo_cacelButton);
		return buttonComposite;
	}



	@Override
	protected boolean isResizable() {
		return true;
	}

}
