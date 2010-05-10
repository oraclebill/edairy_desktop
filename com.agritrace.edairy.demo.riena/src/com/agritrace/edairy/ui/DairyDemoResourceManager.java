package com.agritrace.edairy.ui;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.agritrace.edairy.model.ContainerType;
import com.agritrace.edairy.model.Gender;
import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.Person;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.UnitOfMeasure;
import com.agritrace.edairy.model.dairy.Dairy;
import com.agritrace.edairy.model.dairy.DairyContainer;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.DairyFunction;
import com.agritrace.edairy.model.dairy.DairyLocation;
import com.agritrace.edairy.model.dairy.Employee;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.dairy.MembershipStatus;
import com.agritrace.edairy.model.dairy.Route;
import com.agritrace.edairy.model.dairy.Vehicle;
import com.agritrace.edairy.model.tracking.AcquisitionType;
import com.agritrace.edairy.model.tracking.Container;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.model.tracking.Purpose;
import com.agritrace.edairy.model.tracking.RearingMode;
import com.agritrace.edairy.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.model.tracking.TrackingFactory;

public class DairyDemoResourceManager{

	public static DairyDemoResourceManager INSTANCE = new DairyDemoResourceManager();

	private Resource farmResource;

	private Resource dairyResource;

	private DairyDemoResourceManager(){

	}

	public void  createFarmResource(){
		URI farmResourceURI = URI.createFileURI("c:/temp/eDairy/farmDB.farm");
		farmResource = ResourceManager.INSTANCE.createResource(farmResourceURI);
	}
	
	private List<Farm> createFarms(int farmId)throws ParseException{
		List<Farm> farms = new ArrayList<Farm>();
		Farm farm = TrackingFactory.eINSTANCE.createFarm();
		farm.setFarmId(new Long(farmId).longValue());
		farm.setName("Green Farm_"+farmId);
		Location location1 = ModelFactory.eINSTANCE.createLocation();
		PostalLocation defaultLocation = ModelFactory.eINSTANCE.createPostalLocation();
		defaultLocation.setAddress("2 - Ngeche");
		defaultLocation.setSection("Section A");
		defaultLocation.setEstate("Building B");
		defaultLocation.setVillage("West Windosr");
		defaultLocation.setSubLocation("Princeton Junction");
		defaultLocation.setLocation("Princeton");
		defaultLocation.setDivision("Mercer");
		defaultLocation.setDistrict("Central");
		defaultLocation.setProvince("Western");
		defaultLocation.setPostalCode("08550");
		location1.setPostalLocation(defaultLocation);
		farm.setLocation(location1);
		createFarmProperties(farm,20,20,8000,9000);
		farms.add(farm);

		Farm farm1 = TrackingFactory.eINSTANCE.createFarm();
		farm1.setFarmId(new Long(farmId+1).longValue());
		farm1.setName("Farm_"+farmId);
		Location location2 = ModelFactory.eINSTANCE.createLocation();
		PostalLocation pLocation2 = ModelFactory.eINSTANCE.createPostalLocation();
		pLocation2.setAddress("12 -North Post");
		pLocation2.setSection("Section A");
		pLocation2.setEstate("Estate 1");
		pLocation2.setVillage("West Windosr");
		pLocation2.setSubLocation("Princeton Junction");
		pLocation2.setLocation("Princeton");
		pLocation2.setDivision("Mercer");
		pLocation2.setDistrict("Central");
		pLocation2.setProvince("Western");
		pLocation2.setPostalCode("08550");
		location2.setPostalLocation(pLocation2);
		farm1.setLocation(location2);
		createFarmProperties(farm1,10,15,8050,9050);
		farms.add(farm1);
		
		return farms;
	}

	public void createDairyResource() throws ParseException{
		URI dairyResourceURI = URI.createFileURI("c:/temp/eDairy/dairyDB.dairy");

		dairyResource = ResourceManager.INSTANCE.createResource(dairyResourceURI);

		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("MM/dd/yyyy");
		//location
		Location location1 = ModelFactory.eINSTANCE.createLocation();
		PostalLocation defaultLocation = ModelFactory.eINSTANCE.createPostalLocation();
		defaultLocation.setAddress("2 - Ngeche");
		defaultLocation.setSection("Section A");
		defaultLocation.setEstate("Building B");
		defaultLocation.setVillage("West Windosr");
		defaultLocation.setSubLocation("Princeton Junction");
		defaultLocation.setLocation("Princeton");
		defaultLocation.setDivision("Mercer");
		defaultLocation.setDistrict("Central");
		defaultLocation.setProvince("Western");
		defaultLocation.setPostalCode("08550");
		location1.setPostalLocation(defaultLocation);
		//	
		//		
		Location location2 = ModelFactory.eINSTANCE.createLocation();
		PostalLocation pLocation2 = ModelFactory.eINSTANCE.createPostalLocation();
		pLocation2.setAddress("12 -North Post");
		pLocation2.setSection("Section A");
		pLocation2.setEstate("Estate 1");
		pLocation2.setVillage("West Windosr");
		pLocation2.setSubLocation("Princeton Junction");
		pLocation2.setLocation("Princeton");
		pLocation2.setDivision("Mercer");
		pLocation2.setDistrict("Central");
		pLocation2.setProvince("Western");
		pLocation2.setPostalCode("08550");
		location2.setPostalLocation(pLocation2);
		//		
		Location location3 = ModelFactory.eINSTANCE.createLocation();
		PostalLocation pLocation3 = ModelFactory.eINSTANCE.createPostalLocation();
		pLocation3.setAddress("12 -North Post");
		pLocation3.setSection("Section A");
		pLocation3.setEstate("Estate 1");
		pLocation3.setVillage("Edison");
		pLocation3.setSubLocation("New ");
		pLocation3.setLocation("Princeton");
		pLocation3.setDivision("Middlesex ");
		pLocation3.setDistrict("Central");
		pLocation3.setProvince("Western");
		pLocation3.setPostalCode("08550");
		location3.setPostalLocation(pLocation3);

		//add locations to contents
		//		dairyResource.getContents().add(location1);
		//		dairyResource.getContents().add(location2);
		//		dairyResource.getContents().add(location3);

		//drivers
		Employee driver1 = DairyFactory.eINSTANCE.createEmployee();
		driver1.setName("Joseph Limuru");
		driver1.setGivenName("Joseph");
		driver1.setFamilyName("Limuru");
		driver1.setLocation(location1);
		driver1.setPhoneNumber("609-356-3421");
		driver1.setJobFunction("Driver");
		Date startDate  = sdf.parse("04/18/1998");
		driver1.setStartDate(startDate);
		//		
		Employee driver2 = DairyFactory.eINSTANCE.createEmployee();
		driver2.setName("John Smith");
		driver2.setGivenName("John");
		driver2.setFamilyName("Smith");
		driver2.setLocation(location2);
		driver2.setPhoneNumber("609-456-7898");
		driver2.setJobFunction("Driver");
		Date startDate2  = sdf.parse("02/03/1994");
		driver2.setStartDate(startDate2);
		//		
		Employee driver3 = DairyFactory.eINSTANCE.createEmployee();
		driver3.setName("Jason Spencer");
		driver3.setGivenName("Jason");
		driver3.setFamilyName("Spencer");
		driver3.setLocation(location3);
		driver3.setPhoneNumber("609-478-5565");
		driver3.setJobFunction("Driver");
		Date startDate3  = sdf.parse("07/14/1994");
		driver3.setStartDate(startDate3);
		//add drivers to contents
		//		dairyResource.getContents().add(driver1);
		//		dairyResource.getContents().add(driver2);
		//		dairyResource.getContents().add(driver3);

		//create vehicles
		Vehicle v1 = DairyFactory.eINSTANCE.createVehicle();
		v1.setAssetId(new Long(1001));
		v1.setCapacityInTonnes("2");
		v1.setChassisNumber("23489-1");
		Date acquiredDate  = sdf.parse("02/18/2008");
		v1.setDateAcquired(acquiredDate);
		v1.setDriver(driver1);
		v1.setEngineNumber("21223-3");
		v1.setLogBookNumber("23001");
		v1.setMake("Toyota");
		v1.setModel("Tacoma");
		v1.setRegistrationNumber("1001- Toyota Tacoma");

		Vehicle v2 = DairyFactory.eINSTANCE.createVehicle();
		v2.setAssetId(new Long(1002));
		v2.setCapacityInTonnes("2");
		v2.setChassisNumber("45789-1");
		Date acquiredDate2  = sdf.parse("07/21/2007");
		v2.setDateAcquired(acquiredDate2);
		v2.setDriver(driver2);
		v2.setEngineNumber("45688-3");
		v2.setLogBookNumber("56558");
		v2.setMake("Toyota");
		v2.setModel("Tacoma");
		v2.setRegistrationNumber("1002- Toyota Tacoma");


		Vehicle v3 = DairyFactory.eINSTANCE.createVehicle();
		v3.setAssetId(new Long(1003));
		v3.setCapacityInTonnes("2");
		v3.setChassisNumber("47878-1");
		Date acquiredDate3  = sdf.parse("07/27/2007");
		v3.setDateAcquired(acquiredDate3);
		v3.setDriver(driver3);
		v3.setEngineNumber("45689-3");
		v3.setLogBookNumber("56559");
		v3.setMake("Toyota");
		v3.setModel("Tacoma");
		v3.setRegistrationNumber("1003- Toyota Tacoma");

		//add vehicles
		//		dairyResource.getContents().add(v1);
		//		dairyResource.getContents().add(v2);
		//		dairyResource.getContents().add(v3);
		//
		//		
		//		//dairyLocation
		DairyLocation dLocation = DairyFactory.eINSTANCE.createDairyLocation();
		dLocation.setName("stop1");
		Date openDate  = sdf.parse("04/27/2005");
		dLocation.setDateOpened(openDate);
		dLocation.setCode("DL001");
		dLocation.setPhone("609-457-8989");
		dLocation.getFunctions().add(DairyFunction.MILK_COLLECTION);
		Location dairyLocation1 = ModelFactory.eINSTANCE.createLocation();
		PostalLocation p1 = ModelFactory.eINSTANCE.createPostalLocation();
		p1.setAddress("22 - Ngeche");
		p1.setSection("Section A");
		p1.setEstate("Building B");
		p1.setVillage("West Windosr");
		p1.setSubLocation("Princeton Junction");
		p1.setLocation("Princeton");
		p1.setDivision("Mercer");
		p1.setDistrict("Central");
		p1.setProvince("Western");
		p1.setPostalCode("08550");
		dairyLocation1.setPostalLocation(p1);
		dLocation.setLocation(dairyLocation1);
		//		
		DairyLocation dLocation2 = DairyFactory.eINSTANCE.createDairyLocation();
		dLocation2.setName("stop2");
		Date openDate2  = sdf.parse("04/27/2005");
		dLocation2.setDateOpened(openDate2);
		dLocation2.setCode("DL002");
		dLocation2.setPhone("609-457-1234");
		dLocation2.getFunctions().add(DairyFunction.MILK_COLLECTION);
		Location dairyLocation2 = ModelFactory.eINSTANCE.createLocation();
		PostalLocation p2 = ModelFactory.eINSTANCE.createPostalLocation();
		p2.setAddress("122 - Ngeche");
		p2.setSection("Section A");
		p2.setEstate("Building B");
		p2.setVillage("West Windosr");
		p2.setSubLocation("Princeton Junction");
		p2.setLocation("Princeton");
		p2.setDivision("Mercer");
		p2.setDistrict("Central");
		p2.setProvince("Western");
		p2.setPostalCode("08550");
		dairyLocation2.setPostalLocation(p2);
		dLocation2.setLocation(dairyLocation2);
		//		
		DairyLocation dLocation3 = DairyFactory.eINSTANCE.createDairyLocation();
		dLocation3.setName("stop3");
		Date openDate3  = sdf.parse("04/27/2005");
		dLocation3.setDateOpened(openDate3);
		dLocation3.setCode("DL003");
		dLocation3.setPhone("609-457-8989");
		dLocation3.getFunctions().add(DairyFunction.MILK_COLLECTION);
		//		
		Location dairyLocation3 = ModelFactory.eINSTANCE.createLocation();
		PostalLocation p3 = ModelFactory.eINSTANCE.createPostalLocation();
		p3.setAddress("566 - Ngeche");
		p3.setSection("Section A");
		p3.setEstate("Building B");
		p3.setVillage("West Windosr");
		p3.setSubLocation("Princeton Junction");
		p3.setLocation("Princeton");
		p3.setDivision("Mercer");
		p3.setDistrict("Central");
		p3.setProvince("Western");
		p3.setPostalCode("08550");
		dairyLocation3.setPostalLocation(p3);
		dLocation3.setLocation(dairyLocation3);
		//
		//		
		DairyLocation dLocation2_1 = DairyFactory.eINSTANCE.createDairyLocation();
		dLocation2_1.setName("route2_stop1");
		Date openDate2_1  = sdf.parse("03/26/2008");
		dLocation2_1.setDateOpened(openDate2_1);
		dLocation2_1.setCode("DL021");
		dLocation2_1.setPhone("609-457-8989");
		dLocation2_1.getFunctions().add(DairyFunction.MILK_COLLECTION);
		Location location2_1 = ModelFactory.eINSTANCE.createLocation();
		PostalLocation p2_1 = ModelFactory.eINSTANCE.createPostalLocation();
		p2_1.setAddress("50 - North Post");
		p2_1.setSection("Section A");
		p2_1.setEstate("Building B");
		p2_1.setVillage("West Windosr");
		p2_1.setSubLocation("Princeton Junction");
		p2_1.setLocation("Princeton");
		p2_1.setDivision("Mercer");
		p2_1.setDistrict("Central");
		p2_1.setProvince("Western");
		p2_1.setPostalCode("08550");
		location2_1.setPostalLocation(p2_1);
		dLocation2_1.setLocation(location2_1);
		//		
		DairyLocation dLocation2_2 = DairyFactory.eINSTANCE.createDairyLocation();
		dLocation2_2.setName("route2_stop2");
		Date openDate2_2  = sdf.parse("03/26/2008");
		dLocation2_2.setDateOpened(openDate2_2);
		dLocation2_2.setCode("DL022");
		dLocation2_2.setPhone("609-457-1234");
		dLocation2_2.getFunctions().add(DairyFunction.MILK_COLLECTION);
		Location location2_2 = ModelFactory.eINSTANCE.createLocation();
		PostalLocation p2_2 = ModelFactory.eINSTANCE.createPostalLocation();
		p2_2.setAddress("750 - North Post");
		p2_2.setSection("Section A");
		p2_2.setEstate("Building B");
		p2_2.setVillage("West Windosr");
		p2_2.setSubLocation("Princeton Junction");
		p2_2.setLocation("Princeton");
		p2_2.setDivision("Mercer");
		p2_2.setDistrict("Central");
		p2_2.setProvince("Western");
		p2_2.setPostalCode("08550");
		location2_2.setPostalLocation(p2_2);
		dLocation2_2.setLocation(location2_2);
		//		
		DairyLocation dLocation2_3 = DairyFactory.eINSTANCE.createDairyLocation();
		dLocation2_3.setName("route2_stop3");
		Date openDate2_3  = sdf.parse("04/27/2008");
		dLocation2_3.setDateOpened(openDate2_3);
		dLocation2_3.setCode("DL023");
		dLocation2_3.setPhone("609-457-8989");
		dLocation2_3.getFunctions().add(DairyFunction.MILK_COLLECTION);
		Location location2_3 = ModelFactory.eINSTANCE.createLocation();
		PostalLocation p2_3 = ModelFactory.eINSTANCE.createPostalLocation();
		p2_3.setAddress("1250 - North Post");
		p2_3.setSection("Section A");
		p2_3.setEstate("Building B");
		p2_3.setVillage("West Windosr");
		p2_3.setSubLocation("Princeton Junction");
		p2_3.setLocation("Princeton");
		p2_3.setDivision("Mercer");
		p2_3.setDistrict("Central");
		p2_3.setProvince("Western");
		p2_3.setPostalCode("08550");
		location2_3.setPostalLocation(p2_3);
		//	
		dLocation2_3.setLocation(location2_3);
		//		
		//		//add dairyLocations
		//		dairyResource.getContents().add(dLocation);
		//		dairyResource.getContents().add(dLocation2);
		//		dairyResource.getContents().add(dLocation3);
		//		dairyResource.getContents().add(dLocation2_1);
		//		dairyResource.getContents().add(dLocation2_2);
		//		dairyResource.getContents().add(dLocation2_3);
		//		//route
		Route route1 = DairyFactory.eINSTANCE.createRoute();
		route1.setCode("R0001");
		route1.setName("Route 1");
		route1.getStops().add(dLocation);
		route1.getStops().add(dLocation2);
		route1.getStops().add(dLocation3);

		Route route2 = DairyFactory.eINSTANCE.createRoute();
		route2.setCode("R0002");
		route2.setName("Route 2");
		route2.getStops().add(dLocation2_1);
		route2.getStops().add(dLocation2_2);
		route2.getStops().add(dLocation2_3);
		//		dairyResource.getContents().add(route1);
		//		dairyResource.getContents().add(route2);
		//		
		if(farmResource == null){
			createFarmResource();
		}
		

		

		//dairy conatiner
		List<DairyContainer>bins = createDairyContianer(10,10000);
		
		Dairy dairy = DairyFactory.eINSTANCE.createDairy();
		dairy.setCompanyName("Demo Dairy");
		dairy.setName("Demo Dairy");
		dairy.setDairyId(new Long("30001"));
		dairy.getEmployees().add(driver1);
		dairy.getEmployees().add(driver2);
		dairy.getEmployees().add(driver3);
		dairy.getVehicles().add(v1);
		dairy.getVehicles().add(v2);
		dairy.getVehicles().add(v3);
		dairy.getBranchLocations().add(dLocation);
		dairy.getBranchLocations().add(dLocation2);
		dairy.getBranchLocations().add(dLocation3);
		dairy.getBranchLocations().add(dLocation2_1);
		dairy.getBranchLocations().add(dLocation2_2);
		dairy.getBranchLocations().add(dLocation2_3);

		dairy.getRoutes().add(route1);
		dairy.getRoutes().add(route2);
		dairy.getDairyBins().addAll(bins);
		
		for(int i=0; i<20; i++){
			int farmId = 5000+i*100;
			List<Farm> farms = createFarms(farmId);
			for(Farm f :farms){
				farmResource.getContents().add(f);
			}
			Membership member1 = DairyFactory.eINSTANCE.createMembership();
			member1.setMemberId(""+1000+i);
			Person member = ModelFactory.eINSTANCE.createPerson();
			member.setName("Joseph Limuru"+"_"+i);
			member.setPhoneNumber("609-356-3400"+i);
			member1.setMember(member);
			
			Location memberLocation = ModelFactory.eINSTANCE.createLocation();
			
			PostalLocation mLocation = ModelFactory.eINSTANCE.createPostalLocation();
			mLocation.setAddress(i+" - Ngeche");
			mLocation.setSection("Section A");
			mLocation.setEstate("Building B");
			mLocation.setVillage("West Windosr");
			mLocation.setSubLocation("Princeton Junction");
			mLocation.setLocation("Princeton");
			mLocation.setDivision("Mercer");
			mLocation.setDistrict("Central");
			mLocation.setProvince("Western");
			mLocation.setPostalCode("08550");
			memberLocation.setPostalLocation(mLocation);
			member.setLocation(memberLocation);
			
			String dateString = i<9? "02/0"+i+"/2007":"02/"+i+"/2007";
			Date applicationDate = sdf.parse(dateString);
			member1.setApplicationDate(applicationDate);

			Date effectiveDate = sdf.parse("03/05/2007");
			member1.setDefaultRoute(route1);
			member1.setEffectiveDate(effectiveDate);
			member1.setStatus(MembershipStatus.ACTIVE);
			member1.getFarms().addAll(farms);
			if(i%2==0){
				member1.setDefaultRoute(route2);
			}else{
				member1.setDefaultRoute(route1);
			}
			dairy.getMemberships().add(member1);
		}

		dairyResource.getContents().add(dairy);
		try {
			saveFarmResource();
			saveDairyResource();
		
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadFarmResources(){
		URI farmResourceURI = URI.createFileURI("c:/temp/eDairy/farmDB.farm");
		farmResource =  ResourceManager.INSTANCE.loadResource(farmResourceURI);
	}

	public void loadDairyResources(){
		
		loadFarmResources();
		
		URI dairyResourceURI = URI.createFileURI("c:/temp/eDairy/dairyDB.dairy");
		dairyResource =  ResourceManager.INSTANCE.loadResource(dairyResourceURI);
		//		try {
		//			Dairy dairy = getObjectsFromDairyModel(Dairy.class).get(0);
		//			
		//		} catch (CoreException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
	}
	
	public void reLoadDairyResource(){
		if(farmResource.isLoaded()){
			farmResource.unload();
		}
		if(dairyResource.isLoaded()){
			dairyResource.unload();
		}
		loadDairyResources();
	}

	public <T extends EObject> List<T> getObjectsFromDairyModel(Class<T>  type) throws CoreException{
		List<T> objectList = new ArrayList<T>();
		if(dairyResource == null){
			loadDairyResources();
		}
		if(dairyResource == null){
			throw new CoreException(new Status(IStatus.ERROR,EDairyActivator.PLUGIN_ID,"can't load dairy modle"));
		}
		List<EObject> objects = dairyResource.getContents();
		for(EObject object :objects){
			if(type.isAssignableFrom(object.getClass())){
				objectList.add((T) object);
			}
		}
		return objectList;
	}


	private void createFarmProperties(Farm farm, int containerNumber, int animalNumber, int containerId, int animalId)throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("MM/dd/yyyy");
		for(int i=0; i<containerNumber; i++){
			Container container= TrackingFactory.eINSTANCE.createContainer();
			container.setType(ContainerType.CAN);
			int id = containerId+i;
			container.setContainerId(""+id);
			container.setOwner(farm);
			container.setMeasureType(UnitOfMeasure.LITRE);
			container.setCapacity(50);
			farm.getCans().add(container);
		}

		for(int i=0; i<animalNumber; i++){
			RegisteredAnimal animal1 = TrackingFactory.eINSTANCE.createRegisteredAnimal();
			animal1.setAnimnalRegistrationId(10000+i);
			animal1.setGivenName("animal_"+i);
			animal1.setLocation(farm);
			int n = (int)(10.0 * Math.random());
			int m=n<3?10+n:n+3;
			String date =m>9? "0"+n+"/"+m+"/200"+n:"0"+n+"/0"+m+"/200"+n;
			Date effectedDate = sdf.parse(date);
			animal1.setDateOfAcquisition(effectedDate);
			animal1.setPurpose(Purpose.DAIRY);
			if(i%2==0){
				animal1.setGender(Gender.FEMALE);	
			}else{
				animal1.setGender(Gender.MALE);
			}
			int rearingModelValue = i%7;
			animal1.setRearingMode(RearingMode.get(rearingModelValue));
			int acquisionType = i%5;
			animal1.setAcquisitionType(AcquisitionType.get(acquisionType));			

			ReferenceAnimalType animal1_type = TrackingFactory.eINSTANCE.createReferenceAnimalType();
			animal1_type.setAnimalTypeId(animalId+i);
			animal1_type.setSpecies("Cow");
			animal1_type.setBreed("Western");
			animal1.setAnimalType(animal1_type);
			farm.getAnimals().add(animal1);
		}
	}

	private List<DairyContainer> createDairyContianer(int binNumber, int binId){ 
		List<DairyContainer> binList = new ArrayList<DairyContainer>();
		for(int i=0; i<binNumber; i++){
			DairyContainer bin= DairyFactory.eINSTANCE.createDairyContainer();
			bin.setType(ContainerType.BIN);
			int id = binId+i;
			bin.setContainerId(""+id);
			bin.setAssetId(new Long(id).longValue());
			bin.setMeasureType(UnitOfMeasure.LITRE);
			bin.setCapacity(200);
			binList.add(bin);
		}
		return binList;
	}
	
	public Dairy getDairy(){
		List<Dairy> dairyList;
		try {
			dairyList = getObjectsFromDairyModel(Dairy.class);
			if(dairyList.size()>0){
				return dairyList.get(0);

			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void addFarm(Farm newFarm){
		if(farmResource == null){
			loadFarmResources();
		}
		if(farmResource != null){
			farmResource.getContents().add(newFarm);

		}
	}
	
	public void saveDairyResource() throws IllegalArgumentException, IOException{
		ResourceManager.INSTANCE.saveResource(dairyResource);
	}
	
	public void saveFarmResource(){
		try {
			ResourceManager.INSTANCE.saveResource(farmResource);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


