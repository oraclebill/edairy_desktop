package com.agritrace.edairy.desktop.common.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import com.agritrace.edairy.desktop.common.ui.dialogs.PreferencesDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class PreferencesHandler extends AbstractHandler {
	@Inject
	private Provider<PreferencesDialog> dialogProvider;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		dialogProvider.get().open();
		return null;
	}
}
