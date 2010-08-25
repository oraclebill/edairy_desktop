package com.agritrace.edairy.desktop.splashHandlers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.splash.EclipseSplashHandler;
import org.eclipse.ui.splash.BasicSplashHandler;

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
		Composite parent = monitor.getParent();
		
		// getSplash()
		// getSplash().setBackgroundImage(null);
		// getSplash().setBackgroundMode(SWT.INHERIT_NONE);
		//parent.setBackgroundImage(Activator.getImage("resources/splash/splash.bmp"));
		// parent.setBackground(new Color(parent.getDisplay(), 255, 128, 128));
		//parent.setBackgroundMode(SWT.INHERIT_FORCE);
		monitor.setBackgroundImage(Activator.getImage("splash/splash.bmp"));
		return monitor;
	}
}
