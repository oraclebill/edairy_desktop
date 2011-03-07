/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.account.impl;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;

import java.math.BigDecimal;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.TransactionImpl#getAccount <em>Account</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.TransactionImpl#getTransactionId <em>Transaction Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.TransactionImpl#getTransactionDate <em>Transaction Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.TransactionImpl#getTransactionType <em>Transaction Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.TransactionImpl#getAmount <em>Amount</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.TransactionImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransactionImpl extends EObjectImpl implements Transaction {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransactionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccountPackage.Literals.TRANSACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Account getAccount() {
		if (eContainerFeatureID() != AccountPackage.TRANSACTION__ACCOUNT) return null;
		return (Account)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccount(Account newAccount, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAccount, AccountPackage.TRANSACTION__ACCOUNT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccount(Account newAccount) {
		if (newAccount != eInternalContainer() || (eContainerFeatureID() != AccountPackage.TRANSACTION__ACCOUNT && newAccount != null))
		{
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
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.TRANSACTION__ACCOUNT, newAccount, newAccount));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.TRANSACTION__TRANSACTION_ID, oldTransactionId, transactionId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.TRANSACTION__TRANSACTION_DATE, oldTransactionDate, transactionDate));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.TRANSACTION__TRANSACTION_TYPE, oldTransactionType, transactionType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.TRANSACTION__AMOUNT, oldAmount, amount));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.TRANSACTION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case AccountPackage.TRANSACTION__ACCOUNT:
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
		switch (featureID)
		{
			case AccountPackage.TRANSACTION__ACCOUNT:
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
		switch (eContainerFeatureID())
		{
			case AccountPackage.TRANSACTION__ACCOUNT:
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
		switch (featureID)
		{
			case AccountPackage.TRANSACTION__ACCOUNT:
				return getAccount();
			case AccountPackage.TRANSACTION__TRANSACTION_ID:
				return getTransactionId();
			case AccountPackage.TRANSACTION__TRANSACTION_DATE:
				return getTransactionDate();
			case AccountPackage.TRANSACTION__TRANSACTION_TYPE:
				return getTransactionType();
			case AccountPackage.TRANSACTION__AMOUNT:
				return getAmount();
			case AccountPackage.TRANSACTION__DESCRIPTION:
				return getDescription();
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
			case AccountPackage.TRANSACTION__ACCOUNT:
				setAccount((Account)newValue);
				return;
			case AccountPackage.TRANSACTION__TRANSACTION_ID:
				setTransactionId((Long)newValue);
				return;
			case AccountPackage.TRANSACTION__TRANSACTION_DATE:
				setTransactionDate((Date)newValue);
				return;
			case AccountPackage.TRANSACTION__TRANSACTION_TYPE:
				setTransactionType((TransactionType)newValue);
				return;
			case AccountPackage.TRANSACTION__AMOUNT:
				setAmount((BigDecimal)newValue);
				return;
			case AccountPackage.TRANSACTION__DESCRIPTION:
				setDescription((String)newValue);
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
			case AccountPackage.TRANSACTION__ACCOUNT:
				setAccount((Account)null);
				return;
			case AccountPackage.TRANSACTION__TRANSACTION_ID:
				setTransactionId(TRANSACTION_ID_EDEFAULT);
				return;
			case AccountPackage.TRANSACTION__TRANSACTION_DATE:
				setTransactionDate(TRANSACTION_DATE_EDEFAULT);
				return;
			case AccountPackage.TRANSACTION__TRANSACTION_TYPE:
				setTransactionType(TRANSACTION_TYPE_EDEFAULT);
				return;
			case AccountPackage.TRANSACTION__AMOUNT:
				setAmount(AMOUNT_EDEFAULT);
				return;
			case AccountPackage.TRANSACTION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
			case AccountPackage.TRANSACTION__ACCOUNT:
				return getAccount() != null;
			case AccountPackage.TRANSACTION__TRANSACTION_ID:
				return transactionId != TRANSACTION_ID_EDEFAULT;
			case AccountPackage.TRANSACTION__TRANSACTION_DATE:
				return TRANSACTION_DATE_EDEFAULT == null ? transactionDate != null : !TRANSACTION_DATE_EDEFAULT.equals(transactionDate);
			case AccountPackage.TRANSACTION__TRANSACTION_TYPE:
				return transactionType != TRANSACTION_TYPE_EDEFAULT;
			case AccountPackage.TRANSACTION__AMOUNT:
				return AMOUNT_EDEFAULT == null ? amount != null : !AMOUNT_EDEFAULT.equals(amount);
			case AccountPackage.TRANSACTION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
		result.append(", transactionDate: ");
		result.append(transactionDate);
		result.append(", transactionType: ");
		result.append(transactionType);
		result.append(", amount: ");
		result.append(amount);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //TransactionImpl
