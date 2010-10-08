package com.agritrace.edairy.desktop.collection.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.collection.ui.components.DeliveryJournalFilterPanel;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public class MilkDeliveryJournalView extends AbstractDirectoryView {

	public static final String ID = "com.agritrace.edairy.desktop.collection.ui.views.MilkDeliveryLogView"; //$NON-NLS-1$

	public MilkDeliveryJournalView() {

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
		new DeliveryJournalFilterPanel(comp, SWT.NONE);
	}

}
