/*******************************************************************************
 * Copyright (c) 2007, 2009 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    compeople AG - initial API and implementation
 *******************************************************************************/
package com.agritrace.edairy.desktop.common.ui.navigation;

import java.util.Map;

import org.eclipse.riena.internal.ui.workarea.registry.WorkareaDefinitionRegistryFacade;
import org.eclipse.riena.navigation.IModuleGroupNode;
import org.eclipse.riena.navigation.IModuleNode;
import org.eclipse.riena.navigation.INavigationContext;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.model.ModuleNode;
import org.eclipse.riena.navigation.model.SubModuleNode;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.workarea.IWorkareaDefinition;
import org.eclipse.riena.ui.workarea.WorkareaManager;

import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.model.dairy.security.PrincipalManager;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Factory to help create {@link IModuleNode}s and {@link ISubModuleNode}s.
 */
public final class NodeFactory {
	@Inject
	private static Map<Class<? extends IController>, Provider<? extends IController>> PROVIDER_MAP;
	
	private static class GuiceWorkareaDefinition implements IWorkareaDefinition {
		private final Class<? extends IController> controllerClass;
		private final Provider<? extends IController> controllerProvider;
		private final Object viewId;
		private boolean viewShared;
		private boolean requiredPreparation;

		public GuiceWorkareaDefinition(Class<? extends IController> controllerClass,
				Provider<? extends IController> controllerProvider, Object viewId) {
			this.controllerClass = controllerClass;
			this.controllerProvider = controllerProvider;
			this.viewId = viewId;
		}

		@Override
		public IController createController() {
			return controllerProvider.get();
		}

		@Override
		public Class<? extends IController> getControllerClass() {
			return controllerClass;
		}

		@Override
		public Object getViewId() {
			return viewId;
		}

		@Override
		public boolean isRequiredPreparation() {
			return requiredPreparation;
		}

		@Override
		public boolean isViewShared() {
			return viewShared;
		}

		@Override
		public void setRequiredPreparation(boolean required) {
			requiredPreparation = required;
		}

		@Override
		public void setViewShared(boolean shared) {
			viewShared = shared;
		}
	}

	public static IModuleNode createModule(String nodeId, String caption, IModuleGroupNode parent) {
		final IModuleNode result = new ModuleNode(new NavigationNodeId(nodeId), caption);
		parent.addChild(result);
		result.setClosable(false);
		return result;
	}

	public static ISubModuleNode createSubModule(String nodeId, String caption, IModuleNode parent, String viewId) {
		return createSubModule(nodeId, caption, parent, viewId, (Class<? extends IController>) null);
	}
	
	private static boolean havePermissions(final Class<? extends IController> controllerClass) {
		if (controllerClass == null)
			return true;
		
		// Check permissions
		PermissionRequired annotation = controllerClass.getAnnotation(PermissionRequired.class);
		return annotation == null || PrincipalManager.getInstance().hasPermission(annotation.value());
	}

	public static ISubModuleNode createSubModule(String nodeId, String caption, final IModuleNode parent, String viewId,
			final Class<? extends IController> controllerClass) {
		final Provider<? extends IController> controllerProvider = PROVIDER_MAP.get(controllerClass);
		
		final ISubModuleNode result = new SubModuleNode(new NavigationNodeId(nodeId), caption) {
			@Override
			public boolean allowsActivate(INavigationContext context) {
				return super.allowsActivate(context) && havePermissions(controllerClass);
			}
		};
		
		// path found via org.eclipse.riena.ui.swt.imagePaths in plugin.xml
		result.setIcon("arrow_right.png"); //$NON-NLS-1$
		parent.addChild(result);
		
		if (controllerProvider != null) {
			WorkareaDefinitionRegistryFacade.getInstance().register(result,
					new GuiceWorkareaDefinition(controllerClass, controllerProvider, viewId));
		} else {
			WorkareaManager.getInstance().registerDefinition(result, controllerClass, viewId);
		}
		
		return result;
	}

	private NodeFactory() {
		// prevent instantiation
	}
}
