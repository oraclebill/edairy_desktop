/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.util;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.dairy.util.DairyResourceImpl
 * @generated
 */
public class DairyResourceFactoryImpl extends ResourceFactoryImpl {
	/**
         * Creates an instance of the resource factory.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public DairyResourceFactoryImpl() {
                super();
        }

	/**
         * Creates an instance of the resource.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	public Resource createResource(URI uri) {
                Resource result = new DairyResourceImpl(uri);
                return result;
        }

} //DairyResourceFactoryImpl
