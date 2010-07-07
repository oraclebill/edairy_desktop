package com.agritrace.edairy.desktop.dairy.vehicles.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.dairy.vehicles.ui.controls.VehicleLogDetailComposite;

/**
 * Vehicle log view
 * 
 * @author Bill Jones
 * 
 */
public class VehicleLogView extends SubModuleView {
	public VehicleLogView() {
	}

	public static final String BIND_ID_MASTER = "master"; //$NON-NLS-1$
	public static final String ID = "dairy.vehicle.masterdetail.view";

	@Override
	protected void basicCreatePartControl(Composite panel) {
		panel.setLayout(new GridLayout(2, false));
		panel.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		final Composite mdComposite = new MasterDetailsComposite(panel, SWT.NONE) {
			@Override
			protected void createDetails(Composite parent) {
				GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL)
						.applyTo(new VehicleLogDetailComposite(parent));
				GridLayoutFactory.fillDefaults().generateLayout(parent);
			}
		};
		addUIControl(mdComposite, BIND_ID_MASTER);
		GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(mdComposite);
		panel.pack();
	}

}
