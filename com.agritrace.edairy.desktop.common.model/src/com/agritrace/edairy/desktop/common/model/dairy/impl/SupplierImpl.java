/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Supplier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.SupplierImpl#getSupplierId <em>Supplier Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.SupplierImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.SupplierImpl#getPublicDescription <em>Public Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.SupplierImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.SupplierImpl#getRegistrationDate <em>Registration Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.SupplierImpl#getExpirationDate <em>Expiration Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.SupplierImpl#getNotes <em>Notes</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.SupplierImpl#getRating <em>Rating</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SupplierImpl extends CompanyImpl implements Supplier {
	/**
	 * The default value of the '{@link #getSupplierId() <em>Supplier Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupplierId()
	 * @generated
	 * @ordered
	 */
	protected static final Long SUPPLIER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSupplierId() <em>Supplier Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupplierId()
	 * @generated
	 * @ordered
	 */
	protected Long supplierId = SUPPLIER_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCategories() <em>Categories</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategories()
	 * @generated
	 * @ordered
	 */
	protected EList<String> categories;

	/**
	 * The default value of the '{@link #getPublicDescription() <em>Public Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLIC_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublicDescription() <em>Public Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicDescription()
	 * @generated
	 * @ordered
	 */
	protected String publicDescription = PUBLIC_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final VendorStatus STATUS_EDEFAULT = VendorStatus.PENDING;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected VendorStatus status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getRegistrationDate() <em>Registration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistrationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date REGISTRATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRegistrationDate() <em>Registration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistrationDate()
	 * @generated
	 * @ordered
	 */
	protected Date registrationDate = REGISTRATION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpirationDate() <em>Expiration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpirationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date EXPIRATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpirationDate() <em>Expiration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpirationDate()
	 * @generated
	 * @ordered
	 */
	protected Date expirationDate = EXPIRATION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNotes() <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotes() <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected String notes = NOTES_EDEFAULT;

	/**
	 * The default value of the '{@link #getRating() <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRating()
	 * @generated
	 * @ordered
	 */
	protected static final int RATING_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRating() <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRating()
	 * @generated
	 * @ordered
	 */
	protected int rating = RATING_EDEFAULT;

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
		return DairyPackage.Literals.SUPPLIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getSupplierId() {
		return supplierId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupplierId(Long newSupplierId) {
		Long oldSupplierId = supplierId;
		supplierId = newSupplierId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.SUPPLIER__SUPPLIER_ID, oldSupplierId, supplierId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCategories() {
		if (categories == null) {
			categories = new EDataTypeUniqueEList<String>(String.class, this, DairyPackage.SUPPLIER__CATEGORIES);
		}
		return categories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPublicDescription() {
		return publicDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublicDescription(String newPublicDescription) {
		String oldPublicDescription = publicDescription;
		publicDescription = newPublicDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.SUPPLIER__PUBLIC_DESCRIPTION, oldPublicDescription, publicDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VendorStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(VendorStatus newStatus) {
		VendorStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.SUPPLIER__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistrationDate(Date newRegistrationDate) {
		Date oldRegistrationDate = registrationDate;
		registrationDate = newRegistrationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.SUPPLIER__REGISTRATION_DATE, oldRegistrationDate, registrationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpirationDate(Date newExpirationDate) {
		Date oldExpirationDate = expirationDate;
		expirationDate = newExpirationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.SUPPLIER__EXPIRATION_DATE, oldExpirationDate, expirationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotes(String newNotes) {
		String oldNotes = notes;
		notes = newNotes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.SUPPLIER__NOTES, oldNotes, notes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRating(int newRating) {
		int oldRating = rating;
		rating = newRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.SUPPLIER__RATING, oldRating, rating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.SUPPLIER__SUPPLIER_ID:
				return getSupplierId();
			case DairyPackage.SUPPLIER__CATEGORIES:
				return getCategories();
			case DairyPackage.SUPPLIER__PUBLIC_DESCRIPTION:
				return getPublicDescription();
			case DairyPackage.SUPPLIER__STATUS:
				return getStatus();
			case DairyPackage.SUPPLIER__REGISTRATION_DATE:
				return getRegistrationDate();
			case DairyPackage.SUPPLIER__EXPIRATION_DATE:
				return getExpirationDate();
			case DairyPackage.SUPPLIER__NOTES:
				return getNotes();
			case DairyPackage.SUPPLIER__RATING:
				return getRating();
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
		switch (featureID) {
			case DairyPackage.SUPPLIER__SUPPLIER_ID:
				setSupplierId((Long)newValue);
				return;
			case DairyPackage.SUPPLIER__CATEGORIES:
				getCategories().clear();
				getCategories().addAll((Collection<? extends String>)newValue);
				return;
			case DairyPackage.SUPPLIER__PUBLIC_DESCRIPTION:
				setPublicDescription((String)newValue);
				return;
			case DairyPackage.SUPPLIER__STATUS:
				setStatus((VendorStatus)newValue);
				return;
			case DairyPackage.SUPPLIER__REGISTRATION_DATE:
				setRegistrationDate((Date)newValue);
				return;
			case DairyPackage.SUPPLIER__EXPIRATION_DATE:
				setExpirationDate((Date)newValue);
				return;
			case DairyPackage.SUPPLIER__NOTES:
				setNotes((String)newValue);
				return;
			case DairyPackage.SUPPLIER__RATING:
				setRating((Integer)newValue);
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
		switch (featureID) {
			case DairyPackage.SUPPLIER__SUPPLIER_ID:
				setSupplierId(SUPPLIER_ID_EDEFAULT);
				return;
			case DairyPackage.SUPPLIER__CATEGORIES:
				getCategories().clear();
				return;
			case DairyPackage.SUPPLIER__PUBLIC_DESCRIPTION:
				setPublicDescription(PUBLIC_DESCRIPTION_EDEFAULT);
				return;
			case DairyPackage.SUPPLIER__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case DairyPackage.SUPPLIER__REGISTRATION_DATE:
				setRegistrationDate(REGISTRATION_DATE_EDEFAULT);
				return;
			case DairyPackage.SUPPLIER__EXPIRATION_DATE:
				setExpirationDate(EXPIRATION_DATE_EDEFAULT);
				return;
			case DairyPackage.SUPPLIER__NOTES:
				setNotes(NOTES_EDEFAULT);
				return;
			case DairyPackage.SUPPLIER__RATING:
				setRating(RATING_EDEFAULT);
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
		switch (featureID) {
			case DairyPackage.SUPPLIER__SUPPLIER_ID:
				return SUPPLIER_ID_EDEFAULT == null ? supplierId != null : !SUPPLIER_ID_EDEFAULT.equals(supplierId);
			case DairyPackage.SUPPLIER__CATEGORIES:
				return categories != null && !categories.isEmpty();
			case DairyPackage.SUPPLIER__PUBLIC_DESCRIPTION:
				return PUBLIC_DESCRIPTION_EDEFAULT == null ? publicDescription != null : !PUBLIC_DESCRIPTION_EDEFAULT.equals(publicDescription);
			case DairyPackage.SUPPLIER__STATUS:
				return status != STATUS_EDEFAULT;
			case DairyPackage.SUPPLIER__REGISTRATION_DATE:
				return REGISTRATION_DATE_EDEFAULT == null ? registrationDate != null : !REGISTRATION_DATE_EDEFAULT.equals(registrationDate);
			case DairyPackage.SUPPLIER__EXPIRATION_DATE:
				return EXPIRATION_DATE_EDEFAULT == null ? expirationDate != null : !EXPIRATION_DATE_EDEFAULT.equals(expirationDate);
			case DairyPackage.SUPPLIER__NOTES:
				return NOTES_EDEFAULT == null ? notes != null : !NOTES_EDEFAULT.equals(notes);
			case DairyPackage.SUPPLIER__RATING:
				return rating != RATING_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (supplierId: ");
		result.append(supplierId);
		result.append(", categories: ");
		result.append(categories);
		result.append(", publicDescription: ");
		result.append(publicDescription);
		result.append(", status: ");
		result.append(status);
		result.append(", registrationDate: ");
		result.append(registrationDate);
		result.append(", expirationDate: ");
		result.append(expirationDate);
		result.append(", notes: ");
		result.append(notes);
		result.append(", rating: ");
		result.append(rating);
		result.append(')');
		return result.toString();
	}

} //SupplierImpl
