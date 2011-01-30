package com.agritrace.edairy.desktop.milkops.ui.navigation;

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
import com.agritrace.edairy.desktop.milkops.ui.NavigationConstants;
import com.agritrace.edairy.desktop.milkops.ui.controllers.MilkCollectionLogController;
import com.agritrace.edairy.desktop.milkops.ui.sales.MilkSaleLogController;
import com.agritrace.edairy.desktop.milkops.ui.sales.MilkSaleLogView;
import com.agritrace.edairy.desktop.milkops.ui.views.MilkCollectionLog;

public class MilkNavigationNodeAssembler extends AbstractNavigationAssembler {

	private Set<String> knownTargetIds = null;

	@Override
	public boolean acceptsToBuildNode(NavigationNodeId nodeId, NavigationArgument argument) {
		if (knownTargetIds == null) {
			knownTargetIds = new HashSet<String>(Arrays.asList(NavigationConstants.SUBAPP_MILK));
			knownTargetIds = Collections.unmodifiableSet(knownTargetIds);
		}

		return knownTargetIds.contains(nodeId.getTypeId());
	}

	@Override
	public INavigationNode<?>[] buildNode(NavigationNodeId nodeId, NavigationArgument navigationArgument) {

		final ISubApplicationNode subAppNode = new SubApplicationNode(new NavigationNodeId(
				NavigationConstants.SUBAPP_MILK), "Dairy Operations");
		WorkareaManager.getInstance().registerDefinition(subAppNode, NavigationConstants.SUBAPP_MILK_VIEWID);

		//
		// INTAKE MODULE GROUP
		//
		final IModuleGroupNode moduleGroupNode = new ModuleGroupNode(new NavigationNodeId(
				NavigationConstants.MODULE_GROUP_MILK));
		subAppNode.addChild(moduleGroupNode);

		IModuleNode moduleNode = NodeFactory.createModule(NavigationConstants.MODULE_MILK_COLLECTIONS, "Milk Intake",
				moduleGroupNode);

		NodeFactory.createSubModule(NavigationConstants.SUBMODULE_MILK_INTAKE_REGISTER, "Milk Intake Log", moduleNode,
				MilkCollectionLog.ID, MilkCollectionLogController.class);

		//
		// SALES MODULE GROUP
		//
		moduleNode = NodeFactory.createModule(NavigationConstants.MODULE_MILK_SALES, "Milk Sales", moduleGroupNode);
		NodeFactory.createSubModule(NavigationConstants.SUBMODULE_MILK_SALES_REGISTER,
				"Milk Sales Log", moduleNode, MilkSaleLogView.ID, MilkSaleLogController.class); //$NON-NLS-1$

		//
		// ADJUSTMENTS MODULE GROUP
		//
		moduleNode = NodeFactory.createModule(NavigationConstants.MODULE_MILK_ADJUSMENTS, "Milk Adjustments",
				moduleGroupNode);
		NodeFactory.createSubModule(NavigationConstants.SUBMODULE_MILK_TRANSFER_ADJUSTMENTS,
				"Milk Transfers", moduleNode, MilkSaleLogView.ID, null); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubModule(NavigationConstants.SUBMODULE_MILK_GRADE_ADJUSTMENTS,
				"Milk Grade Changes", moduleNode, MilkSaleLogView.ID, null); //$NON-NLS-1$

		//
		// QCC MODULE GROUP
		//
		moduleNode = NodeFactory.createModule(NavigationConstants.MODULE_MILK_QCC, "Milk Quantity Control",
				moduleGroupNode);
		NodeFactory.createSubModule(NavigationConstants.SUBMODULE_MILK_QCC_VIEWS,
				"QCC Reports", moduleNode, MilkSaleLogView.ID, null); //$NON-NLS-1$

		//
		// CONFIGURATION MODULE GROUP
		//
		moduleNode = NodeFactory.createModule(NavigationConstants.MODULE_MILK_SETUP, "Milk Operations Setup",
				moduleGroupNode);
		NodeFactory.createSubModule(NavigationConstants.SUBMODULE_MILK_GRADE_LIST,
				"Milk Grade List", moduleNode, MilkSaleLogView.ID, null); //$NON-NLS-1$

		return new INavigationNode<?>[] { subAppNode };
	}

}
