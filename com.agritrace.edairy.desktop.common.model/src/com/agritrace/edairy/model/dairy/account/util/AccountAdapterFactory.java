/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.account.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.model.dairy.account.Account;
import com.agritrace.edairy.model.dairy.account.AccountPackage;
import com.agritrace.edairy.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.model.dairy.account.BalancePoint;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * 
 * @see com.agritrace.edairy.model.dairy.account.AccountPackage
 * @generated
 */
public class AccountAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static AccountPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public AccountAdapterFactory() {
	if (modelPackage == null) {
	    modelPackage = AccountPackage.eINSTANCE;
	}
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc --> This implementation returns <code>true</code> if
     * the object is either the model's package or is an instance object of the
     * model. <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
	if (object == modelPackage) {
	    return true;
	}
	if (object instanceof EObject) {
	    return ((EObject) object).eClass().getEPackage() == modelPackage;
	}
	return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AccountSwitch<Adapter> modelSwitch = new AccountSwitch<Adapter>() {
	@Override
	public Adapter caseAccount(Account object) {
	    return createAccountAdapter();
	}

	@Override
	public Adapter caseAccountTransaction(AccountTransaction object) {
	    return createAccountTransactionAdapter();
	}

	@Override
	public Adapter caseBalancePoint(BalancePoint object) {
	    return createBalancePointAdapter();
	}

	@Override
	public Adapter defaultCase(EObject object) {
	    return createEObjectAdapter();
	}
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
	return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link com.agritrace.edairy.model.dairy.account.Account <em>Account</em>}
     * '. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see com.agritrace.edairy.model.dairy.account.Account
     * @generated
     */
    public Adapter createAccountAdapter() {
	return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link com.agritrace.edairy.model.dairy.account.AccountTransaction
     * <em>Transaction</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see com.agritrace.edairy.model.dairy.account.AccountTransaction
     * @generated
     */
    public Adapter createAccountTransactionAdapter() {
	return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link com.agritrace.edairy.model.dairy.account.BalancePoint
     * <em>Balance Point</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see com.agritrace.edairy.model.dairy.account.BalancePoint
     * @generated
     */
    public Adapter createBalancePointAdapter() {
	return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This
     * default implementation returns null. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
	return null;
    }

} // AccountAdapterFactory
