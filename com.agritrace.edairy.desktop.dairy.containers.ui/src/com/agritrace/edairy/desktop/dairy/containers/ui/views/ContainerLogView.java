package com.agritrace.edairy.desktop.dairy.containers.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.views.ScrolledSubModuleView;
import com.agritrace.edairy.desktop.dairy.containers.ui.controls.ContainerLogDetailComposite;

/**
 * Container log view
 * 
 * @author Bill Jones
 * 
 */
public class ContainerLogView extends ScrolledSubModuleView {

	public static final String BIND_ID_MASTER = "master"; //$NON-NLS-1$
	public static final String ID = "dairy.container.masterdetail.view";

	
	public ContainerLogView() {
		super();
	}

	@Override
	protected void basicCreatePartControl(Composite panel) {
		panel.setLayout(new GridLayout(2, false));
		panel.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		final Composite mdComposite = new MasterDetailsComposite(panel, SWT.NONE) {
			@Override
			protected void createDetails(Composite parent) {
				final Composite comp = new ContainerLogDetailComposite(parent);
				GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(comp);
				GridLayoutFactory.fillDefaults().generateLayout(parent);
			}
		};
		addUIControl(mdComposite, BIND_ID_MASTER);
		GridDataFactory.swtDefaults().grab(true, true).minSize(600, -1).align(SWT.FILL, SWT.FILL).applyTo(mdComposite);
		panel.pack();
	}

}
