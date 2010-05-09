package com.agritrace.edairy.desktop.ui.services.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

public class EMFXMLSaveLoader {

	/**
	 * Set options/encoding
	 * 
	 * @param resource
	 *            XML Resource
	 * @param option
	 *            Load/Save options
	 */
	private static void setOption(XMLResource resource,
			Map<String, Boolean> option) {
		resource.setEncoding("UTF-8");
		option.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		option.put(XMLResource.OPTION_USE_LEXICAL_HANDLER, Boolean.TRUE);
	}

	/**
	 * Writes configurations to file
	 */
	public static void writeEObject2XML(String path, EObject object) {
		FileOutputStream f = null;
		try {
			f = new FileOutputStream(path);
			XMLResourceImpl resource = new XMLResourceImpl();
			Map options = resource.getDefaultSaveOptions();
			setOption(resource, options);
			resource.getContents().add(object);
			resource.save(f, options);
			f.close();
		} catch (Exception e) {
			// logger

		} finally {
			if (f != null) {
				try {
					f.close();
				} catch (IOException e) {
					// logger
				}
			}

		}
	}

	/*
	 * Writes configurations to file
	 */
	public static void writeEObjectList2XML(String path, List<EObject> objects) {
		FileOutputStream f = null;
		try {
			f = new FileOutputStream(path);
			XMLResourceImpl resource = new XMLResourceImpl();
			Map options = resource.getDefaultSaveOptions();
			setOption(resource, options);
			for (EObject object : objects) {
				resource.getContents().add(object);
			}

			resource.save(f, options);
			f.close();
		} catch (Exception e) {
			// logger

			int i=0;
		} finally {
			if (f != null) {
				try {
					f.close();
				} catch (IOException e) {
					// logger
				}
			}

		}
	}

	/**
	 * Reads emf model from specific file path
	 */
	public static XMLResource readXMLResource(String path) {
		FileInputStream in = null;
		XMLResource resource = null;
		try {
			File file = new File(path);
			if (!file.exists()) {
				return null;
			}
			in = new FileInputStream(file);

			resource = new XMLResourceImpl();
			Map option = resource.getDefaultLoadOptions();
			setOption(resource, option);
			resource.load(in, option);

			// while (resource.getAllContents().hasNext())
			// {
			// EObject eobj = resource.getAllContents().next();
			// return resource.
			// }
			in.close();
		} catch (Exception e) {
			// do nothing, the file doesn't exist when loading at the first time
			int i = 0;
		} finally {

			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {

				}
			}
		}
		return resource;

	}

}
