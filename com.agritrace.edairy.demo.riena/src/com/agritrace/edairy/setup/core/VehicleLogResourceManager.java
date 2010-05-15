package com.agritrace.edairy.setup.core;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
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
import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.Employee;
import com.agritrace.edairy.model.dairy.Vehicle;
import com.agritrace.edairy.service.ui.views.utils.ServiceUtils;
import com.agritrace.edairy.ui.EDairyActivator;

/**
 * Vehicle Log resource manager
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class VehicleLogResourceManager {

	public static VehicleLogResourceManager INSTANCE = new VehicleLogResourceManager();

	private Resource vehicleResource;

	public static final String FILE_PATH = IDairyResourceManager.XMLDB_BASE + "/vehicles.xml";

	private VehicleLogResourceManager() {

	}

	public void createEmployees() throws ParseException {
		URI farmResourceURI = URI.createFileURI(FILE_PATH);
		vehicleResource = ResourceManager.INSTANCE
				.createResource(farmResourceURI);

		createVehicles();

		try {
			ResourceManager.INSTANCE.saveResource(vehicleResource);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void createVehicles() throws ParseException {

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
		
		//drivers
		Employee driver1 = DairyFactory.eINSTANCE.createEmployee();
		//driver1.setName("Joseph Limuru");
		driver1.setGivenName("Joseph");
		driver1.setFamilyName("Limuru");
		driver1.setLocation(location1);
		driver1.setPhoneNumber("609-356-3421");
		driver1.setJobFunction("Driver");
		Date startDate  = ServiceUtils.DATE_FORMAT.parse("04/18/1998");
		driver1.setStartDate(startDate);
		vehicleResource.getContents().add(driver1);

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
		Employee driver2 = DairyFactory.eINSTANCE.createEmployee();
		//driver2.setName("John Smith");
		driver2.setGivenName("John");
		driver2.setFamilyName("Smith");
		driver2.setLocation(location2);
		driver2.setPhoneNumber("609-456-7898");
		driver2.setJobFunction("Driver");
		Date startDate2  = ServiceUtils.DATE_FORMAT.parse("02/03/1994");
		driver2.setStartDate(startDate2);
		vehicleResource.getContents().add(driver2);
		
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
		
		//		
		Employee driver3 = DairyFactory.eINSTANCE.createEmployee();
		//driver3.setName("Jason Spencer");
		driver3.setGivenName("Jason");
		driver3.setFamilyName("Spencer");
		driver3.setLocation(location3);
		driver3.setPhoneNumber("609-478-5565");
		driver3.setJobFunction("Driver");
		Date startDate3  = ServiceUtils.DATE_FORMAT.parse("07/14/1994");
		driver3.setStartDate(startDate3);
		vehicleResource.getContents().add(driver3);
		
		//create vehicles
		Vehicle v1 = DairyFactory.eINSTANCE.createVehicle();
		v1.setAssetId(new Long(1001));
		v1.setCapacityInTonnes("2");
		v1.setChassisNumber("23489-1");
		Date acquiredDate  = ServiceUtils.DATE_FORMAT.parse("02/18/2008");
		v1.setDateAcquired(acquiredDate);
		v1.setDriver(driver1);
		v1.setEngineNumber("21223-3");
		v1.setLogBookNumber("23001");
		v1.setMake("Toyota");
		v1.setModel("Tacoma");
		v1.setType("Type1");
		v1.setRegistrationNumber("1001- Toyota Tacoma");
		v1.setDominantColour("Black");
		v1.setInsurancePolicyNumber("123455050");
		v1.setInsuranceExpirationDate(ServiceUtils.DATE_FORMAT.parse("08/01/2010"));
		v1.setDamageDate(ServiceUtils.DATE_FORMAT.parse("01/06/2010"));
		v1.setDamageDescription("Damange Description 1..............");
		v1.setDateDisposed(ServiceUtils.DATE_FORMAT.parse("03/08/2010"));
		v1.setDisposalReason("Disposal Reason 1....");
		v1.setDisposalWitness("Bill Gates");
		v1.setYear("2009");

		Vehicle v2 = DairyFactory.eINSTANCE.createVehicle();
		v2.setAssetId(new Long(1002));
		v2.setCapacityInTonnes("2");
		v2.setChassisNumber("45789-1");
		Date acquiredDate2  = ServiceUtils.DATE_FORMAT.parse("07/21/2007");
		v2.setDateAcquired(acquiredDate2);
		v2.setDriver(driver2);
		v2.setEngineNumber("45688-3");
		v2.setLogBookNumber("56558");
		v2.setMake("Toyota");
		v2.setModel("Tacoma");
		v2.setRegistrationNumber("1002- Toyota Tacoma");
		v2.setType("Type2");
		v2.setDominantColour("Blue");
		v2.setInsurancePolicyNumber("11222212121");
		v2.setInsuranceExpirationDate(ServiceUtils.DATE_FORMAT.parse("07/01/2010"));
		v2.setDamageDate(ServiceUtils.DATE_FORMAT.parse("01/01/2010"));
		v2.setDamageDescription("Damange Description 2..............");
		v2.setDateDisposed(ServiceUtils.DATE_FORMAT.parse("01/05/2010"));
		v2.setDisposalReason("Disposal Reason 2....");
		v2.setDisposalWitness("Tracy Bill");
		v2.setYear("2008");

		Vehicle v3 = DairyFactory.eINSTANCE.createVehicle();
		v3.setAssetId(new Long(1003));
		v3.setCapacityInTonnes("2");
		v3.setChassisNumber("47878-1");
		Date acquiredDate3  = ServiceUtils.DATE_FORMAT.parse("07/27/2007");
		v3.setDateAcquired(acquiredDate3);
		v3.setDriver(driver3);
		v3.setEngineNumber("45689-3");
		v3.setLogBookNumber("56559");
		v3.setMake("Toyota");
		v3.setModel("Tacoma");
		v3.setRegistrationNumber("1003- Toyota Tacoma");
		v3.setType("type3");
		v3.setDominantColour("Red");
		v3.setInsurancePolicyNumber("545445455");
		v3.setInsuranceExpirationDate(ServiceUtils.DATE_FORMAT.parse("05/01/2010"));
		v3.setDamageDate(ServiceUtils.DATE_FORMAT.parse("03/01/2010"));
		v3.setDamageDescription("Damange Description 3..............");
		v3.setDateDisposed(ServiceUtils.DATE_FORMAT.parse("03/05/2010"));
		v3.setDisposalReason("Disposal Reason 3....");
		v3.setDisposalWitness("spark wan");
		v3.setYear("2007");

		vehicleResource.getContents().add(v1);
		vehicleResource.getContents().add(v2);
		vehicleResource.getContents().add(v3);

	}

	

	/**
	 * Loads resources
	 */
	public void loadResources() {
		File file = new File(VehicleLogResourceManager.FILE_PATH);
		// if file doesn't exists, we will create it first
		if (!file.exists()) {

			try {
				// Creates the files
				createEmployees();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		URI dairyResourceURI = URI.createFileURI(this.FILE_PATH);
		vehicleResource = ResourceManager.INSTANCE
				.loadResource(dairyResourceURI);
	}

	public <T extends EObject> List<T> getObjectsFromDairyModel(Class<T> type)
			throws CoreException {
		List<T> objectList = new ArrayList<T>();
		if (vehicleResource == null) {
			loadResources();
		}
		if (vehicleResource == null) {
			throw new CoreException(new Status(IStatus.ERROR,
					EDairyActivator.PLUGIN_ID, "can't load dairy modle"));
		}
		List<EObject> objects = vehicleResource.getContents();
		for (EObject object : objects) {
			if (type.isAssignableFrom(object.getClass())) {
				objectList.add((T) object);
			}
		}
		return objectList;
	}

}
