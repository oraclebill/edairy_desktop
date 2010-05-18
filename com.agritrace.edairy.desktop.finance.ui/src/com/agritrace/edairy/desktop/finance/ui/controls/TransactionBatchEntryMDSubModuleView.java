package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.core.databinding.property.list.IListProperty;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.model.SubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.finance.ui.controllers.TransactionBatchEntrySubModuleController;


public class TransactionBatchEntryMDSubModuleView extends SubModuleView {
	
	public static final String ID = "transaction.batch-entry.mdview";
	
	public TransactionBatchEntryMDSubModuleView() {
	}

	@Override
	protected void basicCreatePartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		TransactionBatchEntryComposite mdComposite = new TransactionBatchEntryComposite(parent, SWT.NONE);
		addUIControl(mdComposite, "master");
		
		Composite details = mdComposite.getDetails();
		addUIControl(details, "details");
	}

	@Override
	public SubModuleController getController() {
		// TODO Auto-generated method stub
		return new TransactionBatchEntrySubModuleController( getNavigationNode() );
	}

	
}