package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.ContainerEditDialogController;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class ViewContainerDialog extends RecordDialog<Container> {

	// widgets
	//	 Label idLabelValue   			ViewWidgetId.VIEW_CONTAINER_ID
	//	 Text searchText   				ViewWidgetId.FARM_LIST_MEMBER_LOOKUP_TXT
	//	 ImageButton lookupButton   	ViewWidgetId.FARM_LIST_SEARCH_BUTTON
	//	 CCombo farmCombo   			ViewWidgetId.VIEW_CONTAINER_FARM
	//	 CCombo measureCombo   			ViewWidgetId.VIEW_CONTAINER_UNIT
	//	 Text capacityText   			ViewWidgetId.VIEW_CONTAINER_COMPACITY
	
	
	/**
	 * AddContainerDialog constructor
	 *
	 * @param shell
	 *            the parent shell
	 */
	@Inject
	public ViewContainerDialog(@Named("current") Shell shell, ContainerEditDialogController controller) {
		super(shell, controller);
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

		final Label idLabel = UIControlsFactory.createLabel(dialogArea, "ID:");
		labelFactory.applyTo(idLabel);

		final Label idLabelValue = UIControlsFactory.createLabel(dialogArea, "", ViewWidgetId.VIEW_CONTAINER_ID);
		fieldFactory.applyTo(idLabelValue);

		final Label memberLabel = UIControlsFactory.createLabel(dialogArea, "Member:");
		labelFactory.applyTo(memberLabel);

		// member name text
		final Composite lookupArea = UIControlsFactory.createComposite(dialogArea, SWT.NONE);
		UIControlsFactory.createText(lookupArea, SWT.SINGLE | SWT.BORDER, ViewWidgetId.FARM_LIST_MEMBER_LOOKUP_TXT);
		UIControlsFactory.createImageButton(lookupArea, SWT.NONE, ViewWidgetId.FARM_LIST_SEARCH_BUTTON).
			setImage(Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.MEMBER_SEARCH_ICON));
		GridLayoutFactory.fillDefaults().numColumns(2).generateLayout(lookupArea);
		fieldFactory.applyTo(lookupArea);
		
		
		final Label farmLabel = UIControlsFactory.createLabel(dialogArea, "Farm:");
		labelFactory.applyTo(farmLabel);

		final CCombo farmCombo = UIControlsFactory.createCCombo(dialogArea, ViewWidgetId.VIEW_CONTAINER_FARM);
		fieldFactory.applyTo(farmCombo);

		final Label unitLabel = UIControlsFactory.createLabel(dialogArea, "Unit Of Measure:");
		labelFactory.applyTo(unitLabel);
		final CCombo measureCombo = UIControlsFactory.createCCombo(dialogArea, ViewWidgetId.VIEW_CONTAINER_UNIT);
		fieldFactory.applyTo(measureCombo);

		final Label capacityLabel = UIControlsFactory.createLabel(dialogArea, "Capacity:");
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
	protected boolean isResizable() {
		return true;
	}

}
