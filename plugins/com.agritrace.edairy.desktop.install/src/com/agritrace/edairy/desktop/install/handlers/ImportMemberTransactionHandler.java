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
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.core.uiprocess.UIProcess;
import org.eclipse.ui.handlers.HandlerUtil;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.ui.dialogs.ImportResultsDialog;
import com.agritrace.edairy.desktop.install.MemberTransactionImportTool;
import com.google.inject.Inject;
import com.google.inject.Provider;

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
		private final List<String> msgList;
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
			final boolean importEnabled = transactions.size() > 0;
			final ImportResultsDialog irDialog = new ImportResultsDialog(
					HandlerUtil.getActiveShell(event), msgList, importEnabled);
			if (irDialog.open() == Window.OK) {
				saveTransactions(transactions);
			}
		}

		@Override
		public boolean runJob(IProgressMonitor monitor) {
			InputStream input = null;
			try {
				monitor.beginTask("Transport Routes Import", lineCount);
				monitor.subTask("Reading input file...");

				input = new BufferedInputStream(new FileInputStream(importFile));

				monitor.subTask("Importing records...");

				transactions = new LinkedList<AccountTransaction>();
				errors = new HashMap<String, List<String[]>>();

				final MemberTransactionImportTool tool = toolProvider.get();
				tool.processFile(input, transactions, errors, monitor);

				msgList.add(String.format(
						"%-4d records imported successfully.", transactions.size()));
				for (final String err : errors.keySet()) {
					msgList.add(String.format(
							"%-4d records failed with a '%s' error.", errors
									.get(err).size(), err));
				}
				monitor.setTaskName("Saving members...");

			} catch (final FileNotFoundException e) {
				e.printStackTrace();
				return false;
			} catch (final IOException e) {
				e.printStackTrace();
				return false;
			} finally {
				monitor.done();
				if (input != null) {
					try {
						input.close();
					} catch (final IOException ioe) {
						;
					}
				}
			}

			return true;
		}

		private void saveTransactions(List<AccountTransaction> transactions) {
			final IRepository<AccountTransaction> transactionRepo = accountRepo.get();
			transactionRepo.save(transactions);
//			for (AccountTransaction newEntity : transactions) {
//				transactionRepo.saveNew(newEntity);
//			}
//			RepositoryFactory.getDairyRepository().save();
		}

	}

	@Inject private static Provider<MemberTransactionImportTool> toolProvider;
	@Inject private static Provider<IRepository<AccountTransaction>> accountRepo;

	/**
	 * The constructor.
	 */
	public ImportMemberTransactionHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		this.event = event;

		final Object navigationContext = getNavigationContext(event);
		try {

			final File importFile = new File(getImportFile(event));
			final int lineCount = countLines(importFile);
			final UIProcess process = new TransactionImportProcess(importFile, lineCount,
					navigationContext);

			process.setTitle("Import Transcations");
			process.setNote("Importing...");
			process.start();
		} catch (final Exception e) {
			throw new ExecutionException("Import operation failed.", e);
		}
		return null;
	}
}
