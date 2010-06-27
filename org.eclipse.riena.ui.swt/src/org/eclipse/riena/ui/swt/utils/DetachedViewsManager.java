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
package org.eclipse.riena.ui.swt.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.log.LogService;

import org.eclipse.core.runtime.Assert;
import org.eclipse.equinox.log.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.part.ViewPart;

import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.core.util.ReflectionUtils;
import org.eclipse.riena.internal.ui.swt.Activator;

/**
 * Manages one or more "detached" views.
 * <p>
 * Client code must {@link #dispose()} instances when no longer needed.
 */
public class DetachedViewsManager {

	/**
	 * Name of the method that creates the controller for SubModuleViews.
	 */
	private static final String METHOD_CREATE_CONTROLLER = "createController"; //$NON-NLS-1$

	private final static Logger LOGGER = Log4r.getLogger(Activator.getDefault(), DetachedViewsManager.class);

	/**
	 * Maps a String ('id') to a shell instance holding a detached view.
	 */
	private final Map<String, Shell> id2shell;

	/**
	 * The main shell; detached windows use it as their parent shell.
	 */
	private final Shell mainShell;

	/**
	 * Create a new DetachedViewsManager instance.
	 * <p>
	 * Client code must {@link #dispose()} instances when no longer needed.
	 * 
	 * @param site
	 *            the workbench site; never null
	 */
	public DetachedViewsManager(IWorkbenchSite site) {
		this(site.getShell());
	}

	/**
	 * Create a new DetachedViewsManager instance.
	 * <p>
	 * Client code must {@link #dispose()} instances when no longer needed.
	 * 
	 * @param shell
	 *            the main shell; never null; detached windows will use this
	 *            shell as their parent shell
	 */
	public DetachedViewsManager(Shell shell) {
		Assert.isNotNull(shell);
		id2shell = new HashMap<String, Shell>();
		this.mainShell = shell;
	}

	/**
	 * Close (=dispose) thew view / shell with the given id.
	 * 
	 * @param id
	 *            id of the view to show; must be unique within this instance;
	 *            never null
	 */
	public void closeView(String id) {
		Assert.isNotNull(id);
		Shell shell = id2shell.remove(id);
		if (shell != null) {
			if (!shell.isDisposed()) {
				shell.dispose();
			}
		}
	}

	/**
	 * Deallocate resources used by this class. Client code must
	 * {@link #dispose()} instances when no longer needed.
	 */
	public void dispose() {
		String[] keys = id2shell.keySet().toArray(new String[id2shell.size()]);
		for (String id : keys) {
			closeView(id);
		}
	}

	/**
	 * Return the shell hosting the view with the given id
	 * 
	 * @param id
	 *            the view / shell id; never null
	 * @return a Shell instance or null
	 */
	public Shell getShell(String id) {
		Assert.isNotNull(id);
		return id2shell.get(id);
	}

	/**
	 * Hide the view / shell with the given id
	 * 
	 * @param id
	 *            id of the view / shell to hide; never null
	 */
	public void hideView(String id) {
		Assert.isNotNull(id);
		Shell shell = id2shell.get(id);
		if (shell != null) {
			shell.setVisible(false);
		}
	}

	/**
	 * Show the view / shell with the given id. If the given id matches no
	 * shell, then a new shell / view is created using the given viewClazz.
	 * 
	 * @param id
	 *            id of the view / shell to show; must be unique within this
	 *            instance; not tied to the view-part id, since the view is
	 *            created by reflection; never null
	 * @param viewClazz
	 *            the class of the view; must have parameterless constructor;
	 *            never null
	 * @param position
	 *            one of SWT.LEFT, SWT.RIGHT, SWT.TOP, SWT.BOTTOM. Will place
	 *            the view to the specified edge of the main window. Note the
	 *            position prefference is only applied if a new shell is
	 *            created.
	 */
	public void showView(String id, Class<? extends ViewPart> viewClazz, int position) {
		Assert.isNotNull(id, "id"); //$NON-NLS-1$
		Assert.isLegal(id.trim().length() > 0, String.format("id cannot be null or empty: '%s'", id)); //$NON-NLS-1$
		Assert.isNotNull(viewClazz);
		Shell shell = id2shell.get(id);
		if (shell == null) {
			int x;
			int y;
			Rectangle bounds;
			Rectangle viewBounds = this.mainShell.getBounds();
			switch (position) {
			case SWT.RIGHT:
				x = viewBounds.x + viewBounds.width;
				y = viewBounds.y;
				bounds = new Rectangle(x, y, viewBounds.width / 2, viewBounds.height);
				break;
			case SWT.LEFT:
				x = viewBounds.x - (viewBounds.width / 2);
				y = viewBounds.y;
				bounds = new Rectangle(x, y, viewBounds.width / 2, viewBounds.height);
				break;
			case SWT.TOP:
				x = viewBounds.x;
				y = viewBounds.y - (viewBounds.height / 2);
				bounds = new Rectangle(x, y, viewBounds.width, viewBounds.height / 2);
				break;
			case SWT.BOTTOM:
				x = viewBounds.x;
				y = viewBounds.y + viewBounds.height;
				bounds = new Rectangle(x, y, viewBounds.width, viewBounds.height / 2);
				break;
			default:
				throw new IllegalArgumentException("position=" + position); //$NON-NLS-1$
			}
			shell = openShell(viewClazz, bounds);
			if (shell != null) {
				id2shell.put(id, shell);
			}
		} else {
			showShell(shell);
		}
	}

	/**
	 * Show the view / shell with the given id. If the given id matches no
	 * shell, then a new shell / view is created using the given viewClazz.
	 * 
	 * @param id
	 *            id of the view / shell to show; must be unique within this
	 *            instance; not tied to the view-part id, since the view is
	 *            created by reflection
	 * @param viewClazz
	 *            the class of the view; must have parameterless constructor
	 * @param bounds
	 *            the desired size and location for the shell. The {@code x} and
	 *            {@code y} values set the upper left corner of the shell,
	 *            relative to the display. Note that this is applied only if a
	 *            new shell is created.
	 */
	public void showView(String viewId, Class<? extends ViewPart> viewClazz, Rectangle bounds) {
		Shell shell = id2shell.get(viewId);
		if (shell == null) {
			shell = openShell(viewClazz, bounds);
			if (shell != null) {
				id2shell.put(viewId, shell);
			}
		} else {
			showShell(shell);
		}
	}

	// protected methods
	////////////////////

	/**
	 * Determines the style bits for new shell instances created by this class.
	 * <p>
	 * Default value is: {@code SWT.TITLE | SWT.RESIZE}
	 * <p>
	 * Implementors may override to use different style bits. Note that the
	 * close button will be disabled even if you use {@link SWT#CLOSE}.
	 * 
	 * @see http://dev.eclipse.org/newslists/news.eclipse.tools/msg07666.html
	 */
	protected int getShellStyle() {
		return SWT.TITLE | SWT.RESIZE;
	}

	// helping methods
	//////////////////

	private void showShell(Shell shell) {
		shell.setVisible(true);
	}

	private Shell openShell(Class<? extends ViewPart> viewClazz, Rectangle bounds) {
		Shell result = null;

		result = new Shell(this.mainShell, getShellStyle());
		result.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				e.doit = false; // prevent manual close just in case
			}
		});
		try {
			final IViewPart viewPart = ReflectionUtils.newInstance(viewClazz, (Object[]) null);
			viewPart.createPartControl(result);
			result.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					// dispose part when shell is disposed
					viewPart.dispose();
				}
			});
			if (!checkController(viewPart)) {
				String msg = String.format("%s does not override %s()", viewPart.getClass().getName(), //$NON-NLS-1$
						METHOD_CREATE_CONTROLLER);
				LOGGER.log(LogService.LOG_WARNING, msg);
			}
		} catch (Exception exc) {
			// calling unknown code - catch exception just in case
			String msg = "Exception while creating view: " + viewClazz.getName(); //$NON-NLS-1$
			LOGGER.log(LogService.LOG_ERROR, msg, exc);
		}
		result.setBounds(bounds);
		result.open();
		return result;
	}

	/**
	 * Non-API. Package public for testing
	 * 
	 * @return true if the check passed; false otherwise.
	 */
	@SuppressWarnings("rawtypes")
	boolean checkController(IViewPart viewPart) {
		boolean result = true;
		Class clazz = viewPart.getClass();
		Method method = findMethod(clazz, METHOD_CREATE_CONTROLLER);
		if (method != null) {
			String declClazz = method.getDeclaringClass().getName();
			if (declClazz.equals("org.eclipse.riena.navigation.ui.swt.views.SubModuleView")) { //$NON-NLS-1$
				result = false;
			}
		}
		return result;
	}

	/**
	 * Return the first Method matching {@code methodName} or null. Will start
	 * at the most specific class and search upwards.
	 */
	private Method findMethod(final Class<?> viewClazz, String methodName) {
		Method result = null;
		List<Method> declaredMethods = new ArrayList<Method>();
		Class<?> clazz = viewClazz;
		while (clazz != null) {
			declaredMethods.addAll(Arrays.asList(clazz.getDeclaredMethods()));
			clazz = clazz.getSuperclass();
		}
		for (int i = 0; result == null && i < declaredMethods.size(); i++) {
			Method method = declaredMethods.get(i);
			if (methodName.equals(method.getName())) {
				result = method;
			}
		}
		return result;
	}
}
