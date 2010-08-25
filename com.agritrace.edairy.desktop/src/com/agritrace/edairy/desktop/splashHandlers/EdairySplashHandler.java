package com.agritrace.edairy.desktop.splashHandlers;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.splash.EclipseSplashHandler;

import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;
import com.agritrace.edairy.desktop.member.ui.Activator;

@SuppressWarnings("restriction")
public class EdairySplashHandler extends EclipseSplashHandler {
	@Override
	public void init(Shell splash) {
		super.init(splash);

		getBundleProgressMonitor().beginTask("Initializing database", 1);
		getSplash().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				PersistenceManager.getDefault().getSession().close();
				getBundleProgressMonitor().worked(1);
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
