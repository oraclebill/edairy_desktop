package com.agritrace.edairy.desktop.system.ui.controllers;


import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Permission;
import com.agritrace.edairy.desktop.common.model.dairy.PermissionNamespace;
import com.agritrace.edairy.desktop.common.model.dairy.Role;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.system.ui.constants.RoleBinding;
import com.agritrace.edairy.desktop.system.ui.util.ListSelectionHolder;

public final class RoleDialogController extends RecordDialogController<Role> {
	private Map<PermissionNamespace, Set<Permission>> perms;
	private ListSelectionHolder<PermissionNamespace> nsList;
	private ListSelectionHolder<Permission> permList;
	private Permission selectedModelPermission;
	
	private final Object selectedModelPermissionBean = new Object() {
		@SuppressWarnings("unused")
		public Permission getSelected() {
			return selectedModelPermission;
		}
		
		@SuppressWarnings("unused")
		public void setSelected(Permission perm) {
			selectedModelPermission = perm;
		}
	};
	
	@Override
	protected void configureUserRidgets() {
		perms = new TreeMap<PermissionNamespace, Set<Permission>>(new Comparator<PermissionNamespace>() {
			@Override
			public int compare(PermissionNamespace ns1, PermissionNamespace ns2) {
				return ns1.getName().compareTo(ns2.getName());
			}
		});
		
		Comparator<Permission> permComparator = new Comparator<Permission>() {
			@Override
			public int compare(Permission p1, Permission p2) {
				return p1.getDisplayName().compareTo(p2.getDisplayName());
			}
		};
		
		for (Permission perm: RepositoryFactory.getRepository(Permission.class).all()) {
			Set<Permission> set = perms.get(perm.getNamespace());
			
			if (set == null) {
				set = new TreeSet<Permission>(permComparator);
				perms.put(perm.getNamespace(), set);
			}
			
			set.add(perm);
		}
		
		nsList = ListSelectionHolder.create(RepositoryFactory.getRepository(PermissionNamespace.class).all());
		permList = ListSelectionHolder.create(null);
		final Role workingCopy = getWorkingCopy();
		
		addTextMap(RoleBinding.BIND_ID_ROLE_NAME.name(), DairyPackage.Literals.ROLE__NAME);
		getRidget(ITextRidget.class, RoleBinding.BIND_ID_ROLE_NAME.name()).setMandatory(true);
		addTextMap(RoleBinding.BIND_ID_ROLE_DESCRIPTION.name(), DairyPackage.Literals.ROLE__DESCRIPTION);
		
		final IComboRidget nsCombo = getRidget(IComboRidget.class, RoleBinding.NAMESPACE_COMBO.name());
		nsCombo.bindToModel(nsList, "list", PermissionNamespace.class, "getName", nsList, "selected");
		
		final IListRidget permListRidget = getRidget(IListRidget.class, RoleBinding.PERMISSION_LIST.name());
		permListRidget.bindToModel(permList, "list", Permission.class, "displayName");
		permListRidget.bindSingleSelectionToModel(permList, "selected");
		
		nsCombo.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				permList.setSelected(null);
				permList.replaceContents(perms.get(nsList.getSelected()));
				permListRidget.updateFromModel();
			}
		});
		
		final ITableRidget permTable = getRidget(ITableRidget.class, RoleBinding.BIND_ID_ROLE_PERMISSIONS.name());
		permTable.bindToModel(workingCopy, "permissions", Permission.class,
				new String[] { "namespace.name", "displayName" }, new String[] { "Group", "Permission" });
		permTable.bindSingleSelectionToModel(selectedModelPermissionBean, "selected");
		
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		
		getRidget(IActionRidget.class, RoleBinding.ADD_BUTTON.name()).addListener(new IActionListener() {
			@Override
			public void callback() {
				Permission perm = permList.getSelected();
				
				if (perm != null) {
					if (!workingCopy.getPermissions().contains(perm)) {
						workingCopy.getPermissions().add(perm);
						permTable.updateFromModel();
					} else {
						MessageDialog.openError(shell, "Error", "Cannot add permission. This permission is already added.");
					}
				} else {
					MessageDialog.openWarning(shell, "Error", "Please select a permission to add.");
				}
			}
		});

		getRidget(IActionRidget.class, RoleBinding.REMOVE_BUTTON.name()).addListener(new IActionListener() {
			@Override
			public void callback() {
				if (selectedModelPermission != null) {
					workingCopy.getPermissions().remove(selectedModelPermission);
					permTable.updateFromModel();
				} else {
					MessageDialog.openWarning(shell, "Error", "Please select a permission to remove.");
				}
			}
		});
	}
}
