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

package org.eclipse.riena.navigation.ui.swt.controllers;

import org.easymock.EasyMock;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.riena.core.RienaStatus;
import org.eclipse.riena.core.util.ReflectionUtils;
import org.eclipse.riena.internal.core.test.RienaTestCase;
import org.eclipse.riena.internal.core.test.collect.NonUITestCase;
import org.eclipse.riena.navigation.IModuleNode;
import org.eclipse.riena.navigation.INavigationProcessor;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.model.ModuleNode;
import org.eclipse.riena.navigation.model.SubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.swt.uibinding.SwtControlRidgetMapper;
import org.eclipse.swt.widgets.Display;

/**
 * Abstract class for SubModuleController testing. All controller tests should
 * use this as the super class
 * 
 * @since 2.0
 */
@NonUITestCase
public abstract class AbstractSubModuleControllerTest<C extends SubModuleController> extends RienaTestCase {

	private C controller;
	private INavigationProcessor mockNavigationProcessor = EasyMock.createMock(INavigationProcessor.class);

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		System.getProperties().put(RienaStatus.RIENA_TEST_SYSTEM_PROPERTY, "true"); //$NON-NLS-1$

		// only used to get the initial mappings
		SwtControlRidgetMapper.getInstance();

		Display display = Display.getDefault();
		Realm realm = SWTObservables.getRealm(display);
		assertNotNull(realm);
		ReflectionUtils.invokeHidden(realm, "setDefault", realm); //$NON-NLS-1$

		IModuleNode module = new ModuleNode();
		ISubModuleNode node = new SubModuleNode();
		node.setParent(module);
		module.addChild(node);
		node.setNavigationProcessor(getMockNavigationProcessor());
		controller = createController(node);

		controller.configureRidgets();
		controller.afterBind();

	}

	@Override
	protected void tearDown() throws Exception {
		System.getProperties().put(RienaStatus.RIENA_TEST_SYSTEM_PROPERTY, "false"); //$NON-NLS-1$
		super.tearDown();
	}

	protected C getController() {
		return controller;
	}

	protected INavigationProcessor getMockNavigationProcessor() {
		return mockNavigationProcessor;
	}

	protected abstract C createController(ISubModuleNode node);
}
