/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.dairy.model.account.impl;

import com.agritrace.edairy.dairy.model.account.Account;
import com.agritrace.edairy.dairy.model.account.AccountFactory;
import com.agritrace.edairy.dairy.model.account.AccountPackage;
import com.agritrace.edairy.dairy.model.account.AccountTransaction;
import com.agritrace.edairy.dairy.model.account.BalancePoint;
import com.agritrace.edairy.dairy.model.account.TransactionType;

import com.agritrace.edairy.model.ModelPackage;

import com.agritrace.edairy.model.dairy.DairyPackage;

import com.agritrace.edairy.model.dairy.impl.DairyPackageImpl;

import com.agritrace.edairy.model.impl.ModelPackageImpl;

import com.agritrace.edairy.model.requests.RequestsPackage;

import com.agritrace.edairy.model.requests.impl.RequestsPackageImpl;

import com.agritrace.edairy.model.tracking.TrackingPackage;

import com.agritrace.edairy.model.tracking.impl.TrackingPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AccountPackageImpl extends EPackageImpl implements AccountPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accountEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accountTransactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass balancePointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum transactionTypeEEnum = null;

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
	 * @see com.agritrace.edairy.dairy.model.account.AccountPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AccountPackageImpl() {
		super(eNS_URI, AccountFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AccountPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AccountPackage init() {
		if (isInited) return (AccountPackage)EPackage.Registry.INSTANCE.getEPackage(AccountPackage.eNS_URI);

		// Obtain or create and register package
		AccountPackageImpl theAccountPackage = (AccountPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AccountPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AccountPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DairyPackageImpl theDairyPackage = (DairyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DairyPackage.eNS_URI) instanceof DairyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DairyPackage.eNS_URI) : DairyPackage.eINSTANCE);
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		TrackingPackageImpl theTrackingPackage = (TrackingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TrackingPackage.eNS_URI) instanceof TrackingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TrackingPackage.eNS_URI) : TrackingPackage.eINSTANCE);
		RequestsPackageImpl theRequestsPackage = (RequestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RequestsPackage.eNS_URI) instanceof RequestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RequestsPackage.eNS_URI) : RequestsPackage.eINSTANCE);

		// Create package meta-data objects
		theAccountPackage.createPackageContents();
		theDairyPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theTrackingPackage.createPackageContents();
		theRequestsPackage.createPackageContents();

		// Initialize created meta-data
		theAccountPackage.initializePackageContents();
		theDairyPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theTrackingPackage.initializePackageContents();
		theRequestsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAccountPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AccountPackage.eNS_URI, theAccountPackage);
		return theAccountPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAccount() {
		return accountEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccount_AccountId() {
		return (EAttribute)accountEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAccount_Member() {
		return (EReference)accountEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccount_Established() {
		return (EAttribute)accountEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccount_Type() {
		return (EAttribute)accountEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAccount_Transactions() {
		return (EReference)accountEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAccount_Balances() {
		return (EReference)accountEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAccountTransaction() {
		return accountTransactionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccountTransaction_TransactionId() {
		return (EAttribute)accountTransactionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAccountTransaction_Account() {
		return (EReference)accountTransactionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccountTransaction_TransactionType() {
		return (EAttribute)accountTransactionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccountTransaction_Soure() {
		return (EAttribute)accountTransactionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccountTransaction_Amount() {
		return (EAttribute)accountTransactionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccountTransaction_Description() {
		return (EAttribute)accountTransactionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccountTransaction_TransactionDate() {
		return (EAttribute)accountTransactionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBalancePoint() {
		return balancePointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBalancePoint_AccountBalanceId() {
		return (EAttribute)balancePointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBalancePoint_Account() {
		return (EReference)balancePointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBalancePoint_PreviousBalance() {
		return (EReference)balancePointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBalancePoint_AsOf() {
		return (EAttribute)balancePointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBalancePoint_Amount() {
		return (EAttribute)balancePointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTransactionType() {
		return transactionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccountFactory getAccountFactory() {
		return (AccountFactory)getEFactoryInstance();
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
		accountEClass = createEClass(ACCOUNT);
		createEAttribute(accountEClass, ACCOUNT__ACCOUNT_ID);
		createEReference(accountEClass, ACCOUNT__MEMBER);
		createEAttribute(accountEClass, ACCOUNT__ESTABLISHED);
		createEAttribute(accountEClass, ACCOUNT__TYPE);
		createEReference(accountEClass, ACCOUNT__TRANSACTIONS);
		createEReference(accountEClass, ACCOUNT__BALANCES);

		accountTransactionEClass = createEClass(ACCOUNT_TRANSACTION);
		createEAttribute(accountTransactionEClass, ACCOUNT_TRANSACTION__TRANSACTION_ID);
		createEReference(accountTransactionEClass, ACCOUNT_TRANSACTION__ACCOUNT);
		createEAttribute(accountTransactionEClass, ACCOUNT_TRANSACTION__TRANSACTION_TYPE);
		createEAttribute(accountTransactionEClass, ACCOUNT_TRANSACTION__SOURE);
		createEAttribute(accountTransactionEClass, ACCOUNT_TRANSACTION__AMOUNT);
		createEAttribute(accountTransactionEClass, ACCOUNT_TRANSACTION__DESCRIPTION);
		createEAttribute(accountTransactionEClass, ACCOUNT_TRANSACTION__TRANSACTION_DATE);

		balancePointEClass = createEClass(BALANCE_POINT);
		createEAttribute(balancePointEClass, BALANCE_POINT__ACCOUNT_BALANCE_ID);
		createEReference(balancePointEClass, BALANCE_POINT__ACCOUNT);
		createEReference(balancePointEClass, BALANCE_POINT__PREVIOUS_BALANCE);
		createEAttribute(balancePointEClass, BALANCE_POINT__AS_OF);
		createEAttribute(balancePointEClass, BALANCE_POINT__AMOUNT);

		// Create enums
		transactionTypeEEnum = createEEnum(TRANSACTION_TYPE);
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

		// Obtain other dependent packages
		DairyPackage theDairyPackage = (DairyPackage)EPackage.Registry.INSTANCE.getEPackage(DairyPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(accountEClass, Account.class, "Account", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAccount_AccountId(), ecorePackage.getELong(), "accountId", null, 0, 1, Account.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccount_Member(), theDairyPackage.getMembership(), null, "member", null, 0, 1, Account.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccount_Established(), ecorePackage.getEDate(), "established", null, 0, 1, Account.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccount_Type(), ecorePackage.getEString(), "type", null, 0, 1, Account.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccount_Transactions(), this.getAccountTransaction(), null, "transactions", null, 0, -1, Account.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccount_Balances(), this.getBalancePoint(), null, "balances", null, 0, -1, Account.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(accountTransactionEClass, AccountTransaction.class, "AccountTransaction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAccountTransaction_TransactionId(), ecorePackage.getELong(), "transactionId", null, 1, 1, AccountTransaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccountTransaction_Account(), this.getAccount(), null, "account", null, 1, 1, AccountTransaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccountTransaction_TransactionType(), this.getTransactionType(), "transactionType", null, 1, 1, AccountTransaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccountTransaction_Soure(), ecorePackage.getEString(), "soure", null, 0, 1, AccountTransaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccountTransaction_Amount(), ecorePackage.getEDouble(), "amount", null, 0, 1, AccountTransaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccountTransaction_Description(), ecorePackage.getEString(), "description", null, 0, 1, AccountTransaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccountTransaction_TransactionDate(), ecorePackage.getEDate(), "transactionDate", null, 1, 1, AccountTransaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(balancePointEClass, BalancePoint.class, "BalancePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBalancePoint_AccountBalanceId(), ecorePackage.getELong(), "accountBalanceId", null, 0, 1, BalancePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBalancePoint_Account(), this.getAccount(), null, "account", null, 1, 1, BalancePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBalancePoint_PreviousBalance(), this.getBalancePoint(), null, "previousBalance", null, 1, 1, BalancePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBalancePoint_AsOf(), ecorePackage.getEDate(), "asOf", null, 0, 1, BalancePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBalancePoint_Amount(), ecorePackage.getEBigDecimal(), "amount", null, 0, 1, BalancePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(transactionTypeEEnum, TransactionType.class, "TransactionType");
		addEEnumLiteral(transactionTypeEEnum, TransactionType.CREDIT);
		addEEnumLiteral(transactionTypeEEnum, TransactionType.DEBIT);
	}

} //AccountPackageImpl
