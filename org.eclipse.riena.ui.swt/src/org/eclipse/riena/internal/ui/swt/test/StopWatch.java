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
package org.eclipse.riena.internal.ui.swt.test;

/**
 * Keeps track how much time has passed (in milli seconds).
 * 
 * <pre>
 * StopWatch sw = new StopWatch(&quot;Foobalize&quot;).start();
 * // do foobalize
 * sw.stop();
 * </pre>
 */
public class StopWatch {

	private static int instanceCount;

	private final String name;
	private long start;
	private long stop;

	public StopWatch(String name) {
		synchronized (StopWatch.class) {
			this.name = String.format("%s-%d", name, ++instanceCount); //$NON-NLS-1$
		}
	}

	public StopWatch start() {
		start = System.currentTimeMillis();
		return this;
	}

	public long stop() {
		if (start == 0) {
			throw new IllegalStateException("not started"); //$NON-NLS-1$
		}
		stop = System.currentTimeMillis();
		long result = stop - start;
		System.out.println(toString(stop));
		start = 0;
		return result;
	}

	public void split() {
		if (start == 0) {
			throw new IllegalStateException("not started"); //$NON-NLS-1$
		}
		System.out.println(toString(System.currentTimeMillis()) + " (split)"); //$NON-NLS-1$
	}

	// helping methods
	//////////////////

	private String toString(long stopTime) {
		return String.format("[%s] %s: %d ms", StopWatch.class.getSimpleName(), name, stopTime - start); //$NON-NLS-1$
	}

}
