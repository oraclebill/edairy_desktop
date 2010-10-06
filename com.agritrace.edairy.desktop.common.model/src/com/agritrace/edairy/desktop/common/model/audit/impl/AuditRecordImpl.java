/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.audit.impl;

import com.agritrace.edairy.desktop.common.model.audit.AuditPackage;
import com.agritrace.edairy.desktop.common.model.audit.AuditRecord;
import com.agritrace.edairy.desktop.common.model.audit.ChangeType;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.audit.impl.AuditRecordImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.audit.impl.AuditRecordImpl#getDate <em>Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.audit.impl.AuditRecordImpl#getUser <em>User</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.audit.impl.AuditRecordImpl#getEntity <em>Entity</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.audit.impl.AuditRecordImpl#getChangeType <em>Change Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.audit.impl.AuditRecordImpl#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.audit.impl.AuditRecordImpl#getOldValue <em>Old Value</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.audit.impl.AuditRecordImpl#getNewValue <em>New Value</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.audit.impl.AuditRecordImpl#getTransactionStamp <em>Transaction Stamp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AuditRecordImpl extends EObjectImpl implements AuditRecord {
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
	 * The default value of the '{@link #getUser() <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUser()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUser() <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUser()
	 * @generated
	 * @ordered
	 */
	protected String user = USER_EDEFAULT;

	/**
	 * The default value of the '{@link #getEntity() <em>Entity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntity()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEntity() <em>Entity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntity()
	 * @generated
	 * @ordered
	 */
	protected String entity = ENTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getChangeType() <em>Change Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangeType()
	 * @generated
	 * @ordered
	 */
	protected static final ChangeType CHANGE_TYPE_EDEFAULT = ChangeType.SAVE;

	/**
	 * The cached value of the '{@link #getChangeType() <em>Change Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangeType()
	 * @generated
	 * @ordered
	 */
	protected ChangeType changeType = CHANGE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldName()
	 * @generated
	 * @ordered
	 */
	protected String fieldName = FIELD_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOldValue() <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldValue()
	 * @generated
	 * @ordered
	 */
	protected static final String OLD_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOldValue() <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldValue()
	 * @generated
	 * @ordered
	 */
	protected String oldValue = OLD_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewValue() <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewValue() <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected String newValue = NEW_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransactionStamp() <em>Transaction Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionStamp()
	 * @generated
	 * @ordered
	 */
	protected static final Integer TRANSACTION_STAMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransactionStamp() <em>Transaction Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionStamp()
	 * @generated
	 * @ordered
	 */
	protected Integer transactionStamp = TRANSACTION_STAMP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AuditRecordImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AuditPackage.Literals.AUDIT_RECORD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AuditPackage.AUDIT_RECORD__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AuditPackage.AUDIT_RECORD__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUser() {
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(String newUser) {
		String oldUser = user;
		user = newUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuditPackage.AUDIT_RECORD__USER, oldUser, user));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEntity() {
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntity(String newEntity) {
		String oldEntity = entity;
		entity = newEntity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuditPackage.AUDIT_RECORD__ENTITY, oldEntity, entity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeType getChangeType() {
		return changeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangeType(ChangeType newChangeType) {
		ChangeType oldChangeType = changeType;
		changeType = newChangeType == null ? CHANGE_TYPE_EDEFAULT : newChangeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuditPackage.AUDIT_RECORD__CHANGE_TYPE, oldChangeType, changeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFieldName(String newFieldName) {
		String oldFieldName = fieldName;
		fieldName = newFieldName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuditPackage.AUDIT_RECORD__FIELD_NAME, oldFieldName, fieldName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOldValue() {
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldValue(String newOldValue) {
		String oldOldValue = oldValue;
		oldValue = newOldValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuditPackage.AUDIT_RECORD__OLD_VALUE, oldOldValue, oldValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewValue() {
		return newValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewValue(String newNewValue) {
		String oldNewValue = newValue;
		newValue = newNewValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuditPackage.AUDIT_RECORD__NEW_VALUE, oldNewValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getTransactionStamp() {
		return transactionStamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransactionStamp(Integer newTransactionStamp) {
		Integer oldTransactionStamp = transactionStamp;
		transactionStamp = newTransactionStamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuditPackage.AUDIT_RECORD__TRANSACTION_STAMP, oldTransactionStamp, transactionStamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AuditPackage.AUDIT_RECORD__ID:
				return getId();
			case AuditPackage.AUDIT_RECORD__DATE:
				return getDate();
			case AuditPackage.AUDIT_RECORD__USER:
				return getUser();
			case AuditPackage.AUDIT_RECORD__ENTITY:
				return getEntity();
			case AuditPackage.AUDIT_RECORD__CHANGE_TYPE:
				return getChangeType();
			case AuditPackage.AUDIT_RECORD__FIELD_NAME:
				return getFieldName();
			case AuditPackage.AUDIT_RECORD__OLD_VALUE:
				return getOldValue();
			case AuditPackage.AUDIT_RECORD__NEW_VALUE:
				return getNewValue();
			case AuditPackage.AUDIT_RECORD__TRANSACTION_STAMP:
				return getTransactionStamp();
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
			case AuditPackage.AUDIT_RECORD__ID:
				setId((Long)newValue);
				return;
			case AuditPackage.AUDIT_RECORD__DATE:
				setDate((Date)newValue);
				return;
			case AuditPackage.AUDIT_RECORD__USER:
				setUser((String)newValue);
				return;
			case AuditPackage.AUDIT_RECORD__ENTITY:
				setEntity((String)newValue);
				return;
			case AuditPackage.AUDIT_RECORD__CHANGE_TYPE:
				setChangeType((ChangeType)newValue);
				return;
			case AuditPackage.AUDIT_RECORD__FIELD_NAME:
				setFieldName((String)newValue);
				return;
			case AuditPackage.AUDIT_RECORD__OLD_VALUE:
				setOldValue((String)newValue);
				return;
			case AuditPackage.AUDIT_RECORD__NEW_VALUE:
				setNewValue((String)newValue);
				return;
			case AuditPackage.AUDIT_RECORD__TRANSACTION_STAMP:
				setTransactionStamp((Integer)newValue);
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
			case AuditPackage.AUDIT_RECORD__ID:
				setId(ID_EDEFAULT);
				return;
			case AuditPackage.AUDIT_RECORD__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case AuditPackage.AUDIT_RECORD__USER:
				setUser(USER_EDEFAULT);
				return;
			case AuditPackage.AUDIT_RECORD__ENTITY:
				setEntity(ENTITY_EDEFAULT);
				return;
			case AuditPackage.AUDIT_RECORD__CHANGE_TYPE:
				setChangeType(CHANGE_TYPE_EDEFAULT);
				return;
			case AuditPackage.AUDIT_RECORD__FIELD_NAME:
				setFieldName(FIELD_NAME_EDEFAULT);
				return;
			case AuditPackage.AUDIT_RECORD__OLD_VALUE:
				setOldValue(OLD_VALUE_EDEFAULT);
				return;
			case AuditPackage.AUDIT_RECORD__NEW_VALUE:
				setNewValue(NEW_VALUE_EDEFAULT);
				return;
			case AuditPackage.AUDIT_RECORD__TRANSACTION_STAMP:
				setTransactionStamp(TRANSACTION_STAMP_EDEFAULT);
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
			case AuditPackage.AUDIT_RECORD__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case AuditPackage.AUDIT_RECORD__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case AuditPackage.AUDIT_RECORD__USER:
				return USER_EDEFAULT == null ? user != null : !USER_EDEFAULT.equals(user);
			case AuditPackage.AUDIT_RECORD__ENTITY:
				return ENTITY_EDEFAULT == null ? entity != null : !ENTITY_EDEFAULT.equals(entity);
			case AuditPackage.AUDIT_RECORD__CHANGE_TYPE:
				return changeType != CHANGE_TYPE_EDEFAULT;
			case AuditPackage.AUDIT_RECORD__FIELD_NAME:
				return FIELD_NAME_EDEFAULT == null ? fieldName != null : !FIELD_NAME_EDEFAULT.equals(fieldName);
			case AuditPackage.AUDIT_RECORD__OLD_VALUE:
				return OLD_VALUE_EDEFAULT == null ? oldValue != null : !OLD_VALUE_EDEFAULT.equals(oldValue);
			case AuditPackage.AUDIT_RECORD__NEW_VALUE:
				return NEW_VALUE_EDEFAULT == null ? newValue != null : !NEW_VALUE_EDEFAULT.equals(newValue);
			case AuditPackage.AUDIT_RECORD__TRANSACTION_STAMP:
				return TRANSACTION_STAMP_EDEFAULT == null ? transactionStamp != null : !TRANSACTION_STAMP_EDEFAULT.equals(transactionStamp);
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
		result.append(", date: ");
		result.append(date);
		result.append(", user: ");
		result.append(user);
		result.append(", entity: ");
		result.append(entity);
		result.append(", changeType: ");
		result.append(changeType);
		result.append(", fieldName: ");
		result.append(fieldName);
		result.append(", oldValue: ");
		result.append(oldValue);
		result.append(", newValue: ");
		result.append(newValue);
		result.append(", transactionStamp: ");
		result.append(transactionStamp);
		result.append(')');
		return result.toString();
	}

} //AuditRecordImpl
