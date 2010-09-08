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

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.common.ui.dialogs.ImportResultsDialog;
import com.agritrace.edairy.desktop.install.MemberTransactionImportTool;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ImportMemberTransactionHandler extends HandlerBase {

	ExecutionEvent event;

	private class TransactionImportProcess extends UIProcess {
		final File importFile;
		final int lineCount;
		private List<String> msgList;
		private List<AccountTransaction> transactions;
		private Map<String, List<String[]>> errors;

		public TransactionImportProcess(File importFile, int lineCount,
				Object navigationNode) {
			super("Import Member Transactions", true, navigationNode);
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
			boolean importEnabled = transactions.size() > 0;
			ImportResultsDialog irDialog = new ImportResultsDialog(
					HandlerUtil.getActiveShell(event), msgList, importEnabled);
			if (irDialog.open() == Dialog.OK) {
				saveTransactions(transactions);
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
				
				transactions = new LinkedList<AccountTransaction>();
				errors = new HashMap<String, List<String[]>>();

				MemberTransactionImportTool tool = new MemberTransactionImportTool(input, transactions, errors, monitor);
//				tool.setMonitorDelta(lineCount / 2);
				tool.processFile();

				msgList.add(String.format(
						"%-4d records imported successfully.", transactions.size()));
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

		private void saveTransactions(List<AccountTransaction> transactions) {
			IRepository<AccountTransaction> accountRepo = RepositoryFactory.getRepository(AccountTransaction.class);
			for (AccountTransaction newEntity : transactions) {
				accountRepo.saveNew(newEntity);
			}
//			DairyRepository.getInstance().save();
		}

	}

	/**
	 * The constructor.
	 */
	public ImportMemberTransactionHandler() {
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
			UIProcess process = new TransactionImportProcess(importFile, lineCount,
					navigationContext);

			process.setTitle("Import Transcations");
			process.setNote("Importing...");
			process.start();
		} catch (Exception e) {
			throw new ExecutionException("Import operation failed.", e);
		}
		return null;
	}
}
