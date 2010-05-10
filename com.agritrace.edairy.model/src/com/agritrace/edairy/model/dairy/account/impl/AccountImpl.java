/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.account.impl;

import com.agritrace.edairy.model.dairy.Membership;

import com.agritrace.edairy.model.dairy.account.Account;
import com.agritrace.edairy.model.dairy.account.AccountPackage;
import com.agritrace.edairy.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.model.dairy.account.BalancePoint;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Account</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.account.impl.AccountImpl#getAccountId <em>Account Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.account.impl.AccountImpl#getMember <em>Member</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.account.impl.AccountImpl#getEstablished <em>Established</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.account.impl.AccountImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.account.impl.AccountImpl#getTransactions <em>Transactions</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.account.impl.AccountImpl#getBalances <em>Balances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AccountImpl extends EObjectImpl implements Account {
	/**
         * The default value of the '{@link #getAccountId() <em>Account Id</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getAccountId()
         * @generated
         * @ordered
         */
	protected static final long ACCOUNT_ID_EDEFAULT = 0L;

	/**
         * The cached value of the '{@link #getAccountId() <em>Account Id</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getAccountId()
         * @generated
         * @ordered
         */
	protected long accountId = ACCOUNT_ID_EDEFAULT;

	/**
         * The cached value of the '{@link #getMember() <em>Member</em>}' reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getMember()
         * @generated
         * @ordered
         */
	protected Membership member;

	/**
         * The default value of the '{@link #getEstablished() <em>Established</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getEstablished()
         * @generated
         * @ordered
         */
	protected static final Date ESTABLISHED_EDEFAULT = null;

	/**
         * The cached value of the '{@link #getEstablished() <em>Established</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getEstablished()
         * @generated
         * @ordered
         */
	protected Date established = ESTABLISHED_EDEFAULT;

	/**
         * The default value of the '{@link #getType() <em>Type</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getType()
         * @generated
         * @ordered
         */
	protected static final String TYPE_EDEFAULT = null;

	/**
         * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getType()
         * @generated
         * @ordered
         */
	protected String type = TYPE_EDEFAULT;

	/**
         * The cached value of the '{@link #getTransactions() <em>Transactions</em>}' reference list.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getTransactions()
         * @generated
         * @ordered
         */
	protected EList<AccountTransaction> transactions;

	/**
         * The cached value of the '{@link #getBalances() <em>Balances</em>}' reference list.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getBalances()
         * @generated
         * @ordered
         */
	protected EList<BalancePoint> balances;

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	protected AccountImpl() {
                super();
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	protected EClass eStaticClass() {
                return AccountPackage.Literals.ACCOUNT;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public long getAccountId() {
                return accountId;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setAccountId(long newAccountId) {
                long oldAccountId = accountId;
                accountId = newAccountId;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT__ACCOUNT_ID, oldAccountId, accountId));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public Membership getMember() {
                if (member != null && member.eIsProxy()) {
                        InternalEObject oldMember = (InternalEObject)member;
                        member = (Membership)eResolveProxy(oldMember);
                        if (member != oldMember) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, AccountPackage.ACCOUNT__MEMBER, oldMember, member));
                        }
                }
                return member;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public Membership basicGetMember() {
                return member;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setMember(Membership newMember) {
                Membership oldMember = member;
                member = newMember;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT__MEMBER, oldMember, member));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public Date getEstablished() {
                return established;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setEstablished(Date newEstablished) {
                Date oldEstablished = established;
                established = newEstablished;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT__ESTABLISHED, oldEstablished, established));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public String getType() {
                return type;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setType(String newType) {
                String oldType = type;
                type = newType;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, AccountPackage.ACCOUNT__TYPE, oldType, type));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EList<AccountTransaction> getTransactions() {
                if (transactions == null) {
                        transactions = new EObjectResolvingEList<AccountTransaction>(AccountTransaction.class, this, AccountPackage.ACCOUNT__TRANSACTIONS);
                }
                return transactions;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EList<BalancePoint> getBalances() {
                if (balances == null) {
                        balances = new EObjectResolvingEList<BalancePoint>(BalancePoint.class, this, AccountPackage.ACCOUNT__BALANCES);
                }
                return balances;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case AccountPackage.ACCOUNT__ACCOUNT_ID:
                                return getAccountId();
                        case AccountPackage.ACCOUNT__MEMBER:
                                if (resolve) return getMember();
                                return basicGetMember();
                        case AccountPackage.ACCOUNT__ESTABLISHED:
                                return getEstablished();
                        case AccountPackage.ACCOUNT__TYPE:
                                return getType();
                        case AccountPackage.ACCOUNT__TRANSACTIONS:
                                return getTransactions();
                        case AccountPackage.ACCOUNT__BALANCES:
                                return getBalances();
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
                        case AccountPackage.ACCOUNT__ACCOUNT_ID:
                                setAccountId((Long)newValue);
                                return;
                        case AccountPackage.ACCOUNT__MEMBER:
                                setMember((Membership)newValue);
                                return;
                        case AccountPackage.ACCOUNT__ESTABLISHED:
                                setEstablished((Date)newValue);
                                return;
                        case AccountPackage.ACCOUNT__TYPE:
                                setType((String)newValue);
                                return;
                        case AccountPackage.ACCOUNT__TRANSACTIONS:
                                getTransactions().clear();
                                getTransactions().addAll((Collection<? extends AccountTransaction>)newValue);
                                return;
                        case AccountPackage.ACCOUNT__BALANCES:
                                getBalances().clear();
                                getBalances().addAll((Collection<? extends BalancePoint>)newValue);
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
                        case AccountPackage.ACCOUNT__ACCOUNT_ID:
                                setAccountId(ACCOUNT_ID_EDEFAULT);
                                return;
                        case AccountPackage.ACCOUNT__MEMBER:
                                setMember((Membership)null);
                                return;
                        case AccountPackage.ACCOUNT__ESTABLISHED:
                                setEstablished(ESTABLISHED_EDEFAULT);
                                return;
                        case AccountPackage.ACCOUNT__TYPE:
                                setType(TYPE_EDEFAULT);
                                return;
                        case AccountPackage.ACCOUNT__TRANSACTIONS:
                                getTransactions().clear();
                                return;
                        case AccountPackage.ACCOUNT__BALANCES:
                                getBalances().clear();
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
                        case AccountPackage.ACCOUNT__ACCOUNT_ID:
                                return accountId != ACCOUNT_ID_EDEFAULT;
                        case AccountPackage.ACCOUNT__MEMBER:
                                return member != null;
                        case AccountPackage.ACCOUNT__ESTABLISHED:
                                return ESTABLISHED_EDEFAULT == null ? established != null : !ESTABLISHED_EDEFAULT.equals(established);
                        case AccountPackage.ACCOUNT__TYPE:
                                return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
                        case AccountPackage.ACCOUNT__TRANSACTIONS:
                                return transactions != null && !transactions.isEmpty();
                        case AccountPackage.ACCOUNT__BALANCES:
                                return balances != null && !balances.isEmpty();
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
                result.append(" (accountId: ");
                result.append(accountId);
                result.append(", established: ");
                result.append(established);
                result.append(", type: ");
                result.append(type);
                result.append(')');
                return result.toString();
        }

} //AccountImpl
