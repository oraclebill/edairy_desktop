/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.account.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getTransactionId <em>Transaction Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getAccount <em>Account</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getTransactionType <em>Transaction Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getRelatedLocation <em>Related Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getAmount <em>Amount</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getTransactionDate <em>Transaction Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getCheckNumber <em>Check Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getSignedBy <em>Signed By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AccountTransactionImpl extends EObjectImpl implements AccountTransaction {
	/**
	 * The default value of the '{@link #getTransactionId() <em>Transaction Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionId()
	 * @generated
	 * @ordered
	 */
	protected static final long TRANSACTION_ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTransactionId() <em>Transaction Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionId()
	 * @generated
	 * @ordered
	 */
	protected long transactionId = TRANSACTION_ID_EDEFAULT;

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
	 * The default value of the '{@link #getTransactionType() <em>Transaction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionType()
	 * @generated
	 * @ordered
	 */
	protected static final TransactionType TRANSACTION_TYPE_EDEFAULT = TransactionType.CREDIT;

	/**
	 * The cached value of the '{@link #getTransactionType() <em>Transaction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionType()
	 * @generated
	 * @ordered
	 */
	protected TransactionType transactionType = TRANSACTION_TYPE_EDEFAULT;

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
	 * The default value of the '{@link #getAmount() <em>Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmount()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal AMOUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAmount() <em>Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmount()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal amount = AMOUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransactionDate() <em>Transaction Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date TRANSACTION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransactionDate() <em>Transaction Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionDate()
	 * @generated
	 * @ordered
	 */
	protected Date transactionDate = TRANSACTION_DATE_EDEFAULT;

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
	public long getTransactionId() {
		return transactionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransactionId(long newTransactionId) {
		long oldTransactionId = transactionId;
		transactionId = newTransactionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_ID, oldTransactionId, transactionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReferenceNumber() {
		return referenceNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceNumber(String newReferenceNumber) {
		String oldReferenceNumber = referenceNumber;
		referenceNumber = newReferenceNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__REFERENCE_NUMBER, oldReferenceNumber, referenceNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Account getAccount() {
		if (eContainerFeatureID() != AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT) return null;
		return (Account)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccount(Account newAccount, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAccount, AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccount(Account newAccount) {
		if (newAccount != eInternalContainer() || (eContainerFeatureID() != AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT && newAccount != null)) {
			if (EcoreUtil.isAncestor(this, newAccount))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAccount != null)
				msgs = ((InternalEObject)newAccount).eInverseAdd(this, AccountPackage.ACCOUNT__TRANSACTIONS, Account.class, msgs);
			msgs = basicSetAccount(newAccount, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT, newAccount, newAccount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransactionType(TransactionType newTransactionType) {
		TransactionType oldTransactionType = transactionType;
		transactionType = newTransactionType == null ? TRANSACTION_TYPE_EDEFAULT : newTransactionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_TYPE, oldTransactionType, transactionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionSource getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(TransactionSource newSource) {
		TransactionSource oldSource = source;
		source = newSource == null ? SOURCE_EDEFAULT : newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyLocation getRelatedLocation() {
		if (relatedLocation != null && relatedLocation.eIsProxy()) {
			InternalEObject oldRelatedLocation = (InternalEObject)relatedLocation;
			relatedLocation = (DairyLocation)eResolveProxy(oldRelatedLocation);
			if (relatedLocation != oldRelatedLocation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AccountPackage.ACCOUNT_TRANSACTION__RELATED_LOCATION, oldRelatedLocation, relatedLocation));
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
	public void setRelatedLocation(DairyLocation newRelatedLocation) {
		DairyLocation oldRelatedLocation = relatedLocation;
		relatedLocation = newRelatedLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__RELATED_LOCATION, oldRelatedLocation, relatedLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAmount(BigDecimal newAmount) {
		BigDecimal oldAmount = amount;
		amount = newAmount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__AMOUNT, oldAmount, amount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransactionDate(Date newTransactionDate) {
		Date oldTransactionDate = transactionDate;
		transactionDate = newTransactionDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_DATE, oldTransactionDate, transactionDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCheckNumber() {
		return checkNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckNumber(String newCheckNumber) {
		String oldCheckNumber = checkNumber;
		checkNumber = newCheckNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__CHECK_NUMBER, oldCheckNumber, checkNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSignedBy() {
		return signedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignedBy(String newSignedBy) {
		String oldSignedBy = signedBy;
		signedBy = newSignedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__SIGNED_BY, oldSignedBy, signedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAccount((Account)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT:
				return basicSetAccount(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT:
				return eInternalContainer().eInverseRemove(this, AccountPackage.ACCOUNT__TRANSACTIONS, Account.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_ID:
				return getTransactionId();
			case AccountPackage.ACCOUNT_TRANSACTION__REFERENCE_NUMBER:
				return getReferenceNumber();
			case AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT:
				return getAccount();
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_TYPE:
				return getTransactionType();
			case AccountPackage.ACCOUNT_TRANSACTION__SOURCE:
				return getSource();
			case AccountPackage.ACCOUNT_TRANSACTION__RELATED_LOCATION:
				if (resolve) return getRelatedLocation();
				return basicGetRelatedLocation();
			case AccountPackage.ACCOUNT_TRANSACTION__AMOUNT:
				return getAmount();
			case AccountPackage.ACCOUNT_TRANSACTION__DESCRIPTION:
				return getDescription();
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_DATE:
				return getTransactionDate();
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
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_ID:
				setTransactionId((Long)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__REFERENCE_NUMBER:
				setReferenceNumber((String)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT:
				setAccount((Account)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_TYPE:
				setTransactionType((TransactionType)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__SOURCE:
				setSource((TransactionSource)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__RELATED_LOCATION:
				setRelatedLocation((DairyLocation)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__AMOUNT:
				setAmount((BigDecimal)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_DATE:
				setTransactionDate((Date)newValue);
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
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_ID:
				setTransactionId(TRANSACTION_ID_EDEFAULT);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__REFERENCE_NUMBER:
				setReferenceNumber(REFERENCE_NUMBER_EDEFAULT);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT:
				setAccount((Account)null);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_TYPE:
				setTransactionType(TRANSACTION_TYPE_EDEFAULT);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__SOURCE:
				setSource(SOURCE_EDEFAULT);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__RELATED_LOCATION:
				setRelatedLocation((DairyLocation)null);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__AMOUNT:
				setAmount(AMOUNT_EDEFAULT);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_DATE:
				setTransactionDate(TRANSACTION_DATE_EDEFAULT);
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
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_ID:
				return transactionId != TRANSACTION_ID_EDEFAULT;
			case AccountPackage.ACCOUNT_TRANSACTION__REFERENCE_NUMBER:
				return REFERENCE_NUMBER_EDEFAULT == null ? referenceNumber != null : !REFERENCE_NUMBER_EDEFAULT.equals(referenceNumber);
			case AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT:
				return getAccount() != null;
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_TYPE:
				return transactionType != TRANSACTION_TYPE_EDEFAULT;
			case AccountPackage.ACCOUNT_TRANSACTION__SOURCE:
				return source != SOURCE_EDEFAULT;
			case AccountPackage.ACCOUNT_TRANSACTION__RELATED_LOCATION:
				return relatedLocation != null;
			case AccountPackage.ACCOUNT_TRANSACTION__AMOUNT:
				return AMOUNT_EDEFAULT == null ? amount != null : !AMOUNT_EDEFAULT.equals(amount);
			case AccountPackage.ACCOUNT_TRANSACTION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_DATE:
				return TRANSACTION_DATE_EDEFAULT == null ? transactionDate != null : !TRANSACTION_DATE_EDEFAULT.equals(transactionDate);
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (transactionId: ");
		result.append(transactionId);
		result.append(", referenceNumber: ");
		result.append(referenceNumber);
		result.append(", transactionType: ");
		result.append(transactionType);
		result.append(", source: ");
		result.append(source);
		result.append(", amount: ");
		result.append(amount);
		result.append(", description: ");
		result.append(description);
		result.append(", transactionDate: ");
		result.append(transactionDate);
		result.append(", checkNumber: ");
		result.append(checkNumber);
		result.append(", signedBy: ");
		result.append(signedBy);
		result.append(')');
		return result.toString();
	}

} //AccountTransactionImpl
