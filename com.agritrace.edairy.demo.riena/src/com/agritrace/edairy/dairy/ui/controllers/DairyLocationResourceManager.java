package com.agritrace.edairy.dairy.ui.controllers;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.agritrace.edairy.model.DescriptiveLocation;
import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.MapLocation;
import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.DairyFunction;
import com.agritrace.edairy.model.dairy.DairyLocation;
import com.agritrace.edairy.model.dairy.Route;
import com.agritrace.edairy.model.impl.ModelFactoryImpl;
import com.agritrace.edairy.ui.DairyDemoResourceManager;
import com.agritrace.edairy.ui.EDairyActivator;



public class DairyLocationResourceManager {
	public static final String DAIRY_LOCATIONS_RESOURCE = DairyDemoResourceManager.XMLDB_BASE + "/dairyLocations.xml";
	public static final String ROUTES_RESOURCE = DairyDemoResourceManager.XMLDB_BASE + "/routes.xml";
	private Resource dairyLocationsResource;
	private Resource routesResource;
	private Map<String, Object> saveOptions = new HashMap<String, Object>();
	private ResourceSetImpl resourceSet = new ResourceSetImpl();

	public static DairyLocationResourceManager INSTANCE =  new DairyLocationResourceManager();
	
	
	public Resource getDairyLocationsResource() {
		return dairyLocationsResource;
	}
	
	public Resource getRoutesResource() {
		return routesResource;
	}

	private  DairyLocationResourceManager(){
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		saveOptions.put(XMLResource.OPTION_DECLARE_XML, Boolean.TRUE);
	}
	/**
	 * save options
	 * @return
	 */
	public Map<String, Object> getSaveOptions() {
		return saveOptions;
	}

	/**
	 * get resourceSet
	 * @return
	 */
	public ResourceSetImpl getResourceSet() {
		return resourceSet;
	}
	public void setResourceSet(ResourceSetImpl resourceSet) {
		this.resourceSet = resourceSet;
	}

	/**
	 * load resource
	 * @param uri
	 * @return
	 * @throws RuntimeException
	 */
	public Resource loadResource(URI uri)throws RuntimeException{
		if(uri == null){
			return null;
		}
		return resourceSet.getResource(uri, true);
	}

	/**
	 * save resource with default options
	 * @param resource
	 * @throws IOException
	 * @throws IllegalArgumentException
	 */
	public void saveResource(Resource resource) throws IOException,IllegalArgumentException{
		saveResource(resource,saveOptions);
	}

	/**
	 * save resource for given options.
	 * @param resource
	 * @param saveOptions
	 * @throws IOException
	 * @throws IllegalArgumentException
	 */
	public void saveResource(Resource resource, Map<String,Object>saveOptions)throws IOException,IllegalArgumentException{
		if(resource == null){
			throw new IllegalArgumentException("resource is null.");
		}
		if(resource.getResourceSet() != this.resourceSet){
			throw new IllegalArgumentException("resource does not belong to the resrouce set.");

		}
		if(saveOptions == null){
			saveOptions = this.saveOptions;
		}
		resource.save(saveOptions);
	}
	
	public Resource createResource(URI uri) throws IllegalArgumentException{
		if(uri == null){
			throw new IllegalArgumentException("uri is null");
		}
		return resourceSet.createResource(uri);
	}
	
	public void createDairyLocationsResource() throws ParseException {
		URI farmResourceURI = URI.createFileURI(DAIRY_LOCATIONS_RESOURCE);
		dairyLocationsResource = createResource(farmResourceURI);
		createDairyLocationsData();

		try {
			saveResource(dairyLocationsResource);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void createRoutesResource() throws ParseException {
		URI farmResourceURI = URI.createFileURI(ROUTES_RESOURCE);
		routesResource = createResource(farmResourceURI);
		createRoutesData();

		try {
			saveResource(routesResource);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadDairyLocationsResources() {
		File file = new File(DAIRY_LOCATIONS_RESOURCE);
		// if file doesn't exists, we will create it first
		if (!file.exists()) {

			try {
				// Creates the files
				createDairyLocationsResource();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		URI dairyResourceURI = URI.createFileURI(DAIRY_LOCATIONS_RESOURCE);
		dairyLocationsResource = loadResource(dairyResourceURI);
	}
	
	public void loadRoutesResources() {
		File file = new File(ROUTES_RESOURCE);
		// if file doesn't exists, we will create it first
		if (!file.exists()) {

			try {
				// Creates the files
				createRoutesResource();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		URI dairyResourceURI = URI.createFileURI(ROUTES_RESOURCE);
		routesResource = loadResource(dairyResourceURI);
	}

	public <T extends EObject> List<T> getObjectsFromDairyModel(Class<T> type)
			throws CoreException {
		List<T> objectList = new ArrayList<T>();
		List<EObject> objects = null;
		if (type.equals(DairyLocation.class)) {
			if (dairyLocationsResource == null) {
				loadDairyLocationsResources();
			}
			if (dairyLocationsResource == null) {
				throw new CoreException(new Status(IStatus.ERROR,
						EDairyActivator.PLUGIN_ID, "can't load dairy modle"));
			}
			objects = dairyLocationsResource.getContents();
		} else if (type.equals(Route.class)) {
			if (routesResource == null) {
				loadRoutesResources();
			}
			if (routesResource == null) {
				throw new CoreException(new Status(IStatus.ERROR,
						EDairyActivator.PLUGIN_ID, "can't load dairy modle"));
			}
			objects = routesResource.getContents();
		}
		for (EObject object : objects) {
			if (type.isAssignableFrom(object.getClass())) {
				objectList.add((T) object);
			}
		}
		
		
		
		return objectList;
	}

	private void createDairyLocationsData()
	{
		
		for (int i = 0 ; i < 5; i ++) {
			long id = (long) i;
			DairyLocation dairyLocation = DairyFactory.eINSTANCE.createDairyLocation();
			dairyLocation.setName("testDairylocationName" + id);
			dairyLocation.setDescription("test dairy location description " + id);
			dairyLocation.setDateOpened(new Date());
			dairyLocation.setPhone("555-111-222");
			dairyLocation.getFunctions().addAll(Arrays.asList(DairyFunction.MILK_COLLECTION, DairyFunction.MILK_STORAGE, DairyFunction.MILK_PROCESSING, DairyFunction.WAREHOUSE, DairyFunction.STORE_SALES));
			dairyLocation.setCode("#66778" + id);
			
			
			Route route = DairyFactory.eINSTANCE.createRoute();
			route.setName("testroute" + id);
			route.setDescription("testroutedesc" + id);
			route.setCode("#66778" + id);
			
			dairyLocation.setRoute(route);
			Location location = ModelFactoryImpl.eINSTANCE.createLocation();

			PostalLocation postalLocation = ModelFactory.eINSTANCE.createPostalLocation();
			postalLocation.setAddress("test address " + id);
			postalLocation.setSection("test section " + id);
			postalLocation.setEstate("test estate " + id);
			postalLocation.setVillage("test village " + id);
			postalLocation.setLocation("test location " + id);
			postalLocation.setSubLocation("test sublocation " + id);
			postalLocation.setDistrict("test district " + id);
			postalLocation.setDivision("test division " + id);
			postalLocation.setPostalCode("123456 " + id);
			postalLocation.setProvince("TP " + id);
			
			DescriptiveLocation descriptiveLocation = ModelFactory.eINSTANCE.createDescriptiveLocation();
			descriptiveLocation.setLandmarks("test landmarks " + id);
			descriptiveLocation.setDirections("test directions " + id);
			
			MapLocation mapLocation = ModelFactory.eINSTANCE.createMapLocation();
			mapLocation.setLatitude("123.00");
			mapLocation.setLongitude("-100.00");
			
			location.setPostalLocation(postalLocation);
			location.setDescriptiveLocation(descriptiveLocation);
			location.setMapLocation(mapLocation);
			dairyLocation.setLocation(location);
			
			
			
			dairyLocationsResource.getContents().add(dairyLocation);
			//dairyLocationsResource.getContents().add(route);
			dairyLocation.eResource().getContents().add(route);
			/*dairyLocation.eResource().getContents().add(location);
			location.eResource().getContents().add(postalLocation);
			location.eResource().getContents().add(descriptiveLocation);
			location.eResource().getContents().add(mapLocation);*/

			id ++;
		}
	
	}
	
	private void createRoutesData()
	{
		for (int i = 0 ; i < 5; i++) {
			Route route = DairyFactory.eINSTANCE.createRoute();
			route.setName("testroute" + i);
			route.setDescription("testroutedesc" + i);
			route.setCode("#66778" + i);
			routesResource.getContents().add(route);
		}
	}
}