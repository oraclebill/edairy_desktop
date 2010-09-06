package com.agritrace.edairy.desktop.system.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.Role;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.system.ui.constants.RoleBinding;
import com.agritrace.edairy.desktop.system.ui.controllers.RoleDialogController;

public final class RoleEditDialog extends RecordDialog<Role> {
	public RoleEditDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void buildWorkArea(Composite parent) {
		final Composite contentArea = UIControlsFactory.createComposite(parent);
		contentArea.setLayout(new GridLayout(1, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).minSize(500, 0).applyTo(contentArea);
		
		final Composite editPanel = UIControlsFactory.createComposite(contentArea);
		editPanel.setLayout(new GridLayout(2, false));
		final GridDataFactory factory = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true);
		factory.applyTo(editPanel);

		UIControlsFactory.createLabel(editPanel, "Name");
		final Text txtName = UIControlsFactory.createText(editPanel);
		factory.applyTo(txtName);
		addUIControl(txtName, RoleBinding.BIND_ID_ROLE_NAME.name());

		UIControlsFactory.createLabel(editPanel, "Description");
		final Text txtDescription = UIControlsFactory.createText(editPanel, SWT.MULTI);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).minSize(0, 60).applyTo(txtDescription);
		addUIControl(txtDescription, RoleBinding.BIND_ID_ROLE_DESCRIPTION.name());
		
		// Permission editing area
		
		final Composite permPanel = UIControlsFactory.createComposite(contentArea);
		permPanel.setLayout(new GridLayout(3, false));
		factory.applyTo(permPanel);
		
		final Composite permLeft = UIControlsFactory.createComposite(permPanel);
		permLeft.setLayout(new GridLayout(1, false));
		factory.applyTo(permLeft);
		
		final GridDataFactory vSqueezedFactory = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false);
		final GridDataFactory hSqueezedFactory = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(false, true);
		
		UIControlsFactory.createLabel(permLeft, "Group");
		final Combo nsCombo = UIControlsFactory.createCombo(permLeft, RoleBinding.NAMESPACE_COMBO.name());
		vSqueezedFactory.applyTo(nsCombo);
		
		UIControlsFactory.createLabel(permLeft, "Permission");
		final List permList = UIControlsFactory.createList(permLeft, false, true, RoleBinding.PERMISSION_LIST.name());
		factory.applyTo(permList);

		final Composite permMiddle = UIControlsFactory.createComposite(permPanel);
		permMiddle.setLayout(new GridLayout(1, false));
		hSqueezedFactory.applyTo(permMiddle);
		
		hSqueezedFactory.applyTo(UIControlsFactory.createLabel(permMiddle, ""));
		UIControlsFactory.createButton(permMiddle, ">>", RoleBinding.ADD_BUTTON.name());
		UIControlsFactory.createButton(permMiddle, "<<", RoleBinding.REMOVE_BUTTON.name());
		hSqueezedFactory.applyTo(UIControlsFactory.createLabel(permMiddle, ""));

		final Composite permRight = UIControlsFactory.createComposite(permPanel);
		permRight.setLayout(new GridLayout(1, false));
		factory.applyTo(permRight);
		
		UIControlsFactory.createLabel(permRight, "Selected Permissions");
		final Table permTable = UIControlsFactory.createTable(permRight, SWT.BORDER | SWT.SINGLE,
				RoleBinding.BIND_ID_ROLE_PERMISSIONS.name());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).minSize(0, 200).applyTo(permTable);
	}

	@Override
	protected AbstractWindowController createController() {
		return new RoleDialogController();
	}

}
