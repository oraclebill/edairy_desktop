package com.agritrace.edairy.desktop.dairy.vehicles.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.dairy.vehicles.ui.controllers.VehicleEditDialogController;
import com.agritrace.edairy.desktop.dairy.vehicles.ui.controls.VehicleLogDetailComposite;

public class VehicleEditDialog extends RecordDialog<Vehicle> {
	private Composite comonComp;

	public VehicleEditDialog(Shell shell) {
		super(shell);
	}

	@Override
	protected void buildWorkArea(Composite parent) {
		comonComp = UIControlsFactory.createComposite(parent);
		comonComp.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		comonComp.setLayout(new GridLayout(1, true));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(comonComp);

		VehicleLogDetailComposite details = new VehicleLogDetailComposite(comonComp);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(details);

		parent.pack();
	}


	@Override
	protected VehicleEditDialogController createController() {
		return new VehicleEditDialogController();
	}

}
