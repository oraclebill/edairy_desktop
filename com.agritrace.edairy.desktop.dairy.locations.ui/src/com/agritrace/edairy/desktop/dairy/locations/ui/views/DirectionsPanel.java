package com.agritrace.edairy.desktop.dairy.locations.ui.views;

import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.dairy.locations.ui.controllers.DairyLocationController;

public class DirectionsPanel extends Composite {
	
	public DirectionsPanel(Composite parent, int style) {
		super(parent, style);

		final GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = layout.marginHeight = DairyLocationView.FORM_MARGIN;
		layout.horizontalSpacing = DairyLocationView.COLUMN_MARGIN;
		setLayout(layout);

		final Label landmarkLabel = UIControlsFactory.createLabel(this, "Landmark");
		GridData gd = new GridData();
		landmarkLabel.setLayoutData(gd);

		final Text landmarkText = UIControlsFactory.createText(this, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_DL_LANDMARK);
		gd = new GridData();
		gd.widthHint = DairyLocationView.WIDTH_UNIT * 4;
		landmarkText.setLayoutData(gd);

		final Label directionsLabel = UIControlsFactory.createLabel(this, "Directions");
		gd = new GridData();
		directionsLabel.setLayoutData(gd);

		final Text directionsText = UIControlsFactory.createTextMulti(this, false, false,
				DairyLocationController.RIDGET_ID_DL_DIRECTIONS);
		gd = new GridData();
		gd.widthHint = DairyLocationView.WIDTH_UNIT * 4;
		gd.heightHint = DairyLocationView.ROW_MARGIN * 5;
		directionsText.setLayoutData(gd);
	}
}