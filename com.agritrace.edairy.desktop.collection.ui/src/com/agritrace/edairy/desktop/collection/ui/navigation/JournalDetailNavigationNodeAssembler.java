package com.agritrace.edairy.desktop.collection.ui.navigation;

import org.eclipse.riena.navigation.AbstractNavigationAssembler;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.model.SubModuleNode;
import org.eclipse.riena.ui.workarea.WorkareaManager;

import com.agritrace.edairy.desktop.collection.ui.controllers.MilkCollectionJournalController;
import com.agritrace.edairy.desktop.collection.ui.views.MilkCollectionJournalView;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.collection.ui.NavigationConstants;

public class JournalDetailNavigationNodeAssembler extends AbstractNavigationAssembler {

	@Override
	public INavigationNode<?>[] buildNode(NavigationNodeId nodeId, NavigationArgument navigationArgument) {
		final CollectionJournalPage journalPage = (CollectionJournalPage)navigationArgument.getParameter();
		final ISubModuleNode detailViewNode = new SubModuleNode(
				new NavigationNodeId(NavigationConstants.MILK_COLLECTION_JOURNAL_DETAIL_NODE, journalPage.getReferenceNumber()), 
				journalPage.getReferenceNumber()); 
		detailViewNode.setIcon("milk_detail.gif"); //$NON-NLS-1$
		detailViewNode.setContext("JOURNAL_PAGE", journalPage); // backup..
		WorkareaManager
				.getInstance()
				.registerDefinition(detailViewNode, MilkCollectionJournalController.class, MilkCollectionJournalView.ID)
				.setRequiredPreparation(true);
		return new INavigationNode<?>[] { detailViewNode };
	}

	@Override
	public boolean acceptsToBuildNode(NavigationNodeId nodeId, NavigationArgument argument) {
		return nodeId.getTypeId().equals(NavigationConstants.MILK_COLLECTION_JOURNAL_DETAIL_NODE);
	}

}
