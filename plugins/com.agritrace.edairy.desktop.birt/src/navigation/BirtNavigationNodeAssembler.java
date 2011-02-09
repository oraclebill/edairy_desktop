package navigation;

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
import org.eclipse.riena.navigation.model.ModuleNode;
import org.eclipse.riena.navigation.model.SubApplicationNode;
import org.eclipse.riena.ui.workarea.WorkareaManager;

public class BirtNavigationNodeAssembler extends AbstractNavigationAssembler {

	private Set<String> knownTargetIds = null;

	@Override
	public boolean acceptsToBuildNode(NavigationNodeId nodeId, NavigationArgument argument) {
		if (knownTargetIds == null) {
			knownTargetIds = new HashSet<String>(
					Arrays.asList(NavigationConstants.REPORTS_SUBAPP_TYPEID)
					);
			knownTargetIds = Collections.unmodifiableSet(knownTargetIds);
		}

		return knownTargetIds.contains(nodeId.getTypeId());
	}

	/**
	 * Build the subapplication tree for the reporting area
	 */
	@Override
	public INavigationNode<?>[] buildNode(NavigationNodeId nodeId, NavigationArgument navigationArgument) {

		final ISubApplicationNode subAppNode = new SubApplicationNode(new NavigationNodeId(
				NavigationConstants.REPORTS_SUBAPP_TYPEID), "Dairy Reports");
		WorkareaManager.getInstance().registerDefinition(subAppNode, NavigationConstants.REPORTS_SUBAPP_PERSPECTIVEID);

		// Create two groups - standard report and user reports
		IModuleGroupNode moduleGroupNode;
		IModuleNode moduleNode;

		moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("com.agritrace.edairy.desktop.reports.modulegroup"));
		subAppNode.addChild(moduleGroupNode);

		//
		// create a module for each reporting area
		//
		String typeId = "com.agritrace.edairy.desktop.reports";
		String[] reportingAreas = new String[] { "Milk Intake", "Member Registration", "Stores" };
		for (String areaName : reportingAreas) {
			String instanceId = areaName.toLowerCase().replace(" ", "_");
			nodeId = new NavigationNodeId(typeId, instanceId);
			moduleNode = new ModuleNode(nodeId, areaName);
			moduleGroupNode.addChild(moduleNode);
// moduleNode.setClosable(false);

// NodeFactory.createSubModule(NavigationConstants.SUBMODULE_MILK_INTAKE_REGISTER, "Milk Intake Log",
// moduleNode, MilkCollectionLog.ID, MilkCollectionLogController.class);

		}
		return new INavigationNode<?>[] { subAppNode };

	}
}
