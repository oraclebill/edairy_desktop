package com.agritrace.edairy.desktop.finance.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.account.AdjustmentTransaction;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.finance.ui.controllers.AdjustmentTransactionEditController;
import com.agritrace.edairy.desktop.finance.ui.controls.AdjustmentTransactionEditPanel;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class AdjustmentTransactionEditDialog extends RecordDialog<AdjustmentTransaction> {
	@Inject
	public AdjustmentTransactionEditDialog(@Named("current") final Shell parentShell,
			final AdjustmentTransactionEditController controller) {
		super(parentShell, controller);
	}

	@Override
	protected void buildWorkArea(Composite comp) {
		new AdjustmentTransactionEditPanel(comp, SWT.NONE);
	}
}
