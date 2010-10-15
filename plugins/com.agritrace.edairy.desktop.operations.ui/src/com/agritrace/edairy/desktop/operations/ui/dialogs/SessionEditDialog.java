package com.agritrace.edairy.desktop.operations.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.operations.ui.controllers.SessionEditDialogController;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class SessionEditDialog extends RecordDialog<CollectionSession> {
	@Inject
	public SessionEditDialog(final @Named("current") Shell parentShell, final SessionEditDialogController controller) {
		super(parentShell, controller);
	}

	@Override
	protected void buildWorkArea(Composite panel) {
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(panel);
		GridDataFactory.fillDefaults().hint(350, SWT.DEFAULT).applyTo(panel);

		UIControlsFactory.createLabel(panel, "Code");
		final Text code = UIControlsFactory.createText(panel, SWT.SINGLE, SessionBindingConstants.SESSION_BIND_CODE.name());
		GridDataFactory.fillDefaults().grab(true, true).applyTo(code);

		UIControlsFactory.createLabel(panel, "Description");
		final Text desc = UIControlsFactory.createText(panel, SWT.MULTI, SessionBindingConstants.SESSION_BIND_DESCRIPTION.name());
		GridDataFactory.fillDefaults().grab(true, true).hint(SWT.DEFAULT, 60).applyTo(desc);

		UIControlsFactory.createLabel(panel, "Time of day");
		final DateTime time = UIControlsFactory.createTime(panel, SWT.BORDER | SWT.SHORT, SessionBindingConstants.SESSION_BIND_TIME.name());
		GridDataFactory.fillDefaults().applyTo(time);
	}
}
