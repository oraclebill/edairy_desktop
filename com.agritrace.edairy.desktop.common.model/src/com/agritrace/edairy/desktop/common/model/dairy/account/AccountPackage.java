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
	 * The feature id for the '<em><b>Account Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__ACCOUNT_NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Member</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__MEMBER = 2;

	/**
	 * The feature id for the '<em><b>Established</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__ESTABLISHED = 3;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__STATUS = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__TYPE = 5;

	/**
	 * The feature id for the '<em><b>Transactions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__TRANSACTIONS = 6;

	/**
	 * The feature id for the '<em><b>Balances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__BALANCES = 7;

	/**
	 * The number of structural features of the '<em>Account</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.TransactionImpl <em>Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.TransactionImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getTransaction()
	 * @generated
	 */
	int TRANSACTION = 1;

	/**
	 * The feature id for the '<em><b>Account</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__ACCOUNT = 0;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__TRANSACTION_ID = 1;

	/**
	 * The feature id for the '<em><b>Transaction Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__TRANSACTION_DATE = 2;

	/**
	 * The feature id for the '<em><b>Transaction Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__TRANSACTION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__AMOUNT = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__DESCRIPTION = 5;

	/**
	 * The number of structural features of the '<em>Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl <em>Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountTransactionImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getAccountTransaction()
	 * @generated
	 */
	int ACCOUNT_TRANSACTION = 2;

	/**
	 * The feature id for the '<em><b>Account</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__ACCOUNT = TRANSACTION__ACCOUNT;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__TRANSACTION_ID = TRANSACTION__TRANSACTION_ID;

	/**
	 * The feature id for the '<em><b>Transaction Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__TRANSACTION_DATE = TRANSACTION__TRANSACTION_DATE;

	/**
	 * The feature id for the '<em><b>Transaction Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__TRANSACTION_TYPE = TRANSACTION__TRANSACTION_TYPE;

	/**
	 * The feature id for the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__AMOUNT = TRANSACTION__AMOUNT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__DESCRIPTION = TRANSACTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reference Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__REFERENCE_NUMBER = TRANSACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__SOURCE = TRANSACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Related Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__RELATED_LOCATION = TRANSACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Check Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__CHECK_NUMBER = TRANSACTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Signed By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION__SIGNED_BY = TRANSACTION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_TRANSACTION_FEATURE_COUNT = TRANSACTION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AdjustmentTransactionImpl <em>Adjustment Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AdjustmentTransactionImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getAdjustmentTransaction()
	 * @generated
	 */
	int ADJUSTMENT_TRANSACTION = 3;

	/**
	 * The feature id for the '<em><b>Account</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADJUSTMENT_TRANSACTION__ACCOUNT = TRANSACTION__ACCOUNT;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADJUSTMENT_TRANSACTION__TRANSACTION_ID = TRANSACTION__TRANSACTION_ID;

	/**
	 * The feature id for the '<em><b>Transaction Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADJUSTMENT_TRANSACTION__TRANSACTION_DATE = TRANSACTION__TRANSACTION_DATE;

	/**
	 * The feature id for the '<em><b>Transaction Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADJUSTMENT_TRANSACTION__TRANSACTION_TYPE = TRANSACTION__TRANSACTION_TYPE;

	/**
	 * The feature id for the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADJUSTMENT_TRANSACTION__AMOUNT = TRANSACTION__AMOUNT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADJUSTMENT_TRANSACTION__DESCRIPTION = TRANSACTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Signed Off By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADJUSTMENT_TRANSACTION__SIGNED_OFF_BY = TRANSACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Adjustment Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADJUSTMENT_TRANSACTION_FEATURE_COUNT = TRANSACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.BalancePointImpl <em>Balance Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.BalancePointImpl
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getBalancePoint()
	 * @generated
	 */
	int BALANCE_POINT = 4;

	/**
	 * The feature id for the '<em><b>Account Balance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCE_POINT__ACCOUNT_BALANCE_ID = 0;

	/**
	 * The feature id for the '<em><b>Account</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCE_POINT__ACCOUNT = 1;

	/**
	 * The feature id for the '<em><b>As Of</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCE_POINT__AS_OF = 2;

	/**
	 * The feature id for the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCE_POINT__AMOUNT = 3;

	/**
	 * The number of structural features of the '<em>Balance Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCE_POINT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType <em>Transaction Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getTransactionType()
	 * @generated
	 */
	int TRANSACTION_TYPE = 5;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource <em>Transaction Source</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getTransactionSource()
	 * @generated
	 */
	int TRANSACTION_SOURCE = 6;

	/**
	 * The meta object id for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountStatus <em>Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountStatus
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getAccountStatus()
	 * @generated
	 */
	int ACCOUNT_STATUS = 7;


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
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getAccountNumber <em>Account Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Account Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Account#getAccountNumber()
	 * @see #getAccount()
	 * @generated
	 */
	EAttribute getAccount_AccountNumber();

	/**
	 * Returns the meta object for the container reference '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Member</em>'.
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
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getTransactions <em>Transactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transactions</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Account#getTransactions()
	 * @see #getAccount()
	 * @generated
	 */
	EReference getAccount_Transactions();

	/**
	 * Returns the meta object for the containment reference list '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getBalances <em>Balances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Balances</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Account#getBalances()
	 * @see #getAccount()
	 * @generated
	 */
	EReference getAccount_Balances();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Transaction <em>Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transaction</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Transaction
	 * @generated
	 */
	EClass getTransaction();

	/**
	 * Returns the meta object for the container reference '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Transaction#getAccount <em>Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Account</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Transaction#getAccount()
	 * @see #getTransaction()
	 * @generated
	 */
	EReference getTransaction_Account();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Transaction#getTransactionId <em>Transaction Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Id</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Transaction#getTransactionId()
	 * @see #getTransaction()
	 * @generated
	 */
	EAttribute getTransaction_TransactionId();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Transaction#getTransactionDate <em>Transaction Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Date</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Transaction#getTransactionDate()
	 * @see #getTransaction()
	 * @generated
	 */
	EAttribute getTransaction_TransactionDate();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Transaction#getTransactionType <em>Transaction Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Type</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Transaction#getTransactionType()
	 * @see #getTransaction()
	 * @generated
	 */
	EAttribute getTransaction_TransactionType();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Transaction#getAmount <em>Amount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Amount</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Transaction#getAmount()
	 * @see #getTransaction()
	 * @generated
	 */
	EAttribute getTransaction_Amount();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Transaction#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Transaction#getDescription()
	 * @see #getTransaction()
	 * @generated
	 */
	EAttribute getTransaction_Description();

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
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getRelatedLocation <em>Related Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Related Location</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getRelatedLocation()
	 * @see #getAccountTransaction()
	 * @generated
	 */
	EReference getAccountTransaction_RelatedLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getCheckNumber <em>Check Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Check Number</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getCheckNumber()
	 * @see #getAccountTransaction()
	 * @generated
	 */
	EAttribute getAccountTransaction_CheckNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getSignedBy <em>Signed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signed By</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getSignedBy()
	 * @see #getAccountTransaction()
	 * @generated
	 */
	EAttribute getAccountTransaction_SignedBy();

	/**
	 * Returns the meta object for class '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AdjustmentTransaction <em>Adjustment Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adjustment Transaction</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AdjustmentTransaction
	 * @generated
	 */
	EClass getAdjustmentTransaction();

	/**
	 * Returns the meta object for the reference '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AdjustmentTransaction#getSignedOffBy <em>Signed Off By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signed Off By</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AdjustmentTransaction#getSignedOffBy()
	 * @see #getAdjustmentTransaction()
	 * @generated
	 */
	EReference getAdjustmentTransaction_SignedOffBy();

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
	 * Returns the meta object for the container reference '{@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAccount <em>Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Account</em>'.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAccount()
	 * @see #getBalancePoint()
	 * @generated
	 */
	EReference getBalancePoint_Account();

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
		 * The meta object literal for the '<em><b>Account Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT__ACCOUNT_NUMBER = eINSTANCE.getAccount_AccountNumber();

		/**
		 * The meta object literal for the '<em><b>Member</b></em>' container reference feature.
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
		 * The meta object literal for the '<em><b>Transactions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCOUNT__TRANSACTIONS = eINSTANCE.getAccount_Transactions();

		/**
		 * The meta object literal for the '<em><b>Balances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCOUNT__BALANCES = eINSTANCE.getAccount_Balances();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.TransactionImpl <em>Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.TransactionImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getTransaction()
		 * @generated
		 */
		EClass TRANSACTION = eINSTANCE.getTransaction();

		/**
		 * The meta object literal for the '<em><b>Account</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSACTION__ACCOUNT = eINSTANCE.getTransaction_Account();

		/**
		 * The meta object literal for the '<em><b>Transaction Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSACTION__TRANSACTION_ID = eINSTANCE.getTransaction_TransactionId();

		/**
		 * The meta object literal for the '<em><b>Transaction Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSACTION__TRANSACTION_DATE = eINSTANCE.getTransaction_TransactionDate();

		/**
		 * The meta object literal for the '<em><b>Transaction Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSACTION__TRANSACTION_TYPE = eINSTANCE.getTransaction_TransactionType();

		/**
		 * The meta object literal for the '<em><b>Amount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSACTION__AMOUNT = eINSTANCE.getTransaction_Amount();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSACTION__DESCRIPTION = eINSTANCE.getTransaction_Description();

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
		 * The meta object literal for the '<em><b>Reference Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT_TRANSACTION__REFERENCE_NUMBER = eINSTANCE.getAccountTransaction_ReferenceNumber();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT_TRANSACTION__SOURCE = eINSTANCE.getAccountTransaction_Source();

		/**
		 * The meta object literal for the '<em><b>Related Location</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCOUNT_TRANSACTION__RELATED_LOCATION = eINSTANCE.getAccountTransaction_RelatedLocation();

		/**
		 * The meta object literal for the '<em><b>Check Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT_TRANSACTION__CHECK_NUMBER = eINSTANCE.getAccountTransaction_CheckNumber();

		/**
		 * The meta object literal for the '<em><b>Signed By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT_TRANSACTION__SIGNED_BY = eINSTANCE.getAccountTransaction_SignedBy();

		/**
		 * The meta object literal for the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.impl.AdjustmentTransactionImpl <em>Adjustment Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AdjustmentTransactionImpl
		 * @see com.agritrace.edairy.desktop.common.model.dairy.account.impl.AccountPackageImpl#getAdjustmentTransaction()
		 * @generated
		 */
		EClass ADJUSTMENT_TRANSACTION = eINSTANCE.getAdjustmentTransaction();

		/**
		 * The meta object literal for the '<em><b>Signed Off By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADJUSTMENT_TRANSACTION__SIGNED_OFF_BY = eINSTANCE.getAdjustmentTransaction_SignedOffBy();

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
		 * The meta object literal for the '<em><b>Account</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BALANCE_POINT__ACCOUNT = eINSTANCE.getBalancePoint_Account();

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
