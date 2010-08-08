package com.agritrace.edairy.desktop.dairy.locations.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.ChoiceComposite;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.ui.controls.location.LocationTabFolder;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.dairy.locations.ui.DairyLocationUIConstants;
import com.agritrace.edairy.desktop.dairy.locations.ui.controllers.DairyDialogController;

public class DairyLocationEditDialog extends RecordDialog<DairyLocation> {
	private Composite comonComp;

	public DairyLocationEditDialog(Shell shell) {
		super(shell);
	}

	@Override
	protected void buildWorkArea(Composite parent) {
		comonComp = UIControlsFactory.createComposite(parent);
		comonComp.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		comonComp.setLayout(new GridLayout(1, true));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(comonComp);

		final Composite composite = new Composite(comonComp, SWT.NONE);
		composite.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,1, 1));
		composite.setLayout(new GridLayout(2, false));
		
		UIControlsFactory.createLabel(composite, "Name");
		final Text txtDate = UIControlsFactory.createText(composite);
		txtDate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,1, 1));
		addUIControl(txtDate, DairyLocationUIConstants.RIDGET_ID_NAME);

		//description
		UIControlsFactory.createLabel(composite, "Description", SWT.LEFT);
		final Text descriptionText = UIControlsFactory.createText(composite, SWT.BORDER | SWT.SINGLE,DairyLocationUIConstants.RIDGET_ID_DESCRIPTION);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(descriptionText);

		//phone
		UIControlsFactory.createLabel(composite, "Phone", SWT.LEFT);
		final Text phoneText = UIControlsFactory.createText(composite, SWT.BORDER | SWT.SINGLE,	DairyLocationUIConstants.RIDGET_ID_PHONE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(phoneText);

		//Date 
		UIControlsFactory.createLabel(composite, "Date Opened", SWT.LEFT);
		final DateTime dateOpenedPicker = UIControlsFactory.createDate(composite, SWT.DEFAULT,
				DairyLocationUIConstants.RIDGET_ID_DATEOPENED);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(dateOpenedPicker);
		
		//functions
		UIControlsFactory.createLabel(composite, "Functions", SWT.LEFT);
		final ChoiceComposite functionsChoice = UIControlsFactory.createChoiceComposite(composite, SWT.None, true,
				DairyLocationUIConstants.RIDGET_ID_FUNCTIONS);
		functionsChoice.setOrientation(SWT.HORIZONTAL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(functionsChoice);
		
		//route
		UIControlsFactory.createLabel(composite, "Route", SWT.LEFT);
		final CCombo combo = UIControlsFactory.createCCombo(composite, DairyLocationUIConstants.RIDGET_ID_ROUTE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(combo);
		createContactGroup(comonComp);
		parent.pack();
	}

	private void createContactGroup(Composite parent) {

		final Group companyContactGroup = UIControlsFactory.createGroup(parent, "Address Information");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1).applyTo(companyContactGroup);

		LocationTabFolder locationTabs = new LocationTabFolder(companyContactGroup, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(locationTabs);
		GridLayoutFactory.swtDefaults().generateLayout(companyContactGroup);
	}

	@Override
	protected AbstractWindowController createController() {
		return new DairyDialogController();
	}

}
