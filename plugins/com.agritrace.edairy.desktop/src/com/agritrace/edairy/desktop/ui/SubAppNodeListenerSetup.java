package com.agritrace.edairy.desktop.ui;

import org.eclipse.riena.navigation.IApplicationNode;
import org.eclipse.riena.navigation.ISubApplicationNode;
import org.eclipse.riena.navigation.listener.ApplicationNodeListener;

import com.google.inject.Inject;

/**
 * Adds a few elements to each sub applications' context node.
 * 
 * @author bjones
 */
class SubAppNodeListenerSetup extends ApplicationNodeListener {

    final SubAppContextManager subAppContextManager;

    @Inject
    SubAppNodeListenerSetup(SubAppContextManager subAppContextManager) {
        super();
        this.subAppContextManager = subAppContextManager;
    }

    @Override
    public void childAdded(IApplicationNode source,
            ISubApplicationNode childAdded) {
        addSubAppNodeListeners(source, childAdded);
    }

    @Override
    public void childRemoved(IApplicationNode source,
            ISubApplicationNode childRemoved) {
        removeSubAppNodeListeners(source, childRemoved);
    }

    protected void addSubAppNodeListeners(IApplicationNode appNode,
            ISubApplicationNode subAppNode) {
        subAppNode.addListener(subAppContextManager);
    }

    protected void removeSubAppNodeListeners(IApplicationNode appNode,
            ISubApplicationNode subAppNode) {
        subAppContextManager.removingSubApp(subAppNode);
        subAppNode.removeListener(subAppContextManager);
    }
}
