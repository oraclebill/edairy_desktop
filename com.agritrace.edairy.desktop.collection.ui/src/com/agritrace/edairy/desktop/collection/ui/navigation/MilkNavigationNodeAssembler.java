package com.agritrace.edairy.desktop.collection.ui.navigation;

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

import com.agritrace.edairy.desktop.collection.ui.controllers.MilkCollectionLogController;
import com.agritrace.edairy.desktop.collection.ui.controllers.MilkDeliveryLogController;
import com.agritrace.edairy.desktop.collection.ui.controllers.MilkSubAppConstants;
import com.agritrace.edairy.desktop.collection.ui.views.MilkCollectionLog;
import com.agritrace.edairy.desktop.collection.ui.views.MilkDeliveryLogView;
import com.agritrace.edairy.desktop.common.ui.navigation.NodeFactory;

public class MilkNavigationNodeAssembler extends AbstractNavigationAssembler {

	private Set<String> knownTargetIds = null;

	@Override
	public INavigationNode<?>[] buildNode(NavigationNodeId nodeId, NavigationArgument navigationArgument) {
		
		ISubApplicationNode subAppNode = new SubApplicationNode(new NavigationNodeId(MilkSubAppConstants.SUBAPP_MILK), "Milk");
		WorkareaManager.getInstance().registerDefinition(subAppNode, MilkSubAppConstants.SUBAPP_MILK_VIEWID);

		//
		// COLLECTION MODULE GROUP
		//
		IModuleGroupNode moduleGroupNode = new ModuleGroupNode(new NavigationNodeId(MilkSubAppConstants.MODULE_GROUP_MILK));
		subAppNode.addChild(moduleGroupNode);

		IModuleNode moduleNode = NodeFactory.createModule(MilkSubAppConstants.MODULE_MILK_COLLECTIONS, "Milk Collection",
				moduleGroupNode);

		NodeFactory.createSubModule(MilkSubAppConstants.SUBMODULE_MILK_COLLECTIONS_REGISTER, "Collection Log",
				moduleNode, MilkCollectionLog.ID, MilkCollectionLogController.class); //$NON-NLS-1$ 

//		NodeFactory.createSubModule(MilkSubAppConstants.SUBMODULE_MILK_COLLECTIONS_DETAIL_REGISTER,
//				"Collection Detail Log", moduleNode, MilkCollectionDetailLog.ID,
//				MilkCollectionDetailLogController.class); //$NON-NLS-1$ 
//
//		NodeFactory.createSubModule(MilkSubAppConstants.SUBMODULE_MILK_COLLECTIONS_DETAIL_ENTRY, "Log New Collections",
//				moduleNode, MilkCollectionJournalView.ID, MilkCollectionJournalController.class); //$NON-NLS-1$ 

		//
		// DELIVERY MODULE GROUP
		//
		moduleNode = NodeFactory.createModule(MilkSubAppConstants.MODULE_MILK_DELIVERY, "Milk Deliveries",
				moduleGroupNode);
		NodeFactory.createSubModule(MilkSubAppConstants.SUBMODULE_MILK_DELIVERY_REGISTER,
				"Delivery Log", moduleNode, MilkDeliveryLogView.ID, MilkDeliveryLogController.class); //$NON-NLS-1$ 
		//	NodeFactory.createSubModule("edm.milk.delivery.entry", "Log New Delivery", moduleNode, DeliveryView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		
		return new INavigationNode<?>[] { subAppNode };
	}

	@Override
	public boolean acceptsToBuildNode(NavigationNodeId nodeId, NavigationArgument argument) {
		if (knownTargetIds == null) {
			knownTargetIds = new HashSet<String>(Arrays.asList(
					MilkSubAppConstants.SUBAPP_MILK 
			));
			knownTargetIds = Collections.unmodifiableSet(knownTargetIds);
		}

		return knownTargetIds.contains(nodeId.getTypeId());
	}

}
