/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import com.agritrace.edairy.model.dairy.DairyPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class DairyXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public DairyXMLProcessor() {
	super(EPackage.Registry.INSTANCE);
	DairyPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the DairyResourceFactoryImpl
     * factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
	if (registrations == null) {
	    super.getRegistrations();
	    registrations.put(XML_EXTENSION, new DairyResourceFactoryImpl());
	    registrations.put(STAR_EXTENSION, new DairyResourceFactoryImpl());
	}
	return registrations;
    }

} // DairyXMLProcessor
