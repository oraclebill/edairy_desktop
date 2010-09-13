package com.agritrace.edairy.desktop.dairy.locations.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.ChoiceComposite;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import com.agritrace.edairy.desktop.common.ui.util.FormUtil;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.dairy.locations.ui.DairyLocationUIConstants;

public class DairyLocationDirectoryView extends AbstractDirectoryView {

	public static final String ID = "edairy.locations.dairy.directory";

	public DairyLocationDirectoryView() {
	}

	@Override
	protected void createFilterConditions(Composite parent) {
		final Group filterGroup = UIControlsFactory.createGroup(parent, "Search Criteria");
		filterGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		filterGroup.setLayout(new GridLayout(2, false));
		filterGroup.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		//functions filter
		UIControlsFactory.createLabel(filterGroup, "Functions: ", SWT.LEFT);
		final ChoiceComposite functionsChoice = UIControlsFactory.createChoiceComposite(filterGroup, SWT.None, true,
				DairyLocationUIConstants.RIDGET_ID_FUNCTIONS);
		functionsChoice.setOrientation(SWT.HORIZONTAL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,false).applyTo(functionsChoice);
		
		//route filter
		UIControlsFactory.createLabel(filterGroup, "Transport Route: ", SWT.LEFT);
		final CCombo combo = UIControlsFactory.createCCombo(filterGroup, DairyLocationUIConstants.RIDGET_ID_ROUTE);
		GridData gd = new GridData();
		gd.widthHint = FormUtil.WIDTH_UNIT * 3;
		gd.verticalAlignment = SWT.FILL;
		combo.setLayoutData(gd);

	}

}
