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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.core.uiprocess.UIProcess;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.install.RouteImportTool;
import com.agritrace.edairy.desktop.install.VehicleImportTool;
import com.agritrace.edairy.desktop.install.dialogs.ImportResultsDialog;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ImportVehiclesHandler extends HandlerBase {
	ExecutionEvent event;

	private class VehicleImportProcess extends UIProcess {
		final File importFile;
		final int lineCount;
		private List<String> msgList;
		private List<Vehicle> vehicles;
		private Map<String, List<String[]>> errors;

		public VehicleImportProcess(File importFile, int lineCount,
				Object navigationNode) {
			super("Import Members", true, navigationNode);
			this.importFile = importFile;
			this.lineCount = lineCount;
			msgList = new LinkedList<String>();
		}

		@Override
		public void initialUpdateUI(int totalWork) {
			super.initialUpdateUI(totalWork);
		}

		@Override
		public void finalUpdateUI() {
			boolean importEnabled = vehicles.size() > 0;
			ImportResultsDialog irDialog = new ImportResultsDialog(
					HandlerUtil.getActiveShell(event), msgList, importEnabled);
			if (irDialog.open() == Dialog.OK) {
				saveVehicles(vehicles);
			}
		}

		@Override
		public boolean runJob(IProgressMonitor monitor) {
			InputStream input = null;
			try {
				monitor.beginTask("Routes Import", lineCount);
				monitor.subTask("Reading input file...");

				input = new BufferedInputStream(new FileInputStream(importFile));

				monitor.subTask("Importing records...");
				
				vehicles = new LinkedList<Vehicle>();
				errors = new HashMap<String, List<String[]>>();

				VehicleImportTool tool = new VehicleImportTool(input, vehicles, errors, monitor);
//				tool.setMonitorDelta(lineCount / 2);
				tool.processFile();

				msgList.add(String.format(
						"%-4d records imported successfully.", vehicles.size()));
				for (String err : errors.keySet()) {
					msgList.add(String.format(
							"%-4d records failed with a '%s' error.", errors
									.get(err).size(), err));
				}
				monitor.setTaskName("Saving members...");

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

		private void saveVehicles(List<Vehicle> successes2) {
			DairyRepository.getInstance().getLocalDairy().getVehicles()
					.addAll(successes2);
			DairyRepository.getInstance().save();
		}

	}	/**
	 * The constructor.
	 */
	public ImportVehiclesHandler() {
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
			UIProcess process = new VehicleImportProcess(importFile, lineCount,
					navigationContext);

			process.setTitle("Import Vehicles");
			process.setNote("Importing...");
			process.start();
		} catch (Exception e) {
			throw new ExecutionException("Import operation failed.", e);
		}
		return null;
	}
}
