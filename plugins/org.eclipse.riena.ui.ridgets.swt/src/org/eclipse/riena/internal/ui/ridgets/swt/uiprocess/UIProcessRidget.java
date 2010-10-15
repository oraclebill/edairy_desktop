/*******************************************************************************
 * Copyright (c) 2007, 2009 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    compeople AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.riena.internal.ui.ridgets.swt.uiprocess;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.riena.ui.core.uiprocess.IProgressVisualizer;
import org.eclipse.riena.ui.core.uiprocess.ProcessInfo;
import org.eclipse.riena.ui.ridgets.AbstractRidget;
import org.eclipse.riena.ui.ridgets.IContextUpdateListener;
import org.eclipse.riena.ui.ridgets.IUIProcessRidget;
import org.eclipse.riena.ui.ridgets.IVisualContextManager;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTRidget;
import org.eclipse.riena.ui.ridgets.uibinding.IBindingPropertyLocator;
import org.eclipse.riena.ui.swt.uiprocess.ICancelListener;
import org.eclipse.riena.ui.swt.uiprocess.UIProcessControl;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;

/**
 * The {@link UIProcessRidget} is not a standard {@link AbstractSWTRidget} as it
 * does not bind a {@link Control} but a {@link UIProcessControl}. Another
 * difference is that it does not hold any detail state of the uiProcessControl.
 */
public class UIProcessRidget extends AbstractRidget implements IUIProcessRidget {

	private UIProcessControl uiProcessControl;
	private final CancelListener cancelListener;
	private final Map<IProgressVisualizer, Progress> visualizerProgress;
	private final Map<Object, VisualizerContainer> contexts;
	private IVisualContextManager contextLocator;
	private boolean focusAble;

	public UIProcessRidget() {
		cancelListener = new CancelListener();
		visualizerProgress = new HashMap<IProgressVisualizer, Progress>();
		contexts = new HashMap<Object, VisualizerContainer>();
	}

	static class ContextDataComparator implements Comparator<VisualizerContainer> {

		public int compare(VisualizerContainer o1, VisualizerContainer o2) {
			int time1 = getVisualizerTime(o1);
			int time2 = getVisualizerTime(o2);
			if (time1 > time2) {
				return -1;
			}
			if (time1 == time2) {
				return 0;
			}
			return 1;
		}

		private int getVisualizerTime(VisualizerContainer data) {
			return data.get(data.getCurrentVisualizer());
		}

	}

	//get the container of the active context if exists
	private VisualizerContainer getActiveContextContainer() {
		List<VisualizerContainer> data = getActiveContextContainerList();
		Collections.sort(data, new ContextDataComparator());
		if (data.size() > 0) {
			return data.get(0);
		}
		return null;
	}

	// get the list of active contexts
	private List<VisualizerContainer> getActiveContextContainerList() {
		List<Object> activeContexts = getActiveContexts();
		List<VisualizerContainer> data = new ArrayList<VisualizerContainer>();
		for (Object object : activeContexts) {
			data.add(contexts.get(object));
		}
		return data;
	}

	private List<Object> getActiveContexts() {
		return getContextLocator().getActiveContexts(new LinkedList<Object>(contexts.keySet()));
	}

	/*
	 * holds the progress of a visualized UiProcess
	 */
	private final static class Progress {
		private int totalWork = -1;
		private int completed = 0;

		private Progress() {
			super();
		}
	}

	private void showProcessing() {
		getUIControl().showProcessing();
	}

	/**
	 * open the window controlled by the ridget
	 */
	public void open() {
		getUIControl().start();
		updateUi();
	}

	/**
	 * close the window controlled by the ridget
	 */
	public void close() {
		getUIControl().stop();
	}

	private class CancelListener implements ICancelListener {

		public void canceled(boolean windowClosed) {
			if (getCurrentVisualizer() != null) {
				cancelCurrentVisualizer(windowClosed);
			}
		}

		private void cancelCurrentVisualizer(boolean windowClosed) {
			if (windowClosed) {
				cancelAllVisualizersInContext();
			} else {
				getCurrentProcessInfo().cancel();
			}
			if (isLonelyVisualizer(getCurrentVisualizer()) && !windowClosed) {
				close();
			}
			removeProgressVisualizer(getCurrentVisualizer());
		}

		private void cancelAllVisualizersInContext() {
			// clean up
			List<VisualizerContainer> activeContextDataList = getActiveContextContainerList();
			for (VisualizerContainer visualizerContextData : activeContextDataList) {
				for (IProgressVisualizer visualizer : visualizerContextData.keySet()) {
					visualizer.getProcessInfo().cancel();
				}
			}
		}

	}

	protected void bindUIControl() {
		if (getUIControl() != null) {
			uiProcessControl.addCancelListener(cancelListener);
		}
	}

	public void setUIControl(Object uiControl) {
		checkUIControl(uiControl);
		unbindUIControl();
		uiProcessControl = (UIProcessControl) uiControl;
		bindUIControl();
	}

	protected void checkUIControl(Object uiControl) {
		AbstractSWTRidget.assertType(uiControl, UIProcessControl.class);

	}

	protected void unbindUIControl() {
		if (getUIControl() != null) {
			getUIControl().removeCancelListener(cancelListener);
		}
	}

	public void addProgressVisualizer(IProgressVisualizer visualizer) {
		Object context = visualizer.getProcessInfo().getContext();
		// is there any contextData for this context? (any other visualizers for
		// the same context?)
		VisualizerContainer contextData = contexts.get(context);
		if (contextData == null) {
			// create Container for context to hold all visualizers for the
			// context
			contextData = new VisualizerContainer();
			contexts.put(context, contextData);
			contextLocator.addContextUpdateListener(contextChangeHandler, context);
		}
		// save when the visualizers was started
		saveVisualizerStartupTime(visualizer, contextData);
		// create the Progress Object to save progress and total work for the
		// visualizer
		createVisualizerProgress(visualizer);
		// observe processInfo changes(description, title, ..)
		observeProcessInfo(visualizer.getProcessInfo());
	}

	private ContextChangeHandler contextChangeHandler = new ContextChangeHandler();

	// saves the bounds of the window whenever the execution context changes
	private class ContextChangeHandler implements IContextUpdateListener {

		public boolean contextUpdated(Object context) {
			checkContexts();
			return false;

		}

		public void beforeContextUpdate(Object context) {
			// save the bounds in all context parts
			List<Object> activeContexts = getActiveContexts();
			for (Object subContext : activeContexts) {
				saveBounds(subContext);
			}

		}

	}

	private void checkContexts() {
		if (getActiveContexts().size() == 0) {
			close();
		} else {

			IProgressVisualizer currentVisualizer = getCurrentVisualizer();

			// if this is a user-job, show the ProgressWindow 
			if (currentVisualizer != null && currentVisualizer.getProcessInfo().isDialogVisible()) {
				open();
				Object currentContext = null;
				for (Entry<Object, VisualizerContainer> entry : contexts.entrySet()) {
					VisualizerContainer container = entry.getValue();
					if (container != null && container.getCurrentVisualizer() == currentVisualizer) {
						currentContext = entry.getKey();
						break;
					}
				}
				if (currentContext != null) {
					getUIControl().getWindow().getShell().setBounds(contexts.get(currentContext).getBounds());
				}
				int progress = getProgress(currentVisualizer).completed;
				if (progress <= 0) {
					showProcessing();
				}
			} else {
				showProcessing();
			}
		}
	}

	/**
	 * @see IProgressVisualizer#finalUpdateUI()
	 */
	public void finalUpdateUI(IProgressVisualizer visualizer) {
		if (!visualizer.getProcessInfo().isDialogVisible()) {
			return;
		}
		// if it�s the only visualizer for the current context: close window
		if (isActive(visualizer) && isLonelyVisualizer(visualizer)) {
			visualizer.getProcessInfo().setIgnoreCancel(true);
			close();
		}

	}

	// is the visualizer the only one?
	private boolean isLonelyVisualizer(IProgressVisualizer visualizer) {
		List<VisualizerContainer> activeContextContainerList = getActiveContextContainerList();
		if (activeContextContainerList.size() == 0) {
			return true;
		}
		int count = 0;
		for (VisualizerContainer visualizerContainer : activeContextContainerList) {
			count += visualizerContainer.size();
			if (count > 1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @see IProgressVisualizer#initialUpdateUI(int)
	 */
	public void initialUpdateUI(IProgressVisualizer visualizer, int totalWork) {
		if (!visualizer.getProcessInfo().isDialogVisible()) {
			return;
		}
		if (isActive(visualizer)) {
			// all this makes sense if the visualizers is part of one of the
			// active contexts
			open();
			showProcessing();
			saveTotalWork(visualizer, totalWork);
			getProgress(visualizer).completed = 0;
			updateUi();
		}
	}

	private void createVisualizerProgress(IProgressVisualizer visualizer) {
		// for progress data (total & completed work)
		visualizerProgress.put(visualizer, new Progress());
	}

	// save the time when tihe visualizer has been first seen 
	private void saveVisualizerStartupTime(IProgressVisualizer visualizer, VisualizerContainer contextData) {
		long time = System.currentTimeMillis();
		contextData.put(visualizer, Integer.valueOf((int) time));
	}

	private void observeProcessInfo(ProcessInfo processInfo) {
		processInfo.addPropertyChangeListener(getProcessInfoListener());
	}

	private PropertyChangeListener processInfoListener;

	private PropertyChangeListener getProcessInfoListener() {
		if (processInfoListener == null) {
			processInfoListener = new ProcessInfoListener();
		}
		return processInfoListener;
	}

	/*
	 * observes the processInfo of a visualizer
	 */
	private class ProcessInfoListener implements PropertyChangeListener {

		public void propertyChange(PropertyChangeEvent evt) {
			ProcessInfo pInfo = ProcessInfo.class.cast(evt.getSource());
			if (isActive(pInfo) && !ProcessInfo.PROPERTY_CANCELED.equals(evt.getPropertyName())) {
				updateUi();
			}
		}

		private boolean isActive(ProcessInfo info) {
			return getCurrentVisualizer() != null && getCurrentVisualizer().getProcessInfo().equals(info);
		}

	}

	/*
	 * the current visualizer is part of the list of active contexts at the
	 * specific point in time. the current visualizer is the last one added to
	 * the merged list of visualizers in all contexts.
	 */
	protected IProgressVisualizer getCurrentVisualizer() {
		VisualizerContainer activeContextContainer = getActiveContextContainer();
		if (activeContextContainer != null) {
			return activeContextContainer.getCurrentVisualizer();
		}
		return null;
	}

	/*
	 * update ui but take care of disposed widgets!
	 */
	private void updateUi() {
		Shell windowShell = getWindowShell();
		if (windowShell != null) {
			windowShell.getDisplay().syncExec(new Runnable() {

				public void run() {
					Shell shell = getUIControl().getWindow().getShell();
					if (shell != null && !shell.isDisposed()) {
						getUIControl().setDescription(getCurrentProcessInfo().getNote());
						getUIControl().setTitle(getCurrentProcessInfo().getTitle());
						// show the progress
						reinitializeProgress();

					}
				}

				private void reinitializeProgress() {
					int progress = visualizerProgress.get(getCurrentVisualizer()).completed;
					if (progress <= -1) {
						showProcessing();
					}
				}
			});
		}
	}

	private Shell getWindowShell() {
		Shell shell = getUIControl().getWindow().getShell();
		return shell;
	}

	// get the info for the current visualizer
	private ProcessInfo getCurrentProcessInfo() {
		return getCurrentVisualizer().getProcessInfo();
	}

	private void saveTotalWork(IProgressVisualizer visualizer, int totalWork) {
		this.visualizerProgress.get(visualizer).totalWork = totalWork;
	}

	/**
	 * cleanly remove the visualizer from the it�s container and udpdate user
	 * interface
	 */
	public void removeProgressVisualizer(IProgressVisualizer visualizer) {
		removeVisualizerFromContextData(visualizer);
		removeVisualizerProgress(visualizer);
		cleanContext();
		if (getCurrentVisualizer() != null) {
			updateUi();
		}
	}

	private void cleanContext() {
		Iterator<VisualizerContainer> contextIter = contexts.values().iterator();
		while (contextIter.hasNext()) {
			VisualizerContainer container = contextIter.next();
			if (container != null && container.size() == 0) {
				contextIter.remove();
			}
		}
	}

	private void removeVisualizerProgress(IProgressVisualizer visualizer) {
		visualizerProgress.remove(visualizer);
	}

	private void removeVisualizerFromContextData(IProgressVisualizer visualizer) {
		Collection<VisualizerContainer> contextDataKeys = contexts.values();
		for (VisualizerContainer contextData : contextDataKeys) {
			contextData.remove(visualizer);
		}
	}

	protected boolean isActive(IProgressVisualizer visualizer) {
		return visualizer != null && visualizer == getCurrentVisualizer();
	}

	/**
	 * @see IProgressVisualizer#updateProgress(int)
	 */
	public void updateProgress(IProgressVisualizer visualizer, int progress) {
		if (!visualizer.getProcessInfo().isDialogVisible()) {
			return;
		}
		saveProgress(visualizer, progress);
		if (isActive(visualizer)) {
			getUIControl().showProgress(getProgress(visualizer).completed, getTotalWork(visualizer));
		}
	}

	// cache the progress of a visualizer
	private void saveProgress(IProgressVisualizer visualizer, int progressValue) {
		Progress progress = getProgress(visualizer);
		if (progress != null) {

			if (ProcessInfo.ProgresStrategy.UNIT.equals(visualizer.getProcessInfo().getProgresStartegy())) {
				progress.completed += progressValue;
			} else {
				progress.completed = progressValue;
			}
		}
	}

	private Progress getProgress(IProgressVisualizer visualizer) {
		return visualizerProgress.get(visualizer);
	}

	private Integer getTotalWork(IProgressVisualizer visualizer) {
		return getProgress(visualizer).totalWork;
	}

	private void saveBounds(Object visualContext) {
		if (visualContext != null) {
			Shell shell = getUIControl().getWindow().getShell();
			if (shell != null) {
				contexts.get(visualContext).setBounds(shell.getBounds());
			}
		}
	}

	public void setContextLocator(IVisualContextManager contextLocator) {
		this.contextLocator = contextLocator;
	}

	public IVisualContextManager getContextLocator() {
		return contextLocator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.riena.ui.ridgets.IRidget#getToolTipText()
	 */
	public String getToolTipText() {
		if (getWindowShell() != null && !getWindowShell().isDisposed() && isFocusable()) {
			return getWindowShell().getToolTipText();
		}
		return ""; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.riena.ui.ridgets.IRidget#getUIControl()
	 */
	public UIProcessControl getUIControl() {
		return uiProcessControl;
	}

	/**
	 * answers true if the dialog window has the focus. otherwise false
	 */

	public boolean hasFocus() {
		if (getWindowShell() != null && !getWindowShell().isDisposed() && isFocusable()) {
			return getWindowShell().isFocusControl();
		}
		return false;
	}

	public boolean isFocusable() {
		return focusAble;
	}

	public void setFocusable(boolean focusable) {
		this.focusAble = focusable;
	}

	/**
	 * answers true if the dialog window is visible. otherwise false
	 */

	public boolean isVisible() {
		if (getWindowShell() != null && !getWindowShell().isDisposed()) {
			return getWindowShell().isVisible();
		}
		return false;
	}

	/**
	 * answers true if the dialog window is enabled. otherwise false
	 */
	public boolean isEnabled() {
		if (getWindowShell() != null && !getWindowShell().isDisposed()) {
			return getWindowShell().isEnabled();
		}
		return false;
	}

	/**
	 * request focus of window
	 */
	public void requestFocus() {
		if (getWindowShell() != null && !getWindowShell().isDisposed() && isFocusable()) {
			getWindowShell().forceFocus();
		}
	}

	public void setToolTipText(String toolTipText) {
		if (getWindowShell() != null && !getWindowShell().isDisposed()) {
			getWindowShell().setToolTipText(toolTipText);
		}
	}

	/**
	 * controls the visibility of the dialog
	 */
	public void setVisible(boolean visible) {
		if (visible) {
			open();
		} else {
			close();
		}
	}

	/**
	 * controls the enabled state of the managed dialog window
	 */
	public void setEnabled(boolean enabled) {
		if (getWindowShell() != null && !getWindowShell().isDisposed()) {
			getWindowShell().setEnabled(enabled);
		}
	}

	public String getID() {
		IBindingPropertyLocator locator = SWTBindingPropertyLocator.getInstance();
		return locator.locateBindingProperty(getUIControl());
	}

}
