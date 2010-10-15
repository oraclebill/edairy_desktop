package com.agritrace.edairy.desktop.system.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.system.ui.constants.RoleFilterBinding;

public final class RoleDirectoryView extends AbstractDirectoryView {
	public static final String ID = "edairy.system.roles.directory";

	@Override
	protected void createFilterConditions(Composite comp) {
		setPartName("Security Roles");

		final Composite parent = UIControlsFactory.createComposite(comp);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(parent);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(parent);

		final Group filterGroup = new Group(parent, SWT.NONE);
		filterGroup.setText("Search Criteria");
		filterGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		filterGroup.setLayout(new GridLayout(2, false));
		filterGroup.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		UIControlsFactory.createLabel(filterGroup, "Name");
		final Text name = UIControlsFactory.createText(filterGroup, SWT.None);
		name.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(name);
		addUIControl(name, RoleFilterBinding.FILTER_NAME.name());

		UIControlsFactory.createLabel(filterGroup, "Permission");
		final Text permission = UIControlsFactory.createText(filterGroup, SWT.None);
		permission.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(name);
		addUIControl(permission, RoleFilterBinding.FILTER_PERMISSION.name());
	}
}
