package com.agritrace.edairy.desktop.collection.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.agritrace.edairy.desktop.collection.ui.components.MilkCollectionLogFilterPanel;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public class MilkCollectionLog extends AbstractDirectoryView {

	public static final String ID = "milk-collection-log";

	public MilkCollectionLog() {
	}

	@Override
	protected void createButtonPanel(Composite parent, String viewButtonId, String addButtonId) {
		final Composite buttonsPanel = UIControlsFactory.createComposite(parent, SWT.NULL);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(buttonsPanel);
		
		// create three sections - center section is filler
		Composite leftPanel = UIControlsFactory.createComposite(buttonsPanel);
		Control filler = UIControlsFactory.createLabel(buttonsPanel, "");
		Composite rightPanel = UIControlsFactory.createComposite(buttonsPanel);
		
		UIControlsFactory.createButton(rightPanel, "View Journal", viewButtonId);
		UIControlsFactory.createButton(rightPanel, "Post Journal Details", addButtonId);
		
		UIControlsFactory.createButton(leftPanel, "Import From Scale",  "import-file-button");
		UIControlsFactory.createButton(leftPanel, "Post Journal Totals",  "log-journals-button");
		
		buttonsPanel.setLayout(new GridLayout(3, false));
		
		leftPanel.setLayout(new RowLayout(SWT.HORIZONTAL));
		leftPanel.setLayoutData(GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.BOTTOM).create());
		
		filler.setLayoutData(GridDataFactory.fillDefaults().grab(true,false).create());
		
		rightPanel.setLayout(new RowLayout(SWT.HORIZONTAL));
		rightPanel.setLayoutData(GridDataFactory.swtDefaults().align(SWT.RIGHT, SWT.BOTTOM).create());

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
