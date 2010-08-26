package com.agritrace.edairy.desktop.splashHandlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.StartupThreading.StartupRunnable;
import org.eclipse.ui.internal.splash.EclipseSplashHandler;

import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;
import com.agritrace.edairy.desktop.member.ui.Activator;

@SuppressWarnings("restriction")
public class EdairySplashHandler extends EclipseSplashHandler {
	@Override
	public void init(Shell splash) {
		super.init(splash);
		
		final IProgressMonitor monitor = getBundleProgressMonitor();
		monitor.beginTask("Initializing database", 2);
		
		getSplash().getDisplay().asyncExec(new StartupRunnable() {
			@Override
			public void runWithException() throws Throwable {
				PersistenceManager pm = PersistenceManager.getDefault();
				monitor.worked(1);
				// Force Hibernate to initialize - how should we do this elegantly?
				pm.getSession().close();
				monitor.worked(1);
			}
		});
	}
	
	@Override
	protected Composite getContent() {
		Composite monitor = super.getContent();
		monitor.setBackgroundImage(Activator.getImage("splash/splash.bmp"));
		return monitor;
	}
}
