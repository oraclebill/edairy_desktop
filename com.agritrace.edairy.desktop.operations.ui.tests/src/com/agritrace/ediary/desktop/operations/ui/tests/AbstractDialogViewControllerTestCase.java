package com.agritrace.ediary.desktop.operations.ui.tests;

import org.easymock.EasyMock;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.riena.core.RienaStatus;
import org.eclipse.riena.core.util.ReflectionUtils;
import org.eclipse.riena.internal.core.test.RienaTestCase;
import org.eclipse.riena.navigation.INavigationProcessor;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.swt.uibinding.SwtControlRidgetMapper;
import org.eclipse.swt.widgets.Display;

@SuppressWarnings("restriction")
public abstract class AbstractDialogViewControllerTestCase<C extends AbstractWindowController>
		extends RienaTestCase {

	private C controller;
	private final INavigationProcessor mockNavigationProcessor = EasyMock
			.createMock(INavigationProcessor.class);

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		System.getProperties().put(RienaStatus.RIENA_TEST_SYSTEM_PROPERTY,
				"true"); //$NON-NLS-1$

		// only used to get the initial mappings
		SwtControlRidgetMapper.getInstance();

		final Display display = Display.getDefault();
		final Realm realm = SWTObservables.getRealm(display);
		assertNotNull(realm);
		ReflectionUtils.invokeHidden(realm, "setDefault", realm); //$NON-NLS-1$
		//
		// IModuleNode module = new ModuleNode();
		// ISubModuleNode node = new SubModuleNode();
		// node.setParent(module);
		// module.addChild(node);
		// node.setNavigationProcessor(getMockNavigationProcessor());
		controller = createController();

		controller.configureRidgets();
		controller.afterBind();

	}

	@Override
	protected void tearDown() throws Exception {
		System.getProperties().put(RienaStatus.RIENA_TEST_SYSTEM_PROPERTY,
				"false"); //$NON-NLS-1$
		super.tearDown();
	}

	protected C getController() {
		return controller;
	}

	protected INavigationProcessor getMockNavigationProcessor() {
		return mockNavigationProcessor;
	}

	protected abstract C createController();
}
