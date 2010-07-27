package com.agritrace.edairy.desktop.common.ui.controls.location;

import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.controls.CompositePanel;
import com.agritrace.edairy.desktop.common.ui.util.FormUtil;

public class DirectionsPanel extends CompositePanel {

	public DirectionsPanel(Composite parent, int style) {
		super(parent, style);

		final GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = layout.marginHeight = FormUtil.FORM_MARGIN;
		layout.horizontalSpacing = FormUtil.COLUMN_MARGIN;
		setLayout(layout);

		final Label landmarkLabel = UIControlsFactory.createLabel(this, "Landmark");
		GridData gd = new GridData();
		landmarkLabel.setLayoutData(gd);

		final Text landmarkText = UIControlsFactory.createText(this, SWT.BORDER | SWT.SINGLE,
				ViewWidgetId.LANDMARK_TEXT);
		gd = new GridData();
		gd.widthHint = FormUtil.WIDTH_UNIT * 4;
		landmarkText.setLayoutData(gd);

		final Label directionsLabel = UIControlsFactory.createLabel(this, "Directions");
		gd = new GridData();
		directionsLabel.setLayoutData(gd);

		final Text directionsText = UIControlsFactory.createTextMulti(this, false, false, ViewWidgetId.DIRECTIONS_TEXT);
		gd = new GridData();
		gd.widthHint = FormUtil.WIDTH_UNIT * 4;
		gd.heightHint = FormUtil.ROW_MARGIN * 5;
		directionsText.setLayoutData(gd);
	}
}