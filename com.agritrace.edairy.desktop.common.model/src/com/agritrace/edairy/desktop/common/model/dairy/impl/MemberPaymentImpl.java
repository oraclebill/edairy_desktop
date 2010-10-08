/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.MemberPayment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Member Payment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MemberPaymentImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MemberPaymentImpl#getYear <em>Year</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MemberPaymentImpl#getMonth <em>Month</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MemberPaymentImpl#getPaymentRate <em>Payment Rate</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MemberPaymentImpl#getPaymentsTotal <em>Payments Total</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MemberPaymentImpl#getPaymentsCount <em>Payments Count</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MemberPaymentImpl#getEnteredBy <em>Entered By</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MemberPaymentImpl#getEntryDate <em>Entry Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MemberPaymentImpl extends EObjectImpl implements MemberPayment {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final Long ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Long id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected static final int YEAR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected int year = YEAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getMonth() <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonth()
	 * @generated
	 * @ordered
	 */
	protected static final int MONTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMonth() <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonth()
	 * @generated
	 * @ordered
	 */
	protected int month = MONTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getPaymentRate() <em>Payment Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaymentRate()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal PAYMENT_RATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPaymentRate() <em>Payment Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaymentRate()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal paymentRate = PAYMENT_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPaymentsTotal() <em>Payments Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaymentsTotal()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal PAYMENTS_TOTAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPaymentsTotal() <em>Payments Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaymentsTotal()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal paymentsTotal = PAYMENTS_TOTAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getPaymentsCount() <em>Payments Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaymentsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int PAYMENTS_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPaymentsCount() <em>Payments Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaymentsCount()
	 * @generated
	 * @ordered
	 */
	protected int paymentsCount = PAYMENTS_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEnteredBy() <em>Entered By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnteredBy()
	 * @generated
	 * @ordered
	 */
	protected Employee enteredBy;

	/**
	 * The default value of the '{@link #getEntryDate() <em>Entry Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date ENTRY_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEntryDate() <em>Entry Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryDate()
	 * @generated
	 * @ordered
	 */
	protected Date entryDate = ENTRY_DATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemberPaymentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.MEMBER_PAYMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(Long newId) {
		final Long oldId = id;
		id = newId;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBER_PAYMENT__ID, oldId, id));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getYear() {
		return year;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setYear(int newYear) {
		final int oldYear = year;
		year = newYear;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBER_PAYMENT__YEAR, oldYear, year));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMonth() {
		return month;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMonth(int newMonth) {
		final int oldMonth = month;
		month = newMonth;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBER_PAYMENT__MONTH, oldMonth, month));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BigDecimal getPaymentRate() {
		return paymentRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPaymentRate(BigDecimal newPaymentRate) {
		final BigDecimal oldPaymentRate = paymentRate;
		paymentRate = newPaymentRate;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBER_PAYMENT__PAYMENT_RATE, oldPaymentRate, paymentRate));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BigDecimal getPaymentsTotal() {
		return paymentsTotal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPaymentsTotal(BigDecimal newPaymentsTotal) {
		final BigDecimal oldPaymentsTotal = paymentsTotal;
		paymentsTotal = newPaymentsTotal;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBER_PAYMENT__PAYMENTS_TOTAL, oldPaymentsTotal, paymentsTotal));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPaymentsCount() {
		return paymentsCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPaymentsCount(int newPaymentsCount) {
		final int oldPaymentsCount = paymentsCount;
		paymentsCount = newPaymentsCount;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBER_PAYMENT__PAYMENTS_COUNT, oldPaymentsCount, paymentsCount));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Employee getEnteredBy() {
		if (enteredBy != null && enteredBy.eIsProxy()) {
			final InternalEObject oldEnteredBy = (InternalEObject)enteredBy;
			enteredBy = (Employee)eResolveProxy(oldEnteredBy);
			if (enteredBy != oldEnteredBy) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MEMBER_PAYMENT__ENTERED_BY, oldEnteredBy, enteredBy));
				}
			}
		}
		return enteredBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee basicGetEnteredBy() {
		return enteredBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnteredBy(Employee newEnteredBy) {
		final Employee oldEnteredBy = enteredBy;
		enteredBy = newEnteredBy;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBER_PAYMENT__ENTERED_BY, oldEnteredBy, enteredBy));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getEntryDate() {
		return entryDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEntryDate(Date newEntryDate) {
		final Date oldEntryDate = entryDate;
		entryDate = newEntryDate;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MEMBER_PAYMENT__ENTRY_DATE, oldEntryDate, entryDate));
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
			case DairyPackage.MEMBER_PAYMENT__ID:
				return getId();
			case DairyPackage.MEMBER_PAYMENT__YEAR:
				return getYear();
			case DairyPackage.MEMBER_PAYMENT__MONTH:
				return getMonth();
			case DairyPackage.MEMBER_PAYMENT__PAYMENT_RATE:
				return getPaymentRate();
			case DairyPackage.MEMBER_PAYMENT__PAYMENTS_TOTAL:
				return getPaymentsTotal();
			case DairyPackage.MEMBER_PAYMENT__PAYMENTS_COUNT:
				return getPaymentsCount();
			case DairyPackage.MEMBER_PAYMENT__ENTERED_BY:
				if (resolve) {
					return getEnteredBy();
				}
				return basicGetEnteredBy();
			case DairyPackage.MEMBER_PAYMENT__ENTRY_DATE:
				return getEntryDate();
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
			case DairyPackage.MEMBER_PAYMENT__ID:
				setId((Long)newValue);
				return;
			case DairyPackage.MEMBER_PAYMENT__YEAR:
				setYear((Integer)newValue);
				return;
			case DairyPackage.MEMBER_PAYMENT__MONTH:
				setMonth((Integer)newValue);
				return;
			case DairyPackage.MEMBER_PAYMENT__PAYMENT_RATE:
				setPaymentRate((BigDecimal)newValue);
				return;
			case DairyPackage.MEMBER_PAYMENT__PAYMENTS_TOTAL:
				setPaymentsTotal((BigDecimal)newValue);
				return;
			case DairyPackage.MEMBER_PAYMENT__PAYMENTS_COUNT:
				setPaymentsCount((Integer)newValue);
				return;
			case DairyPackage.MEMBER_PAYMENT__ENTERED_BY:
				setEnteredBy((Employee)newValue);
				return;
			case DairyPackage.MEMBER_PAYMENT__ENTRY_DATE:
				setEntryDate((Date)newValue);
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
			case DairyPackage.MEMBER_PAYMENT__ID:
				setId(ID_EDEFAULT);
				return;
			case DairyPackage.MEMBER_PAYMENT__YEAR:
				setYear(YEAR_EDEFAULT);
				return;
			case DairyPackage.MEMBER_PAYMENT__MONTH:
				setMonth(MONTH_EDEFAULT);
				return;
			case DairyPackage.MEMBER_PAYMENT__PAYMENT_RATE:
				setPaymentRate(PAYMENT_RATE_EDEFAULT);
				return;
			case DairyPackage.MEMBER_PAYMENT__PAYMENTS_TOTAL:
				setPaymentsTotal(PAYMENTS_TOTAL_EDEFAULT);
				return;
			case DairyPackage.MEMBER_PAYMENT__PAYMENTS_COUNT:
				setPaymentsCount(PAYMENTS_COUNT_EDEFAULT);
				return;
			case DairyPackage.MEMBER_PAYMENT__ENTERED_BY:
				setEnteredBy((Employee)null);
				return;
			case DairyPackage.MEMBER_PAYMENT__ENTRY_DATE:
				setEntryDate(ENTRY_DATE_EDEFAULT);
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
			case DairyPackage.MEMBER_PAYMENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case DairyPackage.MEMBER_PAYMENT__YEAR:
				return year != YEAR_EDEFAULT;
			case DairyPackage.MEMBER_PAYMENT__MONTH:
				return month != MONTH_EDEFAULT;
			case DairyPackage.MEMBER_PAYMENT__PAYMENT_RATE:
				return PAYMENT_RATE_EDEFAULT == null ? paymentRate != null : !PAYMENT_RATE_EDEFAULT.equals(paymentRate);
			case DairyPackage.MEMBER_PAYMENT__PAYMENTS_TOTAL:
				return PAYMENTS_TOTAL_EDEFAULT == null ? paymentsTotal != null : !PAYMENTS_TOTAL_EDEFAULT.equals(paymentsTotal);
			case DairyPackage.MEMBER_PAYMENT__PAYMENTS_COUNT:
				return paymentsCount != PAYMENTS_COUNT_EDEFAULT;
			case DairyPackage.MEMBER_PAYMENT__ENTERED_BY:
				return enteredBy != null;
			case DairyPackage.MEMBER_PAYMENT__ENTRY_DATE:
				return ENTRY_DATE_EDEFAULT == null ? entryDate != null : !ENTRY_DATE_EDEFAULT.equals(entryDate);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", year: ");
		result.append(year);
		result.append(", month: ");
		result.append(month);
		result.append(", paymentRate: ");
		result.append(paymentRate);
		result.append(", paymentsTotal: ");
		result.append(paymentsTotal);
		result.append(", paymentsCount: ");
		result.append(paymentsCount);
		result.append(", entryDate: ");
		result.append(entryDate);
		result.append(')');
		return result.toString();
	}

} //MemberPaymentImpl
