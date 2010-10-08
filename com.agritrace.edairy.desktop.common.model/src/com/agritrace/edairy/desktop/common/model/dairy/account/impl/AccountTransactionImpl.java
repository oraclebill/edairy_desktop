/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.account.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getRelatedLocation <em>Related Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getCheckNumber <em>Check Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getSignedBy <em>Signed By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AccountTransactionImpl extends TransactionImpl implements AccountTransaction {
	/**
	 * The default value of the '{@link #getReferenceNumber() <em>Reference Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERENCE_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferenceNumber() <em>Reference Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceNumber()
	 * @generated
	 * @ordered
	 */
	protected String referenceNumber = REFERENCE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final TransactionSource SOURCE_EDEFAULT = TransactionSource.STORE_CREDIT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected TransactionSource source = SOURCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRelatedLocation() <em>Related Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedLocation()
	 * @generated
	 * @ordered
	 */
	protected DairyLocation relatedLocation;

	/**
	 * The default value of the '{@link #getCheckNumber() <em>Check Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String CHECK_NUMBER_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getCheckNumber() <em>Check Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckNumber()
	 * @generated
	 * @ordered
	 */
	protected String checkNumber = CHECK_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSignedBy() <em>Signed By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignedBy()
	 * @generated
	 * @ordered
	 */
	protected static final String SIGNED_BY_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getSignedBy() <em>Signed By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignedBy()
	 * @generated
	 * @ordered
	 */
	protected String signedBy = SIGNED_BY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccountTransactionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccountPackage.Literals.ACCOUNT_TRANSACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getReferenceNumber() {
		return referenceNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferenceNumber(String newReferenceNumber) {
		final String oldReferenceNumber = referenceNumber;
		referenceNumber = newReferenceNumber;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__REFERENCE_NUMBER, oldReferenceNumber, referenceNumber));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransactionSource getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(TransactionSource newSource) {
		final TransactionSource oldSource = source;
		source = newSource == null ? SOURCE_EDEFAULT : newSource;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__SOURCE, oldSource, source));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DairyLocation getRelatedLocation() {
		if (relatedLocation != null && relatedLocation.eIsProxy()) {
			final InternalEObject oldRelatedLocation = (InternalEObject)relatedLocation;
			relatedLocation = (DairyLocation)eResolveProxy(oldRelatedLocation);
			if (relatedLocation != oldRelatedLocation) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AccountPackage.ACCOUNT_TRANSACTION__RELATED_LOCATION, oldRelatedLocation, relatedLocation));
				}
			}
		}
		return relatedLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyLocation basicGetRelatedLocation() {
		return relatedLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedLocation(DairyLocation newRelatedLocation) {
		final DairyLocation oldRelatedLocation = relatedLocation;
		relatedLocation = newRelatedLocation;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__RELATED_LOCATION, oldRelatedLocation, relatedLocation));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCheckNumber() {
		return checkNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCheckNumber(String newCheckNumber) {
		final String oldCheckNumber = checkNumber;
		checkNumber = newCheckNumber;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__CHECK_NUMBER, oldCheckNumber, checkNumber));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSignedBy() {
		return signedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSignedBy(String newSignedBy) {
		final String oldSignedBy = signedBy;
		signedBy = newSignedBy;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__SIGNED_BY, oldSignedBy, signedBy));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AccountPackage.ACCOUNT_TRANSACTION__REFERENCE_NUMBER:
				return getReferenceNumber();
			case AccountPackage.ACCOUNT_TRANSACTION__SOURCE:
				return getSource();
			case AccountPackage.ACCOUNT_TRANSACTION__RELATED_LOCATION:
				if (resolve) {
					return getRelatedLocation();
				}
				return basicGetRelatedLocation();
			case AccountPackage.ACCOUNT_TRANSACTION__CHECK_NUMBER:
				return getCheckNumber();
			case AccountPackage.ACCOUNT_TRANSACTION__SIGNED_BY:
				return getSignedBy();
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
			case AccountPackage.ACCOUNT_TRANSACTION__REFERENCE_NUMBER:
				setReferenceNumber((String)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__SOURCE:
				setSource((TransactionSource)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__RELATED_LOCATION:
				setRelatedLocation((DairyLocation)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__CHECK_NUMBER:
				setCheckNumber((String)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__SIGNED_BY:
				setSignedBy((String)newValue);
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
			case AccountPackage.ACCOUNT_TRANSACTION__REFERENCE_NUMBER:
				setReferenceNumber(REFERENCE_NUMBER_EDEFAULT);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__SOURCE:
				setSource(SOURCE_EDEFAULT);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__RELATED_LOCATION:
				setRelatedLocation((DairyLocation)null);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__CHECK_NUMBER:
				setCheckNumber(CHECK_NUMBER_EDEFAULT);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__SIGNED_BY:
				setSignedBy(SIGNED_BY_EDEFAULT);
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
			case AccountPackage.ACCOUNT_TRANSACTION__REFERENCE_NUMBER:
				return REFERENCE_NUMBER_EDEFAULT == null ? referenceNumber != null : !REFERENCE_NUMBER_EDEFAULT.equals(referenceNumber);
			case AccountPackage.ACCOUNT_TRANSACTION__SOURCE:
				return source != SOURCE_EDEFAULT;
			case AccountPackage.ACCOUNT_TRANSACTION__RELATED_LOCATION:
				return relatedLocation != null;
			case AccountPackage.ACCOUNT_TRANSACTION__CHECK_NUMBER:
				return CHECK_NUMBER_EDEFAULT == null ? checkNumber != null : !CHECK_NUMBER_EDEFAULT.equals(checkNumber);
			case AccountPackage.ACCOUNT_TRANSACTION__SIGNED_BY:
				return SIGNED_BY_EDEFAULT == null ? signedBy != null : !SIGNED_BY_EDEFAULT.equals(signedBy);
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
		if (eIsProxy()) {
			return super.toString();
		}

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (referenceNumber: ");
		result.append(referenceNumber);
		result.append(", source: ");
		result.append(source);
		result.append(", checkNumber: ");
		result.append(checkNumber);
		result.append(", signedBy: ");
		result.append(signedBy);
		result.append(')');
		return result.toString();
	}

} //AccountTransactionImpl
