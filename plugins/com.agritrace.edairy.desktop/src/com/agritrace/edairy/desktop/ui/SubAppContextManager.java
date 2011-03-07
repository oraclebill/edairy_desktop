package com.agritrace.edairy.desktop.ui;

import org.eclipse.riena.navigation.ISubApplicationNode;
import org.eclipse.riena.navigation.listener.ISubApplicationNodeListener;
import org.eclipse.riena.navigation.listener.SubApplicationNodeListener;

import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.google.inject.Inject;

class SubAppContextManager extends SubApplicationNodeListener implements
        ISubApplicationNodeListener {

    final IDairyRepository dairyRepository;

    @Inject
    SubAppContextManager(IDairyRepository dairyRepository) {
        this.dairyRepository = dairyRepository;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.riena.navigation.listener.NavigationNodeListener#beforeActivated
     * (org.eclipse.riena.navigation.INavigationNode)
     */
    @Override
    public void beforeActivated(ISubApplicationNode source) {
        // every sub app gets a context dairy
        setupDairyContext(source);

        // TODO: every sub app gets a session factory

        // TODO: every sub app gets a session exception handler
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.riena.navigation.listener.NavigationNodeListener#afterDeactivated
     * (org.eclipse.riena.navigation.INavigationNode)
     */
    @Override
    public void afterDeactivated(ISubApplicationNode source) {
        // remove exception handler
        // remove and close session factory
        // remove dairy
    }

    public void removingSubApp(ISubApplicationNode subAppNode) {
        // if subApp has not been deactivated, do it now
    }

    private void setupDairyContext(ISubApplicationNode source) {
        // Long dairyId = (Long) source.getParent().getContext("DAIRYID");

        source.setContext("DAIRY", dairyRepository.getLocalDairy());
    }

}
