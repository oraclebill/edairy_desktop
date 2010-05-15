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
	final URI farmResourceURI = URI.createFileURI(FILE_PATH);
	staffInfoResource = ResourceManager.INSTANCE.createResource(farmResourceURI);

	createEmployee1();
	createEmployee2();
	createEmployee3();

	try {
	    ResourceManager.INSTANCE.saveResource(staffInfoResource);
	} catch (final IllegalArgumentException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (final IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    private void createEmployee1() throws ParseException {

	final Employee employee = DairyFactory.eINSTANCE.createEmployee();
	employee.setFamilyName("Wan");
	employee.setGivenName("Spark");
	employee.setJobFunction("R&D");
	employee.setId("1001");
	employee.setPhoneNumber("13816442241");
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
	employee.setLocation(location1);

	staffInfoResource.getContents().add(employee);

    }

    private void createEmployee2() throws ParseException {

	final Employee employee = DairyFactory.eINSTANCE.createEmployee();
	employee.setFamilyName("John");
	employee.setGivenName("Smith");
	employee.setJobFunction("Sales");
	employee.setId("1002");
	employee.setPhoneNumber("925-236-3122121");
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
	employee.setLocation(location1);

	staffInfoResource.getContents().add(employee);

    }

    private void createEmployee3() throws ParseException {

	final Employee employee = DairyFactory.eINSTANCE.createEmployee();
	employee.setFamilyName("Tracy");
	employee.setGivenName("Bill");
	employee.setJobFunction("Marketing");
	employee.setId("1003");
	employee.setPhoneNumber("5032323232");
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
	employee.setLocation(location1);

	staffInfoResource.getContents().add(employee);

    }

    /**
     * Loads resources
     */
    public void loadResources() {
	final File file = new File(StaffInfoResourceManager.FILE_PATH);
	// if file doesn't exists, we will create it first
	if (!file.exists()) {

	    try {
		// Creates the files
		createEmployees();
	    } catch (final ParseException e) {
		e.printStackTrace();
	    }

	}
	final URI dairyResourceURI = URI.createFileURI(StaffInfoResourceManager.FILE_PATH);
	staffInfoResource = ResourceManager.INSTANCE.loadResource(dairyResourceURI);
    }

    @SuppressWarnings("unchecked")
    public <T extends EObject> List<T> getObjectsFromDairyModel(Class<T> type) throws CoreException {
	final List<T> objectList = new ArrayList<T>();
	if (staffInfoResource == null) {
	    loadResources();
	}
	if (staffInfoResource == null) {
	    throw new CoreException(new Status(IStatus.ERROR, EDairyActivator.PLUGIN_ID, "can't load dairy modle"));
	}
	final List<EObject> objects = staffInfoResource.getContents();
	for (final EObject object : objects) {
	    if (type.isAssignableFrom(object.getClass())) {
		objectList.add((T) object);
	    }
	}
	return objectList;
    }

}
