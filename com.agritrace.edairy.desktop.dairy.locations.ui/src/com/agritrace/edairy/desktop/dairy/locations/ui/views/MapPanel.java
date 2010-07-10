package com.agritrace.edairy.desktop.dairy.locations.ui.views;

import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.dairy.locations.ui.controllers.DairyLocationController;

public class MapPanel extends CompositePanel {
	public MapPanel(Composite parent, int style) {
		super(parent, style);
		final GridLayout layout = new GridLayout(3, false);
		layout.marginWidth = layout.marginHeight = DairyLocationView.FORM_MARGIN;
		layout.horizontalSpacing = DairyLocationView.COLUMN_MARGIN;
		this.setLayout(layout);

		final Label latitudeLabel = UIControlsFactory.createLabel(this, "Latitude");
		GridData gd = new GridData();
		latitudeLabel.setLayoutData(gd);

		final Text lattitudeText = UIControlsFactory.createTextDecimal(this,
				DairyLocationController.RIDGET_ID_ML_LATITUDE);
		gd = new GridData();
		gd.widthHint = DairyLocationView.WIDTH_UNIT;
		lattitudeText.setLayoutData(gd);

		final Browser map = UIControlsFactory.createBrowser(this, SWT.BORDER);
		gd = new GridData();
		gd.verticalSpan = 3;
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = SWT.FILL;
		map.setLayoutData(gd);

		final Label longitudeLabel = UIControlsFactory.createLabel(this, "Longitutde");
		gd = new GridData();
		longitudeLabel.setLayoutData(gd);

		final Text longitudeText = UIControlsFactory.createTextDecimal(this,
				DairyLocationController.RIDGET_ID_ML_LONGITUDE);
		gd = new GridData();
		gd.widthHint = DairyLocationView.WIDTH_UNIT;
		longitudeText.setLayoutData(gd);
	}
}