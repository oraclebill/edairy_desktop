/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.account;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory
 * @model kind="package"
 * @generated
 */
public interface AccountPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "account";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://com.agritrace.edairy.desktop.common.model/account";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "account";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AccountPackage eINSTANCE = com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountImpl <em>Account</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getAccount()
	 * @generated
	 */
	int ACCOUNT = 0;

	/**
	 * The feature id for the '<em><b>Account Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__ACCOUNT_ID = 0;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__MEMBER = 1;

	/**
	 * The feature id for the '<em><b>Established</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__ESTABLISHED = 2;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__STATUS = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__TYPE = 4;

	/**
	 * The feature id for the '<em><b>Transactions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__TRANSACTIONS = 5;

	/**
	 * The feature id for the '<em><b>Balances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__BALANCES = 6;

	/**
	 * The number of structural features of the '<em>Account</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl <em>Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getAccountTransaction()
	 * @generated
	 */
	int ACCOUNT_TRANSACTION = 1;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__TRANSACTION_ID = 0;

	/**
	 * The feature id for the '<em><b>Reference Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__REFERENCE_NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Account</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__ACCOUNT = 2;

	/**
	 * The feature id for the '<em><b>Transaction Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__TRANSACTION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__SOURCE = 4;

	/**
	 * The feature id for the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__AMOUNT = 5;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__DESCRIPTION = 6;

	/**
	 * The feature id for the '<em><b>Transaction Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__TRANSACTION_DATE = 7;

	/**
	 * The number of structural features of the '<em>Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.BalancePointImpl <em>Balance Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.BalancePointImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getBalancePoint()
	 * @generated
	 */
	int BALANCE_POINT = 2;

	/**
	 * The feature id for the '<em><b>Account Balance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCE_POINT__ACCOUNT_BALANCE_ID = 0;

	/**
	 * The feature id for the '<em><b>Account</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCE_POINT__ACCOUNT = 1;

	/**
	 * The feature id for the '<em><b>Previous Balance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCE_POINT__PREVIOUS_BALANCE = 2;

	/**
	 * The feature id for the '<em><b>As Of</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCE_POINT__AS_OF = 3;

	/**
	 * The feature id for the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCE_POINT__AMOUNT = 4;

	/**
	 * The number of structural features of the '<em>Balance Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCE_POINT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType <em>Transaction Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getTransactionType()
	 * @generated
	 */
	int TRANSACTION_TYPE = 3;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource <em>Transaction Source</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getTransactionSource()
	 * @generated
	 */
	int TRANSACTION_SOURCE = 4;


	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountStatus <em>Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountStatus
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getAccountStatus()
	 * @generated
	 */
	int ACCOUNT_STATUS = 5;


	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account <em>Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Account</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Account
	 * @generated
	 */
	EClass getAccount();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getAccountId <em>Account Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Account Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Account#getAccountId()
	 * @see #getAccount()
	 * @generated
	 */
	EAttribute getAccount_AccountId();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Member</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Account#getMember()
	 * @see #getAccount()
	 * @generated
	 */
	EReference getAccount_Member();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getEstablished <em>Established</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Established</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Account#getEstablished()
	 * @see #getAccount()
	 * @generated
	 */
	EAttribute getAccount_Established();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Account#getStatus()
	 * @see #getAccount()
	 * @generated
	 */
	EAttribute getAccount_Status();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Account#getType()
	 * @see #getAccount()
	 * @generated
	 */
	EAttribute getAccount_Type();

	/**
	 * Returns the meta object for the reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getTransactions <em>Transactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Transactions</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Account#getTransactions()
	 * @see #getAccount()
	 * @generated
	 */
	EReference getAccount_Transactions();

	/**
	 * Returns the meta object for the reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getBalances <em>Balances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Balances</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Account#getBalances()
	 * @see #getAccount()
	 * @generated
	 */
	EReference getAccount_Balances();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction <em>Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transaction</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction
	 * @generated
	 */
	EClass getAccountTransaction();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getTransactionId <em>Transaction Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getTransactionId()
	 * @see #getAccountTransaction()
	 * @generated
	 */
	EAttribute getAccountTransaction_TransactionId();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getReferenceNumber <em>Reference Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getReferenceNumber()
	 * @see #getAccountTransaction()
	 * @generated
	 */
	EAttribute getAccountTransaction_ReferenceNumber();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getAccount <em>Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Account</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getAccount()
	 * @see #getAccountTransaction()
	 * @generated
	 */
	EReference getAccountTransaction_Account();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getTransactionType <em>Transaction Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getTransactionType()
	 * @see #getAccountTransaction()
	 * @generated
	 */
	EAttribute getAccountTransaction_TransactionType();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getSource()
	 * @see #getAccountTransaction()
	 * @generated
	 */
	EAttribute getAccountTransaction_Source();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getAmount <em>Amount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Amount</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getAmount()
	 * @see #getAccountTransaction()
	 * @generated
	 */
	EAttribute getAccountTransaction_Amount();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getDescription()
	 * @see #getAccountTransaction()
	 * @generated
	 */
	EAttribute getAccountTransaction_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getTransactionDate <em>Transaction Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getTransactionDate()
	 * @see #getAccountTransaction()
	 * @generated
	 */
	EAttribute getAccountTransaction_TransactionDate();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint <em>Balance Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Balance Point</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint
	 * @generated
	 */
	EClass getBalancePoint();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAccountBalanceId <em>Account Balance Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Account Balance Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAccountBalanceId()
	 * @see #getBalancePoint()
	 * @generated
	 */
	EAttribute getBalancePoint_AccountBalanceId();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAccount <em>Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Account</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAccount()
	 * @see #getBalancePoint()
	 * @generated
	 */
	EReference getBalancePoint_Account();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getPreviousBalance <em>Previous Balance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Previous Balance</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getPreviousBalance()
	 * @see #getBalancePoint()
	 * @generated
	 */
	EReference getBalancePoint_PreviousBalance();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAsOf <em>As Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>As Of</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAsOf()
	 * @see #getBalancePoint()
	 * @generated
	 */
	EAttribute getBalancePoint_AsOf();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAmount <em>Amount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Amount</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAmount()
	 * @see #getBalancePoint()
	 * @generated
	 */
	EAttribute getBalancePoint_Amount();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType <em>Transaction Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transaction Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType
	 * @generated
	 */
	EEnum getTransactionType();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource <em>Transaction Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transaction Source</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource
	 * @generated
	 */
	EEnum getTransactionSource();

	/**
	 * Returns the meta object for enum '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Status</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountStatus
	 * @generated
	 */
	EEnum getAccountStatus();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AccountFactory getAccountFactory();

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
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountImpl <em>Account</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getAccount()
		 * @generated
		 */
		EClass ACCOUNT = eINSTANCE.getAccount();

		/**
		 * The meta object literal for the '<em><b>Account Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT__ACCOUNT_ID = eINSTANCE.getAccount_AccountId();

		/**
		 * The meta object literal for the '<em><b>Member</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCOUNT__MEMBER = eINSTANCE.getAccount_Member();

		/**
		 * The meta object literal for the '<em><b>Established</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT__ESTABLISHED = eINSTANCE.getAccount_Established();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT__STATUS = eINSTANCE.getAccount_Status();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT__TYPE = eINSTANCE.getAccount_Type();

		/**
		 * The meta object literal for the '<em><b>Transactions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCOUNT__TRANSACTIONS = eINSTANCE.getAccount_Transactions();

		/**
		 * The meta object literal for the '<em><b>Balances</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCOUNT__BALANCES = eINSTANCE.getAccount_Balances();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl <em>Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getAccountTransaction()
		 * @generated
		 */
		EClass ACCOUNT_TRANSACTION = eINSTANCE.getAccountTransaction();

		/**
		 * The meta object literal for the '<em><b>Transaction Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT_TRANSACTION__TRANSACTION_ID = eINSTANCE.getAccountTransaction_TransactionId();

		/**
		 * The meta object literal for the '<em><b>Reference Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT_TRANSACTION__REFERENCE_NUMBER = eINSTANCE.getAccountTransaction_ReferenceNumber();

		/**
		 * The meta object literal for the '<em><b>Account</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCOUNT_TRANSACTION__ACCOUNT = eINSTANCE.getAccountTransaction_Account();

		/**
		 * The meta object literal for the '<em><b>Transaction Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT_TRANSACTION__TRANSACTION_TYPE = eINSTANCE.getAccountTransaction_TransactionType();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT_TRANSACTION__SOURCE = eINSTANCE.getAccountTransaction_Source();

		/**
		 * The meta object literal for the '<em><b>Amount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT_TRANSACTION__AMOUNT = eINSTANCE.getAccountTransaction_Amount();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT_TRANSACTION__DESCRIPTION = eINSTANCE.getAccountTransaction_Description();

		/**
		 * The meta object literal for the '<em><b>Transaction Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT_TRANSACTION__TRANSACTION_DATE = eINSTANCE.getAccountTransaction_TransactionDate();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.BalancePointImpl <em>Balance Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.BalancePointImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getBalancePoint()
		 * @generated
		 */
		EClass BALANCE_POINT = eINSTANCE.getBalancePoint();

		/**
		 * The meta object literal for the '<em><b>Account Balance Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BALANCE_POINT__ACCOUNT_BALANCE_ID = eINSTANCE.getBalancePoint_AccountBalanceId();

		/**
		 * The meta object literal for the '<em><b>Account</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BALANCE_POINT__ACCOUNT = eINSTANCE.getBalancePoint_Account();

		/**
		 * The meta object literal for the '<em><b>Previous Balance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BALANCE_POINT__PREVIOUS_BALANCE = eINSTANCE.getBalancePoint_PreviousBalance();

		/**
		 * The meta object literal for the '<em><b>As Of</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BALANCE_POINT__AS_OF = eINSTANCE.getBalancePoint_AsOf();

		/**
		 * The meta object literal for the '<em><b>Amount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BALANCE_POINT__AMOUNT = eINSTANCE.getBalancePoint_Amount();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType <em>Transaction Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getTransactionType()
		 * @generated
		 */
		EEnum TRANSACTION_TYPE = eINSTANCE.getTransactionType();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource <em>Transaction Source</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getTransactionSource()
		 * @generated
		 */
		EEnum TRANSACTION_SOURCE = eINSTANCE.getTransactionSource();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountStatus <em>Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountStatus
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getAccountStatus()
		 * @generated
		 */
		EEnum ACCOUNT_STATUS = eINSTANCE.getAccountStatus();

	}

} //AccountPackage
