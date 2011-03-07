/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base.impl;

import com.agritrace.edairy.desktop.common.model.base.ContactMethod;
import com.agritrace.edairy.desktop.common.model.base.Contactable;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contactable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.ContactableImpl#getContactMethods <em>Contact Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContactableImpl extends EObjectImpl implements Contactable {
	/**
	 * The cached value of the '{@link #getContactMethods() <em>Contact Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContactMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<ContactMethod> contactMethods;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContactableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CONTACTABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ContactMethod> getContactMethods() {
		if (contactMethods == null)
		{
			contactMethods = new EObjectContainmentEList<ContactMethod>(ContactMethod.class, this, ModelPackage.CONTACTABLE__CONTACT_METHODS);
		}
		return contactMethods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case ModelPackage.CONTACTABLE__CONTACT_METHODS:
				return ((InternalEList<?>)getContactMethods()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case ModelPackage.CONTACTABLE__CONTACT_METHODS:
				return getContactMethods();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case ModelPackage.CONTACTABLE__CONTACT_METHODS:
				getContactMethods().clear();
				getContactMethods().addAll((Collection<? extends ContactMethod>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case ModelPackage.CONTACTABLE__CONTACT_METHODS:
				getContactMethods().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case ModelPackage.CONTACTABLE__CONTACT_METHODS:
				return contactMethods != null && !contactMethods.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ContactableImpl
