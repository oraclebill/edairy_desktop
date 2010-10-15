package com.agritrace.edairy.desktop.internal.common.persistence;

import org.eclipse.riena.core.RienaActivator;
import org.osgi.framework.BundleContext;

public class PersistenceActivator extends RienaActivator {
	private static PersistenceActivator DEFAULT = null;

	public static PersistenceActivator getDefault() {
		return DEFAULT;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		DEFAULT = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		DEFAULT = null;
	}
}
