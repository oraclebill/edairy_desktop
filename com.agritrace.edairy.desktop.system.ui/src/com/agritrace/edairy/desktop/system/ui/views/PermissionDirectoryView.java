package com.agritrace.edairy.desktop.system.ui.views;

import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public final class PermissionDirectoryView extends AbstractDirectoryView {
	public static final String ID = "edairy.system.permissions.directory";
	
	@Override
	protected void createFilterButtonPanel(Composite parent) {
		UIControlsFactory.createButton(parent, "Search", BIND_ID_FILTER_SEARCH).setVisible(false);
		UIControlsFactory.createButton(parent, "Reset", BIND_ID_FILTER_RESET).setVisible(false);
	}
}
