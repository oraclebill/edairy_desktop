package com.agritrace.edairy.desktop.collection.ui.controllers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;

public class DeliveryJournalEditDialog extends RecordDialog<DeliveryJournal, DeliveryJournalEditController> {

	
	public DeliveryJournalEditDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected DeliveryJournalEditController createController() {
		return new DeliveryJournalEditController();
	}

	@Override
	protected void buildWorkArea(Composite comp) {
		new DeliveryJournalEditPanel(comp, SWT.None);
	}

}
