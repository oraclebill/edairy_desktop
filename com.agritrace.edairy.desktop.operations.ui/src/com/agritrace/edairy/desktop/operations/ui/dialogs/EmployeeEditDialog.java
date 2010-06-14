package com.agritrace.edairy.desktop.operations.ui.dialogs;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.operations.ui.controllers.EmployeeEditDialogController;

public class EmployeeEditDialog extends RecordDialog<Employee, EmployeeEditDialogController> {

	public EmployeeEditDialog(Shell shell) {
		super(shell);
	}

	@Override
	protected EmployeeEditDialogController createController() {
		return new EmployeeEditDialogController();
	}

	@Override
	protected void buildWorkArea(Composite comp) {
		// TODO Auto-generated method stub		
	}

}
