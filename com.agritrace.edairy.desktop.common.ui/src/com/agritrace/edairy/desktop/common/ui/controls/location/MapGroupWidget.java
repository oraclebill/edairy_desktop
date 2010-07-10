package com.agritrace.edairy.desktop.common.ui.controls.location;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;


public class MapGroupWidget {
	public static final String LATITUDE_LABEL_TXT = "Latitude:";

	public static final String LONGTITUDE_LABEL_TXT = "Longtitue:";
	public static final String MAP_GROUP_TXT = "Map";
	private Text directionsText;

	private Text landMarkText;
	private final Group mapGroup;

	public MapGroupWidget(Composite parent) {
		mapGroup = UIControlsFactory.createGroup(parent, MAP_GROUP_TXT);
		creatDirectonsGroup();
	}

	public Group getGroup() {
		return mapGroup;
	}

	private void creatDirectonsGroup() {
		mapGroup.setLayout(new GridLayout(2, false));
		UIControlsFactory.createLabel(mapGroup, LATITUDE_LABEL_TXT);
		landMarkText = UIControlsFactory.createText(mapGroup, SWT.SINGLE | SWT.BORDER, ViewWidgetId.LATITUDE_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(landMarkText);

		UIControlsFactory.createLabel(mapGroup, LONGTITUDE_LABEL_TXT);
		directionsText = UIControlsFactory.createText(mapGroup, SWT.SINGLE | SWT.BORDER, ViewWidgetId.LONGTITUDE_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(directionsText);
	}
}
