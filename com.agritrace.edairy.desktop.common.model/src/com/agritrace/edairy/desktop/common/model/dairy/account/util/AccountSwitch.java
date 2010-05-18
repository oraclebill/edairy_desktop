/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.account.util;

import com.agritrace.edairy.desktop.common.model.dairy.account.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage
 * @generated
 */
public class AccountSwitch<T> {
        /**
         * The cached model package
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected static AccountPackage modelPackage;

        /**
         * Creates an instance of the switch.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public AccountSwitch() {
                if (modelPackage == null) {
                        modelPackage = AccountPackage.eINSTANCE;
                }
        }

        /**
         * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the first non-null result returned by a <code>caseXXX</code> call.
         * @generated
         */
        public T doSwitch(EObject theEObject) {
                return doSwitch(theEObject.eClass(), theEObject);
        }

        /**
         * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the first non-null result returned by a <code>caseXXX</code> call.
         * @generated
         */
        protected T doSwitch(EClass theEClass, EObject theEObject) {
                if (theEClass.eContainer() == modelPackage) {
                        return doSwitch(theEClass.getClassifierID(), theEObject);
                }
                else {
                        List<EClass> eSuperTypes = theEClass.getESuperTypes();
                        return
                                eSuperTypes.isEmpty() ?
                                        defaultCase(theEObject) :
                                        doSwitch(eSuperTypes.get(0), theEObject);
                }
        }

        /**
         * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the first non-null result returned by a <code>caseXXX</code> call.
         * @generated
         */
        protected T doSwitch(int classifierID, EObject theEObject) {
                switch (classifierID) {
                        case AccountPackage.ACCOUNT: {
                                Account account = (Account)theEObject;
                                T result = caseAccount(account);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case AccountPackage.ACCOUNT_TRANSACTION: {
                                AccountTransaction accountTransaction = (AccountTransaction)theEObject;
                                T result = caseAccountTransaction(accountTransaction);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case AccountPackage.BALANCE_POINT: {
                                BalancePoint balancePoint = (BalancePoint)theEObject;
                                T result = caseBalancePoint(balancePoint);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        default: return defaultCase(theEObject);
                }
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>Account</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Account</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
        public T caseAccount(Account object) {
                return null;
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>Transaction</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Transaction</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
        public T caseAccountTransaction(AccountTransaction object) {
                return null;
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>Balance Point</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Balance Point</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
        public T caseBalancePoint(BalancePoint object) {
                return null;
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch, but this is the last case anyway.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject)
         * @generated
         */
        public T defaultCase(EObject object) {
                return null;
        }

} //AccountSwitch
