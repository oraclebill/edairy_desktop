package com.agritrace.edairy.desktop.system.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Role;
import com.agritrace.edairy.desktop.common.model.dairy.security.Permission;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.system.ui.constants.RoleFilterBinding;
import com.agritrace.edairy.desktop.system.ui.dialogs.RoleEditDialog;

@PermissionRequired(Permission.VIEW_ROLES)
public final class RoleDirectoryController extends BasicDirectoryController<Role> {
	private ITextRidget nameSearch;
	private ITextRidget permSearch;
	
	@Override
	protected String getFullTitle() {
		return "Security Roles";
	}
	
	public RoleDirectoryController() {
		super();
		setEClass(DairyPackage.Literals.ROLE);
		setRepository(RepositoryFactory.getRepository(Role.class));
		addTableColumn("ID", DairyPackage.Literals.ROLE__ID);
		addTableColumn("Name", DairyPackage.Literals.ROLE__NAME);
		addTableColumn("Description", DairyPackage.Literals.ROLE__DESCRIPTION);
		addTableColumn("Permissions", DairyPackage.Literals.ROLE__PERMISSIONS, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (!(element instanceof Role))
					return "[error]";
				
				List<Permission> permissions = ((Role) element).getPermissions();
				
				if (permissions == null)
					return "";
				
				StringBuilder sb = new StringBuilder();
				
				for (Permission perm: permissions) {
					if (sb.length() > 0)
						sb.append(" | ");
					
					sb.append(perm.toString());
				}
				
				return sb.toString();
			}
		});
	}

	@Override
	protected void configureFilterRidgets() {
		nameSearch = getRidget(ITextRidget.class, RoleFilterBinding.FILTER_NAME.name());
		permSearch = getRidget(ITextRidget.class, RoleFilterBinding.FILTER_PERMISSION.name());
	}

	@Override
	protected List<Role> getFilteredResult() {
		final List<Role> all = new ArrayList<Role>();
		final String name = nameSearch.getText();
		final String permText = permSearch.getText();
		
		for (Role role: getRepository().all()) {
			if (StringUtils.isEmpty(name) || role.getName().indexOf(name) != -1) {
				if (StringUtils.isEmpty(permText)) {
					all.add(role);
					continue;
				}
				
				for (Permission perm: role.getPermissions()) {
					if (perm.toString().indexOf(permText) != -1) {
						all.add(role);
						break;
					}
				}
			}
		}
		
		return all;
	}

	@Override
	protected RecordDialog<Role> getRecordDialog(Shell shell) {
		return new RoleEditDialog(shell);
	}

	@Override
	protected void resetFilterConditions() {
		nameSearch.setText("");
		permSearch.setText("");
		refreshTableContents();
	}

}
