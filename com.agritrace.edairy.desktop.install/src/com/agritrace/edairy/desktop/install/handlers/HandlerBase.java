package com.agritrace.edairy.desktop.install.handlers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ui.swt.views.NavigationViewPart;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public abstract class HandlerBase extends AbstractHandler {

	public HandlerBase() {
		super();
	}

	protected String getImportFile(ExecutionEvent event)
			throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil
				.getActiveWorkbenchWindowChecked(event);
		FileDialog fileDialog = new FileDialog(window.getShell(), SWT.OPEN);
		fileDialog.setFilterExtensions(new String[] { "*.csv", });
		final String importFileName = fileDialog.open();
		return importFileName;
	}

	public static int countLines(File f) throws IOException {
		InputStream is = null;
		int ret = -1;
		try {
			is = new BufferedInputStream(new FileInputStream(f));
			ret = countLines(is);			
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception e) {
			}
		}
		return ret;
	}

	public static int countLines(InputStream is) throws IOException {
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

	protected void displayErrors(Map<String, List<String[]>> errors) {
		for (Map.Entry<String, List<String[]>> entry : errors.entrySet()) {
			System.err.printf("key: %s, value: %s\n", entry.getKey(),
					entry.getValue());
		}
	}

	protected Object getNavigationContext(ExecutionEvent event)
			throws ExecutionException {
		INavigationNode<?> node = null;
		IWorkbenchPart part = HandlerUtil.getActivePartChecked(event);
		SubModuleView view = (SubModuleView) part
				.getAdapter(SubModuleView.class);
		if (view != null) {
			node = view.getNavigationNode();
		}
		if (node == null) {
			NavigationViewPart nvp = (NavigationViewPart) part
					.getAdapter(NavigationViewPart.class);
			if (nvp != null)
				node = nvp.getSubApplicationNode();
		}
		if (node == null) {
			System.err.println("part: " + part);
		}
		return node;
	}

}