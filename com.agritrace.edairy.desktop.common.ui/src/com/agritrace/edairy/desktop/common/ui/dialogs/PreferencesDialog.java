package com.agritrace.edairy.desktop.common.ui.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public final class PreferencesDialog extends TitleAreaDialog {
	public PreferencesDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createContents(Composite parent) {
		final Control contents = super.createContents(parent);
		setTitle("Preferences");
		setMessage("User and system configuration");
		return contents;
	}
}
