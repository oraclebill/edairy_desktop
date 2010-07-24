package com.agritrace.edairy.desktop.ui.services.tests;

import static com.agritrace.edairy.desktop.common.persistence.DairyUtil.createFarmer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.model.requests.RequestType;
import com.agritrace.edairy.desktop.common.model.requests.RequestsFactory;
import com.agritrace.edairy.desktop.common.model.tracking.AcquisitionType;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Purpose;
import com.agritrace.edairy.desktop.common.model.tracking.RearingMode;
import com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingFactory;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;

/**
 * Service Request resource manager
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceRequestResourceManager {

	public static ServiceRequestResourceManager INSTANCE = new ServiceRequestResourceManager();



	private ServiceRequestResourceManager() {

	}

	private void createReq1() throws ParseException {
		final AnimalHealthRequest req = RequestsFactory.eINSTANCE.createAnimalHealthRequest();
		req.setRequestId(1001l);
		req.setDate(DateTimeUtils.DATE_FORMAT.parse("05/03/2010"));


		// MemberShiip
		final Membership ship = DairyFactory.eINSTANCE.createMembership();

		final Person person = ModelFactory.eINSTANCE.createPerson();
		person.setPhoneNumber("13816442241");
		person.setGivenName("Spark");
		person.setFamilyName("Wan");

		ship.setMember(createFarmer("Benjamin", "", "Linus", "123", (Farm) null));
		// ship.setMemberId("1001");
		req.setRequestingMember(ship);

		req.setType(RequestType.VETERINARY);
		req.setDateHeatDetected(Calendar.getInstance().getTime());
		req.setFirstTreatment(Calendar.getInstance().getTime());
		req.setSecondTreatment(Calendar.getInstance().getTime());
		req.setThirdTreatment(Calendar.getInstance().getTime());
		req.setReportedProblem("problem 1");

		final Farm farm = TrackingFactory.eINSTANCE.createFarm();
		farm.setFarmId(new Long(5001).longValue());
		farm.setName("Green Farm");
		final Location location1 = ModelFactory.eINSTANCE.createLocation();
		final PostalLocation defaultLocation = ModelFactory.eINSTANCE.createPostalLocation();
		defaultLocation.setAddress("2 - Ngeche");
		defaultLocation.setSection("Section A");
		defaultLocation.setEstate("Building B");
		defaultLocation.setVillage("West Windosr");
		defaultLocation.setSubLocation("Princeton Junction");
		defaultLocation.setLocation("Princeton");
		defaultLocation.setDivision("Mercer");
		defaultLocation.setDistrict("Central");
		defaultLocation.setProvince("Jersey");
		defaultLocation.setPostalCode("08550");
		location1.setPostalLocation(defaultLocation);
		farm.setLocation(location1);
		createFarmProperties(farm, 20, 20, 8000, 9000);

		req.setFarm(farm);

	}

	private void createReq2() throws ParseException {
		final AnimalHealthRequest req = RequestsFactory.eINSTANCE.createAnimalHealthRequest();
		req.setRequestId(1002l);
		req.setDate(DateTimeUtils.DATE_FORMAT.parse("04/01/2010"));


		// MemberShiip
		final Membership ship = DairyFactory.eINSTANCE.createMembership();

		final Person person = ModelFactory.eINSTANCE.createPerson();
		person.setPhoneNumber("13816424140");
		person.setGivenName("Tracy");
		person.setFamilyName("Copper");

		ship.setMember(createFarmer("Benjamin", "", "Linus", "123", (Farm) null));
		// ship.setMemberId("1002");
		req.setRequestingMember(ship);

		req.setType(RequestType.INSEMINATION);
		req.setDateHeatDetected(Calendar.getInstance().getTime());
		req.setFirstTreatment(Calendar.getInstance().getTime());
		req.setSecondTreatment(Calendar.getInstance().getTime());
		req.setThirdTreatment(Calendar.getInstance().getTime());
		req.setReportedProblem("problem 2");

		final Farm farm = TrackingFactory.eINSTANCE.createFarm();
		farm.setFarmId(new Long(5001).longValue());
		farm.setName("Blue Farm");
		final Location location1 = ModelFactory.eINSTANCE.createLocation();
		final PostalLocation defaultLocation = ModelFactory.eINSTANCE.createPostalLocation();
		defaultLocation.setAddress("2 - Ngeche");
		defaultLocation.setSection("Section A");
		defaultLocation.setEstate("Building B");
		defaultLocation.setVillage("West Windosr");
		defaultLocation.setSubLocation("Princeton Junction");
		defaultLocation.setLocation("Princeton");
		defaultLocation.setDivision("Mercer");
		defaultLocation.setDistrict("Central");
		defaultLocation.setProvince("Jersey");
		defaultLocation.setPostalCode("08550");
		location1.setPostalLocation(defaultLocation);
		farm.setLocation(location1);
		createFarmProperties(farm, 20, 20, 8000, 9000);

		req.setFarm(farm);

	}

	private void createReq3() throws ParseException {
		final AnimalHealthRequest req = RequestsFactory.eINSTANCE.createAnimalHealthRequest();
		req.setRequestId(1003l);
		req.setDate(Calendar.getInstance().getTime());


		// MemberShiip
		final Membership ship = DairyFactory.eINSTANCE.createMembership();

		final Person person = ModelFactory.eINSTANCE.createPerson();
		person.setPhoneNumber("12345678");
		person.setGivenName("John");
		person.setFamilyName("Smith");

		ship.setMember(createFarmer("Benjamin", "", "Linus", "123", (Farm) null));
		// ship.setMemberId("1003");
		req.setRequestingMember(ship);

		req.setType(RequestType.VETERINARY);
		req.setDateHeatDetected(Calendar.getInstance().getTime());
		req.setFirstTreatment(Calendar.getInstance().getTime());
		req.setSecondTreatment(Calendar.getInstance().getTime());
		req.setThirdTreatment(Calendar.getInstance().getTime());
		req.setReportedProblem("problem 3");

		final Farm farm = TrackingFactory.eINSTANCE.createFarm();
		farm.setFarmId(new Long(5001).longValue());
		farm.setName("Yellow Farm");
		final Location location1 = ModelFactory.eINSTANCE.createLocation();
		final PostalLocation defaultLocation = ModelFactory.eINSTANCE.createPostalLocation();
		defaultLocation.setAddress("2 - Ngeche");
		defaultLocation.setSection("Section A");
		defaultLocation.setEstate("Building B");
		defaultLocation.setVillage("West Windosr");
		defaultLocation.setSubLocation("Princeton Junction");
		defaultLocation.setLocation("Princeton");
		defaultLocation.setDivision("Mercer");
		defaultLocation.setDistrict("Central");
		defaultLocation.setProvince("Jersey");
		defaultLocation.setPostalCode("08550");
		location1.setPostalLocation(defaultLocation);
		farm.setLocation(location1);
		createFarmProperties(farm, 20, 20, 8000, 9000);

		req.setFarm(farm);

	}



	private void createFarmProperties(Farm farm, int containerNumber, int animalNumber, int containerId, int animalId)
			throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("MM/dd/yyyy");
		for (int i = 0; i < containerNumber; i++) {
			final Container container = TrackingFactory.eINSTANCE.createContainer();
//			container.setType(ContainerType.BIN);
			// final int id = containerId + i;
			// container.setContainerId(id);
			container.setOwner(farm);
			container.setMeasureType(UnitOfMeasure.LITRE);
			container.setCapacity(50);
			farm.getCans().add(container);
		}

		for (int i = 0; i < animalNumber; i++) {
			final RegisteredAnimal animal1 = TrackingFactory.eINSTANCE.createRegisteredAnimal();
			animal1.setRegistrationId(10001);
			animal1.setGivenName("animal_" + i);
			animal1.setLocation(farm);
			final int n = (int) (10.0 * Math.random());
			final int m = n < 3 ? 10 + n : n + 3;
			final String date = m > 9 ? "0" + n + "/" + m + "/200" + n : "0" + n + "/0" + m + "/200" + n;
			final Date effectedDate = sdf.parse(date);
			animal1.setDateOfAcquisition(effectedDate);
			animal1.setPurpose(Purpose.DAIRY);
			if (i % 2 == 0) {
				animal1.setGender(Gender.FEMALE);
			} else {
				animal1.setGender(Gender.MALE);
			}
			final int rearingModelValue = i % 7;
			animal1.setRearingMode(RearingMode.get(rearingModelValue));
			final int acquisionType = i % 5;
			animal1.setAcquisitionType(AcquisitionType.get(acquisionType));

			final ReferenceAnimalType animal1_type = TrackingFactory.eINSTANCE.createReferenceAnimalType();
			// animal1_type.setAnimalTypeId(animalId + i);
			animal1_type.setSpecies("Cow");
			animal1_type.setSpecies("jersey");
			animal1.setAnimalType(animal1_type);
			farm.getAnimals().add(animal1);

		}
	}
}
