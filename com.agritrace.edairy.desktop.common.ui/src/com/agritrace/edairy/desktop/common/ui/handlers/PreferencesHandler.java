package com.agritrace.edairy.desktop.common.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.common.ui.dialogs.PreferencesDialog;

public class PreferencesHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		new PreferencesDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell()).open();
		return null;
	}
}
