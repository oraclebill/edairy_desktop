package com.agritrace.edairy.desktop.install.dbsetup;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.riena.navigation.IApplicationNode;
import org.eclipse.riena.navigation.ui.controllers.ApplicationController;
import org.eclipse.riena.navigation.ui.swt.application.SwtApplication;
import org.eclipse.riena.navigation.ui.swt.login.ILoginSplashViewExtension;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class Application extends SwtApplication implements IApplication
{

	/* (non-Javadoc)
	 * @see org.eclipse.riena.navigation.ui.application.AbstractApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	@Override
	public Object start(IApplicationContext context) throws Exception
	{
		return super.start(context);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.riena.navigation.ui.application.AbstractApplication#createModel()
	 */
	@Override
	protected IApplicationNode createModel()
	{
		return super.createModel();
	}
}
