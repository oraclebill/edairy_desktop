package com.agritrace.edairy.desktop.collection.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.collection.ui.components.MilkCollectionLogFilterPanel;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public class MilkCollectionLog extends AbstractDirectoryView {

	public static final String ID = "milk-collection-log";

	public MilkCollectionLog() {
	}

	@Override
	protected void createButtonPanel(Composite parent, String viewButtonId, String addButtonId) {
		final Composite buttonsPanel = UIControlsFactory.createComposite(parent, SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(true, false).applyTo(buttonsPanel);
		buttonsPanel.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button viewButton = UIControlsFactory.createButton(buttonsPanel, "View", viewButtonId);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false, false).applyTo(viewButton);

		final Button addButton = UIControlsFactory.createButton(buttonsPanel, "Add", addButtonId);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false, false).applyTo(addButton);

		final Button importButton = UIControlsFactory.createButton(buttonsPanel, "Import",  "import-file-button");
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false, false).applyTo(importButton);
	}

	@Override
	protected void createFilterButtonPanel(Composite parent) {
		// prevent superclass from adding buttons..
	}

	@Override
	protected void createFilterConditions(Composite top) {
		Composite parent = UIControlsFactory.createComposite(top);
		parent.setLayout(new FillLayout());
		final Composite comp = new MilkCollectionLogFilterPanel(parent, SWT.NONE);
		comp.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
//		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(3, -1).applyTo(comp);
	}

}
