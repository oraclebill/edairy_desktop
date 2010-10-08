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

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Balance Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.BalancePointImpl#getAccountBalanceId <em>Account Balance Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.BalancePointImpl#getAccount <em>Account</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.BalancePointImpl#getAsOf <em>As Of</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.BalancePointImpl#getAmount <em>Amount</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BalancePointImpl extends EObjectImpl implements BalancePoint {
	/**
	 * The default value of the '{@link #getAccountBalanceId() <em>Account Balance Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccountBalanceId()
	 * @generated
	 * @ordered
	 */
	protected static final long ACCOUNT_BALANCE_ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getAccountBalanceId() <em>Account Balance Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccountBalanceId()
	 * @generated
	 * @ordered
	 */
	protected long accountBalanceId = ACCOUNT_BALANCE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getAsOf() <em>As Of</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsOf()
	 * @generated
	 * @ordered
	 */
	protected static final Date AS_OF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAsOf() <em>As Of</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsOf()
	 * @generated
	 * @ordered
	 */
	protected Date asOf = AS_OF_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BalancePointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccountPackage.Literals.BALANCE_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getAccountBalanceId() {
		return accountBalanceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAccountBalanceId(long newAccountBalanceId) {
		final long oldAccountBalanceId = accountBalanceId;
		accountBalanceId = newAccountBalanceId;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.BALANCE_POINT__ACCOUNT_BALANCE_ID, oldAccountBalanceId, accountBalanceId));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Account getAccount() {
		if (eContainerFeatureID() != AccountPackage.BALANCE_POINT__ACCOUNT) {
			return null;
		}
		return (Account)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccount(Account newAccount, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAccount, AccountPackage.BALANCE_POINT__ACCOUNT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAccount(Account newAccount) {
		if (newAccount != eInternalContainer() || eContainerFeatureID() != AccountPackage.BALANCE_POINT__ACCOUNT && newAccount != null) {
			if (EcoreUtil.isAncestor(this, newAccount)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newAccount != null) {
				msgs = ((InternalEObject)newAccount).eInverseAdd(this, AccountPackage.ACCOUNT__BALANCES, Account.class, msgs);
			}
			msgs = basicSetAccount(newAccount, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.BALANCE_POINT__ACCOUNT, newAccount, newAccount));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getAsOf() {
		return asOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAsOf(Date newAsOf) {
		final Date oldAsOf = asOf;
		asOf = newAsOf;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.BALANCE_POINT__AS_OF, oldAsOf, asOf));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAmount(BigDecimal newAmount) {
		final BigDecimal oldAmount = amount;
		amount = newAmount;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.BALANCE_POINT__AMOUNT, oldAmount, amount));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AccountPackage.BALANCE_POINT__ACCOUNT:
				if (eInternalContainer() != null) {
					msgs = eBasicRemoveFromContainer(msgs);
				}
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
			case AccountPackage.BALANCE_POINT__ACCOUNT:
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
			case AccountPackage.BALANCE_POINT__ACCOUNT:
				return eInternalContainer().eInverseRemove(this, AccountPackage.ACCOUNT__BALANCES, Account.class, msgs);
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
			case AccountPackage.BALANCE_POINT__ACCOUNT_BALANCE_ID:
				return getAccountBalanceId();
			case AccountPackage.BALANCE_POINT__ACCOUNT:
				return getAccount();
			case AccountPackage.BALANCE_POINT__AS_OF:
				return getAsOf();
			case AccountPackage.BALANCE_POINT__AMOUNT:
				return getAmount();
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
			case AccountPackage.BALANCE_POINT__ACCOUNT_BALANCE_ID:
				setAccountBalanceId((Long)newValue);
				return;
			case AccountPackage.BALANCE_POINT__ACCOUNT:
				setAccount((Account)newValue);
				return;
			case AccountPackage.BALANCE_POINT__AS_OF:
				setAsOf((Date)newValue);
				return;
			case AccountPackage.BALANCE_POINT__AMOUNT:
				setAmount((BigDecimal)newValue);
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
			case AccountPackage.BALANCE_POINT__ACCOUNT_BALANCE_ID:
				setAccountBalanceId(ACCOUNT_BALANCE_ID_EDEFAULT);
				return;
			case AccountPackage.BALANCE_POINT__ACCOUNT:
				setAccount((Account)null);
				return;
			case AccountPackage.BALANCE_POINT__AS_OF:
				setAsOf(AS_OF_EDEFAULT);
				return;
			case AccountPackage.BALANCE_POINT__AMOUNT:
				setAmount(AMOUNT_EDEFAULT);
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
			case AccountPackage.BALANCE_POINT__ACCOUNT_BALANCE_ID:
				return accountBalanceId != ACCOUNT_BALANCE_ID_EDEFAULT;
			case AccountPackage.BALANCE_POINT__ACCOUNT:
				return getAccount() != null;
			case AccountPackage.BALANCE_POINT__AS_OF:
				return AS_OF_EDEFAULT == null ? asOf != null : !AS_OF_EDEFAULT.equals(asOf);
			case AccountPackage.BALANCE_POINT__AMOUNT:
				return AMOUNT_EDEFAULT == null ? amount != null : !AMOUNT_EDEFAULT.equals(amount);
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
		result.append(" (accountBalanceId: ");
		result.append(accountBalanceId);
		result.append(", asOf: ");
		result.append(asOf);
		result.append(", amount: ");
		result.append(amount);
		result.append(')');
		return result.toString();
	}

} //BalancePointImpl
