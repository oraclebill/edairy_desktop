package com.agritrace.edairy.desktop.birt.navigation;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.riena.core.RienaLocations;
import org.eclipse.riena.navigation.AbstractNavigationAssembler;
import org.eclipse.riena.navigation.IAction;
import org.eclipse.riena.navigation.IModuleGroupNode;
import org.eclipse.riena.navigation.IModuleNode;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubApplicationNode;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.model.ModuleGroupNode;
import org.eclipse.riena.navigation.model.ModuleNode;
import org.eclipse.riena.navigation.model.SubApplicationNode;
import org.eclipse.riena.ui.workarea.WorkareaManager;

import com.agritrace.edairy.desktop.birt.viewer.ReportViewController;
import com.agritrace.edairy.desktop.common.ui.navigation.NodeFactory;

public class BirtNavigationNodeAssembler extends AbstractNavigationAssembler {

	private Set<String> knownTargetIds = null;

	@Override
	public boolean acceptsToBuildNode(NavigationNodeId nodeId, NavigationArgument argument) {
		if (knownTargetIds == null) {
			knownTargetIds = new HashSet<String>(Arrays.asList(NavigationConstants.REPORTS_SUBAPP_TYPEID));
			knownTargetIds = Collections.unmodifiableSet(knownTargetIds);
		}
		return knownTargetIds.contains(nodeId.getTypeId());
	}

	/**
	 * Build the sub-application tree for the reporting area
	 */
	@Override
	public INavigationNode<?>[] buildNode(NavigationNodeId nodeId, NavigationArgument navigationArgument) {

		final ISubApplicationNode subAppNode = new SubApplicationNode(new NavigationNodeId(
				NavigationConstants.REPORTS_SUBAPP_TYPEID), "Reports");
		WorkareaManager.getInstance().registerDefinition(subAppNode, NavigationConstants.REPORTS_SUBAPP_PERSPECTIVEID);

		// Create two groups - standard report and user reports
		IModuleGroupNode moduleGroupNode;
		IModuleNode moduleNode;

		moduleGroupNode = new ModuleGroupNode(nodeId);
		subAppNode.addChild(moduleGroupNode);

		// find the reports area and add a submodule for each report found
		File reportArea = new File(RienaLocations.getDataArea(), "reports");
		if (reportArea.exists() && reportArea.isDirectory()) {
			for (File f : reportArea.listFiles()) {
				if (f.isDirectory()) {
					moduleNode = createModuleForDirectory(moduleGroupNode, f);
				}
			}
		}
		return new INavigationNode<?>[] { subAppNode };
	}

	public IModuleNode createModuleForDirectory(IModuleGroupNode parent, File f) {
		//
		// create a module for each reporting area
		//
		String typeId = "com.agritrace.edairy.desktop.reports.reportDirectory";
		NavigationNodeId nodeId = new NavigationNodeId(typeId, f.getName());
		IModuleNode moduleNode = new ModuleNode(nodeId, f.getName());
		moduleNode.setContext("directory", f);
		parent.addChild(moduleNode);

		for (File child : f.listFiles()) {
			if (f.isFile() && f.getName().endsWith(".rpt")) {
				createSubModuleForReportFile(moduleNode, child);
			}
		}

		return moduleNode;
	}

	public ISubModuleNode createSubModuleForReportFile(IModuleNode parent, File f) {

		final NavigationNodeId nodeId = new NavigationNodeId("com.agritrace.edairy.desktop.reports.reportFile",
				f.getName());
		final ISubModuleNode submoduleNode = NodeFactory.createSubModule(nodeId, f.getName(), parent,
				NavigationConstants.REPORTS_SUBMODULE_VIEWID, ReportViewController.class);
		submoduleNode.addAction(new IAction() {
			@Override
			public void run() {
				System.err.println("!!!!!!!!!!!!!! node action : " + nodeId.toString());
			}
		});
		return submoduleNode;
	}
}
