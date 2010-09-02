package com.agritrace.edairy.desktop.system.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.Permission;
import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.system.ui.Activator;
import com.agritrace.edairy.desktop.system.ui.constants.PermissionBinding;
import com.agritrace.edairy.desktop.system.ui.controllers.PermissionDialogController;

public final class PermissionEditDialog extends RecordDialog<Permission> {
	public PermissionEditDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void buildWorkArea(Composite parent) {
		final Composite contentArea = UIControlsFactory.createComposite(parent);
		contentArea.setLayout(new GridLayout(3, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).minSize(300, 0).applyTo(contentArea);

		final GridDataFactory factory = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1);

		UIControlsFactory.createLabel(contentArea, "Namespace");
		final Text txtNamespace = UIControlsFactory.createText(contentArea);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(txtNamespace);
		addUIControl(txtNamespace, PermissionBinding.BIND_ID_PERMISSION_NAMESPACE_NAME.name());

		final ImageButton lookupButton = UIControlsFactory.createImageButton(contentArea, SWT.NULL,
				PermissionBinding.NAMESPACE_LOOKUP_BUTTON.name());
		lookupButton.setImage(Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.MEMBER_SEARCH_ICON));
		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.FILL).grab(false, false).applyTo(lookupButton);

		UIControlsFactory.createLabel(contentArea, "Internal name");
		final Text txtName = UIControlsFactory.createText(contentArea);
		factory.applyTo(txtName);
		addUIControl(txtName, PermissionBinding.BIND_ID_PERMISSION_NAME.name());

		UIControlsFactory.createLabel(contentArea, "Display name");
		final Text txtDisplayName = UIControlsFactory.createText(contentArea);
		factory.applyTo(txtDisplayName);
		addUIControl(txtDisplayName, PermissionBinding.BIND_ID_PERMISSION_DISPLAYNAME.name());
	}

	@Override
	protected AbstractWindowController createController() {
		return new PermissionDialogController();
	}

}
