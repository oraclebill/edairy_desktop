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
package org.eclipse.riena.ui.swt.lnf;

import org.osgi.framework.Bundle;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Platform;

import org.eclipse.riena.core.exception.Failure;
import org.eclipse.riena.core.wire.Wire;
import org.eclipse.riena.internal.ui.swt.Activator;
import org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultLnf;
import org.eclipse.riena.ui.swt.utils.BundleUtil;

/**
 * The {@code LnfManager} manages the current look and feel of the riena
 * (navigation) widgets.
 * <p>
 * The {@code LnfManager} has the term of a default look-and-feel (L&F). The
 * default L&F is initially set by Riena to {@code RienaDefaultLnf}. But the
 * default L&F may also be overridden by frameworks based on Riena. That allows
 * them to define their own default L&F.
 * <p>
 * <b>Note:</b> Changing the L&F within a running application might result in
 * system resources such as colors, fonts and images which will not be disposed.
 * <p>
 * However, applications can again override the default L&F. This can be done by
 * either setting the system property "riena.lnf" or by specifying their L&F
 * with the methods {@code LnfManager.setLnf()}.
 * <p>
 * When specifying the L&F class via a string (either system property or one of
 * the above mentioned methods) the string should conform to:
 * 
 * <pre>
 * lnf := [ Bundle-Symbolic-Name &quot;:&quot; ] LnF-Class-Name
 * </pre>
 * 
 * Where Bundle-Symbolic-Name allows to load the L&F class from the bundle with
 * this symbolic name.<br>
 * If the Bundle-Symbolic-Name is omitted the {@code LnfManager} tries to load
 * the Lnf class with the {LnfMangager}'s class loader.
 */
public final class LnfManager {

	/**
	 * Allows setting of an application L&F.
	 * 
	 * @since 1.2
	 */
	public static final String RIENA_LNF_SYSTEM_PROPERTY = "riena.lnf"; //$NON-NLS-1$

	private static RienaDefaultLnf defaultLnf = new RienaDefaultLnf();
	private static RienaDefaultLnf currentLnf;

	private LnfManager() {
		// cannot instantiated, because all methods are static
	}

	/**
	 * Set a new default look and feel. See class header JavaDoc for details.
	 * 
	 * @param defaultLnf
	 *            new default L&F
	 * @since 1.2
	 */
	public static void setDefaultLnf(RienaDefaultLnf defaultLnf) {
		Assert.isNotNull(defaultLnf, "defaultLnf must not be null."); //$NON-NLS-1$
		LnfManager.defaultLnf = defaultLnf;
		setLnf((RienaDefaultLnf) null);
	}

	/**
	 * Set the new look and feel specified by the given class name (see class
	 * header JavaDoc).
	 * <p>
	 * <b>Note:</b> Changing the L&F in a running application might result in
	 * system resources such as colors, fonts and images which will not be
	 * disposed.
	 * 
	 * @param currentLnfClassName
	 *            a string specifying the name of the class that implements the
	 *            look and feel
	 */
	public static void setLnf(String currentLnfClassName) {
		setLnf(createLnf(currentLnfClassName));
	}

	/**
	 * Sets the new look and feel.
	 * <p>
	 * If this is set, it will override the default look and feel. See class
	 * header JavaDoc for details.
	 * <p>
	 * <b>Note:</b> Changing the L&F in a running application might result in
	 * system resources such as colors, fonts and images which will not be
	 * disposed.
	 * 
	 * @param currentLnf
	 *            new look and feel to install.
	 */
	public static void setLnf(RienaDefaultLnf currentLnf) {
		if (LnfManager.currentLnf == currentLnf) {
			return;
		}
		if (LnfManager.currentLnf != null) {
			LnfManager.currentLnf.uninitialize();
		}
		LnfManager.currentLnf = currentLnf;
		if (LnfManager.currentLnf != null) {
			if (Activator.getDefault() != null) {
				Wire.instance(LnfManager.currentLnf).andStart(Activator.getDefault().getContext());
			}
			LnfManager.currentLnf.initialize();
		}
	}

	/**
	 * Returns the current look and feel. If no look and feel is set, the
	 * default look and feel is returned.
	 * 
	 * @return current look and feel
	 */
	public static RienaDefaultLnf getLnf() {
		if (currentLnf == null) {
			final String className = System.getProperty(RIENA_LNF_SYSTEM_PROPERTY);
			if (className != null) {
				setLnf(className);
			} else {
				setLnf(defaultLnf);
			}
		}
		return currentLnf;
	}

	/**
	 * Return the current L&F class name.
	 * 
	 * @return the lnfClassName
	 * 
	 * @deprecated This was only needed for unit tests!! We should abandon it.
	 */
	@Deprecated
	public static String getLnfClassName() {
		return getLnf().getClass().getName();
	}

	/**
	 * Disposes (uninitializes) the current look and feel.
	 */
	public static void dispose() {
		if (currentLnf != null) {
			currentLnf.uninitialize();
			currentLnf = null;
		}
	}

	private static final String BUNDLE_CLASS_NAME_SEPARATOR = ":"; //$NON-NLS-1$

	private static RienaDefaultLnf createLnf(String lnfClassName) {
		if (lnfClassName == null) {
			return null;
		}
		Class<?> lnfClass = null;
		if (lnfClassName.contains(BUNDLE_CLASS_NAME_SEPARATOR)) {
			String[] parts = lnfClassName.split(BUNDLE_CLASS_NAME_SEPARATOR);
			String bundleSymbolicName = parts[0];
			String className = parts[1];
			Bundle bundle = Platform.getBundle(bundleSymbolicName);
			if (!BundleUtil.isReady(bundle)) {
				throw new LnfManagerFailure(
						"can't load LnfClass '" + className + "' from bundle " + bundleSymbolicName + " because bundle is not ready."); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			try {
				lnfClass = bundle.loadClass(className);
			} catch (ClassNotFoundException e) {
				throw new LnfManagerFailure(
						"can't load LnfClass '" + className + "' from bundle " + bundleSymbolicName + ".", e); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
		} else {
			lnfClass = loadClass(lnfClassName);
		}
		try {
			return (RienaDefaultLnf) lnfClass.newInstance();
		} catch (Exception e) {
			throw new LnfManagerFailure("can't create instance for LnfClass '" + lnfClass.getName() + ".", e); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	private static Class<?> loadClass(String className) {
		try {
			return LnfManager.class.getClassLoader().loadClass(className);
		} catch (ClassNotFoundException e) {
			throw new LnfManagerFailure("Can't load LnfClass '" + className //$NON-NLS-1$
					+ "'. Please use the class format specified in the LnfManager or change your bundle dependencies.", //$NON-NLS-1$
					e);
		}
		//
		// This code has been �removed� because it is likely the cause for sporadic errors - which is not good!
		// 
		//		try {
		//			return Thread.currentThread().getContextClassLoader().loadClass(className);
		//		} catch (Exception e) {
		//			Nop.reason("try next"); //$NON-NLS-1$
		//		}
		//
		//		throw new LnfManagerFailure("can't load LnfClass '" + className + "."); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@SuppressWarnings("serial")
	private static class LnfManagerFailure extends Failure {

		/**
		 * @param msg
		 */
		public LnfManagerFailure(String msg) {
			super(msg);
		}

		/**
		 * @param msg
		 */
		public LnfManagerFailure(String msg, Throwable thrown) {
			super(msg, thrown);
		}
	};
}
