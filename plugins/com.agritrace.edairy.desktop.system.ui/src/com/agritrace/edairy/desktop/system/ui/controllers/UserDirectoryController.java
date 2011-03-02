package com.agritrace.edairy.desktop.system.ui.controllers;

import java.util.List;

import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Role;
import com.agritrace.edairy.desktop.common.model.base.SystemUser;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission;
import com.agritrace.edairy.desktop.common.persistence.FilterParameter;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.views.BaseListView;
import com.agritrace.edairy.desktop.system.ui.dialogs.UserDialog;
import com.agritrace.edairy.desktop.system.ui.dialogs.UserDialogController;
import com.google.inject.Inject;

@PermissionRequired(UIPermission.VIEW_ROLES)
public final class UserDirectoryController extends BasicDirectoryController<SystemUser> {

	public UserDirectoryController() {
		super();
		setEClass(ModelPackage.Literals.SYSTEM_USER);
		addTableColumn("Name", ModelPackage.Literals.SYSTEM_USER__USERNAME);
		addTableColumn("Role", ModelPackage.Literals.SYSTEM_USER__ROLE.getName() + "."
				+ ModelPackage.Literals.ROLE__NAME.getName(), String.class);
	}

	@Inject
	@Override
	public void setRepository(IRepository<SystemUser> myRepo) {
		super.setRepository(myRepo);
	}

	@Override
	protected String getFullTitle() {
		return "System Users";
	}

	@Override
	protected void configureFilterRidgets() {
		getRidget(IActionRidget.class, BaseListView.BIND_ID_FILTER_SEARCH).setVisible(false);
		getRidget(IActionRidget.class, BaseListView.BIND_ID_FILTER_RESET).setVisible(false);
	}

	@Override
	protected List<SystemUser> getFilteredResult() {
		return getRepository().all();
	}

	@Override
	protected RecordDialog<SystemUser> getRecordDialog(Shell shell) {
		UserDialogController controller = new UserDialogController();
		controller.setEmployeeList(getRepository().filter(Employee.class, new FilterParameter[0]));
		controller.setRoleList(getRepository().filter(Role.class, new FilterParameter[0]));
		UserDialog dialog = new UserDialog(getShell(), controller);
		return dialog;
	}

	@Override
	protected void resetFilterConditions() {
		// TODO:
	}
}
