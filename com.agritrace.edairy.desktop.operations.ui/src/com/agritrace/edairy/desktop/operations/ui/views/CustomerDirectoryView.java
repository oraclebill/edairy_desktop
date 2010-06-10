package com.agritrace.edairy.desktop.operations.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;

public class CustomerDirectoryView extends AbstractRecordListView {

	public static final String ID = "edairy.operations.customer.directory";

	public static final String BIND_ID_FILTER_CUSTOMERTYPE = "bind.id.filter.categories";
	public static final String BIND_ID_FILTER_COMPANYNAME = "bind.id.filter.company";
	public static final String BIND_ID_FILTER_STATUS = "bind.id.filter.status";

	@Override
	protected void createFilterConditions(Composite parent) {
		parent.setLayout(GridLayoutFactory.swtDefaults().margins(0, 0)
				.numColumns(2).create());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(parent);

		// Categories
		UIControlsFactory.createLabel(parent, "Type");

		CCombo typeCombo = UIControlsFactory.createCCombo(parent);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(typeCombo);
		addUIControl(typeCombo, BIND_ID_FILTER_CUSTOMERTYPE);

		// Company name
		UIControlsFactory.createLabel(parent, "Company Name");
		Text companyName = UIControlsFactory.createText(parent, SWT.None);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(companyName);
		addUIControl(companyName, BIND_ID_FILTER_COMPANYNAME);

		// Status
		UIControlsFactory.createLabel(parent, "Status");
		Combo status = UIControlsFactory.createCombo(parent);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(status);
		addUIControl(status, BIND_ID_FILTER_STATUS);

	}

}
