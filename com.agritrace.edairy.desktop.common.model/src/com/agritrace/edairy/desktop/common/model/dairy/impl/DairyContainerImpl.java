/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.dairy.Asset;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;

import com.agritrace.edairy.desktop.common.model.tracking.impl.ContainerImpl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyContainerImpl#getAssetId <em>Asset Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyContainerImpl#getTagType <em>Tag Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyContainerImpl#getTagValue <em>Tag Value</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyContainerImpl#getDateAcquired <em>Date Acquired</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyContainerImpl#getDamageDate <em>Damage Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyContainerImpl#getDamageDescription <em>Damage Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyContainerImpl#getDateDisposed <em>Date Disposed</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyContainerImpl#getDisposalReason <em>Disposal Reason</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.DairyContainerImpl#getDisposalWitness <em>Disposal Witness</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DairyContainerImpl extends ContainerImpl implements DairyContainer {
	/**
	 * The default value of the '{@link #getAssetId() <em>Asset Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssetId()
	 * @generated
	 * @ordered
	 */
	protected static final Long ASSET_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAssetId() <em>Asset Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssetId()
	 * @generated
	 * @ordered
	 */
	protected Long assetId = ASSET_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTagType() <em>Tag Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTagType()
	 * @generated
	 * @ordered
	 */
	protected static final String TAG_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTagType() <em>Tag Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTagType()
	 * @generated
	 * @ordered
	 */
	protected String tagType = TAG_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTagValue() <em>Tag Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTagValue()
	 * @generated
	 * @ordered
	 */
	protected static final String TAG_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTagValue() <em>Tag Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTagValue()
	 * @generated
	 * @ordered
	 */
	protected String tagValue = TAG_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDateAcquired() <em>Date Acquired</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateAcquired()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_ACQUIRED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateAcquired() <em>Date Acquired</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateAcquired()
	 * @generated
	 * @ordered
	 */
	protected Date dateAcquired = DATE_ACQUIRED_EDEFAULT;

	/**
	 * The default value of the '{@link #getDamageDate() <em>Damage Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDamageDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DAMAGE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDamageDate() <em>Damage Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDamageDate()
	 * @generated
	 * @ordered
	 */
	protected Date damageDate = DAMAGE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDamageDescription() <em>Damage Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDamageDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DAMAGE_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDamageDescription() <em>Damage Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDamageDescription()
	 * @generated
	 * @ordered
	 */
	protected String damageDescription = DAMAGE_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDateDisposed() <em>Date Disposed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateDisposed()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_DISPOSED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateDisposed() <em>Date Disposed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateDisposed()
	 * @generated
	 * @ordered
	 */
	protected Date dateDisposed = DATE_DISPOSED_EDEFAULT;

	/**
	 * The default value of the '{@link #getDisposalReason() <em>Disposal Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisposalReason()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPOSAL_REASON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisposalReason() <em>Disposal Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisposalReason()
	 * @generated
	 * @ordered
	 */
	protected String disposalReason = DISPOSAL_REASON_EDEFAULT;

	/**
	 * The default value of the '{@link #getDisposalWitness() <em>Disposal Witness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisposalWitness()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPOSAL_WITNESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisposalWitness() <em>Disposal Witness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisposalWitness()
	 * @generated
	 * @ordered
	 */
	protected String disposalWitness = DISPOSAL_WITNESS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DairyContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.DAIRY_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getAssetId() {
		return assetId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssetId(Long newAssetId) {
		Long oldAssetId = assetId;
		assetId = newAssetId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_CONTAINER__ASSET_ID, oldAssetId, assetId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTagType() {
		return tagType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTagType(String newTagType) {
		String oldTagType = tagType;
		tagType = newTagType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_CONTAINER__TAG_TYPE, oldTagType, tagType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTagValue() {
		return tagValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTagValue(String newTagValue) {
		String oldTagValue = tagValue;
		tagValue = newTagValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_CONTAINER__TAG_VALUE, oldTagValue, tagValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDateAcquired() {
		return dateAcquired;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateAcquired(Date newDateAcquired) {
		Date oldDateAcquired = dateAcquired;
		dateAcquired = newDateAcquired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_CONTAINER__DATE_ACQUIRED, oldDateAcquired, dateAcquired));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDamageDate() {
		return damageDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDamageDate(Date newDamageDate) {
		Date oldDamageDate = damageDate;
		damageDate = newDamageDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_CONTAINER__DAMAGE_DATE, oldDamageDate, damageDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDamageDescription() {
		return damageDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDamageDescription(String newDamageDescription) {
		String oldDamageDescription = damageDescription;
		damageDescription = newDamageDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_CONTAINER__DAMAGE_DESCRIPTION, oldDamageDescription, damageDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDateDisposed() {
		return dateDisposed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateDisposed(Date newDateDisposed) {
		Date oldDateDisposed = dateDisposed;
		dateDisposed = newDateDisposed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_CONTAINER__DATE_DISPOSED, oldDateDisposed, dateDisposed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisposalReason() {
		return disposalReason;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisposalReason(String newDisposalReason) {
		String oldDisposalReason = disposalReason;
		disposalReason = newDisposalReason;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_CONTAINER__DISPOSAL_REASON, oldDisposalReason, disposalReason));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisposalWitness() {
		return disposalWitness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisposalWitness(String newDisposalWitness) {
		String oldDisposalWitness = disposalWitness;
		disposalWitness = newDisposalWitness;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.DAIRY_CONTAINER__DISPOSAL_WITNESS, oldDisposalWitness, disposalWitness));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.DAIRY_CONTAINER__ASSET_ID:
				return getAssetId();
			case DairyPackage.DAIRY_CONTAINER__TAG_TYPE:
				return getTagType();
			case DairyPackage.DAIRY_CONTAINER__TAG_VALUE:
				return getTagValue();
			case DairyPackage.DAIRY_CONTAINER__DATE_ACQUIRED:
				return getDateAcquired();
			case DairyPackage.DAIRY_CONTAINER__DAMAGE_DATE:
				return getDamageDate();
			case DairyPackage.DAIRY_CONTAINER__DAMAGE_DESCRIPTION:
				return getDamageDescription();
			case DairyPackage.DAIRY_CONTAINER__DATE_DISPOSED:
				return getDateDisposed();
			case DairyPackage.DAIRY_CONTAINER__DISPOSAL_REASON:
				return getDisposalReason();
			case DairyPackage.DAIRY_CONTAINER__DISPOSAL_WITNESS:
				return getDisposalWitness();
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
		switch (featureID) {
			case DairyPackage.DAIRY_CONTAINER__ASSET_ID:
				setAssetId((Long)newValue);
				return;
			case DairyPackage.DAIRY_CONTAINER__TAG_TYPE:
				setTagType((String)newValue);
				return;
			case DairyPackage.DAIRY_CONTAINER__TAG_VALUE:
				setTagValue((String)newValue);
				return;
			case DairyPackage.DAIRY_CONTAINER__DATE_ACQUIRED:
				setDateAcquired((Date)newValue);
				return;
			case DairyPackage.DAIRY_CONTAINER__DAMAGE_DATE:
				setDamageDate((Date)newValue);
				return;
			case DairyPackage.DAIRY_CONTAINER__DAMAGE_DESCRIPTION:
				setDamageDescription((String)newValue);
				return;
			case DairyPackage.DAIRY_CONTAINER__DATE_DISPOSED:
				setDateDisposed((Date)newValue);
				return;
			case DairyPackage.DAIRY_CONTAINER__DISPOSAL_REASON:
				setDisposalReason((String)newValue);
				return;
			case DairyPackage.DAIRY_CONTAINER__DISPOSAL_WITNESS:
				setDisposalWitness((String)newValue);
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
			case DairyPackage.DAIRY_CONTAINER__ASSET_ID:
				setAssetId(ASSET_ID_EDEFAULT);
				return;
			case DairyPackage.DAIRY_CONTAINER__TAG_TYPE:
				setTagType(TAG_TYPE_EDEFAULT);
				return;
			case DairyPackage.DAIRY_CONTAINER__TAG_VALUE:
				setTagValue(TAG_VALUE_EDEFAULT);
				return;
			case DairyPackage.DAIRY_CONTAINER__DATE_ACQUIRED:
				setDateAcquired(DATE_ACQUIRED_EDEFAULT);
				return;
			case DairyPackage.DAIRY_CONTAINER__DAMAGE_DATE:
				setDamageDate(DAMAGE_DATE_EDEFAULT);
				return;
			case DairyPackage.DAIRY_CONTAINER__DAMAGE_DESCRIPTION:
				setDamageDescription(DAMAGE_DESCRIPTION_EDEFAULT);
				return;
			case DairyPackage.DAIRY_CONTAINER__DATE_DISPOSED:
				setDateDisposed(DATE_DISPOSED_EDEFAULT);
				return;
			case DairyPackage.DAIRY_CONTAINER__DISPOSAL_REASON:
				setDisposalReason(DISPOSAL_REASON_EDEFAULT);
				return;
			case DairyPackage.DAIRY_CONTAINER__DISPOSAL_WITNESS:
				setDisposalWitness(DISPOSAL_WITNESS_EDEFAULT);
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
			case DairyPackage.DAIRY_CONTAINER__ASSET_ID:
				return ASSET_ID_EDEFAULT == null ? assetId != null : !ASSET_ID_EDEFAULT.equals(assetId);
			case DairyPackage.DAIRY_CONTAINER__TAG_TYPE:
				return TAG_TYPE_EDEFAULT == null ? tagType != null : !TAG_TYPE_EDEFAULT.equals(tagType);
			case DairyPackage.DAIRY_CONTAINER__TAG_VALUE:
				return TAG_VALUE_EDEFAULT == null ? tagValue != null : !TAG_VALUE_EDEFAULT.equals(tagValue);
			case DairyPackage.DAIRY_CONTAINER__DATE_ACQUIRED:
				return DATE_ACQUIRED_EDEFAULT == null ? dateAcquired != null : !DATE_ACQUIRED_EDEFAULT.equals(dateAcquired);
			case DairyPackage.DAIRY_CONTAINER__DAMAGE_DATE:
				return DAMAGE_DATE_EDEFAULT == null ? damageDate != null : !DAMAGE_DATE_EDEFAULT.equals(damageDate);
			case DairyPackage.DAIRY_CONTAINER__DAMAGE_DESCRIPTION:
				return DAMAGE_DESCRIPTION_EDEFAULT == null ? damageDescription != null : !DAMAGE_DESCRIPTION_EDEFAULT.equals(damageDescription);
			case DairyPackage.DAIRY_CONTAINER__DATE_DISPOSED:
				return DATE_DISPOSED_EDEFAULT == null ? dateDisposed != null : !DATE_DISPOSED_EDEFAULT.equals(dateDisposed);
			case DairyPackage.DAIRY_CONTAINER__DISPOSAL_REASON:
				return DISPOSAL_REASON_EDEFAULT == null ? disposalReason != null : !DISPOSAL_REASON_EDEFAULT.equals(disposalReason);
			case DairyPackage.DAIRY_CONTAINER__DISPOSAL_WITNESS:
				return DISPOSAL_WITNESS_EDEFAULT == null ? disposalWitness != null : !DISPOSAL_WITNESS_EDEFAULT.equals(disposalWitness);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Asset.class) {
			switch (derivedFeatureID) {
				case DairyPackage.DAIRY_CONTAINER__ASSET_ID: return DairyPackage.ASSET__ASSET_ID;
				case DairyPackage.DAIRY_CONTAINER__TAG_TYPE: return DairyPackage.ASSET__TAG_TYPE;
				case DairyPackage.DAIRY_CONTAINER__TAG_VALUE: return DairyPackage.ASSET__TAG_VALUE;
				case DairyPackage.DAIRY_CONTAINER__DATE_ACQUIRED: return DairyPackage.ASSET__DATE_ACQUIRED;
				case DairyPackage.DAIRY_CONTAINER__DAMAGE_DATE: return DairyPackage.ASSET__DAMAGE_DATE;
				case DairyPackage.DAIRY_CONTAINER__DAMAGE_DESCRIPTION: return DairyPackage.ASSET__DAMAGE_DESCRIPTION;
				case DairyPackage.DAIRY_CONTAINER__DATE_DISPOSED: return DairyPackage.ASSET__DATE_DISPOSED;
				case DairyPackage.DAIRY_CONTAINER__DISPOSAL_REASON: return DairyPackage.ASSET__DISPOSAL_REASON;
				case DairyPackage.DAIRY_CONTAINER__DISPOSAL_WITNESS: return DairyPackage.ASSET__DISPOSAL_WITNESS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Asset.class) {
			switch (baseFeatureID) {
				case DairyPackage.ASSET__ASSET_ID: return DairyPackage.DAIRY_CONTAINER__ASSET_ID;
				case DairyPackage.ASSET__TAG_TYPE: return DairyPackage.DAIRY_CONTAINER__TAG_TYPE;
				case DairyPackage.ASSET__TAG_VALUE: return DairyPackage.DAIRY_CONTAINER__TAG_VALUE;
				case DairyPackage.ASSET__DATE_ACQUIRED: return DairyPackage.DAIRY_CONTAINER__DATE_ACQUIRED;
				case DairyPackage.ASSET__DAMAGE_DATE: return DairyPackage.DAIRY_CONTAINER__DAMAGE_DATE;
				case DairyPackage.ASSET__DAMAGE_DESCRIPTION: return DairyPackage.DAIRY_CONTAINER__DAMAGE_DESCRIPTION;
				case DairyPackage.ASSET__DATE_DISPOSED: return DairyPackage.DAIRY_CONTAINER__DATE_DISPOSED;
				case DairyPackage.ASSET__DISPOSAL_REASON: return DairyPackage.DAIRY_CONTAINER__DISPOSAL_REASON;
				case DairyPackage.ASSET__DISPOSAL_WITNESS: return DairyPackage.DAIRY_CONTAINER__DISPOSAL_WITNESS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (assetId: ");
		result.append(assetId);
		result.append(", tagType: ");
		result.append(tagType);
		result.append(", tagValue: ");
		result.append(tagValue);
		result.append(", dateAcquired: ");
		result.append(dateAcquired);
		result.append(", damageDate: ");
		result.append(damageDate);
		result.append(", damageDescription: ");
		result.append(damageDescription);
		result.append(", dateDisposed: ");
		result.append(dateDisposed);
		result.append(", disposalReason: ");
		result.append(disposalReason);
		result.append(", disposalWitness: ");
		result.append(disposalWitness);
		result.append(')');
		return result.toString();
	}

} //DairyContainerImpl
