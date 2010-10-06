/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.audit.impl;

import com.agritrace.edairy.desktop.common.model.audit.AuditFactory;
import com.agritrace.edairy.desktop.common.model.audit.AuditPackage;
import com.agritrace.edairy.desktop.common.model.audit.AuditRecord;
import com.agritrace.edairy.desktop.common.model.audit.ChangeType;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AuditPackageImpl extends EPackageImpl implements AuditPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass auditRecordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum changeTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.agritrace.edairy.desktop.common.model.audit.AuditPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AuditPackageImpl() {
		super(eNS_URI, AuditFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link AuditPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AuditPackage init() {
		if (isInited) return (AuditPackage)EPackage.Registry.INSTANCE.getEPackage(AuditPackage.eNS_URI);

		// Obtain or create and register package
		AuditPackageImpl theAuditPackage = (AuditPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AuditPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AuditPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theAuditPackage.createPackageContents();

		// Initialize created meta-data
		theAuditPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAuditPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AuditPackage.eNS_URI, theAuditPackage);
		return theAuditPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAuditRecord() {
		return auditRecordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuditRecord_Id() {
		return (EAttribute)auditRecordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuditRecord_Date() {
		return (EAttribute)auditRecordEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuditRecord_User() {
		return (EAttribute)auditRecordEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuditRecord_Entity() {
		return (EAttribute)auditRecordEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuditRecord_ChangeType() {
		return (EAttribute)auditRecordEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuditRecord_FieldName() {
		return (EAttribute)auditRecordEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuditRecord_OldValue() {
		return (EAttribute)auditRecordEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuditRecord_NewValue() {
		return (EAttribute)auditRecordEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuditRecord_TransactionStamp() {
		return (EAttribute)auditRecordEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getChangeType() {
		return changeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuditFactory getAuditFactory() {
		return (AuditFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		auditRecordEClass = createEClass(AUDIT_RECORD);
		createEAttribute(auditRecordEClass, AUDIT_RECORD__ID);
		createEAttribute(auditRecordEClass, AUDIT_RECORD__DATE);
		createEAttribute(auditRecordEClass, AUDIT_RECORD__USER);
		createEAttribute(auditRecordEClass, AUDIT_RECORD__ENTITY);
		createEAttribute(auditRecordEClass, AUDIT_RECORD__CHANGE_TYPE);
		createEAttribute(auditRecordEClass, AUDIT_RECORD__FIELD_NAME);
		createEAttribute(auditRecordEClass, AUDIT_RECORD__OLD_VALUE);
		createEAttribute(auditRecordEClass, AUDIT_RECORD__NEW_VALUE);
		createEAttribute(auditRecordEClass, AUDIT_RECORD__TRANSACTION_STAMP);

		// Create enums
		changeTypeEEnum = createEEnum(CHANGE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(auditRecordEClass, AuditRecord.class, "AuditRecord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAuditRecord_Id(), ecorePackage.getELongObject(), "id", null, 0, 1, AuditRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuditRecord_Date(), ecorePackage.getEDate(), "date", null, 1, 1, AuditRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuditRecord_User(), ecorePackage.getEString(), "user", null, 1, 1, AuditRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuditRecord_Entity(), ecorePackage.getEString(), "entity", null, 0, 1, AuditRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuditRecord_ChangeType(), this.getChangeType(), "changeType", null, 1, 1, AuditRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuditRecord_FieldName(), ecorePackage.getEString(), "fieldName", null, 0, 1, AuditRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuditRecord_OldValue(), ecorePackage.getEString(), "oldValue", null, 0, 1, AuditRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuditRecord_NewValue(), ecorePackage.getEString(), "newValue", null, 0, 1, AuditRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuditRecord_TransactionStamp(), ecorePackage.getEIntegerObject(), "transactionStamp", null, 0, 1, AuditRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(changeTypeEEnum, ChangeType.class, "ChangeType");
		addEEnumLiteral(changeTypeEEnum, ChangeType.SAVE);
		addEEnumLiteral(changeTypeEEnum, ChangeType.DELETE);

		// Create resource
		createResource(eNS_URI);
	}

} //AuditPackageImpl
