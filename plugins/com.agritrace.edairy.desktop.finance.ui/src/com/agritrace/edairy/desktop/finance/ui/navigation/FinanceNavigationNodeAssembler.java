package com.agritrace.edairy.desktop.finance.ui.navigation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.riena.navigation.AbstractNavigationAssembler;
import org.eclipse.riena.navigation.IModuleGroupNode;
import org.eclipse.riena.navigation.IModuleNode;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubApplicationNode;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.model.ModuleGroupNode;
import org.eclipse.riena.navigation.model.SubApplicationNode;
import org.eclipse.riena.ui.workarea.WorkareaManager;

import com.agritrace.edairy.desktop.common.ui.navigation.NodeFactory;
import com.agritrace.edairy.desktop.finance.ui.controllers.AccountTransactionJournalController;
import com.agritrace.edairy.desktop.finance.ui.controllers.AdjustmentTransactionJournalController;
import com.agritrace.edairy.desktop.finance.ui.controllers.MemberPaymentsViewController;
import com.agritrace.edairy.desktop.finance.ui.paymentrequest.PaymentRequestView;
import com.agritrace.edairy.desktop.finance.ui.paymentrequest.PaymentRequestViewController;
import com.agritrace.edairy.desktop.finance.ui.views.AdjustmentTransactionJournalView;
import com.agritrace.edairy.desktop.finance.ui.views.MemberPaymentsView;
import com.agritrace.edairy.desktop.finance.ui.views.TransactionJournalView;

public class FinanceNavigationNodeAssembler extends AbstractNavigationAssembler {
	// FINANCE

	private static final String LABEL_FINANCE = "Finance";
	private static final String LABEL_PAYMENTS = "Member Payments Register";
	private static final String LABEL_TRANSACTION_LOG = "Member Transaction Register";
	private static final String LABEL_ADJUSTMENT = "Account Adjustment Register";
	private static final String SUBAPP_FINANCE = "com.agritrace.edairy.desktop.finance";	//$NON-NLS-1$
	private static final String MODULE_TRANSACTION_REGISTER = "edm.transaction.entry";	//$NON-NLS-1$
	private static final String MODULE_MILK_PRICE_REGISTER = "edm.milk-price.entry";	//$NON-NLS-1$
	private static final String MODULE_ADJUSTMENT_REGISTER = "edm.adjustment.entry";	//$NON-NLS-1$
	private static final String MODULE_GROUP_TRANSACTIONS = "modulegroup.finance.transactions"; 	//$NON-NLS-1$
	private static final String MODULE_GROUP_MILK_PRICE = "modulegroup.finance.milk-price"; 	//$NON-NLS-1$
	private static final String MODULE_GROUP_ADJUSTMENT = "modulegroup.finance.adjustment"; 	//$NON-NLS-1$
	private static final String MODULE_GROUP_PAYMENTS = "modulegroup.finance.payments"; 	//$NON-NLS-1$
	private static final String SUBMODULE_FINANCE_TRANSACTION_REGISTER = "edm.finances.log";	//$NON-NLS-1$
	private static final String SUBMODULE_FINANCE_PAYMENT_REQUEST = "com.agritrace.edairy.desktop.finance.ui.views.PaymentRequestView";
	private static final String SUBMODULE_FINANCE_MEMBER_PAYMENTS = "com.agritrace.edairy.desktop.finance.ui.views.MemberPaymentsView";	//$NON-NLS-1$
	private static final String SUBMODULE_FINANCE_ADJUSTMENT_REGISTER = "adjustment.log";	//$NON-NLS-1$

	private static final String TAB_FINANCE = SUBAPP_FINANCE;
	private static final String LABEL_PAYMENT_REQUEST = "Payment Request";

	private Set<String> knownTargetIds = null;

	@Override
	public boolean acceptsToBuildNode(NavigationNodeId nodeId, NavigationArgument argument) {
		if (knownTargetIds == null) {
			knownTargetIds = new HashSet<String>(Arrays.asList(SUBAPP_FINANCE));
			knownTargetIds = Collections.unmodifiableSet(knownTargetIds);
		}

		return knownTargetIds.contains(nodeId.getTypeId());
	}

	@Override
	public INavigationNode<?>[] buildNode(NavigationNodeId nodeId, NavigationArgument navigationArgument) {

		//
		// FINANCE TAB
		//

		final ISubApplicationNode subAppNode = new SubApplicationNode(new NavigationNodeId(SUBAPP_FINANCE),
				LABEL_FINANCE);
		WorkareaManager.getInstance().registerDefinition(subAppNode, TAB_FINANCE);

		//
		// FINANCE GROUP
		//
		{
			final IModuleGroupNode moduleGroupNode = new ModuleGroupNode(new NavigationNodeId(MODULE_GROUP_TRANSACTIONS));
			subAppNode.addChild(moduleGroupNode);

			final IModuleNode moduleNode = NodeFactory.createModule(MODULE_TRANSACTION_REGISTER, LABEL_TRANSACTION_LOG, moduleGroupNode);
			NodeFactory.createSubModule(SUBMODULE_FINANCE_TRANSACTION_REGISTER,
							"Transaction Journal", moduleNode, TransactionJournalView.ID, AccountTransactionJournalController.class); //$NON-NLS-1$
		}
		{
			final IModuleGroupNode moduleGroupNode = new ModuleGroupNode(new NavigationNodeId(MODULE_GROUP_MILK_PRICE));
			subAppNode.addChild(moduleGroupNode);

			final IModuleNode moduleNode = NodeFactory.createModule(MODULE_MILK_PRICE_REGISTER, LABEL_PAYMENTS, moduleGroupNode);
//			NodeFactory.createSubModule(SUBMODULE_FINANCE_MILK_PRICE_REGISTER,
//					LABEL_MILKPRICE, moduleNode, MilkPriceJournalView.ID, MilkPriceJournalController.class); //$NON-NLS-1$
			NodeFactory.createSubModule(SUBMODULE_FINANCE_MEMBER_PAYMENTS,
					LABEL_PAYMENTS, moduleNode, MemberPaymentsView.ID, MemberPaymentsViewController.class);
			NodeFactory.createSubModule(SUBMODULE_FINANCE_PAYMENT_REQUEST,
					LABEL_PAYMENT_REQUEST, moduleNode, PaymentRequestView.ID, PaymentRequestViewController.class);
		}
		{
			final IModuleGroupNode moduleGroupNode = new ModuleGroupNode(new NavigationNodeId(MODULE_GROUP_ADJUSTMENT));
			subAppNode.addChild(moduleGroupNode);

			final IModuleNode moduleNode = NodeFactory.createModule(MODULE_ADJUSTMENT_REGISTER, LABEL_ADJUSTMENT, moduleGroupNode);
			NodeFactory.createSubModule(SUBMODULE_FINANCE_ADJUSTMENT_REGISTER,
							LABEL_ADJUSTMENT, moduleNode, AdjustmentTransactionJournalView.ID, AdjustmentTransactionJournalController.class);
		}
		return new INavigationNode<?>[] { subAppNode };
	}

}
