package com.agritrace.edairy.desktop.install.handlers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ui.swt.views.NavigationViewPart;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.core.uiprocess.UIProcess;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.hamcrest.core.Is;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.install.MemberImportTool;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ImportMembersHandler extends AbstractHandler {

	private List<Membership> successes;
	private Map<String, List<String[]>> errors;

	/**
	 * The constructor.
	 */
	public ImportMembersHandler() {
		successes = new ArrayList<Membership>();
		errors = new HashMap<String, List<String[]>>();
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		FileDialog fileDialog = new FileDialog(window.getShell(), SWT.OPEN);
		fileDialog.setFilterExtensions(new String[] { "*.csv", });
		final String importFileName = fileDialog.open();

		DairyRepository.getInstance();
		// Dairy dairy = dairyRepo.getLocalDairy();
		try {

			final Job job = new Job("Import Members") { //$NON-NLS-1$
				@Override
				public IStatus run(final IProgressMonitor monitor) {
					return doImport(importFileName, monitor);
				}
			};

			Object navigationContext = getNavigationContext(event);

			job.setProperty(UIProcess.PROPERTY_CONTEXT, navigationContext);
			job.setUser(true);// to be visualized the job has to be user
			job.schedule();

		} catch (Exception e) {
			throw new ExecutionException("Import operation failed.", e);
		}
		// MessageDialog.openInformation(window.getShell(), "Status",
		// "Import completed successfully");
		return null;
	}

	protected IStatus doImport(String importFileName, IProgressMonitor monitor) {
		InputStream is = null;
		File importFile = new File(importFileName);
		try {
			is = new FileInputStream(importFile);
			int lineCount = countLines(new BufferedInputStream(is));
			is.close();
			is = new BufferedInputStream(new FileInputStream(importFile));
			monitor.beginTask("Import " + lineCount + " members from " + importFile, lineCount);
			MemberImportTool importer = new MemberImportTool(is, successes, errors, monitor);
			importer.processFile();
			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}
			if (errors.size() > 0) {
				displayErrors(errors);
			}
			saveMembers(successes);
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return new Status(Status.ERROR, "", e.getMessage(), e);
		} catch (IOException e) {
			e.printStackTrace();
			return new Status(Status.ERROR, "", e.getMessage(), e);
		} finally {
			monitor.done();
			if (is != null) {
				try {
					is.close();
				} catch (IOException ioe) {
					;
				}
			}
		}

		return Status.OK_STATUS;
	}
	
	protected void displayErrors(Map<String, List<String[]>> errors) {
		for (Map.Entry<String, List<String[]>> entry : errors.entrySet()) {
			System.err.printf("key: %s, value: %s\n", entry.getKey(), entry.getValue());
		}
	}

	private void saveMembers(List<Membership> successes2) {
		DairyRepository.getInstance().getLocalDairy().getMemberships().addAll(successes2);
		DairyRepository.getInstance().save();
	}

	protected Object getNavigationContext(ExecutionEvent event) throws ExecutionException {
		INavigationNode<?> node = null;
		IWorkbenchPart part = HandlerUtil.getActivePartChecked(event);
		SubModuleView view = (SubModuleView) part.getAdapter(SubModuleView.class);
		if (view != null) {
			node = view.getNavigationNode();
		}
		if (node == null) {
			NavigationViewPart nvp = (NavigationViewPart) part.getAdapter(NavigationViewPart.class);
			if (nvp != null)
				node = nvp.getSubApplicationNode();
		}
		if (node == null) {
			System.err.println("part: " + part);
		}
		return node;
	}

	protected static int countLines(InputStream is) throws IOException {
		final int CR = '\r', LF = '\n';
		int lineCount = 0, c = 0, lastChar = -1;
		while ((c = is.read()) != -1) {
			if (c == CR) {
				lineCount++;
			} else if (c == LF) {
				if (lastChar != CR) {
					lineCount++;
				}
			}
			lastChar = c;
		}
		return lineCount;
	}

}
