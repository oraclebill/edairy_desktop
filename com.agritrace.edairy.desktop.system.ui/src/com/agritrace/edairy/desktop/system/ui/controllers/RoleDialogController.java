package com.agritrace.edairy.desktop.system.ui.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget.SelectionType;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Role;
import com.agritrace.edairy.desktop.common.model.dairy.security.Namespace;
import com.agritrace.edairy.desktop.common.model.dairy.security.Permission;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.system.ui.constants.RoleBinding;
import com.agritrace.edairy.desktop.system.ui.util.ListMultiSelectionHolder;
import com.agritrace.edairy.desktop.system.ui.util.ListSelectionHolder;
import com.google.inject.Inject;

public final class RoleDialogController extends RecordDialogController<Role> {
	private Map<Namespace, Set<Permission>> perms;
	private ListSelectionHolder<Namespace> nsList;
	private ListMultiSelectionHolder<Permission> permList;
	private List<Permission> selectedModelPermissions = new ArrayList<Permission>();
	
	@Inject
	public RoleDialogController() {}
	
	@Override
	protected void configureUserRidgets() {
		perms = new EnumMap<Namespace, Set<Permission>>(Namespace.class);
		
		for (Permission perm: Permission.values()) {
			Set<Permission> set = perms.get(perm.getNamespace());
			
			if (set == null) {
				set = EnumSet.of(perm);
				perms.put(perm.getNamespace(), set);
			} else {
				set.add(perm);
			}
		}
		
		nsList = ListSelectionHolder.create(Arrays.asList(Namespace.values()));
		permList = ListMultiSelectionHolder.create(null);
		final Role workingCopy = getWorkingCopy();
		
		getWindowRidget().setTitle(workingCopy.getId() == null ? "Add Role" : "Edit Role");
		
		addTextMap(RoleBinding.BIND_ID_ROLE_NAME.name(), DairyPackage.Literals.ROLE__NAME);
		getRidget(ITextRidget.class, RoleBinding.BIND_ID_ROLE_NAME.name()).setMandatory(true);
		addTextMap(RoleBinding.BIND_ID_ROLE_DESCRIPTION.name(), DairyPackage.Literals.ROLE__DESCRIPTION);
		
		final IComboRidget nsCombo = getRidget(IComboRidget.class, RoleBinding.NAMESPACE_COMBO.name());
		nsCombo.bindToModel(nsList, "list", Namespace.class, null /* toString */, nsList, "selected");
		
		final IListRidget permListRidget = getRidget(IListRidget.class, RoleBinding.PERMISSION_LIST.name());
		permListRidget.bindToModel(permList, "list", Permission.class, new String[] { null }, null);
		permListRidget.setSelectionType(SelectionType.MULTI);
		permListRidget.bindMultiSelectionToModel(permList, "selected");
		
		nsCombo.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				permList.getSelected().clear();
				permList.replaceContents(perms.get(nsList.getSelected()));
				permListRidget.updateFromModel();
			}
		});
		
		final ITableRidget permTable = getRidget(ITableRidget.class, RoleBinding.BIND_ID_ROLE_PERMISSIONS.name());
		permTable.bindToModel(workingCopy, "permissions", Permission.class,
				new String[] { "namespace", "displayName" }, new String[] { "Group", "Permission" });
		permTable.setSelectionType(SelectionType.MULTI);
		permTable.bindMultiSelectionToModel(new Object() {
			@SuppressWarnings("unused")
			public List<Permission> getSelected() {
				return selectedModelPermissions;
			}
			
			@SuppressWarnings("unused")
			public void setSelected(List<Permission> selected) {
				selectedModelPermissions = selected;
			}
		}, "selected");
		
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		
		getRidget(IActionRidget.class, RoleBinding.ADD_BUTTON.name()).addListener(new IActionListener() {
			@Override
			public void callback() {
				Collection<Permission> perms = permList.getSelected();
				
				if (!perms.isEmpty()) {
					for (Permission perm: perms) {
						if (!workingCopy.getPermissions().contains(perm)) {
							workingCopy.getPermissions().add(perm);
						}
					}

					permTable.updateFromModel();
				} else {
					MessageDialog.openWarning(shell, "Error", "Please select some permissions to add.");
				}
			}
		});

		getRidget(IActionRidget.class, RoleBinding.REMOVE_BUTTON.name()).addListener(new IActionListener() {
			@Override
			public void callback() {
				if (!selectedModelPermissions.isEmpty()) {
					workingCopy.getPermissions().removeAll(selectedModelPermissions);
					permTable.updateFromModel();
				} else {
					MessageDialog.openWarning(shell, "Error", "Please select some permissions to remove.");
				}
			}
		});
	}
}
