package com.agritrace.edairy.desktop.system.ui.dialogs;

import java.util.List;

import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Role;
import com.agritrace.edairy.desktop.common.model.base.SystemUser;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;

public class UserDialogController extends RecordDialogController<SystemUser> {

	private List<Role> roleList;
	private List<Employee> employeeList;
	
	public UserDialogController() {
		super("SystemUser");
	}

	/* (non-Javadoc)
	 * @see com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController#configureUserRidgets()
	 */
	@Override
	protected void configureUserRidgets() {
		addTextMap(UserDialog.BIND_ID_USERNAME, ModelPackage.Literals.SYSTEM_USER__USERNAME);
		addTextMap(UserDialog.BIND_ID_PASSWORD, ModelPackage.Literals.SYSTEM_USER__PASSWORD);
		addComboMap(UserDialog.BIND_ID_SYSTEMROLE, roleList, "getName", ModelPackage.Literals.SYSTEM_USER__ROLE);
		addComboMap(UserDialog.BIND_ID_EMPLOYEE, employeeList, "getEmployeeNumber", ModelPackage.Literals.SYSTEM_USER__RELATED_EMPLOYEE);
		
		getRidget(IToggleButtonRidget.class, UserDialog.BIND_ID_ENABLE_OS_AUTH).setVisible(false);
		
	}
	

	/* (non-Javadoc)
	 * @see com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController#afterBind()
	 */
	@Override
	public void afterBind() {
		// TODO Auto-generated method stub
		super.afterBind();
	}

	/**
	 * @return the roleList
	 */
	public List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * @param roleList the roleList to set
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * @return the employeeList
	 */
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	/**
	 * @param employeeList the employeeList to set
	 */
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}


}
