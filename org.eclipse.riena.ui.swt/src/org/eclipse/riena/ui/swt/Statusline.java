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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;

/**
 * Status line.
 * 
 * @since 1.2
 */
public class Statusline extends Composite implements IComplexComponent {

	//widget ids
	/**
	 * @since 1.2
	 */
	public final static String SL_NUMBER_RIDGET_ID = "statuslineNumberRidget"; //$NON-NLS-1$
	/**
	 * @since 1.2
	 */
	public final static String SL_UIPROCES_RIDGET_ID = "statuslineUIProcessRidget"; //$NON-NLS-1$

	private List<Object> uiControls;
	private StatuslineMessage message;
	private Class<? extends Control> spacer;

	// factory for the creation of the contents of the statusline
	private IStatusLineContentFactory contentFactory;

	/**
	 * Creates a new instance of <code>Statusline</code>.
	 * 
	 * @param parent
	 *            a widget which will be the parent of the new instance (cannot
	 *            be null)
	 * @param style
	 *            the style of widget to construct
	 */
	public Statusline(Composite parent, int style) {
		this(parent, style | SWT.NO_SCROLL, (Class<? extends Control>) null);
	}

	/**
	 * Creates a new instance of <code>Statusline</code>.
	 * 
	 * @param parent
	 *            a widget which will be the parent of the new instance (cannot
	 *            be null)
	 * @param style
	 *            the style of widget to construct
	 * @since 1.2
	 */
	public Statusline(Composite parent, int style, IStatusLineContentFactory contentFactory) {
		this(parent, style | SWT.NO_SCROLL, null, contentFactory);
	}

	/**
	 * 
	 * @param parent
	 *            a widget which will be the parent of the new instance (cannot
	 *            be null)
	 * @param style
	 *            the style of widget to construct
	 * @param pSpacer
	 *            class to create spacer
	 * @param contentFactory
	 *            factory for the creation of the contents of the
	 *            <code>Statusline</code>
	 */
	public Statusline(Composite parent, int style, Class<? extends Control> pSpacer) {
		this(parent, style | SWT.NO_SCROLL, pSpacer, new DefaultStatuslineContentFactory());
	}

	/**
	 * Creates a new instance of <code>Statusline</code>.
	 * 
	 * @param parent
	 *            a widget which will be the parent of the new instance (cannot
	 *            be null)
	 * @param style
	 *            the style of widget to construct
	 * @param pSpacer
	 *            class to create spacer
	 * @param contentFactory
	 *            factory for the creation of the contents of the
	 *            <code>Statusline</code>
	 */
	public Statusline(Composite parent, int style, Class<? extends Control> pSpacer,
			IStatusLineContentFactory contentFactory) {
		super(parent, style | SWT.NO_SCROLL);
		spacer = pSpacer;
		this.contentFactory = contentFactory;
		init();
	}

	/**
	 * Initializes the status line.
	 */
	private void init() {
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.STATUSLINE_BACKGROUND));
		uiControls = new ArrayList<Object>();
		createContents();
	}

	/**
	 * Creates the contents of the status line.
	 */
	protected void createContents() {
		message = new StatuslineMessage(this, SWT.NONE);

		// delegation to the content factory
		getContentFactory().createContent(this);
	}

	/**
	 * @see org.eclipse.riena.ui.common.IComplexComponent#getUIControls()
	 */
	public List<Object> getUIControls() {
		return uiControls;
	}

	private Object getUIControl(String id) {
		if (id == null) {
			return null;
		}
		for (Object uiControl : getUIControls()) {
			if (id.equals(SWTBindingPropertyLocator.getInstance().locateBindingProperty(uiControl))) {
				return uiControl;
			}
		}

		return null;
	}

	/**
	 * Adds the given control to the list of the controls that will be binded.
	 * 
	 * @param uiControl
	 *            control to bind
	 * @param propertyName
	 *            name of the property...
	 * @since 1.2
	 */
	public void addUIControl(Widget uiControl, String propertyName) {
		SWTBindingPropertyLocator.getInstance().setBindingProperty(uiControl, propertyName);
		getUIControls().add(uiControl);
	}

	///
	///// Getters

	/**
	 * @since 1.2
	 */
	public IStatusLineContentFactory getContentFactory() {
		return contentFactory;
	}

	/**
	 * @since 1.2
	 */
	public final StatuslineMessage getMessageComposite() {
		return message;
	}

	/**
	 * @since 1.2
	 */
	public StatuslineNumber getStatuslineNumber() {
		return (StatuslineNumber) getUIControl(SL_NUMBER_RIDGET_ID);
	}

	/**
	 * @since 1.2
	 */
	public StatuslineUIProcess getStatuslineUIProcess() {
		return (StatuslineUIProcess) getUIControl(SL_UIPROCES_RIDGET_ID);
	}

	/**
	 * @since 1.2
	 */
	public Class<? extends Control> getSpacer() {
		return spacer;
	}

}
