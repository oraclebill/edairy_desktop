package com.agritrace.edairy.desktop.install.handlers;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.install.MemberImportTool;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ImportMembersHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public ImportMembersHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		FileDialog fileDialog = new FileDialog(window.getShell(), SWT.OPEN | SWT.SHEET);
		fileDialog.setFilterExtensions(new String[] { "*.csv", });
		String importFileName = fileDialog.open();
		
		DairyRepository dairyRepo = DairyRepository.getInstance();
//		Dairy dairy = dairyRepo.getLocalDairy();
		try {
			MemberImportTool importTool = new MemberImportTool(new File(importFileName));
			importTool.processFile();
//			dairyRepo.save(dairy);
		}
		catch(Exception e) {
			throw new ExecutionException("Import operation failed.", e);
		}
		MessageDialog.openInformation(window.getShell(), "Status", "Import completed successgfully");
		return null;
	}
}
