package com.agritrace.edairy.desktop.dairy.profile.ui.controllers;

import org.eclipse.core.runtime.Assert;
import org.eclipse.riena.core.injector.Inject;
import org.eclipse.riena.core.wire.InjectService;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.ModuleController;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IInfoFlyoutRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IWindowRidget;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.common.ui.managers.IDairyResourceManager;
import com.agritrace.edairy.desktop.dairy.profile.ui.Activator;
import com.agritrace.edairy.desktop.dairy.profile.ui.DairyProfileViewWidgetID;

/**
 * Dairy Profile view controller
 * 
 * @author Bill Jones
 * 
 */
public class DairyProfileViewController extends SubModuleController {

	public static final String ID = DairyProfileViewController.class.getName();

	private SessionFactory sessionFactory;
	private Dairy localDairy;

	@InjectService()
	public void bind(SessionFactory service) {
		System.err.println(">>>>>>>>>>>>>>>>>> Service BIND: " + service);
		sessionFactory = service;
	}
 
	public void unbind(SessionFactory service) {
		System.err.println(">>>>>>>>>>>>>>>>>> Service UNBIND: " + service);
		sessionFactory = service = null;
	}

	public DairyProfileViewController() {
		super();
		
		System.err.println(">>>>>>>>>>>>>>>>>> DairyProfileViewController: " );

	}

	private Dairy shallowCopy(Dairy d) {
		return d;
	}

	@Override
	public void configureRidgets() {
		System.err.println(">>>>>>>>>>>>>>>>>> in configureRidgets: " );

//		Inject.service(SessionFactory.class.getName()).useRanking().into(this).andStart(Activator.getDefault().getBundle().getBundleContext());
//
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		Dairy dairy = (Dairy) session.createQuery("FROM Dairy").uniqueResult();
//		
//		Assert.isLegal(dairy != null);
		
		localDairy = DairyDemoResourceManager.INSTANCE.getLocalDairy();
		final Dairy workingDairyCopy = shallowCopy(localDairy);

		getWindowRidget().setTitle("Dairy Profile");

		/*
		 * final ITextRidget routeId = getRidget(ITextRidget.class,
		 * RIDGET_ID_ROUTE_ID); routeId.setOutputOnly(true);
		 * routeId.bindToModel(route, "routeId"); routeId.updateFromModel();
		 */

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
//		final ITextRidget txtLOCATION_ADDRESS = getRidget(ITextRidget.class,
//				DairyProfileViewWidgetID.DAIRY_LOCATION_ADDRESS);
//		txtLOCATION_ADDRESS.bindToModel(workingDairyCopy, "LOCATION_ADDRESS");
//		txtLOCATION_ADDRESS.updateFromModel();
//
//		final ITextRidget txtLOCATION_SECTION = getRidget(ITextRidget.class,
//				DairyProfileViewWidgetID.DAIRY_LOCATION_SECTION);
//		txtLOCATION_SECTION.bindToModel(workingDairyCopy, "LOCATION_SECTION");
//		txtLOCATION_SECTION.updateFromModel();
//
//		final ITextRidget txtLOCATION_ESTATE = getRidget(ITextRidget.class,
//				DairyProfileViewWidgetID.DAIRY_LOCATION_ESTATE);
//		txtLOCATION_ESTATE.bindToModel(workingDairyCopy, "LOCATION_ESTATE");
//		txtLOCATION_ESTATE.updateFromModel();
//
//		final ITextRidget txtLOCATION_LOCATION = getRidget(ITextRidget.class,
//				DairyProfileViewWidgetID.DAIRY_LOCATION_LOCATION);
//		txtLOCATION_LOCATION.bindToModel(workingDairyCopy, "LOCATION_LOCATION");
//		txtLOCATION_LOCATION.updateFromModel();
//
//		final ITextRidget txtLOCATION_SUBLOCATION = getRidget(ITextRidget.class,
//				DairyProfileViewWidgetID.DAIRY_LOCATION_SUBLOCATION);
//		txtLOCATION_SUBLOCATION.bindToModel(workingDairyCopy, "LOCATION_SUBLOCATION");
//		txtLOCATION_SUBLOCATION.updateFromModel();
//
//		final ITextRidget txtLOCATION_DIVISION = getRidget(ITextRidget.class,
//				DairyProfileViewWidgetID.DAIRY_LOCATION_DIVISION);
//		txtLOCATION_DIVISION.bindToModel(workingDairyCopy, "LOCATION_DIVISION");
//		txtLOCATION_DIVISION.updateFromModel();
//
//		final ITextRidget txtLOCATION_DISTRICT = getRidget(ITextRidget.class,
//				DairyProfileViewWidgetID.DAIRY_LOCATION_DISTRICT);
//		txtLOCATION_DISTRICT.bindToModel(workingDairyCopy, "LOCATION_DISTRICT");
//		txtLOCATION_DISTRICT.updateFromModel();
//
//		final ITextRidget txtLOCATION_PROVINCE = getRidget(ITextRidget.class,
//				DairyProfileViewWidgetID.DAIRY_LOCATION_PROVINCE);
//		txtLOCATION_PROVINCE.bindToModel(workingDairyCopy, "LOCATION_PROVINCE");
//		txtLOCATION_PROVINCE.updateFromModel();
//
//		final ITextRidget txtLOCATION_POSTALCODE = getRidget(ITextRidget.class,
//				DairyProfileViewWidgetID.DAIRY_LOCATION_POSTALCODE);
//		txtLOCATION_POSTALCODE.bindToModel(workingDairyCopy, "LOCATION_POSTALCODE");
//		txtLOCATION_POSTALCODE.updateFromModel();
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
