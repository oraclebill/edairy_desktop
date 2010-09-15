package com.agritrace.edairy.desktop.finance.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.finance.ui.controllers.AdjustmentTransactionJournalFilterPanel;

public final class AdjustmentTransactionJournalView extends AbstractDirectoryView {

	public static final String ID = "adjustment.journal"; //$NON-NLS-1$

	public AdjustmentTransactionJournalView() {
	}

	protected void createFilterGroup(Composite parent) {
		createFilterConditions(parent);
		createFilterButtonPanel(parent);
	}

	@Override
	protected void createFilterConditions(Composite parent) {
		Composite comp = UIControlsFactory.createComposite(parent);
		comp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comp.setLayout(new GridLayout(2, false));
		
		GridDataFactory.fillDefaults().applyTo(new AdjustmentTransactionJournalFilterPanel(comp));

		final Composite composite_1 = new Composite(comp, SWT.NONE);
		GridDataFactory.fillDefaults().applyTo(composite_1);
		composite_1.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
	}

}
