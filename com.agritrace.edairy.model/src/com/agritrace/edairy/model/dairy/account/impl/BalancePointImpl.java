/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.account.impl;

import com.agritrace.edairy.model.dairy.account.Account;
import com.agritrace.edairy.model.dairy.account.AccountPackage;
import com.agritrace.edairy.model.dairy.account.BalancePoint;

import java.math.BigDecimal;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Balance Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.account.impl.BalancePointImpl#getAccountBalanceId <em>Account Balance Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.account.impl.BalancePointImpl#getAccount <em>Account</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.account.impl.BalancePointImpl#getPreviousBalance <em>Previous Balance</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.account.impl.BalancePointImpl#getAsOf <em>As Of</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.account.impl.BalancePointImpl#getAmount <em>Amount</em>}</li>
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
         * The cached value of the '{@link #getAccount() <em>Account</em>}' reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getAccount()
         * @generated
         * @ordered
         */
	protected Account account;

	/**
         * The cached value of the '{@link #getPreviousBalance() <em>Previous Balance</em>}' reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getPreviousBalance()
         * @generated
         * @ordered
         */
	protected BalancePoint previousBalance;

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
	public long getAccountBalanceId() {
                return accountBalanceId;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setAccountBalanceId(long newAccountBalanceId) {
                long oldAccountBalanceId = accountBalanceId;
                accountBalanceId = newAccountBalanceId;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.BALANCE_POINT__ACCOUNT_BALANCE_ID, oldAccountBalanceId, accountBalanceId));
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
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, AccountPackage.BALANCE_POINT__ACCOUNT, oldAccount, account));
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
                        eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.BALANCE_POINT__ACCOUNT, oldAccount, account));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public BalancePoint getPreviousBalance() {
                if (previousBalance != null && previousBalance.eIsProxy()) {
                        InternalEObject oldPreviousBalance = (InternalEObject)previousBalance;
                        previousBalance = (BalancePoint)eResolveProxy(oldPreviousBalance);
                        if (previousBalance != oldPreviousBalance) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, AccountPackage.BALANCE_POINT__PREVIOUS_BALANCE, oldPreviousBalance, previousBalance));
                        }
                }
                return previousBalance;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public BalancePoint basicGetPreviousBalance() {
                return previousBalance;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setPreviousBalance(BalancePoint newPreviousBalance) {
                BalancePoint oldPreviousBalance = previousBalance;
                previousBalance = newPreviousBalance;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.BALANCE_POINT__PREVIOUS_BALANCE, oldPreviousBalance, previousBalance));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public Date getAsOf() {
                return asOf;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setAsOf(Date newAsOf) {
                Date oldAsOf = asOf;
                asOf = newAsOf;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.BALANCE_POINT__AS_OF, oldAsOf, asOf));
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
                        eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.BALANCE_POINT__AMOUNT, oldAmount, amount));
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
                                if (resolve) return getAccount();
                                return basicGetAccount();
                        case AccountPackage.BALANCE_POINT__PREVIOUS_BALANCE:
                                if (resolve) return getPreviousBalance();
                                return basicGetPreviousBalance();
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
                        case AccountPackage.BALANCE_POINT__PREVIOUS_BALANCE:
                                setPreviousBalance((BalancePoint)newValue);
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
                        case AccountPackage.BALANCE_POINT__PREVIOUS_BALANCE:
                                setPreviousBalance((BalancePoint)null);
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
                                return account != null;
                        case AccountPackage.BALANCE_POINT__PREVIOUS_BALANCE:
                                return previousBalance != null;
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
                if (eIsProxy()) return super.toString();

                StringBuffer result = new StringBuffer(super.toString());
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
