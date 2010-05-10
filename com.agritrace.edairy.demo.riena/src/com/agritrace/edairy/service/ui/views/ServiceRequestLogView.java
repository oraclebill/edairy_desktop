package com.agritrace.edairy.service.ui.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.ridgets.swt.uibinding.SwtControlRidgetMapper;
import org.eclipse.riena.ui.ridgets.uibinding.DefaultBindingManager;
import org.eclipse.riena.ui.ridgets.uibinding.IBindingManager;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.agritrace.edairy.service.ui.views.utils.ServiceUtils;

/**
 * Services log view
 * 
 * @author Spark Wan
 * 
 */
public class ServiceRequestLogView extends SubModuleView {

	public static final String ID = ServiceRequestLogView.class.getName();
	public static final String BIND_ID_MASTER = "master"; //$NON-NLS-1$
	@Override
	protected void basicCreatePartControl(Composite parent) {

		parent.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));

		parent.setLayout(new GridLayout(1, false));

		Composite panel = new Composite(parent, SWT.NULL);
		panel.setLayout(new GridLayout(2, false));
		panel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		panel.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));

		// Creates filter section
		ServiceRequestFilterSection filterSection = new ServiceRequestFilterSection();
		filterSection.createSection(panel);	
		// Since Master/Detail are in different composite, we need to pass the panel as detail composite
		final ServiceRequestMasterDetailComposite mdComposite = new ServiceRequestMasterDetailComposite(
				panel, SWT.NONE);		
//		mdComposite.getTable().add
		addUIControl(mdComposite, BIND_ID_MASTER);
		this.addUIControl(mdComposite.getTable(), AbstractMasterDetailsComposite.BIND_ID_TABLE);
		mdComposite.addTypeChangeListener(new IRequestTypeChangeListener(){

			@Override
			public void typeChanged() {
				// Add master details controls into
				List<Object> injectedControls = new ArrayList<Object>();
				for (Object control : mdComposite.getUIControls()) {
					
					if (control instanceof Control
							&& !((Control) control).isDisposed()) {
						String bindId = SWTBindingPropertyLocator
						.getInstance()
						.locateBindingProperty(
								control);
						ServiceRequestLogView.this.addUIControl(
								control, bindId);
						//  Only not existing widget or disposed existing ridget need to injected again
						if (ServiceRequestLogView.this.getController()
								.getRidget(bindId) == null
								|| (ServiceRequestLogView.this.getController()
										.getRidget(bindId) != null && ((Control) (ServiceRequestLogView.this
										.getController().getRidget(bindId)
										.getUIControl())).isDisposed())) {
							injectedControls.add(control);
						}			
						//injectedControls.add(control);
					}							
				}
				// SwtRidgetFactory.
				ServiceUtils.injectRidgets(
						ServiceRequestLogView.this.getController(),
						injectedControls, SWTBindingPropertyLocator
						.getInstance());
				//mdComposite.forceFocus();
				
			}});
//				ServiceRequestMasterDetailComposite.REQUEST_TYPE_CHANGED,
//				new Listener() {
//
//					@Override
//					public void handleEvent(Event event) {
//						
//					
//						
//						
//			
//
//					}
//				});
		// Add master details controls into 
		for (Object control : mdComposite.getUIControls()) {
			addUIControl(control, SWTBindingPropertyLocator.getInstance()
					.locateBindingProperty(control));
		}


	}


}
