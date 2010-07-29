package com.agritrace.edairy.desktop.install.handlers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.riena.ui.core.uiprocess.UIProcess;
import org.eclipse.ui.handlers.HandlerUtil;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.install.EmployeeImportTool;
import com.agritrace.edairy.desktop.install.ValidationException;
import com.agritrace.edairy.desktop.install.dialogs.ImportResultsDialog;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ImportEmployeesHandler extends HandlerBase {

	private class EmployeeImportProcess extends UIProcess {
		final File importFile;
		final int lineCount;
		private List<String> msgList;
		private List<Employee> successes;
		private Map<String, List<String[]>> errors;

		public EmployeeImportProcess(File importFile, int lineCount,
				Object navigationNode) {
			super("Import Employees", true, navigationNode);
			this.importFile = importFile;
			this.lineCount = lineCount;
			
			msgList = new LinkedList<String>();
			successes = new LinkedList<Employee>();
			errors = new HashMap<String, List<String[]>>();
		}

		@Override
		public void initialUpdateUI(int totalWork) {
			super.initialUpdateUI(totalWork);
		}

		@Override
		public void finalUpdateUI() {
			boolean importEnabled = successes.size() > 0;
			ImportResultsDialog irDialog = new ImportResultsDialog(
					HandlerUtil.getActiveShell(event), msgList, importEnabled);
			if (irDialog.open() == Dialog.OK) {
				saveEmployees(successes);
			}
		}

		@Override
		public boolean runJob(IProgressMonitor monitor) {
			InputStream input = null;
			try {
				monitor.beginTask("Member Import", lineCount);
				monitor.subTask("Reading input file...");

				input = new BufferedInputStream(new FileInputStream(importFile));

				monitor.subTask("Importing records...");
				try {
					new EmployeeImportTool(input, successes, errors, monitor)
						.processFile();
					msgList.add(String.format(
							"%-4d records imported successfully.", successes.size()));
					for (String err : errors.keySet()) {
						msgList.add(String.format(
								"%-4d records failed with a '%s' error.", errors
										.get(err).size(), err));
					}
					monitor.setTaskName("Saving members...");
				}
				catch(ValidationException ve) {
					msgList.add(String.format(
							"Import failed with message: '%s'", ve.getMessage()));
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			} finally {
				monitor.done();
				if (input != null) {
					try {
						input.close();
					} catch (IOException ioe) {
						;
					}
				}
			}

			return true;
		}
		
		private void saveEmployees(List<Employee> successes2) {
			DairyRepository.getInstance().getLocalDairy().getEmployees()
					.addAll(successes2);
			DairyRepository.getInstance().save();
		}



	}

	private ExecutionEvent event;

	/**
	 * The constructor.
	 */
	public ImportEmployeesHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		this.event = event;
		Object navigationContext = getNavigationContext(event);

		try {
			File importFile = new File(getImportFile(event));
			int lineCount = countLines(importFile);

			UIProcess process = new EmployeeImportProcess(importFile,
					lineCount, navigationContext);
			// job.setProperty(UIProcess.PROPERTY_CONTEXT, navigationContext);
			// job.setUser(true);// to be visualized the job has to be user
			// job.schedule();
			process.setTitle("Import Employees");
			process.setNote("Importing...");
			process.start();

		} catch (Exception e) {
			throw new ExecutionException("Import operation failed.", e);
		}
		return null;
	}

}
