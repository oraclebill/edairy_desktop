package com.agritrace.edairy.setup.core;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
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
import com.agritrace.edairy.ui.EDairyActivator;

/**
 * Staff info resource manager
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class StaffInfoResourceManager {

	public static StaffInfoResourceManager INSTANCE = new StaffInfoResourceManager();

	private Resource staffInfoResource;

	public static final String FILE_PATH = IDairyResourceManager.XMLDB_BASE + "staffinfo.xml";

	private StaffInfoResourceManager() {

	}

	public void createEmployees() throws ParseException {
		URI farmResourceURI = URI.createFileURI(FILE_PATH);
		staffInfoResource = ResourceManager.INSTANCE
				.createResource(farmResourceURI);

		createEmployee1();
		createEmployee2();
		createEmployee3();

		try {
			ResourceManager.INSTANCE.saveResource(staffInfoResource);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void createEmployee1() throws ParseException {

		Employee employee = DairyFactory.eINSTANCE.createEmployee();
		employee.setFamilyName("Wan");
		employee.setGivenName("Spark");
		employee.setJobFunction("R&D");
		employee.setId("1001");
		employee.setPhoneNumber("13816442241");
		Location location1 = ModelFactory.eINSTANCE.createLocation();
		PostalLocation defaultLocation = ModelFactory.eINSTANCE
				.createPostalLocation();
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
		employee.setLocation(location1);		

		staffInfoResource.getContents().add(employee);

	}

	private void createEmployee2() throws ParseException {

		Employee employee = DairyFactory.eINSTANCE.createEmployee();
		employee.setFamilyName("John");
		employee.setGivenName("Smith");
		employee.setJobFunction("Sales");
		employee.setId("1002");
		employee.setPhoneNumber("925-236-3122121");
		Location location1 = ModelFactory.eINSTANCE.createLocation();
		PostalLocation defaultLocation = ModelFactory.eINSTANCE
				.createPostalLocation();
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
		employee.setLocation(location1);

		staffInfoResource.getContents().add(employee);

	}

	private void createEmployee3() throws ParseException {

		Employee employee = DairyFactory.eINSTANCE.createEmployee();
		employee.setFamilyName("Tracy");
		employee.setGivenName("Bill");
		employee.setJobFunction("Marketing");
		employee.setId("1003");
		employee.setPhoneNumber("5032323232");
		Location location1 = ModelFactory.eINSTANCE.createLocation();
		PostalLocation defaultLocation = ModelFactory.eINSTANCE
				.createPostalLocation();
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
		employee.setLocation(location1);

		staffInfoResource.getContents().add(employee);

	}

	/**
	 * Loads resources
	 */
	public void loadResources() {
		File file = new File(StaffInfoResourceManager.FILE_PATH);
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
		staffInfoResource = ResourceManager.INSTANCE
				.loadResource(dairyResourceURI);
	}

	public <T extends EObject> List<T> getObjectsFromDairyModel(Class<T> type)
			throws CoreException {
		List<T> objectList = new ArrayList<T>();
		if (staffInfoResource == null) {
			loadResources();
		}
		if (staffInfoResource == null) {
			throw new CoreException(new Status(IStatus.ERROR,
					EDairyActivator.PLUGIN_ID, "can't load dairy modle"));
		}
		List<EObject> objects = staffInfoResource.getContents();
		for (EObject object : objects) {
			if (type.isAssignableFrom(object.getClass())) {
				objectList.add((T) object);
			}
		}
		return objectList;
	}

}
