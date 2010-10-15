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

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.riena.ui.core.uiprocess.IProgressVisualizer;
import org.eclipse.riena.ui.swt.uiprocess.UIProcessWindow;
import org.eclipse.swt.graphics.Rectangle;

/**
 * A {@link VisualizerContainer} is related to a visual context in the
 * {@link UIProcessRidget}. The container holds all {@link IProgressVisualizer}
 * for the context and the bounds of the {@link UIProcessWindow} in the context.
 * Inside it maps {@link IProgressVisualizer} to their activation time.
 * 
 */
@SuppressWarnings("serial")
class VisualizerContainer extends HashMap<IProgressVisualizer, Integer> {

	private Rectangle bounds;

	/**
	 * determines the visualizer currently active in this container. A
	 * {@link VisualizerContainer} is related to a visual context managed in
	 * {@link UIProcessRidget}
	 * 
	 * @return the active visualizer
	 */
	public IProgressVisualizer getCurrentVisualizer() {
		return getFreshestVisualizer();
	}

	private IProgressVisualizer getFreshestVisualizer() {
		List<IProgressVisualizer> visualizers = new LinkedList<IProgressVisualizer>(keySet());
		// use the comparator
		Collections.sort(visualizers, new VisualizerComparator());
		if (visualizers.size() > 0) {
			// the first one is that with maximum activation time
			return visualizers.get(0);
		}
		return null;
	}

	/**
	 * comparator to order the list of {@link IProgressVisualizer}. The
	 * {@link IProgressVisualizer} with the maximum activation
	 * time(get(visualizer)) is the first one.
	 */
	class VisualizerComparator implements Comparator<IProgressVisualizer> {

		public int compare(IProgressVisualizer o1, IProgressVisualizer o2) {
			Integer time1 = get(o1);
			if (time1 == null) {
				time1 = -1;
			}
			Integer time2 = get(o2);
			if (time2 == null) {
				time2 = -1;
			}
			if (time1 > time2) {
				return -1;
			}
			if (time1.equals(time2)) {
				return 0;
			}

			return 1;
		}
	}

	/**
	 * manage bounds of the {@link UIProcessWindow}
	 */

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public Rectangle getBounds() {
		return bounds;
	}
}
