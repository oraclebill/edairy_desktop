package com.agritrace.edairy.desktop.common.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;

public class MapGroupWidget  {
	private Group mapGroup;
	
	public static final String MAP_GROUP_TXT="Map";
	public static final String LATITUDE_LABEL_TXT="Latitude:";
	public static final String LONGTITUDE_LABEL_TXT="Longtitue:";
	
	private Text landMarkText;
	private Text directionsText;
	
	public MapGroupWidget(Composite parent){
		mapGroup = UIControlsFactory.createGroup(parent, MAP_GROUP_TXT);
		creatDirectonsGroup();
	}

	private void creatDirectonsGroup() {
		mapGroup.setLayout(new GridLayout(2,false));
		Label landMarkLabel = UIControlsFactory.createLabel(mapGroup, LATITUDE_LABEL_TXT);
		landMarkText = UIControlsFactory.createText(mapGroup, SWT.SINGLE|SWT.BORDER, ViewWidgetId.LATITUDE_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true,false).applyTo(landMarkText);
		
		Label directionLabel = UIControlsFactory.createLabel(mapGroup, LONGTITUDE_LABEL_TXT);
		directionsText = UIControlsFactory.createText(mapGroup, SWT.SINGLE|SWT.BORDER, ViewWidgetId.LONGTITUDE_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true,false).applyTo(directionsText);
	}
	public Group getGroup() {
		return mapGroup;
	}
}

