package com.agritrace.edairy.desktop.collection.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.collection.ui.components.DeliveryJournalEditPanel;
import com.agritrace.edairy.desktop.collection.ui.controllers.MilkDeliveryJournalEditController;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class DeliveryJournalEditDialog extends RecordDialog<DeliveryJournal> {
	@Inject
	public DeliveryJournalEditDialog(@Named("current") final Shell parentShell,
			final MilkDeliveryJournalEditController controller) {
		super(parentShell, controller);
	}

	@Override
	protected void buildWorkArea(Composite comp) {
		new DeliveryJournalEditPanel(comp, SWT.None);
	}
}
