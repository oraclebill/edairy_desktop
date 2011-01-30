package com.agritrace.edairy.desktop.milkops.ui.sales;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public class MilkSaleLogView extends AbstractDirectoryView {

	public static final String ID = "com.agritrace.edairy.desktop.milkops.ui.views.MilkDeliveryLogView"; //$NON-NLS-1$

	public MilkSaleLogView() {
	}

	/**
	 * Create contents of the view part.
	 *
	 * @param parent
	 */
	@Override
	public void basicCreatePartControl(Composite parent) {
		super.basicCreatePartControl(parent);
	}

	@Override
	protected void createFilterConditions(Composite comp) {
		new MilkSaleLogFilterPanel(comp, SWT.NONE);
	}
}
