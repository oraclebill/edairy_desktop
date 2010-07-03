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
import com.agritrace.edairy.desktop.finance.ui.controllers.MemberTransactionRegisterController;
import com.agritrace.edairy.desktop.finance.ui.views.MemberTransactionRegisterView;

public class FinanceNavigationNodeAssembler extends AbstractNavigationAssembler {
	// FINANCE

	private static final String LABEL_FINANCE = "Finance";
	private static final String MODULE_FINANCE = "edm.finances";//$NON-NLS-1$
	private static final String MODULE_GROUP_FINANCE = "modulegroup.desktop.finance"; //$NON-NLS-1$
	private static final String SUBAPP_FINANCE = "com.agritrace.edairy.desktop.finance";//$NON-NLS-1$
	private static final String SUBMODULE_FINANCE_TRANSACTION_REGISTER = "edm.finances.log";//$NON-NLS-1$

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

		final IModuleGroupNode moduleGroupNode = new ModuleGroupNode(new NavigationNodeId(MODULE_GROUP_FINANCE));
		subAppNode.addChild(moduleGroupNode);

		//
		// FINANCE GROUP
		//

		final IModuleNode financeMembers = NodeFactory.createModule(MODULE_FINANCE, LABEL_FINANCE, moduleGroupNode);
		NodeFactory
				.createSubModule(
						SUBMODULE_FINANCE_TRANSACTION_REGISTER,
						"Transaction Journal", financeMembers, MemberTransactionRegisterView.ID, MemberTransactionRegisterController.class); //$NON-NLS-1$ 
		// NodeFactory.createSubModule(SUBMODULE_FINANCE_TRANSACTION_BATCH_ENTRY,
		//				"Transaction Journal 8", financeMembers, TransactionBatchEntrySubModuleView.ID); //$NON-NLS-1$ 
		// NodeFactory.createSubModule(
		//				"edm.finances.mdlog", "Transaction Journal 9", financeMembers, TransactionBatchEntryMDSubModuleView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		// NodeFactory
		//				.createSubModule(SUBMODULE_FINANCE_ADJUSTMENTS_REGISTER, "Adjustments", financeMembers, BlankView.ID); //$NON-NLS-1$ 
		// NodeFactory.createSubModule(SUBMODULE_FINANCE_MILK_PRICE_REGISTER,
		//				"Milk Price Register", financeMembers, BlankView.ID); //$NON-NLS-1$ 

		return new INavigationNode<?>[] { subAppNode };
	}

}
