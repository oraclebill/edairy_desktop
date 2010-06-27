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

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Utility class for sharing of a common timer. We don´t want to have a big
 * number of worker threads.
 */
public class TimerUtil {

	// the common timer instance
	private final static Timer TIMER = new Timer();

	private static Set<TimerTask> tasks = new HashSet<TimerTask>();

	/**
	 * No public constructor for this utility class.
	 */
	private TimerUtil() {
		super();
	}

	public synchronized static void schedule(TimerTask task, int delay, int period) {
		if (tasks.contains(task)) {
			return;
		}
		// the actual task of work
		TIMER.schedule(task, delay, period);

		tasks.add(task);
	}

	public synchronized static void stop(TimerTask task) {
		// stop a specific task
		task.cancel();
		tasks.remove(task);
	}

}
