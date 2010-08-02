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
import com.agritrace.edairy.desktop.finance.ui.controllers.MilkPriceJournalController;
import com.agritrace.edairy.desktop.finance.ui.views.MilkPriceJournalView;
import com.agritrace.edairy.desktop.finance.ui.views.TransactionJournalView;

public class FinanceNavigationNodeAssembler extends AbstractNavigationAssembler {
	// FINANCE

	private static final String LABEL_FINANCE = "Finance";
	private static final String LABEL_MILK_PRICE = "Milk Price Register";
	private static final String LABEL_TRANSACTION_LOG = "Member Transaction Register";
	private static final String SUBAPP_FINANCE = "com.agritrace.edairy.desktop.finance";	//$NON-NLS-1$
	private static final String MODULE_TRANSACTION_REGISTER = "edm.transaction.entry";	//$NON-NLS-1$
	private static final String MODULE_MILK_PRICE_REGISTER = "edm.milk-price.entry";	//$NON-NLS-1$
	private static final String MODULE_GROUP_TRANSACTIONS = "modulegroup.finance.transactions"; 	//$NON-NLS-1$
	private static final String MODULE_GROUP_MILK_PRICE = "modulegroup.finance.milk-price"; 	//$NON-NLS-1$
	private static final String SUBMODULE_FINANCE_TRANSACTION_REGISTER = "edm.finances.log";	//$NON-NLS-1$
	private static final String SUBMODULE_FINANCE_MILK_PRICE_REGISTER = "milk.price.log";	//$NON-NLS-1$

	private static final String TAB_FINANCE = SUBAPP_FINANCE;

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
			NodeFactory
					.createSubModule(
							SUBMODULE_FINANCE_TRANSACTION_REGISTER,
							"Transaction Journal", moduleNode, TransactionJournalView.ID, AccountTransactionJournalController.class); //$NON-NLS-1$ 
		}
		{
			final IModuleGroupNode moduleGroupNode = new ModuleGroupNode(new NavigationNodeId(MODULE_GROUP_MILK_PRICE));
			subAppNode.addChild(moduleGroupNode);

			final IModuleNode moduleNode = NodeFactory.createModule(MODULE_MILK_PRICE_REGISTER, LABEL_MILK_PRICE, moduleGroupNode);
			NodeFactory
					.createSubModule(
							SUBMODULE_FINANCE_MILK_PRICE_REGISTER,
							"Milk Price Register", moduleNode, MilkPriceJournalView.ID, MilkPriceJournalController.class); //$NON-NLS-1$
		}
		// NodeFactory.createSubModule(
		//				"edm.finances.mdlog", "Transaction Journal 9", financeMembers, TransactionBatchEntryMDSubModuleView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		// NodeFactory
		//				.createSubModule(SUBMODULE_FINANCE_ADJUSTMENTS_REGISTER, "Adjustments", financeMembers, BlankView.ID); //$NON-NLS-1$ 
		// NodeFactory.createSubModule(SUBMODULE_FINANCE_MILK_PRICE_REGISTER,
		//				"Milk Price Register", financeMembers, BlankView.ID); //$NON-NLS-1$ 

		return new INavigationNode<?>[] { subAppNode };
	}

}
