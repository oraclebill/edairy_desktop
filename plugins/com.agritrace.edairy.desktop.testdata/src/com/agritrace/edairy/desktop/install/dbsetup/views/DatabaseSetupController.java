package com.agritrace.edairy.desktop.install.dbsetup.views;

import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.install.dbsetup.TestDataGenerator;
import com.agritrace.edairy.desktop.install.dbsetup.TestDataGeneratorConfig;

public class DatabaseSetupController extends SubModuleController implements IController
{

	TestDataGeneratorConfig	config		= new TestDataGeneratorConfig();
	TestDataGenerator		generator	= new TestDataGenerator();

	public DatabaseSetupController()
	{
		// TODO Auto-generated constructor stub
	}

	public DatabaseSetupController(ISubModuleNode navigationNode)
	{
		super(navigationNode);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.riena.navigation.ui.controllers.SubModuleController#configureRidgets()
	 */
	@Override
	public void configureRidgets()
	{
		super.configureRidgets();
		ITextRidget text;
		getRidget(ITextRidget.class, "dairy-registration-txt").bindToModel(config, "");
		getRidget(ITextRidget.class, "dairy-licensee-txt").bindToModel(config, "");
		getRidget(ITextRidget.class, "db-name-txt").bindToModel(config, "");
		getRidget(ITextRidget.class, "db-server-txt").bindToModel(config, "");
		getRidget(ITextRidget.class, "db-port-txt").bindToModel(config, "");
		getRidget(ITextRidget.class, "db-adminuser-txt").bindToModel(config, "");
		getRidget(ITextRidget.class, "db-adminpassword-txt").bindToModel(config, "");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.riena.navigation.ui.controllers.SubModuleController#afterBind()
	 */
	@Override
	public void afterBind()
	{
		// TODO Auto-generated method stub
		super.afterBind();
	}

}
