/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.audit;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.audit.AuditFactory
 * @model kind="package"
 * @generated
 */
public interface AuditPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "audit";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://com.agritrace.edairy.desktop.common.model/audit/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "audit";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AuditPackage eINSTANCE = com.agritrace.edairy.desktop.common.model.audit.impl.AuditPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.audit.impl.AuditRecordImpl <em>Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.audit.impl.AuditRecordImpl
	 * @see com.agritrace.edairy.desktop.common.model.audit.impl.AuditPackageImpl#getAuditRecord()
	 * @generated
	 */
	int AUDIT_RECORD = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIT_RECORD__ID = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIT_RECORD__DATE = 1;

	/**
	 * The feature id for the '<em><b>User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIT_RECORD__USER = 2;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIT_RECORD__ENTITY = 3;

	/**
	 * The feature id for the '<em><b>Change Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIT_RECORD__CHANGE_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIT_RECORD__FIELD_NAME = 5;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIT_RECORD__OLD_VALUE = 6;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIT_RECORD__NEW_VALUE = 7;

	/**
	 * The feature id for the '<em><b>Transaction Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIT_RECORD__TRANSACTION_STAMP = 8;

	/**
	 * The number of structural features of the '<em>Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIT_RECORD_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.audit.ChangeType <em>Change Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.audit.ChangeType
	 * @see com.agritrace.edairy.desktop.common.model.audit.impl.AuditPackageImpl#getChangeType()
	 * @generated
	 */
	int CHANGE_TYPE = 1;


	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord <em>Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Record</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditRecord
	 * @generated
	 */
	EClass getAuditRecord();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getId()
	 * @see #getAuditRecord()
	 * @generated
	 */
	EAttribute getAuditRecord_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getDate()
	 * @see #getAuditRecord()
	 * @generated
	 */
	EAttribute getAuditRecord_Date();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getUser()
	 * @see #getAuditRecord()
	 * @generated
	 */
	EAttribute getAuditRecord_User();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Entity</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getEntity()
	 * @see #getAuditRecord()
	 * @generated
	 */
	EAttribute getAuditRecord_Entity();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getChangeType <em>Change Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Change Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getChangeType()
	 * @see #getAuditRecord()
	 * @generated
	 */
	EAttribute getAuditRecord_ChangeType();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getFieldName <em>Field Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Name</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getFieldName()
	 * @see #getAuditRecord()
	 * @generated
	 */
	EAttribute getAuditRecord_FieldName();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getOldValue <em>Old Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Value</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getOldValue()
	 * @see #getAuditRecord()
	 * @generated
	 */
	EAttribute getAuditRecord_OldValue();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Value</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getNewValue()
	 * @see #getAuditRecord()
	 * @generated
	 */
	EAttribute getAuditRecord_NewValue();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getTransactionStamp <em>Transaction Stamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Stamp</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditRecord#getTransactionStamp()
	 * @see #getAuditRecord()
	 * @generated
	 */
	EAttribute getAuditRecord_TransactionStamp();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.audit.ChangeType <em>Change Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Change Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.audit.ChangeType
	 * @generated
	 */
	EEnum getChangeType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AuditFactory getAuditFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.audit.impl.AuditRecordImpl <em>Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.audit.impl.AuditRecordImpl
		 * @see com.agritrace.edairy.desktop.common.model.audit.impl.AuditPackageImpl#getAuditRecord()
		 * @generated
		 */
		EClass AUDIT_RECORD = eINSTANCE.getAuditRecord();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIT_RECORD__ID = eINSTANCE.getAuditRecord_Id();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIT_RECORD__DATE = eINSTANCE.getAuditRecord_Date();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIT_RECORD__USER = eINSTANCE.getAuditRecord_User();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIT_RECORD__ENTITY = eINSTANCE.getAuditRecord_Entity();

		/**
		 * The meta object literal for the '<em><b>Change Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIT_RECORD__CHANGE_TYPE = eINSTANCE.getAuditRecord_ChangeType();

		/**
		 * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIT_RECORD__FIELD_NAME = eINSTANCE.getAuditRecord_FieldName();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIT_RECORD__OLD_VALUE = eINSTANCE.getAuditRecord_OldValue();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIT_RECORD__NEW_VALUE = eINSTANCE.getAuditRecord_NewValue();

		/**
		 * The meta object literal for the '<em><b>Transaction Stamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIT_RECORD__TRANSACTION_STAMP = eINSTANCE.getAuditRecord_TransactionStamp();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.audit.ChangeType <em>Change Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.audit.ChangeType
		 * @see com.agritrace.edairy.desktop.common.model.audit.impl.AuditPackageImpl#getChangeType()
		 * @generated
		 */
		EEnum CHANGE_TYPE = eINSTANCE.getChangeType();

	}

} //AuditPackage
