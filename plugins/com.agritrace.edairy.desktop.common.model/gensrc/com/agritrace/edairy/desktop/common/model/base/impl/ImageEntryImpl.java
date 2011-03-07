/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base.impl;

import com.agritrace.edairy.desktop.common.model.base.ImageEntry;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.ImageEntryImpl#getImageId <em>Image Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.ImageEntryImpl#getMimeType <em>Mime Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.ImageEntryImpl#getImageData <em>Image Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImageEntryImpl extends EObjectImpl implements ImageEntry {
	/**
	 * The default value of the '{@link #getImageId() <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageId()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImageId() <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageId()
	 * @generated
	 * @ordered
	 */
	protected String imageId = IMAGE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getMimeType() <em>Mime Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMimeType()
	 * @generated
	 * @ordered
	 */
	protected static final String MIME_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMimeType() <em>Mime Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMimeType()
	 * @generated
	 * @ordered
	 */
	protected String mimeType = MIME_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getImageData() <em>Image Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageData()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] IMAGE_DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImageData() <em>Image Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageData()
	 * @generated
	 * @ordered
	 */
	protected byte[] imageData = IMAGE_DATA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.IMAGE_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImageId() {
		return imageId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImageId(String newImageId) {
		String oldImageId = imageId;
		imageId = newImageId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.IMAGE_ENTRY__IMAGE_ID, oldImageId, imageId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMimeType(String newMimeType) {
		String oldMimeType = mimeType;
		mimeType = newMimeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.IMAGE_ENTRY__MIME_TYPE, oldMimeType, mimeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getImageData() {
		return imageData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImageData(byte[] newImageData) {
		byte[] oldImageData = imageData;
		imageData = newImageData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.IMAGE_ENTRY__IMAGE_DATA, oldImageData, imageData));
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
			case ModelPackage.IMAGE_ENTRY__IMAGE_ID:
				return getImageId();
			case ModelPackage.IMAGE_ENTRY__MIME_TYPE:
				return getMimeType();
			case ModelPackage.IMAGE_ENTRY__IMAGE_DATA:
				return getImageData();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case ModelPackage.IMAGE_ENTRY__IMAGE_ID:
				setImageId((String)newValue);
				return;
			case ModelPackage.IMAGE_ENTRY__MIME_TYPE:
				setMimeType((String)newValue);
				return;
			case ModelPackage.IMAGE_ENTRY__IMAGE_DATA:
				setImageData((byte[])newValue);
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
			case ModelPackage.IMAGE_ENTRY__IMAGE_ID:
				setImageId(IMAGE_ID_EDEFAULT);
				return;
			case ModelPackage.IMAGE_ENTRY__MIME_TYPE:
				setMimeType(MIME_TYPE_EDEFAULT);
				return;
			case ModelPackage.IMAGE_ENTRY__IMAGE_DATA:
				setImageData(IMAGE_DATA_EDEFAULT);
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
			case ModelPackage.IMAGE_ENTRY__IMAGE_ID:
				return IMAGE_ID_EDEFAULT == null ? imageId != null : !IMAGE_ID_EDEFAULT.equals(imageId);
			case ModelPackage.IMAGE_ENTRY__MIME_TYPE:
				return MIME_TYPE_EDEFAULT == null ? mimeType != null : !MIME_TYPE_EDEFAULT.equals(mimeType);
			case ModelPackage.IMAGE_ENTRY__IMAGE_DATA:
				return IMAGE_DATA_EDEFAULT == null ? imageData != null : !IMAGE_DATA_EDEFAULT.equals(imageData);
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
		result.append(" (imageId: ");
		result.append(imageId);
		result.append(", mimeType: ");
		result.append(mimeType);
		result.append(", imageData: ");
		result.append(imageData);
		result.append(')');
		return result.toString();
	}

} //ImageEntryImpl
