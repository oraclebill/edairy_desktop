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
package org.eclipse.riena.ui.swt;

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import org.eclipse.riena.ui.swt.lnf.IgnoreLnFUpdater;
import org.eclipse.riena.ui.swt.lnf.LnFUpdater;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;

/**
 * This composite presents a list of single or multiple choices. It is mapped to
 * a {@link org.eclipse.riena.ui.ridgets.ISingleChoiceRidget} or
 * {@link org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget}.
 */
@IgnoreLnFUpdater("background")
public class ChoiceComposite extends Composite {

	private final boolean isMulti;
	private int orientation;

	/**
	 * Create a new ChoiceComposite instance given its parent and style value.
	 * The default orientation is <tt>SWT.VERTICAL</tt> (see also
	 * {@link #setOrientation(int)}). Multiple selection is allowed (=check
	 * boxes).
	 * 
	 * @param parent
	 *            the parent Composite (non-null)
	 * @param style
	 *            the SWT style of the Composite
	 */
	public ChoiceComposite(Composite parent, int style) {
		this(parent, style, true);
	}

	/**
	 * Create a new ChoiceComposite instance given its parent and style value.
	 * The default orientation is <tt>SWT.VERTICAL</tt> (see also
	 * {@link #setOrientation(int)}).
	 * 
	 * @param parent
	 *            the parent Composite (non-null)
	 * @param style
	 *            the SWT style of the Composite
	 * @param multipleSelection
	 *            true to allow multiple selection (=check boxes), false for
	 *            single selection (=radio buttons)
	 */
	public ChoiceComposite(Composite parent, int style, boolean multipleSelection) {
		super(parent, style);
		this.isMulti = multipleSelection;
		this.orientation = SWT.VERTICAL;
		applyOrientation();
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		LnFUpdater.addControlsAfterBind(this.getClass());
	}

	/**
	 * Returns the orientation of this ChoiceComposite.
	 * 
	 * @return one of <tt>SWT.VERTICAL</tt> or <tt>SWT.HORIZONTAL</tt>.
	 */
	public int getOrientation() {
		return orientation;
	}

	/**
	 * Returns true if this instance allows multiple selection, false otherwise.
	 */
	public final boolean isMultipleSelection() {
		return isMulti;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * The value will be propagated to children of this composite.
	 */
	@Override
	public final void setBackground(Color color) {
		setRedraw(false);
		try {
			super.setBackground(color);
			for (Control child : getChildren()) {
				child.setBackground(color);
			}
		} finally {
			setRedraw(true);
		}
	}

	@Override
	public final void setEnabled(boolean enabled) {
		setRedraw(false);
		try {
			super.setEnabled(enabled);
			for (Control child : getChildren()) {
				child.setEnabled(enabled);
			}
		} finally {
			setRedraw(true);
		}
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * The value will be propagated to children of this composite.
	 */
	@Override
	public final void setForeground(Color color) {
		setRedraw(false);
		try {
			super.setForeground(color);
			for (Control child : getChildren()) {
				child.setForeground(color);
			}
		} finally {
			setRedraw(true);
		}
	}

	/**
	 * Sets the orientation (vertical or horizontal) of the choices in this
	 * composite.
	 * 
	 * @param orientation
	 *            <tt>SWT.VERTICAL</tt> for vertical orientation or
	 *            <tt>SWT.HORIZONTAL</tt> for horizontal orientation
	 * @throws RuntimeException
	 *             if orientation has an unsupported value
	 */
	public final void setOrientation(int orientation) {
		Assert.isLegal(orientation == SWT.VERTICAL || orientation == SWT.HORIZONTAL);
		if (this.orientation != orientation) {
			this.orientation = orientation;
			applyOrientation();
		}
	}

	// helping methods
	// ////////////////

	private void applyOrientation() {
		if (orientation == SWT.VERTICAL) {
			setLayout(new FillLayout(SWT.VERTICAL));
		} else {
			RowLayout layout = new RowLayout(SWT.HORIZONTAL);
			layout.marginLeft = 0;
			layout.marginRight = 0;
			layout.marginTop = 0;
			layout.marginBottom = 0;
			layout.wrap = false;
			setLayout(layout);
		}
	}

}
