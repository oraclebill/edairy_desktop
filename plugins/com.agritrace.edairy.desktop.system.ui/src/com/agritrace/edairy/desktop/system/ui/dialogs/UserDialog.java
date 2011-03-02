package com.agritrace.edairy.desktop.system.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.base.SystemUser;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;

public class UserDialog extends RecordDialog<SystemUser> {
	
	private static final String LBL_PREFIX = "label";
	
	public static final String BIND_ID_USERNAME = "USERNAME_TXT";
	public static final String BIND_ID_PASSWORD = "PASSWORD_TXT";
	public static final String BIND_ID_SYSTEMROLE = "SYSTEMROLE_COMBO";
	public static final String BIND_ID_ENABLE_OS_AUTH = "OSAUTH_CK";
	public static final String BIND_ID_EMPLOYEE = "LINKEDEMPLOYEE_COMBO";

	private Text usernameTxt;
	private Text passwordTxt;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public UserDialog(Shell parentShell, UserDialogController controller) {
		super(parentShell, controller);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	@Override
	protected void buildWorkArea(Composite container) {
		container.setLayout(new GridLayout(2, false));
		
		Label lblUsername = UIControlsFactory.createLabel(container, "Username");
		lblUsername.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

		usernameTxt = UIControlsFactory.createText(container, SWT.NONE, BIND_ID_USERNAME);
		usernameTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblPassword = UIControlsFactory.createLabel(container, "Password");
		lblPassword.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

		passwordTxt = new Text(container, SWT.BORDER | SWT.PASSWORD);
		passwordTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		SWTBindingPropertyLocator.getInstance().setBindingProperty(passwordTxt, BIND_ID_PASSWORD);

		Label lblRole = UIControlsFactory.createLabel(container, "Role");
		lblRole.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

		CCombo roleCombo = UIControlsFactory.createCCombo(container, BIND_ID_SYSTEMROLE);
		roleCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblLinkedEmployee = UIControlsFactory.createLabel(container, "Employee ID");
		lblLinkedEmployee.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLinkedEmployee.setText("Linked Employee");

		CCombo linkedEmployeeCombo = UIControlsFactory.createCCombo(container, BIND_ID_EMPLOYEE);
		linkedEmployeeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));		

		Label lblOsAuthentication = UIControlsFactory.createLabel(container, "OS Authentication?", LBL_PREFIX + BIND_ID_ENABLE_OS_AUTH);
		lblOsAuthentication.setText("OS Authentication?");

		Button osAuthBtn = UIControlsFactory.createButtonToggle(container, "", BIND_ID_ENABLE_OS_AUTH);
	}

}
