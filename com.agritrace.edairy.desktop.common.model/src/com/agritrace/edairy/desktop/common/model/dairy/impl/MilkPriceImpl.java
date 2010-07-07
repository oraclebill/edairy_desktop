/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.MilkPrice;
import com.agritrace.edairy.desktop.common.model.dairy.MilkPricePeriod;

import java.math.BigDecimal;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Milk Price</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkPriceImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkPriceImpl#getPricePeriod <em>Price Period</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkPriceImpl#getPriceDate <em>Price Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkPriceImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkPriceImpl#getEnteredBy <em>Entered By</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkPriceImpl#getEntryDate <em>Entry Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkPriceImpl#getNotes <em>Notes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MilkPriceImpl extends EObjectImpl implements MilkPrice {
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
	 * The default value of the '{@link #getPricePeriod() <em>Price Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPricePeriod()
	 * @generated
	 * @ordered
	 */
	protected static final MilkPricePeriod PRICE_PERIOD_EDEFAULT = MilkPricePeriod.DAILY;

	/**
	 * The cached value of the '{@link #getPricePeriod() <em>Price Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPricePeriod()
	 * @generated
	 * @ordered
	 */
	protected MilkPricePeriod pricePeriod = PRICE_PERIOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriceDate() <em>Price Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriceDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date PRICE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPriceDate() <em>Price Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriceDate()
	 * @generated
	 * @ordered
	 */
	protected Date priceDate = PRICE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal value = VALUE_EDEFAULT;

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
	 * The default value of the '{@link #getNotes() <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotes() <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected String notes = NOTES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MilkPriceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.MILK_PRICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(Long newId) {
		Long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_PRICE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MilkPricePeriod getPricePeriod() {
		return pricePeriod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPricePeriod(MilkPricePeriod newPricePeriod) {
		MilkPricePeriod oldPricePeriod = pricePeriod;
		pricePeriod = newPricePeriod == null ? PRICE_PERIOD_EDEFAULT : newPricePeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_PRICE__PRICE_PERIOD, oldPricePeriod, pricePeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getPriceDate() {
		return priceDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriceDate(Date newPriceDate) {
		Date oldPriceDate = priceDate;
		priceDate = newPriceDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_PRICE__PRICE_DATE, oldPriceDate, priceDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(BigDecimal newValue) {
		BigDecimal oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_PRICE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getEnteredBy() {
		if (enteredBy != null && enteredBy.eIsProxy()) {
			InternalEObject oldEnteredBy = (InternalEObject)enteredBy;
			enteredBy = (Employee)eResolveProxy(oldEnteredBy);
			if (enteredBy != oldEnteredBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MILK_PRICE__ENTERED_BY, oldEnteredBy, enteredBy));
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
	public void setEnteredBy(Employee newEnteredBy) {
		Employee oldEnteredBy = enteredBy;
		enteredBy = newEnteredBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_PRICE__ENTERED_BY, oldEnteredBy, enteredBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEntryDate() {
		return entryDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryDate(Date newEntryDate) {
		Date oldEntryDate = entryDate;
		entryDate = newEntryDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_PRICE__ENTRY_DATE, oldEntryDate, entryDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotes(String newNotes) {
		String oldNotes = notes;
		notes = newNotes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_PRICE__NOTES, oldNotes, notes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.MILK_PRICE__ID:
				return getId();
			case DairyPackage.MILK_PRICE__PRICE_PERIOD:
				return getPricePeriod();
			case DairyPackage.MILK_PRICE__PRICE_DATE:
				return getPriceDate();
			case DairyPackage.MILK_PRICE__VALUE:
				return getValue();
			case DairyPackage.MILK_PRICE__ENTERED_BY:
				if (resolve) return getEnteredBy();
				return basicGetEnteredBy();
			case DairyPackage.MILK_PRICE__ENTRY_DATE:
				return getEntryDate();
			case DairyPackage.MILK_PRICE__NOTES:
				return getNotes();
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
			case DairyPackage.MILK_PRICE__ID:
				setId((Long)newValue);
				return;
			case DairyPackage.MILK_PRICE__PRICE_PERIOD:
				setPricePeriod((MilkPricePeriod)newValue);
				return;
			case DairyPackage.MILK_PRICE__PRICE_DATE:
				setPriceDate((Date)newValue);
				return;
			case DairyPackage.MILK_PRICE__VALUE:
				setValue((BigDecimal)newValue);
				return;
			case DairyPackage.MILK_PRICE__ENTERED_BY:
				setEnteredBy((Employee)newValue);
				return;
			case DairyPackage.MILK_PRICE__ENTRY_DATE:
				setEntryDate((Date)newValue);
				return;
			case DairyPackage.MILK_PRICE__NOTES:
				setNotes((String)newValue);
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
			case DairyPackage.MILK_PRICE__ID:
				setId(ID_EDEFAULT);
				return;
			case DairyPackage.MILK_PRICE__PRICE_PERIOD:
				setPricePeriod(PRICE_PERIOD_EDEFAULT);
				return;
			case DairyPackage.MILK_PRICE__PRICE_DATE:
				setPriceDate(PRICE_DATE_EDEFAULT);
				return;
			case DairyPackage.MILK_PRICE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case DairyPackage.MILK_PRICE__ENTERED_BY:
				setEnteredBy((Employee)null);
				return;
			case DairyPackage.MILK_PRICE__ENTRY_DATE:
				setEntryDate(ENTRY_DATE_EDEFAULT);
				return;
			case DairyPackage.MILK_PRICE__NOTES:
				setNotes(NOTES_EDEFAULT);
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
			case DairyPackage.MILK_PRICE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case DairyPackage.MILK_PRICE__PRICE_PERIOD:
				return pricePeriod != PRICE_PERIOD_EDEFAULT;
			case DairyPackage.MILK_PRICE__PRICE_DATE:
				return PRICE_DATE_EDEFAULT == null ? priceDate != null : !PRICE_DATE_EDEFAULT.equals(priceDate);
			case DairyPackage.MILK_PRICE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case DairyPackage.MILK_PRICE__ENTERED_BY:
				return enteredBy != null;
			case DairyPackage.MILK_PRICE__ENTRY_DATE:
				return ENTRY_DATE_EDEFAULT == null ? entryDate != null : !ENTRY_DATE_EDEFAULT.equals(entryDate);
			case DairyPackage.MILK_PRICE__NOTES:
				return NOTES_EDEFAULT == null ? notes != null : !NOTES_EDEFAULT.equals(notes);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", pricePeriod: ");
		result.append(pricePeriod);
		result.append(", priceDate: ");
		result.append(priceDate);
		result.append(", value: ");
		result.append(value);
		result.append(", entryDate: ");
		result.append(entryDate);
		result.append(", notes: ");
		result.append(notes);
		result.append(')');
		return result.toString();
	}

} //MilkPriceImpl
