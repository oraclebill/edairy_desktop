package com.agritrace.edairy.desktop.common.ui.views;

import org.eclipse.core.runtime.Assert;
import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.core.util.InvocationTargetFailure;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.workarea.IWorkareaDefinition;
import org.eclipse.riena.ui.workarea.WorkareaManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.ui.activator.Activator;

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

}
