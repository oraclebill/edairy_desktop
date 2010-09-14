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

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.common.ui.dialogs.ImportResultsDialog;
import com.agritrace.edairy.desktop.install.MemberImportTool;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ImportMembersHandler extends HandlerBase {

	private class MemberImportProcess extends UIProcess {
		final File importFile;
		final int lineCount;
		private List<String> msgList;

		private List<Membership> successes;
		private Map<String, List<String[]>> errors;


		public MemberImportProcess(File importFile, int lineCount,
				Object navigationNode) {
			super("Import Members", true, navigationNode);
			this.importFile = importFile;
			this.lineCount = lineCount;

			msgList = new LinkedList<String>();
			successes = new ArrayList<Membership>();
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
				saveMembers(successes);
			}
		}

		@Override
		public boolean runJob(IProgressMonitor monitor) {
			InputStream input = null;
			try {
				monitor.beginTask("Member Import", lineCount);
				setNote("Reading input file...");
				
				
				input = new BufferedInputStream(new FileInputStream(importFile));
				
				setNote("Importing " + lineCount + " members...");
				MemberImportTool tool = new MemberImportTool(input, successes, errors, monitor);
				tool.setMonitorDelta(lineCount / 100);
				tool.processFile();

				msgList.add(String.format("%-4d records imported successfully.",
						successes.size()));
				for (String err : errors.keySet()) {
					msgList.add(String.format("%-4d records failed with a '%s' error.",
							errors.get(err).size(), err));
				}
				setNote("Saving members...");

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
		
		private void saveMembers(List<Membership> successes2) {
			RepositoryFactory.getDairyRepository().getLocalDairy().getMemberships()
					.addAll(successes2);
			RepositoryFactory.getDairyRepository().save();
		}
	}
	
	private ExecutionEvent event;

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
		// create a file dialog to get the filename..
		this.event = event;

		try {

			//			final Job job = new Job("Import Members") { //$NON-NLS-1$
			// @Override
			// public IStatus run(final IProgressMonitor monitor) {
			// return doImport(importFileName, monitor);
			// }
			// };

			Object navigationContext = getNavigationContext(event);
			File importFile = new File(getImportFile(event));
			int lineCount = countLines(importFile);
			UIProcess process = new MemberImportProcess(importFile, lineCount,
					navigationContext);
			// job.setProperty(UIProcess.PROPERTY_CONTEXT, navigationContext);
			// job.setUser(true);// to be visualized the job has to be user
			// job.schedule();
			process.setTitle("Import Members");
			process.setNote("Importing...");
			process.start();

		} catch (Exception e) {
			throw new ExecutionException("Import operation failed.", e);
		}
		// MessageDialog.openInformation(window.getShell(), "Status",
		// "Import completed successfully");
		return null;
	}



}
