package com.agritrace.edairy.desktop.dairy.profile.ui.controllers;

import org.eclipse.core.runtime.Assert;
import org.eclipse.riena.core.injector.Inject;
import org.eclipse.riena.core.wire.InjectService;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.ModuleController;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IInfoFlyoutRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IWindowRidget;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;
import com.agritrace.edairy.desktop.dairy.profile.ui.Activator;

/**
 * Dairy Profile view controller
 * 
 * @author Bill Jones
 * 
 */
public class DairyProfileViewController extends SubModuleController {

	private static final String EDAIRY_SITE_DAIRYID = "edairy.site.dairyid";

	public static final String ID = DairyProfileViewController.class.getName();

	private final DairyRepository dairyRepository;
	private Dairy localDairy;

	public DairyProfileViewController() {
		super();	
		dairyRepository = new DairyRepository();
		long dairyId = getDairyId();
		localDairy = dairyRepository.findByKey(dairyId);
		if (localDairy == null) {
			initLocalDairy();
		}
	}

	private long getDairyId() {
		long id = -1;
		
		String dairyId;
		try {
			dairyId = System.getProperty(EDAIRY_SITE_DAIRYID);
			if (dairyId != null) {
				id = new Long(dairyId).longValue();
			}
		}
		catch (Exception e) {
		}
		return id;
	}
	
	private void initLocalDairy() {
		localDairy = DairyFactory.eINSTANCE.createDairy();
		localDairy.setLocation(
				DairyUtil.createLocation(null, null, null));
		
	}
	
	
	@Override
	public void configureRidgets() {
		System.err.println(">>>>>>>>>>>>>>>>>> in configureRidgets: " );		

		getWindowRidget().setTitle("Dairy Profile");

//		final ITextRidget txtNAME = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_NAME);
//		txtNAME.bindToModel(workingDairyCopy, "NAME");
//		txtNAME.updateFromModel();
//
//		final ITextRidget txtID = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_ID);
//		txtID.bindToModel(workingDairyCopy, "ID");
//		txtID.updateFromModel();
//
//		final ITextRidget txtLICENSE = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_LICENSE);
//		txtLICENSE.bindToModel(workingDairyCopy, "LICENSE");
//		txtLICENSE.updateFromModel();
//
//		final ITextRidget txtESTABLISHED_DATE = getRidget(ITextRidget.class,
//				DairyProfileViewWidgetID.DAIRY_ESTABLISHED_DATE);
//		txtESTABLISHED_DATE.bindToModel(workingDairyCopy, "ESTABLISHED_DATE");
//		txtESTABLISHED_DATE.updateFromModel();
//
//		final ITextRidget txtMANAGER_NAME = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_MANAGER_NAME);
//		txtMANAGER_NAME.bindToModel(workingDairyCopy, "MANAGER_NAME");
//		txtMANAGER_NAME.updateFromModel();
//
//		final ITextRidget txtMEMBER_COUNT = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_MEMBER_COUNT);
//		txtMEMBER_COUNT.bindToModel(workingDairyCopy, "MEMBER_COUNT");
//		txtMEMBER_COUNT.updateFromModel();
//
//		final ITextRidget txtPROFILE_IMAGE = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_PROFILE_IMAGE);
//		txtPROFILE_IMAGE.bindToModel(workingDairyCopy, "PROFILE_IMAGE");
//		txtPROFILE_IMAGE.updateFromModel();
//
//		final ITextRidget txtMAP_IMAGE = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_MAP_IMAGE);
//		txtMAP_IMAGE.bindToModel(workingDairyCopy, "MAP_IMAGE");
//		txtMAP_IMAGE.updateFromModel();
//
//		final ITextRidget txtPUBLIC_DESCRIPTION = getRidget(ITextRidget.class,
//				DairyProfileViewWidgetID.DAIRY_PUBLIC_DESCRIPTION);
//		txtPUBLIC_DESCRIPTION.bindToModel(workingDairyCopy, "PUBLIC_DESCRIPTION");
//		txtPUBLIC_DESCRIPTION.updateFromModel();
//
//		final IActionRidget saveAction = (IActionRidget) getRidget(DairyProfileViewWidgetID.DAIRY_SAVE);
//		saveAction.addListener(new IActionListener() {
//			@Override
//			public void callback() {
//				DairyDemoResourceManager.INSTANCE.getLocalDairy(); // TODO
//			}
//		});
//
//		final IActionRidget cencelAction = (IActionRidget) getRidget(DairyProfileViewWidgetID.DAIRY_CANCEL);
//		cencelAction.addListener(new IActionListener() {
//			@Override
//			public void callback() {
//				DairyDemoResourceManager.INSTANCE.getLocalDairy(); // TODO
//			}
//		});

	}

	
	@Override
	public void afterBind() {
		// TODO Auto-generated method stub
		super.afterBind();
		System.err.println(">>>>>>>>>>>>>>>>>> afterBind: " );
		
	}

	@Override
	public IRidget getInitialFocus() {
		// TODO Auto-generated method stub
		System.err.println(">>>>>>>>>>>>>>>>>> getInitialFocus: " );
		
		return super.getInitialFocus();
	}

	@Override
	public ModuleController getModuleController() {
		// TODO Auto-generated method stub
		System.err.println(">>>>>>>>>>>>>>>>>> getModuleController: " );

		return super.getModuleController();
	}

	@Override
	public IWindowRidget getWindowRidget() {
		// TODO Auto-generated method stub
		System.err.println(">>>>>>>>>>>>>>>>>> getWindowRidget: " );

		return super.getWindowRidget();
	}

	@Override
	public IInfoFlyoutRidget getInfoFlyout() {
		// TODO Auto-generated method stub
		System.err.println(">>>>>>>>>>>>>>>>>> getInfoFlyout: " );

		return super.getInfoFlyout();
	}

	@Override
	public void setInitialFocus(IRidget ridget) {
		// TODO Auto-generated method stub
		super.setInitialFocus(ridget);
		System.err.println(">>>>>>>>>>>>>>>>>> setInitialFocus: " + ridget );

	}

	@Override
	public void setNavigationNode(ISubModuleNode navigationNode) {
		// TODO Auto-generated method stub
		super.setNavigationNode(navigationNode);
		System.err.println(">>>>>>>>>>>>>>>>>> setNavigationNode: " + navigationNode );

	}

	@Override
	public void setWindowRidget(IWindowRidget windowRidget) {
		// TODO Auto-generated method stub
		super.setWindowRidget(windowRidget);
		System.err.println(">>>>>>>>>>>>>>>>>> setWindowRidget: " + windowRidget);

	}

	@Override
	public void updateAllRidgetsFromModel() {
		// TODO Auto-generated method stub
		super.updateAllRidgetsFromModel();
		System.err.println(">>>>>>>>>>>>>>>>>> updateAllRidgetsFromModel: " );

	}

	@Override
	protected void updateIcon(IWindowRidget windowRidget) {
		// TODO Auto-generated method stub
		super.updateIcon(windowRidget);		
		System.err.println(">>>>>>>>>>>>>>>>>> updateIcon: " + windowRidget );

		
	}

	@Override
	public void addDefaultAction(IRidget focusRidget, IActionRidget action) {
		// TODO Auto-generated method stub
		super.addDefaultAction(focusRidget, action);
		System.err.println(">>>>>>>>>>>>>>>>>> addDefaultAction: " + focusRidget + ", " + action );
	}
}
