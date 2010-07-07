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
package org.eclipse.riena.ui.ridgets.swt.uibinding;

import org.eclipse.swt.widgets.Widget;

import org.eclipse.riena.ui.ridgets.swt.AbstractRidgetController;
import org.eclipse.riena.ui.ridgets.uibinding.IControlRidgetMapper;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.WidgetIdentificationSupport;

/**
 * This class is responsible for managing a list of SWT widgets, creating
 * appropriate ridgets for them and passing those ridgets to a given controller.
 * <p>
 * Here's an example of how to use this class to create ridgets for your widgets
 * in a <b>regular</b> ViewPart.
 * 
 * <pre>
 * tree = new Tree(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
 * delegate.addUIControl(tree, &quot;tree&quot;);
 * 
 * delegate.injectAndBind(controller);
 * parent.addDisposeListener(new DisposeListener() {
 * 	public void widgetDisposed(DisposeEvent e) {
 * 		delegate.unbind(controller);
 * 	}
 * });
 * </pre>
 * 
 * If you use the Riena UI / Navigation you should look at the classes
 * SubModuleController and SubModuleView (and their subclasses) instead.
 * 
 * @see AbstractRidgetController
 */
public class DefaultSwtBindingDelegate extends AbstractViewBindingDelegate {

	public DefaultSwtBindingDelegate() {
		this(SwtControlRidgetMapper.getInstance());
	}

	@SuppressWarnings("unchecked")
	public DefaultSwtBindingDelegate(IControlRidgetMapper mapper) {
		super(SWTBindingPropertyLocator.getInstance(), mapper);
	}

	@Override
	public void addUIControl(Object uiControl, String bindingId) {
		super.addUIControl(uiControl, bindingId);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(uiControl, bindingId);

		if (uiControl instanceof Widget) {
			WidgetIdentificationSupport.setIdentification((Widget) uiControl, bindingId);
		}
	}
}
