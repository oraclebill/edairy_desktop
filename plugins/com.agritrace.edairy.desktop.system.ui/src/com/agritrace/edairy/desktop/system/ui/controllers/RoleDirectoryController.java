package com.agritrace.edairy.desktop.system.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Role;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.system.ui.constants.RoleFilterBinding;
import com.agritrace.edairy.desktop.system.ui.dialogs.RoleEditDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

@PermissionRequired(UIPermission.VIEW_ROLES)
public final class RoleDirectoryController extends BasicDirectoryController<Role> {
	private ITextRidget nameSearch;
	private ITextRidget permSearch;
	
	@Inject
	Provider<RoleEditDialog> dialogProvider;
	
	@Override
	protected String getFullTitle() {
		return "Security Roles";
	}

	@Inject
	public RoleDirectoryController() {
		super();
//		this.dialogProvider = dialogProvider;
		setEClass(ModelPackage.Literals.ROLE);
		addTableColumn("ID", ModelPackage.Literals.ROLE__ID);
		addTableColumn("Name", ModelPackage.Literals.ROLE__NAME);
		addTableColumn("Description", ModelPackage.Literals.ROLE__DESCRIPTION);
		addTableColumn("Permissions", ModelPackage.Literals.ROLE__PERMISSIONS, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (!(element instanceof Role)) {
					return "[error]";
				}

				final List<UIPermission> permissions = ((Role) element).getPermissions();

				if (permissions == null) {
					return "";
				}

				final StringBuilder sb = new StringBuilder();

				for (final UIPermission perm: permissions) {
					if (sb.length() > 0) {
						sb.append(" | ");
					}

					sb.append(perm.toString());
				}

				return sb.toString();
			}
		});
	}

	
	/* (non-Javadoc)
	 * @see com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController#setRepository(com.agritrace.edairy.desktop.common.persistence.IRepository)
	 */
	@Inject
	public void setRepository(IRepository<Role> myRepo) {
		// TODO Auto-generated method stub
		super.setRepository(myRepo);
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

		for (final Role role: getRepository().all()) {
			if (StringUtils.isEmpty(name) || role.getName().indexOf(name) != -1) {
				if (StringUtils.isEmpty(permText)) {
					all.add(role);
					continue;
				}

				for (final UIPermission perm: role.getPermissions()) {
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
		return dialogProvider.get();
	}

	@Override
	protected void resetFilterConditions() {
		nameSearch.setText("");
		permSearch.setText("");
		refreshTableContents();
	}
	
//	@Override
//	public void refreshTableContents() {
//		// TODO: Figure out a way to implement the dialog safely
//		refreshTableContentsSafe();
//	}

}
