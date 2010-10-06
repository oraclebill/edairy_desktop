package com.agritrace.edairy.desktop.ui.services.tests;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.ui.swt.controllers.AbstractSubModuleControllerTest;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;
import org.hibernate.Session;

import com.agritrace.edairy.desktop.collection.services.TestPersistenceModule;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.services.ui.controllers.AnimalHealthRequestViewController;
import com.agritrace.edairy.desktop.services.ui.views.AnimalHealthRequestView;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Test case for service request controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceRequestControllerTestCase extends AbstractSubModuleControllerTest<AnimalHealthRequestViewController> {
	@Inject
	private static Provider<Session> sessionProvider;
	
	static {
		Guice.createInjector(new TestPersistenceModule(), new AbstractModule() {
			@Override
			protected void configure() {
				requestStaticInjection(ServiceRequestControllerTestCase.class);
			}
		});
	}

	List<AnimalHealthRequest> requests = new ArrayList<AnimalHealthRequest>();

	@Override
	protected AnimalHealthRequestViewController createController(ISubModuleNode node) {
		final AnimalHealthRequestViewController newInst = Guice.createInjector(
				new TestPersistenceModule()).getInstance(AnimalHealthRequestViewController.class);
		node.setNodeId(new NavigationNodeId("edm.services.log"));
		newInst.setNavigationNode(node);
		return newInst;
	}

	/**
	 * Initial model from the XML file
	 * 
	 * @throws ParseException
	 * @throws CoreException
	 */
	private void initModel() {
		Farm farm = DairyUtil.createFarm("daisy dukes", DairyUtil.createLocation(null, null, null));
		Farmer farmer = DairyUtil.createFarmer("Joe", "", "Gibbs", "1234567", Arrays.asList(farm));
		Date now = new Date();
		
		Membership membership = DairyUtil.createMembership(now, now, farmer);
		Dairy testDairy = DairyFactory.eINSTANCE.createDairy();

		testDairy.setLegalName("test");
		testDairy.setCompanyName("test co");
		testDairy.setPhoneNumber("12345678");
		testDairy.getMemberships().add(membership);
		testDairy.setLocation(DairyUtil.createLocation(null, null, null));
		sessionProvider.get().save(testDairy);
	}

	/**
	 * Test the filter section and buttons
	 */
	public void testWidgetsBound() {

		initModel();

		IController controller = getController();

		// Default value of Start Date
		final ITextRidget startDate = controller.getRidget(ITextRidget.class, AnimalHealthRequestView.START_DATE_TEXT);
		assertEquals(startDate.getText(), DateTimeUtils.getFirstDayofMonth());

		// Default value of End date
		final ITextRidget endDate = controller.getRidget(ITextRidget.class, AnimalHealthRequestView.END_DATE_TEXT);
		assertEquals(endDate.getText(), DateTimeUtils.getLastDayofMonth());

		// All type button
		final IToggleButtonRidget allTypeBtn = controller.getRidget(IToggleButtonRidget.class,
				AnimalHealthRequestView.REQUEST_TYPE_ALL);
		assertTrue(allTypeBtn.isSelected());

		// Verternary (Request type), By defalut verternary button is unchecked
		final IToggleButtonRidget verterTypeBtn = controller.getRidget(IToggleButtonRidget.class,
				AnimalHealthRequestView.REQUEST_TYPE_VERTERNARY);
		assertFalse(verterTypeBtn.isSelected());

		// By default insemeniation button is unchecked
		final IToggleButtonRidget insemenitationTypeBtn = getController().getRidget(IToggleButtonRidget.class,
				AnimalHealthRequestView.REQUEST_TYPE_INSEMINATION);
		assertFalse(insemenitationTypeBtn.isSelected());

		// farm lookup

		// member lookup

		// search button

		// Configure column formatter for table ridget
		final ITableRidget masterTable = controller.getRidget(ITableRidget.class,
				AbstractMasterDetailsComposite.BIND_ID_TABLE);
		assertNotNull(masterTable);
		assertNotNull(masterTable.getObservableList());

		controller.getRidget(IActionRidget.class, AnimalHealthRequestView.BIND_ID_FILTER_SEARCH);

		// Test Reset Button
		final IActionRidget reset = controller.getRidget(IActionRidget.class, AnimalHealthRequestView.BIND_ID_FILTER_RESET);
		reset.fireAction();


		// TODO More items

	}

	public void testMasterDetail() {
		// TODO

	}

}
