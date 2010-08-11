package com.agritrace.edairy.desktop.operations.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public class CustomerDirectoryView extends AbstractDirectoryView {
	public static final String BIND_ID_FILTER_COMPANYNAME = "bind.id.filter.company";

	public static final String BIND_ID_FILTER_CUSTOMERTYPE = "bind.id.filter.categories";

	public static final String BIND_ID_FILTER_STATUS = "bind.id.filter.status";
	public static final String ID = "edairy.operations.customer.directory";

	public CustomerDirectoryView() {
	}

	@Override
	protected void createFilterConditions(Composite parent) {
		final Group filterGroup = UIControlsFactory.createGroup(parent, "Search Criteria");
		filterGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		filterGroup.setLayout(new GridLayout(2, false));
		filterGroup.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		UIControlsFactory.createLabel(filterGroup, "Company Name");
		final Text companyName = UIControlsFactory.createText(filterGroup, SWT.None);
		companyName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(companyName);
		addUIControl(companyName, BIND_ID_FILTER_COMPANYNAME);

		UIControlsFactory.createLabel(filterGroup, "Type");
		final CCombo typeCombo = UIControlsFactory.createCCombo(filterGroup);
		typeCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(typeCombo);
		addUIControl(typeCombo, BIND_ID_FILTER_CUSTOMERTYPE);

		UIControlsFactory.createLabel(filterGroup, "Status");
		final CCombo status = UIControlsFactory.createCCombo(filterGroup);
		status.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(status);
		addUIControl(status, BIND_ID_FILTER_STATUS);
	}

}
