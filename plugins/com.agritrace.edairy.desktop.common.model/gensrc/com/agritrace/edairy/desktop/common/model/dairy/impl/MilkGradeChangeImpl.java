/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.MilkGrade;
import com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Milk Grade Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkGradeChangeImpl#getDate <em>Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkGradeChangeImpl#getStartingGrade <em>Starting Grade</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkGradeChangeImpl#getEndingGrade <em>Ending Grade</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkGradeChangeImpl#getChangedBy <em>Changed By</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkGradeChangeImpl#getReason <em>Reason</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MilkGradeChangeImpl extends EObjectImpl implements MilkGradeChange {
	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStartingGrade() <em>Starting Grade</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartingGrade()
	 * @generated
	 * @ordered
	 */
	protected MilkGrade startingGrade;

	/**
	 * The cached value of the '{@link #getEndingGrade() <em>Ending Grade</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndingGrade()
	 * @generated
	 * @ordered
	 */
	protected MilkGrade endingGrade;

	/**
	 * The cached value of the '{@link #getChangedBy() <em>Changed By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangedBy()
	 * @generated
	 * @ordered
	 */
	protected Employee changedBy;

	/**
	 * The default value of the '{@link #getReason() <em>Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReason()
	 * @generated
	 * @ordered
	 */
	protected static final String REASON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReason() <em>Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReason()
	 * @generated
	 * @ordered
	 */
	protected String reason = REASON_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MilkGradeChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.MILK_GRADE_CHANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_GRADE_CHANGE__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MilkGrade getStartingGrade() {
		if (startingGrade != null && startingGrade.eIsProxy())
		{
			InternalEObject oldStartingGrade = (InternalEObject)startingGrade;
			startingGrade = (MilkGrade)eResolveProxy(oldStartingGrade);
			if (startingGrade != oldStartingGrade)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MILK_GRADE_CHANGE__STARTING_GRADE, oldStartingGrade, startingGrade));
			}
		}
		return startingGrade;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MilkGrade basicGetStartingGrade() {
		return startingGrade;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartingGrade(MilkGrade newStartingGrade) {
		MilkGrade oldStartingGrade = startingGrade;
		startingGrade = newStartingGrade;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_GRADE_CHANGE__STARTING_GRADE, oldStartingGrade, startingGrade));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MilkGrade getEndingGrade() {
		if (endingGrade != null && endingGrade.eIsProxy())
		{
			InternalEObject oldEndingGrade = (InternalEObject)endingGrade;
			endingGrade = (MilkGrade)eResolveProxy(oldEndingGrade);
			if (endingGrade != oldEndingGrade)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MILK_GRADE_CHANGE__ENDING_GRADE, oldEndingGrade, endingGrade));
			}
		}
		return endingGrade;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MilkGrade basicGetEndingGrade() {
		return endingGrade;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndingGrade(MilkGrade newEndingGrade) {
		MilkGrade oldEndingGrade = endingGrade;
		endingGrade = newEndingGrade;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_GRADE_CHANGE__ENDING_GRADE, oldEndingGrade, endingGrade));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getChangedBy() {
		if (changedBy != null && changedBy.eIsProxy())
		{
			InternalEObject oldChangedBy = (InternalEObject)changedBy;
			changedBy = (Employee)eResolveProxy(oldChangedBy);
			if (changedBy != oldChangedBy)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MILK_GRADE_CHANGE__CHANGED_BY, oldChangedBy, changedBy));
			}
		}
		return changedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee basicGetChangedBy() {
		return changedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangedBy(Employee newChangedBy) {
		Employee oldChangedBy = changedBy;
		changedBy = newChangedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_GRADE_CHANGE__CHANGED_BY, oldChangedBy, changedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReason(String newReason) {
		String oldReason = reason;
		reason = newReason;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_GRADE_CHANGE__REASON, oldReason, reason));
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
			case DairyPackage.MILK_GRADE_CHANGE__DATE:
				return getDate();
			case DairyPackage.MILK_GRADE_CHANGE__STARTING_GRADE:
				if (resolve) return getStartingGrade();
				return basicGetStartingGrade();
			case DairyPackage.MILK_GRADE_CHANGE__ENDING_GRADE:
				if (resolve) return getEndingGrade();
				return basicGetEndingGrade();
			case DairyPackage.MILK_GRADE_CHANGE__CHANGED_BY:
				if (resolve) return getChangedBy();
				return basicGetChangedBy();
			case DairyPackage.MILK_GRADE_CHANGE__REASON:
				return getReason();
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
			case DairyPackage.MILK_GRADE_CHANGE__DATE:
				setDate((Date)newValue);
				return;
			case DairyPackage.MILK_GRADE_CHANGE__STARTING_GRADE:
				setStartingGrade((MilkGrade)newValue);
				return;
			case DairyPackage.MILK_GRADE_CHANGE__ENDING_GRADE:
				setEndingGrade((MilkGrade)newValue);
				return;
			case DairyPackage.MILK_GRADE_CHANGE__CHANGED_BY:
				setChangedBy((Employee)newValue);
				return;
			case DairyPackage.MILK_GRADE_CHANGE__REASON:
				setReason((String)newValue);
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
			case DairyPackage.MILK_GRADE_CHANGE__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case DairyPackage.MILK_GRADE_CHANGE__STARTING_GRADE:
				setStartingGrade((MilkGrade)null);
				return;
			case DairyPackage.MILK_GRADE_CHANGE__ENDING_GRADE:
				setEndingGrade((MilkGrade)null);
				return;
			case DairyPackage.MILK_GRADE_CHANGE__CHANGED_BY:
				setChangedBy((Employee)null);
				return;
			case DairyPackage.MILK_GRADE_CHANGE__REASON:
				setReason(REASON_EDEFAULT);
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
			case DairyPackage.MILK_GRADE_CHANGE__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case DairyPackage.MILK_GRADE_CHANGE__STARTING_GRADE:
				return startingGrade != null;
			case DairyPackage.MILK_GRADE_CHANGE__ENDING_GRADE:
				return endingGrade != null;
			case DairyPackage.MILK_GRADE_CHANGE__CHANGED_BY:
				return changedBy != null;
			case DairyPackage.MILK_GRADE_CHANGE__REASON:
				return REASON_EDEFAULT == null ? reason != null : !REASON_EDEFAULT.equals(reason);
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
		result.append(" (date: ");
		result.append(date);
		result.append(", reason: ");
		result.append(reason);
		result.append(')');
		return result.toString();
	}

} //MilkGradeChangeImpl
