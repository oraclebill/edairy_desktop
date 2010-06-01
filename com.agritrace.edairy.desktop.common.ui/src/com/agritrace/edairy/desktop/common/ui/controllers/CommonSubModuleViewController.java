package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;

/**
 * Common Submodule view controller which delegates the controller to multiple
 * <code>ISubModuleControllerDelegate</code>
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class CommonSubModuleViewController extends SubModuleController {

	private final List<ISubModuleControllerDelegate> delegates = new ArrayList<ISubModuleControllerDelegate>();
	private final List<EObject> _eobjs = new ArrayList<EObject>();

	/**
	 * Adds module controller delegate
	 * 
	 * @param delegate
	 */
	public void addSubModuleControllerDelegate(ISubModuleControllerDelegate delegate) {
		this.delegates.add(delegate);
	}

	/**
	 * Gets all sub module controller delegates
	 * 
	 * @return
	 */
	public List<ISubModuleControllerDelegate> getSubModuleControllerDelegates() {
		return this.delegates;
	}

	/**
	 * Removes controller delegate
	 * 
	 * @param delegate
	 */
	public void removeSubModuleControllerDelegate(ISubModuleControllerDelegate delegate) {
		this.delegates.remove(delegate);
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();
		addSubModuleControllers();
		for (final ISubModuleControllerDelegate delegate : this.delegates) {
			delegate.configureRidgets();
		}
	}

	/**
	 * Sublclass should overide this to add controller delegate
	 */
	protected void addSubModuleControllers() {
		// empty
	}

	public List<EObject> getModelObjects() {

		return _eobjs;
	}

	public void fireListeners(int eventType) {
		for (final ISubModuleControllerDelegate delegate : this.getSubModuleControllerDelegates()) {
			delegate.fireListener(eventType);
		}

	}

}
