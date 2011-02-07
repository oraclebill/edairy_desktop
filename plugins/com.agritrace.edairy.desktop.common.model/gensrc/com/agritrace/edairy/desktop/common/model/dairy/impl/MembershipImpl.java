/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;

import com.agritrace.edairy.desktop.common.model.tracking.Farmer;

import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
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
 * An implementation of the model object '<em><b>Membership</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MembershipImpl#getMemberId <em>Member Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MembershipImpl#getMemberNumber <em>Member Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MembershipImpl#getApplicationDate <em>Application Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MembershipImpl#getEffectiveDate <em>Effective Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MembershipImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MembershipImpl#getDefaultRoute <em>Default Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MembershipImpl#getFarmer <em>Farmer</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MembershipImpl#getAccount <em>Account</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MembershipImpl#getDairy <em>Dairy</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MembershipImpl#getMaziwaCardNumber <em>Maziwa Card Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MembershipImpl#getMaziwaCardIssueDate <em>Maziwa Card Issue Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MembershipImpl extends EObjectImpl implements Membership {
	/**
	 * The default value of the '{@link #getMemberId() <em>Member Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberId()
	 * @generated
	 * @ordered
	 */
	protected static final Long MEMBER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemberId() <em>Member Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberId()
	 * @generated
	 * @ordered
	 */
	protected Long memberId = MEMBER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getMemberNumber() <em>Member Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String MEMBER_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemberNumber() <em>Member Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberNumber()
	 * @generated
	 * @ordered
	 */
	protected String memberNumber = MEMBER_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getApplicationDate() <em>Application Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date APPLICATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApplicationDate() <em>Application Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationDate()
	 * @generated
	 * @ordered
	 */
	protected Date applicationDate = APPLICATION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEffectiveDate() <em>Effective Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEffectiveDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date EFFECTIVE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEffectiveDate() <em>Effective Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEffectiveDate()
	 * @generated
	 * @ordered
	 */
	protected Date effectiveDate = EFFECTIVE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final MembershipStatus STATUS_EDEFAULT = MembershipStatus.ACTIVE;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected MembershipStatus status = STATUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefaultRoute() <em>Default Route</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultRoute()
	 * @generated
	 * @ordered
	 */
	protected DairyLocation defaultRoute;

	/**
	 * The cached value of the '{@link #getFarmer() <em>Farmer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFarmer()
	 * @generated
	 * @ordered
	 */
	protected Farmer farmer;

	/**
	 * The cached value of the '{@link #getAccount() <em>Account</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccount()
	 * @generated
	 * @ordered
	 */
	protected Account account;

	/**
	 * The default value of the '{@link #getMaziwaCardNumber() <em>Maziwa Card Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaziwaCardNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String MAZIWA_CARD_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaziwaCardNumber() <em>Maziwa Card Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaziwaCardNumber()
	 * @generated
	 * @ordered
	 */
	protected String maziwaCardNumber = MAZIWA_CARD_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaziwaCardIssueDate() <em>Maziwa Card Issue Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaziwaCardIssueDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date MAZIWA_CARD_ISSUE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaziwaCardIssueDate() <em>Maziwa Card Issue Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaziwaCardIssueDate()
	 * @generated
	 * @ordered
	 */
	protected Date maziwaCardIssueDate = MAZIWA_CARD_ISSUE_DATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MembershipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.MEMBERSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getMemberId() {
		return memberId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemberId(Long newMemberId) {
		Long oldMemberId = memberId;
		memberId = newMemberId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBERSHIP__MEMBER_ID, oldMemberId, memberId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMemberNumber() {
		return memberNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemberNumber(String newMemberNumber) {
		String oldMemberNumber = memberNumber;
		memberNumber = newMemberNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBERSHIP__MEMBER_NUMBER, oldMemberNumber, memberNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getApplicationDate() {
		return applicationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicationDate(Date newApplicationDate) {
		Date oldApplicationDate = applicationDate;
		applicationDate = newApplicationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBERSHIP__APPLICATION_DATE, oldApplicationDate, applicationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEffectiveDate(Date newEffectiveDate) {
		Date oldEffectiveDate = effectiveDate;
		effectiveDate = newEffectiveDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBERSHIP__EFFECTIVE_DATE, oldEffectiveDate, effectiveDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MembershipStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(MembershipStatus newStatus) {
		MembershipStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBERSHIP__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyLocation getDefaultRoute() {
		if (defaultRoute != null && defaultRoute.eIsProxy()) {
			InternalEObject oldDefaultRoute = (InternalEObject)defaultRoute;
			defaultRoute = (DairyLocation)eResolveProxy(oldDefaultRoute);
			if (defaultRoute != oldDefaultRoute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MEMBERSHIP__DEFAULT_ROUTE, oldDefaultRoute, defaultRoute));
			}
		}
		return defaultRoute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyLocation basicGetDefaultRoute() {
		return defaultRoute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultRoute(DairyLocation newDefaultRoute) {
		DairyLocation oldDefaultRoute = defaultRoute;
		defaultRoute = newDefaultRoute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBERSHIP__DEFAULT_ROUTE, oldDefaultRoute, defaultRoute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Farmer getFarmer() {
		return farmer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFarmer(Farmer newFarmer, NotificationChain msgs) {
		Farmer oldFarmer = farmer;
		farmer = newFarmer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBERSHIP__FARMER, oldFarmer, newFarmer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFarmer(Farmer newFarmer) {
		if (newFarmer != farmer) {
			NotificationChain msgs = null;
			if (farmer != null)
				msgs = ((InternalEObject)farmer).eInverseRemove(this, TrackingPackage.FARMER__MEMBERSHIP, Farmer.class, msgs);
			if (newFarmer != null)
				msgs = ((InternalEObject)newFarmer).eInverseAdd(this, TrackingPackage.FARMER__MEMBERSHIP, Farmer.class, msgs);
			msgs = basicSetFarmer(newFarmer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBERSHIP__FARMER, newFarmer, newFarmer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccount(Account newAccount, NotificationChain msgs) {
		Account oldAccount = account;
		account = newAccount;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBERSHIP__ACCOUNT, oldAccount, newAccount);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccount(Account newAccount) {
		if (newAccount != account) {
			NotificationChain msgs = null;
			if (account != null)
				msgs = ((InternalEObject)account).eInverseRemove(this, AccountPackage.ACCOUNT__MEMBER, Account.class, msgs);
			if (newAccount != null)
				msgs = ((InternalEObject)newAccount).eInverseAdd(this, AccountPackage.ACCOUNT__MEMBER, Account.class, msgs);
			msgs = basicSetAccount(newAccount, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBERSHIP__ACCOUNT, newAccount, newAccount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dairy getDairy() {
		if (eContainerFeatureID() != DairyPackage.MEMBERSHIP__DAIRY) return null;
		return (Dairy)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDairy(Dairy newDairy, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDairy, DairyPackage.MEMBERSHIP__DAIRY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDairy(Dairy newDairy) {
		if (newDairy != eInternalContainer() || (eContainerFeatureID() != DairyPackage.MEMBERSHIP__DAIRY && newDairy != null)) {
			if (EcoreUtil.isAncestor(this, newDairy))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDairy != null)
				msgs = ((InternalEObject)newDairy).eInverseAdd(this, DairyPackage.DAIRY__MEMBERSHIPS, Dairy.class, msgs);
			msgs = basicSetDairy(newDairy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBERSHIP__DAIRY, newDairy, newDairy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaziwaCardNumber() {
		return maziwaCardNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaziwaCardNumber(String newMaziwaCardNumber) {
		String oldMaziwaCardNumber = maziwaCardNumber;
		maziwaCardNumber = newMaziwaCardNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBERSHIP__MAZIWA_CARD_NUMBER, oldMaziwaCardNumber, maziwaCardNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getMaziwaCardIssueDate() {
		return maziwaCardIssueDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaziwaCardIssueDate(Date newMaziwaCardIssueDate) {
		Date oldMaziwaCardIssueDate = maziwaCardIssueDate;
		maziwaCardIssueDate = newMaziwaCardIssueDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBERSHIP__MAZIWA_CARD_ISSUE_DATE, oldMaziwaCardIssueDate, maziwaCardIssueDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DairyPackage.MEMBERSHIP__FARMER:
				if (farmer != null)
					msgs = ((InternalEObject)farmer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DairyPackage.MEMBERSHIP__FARMER, null, msgs);
				return basicSetFarmer((Farmer)otherEnd, msgs);
			case DairyPackage.MEMBERSHIP__ACCOUNT:
				if (account != null)
					msgs = ((InternalEObject)account).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DairyPackage.MEMBERSHIP__ACCOUNT, null, msgs);
				return basicSetAccount((Account)otherEnd, msgs);
			case DairyPackage.MEMBERSHIP__DAIRY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDairy((Dairy)otherEnd, msgs);
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
			case DairyPackage.MEMBERSHIP__FARMER:
				return basicSetFarmer(null, msgs);
			case DairyPackage.MEMBERSHIP__ACCOUNT:
				return basicSetAccount(null, msgs);
			case DairyPackage.MEMBERSHIP__DAIRY:
				return basicSetDairy(null, msgs);
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
			case DairyPackage.MEMBERSHIP__DAIRY:
				return eInternalContainer().eInverseRemove(this, DairyPackage.DAIRY__MEMBERSHIPS, Dairy.class, msgs);
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
			case DairyPackage.MEMBERSHIP__MEMBER_ID:
				return getMemberId();
			case DairyPackage.MEMBERSHIP__MEMBER_NUMBER:
				return getMemberNumber();
			case DairyPackage.MEMBERSHIP__APPLICATION_DATE:
				return getApplicationDate();
			case DairyPackage.MEMBERSHIP__EFFECTIVE_DATE:
				return getEffectiveDate();
			case DairyPackage.MEMBERSHIP__STATUS:
				return getStatus();
			case DairyPackage.MEMBERSHIP__DEFAULT_ROUTE:
				if (resolve) return getDefaultRoute();
				return basicGetDefaultRoute();
			case DairyPackage.MEMBERSHIP__FARMER:
				return getFarmer();
			case DairyPackage.MEMBERSHIP__ACCOUNT:
				return getAccount();
			case DairyPackage.MEMBERSHIP__DAIRY:
				return getDairy();
			case DairyPackage.MEMBERSHIP__MAZIWA_CARD_NUMBER:
				return getMaziwaCardNumber();
			case DairyPackage.MEMBERSHIP__MAZIWA_CARD_ISSUE_DATE:
				return getMaziwaCardIssueDate();
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
			case DairyPackage.MEMBERSHIP__MEMBER_ID:
				setMemberId((Long)newValue);
				return;
			case DairyPackage.MEMBERSHIP__MEMBER_NUMBER:
				setMemberNumber((String)newValue);
				return;
			case DairyPackage.MEMBERSHIP__APPLICATION_DATE:
				setApplicationDate((Date)newValue);
				return;
			case DairyPackage.MEMBERSHIP__EFFECTIVE_DATE:
				setEffectiveDate((Date)newValue);
				return;
			case DairyPackage.MEMBERSHIP__STATUS:
				setStatus((MembershipStatus)newValue);
				return;
			case DairyPackage.MEMBERSHIP__DEFAULT_ROUTE:
				setDefaultRoute((DairyLocation)newValue);
				return;
			case DairyPackage.MEMBERSHIP__FARMER:
				setFarmer((Farmer)newValue);
				return;
			case DairyPackage.MEMBERSHIP__ACCOUNT:
				setAccount((Account)newValue);
				return;
			case DairyPackage.MEMBERSHIP__DAIRY:
				setDairy((Dairy)newValue);
				return;
			case DairyPackage.MEMBERSHIP__MAZIWA_CARD_NUMBER:
				setMaziwaCardNumber((String)newValue);
				return;
			case DairyPackage.MEMBERSHIP__MAZIWA_CARD_ISSUE_DATE:
				setMaziwaCardIssueDate((Date)newValue);
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
			case DairyPackage.MEMBERSHIP__MEMBER_ID:
				setMemberId(MEMBER_ID_EDEFAULT);
				return;
			case DairyPackage.MEMBERSHIP__MEMBER_NUMBER:
				setMemberNumber(MEMBER_NUMBER_EDEFAULT);
				return;
			case DairyPackage.MEMBERSHIP__APPLICATION_DATE:
				setApplicationDate(APPLICATION_DATE_EDEFAULT);
				return;
			case DairyPackage.MEMBERSHIP__EFFECTIVE_DATE:
				setEffectiveDate(EFFECTIVE_DATE_EDEFAULT);
				return;
			case DairyPackage.MEMBERSHIP__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case DairyPackage.MEMBERSHIP__DEFAULT_ROUTE:
				setDefaultRoute((DairyLocation)null);
				return;
			case DairyPackage.MEMBERSHIP__FARMER:
				setFarmer((Farmer)null);
				return;
			case DairyPackage.MEMBERSHIP__ACCOUNT:
				setAccount((Account)null);
				return;
			case DairyPackage.MEMBERSHIP__DAIRY:
				setDairy((Dairy)null);
				return;
			case DairyPackage.MEMBERSHIP__MAZIWA_CARD_NUMBER:
				setMaziwaCardNumber(MAZIWA_CARD_NUMBER_EDEFAULT);
				return;
			case DairyPackage.MEMBERSHIP__MAZIWA_CARD_ISSUE_DATE:
				setMaziwaCardIssueDate(MAZIWA_CARD_ISSUE_DATE_EDEFAULT);
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
			case DairyPackage.MEMBERSHIP__MEMBER_ID:
				return MEMBER_ID_EDEFAULT == null ? memberId != null : !MEMBER_ID_EDEFAULT.equals(memberId);
			case DairyPackage.MEMBERSHIP__MEMBER_NUMBER:
				return MEMBER_NUMBER_EDEFAULT == null ? memberNumber != null : !MEMBER_NUMBER_EDEFAULT.equals(memberNumber);
			case DairyPackage.MEMBERSHIP__APPLICATION_DATE:
				return APPLICATION_DATE_EDEFAULT == null ? applicationDate != null : !APPLICATION_DATE_EDEFAULT.equals(applicationDate);
			case DairyPackage.MEMBERSHIP__EFFECTIVE_DATE:
				return EFFECTIVE_DATE_EDEFAULT == null ? effectiveDate != null : !EFFECTIVE_DATE_EDEFAULT.equals(effectiveDate);
			case DairyPackage.MEMBERSHIP__STATUS:
				return status != STATUS_EDEFAULT;
			case DairyPackage.MEMBERSHIP__DEFAULT_ROUTE:
				return defaultRoute != null;
			case DairyPackage.MEMBERSHIP__FARMER:
				return farmer != null;
			case DairyPackage.MEMBERSHIP__ACCOUNT:
				return account != null;
			case DairyPackage.MEMBERSHIP__DAIRY:
				return getDairy() != null;
			case DairyPackage.MEMBERSHIP__MAZIWA_CARD_NUMBER:
				return MAZIWA_CARD_NUMBER_EDEFAULT == null ? maziwaCardNumber != null : !MAZIWA_CARD_NUMBER_EDEFAULT.equals(maziwaCardNumber);
			case DairyPackage.MEMBERSHIP__MAZIWA_CARD_ISSUE_DATE:
				return MAZIWA_CARD_ISSUE_DATE_EDEFAULT == null ? maziwaCardIssueDate != null : !MAZIWA_CARD_ISSUE_DATE_EDEFAULT.equals(maziwaCardIssueDate);
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
		result.append(" (memberId: ");
		result.append(memberId);
		result.append(", memberNumber: ");
		result.append(memberNumber);
		result.append(", applicationDate: ");
		result.append(applicationDate);
		result.append(", effectiveDate: ");
		result.append(effectiveDate);
		result.append(", status: ");
		result.append(status);
		result.append(", maziwaCardNumber: ");
		result.append(maziwaCardNumber);
		result.append(", maziwaCardIssueDate: ");
		result.append(maziwaCardIssueDate);
		result.append(')');
		return result.toString();
	}

} //MembershipImpl
