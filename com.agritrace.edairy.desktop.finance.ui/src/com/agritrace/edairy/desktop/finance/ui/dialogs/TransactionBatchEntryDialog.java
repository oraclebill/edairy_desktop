package com.agritrace.edairy.desktop.finance.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.ui.dialogs.BaseDialogView;
import com.agritrace.edairy.desktop.finance.ui.controls.TransactionEntryPanel;

public class TransactionBatchEntryDialog extends BaseDialogView {

	public static final String ID = "transaction.batch-entry.mdview";

	public TransactionBatchEntryDialog() {
		this(null);
	}

	public TransactionBatchEntryDialog(Shell shell) {
		super(shell);
	}

	@Override
	protected void buildWorkArea(Composite parent) {

		final Composite master = new MasterDetailsComposite(parent, SWT.TOP) {
			@Override
			protected void createDetails(Composite parent) {
				final Composite detailPanel = new TransactionEntryPanel(parent, SWT.NONE);
				GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(detailPanel);
				GridLayoutFactory.fillDefaults().generateLayout(parent);
			}
		};
		addUIControl(master, "master");
		GridLayoutFactory.fillDefaults().generateLayout(master);
	}

	// @Override
	// protected void buildWorkArea(Composite parent) {
	// parent.setLayout(new FillLayout());
	// TransactionBatchEntryComposite mdComposite = new
	// TransactionBatchEntryComposite(parent, SWT.NONE);
	// addUIControl(mdComposite, "master");
	//
	// Composite details = mdComposite.getDetails();
	// addUIControl(details, "details");
	// }

	@Override
	protected AbstractWindowController createController() {
		// return new TransactionBatchEntrySubModuleController(
		// getNavigationNode() );
		return new TransactionBatchEntryDialogController();	}

}