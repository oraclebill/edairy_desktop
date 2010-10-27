package com.agritrace.edairy.desktop.common.ui.controls.location;

import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.controls.CompositePanel;
import com.agritrace.edairy.desktop.common.ui.util.FormUtil;

public class MapPanel extends CompositePanel {
	public MapPanel(Composite parent, int style) {
		super(parent, style);
		final GridLayout layout = new GridLayout(3, false);
		layout.marginWidth = layout.marginHeight = FormUtil.FORM_MARGIN;
		layout.horizontalSpacing = FormUtil.COLUMN_MARGIN;
		this.setLayout(layout);

		final Label latitudeLabel = UIControlsFactory.createLabel(this, "Latitude");
		GridData gd = new GridData();
		latitudeLabel.setLayoutData(gd);

		final Text lattitudeText = UIControlsFactory.createTextDecimal(this,
				ViewWidgetId.LATITUDE_TEXT);
		gd = new GridData();
		gd.widthHint = FormUtil.WIDTH_UNIT;
		lattitudeText.setLayoutData(gd);

		final Browser map = UIControlsFactory.createBrowser(this, SWT.BORDER);
		gd = new GridData();
		gd.verticalSpan = 3;
		gd.grabExcessHorizontalSpace = false;
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = false;
		gd.verticalAlignment = SWT.FILL;
		gd.heightHint = 150;
		gd.widthHint = 150;
		map.setLayoutData(gd);
		map.setUrl("http://maps.google.com/maps/api/staticmap?center=limuru+kenya&zoom=11&size=150x150&sensor=false");
		map.refresh();

		final Label longitudeLabel = UIControlsFactory.createLabel(this, "Longitutde");
		gd = new GridData();
		longitudeLabel.setLayoutData(gd);

		final Text longitudeText = UIControlsFactory.createTextDecimal(this,
				ViewWidgetId.LONGTITUDE_TEXT);
		gd = new GridData();
		gd.widthHint = FormUtil.WIDTH_UNIT;
		longitudeText.setLayoutData(gd);
	}
}