package com.agritrace.edairy.desktop.common.ui.managers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingFactory;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;

public class ResourceManager {

	private final Map<String, Object> saveOptions = new HashMap<String, Object>();

	private ResourceSetImpl resourceSet = new ResourceSetImpl();

	public static ResourceManager INSTANCE = new ResourceManager();

	private ResourceManager() {
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		saveOptions.put(XMLResource.OPTION_DECLARE_XML, Boolean.TRUE);		

		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
			.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());		
	}

	/**
	 * save options
	 * 
	 * @return
	 */
	public Map<String, Object> getSaveOptions() {
		return saveOptions;
	}

	/**
	 * get resourceSet
	 * 
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
	 * 
	 * @param uri
	 * @return
	 * @throws RuntimeException
	 */
	public Resource loadResource(URI uri) throws RuntimeException {
		if (uri == null) {
			return null;
		}
		System.err.println(uri);
		return resourceSet.getResource(uri, true);
	}

	/**
	 * save resource with default options
	 * 
	 * @param resource
	 * @throws IOException
	 * @throws IllegalArgumentException
	 */
	public void saveResource(Resource resource) throws IOException, IllegalArgumentException {
		saveResource(resource, saveOptions);
	}

	/**
	 * save resource for given options.
	 * 
	 * @param resource
	 * @param saveOptions
	 * @throws IOException
	 * @throws IllegalArgumentException
	 */
	public void saveResource(Resource resource, Map<String, Object> saveOptions) throws IOException,
			IllegalArgumentException {
		if (resource == null) {
			throw new IllegalArgumentException("resource is null.");
		}
		if (resource.getResourceSet() != this.resourceSet) {
			throw new IllegalArgumentException("resource does not belong to the resrouce set.");

		}
		if (saveOptions == null) {
			saveOptions = this.saveOptions;
		}
		resource.save(saveOptions);
	}

	public Resource createResource(URI uri) throws IllegalArgumentException {
		if (uri == null) {
			throw new IllegalArgumentException("uri is null");
		}
		Resource retVal = resourceSet.createResource(uri);
		Assert.isLegal(retVal != null);
		return retVal;
	}
}
