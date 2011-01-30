package com.agritrace.edairy.desktop.milkops.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.milkops.ui.components.MilkCollectionLogFilterPanel;

public class MilkCollectionLog extends AbstractDirectoryView {

	public static final String ID = "milk-collection-log";

	public MilkCollectionLog() {
		setTitleToolTip("A searchable list of all collection records.");
		setPartName("Milk Collection Journal Register");
		setContentDescription("Master collection journal list.");
	}

	@Override
	protected void createButtonPanel(Composite parent, String viewButtonId, String addButtonId) {
		final Composite buttonsPanel = UIControlsFactory.createComposite(parent, SWT.NULL);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(buttonsPanel);

		// create three sections - center section is filler
		final Composite leftPanel = UIControlsFactory.createComposite(buttonsPanel);
		final Control filler = UIControlsFactory.createLabel(buttonsPanel, "");
		final Composite rightPanel = UIControlsFactory.createComposite(buttonsPanel);

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
	protected void createFilterGroup(Composite parent) {
//		Composite filterGroup = UIControlsFactory.createComposite(parent, SWT.BORDER);
//		filterGroup.setLayout(new FillLayout());
		final Composite panel = new MilkCollectionLogFilterPanel(parent, SWT.BORDER);
		panel.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());
		panel.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
//		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(3, -1).applyTo(comp);
	}

}
