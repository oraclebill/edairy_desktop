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
import com.agritrace.edairy.desktop.common.ui.util.FormToolkit;
import org.eclipse.swt.widgets.Scale;

public class MapPanel extends CompositePanel {
	public static final String	MAP_LATITUDE	= "map-latitude";
	public static final String	MAP_LONGITUDE	= "map-longitude";
	public static final String	MAP_BROWSER		= "map-browser";
	public static final String	MAP_ZOOM_SCALE	= "map-zoom";
	public static final int		MAP_HEIGHT		= 150;
	public static final int		MAP_WIDTH		= 150;

	public MapPanel(Composite parent, int style) {
		super(parent, style);
		final GridLayout layout = new GridLayout(3, false);
		layout.marginWidth = layout.marginHeight = FormToolkit.FORM_MARGIN;
		layout.horizontalSpacing = FormToolkit.COLUMN_MARGIN;
		this.setLayout(layout);

		final Label latitudeLabel = UIControlsFactory.createLabel(this, "Latitude");

		final Text lattitudeText = UIControlsFactory.createTextDecimal(this, MAP_LATITUDE);
		GridData gd = new GridData();
		gd.widthHint = FormToolkit.WIDTH_UNIT;
		lattitudeText.setLayoutData(gd);

		try {
			final Browser map = UIControlsFactory.createBrowser(this, SWT.BORDER, MAP_BROWSER);
			gd = new GridData();
			gd.verticalSpan = 4;
			gd.grabExcessHorizontalSpace = false;
			gd.horizontalAlignment = SWT.FILL;
			gd.grabExcessVerticalSpace = false;
			gd.verticalAlignment = SWT.FILL;
			gd.heightHint = MAP_HEIGHT;
			gd.widthHint = MAP_WIDTH;
			map.setLayoutData(gd);
// map.setUrl("http://maps.google.com/maps/api/staticmap?center=-1.2833333+36.8166667&zoom=11&size=150x150&sensor=false");
			map.refresh();
		} catch (Exception e) {
			;
		}

		final Label longitudeLabel = UIControlsFactory.createLabel(this, "Longitude", "label" + MAP_LONGITUDE);
		final Text longitudeText = UIControlsFactory.createTextDecimal(this, MAP_LONGITUDE);
		gd = new GridData();
		gd.widthHint = FormToolkit.WIDTH_UNIT;
		longitudeText.setLayoutData(gd);
		UIControlsFactory.createLabel(this, "");
		UIControlsFactory.createLabel(this, "");
		UIControlsFactory.createLabel(this, "");
		UIControlsFactory.createLabel(this, "");
		UIControlsFactory.createLabel(this, "");
		UIControlsFactory.createLabel(this, "");
		
				Scale scale = UIControlsFactory.createScale(this, SWT.NONE, MAP_ZOOM_SCALE);
				scale.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
	}
}