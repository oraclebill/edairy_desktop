package com.agritrace.edairy.desktop.install.navigation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.riena.navigation.AbstractNavigationAssembler;
import org.eclipse.riena.navigation.IModuleGroupNode;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubApplicationNode;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.model.ModuleGroupNode;
import org.eclipse.riena.navigation.model.SubApplicationNode;
import org.eclipse.riena.ui.workarea.WorkareaManager;

public class InstallNavigationNodeAssembler extends AbstractNavigationAssembler {
	// FINANCE

	private static final String LABEL_INSTALL = "Install";
	private static final String SUBAPP_INSTALL = "com.agritrace.edairy.desktop.install";	//$NON-NLS-1$
	private static final String MODULE_GROUP_INSTALL_IMPORT = "modulegroup.install.import"; 	//$NON-NLS-1$
	private Set<String> knownTargetIds = null;

	@Override
	public boolean acceptsToBuildNode(NavigationNodeId nodeId, NavigationArgument argument) {
		if (knownTargetIds == null) {
			knownTargetIds = new HashSet<String>(Arrays.asList(SUBAPP_INSTALL));
			knownTargetIds = Collections.unmodifiableSet(knownTargetIds);
		}

		return knownTargetIds.contains(nodeId.getTypeId());
	}

	@Override
	public INavigationNode<?>[] buildNode(NavigationNodeId nodeId, NavigationArgument navigationArgument) {

		//
		// FINANCE TAB
		//

		final ISubApplicationNode subAppNode = new SubApplicationNode(new NavigationNodeId(SUBAPP_INSTALL),
				LABEL_INSTALL);
		WorkareaManager.getInstance().registerDefinition(subAppNode, SUBAPP_INSTALL);

		//
		// FINANCE GROUP
		//
		{
			final IModuleGroupNode moduleGroupNode = new ModuleGroupNode(new NavigationNodeId(MODULE_GROUP_INSTALL_IMPORT));
			subAppNode.addChild(moduleGroupNode);

			/*
			final IModuleNode moduleNode = NodeFactory.createModule(MODULE_INSTALL_IMPORT, LABEL_IMPORT_WIZARD, moduleGroupNode);
			NodeFactory
					.createSubModule(
							SUBMODULE_INSTALL_IMPORT_EMPLOYEES,
							LABEL_IMPORT_EMPLOYEES, moduleNode, SampleView.ID); //$NON-NLS-1$
			*/
		}

		return new INavigationNode<?>[] { subAppNode };
	}

}
