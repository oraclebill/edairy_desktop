package com.agritrace.edairy.desktop.ui.services.tests;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.ui.swt.controllers.AbstractSubModuleControllerTest;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.Person;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.model.requests.RequestType;
import com.agritrace.edairy.model.requests.RequestsFactory;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.model.tracking.TrackingFactory;
import com.agritrace.edairy.service.ui.controllers.ServiceLogViewController;
import com.agritrace.edairy.service.ui.views.ServiceRequestFilterSection;
import com.agritrace.edairy.service.ui.views.utils.ServiceUtils;

/**
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceRequestControllerTestCase extends
		AbstractSubModuleControllerTest<ServiceLogViewController> {


	public static String EMF_MODEL_PATH = "c:/servicerequest.xml";
	List<AnimalHealthRequest> requests = new ArrayList<AnimalHealthRequest>();
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		File file = new File(EMF_MODEL_PATH);
		if (!file.exists()) {
			
			List<EObject> objects = new ArrayList<EObject>();
			List<EObject> reqs = this
			.createServiceRequestList();
			objects.addAll(reqs);
			for (EObject obj: reqs)
			{
				if (obj instanceof AnimalHealthRequest )
				{
					AnimalHealthRequest req = (AnimalHealthRequest)obj;
					objects.add(req.getRequestingMember());
					objects.add(req.getFarm());
					objects.add(req.getRequestingMember().getMember());					
				}
			}
			EMFXMLSaveLoader.writeEObjectList2XML(EMF_MODEL_PATH, objects);
		} else {
			XMLResource resource = EMFXMLSaveLoader
					.readXMLResource(EMF_MODEL_PATH);
			TreeIterator<EObject> iter= resource.getAllContents();
			while (resource != null && iter.hasNext()) {
				EObject eobj = iter.next();
				if (eobj instanceof AnimalHealthRequest) {
					requests.add((AnimalHealthRequest) eobj);
				}
			}
		}

	}

	@Override
	protected ServiceLogViewController createController(ISubModuleNode node) {
		ServiceLogViewController newInst = new ServiceLogViewController();
		node.setNodeId(new NavigationNodeId("edm.services.log"));
		newInst.setNavigationNode(node);
		newInst.setEMFModels(requests);
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

	

	
	private List<EObject> createServiceRequestList() {

		// This is for demo only
		List<EObject> ret = new ArrayList<EObject>();
		AnimalHealthRequest req1 = RequestsFactory.eINSTANCE
				.createAnimalHealthRequest();
		req1.setRequestId(1001l);
		req1.setDate(Calendar.getInstance().getTime());
		// MemberShiip
		Membership ship = DairyFactory.eINSTANCE.createMembership();
		Person person = ModelFactory.eINSTANCE.createPerson();
		person.setPhoneNumber("13816442241");
		person.setName("Spark Wan");
		ship.setMember(person);
		ship.setMemberId("1001");
		req1.setRequestingMember(ship);

		Farm farm = TrackingFactory.eINSTANCE.createFarm();
		farm.setName("Farm1");

		req1.setFarm(farm);
		req1.setType(RequestType.VETERINARY);
		req1.setDateHeatDetected(Calendar.getInstance().getTime());
		req1.setSecondTreatment(Calendar.getInstance().getTime());
		req1.setThirdTreatment(Calendar.getInstance().getTime());
		ret.add(req1);

		AnimalHealthRequest req2 = RequestsFactory.eINSTANCE
				.createAnimalHealthRequest();
		req2.setRequestId(1002l);
		req2.setDate(Calendar.getInstance().getTime());
		// MemberShiip
		Membership ship2 = DairyFactory.eINSTANCE.createMembership();
		Person person2 = ModelFactory.eINSTANCE.createPerson();
		person2.setPhoneNumber("12345678");
		person2.setName("Tracy Smith");
		ship2.setMember(person2);
		ship2.setMemberId("1002");
		req2.setRequestingMember(ship2);

		Farm farm2 = TrackingFactory.eINSTANCE.createFarm();
		farm2.setName("Farm2");

		req2.setFarm(farm2);
		req2.setType(RequestType.INSEMINATION);
		req2.setDateHeatDetected(Calendar.getInstance().getTime());
		req2.setSecondTreatment(Calendar.getInstance().getTime());
		req2.setThirdTreatment(Calendar.getInstance().getTime());
		ret.add(req2);

		AnimalHealthRequest req3 = RequestsFactory.eINSTANCE
				.createAnimalHealthRequest();
		req3.setRequestId(1003l);
		try {
			req3.setDate(ServiceUtils.DATE_FORMAT.parse("04/01/2010"));
		} catch (ParseException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
		// MemberShiip
		Membership ship3 = DairyFactory.eINSTANCE.createMembership();
		Person person3 = ModelFactory.eINSTANCE.createPerson();
		person3.setPhoneNumber("12345678");
		person3.setName("Tracy Smith");
		ship3.setMember(person3);
		ship3.setMemberId("1003");
		req3.setRequestingMember(ship3);

		Farm farm3 = TrackingFactory.eINSTANCE.createFarm();
		farm3.setName("Farm3");

		req3.setFarm(farm3);
		req3.setType(RequestType.INSEMINATION);
		req3.setDateHeatDetected(Calendar.getInstance().getTime());
		req3.setSecondTreatment(Calendar.getInstance().getTime());
		req3.setThirdTreatment(Calendar.getInstance().getTime());
		ret.add(req3);
		return ret;
	}
	
	
}
