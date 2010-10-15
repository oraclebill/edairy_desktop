package com.agritrace.edairy.desktop.collection.ui.dialogs;

import org.eclipse.jface.wizard.Wizard;

public class CollectionJournalWizard extends Wizard {

	public CollectionJournalWizard() {
		setWindowTitle("New Wizard");
	}

	@Override
	public void addPages() {
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
