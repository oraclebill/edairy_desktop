package com.agritrace.edairy.desktop.internal.common.persistence;
//package com.agritrace.edairy.desktop.common.persistence.test;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.eclipse.emf.common.util.URI;
//import org.eclipse.emf.ecore.resource.Resource;
//import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
//import org.eclipse.emf.ecore.xmi.XMLResource;
//
//public class ResourceManager {
//
//	public static ResourceManager INSTANCE = new ResourceManager();
//
//	private ResourceSetImpl resourceSet = new ResourceSetImpl();
//
//	private final Map<String, Object> saveOptions = new HashMap<String, Object>();
//
//	private ResourceManager() {
//		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
//		saveOptions.put(XMLResource.OPTION_DECLARE_XML, Boolean.TRUE);
//	}
//
//	public Resource createResource(URI uri) throws IllegalArgumentException {
//		if (uri == null) {
//			throw new IllegalArgumentException("uri is null");
//		}
//		return resourceSet.createResource(uri);
//	}
//
//	/**
//	 * get resourceSet
//	 *
//	 * @return
//	 */
//	public ResourceSetImpl getResourceSet() {
//		return resourceSet;
//	}
//
//	/**
//	 * save options
//	 *
//	 * @return
//	 */
//	public Map<String, Object> getSaveOptions() {
//		return saveOptions;
//	}
//
//	/**
//	 * load resource
//	 *
//	 * @param uri
//	 * @return
//	 * @throws RuntimeException
//	 */
//	public Resource loadResource(URI uri) throws RuntimeException {
//		if (uri == null) {
//			return null;
//		}
//		return resourceSet.getResource(uri, true);
//	}
//
//	/**
//	 * save resource with default options
//	 *
//	 * @param resource
//	 * @throws IOException
//	 * @throws IllegalArgumentException
//	 */
//	public void saveResource(Resource resource) throws IOException, IllegalArgumentException {
//		saveResource(resource, saveOptions);
//	}
//
//	/**
//	 * save resource for given options.
//	 *
//	 * @param resource
//	 * @param saveOptions
//	 * @throws IOException
//	 * @throws IllegalArgumentException
//	 */
//	public void saveResource(Resource resource, Map<String, Object> saveOptions) throws IOException,
//			IllegalArgumentException {
//		if (resource == null) {
//			throw new IllegalArgumentException("resource is null.");
//		}
//		if (resource.getResourceSet() != this.resourceSet) {
//			throw new IllegalArgumentException("resource does not belong to the resrouce set.");
//
//		}
//		if (saveOptions == null) {
//			saveOptions = this.saveOptions;
//		}
//		resource.save(saveOptions);
//	}
//
//	public void setResourceSet(ResourceSetImpl resourceSet) {
//		this.resourceSet = resourceSet;
//	}
//}
