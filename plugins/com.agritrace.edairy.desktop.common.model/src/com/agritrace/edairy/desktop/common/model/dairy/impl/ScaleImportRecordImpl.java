/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scale Import Record</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.ScaleImportRecordImpl#getScaleSerial <em>Scale Serial</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.ScaleImportRecordImpl#getCollectionTime <em>Collection Time</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.ScaleImportRecordImpl#getCenterNumber <em>Center Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.ScaleImportRecordImpl#getNumCans <em>Num Cans</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.ScaleImportRecordImpl#getTripNumber <em>Trip Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.ScaleImportRecordImpl#getOperatorCode <em>Operator Code</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.ScaleImportRecordImpl#isValidated <em>Validated</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScaleImportRecordImpl extends CollectionJournalLineImpl implements ScaleImportRecord {
	/**
	 * The default value of the '{@link #getScaleSerial() <em>Scale Serial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScaleSerial()
	 * @generated
	 * @ordered
	 */
	protected static final String SCALE_SERIAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScaleSerial() <em>Scale Serial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScaleSerial()
	 * @generated
	 * @ordered
	 */
	protected String scaleSerial = SCALE_SERIAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getCollectionTime() <em>Collection Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionTime()
	 * @generated
	 * @ordered
	 */
	protected static final Date COLLECTION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCollectionTime() <em>Collection Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionTime()
	 * @generated
	 * @ordered
	 */
	protected Date collectionTime = COLLECTION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCenterNumber() <em>Center Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCenterNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String CENTER_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCenterNumber() <em>Center Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCenterNumber()
	 * @generated
	 * @ordered
	 */
	protected String centerNumber = CENTER_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumCans() <em>Num Cans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumCans()
	 * @generated
	 * @ordered
	 */
	protected static final String NUM_CANS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumCans() <em>Num Cans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumCans()
	 * @generated
	 * @ordered
	 */
	protected String numCans = NUM_CANS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTripNumber() <em>Trip Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTripNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String TRIP_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTripNumber() <em>Trip Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTripNumber()
	 * @generated
	 * @ordered
	 */
	protected String tripNumber = TRIP_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getOperatorCode() <em>Operator Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorCode()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATOR_CODE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getOperatorCode() <em>Operator Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorCode()
	 * @generated
	 * @ordered
	 */
	protected String operatorCode = OPERATOR_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #isValidated() <em>Validated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALIDATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValidated() <em>Validated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidated()
	 * @generated
	 * @ordered
	 */
	protected boolean validated = VALIDATED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScaleImportRecordImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.SCALE_IMPORT_RECORD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScaleSerial() {
		return scaleSerial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScaleSerial(String newScaleSerial) {
		String oldScaleSerial = scaleSerial;
		scaleSerial = newScaleSerial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.SCALE_IMPORT_RECORD__SCALE_SERIAL, oldScaleSerial, scaleSerial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCollectionTime() {
		return collectionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollectionTime(Date newCollectionTime) {
		Date oldCollectionTime = collectionTime;
		collectionTime = newCollectionTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.SCALE_IMPORT_RECORD__COLLECTION_TIME, oldCollectionTime, collectionTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCenterNumber() {
		return centerNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCenterNumber(String newCenterNumber) {
		String oldCenterNumber = centerNumber;
		centerNumber = newCenterNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.SCALE_IMPORT_RECORD__CENTER_NUMBER, oldCenterNumber, centerNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNumCans() {
		return numCans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumCans(String newNumCans) {
		String oldNumCans = numCans;
		numCans = newNumCans;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.SCALE_IMPORT_RECORD__NUM_CANS, oldNumCans, numCans));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTripNumber() {
		return tripNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTripNumber(String newTripNumber) {
		String oldTripNumber = tripNumber;
		tripNumber = newTripNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.SCALE_IMPORT_RECORD__TRIP_NUMBER, oldTripNumber, tripNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperatorCode() {
		return operatorCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperatorCode(String newOperatorCode) {
		String oldOperatorCode = operatorCode;
		operatorCode = newOperatorCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.SCALE_IMPORT_RECORD__OPERATOR_CODE, oldOperatorCode, operatorCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValidated() {
		return validated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidated(boolean newValidated) {
		boolean oldValidated = validated;
		validated = newValidated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.SCALE_IMPORT_RECORD__VALIDATED, oldValidated, validated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.SCALE_IMPORT_RECORD__SCALE_SERIAL:
				return getScaleSerial();
			case DairyPackage.SCALE_IMPORT_RECORD__COLLECTION_TIME:
				return getCollectionTime();
			case DairyPackage.SCALE_IMPORT_RECORD__CENTER_NUMBER:
				return getCenterNumber();
			case DairyPackage.SCALE_IMPORT_RECORD__NUM_CANS:
				return getNumCans();
			case DairyPackage.SCALE_IMPORT_RECORD__TRIP_NUMBER:
				return getTripNumber();
			case DairyPackage.SCALE_IMPORT_RECORD__OPERATOR_CODE:
				return getOperatorCode();
			case DairyPackage.SCALE_IMPORT_RECORD__VALIDATED:
				return isValidated();
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
			case DairyPackage.SCALE_IMPORT_RECORD__SCALE_SERIAL:
				setScaleSerial((String)newValue);
				return;
			case DairyPackage.SCALE_IMPORT_RECORD__COLLECTION_TIME:
				setCollectionTime((Date)newValue);
				return;
			case DairyPackage.SCALE_IMPORT_RECORD__CENTER_NUMBER:
				setCenterNumber((String)newValue);
				return;
			case DairyPackage.SCALE_IMPORT_RECORD__NUM_CANS:
				setNumCans((String)newValue);
				return;
			case DairyPackage.SCALE_IMPORT_RECORD__TRIP_NUMBER:
				setTripNumber((String)newValue);
				return;
			case DairyPackage.SCALE_IMPORT_RECORD__OPERATOR_CODE:
				setOperatorCode((String)newValue);
				return;
			case DairyPackage.SCALE_IMPORT_RECORD__VALIDATED:
				setValidated((Boolean)newValue);
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
			case DairyPackage.SCALE_IMPORT_RECORD__SCALE_SERIAL:
				setScaleSerial(SCALE_SERIAL_EDEFAULT);
				return;
			case DairyPackage.SCALE_IMPORT_RECORD__COLLECTION_TIME:
				setCollectionTime(COLLECTION_TIME_EDEFAULT);
				return;
			case DairyPackage.SCALE_IMPORT_RECORD__CENTER_NUMBER:
				setCenterNumber(CENTER_NUMBER_EDEFAULT);
				return;
			case DairyPackage.SCALE_IMPORT_RECORD__NUM_CANS:
				setNumCans(NUM_CANS_EDEFAULT);
				return;
			case DairyPackage.SCALE_IMPORT_RECORD__TRIP_NUMBER:
				setTripNumber(TRIP_NUMBER_EDEFAULT);
				return;
			case DairyPackage.SCALE_IMPORT_RECORD__OPERATOR_CODE:
				setOperatorCode(OPERATOR_CODE_EDEFAULT);
				return;
			case DairyPackage.SCALE_IMPORT_RECORD__VALIDATED:
				setValidated(VALIDATED_EDEFAULT);
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
			case DairyPackage.SCALE_IMPORT_RECORD__SCALE_SERIAL:
				return SCALE_SERIAL_EDEFAULT == null ? scaleSerial != null : !SCALE_SERIAL_EDEFAULT.equals(scaleSerial);
			case DairyPackage.SCALE_IMPORT_RECORD__COLLECTION_TIME:
				return COLLECTION_TIME_EDEFAULT == null ? collectionTime != null : !COLLECTION_TIME_EDEFAULT.equals(collectionTime);
			case DairyPackage.SCALE_IMPORT_RECORD__CENTER_NUMBER:
				return CENTER_NUMBER_EDEFAULT == null ? centerNumber != null : !CENTER_NUMBER_EDEFAULT.equals(centerNumber);
			case DairyPackage.SCALE_IMPORT_RECORD__NUM_CANS:
				return NUM_CANS_EDEFAULT == null ? numCans != null : !NUM_CANS_EDEFAULT.equals(numCans);
			case DairyPackage.SCALE_IMPORT_RECORD__TRIP_NUMBER:
				return TRIP_NUMBER_EDEFAULT == null ? tripNumber != null : !TRIP_NUMBER_EDEFAULT.equals(tripNumber);
			case DairyPackage.SCALE_IMPORT_RECORD__OPERATOR_CODE:
				return OPERATOR_CODE_EDEFAULT == null ? operatorCode != null : !OPERATOR_CODE_EDEFAULT.equals(operatorCode);
			case DairyPackage.SCALE_IMPORT_RECORD__VALIDATED:
				return validated != VALIDATED_EDEFAULT;
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
		result.append(" (scaleSerial: ");
		result.append(scaleSerial);
		result.append(", collectionTime: ");
		result.append(collectionTime);
		result.append(", centerNumber: ");
		result.append(centerNumber);
		result.append(", numCans: ");
		result.append(numCans);
		result.append(", tripNumber: ");
		result.append(tripNumber);
		result.append(", operatorCode: ");
		result.append(operatorCode);
		result.append(", validated: ");
		result.append(validated);
		result.append(')');
		return result.toString();
	}

} //ScaleImportRecordImpl
