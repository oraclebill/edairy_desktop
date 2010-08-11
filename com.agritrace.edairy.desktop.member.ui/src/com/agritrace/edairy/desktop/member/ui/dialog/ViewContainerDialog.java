package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.dialogs.BaseDialogView;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.ViewContainerDialogController;

public class ViewContainerDialog extends BaseDialogView {

	/**
	 * AddContainerDialog constructor
	 * 
	 * @param shell
	 *            the parent shell
	 */
	public ViewContainerDialog(Shell shell) {
		super(shell);

	}

	/**
	 * Creates the gray area
	 * 
	 * @param parent
	 *            the parent composite
	 * @return Control
	 */
	@Override
	protected void buildWorkArea(Composite parent) {
		final Composite dialogArea = UIControlsFactory.createComposite(parent);
		dialogArea.setLayout(new GridLayout(2, false));
		dialogArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		UIControlsFactory.createLabel(dialogArea, "ID:");

		final Label idLabel = UIControlsFactory.createLabel(dialogArea, "", ViewWidgetId.VIEW_CONTAINER_ID);
		idLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	
//		UIControlsFactory.createLabel(dialogArea, "Container Type:");
//		final Combo containerCombo = UIControlsFactory.createCombo(dialogArea, ViewWidgetId.VIEW_CONTAINER_TYPE);
//		containerCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		UIControlsFactory.createLabel(dialogArea, "Unit Of Measure:");
		final CCombo measureCombo = UIControlsFactory.createCCombo(dialogArea, ViewWidgetId.VIEW_CONTAINER_UNIT);
		measureCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		UIControlsFactory.createLabel(dialogArea, "Capacity:");

		final Text capacityText = UIControlsFactory.createText(dialogArea, SWT.BORDER | SWT.SINGLE,
				ViewWidgetId.VIEW_CONTAINER_COMPACITY);
		capacityText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		UIControlsFactory.createLabel(dialogArea, "Farm:");
		final CCombo farmCombo = UIControlsFactory.createCCombo(dialogArea, ViewWidgetId.VIEW_CONTAINER_FARM);
		farmCombo.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		
		final Label memberNameLabel = UIControlsFactory.createLabel(dialogArea, "Member Name :");
		
		final Label memberNameValueLabel = UIControlsFactory.createLabel(dialogArea, "");
		addUIControl(memberNameValueLabel, ViewWidgetId.VIEW_FARM_MEMBER_NAME);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(memberNameValueLabel);


	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setSize(550, 450);
	}

	@Override
	protected AbstractWindowController createController() {
		return new ViewContainerDialogController();
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

}
