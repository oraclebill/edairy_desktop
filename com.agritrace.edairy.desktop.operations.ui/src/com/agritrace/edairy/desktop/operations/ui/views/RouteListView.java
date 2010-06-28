package com.agritrace.edairy.desktop.operations.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public class RouteListView extends AbstractDirectoryView {

	public static final String ID = "route-list-view";

	public static final String BIND_ID_FILTER_NAME = "name-filter-txt";
	public static final String BIND_ID_FILTER_DESC = "description-filter-txt";

	@Override
	protected void createFilterPanel(Composite parent) {
		parent.setLayout(GridLayoutFactory.swtDefaults().margins(0, 0)
				.numColumns(2).create());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(parent);

		// Route name
		UIControlsFactory.createLabel(parent, "Name");
		Text routeName = UIControlsFactory.createText(parent, SWT.None);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(routeName);
		addUIControl(routeName, BIND_ID_FILTER_NAME);

		// Route description
		UIControlsFactory.createLabel(parent, "Description");
		Text routeDesc = UIControlsFactory.createText(parent, SWT.None);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(routeDesc);
		addUIControl(routeDesc, BIND_ID_FILTER_DESC);

//		// Status
//		UIControlsFactory.createLabel(parent, "Status");
//		Combo status = UIControlsFactory.createCombo(parent);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(status);
//		addUIControl(status, BIND_ID_FILTER_STATUS);

	}

}
