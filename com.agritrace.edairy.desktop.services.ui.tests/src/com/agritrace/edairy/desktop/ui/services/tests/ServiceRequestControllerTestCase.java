package com.agritrace.edairy.desktop.ui.services.tests;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.ui.swt.controllers.AbstractSubModuleControllerTest;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;

import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.ui.util.ServiceUtils;
import com.agritrace.edairy.desktop.services.ui.views.ServiceRequestFilterSection;
import com.agritrace.edairy.desktop.services.ui.controllers.*;

/**
 * Test case for service request controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceRequestControllerTestCase extends AbstractSubModuleControllerTest<ServiceLogViewController> {

    List<AnimalHealthRequest> requests = new ArrayList<AnimalHealthRequest>();
    private ServiceLogViewController newInst;

    @Override
    protected ServiceLogViewController createController(ISubModuleNode node) {
	try {
	    initModel();
	} catch (final ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (final CoreException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	newInst = new ServiceLogViewController();
	node.setNodeId(new NavigationNodeId("edm.services.log"));
	newInst.setNavigationNode(node);
	newInst.setEMFModels(requests);
	return newInst;

    }

    /**
     * Initial model from the XML file
     * 
     * @throws ParseException
     * @throws CoreException
     */
    private void initModel() throws ParseException, CoreException {
	ServiceRequestResourceManager.INSTANCE.loadResources();
	requests = ServiceRequestResourceManager.INSTANCE.getObjectsFromDairyModel(AnimalHealthRequest.class);

    }

    /**
     * Test the filter section and buttons
     */
    public void testFilterSection() {

	// Default value of Start Date
	final ITextRidget startDate = getController().getRidget(ITextRidget.class,
		ServiceRequestFilterSection.STARTE_DATE);
	assertEquals(startDate.getText(), ServiceUtils.getFirstDayofMonth());

	// Default value of End date
	final ITextRidget endDate = getController().getRidget(ITextRidget.class, ServiceRequestFilterSection.END_DATE);
	assertEquals(endDate.getText(), ServiceUtils.getLastDayofMonth());

	// All type button
	final IToggleButtonRidget allTypeBtn = getController().getRidget(IToggleButtonRidget.class,
		ServiceRequestFilterSection.REQUEST_TYPE_ALL);
	assertTrue(allTypeBtn.isSelected());

	// Verternary (Request type), By defalut verternary button is unchecked
	final IToggleButtonRidget verterTypeBtn = getController().getRidget(IToggleButtonRidget.class,
		ServiceRequestFilterSection.REQUEST_TYPE_VERTERNARY);
	assertFalse(verterTypeBtn.isSelected());

	// By default insemeniation button is unchecked
	final IToggleButtonRidget insemenitationTypeBtn = getController().getRidget(IToggleButtonRidget.class,
		ServiceRequestFilterSection.REQUEST_TYPE_INSEMINATION);
	assertFalse(insemenitationTypeBtn.isSelected());

	// Verfiy
	// Configure column formatter for table ridget
	final ITableRidget masterTable = getController().getRidget(ITableRidget.class,
		AbstractMasterDetailsComposite.BIND_ID_TABLE);
	assertEquals(masterTable.getObservableList().size(), 3);

	// Test Apply Button, Change some condition
	final IActionRidget apply = getController().getRidget(IActionRidget.class,
		ServiceRequestFilterSection.BIND_ID_APPLY);

	// Test Reset Button
	// final IActionRidget reset = (IActionRidget)
	// getController().getRidget(
	// IActionRidget.class, ServiceRequestFilterSection.BIND_ID_RESET);
	// reset.fireAction();

	// TODO More items

    }

    public void testMasterDetail() {
	// TODO

    }

}
