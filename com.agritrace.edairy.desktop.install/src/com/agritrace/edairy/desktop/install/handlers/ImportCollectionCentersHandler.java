package com.agritrace.edairy.desktop.install.handlers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.common.ui.dialogs.ImportResultsDialog;
import com.agritrace.edairy.desktop.install.CollectionCenterImportTool;
import com.agritrace.edairy.desktop.operations.services.dairylocation.IDairyLocationRepository;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ImportCollectionCentersHandler extends HandlerBase {

	ExecutionEvent event;

	private class CollectionCenterImportProcess extends UIProcess {
		final File importFile;
		final int lineCount;
		private List<String> msgList;
		private List<DairyLocation> centers;
		private Map<String, List<String[]>> errors;

		public CollectionCenterImportProcess(File importFile, int lineCount,
				Object navigationNode) {
			super("Import Collection Centers", true, navigationNode);
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
			boolean importEnabled = centers.size() > 0;
			ImportResultsDialog irDialog = new ImportResultsDialog(
					HandlerUtil.getActiveShell(event), msgList, importEnabled);
			if (irDialog.open() == Dialog.OK) {
				saveCenters(centers);
			}
		}

		@Override
		public boolean runJob(IProgressMonitor monitor) {
			InputStream input = null;
			try {
				monitor.beginTask("Collection Centers Import", lineCount);
				monitor.subTask("Reading input file...");

				input = new BufferedInputStream(new FileInputStream(importFile));

				monitor.subTask("Importing records...");
				
				centers = new ArrayList<DairyLocation>();
				errors = new HashMap<String, List<String[]>>();

				CollectionCenterImportTool tool = new CollectionCenterImportTool(input, centers, errors, monitor);
//				tool.setMonitorDelta(lineCount / 2);
				tool.processFile();

				msgList.add(String.format(
						"%-4d records imported successfully.", centers.size()));
				for (String err : errors.keySet()) {
					msgList.add(String.format(
							"%-4d records failed with a '%s' error.", errors
									.get(err).size(), err));
				}
				monitor.setTaskName("Saving collection centers...");

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

		private void saveCenters(List<DairyLocation> successes2) {
			IDairyLocationRepository repo = RepositoryFactory.getRegisteredRepository(IDairyLocationRepository.class);
			repo.saveAll(successes2);
		}

	}

	/**
	 * The constructor.
	 */
	public ImportCollectionCentersHandler() {
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
			UIProcess process = new CollectionCenterImportProcess(importFile, lineCount,
					navigationContext);

			process.setTitle("Import Collection Centers");
			process.setNote("Importing...");
			process.start();
		} catch (Exception e) {
			throw new ExecutionException("Import operation failed.", e);
		}
		return null;
	}
}
