package com.agritrace.edairy.desktop.operations.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public class RouteDirectoryView extends AbstractDirectoryView {

	public static final String BIND_ID_FILTER_DESC = "description-filter-txt";

	public static final String BIND_ID_FILTER_NAME = "name-filter-txt";
	public static final String ID = "edairy.operations.route.directory";

	@Override
	protected void createFilterConditions(Composite top) {
		Composite parent = UIControlsFactory.createComposite(top);
		parent.setLayout(GridLayoutFactory.swtDefaults().margins(0, 0).numColumns(2).create());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(parent);

		// Route name
		UIControlsFactory.createLabel(parent, "Name");
		final Text routeName = UIControlsFactory.createText(parent, SWT.None);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(routeName);
		addUIControl(routeName, BIND_ID_FILTER_NAME);

		// Route description
		UIControlsFactory.createLabel(parent, "Description");
		final Text routeDesc = UIControlsFactory.createText(parent, SWT.None);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(routeDesc);
		addUIControl(routeDesc, BIND_ID_FILTER_DESC);

		// // Status
		// UIControlsFactory.createLabel(parent, "Status");
		// Combo status = UIControlsFactory.createCombo(parent);
		// GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,
		// false).applyTo(status);
		// addUIControl(status, BIND_ID_FILTER_STATUS);

	}

}
