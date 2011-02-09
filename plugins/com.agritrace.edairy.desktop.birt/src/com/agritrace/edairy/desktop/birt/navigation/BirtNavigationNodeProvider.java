package com.agritrace.edairy.desktop.birt.navigation;

import java.util.List;

import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.INavigationNodeProvider;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.StartupNodeInfo;

public class BirtNavigationNodeProvider implements INavigationNodeProvider {

	public BirtNavigationNodeProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public INavigationNode<?> provideNode(INavigationNode<?> sourceNode, NavigationNodeId targetId,
			NavigationArgument argument) {
		System.err.println("provideNode: " + sourceNode);
		System.err.println("targetId: " + targetId);
		System.err.println("argument: " + argument);
		return null;
	}

	@Override
	public List<StartupNodeInfo> getSortedStartupNodeInfos() {
		System.err.println("getSortedStartupNodeInfos");
		return null;
	}

	@Override
	public void cleanUp() {
		System.err.println("getSortedStartupNodeInfos");
	}

}
