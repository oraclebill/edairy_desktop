package com.agritrace.edairy.desktop.dairy.containers.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.dairy.containers.ui.controllers.ContainerEditDialogController;
import com.agritrace.edairy.desktop.dairy.containers.ui.controls.ContainerLogDetailComposite;

public class ContainerEditDialog extends RecordDialog<DairyContainer> {
	private Composite comonComp;

	public ContainerEditDialog(Shell shell) {
		super(shell);
	}

	@Override
	protected void buildWorkArea(Composite parent) {
		comonComp = UIControlsFactory.createComposite(parent);
		comonComp.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		comonComp.setLayout(new GridLayout(1, true));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(comonComp);

		ContainerLogDetailComposite details = new ContainerLogDetailComposite(comonComp);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(details);

		parent.pack();
	}


	@Override
	protected ContainerEditDialogController createController() {
		return new ContainerEditDialogController();
	}

}
