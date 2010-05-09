package com.agritrace.edairy.service.ui.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.Person;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.model.requests.RequestType;
import com.agritrace.edairy.model.requests.RequestsFactory;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.model.tracking.TrackingFactory;
import com.agritrace.edairy.service.ui.views.utils.ServiceUtils;

/**
 * Service log view controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceLogViewController extends CommonSubModuleViewController {

	private List<AnimalHealthRequest> filtedResult;
	private List<AnimalHealthRequest> origalRequestList = new ArrayList<AnimalHealthRequest>();
	public static final String ID = ServiceLogViewController.class.getName();

	public static final int EVENT_TYPE_TABLE_INPUT_CHANGED = 1;

	public ServiceLogViewController() {
		super();
		this.createServiceRequestList();
		this.setFilteredResult(this.getServiceRequestList());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.agritrace.edairy.service.ui.controllers.CommonSubModuleViewController
	 * #addSubModuleControllers()
	 */
	@Override
	protected void addSubModuleControllers() {

		addSubModuleControllerDelegate(new ServiceRequestLogFilterControllerDelegate(
				this));
		addSubModuleControllerDelegate(new ServiceRequestLogMasterDetailControllerDelegate(
				this));
	}

	public List<AnimalHealthRequest> getServiceRequestList() {

		return this.origalRequestList;
	}

	private void createServiceRequestList() {

		// This is for demo only
		List<AnimalHealthRequest> ret = this.origalRequestList;
		ret.clear();
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
	}

	public List<AnimalHealthRequest> getFilteredResult() {
		return filtedResult;
	}

	public void setFilteredResult(List<AnimalHealthRequest> result) {
		filtedResult = result;
	}

	public void fireListeners(int eventType) {
		for (ISubModuleControllerDelegate delegate : this
				.getSubModuleControllerDelegates()) {
			delegate.fireListener(eventType);
		}

	}
}
