package com.agritrace.edairy.service.core;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.agritrace.edairy.desktop.model.IDairyResourceManager;
import com.agritrace.edairy.desktop.model.ResourceManager;
import com.agritrace.edairy.model.ContainerType;
import com.agritrace.edairy.model.Gender;
import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.Person;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.UnitOfMeasure;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.model.requests.RequestType;
import com.agritrace.edairy.model.requests.RequestsFactory;
import com.agritrace.edairy.model.tracking.AcquisitionType;
import com.agritrace.edairy.model.tracking.Container;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.model.tracking.Purpose;
import com.agritrace.edairy.model.tracking.RearingMode;
import com.agritrace.edairy.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.model.tracking.TrackingFactory;
import com.agritrace.edairy.service.ui.views.utils.ServiceUtils;
import com.agritrace.edairy.ui.EDairyActivator;

/**
 * Service Request resource manager
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceRequestResourceManager {

    public static ServiceRequestResourceManager INSTANCE = new ServiceRequestResourceManager();

    private Resource serviceRequestResource;

    public static final String FILE_PATH = IDairyResourceManager.XMLDB_BASE + "/servicerequests.xml";

    private ServiceRequestResourceManager() {

    }

    public void createServiceRequestsResource() throws ParseException {
	final URI farmResourceURI = URI.createFileURI(FILE_PATH);
	serviceRequestResource = ResourceManager.INSTANCE.createResource(farmResourceURI);

	createReq1();

	createReq2();
	createReq3();

	try {
	    ResourceManager.INSTANCE.saveResource(serviceRequestResource);
	} catch (final IllegalArgumentException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (final IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    private void createReq1() throws ParseException {
	final AnimalHealthRequest req = RequestsFactory.eINSTANCE.createAnimalHealthRequest();
	req.setRequestId(1001l);
	req.setDate(ServiceUtils.DATE_FORMAT.parse("05/03/2010"));

	serviceRequestResource.getContents().add(req);

	// MemberShiip
	final Membership ship = DairyFactory.eINSTANCE.createMembership();
	serviceRequestResource.getContents().add(ship);

	final Person person = ModelFactory.eINSTANCE.createPerson();
	person.setPhoneNumber("13816442241");
	person.setGivenName("Spark");
	person.setFamilyName("Wan");
	serviceRequestResource.getContents().add(person);

	ship.setMember(person);
	ship.setMemberId("1001");
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
	serviceRequestResource.getContents().add(farm);

    }

    private void createReq2() throws ParseException {
	final AnimalHealthRequest req = RequestsFactory.eINSTANCE.createAnimalHealthRequest();
	req.setRequestId(1002l);
	req.setDate(ServiceUtils.DATE_FORMAT.parse("04/01/2010"));

	serviceRequestResource.getContents().add(req);

	// MemberShiip
	final Membership ship = DairyFactory.eINSTANCE.createMembership();
	serviceRequestResource.getContents().add(ship);

	final Person person = ModelFactory.eINSTANCE.createPerson();
	person.setPhoneNumber("13816424140");
	person.setGivenName("Tracy");
	person.setFamilyName("Copper");
	serviceRequestResource.getContents().add(person);

	ship.setMember(person);
	ship.setMemberId("1002");
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
	serviceRequestResource.getContents().add(farm);

    }

    private void createReq3() throws ParseException {
	final AnimalHealthRequest req = RequestsFactory.eINSTANCE.createAnimalHealthRequest();
	req.setRequestId(1003l);
	req.setDate(Calendar.getInstance().getTime());

	serviceRequestResource.getContents().add(req);

	// MemberShiip
	final Membership ship = DairyFactory.eINSTANCE.createMembership();
	serviceRequestResource.getContents().add(ship);

	final Person person = ModelFactory.eINSTANCE.createPerson();
	person.setPhoneNumber("12345678");
	person.setGivenName("John");
	person.setFamilyName("Smith");
	serviceRequestResource.getContents().add(person);

	ship.setMember(person);
	ship.setMemberId("1003");
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
	serviceRequestResource.getContents().add(farm);

    }

    /**
     * Loads resources
     */
    public void loadResources() {
	final File file = new File(ServiceRequestResourceManager.FILE_PATH);
	// if file doesn't exists, we will create it first
	if (!file.exists()) {

	    try {
		// Creates the files
		createServiceRequestsResource();
	    } catch (final ParseException e) {
		e.printStackTrace();
	    }

	}
	final URI dairyResourceURI = URI.createFileURI(ServiceRequestResourceManager.FILE_PATH);
	serviceRequestResource = ResourceManager.INSTANCE.loadResource(dairyResourceURI);
    }

    public <T extends EObject> List<T> getObjectsFromDairyModel(Class<T> type) throws CoreException {
	final List<T> objectList = new ArrayList<T>();
	if (serviceRequestResource == null) {
	    loadResources();
	}
	if (serviceRequestResource == null) {
	    throw new CoreException(new Status(IStatus.ERROR, EDairyActivator.PLUGIN_ID, "can't load dairy modle"));
	}
	final List<EObject> objects = serviceRequestResource.getContents();
	for (final EObject object : objects) {
	    if (type.isAssignableFrom(object.getClass())) {
		objectList.add((T) object);
	    }
	}
	return objectList;
    }

    private void createFarmProperties(Farm farm, int containerNumber, int animalNumber, int containerId, int animalId)
	    throws ParseException {
	final SimpleDateFormat sdf = new SimpleDateFormat();
	sdf.applyPattern("MM/dd/yyyy");
	for (int i = 0; i < containerNumber; i++) {
	    final Container container = TrackingFactory.eINSTANCE.createContainer();
	    container.setType(ContainerType.BIN);
	    final int id = containerId + i;
	    container.setContainerId("" + id);
	    container.setOwner(farm);
	    container.setMeasureType(UnitOfMeasure.LITRE);
	    container.setCapacity(50);
	    farm.getCans().add(container);
	}

	for (int i = 0; i < animalNumber; i++) {
	    final RegisteredAnimal animal1 = TrackingFactory.eINSTANCE.createRegisteredAnimal();
	    animal1.setAnimnalRegistrationId(10001);
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
	    animal1_type.setAnimalTypeId(animalId + i);
	    animal1_type.setSpecies("Cow");
	    animal1_type.setSpecies("jersey");
	    animal1.setAnimalType(animal1_type);
	    farm.getAnimals().add(animal1);

	    this.serviceRequestResource.getContents().add(animal1_type);
	}
    }
}
