/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.account.impl;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getTransactionId <em>Transaction Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getAccount <em>Account</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getTransactionType <em>Transaction Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getAmount <em>Amount</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl#getTransactionDate <em>Transaction Date</em>}</li>
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
	 * The cached value of the '{@link #getAccount() <em>Account</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccount()
	 * @generated
	 * @ordered
	 */
	protected Account account;

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
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected String source = SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAmount() <em>Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmount()
	 * @generated
	 * @ordered
	 */
	protected static final double AMOUNT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAmount() <em>Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmount()
	 * @generated
	 * @ordered
	 */
	protected double amount = AMOUNT_EDEFAULT;

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
	public Account getAccount() {
		if (account != null && account.eIsProxy()) {
			InternalEObject oldAccount = (InternalEObject)account;
			account = (Account)eResolveProxy(oldAccount);
			if (account != oldAccount) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT, oldAccount, account));
			}
		}
		return account;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Account basicGetAccount() {
		return account;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccount(Account newAccount) {
		Account oldAccount = account;
		account = newAccount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT, oldAccount, account));
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
	public String getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(String newSource) {
		String oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT_TRANSACTION__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAmount(double newAmount) {
		double oldAmount = amount;
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_ID:
				return getTransactionId();
			case AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT:
				if (resolve) return getAccount();
				return basicGetAccount();
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_TYPE:
				return getTransactionType();
			case AccountPackage.ACCOUNT_TRANSACTION__SOURCE:
				return getSource();
			case AccountPackage.ACCOUNT_TRANSACTION__AMOUNT:
				return getAmount();
			case AccountPackage.ACCOUNT_TRANSACTION__DESCRIPTION:
				return getDescription();
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_DATE:
				return getTransactionDate();
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
			case AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT:
				setAccount((Account)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_TYPE:
				setTransactionType((TransactionType)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__SOURCE:
				setSource((String)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__AMOUNT:
				setAmount((Double)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_DATE:
				setTransactionDate((Date)newValue);
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
			case AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT:
				setAccount((Account)null);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_TYPE:
				setTransactionType(TRANSACTION_TYPE_EDEFAULT);
				return;
			case AccountPackage.ACCOUNT_TRANSACTION__SOURCE:
				setSource(SOURCE_EDEFAULT);
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
			case AccountPackage.ACCOUNT_TRANSACTION__ACCOUNT:
				return account != null;
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_TYPE:
				return transactionType != TRANSACTION_TYPE_EDEFAULT;
			case AccountPackage.ACCOUNT_TRANSACTION__SOURCE:
				return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
			case AccountPackage.ACCOUNT_TRANSACTION__AMOUNT:
				return amount != AMOUNT_EDEFAULT;
			case AccountPackage.ACCOUNT_TRANSACTION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case AccountPackage.ACCOUNT_TRANSACTION__TRANSACTION_DATE:
				return TRANSACTION_DATE_EDEFAULT == null ? transactionDate != null : !TRANSACTION_DATE_EDEFAULT.equals(transactionDate);
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
		result.append(')');
		return result.toString();
	}

} //AccountTransactionImpl
