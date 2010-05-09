package com.agritrace.edairy.desktop.ui.services.tests;

import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.ui.swt.controllers.AbstractSubModuleControllerTest;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.service.ui.controllers.ServiceLogViewController;
import com.agritrace.edairy.service.ui.views.ServiceRequestFilterSection;
import com.agritrace.edairy.service.ui.views.utils.ServiceUtils;

/**
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceRequestControllerTestCase extends
		AbstractSubModuleControllerTest<ServiceLogViewController> {

	@Override
	protected ServiceLogViewController createController(ISubModuleNode node) {
		ServiceLogViewController newInst = new ServiceLogViewController();
		node.setNodeId(new NavigationNodeId("edm.services.log"));
		newInst.setNavigationNode(node);
		return newInst;

	}

	public void testFilterSection() {

		// Default value of Start Date
		ITextRidget startDate = (ITextRidget) getController().getRidget(
				ITextRidget.class, ServiceRequestFilterSection.STARTE_DATE); //$NON-NLS-1$
		assertEquals(startDate.getText(), ServiceUtils.getFirstDayofMonth());
		
		// Default value of End date
		ITextRidget endDate = (ITextRidget) getController().getRidget(
				ITextRidget.class, ServiceRequestFilterSection.END_DATE); //$NON-NLS-1$
		assertEquals(endDate.getText(), ServiceUtils.getLastDayofMonth());
		
		// Test Apply Button, Change some condition
		final IActionRidget apply = (IActionRidget) getController().getRidget(
				IActionRidget.class, ServiceRequestFilterSection.BIND_ID_APPLY);

		
		// Test Reset Button
//		final IActionRidget reset = (IActionRidget) getController().getRidget(
//		IActionRidget.class, ServiceRequestFilterSection.BIND_ID_RESET);
//reset.fireAction();

		// TODO More items

	}

	public void testMasterDetail() {

	}

}
