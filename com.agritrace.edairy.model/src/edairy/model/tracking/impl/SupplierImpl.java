/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model.tracking.impl;

import edairy.model.impl.CompanyImpl;

import edairy.model.tracking.Supplier;
import edairy.model.tracking.TrackingPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Supplier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SupplierImpl extends CompanyImpl implements Supplier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SupplierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackingPackage.Literals.SUPPLIER;
	}

} //SupplierImpl
