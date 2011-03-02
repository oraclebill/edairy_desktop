package com.agritrace.edairy.desktop.common.ui.views;

import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.agritrace.edairy.desktop.common.ui.activator.Activator;
import com.google.inject.Injector;

public abstract class ScrolledSubModuleView extends SubModuleView {

	private final static Logger LOGGER = Log4r.getLogger(Activator.getDefault(), ScrolledSubModuleView.class);

	@Override
	protected void createWorkarea(Composite parent) {
		parent.setLayout(new FillLayout());
		final Color bgColor = LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND);

		final ScrolledComposite scrolled = new ScrolledComposite(parent,  SWT.H_SCROLL | SWT.V_SCROLL);
		scrolled.setExpandHorizontal(true);
		scrolled.setExpandVertical(true);
		scrolled.setBackground(bgColor);

		final Composite newParent = new Composite(scrolled, SWT.DOUBLE_BUFFERED);
		scrolled.setContent(newParent);
		newParent.setBackground(bgColor);

		basicCreatePartControl(newParent);
		afterBasicCreatePartControl(newParent);

		scrolled.setMinSize(newParent.computeSize(640, 480));

	}

	/* (non-Javadoc)
	 * @see org.eclipse.riena.navigation.ui.swt.views.SubModuleView#basicCreatePartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void basicCreatePartControl(Composite parent) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.riena.navigation.ui.swt.views.SubModuleView#createController(org.eclipse.riena.navigation.ISubModuleNode)
	 */
	@Override
	protected SubModuleController createController(ISubModuleNode node) {
		SubModuleController controller = super.createController(node);
		if (controller != null) {
			BundleContext context = Platform.getBundle("com.agritrace.edairy.desktop").getBundleContext();
			ServiceReference service = context.getServiceReference(Injector.class.getName());
			Injector injector = (Injector) context.getService(service);
			injector.injectMembers(controller);
		}
		return controller;
	}	
	
	

}
