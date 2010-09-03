package com.agritrace.edairy.desktop.system.ui.controllers;

import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Permission;
import com.agritrace.edairy.desktop.common.model.dairy.PermissionNamespace;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.system.ui.constants.PermissionBinding;
import com.agritrace.edairy.desktop.system.ui.dialogs.NamespaceLookupDialog;

public final class PermissionDialogController extends RecordDialogController<Permission> {
	private ITextRidget namespaceName;

	@Override
	protected void configureUserRidgets() {
		namespaceName = getRidget(ITextRidget.class, PermissionBinding.BIND_ID_PERMISSION_NAMESPACE_NAME.name());
		namespaceName.setOutputOnly(true);
		namespaceName.setMandatory(true);
		updateNamespaceName();
		
		addTextMap(PermissionBinding.BIND_ID_PERMISSION_NAME.name(), DairyPackage.Literals.PERMISSION__NAME);
		addTextMap(PermissionBinding.BIND_ID_PERMISSION_DISPLAYNAME.name(), DairyPackage.Literals.PERMISSION__DISPLAY_NAME);
		
		getRidget(ITextRidget.class, PermissionBinding.BIND_ID_PERMISSION_NAME.name()).setMandatory(true);
		getRidget(ITextRidget.class, PermissionBinding.BIND_ID_PERMISSION_DISPLAYNAME.name()).setMandatory(true);
		
		getRidget(IActionRidget.class, PermissionBinding.NAMESPACE_LOOKUP_BUTTON.name()).addListener(new IActionListener() {
			@Override
			public void callback() {
				doNamespaceLookup();
			}
		});
	}
	
	private void updateNamespaceName() {
		final PermissionNamespace namespace = getWorkingCopy().getNamespace();
		namespaceName.setText(namespace == null ? "" : namespace.getName());
	}

	private void doNamespaceLookup() {
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		final NamespaceLookupDialog dlg = new NamespaceLookupDialog(shell);
		
		if (dlg.open() == Window.OK) {
			getWorkingCopy().setNamespace(dlg.getSelectedNamespace());
			updateNamespaceName();
		}
	}
}
