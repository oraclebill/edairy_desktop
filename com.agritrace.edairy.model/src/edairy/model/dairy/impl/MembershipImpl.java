/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model.dairy.impl;

import edairy.model.dairy.DairyPackage;
import edairy.model.dairy.Membership;
import edairy.model.dairy.MembershipStatus;
import edairy.model.dairy.RouteDefinition;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Membership</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edairy.model.dairy.impl.MembershipImpl#getApplicationDate <em>Application Date</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.MembershipImpl#getEffectiveDate <em>Effective Date</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.MembershipImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.MembershipImpl#getDefaultRoute <em>Default Route</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MembershipImpl extends EObjectImpl implements Membership {
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
	protected static final MembershipStatus STATUS_EDEFAULT = null;

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
	protected RouteDefinition defaultRoute;

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
	public RouteDefinition getDefaultRoute() {
		if (defaultRoute != null && defaultRoute.eIsProxy()) {
			InternalEObject oldDefaultRoute = (InternalEObject)defaultRoute;
			defaultRoute = (RouteDefinition)eResolveProxy(oldDefaultRoute);
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
	public RouteDefinition basicGetDefaultRoute() {
		return defaultRoute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultRoute(RouteDefinition newDefaultRoute) {
		RouteDefinition oldDefaultRoute = defaultRoute;
		defaultRoute = newDefaultRoute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBERSHIP__DEFAULT_ROUTE, oldDefaultRoute, defaultRoute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.MEMBERSHIP__APPLICATION_DATE:
				return getApplicationDate();
			case DairyPackage.MEMBERSHIP__EFFECTIVE_DATE:
				return getEffectiveDate();
			case DairyPackage.MEMBERSHIP__STATUS:
				return getStatus();
			case DairyPackage.MEMBERSHIP__DEFAULT_ROUTE:
				if (resolve) return getDefaultRoute();
				return basicGetDefaultRoute();
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
				setDefaultRoute((RouteDefinition)newValue);
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
				setDefaultRoute((RouteDefinition)null);
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
			case DairyPackage.MEMBERSHIP__APPLICATION_DATE:
				return APPLICATION_DATE_EDEFAULT == null ? applicationDate != null : !APPLICATION_DATE_EDEFAULT.equals(applicationDate);
			case DairyPackage.MEMBERSHIP__EFFECTIVE_DATE:
				return EFFECTIVE_DATE_EDEFAULT == null ? effectiveDate != null : !EFFECTIVE_DATE_EDEFAULT.equals(effectiveDate);
			case DairyPackage.MEMBERSHIP__STATUS:
				return status != STATUS_EDEFAULT;
			case DairyPackage.MEMBERSHIP__DEFAULT_ROUTE:
				return defaultRoute != null;
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
		result.append(" (applicationDate: ");
		result.append(applicationDate);
		result.append(", effectiveDate: ");
		result.append(effectiveDate);
		result.append(", status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //MembershipImpl
