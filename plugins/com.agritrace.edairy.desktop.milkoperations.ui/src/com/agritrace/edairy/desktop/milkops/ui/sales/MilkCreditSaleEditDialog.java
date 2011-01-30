package com.agritrace.edairy.desktop.milkops.ui.sales;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class MilkCreditSaleEditDialog extends RecordDialog<DeliveryJournal> {
	@Inject
	public MilkCreditSaleEditDialog(@Named("current") final Shell parentShell,
			final MilkCreditSaleEditDialogController controller) {
		super(parentShell, controller);
	}

	@Override
	protected void buildWorkArea(Composite comp) {
		new MilkCreditSaleEditPanel(comp, SWT.None);
	}
}
