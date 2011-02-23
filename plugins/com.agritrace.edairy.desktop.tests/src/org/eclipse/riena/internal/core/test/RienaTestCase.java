/*******************************************************************************
 * Copyright (c) 2007, 2010 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    compeople AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.riena.internal.core.test;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import org.eclipse.core.internal.registry.ExtensionRegistry;
import org.eclipse.core.runtime.ContributorFactoryOSGi;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.RegistryFactory;

import org.eclipse.riena.core.util.Nop;
import org.eclipse.riena.core.util.Trace;
import org.eclipse.riena.internal.core.ignore.IgnoreFindBugs;

/**
 * Base class for test cases.<br>
 * It extends the {@link junit.framework.TestCase} with a few helpers.
 */
// this is for org.eclipse.core.internal.registry.ExtensionRegistry
@SuppressWarnings("restriction")
public abstract class RienaTestCase extends TestCase {

	// private static final String ORG_ECLIPSE_RIENA_BUNDLE_PREFIX = null;//"org.eclipse.riena"; 
	// Keep track of services and corresponding service references.
	private final Map<Object, ServiceReference> services = new HashMap<Object, ServiceReference>();
	// Do not access this field directly! Use the getter getContext() because this does a lazy initialization.
	private BundleContext context;

	private final boolean trace = Trace.isOn(RienaTestCase.class, getClass(), "debug"); //$NON-NLS-1$

	//private Set<String> before;
	//private Set<String> after;

	/**
	 * 
	 */
	public RienaTestCase() {
		super();
	}

	/**
	 * @param name
	 */
	public RienaTestCase(final String name) {
		super(name);
	}

	/**
	 * A counterpart to Assert.fail() that may be invoked to indicate that
	 * everything is fine and that the test should continue. May be used e.g. in
	 * an otherwise empty catch block that handles an expected exception. In
	 * this use case its advantages over a comment are that it allows a more
	 * uniform way of documentation than the numerous variations of "// ignore"
	 * and that it avoids a Checkstyle warning about the empty block.
	 */
	protected void ok() {
		// nothing to do, everything is OK...
	}

	/**
	 * A counterpart to Assert.fail(String) that may be invoked to indicate that
	 * everything is fine and that the test should continue.
	 * 
	 * @see #ok()
	 * 
	 * @param message
	 *            A message explaining why nothing is wrong.
	 */
	protected void ok(final String message) {
		ok();
	}

	/*
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		services.clear();
		// before = ExtensionRegistryAnalyzer.getRegistryPaths(ORG_ECLIPSE_RIENA_BUNDLE_PREFIX);
	}

	/*
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		for (final ServiceReference reference : services.values()) {
			getContext().ungetService(reference);
		}
		services.clear();
		//		try {
		//			assertNotNull("Obviously the super.setUp() method has not been called!", before); //$NON-NLS-1$
		//			after = ExtensionRegistryAnalyzer.getRegistryPaths(ORG_ECLIPSE_RIENA_BUNDLE_PREFIX);
		//			if (!before.equals(after)) {
		//				fail("ExtensionRegistry has changed while running the test " + getName() + ": " //$NON-NLS-1$ //$NON-NLS-2$
		//						+ ExtensionRegistryAnalyzer.symmetricDiff(before, after).toString());
		//			}
		//		} finally {
		//			after = null;
		//			before = null;
		//			super.tearDown();
		//		}
		super.tearDown();
	}

	/**
	 * Return the bundle context. <br>
	 * <b>Note: </b>This method must not be called from a constructor of a test
	 * case!
	 * 
	 * @return
	 */
	protected BundleContext getContext() {
		if (context == null) {
			try {
				final Bundle bundle = FrameworkUtil.getBundle(getClass());
				context = bundle.getBundleContext();
			} catch (final Throwable t) {
				Nop.reason("We don´t care. Maybe it is not running as a plugin test."); //$NON-NLS-1$
			}
		}
		return context;
	}

	/**
	 * Get the file (from src-folder) for the resource within the same directory
	 * this unit test is in.
	 * 
	 * @param resource
	 * @return
	 */
	protected File getFile(final String resource) {
		// TODO warning suppression. Ignoring FindBugs problem that
		// getResource(..) will return a resource relative to a
		// subclass rather than relative to this class. This is the
		// intended behavior.
		final URL url = getClass().getResource(resource);
		// nested File constructors for OS independence...
		return new File(new File(new File("").getAbsolutePath(), "src"), url.getFile()); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Enable/Disable printing.
	 * 
	 * @param print
	 * @Deprecated Has been replaced by Eclipse´s trace facility.
	 */
	@Deprecated
	protected void setPrint(final boolean print) {
	}

	/**
	 * Check whether trace is switched on or not.
	 * 
	 * @return tracing?
	 */
	protected boolean isTrace() {
		return trace;
	}

	/**
	 * Print the current test´s name.
	 */
	protected void printTestName() {
		if (!isTrace()) {
			return;
		}
		System.out.println(getName());
		for (int i = 0; i < getName().length(); i++) {
			System.out.print('-');
		}
		System.out.println();
	}

	/**
	 * Print the string, no CR/LF.
	 * 
	 * @param string
	 */
	protected void print(final String string) {
		if (!isTrace()) {
			return;
		}
		System.out.print(string);
	}

	/**
	 * Print the string, with CR/LF.
	 * 
	 * @param string
	 */
	protected void println(final String string) {
		if (!isTrace()) {
			return;
		}
		System.out.println(string);
	}

	/**
	 * Add an extension/extension point defined within the ´plugin.xml´ given
	 * with the <code>pluginResource</code> to the extension registry.
	 * 
	 * @param forLoad
	 * @param pluginResource
	 * @throws InterruptedException
	 */
	protected void addPluginXml(final Class<?> forLoad, final String pluginResource) {
		addPluginXml(forLoad, pluginResource, -1);
	}

	/**
	 * Add an extension/extension point defined within the ´plugin.xml´ given
	 * with the <code>pluginResource</code> to the extension registry.
	 * Additionally it is possible to perform a sleep interval after the
	 * ´plugin.xml´ has been added.
	 * 
	 * @param forLoad
	 * @param pluginResource
	 * @param sleepInMs
	 * @throws InterruptedException
	 */
	protected void addPluginXml(final Class<?> forLoad, final String pluginResource, final int sleepInMs) {
		final IExtensionRegistry registry = RegistryFactory.getRegistry();
		@IgnoreFindBugs(value = "OBL_UNSATISFIED_OBLIGATION", justification = "stream will be closed by getResourceAsStream()")
		final InputStream inputStream = forLoad.getResourceAsStream(pluginResource);
		final IContributor contributor = ContributorFactoryOSGi.createContributor(getContext().getBundle());
		final RegistryEventListener listener = new RegistryEventListener(forLoad.getName() + " - " + pluginResource); //$NON-NLS-1$
		registry.addListener(listener);
		final boolean success = registry.addContribution(inputStream, contributor, false, pluginResource, null,
				((ExtensionRegistry) registry).getTemporaryUserToken());
		listener.waitAdded();
		registry.removeListener(listener);
		assertTrue(success);
		if (sleepInMs > 0) {
			try {
				Thread.sleep(sleepInMs);
			} catch (final InterruptedException e) {
				println("Sleeping in addPluginXml failed!"); //$NON-NLS-1$
			}
		}
	}

	/**
	 * Remove the given extension from the extension registry.
	 * 
	 * @param extensionId
	 */
	protected void removeExtension(final String extensionId) {
		removeExtension(extensionId, -1);
	}

	/**
	 * Remove the given extension from the extension registry. Additionally it
	 * is possible to perform a sleep interval after the extension has been
	 * removed.
	 * 
	 * @param extensionId
	 * @param sleepInMs
	 */
	protected void removeExtension(final String extensionId, final int sleepInMs) {
		final IExtensionRegistry registry = RegistryFactory.getRegistry();
		final IExtension extension = registry.getExtension(extensionId);
		assertNotNull(extension);
		final RegistryEventListener listener = new RegistryEventListener(extensionId);
		registry.addListener(listener);
		final boolean success = registry.removeExtension(extension, ((ExtensionRegistry) registry)
				.getTemporaryUserToken());
		listener.waitExtensionRemoved();
		registry.removeListener(listener);
		assertTrue(success);
		if (sleepInMs > 0) {
			try {
				Thread.sleep(sleepInMs);
			} catch (final InterruptedException e) {
				println("Sleeping in removeExtension failed!"); //$NON-NLS-1$
			}
		}
	}

	/**
	 * Remove the given extension from the extension registry.
	 * 
	 * @param extensionPointId
	 */
	protected void removeExtensionPoint(final String extensionPointId) {
		removeExtensionPoint(extensionPointId, -1);
	}

	/**
	 * Remove the given extension from the extension registry.Additionally it is
	 * possible to perform a sleep interval after the extension point has been
	 * removed.
	 * 
	 * @param extensionPointId
	 * @param sleepInMs
	 */
	protected void removeExtensionPoint(final String extensionPointId, final int sleepInMs) {
		final IExtensionRegistry registry = RegistryFactory.getRegistry();
		final IExtensionPoint extensionPoint = registry.getExtensionPoint(extensionPointId);
		assertNotNull(extensionPoint);
		final RegistryEventListener listener = new RegistryEventListener(extensionPointId);
		registry.addListener(listener);
		final boolean success = registry.removeExtensionPoint(extensionPoint, ((ExtensionRegistry) registry)
				.getTemporaryUserToken());
		listener.waitExtensionPointRemoved();
		registry.removeListener(listener);
		assertTrue(success);
		if (sleepInMs > 0) {
			try {
				Thread.sleep(sleepInMs);
			} catch (final InterruptedException e) {
				println("Sleeping in removeExtensionPoint failed!"); //$NON-NLS-1$
			}
		}
	}

	/**
	 * Get the service for the specified <code>serviceClass</code>.
	 * 
	 * @param serviceClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> T getService(final Class<T> serviceClass) {
		final ServiceReference reference = getContext().getServiceReference(serviceClass.getName());
		if (reference == null) {
			return null;
		}
		final Object service = getContext().getService(reference);
		if (service == null) {
			return null;
		}
		services.put(service, reference);
		return (T) service;
	}

	/**
	 * Unget the specified <code>service</code>.
	 * 
	 * @param service
	 */
	protected void ungetService(final Object service) {
		final ServiceReference reference = services.get(service);
		if (reference == null) {
			return;
		}
		getContext().ungetService(reference);
	}

	/**
	 * Starts the bundle with the given <code>bundleName</code>.
	 * 
	 * @param bundleName
	 * @throws BundleException
	 */
	protected void startBundle(final String bundleName) throws BundleException {
		startBundles(bundleName.replaceAll("\\.", "\\\\."), null); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Starts all bundles that match the <code>includePattern</code> but not the
	 * <code>excludePattern</code>. The <code>excludePattern</code> may be
	 * <code>null</code>.
	 * 
	 * @param includePattern
	 * @param excludePattern
	 * @throws BundleException
	 */
	protected void startBundles(final String includePattern, final String excludePattern) throws BundleException {
		doWithBundles(includePattern, excludePattern, new IClosure() {

			public void execute(final Bundle bundle) throws BundleException {
				if (bundle.getState() == Bundle.RESOLVED || bundle.getState() == Bundle.STARTING /*
																								 * STARTING
																								 * ==
																								 * LAZY
																								 */) {
					bundle.start();
				} else {
					if (bundle.getState() == Bundle.INSTALLED) {
						throw new RuntimeException(
								"can't start required bundle because it is not RESOLVED but only INSTALLED : " //$NON-NLS-1$
										+ bundle.getSymbolicName());
					}
				}
			}
		});
	}

	/**
	 * Stops the bundle with the given <code>bundleName</code>.
	 * 
	 * @param bundleName
	 * @throws BundleException
	 */
	protected void stopBundle(final String bundleName) throws BundleException {
		stopBundles(bundleName.replaceAll("\\.", "\\\\."), null); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Stops all bundles that match the <code>includePattern</code> but not the
	 * <code>excludePattern</code>. The <code>excludePattern</code> may be
	 * <code>null</code>.
	 * 
	 * @param includePattern
	 * @param excludePattern
	 * @throws BundleException
	 */
	protected void stopBundles(final String includePattern, final String excludePattern) throws BundleException {
		doWithBundles(includePattern, excludePattern, new IClosure() {

			public void execute(final Bundle bundle) throws BundleException {
				if (bundle.getState() == Bundle.ACTIVE) {
					bundle.stop();
				} else {
					if (bundle.getState() != Bundle.UNINSTALLED) {
						Nop
								.reason("testcase tried to stop this bundle which did not run, but we can ignore this ==> bundle is stopped already"); //$NON-NLS-1$
					}
				}
			}
		});
	}

	/**
	 * IClosure with all bundles that match the <code>includePattern</code> but
	 * not the <code>excludePattern</code> what is specified within the
	 * <code>closure</code>. The <code>excludePattern</code> may be
	 * <code>null</code>.
	 * 
	 * @param includePattern
	 * @param excludePattern
	 * @param closure
	 * @throws BundleException
	 */
	protected void doWithBundles(final String includePattern, String excludePattern, final IClosure closure)
			throws BundleException {
		if (includePattern == null) {
			throw new UnsupportedOperationException("truePattern must be set"); //$NON-NLS-1$
		}
		if (excludePattern == null) {
			excludePattern = ""; //$NON-NLS-1$
		}
		final Pattern include = Pattern.compile(includePattern);
		final Pattern exclude = Pattern.compile(excludePattern);

		final Bundle[] bundles = getContext().getBundles();
		for (final Bundle bundle : bundles) {
			if (include.matcher(bundle.getSymbolicName()).matches()
					&& !(exclude.matcher(bundle.getSymbolicName()).matches())) {
				closure.execute(bundle);
			}
		}
	}

	protected interface IClosure {
		void execute(Bundle bundle) throws BundleException;
	}

	private final class RegistryEventListener implements IRegistryEventListener {

		private final CountDownLatch added = new CountDownLatch(1);
		private final CountDownLatch extensionRemoved = new CountDownLatch(1);
		private final CountDownLatch extensionPointRemoved = new CountDownLatch(1);
		private final String ident;
		private final static int SECONDS_TO_WAIT = 1;

		private RegistryEventListener(final String ident) {
			this.ident = ident;
		}

		public void waitAdded() {
			final String message = "Expected extension/point has not been ´added´ for " + ident + " because "; //$NON-NLS-1$ //$NON-NLS-2$
			try {
				added.await(SECONDS_TO_WAIT, TimeUnit.SECONDS);
				if (added.getCount() == 1) {
					if (isTrace()) {
						System.err.println(message + " time-out has been reached. Which might be ok!"); //$NON-NLS-1$
					}
				}
			} catch (final InterruptedException e) {
				TestCase.fail(message + " the CountDownLatch failed with " + e); //$NON-NLS-1$ 
			}
		}

		public void waitExtensionRemoved() {
			final String message = "Expected extension id " + ident + " has not been ´removed´ because "; //$NON-NLS-1$ //$NON-NLS-2$
			try {
				extensionRemoved.await(SECONDS_TO_WAIT, TimeUnit.SECONDS);
				if (extensionRemoved.getCount() == 1) {
					if (isTrace()) {
						System.err.println(message + " time-out has been reached. Which might be ok!"); //$NON-NLS-1$
					}
				}
			} catch (final InterruptedException e) {
				TestCase.fail(message + " the CountDownLatch failed with " + e); //$NON-NLS-1$ 
			}
		}

		public void waitExtensionPointRemoved() {
			final String message = "Expected extension point id " + ident + " has not been ´removed´ because "; //$NON-NLS-1$ //$NON-NLS-2$
			try {
				extensionPointRemoved.await(SECONDS_TO_WAIT, TimeUnit.SECONDS);
				if (extensionPointRemoved.getCount() == 1) {
					if (isTrace()) {
						System.err.println(message + " time-out has been reached. Which might be ok!"); //$NON-NLS-1$
					}
				}
			} catch (final InterruptedException e) {
				TestCase.fail(message + " the CountDownLatch failed with " + e); //$NON-NLS-1$ 
			}
		}

		public void added(final IExtension[] extensions) {
			if (isTrace()) {
				System.out.println("Extensions added: "); //$NON-NLS-1$
				for (final IExtension extension : extensions) {
					System.out.println(" - " + extension.getUniqueIdentifier() + ", " //$NON-NLS-1$ //$NON-NLS-2$
							+ extension.getExtensionPointUniqueIdentifier());
				}
			}
			added.countDown();
		}

		public void added(final IExtensionPoint[] extensionPoints) {
			if (isTrace()) {
				System.out.println("ExtensionPoints added: "); //$NON-NLS-1$
				for (final IExtensionPoint extensionPoint : extensionPoints) {
					System.out.println(" - " + extensionPoint.getUniqueIdentifier()); //$NON-NLS-1$
				}
			}
			added.countDown();
		}

		public void removed(final IExtension[] extensions) {
			if (isTrace()) {
				System.out.println("Extensions removed: "); //$NON-NLS-1$
				for (final IExtension extension : extensions) {
					System.out.println(" - " + extension.getUniqueIdentifier() + ", " //$NON-NLS-1$ //$NON-NLS-2$
							+ extension.getExtensionPointUniqueIdentifier());
				}
			}
			extensionRemoved.countDown();
		}

		public void removed(final IExtensionPoint[] extensionPoints) {
			if (isTrace()) {
				System.out.println("ExtensionPoints removed: "); //$NON-NLS-1$
				for (final IExtensionPoint extensionPoint : extensionPoints) {
					System.out.println(" - " + extensionPoint.getUniqueIdentifier()); //$NON-NLS-1$
				}
			}
			extensionPointRemoved.countDown();
		}
	};
}
