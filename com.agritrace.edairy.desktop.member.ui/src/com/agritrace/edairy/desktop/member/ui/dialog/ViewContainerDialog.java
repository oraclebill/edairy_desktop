package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;
import com.agritrace.edairy.desktop.common.ui.dialogs.BaseDialogView;
import com.agritrace.edairy.desktop.member.ui.Activator;
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
		dialogArea.setLayout(new GridLayout(3, false));
		dialogArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final GridDataFactory labelFactory = GridDataFactory.swtDefaults().hint(DEFAULT_LABEL_WIDTH, SWT.DEFAULT).indent(5, 0);
		final GridDataFactory fieldFactory = GridDataFactory.swtDefaults().hint(DEFAULT_FIELD_WIDTH, SWT.DEFAULT).span(2, 1).grab(false, false);

		Label idLabel = UIControlsFactory.createLabel(dialogArea, "ID:");
		labelFactory.applyTo(idLabel);

		final Label idLabelValue = UIControlsFactory.createLabel(dialogArea, "", ViewWidgetId.VIEW_CONTAINER_ID);
		fieldFactory.applyTo(idLabelValue);
		
		final Label memberLabel = UIControlsFactory.createLabel(dialogArea, "Member:");
		labelFactory.applyTo(memberLabel);

		// member name text
		final Text searchText = UIControlsFactory.createText(dialogArea, SWT.SINGLE | SWT.BORDER, ViewWidgetId.FARM_LIST_MEMBER_LOOKUP_TXT);
		GridDataFactory.fillDefaults().hint(DEFAULT_FIELD_WIDTH, SWT.DEFAULT).grab(false, false).applyTo(searchText);

		final ImageButton lookupButton = UIControlsFactory.createImageButton(dialogArea, SWT.NULL, ViewWidgetId.FARM_LIST_SEARCH_BUTTON);
		final Image lookupIcon = Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.MEMBER_SEARCH_ICON);
		lookupButton.setImage(lookupIcon);
		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.FILL).grab(false, false).applyTo(lookupButton);

		Label farmLabel = UIControlsFactory.createLabel(dialogArea, "Farm:");
		labelFactory.applyTo(farmLabel);

		final CCombo farmCombo = UIControlsFactory.createCCombo(dialogArea, ViewWidgetId.VIEW_CONTAINER_FARM);
		fieldFactory.applyTo(farmCombo);

		Label unitLabel = UIControlsFactory.createLabel(dialogArea, "Unit Of Measure:");
		labelFactory.applyTo(unitLabel);
		final CCombo measureCombo = UIControlsFactory.createCCombo(dialogArea, ViewWidgetId.VIEW_CONTAINER_UNIT);
		fieldFactory.applyTo(measureCombo);

		Label capacityLabel = UIControlsFactory.createLabel(dialogArea, "Capacity:");
		labelFactory.applyTo(capacityLabel);
		final Text capacityText = UIControlsFactory.createText(dialogArea, SWT.BORDER | SWT.SINGLE, ViewWidgetId.VIEW_CONTAINER_COMPACITY);
		fieldFactory.applyTo(capacityText);

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
