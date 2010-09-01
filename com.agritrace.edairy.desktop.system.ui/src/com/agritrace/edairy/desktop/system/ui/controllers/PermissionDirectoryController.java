package com.agritrace.edairy.desktop.system.ui.controllers;

import java.util.List;

import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Permission;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.system.ui.dialogs.PermissionEditDialog;

public class PermissionDirectoryController extends BasicDirectoryController<Permission> {
	public PermissionDirectoryController() {
		super();
		setEClass(DairyPackage.Literals.PERMISSION);
		setRepository(RepositoryFactory.getRepository(Permission.class));
		addTableColumn("ID", DairyPackage.Literals.PERMISSION__ID);
		addTableColumn("Namespace", "namespace.name", String.class);
		addTableColumn("Internal Name", DairyPackage.Literals.PERMISSION__NAME);
		addTableColumn("Display Name", DairyPackage.Literals.PERMISSION__DISPLAY_NAME);
	}

	@Override
	protected void configureFilterRidgets() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List<Permission> getFilteredResult() {
		List<Permission> all = getRepository().all();
		return all;
	}

	@Override
	protected RecordDialog<Permission> getRecordDialog(Shell shell) {
		return new PermissionEditDialog(shell);
	}

	@Override
	protected void resetFilterConditions() {
		// TODO Auto-generated method stub
		
	}

}
